package com.ai.sacenter.suggest.service.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.suggest.IUpfgxmFactory;
import com.ai.sacenter.suggest.service.interfaces.IUpfgxmSV;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê11ÔÂ9ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 ss
 */
public class UpfgxmSVImpl extends UpdcEclipseImpl implements IUpfgxmSV{
	public UpfgxmSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpfgxmSV#finishSFUpfgxmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.common.IOVUpdbpmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfgxmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfgxmFactory.getIUpfgxmSV().finishSFUpfgxmComplete(fromMBean, 
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
