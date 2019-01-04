package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ��������</p>
 * <p>Copyright: Copyright (c) 2016��3��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrdOfferSRV {
	/**
	 * ���ݿ�ͨ�����û����ɻ��ڶ���ģ����Ԫ����������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserDepend(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݻ��ڿ�ͨ����������ϵ������Ԫ������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdNature(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�����û����ɻ��ڶ���ģ�Ͷ�����ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdExpire( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�����û����ɻ��ڶ���ģ�Ͷ�����ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdEffective( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݻ����û�ģ�Ͷ���������Ԫ������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFNature(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�����û����ɾ߱������ڿ�ͨ�����Լ�������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ�����û�
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFExpire( IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�����û�����������ͨ�����Լ�������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�����û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFEffective( IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
}
