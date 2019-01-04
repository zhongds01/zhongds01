package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户到期工单处理</p>
 * <p>Copyright: Copyright (c) 2017年3月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExpireSRV {
	/**
	 * 根据开通定单订购完成到期用户开通
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单订购完成服务产品下周期开通[下周期开通和本周期开通]
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单订购完成服务产品全部立即开通
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdEffective(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通用户订购完成全量下周期[下周期开通]订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前用户删除下周工单以及其下周期工单订购
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通主用户
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserHistory(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据当前用户删除下周工单以及其下周期工单订购[其成员下周期对应服务产品退订]
	 * @param fromRequest 开通定单
	 * @param fromGroup 开通主用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFGroupHistory( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromGroup,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
}
