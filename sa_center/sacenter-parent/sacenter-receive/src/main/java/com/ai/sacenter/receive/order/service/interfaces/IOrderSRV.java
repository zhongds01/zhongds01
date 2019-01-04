package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrderSRV {
	/**
	 * 根据开通消息转换为开通历史消息
	 * @param fromMBean 全局事务
	 * @param fromRequest 开通消息
	 * @param fromUpdcpm 开通接入能力
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVRocketExigence getSFMsgFHistory( MBeanDelegate fromMBean, 
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据开通消息转换为开通失败消息
	 * @param fromMBean 全局事务
	 * @param fromRequest 开通消息
	 * @param fromUpdcpm 开通接入能力
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVRocketExigence getSFMsgFFail( MBeanDelegate fromMBean, 
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
     * 开通定单接收[同步方式]
     * @param fromRequest 开通消息
     * @return
     * @throws SFException
     * @throws Exception
     */
	public IOVMsgFResponse orderReceive(IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
     * 开通定单接收[异步方式]
     * @param fromRequest 开通消息
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderReceiveAsyn(IOVRocketExigence fromRequest[]) throws SFException,Exception;
	/**
     * 开通定单接收异常转失败存储[异步方式]
     * @param fromRequest 开通定单
     * @param aEXCEPTION 业务类型
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderReceiveAsyn(IOVRocketExigence fromRequest[],
			SFException aEXCEPTION) throws SFException,Exception;
	/**
     * 开通定单接收历史储存[异步方式]
     * @param fromRequest 开通定单
     * @param aEXCEPTION 业务类型
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void orderCompleteAsyn(IOVRocketExigence fromRequest[],
			SFException aEXCEPTION) throws SFException,Exception;
	/**
	 * 开通定单分发调度
	 * @param fromMBean 全局事务
	 * @param fromRocketHome 开通定单
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromRocketHome, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 开通定单接收[异步方式]
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext 开通上下文
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderReceiveAsyn(IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据开通接入能力完成开通消息调度
	 * @param fromMBean 全局事务
	 * @param fromPentium 开通定单
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderDistribute( IOVMsgFRequest fromPentium,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通接入能力完成开通定单调度
	 * @param fromRequest 开通消息
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMsgFResponse orderDistribute(IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 开通消息转开通消息历史
	 * @param fromRequest   开通消费
	 * @param fromUpdcpm 开通接入
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void orderComplete( IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 开通消息转开通消息失败表
	 * @param fromRequest   开通消费
	 * @param fromUpdcpm 开通接入
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void orderException( IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
