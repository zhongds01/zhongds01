package com.ai.sacenter.provision.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��Ԫ���ڲ���ʲ�</p>
 * <p>Copyright: Copyright (c) 2017��2��25��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpffmxCapital {
	/**
	 * ���ָ����Ԫ����ָ����Ԫ����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpfgkmHome ���ڹ���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmSuspend( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ָ����Ԫ�ָ�ָ����Ԫ����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpfgkmHome ���ڹ���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmResume( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ָ����Ԫ����[�û������Լ��μƷѺ���]�������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpfgkmHome ���ڹ���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmChange( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ָ����Ԫ����ת��ʷ����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpfgkmHome ���ڹ���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ָ����Ԫ����ת��ʷ����
	 * @param fromMBean ȫ������
	 * @param fromUpfgkmHome ��Ԫ���ڹ���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ָ����Ԫ��������
	 * @param fromMBean ȫ������
	 * @param fromUpfgkmHome ��Ԫ���ڹ���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmExpire( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
}
