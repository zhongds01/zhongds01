package com.ai.sacenter.teaminvoke.in.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 后台进程服务</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdbcSV {
	/**
	 * 完成网元测异步反馈到服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元回执单
	 * @param aCfgTf 转移进程配置
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * 完成服务网元工单到网元测激活
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元工单清单
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmNetWork(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * 完成服务队列工单到服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromUpdfmxHome 服务队列工单
	 * @param fromASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpdcmqComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpdfmxHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * 按照到期网元通知索引完成网元下周期批开
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元通知索引
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK) throws RemoteException, Exception;
}
