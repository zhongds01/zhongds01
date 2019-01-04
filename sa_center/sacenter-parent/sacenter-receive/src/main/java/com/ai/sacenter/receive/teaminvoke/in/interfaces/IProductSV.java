package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmItemHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmMiscHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmServiceHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���Ʒ���Ľӿڷ���</p>
 * <p>Copyright: Copyright (c) 2016��6��19��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IProductSV {
	/**
	 * ���ݲ�Ʒ��Ų�ѯ��Ʒ��Ԫ
	 * @param aProductId
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmItemHome getProductItemById( long aProductId ) throws RemoteException,Exception; 
	/**
	 * ���ݲ�Ʒ��Ų�ѯ��Ʒ��Ԫ����
	 * @param aProductId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmServiceHome getServiceByProdId( long aProductId )  throws RemoteException,Exception; 
	/**
	 * ���ݲ�Ʒ��Ų�ѯ����Ʒ���Ĳ�Ʒ������
	 * @param aProductId ��Ʒ���
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmMiscHome getUpSpInfoByProdId( long aProductId ) throws RemoteException,Exception;
	/**
	 * ���ݲ�Ʒ��Ų�ѯ��ͨ������Ʒ������
	 * @param aProductId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmMiscHome getSpInfoByProdId( long aProductId ) throws RemoteException,Exception;

}
