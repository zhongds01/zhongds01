package com.ai.sacenter.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.complex.cache.ICache;
import com.ai.appframe2.complex.xml.cfg.caches.Cache;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.model.ICacheConfigure;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UUID;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 数据缓存工厂</p>
 * <p>Copyright: Copyright (c) 2012-8-28</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFCacheFactory {
	private static final Log log = LogFactory.getLog( SFCacheFactory.class );
	private final static ICacheDequeHome _DEQUE_FACTORY = new ICacheDequeHome();
	private final static ICacheLatenHome _CACHE_FACTORY = new ICacheLatenHome();
	private SFCacheFactory() {
		super();
	}
	
	/**
	 * 开通缓存配置
	 * @return
	 */
	public static ICacheConfigure getConfgiure(){
		return IConfigDefine.getINSTANCE().getConfigCache();
	}
	
	/**
	 * 开通事务管理
	 * @return
	 */
	public static ICacheDequeHome getDeque(){
		return _DEQUE_FACTORY;
	}
	
	/**
	 * 开通缓存管理
	 * @return
	 */
	public static ICacheLatenHome getCache(){
		return _CACHE_FACTORY;
	}
	
	public static class ICacheLatenHome implements java.io.Serializable{
		private static final long serialVersionUID = -5312168413654102332L;
		public ICacheLatenHome(){
			super();
		}
		
		/**
		 * 获取当前开通缓存方言
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public ICacheConfigure.ICacheRoute hgetRoute() throws SFException,Exception{
			ICacheConfigure.ICacheRoute fromRoute = null;
			try
			{
				ICacheDeque _deque = SFCacheFactory.getDeque().getLaten();
				ICacheConfigure _configure = SFCacheFactory.getConfgiure();
				fromRoute = _configure.getRoute( _deque != null?_deque.getGroup():null );
			}
			finally{
				
			}
			return fromRoute;
		}
		
		/**
		 * 获取当前开通缓存集群
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public ICacheConfigure.IClusterGroup hgetCluster() throws SFException,Exception{
			ICacheConfigure.IClusterGroup fromCluster = null;
			try
			{
				ICacheConfigure.ICacheRoute fromRoute = hgetRoute();
				fromCluster = SFCacheFactory.getConfgiure().getCluster( fromRoute.getGROUP() );
			}
			finally{
				
			}
			return fromCluster;
		}
		
		/**
		 * 根据集群服务编码获取开通缓存集群
		 * @param _cluster 集群服务编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public ICacheConfigure.IClusterGroup hgetCluster( String _cluster ) throws SFException,Exception{
			ICacheConfigure.IClusterGroup fromCluster = null;
			try
			{
				fromCluster = SFCacheFactory.getConfgiure().getCluster( _cluster );
			}
			finally{
				
			}
			return fromCluster;
		}
		
		/**
		 * 根据缓存实体获取开通缓存集群
		 * @param fromCache 缓存实体,可为NULL
		 * @param fromEntity 缓存表
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public SFCacheCluster.ICacheSlot hgetCluster( ObjectType fromEntity )  throws SFException,Exception{ 
			SFCacheCluster.ICacheSlot __cacheslot__ = null;
			try
			{
				SFCacheCluster __cluster__ = new SFCacheCluster( fromEntity );
				SFCacheFactory.ICacheDeque _cachedeque_ = SFCacheFactory.getDeque().getTransaction();
				Cache _cache_ = SystemUtils.ISystem.getSFUpfgkmCache( _cachedeque_.getGroup() );
				__cluster__.getCluster( _cache_ ).mergeAsSlot( _cache_, fromEntity );
				__cacheslot__ = __cluster__.getCacheSlot( _cachedeque_.getGroup() );
			}
			finally{
				
			}
			return __cacheslot__;
		}
		
		/**
		 * 根据缓存实体获取开通缓存集群
		 * @param fromCache 缓存实体,可为NULL
		 * @param fromEntity 缓存表
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public SFCacheCluster hgetCluster(ICache fromCache, ObjectType fromEntity )  throws SFException,Exception{ 
			SFCacheCluster __cluster__ = new SFCacheCluster( fromEntity );
			try
			{
				if( fromCache != null ){
					Cache _cache_ = SystemUtils.ISystem.getSFUpfgkmCache( fromCache );
					__cluster__.getCluster( fromCache ).mergeAsSlot( _cache_, fromEntity );
				}
				else{
					Cache _cache_[] = SystemUtils.ISystem.getSFUpfgkmCache( fromEntity.getMapingEnty() );
					for( int index = 0; _cache_ != null && index < _cache_.length; index++ ){
						__cluster__.getCluster( _cache_[index] ).mergeAsSlot( _cache_[index], fromEntity );
					}
				}
			}
			finally{
				
			}
			return __cluster__;
		}
		
		/**
		 * 根据当前缓存实体查询开通配置记录
		 * @param fromTYPE
		 * @param fromCond
		 * @param fromPARAM
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.ArrayList hgetAll(ObjectType fromTYPE, String fromCond, java.util.Map fromPARAM) throws SFException, Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hgetAll(fromTYPE, fromCond, fromPARAM);
		}
		
		/**
		 * 根据缓缓区域获取对应所有缓存数据
		 * @param _class 缓存区域
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.HashMap hgetAll( Class _class ) throws SFException,Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hgetAll( _class );
		}
		
		/**
		 * 根据缓缓区域和键值获取对应缓缓数据
		 * @param _class 缓存区域
		 * @param _route  缓存键值
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public Object hget( Class _class , String _route ) throws SFException,Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hget( _class, _route );
		}
		
		/**
		 * 该键值是否存在
		 * @param _class 缓存区域
		 * @param _route  缓存键值
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public boolean hexist( Class _class , String _route ) throws SFException,Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hexist( _class, _route );
		}
		
		/**
		 * 指定集群刷新缓存
		 * @param _group 集群编码
		 * @throws SFException
		 * @throws Exception
		 */
		public void refreshGroup( String _group ) throws SFException,Exception{
			IUpdcfgFactory.getIUpdcfgSV().refreshGroup( _group );
		}
	}
	
	public static class ICacheDequeHome implements java.io.Serializable{
		private static final long serialVersionUID = -8056727597453428734L;
		private final static ThreadLocal _deque_factory = new ThreadLocal(); 
		public ICacheDequeHome(){
			super();
		}
		
		/**
		 * 启动线程级缓存事务,如存在缓存事务则挂起线程级缓存事务
		 * @param _cache 缓存类
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction( ICache _cache ) throws SFException, Exception{
			try
			{
				ICacheDeque _deque = new ICacheDeque();
				_deque._group  = _cache;
				_deque._parent = (ICacheDeque)_deque_factory.get();
				if (log.isDebugEnabled()){
					log.debug("ucmframe thread name:" + Thread.currentThread().getName() + " mbean ["
							+ this + "] create deque [" + _deque + "]");
				}
				_deque_factory.set( _deque );
			}
			finally{
				
			}
		}
		
		/**
		 * 获取当前程级缓存事务,如线程事务中不存在缓存事务则抛异常
		 * @return
		 */
		public ICacheDeque getTransaction(){
			ICacheDeque _deque = null;
			try
			{
				_deque = (ICacheDeque)_deque_factory.get();
				if( _deque == null ){ ExceptionFactory.throwRuntime("IOS0010000", new String[] { Thread.currentThread().getName() }); }
			}
			finally{
				
			}
			return _deque;
		}
		
		/**
		 * 获取当前程级缓存事务,如线程事务中不存在缓存事务则返回空
		 * @return
		 */
		public ICacheDeque getLaten(){
			return (ICacheDeque)_deque_factory.get();
		}
		
		/**
		 * 提交当前线程级缓存事务,如当前缓存事务中父级缓存事务则恢复父级缓存事务
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitTransaction() throws SFException, Exception{
			try
			{
				ICacheDeque _deque = (ICacheDeque)_deque_factory.get();
				if( _deque != null ){
					_deque_factory.set( _deque._parent );
					log.debug("ucmframe thread name:" + Thread.currentThread().getName() + " mbean ["
							+ this + "] commit deque [" + _deque + "]");
					_deque = null;
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 回滚当前线程级缓存事务,如当前缓存事务中父级缓存事务则恢复父级缓存事务
		 */
		public void rollbackTransaction() throws SFException,Exception{
			try
			{
				ICacheDeque _deque = (ICacheDeque)_deque_factory.get();
				if( _deque != null ){
					log.debug("ucmframe thread name:" + Thread.currentThread().getName() + " mbean ["
							+ this + "] rollback deque [" + _deque + "]");
					_deque_factory.set( _deque._parent );
					_deque = null;
				}
			}
			finally{
				
			}
		}
	}
	
	public static class ICacheDeque implements java.io.Serializable{
		private static final long serialVersionUID = 1224125167712903672L;
		/*事务编码*/
		private UUID _id = null;
		/*缓存类*/
		private ICache _group = null;
		/*缓存结构*/
		private java.util.HashMap _cache = new java.util.HashMap();
		/*父级事务*/
		private ICacheDeque _parent = null;
		public ICacheDeque(){
			super();
			_id = UUID.getUUID();
		}
		
		/**
		 * @return 缓存实体类
		 */
		public ICache getGroup() {
			return _group;
		}
		
		/**
		 * @param group 缓存实体类
		 */
		public void setGroup(ICache group) {
			_group = group;
		}

		/**
		 * @return 缓存结构
		 */
		public java.util.HashMap getCache() {
			return _cache;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return _id.toString();
		}
		
	}
}
