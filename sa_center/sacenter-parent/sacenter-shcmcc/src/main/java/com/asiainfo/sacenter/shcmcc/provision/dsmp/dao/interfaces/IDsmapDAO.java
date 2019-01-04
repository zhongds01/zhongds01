package com.asiainfo.sacenter.shcmcc.provision.dsmp.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ20ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IDsmapDAO extends IUpdbmDAOLife {
	/**
	 * 
	 * @param fromUpfgkmHome
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpdfmxOffer getSFUpfgkmHome( IUpfgkmCityHome fromUpfgkmHome ) throws RemoteException, Exception;
}
