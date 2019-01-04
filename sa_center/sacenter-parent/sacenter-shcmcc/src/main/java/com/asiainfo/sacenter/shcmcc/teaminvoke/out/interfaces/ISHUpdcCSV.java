package com.asiainfo.sacenter.shcmcc.teaminvoke.out.interfaces;

import java.rmi.RemoteException;

/**
 * 
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: ��ͨ���Ķ��Ⱪ©��csf����</p>
 * <p>Copyright: Copyright (c) 2017��3��30��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISHUpdcCSV {


	/**
	 * ��ͨ���������[ͬ����Ϣ]
	 * @param fromMetaMX ��ͨ������Ϣ
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public String orderReceive( String fromMetaMX ) throws RemoteException,Exception;
	
	/**
	 * ��ͨ������鵵[ͬ����Ϣ]
	 * @param fromMetaMX ��ͨ�鵵��Ϣ
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public String orderComplete( String fromMetaMX ) throws RemoteException,Exception;


	/**
	 * �޸�Radiusϵͳ�û����ʽӿ�
	 * @param velocity ����    ����Ϊ��������   e.g 12M   �����»��߷ָ�Ϊ��_�������� e.g  20M_1200M
	 * @param userName ��½�� ��bill_id��
	 * @return
	 * @throws Exception
	 */
	public String alterRadiusSpeed(String busiType, String userName, String velocity ) throws Exception;

	/**
	 * �޸�radiusϵͳ�˺�״̬
	 * @param opType �û�״̬ 0��������1��������
	 * @param userName ��½�� ��bill_id��
	 * @return
	 * @throws Exception
	 */
	public String alterRadiusState(String busiType, String userName, String opType ) throws Exception;
}

	
