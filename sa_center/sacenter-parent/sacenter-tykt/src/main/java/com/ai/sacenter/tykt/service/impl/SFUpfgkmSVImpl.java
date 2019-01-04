package com.ai.sacenter.tykt.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.tykt.IUpfgkmFactory;
import com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSV;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFUpfgkmSVImpl extends UpdcEclipseImpl implements ISFUpfgkmSV{

	public SFUpfgkmSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSV#finishSFUpfgkmSync(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfgkmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfgkmFactory.getIUpfgkmSV().finishSFUpfgkmSync(fromMBean, 
					fromUpfgkmHome, 
					aContext);
		}
		catch( java.lang.Exception aEXCEPTION){
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSV#finishSFUpfgkmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfgkmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwmComplete(fromMBean, 
					fromUpfgkmHome, 
					aContext);
		}
		catch( java.lang.Exception aEXCEPTION){
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSV#finishSFUpfgkmUrgency(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfgkmUrgency(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfgkmFactory.getIUpfgkmSV().finishSFUpfgkmUrgency(fromMBean, 
					fromUpfgkmHome, 
					aContext);
		}
		catch( java.lang.Exception aEXCEPTION){
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}
}
