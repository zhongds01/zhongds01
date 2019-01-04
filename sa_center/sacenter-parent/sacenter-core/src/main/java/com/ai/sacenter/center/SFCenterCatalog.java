package com.ai.sacenter.center;

import com.ai.appframe2.complex.datasource.DataSourceTemplate;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.ICenterCatalog;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpdbcWrapper;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �������ı���</p>
 * <p>Copyright: Copyright (c) 2015��6��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFCenterCatalog implements java.io.Serializable{
	private static final long serialVersionUID = 1993268501911296231L;
	/*����·��*/
	private String  _objective;
	/*��������*/
	private String  _category ;
	/*����ֵ*/
	private Object  _center   ; 
	/*��������*/
	private String  _channel  ;
	/*����Ŀ¼*/
	private IUpffxCatalog  _subflow = null;
	public SFCenterCatalog( String __objective ) throws Exception{
		super();
		_objective = __objective                    ;
		_category  = null                           ;
		_center    = null                           ;
		_channel   = "*"                            ;
		_subflow   = new IUpffxCatalog( _objective );
	}
	
	public SFCenterCatalog( SFCenterCatalog __catalog ) throws Exception{
		super();
		_objective = __catalog._objective                   ;
		_category  = __catalog._category                    ;
		_center    = __catalog._center                      ;
		_channel   = __catalog._channel                     ;
		_subflow   = new IUpffxCatalog( __catalog._subflow );
	}
	
	public SFCenterCatalog( ISystemTemplate.ICenterWrapper __catalog, Object __region_id ) throws Exception{
		super();
		_objective = __catalog.getID                         ();
		_category  = __catalog.getCATEGORY                   ();
		_center    = __region_id                               ;
		_channel   = "*"                                       ;
		_subflow   = new IUpffxCatalog( _objective, __catalog );
	}
	
	public SFCenterCatalog(String __implclass, String  __category, Object __region_id, String __channel) throws Exception{
		super();
		_objective = __implclass                    ;
		_category  = __category                     ;
		_center    = __region_id                    ;
		_channel   = __channel                      ;
		_subflow   = new IUpffxCatalog( _objective );
	}
	
	public SFCenterCatalog(ISystemTemplate.ICenterMapping __catalog, Object __region_id, String __channel) throws Exception{
		super();
		_objective = __catalog.getFUNCTION                   ();
		_category  = __catalog.getID                         ();
		_center    = __region_id                               ;
		_channel   = __channel                                 ;
		_subflow   = new IUpffxCatalog( _objective, __catalog );
	}
	
	public SFCenterCatalog(String __implclass, ISystemTemplate.ICenterMapping __catalog, String  __category, Object __region_id, String __channel) throws Exception{
		super();
		_objective = __implclass                               ;
		_category  = __catalog.getID()                         ;
		_center    = __region_id                               ;
		_channel   = __channel                                 ;
		_subflow   = new IUpffxCatalog( _objective, __catalog );
	}
	
	/**
	 * @return the oBJECTIVE
	 */
	public String getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return ��������
	 */
	public String getCategory() {
		return _category;
	}
	
	/**
	 * @param cATEGORY ��������
	 */
	public void setCategory(String cATEGORY) {
		_category = cATEGORY;
	}
	
	/**
	 * @return ����ֵ
	 */
	public Object getCenter() {
		return _center;
	}
	
	/**
	 * @param cENTER ����ֵ
	 */
	public void setCenter(Object cENTER) {
		_center = cENTER;
	}
	
	/**
	 * @return ��������
	 */
	public String getChannel() {
		return _channel;
	}
	
	/**
	 * @param cHANNEL ��������
	 */
	public void setChannel(String cHANNEL) {
		_channel = cHANNEL;
	}
	
	/**
	 * @return ���Ĺ淶
	 */
	public IUpffxCatalog getSUBFLOW() {
		return _subflow;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		java.util.Map fromBundle = new java.util.HashMap();
		try
		{
			java.util.Map fromBody = null;
			fromBundle.put( "OBJECTIVE", _objective                   );
			fromBundle.put( "CATEGORY" , _category                    );
			fromBundle.put( "CENTER"   , _center                      );
			fromBundle.put( "PLATFORM" , _subflow.getNetWork().getID());
			fromBundle.put( "BODY"     , fromBody = new java.util.HashMap());
			if( _subflow != null && _subflow._catalog != null ){
				fromBody.put( "DATASOURCE" , _subflow._catalog.getCOMPOSITE() );
			}
			if( _subflow._mapping != null ){
				fromBody.put( "PLATFORM_" , _subflow._mapping.getPLATFORM_() );
				fromBody.put( "CATEGORY_" , _subflow._mapping.getCATEGORY () );
				fromBody.put( "FUNCTION"  , _subflow._mapping.getFUNCTION () );
				fromBody.put( "COMPLEX"   , _subflow._mapping.getCOMPLEX  () );
			}
			fromXML = XmlUtils.createGeneralXml("InterBOSS", fromBundle );
		}
		catch( java.lang.Exception exception ){
			fromXML = super.toString();
		}
		finally{
			if( fromBundle != null ){ fromBundle.clear(); fromBundle = null; }
		}
		return fromXML;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018��5��7��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffxCatalog implements java.io.Serializable{
		private static final long serialVersionUID = 8922199397159193984L;
		private Class _objective = null;
		/*����Ŀ¼*/
		private ICenterCatalog _catalog;
		/*����ӳ��*/
		private IUpdbcWrapper  _mapping;
		/*������Ԫ*/
		private IUpffmOffer    _network;
		/*������*/
		private IUpdcContext   _context;
		/*��������*/
		private java.util.Map  _subflow = new java.util.HashMap();
		public IUpffxCatalog( String objective ) throws Exception{
			super();
			_objective = Class.forName( objective );
		}
		
		public IUpffxCatalog( IUpffxCatalog __catalog ) throws Exception{
			super();
			_objective = __catalog._objective    ;
			_catalog   = __catalog._catalog      ;
			_mapping   = __catalog._mapping      ;
			_network   = __catalog._network      ;
			_context   = __catalog._context      ;
			_subflow.putAll( __catalog._subflow );
		}
		
		public IUpffxCatalog( String objective, ISystemTemplate.ICenterWrapper __catalog ) throws Exception{
			super();
			_objective = Class.forName( objective );
			_mapping   = __catalog                 ;
		}
		
		public IUpffxCatalog( String objective, ISystemTemplate.ICenterMapping __catalog ) throws Exception{
			super();
			_objective = Class.forName( objective );
			_mapping   = __catalog                 ;
		}
		
		/**
		 * @return ����Ŀ¼
		 */
		public ICenterCatalog getCatalog(){
			try
			{
				if( _catalog == null && _objective != null ){
					if( _mapping != null && _mapping instanceof ISystemTemplate.ICenterWrapper /*Ϊ��չ����*/ ){
						_catalog = CenterUtils.ICustom.getSFCenterChannel( _objective.getName() );
					}
					else{
						_catalog = CenterUtils.ICustom.getSFCenterChannel( _objective.getName() );
						if( _catalog == null && DataSourceTemplate.getCurrentTemplate() != null /*ΪĬ������*/ ){
							_catalog = new ICenterCatalog( _objective, DataSourceTemplate.getCurrentTemplate() ); 
						}
					}
				}
			}
			catch( java.lang.Exception exception ){
				ExceptionFactory.throwRuntime( exception );
			}
			return _catalog;
		}
		
		/**
		 * @param catalog ����Ŀ¼
		 */
		public void setCatalog(ICenterCatalog catalog) {
			_catalog = catalog;
		}
		
		/**
		 * @return ����ӳ��
		 */
		public IUpdbcWrapper getMapping() {
			return _mapping;
		}
		
		/**
		 * @param mapping ����ӳ��
		 */
		public void setMapping(IUpdbcWrapper mapping) {
			_mapping = mapping;
		}
		
		/**
		 * @return ������Ԫ
		 */
		public IUpffmOffer getNetWork(){
			try
			{
				if( _network == null && _objective != null ){
					_network = CenterUtils.ICustom.getSFCenterNetWork( _objective.getName() );
				}
			}
			catch( java.lang.Exception exception ){
				ExceptionFactory.throwRuntime( exception );
			}
			return _network;
		}
		
		/**
		 * @param network ������Ԫ
		 */
		public void setNetWork(IUpffmOffer  network) {
			_network = network;
		}
		
		/**
		 * @return the _context
		 */
		public IUpdcContext getContext() {
			if( _context == null ){ _context = ClassUtils.getIContextImpl(); }
			return _context;
		}
		
		/**
		 * @param context the _context to set
		 */
		public void setContext(IUpdcContext context) {
			_context = context;
		}
		
		/**
		 * @return ��������
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * �Ƿ��Զ�����������
		 * @return
		 */
		public boolean isCUSTOM(){
			return _mapping != null && _mapping instanceof ISystemTemplate.ICenterWrapper;
		}
		
	}
}
