package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IUpfgkmUserHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 即开即通任务调度服务</p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ITaskSRV {
	/**
	 * 创建激活流程任务单
	 * @param fromOrder 服务定单
	 * @param fromOffer 服务产品订购
	 * @param fromUpdbm 服务流程规范
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium finishSFTaskCreate( IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
		    ISystemTemplate.IUpdbpmOffer fromUpdbm,
		    IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据流程订单查询当前流程订单服务属性清单
	 * @param fromOrder 服务定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFTaskOffer( IOVOrderPentium fromOrder ) throws SFException, Exception;
	/**
	 * 根据流程订单任务查询当前流程订单服务属性清单
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium  fromTASK,
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据流程订单任务查询当前流程订单服务属性清单
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium  fromTASK,
			IOVUpdspmLife fromUpdfwm,
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通任务获取当前开通任务对应开通用户
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmUserHome getSFUpfgkmUser( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 单个开通任务调度网元指令处理任务
	 * @param fromBWO 服务定单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium fromOrder,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 批量任务调度网元指令处理任务
	 * @param fromBWO 服务定单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium fromOrder[] ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 完成平台执行结果打包
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromASK 激活反馈集
	 * @param aEXCEPTION 激活异常
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskRespond( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 网元指令反馈到流程调度中
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromNetWork 网元反馈
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskChain(IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 网元指令反馈到流程调度中
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param aEXCEPTION  激活异常
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskChain( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 正常完成服务任务单
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 逻辑指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元应答集完成落地工单任务处理
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromASK 网元应答集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务异常完成服务任务调度
	 * @param fromOrder 服务定单
	 * @param fromTASK  服务任务
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务异常完成服务任务调度
	 * @param fromOrder 服务定单
	 * @param fromTASK  服务任务
	 * @param fromUpdfwm 逻辑指令集
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务异常完成人工跳单调度
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务异常完成异常回单调度
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成服务定单异常策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param aEXCEPTION 异常类型
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION ,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 完成服务定单任务依赖开通任务和开通产品订购
	 * @param fromOrder 服务定单
	 * @param fromDepend 服务定单全量单
	 * @param fromTASK 服务定单任务
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFTaskDepend( IOVOrderPentium fromOrder,
			IOVTaskPentium[] fromDepend , 
			IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 服务定单任务正常报竣归档
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务群组单完成服务成员单调度
	 * @param fromGroup 服务群组单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskGroup(IOVOrderPentium fromGroup, 
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成{服务网元级异常补偿机制}
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromASK 异常代码
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskNetWork( IOVOrderPentium fromOrder,
	    IOVTaskPentium fromTASK,
		IOVUpdspmLife fromUpdfwm,
		IOVUpfwmResponse fromASK,
		SFException aEXCEPTION,
		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据异常激活任务完成{服务网元级异常补偿机制}
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 网元补偿组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return 不为NULL则已补偿否则异常
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFTaskCompensa( IOVOrderPentium fromOrder,
	    IOVTaskPentium fromTASK,
		IOVUpdspmLife fromUpdfwm,
		IOVUpdcpmOffer fromUpdcpm,
		SFException aEXCEPTION,
		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据异常激活任务完成服务任务转抛异常策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成服务任务异常补偿报竣策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskIgnore( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成异常服务任务正常报竣策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成服务落地任务派单策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskHuman( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成异常转重做队列策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskQueue( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成异常回滚策略
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskRollBack( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常激活任务完成{异常转历史策略[服务异常策略]}
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令级
	 * @param fromUpdcpm 服务策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskHistory( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION ,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据异常派单组件完成默认派单类组件适配器
	 * @param fromOrder  服务订单
	 * @param fromTASK  服务订单任务
	 * @param fromUpdfwm  服务激活指令
	 * @param fromUpdcpm 异常派单组件
	 * @param aEXCEPTION 服务异常类
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdffwmOffer finishSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
