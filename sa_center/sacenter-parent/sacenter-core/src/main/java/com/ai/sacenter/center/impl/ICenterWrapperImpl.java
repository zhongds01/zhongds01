package com.ai.sacenter.center.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.center.ICenterWrapper;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 中心转换空实现</p>
 * <p>Copyright: Copyright (c) 2015年6月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ICenterWrapperImpl implements ICenterWrapper {
	protected final static Log log = LogFactory.getLog( ICenterWrapperImpl.class );
	public ICenterWrapperImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.center.ICenterWrapper#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
	 */
	public SFCenterOffer wrapper(Object fromCENTER, 
			SFCenterCatalog fromCatalog,
			IUpdcContext fromLDAP) throws SFException, Exception {
		SFCenterOffer fromOffer = null;
		try
		{
			fromOffer = CenterUtils.ICustom._wrap(fromCENTER.toString(), 
					fromCatalog);
		}
		finally{
			
		}
		return fromOffer;
	}
	
}
