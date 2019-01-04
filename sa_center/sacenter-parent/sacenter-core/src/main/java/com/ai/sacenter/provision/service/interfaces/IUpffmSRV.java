package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������Ԫ��������</p>
 * <p>Copyright: Copyright (c) 2014-4-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpffmSRV {
	/**
	 * ���ݵ�ǰ��Ԫ���������Ԫ����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ���񼤻�ָ��
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ��Ԫ���������Ԫ�����鵵
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ���񼤻�ָ��
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmCreate( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ��Ԫ���������Ԫ������ʷ�鵵
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ���񼤻�ָ��
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ��Ԫ��������鵵(��Ԫ��������������ͨ��)
	 * @param fromMBean ȫ������
	 * @param fromCouple ��Ԫ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IOVUpfwmCouple fromCouple[],
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ����ҵ�񼶲������[��������ת��ʷ[Ĭ����Ԫ�����鵵[ɾ�����񶨵�����������Ԫ������]]]
	 * @param fromPentium ��������
	 * @param fromUpdcpm ���������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ����ҵ�񼶲������[��Ԫ������ת��Ԫʧ�ܵ�[���񶨵��쳣����[ɾ�����񶨵�����������Ԫ������]]]
	 * @param fromPentium ��������
	 * @param fromUpdcpm ���������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ����ҵ�񼶲������[���������񶨵�[������񶨵�]]
	 * @param fromPentium ��������
	 * @param fromUpdcpm ����鵵���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���񶨵����������쳣����[���񶨵�������תʧ�ܱ�,��Ԫ����ת��Ԫ����ʧ�ܱ�,ɾ�����񶨵�����������Ԫ������]
	 * @param fromPentium ��������
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION, 
			IUpdcContext aContext ) throws SFException,Exception;
}
