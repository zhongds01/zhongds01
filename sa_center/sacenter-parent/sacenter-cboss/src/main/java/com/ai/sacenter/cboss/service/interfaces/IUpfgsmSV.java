package com.ai.sacenter.cboss.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: CBOSS����</p>
 * <p>Copyright: Copyright (c) 2014-12-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgsmSV {
	/**
	 * ���񼤻�⵽CBOSS��ͬ��
	 * @param fromMBean ����ȫ������
	 * @param fromINDEX ��Ԫ������
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * �����Ԫ���첽���������񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome �첽��Ԫ����
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
}
