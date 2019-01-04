package com.ai.sacenter.receive.teaminvoke.out.impl;

import java.rmi.RemoteException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFESFaultException;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.util.UpfwmUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcFSVImpl implements IUpdcFSV {
	protected final static Log log = LogFactory.getLog( UpdcFSVImpl.class );
    public UpdcFSVImpl() {
		super();
	}
   
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rocketReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage, com.ai.sacenter.SFException)
	 */
	public void rocketReceiveAsyn(RocketFMessage fromRocket, SFException aEXCEPTION) throws SFException, Exception {
		try
		{
			IOVRocketExigence _rocket = OrderUtils.IRocket._jj_rocket(fromRocket, aEXCEPTION);
			SFCenterFactory.pushCenterInfo( _rocket.getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOrderFactory.getIOrderSV().orderReceiveAsyn( new IOVRocketExigence[]{_rocket}, aEXCEPTION );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rocketCompleteAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage, com.ai.sacenter.SFException)
	 */
	public void rocketCompleteAsyn(RocketFMessage fromRocket, SFException aEXCEPTION) throws SFException, Exception {
		try
		{
			IOVRocketExigence _rocket = OrderUtils.IRocket._jj_rocket(fromRocket, aEXCEPTION);
			SFCenterFactory.pushCenterInfo( _rocket.getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOrderFactory.getIOrderSV().orderCompleteAsyn( new IOVRocketExigence[]{_rocket}, aEXCEPTION );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#orderTransparent(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.provision.valuebean.IOVUpffmxOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFResponse orderTransparent(IOVUpfwmOffer fromUpfwm, 
			IOVUpffmxOffer fromOffer, 
			IUpdcContext aContext) throws RemoteException, Exception {
		IOVMsgFResponse fromASK = null;
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			IOVUpfwmResponse fromNetWork = null;
			UpfwmUtils.ICustom._wrap( fromUpfwm, fromOffer, aContext );
			fromNetWork = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmSync(fromUpfwm, aContext);
			fromASK = OrderUtils.IRocket._jj_response(fromUpfwm, fromNetWork);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw exception;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#orderReceive(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public RocketFRsRspMessage orderReceive(RocketFMessage fromMetaMX) throws RemoteException, Exception {
		RocketFRsRspMessage fromRsBody = null;
		try
		{
			IOVRocketExigence _rocket = OrderUtils.IRocket._jj_rocket( fromMetaMX );
			SFCenterFactory.pushCenterInfo( _rocket.getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOVMsgFResponse _response = IOrderFactory.getIOrderSV().orderReceive( _rocket );
				String _rspBody = OrderUtils.IRocket._jj_response( _response );
				fromRsBody = new RocketFRsRspMessage( _rocket, _rspBody );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getServiceFault( exception );
				throw aEXCEPTION;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( SFESFaultException exception ){
			java.lang.Exception _exception = ExceptionFactory.getPrimitive( exception );
			throw _exception;
		}
		catch( java.lang.Exception exception ){
			try{
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				rocketCompleteAsyn(fromMetaMX, aEXCEPTION);
			}
			catch( java.lang.Exception _exception ){
				log.error( _exception.getMessage(), _exception );
			}
			throw exception;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		return fromRsBody;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#orderReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public void orderReceiveAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		try
		{
			IOVRocketExigence _rocket = OrderUtils.IRocket._jj_rocket( fromRocket );
			SFCenterFactory.pushCenterInfo( _rocket.getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOrderFactory.getIOrderSV().orderReceiveAsyn( new IOVRocketExigence[]{ _rocket } );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			SFException aEXCEPTION = ExceptionFactory.getException( exception );
			rocketReceiveAsyn(fromRocket, aEXCEPTION);
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rocketTransparent(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.provision.valuebean.IOVUpffmxOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMocketRespone rocketTransparent(IOVUpfwmOffer fromUpfwm, IOVUpffmxOffer fromOffer, IUpdcContext aContext) throws RemoteException, Exception {
		IOVMocketRespone fromRsRsp = null;
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			IOVUpfwmResponse fromNetWork = null;
			UpfwmUtils.ICustom._wrap( fromUpfwm, fromOffer, aContext );
			fromNetWork = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmSync(fromUpfwm, aContext);
			fromRsRsp = ExigenceUtils.IRocket._jj_response(fromUpfwm, fromNetWork);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw exception;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		return fromRsRsp;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rocketReceive(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public RocketFRsRspMessage rocketReceive(RocketFMessage fromRocket) throws RemoteException, Exception {
		RocketFRsRspMessage fromRsBody = null;
		try
		{
			IOVMsgFExigence _rocket = ExigenceUtils.IRocket._jj_rocket( fromRocket );
			SFCenterFactory.pushCenterInfo( _rocket.getORDER().getROCKET().getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOVMocketRespone _response = IExigenceFactory.getIUpdcSV().rocketReceive( _rocket );
				String _rspBody = ExigenceUtils.IRocket._jj_response( _response );
				fromRsBody = new RocketFRsRspMessage( _rocket, _rspBody );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getServiceFault( exception );
				throw aEXCEPTION;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( SFESFaultException exception ){
			java.lang.Exception _exception = ExceptionFactory.getPrimitive( exception );
			throw _exception;
		}
		catch( java.lang.Exception exception ){
			try{
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				rocketCompleteAsyn(fromRocket, aEXCEPTION);
			}
			catch( java.lang.Exception _exception ){
				log.error( _exception.getMessage(), _exception );
			}
			throw exception;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		return fromRsBody;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rocketReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public void rocketReceiveAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		try
		{
			IOVMsgFExigence _rocket = ExigenceUtils.IRocket._jj_rocket( fromRocket );
			SFCenterFactory.pushCenterInfo( _rocket.getORDER().getROCKET().getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IExigenceFactory.getIUpdcSV().rocketReceiveAsyn( new IOVMsgFExigence[]{ _rocket });
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			SFException aEXCEPTION = ExceptionFactory.getException( exception );
			rocketReceiveAsyn(fromRocket, aEXCEPTION);
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rocketCompleteAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public RocketFRsRspMessage rocketCompleteAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		RocketFRsRspMessage fromRsBody = null;
		try
		{
			IOVMocketRespone _rocket = ExigenceUtils.IRocket._jj_complete( fromRocket );
			SFCenterFactory.pushCenterInfo( _rocket.getORDER().getROCKET().getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOVMocketRespone _response = IExigenceFactory.getIUpdcSV().rocketComplete( _rocket );
				String _rspBody = ExigenceUtils.IRocket._jj_response( _response );
				fromRsBody = new RocketFRsRspMessage( _rocket, _rspBody );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getServiceFault( exception );
				throw aEXCEPTION;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( SFESFaultException exception ){
			java.lang.Exception _exception = ExceptionFactory.getPrimitive( exception );
			throw _exception;
		}
		catch( java.lang.Exception exception ){
			try{
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				rocketCompleteAsyn(fromRocket, aEXCEPTION);
			}
			catch( java.lang.Exception _exception ){
				log.error( _exception.getMessage(), _exception );
			}
			throw exception;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		return fromRsBody;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#rabbitReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public void rabbitReceiveAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		try
		{
			IOVMocketExigence _rocket = ExigenceUtils.IRocket._jj_mocket( fromRocket );
			SFCenterFactory.pushCenterInfo( _rocket.getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IExigenceFactory.getIUpdcSV().rabbitReceiveAsyn( new IOVMocketExigence[]{ _rocket } );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getServiceFault( exception );
				throw aEXCEPTION;
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( SFESFaultException exception ){
			java.lang.Exception _exception = ExceptionFactory.getPrimitive( exception );
			throw _exception;
		}
		catch( java.lang.Exception exception ){
			try{
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				rocketCompleteAsyn(fromRocket, aEXCEPTION);
			}
			catch( java.lang.Exception _exception ){
				log.error( _exception.getMessage(), _exception );
			}
			throw exception;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#orderTurnRedo(java.lang.String, long, java.lang.String, java.lang.String)
	 */
	public void orderTurnRedo(String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			UpdcFactory.getIUpdcSV().finishSFTaskRedo( new long[]{aTASK_ID}, 
					aVM_ORG_ID, 
					aVM_STAFF_ID, 
					fromASK);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
			if( fromASK != null ){ fromASK.clear(); fromASK = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#orderComplete(java.lang.String, long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void orderComplete(String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_REASON, 
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			UpdcFactory.getIUpdcSV().finishSFTaskComplete( new long[]{aTASK_ID}, 
					aVM_REASON,
					aVM_ORG_ID, 
					aVM_STAFF_ID, 
					fromASK);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
			if( fromASK != null ){ fromASK.clear(); fromASK = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#orderException(java.lang.String, long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void orderException(String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_REASON, 
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			UpdcFactory.getIUpdcSV().finishSFTaskException( new long[]{aTASK_ID}, 
					aVM_REASON,
					aVM_ORG_ID, 
					aVM_STAFF_ID, 
					fromASK);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
			if( fromASK != null ){ fromASK.clear(); fromASK = null; }
		}
	}


	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#suspendSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void suspendSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			UpdcFactory.getIUpdcSV().suspendSFOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aVM_REASON, 
					aADDIN_XML);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#resumeSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void resumeSFOrder(String aVM_ORDER_ID, String aBILL_ID, String aVM_REASON, String aADDIN_XML) throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			UpdcFactory.getIUpdcSV().resumeSFOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aVM_REASON, 
					aADDIN_XML);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#cancelSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void cancelSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			UpdcFactory.getIUpdcSV().cancelSFOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aVM_REASON, 
					aADDIN_XML);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV#getASKOrder(long, java.lang.String, java.lang.String)
	 */
	public java.util.HashMap getASKOrder(long aVM_ORDER_ID, 
			String aBILL_ID, 
			String aADDIN_XML) throws RemoteException, Exception {
		java.util.HashMap fromASK = null;
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			fromASK = UpdcFactory.getIUpdcSV().getASKOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aADDIN_XML);
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getMBean().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			UpfsvcManager.finishMBean();
		}
		return fromASK;
	}
}