package com.ai.sacenter.receive.order.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyUser;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê10ÔÂ31ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */

public interface IUrgencyDAO extends IUpdbmDAOLife{
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException, Exception; 
	/**
	 * 
	 * @param fromCsosHome
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.List<IOVUrgencyUser> getSFUrgencyUser(IUpfgkmCityHome fromCsosHome )throws RemoteException,Exception;
}
