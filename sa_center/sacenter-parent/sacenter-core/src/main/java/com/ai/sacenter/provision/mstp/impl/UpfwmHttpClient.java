package com.ai.sacenter.provision.mstp.impl;

import org.apache.commons.httpclient.HttpStatus;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;
import com.asiainfo.appframe.ext.exeframe.http.client.HttpUtil;
import com.asiainfo.appframe.ext.exeframe.http.client.response.HttpResponse;
import com.asiainfo.appframe.ext.exeframe.http.client.response.HttpResponseByte;
import com.asiainfo.appframe.ext.exeframe.http.client.response.HttpResponseString;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-29</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmHttpClient extends UpfwmDefault {
	private static final long serialVersionUID = -6581711408347307321L;
	protected String _client_ = null;
	public UpfwmHttpClient(IUpffmNetWork fromUpfm, IUpfwmDefine fromNetWork) throws Exception {
		super(fromUpfm, fromNetWork);
		try
		{
			IUpfwmHttpDefine fromHttp = null;
			for (java.util.Iterator itera = fromNetWork.getNETWORK_().iterator(); itera.hasNext();) {
				fromHttp = (IUpfwmHttpDefine) itera.next();
				if (StringUtils.isBlank(fromHttp.getURL()) == false) {
					_client_ = fromHttp.getURL();
					break;
				}
			}
		}
		finally{
			
		}
	}
	/**
	 * 调用远端服务
	 * @param fromPARAM 请求参数
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object call( Object fromPARAM ) throws SFException,Exception{
		Object fromASK = null;
		try
		{
			HttpResponse fromUpfgsm = null;
			CfgHttpClient _httpclient_ = SystemUtils.ISystem.getSFUpfgkmHttp(NETWORK_, PLATFORM_);
			if (ClassUtils.IClass.isMap(fromPARAM) /* 基于Map形参调用 */) {
				fromUpfgsm = (HttpResponse) HttpUtil.doPost(_httpclient_.getCfgHttpClientCode(), (java.util.Map) fromPARAM);
			} else/* 基于String形参调用 */{
				fromUpfgsm = (HttpResponse) HttpUtil.doPost(_httpclient_.getCfgHttpClientCode(), null, ((String) fromPARAM).getBytes("UTF-8"));
			}
			if( fromUpfgsm.getStatusCode() != HttpStatus.SC_OK ){
				fault( fromUpfgsm );
			}
			else if( fromUpfgsm instanceof HttpResponseByte ){
				fromASK = ((HttpResponseByte)fromUpfgsm).getResponseBody();
			}
			else{
				fromASK = ((HttpResponseString)fromUpfgsm).getResponseBody();
			}
		}
		finally{
			
		}
		return fromASK;
	}
	
	/**
	 * 调用远端服务
	 * @param xmlhead 报文头参数
	 * @param xmlbody 报文体
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String call( java.util.Map xmlhead, String xmlbody ) throws SFException,Exception{
		String fromASK = null;
		try
		{
			CfgHttpClient _httpclient_ = SystemUtils.ISystem.getSFUpfgkmHttp(NETWORK_, PLATFORM_);
			if( xmlhead == null || StringUtils.isBlank( xmlbody ) ){
				ExceptionFactory.throwIllegal("IOS0012016", new String[] { NETWORK_.getID_(), "xmlhead/xmlbody" });	
			}
			HttpResponse fromUpffmx = (HttpResponse)HttpUtil.doPost( _httpclient_.getCfgHttpClientCode(), 
					new java.util.HashMap(), 
					xmlbody.getBytes( "UTF-8" ), 
					xmlhead);
			if( fromUpffmx.getStatusCode() != HttpStatus.SC_OK ){
				fault( fromUpffmx );
			}
			else if( fromUpffmx instanceof HttpResponseByte ){
				fromASK = new String( ((HttpResponseByte)fromUpffmx).getResponseBody(), "UTF-8" );
			}
			else{
				fromASK = ((HttpResponseString)fromUpffmx).getResponseBody();
			}
		}
		finally{
			
		}
		return fromASK;
	}
	/**
	 * 
	 * @param fromASK
	 * @throws SFException
	 * @throws Exception
	 */
	public void fault( HttpResponse fromFault ) throws SFException,Exception{
		try
		{
			String aFaultCode = String.valueOf( fromFault.getStatusCode() );
			String aFaultString = HttpStatus.getStatusText( fromFault.getStatusCode() );
			ExceptionFactory.throwFault("IOS0012015", new String[] { PLATFORM_.getID(),
					aFaultCode, aFaultString },
					PLATFORM_.getID(), fromFault);
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
	public static class IUpfwmHttpDefine extends IUpfwmDefine.IUpfwmCauDefine{
		private static final long serialVersionUID = 3521913150216341953L;
		public IUpfwmHttpDefine(org.dom4j.Element aElement ) throws Exception{
			super( aElement );
		}
	}
}
