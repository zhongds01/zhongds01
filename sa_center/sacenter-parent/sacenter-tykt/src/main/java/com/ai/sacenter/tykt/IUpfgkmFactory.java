package com.ai.sacenter.tykt;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSRV;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê2ÔÂ17ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmFactory {
	public IUpfgkmFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ISFUpfgkmSRV getIUpfgkmSV() throws Exception{
		return (ISFUpfgkmSRV)UpfsvcFactory.getService( ISFUpfgkmSRV.class );
	}
}
