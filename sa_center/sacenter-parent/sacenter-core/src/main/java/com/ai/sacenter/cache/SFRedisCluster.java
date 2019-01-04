package com.ai.sacenter.cache;

import com.ai.sacenter.SFException;
import com.ai.sacenter.module.model.ICacheConfigure;
import com.ai.sacenter.util.HttpServletWrapper;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年7月20日</p>
 * <p>Company: AI(SH)</p>
 * @author zhouyh
 * @version 2.0 
 *
 */
public class SFRedisCluster implements java.io.Serializable{
	private static final long serialVersionUID = -3591651705125029818L;
	private static final Log log = LogFactory.getLog(SFRedisCluster.class);
	/**
	 * 每次取LIST缓存中的条目数
	 * 表数据过大时会阻塞超时，每次取用定额数目
	 */
	private long _maxRow = 100l;

	/**
	 * 归属缓存组
	 */
	private String Group;

	/**
	 * 主集群连接
	 */
	private JedisCluster MasterCluster;

	/**
	 * 从集群连接
	 */
	private JedisCluster SlaveCluster;

	/**
	 * 当前使用集群连接
	 */
	private JedisCluster HEADCluster;
	
	/**
	 * 配置数据
	 */
	private ICacheConfigure.ICacheCluster[] MasterConfig;
	private ICacheConfigure.ICacheCluster[] SlaveConfig;
	private GenericObjectPoolConfig ConfigPool;
	
	public SFRedisCluster(String Group, GenericObjectPoolConfig ConfigPool,ICacheConfigure.ICacheCluster[] MasterConfig, ICacheConfigure.ICacheCluster[] SlaveConfig) {
		JedisCluster headCluster = null;
		java.util.Set MasterURL = null;
		java.util.Set SlaveURL = null;
		try {
			ICacheConfigure.ICacheParameter fromPARAM = SFCacheFactory.getConfgiure().getParam( Group );
			_maxRow = fromPARAM.getAsLong( "MaxRow", _maxRow );
			MasterURL = SFRedisCluster.getClusterURLs(MasterConfig);
			SlaveURL = SFRedisCluster.getClusterURLs(SlaveConfig);
		}catch (Exception e){
			log.error("REDIS集群"+Group+"配置数据解析有误",e);
			return;
		}
		/*
		初始化连接从集群
		 */
		try {
			headCluster = null;
			headCluster = new JedisCluster(SlaveURL, ConfigPool);
			this.HEADCluster = headCluster;
		}finally {
			this.SlaveCluster = headCluster;
		}

		/*
		初始化连接主集群
		 */
		try{
			headCluster = null;
			headCluster = new JedisCluster(MasterURL, ConfigPool);
			this.HEADCluster = headCluster;
		}finally {
			this.MasterCluster = headCluster;
		}
		this.Group = Group;
		this.MasterConfig = MasterConfig;
		this.SlaveConfig = SlaveConfig;
		this.ConfigPool = ConfigPool;
	}
	
