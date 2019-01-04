package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���ڶ����������</p>
 * <p>Copyright: Copyright (c) 2017��3��6��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdbcSV {
	/**
	 * ���ݿ�ͨ������ɿ�ͨ�����첽����鵵
	 * @param fromMBean ȫ������
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderCompleteAsyn( MBeanDelegate fromMBean, 
			IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * ���ݿ�ͨ������ɿ�ͨ�����첽����鵵
	 * @param fromMBean ȫ������
	 * @param fromExigence ��ͨ����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rocketCompleteAsyn( MBeanDelegate fromMBean, 
			IOVMsgFExigence fromExigence,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws RemoteException, Exception;
}
