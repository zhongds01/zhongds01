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
 * <p>Description: 服务调用质量控制</p>
 * <p>Copyright: Copyright (c) 2014-9-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class MBeanDelegate implements java.io.Serializable {
	private static final long serialVersionUID = -2299980239984500672L;
	/*发起方*/
	private Object _objective;
	/*JVM编号*/
	private UUID  _id_ = null;
	/*操作流水号*/
	private long   _order_id;
	/*主机地址*/
	private String _host_;
	/*服务名称*/
	private String _weblogic_;
	/*创建时间*/
	private java.sql.Timestamp _create;
	/*地市编码*/
	private String _region_id;
	/*完成时间*/
	private java.sql.Timestamp _complete;
	/*订购比对时间*/
	private java.sql.Timestamp _creator;
	/*数据访问DAO类*/
	private Class<?>  _repository;
	/*渠道编码*/
	private String _channel;
	/*语言属性*/
	private java.util.Locale _locale_;
	/*服务异常*/
	private SFException _exception = null;
	/*其他参数*/
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
	 * @return 交易编号
	 */
	public long getORDER_ID() {
		return _order_id;
	}

	/**
	 * @param order_id 交易编号
	 */
	public void setORDER_ID(long order_id) {
		_order_id = order_id;
	}
	
	/**
	 * @return 主机地址
	 */
	public String getHOST() {
		return _host_;
	}

	/**
	 * @param host 主机地址
	 */
	public void setHOST(String host) {
		_host_ = host;
	}

	/**
	 * @return 服务名称
	 */
	public String getWEBLOGIC() {
		return _weblogic_;
	}

	/**
	 * @param weblogic 服务名称
	 */
	public void setWEBLOGIC(String weblogic) {
		_weblogic_ = weblogic;
	}
	
	/**
	 * @return 创建时间
	 */
	public java.sql.Timestamp getCREATE() {
		return _create;
	}

	/**
	 * @param create 创建时间
	 */
	public void setCREATE(java.sql.Timestamp create) {
		_create = create;
	}
	
	/**
	 * @return 地市编码
	 */
	public String getREGION_ID() {
		return _region_id;
	}

	/**
	 * @param region_id 地市编码
	 */
	public void setREGION_ID(String region_id) {
		_region_id = region_id;
	}
	
	/**
	 * @return 完成时间
	 */
	public java.sql.Timestamp getCOMPLETE() {
		return _complete;
	}

	/**
	 * @param complete 完成时间
	 */
	public void setCOMPLETE(java.sql.Timestamp complete) {
		_complete = complete;
	}
	
	/**
	 * @return 订购比对时间
	 */
	public java.sql.Timestamp getCREATOR() {
		return _creator;
	}

	/**
	 * @return 数据仓库类
	 */
	public Class<?> getREPOSITORY() {
		return _repository;
	}

	/**
	 * @param repository 数据仓库类
	 */
	public void setREPOSITORY(Class<?> repository) {
		_repository = repository;
	}
	
	/**
	 * @param creator 订购比对时间
	 */
	public void setCREATOR(java.sql.Timestamp creator) {
		_creator = creator;
	}
	
	/**
	 * @return 渠道编码
	 */
	public String getCHANNEL() {
		return _channel;
	}

	/**
	 * @param channel 渠道编码
	 */
	public void setCHANNEL(String channel) {
		_channel = channel;
	}
	
	/**
	 * @return 语言属性
	 */
	public java.util.Locale getLOCALE() {
		if( _locale_ == null ) return java.util.Locale.SIMPLIFIED_CHINESE;
		return _locale_;
	}

	/**
	 * @param locale 语言属性
	 */
	public void setLOCALE(java.util.Locale locale) {
		_locale_ = locale;
	}

	/**
	 * @return 服务异常
	 */
	public SFException getEXCEPTION() {
		return _exception;
	}

	/**
	 * @param exception 服务异常
	 */
	public void setEXCEPTION(SFException exception) {
		_exception = exception;
	}

	/**
	 * @return 其他参数
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
		/*服务组件*/
		private String  _program_    = null;
		/*最大字节数*/
		private long    _maxbytes_   = 2000;
		/*其他参数*/
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
		 * @return 服务组件
		 */
		public String getPROGRAM() {
			return _program_;
		}

		/**
		 * @param program 服务组件
		 */
		public void setPROGRAM(String program) {
			_program_ = program;
		}
		
		/**
		 * @return 最大字节数
		 */
		public long getMAXBYTE() {
			return _maxbytes_;
		}

		/**
		 * @param maxbytes 最大字节数
		 */
		public void setMAXBYTE(long maxbytes) {
			_maxbytes_ = maxbytes;
		}
		
		/**
		 * @return 其他参数
		 */
		public java.util.Map<Object, Object> getSUBFLOW() {
			return _subflow;
		}
	}
}