	/**
	 * 
	 * @param fromKEY
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList getAll( String fromKEY ) throws SFException,Exception{
		java.util.ArrayList fromLaten = new java.util.ArrayList();
		try
		{
			JedisCluster headCluster = this.getUsedCluster();
			if( headCluster.exists( fromKEY ).booleanValue() == false ){
				throw new Exception("cache cluster <" + Group + "> node <"+ fromKEY + "> not exists!");
			}
			long _llen = headCluster.llen( fromKEY ).longValue();
			for( long index = 0; index < _llen; index += _maxRow ){
				java.util.List _laten = null;
				try
				{
					_laten = headCluster.lrange( fromKEY, index, index + _maxRow - 1);
					fromLaten.addAll( _laten );
				}
				finally{
					if( _laten != null ){ _laten.clear(); _laten = null; }
				}
			}
		}
		finally{
			
		}
		return fromLaten;
	}

	public String getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

	public JedisCluster getMasterCluster() {
		return MasterCluster;
	}

	public void setMasterCluster(JedisCluster masterCluster) {
		MasterCluster = masterCluster;
	}

	public JedisCluster getSlaveCluster() {
		return SlaveCluster;
	}

	public void setSlaveCluster(JedisCluster slaveCluster) {
		SlaveCluster = slaveCluster;
	}

	public JedisCluster getHEADCluster() {
		return HEADCluster;
	}

	public void setHEADCluster(JedisCluster HEADCluster) {
		this.HEADCluster = HEADCluster;
	}

	public ICacheConfigure.ICacheCluster[] getMasterConfig() {
		return MasterConfig;
	}

	public void setMasterConfig(ICacheConfigure.ICacheCluster[] masterConfig) {
		MasterConfig = masterConfig;
	}

	public ICacheConfigure.ICacheCluster[] getSlaveConfig() {
		return SlaveConfig;
	}

	public void setSlaveConfig(ICacheConfigure.ICacheCluster[] slaveConfig) {
		SlaveConfig = slaveConfig;
	}

	public GenericObjectPoolConfig getConfigPool() {
		return ConfigPool;
	}

	public void setConfigPool(GenericObjectPoolConfig configPool) {
		ConfigPool = configPool;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public JedisCluster getUsedCluster()throws Exception{
		try{
			if(this.HEADCluster != null) {
				this.HEADCluster.set("LINK_TEST", new java.util.Date().toString());
				return HEADCluster;
			}else{
				log.error(this.Group+"当前连接为空,将尝试重新连接");
				throw new Exception("当前连接为空,将尝试重新连接");
			}
		}catch (Exception e){
			log.error("当前使用集群连接失败，将尝试重新获取连接");
			try{
				if(this.MasterCluster != null){
					this.MasterCluster.set("LINK_TEST", new java.util.Date().toString());
				}else{
					this.MasterCluster = new JedisCluster(SFRedisCluster.getClusterURLs(this.MasterConfig),ConfigPool);
					this.MasterCluster.set("LINK_TEST", new java.util.Date().toString());
				}
				this.HEADCluster = MasterCluster;
				log.info(this.Group+"使用主集群");
				return HEADCluster;
			}catch (Exception e2){
				log.error("尝试连接主集群失败！将继续尝试连接从集群");
				try{
					if(this.SlaveCluster != null){
						this.SlaveCluster.set("LINK_TEST", new java.util.Date().toString());
					}else{
						this.SlaveCluster = new JedisCluster(SFRedisCluster.getClusterURLs(this.SlaveConfig),ConfigPool);
						this.SlaveCluster.set("LINK_TEST", new java.util.Date().toString());
					}
					this.HEADCluster = SlaveCluster;
					log.info(this.Group+"使用从集群");
					return HEADCluster;
				}catch (Exception e3){
					throw new Exception("尝试连接主从集群都失败！无法获取可用的REDIS连接！");
				}
			}
		}
	}

	/**
	 *
	 * @param clusterConfigs
	 * @return
	 * @throws Exception
	 */
	private static java.util.Set getClusterURLs( ICacheConfigure.ICacheCluster clusterConfigs[]) throws Exception{
		java.util.Set HostAndPorts = new java.util.HashSet( clusterConfigs.length );
		for( int index = 0; clusterConfigs != null && index < clusterConfigs.length; index++ ){
			String URL = clusterConfigs[index].getHOME();
			HttpServletWrapper HttpServlet = new HttpServletWrapper(URL);
			HostAndPorts.add(new HostAndPort( HttpServlet.getHOST(), HttpServlet.getPORT() ) );
			
		}
		return HostAndPorts;
	}

	/**
	 * 广播监听类，监听缓存全量刷新事件
	 */
	public static class RedisPubSubListener extends JedisPubSub {
		private SFRedisCluster _cluster;
		public RedisPubSubListener( SFRedisCluster rediscluster ){
			super();
			_cluster = rediscluster;
		}
		
		/* (non-Javadoc)
		 * @see redis.clients.jedis.JedisPubSub#onMessage(java.lang.String, java.lang.String)
		 */
		public void onMessage(String channel, String message) {
			RedisMsgFRequest _redis_listener = null;
			try
			{
				if( StringUtils.startWith( channel, _cluster.getGroup() ) ){
					_redis_listener = new RedisMsgFRequest( message );
					if( StringUtils.equals( _redis_listener._command, TYPE.ICommand.MASTER )/*切换主集群*/ ){
						_handoverMasterCluster( _cluster, _redis_listener );
					}
					else if( StringUtils.equals( _redis_listener._command, TYPE.ICommand.SLAVE )/*切换备集群*/ ){
						_handoverSlaveCluster( _cluster, _redis_listener );
					}
				}
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
			}
			finally{
				if( _redis_listener != null ){ _redis_listener = null; }
			}
		}

		/**
		 * 切换主集群
		 * @param _cluster
		 * @param _redis_listener
		 * @throws Exception
		 */
		private void _handoverMasterCluster( SFRedisCluster _cluster, RedisMsgFRequest _redis_listener ) throws Exception{
			try {
				JedisCluster cluster = _cluster.getMasterCluster();
				if( cluster != null ){
					cluster.set("LINK_TEST", new java.util.Date().toString());
				}
				else{
					cluster = new JedisCluster(SFRedisCluster.getClusterURLs( _cluster.getMasterConfig()), _cluster.getConfigPool() );
					_cluster.setMasterCluster(cluster);
				}
				cluster.set( "LINK_TEST", new java.util.Date().toString() );
				_cluster.setHEADCluster( cluster );
			}
			catch (Exception exception){
				log.error( "收到集群刷新完毕广播但尝试连接集群失败", exception );
			}
		}
		
		/**
		 * 切换备集群
		 * @param _cluster
		 * @param _redis_listener
		 */
		private void _handoverSlaveCluster( SFRedisCluster _cluster, RedisMsgFRequest _redis_listener ){
			try {
				JedisCluster cluster = _cluster.getSlaveCluster();
				if( cluster != null ){
					cluster.set("LINK_TEST", new java.util.Date().toString());
				}
				else{
					cluster = new JedisCluster(SFRedisCluster.getClusterURLs( _cluster.getSlaveConfig()), 
							_cluster.getConfigPool() );
					_cluster.setSlaveCluster(cluster);
				}
				cluster.set("AICACHE_LINK_TEST",new java.util.Date().toString());
				_cluster.setHEADCluster(cluster);
				SFCacheFactory.getCache().refreshGroup( _cluster.getGroup() );
			}
			catch (Exception exception){
				log.error("收到集群刷新完毕广播但尝试连接集群失败", exception);
			}
		}
		
