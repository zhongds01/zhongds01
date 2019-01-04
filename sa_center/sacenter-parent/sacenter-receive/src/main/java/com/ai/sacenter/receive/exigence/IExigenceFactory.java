package com.ai.sacenter.receive.exigence;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV;
import com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IExigenceFactory {
	public IExigenceFactory() {
		super();
	}
	
	/**
	 * 异步定单SV
	 * @return
	 * @throws Exception
	 */
	public static IExigenceSRV getIUpdcSV() throws Exception{
		return (IExigenceSRV)UpfsvcFactory.getService( IExigenceSRV.class );
	}
	
	/**
	 * 异步定单能力SV
	 * @return
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	
	/**
	 * 异步定单组件SV
	 * @return
	 * @throws Exception
	 */
	public static IUpdfmxSRV getIUpdfmxSV() throws Exception{
		return (IUpdfmxSRV)UpfsvcFactory.getService( IUpdfmxSRV.class );
	}
}
