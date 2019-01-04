package com.ai.sacenter.receive.center.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.center.impl.ICenterWrapperImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.exigence.bo.IISPCRocket;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.tykt.valuebean.IOVKtSyncRequest;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmUserHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单中心路由</p>
 * <p>Copyright: Copyright (c) 2017年2月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpdbfsCenterImpl extends ICenterWrapperImpl{

	public SFUpdbfsCenterImpl() {
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
	public static class RegionIdCenterImpl extends SFUpdbfsCenterImpl{
		public RegionIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.receive.center.impl.SFUpdbfsCenterImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER,
				SFCenterCatalog fromCatalog, 
				IUpdcContext fromLDAP) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				if( fromCENTER instanceof IUpfgkmUserHome ){
					IUpfgkmUserHome.IUpfgkmPhoneHome __user__ = ((IUpfgkmUserHome)fromCENTER).getUSER();
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict( __user__.getREGION_ID(), fromCatalog );
				}
				else if( fromCENTER instanceof IOVUser ){
					IOVUser __user__ = (IOVUser)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict( __user__.getREGION_ID(), fromCatalog );
				}
				else if( fromCENTER instanceof IOVRocketExigence ){
					IOVRocketExigence fromRequest = (IOVRocketExigence)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict( fromRequest.getORDER_REGION_ID(), fromCatalog );
				}
				else if( fromCENTER instanceof IOVMsgFUser ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict( fromMsgFUser.getUSER_REGION_ID(), fromCatalog );
				}
				else if( fromCENTER instanceof IOVOrderPentium ){
					IOVOrderPentium  fromOrder = (IOVOrderPentium)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict( fromOrder.getUSER_REGION_ID(), fromCatalog );
				}
				else if( fromCENTER instanceof IOVMocketExigence ){
					IOVMocketExigence fromOsOffer = (IOVMocketExigence)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict(fromOsOffer.getORDER_REGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IISPCRocket ){
					IISPCRocket fromRocket = (IISPCRocket)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict(fromRocket.getRegionId(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVUpfwmCouple ){
					IOVUpfwmCouple fromCouple = (IOVUpfwmCouple)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict(fromCouple.getREGION_CODE(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVKtSyncRequest ){
					IOVKtSyncRequest fromKtSync = (IOVKtSyncRequest)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict(fromKtSync.getRegionId(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVMocketRespone.IRocketRsRspHome ){
					IOVMocketRespone.IRocketRsRspHome fromRsRsp = (IOVMocketRespone.IRocketRsRspHome)fromCENTER;
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict(fromRsRsp.getORDER_REGION_ID(), fromCatalog);
				}
				else{
					fromOffer = CenterUtils.ICustom.getSFUpfgkmDistrict( fromCENTER.toString(), fromCatalog );
				}
			}
			finally{
				
			}
			return fromOffer;
		}

	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 用户号码中心路由</p>
	 * <p>Copyright: Copyright (c) 2017年2月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class BillIdCenterImpl extends SFUpdbfsCenterImpl{
		public BillIdCenterImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.receive.center.impl.SFUpdbfsCenterImpl#wrapper(java.lang.Object, com.ai.sacenter.center.SFCenterCatalog, com.ai.sacenter.IUpdcContext)
		 */
		public SFCenterOffer wrapper(Object fromCENTER,
				SFCenterCatalog fromCatalog, 
				IUpdcContext fromLDAP) throws SFException, Exception {
			SFCenterOffer fromOffer = null;
			try
			{
				ISystemTemplate.ICenterRoute fromRoute = null;
				ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
				if( fromCENTER instanceof IUpfgkmUserHome ){
					IUpfgkmUserHome.IUpfgkmPhoneHome __user__ = ((IUpfgkmUserHome)fromCENTER).getUSER();
					fromOffice = CenterUtils.getSFUpfgkmOffice( __user__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVUser ){
					IOVUser __user__ = (IOVUser)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __user__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVRocketExigence ){
					IOVRocketExigence __rocket__ = (IOVRocketExigence)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __rocket__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				
				else if( fromCENTER instanceof IOVMsgFUser ){
					IOVMsgFUser __user__ = (IOVMsgFUser)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __user__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVOrderPentium ){
					IOVOrderPentium  __order__ = (IOVOrderPentium)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __order__.getBILL_ID()  );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVMocketExigence ){
					IOVMocketExigence __rocket__ = (IOVMocketExigence)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __rocket__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IISPCRocket ){
					IISPCRocket __rocket__ = (IISPCRocket)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __rocket__.getBillId() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVMocketRespone.IRocketRsRspHome ){
					IOVMocketRespone.IRocketRsRspHome __rocket__ = (IOVMocketRespone.IRocketRsRspHome)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __rocket__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVUpfwmCouple ){
					IOVUpfwmCouple __rocket__ = (IOVUpfwmCouple)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __rocket__.getBILL_ID() );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				else if( fromCENTER instanceof IOVKtSyncRequest ){
					IOVKtSyncRequest __rocket__ = (IOVKtSyncRequest)fromCENTER;
					fromOffice = CenterUtils.getSFUpfgkmOffice( __rocket__.getBillId() );
					fromRoute = CenterUtils.ICustom.getCenterOffer(fromOffice.getREGION_CODE(), 
							IUpdcConst.IUpdbm.IUpdbf.PROVISION, 
							fromOffice.getPLATFORM_() );
					fromOffer = CenterUtils.ISystem._wrap( fromCatalog, fromRoute );
				}
				else{
					fromOffice = CenterUtils.getSFUpfgkmOffice( fromCENTER.toString()  );
					fromOffer = CenterUtils.ICustom._wrap( fromOffice.getREGION_ID(), fromCatalog);
				}
				
			}
			finally{
				
			}
			return fromOffer;
		}
	}
}
