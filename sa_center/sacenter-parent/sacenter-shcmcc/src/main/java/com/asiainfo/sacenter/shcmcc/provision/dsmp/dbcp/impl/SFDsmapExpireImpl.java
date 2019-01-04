package com.asiainfo.sacenter.shcmcc.provision.dsmp.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.DsmapFactory;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ20ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFDsmapExpireImpl extends IUpffmxCapitalImpl {

	public SFDsmapExpireImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl#finishSFUpfgkmExpire(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpdfmxOffer fromUpdfmx = DsmapFactory.getIDsmapDAO().getSFUpfgkmHome( fromUpfgkmHome );
			if( fromUpdfmx != null && fromUpdfmx.getORDER().getSUBFLOW().size() > 0 ){
				DsmapFactory.getIDsmapDAO().finish( fromUpdfmx.getORDER().getSUBFLOW() );
			}
		}
		finally{
		
		}
	}

}
