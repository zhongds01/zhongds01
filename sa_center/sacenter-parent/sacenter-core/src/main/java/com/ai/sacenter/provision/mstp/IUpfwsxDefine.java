package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

public class IUpfwsxDefine implements java.io.Serializable{
	private static final long serialVersionUID = 24280328931735981L;
	private IUpffmNetWork PLATFORM_;
	private IUpfspxLife POOL_ = null;
	private org.dom4j.Element ROOT_ = null;
	private java.util.List  NETWORK_= null;
	private java.util.Map STUB_ = new java.util.HashMap();
	public IUpfwsxDefine( IUpffmNetWork fromClient )  throws Exception{
		super();
		PLATFORM_ = fromClient;
		if( StringUtils.startWith( fromClient.getNETWORK(), "$REF[" ) ){ 
			ROOT_ = XmlUtils.parseFileXml(StringUtils.substringBetwn(
					fromClient.getNETWORK(), "$REF[", "]"));
		}
		else if( StringUtils.endsIgnoreCaseWith( fromClient.getNETWORK(), ".xml") ){
			ROOT_ = XmlUtils.parseFileXml( fromClient.getNETWORK() );
		}
		else{
			ROOT_ = XmlUtils.parseXml( fromClient.getNETWORK() );
		}
		POOL_ = new IUpfspxLife( (org.dom4j.Element)ROOT_.element("pool") );
		NETWORK_ = ROOT_.elements( "context" );
		JdomUtils.IJdom.getIJDX$StubL( ROOT_ , STUB_ );
	}
	/**
	 * @return the nETWORK_
	 */
	public java.util.List getNETWORK_() {
		return NETWORK_;
	}

	/**
	 * @return the pLATFORM_
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}

	/**
	 * @return the pOOL_
	 */
	public IUpfspxLife getPOOL_() {
		return POOL_;
	}

	/**
	 * @return the rOOT_
	 */
	public org.dom4j.Element getROOT_() {
		return ROOT_;
	}

	/**
	 * @return the sTUB_
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元上发对象池化信息</p>
	 * <p>Copyright: Copyright (c) 2013-3-26</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfspxLife implements java.io.Serializable{
		private static final long serialVersionUID = -2148053028167854528L;
		private String FACTORY_;
		private String CLIENT_;
		private java.util.Map STUB_ = new java.util.HashMap();
		private org.dom4j.Element ROOT_;
		public IUpfspxLife(org.dom4j.Element aPoolDefine){
			super();
			ROOT_= aPoolDefine;
			FACTORY_ = ROOT_.attributeValue( "factory" );
			StringUtils.manifest( ROOT_.attributeValue("manifest", "maxWait=200" ) , STUB_ );
			CLIENT_ = ROOT_.element("client").getTextTrim();
		}
		/**
		 * @return 池化类工厂
		 */
		public String getFACTORY_() {
			return FACTORY_;
		}
		/**
		 * @return 扩展属性
		 */
		public java.util.Map getSTUB_() {
			return STUB_;
		}
		/**
		 * @return 客户端池化类
		 */
		public String getCLIENT_() {
			return CLIENT_;
		}
		/**
		 * @return 池化配置
		 */
		public org.dom4j.Element getROOT_() {
			return ROOT_;
		}
	}
}
