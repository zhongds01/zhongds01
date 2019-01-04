package com.ai.sacenter.receive.teaminvoke.out.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: �ⲿ���÷���/�Խ�CSF</p>
 * <p>Copyright: Copyright (c) 2017��3��6��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcCSV {
	/**
	 * ��ͨ������Ϣ����[ͬ����Ϣ]
	 * @param fromRocket ��ͨ����
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage orderReceive( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * ��ͨ������Ϣ����[�첽��Ϣ]
	 * @param fromRocket ��ͨ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * ��ͨ���������[ͬ����Ϣ]
	 * @param fromRocket ��ͨ������Ϣ
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketReceive( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * ��ͨ���������[�첽��Ϣ]
	 * @param fromRocket ��ͨ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * ��ͨ������鵵[�첽��Ϣ]
	 * @param fromRocket ��ͨ�鵵��Ϣ
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketCompleteAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * ��ͨ���������[�첽�뿪ͨ�첽��]
	 * @param fromRocket ��ͨ����
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rabbitReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException, Exception;
	
}
