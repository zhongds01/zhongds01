package com.ai.sacenter.receive.center.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.center.impl.ICenterWrapperImpl;
import com.ai.sacenter.center.impl.SFCustomCenterImpl;
import com.ai.sacenter.receive.exigence.bo.IISPCRocket;
import com.ai.sacenter.receive.exigence.bo.IISPCRocketX;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketOffer;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 异步定单中心路由</p>
 * <p>Copyright: Copyright (c) 2017年5月4日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpdspcCenterImpl extends ICenterWrapperImpl {
	public SFUpdspcCenterImpl() {
		super();
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
				if( fromCENTER instanceof IOVMocketExigence ){
					IOVMocketExigence __mocket__ = (IOVMocketExigence)fromCENTER;
					fromRoute = CustomUtils.ISystem.getCenterByRegionId( __mocket__.getORDER_REGION_ID() );
				}
				else if( fromCENTER instanceof IOVMocketOffer ){
					IOVMocketOffer __mocketx__ = (IOVMocketOffer)fromCENTER;
					fromRoute = CustomUtils.ISystem.getCenterByRegionId( __mocketx__.getREGION_ID() );
				}
				else if( fromCENTER instanceof IISPCRocket ){
					IISPCRocket __mocket__ = (IISPCRocket)fromCENTER;
					fromRoute = CustomUtils.ISystem.getCenterByRegionId( __mocket__.getRegionId() );
				}
				else if( fromCENTER instanceof IISPCRocketX ){
					IISPCRocketX __mocketx__ = (IISPCRocketX)fromCENTER;
					fromRoute = CustomUtils.ISystem.getCenterByRegionId( __mocketx__.getRegionId() );
				}
				else{
					fromRoute = CustomUtils.ISystem.getCenterByRegionId( fromCENTER.toString() );
				}
				fromOffer = CenterUtils.ISystem._wrap(fromCatalog, 
						fromRoute);
			}
			finally{
				
			}
			return fromOffer;
		}
		
		
	}
}
