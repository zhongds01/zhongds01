package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元定单工具类</p>
 * <p>Copyright: Copyright (c) 2018年5月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class UpffmUtils {

	public UpffmUtils() {
		super();
	}

	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromOrder
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOrder _wrap( IOVUpfwmOffer fromUpfwm, IOVUpfwmOrder fromOrder ) throws SFException,Exception{
			try
			{
				fromOrder.setPS_ID       ( fromUpfwm.getPS_ID           () );
				fromOrder.setCUST_ORDER  ( fromUpfwm.getCUST_ORDER      () );
				fromOrder.setDONE_CODE   ( fromUpfwm.getDONE_CODE       () );
				fromOrder.setCATALOG     ( fromUpfwm.getCATALOG         () );
				fromOrder.setBUSINESS    ( fromUpfwm.getBUSINESS        () );
				fromOrder.setORDER_ID    ( fromUpfwm.getORDER_ID        () );
				fromOrder.setTASK_ID     ( fromUpfwm.getTASK_ID         () );
				fromOrder.setCATEGORY    ( fromUpfwm.getCATEGORY        () );
				fromOrder.setUSER_ID     ( fromUpfwm.getUSER_ID         () );
				fromOrder.setBILL_ID     ( fromUpfwm.getBILL_ID         () );
				fromOrder.setSUB_BILL_ID ( fromUpfwm.getSUB_BILL_ID     () );
				fromOrder.setREGION_ID   ( fromUpfwm.getREGION_ID       () );
				fromOrder.setCREATE_DATE ( fromUpfwm.getCREATE_DATE     () );
				fromOrder.setPRIORITY    ( fromUpfwm.getPRIORITY        () );
				fromOrder.setPLATFORM    ( fromUpfwm.getPLATFORM        () );
				fromOrder.setDIRECTIVE   ( fromUpfwm.getDIRECTIVE       () );
				fromOrder.setPROGRAM     ( fromUpfwm.getPROGRAM         () );
				fromOrder.setOLD_PS_PARAM( fromUpfwm.getOLD_PS_PARAM    () );
				fromOrder.setPS_PARAM    ( fromUpfwm.getPS_PARAM        () );
				fromOrder.setTARGET_PARAM( fromUpfwm.getTARGET_PARAM    () );
				fromOrder.setPS_STATUS   ( fromUpfwm.getPS_STATUS       () );
				fromOrder.setFAIL_CODE   ( fromUpfwm.getFAIL_CODE       () );
				fromOrder.setFAIL_DEVICE ( fromUpfwm.getFAIL_DEVICE     () );
				fromOrder.setFAIL_REASON ( fromUpfwm.getFAIL_REASON     () );
				fromOrder.setFAIL_LOG    ( fromUpfwm.getFAIL_LOG        () );
				fromOrder.setSTART_DATE  ( fromUpfwm.getSTART_DATE      () );
				fromOrder.setEND_DATE    ( fromUpfwm.getEND_DATE        () );
				fromOrder.setRET_DATE    ( fromUpfwm.getRET_DATE        () );
				fromOrder.setSTOP_TYPE   ( fromUpfwm.getSTOP_TYPE       () );
				fromOrder.setPS_NET_CODE ( fromUpfwm.getPS_NET_CODE     () );
				fromOrder.setSERVICE_ID  ( fromUpfwm.getSERVICE_ID      () );
				fromOrder.setRETRY_TIMES ( fromUpfwm.getRETRY_TIMES     () );
				fromOrder.setORIGINATE   ( IUpdcConst.IUpdbm.IUpdbf.NORMAL );
				fromOrder.setSUB_PLAN_NO ( fromUpfwm.getSUB_PLAN_NO     () );
				fromOrder.setORDER_DATE  ( fromUpfwm.getORDER_DATE      () );
				fromOrder.setSTATE       ( IUpdcConst.IState.C             );
				fromOrder.setSTAFF_ID    ( fromUpfwm.getSTAFF_ID        () );
				fromOrder.setORG_ID      ( fromUpfwm.getORG_ID          () );
			}
			finally{
				
			}
			return fromOrder;
		}
		
		/**
		 * 根据网元工单创建网元工单与施工单关联
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 开通指令
		 * @param fromUpfwm 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOrder _wrap( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm, 
				IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfwmOrder fromUpffm = null;
			try
			{
				fromUpffm = new IOVUpfwmOrder();
				ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
				fromUpdbm = UpdcUtils.ISubFlow.getSUBFLOW(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				UpffmUtils.ICustom._wrap( fromUpfwm, fromUpffm               );
				fromUpffm.setORIGINATE  ( IUpdcConst.IUpdbm.IUpdbf.NORMAL    );
				if( fromOrder.isHUMAN() ){
					fromUpffm.setORIGINATE( IUpdcConst.IUpdbm.IUpdbf.HUMAN   );
				}
				fromUpffm.setCOMPLETE   ( fromUpdbm.getCOMPLETE           () );
				fromUpffm.setSTATE      ( IUpdcConst.IState.C                );
			}
			finally{
				
			}
			return fromUpffm;
		}
		public static class IICustom{
			public IICustom(){
				super();
			}
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		public static class ISystemX{
			public ISystemX(){
				super();
			}
		}
	}
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
	}
}
