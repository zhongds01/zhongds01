package com.ai.sacenter.provision.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmComplete;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单核心</p>
 * <p>Copyright: Copyright (c) 2013-4-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpfwmSRV {
	/**
	 * 根据服务定单任务生成网元工单开通串以及开通优先级
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxOffer finishSFUpfwmLifite(IOVOrderPentium fromOrder,
			IOVTaskPentium  fromTASK,
			IOVUpfwmOffer fromUpfwm,
	        IOVUpdspmLife  fromUpdfwm, 
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前网元映射组件完成流程级网元订购属性组件
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param fromUpdcpm 服务映射组件
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap finishSFUpfwmOffer( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据网元工单查询当前网元工单服务属性清单
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 流程任务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmRequest getSFUpfwmOffer(IOVUpfwmOffer fromUpfwm,
	        IOVUpdspmLife fromUpdfwm, 
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务任务单完成服务开通串流程级网元工单
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmOffer finishSFUpfwmCreate( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务任务单完成服务开通串流程级网元变化工单
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmOffer finishSFUpfwmChange( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前服务任务单完成服务开通串流程级网元工单(包含转网元历史工单和网元定单沉淀)
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务定单任务
	 * @param fromUpdfwm 激活指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmOffer finishSFUpfwmActive( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据服务定单任务完成与网元实时交互(包含网元历史工单和异常网元监控工单)
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 激活指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmSync(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 查询当前网元名单路由规则
	 * @param fromBILL 用户号码
	 * @param fromUpfm 服务网元
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpfwmUser( String fromBILL , 
			IPlatformTemplate.IUpffmOffer fromUpfm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务定单查询当前黑名单清单
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpfwmUser( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 查询网元调试反馈描述
	 * @param fromUpfm 网元信息
	 * @param fromUpdfm 网元指令信息
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public byte[] getSFUpfwmDebug( IPlatformTemplate.IUpffmOffer fromUpfm,
			IPlatformTemplate.IUpffmDirective fromUpdfm) throws SFException,Exception;	
	/**
	 * 完成服务定单异步表存储
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 完成网元工单归档处理
	 * @param fromUpfwm
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete( IOVUpfwmOffer fromUpfwm[] , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元工单完成正常报竣
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param fromASK 网元反馈集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据网元工单完成异常报竣
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param aEXCEPTION 网元异常集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据网元工单完成与网元实时交互
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmNetWork( IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 转重做队列策略[后台队列自动处理]
	 * @param fromUpfwm 网元工单
	 * @param aUpdspmLife 网元指令
	 * @param fromUpdcpm 异常策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmQueue( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 其他异常策略[异常工单归档]
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元指令
	 * @param fromUpdcpm 异常策略组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据网元工单完成网元应答沉淀(包含网元工单沉淀历史表)
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param fromASK 网元反馈集
	 * @param aEXCEPTION 网元异常集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmMonitor( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 网元回执单归档到服务工单历史表中
	 * @param fromMBean 激活全局事务
	 * @param fromUpfwm 网元工单清单
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory(IOVUpfwmComplete fromUpfwm, 
            IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * 完成网元测反馈单归档到服务激活历史表和服务网元反馈表
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元工单清单
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * 服务开通测实时同步到网元测
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmSync(IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * 完成服务网元工单到网元测激活
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元工单清单
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmNetWork(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws RemoteException, Exception;
}
