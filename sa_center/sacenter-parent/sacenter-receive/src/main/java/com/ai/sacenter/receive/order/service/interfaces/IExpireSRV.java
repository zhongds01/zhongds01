package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �û����ڹ�������</p>
 * <p>Copyright: Copyright (c) 2017��3��7��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExpireSRV {
	/**
	 * ���ݿ�ͨ����������ɵ����û���ͨ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����������ɷ����Ʒ�����ڿ�ͨ[�����ڿ�ͨ�ͱ����ڿ�ͨ]
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����������ɷ����Ʒȫ��������ͨ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdEffective(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�û��������ȫ��������[�����ڿ�ͨ]������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ�û�ɾ�����ܹ����Լ��������ڹ�������
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ���û�
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserHistory(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ�û�ɾ�����ܹ����Լ��������ڹ�������[���Ա�����ڶ�Ӧ�����Ʒ�˶�]
	 * @param fromRequest ��ͨ����
	 * @param fromGroup ��ͨ���û�
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFGroupHistory( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromGroup,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
}
