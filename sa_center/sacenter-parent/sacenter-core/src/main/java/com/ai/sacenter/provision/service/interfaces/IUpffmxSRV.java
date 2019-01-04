package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元到期插件资产</p>
 * <p>Copyright: Copyright (c) 2017年2月25日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpffmxSRV {
	/**
	 * 网元到期停机资产[异步指令][服务开通资产]
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 服务指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmSuspend(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 网元到期复机资产[异步指令][服务开通资产]
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 服务指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmResume(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 网元到期变更资产[异步指令][服务开通资产]
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 服务指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmChange(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 网元到期转历史资产[异步指令][服务开通资产]
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 服务指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmHistory(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 网元到期转历史资产[异步指令][服务开通资产]
	 * @param fromMBean 全局事务
	 * @param fromUpfgkmHome 网元通知索引
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 按照到期网元通知索引完成网元下周期批开
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元通知索引
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgkmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 按照当前事务中完成到期用户下周期批开
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffmx( IUpdcContext aContext) throws SFException, Exception;
}
