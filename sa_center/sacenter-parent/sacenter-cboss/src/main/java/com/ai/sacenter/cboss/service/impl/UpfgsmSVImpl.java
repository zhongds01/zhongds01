package com.ai.sacenter.cboss.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.cboss.IUpfgsmFactory;
import com.ai.sacenter.cboss.service.interfaces.IUpfgsmSV;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
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
public class UpfgsmSVImpl extends UpdcEclipseImpl implements IUpfgsmSV{

	public UpfgsmSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSV#finishSFUpfgsmSync(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfgsmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmSync(fromMBean, 
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
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSV#finishSFUpfgsmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpfgsmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmComplete(fromMBean, 
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
