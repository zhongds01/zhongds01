package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元消息接口服务</p>
 * <p>Copyright: Copyright (c) 2013-5-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdfmxSRV {
	/**
	 * 网元工单与网元交易沉淀到当前网元事务中
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元指令集
	 * @param fromTYPE  消息类型
	 * @param fromASK  交易消息
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmMonitor( IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm,
			String fromTYPE,
	        Object fromASK,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 沉淀网元工单交易日志[独立事务]
	 * @param fromUpfwm  网元工单
	 * @param fromUpdfwm 流程任务指令集
	 * @param fromASK 网元反馈集
	 * @param aEXCEPTION  网元异常消息
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmUatmix( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK,
			java.lang.Exception aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 沉淀网元工单交易日志[独立事务]
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 沉淀网元工单交易日志[独立事务]
	 * @param fromUpdfmx[IOVUpfwmUatmix] 交易对象
	 * @throws SFException 异常类型
	 * @throws Exception
	 */
	public void finishSFUpfwmUatmix( IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception;
}
