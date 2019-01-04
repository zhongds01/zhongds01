package com.ai.sacenter.teaminvoke.in.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��̨���̷���</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdbcSV {
	/**
	 * �����Ԫ���첽���������񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ��ִ��
	 * @param aCfgTf ת�ƽ�������
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * ��ɷ�����Ԫ��������Ԫ�⼤��
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ�����嵥
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmNetWork(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * ��ɷ�����й��������񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromUpdfmxHome ������й���
	 * @param fromASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpdcmqComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpdfmxHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * ���յ�����Ԫ֪ͨ���������Ԫ����������
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ֪ͨ����
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK) throws RemoteException, Exception;
}
