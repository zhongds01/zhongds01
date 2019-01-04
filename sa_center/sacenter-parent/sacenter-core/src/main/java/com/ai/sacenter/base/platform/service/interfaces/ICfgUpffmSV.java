package com.ai.sacenter.base.platform.service.interfaces;

import java.rmi.RemoteException;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ6ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface ICfgUpffmSV {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmNetWork() throws RemoteException,Exception; 
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpfmxCatalog() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmOperate() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmOperateX() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmLogical()  throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmSubFlow()  throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmProtocol() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmOffice() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmPhone() throws RemoteException, Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmDebug() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getIUpffsmOffer( ) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromUpffsm
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void deployUpffsmOffer( java.util.HashMap fromUpffsm ) throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmMisc() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffxmOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmsOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpffmsCatalog() throws RemoteException,Exception;
}
