package com.ai.sacenter.receive.order.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.OrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.util.UrgencyUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通修复单资产组件</p>
 * <p>Copyright: Copyright (c) 2016年10月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUrgencyCapitalImpl extends UpdcEclipseImpl implements IBusinesCapital {
	public IUrgencyCapitalImpl() {
		super();
	}
	/**
	 * IUpdbfsUrgFStrapImpl
	 * 紧急复机资产[开通修复单组件]
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIUrgFStrapImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpfwmOffer fromUpfwm = null;
		try
		{
			IOVMsgFUser fromOrdUser = null;
			fromOrdUser = fromRequest.getUSER( fromRequest.getUSER_ID() );
			fromUpfwm = UrgencyUtils.IUpfwm._wrap(fromRequest, 
					fromOrdUser,
					fromUpdcpm, 
					aContext);
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwmSync(fromUpfwm, 
					aContext);
		}
		finally{
			if( fromUpfwm != null ){ fromUpfwm = null; }
		}
		return fromASK;
	}
	/**
	 * IUpdbfsUrgFMsgFImpl
	 * 开通消息处理资产[开通修复单组件]
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIUrgFMsgFImpl( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		try
		{
			IOVRocketExigence fromRocket = null;
			fromRocket = OrderFactory.getIOrderDAO().getSFRocketByOrderId(Long.parseLong( fromRequest.getDONE_CODE()), fromRequest.getREGION_ID() );
			if( fromRocket != null ){
				IUpfgkmOfferHome fromUpdfcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
				if( fromUpdfcpm == null ){ 
					ExceptionFactory.throwServiceBus("IOS0011088", new String[]{ fromRocket.getCATALOG(), fromRocket.getBUSINESS() });
				}
				IOrderFactory.getIOrderSV().orderDistribute(fromRocket, 
						fromUpdfcpm, 
						aContext);
				IOrderFactory.getIOrderSV().orderComplete(fromRocket, 
						fromUpdfcpm, 
						null, 
						aContext);
			}
		}
		finally{
		
		}
		return fromASK;
	}
}
