package com.ai.sacenter.provision.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdfmxDAO extends IUpdbmDAOLife{
	/**
	 * 获取当前消息编号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getPLMM_ID() throws RemoteException,Exception;
}
