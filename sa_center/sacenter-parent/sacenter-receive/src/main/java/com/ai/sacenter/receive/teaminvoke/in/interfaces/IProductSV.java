package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmItemHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmMiscHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmServiceHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 与产品中心接口服务</p>
 * <p>Copyright: Copyright (c) 2016年6月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IProductSV {
	/**
	 * 根据产品编号查询产品单元
	 * @param aProductId
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmItemHome getProductItemById( long aProductId ) throws RemoteException,Exception; 
	/**
	 * 根据产品编号查询产品单元关联
	 * @param aProductId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmServiceHome getServiceByProdId( long aProductId )  throws RemoteException,Exception; 
	/**
	 * 根据产品编号查询产商品中心产品局数据
	 * @param aProductId 产品编号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmMiscHome getUpSpInfoByProdId( long aProductId ) throws RemoteException,Exception;
	/**
	 * 根据产品编号查询开通归属产品局数据
	 * @param aProductId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmMiscHome getSpInfoByProdId( long aProductId ) throws RemoteException,Exception;

}
