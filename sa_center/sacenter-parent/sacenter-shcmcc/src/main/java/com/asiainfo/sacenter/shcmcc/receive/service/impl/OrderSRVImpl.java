package com.asiainfo.sacenter.shcmcc.receive.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.asiainfo.sacenter.shcmcc.receive.service.interfaces.IOrderSRV;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年6月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OrderSRVImpl implements IOrderSRV {
	public OrderSRVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.asiainfo.sacenter.shcmcc.receive.service.interfaces.IOrderSRV#getSFMsgFCentrex(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMsgFCentrex(IOVMsgFExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFCentrexImpl{
				public SFMsgFCentrexImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFSubject(IOVRocketExigence fromOrder,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromRequest = UpdbfsUtils.ICustom._wrap(fromOrder, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromRequest, fromUpffmx.getCENTREX(), fromUpdcpm);
						try
						{
							//测试通过待代码复查
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw exception;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFCentrexImpl fromCentrexImpl = new SFMsgFCentrexImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFExigence.IMsgFOfferXHome fromOrderHome = fromRequest.getORDER();
				UpdbfsUtils.ICustom._wrap(fromOrderHome.getROCKET(), 
						fromUpffmx, 
						fromUpdcpm);
				for( java.util.Iterator itera = fromOrderHome.getORDER().iterator(); itera.hasNext(); ){
					IOVRocketExigence fromOrder = (IOVRocketExigence)itera.next();
					fromCentrexImpl.finishSFMsgFSubject(fromOrder, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromCentrexImpl != null ){ fromCentrexImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
}
