package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������з���</p>
 * <p>Copyright: Copyright (c) 2014-12-30</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcmqSRV {
	/**
	 * ���������������Ԫת��������[��̨�����Զ�����]
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVQueuePentium finishSFUpdcmqCreate( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵�����ת������е�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcmqCreate( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ�����й�����ɷ��������ز�����Ԫ���
	 * @param fromQueue ������й���
	 * @param fromUpdcpm ����������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskActive(IOVQueuePentium fromQueue, 
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ɷ�����й��������񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromUpdfmxHome ������й���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcmqComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpdfmxHome,
			IUpdcContext aContext ) throws SFException, Exception;
}
