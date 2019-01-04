package com.asiainfo.sacenter.shcmcc.provision.dsmp;

import com.ai.sacenter.common.UpfsvcFactory;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.service.interfaces.ISFDsmapSRV;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ20ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IDsmapFactory {
	public IDsmapFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ISFDsmapSRV getIDsmapSV() throws Exception{
		return (ISFDsmapSRV)UpfsvcFactory.getService( ISFDsmapSRV.class );
	}
}
