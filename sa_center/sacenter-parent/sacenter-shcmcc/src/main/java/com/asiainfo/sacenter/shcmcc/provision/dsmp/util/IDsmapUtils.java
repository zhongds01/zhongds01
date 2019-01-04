package com.asiainfo.sacenter.shcmcc.provision.dsmp.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.bo.IISANotifyIndex;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.IISADsmpOrder;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.IISADsmpStatus;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.ISADsmpOrder;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.ISADsmpStatus;

public class IDsmapUtils {

	public IDsmapUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 根据开通工单创建CBOSS测平台工单
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUpfwm 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IISADsmpOrder _jf_dsmpoffer( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IISADsmpOrder fromINDEX = null;
			try
			{
				fromINDEX = new ISADsmpOrder();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmx = fromUpfwm.getORDER();
				fromINDEX.setSoNbr        ( fromUpfwm.getPS_ID                        () );
				fromINDEX.setMsoNbr       ( 0l                                           );
				fromINDEX.setOrderId      ( fromOrder.getORDER_ID                     () );
				fromINDEX.setOfferId      ( fromTASK.getOFFER_ID                      () );
				fromINDEX.setTaskId       ( fromTASK.getTASK_ID                       () );
				fromINDEX.setCategory     ( fromOrder.getCOMPOSITE                    () );
				fromINDEX.setUserId       ( fromOrder.getUSER_ID                      () );
				fromINDEX.setBillId       ( fromUpfwm.getBILL_ID                      () );
				fromINDEX.setSubBillId    ( fromUpfwm.getSUB_BILL_ID                  () );
				fromINDEX.setCreateDate   ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setRegionId     ( fromUpfwm.getREGION_ID                    () );
				fromINDEX.setSubPlanNo    ( fromUpfwm.getSUB_PLAN_NO                  () );
				fromINDEX.setOrderDate    ( fromUpfwm.getORDER_DATE                   () );
				fromINDEX.setBusiType     ( Integer.parseInt(fromUpfom.getPS_SERVICE() ) );
				fromINDEX.setActType      ( fromUpfom.getCODE                         () );
				fromINDEX.setUserSts      ( fromUpfom.getPLOSFLG                      () );
				fromINDEX.setBrand        ( 0                                            );
				fromINDEX.setPsParam      ( fromUpfwm.getPS_PARAM                     () );
				fromINDEX.setSts          ( 1                                            );
				fromINDEX.setComposite    ( fromUpfom.getCOMPOSITE                    () );
				fromINDEX.setCommitDate   ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setProcessDate  ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setSrc          ( 0                                            );
				fromINDEX.setOrderFlag    ( 1                                            );
				fromINDEX.setCallbackFlag ( 0                                            );
				fromINDEX.setReconfirmFlag( 0                                            );
				String fromDELETE[] = ClassUtils.IClass.transfer( fromUpfwmx.getGRAPHICS(), fromINDEX );
				if( fromDELETE != null && fromDELETE.length > 0 ){
					ClassUtils.IMerge.purge( fromUpfwmx.getGRAPHICS(), fromDELETE );
					String fromPARAM = UpfwmUtils.ICustom.wrap( fromUpfwmx.getGRAPHICS() );
					fromINDEX.setPsParam( fromPARAM );
				}
			}
			finally{
			
			}
			return fromINDEX;
		}
		/**
		 * 用户状态全量状态上发指令资产[用户状态][CBOSS]
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUpfwm 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IISADsmpStatus _jf_allsts( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception{
			IISADsmpStatus fromINDEX = null;
			try
			{
				fromINDEX = new ISADsmpStatus();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmx = fromUpfwm.getORDER();
				fromINDEX.setSoNbr        ( fromOrder.getORDER_ID   () );
				fromINDEX.setOrderId      ( fromOrder.getORDER_ID   () );
				fromINDEX.setOfferId      ( fromTASK.getOFFER_ID    () );
				fromINDEX.setTaskId       ( fromTASK.getTASK_ID     () );
				fromINDEX.setCategory     ( fromOrder.getCOMPOSITE  () );
				fromINDEX.setUserId       ( fromOrder.getUSER_ID    () );
				fromINDEX.setBillId       ( fromUpfwm.getBILL_ID    () );
				fromINDEX.setSubBillId    ( fromUpfwm.getSUB_BILL_ID() );
				fromINDEX.setCreateDate   ( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setRegionId     ( fromUpfwm.getREGION_ID  () );
				fromINDEX.setSubPlanNo    ( fromUpfwm.getSUB_PLAN_NO() );
				fromINDEX.setOrderDate    ( fromUpfwm.getORDER_DATE () );
				fromINDEX.setUserSts      ( fromUpfom.getPLOSFLG    () );
				fromINDEX.setSts          ( 1                          );
				fromINDEX.setCommitDate   ( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setStsChgTime   ( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setStsOprTime   ( fromUpfwm.getCREATE_DATE() );
				ClassUtils.IClass.transfer( fromUpfwmx.getGRAPHICS(), fromINDEX );
			}
			finally{
				
			}
			return fromINDEX;
		}
		public static class ICustomX{
			public ICustomX(){
				super();
			}
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		/**
		 * 
		 * @param fromMBean
		 * @param fromUpfwm
		 * @param fromUpffm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmRabbit.IUpfwmNotify _jj_notify(MBeanDelegate fromMBean,
				DataContainer fromUpfwm,
				IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
			try
			{
				fromNotify = new IOVUpfwmRabbit.IUpfwmNotify();
				fromNotify.setUSER_ID     ( fromUpfwm.getAsLong    ( IISANotifyIndex.S_UserId    ) );
				fromNotify.setCATEGORY    ( fromUpfwm.getAsString  ( IISANotifyIndex.S_Category  ) );
				fromNotify.setCATEGORY    ( IUpdcConst.IUpdbm.IUpdbf.NORMAL                        );
				fromNotify.setPLATFORM    ( fromUpffm.getID                                     () );
				fromNotify.setREGION_ID   ( fromUpfwm.getAsString  ( IISANotifyIndex.S_RegionId  ) );
				fromNotify.setCREATE_DATE ( fromMBean.getCREATE                                 () );
			}
			finally{
				
			}
			return fromNotify;
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		/**
		 * 是否为网元工单容器
		 * @param aOBJECTIVE
		 * @return
		 */
		public static boolean isPROVISION( Object aOBJECTIVE ){
			boolean fromNOTIFY = false;
			try
			{
				fromNOTIFY = aOBJECTIVE != null && ( aOBJECTIVE instanceof IISADsmpOrder || aOBJECTIVE instanceof IISADsmpStatus );
				if( fromNOTIFY == true ){
					DataStructInterface fromEntity = (DataStructInterface)aOBJECTIVE;
					fromNOTIFY = fromEntity.isNew();
				}
			}
			finally{
				
			}
			return fromNOTIFY;
		}
	}

}
