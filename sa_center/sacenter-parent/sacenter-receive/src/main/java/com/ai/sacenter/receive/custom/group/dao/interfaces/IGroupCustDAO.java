package com.ai.sacenter.receive.custom.group.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.custom.group.bo.CmGroupCust;

/**
 * 集团客户信息查询
 * @author admin
 *
 */
public interface IGroupCustDAO extends IUpdbmDAOLife{
	/**
	 * 根据客户编号查询集团客户信息
	 * @param aCUSTOM_ID
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CmGroupCust getGroupCust(long aCUSTOM_ID, String aREGION_ID)throws RemoteException,Exception;
}
