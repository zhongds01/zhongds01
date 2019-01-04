package com.ai.sacenter.receive.custom.service.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �ͻ������ڲ�����</p>
 * <p>Copyright: Copyright (c) 2016��3��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICustomSRV {
	/**
	 * �����û���Ų�ѯԤת���û��Լ��䶩����ϵ
	 * @param aUserId �û����
	 * @param aRegionId �û����ڵ���
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser getSFUserByUserId( long aUserId, String aRegionId) throws SFException,Exception;
	/**
	 * �����û���Ų�ѯԤת���û�[������ר��]
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserLoader( long aUserId[], String aRegionId) throws SFException,Exception;
	/**
	 * �����û���Ų�ѯ�û��߻���Ϣ
	 * @param aUserId �û����
	 * @param aRegionId �û����ڵ���
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser getSFUserOfferByUserId( long aUserId, String aRegionId) throws SFException,Exception;
	/**
	 * ���ݲ߻�ʵ����Ų�ѯ��Ӧ�߻���ϵ
	 * @param aInsOfferId �߻�ʵ�����
	 * @param aRegionId �߻����ڵ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserOfferByInsOfferId( long aInsOfferId, String aRegionId ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�û���ѯ�û�������ϵ
	 * @param aUserId �û����
	 * @param aRegionid ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFUserOrderByUserId( long aUserId, String aRegionid ) throws SFException,Exception;
	/**
	 * �����û���Ų�ѯ�û�Ⱥ���ϵ
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFUserGroupByUserId( long aUserId, String aRegionId ) throws SFException,Exception;
	/**
	 * �����û����񶩹���ѯ�û�������
	 * @param fromMsgFUser
	 * @param fromMsgFOffer
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserCentrex getSFUserCentrex( IOVMsgFUser fromMsgFUser, 
			IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * �����û����񶩹���ѯ�û�������ϵ
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromMsgFOffer ��ͨ��Ʒ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrder getSFUserOrder( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * ���ݲ߻�ʵ����Ų�ѯ��ӦȺ��߻���ϵ
	 * @param aInsOfferId �߻�ʵ�����
	 * @param aRegionId �߻����ڵ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getSFGroupOrderOffer( long aInsOfferId, String aRegionId ) throws SFException,Exception;
	/**
	 * �����û����������ѯ�û���Ʒ��Ӧ�߻���ϵ
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromMsgFOffer ��ͨ��Ʒ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getSFOrderOffer( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ���������ѯ�ò�Ʒ��Ӧ�߻��û�
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromMsgFOffer ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFOfferUser( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ���������ѯ�ò�Ʒ��ӦȺ�����û�
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromMsgFOffer ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFGroupUser( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�û���ѯ���û���Ӧ��ǰ��Ч�ײ�
	 * @param fromMsgFUser ��ͨ�û�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserOffer( IOVMsgFUser fromMsgFUser ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ���������ѯ�÷����Ʒ��Ӧʵ���߻�
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromMsgFOffer ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserOffer( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * ���ݵ��ڷ����Ʒ��ȡ�û�������ϵ
	 * @param fromExpUser ���ڹ���
	 * @param fromExpOffer ���ڷ����Ʒ
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUserOrder getSFUserOrder( IOVExpireUser fromExpUser, IOVExpireOffer fromExpOffer ) throws SFException,Exception; 
	/**
	 * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
	 * @param aCustomId �ͻ����
	 * @param aCustomType �ͻ�����
	 * @param aRegionId ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVCustom getSFCustom( long aCustomId, String aCustomType, String aRegionId ) throws SFException,Exception;
}
