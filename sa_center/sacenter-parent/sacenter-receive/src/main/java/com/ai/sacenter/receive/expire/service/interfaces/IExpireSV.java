package com.ai.sacenter.receive.expire.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���ڷ���</p>
 * <p>Copyright: Copyright (c) 2018��3��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0
 */
public interface IExpireSV {
	/**
	 * ��ɵ�������������
	 * @param fromMBean ������
	 * @param fromExpireHome ���ڹ��� 
	 * @param fromASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpffxComplete( MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromExpireHome,
			java.util.HashMap fromASK) throws RemoteException, Exception;
}
