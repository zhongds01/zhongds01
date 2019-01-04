package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通订购服务</p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrdOfferSRV {
	/**
	 * 根据开通定单用户生成基于定单模型网元依赖订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserDepend(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据基于开通定单订购关系生成网元订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdNature(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单用户生成基于定单模型订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdExpire( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单用户生成基于定单模型订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOrdEffective( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据基于用户模型订购生成网元订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFNature(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单用户生成具备下周期开通工单以及订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通工单用户
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFExpire( IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单用户生成立即开通工单以及订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通定单用户
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFEffective( IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
}
