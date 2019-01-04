package com.ai.sacenter.cboss.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

public interface IUpfgsmSRV {
	/**
	 * 根据开通工单创建CBOSS测业务平台主动订购同步
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 开通指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通工单创建CBOSS测内容计费主动订购同步
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 开通指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgxmOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通工单创建CBOSS测全量用户状态同步
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 开通指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgsmStatus(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通工单创建CBOSS测用户品牌变化同步
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgsmBrand( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	
	/**
	 * 根据开通工单创建CBOSS测业务平台被动订购同步
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmPassive(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext)throws SFException, Exception;
	
	/**
	 * 根据开通工单创建CBOSS测内容计费被动订购同步
	 * @param fromOrder 开通工单
	 * @param fromTASK 开通任务
	 * @param fromUpdfwm 服务指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSUpfgxmPassive(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext)throws SFException, Exception;
	/**
	 * 
	 * @param fromUpfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap finishSFUpfgsmMisc( java.util.HashMap fromUpfwm, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 服务激活测到CBOSS测同步
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元索引单
	 * @param fromASK 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * 完成网元测异步反馈到服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 异步网元反馈
	 * @param aContext 额外信息
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws RemoteException, Exception;
	
}
