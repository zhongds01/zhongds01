package com.ai.sacenter.receive.teaminvoke.in.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdcSV;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

public class UpdcSVImpl extends UpdcEclipseImpl implements IUpdcSV {
	public UpdcSVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdcSV#orderReceiveAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void orderReceiveAsyn(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromRocket, 
			java.util.HashMap fromOther) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromOther );
		try
		{
			IOrderFactory.getIOrderSV().orderReceiveAsyn(fromMBean, 
					fromRocket, 
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
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdcSV#urgencyReceiveAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, java.util.HashMap)
	 */
	public void urgencyReceiveAsyn(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUrgency, 
			java.util.HashMap fromOther) throws RemoteException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromOther );
		try
		{
			IOrderFactory.getIUrgencySV().urgencyReceiveAsyn(fromMBean, 
					fromUrgency, 
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
