package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IOrderRsRspHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 解决方案服务</p>
 * <p>Copyright: Copyright (c) 2014-4-8</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV {
	/**
	 * 根据服务定单查询当前异常服务定单派单策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 网元指令集
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return 派单策略数组(0派单策略组件1派单策略规范)
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskClaim( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据服务激活落地派单策略实现落地工单派单
	 * @param fromOrder  服务定单
	 * @param fromTASK   服务定单任务
	 * @param fromUpdfwm 网元指令集
	 * @param aEXCEPTION 服务异常类
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdffwmOffer finishSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据服务定单任务查询当前服务定单任务异常补偿组件
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromNetWork 网元反馈集
	 * @param aEXCEPTION 激活异常
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskCompensa(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成服务激活定单任务异常补偿机制
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromNetWork 网元反馈集
	 * @param aEXCEPTION 激活异常
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFTaskNetWork( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据服务定单任务查询当前框架级反馈策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param aEXCEPTION 激活异常
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse getSFTaskRespond(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据网元反馈代码转换为服务开通反馈代码
	 * @param fromTASK 服务工单
	 * @param fromUpdfwm 激活指令集
	 * @param fromNetWork 网元反馈集
	 * @param aEXCEPTION 激活异常
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse getSFTaskRespond( Object fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据外部反馈转换服务开通反馈
	 * @param fromRequest 外部反馈
	 * @param fromUpdcpm 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOrderRsRspHome getSFTaskExtend( IOVOrderResponse fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据服务定单任务查询服务定单异常策略组件
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务指令集
	 * @param aEXCEPTION 激活异常
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskException( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据服务定单任务完成服务定单异常策略组件
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务指令集
	 * @param aEXCEPTION 激活异常
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据服务队列查询当前服务队列激活组件策略
	 * @param fromQueue 服务队列
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpdcmqComplete( IOVQueuePentium fromQueue,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务队列工单完成当前服务队列报竣
	 * @param fromQueue 服务队列工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcmqComplete( IOVQueuePentium fromQueue,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据当前异常服务任务查询服务任务异常回滚组件
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前异常服务订单任务完成服务订单异常回滚组件
	 * @param fromOrder 服务定单
	 * @param fromTASK  服务定单任务
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFTaskRollBack( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
