package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 与开通接入能力对接</p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrdLdapSRV {
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFEffective( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	
	/**
	 * 
	 * @param fromUpdfmx
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFExpire( IUpdfmxExpire fromUpdfmx, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext ) throws SFException, Exception;
	
	/**
	 * 根据用户订单生成开通工单及订购关系(用户测依赖订购关系)
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通接入层
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFNature(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据用户订单生成主用户立即开通工单及订购关系[其成员下周期开通]
	 * @param fromRequest 开通工单
	 * @param fromUpdcpm 开通接入层
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFGroup( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMemberNature( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMemberEffective( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMemberExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFGroupEffective( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFGroupExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
}
