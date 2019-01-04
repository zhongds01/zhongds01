package com.ai.sacenter.common;

import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.sacenter.SFException;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���������������</p>
 * <p>Copyright: Copyright (c) 2014-9-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class MBeanDelegate implements java.io.Serializable {
	private static final long serialVersionUID = -2299980239984500672L;
	/*����*/
	private Object _objective;
	/*JVM���*/
	private UUID  _id_ = null;
	/*������ˮ��*/
	private long   _order_id;
	/*������ַ*/
	private String _host_;
	/*��������*/
	private String _weblogic_;
	/*����ʱ��*/
	private java.sql.Timestamp _create;
	/*���б���*/
	private String _region_id;
	/*���ʱ��*/
	private java.sql.Timestamp _complete;
	/*�����ȶ�ʱ��*/
	private java.sql.Timestamp _creator;
	/*���ݷ���DAO��*/
	private Class<?>  _repository;
	/*��������*/
	private String _channel;
	/*��������*/
	private java.util.Locale _locale_;
	/*�����쳣*/
	private SFException _exception = null;
	/*��������*/
	private IUpdbfmxOffer _subflow = null;
	public MBeanDelegate() throws Exception{
		super();
		_id_       = UUID.getUUID                          ();
		_host_     = SystemUtils.getHOST                   ();
		_weblogic_ = SystemUtils.getWEBLOGIC               ();
		_locale_   = AppframeLocaleFactory.getCurrentLocale();
		_subflow   = new IUpdbfmxOffer                     ();
	}

	public MBeanDelegate( Object oBJECTIVE ) throws Exception{
		super();
		_objective = oBJECTIVE                               ; 
		_id_       = UUID.getUUID                          ();
		_host_     = SystemUtils.getHOST                   ();
		_weblogic_ = SystemUtils.getWEBLOGIC               ();
		_locale_   = AppframeLocaleFactory.getCurrentLocale();
		_subflow   = new IUpdbfmxOffer                     ();
	}
	
	/**
	 * @return the oBJECTIVE
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @param oBJECTIVE the oBJECTIVE to set
	 */
	public void setOBJECTIVE(Object oBJECTIVE) {
		_objective = oBJECTIVE;
	}
	
	/**
	 * @return the iD
	 */
	public UUID getID() {
		return _id_;
	}
	
	/**
	 * @return ���ױ��
	 */
	public long getORDER_ID() {
		return _order_id;
	}

	/**
	 * @param order_id ���ױ��
	 */
	public void setORDER_ID(long order_id) {
		_order_id = order_id;
	}
	
	/**
	 * @return ������ַ
	 */
	public String getHOST() {
		return _host_;
	}

	/**
	 * @param host ������ַ
	 */
	public void setHOST(String host) {
		_host_ = host;
	}

	/**
	 * @return ��������
	 */
	public String getWEBLOGIC() {
		return _weblogic_;
	}

	/**
	 * @param weblogic ��������
	 */
	public void setWEBLOGIC(String weblogic) {
		_weblogic_ = weblogic;
	}
	
	/**
	 * @return ����ʱ��
	 */
	public java.sql.Timestamp getCREATE() {
		return _create;
	}

	/**
	 * @param create ����ʱ��
	 */
	public void setCREATE(java.sql.Timestamp create) {
		_create = create;
	}
	
	/**
	 * @return ���б���
	 */
	public String getREGION_ID() {
		return _region_id;
	}

	/**
	 * @param region_id ���б���
	 */
	public void setREGION_ID(String region_id) {
		_region_id = region_id;
	}
	
	/**
	 * @return ���ʱ��
	 */
	public java.sql.Timestamp getCOMPLETE() {
		return _complete;
	}

	/**
	 * @param complete ���ʱ��
	 */
	public void setCOMPLETE(java.sql.Timestamp complete) {
		_complete = complete;
	}
	
	/**
	 * @return �����ȶ�ʱ��
	 */
	public java.sql.Timestamp getCREATOR() {
		return _creator;
	}

	/**
	 * @return ���ݲֿ���
	 */
	public Class<?> getREPOSITORY() {
		return _repository;
	}

	/**
	 * @param repository ���ݲֿ���
	 */
	public void setREPOSITORY(Class<?> repository) {
		_repository = repository;
	}
	
	/**
	 * @param creator �����ȶ�ʱ��
	 */
	public void setCREATOR(java.sql.Timestamp creator) {
		_creator = creator;
	}
	
	/**
	 * @return ��������
	 */
	public String getCHANNEL() {
		return _channel;
	}

	/**
	 * @param channel ��������
	 */
	public void setCHANNEL(String channel) {
		_channel = channel;
	}
	
	/**
	 * @return ��������
	 */
	public java.util.Locale getLOCALE() {
		if( _locale_ == null ) return java.util.Locale.SIMPLIFIED_CHINESE;
		return _locale_;
	}

	/**
	 * @param locale ��������
	 */
	public void setLOCALE(java.util.Locale locale) {
		_locale_ = locale;
	}

	/**
	 * @return �����쳣
	 */
	public SFException getEXCEPTION() {
		return _exception;
	}

	/**
	 * @param exception �����쳣
	 */
	public void setEXCEPTION(SFException exception) {
		_exception = exception;
	}

	/**
	 * @return ��������
	 */
	public IUpdbfmxOffer getSUBFLOW() {
		return _subflow;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String __xml__ = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "InterBOSS" );
			org.dom4j.Element _program = _root.addElement( "PROGRAM" );
			_program.addElement( "_id_"       ).setText( _id_.toString().toUpperCase() );
			_program.addElement( "_host_"     ).setText( _host_                        );
			_program.addElement( "_weblogic_" ).setText( _weblogic_                    );
			_program.addElement( "_locale_"   ).setText( _locale_.toString          () );
			if( _subflow != null ){
				org.dom4j.Element _platform = _program.addElement( "SUBFLOW" );
				_platform.addElement( "_program_" ).setText( _subflow._program_                    );
				_platform.addElement( "_maxbyte_" ).setText( String.valueOf( _subflow._maxbytes_ ) );
			}
			__xml__ = XmlUtils.IXml._format( document.asXML() );
		}
		catch( java.lang.Exception exception ){
			__xml__ = super.toString();
		}
		return __xml__;
	}

	public static class IUpdbfmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = -3639819552353649569L;
		/*�������*/
		private String  _program_    = null;
		/*����ֽ���*/
		private long    _maxbytes_   = 2000;
		/*��������*/
		private java.util.Map<Object, Object> _subflow   = new java.util.HashMap<Object, Object>();
		public IUpdbfmxOffer() throws Exception{
			super();
			ISystemTemplate.IStaticOffer __little__ = null;
			ISystemTemplate.IStaticCategory __category__ = null;
			IConfigDefine.IGlobalDefine.IControlDefine __control__ = null;
			__control__   = IConfigDefine.getINSTANCE().getControl           ();
			_program_     = __control__.getPROGRAM                           ();
			__category__  = SystemUtils.ISystem.getSFStaticCategory( "SYSTEM" );
			if( __category__ != null ){
				if( ( __little__ = __category__.getLITTLE( "BYTE" ) ) != null ){
					_maxbytes_ = Long.parseLong( __little__.getVALUE() );
				}
			}
		}
		
		/**
		 * @return �������
		 */
		public String getPROGRAM() {
			return _program_;
		}

		/**
		 * @param program �������
		 */
		public void setPROGRAM(String program) {
			_program_ = program;
		}
		
		/**
		 * @return ����ֽ���
		 */
		public long getMAXBYTE() {
			return _maxbytes_;
		}

		/**
		 * @param maxbytes ����ֽ���
		 */
		public void setMAXBYTE(long maxbytes) {
			_maxbytes_ = maxbytes;
		}
		
		/**
		 * @return ��������
		 */
		public java.util.Map<Object, Object> getSUBFLOW() {
			return _subflow;
		}
	}
}
