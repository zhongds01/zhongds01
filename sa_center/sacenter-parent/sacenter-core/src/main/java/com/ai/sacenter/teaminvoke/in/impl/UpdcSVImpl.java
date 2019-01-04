package com.ai.sacenter.teaminvoke.in.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcSVImpl extends UpdcEclipseImpl implements IUpdcSV {

	public UpdcSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#applySFOrder(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFOrder(IOVOrderRequest fromPentium,
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws RemoteException, Exception {
		IOVOrderResponse fromASK = null;
		try
		{
			fromASK = IUpdcFactory.getISystemSV().applySFOrder(fromPentium, 
					fromUpdcpm, 
					fromXML);
		}
		finally{
			
		}
		return fromASK;
	}
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#applySFBatch(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFBatch(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception{
		IOVOrderResponse fromASK =null;
		try
		{
			fromASK = IUpdcFactory.getISystemSV().applySFBatch(
					fromPentium, 
					fromUpdcpm, 
					fromXML);
			
		}finally{
			
		}
		return fromASK;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#applySFGroup(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFGroup(IOVOrderRequest fromPentium,
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws RemoteException, Exception {
		IOVOrderResponse fromASK = null;
		try
		{
			fromASK = IUpdcFactory.getISystemSV().applySFGroup(fromPentium, 
					fromUpdcpm, 
					fromXML);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#applySFCentrex(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFCentrex(IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws RemoteException, Exception {
		IOVOrderResponse fromASK = null;
		try
		{
			fromASK = IUpdcFactory.getISystemSV().applySFCentrex(fromRequest, 
					fromUpdcpm, 
					fromXML);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#applySFCentrex(com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFCentrex(IOVOrderResponse fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws RemoteException, Exception {
		IOVOrderResponse fromASK = null;
		try
		{
			fromASK = IUpdcFactory.getISystemSV().applySFCentrex(fromRequest, 
					fromUpdcpm, 
					fromXML);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#cancelSFExpire(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse cancelSFExpire(IOVOrderRequest fromPentium,
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws RemoteException, Exception {
		IOVOrderResponse fromASK = null;
		try
		{
			fromASK = IUpdcFactory.getISystemSV().cancelSFExpire(fromPentium, 
					fromUpdcpm, 
					fromXML);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#suspendSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void suspendSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws RemoteException, Exception {
		try
		{
			IUpdcFactory.getISystemSV().suspendSFOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aVM_REASON, 
					aADDIN_XML);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#resumeSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void resumeSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws RemoteException, Exception {
		try
		{
			IUpdcFactory.getISystemSV().resumeSFOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aVM_REASON, 
					aADDIN_XML);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#cancelSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void cancelSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws RemoteException, Exception {
		try
		{
			IUpdcFactory.getISystemSV().cancelSFOrder(aVM_ORDER_ID, 
					aBILL_ID, 
					aVM_REASON, 
					aADDIN_XML);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#getASKOrder(long, java.lang.String, java.lang.String)
	 */
	public java.util.HashMap getASKOrder(long aVM_ORDER_ID, 
			String aBILL_ID, 
			String aADDIN_XML) throws RemoteException, Exception {
		java.util.HashMap fromUpdcpm = null;
		try
		{
			fromUpdcpm = IUpdcFactory.getISystemSV().getASKOrder( aVM_ORDER_ID, 
					aBILL_ID, 
					aADDIN_XML );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#finishSFTaskRedo(long[], java.lang.String, java.lang.String, java.util.HashMap)
	 */
	public void finishSFTaskRedo(long[] aTASK_ID, 
			String aVM_ORG_ID, 
			String aVM_STAFF_ID, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		try
		{
			IUpdcFactory.getISystemSV().finishSFTaskRedo(aTASK_ID, 
					aVM_ORG_ID, 
					aVM_STAFF_ID, 
					fromASK);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#finishSFTaskComplete(long[], java.lang.String, java.lang.String, java.lang.String, java.util.HashMap)
	 */
	public void finishSFTaskComplete(long[] aTASK_ID, 
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID, 
			java.util.HashMap fromASK ) throws RemoteException, Exception {
		try
		{
			IUpdcFactory.getISystemSV().finishSFTaskComplete(aTASK_ID, 
					aVM_REASON,
					aVM_ORG_ID, 
					aVM_STAFF_ID, 
					fromASK);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV#finishSFTaskException(long[], java.lang.String, java.lang.String, java.lang.String, java.util.HashMap)
	 */
	public void finishSFTaskException(long[] aTASK_ID, 
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID, 
			java.util.HashMap fromASK) throws RemoteException, Exception {
		try
		{
			IUpdcFactory.getISystemSV().finishSFTaskException(aTASK_ID, 
					aVM_REASON, 
					aVM_ORG_ID, 
					aVM_STAFF_ID,
					fromASK);
		}
		finally{
	
		}
	}
}
