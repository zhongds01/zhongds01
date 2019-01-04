package com.ai.sacenter.receive.expire.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 到期服务</p>
 * <p>Copyright: Copyright (c) 2018年3月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0
 */
public interface IExpireSV {
	/**
	 * 完成到期下周期批开
	 * @param fromMBean 事务句柄
	 * @param fromExpireHome 到期工单 
	 * @param fromASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpffxComplete( MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromExpireHome,
			java.util.HashMap fromASK) throws RemoteException, Exception;
}
