package com.ai.sacenter.receive.order.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年10月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUrgencySRV {
	/**
	 * 开通修复单分发调度
	 * @param fromMBean 全局事务
	 * @param fromUrgencyHome 紧急定单
	 * @param fromOther
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void urgencyReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUrgencyHome,
			IUpdcContext aContext ) throws SFException,Exception;
}
