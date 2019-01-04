package com.ai.sacenter.core.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.util.ArrayUQList;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcDAO extends IUpdbmDAOLife {
	/***
	 * 获取流程任务编号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException,Exception;
	/**
	 * 获取新队列编号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getPLQK_ID() throws RemoteException,Exception;
	/**
	 * 获取当前定单编号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getOFFER_ID() throws RemoteException,Exception;
	/**
	 * 根据受理测订单号查询服务定单(在途单、失败单以及下周期单)
	 * @param aVM_ORDER_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFOrder( String aVM_ORDER_ID ) throws RemoteException,Exception;
	/**
	 * 根据定单项编号查询服务定单
	 * @param aORDER_ID 开通订单项编号
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( String aORDER_ID, long  aUSER_ID, String aREGION_ID ) throws RemoteException,Exception;
	/**
	 * 根据订单编号和流程任务查询即开即通订单
	 * @param fromTASK
	 * @param aORDER_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium getSFOrder( IOVTaskPentium fromTASK , 
			long aORDER_ID ) throws RemoteException,Exception;
	/**
	 * 根据流程任务查询即开即通订单
	 * @param aUpdswfLife
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFOrder( IOVTaskPentium fromTASK[] ) throws RemoteException,Exception;
	/**
	 * 根据服务群组定单查询该服务定单对应子服务定单
	 * @param fromGroup 服务群组定单
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderPentium[] getSFMember( IOVOrderPentium fromGroup ) throws RemoteException,Exception;
	/**
	 * 根据订单任务编号查询流程任务
	 * @param aTASK_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( long aTASK_ID ) throws RemoteException,Exception;
	/**
	 * 根据任务编号查询落地工单
	 * @param aTASK_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTaskFail( long aTASK_ID[] ) throws RemoteException,Exception;
	/**
	 * 根据队列查询流程任务工单
	 * @param fromQueue 服务队列
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( IOVQueuePentium fromQueue ) throws RemoteException,Exception;
	/**
	 * 根据批量调度队列查询批量流程订单任务
	 * @param fromQueue 服务队列
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVQueuePentium fromQueue[] ) throws RemoteException,Exception;
	/**
	 * 根据网元反馈查询流程订单任务
	 * @param fromUpfwm 网元反馈
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium getSFTask( IOVUpfwmOrder fromUpfwm ) throws RemoteException,Exception;
	/**
	 * 根据网元反馈查询流程订单任务
	 * @param fromUpfwm 网元反馈
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVUpfwmOrder fromUpfwm[] ) throws RemoteException,Exception;
	/**
	 * 根据流程订单查询流程订单任务
	 * @param fromOrder
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask( IOVOrderPentium fromOrder[] ) throws RemoteException,Exception;
	/**
	 * 根据流程订单查询流程订单任务
	 * @param fromOrder
	 * @param fromTASK
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] getSFTask(IOVOrderPentium fromOrder[] ,
			IOVTaskPentium[] fromTASK ) throws RemoteException,Exception;
	/**
	 * 根据当前队列为C查询已处理队列数据
	 * @param fromQueue 服务队列
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public ArrayUQList getSFQueue( ArrayUQList fromQueue ) throws RemoteException,Exception;
	
	/**
	 * 完成即开即通流程调度
	 * @param fromOrder
	 * @param fromTASK
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFOrder( IOVOrderPentium fromOrder[] , 
			IOVTaskPentium fromTASK[] ) throws RemoteException,Exception;
}
