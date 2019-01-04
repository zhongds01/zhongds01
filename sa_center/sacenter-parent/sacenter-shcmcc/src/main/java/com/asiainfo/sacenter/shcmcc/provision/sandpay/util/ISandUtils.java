package com.asiainfo.sacenter.shcmcc.provision.sandpay.util;

import com.ai.sacenter.SFException;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;
import com.asiainfo.sacenter.shcmcc.provision.sandpay.valuebean.ISandPayRequest;
import com.asiainfo.sacenter.shcmcc.provision.sandpay.valuebean.ISandPayResponse;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê5ÔÂ12ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISandUtils {

	public ISandUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 
		 * @param fromBizReq
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISandPayRequest _wrapWithReq( String fromBizReq ) throws SFException,Exception{
			ISandPayRequest fromRequest = null;
			java.util.HashMap fromUpffmx = new java.util.HashMap();
			try
			{
				fromRequest = new ISandPayRequest( fromBizReq );
				XmlUtils.XPath( fromBizReq, fromUpffmx );
				java.util.Map xmlhead = (java.util.Map)fromUpffmx.get( "xmlhead" );
				String xmlbody = (String)fromUpffmx.get( "xmlbody" );
				if( xmlhead != null && xmlbody != null ){
					fromRequest.setORDER( new ISandPayRequest.ISandPaySyncReq() );
					fromRequest.getORDER().setXmlhead( xmlhead                      );
					fromRequest.getORDER().setXmlbody( JSONUtils.fromXML( xmlbody ) );
				}
			}
			finally{
				if( fromUpffmx != null ){ fromUpffmx.clear(); fromUpffmx = null; }
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromBizRsp
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISandPayResponse _wrapWithRsp( String fromBizRsp ) throws SFException,Exception{
			ISandPayResponse fromResponse = null;
			java.util.Map fromUpffmx = new java.util.HashMap();
			try
			{
				fromResponse = new ISandPayResponse( fromBizRsp );
				XmlUtils.XPath( (String)fromBizRsp, fromUpffmx );
				String fromRspCode = (String)fromUpffmx.get("response_code");
				if( StringUtils.isBlank( fromRspCode ) == false ){
					fromResponse.setResult( new ISandPayResponse.ISandPaySyncRsRsp() );
					fromResponse.getResult().setRspCode  ( (String)fromUpffmx.get("response_code") );
					fromResponse.getResult().setRspDesc  ( (String)fromUpffmx.get("response_msg" ) );
					fromResponse.getResult().setRspResult( fromBizRsp                              );
					ClassUtils.IMerge.merge( fromUpffmx, fromResponse.getResult().getRspBody() );
				}
			}
			finally{
				if( fromUpffmx != null ){ fromUpffmx.clear(); fromUpffmx = null; }
			}
			return fromResponse;
		}
	}
}
