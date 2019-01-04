package com.ai.sacenter.receive.exigence.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通异步DB模式</p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExigenceSV {
	/**
	 * 完成开通定单异步服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromCouple 异步网元反馈
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
}
