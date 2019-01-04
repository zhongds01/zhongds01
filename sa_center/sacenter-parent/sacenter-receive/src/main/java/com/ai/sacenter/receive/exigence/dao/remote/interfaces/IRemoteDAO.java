package com.ai.sacenter.receive.exigence.dao.remote.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�첽��DAO</p>
 * <p>Copyright: Copyright (c) 2017��5��31��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IRemoteDAO extends IRocketDAO {
	/**
	 * 
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID( String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getOFFER_ID( String aREGION_ID ) throws RemoteException,Exception;
}
