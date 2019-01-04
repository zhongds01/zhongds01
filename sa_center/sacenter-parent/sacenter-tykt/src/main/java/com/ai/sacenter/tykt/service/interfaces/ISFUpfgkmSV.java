package com.ai.sacenter.tykt.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ͳһ��ͨ����</p>
 * <p>Copyright: Copyright (c) 2014-12-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface ISFUpfgkmSV {
	/**
	 * ���񼤻�⵽ͳһ��ͨ��ͬ��
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ�����嵥
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * �����Ԫ���첽���������񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromCouple �첽��Ԫ����
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * ��ɷ���ͨ���������
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome Ӫҵ������������
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmUrgency( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
}
