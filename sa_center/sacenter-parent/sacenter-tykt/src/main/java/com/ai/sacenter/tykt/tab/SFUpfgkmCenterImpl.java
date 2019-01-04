package com.ai.sacenter.tykt.tab;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.center.impl.ICenterWrapperImpl;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: 统一开通分区路由</p>
 * <p>Copyright: Copyright (c) 2017年9月5日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFUpfgkmCenterImpl extends ICenterWrapperImpl {
	public SFUpfgkmCenterImpl(){
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 地市编码中心路由</p>
	 * <p>Copyright: Copyright (c) 2017年9月5日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class RegionIdCenterImpl extends SFUpfgkmCenterImpl{
		public RegionIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.center.impl.ICenterWrapperImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER, 
				SFCenterCatalog fromCatalog, 
				IUpdcContext aContext) throws SFException, Exception {
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
	
	/**
	 * 
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 用户号码中心路由</p>
	 * <p>Copyright: Copyright (c) 2017年9月5日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class BillIdCenterImpl extends SFUpfgkmCenterImpl{
		public BillIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.center.impl.ICenterWrapperImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER, 
				SFCenterCatalog fromCatalog, 
				IUpdcContext aContext) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				ISystemTemplate.ICenterRoute fromRoute = null;
				ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
				fromOffice = CenterUtils.getSFUpfgkmOffice( fromCENTER.toString() );
				fromRoute = CenterUtils.ICustom.getCenterOffer(fromOffice.getREGION_CODE(), 
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
