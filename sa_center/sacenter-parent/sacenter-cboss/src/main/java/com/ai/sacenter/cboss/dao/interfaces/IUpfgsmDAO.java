package com.ai.sacenter.cboss.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-26</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpfgsmDAO extends IUpdbmDAOLife{
	/**
	 * ������Ԫ����������ѯ��Ԫ���ڹ���
	 * @param fromUpfgkmHome
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmCityHome getSFNotifyPassage( IUpfgkmCityHome fromUpfgkmHome ) throws RemoteException, Exception;
	/**
	 * 
	 * @param fromUpfgkmHome
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpdfmxOffer getSFNotifyLimite( IUpfgkmCityHome fromUpfgkmHome ) throws RemoteException, Exception;
}
