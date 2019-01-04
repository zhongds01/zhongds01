package com.asiainfo.sacenter.shcmcc.provision.sandpay.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.dbcp.impl.IHttpProtocolImpl;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmHttpClient;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.asiainfo.sacenter.shcmcc.provision.sandpay.util.ISandUtils;
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
public class ISandPayProtocolImpl extends IHttpProtocolImpl {

	public ISandPayProtocolImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IPlatformTemplate.IUpffmDirective fromUpdfm = fromUpdfwm.getDIRECTIVE();
			String fromPLMMX = UpdcUtils.ISubFlow.getDIRECTIVE( fromUpdfm, aContext );
			fromPLMMX = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain(fromUpdfm.getID(), 
					fromPLMMX, 
					fromUpdcpm.getSUBFLOW().getSUBFLOW(), 
					fromUpdcpm.getSUBFLOW().getPLATFORM(), 
					aContext );
			fromUpdcpm.getPLATFORM().setORIGINAL( fromPLMMX );
			fromUpdcpm.getPLATFORM().setBOTTOM  ( fromPLMMX );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IHttpProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.mstp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.IUpdcContext)
	 */
	public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpfwmClient fromNetWork,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		String  fromRsBody = null;
		ISandPayRequest fromRequest = null;
		try
		{
			UpfwmHttpClient fromClient = (UpfwmHttpClient)fromNetWork;
			if( log.isDebugEnabled() ) log.debug("request:"+ fromUpdcpm.getPLATFORM().getORIGINAL() );
			fromRequest = ISandUtils.ICustom._wrapWithReq( (String)fromUpdcpm.getPLATFORM().getORIGINAL() );
			if( fromRequest == null || fromRequest.getORDER() == null ){
				ExceptionFactory.throwIllegal("IOS0012016", new String[] { fromClient.getNETWORK_().getID_(), "xmlhead/xmlbody" });
			}
			if( log.isDebugEnabled() ) log.debug( "request:" + fromRequest.getORDER().getXmlbody() );
			fromRsBody = fromClient.call( fromRequest.getORDER().getXmlhead(), fromRequest.getORDER().getXmlbody() );
			if( log.isDebugEnabled() ) log.debug("response:" + fromRsBody );
			if( StringUtils.isBlank( fromRsBody ) ){
				ExceptionFactory.throwRemote("IOS0012011", new String[]{ fromClient.getNETWORK_().getID_() } );
			}
			if( StringUtils.contains( fromRsBody, "time out" ) ){
				ExceptionFactory.throwTimeOut("IOS0012004", new String[]{ fromClient.getNETWORK_().getID_() } );
			}
			fromRsBody = JSONUtils.fromXML("InterBOSS", fromRsBody );
		}
		finally{
			if( fromRequest != null ){ fromRequest = null; }
		}
		return fromRsBody;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			Object fromRsBody,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromUpdcpm = null;
		ISandPayResponse fromRsRsp = null;
		try
		{
			fromUpdcpm = new IOVUpfwmResponse( fromUpfwm );
			fromRsRsp = ISandUtils.ICustom._wrapWithRsp( (String)fromRsBody );
			if( fromRsRsp == null || fromRsRsp.getResult() == null ){
				fromUpdcpm.setFAILURE( Boolean.TRUE );
			}
			else{
				fromUpdcpm.setFAILURE( StringUtils.equals( fromRsRsp.getResult().getRspCode(), "0000")?
						Boolean.FALSE:Boolean.TRUE );
				fromUpdcpm.setRspCode  ( fromRsRsp.getResult().getRspCode  () );
				fromUpdcpm.setRspDesc  ( fromRsRsp.getResult().getRspDesc  () );
				fromUpdcpm.setRspBody  ( fromRsRsp.getResult().getRspBody  () );
				fromUpdcpm.setRspBottom( fromRsRsp.getResult().getRspResult() );
			}
			
		}
		finally{
			if( fromRsRsp != null ){ fromRsRsp = null; }
		}
		return fromUpdcpm;
	}

}
