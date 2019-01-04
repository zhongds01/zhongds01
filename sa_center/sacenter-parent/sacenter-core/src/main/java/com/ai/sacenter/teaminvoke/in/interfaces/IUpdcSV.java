package com.ai.sacenter.teaminvoke.in.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��������ӿڷ���</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcSV {
	/**
	 * ���������ͨ����
	 * @param fromPentium ��������
	 * @param fromUpdcpm ��������ģ��
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFOrder(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * �����Ա���񶨵�
	 * @param fromPentium
	 * @param fromUpdcpm
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFBatch(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * �������Ⱥ�鶨��
	 * @param fromPentium ����Ⱥ�鶨��
	 * @param fromUpdcpm ����Ⱥ������
	 * @param fromXML 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFGroup(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * �����������������
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
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
			String fromXML ) throws RemoteException,Exception;
	/**
	 * ���볷����Ԫ�����ڵ�
	 * @param fromPentium ��������
	 * @param fromUpdcpm ��������
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse cancelSFExpire( IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * ������񼤻���ض���
	 * @param aVM_ORDER_ID ҵ����ˮ��
	 * @param aBILL_ID  �û�����
	 * @param aVM_REASON ����ԭ��
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void suspendSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * ������񼤻���ض���
	 * @param aVM_ORDER_ID ҵ����ˮ��
	 * @param aBILL_ID �û�����
	 * @param aVM_REASON ����ԭ��
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void resumeSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * ���񼤻���ض�������
	 * @param aVM_ORDER_ID ���񶩵�
	 * @param aBILL_ID �û�����
	 * @param aVM_REASON ����ԭ��
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void cancelSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * ��ѯ���߼�¼��Ϣ
	 * IOpenApplicException    ������ͨ��ѯδ�������
	 * IOpenRemoteException    ������ͨԶ�̴����쳣
	 * IOpenException          ������ͨ[aVM_ORDER_ID]��Ӧ��¼��Ч
	 * @param aVM_ORDER_ID
	 * @param aBILL_ID
	 * @param aADDIN_XML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getASKOrder( long aVM_ORDER_ID , 
			String aBILL_ID , 
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * ���񼤻�����ת����
	 * @param aTASK_ID ������ص����
	 * @param aVM_ORG_ID ����Ա������֯���
	 * @param aVM_STAFF_ID ����Ա���
	 * @param fromASK �����������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFTaskRedo(long aTASK_ID[],
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws RemoteException,Exception;
	/**
	 * ���񼤻������˹�����
	 * @param aTASK_ID ������ص����
	 * @param aVM_REASON �˹�����ԭ��
	 * @param aVM_ORG_ID ����Ա������֯���
	 * @param aVM_STAFF_ID ����Ա���
	 * @param fromASK �����������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFTaskComplete(long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws RemoteException,Exception;
	/**
	 * ���񼤻������쳣�ص�
	 * @param aTASK_ID ������ص����
	 * @param aVM_REASON �쳣ԭ������
	 * @param aVM_ORG_ID ����Ա������֯���
	 * @param aVM_STAFF_ID ����Ա���
	 * @param fromASK �����������
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFTaskException( long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK) throws RemoteException,Exception;
}
