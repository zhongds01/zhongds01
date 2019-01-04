package com.ai.sacenter.receive.teaminvoke.in.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.valuebean.IOVRocketOffer;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdbcSV;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

public class UpdbcSVImpl extends UpdcEclipseImpl implements IUpdbcSV {
	public UpdbcSVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdbcSV#orderCompleteAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void orderCompleteAsyn(MBeanDelegate fromMBean,
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			IOVRocketExigence fromHistory = IOrderFactory.getIOrderSV().getSFMsgFHistory(fromMBean, 
					fromRequest, 
					fromUpdcpm, 
					aEXCEPTION,
					aContext);
			for( java.util.Iterator<IOVRocketOffer> itera = fromHistory.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
				fromOffer.setCOMPLETE_DATE( fromHistory.getCOMPLETE_DATE() );
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, fromOffer.getINSTANCE() );
			}
			UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, fromHistory.getINSTANCE() );
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			log.error( exception, exception);
			fromRequest.getORDER().setCOMPLETE( null );
			UpfsvcManager.getMBean().rollbackTransaction();
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdbcSV#rocketCompleteAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void rocketCompleteAsyn(MBeanDelegate fromMBean, 
			IOVMsgFExigence fromExigence, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws RemoteException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromExigence );
			orderCompleteAsyn(fromMBean, 
					fromExigence.getORDER().getROCKET(), 
					fromUpdcpm, 
					aEXCEPTION, 
					aContext);
		}
		catch( java.lang.Exception exception ){
			log.error( exception, exception);
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
	}
}
