package com.ai.sacenter.receive.exigence.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通异步定单内部服务</p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExigenceSRV {
	/**
	 * 开通定单分发调度
	 * @param fromExigence 开通定单分发调度
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketDistribute( IOVMsgFExigence fromExigence,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 开通异步定单[批量]发调度
	 * @param fromMBean 全局事务
	 * @param fromUpfgkmHome 开通定单项
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 开通定单项接收[同步方式]
	 * @param fromExigence 开通定单项
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketReceive( IOVMsgFExigence fromExigence ) throws SFException,Exception;
	/**
	 * 开通定单项接收[异步方式]
	 * @param fromExigence 开通定单项
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn( IOVMsgFExigence fromExigence[] ) throws SFException,Exception;
	/**
     * 开通定单接收异常[异步方式]
     * @param fromExigence 开通定单
     * @param aEXCEPTION 业务类型
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void rocketReceiveAsyn(IOVMsgFExigence fromExigence[], SFException aEXCEPTION) throws SFException,Exception;
	/**
	 * 开通定单项归档[异步方式]
	 * @param fromRocket 开通异步反馈
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketComplete( IOVMocketRespone fromRocket ) throws SFException,Exception;
	/**
	 * 开通订单项接收[异步入开通异步单]
	 * @param fromExigence 开通定单
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rabbitReceiveAsyn( IOVMocketExigence fromExigence[] ) throws SFException, Exception;
}
