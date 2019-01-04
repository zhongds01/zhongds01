package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ��������[�ڲ�����]</p>
 * <p>Copyright: Copyright (c) 2018��1��5��</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0
 */
public interface IUpdcSV {
	/**
	 * ��ͨ�����ַ�����
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ����
	 * @param fromOther
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromRocket, 
			java.util.HashMap fromOther) throws RemoteException,Exception; 
	/**
	 * ��ͨ�޸����ַ�����
	 * @param fromMBean ȫ������
	 * @param fromUrgency ��ͨ�޸���
	 * @param fromOther
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void urgencyReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUrgency, 
			java.util.HashMap fromOther) throws RemoteException,Exception; 
}
