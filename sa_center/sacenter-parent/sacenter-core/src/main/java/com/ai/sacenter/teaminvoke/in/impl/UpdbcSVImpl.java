package com.ai.sacenter.teaminvoke.in.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdbcSVImpl extends UpdcEclipseImpl implements IUpdbcSV {
    public UpdbcSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV#finishSFUpfwmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwmComplete(fromMBean, 
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
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV#finishSFUpfwmNetWork(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfwmNetWork(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwmNetWork(fromMBean, 
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

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV#finishSFUpdcmqComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpdcmqComplete(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpdfmxHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpdcFactory.getIUpdcmqSV().finishSFUpdcmqComplete(fromMBean, 
					fromUpdfmxHome, 
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

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV#finishSFUpfwmExpire(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfwmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfwmFactory.getIUpffmxSV().finishSFUpfgkmExpire(fromMBean, 
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
