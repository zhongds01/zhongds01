package com.ai.sacenter.receive.exigence.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�첽DBģʽ</p>
 * <p>Copyright: Copyright (c) 2017��4��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExigenceSV {
	/**
	 * ��ɿ�ͨ�����첽���񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromCouple �첽��Ԫ����
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
}
