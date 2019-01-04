package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 与核心调用服务</p>
 * <p>Copyright: Copyright (c) 2014-5-21</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdosSRV {
	/**
	 * 查询流程控制消息适配
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdbmtcLife getSFUpdbmToken() throws SFException,Exception;
	/**
	 * 根据异常激活任务单查询当前服务任务单派单规范
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令级
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute getSFUpdbmClaim( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION ,
			IUpdcContext aContext ) throws SFException, Exception;
}
