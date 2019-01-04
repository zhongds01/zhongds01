package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.dbcp.IUpfwmProtocol;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于人机语言协议封装</p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmProtocolImpl extends UpdcEclipseImpl implements IUpfwmProtocol {

	public IUpfwmProtocolImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmProtocol#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
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
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmProtocol#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IUpfwmClient fromNetWork,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmProtocol#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			Object fromRsBody, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromUpdcpm = null;
		try
		{
			fromUpdcpm = new IOVUpfwmResponse( fromUpfwm );
			Object fromRsRaw = fromRsBody != null && fromRsBody instanceof byte[]? 
					new String( (byte[])fromRsBody ):fromRsBody;
			if( ClassUtils.IClass.isString( fromRsRaw ) ){
				String fromPLMMX = (String)fromRsRaw;
				fromUpdcpm.setFAILURE  ( Boolean.FALSE );
				fromUpdcpm.setRspResult( fromPLMMX     );
				fromUpdcpm.setRspBottom( fromPLMMX     );
			}
			else{
				fromUpdcpm.setFAILURE  ( Boolean.FALSE                             );
				fromUpdcpm.setRspDesc  ( fromRsRaw != null?fromRsRaw.toString():"" );
				fromUpdcpm.setRspBottom( fromRsRaw != null?fromRsRaw.toString():"" );
				if( ClassUtils.IClass.isException( fromRsRaw ) ){
					SFException aEXCEPTION = ExceptionFactory.getException( (java.lang.Exception)fromRsRaw );
					fromUpdcpm.setFAILURE( Boolean.TRUE );
					fromUpdcpm.setRspCode( aEXCEPTION.getFaultCode() );
					fromUpdcpm.setRspDesc( aEXCEPTION.getMessage  () );
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

}
