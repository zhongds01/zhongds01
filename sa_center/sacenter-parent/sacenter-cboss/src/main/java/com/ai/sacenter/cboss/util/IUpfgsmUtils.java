package com.ai.sacenter.cboss.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.cboss.bo.IISAMcasIndex;
import com.ai.sacenter.cboss.bo.IISAMiscStatus;
import com.ai.sacenter.cboss.bo.IISARadiusIndex;
import com.ai.sacenter.cboss.bo.IISARadiusX;
import com.ai.sacenter.cboss.bo.ISABrandChg;
import com.ai.sacenter.cboss.bo.ISABrandChgHis;
import com.ai.sacenter.cboss.bo.ISAMcasHis;
import com.ai.sacenter.cboss.bo.ISAMcasIndex;
import com.ai.sacenter.cboss.bo.ISAMiscStatus;
import com.ai.sacenter.cboss.bo.ISAMiscStatusHis;
import com.ai.sacenter.cboss.bo.ISARadiusHis;
import com.ai.sacenter.cboss.bo.ISARadiusIndex;
import com.ai.sacenter.cboss.bo.ISARadiusX;
import com.ai.sacenter.cboss.bo.ISARadiusXHis;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmBrand;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmHistory;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmMcas;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmOffer;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmOrder;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmRabbit;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmRadius;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmRocket;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmStatus;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
import com.ai.sacenter.provision.valuebean.IOVUpfwmUnique;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年5月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgsmUtils {
	public IUpfgsmUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 用户状态全量状态上发指令资产[用户状态][CBOSS]
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUnique 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmStatus _jf_allsts( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmUnique fromUnique, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmStatus fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfgsmStatus();
				IOVUpfwmOffer fromUpfwm = fromUnique.getPROVISION();
				IUpdfmxLittle.IUpffxLittle fromUpffx = fromINDEX.getLittle();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmx = fromUpfwm.getORDER();
				fromINDEX.setSO_NBR      ( fromUpfwm.getPS_ID      () );
				fromINDEX.setORDER_ID    ( fromUpfwm.getORDER_ID   () );
				fromINDEX.setOFFER_ID    ( fromTASK.getOFFER_ID    () );
				fromINDEX.setTASK_ID     ( fromTASK.getTASK_ID     () );
				fromINDEX.setCATEGORY    ( fromUpfwm.getCOMPOSITE  () );
				fromINDEX.setUSER_ID     ( fromUpfwm.getUSER_ID    () );
				fromINDEX.setBILL_ID     ( fromUpfwm.getBILL_ID    () );
				fromINDEX.setSUB_BILL_ID ( fromUpfwm.getSUB_BILL_ID() );
				fromINDEX.setCREATE_DATE ( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setREGION_ID   ( fromUpfwm.getREGION_ID  () );
				fromINDEX.setSUB_PLAN_NO ( fromUpfwm.getSUB_PLAN_NO() );
				fromINDEX.setORDER_DATE  ( fromUpfwm.getORDER_DATE () );
				fromINDEX.setUSER_STS    ( fromUpfom.getPLOSFLG    () );
				fromINDEX.setSTOP_TYPE   ( fromUpfwm.getSTOP_TYPE  () );
				fromINDEX.setSTS         ( IUpfgsmConst.IState.CREATE );
				fromINDEX.setCOMMIT_DATE ( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setSTS_CHG_TIME( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setSTS_OPR_TIME( fromUpfwm.getCREATE_DATE() );
				ClassUtils.IMerge.merge  ( fromUpfwmx.getGRAPHICS(), fromUpffx.getSUBFLOW() );
				String[] fromDELETE = ClassUtils.IClass.transfer( fromUpffx.getSUBFLOW(), fromINDEX );
				if( fromDELETE != null && fromDELETE.length > 0 ){
					ClassUtils.IMerge.purge( fromUpffx.getSUBFLOW(), fromDELETE );
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 根据开通工单创建CBOSS测用户品牌变化工单
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUpfwm 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmBrand _jf_brandchg( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfgsmBrand fromINDEX = null;
			try
		    {
				fromINDEX = new IOVUpfgsmBrand();
				IUpdfmxLittle.IUpffxLittle fromUpffx = fromINDEX.getLittle();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmx = fromUpfwm.getORDER();
				fromINDEX.setSO_NBR     ( fromUpfwm.getPS_ID      () );
				fromINDEX.setORDER_ID   ( fromUpfwm.getORDER_ID   () );
				fromINDEX.setOFFER_ID   ( fromTASK.getOFFER_ID    () );
				fromINDEX.setTASK_ID    ( fromTASK.getTASK_ID     () );
				fromINDEX.setCATEGORY   ( fromUpfwm.getCOMPOSITE  () );
				fromINDEX.setUSER_ID    ( fromUpfwm.getUSER_ID    () );
				fromINDEX.setBILL_ID    ( fromUpfwm.getBILL_ID    () );
				fromINDEX.setSUB_BILL_ID( fromUpfwm.getSUB_BILL_ID() );
				fromINDEX.setCREATE_DATE( fromUpfwm.getCREATE_DATE() );
				fromINDEX.setREGION_ID  ( fromUpfwm.getREGION_ID  () );
				fromINDEX.setORDER_DATE ( fromUpfwm.getORDER_DATE () );
				fromINDEX.setSUB_PLAN_NO( fromUpfwm.getSUB_PLAN_NO() );
				fromINDEX.setUSER_STS   ( fromUpfom.getPLOSFLG    () );
				fromINDEX.setSTOP_TYPE  ( fromUpfwm.getSTOP_TYPE  () );
				fromINDEX.setSTS        ( IUpfgsmConst.IState.CREATE );
				fromINDEX.setCOMMIT_DATE( fromUpfwm.getCREATE_DATE() );
				ClassUtils.IMerge.merge ( fromUpfwmx.getGRAPHICS(), fromUpffx.getSUBFLOW() );
				String[] fromDELETE = ClassUtils.IClass.transfer( fromUpffx.getSUBFLOW(), fromINDEX );
				if( fromDELETE != null && fromDELETE.length > 0 ){
					ClassUtils.IMerge.purge( fromUpffx.getSUBFLOW(), fromDELETE );
				}
		    }
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromType
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmRocket _jf_miscoffer( IOVUpfgsmRocket fromRocket, ObjectType fromType ) throws SFException,Exception{
			IOVUpfgsmRocket fromHistory = null;
			try
			{
				IISARadiusX _rocket = (IISARadiusX)ClassUtils.IClass.getASTBOEntity( fromType );
				OracleUtils.ICustom.transfer( fromRocket.getINSTANCE(), _rocket );
				fromHistory = new IOVUpfgsmRocket( _rocket );
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 根据开通工单创建CBOSS测平台工单
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUnique 网元索引
		 * @param fromUpfwm 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmRadius _jf_miscoffer( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmUnique fromUnique,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmRadius fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfgsmRadius();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromINDEX.setSO_NBR        ( fromUpfwm.getPS_ID                        () );
				fromINDEX.setMSO_NBR       ( 0l                                           );
				fromINDEX.setORDER_ID      ( fromUpfwm.getORDER_ID                     () );
				fromINDEX.setOFFER_ID      ( fromTASK.getOFFER_ID                      () );
				fromINDEX.setTASK_ID       ( fromTASK.getTASK_ID                       () );
				fromINDEX.setCATEGORY      ( fromUpfwm.getCOMPOSITE                    () );
				fromINDEX.setUSER_ID       ( fromUpfwm.getUSER_ID                      () );
				fromINDEX.setBILL_ID       ( fromUpfwm.getBILL_ID                      () );
				fromINDEX.setSUB_BILL_ID   ( fromUpfwm.getSUB_BILL_ID                  () );
				fromINDEX.setCREATE_DATE   ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setREGION_ID     ( fromUpfwm.getREGION_ID                    () );
				fromINDEX.setSUB_PLAN_NO   ( fromUpfwm.getSUB_PLAN_NO                  () );
				fromINDEX.setORDER_DATE    ( fromUpfwm.getORDER_DATE                   () );
				fromINDEX.setBUSI_TYPE     ( Integer.parseInt(fromUpfom.getPS_SERVICE() ) );
				fromINDEX.setACT_TYPE      ( fromUpfom.getCODE                         () );
				fromINDEX.setUSER_STS      ( fromUpfom.getPLOSFLG                      () );
				fromINDEX.setSTOP_TYPE     ( fromUpfwm.getSTOP_TYPE                    () );
				fromINDEX.setBRAND         ( 0                                            );
				fromINDEX.setSTS           ( IUpfgsmConst.IState.CREATE                   );
				fromINDEX.setCOMPOSITE     ( fromUpfom.getCOMPOSITE                    () );
				fromINDEX.setCOMMIT_DATE   ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setPROCESS_DATE  ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setSRC           ( ISystem.getSRC( fromOrder, fromTASK        ) );
				fromINDEX.setORDER_FLAG    ( IUpfgsmConst.IOriginate.USER                 );
				fromINDEX.setRECONFIRM_FLAG( 0                                            );
				fromINDEX.setCALLBACK_FLAG ( IUpfgsmConst.ICallBack.NO                    );
				if( fromUpfom.isREPLY() ){
					fromINDEX.setCALLBACK_FLAG( IUpfgsmConst.ICallBack.YES                );
				}
				ICustom.IICustom._jj_extendx( fromUpfwm, fromINDEX                        );
			}
			finally{
			
			}
			return fromINDEX;
		}
		
		/**
		 * 根据开通工单创建CBOSS测内容计费工单
		 * @param fromOrder 开通工单
		 * @param fromTASK 开通任务
		 * @param fromUpdfwm 服务指令集
		 * @param fromUnique 网元索引
		 * @param fromUpfwm 网元工单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmMcas _jf_mcasoffer( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmUnique fromUnique,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmMcas fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfgsmMcas();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromINDEX.setSO_NBR        ( fromUpfwm.getPS_ID                      () );
				fromINDEX.setMSO_NBR       ( 0l                                         );
				fromINDEX.setORDER_ID      ( fromUpfwm.getORDER_ID                   () );
				fromINDEX.setOFFER_ID      ( fromTASK.getOFFER_ID                    () );
				fromINDEX.setTASK_ID       ( fromTASK.getTASK_ID                     () );
				fromINDEX.setCATEGORY      ( fromUpfwm.getCOMPOSITE                  () );
				fromINDEX.setUSER_ID       ( fromUpfwm.getUSER_ID                    () );
				fromINDEX.setBILL_ID       ( fromUpfwm.getBILL_ID                    () );
				fromINDEX.setSUB_BILL_ID   ( fromUpfwm.getSUB_BILL_ID                () );
				fromINDEX.setCREATE_DATE   ( fromUpfwm.getCREATE_DATE                () );
				fromINDEX.setREGION_ID     ( fromUpfwm.getREGION_ID                  () );
				fromINDEX.setSUB_PLAN_NO   ( fromUpfwm.getSUB_PLAN_NO                () );
				fromINDEX.setORDER_DATE    ( fromUpfwm.getORDER_DATE                 () );
				fromINDEX.setBUSI_TYPE     ( Integer.parseInt(fromUpfom.getPS_SERVICE()));
				fromINDEX.setACT_TYPE      ( fromUpfom.getCODE                       () );
				fromINDEX.setUSER_STS      ( fromUpfom.getPLOSFLG                    () );
				fromINDEX.setSTOP_TYPE     ( fromUpfwm.getSTOP_TYPE                  () );
				fromINDEX.setBRAND         ( 0                                          );
				fromINDEX.setSTS           ( IUpfgsmConst.IState.CREATE                 );
				fromINDEX.setCOMPOSITE     ( fromUpfom.getCOMPOSITE                  () );
				fromINDEX.setCOMMIT_DATE   ( fromUpfwm.getCREATE_DATE                () );
				fromINDEX.setPROCESS_DATE  ( fromUpfwm.getCREATE_DATE                () );
				fromINDEX.setSRC           ( ISystem.getSRC( fromOrder, fromTASK      ) );
				fromINDEX.setORDER_FLAG    ( IUpfgsmConst.IOriginate.USER               );
				fromINDEX.setCALLBACK_FLAG ( IUpfgsmConst.ICallBack.NO                  );
				fromINDEX.setRECONFIRM_FLAG( 0                                          );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromINDEX                      );
			}
			finally{
			
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUnique
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmRadius _jf_miscosstatus(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmUnique fromUnique,
				IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmRadius fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfgsmRadius();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromINDEX.setSO_NBR         ( fromUpfwm.getPS_ID                        () );
				fromINDEX.setMSO_NBR        ( fromUnique.getPROVISION().getPS_ID        () );
				fromINDEX.setORDER_ID       ( fromUpfwm.getORDER_ID                     () );
				fromINDEX.setOFFER_ID       ( fromTASK.getOFFER_ID                      () );
				fromINDEX.setTASK_ID        ( fromTASK.getTASK_ID                       () );
				fromINDEX.setCATEGORY       ( fromUpfwm.getCOMPOSITE                    () );
				fromINDEX.setUSER_ID        ( fromUpfwm.getUSER_ID                      () );
				fromINDEX.setBILL_ID        ( fromUpfwm.getBILL_ID                      () );
				fromINDEX.setSUB_BILL_ID    ( fromUpfwm.getSUB_BILL_ID                  () );
				fromINDEX.setCREATE_DATE    ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setREGION_ID      ( fromUpfwm.getREGION_ID                    () );
				fromINDEX.setSUB_PLAN_NO    ( fromUpfwm.getSUB_PLAN_NO                  () );
				fromINDEX.setORDER_DATE     ( fromUpfwm.getORDER_DATE                   () );
				fromINDEX.setBUSI_TYPE      ( Integer.parseInt(fromUpfom.getPS_SERVICE() ) );
				fromINDEX.setACT_TYPE       ( fromUpfom.getCODE                         () );
				fromINDEX.setUSER_STS       ( fromUpfom.getPLOSFLG                      () );
				fromINDEX.setSTOP_TYPE      ( fromUpfwm.getSTOP_TYPE                    () );
				fromINDEX.setBRAND          ( 0                                            );
				fromINDEX.setSTS            ( IUpfgsmConst.IState.CREATE                   );
				fromINDEX.setCOMPOSITE      ( fromUpfom.getCOMPOSITE                    () );
				fromINDEX.setCOMMIT_DATE    ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setPROCESS_DATE   ( fromUpfwm.getCREATE_DATE                  () );
				fromINDEX.setSRC            ( ISystem.getSRC( fromOrder, fromTASK        ) );
				fromINDEX.setORDER_FLAG     ( IUpfgsmConst.IOriginate.OSSTATE              );
				fromINDEX.setCALLBACK_FLAG  ( IUpfgsmConst.ICallBack.NO                    );
				fromINDEX.setRECONFIRM_FLAG ( 0                                            );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromINDEX                         );
			}
			finally{
			
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmMcas _jf_mcasosstatus(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmUnique fromUnique,
				IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfgsmMcas fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfgsmMcas();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromINDEX.setSO_NBR        ( fromUpfwm.getPS_ID                      () );
				fromINDEX.setMSO_NBR       ( fromUnique.getPROVISION().getPS_ID      () );
				fromINDEX.setORDER_ID      ( fromUpfwm.getORDER_ID                   () );
				fromINDEX.setOFFER_ID      ( fromTASK.getOFFER_ID                    () );
				fromINDEX.setTASK_ID       ( fromTASK.getTASK_ID                     () );
				fromINDEX.setCATEGORY      ( fromUpfwm.getCOMPOSITE                  () );
				fromINDEX.setUSER_ID       ( fromUpfwm.getUSER_ID                    () );
				fromINDEX.setBILL_ID       ( fromUpfwm.getBILL_ID                    () );
				fromINDEX.setSUB_BILL_ID   ( fromUpfwm.getSUB_BILL_ID                () );
				fromINDEX.setCREATE_DATE   ( fromUpfwm.getCREATE_DATE                () );
				fromINDEX.setREGION_ID     ( fromUpfwm.getREGION_ID                  () );
				fromINDEX.setSUB_PLAN_NO   ( fromUpfwm.getSUB_PLAN_NO                () );
				fromINDEX.setORDER_DATE    ( fromUpfwm.getORDER_DATE                 () );
				fromINDEX.setBUSI_TYPE     ( Integer.parseInt(fromUpfom.getPS_SERVICE()));
				fromINDEX.setACT_TYPE      ( fromUpfom.getCODE                       () );
				fromINDEX.setUSER_STS      ( fromUpfom.getPLOSFLG                    () );
				fromINDEX.setSTOP_TYPE     ( fromUpfwm.getSTOP_TYPE                  () );
				fromINDEX.setBRAND         ( 0                                          );
				fromINDEX.setSTS           ( IUpfgsmConst.IState.CREATE                 );
				fromINDEX.setCOMPOSITE     ( fromUpfom.getCOMPOSITE                  () );
				fromINDEX.setCOMMIT_DATE   ( fromUpfwm.getCREATE_DATE                () );
				fromINDEX.setPROCESS_DATE  ( fromUpfwm.getCREATE_DATE                () );
				fromINDEX.setSRC           ( ISystem.getSRC( fromOrder, fromTASK      ) );
				fromINDEX.setORDER_FLAG    ( IUpfgsmConst.IOriginate.OSSTATE            );
				fromINDEX.setCALLBACK_FLAG ( IUpfgsmConst.ICallBack.NO                  );
				fromINDEX.setRECONFIRM_FLAG( 0                                          );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromINDEX                      );
			}
			finally{
			
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmOffer _jj_miscoffer( Object fromEntity ) throws SFException,Exception{
			IOVUpfgsmOffer fromINDEX = null;
			try
			{
				if( fromEntity == null || ( fromEntity instanceof DataContainer ) == false ){
					fromINDEX = null;
				}
				else if( ( fromEntity instanceof ISABrandChg ) ){
					fromINDEX = new IOVUpfgsmBrand( (ISABrandChg)fromEntity );
				}
				else if( ( fromEntity instanceof ISAMiscStatus ) ){
					fromINDEX = new IOVUpfgsmStatus( (ISAMiscStatus)fromEntity );
				}
				else if( ( fromEntity instanceof ISARadiusIndex ) ){
					fromINDEX = new IOVUpfgsmRadius( (ISARadiusIndex)fromEntity );
				}
				else if( ( fromEntity instanceof ISAMcasIndex ) ){
					fromINDEX = new IOVUpfgsmMcas( (ISAMcasIndex)fromEntity );
				}
				else if( ( fromEntity instanceof ISARadiusX ) ){
					fromINDEX = new IOVUpfgsmRocket( (ISARadiusX)fromEntity );
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromINDEX
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmHistory _jj_mischistory( IOVUpfgsmOrder fromINDEX ) throws SFException,Exception{
			IOVUpfgsmHistory fromHistory = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromORACLE = null;
				ObjectType _objecttype = fromINDEX.getINSTANCE().getObjectType();
				fromORACLE = HQSQLUtils.ISystem.getSFUpfgkmHistory( _objecttype.getMapingEnty() );
				if( fromORACLE != null && StringUtils.isBlank( fromORACLE.getPERSISTENT() ) == false ){
					IISAProvision _provision = (IISAProvision)ClassUtils.IClass.getASTBOEntity( fromORACLE.getPERSISTENT() );
					OracleUtils.ICustom.transfer( fromINDEX.getINSTANCE(), _provision );
					fromHistory = new IOVUpfgsmHistory( _provision );
					fromHistory.setPS_ID      ( fromINDEX.getSO_NBR     () );
					fromHistory.setCREATE_DATE( fromINDEX.getCREATE_DATE() );
					fromHistory.setREGION_ID  ( fromINDEX.getREGION_ID  () );
					fromHistory.setPS_STATUS  ( fromINDEX.getSTS        () );
				}
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmOffer _jj_miscnotify( Object fromEntity ) throws SFException,Exception{
			IOVUpfgsmOffer fromINDEX = null;
			try
			{
				if( fromEntity == null || ( fromEntity instanceof DataContainer ) == false ){
					fromINDEX = null;
				}
				else if( ( fromEntity instanceof ISABrandChg ) && ((ISABrandChg)fromEntity).isNew() ){
					fromINDEX = new IOVUpfgsmBrand( (ISABrandChg)fromEntity );
				}
				else if( ( fromEntity instanceof ISAMiscStatus ) && ((ISAMiscStatus)fromEntity).isNew() ){
					fromINDEX = new IOVUpfgsmStatus( (ISAMiscStatus)fromEntity );
				}
				else if( ( fromEntity instanceof ISARadiusIndex ) && ((ISARadiusIndex)fromEntity).isNew() ){
					fromINDEX = new IOVUpfgsmRadius( (ISARadiusIndex)fromEntity );
				}
				else if( ( fromEntity instanceof ISAMcasIndex ) && ((ISAMcasIndex)fromEntity).isNew() ){
					fromINDEX = new IOVUpfgsmMcas( (ISAMcasIndex)fromEntity );
				}
				else if( ( fromEntity instanceof ISARadiusX ) && ((ISARadiusX)fromEntity).isNew() ){
					fromINDEX = new IOVUpfgsmRocket( (ISARadiusX)fromEntity );
				}
			}
			finally{
				
			}
			return fromINDEX;
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
				IOVUpfgsmOffer fromUpfwm,
				IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
			try
			{
				fromNotify = new IOVUpfwmRabbit.IUpfwmNotify();
				fromNotify.setUSER_ID     ( fromUpfwm.getUSER_ID             () );
				fromNotify.setCATEGORY    ( fromUpfwm.getCATEGORY            () );
				if( fromNotify.isEXPIRE() == false/*非到期工单*/){
					fromNotify.setCATEGORY( IUpdcConst.IUpdbm.IUpdbf.NORMAL     );
				}
				fromNotify.setPLATFORM    ( fromUpffm.getID                  () );
				fromNotify.setCREATE_DATE ( fromUpfwm.getORDER_DATE          () );
				fromNotify.setREGION_ID   ( fromUpfwm.getREGION_ID           () );
				fromNotify.setSTATUS      ( fromUpfwm.getSTOP_TYPE           () );
			}
			finally{
				
			}
			return fromNotify;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmHistory _jj_statushistory( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmHistory fromHistory = null;
			try
			{
				IOVUpfwmOffer.IUpfwmOfferHome fromUpffmx = fromUpfwm.getORDER();
				fromHistory = IICustom._jj_history(fromUpfwm, fromUpdfwm, ISAMiscStatusHis.S_TYPE, aContext);
				ClassUtils.IMerge.merge( fromUpffmx.getGRAPHICS(), fromHistory.getORDER().getGRAPHICS() );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromHistory );
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmHistory _jj_brandhistory( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmHistory fromHistory = null;
			try
			{
				IOVUpfwmOffer.IUpfwmOfferHome fromUpffmx = fromUpfwm.getORDER();
				fromHistory = IICustom._jj_history(fromUpfwm, fromUpdfwm, ISABrandChgHis.S_TYPE, aContext);
				ClassUtils.IMerge.merge( fromUpffmx.getGRAPHICS(), fromHistory.getORDER().getGRAPHICS() );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromHistory );
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmHistory _jj_mischistory(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmHistory fromHistory = null;
			try
			{
				IOVUpfwmOffer.IUpfwmOfferHome fromUpffmx = fromUpfwm.getORDER();
				boolean fromREPLY = UpdbpmUtils.IIfElse.isREPLY(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromHistory = IICustom._jj_history(fromUpfwm, fromUpdfwm, ISARadiusHis.S_TYPE, aContext);
				fromHistory.setPS_STATUS    ( IUpfwmConst.IUpdos.SUCCEED        );
				if( fromREPLY == true ){
					fromHistory.setPS_STATUS( IUpfwmConst.IUpdos.CREATE         );
				}
				ClassUtils.IMerge.merge( fromUpffmx.getGRAPHICS(), fromHistory.getORDER().getGRAPHICS() );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromHistory );
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgsmHistory _jj_mcashistory( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgsmHistory fromHistory = null;
			try
			{
				IOVUpfwmOffer.IUpfwmOfferHome fromUpffmx = fromUpfwm.getORDER();
				fromHistory = IICustom._jj_history(fromUpfwm, fromUpdfwm, ISAMcasHis.S_TYPE, aContext);
				ClassUtils.IMerge.merge( fromUpffmx.getGRAPHICS(), fromHistory.getORDER().getGRAPHICS() );
				ICustom.IICustom._jj_extendx( fromUpfwm, fromHistory );
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 
		 * @param fromSubSQL
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map _jj_extendx( HQSQLEntityBean fromSubSQL ) throws SFException,Exception{
			try
			{
				StringBuilder fromPARAM = new StringBuilder();
				String fromPARA = fromSubSQL.getAsString( IISARadiusIndex.S_PsParam );
				if( fromPARA != null && StringUtils.isBlank( fromPARA ) == false ){
					JdomUtils.ICustom.wrap( fromPARA, fromSubSQL.getLittle().getSubFlow() );
				}
				for( java.util.Iterator itera = fromSubSQL.getLittle().getLittle().iterator(); itera.hasNext(); ){
					HQSQLEntityBean fromSubJect = (HQSQLEntityBean)itera.next();
					for( int __index = 0; __index < 20; __index++ ){
						String _field = ClassUtils.getINDEX( new String[]{"PARAM_",__index < 9 ?"0":"", 
								String.valueOf( __index + 1 ) } );
						fromPARA = fromSubJect.getAsString( _field );
						if( fromPARA == null ){ break; }
						fromPARAM.append( fromPARA );
					}
				}
				if( fromPARAM != null && fromPARAM.toString().length() > 0 ){ 
					JdomUtils.ICustom.wrap( fromPARAM.toString(), fromSubSQL.getLittle().getSubFlow() );
				}
			}
			finally{
				
			}
			return fromSubSQL.getLittle().getSubFlow();
		}
		
		public static class IICustom{
			public IICustom(){
				super();
			}
			
			/**
			 * 
			 * @param fromUpfwm
			 * @param fromUpdfwm
			 * @param fromUpffmx
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpfgsmHistory _jj_history( IOVUpfwmOffer fromUpfwm,
					IOVUpdspmLife fromUpdfwm,
					ObjectType fromUpffmx,
					IUpdcContext aContext) throws SFException, Exception{
				IOVUpfgsmHistory fromHistory = null;
				try
				{
					IISAProvision ___history = null;
					java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp(System.currentTimeMillis());
					___history = (IISAProvision)ClassUtils.IClass.getASTBOEntity( fromUpffmx );
					OracleUtils.ICustom.transfer( fromUpfwm.getINSTANCE(), ___history );
					fromHistory = new IOVUpfgsmHistory( ___history );
					if( fromUpfwm.getEND_DATE() == null ){ fromHistory.setEND_DATE( aCOMPLETE ); }
					if( fromUpfwm.getRET_DATE() == null ){ fromHistory.setRET_DATE( aCOMPLETE ); }
					fromHistory.setDIRECTIVE( fromUpdfwm.getOPERATE().getCODE() );
					fromHistory.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED        );
				}
				finally{
					
				}
				return fromHistory;
			}
			
			/**
			 * 
			 * @param fromUpfwm
			 * @param fromRabbit
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static java.util.Map _jj_extendx( IOVUpfwmOffer fromUpfwm, IOVUpfgsmRabbit fromRabbit ) throws SFException,Exception{
				try
				{
					IUpdfmxLittle.IUpffxLittle fromUpffx = fromRabbit.getLittle();
					ClassUtils.IMerge.merge( fromUpfwm.getORDER().getGRAPHICS(), fromUpffx.getSUBFLOW() );
					String[] fromDELETE = ClassUtils.IClass.transfer( fromUpffx.getSUBFLOW(), fromRabbit );
					if( fromDELETE != null && fromDELETE.length > 0 ){ 
						ClassUtils.IMerge.purge( fromRabbit.getLittle().getSUBFLOW(), fromDELETE ); 
					}
					fromRabbit.setPS_PARAM( UpfwmUtils.ICustom.wrap( fromUpffx.getSUBFLOW  () ) );
					String fromPARAM[] = SystemUtils.ICustom.substringAsL( fromRabbit.getPS_PARAM() );
					if( fromPARAM != null && fromPARAM.length > 1 ){
						fromRabbit.setPS_PARAM( null                                            );
						for( int index = 0,fromSortBy = 10000; fromPARAM != null && index < fromPARAM.length; fromSortBy++ ){
							IOVUpfgsmRocket fromRocket = new IOVUpfgsmRocket();
							fromRocket.setSO_NBR       ( UpfwmFactory.getIUpfwmDAO().getPS_ID() );
							fromRocket.setMSO_NBR      ( fromRabbit.getSO_NBR                () );
							fromRocket.setCATEGORY     ( fromRabbit.getCATEGORY              () );
							fromRocket.setUSER_ID      ( fromRabbit.getUSER_ID               () );
							fromRocket.setSORT_BY      ( fromSortBy                             );
							fromRocket.setCREATE_DATE  ( fromRabbit.getCREATE_DATE           () );
							fromRocket.setREGION_ID    ( fromRabbit.getREGION_ID             () );
							fromRocket.setSUB_PLAN_NO  ( fromRabbit.getSUB_PLAN_NO           () );
							fromRocket.setORDER_DATE   ( fromRabbit.getORDER_DATE            () );
							IBeanWrapper fromMBean = new IBeanWrapper( fromRocket );
							for( int _index = 0; fromPARAM != null && index < fromPARAM.length && _index < 20; _index++,index++ ){
								String fromFIELD = ClassUtils.getINDEX( new String[]{"PARAM_",_index < 9 ?"0":"", String.valueOf( _index + 1 ) } );
								fromMBean.setPropertyValue( fromFIELD, fromPARAM[index] );
							}
							fromRabbit.getLittle().getLITTLE().add( fromRocket );
						}
					}
				}
				finally{
					
				}
				return fromRabbit.getLittle().getSUBFLOW();
			}
			
			/**
			 * 
			 * @param fromUpfwm
			 * @param fromHistory
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static java.util.Map _jj_extendx( IOVUpfwmOffer fromUpfwm, IOVUpfgsmHistory fromHistory ) throws SFException,Exception{
				try
				{
					String fromPARA[] = SystemUtils.ICustom.substringAsL( fromHistory.getPS_PARAM()  );
					if( fromPARA != null && fromPARA.length > 1 ){
						fromHistory.setPS_PARAM        ( null                                     );
						fromUpfwm.setPS_PARAM          ( fromHistory.getPS_PARAM               () );
						for( int index = 0,fromSortBy = 10000; fromPARA != null && index < fromPARA.length; fromSortBy++ ){
							IOVUpfgsmRocket fromRocket = new IOVUpfgsmRocket( new ISARadiusXHis() );
							fromRocket.setSO_NBR       ( UpfwmFactory.getIUpfwmDAO().getPS_ID  () );
							fromRocket.setMSO_NBR      ( fromHistory.getPS_ID                  () );
							fromRocket.setCATEGORY     ( fromHistory.getCOMPOSITE              () );
							fromRocket.setUSER_ID      ( fromHistory.getUSER_ID                () );
							fromRocket.setSORT_BY      ( fromSortBy                               );
							fromRocket.setCREATE_DATE  ( fromHistory.getCREATE_DATE            () );
							fromRocket.setREGION_ID    ( fromHistory.getREGION_ID              () );
							fromRocket.setSUB_PLAN_NO  ( fromHistory.getSUB_PLAN_NO            () );
							fromRocket.setORDER_DATE   ( fromHistory.getORDER_DATE             () );
							IBeanWrapper fromMBean = new IBeanWrapper( fromRocket                 );
							for( int _index = 0; fromPARA != null && index < fromPARA.length && _index < 20; _index++,index++ ){
								String fromFIELD = ClassUtils.getINDEX( new String[]{"PARAM_",_index < 9 ?"0":"", String.valueOf( _index + 1 ) } );
								fromMBean.setPropertyValue( fromFIELD, fromPARA[index] );
							}
							fromHistory.getLittle().getLITTLE().add( fromRocket );
						}
					}
				}
				finally{
					
				}
				return fromHistory.getORDER().getGRAPHICS();
			}
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 查询CBOSS受理来源(0-BOSS,1-平台)
		 * @param fromOrder
		 * @param fromTASK
		 * @return
		 */
		public static int getSRC(IOVOrderPentium fromOrder, IOVTaskPentium fromTASK ){
			int fromSRC = IUpfgsmConst.IChannel.ISource.BOSS;
			try
			{
				IOVOfferPentium.IOfferMBeanHome fromOffer = fromTASK.getORDER().getOFFER().getORDER();
				String fromCMSRC = (String)fromOffer.getOFFER().get( IUpfgsmConst.ICustom.VGPCMSRC );
				if( fromCMSRC != null && StringUtils.equals( fromCMSRC, IUpfgsmConst.IChannel.CBOSS ) ){
					fromSRC = IUpfgsmConst.IChannel.ISource.PLATFORM;
				}
				else if( StringUtils.equals( fromOrder.getCHANNEL(), IUpfgsmConst.IChannel.CBOSS ) ){
					fromSRC = IUpfgsmConst.IChannel.ISource.PLATFORM;
				}
			}
			finally{
				
			}
			return fromSRC;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年2月21日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		/**
		 * 是否具备上发网元通知单
		 * @param fromEntity
		 * @return
		 */
		public static boolean isNOTIFY( Object fromEntity ){
			boolean fromNotify = false;
			try
			{
				fromNotify = ( fromEntity != null && ( fromEntity instanceof IISARadiusIndex || 
						fromEntity instanceof IISAMcasIndex || fromEntity instanceof IISAMiscStatus ) ) &&
						((DataContainer)fromEntity).isNew();
			}
			finally{
				
			}
			return fromNotify;
		}
	}
}
