package com.ai.sacenter.core.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活核心服务</p>
 * <p>Copyright: Copyright (c) 2015年11月5日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcSV {
	/**
	 * 获取当前中心操作流水号
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException,Exception;
	
	/**
	 * 服务工单持久化到服务开通库[独立事务]
	 * @param fromUpdfmx 服务异步集
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderComplteAsyn( IOVUpdfmxOffer fromUpdfmx ) throws RemoteException,Exception;
}
