package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
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
public interface IUpffmxSRV {
	/**
	 * ��Ԫ����ͣ���ʲ�[�첽ָ��][����ͨ�ʲ�]
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmSuspend(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��Ԫ���ڸ����ʲ�[�첽ָ��][����ͨ�ʲ�]
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmResume(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��Ԫ���ڱ���ʲ�[�첽ָ��][����ͨ�ʲ�]
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmChange(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��Ԫ����ת��ʷ�ʲ�[�첽ָ��][����ͨ�ʲ�]
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmHistory(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��Ԫ����ת��ʷ�ʲ�[�첽ָ��][����ͨ�ʲ�]
	 * @param fromMBean ȫ������
	 * @param fromUpfgkmHome ��Ԫ֪ͨ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���յ�����Ԫ֪ͨ���������Ԫ����������
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ֪ͨ����
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���յ�ǰ��������ɵ����û�����������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffmx( IUpdcContext aContext) throws SFException, Exception;
}
