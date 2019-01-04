package com.ai.sacenter.provision.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��Ԫ���ڹ���</p>
 * <p>Copyright: Copyright (c) 2017��3��6��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpffmxDAO extends IUpdbmDAOLife{
	/**
	 * �����û���Ų�ѯ��Ԫ����֪ͨ��
	 * @param aUSER_ID �û����
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmNotify[] getSFUpffmxHome( long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * �����û����������ѯ��Ԫ����֪ͨ��
	 * @param aUSER_ID �û����
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmNotify[] getSFUpffmxHome( long aUSER_ID[], String aREGION_ID ) throws RemoteException,Exception;
}
