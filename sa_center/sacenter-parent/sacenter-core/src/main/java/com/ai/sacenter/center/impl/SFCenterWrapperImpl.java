package com.ai.sacenter.center.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.util.CenterUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description:服务 中心转换实现类</p>
 * <p>Copyright: Copyright (c) 2015年6月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFCenterWrapperImpl extends ICenterWrapperImpl {
	public SFCenterWrapperImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.center.impl.ICenterWrapperImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
	 */
	public SFCenterOffer wrapper(Object fromCENTER, 
			SFCenterCatalog fromCATALOG,
			IUpdcContext fromLDAP) throws SFException, Exception {
		return super.wrapper(fromCENTER, fromCATALOG, fromLDAP);
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年6月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class RegionIdCenterImpl extends SFCenterWrapperImpl{
		public RegionIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.center.impl.SFCenterWrapperImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER,
				SFCenterCatalog fromCatalog, 
				IUpdcContext fromLDAP) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				fromOffer = CenterUtils.ICustom._wrap( fromCENTER != null?
						fromCENTER.toString():null, 
						fromCatalog);
			}
			finally{
				
			}
			return fromOffer;
		}
	}
}
