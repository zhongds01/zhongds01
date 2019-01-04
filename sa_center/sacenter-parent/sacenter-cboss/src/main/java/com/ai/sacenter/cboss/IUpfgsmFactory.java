package com.ai.sacenter.cboss;

import com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV;
import com.ai.sacenter.common.UpfsvcFactory;


/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ23ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgsmFactory {

	public IUpfgsmFactory() {
		super();
	}
	/**
	 * @return
	 * @throws Exception 
	 */
	public static IUpfgsmSRV getIUpfgsmSV() throws Exception{
		return (IUpfgsmSRV)UpfsvcFactory.getService(IUpfgsmSRV.class);
	}

}
