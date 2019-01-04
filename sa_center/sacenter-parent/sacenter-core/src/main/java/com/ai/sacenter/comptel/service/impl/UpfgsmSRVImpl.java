package com.ai.sacenter.comptel.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.service.interfaces.IUpfgsmSRV;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-5-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfgsmSRVImpl extends UpdcEclipseImpl implements IUpfgsmSRV {
	public UpfgsmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfgsmSRV#getSFUpfgsmMisc(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public IUpfgsmTemplate.IUpfgsmOffer getSFUpfgsmMisc(IOVUpfwmOffer fromUpfwm, IUpdcContext aContext) throws SFException, Exception {
		IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm = null;
		try
		{
			fromUpfgsm = IUpdcfgFactory.getIUpffmSV().getSFUpfgsmMisc( fromUpfwm.getCATEGORY() );
		}
		finally{
			
		}
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfgsmSRV#finishSFUpfgsmMisc(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgsmTemplate.IUpfgsmOffer, com.ai.sacenter.valuebean.IUpfgsmTemplate.IUpfgsmxOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfgsmMisc(IOVUpfwmOffer fromUpfwm, 
			IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm, 
			IUpfgsmTemplate.IUpfgsmxOffer fromUpfgsmx, 
			IUpdcContext aContext) throws SFException, Exception {
		Object fromUpffx = null;
		try
		{
			IOVUpfwmOffer.IUpfwmOfferHome fromUpffmx = fromUpfwm.getORDER();
			String aCOMPLEX = fromUpfgsmx.getCOMPETE();
			if( StringUtils.isBlank( fromUpfgsmx.getCOMPLEX() ) == false ){
				aCOMPLEX = fromUpfgsmx.getCOMPLEX();
			}
			fromUpffx = (String)IUpdcpFactory.getIUpfwmSV().finishSFUpfvnChain( aCOMPLEX, 
					fromUpffmx.getOFFER(), 
					aContext);
		}
		finally{
			
		}
		return fromUpffx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfgsmSRV#finishSFUpfgsmMisc(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.HashMap finishSFUpfgsmMisc(IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.HashMap fromUpffsm = null;
		try
		{
			IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm = null;
			fromUpfgsm = getSFUpfgsmMisc(fromUpfwm, aContext);
			if( fromUpfgsm != null ){
				fromUpffsm = new java.util.HashMap();
				IUpfgsmTemplate.IUpfgsmxOffer fromUpfgsmx = null;
				for( java.util.Iterator itera = fromUpfgsm.getCOMPETENCE().iterator(); itera.hasNext(); ){
					fromUpfgsmx = (IUpfgsmTemplate.IUpfgsmxOffer)itera.next();
					Object fromUpffx = finishSFUpfgsmMisc(fromUpfwm, 
							fromUpfgsm, 
							fromUpfgsmx, 
							aContext);
					if( fromUpffx != null ){ fromUpffsm.put( fromUpfgsmx.getMAPPING() , fromUpffx );}
				}
			}
		}
		finally{
			
		}
		return fromUpffsm;
	}

}
