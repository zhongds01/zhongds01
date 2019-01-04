package com.ai.sacenter.servicefulfil.service.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.servicefulfil.SFUpdcFactory;
import com.ai.sacenter.servicefulfil.service.interfaces.ISFUpdcFSV;
import com.ai.sacenter.tykt.bo.ISAEquipment;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê1ÔÂ12ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpdcFSVImpl extends UpdcEclipseImpl implements ISFUpdcFSV {
	public SFUpdcFSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.service.interfaces.ISFUpdcFSV#transferRequire()
	 */
	public void transferRequire() throws RemoteException, Exception {
		try
		{
			ISAEquipment fromUpfwm = new ISAEquipment();
			fromUpfwm.setPsId( UpfwmFactory.getIUpfwmDAO().getPS_ID() );
			fromUpfwm.setRegionCode( SFCenterFactory.getCenterInfo().getREGION_ID() );
			fromUpfwm.setComposite ( IUpdcConst.IUpdbm.IUpdbf.NORMAL );
			fromUpfwm.setStsToOld();
			fromUpfwm.delete();
			UpfsvcManager.getSession().submitISQLLifite( fromUpfwm );
			
			fromUpfwm = new ISAEquipment();
			fromUpfwm.setPsId      ( 600122500003121l                          );
			fromUpfwm.setRegionCode( SFCenterFactory.getCenterInfo().getREGION_ID() );
			fromUpfwm.setComposite ( IUpdcConst.IUpdbm.IUpdbf.NORMAL           );
			fromUpfwm.setStsToOld();
			fromUpfwm.setBusiCode( 192110029512l );
			
			UpfsvcManager.getSession().submitISQLLifite( fromUpfwm );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.service.interfaces.ISFUpdcFSV#transferNewRequire()
	 */
	public void transferNewRequire() throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getMBean().rollbackTransaction();
		    throw exception;
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.service.interfaces.ISFUpdcFSV#transferException()
	 */
	public void transferException() throws RemoteException, Exception {
		try
		{
			ISAEquipment fromUpfwm = new ISAEquipment();
			fromUpfwm.setPsId( UpfwmFactory.getIUpfwmDAO().getPS_ID() );
			fromUpfwm.setRegionCode( SFCenterFactory.getCenterInfo().getREGION_ID() );
			fromUpfwm.setComposite ( IUpdcConst.IUpdbm.IUpdbf.NORMAL );
			UpfsvcManager.getSession().submitISQLLifite( fromUpfwm );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.service.interfaces.ISFUpdcFSV#transferHistory(com.ai.sacenter.IUpdcContext)
	 */
	public void transferHistory(IUpdcContext context) throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			SFUpdcFactory.getIUpdcFSV().transferRequire();
			SFUpdcFactory.getIUpdcFSV().transferException();
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getMBean().rollbackTransaction();
			SFUpdcFactory.getIUpdcFSV().transferNewRequire();
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}

}
