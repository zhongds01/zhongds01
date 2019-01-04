package com.ai.sacenter.receive.order.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��4��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrderDAO extends IUpdbmDAOLife {
	/**
	 * 
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID( )throws RemoteException,Exception;
	/**
	 * 
	 * @param aORDER_ID
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVRocketExigence getSFRocketByOrderId( long aORDER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * ����UserId��ѯ�־û���ͨ������Ϣ
	 * @param aUSER_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVRocketExigence[] getSFRocketByUserId(long aUSER_ID) throws RemoteException,Exception;
	/**
	 * ���ݿ�ͨ������ѯ��ͨ��������ͬ���û�����
	 * @param fromDispatch
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.List<IOVRocketExigence> getSFRocketDispatch(java.util.List<IOVRocketExigence> fromDispatch)throws RemoteException,Exception;
}
