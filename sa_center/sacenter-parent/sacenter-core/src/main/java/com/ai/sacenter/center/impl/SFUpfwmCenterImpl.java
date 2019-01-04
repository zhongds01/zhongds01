package com.ai.sacenter.center.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IUpfgkmUserHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元测中心路由</p>
 * <p>Copyright: Copyright (c) 2017年2月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpfwmCenterImpl extends ICenterWrapperImpl {
	public SFUpfwmCenterImpl() {
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
	 * <p>Description: 用户地市中心路由</p>
	 * <p>Copyright: Copyright (c) 2017年2月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class RegionIdCenterImpl extends SFUpfwmCenterImpl{
		public RegionIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.center.impl.SFUpfwmCenterImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER,
				SFCenterCatalog fromCatalog, 
				IUpdcContext fromLDAP) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				String aREGION_ID = CenterUtils.ICustom.getRegionId();
				if( fromCENTER instanceof IOVUpdbpmOffice ){
					aREGION_ID = ((IOVUpdbpmOffice)fromCENTER).getSUBFLOW().getREGION_CODE();
				}
				else if( fromCENTER instanceof IUpfgkmUserHome ){
					aREGION_ID = ((IUpfgkmUserHome)fromCENTER).getUSER().getREGION_CODE();
				}
				else if( fromCENTER instanceof IOVUpfwmCouple ){
					aREGION_ID = ((IOVUpfwmCouple)fromCENTER).getREGION_ID();
				}
				else if( fromCENTER != null ){
					aREGION_ID = fromCENTER.toString();
				}
				fromOffer = CenterUtils.ICustom._wrap(aREGION_ID, fromCatalog);
			}
			finally{
				
			}
			return fromOffer;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 用户号码中心路由</p>
	 * <p>Copyright: Copyright (c) 2017年2月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class BillIdCenterImpl extends SFUpfwmCenterImpl{
		public BillIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.center.impl.SFUpfwmCenterImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER,
				SFCenterCatalog fromCatalog, 
				IUpdcContext fromLDAP) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
				if( fromCENTER instanceof IOVUpdbpmOffice ){
					IOVUpdbpmOffice.IUpdbpmOfferHome fromOfficeX = null;
					fromOfficeX = ((IOVUpdbpmOffice)fromCENTER).getSUBFLOW();
					fromOffice = CenterUtils.getSFUpfgkmOffice( fromOfficeX.getBILL_ID() );
				}
				else if( fromCENTER instanceof IUpfgkmUserHome ){
					IUpfgkmUserHome.IUpfgkmPhoneHome fromUSER = null;
					fromUSER = ((IUpfgkmUserHome)fromCENTER).getUSER();
					fromOffice = CenterUtils.getSFUpfgkmOffice( fromUSER.getBILL_ID() );
				}
				else if( fromCENTER instanceof IOVUpfwmCouple ){
					IOVUpfwmCouple fromCouple = (IOVUpfwmCouple)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( fromCouple.getBILL_ID() );
				}
				else{
					fromOffice = CenterUtils.getSFUpfgkmOffice( fromCENTER.toString() );
				}
				fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), 
						fromCatalog);
			}
			finally{
				
			}
			return fromOffer;
		}
	}
}
