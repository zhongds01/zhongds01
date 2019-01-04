package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务网元定单管理</p>
 * <p>Copyright: Copyright (c) 2014-4-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpffmSRV {
	/**
	 * 根据当前网元工单完成网元定单
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务激活指令
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据当前网元工单完成网元工单归档
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务激活指令
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmCreate( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据当前网元工单完成网元工单历史归档
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务激活指令
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 网元定单激活归档(网元定单反馈到服务开通中)
	 * @param fromMBean 全局事务
	 * @param fromCouple 网元定单反馈
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IOVUpfwmCouple fromCouple[],
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元反馈业务级策略完成[服务反馈单转历史[默认网元工单归档[删除服务定单反馈单和网元反馈单]]]
	 * @param fromPentium 服务反馈单
	 * @param fromUpdcpm 服务监控组件
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元反馈业务级策略完成[网元反馈单转网元失败单[服务定单异常界面[删除服务定单反馈单和网元反馈单]]]
	 * @param fromPentium 服务反馈单
	 * @param fromUpdcpm 服务监控组件
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元反馈业务级策略完成[反馈到服务定单[满足服务定单]]
	 * @param fromPentium 服务反馈单
	 * @param fromUpdcpm 服务归档组件
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 服务定单反馈处理异常竣工[服务定单反馈单转失败表,网元工单转网元工单失败表,删除服务定单反馈单和网元反馈单]
	 * @param fromPentium 服务反馈单
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException( IOVUpfwmOrder fromPentium,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION, 
			IUpdcContext aContext ) throws SFException,Exception;
}