		/*public RedisPubSubListener(SFRedisCluster.TYPE type , String channel, String message, SFRedisCluster sfRedisCluster){
			this.TYPE = type;
			this.Channel = channel;
			this.Message = message;
			this.SFcluster = sfRedisCluster;
		}
		public void onMessage(String channel, String message) {
			if(channel != null && channel.equals(this.Channel) && message != null && message.equals(this.Message)){
				if(this.TYPE.equals( SFRedisCluster.TYPE.MASTER ) ){
					try {
						JedisCluster cluster = this.SFcluster.getMasterCluster();
						if(cluster != null){
							cluster.set("LINK_TEST", new java.util.Date().toString());
						}else{
							cluster = new JedisCluster(SFRedisCluster.getClusterURLs(this.SFcluster.getMasterConfig()),this.SFcluster.getConfigPool());
							this.SFcluster.setMasterCluster(cluster);
						}
						cluster.set("LINK_TEST",new java.util.Date().toString());
						this.SFcluster.setHEADCluster(cluster);
					}catch (Exception e){
						log.error("收到集群刷新完毕广播但尝试连接集群失败",e);
					}
				}
			}else{
				try {
					JedisCluster cluster = this.SFcluster.getSlaveCluster();
					if(cluster != null){
						cluster.set("LINK_TEST", new java.util.Date().toString());
					}else{
						cluster = new JedisCluster(SFRedisCluster.getClusterURLs(this.SFcluster.getSlaveConfig()),this.SFcluster.getConfigPool());
						this.SFcluster.setSlaveCluster(cluster);
					}
					cluster.set("LINK_TEST",new java.util.Date().toString());
					this.SFcluster.setHEADCluster(cluster);
				}catch (Exception e){
					log.error("收到集群刷新完毕广播但尝试连接集群失败",e);
				}
			}
		}*/

	}
	
	public static class RedisCacheLoader implements java.lang.Runnable{
		private String _TYPE;//MASTER/SLAVE
		private SFRedisCluster _cluster;
		public RedisCacheLoader( SFRedisCluster cluster ,String TYPE){
			super();
			_cluster = cluster;
			_TYPE = TYPE;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try
			{
				java.util.Set RedisURL = null;
				if("MASTER".equals(this._TYPE)){
					RedisURL = SFRedisCluster.getClusterURLs( _cluster.getMasterConfig() );
				}else{
					RedisURL = SFRedisCluster.getClusterURLs( _cluster.getSlaveConfig() );
				}

				while( true ){
					JedisCluster cluster = null;
					try{
						cluster = new JedisCluster( RedisURL );
						if( cluster != null ){
							cluster.set( "AICACHE_LINK_TEST", new java.util.Date().toString() );
						}
						cluster.psubscribe( new RedisPubSubListener( _cluster ), new String[]{ "*" } );
					}
					catch( java.lang.Exception exception ){
						log.error("收到集群刷新监听失败", exception);
					}
					finally{
						if( cluster != null ){ cluster.close(); cluster = null; }
					}
				}
			}
			catch( java.lang.Exception exception ){
				log.error("收到集群刷新监听失败", exception);
			}
			finally{
				
			}
		}
	}
	public static class RedisMsgFRequest implements java.io.Serializable{
		private static final long serialVersionUID = 4999360652300175269L;
		private java.sql.Timestamp _update = null;
		private String _command = null;
		private String _hostname;
		public RedisMsgFRequest( String _message ){
			super();
			String _arguments[] = StringUtils.split( _message, "|" );
			if( _arguments != null && _arguments.length > 0 ){
				_update = TimeUtils.getTimestamp( _arguments[0] );
			}
			if( _arguments != null && _arguments.length > 1 ){
				_command = _arguments[1];
			}
			if( _arguments != null && _arguments.length > 2 ){
				_hostname = _arguments[2];
			}
		}
		
		/**
		 * @return the _update
		 */
		public java.sql.Timestamp getUpdate() {
			return _update;
		}
		
		/**
		 * @param _update the _update to set
		 */
		public void setUpdate(java.sql.Timestamp update) {
			_update = update;
		}
		
		/**
		 * @return the _command
		 */
		public String getCommand() {
			return _command;
		}
		
		/**
		 * @param _command the _command to set
		 */
		public void setCommand(String command) {
			_command = command;
		}
		
		/**
		 * @return the _hostname
		 */
		public String getHostname() {
			return _hostname;
		}
		
		/**
		 * @param hostname the _hostname to set
		 */
		public void set_hostname(String hostname) {
			_hostname = hostname;
		}
		
	}
	public interface TYPE{
		public interface ICommand{
			/*切换主集群*/
			public final static String MASTER = "0";
			/*切换备集群*/
			public final static String SLAVE  = "1";
		}
	}
}
