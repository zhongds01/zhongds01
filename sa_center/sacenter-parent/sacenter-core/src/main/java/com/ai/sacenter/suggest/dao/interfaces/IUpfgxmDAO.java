package com.ai.sacenter.suggest.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015��11��8��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgxmDAO extends IUpdbmDAOLife {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws ception
	 */
	public long getPLMQ_ID() throws RemoteException,Exception;
}
