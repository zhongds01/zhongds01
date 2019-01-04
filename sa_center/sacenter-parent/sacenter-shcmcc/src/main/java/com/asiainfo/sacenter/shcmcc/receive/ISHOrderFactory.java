package com.asiainfo.sacenter.shcmcc.receive;

import com.ai.sacenter.common.UpfsvcFactory;
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
public class ISHOrderFactory {
	public ISHOrderFactory(){
		super();
	}
	/**
     * 开通定单[内部服务]
     * @return
     * @throws Exception
     */
	public static IOrderSRV getIOrderSV() throws Exception{
		return (IOrderSRV)UpfsvcFactory.getService(IOrderSRV.class);
	}
}
