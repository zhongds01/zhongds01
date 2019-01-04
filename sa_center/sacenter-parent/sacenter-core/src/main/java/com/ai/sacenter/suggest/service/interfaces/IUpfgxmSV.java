package com.ai.sacenter.suggest.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务反馈服务接口</p>
 * <p>Copyright: Copyright (c) 2015年11月9日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgxmSV {
	/**
	 * 
	 * @param fromMBean
	 * @param fromUpfgkmHome
	 * @param fromASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgxmComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK) throws RemoteException, Exception;
}
