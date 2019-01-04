package com.ai.sacenter.core.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdwfSRV {
	/**
	 * 创建服务定单[不带服务定单存储]
	 * @param fromRequest 开通定单
	 * @param fromUSER   开通用户
	 * @param fromGROUP  开通用户所属群组
	 * @param aCOMPETENCE 服务能力集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium createSFOrder( IOVOrderRequest fromRequest,
			IOVOrderUser fromUSER,
			IOVOrderUser fromGROUP,
			IProfessionalTemplate.ICompetenceOffer aCOMPETENCE, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 创建群组成员定单[不带服务定单存储]
	 * @param fromRequest 开通定单
	 * @param fromMEMBER 成员用户
	 * @param fromGROUP 群组用户
	 * @param aCOMPETENCE 群组能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] createSFOrder( IOVOrderRequest fromRequest,
			IOVOrderUser fromMEMBER[],
			IOVOrderUser fromGROUP,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据受理测订单号查询服务定单(在途单、失败单以及下周期单)
	 * @param aVM_ORDER_ID
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFOrder( String aVM_ORDER_ID ) throws SFException,Exception;
	/**
	 * 根据定单项编号查询服务定单
	 * @param aORDER_ID 开通订单项编号
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( String aORDER_ID, long  aUSER_ID, String aREGION_ID ) throws SFException,Exception;
	/**
	 * 根据订单编号查询即开即通订单信息
	 * @param aORDER_ID 服务定单号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( long aORDER_ID ) throws SFException,Exception;
	/**
	 * 根据订单编号查询即开即通订单信息
	 * @param fromTASK 服务定单任务
	 * @param aORDER_ID 服务定单号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( IOVTaskPentium fromTASK ,
			long aORDER_ID   ) throws SFException,Exception;
	/**
	 * 根据服务群组定单查询该服务定单对应子服务定单
	 * @param fromGroup 服务群组定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFMember( IOVOrderPentium fromGroup ) throws SFException,Exception;
	/**
	 * 根据订单任务编号查询订单任务信息
	 * @param aTASK_ID
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( long aTASK_ID ) throws SFException,Exception;
	/**
	 * 查询流程落地流程任务
	 * @param aTASK_ID
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskFail( long aTASK_ID[] ) throws SFException,Exception;
	/**
	 * 根据网元定单查询服务定单任务
	 * @param fromUpfwm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( IOVUpfwmOrder fromUpfwm ) throws SFException,Exception;
	/**
	 * 根据网元定单查询服务定单任务
	 * @param fromUpfwm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVUpfwmOrder fromUpfwm[] ) throws SFException,Exception;
	/**
	 * 根据服务队列查询服务定单任务
	 * @param fromQueue 服务队列
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask(IOVQueuePentium fromQueue) throws SFException,Exception;
	/**
	 * 根据订单编号查询服务(非副本)任务单列表信息
	 * @param fromOrder 服务定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * 根据订单编号查询服务(副本)任务单列表信息
	 * @param fromOrder 服务定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskControl( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * 根据服务定单查询线程变量上待调度网元服务任务单
	 * @param fromOrder 服务定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskCreate( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * 根据订单编号查询异常任务单
	 * @param fromOrder
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskFailure( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * 根据服务定单查询服务定单反馈任务
	 * @param fromOrder 服务定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskReply( IOVOrderPentium fromOrder ) throws SFException,Exception;
	/**
	 * 根据服务任务单查询服务被依赖服务任务单
	 * @param fromOrder 服务订单
	 * @param fromTASK 服务依赖任务单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTaskDepend( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK ) throws SFException,Exception;
	/**
	 * 查询流程对应流程任务并合并流程任务
	 * @param fromBWO
	 * @param fromTASK
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVOrderPentium fromBWO , 
			IOVTaskPentium fromTASK[] ) throws SFException,Exception;
	
	/**
	 * 
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrder( IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 创建服务开通普通工单
	 * @param fromRequest
	 * @param fromBusines
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium applySFOrder( IOVOrderRequest fromRequest, 
			IProfessionalTemplate.ICompetenceBusines fromBusines,
			IUpdcContext aContext ) throws SFException,Exception;
	
	/**
	 * 创建服务开通成员工单开通(连带成员工单开通)
	 * @param fromRequest 开通定单
	 * @param fromBusines 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] applySFBatch(IOVOrderRequest fromRequest,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext) throws SFException, Exception;
	
	/**
	 * 创建服务开通群组工单开通(连带成员工单开通)
	 * @param fromRequest 开通定单
	 * @param fromBusines 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium applySFGroup( IOVOrderRequest fromRequest , 
			IProfessionalTemplate.ICompetenceBusines fromBusines,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 创建服务固网开通工单开通
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium[] applySFCentrex( IOVOrderRequest fromRequest, 
			IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 创建服务开通异常工单
	 * @param fromOrder 被回滚工单
	 * @param fromTASK 被回滚任务单
	 * @param fromUpdfmx 回滚任务单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderPentium applySFRollBack( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVTaskPentium fromUpdfmx[],
			IUpdcContext aContext ) throws SFException,Exception;
}
