package com.ai.sacenter.core.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.util.ArrayUQList;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcDAO extends IUpdbmDAOLife {
	/***
	 * ��ȡ����������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException,Exception;
	/**
	 * ��ȡ�¶��б��
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getPLQK_ID() throws RemoteException,Exception;
	/**
	 * ��ȡ��ǰ�������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getOFFER_ID() throws RemoteException,Exception;
	/**
	 * ��������ⶩ���Ų�ѯ���񶨵�(��;����ʧ�ܵ��Լ������ڵ�)
	 * @param aVM_ORDER_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFOrder( String aVM_ORDER_ID ) throws RemoteException,Exception;
	/**
	 * ���ݶ������Ų�ѯ���񶨵�
	 * @param aORDER_ID ��ͨ��������
	 * @param aUSER_ID �û����
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( String aORDER_ID, long  aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * ���ݶ�����ź����������ѯ������ͨ����
	 * @param fromTASK
	 * @param aORDER_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( IOVTaskPentium fromTASK , 
			long aORDER_ID ) throws RemoteException,Exception;
	/**
	 * �������������ѯ������ͨ����
	 * @param aUpdswfLife
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFOrder( IOVTaskPentium fromTASK[] ) throws RemoteException,Exception;
	/**
	 * ���ݷ���Ⱥ�鶨����ѯ�÷��񶨵���Ӧ�ӷ��񶨵�
	 * @param fromGroup ����Ⱥ�鶨��
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFMember( IOVOrderPentium fromGroup ) throws RemoteException,Exception;
	/**
	 * ���ݶ��������Ų�ѯ��������
	 * @param aTASK_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( long aTASK_ID ) throws RemoteException,Exception;
	/**
	 * ���������Ų�ѯ��ع���
	 * @param aTASK_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskFail( long aTASK_ID[] ) throws RemoteException,Exception;
	/**
	 * ���ݶ��в�ѯ�������񹤵�
	 * @param fromQueue �������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( IOVQueuePentium fromQueue ) throws RemoteException,Exception;
	/**
	 * �����������ȶ��в�ѯ�������̶�������
	 * @param fromQueue �������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVQueuePentium fromQueue[] ) throws RemoteException,Exception;
	/**
	 * ������Ԫ������ѯ���̶�������
	 * @param fromUpfwm ��Ԫ����
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( IOVUpfwmOrder fromUpfwm ) throws RemoteException,Exception;
	/**
	 * ������Ԫ������ѯ���̶�������
	 * @param fromUpfwm ��Ԫ����
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVUpfwmOrder fromUpfwm[] ) throws RemoteException,Exception;
	/**
	 * �������̶�����ѯ���̶�������
	 * @param fromOrder
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVOrderPentium fromOrder[] ) throws RemoteException,Exception;
	/**
	 * �������̶�����ѯ���̶�������
	 * @param fromOrder
	 * @param fromTASK
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask(IOVOrderPentium fromOrder[] ,
			IOVTaskPentium[] fromTASK ) throws RemoteException,Exception;
	/**
	 * ���ݵ�ǰ����ΪC��ѯ�Ѵ����������
	 * @param fromQueue �������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public ArrayUQList getSFQueue( ArrayUQList fromQueue ) throws RemoteException,Exception;
	
	/**
	 * ��ɼ�����ͨ���̵���
	 * @param fromOrder
	 * @param fromTASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFOrder( IOVOrderPentium fromOrder[] , 
			IOVTaskPentium fromTASK[] ) throws RemoteException,Exception;
}
