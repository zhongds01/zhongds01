package com.ai.sacenter.center;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.UUID;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务开通中心路由</p>
 * <p>Copyright: Copyright (c) 2015-3-18</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFCenterFactory {
	private final static ThreadLocal DEFAULT_FACTORY = new ThreadLocal();
	public SFCenterFactory() {
		super();
	}
	
	/**
	 * 按地市路由原则基于APP应用服务中心
	 * @throws SFException
	 * @throws Exception
	 */
	public static void pushCenterInfo() throws SFException,Exception{
		try
		{
			SFCenterOffer _centeroffer = null;
			SFCenterCatalog _catalog = null;
			ICenterOfferHome _centerhome = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome != null ){
				SFCenterCatalog __catalog = _centerhome.getCatalog();
				_catalog     = new SFCenterCatalog( __catalog                     );
				_centeroffer = new SFCenterOffer  ( _catalog, _centerhome._center );
			}
			else{
				CenterInfo _centerinfo = CenterFactory.getCenterInfo();
				_catalog = CenterUtils.ISystem._jj_catalog(IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _centerinfo.getRegion(), "*" );
				_centeroffer = new SFCenterOffer( _catalog, _centerinfo );
			}
			wrapWithCenter( _catalog, _centeroffer );
		}
		finally{
			
		}
	}
	
	/**
	 * 按地市路由原则设置基于服务中心信息
	 * @param fromREGION 中心编码
	 * @throws SFException
	 * @throws Exception
	 */
	public static void pushCenterInfo( String _region_id ) throws SFException,Exception{
		try 
		{
			SFCenterCatalog _catalog = CenterUtils.ISystem._jj_catalog(IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _region_id, "*");
			SFCenterOffer _centeroffer = CenterUtils.ISystem._wrap( _region_id, _catalog);
			wrapWithCenter( _catalog, _centeroffer );
		} 
		finally {

		}
	}
	
	/**
	 * 根据中心编码设置基于服务网元测中心信息
	 * @param _category 服务中心类型
	 * @param _region_id 服务中心值
	 * @throws SFException
	 * @throws Exception
	 */
	public static void pushCenterInfo( String _category, Object _region_id ) throws SFException,Exception{
		try
		{
			SFCenterCatalog _catalog = CenterUtils.ISystem._jj_catalog(_category, _region_id, "*" );
			SFCenterOffer _centeroffer = CenterUtils.ISystem._wrap( _catalog.getCenter(), _catalog );
			wrapWithCenter( _catalog, _centeroffer );
		}
		finally{
			
		}
	}
	
	/**
	 * 根据服务路由类设置基于DAO类内部数据中心
	 * @param _implclass 服务路由类
	 * @param _region_id 服务中心值
	 * @throws SFException
	 * @throws Exception
	 */
	public static void pushCenterInfo( Class _implclass, Object _region_id ) throws SFException,Exception{
		try
		{
			SFCenterCatalog _catalog = CenterUtils.ISystem._jj_catalog( _implclass, _region_id );
			SFCenterOffer _centeroffer = CenterUtils.ISystem._wrap( _catalog.getCenter(), _catalog );
			wrapWithCenter( _catalog, _centeroffer );
		}
		finally{
			
		}
	}
	
	/**
	 * 根据中心编码设置基于服务网元测中心信息
	 * @param _category 服务中心类型
	 * @param _region_id 服务中心值
	 * @param _channel 服务网元域
	 * @throws SFException
	 * @throws Exception
	 */
	public static void pushCenterInfo(String _category, Object _region_id, String _channel ) throws SFException,Exception{
		try 
		{
			SFCenterCatalog _catalog = CenterUtils.ISystem._jj_catalog(_category, _region_id, _channel );
			SFCenterOffer _centeroffer = CenterUtils.ISystem._wrap( _catalog.getCenter(), _catalog );
			wrapWithCenter( _catalog, _centeroffer );
		} 
		finally {

		}
	}
	
	/**
	 * 根据中心编码设置基于服务网元测中心信息
	 * @param _implclass 服务资产类
	 * @param _category 服务中心类型
	 * @param _region_id 服务中心值
	 * @param _channel 服务网元域
	 * @throws SFException
	 * @throws Exception
	 */
	public static void pushCenterInfo(String _implclass, String _category, Object _region_id, String _channel ) throws SFException,Exception{
		try 
		{
			SFCenterCatalog _catalog = CenterUtils.ISystem._jj_catalog(_implclass, _category, _region_id, _channel);
			SFCenterOffer _centeroffer = CenterUtils.ISystem._wrap( _catalog.getCenter(), _catalog );
			wrapWithCenter( _catalog, _centeroffer );
		} 
		finally {

		}
	}
	
	/**
	 * 根据中心类型和地市类型生成当前激活中心信息
	 * @param _catalog  服务类型
	 * @param _centeroffer 服务中心
	 * @throws SFException
	 * @throws Exception
	 */
	private static ICenterOfferHome wrapWithCenter( SFCenterCatalog _catalog, SFCenterOffer _centeroffer ) throws SFException,Exception{
		ICenterOfferHome _centerhome = null;
		try 
		{
			_centerhome = new ICenterOfferHome();
			_centerhome._parent = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome._parent == null && CenterFactory.isSetCenterInfo() ) {
				CenterInfo _centerinfo = CenterFactory.getCenterInfo();
				_centerhome._parent = new ICenterOfferHome();
				_centerhome._parent._catalog = CenterUtils.ISystem._jj_catalog(IUpdcConst.IUpdbm.IUpdmc.REGION_ID, 
						_centerinfo.getRegion(), 
						"*" );
				_centerhome._parent._center = new SFCenterOffer( _centerhome._parent._catalog, _centerinfo );
				_centerhome._parent._objective = null;
			}
			CenterInfo fromCenter = new CenterInfo( _centeroffer.getCENTER_ID(), _centeroffer.getREGION_ID() );
			CenterFactory.setDirectCenterInfo( fromCenter );
			if( _centerhome._parent != null ){ _centerhome._subflow.putAll( _centerhome._parent._subflow ); }
			_catalog.getSUBFLOW().getSUBFLOW().putAll( _centerhome._subflow );
			_centerhome.setCatalog  ( _catalog     );
			_centerhome.setOBJECTIVE( new Object() );
			_centerhome.setCENTER   ( _centeroffer );
			DEFAULT_FACTORY.set( _centerhome );
		} 
		finally {

		}
		return _centerhome;
	}
	
	/**
	 * 获取当前中心信息
	 * @return
	 */
	public static SFCenterOffer getCenterInfo(){
		SFCenterOffer _centeroffer = null;
		try 
		{
			ICenterOfferHome _centerhome = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome == null ){
				ExceptionFactory.throwRuntime("IOS0010000", new String[] { Thread.currentThread().getName() });
			}
			_centeroffer = _centerhome._center;
		} 
		finally {

		}
		return _centeroffer;
	}
	
	/**
	 * 获取当前中心信息,如无服务中心则返回空
	 * @return
	 */
	public static SFCenterOffer getCenterBlank(){
		SFCenterOffer _centeroffer = null;
		try 
		{
			ICenterOfferHome _centerhome = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome != null ){ _centeroffer = _centerhome._center; }
		} 
		finally{

		}
		return _centeroffer;
	}
	
	/**
	 * 
	 * @return
	 */
	public static SFCenterCatalog getCatalog(){
		SFCenterCatalog __catalog = null;
		try
		{
			ICenterOfferHome _centerhome = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome == null ){
				ExceptionFactory.throwRuntime("IOS0010000", new String[] { Thread.currentThread().getName() });
			}
			__catalog = _centerhome._catalog;
		}
		finally{
			
		}
		return __catalog;
	}
	
	/**
	 * 获取路由属性集
	 * @return
	 */
	public static ICenterOfferHome getSubFlow( ){
		ICenterOfferHome _centerhome = null;
		try
		{
			_centerhome = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome == null ){
				ExceptionFactory.throwRuntime("IOS0010000", new String[] { Thread.currentThread().getName() });
			}
		}
		finally{
			
		}
		return _centerhome;
	}
	
	/**
	 * 释放当前中心信息,如存在父级中心则恢复中心信息
	 * @throws SFException
	 * @throws Exception
	 */
	public static void popCenterInfo( ) throws SFException,Exception{
		try 
		{
			ICenterOfferHome _centerhome = (ICenterOfferHome)DEFAULT_FACTORY.get();
			if( _centerhome != null ) {
				CenterFactory.popCenterInfo();
				if( _centerhome._parent == null ){
					CenterFactory.setCenterInfoEmpty();
					DEFAULT_FACTORY.set( null );
				} 
				else{
					SFCenterOffer _centeroffer = _centerhome._parent._center;
					CenterInfo _centerinfo = new CenterInfo( _centeroffer.getCENTER_ID(), _centeroffer.getREGION_ID() );
					CenterFactory.setDirectCenterInfo( _centerinfo );
					if( _centerhome._parent._objective == null ) {
						DEFAULT_FACTORY.set( null );
					} 
					else{
						DEFAULT_FACTORY.set( _centerhome._parent );
					}
				}
			}
		} 
		finally {

		}
	}
	
	public static class ICenterOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 9042240871525213068L;
		/*编号*/
		private UUID _id;
		/*自服中心*/
		private Object           _objective;
		/*激活中心*/
		private SFCenterCatalog  _catalog;
		/*中心信息*/
		private SFCenterOffer    _center;
		/*服务属性*/
		private java.util.Map    _subflow;
		/*父级路由*/
    	private ICenterOfferHome _parent;
		public ICenterOfferHome(){
			super();
			_id      = UUID.getUUID();
			_parent  =  null;
			_subflow = new java.util.HashMap();
		}
		
		/**
		 * @return 中心编码
		 */
		public UUID getID() {
			return _id;
		}
		
		/**
		 * @return 自服中心
		 */
		public Object getOBJECTIVE() {
			return _objective;
		}
		
		/**
		 * @param objective 自服中心
		 */
		public void setOBJECTIVE(Object objective) {
			_objective = objective;
		}
		
		/**
		 * @return 激活中心
		 */
		public SFCenterCatalog getCatalog() {
			return _catalog;
		}
		
		/**
		 * @param catalog 激活中心
		 */
		public void setCatalog(SFCenterCatalog catalog) {
			_catalog = catalog;
		}
		
		/**
		 * @return 服务中心
		 */
		public SFCenterOffer getCENTER() {
			return _center;
		}
		
		/**
		 * @param center 服务中心
		 */
		public void setCENTER(SFCenterOffer center) {
			_center = center;
		}
		
		/**
		 * @return 服务属性
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
		
	}
}
