package com.ai.sacenter.base.basic.service.interfaces;

import java.rmi.RemoteException;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IBaseSV {
	/**
	 * 获取操作批次号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getDONE_CODE() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.sql.Timestamp getSysdate() throws RemoteException, Exception;
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public int retrieveCount(ObjectType fromTYPE, 
			String fromCond,
			java.util.HashMap fromPARAM) throws RemoteException, Exception;
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @param fromCol
	 * @param startRowIndex
	 * @param endRowIndex
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public DataStructInterface[] retrieve ( ObjectType fromTYPE , 
			String fromCond, 
			java.util.HashMap fromPARAM, 
			String fromCol[],
			int startRowIndex , 
			int endRowIndex ) throws RemoteException, Exception;
	/**
	 * 
	 * @param fromContain
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finish( DataContainerInterface fromContain[] ) throws RemoteException,Exception;
}
