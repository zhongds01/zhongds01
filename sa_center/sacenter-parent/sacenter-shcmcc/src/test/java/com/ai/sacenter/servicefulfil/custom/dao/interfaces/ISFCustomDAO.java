package com.ai.sacenter.servicefulfil.custom.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.custom.bo.InsOffer;
import com.ai.sacenter.receive.custom.bo.InsUser;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��3��29��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISFCustomDAO extends IUpdbmDAOLife{
	/**
	 * �����û�id��ѯ�û���Ϣ
	 * @param aUSER_ID �û���� 
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsUser getIInsUserByUserId( long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * �����û���Ų�ѯ�û��߻���Ϣ
	 * @param aUSER_ID �û���� 
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOffer[] getIInsOfferByUserId(long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
}
