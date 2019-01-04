package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.dbcp.IUpffmxCapital;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元到期插件资产</p>
 * <p>Copyright: Copyright (c) 2017年2月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpffmxCapitalImpl extends UpdcEclipseImpl implements IUpffmxCapital {
	public IUpffmxCapitalImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpffmxCapital#finishSFUpfgkmSuspend(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmSuspend(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpffmxCapital#finishSFUpfgkmResume(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmResume(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpffmxCapital#finishSFUpfgkmChange(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmChange(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpffmxCapital#finishSFUpfgkmHistory(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmHistory(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpffmxCapital#finishSFUpfgkmHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.IUpffmxCapital#finishSFUpfgkmExpire(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		
	}

}
