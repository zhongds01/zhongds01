package com.ai.sacenter.receive.teaminvoke.out.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通接收服务[外部服务]</p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcFSV {
	/**
	 * 开通定单异常失败归档[独立事务]
	 * @param fromRocket 开通定单
	 * @param aEXCEPTION 异常类型
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn(RocketFMessage fromRocket, SFException aEXCEPTION) throws SFException, Exception;
	/**
	 * 开通定单异常历史归档[独立事务]
	 * @param fromRocket 开通定单
	 * @param aEXCEPTION 异常类型
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketCompleteAsyn(RocketFMessage fromRocket, SFException aEXCEPTION) throws SFException, Exception;
	/**
	 * 
	 * @param fromUpfwm
	 * @param fromOffer
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderTransparent( IOVUpfwmOffer fromUpfwm,
			IOVUpffmxOffer fromOffer,
			IUpdcContext aContext ) throws RemoteException,Exception;
	/**
	 * 开通定单消息接收[同步消息][数据库连接异常则直接跑异常]
	 * @param fromRocket 开通定单消息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage orderReceive( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
     * 开通定单消息接收[异步方式][数据库连接异常则直接跑异常]
     * @param fromRocket 开通定单
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderReceiveAsyn(RocketFMessage fromRocket) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromUpfwm
	 * @param fromOffer
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketTransparent( IOVUpfwmOffer fromUpfwm,
			IOVUpffmxOffer fromOffer,
			IUpdcContext aContext ) throws RemoteException,Exception;
	/**
	 * 开通定单项接收[同步方式]
	 * @param fromRocket 开通定单
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketReceive(RocketFMessage fromRocket)  throws RemoteException,Exception;
	/**
     * 开通定单项接收[异步方式]
     * @param fromRocket 开通定单
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void rocketReceiveAsyn(RocketFMessage fromRocket)  throws RemoteException,Exception;
	/**
	 * 开通定单项归档[异步方式]
	 * @param fromRocket
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketCompleteAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * 开通订单项接收[异步入开通异步单]
	 * @param fromRocket 开通定单
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rabbitReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException, Exception;
	/**
	 * 服务定单任务转重做送网元
	 * @param aVM_ORDER_ID 外围订单号
	 * @param aTASK_ID 服务定单任务号
	 * @param aVM_ORG_ID 对应组织编号
	 * @param aVM_STAFF_ID 受理工号 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderTurnRedo( String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception;
	/**
	 * 服务定单任务人工跳单报竣
	 * @param aVM_ORDER_ID 外围订单号
	 * @param aTASK_ID 服务定单任务号
	 * @param aVM_REASON 人工跳单原因
	 * @param aVM_ORG_ID 对应组织编号
	 * @param aVM_STAFF_ID 受理工号 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderComplete( String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception;
	/**
	 * 服务定单任务异常回滚报竣
	 * @param aVM_ORDER_ID 外围订单号
	 * @param aTASK_ID 服务定单任务号
	 * @param aVM_REASON 人工跳单原因
	 * @param aVM_ORG_ID 对应组织编号
	 * @param aVM_STAFF_ID 受理工号 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderException( String aVM_ORDER_ID, 
			long aTASK_ID,
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID) throws RemoteException, Exception;
	/**
	 * 挂起服务激活落地定单
	 * @param aVM_ORDER_ID 服务订单
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 被挂起原因
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void suspendSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 激活服务激活落地定单
	 * @param aVM_ORDER_ID 服务订单
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 激活原因
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void resumeSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 服务激活落地定单撤单
	 * @param aVM_ORDER_ID 服务订单
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 撤单原因
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void cancelSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 查询离线记录信息
	 * IOpenApplicException    即开即通查询未处理完成
	 * IOpenRemoteException    即开即通远程处理异常
	 * IOpenException          即开即通[aVM_ORDER_ID]对应记录无效
	 * @param aVM_ORDER_ID
	 * @param aBILL_ID
	 * @param aADDIN_XML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getASKOrder( long aVM_ORDER_ID , 
			String aBILL_ID , 
			String aADDIN_XML ) throws RemoteException,Exception;
}
