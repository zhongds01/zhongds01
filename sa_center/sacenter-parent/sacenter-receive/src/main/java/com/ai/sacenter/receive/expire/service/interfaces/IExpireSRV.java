package com.ai.sacenter.receive.expire.service.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��3��7��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExpireSRV {
	/**
	 * �����û����ת�ص�ǰ���ڹ����û�
	 * @param aUSER_ID �û����
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpdfmxDirectory getSFUpffxUser(long aUSER_ID, String aREGION_ID )  throws SFException, Exception;
	/**
	 * �����û���ź͵���ʱ���ѯ��ǰ���ڹ����û�
	 * @param aUSER_ID �û����
	 * @param aREGION_ID ���б���
	 * @param fromExpire ����ʱ��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVExpireUser getSFUpffxUser( long aUSER_ID, String aREGION_ID, long fromExpire) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����װ�ص�����������
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxLoad( IOVMsgFRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ɵ����û����ڹ�������
	 * @param fromRequest ��ͨ����
	 * @param fromUser ��ͨ�û�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxRecycle(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromUser,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�û���ɵ�ǰ�û��������Լ��䶩����ϵ��ʷ�鵵
	 * @param fromRequest ��ͨ����
	 * @param fromUser ��ͨ�û�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxHistory(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromUser,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����������������ڶ�����ϵ�鵵
	 * @param fromOrder ��ͨ����
	 * @param fromUser ��ͨ�û�
	 * @param fromOffer ��ͨ��������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxHistory( IOVMsgFRequest fromOrder, 
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ����û���ɵ��ڹ�������
	 * @param fromOrder ��ͨ����
	 * @param fromUser ��ͨ�û�
	 * @param fromExpire ����ʱ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVExpireUser finishSFUpffxUser(IOVMsgFRequest fromOrder, 
			IOVMsgFUser fromUser, 
			java.sql.Timestamp fromExpire,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����������ɵ��ڹ���������ϵ
	 * @param fromOrder ��ͨ����
	 * @param fromUser ��ͨ�û�
	 * @param fromOffer ��ͨ���ڶ���
	 * @param fromExpire ����ʱ��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxExpire(IOVMsgFRequest fromOrder, 
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer,
			java.sql.Timestamp fromExpire,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ɵ�������������
	 * @param fromMBean ������
	 * @param fromExpireHome ���ڹ��� 
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpffxComplete( MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromExpireHome,
			IUpdcContext aContext) throws RemoteException, Exception;
}
