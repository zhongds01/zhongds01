package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务任务映射指令资产</p>
 * <p>Copyright: Copyright (c) 2015年10月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgsmCapitalImpl extends IUpfwmCapitalImpl {
	public IUpfgsmCapitalImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwmSync(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext);
		}
		finally{
		
		}
		return fromASK;
	}

}
