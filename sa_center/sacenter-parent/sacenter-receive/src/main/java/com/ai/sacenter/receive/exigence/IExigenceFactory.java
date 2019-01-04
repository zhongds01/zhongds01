package com.ai.sacenter.receive.exigence;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV;
import com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��4��26��</p>
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
	 * �첽����SV
	 * @return
	 * @throws Exception
	 */
	public static IExigenceSRV getIUpdcSV() throws Exception{
		return (IExigenceSRV)UpfsvcFactory.getService( IExigenceSRV.class );
	}
	
	/**
	 * �첽��������SV
	 * @return
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	
	/**
	 * �첽�������SV
	 * @return
	 * @throws Exception
	 */
	public static IUpdfmxSRV getIUpdfmxSV() throws Exception{
		return (IUpdfmxSRV)UpfsvcFactory.getService( IUpdfmxSRV.class );
	}
}
