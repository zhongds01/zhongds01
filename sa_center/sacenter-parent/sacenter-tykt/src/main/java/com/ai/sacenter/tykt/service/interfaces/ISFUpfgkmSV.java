package com.ai.sacenter.tykt.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 统一开通服务</p>
 * <p>Copyright: Copyright (c) 2014-12-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface ISFUpfgkmSV {
	/**
	 * 服务激活测到统一开通测同步
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元工单清单
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * 完成网元测异步反馈到服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromCouple 异步网元反馈
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * 完成服务开通测紧急复机
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 营业紧急复机工单
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmUrgency( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
}
