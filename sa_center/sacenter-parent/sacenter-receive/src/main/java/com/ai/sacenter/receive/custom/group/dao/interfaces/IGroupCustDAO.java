package com.ai.sacenter.receive.custom.group.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.custom.group.bo.CmGroupCust;

/**
 * ���ſͻ���Ϣ��ѯ
 * @author admin
 *
 */
public interface IGroupCustDAO extends IUpdbmDAOLife{
	/**
	 * ���ݿͻ���Ų�ѯ���ſͻ���Ϣ
	 * @param aCUSTOM_ID
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CmGroupCust getGroupCust(long aCUSTOM_ID, String aREGION_ID)throws RemoteException,Exception;
}