package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元方案能力服务</p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV {
	/**
	 * 根据网元定单查询当前网元级反馈规范
	 * @param fromUpfwm 网元定单
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond( IOVUpfwmOrder fromUpfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据网元定单查询当前网元级反馈规范
	 * @param fromUpfwm 网元定单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond( IOVUpfwmOrder fromUpfwm, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据网元反馈定单完成网元反馈归档类组件
	 * @param fromUpfwm 网元反馈单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmComplete( IOVUpfwmOrder fromUpfwm,
			IUpdcContext aContext ) throws SFException, Exception; 
	/**
	 * 根据网元定单通知类组件组件完成网元定单激活归档(网元定单反馈到服务激活中)
	 * @param fromUpfwm 网元定单
	 * @param fromUpdcpm 网元归档组件
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete( IOVUpfwmOrder fromUpfwm,
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据异常代码查询网元反馈策略[如逻辑异常则按照网元异常反馈策略,否则按照系统级异常转换为网元级异常]
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 激活指令
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond( IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				SFException aEXCEPTION,
			    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据网元定单调度类型查询网元异常策略组件
	 * @param fromUpfwm  网元工单
	 * @param fromUpdfwm 激活指令
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmException(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据网元工单完成网元异常策略组件
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务激活指令
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据当前服务任务获取当前用户号段对应网元局向
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务单
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdbpmOffice getSFUpfwmOffice( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据网元定单查询服务流程级网元订购主属性组件
	 * @param fromUpfwm 
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmMapping(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务流程查询服务流程级网元订购次属性组件
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfwmComposite(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据服务定单任务完成流程级网元订购属性组件
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 激活指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxOffer finishSFUpfwmOffer( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
}
