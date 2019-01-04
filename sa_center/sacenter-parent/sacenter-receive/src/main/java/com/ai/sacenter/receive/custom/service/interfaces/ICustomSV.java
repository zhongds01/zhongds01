package com.ai.sacenter.receive.custom.service.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.util.CarbonList;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��3��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICustomSV {
	/**
	 * �����û���Ų�ѯ��Ϣ�������û������Լ�������ϵ
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser getIInsUserByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * �����û���Ų�ѯ��Ϣ�������û�����(������������ϵ)
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser[] getIInsUserByUserId(long aUserId[], 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * �����û���Ų�ѯ�û�������ϵ
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVUserCentrex> getIInsSrvpkgByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * �����û���Ʒ������Ų�ѯ�û�������ϵ
	 * @param aUserId �û����
	 * @param aInsSrvpkgId �û��������
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUserCentrex getIInsSrvpkgByInsSrvpkgId(long aUserId, 
			long aInsSrvpkgId, 
			String aRegionId) throws RemoteException, Exception;
	/**
	 * �����û���Ų�ѯ�û�Ⱥ���ϵ
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVUserOrderOffer> getIInsOffInsUserByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * �����û���Ų�ѯ�û��߻�
	 * @param aUserId �û����
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVUserOffer> getIInsOfferByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * ���ݲ߻�ʵ����Ų�ѯ�û��߻�
	 * @param aInsOfferId �߻�ʵ�����
	 * @param aRegionId ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUserOffer getIInsOfferByInsOfferId(long aInsOfferId, 
			String aRegionId) throws RemoteException,Exception;
	/**
	 * ���ݲ߻�ʵ����Ų�ѯ��ӦȺ��߻���ϵ
	 * @param aInsOfferId �߻�ʵ�����
	 * @param aRegionId �߻����ڵ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getIInsGrpOfferByInsOfferId( long aInsOfferId, 
			String aRegionId ) throws SFException,Exception;
	/**
	 * ���ݲ߻�ʵ����Ų�ѯ��ӦȺ��߻���ϵ
	 * @param aInsOfferId �߻�ʵ�����
	 * @param aUserId �û����
	 * @param aRegionId �߻����ڵ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getIInsGrpOfferByInsOfferId( long aInsOfferId, 
			long aUserId, 
			String aRegionId ) throws RemoteException, Exception;
	/**
	 * ���ݿͻ���Ų�ѯ�ͻ�����
	 * @param aCUSTOM_ID �ͻ����
	 * @param aCUSTOM_TYPE �ͻ�����
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVCustom getICustom( long aCUSTOM_ID, 
			String aCUSTOM_TYPE,
			String aREGION_ID ) throws RemoteException,Exception;
}
