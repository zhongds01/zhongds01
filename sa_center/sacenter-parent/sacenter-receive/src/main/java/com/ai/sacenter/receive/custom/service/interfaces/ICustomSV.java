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
 * <p>Copyright: Copyright (c) 2016年3月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICustomSV {
	/**
	 * 根据用户编号查询信息中心中用户资料以及订购关系
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser getIInsUserByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * 根据用户编号查询信息中心中用户资料(不包含订购关系)
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser[] getIInsUserByUserId(long aUserId[], 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * 根据用户编号查询用户订购关系
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVUserCentrex> getIInsSrvpkgByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * 根据用户产品订购编号查询用户订购关系
	 * @param aUserId 用户编号
	 * @param aInsSrvpkgId 用户订购编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUserCentrex getIInsSrvpkgByInsSrvpkgId(long aUserId, 
			long aInsSrvpkgId, 
			String aRegionId) throws RemoteException, Exception;
	/**
	 * 根据用户编号查询用户群组关系
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVUserOrderOffer> getIInsOffInsUserByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * 根据用户编号查询用户策划
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVUserOffer> getIInsOfferByUserId( long aUserId, 
			String aRegionId ) throws RemoteException,Exception;
	/**
	 * 根据策划实例编号查询用户策划
	 * @param aInsOfferId 策划实例编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUserOffer getIInsOfferByInsOfferId(long aInsOfferId, 
			String aRegionId) throws RemoteException,Exception;
	/**
	 * 根据策划实例编号查询对应群组策划关系
	 * @param aInsOfferId 策划实例编号
	 * @param aRegionId 策划所在地市
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getIInsGrpOfferByInsOfferId( long aInsOfferId, 
			String aRegionId ) throws SFException,Exception;
	/**
	 * 根据策划实例编号查询对应群组策划关系
	 * @param aInsOfferId 策划实例编号
	 * @param aUserId 用户编号
	 * @param aRegionId 策划所在地市
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getIInsGrpOfferByInsOfferId( long aInsOfferId, 
			long aUserId, 
			String aRegionId ) throws RemoteException, Exception;
	/**
	 * 根据客户编号查询客户资料
	 * @param aCUSTOM_ID 客户编号
	 * @param aCUSTOM_TYPE 客户类型
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVCustom getICustom( long aCUSTOM_ID, 
			String aCUSTOM_TYPE,
			String aREGION_ID ) throws RemoteException,Exception;
}
