package com.ai.sacenter.tykt.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: 网元激活内部服务</p>
 * <p>Copyright: Copyright (c) 2016年2月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISFUpfgkmSRV {
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmCreate(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmChange(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成服务开通测紧急复机
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 营业紧急复机工单
	 * @param aContext 额外信息
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmUrgency( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 服务开通测到统一开通测同步
	 * @param fromMBean 激活全局事务
	 * @param fromUpfgkmHome 网元索引单
	 * @param fromASK 额外信息
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws SFException, Exception;
}
