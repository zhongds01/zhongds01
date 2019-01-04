package com.ai.sacenter.receive.order.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��10��31��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUrgencySRV {
	/**
	 * ��ͨ�޸����ַ�����
	 * @param fromMBean ȫ������
	 * @param fromUrgencyHome ��������
	 * @param fromOther
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void urgencyReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUrgencyHome,
			IUpdcContext aContext ) throws SFException,Exception;
}
