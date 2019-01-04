package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-5-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISystemSRV {
	/**
	 * 申请服务普通定单
	 * @param fromPentium 服务请求单
	 * @param fromUpdcpm 服务能力模板
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFOrder(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * 申请批量成员服务定单 
	 * @param fromPentium
	 * @param fromUpdcpm
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFBatch(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * 申请服务群组定单
	 * @param fromRequest 服务群组定单
	 * @param fromUpdcpm 服务群组能力
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFGroup(IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * 创建服务固网开通工单开通
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * 申请服务服务定单反馈
	 * @param fromRequest 服务定单反馈
	 * @param fromUpdcpm 开通能力
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderResponse fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * 申请撤销网元下周期单
	 * @param fromPentium 服务请求单
	 * @param fromUpdcpm 服务能力
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse cancelSFExpire( IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception;
	/**
	 * 挂起服务激活落地定单
	 * @param aVM_ORDER_ID 服务订单号
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 被暂停原因
	 * @param aADDIN_XML
	 * @throws SFException
	 * @throws Exception
	 */
	public void suspendSFOrder( String aVM_ORDER_ID , 
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws SFException,Exception;
	/**
	 * 激活服务激活落地定单
	 * @param aVM_ORDER_ID 服务订单号
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 激活原因
	 * @param aADDIN_XML
	 * @throws SFException
	 * @throws Exception
	 */
	public void resumeSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws SFException,Exception;
	/**
	 * 服务激活落地定单撤单
	 * @param aVM_ORDER_ID 服务订单
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 撤单原因
	 * @param aADDIN_XML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] cancelSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws SFException,Exception;
	/**
	 * 查询服务离线定单反馈
	 * IOpenApplicException 即开即通查询未处理完成
	 * IOpenSFException 即开即通远程处理异常
	 * IOpenException       即开即通[aVM_ORDER_ID]对应记录无效
	 * @param aVM_ORDER_ID  服务定单编号
	 * @param aBILL_ID 用户号码
	 * @param aADDIN_XML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getASKOrder( long aVM_ORDER_ID , 
			String aBILL_ID , 
			String aADDIN_XML ) throws SFException,Exception;
    /**
     * 根据服务定单完成单个服务定单调度[不带流程拆分规则]
     * @param fromOrder 开通工单
     * @param fromTASK 开通任务
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpfwm( IOVOrderPentium fromOrder , 
    		IOVTaskPentium fromTASK[],
			IUpdcContext aContext ) throws SFException,Exception;
    /**
     * 根据服务定完成批量服务定单调度[不带流程拆分规则]
     * @param fromOrder 服务定单
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpfwm( IOVOrderPentium fromOrder[] , 
			IUpdcContext aContext ) throws SFException,Exception;
    /**
     * 根据批量服务指令集完成服务定单任务调度
     * @param fromUpdbm 服务定单
     * @param fromUpdfm 服务指令集
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpfwm( java.util.Map fromUpdbm , 
			java.util.List fromUpdfm , 
			IUpdcContext aContext ) throws SFException,Exception;
    /**
	 * 根据服务指令集完成服务定单任务网元指令调度
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 通知网元数据在途(网元数据在内存中)处理
	 * 1.当服务定单任务异常回单，服务定单任务产生网元指令数据未提交到数据库时直接清除服务定单任务对应网元工单shujuu
	 * @param aINSTANCE 服务定单
	 * @param aUpdswfLife 服务定单任务
	 * @param aUpdspmLife 网元指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfmc( IOVOrderPentium aINSTANCE , 
			IOVTaskPentium aUpdswfLife , 
			IOVUpdspmLife aUpdspmLife , 
			IUpdcContext aContext )  throws SFException,Exception;
    /**
	 * 完成任务包含送网元操作
	 * @param fromTASK
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 完成任务不包含送网元操作
	 * @param aTASK_ID
	 * @param fromASK
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( long aTASK_ID ,
			IOVUpfwmResponse fromASK )  throws SFException,Exception;
	/**
	 * 根据网元应答结果完成当前服务激活任务调度
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromASK 网元应答集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder, 
		IOVTaskPentium fromTASK,
		IOVUpfwmResponse fromASK,
		IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据网元应答完成当前服务定单任务
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务指令集
	 * @param fromASK 网元应答集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK ,
			IUpdcContext aContext )  throws SFException,Exception;
	/**
	 * 根据网元应答异常报竣当前服务定单任务
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 服务指令集
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION ,
			IUpdcContext aContext )  throws SFException,Exception;
	/**
	 * 服务激活任务单转重做
	 * @param aTASK_ID 服务落地单编号
	 * @param aVM_ORG_ID 操作员所在组织编号
	 * @param aVM_STAFF_ID 操作员编号
	 * @param fromASK 其他服务参数
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskRedo(long aTASK_ID[],
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws SFException,Exception;
	/**
	 * 服务激活任务单人工报竣
	 * @param aTASK_ID 服务落地单编号
	 * @param aVM_REASON 人工跳单原因
	 * @param aVM_ORG_ID 操作员所在组织编号
	 * @param aVM_STAFF_ID 操作员编号
	 * @param fromASK 其他服务参数
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete(long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws SFException,Exception;
	/**
	 * 服务激活任务单异常回单
	 * @param aTASK_ID 服务落地单编号
	 * @param aVM_REASON 异常原因描述
	 * @param aVM_ORG_ID 操作员所在组织编号
	 * @param aVM_STAFF_ID 操作员编号
	 * @param fromASK 其他服务参数
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK) throws SFException,Exception;
}
