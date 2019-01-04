package com.ai.sacenter.receive.teaminvoke.out.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 外部调用服务/对接CSF</p>
 * <p>Copyright: Copyright (c) 2017年3月6日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcCSV {
	/**
	 * 开通定单消息接收[同步消息]
	 * @param fromRocket 开通定单
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage orderReceive( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * 开通定单消息接收[异步消息]
	 * @param fromRocket 开通定单消息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * 开通定单项接收[同步消息]
	 * @param fromRocket 开通定单消息
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public RocketFRsRspMessage rocketReceive( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * 开通定单项接收[异步消息]
	 * @param fromRocket 开通定单消息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn( RocketFMessage fromRocket ) throws RemoteException,Exception;
	/**
	 * 开通订单项归档[异步消息]
	 * @param fromRocket 开通归档信息
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
	
}
