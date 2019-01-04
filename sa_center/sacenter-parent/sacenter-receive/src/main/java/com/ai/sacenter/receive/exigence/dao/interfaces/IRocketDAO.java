package com.ai.sacenter.receive.exigence.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.util.CarbonList;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê4ÔÂ26ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IRocketDAO extends IUpdbmDAOLife {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getOFFER_ID() throws RemoteException,Exception;
	/**
	 * 
	 * @param fromOrder
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVMocketExigence> getSFRocketPassage( CarbonList<IOVMocketExigence> fromOrder ) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromOrder
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public CarbonList<IOVMocketExigence> getSFRocketLimite( CarbonList<IOVMocketExigence> fromOrder ) throws RemoteException,Exception;
}
