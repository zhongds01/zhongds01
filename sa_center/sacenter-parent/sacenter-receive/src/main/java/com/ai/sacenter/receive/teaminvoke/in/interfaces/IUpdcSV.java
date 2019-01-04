package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单接收[内部服务]</p>
 * <p>Copyright: Copyright (c) 2018年1月5日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0
 */
public interface IUpdcSV {
	/**
	 * 开通定单分发调度
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单
	 * @param fromOther
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromRocket, 
			java.util.HashMap fromOther) throws RemoteException,Exception; 
	/**
	 * 开通修复单分发调度
	 * @param fromMBean 全局事务
	 * @param fromUrgency 开通修复单
	 * @param fromOther
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void urgencyReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUrgency, 
			java.util.HashMap fromOther) throws RemoteException,Exception; 
}
