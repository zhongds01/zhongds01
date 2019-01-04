package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ��Ϣ�ӿڷ���</p>
 * <p>Copyright: Copyright (c) 2013-5-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdfmxSRV {
	/**
	 * ��Ԫ��������Ԫ���׳�����ǰ��Ԫ������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param fromTYPE  ��Ϣ����
	 * @param fromASK  ������Ϣ
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmMonitor( IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm,
			String fromTYPE,
	        Object fromASK,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ����������־[��������]
	 * @param fromUpfwm  ��Ԫ����
	 * @param fromUpdfwm ��������ָ�
	 * @param fromASK ��Ԫ������
	 * @param aEXCEPTION  ��Ԫ�쳣��Ϣ
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmUatmix( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK,
			java.lang.Exception aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ����������־[��������]
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ����������־[��������]
	 * @param fromUpdfmx[IOVUpfwmUatmix] ���׶���
	 * @throws SFException �쳣����
	 * @throws Exception
	 */
	public void finishSFUpfwmUatmix( IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception;
}
