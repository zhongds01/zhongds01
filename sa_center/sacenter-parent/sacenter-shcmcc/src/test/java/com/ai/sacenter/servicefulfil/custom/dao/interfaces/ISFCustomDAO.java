package com.ai.sacenter.servicefulfil.custom.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.custom.bo.InsOffer;
import com.ai.sacenter.receive.custom.bo.InsUser;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISFCustomDAO extends IUpdbmDAOLife{
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
	 * 根据用户编号查询用户策划信息
	 * @param aUSER_ID 用户编号 
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public InsOffer[] getIInsOfferByUserId(long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
}
