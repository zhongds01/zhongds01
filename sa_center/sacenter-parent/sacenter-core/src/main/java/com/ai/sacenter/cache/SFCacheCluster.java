package com.ai.sacenter.cache;

import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.complex.cache.ICache;
import com.ai.appframe2.complex.xml.cfg.caches.Cache;
import com.ai.appframe2.complex.xml.cfg.defaults.Property;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.model.ICacheConfigure;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 缓存集群槽位</p>
 * <p>Copyright: Copyright (c) 2017年7月20日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFCacheCluster implements java.io.Serializable{
	private static final long serialVersionUID = 1248772678961221809L;
	private static java.util.Map<String, java.util.HashMap<String, CarbonList<ICacheEntity>>> _runtime_cache = null;
	/*发起方*/
	private ObjectType _objective = null;
	/*集群槽位*/
	private java.util.HashMap<String, IClusterSlot> _cluster = new java.util.HashMap<String, IClusterSlot>();
	static{
		try
		{
			CarbonList<ICacheEntity> _runtime_table_ = null;
			java.util.HashMap<String, CarbonList<ICacheEntity>> __runtime_cache__ = null;
			_runtime_cache = new java.util.concurrent.ConcurrentHashMap<String, java.util.HashMap<String, CarbonList<ICacheEntity>>>();
			Cache __cache__[] = SystemUtils.ISystem.getSFUpfgkmCache();
			for( int index = 0; __cache__ != null && index < __cache__.length; index++ ){
				__runtime_cache__ = new java.util.HashMap<String, CarbonList<ICacheEntity>>();
				Property ___property___[] = __cache__[index].getPropertys();
				for( int _index_ = 0; ___property___ != null && _index_ < ___property___.length; _index_++ ){
					ICacheEntity __cacheentity__ = new ICacheEntity( ___property___[_index_] );
					if( __cacheentity__.isVALID() == false ){ continue; }
					_runtime_table_ = (CarbonList<ICacheEntity>)__runtime_cache__.get( __cacheentity__.getTable() );
					if( _runtime_table_ == null ){
						__runtime_cache__.put( __cacheentity__.getTable(), _runtime_table_ = new CarbonList<ICacheEntity>() );
					}
					_runtime_table_.add( __cacheentity__ );
				}
				_runtime_cache.put( __cache__[index].getId(), __runtime_cache__ );
			}
		}
		catch( java.lang.Exception exception ){
			SFException _exception = ExceptionFactory.getException( exception );
			throw _exception;
		}
	}
	public SFCacheCluster( ObjectType objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return 发起方
	 */
	public ObjectType getObjective() {
		return _objective;
	}

	/**
	 * @return 缓存实体槽位
	 */
	public java.util.HashMap<String, IClusterSlot> getCluster() {
		return _cluster;
	}

	/**
	 * 根据缓存类获取其对应集群槽位槽位
	 * @param _cache_ 缓存类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IClusterSlot getClustSlot( ICache _cache ) throws SFException,Exception{
		IClusterSlot fromCluster = null;
		try
		{
			String _message = "Service Open Cache <{0}> does not exist or multiple cluster configurations";
			if( _cluster.size() != 1 ){ throw new SFException("IOS0011094", JdomUtils.ICustom._wrapAsMessage( _message,
					new String[]{_cache.getClass().getName()})); 
			}
			for( java.util.Iterator<IClusterSlot> itera = _cluster.values().iterator(); itera.hasNext(); ){
				fromCluster = (IClusterSlot)itera.next();
				if( fromCluster != null ){ break; }
			}
		}
		finally{
			
		}
		return fromCluster;
	}
	
	/**
	 *  根据缓存类获取其对应缓存槽位
	 * @param _cache_ 缓存类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ICacheSlot getCacheSlot( ICache _cache_ ) throws SFException,Exception{
		ICacheSlot __cacheslot__ = null;
		try
		{
			ICacheConfigure _configure = SFCacheFactory.getConfgiure();
			ICacheConfigure.IClusterGroup __cluster__ = _configure.getCluster( _cache_ );
			IClusterSlot __clusterslot__ = (IClusterSlot)_cluster.get( __cluster__.getGROUP() );
			if( __clusterslot__ != null ){ __cacheslot__ = __clusterslot__.getSlot( _cache_ ); }
		}
		finally{
			
		}
		return __cacheslot__;
	}
	
	/**
	 * 根据缓存类集群获取当前集群槽位列表
	 * @param _cache_ 缓存类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IClusterSlot getCluster( ICache _cache_ ) throws SFException,Exception{
		IClusterSlot _cluster_ = null;
		try
		{
			ICacheConfigure _configure = SFCacheFactory.getConfgiure();
			ICacheConfigure.IClusterGroup __cluster__ = _configure.getCluster( _cache_ );
			_cluster_ = (IClusterSlot)_cluster.get( __cluster__.getGROUP() );
			if( _cluster_ == null ){ _cluster.put( __cluster__.getGROUP(), _cluster_ = new IClusterSlot( __cluster__ )  ); }
		}
		finally{
			
		}
		return _cluster_;
	}
	
	/**
	 * 根据缓存类集群获取当前集群槽位列表
	 * @param _cache_ 缓存类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IClusterSlot getCluster( Cache _cache_ ) throws SFException,Exception{
		IClusterSlot _cluster_ = null;
		try
		{
			ICacheConfigure _configure = SFCacheFactory.getConfgiure();
			ICacheConfigure.IClusterGroup __cluster__ = _configure.getCluster( _cache_ );
			_cluster_ = (IClusterSlot)_cluster.get( __cluster__.getGROUP() );
			if( _cluster_ == null ){ _cluster.put( __cluster__.getGROUP(), _cluster_ = new IClusterSlot( __cluster__ )  ); }
		}
		finally{
			
		}
		return _cluster_;
	}
	
	/**
	 * 根据集群编码湖获取当前集群槽位列表
	 * @param group 集群编码
	 * @return
	 */
	public IClusterSlot getCluster( ICacheConfigure.IClusterGroup group ){
		IClusterSlot _cluster_ = null;
		try
		{
			_cluster_ = (IClusterSlot)_cluster.get( group.getGROUP() );
			if( _cluster_ == null ){ _cluster.put( group.getGROUP(), _cluster_ = new IClusterSlot( group )  ); }
		}
		finally{
			
		}
		return _cluster_;
	}
	
	public static class IClusterSlot implements java.io.Serializable{
		private static final long serialVersionUID = -7369418600928062992L;
		/*缓存集群*/
		private ICacheConfigure.IClusterGroup _cluster = null;
		/*缓存类*/
		private CarbonList<ICacheSlot>  _slot = new CarbonList<ICacheSlot>();
		public IClusterSlot( ICacheConfigure.IClusterGroup cluster ){
			super();
			_cluster = cluster;
		}
		
		/**
		 * @return 缓存集群
		 */
		public ICacheConfigure.IClusterGroup getCluster() {
			return _cluster;
		}
		
		/**
		 * @param cluster 缓存类
		 */
		public void setCluster(ICacheConfigure.IClusterGroup cluster) {
			_cluster = cluster;
		}
		
		/**
		 * @return 缓存类
		 */
		public CarbonList<ICacheSlot> getSlot() {
			return _slot;
		}
		
		/**
		 * 
		 * @param _cache
		 * @return
		 */
		public ICacheSlot getSlot( Cache _cache ){
			ICacheSlot cacheslot = null;
			try
			{
				for( java.util.Iterator<ICacheSlot> itera = _slot.iterator(); itera.hasNext(); ){
					ICacheSlot _cacheslot = (ICacheSlot)itera.next();
					if( StringUtils.equals( _cacheslot._cache.getId(), _cache.getId() ) ){
						cacheslot = _cacheslot;
						break;
					}
				}
			}
			finally{
				
			}
			return cacheslot;
		}
		
		/**
		 * 
		 * @param _cache
		 * @return
		 */
		public ICacheSlot getSlot( ICache _cache ){
			ICacheSlot cacheslot = null;
			try
			{
				for( java.util.Iterator<ICacheSlot> itera = _slot.iterator(); itera.hasNext(); ){
					ICacheSlot _cacheslot = (ICacheSlot)itera.next();
					if( StringUtils.equals( _cacheslot._cache.getId(), _cache.getClass().getName() ) ){
						cacheslot = _cacheslot;
						break;
					}
				}
			}
			finally{
				
			}
			return cacheslot;
		}
		
		/**
		 * 
		 * @param _cache
		 * @param _objecttype
		 * @throws Exception
		 */
		public ICacheSlot mergeAsSlot( Cache _cache, ObjectType _objecttype ) throws Exception{
			ICacheSlot cacheslot = null;
			try
			{
				java.util.Map<String, CarbonList<ICacheEntity>> _runtime_cache_ = null;
				String _table_name_ = OracleUtils.ICustom.getTableName( _objecttype.getMapingEnty() );
				if( ( cacheslot = (ICacheSlot)_slot.get( _cache ) ) == null ){ 
					_slot.add( cacheslot = new ICacheSlot( _cache ) );  
				}
				_runtime_cache_ = (java.util.Map<String, CarbonList<ICacheEntity>>)_runtime_cache.get( _cache.getId() );
				if( _runtime_cache_.get( _table_name_ ) != null ){
					CarbonList<ICacheEntity> __cache__ = (CarbonList<ICacheEntity>)_runtime_cache_.get( _table_name_ );
					for( java.util.Iterator<ICacheEntity> itera = __cache__.iterator(); itera.hasNext(); ){
						ICacheEntity __cacheentity__ = (ICacheEntity)itera.next();
						if( __cacheentity__.isVALID( _table_name_ ) == false ){ continue; }
						if( cacheslot.getEntity().get( __cacheentity__ ) == null ){
							cacheslot.getEntity().add( __cacheentity__ );
						}
					}
				}
			}
			finally{
				
			}
			return cacheslot;
		}
		
	}
	public static class ICacheSlot implements java.io.Serializable{
		private static final long serialVersionUID = -816818335225524005L;
		/*缓存类*/
		private Cache _cache = null;
		/*缓存实体*/
		private CarbonList<ICacheEntity> _entity = new CarbonList<ICacheEntity>();
		public ICacheSlot( Cache cache ){
			super();
			_cache = cache;
		}
		
		/**
		 * @return 缓存类
		 */
		public Cache getCache() {
			return _cache;
		}
		
		/**
		 * @param cache 缓存类
		 */
		public void setCache(Cache cache) {
			_cache = cache;
		}
		
		/**
		 * @return the _entity
		 */
		public CarbonList<ICacheEntity> getEntity() {
			return _entity;
		}
		
		/**
		 * @param entity
		 */
		public void setEntity(CarbonList<ICacheEntity> entity) {
			_entity = entity;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object objective) {
			if( objective instanceof Cache ){
				Cache _cache_ = (Cache)objective;
				return _cache.getId().equals( _cache_.getId() );
			}
			else if( objective instanceof Cache ){
				ICacheSlot _cache_ = (ICacheSlot)objective;
				return _cache.getId().equals( _cache_._cache.getId() );
			}
			else{
				return false;
			}
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object objective) {
			if( objective instanceof Cache ){
				Cache _cache_ = (Cache)objective;
				return _cache.getId().compareTo( _cache_.getId() );
			}
			else if( objective instanceof Cache ){
				ICacheSlot _cache_ = (ICacheSlot)objective;
				return _cache.getId().compareTo( _cache_._cache.getId() );
			}
			else{
				return -1;
			}
		}
	}
	
	public static class ICacheEntity implements java.io.Serializable,java.lang.Comparable<Object>{
		private static final long serialVersionUID = -816818335225524005L;
		/*类型*/
		private String _type ;
		/*缓存表*/
		private String _table;
		/*缓存键表*/
		private String _cache;
		public ICacheEntity(){
			super();
		}
		
		public ICacheEntity( Property _property_ ){
			super();
			_type  = _property_.getType ();
			_table = _property_.getName ();
			_cache = _property_.getValue();
		}
		
		public ICacheEntity( ICacheEntity _entity_ ){
			super();
			_type  = _entity_._type ;
			_table = _entity_._table;
			_cache = _entity_._cache;
		}
		
		public ICacheEntity( String type, String table, String cache ){
			super();
			_type  = type ;
			_table = table;
			_cache = cache;
		}
		
		/**
		 * @return 类型
		 */
		public String getType() {
			return _type;
		}

		/**
		 * @param type 类型
		 */
		public void setType(String type) {
			_type = type;
		}

		/**
		 * @return 缓存表
		 */
		public String getTable() {
			return _table;
		}
		
		/**
		 * @param table 缓存表
		 */
		public void setTable(String table) {
			_table = table;
		}
		
		/**
		 * @return 缓存键表
		 */
		public String getCache() {
			return _cache;
		}
		
		/**
		 * @param cache 缓存键表
		 */
		public void setCache(String cache) {
			_cache = cache;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isVALID(){
			return StringUtils.equalsIgnoreCase( _type, "table" );
		}
		
		/**
		 * 
		 * @param _table_name
		 * @return
		 */
		public boolean isVALID( String _table_name ){
			if( StringUtils.equalsIgnoreCase( _type, "table" ) ){
				String _tables_[] = StringUtils.substring( _table_name, "{", "}" );
				if( _tables_ != null && _tables_.length > 0 ){
					return StringUtils.equalsIgnoreCase( _table, _tables_[ _tables_.length - 1 ] );
				}
				else{
					return StringUtils.equalsIgnoreCase( _table, _table_name );
				}
			}
			return false;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object objective) {
			if( ( objective instanceof ICacheEntity ) == false ){
				return false;
			}
			else{
				ICacheEntity _cache_ = (ICacheEntity)objective;
				String _left = ClassUtils.getINDEX( new String[]{ _table, "_$_", _cache } );
				String _right = ClassUtils.getINDEX( new String[]{ _cache_._table, "_$_", _cache_._cache } );
				return _left.equals( _right );
			}
		}

		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object objective) {
			if( ( objective instanceof ICacheEntity ) == false ){
				return -1;
			}
			else{
				ICacheEntity _cache_ = (ICacheEntity)objective;
				String _left = ClassUtils.getINDEX( new String[]{ _table, "_$_", _cache } );
				String _right = ClassUtils.getINDEX( new String[]{ _cache_._table, "_$_", _cache_._cache } );
				return _left.compareToIgnoreCase( _right );
			}
		}
		
	}
}
