package com.ai.sacenter.receive.custom.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.custom.bo.CmFamilyCust;
import com.ai.sacenter.receive.custom.bo.CmIndivCust;
import com.ai.sacenter.receive.custom.bo.CmVpmnCust;
import com.ai.sacenter.receive.custom.bo.InsOffer;
import com.ai.sacenter.receive.custom.bo.InsOfferInsUser;
import com.ai.sacenter.receive.custom.bo.InsProd;
import com.ai.sacenter.receive.custom.bo.InsProdInsSrv;
import com.ai.sacenter.receive.custom.bo.InsSrvAttr;
import com.ai.sacenter.receive.custom.bo.InsUser;
import com.ai.sacenter.receive.custom.bo.InsUserOsState;

public interface ICustomDAO extends IUpdbmDAOLife{
	/**
	 * 根据用户id查询用户信息
	 * @param aUSER_ID 用户编号 
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsUser getIInsUserByUserId( long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据用户id查询用户信息
	 * @param aUSER_ID 用户编号 
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsUser[] getIInsUserByUserId( long aUSER_ID[], String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据用户id查询用户信息
	 * @param aUSER_ID 用户编号 
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsUserOsState getIInsUserOsStateByUserId( long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据用户id查询用户信息
	 * @param aUSER_ID 用户编号 
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsUserOsState[] getIInsUserOsStateByUserId( long aUSER_ID[], String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据用户编号查询用户策划信息
	 * @param aUSER_ID 用户编号 
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOffer[] getIInsOfferByUserId(long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据策划实例编号查询用户策划信息
	 * @param aInsOfferId 策划实例编号
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOffer getIInsOfferByInsOfferId( long aInsOfferId, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aUSER_ID
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOfferInsUser[] getInsOffInsUserByUserId( long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aInsOfferId
	 * @param aUserId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOfferInsUser getInsOffInsUserByInsOfferId( long aInsOfferId, 
			long aUserId, 
			String aRegionId ) throws RemoteException, Exception;
	/**
	 * 
	 * @param aInsOfferId
	 * @param aIsMainOffer
	 * @param aIsGrpMainUser
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOfferInsUser getInsOffInsUserByInsOfferId(long aInsOfferId, 
			int aIsMainOffer, 
			int aIsGrpMainUser, 
			String aRegionId ) throws RemoteException, Exception;
	/**
	 * 
	 * @param aUserId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsProdInsSrv[] getIInsSrvByUserId( long aUserId, String aRegionId ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aUserId
	 * @param aInsSrvpkgId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsProdInsSrv[] getIInsSrvByInsSrvpkgId( long aUserId, long aInsSrvpkgId, String aRegionId ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aUserId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsSrvAttr[] getIInsSrvAttrByUserId( long aUserId, String aRegionId ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aUserId
	 * @param aProdSrvRelatId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsSrvAttr[] getIInsSrvAttrByProdSrvRelatId( long aUserId, long aProdSrvRelatId, String aRegionId ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aUserId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsProd[] getIInsSrvpkgByUserId( long aUserId, String aRegionId ) throws RemoteException,Exception;
	/**
	 * 
	 * @param aUserId
	 * @param aInsSrvpkgId
	 * @param aRegionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsProd getIInsSrvpkgByInsSrvpkgId( long aUserId, long aInsSrvpkgId, String aRegionId ) throws RemoteException,Exception;
	/**
	 * 根据客户ID查询客户信息
	 * @param aCUST_ID
	 * @param regionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CmIndivCust getCmIndivCust(long aCUST_ID, String regionId) throws RemoteException,Exception;
	/**
	 * 根据客户ID查询VPMN用户的客户信息
	 * @param aCUST_ID
	 * @param regionId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CmVpmnCust getVpmnCust(long aCUST_ID, String regionId) throws RemoteException,Exception;
	/**
	 * 根据客户ID查询家庭客户信息
	 * @param aCUST_ID
	 * @param regionID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CmFamilyCust getFamilyCust(long aCUST_ID,String regionID) throws RemoteException,Exception;
	
}
