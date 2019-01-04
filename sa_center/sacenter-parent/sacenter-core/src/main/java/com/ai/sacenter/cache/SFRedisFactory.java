package com.ai.sacenter.cache;

import com.ai.sacenter.SFException;
import com.ai.sacenter.module.model.ICacheConfigure;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPubSub;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê7ÔÂ20ÈÕ</p>
 * <p>Company: AI(SH)</p>
 * @author zhouyh
 * @version 2.0 
 *
 */
public class SFRedisFactory implements java.io.Serializable{
	private static final long serialVersionUID = -8266548939296426187L;
	private static java.util.Map _REDIS_FACTORY = new java.util.concurrent.ConcurrentHashMap();
	public SFRedisFactory() {
		super();
	}
	
	/**
	 * 
	 * @param fromCluster
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static SFRedisCluster createCluster( ICacheConfigure.IClusterGroup fromCluster ) throws SFException,Exception{
		SFRedisCluster _rediscluster = null;
		try
		{
			_rediscluster = (SFRedisCluster)_REDIS_FACTORY.get( fromCluster.getGROUP() );
			if( _rediscluster == null ){
				synchronized ( _REDIS_FACTORY ) {
					_rediscluster = (SFRedisCluster)_REDIS_FACTORY.get( fromCluster.getGROUP() );
					if( _rediscluster == null ){
						GenericObjectPoolConfig _object_config = null;
						_object_config = SFRedisFactory._createPoolConfig( fromCluster );
						_rediscluster = new SFRedisCluster(fromCluster.getGROUP(),
								_object_config, 
								fromCluster.getMASTER(), 
								fromCluster.getSLAVE());
						new Thread( new SFRedisCluster.RedisCacheLoader( _rediscluster , "MASTER") ).start();
						new Thread( new SFRedisCluster.RedisCacheLoader( _rediscluster , "SLAVE") ).start();
						_REDIS_FACTORY.put( fromCluster.getGROUP(), _rediscluster );
					}
				}
			}
		}
		finally{
			
		}
		return _rediscluster;
	}
	
	/**
	 * 
	 * @param fromCluster
	 * @throws SFException
	 * @throws Exception
	 */
	public static void returnCluster( SFRedisCluster fromCluster ) throws SFException,Exception{
		
	}
	
	/**
	 * 
	 * @param fromCluster
	 * @return
	 */
	private static GenericObjectPoolConfig _createPoolConfig( ICacheConfigure.IClusterGroup fromCluster ){
		GenericObjectPoolConfig _object_config = null;
		try
		{
			ICacheConfigure.ICacheParameter fromCache = null;
			_object_config = new GenericObjectPoolConfig();
			fromCache = SFCacheFactory.getConfgiure().getParam( fromCluster.getGROUP() );
			_object_config.setMaxTotal     ( fromCache.getAsInt    ( "MaxActive" , 10 ) ); 
			_object_config.setMaxIdle      ( fromCache.getAsInt    ( "MaxIdle"   , 1  ) );
			_object_config.setMaxWaitMillis( fromCache.getAsLong   ( "MaxWait"   , 500) );
			_object_config.setTestOnBorrow ( fromCache.getAsBoolean( "TestOnBorrow"   ) );
		}
		finally{
			
		}
		return _object_config;
	}

	public static class RedisGroup {
		private SFRedisCluster Master;
		private SFRedisCluster Slave;
		private JedisPubSub MasterListener;
		private JedisPubSub SlaveListener;
		private SFRedisCluster HEAD;

		public SFRedisCluster getMaster() {
			return Master;
		}

		public void setMaster(SFRedisCluster master) {
			Master = master;
		}

		public SFRedisCluster getSlave() {
			return Slave;
		}

		public void setSlave(SFRedisCluster slave) {
			Slave = slave;
		}

		public JedisPubSub getMasterListener() {
			return MasterListener;
		}

		public void setMasterListener(JedisPubSub masterListener) {
			MasterListener = masterListener;
		}

		public JedisPubSub getSlaveListener() {
			return SlaveListener;
		}

		public void setSlaveListener(JedisPubSub slaveListener) {
			SlaveListener = slaveListener;
		}

		public SFRedisCluster getHEAD() {
			return HEAD;
		}

		public void setHEAD(SFRedisCluster HEAD) {
			this.HEAD = HEAD;
		}
	}
}
