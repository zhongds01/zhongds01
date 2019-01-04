package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ������������</p>
 * <p>Copyright: Copyright (c) 2015��10��28��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV {
	/**
	 * ������Ԫ������ѯ��ǰ��Ԫ�������淶
	 * @param fromUpfwm ��Ԫ����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond( IOVUpfwmOrder fromUpfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ������Ԫ������ѯ��ǰ��Ԫ�������淶
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond( IOVUpfwmOrder fromUpfwm, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ������Ԫ�������������Ԫ�����鵵�����
	 * @param fromUpfwm ��Ԫ������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmComplete( IOVUpfwmOrder fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception; 
	/**
	 * ������Ԫ����֪ͨ�������������Ԫ��������鵵(��Ԫ�������������񼤻���)
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdcpm ��Ԫ�鵵���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete( IOVUpfwmOrder fromUpfwm,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �����쳣�����ѯ��Ԫ��������[���߼��쳣������Ԫ�쳣��������,������ϵͳ���쳣ת��Ϊ��Ԫ���쳣]
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ��
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond( IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				SFException aEXCEPTION,
			    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ�����������Ͳ�ѯ��Ԫ�쳣�������
	 * @param fromUpfwm  ��Ԫ����
	 * @param fromUpdfwm ����ָ��
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmException(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������Ԫ���������Ԫ�쳣�������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ���񼤻�ָ��
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݵ�ǰ���������ȡ��ǰ�û��Ŷζ�Ӧ��Ԫ����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdbpmOffice getSFUpfwmOffice( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ������ѯ�������̼���Ԫ�������������
	 * @param fromUpfwm 
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmMapping(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ�������̲�ѯ�������̼���Ԫ�������������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmComposite(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݷ��񶨵�����������̼���Ԫ�����������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxOffer finishSFUpfwmOffer( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
}
