package com.ai.sacenter.receive.custom;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �ͻ������ڲ�����</p>
 * <p>Copyright: Copyright (c) 2016��3��23��</p>
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
	 * �ͻ������ڲ�����
	 * @return
	 * @throws Exception
	 */
	public static ICustomSRV getICustomSV() throws Exception{
		return (ICustomSRV)UpfsvcFactory.getService(ICustomSRV.class);
	}
}
