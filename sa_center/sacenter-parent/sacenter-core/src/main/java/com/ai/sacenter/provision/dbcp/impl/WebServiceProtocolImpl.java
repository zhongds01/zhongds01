package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmWebService;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于WebService协议封装</p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class WebServiceProtocolImpl extends IUpfwmProtocolImpl {
	public WebServiceProtocolImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmRequest fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IPlatformTemplate.IUpffgsmOffer fromUpfgsm[] = null;
			fromUpfgsm = UpfgsmUtils.ICustom.getICSTKUpfgsmc();
			Object fromRQKUpfwm[] = new Object[ fromUpfgsm.length ];
			for( int index = 0 ; fromUpfgsm != null && index < fromUpfgsm.length ; index++ ){
				fromRQKUpfwm[index] = null;
				Object fromPARAM = fromUpdcpm.getSUBFLOW().getPLATFORM().get( 
						fromUpfgsm[index].getMAPPING() );
				if( fromPARAM == null ) continue;
				Class fromTYPE = ClassUtils.IClass.wrap( fromUpfgsm[index].getCATEGORY() );
				fromRQKUpfwm[index] = ClassUtils.IClass.transfer( fromPARAM , fromTYPE );
			}
			fromUpdcpm.getPLATFORM().setORIGINAL( fromRQKUpfwm );
			fromUpdcpm.getPLATFORM().setBOTTOM( XmlUtils.createNoformatXml( 
					"ucmframe", fromUpdcpm.getSUBFLOW().getPLATFORM() ) );
		}
		finally{
		
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IUpfwmClient fromNetWork,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		Object fromASK = null;
		try
		{
			UpfwmWebService fromClient = (UpfwmWebService)fromNetWork;
			IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			Object[] fromPARAM = (Object[])fromUpffmxHome.getORIGINAL();
			fromClient.call( fromUpfom.getCODE() , fromPARAM );
		}
		finally{
		
		}
		return fromASK;
	}

}
