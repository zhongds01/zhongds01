package com.ai.sacenter.center.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务自定义中心路由</p>
 * <p>Copyright: Copyright (c) 2017年3月20日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFCustomCenterImpl extends ICenterWrapperImpl {
	public SFCustomCenterImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.center.impl.ICenterWrapperImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
	 */
	public SFCenterOffer wrapper(Object fromCENTER, 
			SFCenterCatalog fromCatalog,
			IUpdcContext fromLDAP) throws SFException, Exception {
		SFCenterOffer fromOffer = null;
		try
		{
			fromOffer = CenterUtils.ICustom._wrap( fromCENTER.toString(), 
					fromCatalog);
		}
		finally{
			
		}
		return fromOffer;
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 地市编码中心路由</p>
	 * <p>Copyright: Copyright (c) 2017年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class RegionIdCenterImpl extends SFCustomCenterImpl{
		public RegionIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.center.impl.SFCustomCenterImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER,
				SFCenterCatalog fromCatalog, 
				IUpdcContext fromLDAP) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				ISystemTemplate.ICenterRoute fromRoute = null;
				String aREGION_ID = fromCENTER != null?fromCENTER.toString():CenterUtils.ICustom.getRegionId();
				fromRoute = CenterUtils.ICustom.getCenterOffer(aREGION_ID, 
						fromCatalog.getSUBFLOW().getMapping().getCATEGORY(), 
						fromCatalog.getSUBFLOW().getMapping().getPLATFORM_() );
				fromOffer = CenterUtils.ISystem._wrap( fromCatalog, fromRoute );
			}
			finally{
				
			}
			return fromOffer;
		}
		
	}
}
