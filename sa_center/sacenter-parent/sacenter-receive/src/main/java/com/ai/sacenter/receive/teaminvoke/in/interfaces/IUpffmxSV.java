package com.ai.sacenter.receive.teaminvoke.in.interfaces;

import java.rmi.RemoteException;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 网元工单接口服务</p>
 * <p>Copyright: Copyright (c) 2017年3月9日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpffmxSV {
	/**
	 * 获取开通定单编号
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getROCKET_ID() throws RemoteException,Exception;
}
