package com.ai.sacenter.receive.order.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrderDAO extends IUpdbmDAOLife {
	/**
	 * 
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID( )throws RemoteException,Exception;
	/**
	 * 
	 * @param aORDER_ID
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVRocketExigence getSFRocketByOrderId( long aORDER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据UserId查询持久化开通请求消息
	 * @param aUSER_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVRocketExigence[] getSFRocketByUserId(long aUSER_ID) throws RemoteException,Exception;
	/**
	 * 根据开通定单查询开通定单所属同组用户定单
	 * @param fromDispatch
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.List<IOVRocketExigence> getSFRocketDispatch(java.util.List<IOVRocketExigence> fromDispatch)throws RemoteException,Exception;
}
