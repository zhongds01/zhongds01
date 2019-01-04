package com.ai.sacenter.base.competence.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年9月30日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface ICfgUpdcpmDAO extends IUpdbmDAOLife{
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdbfxBusines() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdbfxKernel() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdbfxCatalog() throws RemoteException,Exception;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcpmOffer()  throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcpmCatalog()  throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIProductOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIProductComptel() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIProductCatalog() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIComptelOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIComptelCatalog() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIComptelKernel() throws RemoteException,Exception; 
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdbpmOffer() throws RemoteException,Exception; 
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdbpmCatalog() throws RemoteException,Exception; 
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdpgmOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdpgmCatalog() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptOffer() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptCatalog() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptMapping() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptRollBack() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptCompensation() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptDistribute() throws RemoteException,Exception;
	/**
	 * 查询服务激活异常原因清单
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getIUpdcmptCausation() throws RemoteException,Exception;
}
