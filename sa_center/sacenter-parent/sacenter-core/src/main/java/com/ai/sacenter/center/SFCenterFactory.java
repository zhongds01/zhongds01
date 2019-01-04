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
 * <p>Description: ����ͨ����·��</p>
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
	 * ������·��ԭ�����APPӦ�÷�������
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
	 * ������·��ԭ�����û��ڷ���������Ϣ
	 * @param fromREGION ���ı���
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
	 * �������ı������û��ڷ�����Ԫ��������Ϣ
	 * @param _category ������������
	 * @param _region_id ��������ֵ
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
	 * ���ݷ���·�������û���DAO���ڲ���������
	 * @param _implclass ����·����
	 * @param _region_id ��������ֵ
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
	 * �������ı������û��ڷ�����Ԫ��������Ϣ
	 * @param _category ������������
	 * @param _region_id ��������ֵ
	 * @param _channel ������Ԫ��
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
	 * �������ı������û��ڷ�����Ԫ��������Ϣ
	 * @param _implclass �����ʲ���
	 * @param _category ������������
	 * @param _region_id ��������ֵ
	 * @param _channel ������Ԫ��
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
	 * �����������ͺ͵����������ɵ�ǰ����������Ϣ
	 * @param _catalog  ��������
	 * @param _centeroffer ��������
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
	 * ��ȡ��ǰ������Ϣ
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
	 * ��ȡ��ǰ������Ϣ,���޷��������򷵻ؿ�
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
	 * ��ȡ·�����Լ�
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
	 * �ͷŵ�ǰ������Ϣ,����ڸ���������ָ�������Ϣ
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
		/*���*/
		private UUID _id;
		/*�Է�����*/
		private Object           _objective;
		/*��������*/
		private SFCenterCatalog  _catalog;
		/*������Ϣ*/
		private SFCenterOffer    _center;
		/*��������*/
		private java.util.Map    _subflow;
		/*����·��*/
    	private ICenterOfferHome _parent;
		public ICenterOfferHome(){
			super();
			_id      = UUID.getUUID();
			_parent  =  null;
			_subflow = new java.util.HashMap();
		}
		
		/**
		 * @return ���ı���
		 */
		public UUID getID() {
			return _id;
		}
		
		/**
		 * @return �Է�����
		 */
		public Object getOBJECTIVE() {
			return _objective;
		}
		
		/**
		 * @param objective �Է�����
		 */
		public void setOBJECTIVE(Object objective) {
			_objective = objective;
		}
		
		/**
		 * @return ��������
		 */
		public SFCenterCatalog getCatalog() {
			return _catalog;
		}
		
		/**
		 * @param catalog ��������
		 */
		public void setCatalog(SFCenterCatalog catalog) {
			_catalog = catalog;
		}
		
		/**
		 * @return ��������
		 */
		public SFCenterOffer getCENTER() {
			return _center;
		}
		
		/**
		 * @param center ��������
		 */
		public void setCENTER(SFCenterOffer center) {
			_center = center;
		}
		
		/**
		 * @return ��������
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
		
	}
}
