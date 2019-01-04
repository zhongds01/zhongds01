package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IOrderRsRspHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �����������</p>
 * <p>Copyright: Copyright (c) 2014-4-8</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV {
	/**
	 * ���ݷ��񶨵���ѯ��ǰ�쳣���񶨵��ɵ�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return �ɵ���������(0�ɵ��������1�ɵ����Թ淶)
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskClaim( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݷ��񼤻�����ɵ�����ʵ����ع����ɵ�
	 * @param fromOrder  ���񶨵�
	 * @param fromTASK   ���񶨵�����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aEXCEPTION �����쳣��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdffwmOffer finishSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݷ��񶨵������ѯ��ǰ���񶨵������쳣�������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromNetWork ��Ԫ������
	 * @param aEXCEPTION �����쳣
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskCompensa(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ��ɷ��񼤻�������쳣��������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromNetWork ��Ԫ������
	 * @param aEXCEPTION �����쳣
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFTaskNetWork( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵������ѯ��ǰ��ܼ���������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param aEXCEPTION �����쳣
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse getSFTaskRespond(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������Ԫ��������ת��Ϊ����ͨ��������
	 * @param fromTASK ���񹤵�
	 * @param fromUpdfwm ����ָ�
	 * @param fromNetWork ��Ԫ������
	 * @param aEXCEPTION �����쳣
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse getSFTaskRespond( Object fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * �����ⲿ����ת������ͨ����
	 * @param fromRequest �ⲿ����
	 * @param fromUpdcpm ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOrderRsRspHome getSFTaskExtend( IOVOrderResponse fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵������ѯ���񶨵��쳣�������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aEXCEPTION �����쳣
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskException( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵�������ɷ��񶨵��쳣�������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aEXCEPTION �����쳣
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݷ�����в�ѯ��ǰ������м����������
	 * @param fromQueue �������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpdcmqComplete( IOVQueuePentium fromQueue,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ�����й�����ɵ�ǰ������б���
	 * @param fromQueue ������й���
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcmqComplete( IOVQueuePentium fromQueue,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ�쳣���������ѯ���������쳣�ع����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ�쳣���񶩵�������ɷ��񶩵��쳣�ع����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ���񶨵�����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFTaskRollBack( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
