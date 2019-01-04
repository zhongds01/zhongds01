package com.ai.sacenter.receive.custom;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 客户中心内部服务</p>
 * <p>Copyright: Copyright (c) 2016年3月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ICustomFactory {
	public ICustomFactory(){
		super();
	}
	/**
	 * 客户中心内部服务
	 * @return
	 * @throws Exception
	 */
	public static ICustomSRV getICustomSV() throws Exception{
		return (ICustomSRV)UpfsvcFactory.getService(ICustomSRV.class);
	}
}
