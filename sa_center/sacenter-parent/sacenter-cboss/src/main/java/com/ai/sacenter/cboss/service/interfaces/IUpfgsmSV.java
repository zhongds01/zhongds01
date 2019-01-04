package com.ai.sacenter.cboss.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: CBOSS服务</p>
 * <p>Copyright: Copyright (c) 2014-12-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgsmSV {
	/**
	 * 服务激活测到CBOSS测同步
	 * @param fromMBean 激活全局事务
	 * @param fromINDEX 网元索引单
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
	/**
	 * 完成网元测异步反馈到服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 异步网元反馈
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			java.util.HashMap fromASK ) throws RemoteException, Exception;
}
