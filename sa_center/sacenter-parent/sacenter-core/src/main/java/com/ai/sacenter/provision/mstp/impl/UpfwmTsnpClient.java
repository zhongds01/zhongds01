package com.ai.sacenter.provision.mstp.impl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.util.HttpUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 中移网状网协议客户端</p>
 * <p>Copyright: Copyright (c) 2015-3-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmTsnpClient extends UpfwmHttpClient {
	private static final long serialVersionUID = -5258477705931404975L;
	public UpfwmTsnpClient(IUpffmNetWork fromUpfm, IUpfwmDefine fromNetWork)
			throws Exception {
		super(fromUpfm, fromNetWork);
	}
	/**
	 * 
	 * @param fromTsnpReq
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public UpfwmTsnpRsp call( UpfwmTsnpReq fromTsnpReq ) throws SFException,Exception{
		UpfwmTsnpRsp fromRsRsp = null;
		try
		{
			if (StringUtils.isBlank(fromTsnpReq.xmlhead)) {
				ExceptionFactory.throwIllegal("IOS0012016", new String[] {PLATFORM_.getID(), "xmlhead" });
			}
			String xmlhome = call(fromTsnpReq.xmlhead, fromTsnpReq.xmlbody, fromTsnpReq.attachfile);
			fromRsRsp = new UpfwmTsnpRsp(xmlhome);
		} 
		finally {

		}
		return fromRsRsp;
	}
	/**
	 * 
	 * @param xmlhead
	 * @param xmlbody
	 * @param attachfile
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String call( String xmlhead, 
			String xmlbody, 
			java.io.File attachfile ) throws SFException,Exception{
		String xmlhome = null;
		java.util.List fromBody = new java.util.ArrayList();
		try {
			fromBody.add(new StringPart("xmlhead", xmlhead, "UTF-8"));
			if (StringUtils.isBlank(xmlbody) == false) {
				fromBody.add(new StringPart("xmlbody", xmlbody, "UTF-8"));
			}
			if (attachfile != null && attachfile.exists()) {
				fromBody.add(new FilePart("attachfile", attachfile, null, "UTF-8"));
			}
			Part[] fromEntity = (Part[]) fromBody.toArray(new Part[] {});
			xmlhome = doPost(fromEntity);
			if (StringUtils.isBlank(xmlhome)) {
				fault(String.valueOf(9999), "NULL");
			}
		} finally {
			if (fromBody != null) {
				fromBody.clear();
				fromBody = null;
			}
		}
		return xmlhome;
	}
	/**
	 * 
	 * @param fromEntity
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private String doPost( Part fromEntity[] ) throws SFException,Exception{
		String xmlhome = null;
		try 
		{
			CfgHttpClient _httpclient_ = SystemUtils.ISystem.getSFUpfgkmHttp(NETWORK_, PLATFORM_);
			HttpClient fromClient = HttpUtils.ICustom.wrap( _httpclient_ );
			PostMethod fromPost = new PostMethod(_httpclient_.getUrlAddress());
			fromPost.getParams().setParameter("http.method.multipart.boundary", "asiainfo");
			MultipartRequestEntity fromPart = new MultipartRequestEntity(
					fromEntity, fromPost.getParams());
			fromPost.setRequestEntity(fromPart);
			int fromSTATUS = fromClient.executeMethod(fromPost);
			if (fromSTATUS != HttpStatus.SC_OK) {
				fault( String.valueOf(fromSTATUS), HttpStatus.getStatusText(fromSTATUS));
			}
			xmlhome = fromPost.getResponseBodyAsString();
		} finally {

		}
		return xmlhome;
	}
	/**
	 * 
	 * @param faultcode
	 * @param faultString
	 * @throws SFException
	 * @throws Exception
	 */
	private void fault( String faultcode,
			String faultString ) throws SFException,Exception{
		try
		{
			ExceptionFactory.throwFault("IOS0012015", new String[] { PLATFORM_.getID(),
					faultcode, faultString },
					PLATFORM_.getID(), faultString);
		}
		finally{
			
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-1-29</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmTsnpDefine extends UpfwmHttpClient.IUpfwmHttpDefine{
		private static final long serialVersionUID = -1222623433411511644L;
		public IUpfwmTsnpDefine(org.dom4j.Element aElement ) throws Exception{
			super( aElement );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-3-16</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class UpfwmTsnpReq implements java.io.Serializable{
		private static final long serialVersionUID = 3516824369621586850L;
		private String xmlhead;
		private String xmlbody;
		private java.io.File attachfile;
		public UpfwmTsnpReq(){
			super();
			xmlhead = null;
			xmlbody = null;
			attachfile = null;
		}
		/**
		 * @return the attachfile
		 */
		public java.io.File getAttachfile() {
			return attachfile;
		}
		/**
		 * @param attachfile the attachfile to set
		 */
		public void setAttachfile(java.io.File attachfile) {
			this.attachfile = attachfile;
		}
		/**
		 * @return the xmlbody
		 */
		public String getXmlbody() {
			return xmlbody;
		}
		/**
		 * @param xmlbody the xmlbody to set
		 */
		public void setXmlbody(String xmlbody) {
			this.xmlbody = xmlbody;
		}
		/**
		 * @return the xmlhead
		 */
		public String getXmlhead() {
			return xmlhead;
		}
		/**
		 * @param xmlhead the xmlhead to set
		 */
		public void setXmlhead(String xmlhead) {
			this.xmlhead = xmlhead;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-3-7</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class UpfwmTsnpRsp implements java.io.Serializable{
		private static final long serialVersionUID = 4326098849620200761L;
		private String rsRspCode;
		private String rsRspDesc;
		private String svcCont;
		private String xmlHome = null;
		public UpfwmTsnpRsp( String fromHome ){
			super();
			xmlHome = fromHome;
			org.dom4j.Element fromBoss = XmlUtils.parseXml(fromHome);
			org.dom4j.Element fromRsRsp = fromBoss.element("Response");
			if (fromRsRsp != null) {
				rsRspCode = fromRsRsp.elementText("RspCode");
				rsRspDesc = fromRsRsp.elementText("RspDesc");
			}
			fromRsRsp = fromRsRsp.element("SvcCont");
			if (fromRsRsp != null)
				svcCont = fromRsRsp.getTextTrim();
		}
		/**
		 * @return the rsRspCode
		 */
		public String getRsRspCode() {
			return rsRspCode;
		}
		/**
		 * @return the rsRspDesc
		 */
		public String getRsRspDesc() {
			return rsRspDesc;
		}
		/**
		 * @return the svcCont
		 */
		public String getSvcCont() {
			return svcCont;
		}
		/**
		 * @return the xmlHome
		 */
		public String getXmlHome() {
			return xmlHome;
		}
		
	}
}
