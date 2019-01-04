package com.ai.sacenter.servicefulfil.cboss.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISFCBossDAO extends IUpdbmDAOLife{
	/**
	 * 
	 * @param fromUpfwm
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpfgsmINDEX( java.util.HashMap fromUpfwm[] ) throws RemoteException,Exception;
}
