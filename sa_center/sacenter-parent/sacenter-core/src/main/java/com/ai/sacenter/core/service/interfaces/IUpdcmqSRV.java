package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务队列服务</p>
 * <p>Copyright: Copyright (c) 2014-12-30</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcmqSRV {
	/**
	 * 创建激活定单任务发网元转重做队列[后台队列自动处理]
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVQueuePentium finishSFUpdcmqCreate( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务定单任务转服务队列调度中
	 * @param fromOrder 服务定单
	 * @param fromTASK 服务任务
	 * @param fromUpdfwm 服务指令集
	 * @param fromUpdcpm 服务队列组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcmqCreate( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务队列工单完成服务任务重操作网元组件
	 * @param fromQueue 服务队列工单
	 * @param fromUpdcpm 服务队列组件
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskActive(IOVQueuePentium fromQueue, 
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成服务队列工单到服务激活中
	 * @param fromMBean 激活全局事务
	 * @param fromUpdfmxHome 服务队列工单
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcmqComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpdfmxHome,
			IUpdcContext aContext ) throws SFException, Exception;
}
