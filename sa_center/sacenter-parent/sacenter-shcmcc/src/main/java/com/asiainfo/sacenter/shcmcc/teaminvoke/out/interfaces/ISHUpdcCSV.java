package com.asiainfo.sacenter.shcmcc.teaminvoke.out.interfaces;

import java.rmi.RemoteException;

/**
 * 
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: 开通中心对外暴漏的csf服务</p>
 * <p>Copyright: Copyright (c) 2017年3月30日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISHUpdcCSV {


	/**
	 * 开通定单项接收[同步消息]
	 * @param fromMetaMX 开通定单消息
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public String orderReceive( String fromMetaMX ) throws RemoteException,Exception;
	
	/**
	 * 开通定单项归档[同步消息]
	 * @param fromMetaMX 开通归档信息
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public String orderComplete( String fromMetaMX ) throws RemoteException,Exception;


	/**
	 * 修改Radius系统用户速率接口
	 * @param velocity 速率    单个为下行速率   e.g 12M   两个下划线分割为上_下行速率 e.g  20M_1200M
	 * @param userName 登陆名 （bill_id）
	 * @return
	 * @throws Exception
	 */
	public String alterRadiusSpeed(String busiType, String userName, String velocity ) throws Exception;

	/**
	 * 修改radius系统账号状态
	 * @param opType 用户状态 0、正常；1、锁定；
	 * @param userName 登陆名 （bill_id）
	 * @return
	 * @throws Exception
	 */
	public String alterRadiusState(String busiType, String userName, String opType ) throws Exception;
}

	
