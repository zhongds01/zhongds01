package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-5-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISystemSRV {
	/**
	 * ���������ͨ����
	 * @param fromPentium ��������
	 * @param fromUpdcpm ��������ģ��
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFOrder(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * ����������Ա���񶨵� 
	 * @param fromPentium
	 * @param fromUpdcpm
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFBatch(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * �������Ⱥ�鶨��
	 * @param fromRequest ����Ⱥ�鶨��
	 * @param fromUpdcpm ����Ⱥ������
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFGroup(IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * �������������ͨ������ͨ
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * ���������񶨵�����
	 * @param fromRequest ���񶨵�����
	 * @param fromUpdcpm ��ͨ����
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderResponse fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * ���볷����Ԫ�����ڵ�
	 * @param fromPentium ��������
	 * @param fromUpdcpm ��������
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse cancelSFExpire( IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * ������񼤻���ض���
	 * @param aVM_ORDER_ID ���񶩵���
	 * @param aBILL_ID �û�����
	 * @param aVM_REASON ����ͣԭ��
	 * @param aADDIN_XML
	 * @throws SFException
	 * @throws Exception
	 */
	public void suspendSFOrder( String aVM_ORDER_ID , 
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws SFException,Exception;
	/**
	 * ������񼤻���ض���
	 * @param aVM_ORDER_ID ���񶩵���
	 * @param aBILL_ID �û�����
	 * @param aVM_REASON ����ԭ��
	 * @param aADDIN_XML
	 * @throws SFException
	 * @throws Exception
	 */
	public void resumeSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws SFException,Exception;
	/**
	 * ���񼤻���ض�������
	 * @param aVM_ORDER_ID ���񶩵�
	 * @param aBILL_ID �û�����
	 * @param aVM_REASON ����ԭ��
	 * @param aADDIN_XML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] cancelSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws SFException,Exception;
	/**
	 * ��ѯ�������߶�������
	 * IOpenApplicException ������ͨ��ѯδ�������
	 * IOpenSFException ������ͨԶ�̴����쳣
	 * IOpenException       ������ͨ[aVM_ORDER_ID]��Ӧ��¼��Ч
	 * @param aVM_ORDER_ID  ���񶨵����
	 * @param aBILL_ID �û�����
	 * @param aADDIN_XML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getASKOrder( long aVM_ORDER_ID , 
			String aBILL_ID , 
			String aADDIN_XML ) throws SFException,Exception;
    /**
     * ���ݷ��񶨵���ɵ������񶨵�����[�������̲�ֹ���]
     * @param fromOrder ��ͨ����
     * @param fromTASK ��ͨ����
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpfwm( IOVOrderPentium fromOrder , 
    		IOVTaskPentium fromTASK[],
			IUpdcContext aContext ) throws SFException,Exception;
    /**
     * ���ݷ�������������񶨵�����[�������̲�ֹ���]
     * @param fromOrder ���񶨵�
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpfwm( IOVOrderPentium fromOrder[] , 
			IUpdcContext aContext ) throws SFException,Exception;
    /**
     * ������������ָ���ɷ��񶨵��������
     * @param fromUpdbm ���񶨵�
     * @param fromUpdfm ����ָ�
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpfwm( java.util.Map fromUpdbm , 
			java.util.List fromUpdfm , 
			IUpdcContext aContext ) throws SFException,Exception;
    /**
	 * ���ݷ���ָ���ɷ��񶨵�������Ԫָ�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ֪ͨ��Ԫ������;(��Ԫ�������ڴ���)����
	 * 1.�����񶨵������쳣�ص������񶨵����������Ԫָ������δ�ύ�����ݿ�ʱֱ��������񶨵������Ӧ��Ԫ����shujuu
	 * @param aINSTANCE ���񶨵�
	 * @param aUpdswfLife ���񶨵�����
	 * @param aUpdspmLife ��Ԫָ�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfmc( IOVOrderPentium aINSTANCE , 
			IOVTaskPentium aUpdswfLife , 
			IOVUpdspmLife aUpdspmLife , 
			IUpdcContext aContext )  throws SFException,Exception;
    /**
	 * ��������������Ԫ����
	 * @param fromTASK
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������񲻰�������Ԫ����
	 * @param aTASK_ID
	 * @param fromASK
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( long aTASK_ID ,
			IOVUpfwmResponse fromASK )  throws SFException,Exception;
	/**
	 * ������ԪӦ������ɵ�ǰ���񼤻��������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromASK ��ԪӦ��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder, 
		IOVTaskPentium fromTASK,
		IOVUpfwmResponse fromASK,
		IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������ԪӦ����ɵ�ǰ���񶨵�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromASK ��ԪӦ��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK ,
			IUpdcContext aContext )  throws SFException,Exception;
	/**
	 * ������ԪӦ���쳣������ǰ���񶨵�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION ,
			IUpdcContext aContext )  throws SFException,Exception;
	/**
	 * ���񼤻�����ת����
	 * @param aTASK_ID ������ص����
	 * @param aVM_ORG_ID ����Ա������֯���
	 * @param aVM_STAFF_ID ����Ա���
	 * @param fromASK �����������
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskRedo(long aTASK_ID[],
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws SFException,Exception;
	/**
	 * ���񼤻������˹�����
	 * @param aTASK_ID ������ص����
	 * @param aVM_REASON �˹�����ԭ��
	 * @param aVM_ORG_ID ����Ա������֯���
	 * @param aVM_STAFF_ID ����Ա���
	 * @param fromASK �����������
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete(long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws SFException,Exception;
	/**
	 * ���񼤻������쳣�ص�
	 * @param aTASK_ID ������ص����
	 * @param aVM_REASON �쳣ԭ������
	 * @param aVM_ORG_ID ����Ա������֯���
	 * @param aVM_STAFF_ID ����Ա���
	 * @param fromASK �����������
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK) throws SFException,Exception;
}
