package com.ai.sacenter.receive.expire.service.impl;

import java.rmi.RemoteException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.expire.IExpireFactory;
import com.ai.sacenter.receive.expire.service.interfaces.IExpireSV;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ24ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExpireSVImpl implements IExpireSV {
	protected final static Log log = LogFactory.getLog( ExpireSVImpl.class );
	public ExpireSVImpl(){
		super();
	}
	
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSV#finishSFUpffxComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void finishSFUpffxComplete(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromExpireHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IExpireFactory.getIExpireSV().finishSFUpffxComplete(fromMBean, 
					fromExpireHome, 
					aContext);
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
			UpfsvcManager.finishMBean();
		}
	}

}
