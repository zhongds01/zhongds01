package com.ai.sacenter.suggest.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务反馈内部服务</p>
 * <p>Copyright: Copyright (c) 2014-12-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgxmSRV {
	/**
	 * 根据当前服定单务完成服务阶段通知
	 * @param fromOrder 服务定单
	 * @param fromTASK  服务定单任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK[],
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务任务完成服务阶段通知
	 * @param fromOrder 服务定单
	 * @param fromTASK  服务定单任务
	 * @param aEXCEPTION 异常类型(为NULL则成功，否则异常完成)
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务阶段单完成外部阶段通知
	 * @param fromMBean
	 * @param fromUpfgkmHome
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgxmComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception;
}
