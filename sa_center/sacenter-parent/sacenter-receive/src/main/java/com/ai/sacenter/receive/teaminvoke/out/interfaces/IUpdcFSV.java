package com.ai.sacenter.receive.teaminvoke.out.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��ͨ���շ���[�ⲿ����]</p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcFSV {
	/**
	 * ��ͨ�����쳣ʧ�ܹ鵵[��������]
	 * @param fromRocket ��ͨ����
	 * @param aEXCEPTION �쳣����
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn(RocketFMessage fromRocket, SFException aEXCEPTION) throws SFException, Exception;
	/**
	 * ��ͨ�����쳣��ʷ�鵵[��������]
	 * @param fromRocket ��ͨ����
	 * @param aEXCEPTION �쳣����
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketCompleteAsyn(RocketFMessage fromRocket, SFException aEXCEPTION) throws SFException, Exception;
	/**
	 * 
	 * @param fromUpfwm
	 * @param fromOffer
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderTransparent( IOVUpfwmOffer fromUpfwm,
			IOVUpffmxOffer fromOffer,
			IUpdcContext aContext ) throws RemoteException,Exception;
	/**
	 * ��ͨ������Ϣ����[ͬ����Ϣ][���ݿ������쳣��ֱ�����쳣]
	 * @param fromRocket ��ͨ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage orderReceive( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
     * ��ͨ������Ϣ����[�첽��ʽ][���ݿ������쳣��ֱ�����쳣]
     * @param fromRocket ��ͨ����
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderReceiveAsyn(RocketFMessage fromRocket) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromUpfwm
	 * @param fromOffer
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketTransparent( IOVUpfwmOffer fromUpfwm,
			IOVUpffmxOffer fromOffer,
			IUpdcContext aContext ) throws RemoteException,Exception;
	/**
	 * ��ͨ���������[ͬ����ʽ]
	 * @param fromRocket ��ͨ����
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketReceive(RocketFMessage fromRocket)  throws RemoteException,Exception;
	/**
     * ��ͨ���������[�첽��ʽ]
     * @param fromRocket ��ͨ����
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void rocketReceiveAsyn(RocketFMessage fromRocket)  throws RemoteException,Exception;
	/**
	 * ��ͨ������鵵[�첽��ʽ]
	 * @param fromRocket
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketCompleteAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * ��ͨ���������[�첽�뿪ͨ�첽��]
	 * @param fromRocket ��ͨ����
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rabbitReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException, Exception;
	/**
	 * ���񶨵�����ת��������Ԫ
	 * @param aVM_ORDER_ID ��Χ������
	 * @param aTASK_ID ���񶨵������
	 * @param aVM_ORG_ID ��Ӧ��֯���
	 * @param aVM_STAFF_ID ������ 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderTurnRedo( String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception;
	/**
	 * ���񶨵������˹���������
	 * @param aVM_ORDER_ID ��Χ������
	 * @param aTASK_ID ���񶨵������
	 * @param aVM_REASON �˹�����ԭ��
	 * @param aVM_ORG_ID ��Ӧ��֯���
	 * @param aVM_STAFF_ID ������ 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderComplete( String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception;
	/**
	 * ���񶨵������쳣�ع�����
	 * @param aVM_ORDER_ID ��Χ������
	 * @param aTASK_ID ���񶨵������
	 * @param aVM_REASON �˹�����ԭ��
	 * @param aVM_ORG_ID ��Ӧ��֯���
	 * @param aVM_STAFF_ID ������ 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderException( String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception;
	/**
	 * ������񼤻���ض���
	 * @param aVM_ORDER_ID ���񶩵�
	 * @param aBILL_ID �û�����
	 * @param aVM_REASON ������ԭ��
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
	 * @param aVM_ORDER_ID ���񶩵�
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
}
