package com.ai.sacenter.center;

import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.JVMUtils;
import com.ai.sacenter.valuebean.ISystemTemplate.ICenterRoute;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务中心路由</p>
 * <p>Copyright: Copyright (c) 2013-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFCenterOffer implements java.io.Serializable {
	private static final long serialVersionUID = 6392786146196631717L;
	private String  _jvmid      ;
	private String  _region_id  ;
	private String  _center_id  ;
	private String  _channel_id ;
	private String  _platform   ;
	private IUpffxCatalog _subflow = null;
	public SFCenterOffer(){
		super();
		_jvmid = JVMUtils.getJVMID();
	}
	
	public SFCenterOffer( SFCenterCatalog _catalog, CenterInfo _centeroffer ){
		super();
		_jvmid       = JVMUtils.getJVMID()                  ;
		_region_id   = _centeroffer.getRegion()             ;
		_center_id   = _centeroffer.getCenter()             ;
		_channel_id  = "*"                                  ;
		_platform    = IUpdcConst.IUpfwm.IUpfm.ucmframe     ;
		ICenterRoute _route = new ICenterRoute( _region_id, _center_id, _catalog.getCategory(), _platform );
		_subflow     = new IUpffxCatalog( _route , _catalog );
	}
	
	public SFCenterOffer( SFCenterCatalog _catalog, SFCenterOffer _centeroffer ){
		super();
		_jvmid       = JVMUtils.getJVMID()                   ;
		_region_id   = _centeroffer._region_id               ;
		_center_id   = _centeroffer._center_id               ;
		_channel_id  = _centeroffer._channel_id              ;
		_platform    = _centeroffer._platform                ;
		_subflow     = new IUpffxCatalog( _centeroffer._subflow._route, _catalog );
	}
	
	public SFCenterOffer( SFCenterCatalog _catalog, ICenterRoute _centerroute ){
		super();
		_jvmid       = JVMUtils.getJVMID()                        ;
		_region_id   = _centerroute.getROUTE()                    ;
		_center_id   = _centerroute.getCENTER()                   ;
		_channel_id  = _catalog.getChannel()                      ;
		_platform    = _centerroute.getPLATFORM_()                ;
		_subflow     = new IUpffxCatalog( _centerroute, _catalog );
	}
	
	/**
	 * @return 虚拟机编号
	 */
	public String getJVMID() {
		return _jvmid;
	}
	
	/**
	 * @return 区域编码
	 */
	public String getREGION_ID() {
		return _region_id;
	}
	
	/**
	 * @param rEGION_ID 区域编码
	 */
	public void setREGION_ID(String rEGION_ID) {
		_region_id = rEGION_ID;
	}
	
	/**
	 * @return 中心编码
	 */
	public String getCENTER_ID() {
		return _center_id;
	}
	
	/**
	 * @param cENTER 中心编码
	 */
	public void setCENTER(String cENTER_ID) {
		_center_id = cENTER_ID;
	}
	
	/**
	 * @return 渠道编码
	 */
	public String getCHANNEL_ID() {
		return _channel_id;
	}
	
	/**
	 * @param cHANNEL_ID 渠道编码
	 */
	public void setCHANNEL(String cHANNEL_ID) {
		_channel_id = cHANNEL_ID;
	}
	
	/**
	 * @return 网元域
	 */
	public String getPLATFORM() {
		return _platform;
	}
	
	/**
	 * @param pLATFORM 网元域
	 */
	public void setPLATFORM(String pLATFORM) {
		_platform = pLATFORM;
	}
	
	/**
	 * @return 中心规范
	 */
	public IUpffxCatalog getSUBFLOW() {
		return _subflow;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String _bundle = null;
		try
		{
			if( _jvmid.equals( JVMUtils.getJVMID() ) ){
				_bundle = ExceptionFactory.getResource("IOS0011077", 
						new String[]{_center_id, _region_id, _channel_id, _platform });
			}
			else{
				_bundle = ExceptionFactory.getResource("IOS0011078", 
						new String[]{_center_id, _region_id, _channel_id, _platform });
			}
		}
		finally{
			
		}
		return _bundle;
	}
	
	public static class IUpffxCatalog implements java.io.Serializable{
		private static final long serialVersionUID = 8706908967280035212L;
		private ICenterRoute    _route  ;
		private SFCenterCatalog _catalog;
		private java.util.Map   _subflow = new java.util.HashMap();
		public IUpffxCatalog(){
			super();
		}
		
		public IUpffxCatalog( ICenterRoute route, SFCenterCatalog catalog ){
			super();
			_route   = route  ;
			_catalog = catalog;
		}
		
		/**
		 * @return 中心路由
		 */
		public ICenterRoute getRoute() {
			return _route;
		}
		
		/**
		 * @return 中心规范
		 */
		public SFCenterCatalog getCatalog() {
			return _catalog;
		}

		/**
		 * @return the _subflow
		 */
		public java.util.Map getSubFlow() {
			return _subflow;
		}
		
	}
}
