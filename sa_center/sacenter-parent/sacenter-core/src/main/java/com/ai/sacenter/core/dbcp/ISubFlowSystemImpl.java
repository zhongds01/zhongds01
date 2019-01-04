package com.ai.sacenter.core.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活工单适配器</p>
 * <p>Copyright: Copyright (c) 2014-8-20</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ISubFlowSystemImpl extends IUpdcpmCapitalImpl {

	public ISubFlowSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 异常派单类组件</p>
	 * <p>Copyright: Copyright (c) 2014-12-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmClaimCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmClaimCreateImpl(){
			super();
		}
		/**
		 * 根据服务定单任务完成异常派单类组件适配器
		 * @param fromOrder  服务订单
		 * @param fromTASK   服务订单任务
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
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdffwmOffer fromUpddgma = null;
			try
			{
				fromUpddgma = IUpdcFactory.getITaskSV().finishSFTaskClaim(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
			return fromUpddgma;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活异常策略组件</p>
	 * <p>Copyright: Copyright (c) 2014-8-20</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmSubFlowCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmSubFlowCreateImpl(){
			super();
		}
		/**
		 * 根据异常激活任务完成{转重做队列[后台队列自动处理]}
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUpdcpm 服务策略组件
		 * @param fromASK  异常反馈策略
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskQueue( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskQueue(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 根据异常激活任务完成{自动回滚[满足自动回滚条件]}
		 * @param fromOrder 服务定单
		 * @param fromTASK  服务任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUpdcpm 服务策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskRollBack( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskRollBack(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 根据异常激活任务完成{转抛异常[服务定单异常界面]}
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 激活指令级
		 * @param fromUpdcpm 服务策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskException( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskException(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 根据异常激活任务完成{转异常补偿[服务定单异常界面]}
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 激活指令级
		 * @param fromUpdcpm 服务策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskIgnore( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskIgnore(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 根据异常激活任务完成{正常报竣[满足正常报竣归档]}
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 激活指令级
		 * @param fromUpdcpm 服务策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskComplete( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 根据异常激活任务完成{人工落地[服务定单异常界面]}
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUpdcpm 服务策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskHuman( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskHuman(fromOrder, 
						fromTASK,
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 根据异常激活任务完成{异常转历史策略[服务异常策略]}
		 * @param fromOrder 服务定单
		 * @param fromTASK  服务任务
		 * @param fromUpdfwm 服务指令集
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
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务开通异常容错机制类组件</p>
	 * <p>Copyright: Copyright (c) 2016年8月30日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbmCompensaCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmCompensaCreateImpl(){
			super();
		}
		/**
		 * 空异常激活任务完成{服务网元级异常补偿机制}
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
		public Object finishSFTaskBlank( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			return null;
		}
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
		public Object finishSFTaskDefault( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			Object fromEnable = null;
			try
			{
				fromEnable = IUpdcFactory.getITaskSV().finishSFTaskCompensa(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
			return fromEnable;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活异常回滚类组件</p>
	 * <p>Copyright: Copyright (c) 2014-12-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmRollBackCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmRollBackCreateImpl(){
			super();
		}
		/**
		 * 根据服务定单任务完成空异常回滚类组件
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务定单任务
		 * @param fromUpdcpm 服务映射组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVTaskPentium[] finishSFTaskBlank(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			IOVTaskPentium fromBWK[] = null;
			try
			{
				
			}
			finally{
				
			}
			return fromBWK;
		}
		/**
		 * 根据服务定单任务完成异常回滚类组件
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务定单任务
		 * @param fromUpdcpm 服务映射组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVTaskPentium[] finishSFTaskRollBack(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			IOVTaskPentium fromBWK[] = null;
			try
			{
				fromBWK = IUpdcFactory.getIUpdbpmSV().finishSFUpdbmException(fromOrder, 
						fromTASK, 
						fromUpdcpm,
						aEXCEPTION,
						aContext);
			}
			finally{
				
			}
			return fromBWK;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务队列激活类组件</p>
	 * <p>Copyright: Copyright (c) 2014-12-30</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmQueueCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmQueueCreateImpl(){
			super();
		}
		/**
		 * 根据服务队列工单完成服务任务重操作网元组件
		 * @param fromQueue 服务队列工单
		 * @param fromUpdcpm 服务队列组件
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskActive(IOVQueuePentium fromQueue, 
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IUpdcFactory.getIUpdcmqSV().finishSFTaskActive(fromQueue, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
