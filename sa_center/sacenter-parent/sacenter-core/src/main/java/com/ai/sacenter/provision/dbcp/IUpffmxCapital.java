package com.ai.sacenter.provision.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
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
public interface IUpffmxCapital {
	/**
	 * 完成指定网元挂起指定网元到期
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpfwm 网元工单
	 * @param fromUpfgkmHome 到期工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmSuspend( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成指定网元恢复指定网元到期
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpfwm 网元工单
	 * @param fromUpfgkmHome 到期工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmResume( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成指定网元到期[用户号码以及次计费号码]变更规则
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpfwm 网元工单
	 * @param fromUpfgkmHome 到期工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmChange( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成指定网元到期转历史规则
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpfwm 网元工单
	 * @param fromUpfgkmHome 到期工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成指定网元到期转历史规则
	 * @param fromMBean 全局事务
	 * @param fromUpfgkmHome 网元到期工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成指定网元到期批开
	 * @param fromMBean 全局事务
	 * @param fromUpfgkmHome 网元到期工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmExpire( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException,Exception;
}
