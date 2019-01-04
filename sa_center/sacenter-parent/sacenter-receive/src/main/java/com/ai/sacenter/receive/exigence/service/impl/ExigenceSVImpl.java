package com.ai.sacenter.receive.exigence.service.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSV;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

public class ExigenceSVImpl extends UpdcEclipseImpl implements IExigenceSV {

	public ExigenceSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSV#rocketReceiveAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void rocketReceiveAsyn(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IExigenceFactory.getIUpdcSV().rocketReceiveAsyn(fromMBean, 
					fromUpfgkmHome, 
					aContext);
		}
		catch( java.lang.Exception aEXCEPTION ){
			throw aEXCEPTION;
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
			UpfsvcManager.finishMBean();
		}
	}

}
