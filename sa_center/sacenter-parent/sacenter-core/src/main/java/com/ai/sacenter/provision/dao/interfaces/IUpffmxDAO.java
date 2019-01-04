package com.ai.sacenter.provision.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元到期工单</p>
 * <p>Copyright: Copyright (c) 2017年3月6日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpffmxDAO extends IUpdbmDAOLife{
	/**
	 * 根据用户编号查询网元到期通知单
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmNotify[] getSFUpffmxHome( long aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据用户编号批量查询网元到期通知单
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmNotify[] getSFUpffmxHome( long aUSER_ID[], String aREGION_ID ) throws RemoteException,Exception;
}
