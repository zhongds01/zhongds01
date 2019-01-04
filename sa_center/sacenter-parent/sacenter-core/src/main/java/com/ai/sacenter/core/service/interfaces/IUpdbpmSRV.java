package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 激活流程调度</p>
 * <p>Copyright: Copyright (c) 2013-12-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdbpmSRV {
	/**
	 * 根据服务流程配置构造当前服务流程拆分订购清单
	 * @param fromOrder 服务定单
	 * @param fromUpdbm 服务流程
	 * @param fromUpdcpm 服务产品集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpdbmOffer( IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务工单获取当前网元号段局向规范
	 * @param fromOrder 服务工单
	 * @param fromUpdbm 服务流程
	 * @param fromUpdcpm 服务能力集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdbpmOffice getSFUpdbpmOffice(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm, 
            IOVUpdbpmOffer fromUpdcpm, 
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据流程模板编号查询激活流程定义
	 * @param aWORKFLOW 服务激活流程
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IUpdbpmOffer getSFUpdbmBpel( String aWORKFLOW ) throws SFException,Exception;
	/**
	 * 根据定单任务查询流程任务定义
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbpmOffer getSFUpdbmBpel( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext )  throws SFException,Exception;
	/**
	 * 完成服务激活定单任务串行关系
	 * @param fromOrder
	 * @param fromUpdbpm
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbmDepend( IOVOrderPentium fromOrder , 
			java.util.List fromUpdbpm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务定单按照服务激活流程拆分服务任务单
	 * @param fromOrder 服务定单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
     * 根据流程订单完成服务定单流程调度[开通工单拆分规则]
     * @param fromOrder 服务定单
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpdbpm( IOVOrderPentium fromOrder[] , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据流程编号拆分调度工单
	 * @param fromOrder 服务定单
	 * @param fromOffer 服务产品订购
	 * @param aWORKFLOW 服务激活流程
	 * @param fromUpdcpm 服务能力集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbm( IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			String aWORKFLOW,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据当前异常服务订单任务完成服务订单异常回滚组件
	 * @param fromOrder 服务定单
	 * @param fromTASK  服务定单任务
	 * @param fromUpdcmpt 异常回单组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmException( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IOVUpdcpmOffer fromUpdcmpt,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务任务单拆分服务工单级异常补偿任务单
	 * @param fromOrder 服务定单
	 * @param fromTASK 激活任务单
	 * @param fromUpdcpm 异常补偿组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmCompensate( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据当前服务定单任务拆分异常回滚任务单
	 * @param fromOrder 服务定单
	 * @param fromTASK 激活任务单
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmRollBack( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据流程订单和流程任务配置生成流程订单任务
	 * @param fromOrder 服务定单
	 * @param fromOffer 服务产品订购
	 * @param fromUpdbm 流程任务配置
	 * @param fromUpdcpm 服务流程订购
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm, 
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据流程模板调度生成流程订单任务清单
	 * @param fromOrder 服务定单
	 * @param fromUpdbpm 流程模板
	 * @param fromUpdcpm 服务流程订购
	 * @param fromINDEX 服务索引
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
    		IProfessionalTemplate.IUpdbpmOffer fromUpdbpm,
    		IOVUpdbpmOffer fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据开通订购完成开通网元拆分
	 * @param fromOrder 服务订单
	 * @param fromOffer 服务订购
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
    		IOVOfferPentium fromOffer,
    		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 沉淀流程级属性到线程变量中
	 * @param fromOrder 服务定单
	 * @param fromUpdbm 激活流程规范
	 * @param fromUpdcpm 服务流程订购
	 * @param fromUpdspm 流程级属性
	 * @param fromVariable 流程级变量
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbmOffer(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			java.util.Map fromUpdspm,
			Object fromVariable[][],
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据服务激活流程任务规范完成激活流程任务普通拆分匹配[服务激活流程拆分]
	 * @param fromOrder  服务定单
	 * @param fromOffer  服务产品订购
	 * @param fromUpdbm 流程任务规则
	 * @param fromUpdcpm 服务流程订购
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmDefault(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm, 
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据服务激活流程任务规范完成激活子流程拆分匹配[服务激活流程拆分]
	 * @param fromOrder 服务定单
	 * @param fromOffer 服务产品订购
	 * @param fromUpdbm 流程任务规则
	 * @param fromUpdcpm 服务流程订购
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmSubFlow(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据服务激活流程任务规范完成激活逻辑其他局向拆分匹配[服务激活流程拆分]
	 * @param fromOrder 服务定单
	 * @param fromOffer 服务产品订购
	 * @param fromUpdbm 流程任务规则
	 * @param fromUpdcpm 服务流程订购
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmOffice(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
}
