package com.ai.sacenter.servicefulfil.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;


public interface ISFUpdcFSV {
	/**
	 * 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void transferRequire() throws RemoteException,Exception;
	/**
	 * 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void transferNewRequire() throws RemoteException,Exception;
	/**
	 * 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void transferException() throws RemoteException,Exception;
	/**
	 * 
	 * @param context
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void transferHistory(IUpdcContext context ) throws RemoteException,Exception;
}
