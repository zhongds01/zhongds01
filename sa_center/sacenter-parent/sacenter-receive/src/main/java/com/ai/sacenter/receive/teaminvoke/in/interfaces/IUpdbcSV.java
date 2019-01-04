package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于独立事务服务</p>
 * <p>Copyright: Copyright (c) 2017年3月6日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdbcSV {
	/**
	 * 根据开通定单完成开通定单异步事务归档
	 * @param fromMBean 全局事务
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通接入能力
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderCompleteAsyn( MBeanDelegate fromMBean, 
			IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * 根据开通定单完成开通定单异步事务归档
	 * @param fromMBean 全局事务
	 * @param fromExigence 开通定单
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rocketCompleteAsyn( MBeanDelegate fromMBean, 
			IOVMsgFExigence fromExigence,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws RemoteException, Exception;
}
