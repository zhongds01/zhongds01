package com.ai.sacenter.core.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdwfSRV {
	/**
	 * �������񶨵�[�������񶨵��洢]
	 * @param fromRequest ��ͨ����
	 * @param fromUSER   ��ͨ�û�
	 * @param fromGROUP  ��ͨ�û�����Ⱥ��
	 * @param aCOMPETENCE ����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium createSFOrder( IOVOrderRequest fromRequest,
			IOVOrderUser fromUSER,
			IOVOrderUser fromGROUP,
			IProfessionalTemplate.ICompetenceOffer aCOMPETENCE, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����Ⱥ���Ա����[�������񶨵��洢]
	 * @param fromRequest ��ͨ����
	 * @param fromMEMBER ��Ա�û�
	 * @param fromGROUP Ⱥ���û�
	 * @param aCOMPETENCE Ⱥ������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] createSFOrder( IOVOrderRequest fromRequest,
			IOVOrderUser fromMEMBER[],
			IOVOrderUser fromGROUP,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��������ⶩ���Ų�ѯ���񶨵�(��;����ʧ�ܵ��Լ������ڵ�)
	 * @param aVM_ORDER_ID
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFOrder( String aVM_ORDER_ID ) throws SFException,Exception;
	/**
	 * ���ݶ������Ų�ѯ���񶨵�
	 * @param aORDER_ID ��ͨ��������
	 * @param aUSER_ID �û����
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( String aORDER_ID, long  aUSER_ID, String aREGION_ID ) throws SFException,Exception;
	/**
	 * ���ݶ�����Ų�ѯ������ͨ������Ϣ
	 * @param aORDER_ID ���񶨵���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( long aORDER_ID ) throws SFException,Exception;
	/**
	 * ���ݶ�����Ų�ѯ������ͨ������Ϣ
	 * @param fromTASK ���񶨵�����
	 * @param aORDER_ID ���񶨵���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( IOVTaskPentium fromTASK ,
			long aORDER_ID   ) throws SFException,Exception;
	/**
	 * ���ݷ���Ⱥ�鶨����ѯ�÷��񶨵���Ӧ�ӷ��񶨵�
	 * @param fromGroup ����Ⱥ�鶨��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFMember( IOVOrderPentium fromGroup ) throws SFException,Exception;
	/**
	 * ���ݶ��������Ų�ѯ����������Ϣ
	 * @param aTASK_ID
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( long aTASK_ID ) throws SFException,Exception;
	/**
	 * ��ѯ���������������
	 * @param aTASK_ID
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskFail( long aTASK_ID[] ) throws SFException,Exception;
	/**
	 * ������Ԫ������ѯ���񶨵�����
	 * @param fromUpfwm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( IOVUpfwmOrder fromUpfwm ) throws SFException,Exception;
	/**
	 * ������Ԫ������ѯ���񶨵�����
	 * @param fromUpfwm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVUpfwmOrder fromUpfwm[] ) throws SFException,Exception;
	/**
	 * ���ݷ�����в�ѯ���񶨵�����
	 * @param fromQueue �������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask(IOVQueuePentium fromQueue) throws SFException,Exception;
	/**
	 * ���ݶ�����Ų�ѯ����(�Ǹ���)�����б���Ϣ
	 * @param fromOrder ���񶨵�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * ���ݶ�����Ų�ѯ����(����)�����б���Ϣ
	 * @param fromOrder ���񶨵�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskControl( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵���ѯ�̱߳����ϴ�������Ԫ��������
	 * @param fromOrder ���񶨵�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskCreate( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * ���ݶ�����Ų�ѯ�쳣����
	 * @param fromOrder
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskFailure( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵���ѯ���񶨵���������
	 * @param fromOrder ���񶨵�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskReply( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * ���ݷ������񵥲�ѯ����������������
	 * @param fromOrder ���񶩵�
	 * @param fromTASK ������������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTaskDepend( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK ) throws SFException,Exception;
	/**
	 * ��ѯ���̶�Ӧ�������񲢺ϲ���������
	 * @param fromBWO
	 * @param fromTASK
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVOrderPentium fromBWO , 
			IOVTaskPentium fromTASK[] ) throws SFException,Exception;
	
	/**
	 * 
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrder( IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��������ͨ��ͨ����
	 * @param fromRequest
	 * @param fromBusines
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium applySFOrder( IOVOrderRequest fromRequest, 
			IProfessionalTemplate.ICompetenceBusines fromBusines,
			IUpdcContext aContext ) throws SFException,Exception;
	
	/**
	 * ��������ͨ��Ա������ͨ(������Ա������ͨ)
	 * @param fromRequest ��ͨ����
	 * @param fromBusines ��ͨ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] applySFBatch(IOVOrderRequest fromRequest,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext) throws SFException, Exception;
	
	/**
	 * ��������ͨȺ�鹤����ͨ(������Ա������ͨ)
	 * @param fromRequest ��ͨ����
	 * @param fromBusines ��ͨ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium applySFGroup( IOVOrderRequest fromRequest , 
			IProfessionalTemplate.ICompetenceBusines fromBusines,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �������������ͨ������ͨ
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] applySFCentrex( IOVOrderRequest fromRequest, 
			IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��������ͨ�쳣����
	 * @param fromOrder ���ع�����
	 * @param fromTASK ���ع�����
	 * @param fromUpdfmx �ع�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium applySFRollBack( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVTaskPentium fromUpdfmx[],
			IUpdcContext aContext ) throws SFException,Exception;
}
