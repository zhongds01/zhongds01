package com.ai.sacenter.receive.expire.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

public interface IExpireDAO extends IUpdbmDAOLife{
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException, Exception;
	
	/**
	 * 查询用户下周期数据
	 * @param aUSER_ID
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVExpireUser[] getExpireUser(long aUSER_ID, String aREGION_ID)throws RemoteException,Exception;
	/**
	 * 
	 * @param fromExpireHome
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmCityHome getExpireUser(IUpfgkmCityHome fromExpireHome)throws RemoteException,Exception;
	/**
	 * 
	 * @param aUser_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVExpireUser[] getExpireUser(long aUser_ID)throws RemoteException,Exception;
}
