package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.dbcp.IUpfwmCapital;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.IUpfwmMonitor;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务网元工单指令资产</p>
 * <p>Copyright: Copyright (c) 2015年10月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmCapitalImpl extends UpdcEclipseImpl implements IUpfwmCapital,IUpfwmMonitor {
	public IUpfwmCapitalImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmMonitor#finishSFUpfwmLogin(com.ai.sacenter.provision.dbcp.IUpfwmClient)
	 */
	public void finishSFUpfwmLogin(IUpfwmClient fromClient) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmMonitor#finishSFUpfwmHbhbt(com.ai.sacenter.provision.dbcp.IUpfwmClient)
	 */
	public void finishSFUpfwmHbhbt(IUpfwmClient fromClient) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmMonitor#finishSFUpfwmLogout(com.ai.sacenter.provision.dbcp.IUpfwmClient)
	 */
	public void finishSFUpfwmLogout(IUpfwmClient fromClient) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmCapital#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwmActive(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpfwmCapital#finishSFUpdfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, IUpdcContext aContext)
			throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			fromASK = IUpfwmFactory.getIUpdfwmSV().finishSFUpdfwm(fromUpfwm, 
					fromUpdfwm, 
					aContext);
		}
		finally{
			
		}
		return fromASK;
	}

}
