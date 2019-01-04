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
 * <p>Description: ���ݻ��湤��</p>
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
	 * ��ͨ��������
	 * @return
	 */
	public static ICacheConfigure getConfgiure(){
		return IConfigDefine.getINSTANCE().getConfigCache();
	}
	
	/**
	 * ��ͨ�������
	 * @return
	 */
	public static ICacheDequeHome getDeque(){
		return _DEQUE_FACTORY;
	}
	
	/**
	 * ��ͨ�������
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
		 * ��ȡ��ǰ��ͨ���淽��
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
		 * ��ȡ��ǰ��ͨ���漯Ⱥ
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
		 * ���ݼ�Ⱥ��������ȡ��ͨ���漯Ⱥ
		 * @param _cluster ��Ⱥ�������
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
		 * ���ݻ���ʵ���ȡ��ͨ���漯Ⱥ
		 * @param fromCache ����ʵ��,��ΪNULL
		 * @param fromEntity �����
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
		 * ���ݻ���ʵ���ȡ��ͨ���漯Ⱥ
		 * @param fromCache ����ʵ��,��ΪNULL
		 * @param fromEntity �����
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
		 * ���ݵ�ǰ����ʵ���ѯ��ͨ���ü�¼
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
		 * ���ݻ��������ȡ��Ӧ���л�������
		 * @param _class ��������
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.HashMap hgetAll( Class _class ) throws SFException,Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hgetAll( _class );
		}
		
		/**
		 * ���ݻ�������ͼ�ֵ��ȡ��Ӧ��������
		 * @param _class ��������
		 * @param _route  �����ֵ
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public Object hget( Class _class , String _route ) throws SFException,Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hget( _class, _route );
		}
		
		/**
		 * �ü�ֵ�Ƿ����
		 * @param _class ��������
		 * @param _route  �����ֵ
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public boolean hexist( Class _class , String _route ) throws SFException,Exception{
			return IUpdcfgFactory.getIUpdcfgSV().hexist( _class, _route );
		}
		
		/**
		 * ָ����Ⱥˢ�»���
		 * @param _group ��Ⱥ����
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
		 * �����̼߳���������,����ڻ�������������̼߳���������
		 * @param _cache ������
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
		 * ��ȡ��ǰ�̼���������,���߳������в����ڻ������������쳣
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
		 * ��ȡ��ǰ�̼���������,���߳������в����ڻ��������򷵻ؿ�
		 * @return
		 */
		public ICacheDeque getLaten(){
			return (ICacheDeque)_deque_factory.get();
		}
		
		/**
		 * �ύ��ǰ�̼߳���������,�統ǰ���������и�������������ָ�������������
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
		 * �ع���ǰ�̼߳���������,�統ǰ���������и�������������ָ�������������
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
		/*�������*/
		private UUID _id = null;
		/*������*/
		private ICache _group = null;
		/*����ṹ*/
		private java.util.HashMap _cache = new java.util.HashMap();
		/*��������*/
		private ICacheDeque _parent = null;
		public ICacheDeque(){
			super();
			_id = UUID.getUUID();
		}
		
		/**
		 * @return ����ʵ����
		 */
		public ICache getGroup() {
			return _group;
		}
		
		/**
		 * @param group ����ʵ����
		 */
		public void setGroup(ICache group) {
			_group = group;
		}

		/**
		 * @return ����ṹ
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
