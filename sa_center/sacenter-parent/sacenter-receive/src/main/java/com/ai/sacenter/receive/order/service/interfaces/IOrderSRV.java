package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��3��15��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrderSRV {
	/**
	 * ���ݿ�ͨ��Ϣת��Ϊ��ͨ��ʷ��Ϣ
	 * @param fromMBean ȫ������
	 * @param fromRequest ��ͨ��Ϣ
	 * @param fromUpdcpm ��ͨ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVRocketExigence getSFMsgFHistory( MBeanDelegate fromMBean, 
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ��Ϣת��Ϊ��ͨʧ����Ϣ
	 * @param fromMBean ȫ������
	 * @param fromRequest ��ͨ��Ϣ
	 * @param fromUpdcpm ��ͨ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVRocketExigence getSFMsgFFail( MBeanDelegate fromMBean, 
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
     * ��ͨ��������[ͬ����ʽ]
     * @param fromRequest ��ͨ��Ϣ
     * @return
     * @throws SFException
     * @throws Exception
     */
	public IOVMsgFResponse orderReceive(IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
     * ��ͨ��������[�첽��ʽ]
     * @param fromRequest ��ͨ��Ϣ
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderReceiveAsyn(IOVRocketExigence fromRequest[]) throws SFException,Exception;
	/**
     * ��ͨ���������쳣תʧ�ܴ洢[�첽��ʽ]
     * @param fromRequest ��ͨ����
     * @param aEXCEPTION ҵ������
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderReceiveAsyn(IOVRocketExigence fromRequest[],
			SFException aEXCEPTION) throws SFException,Exception;
	/**
     * ��ͨ����������ʷ����[�첽��ʽ]
     * @param fromRequest ��ͨ����
     * @param aEXCEPTION ҵ������
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderCompleteAsyn(IOVRocketExigence fromRequest[],
			SFException aEXCEPTION) throws SFException,Exception;
	/**
	 * ��ͨ�����ַ�����
	 * @param fromMBean ȫ������
	 * @param fromRocketHome ��ͨ����
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromRocketHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ��ͨ��������[�첽��ʽ]
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext ��ͨ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderReceiveAsyn(IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ����������ɿ�ͨ��Ϣ����
	 * @param fromMBean ȫ������
	 * @param fromPentium ��ͨ����
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderDistribute( IOVMsgFRequest fromPentium,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����������ɿ�ͨ��������
	 * @param fromRequest ��ͨ��Ϣ
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderDistribute(IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ͨ��Ϣת��ͨ��Ϣ��ʷ
	 * @param fromRequest   ��ͨ����
	 * @param fromUpdcpm ��ͨ����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void orderComplete( IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ͨ��Ϣת��ͨ��Ϣʧ�ܱ�
	 * @param fromRequest   ��ͨ����
	 * @param fromUpdcpm ��ͨ����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void orderException( IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
