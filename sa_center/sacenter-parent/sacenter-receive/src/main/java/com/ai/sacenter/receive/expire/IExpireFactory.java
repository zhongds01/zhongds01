package com.ai.sacenter.receive.expire;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV;

/**
 * 
 * @author:HC
 * @date:2016年3月14日
 * @description:
 */
public class IExpireFactory {
	
	public IExpireFactory() {
		super();
	}
	/**
	 * 开通到期[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IExpireSRV getIExpireSV() throws Exception{
		return (IExpireSRV)UpfsvcFactory.getService(IExpireSRV.class);
	}
}
