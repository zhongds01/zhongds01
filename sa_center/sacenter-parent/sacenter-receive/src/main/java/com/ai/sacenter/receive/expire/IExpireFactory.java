package com.ai.sacenter.receive.expire;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV;

/**
 * 
 * @author:HC
 * @date:2016��3��14��
 * @description:
 */
public class IExpireFactory {
	
	public IExpireFactory() {
		super();
	}
	/**
	 * ��ͨ����[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IExpireSRV getIExpireSV() throws Exception{
		return (IExpireSRV)UpfsvcFactory.getService(IExpireSRV.class);
	}
}
