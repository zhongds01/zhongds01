package com.ai.sacenter.util;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.IISAUatmix;
import com.ai.sacenter.provision.bo.ISAProvision;
import com.ai.sacenter.provision.bo.ISAProvisionHis;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfgmtxLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmBase;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.provision.valuebean.IOVUpfwmUatmix;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单工具类</p>
 * <p>Copyright: Copyright (c) 2014-7-20</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmUtils {

	public UpfwmUtils() {
		super();
	}
	
	/**
	 * 流程订单任务送网元前指令预处理任务
	 * @param fromOrder 流程订单信息
	 * @param fromTASK 流程订单任务
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public static void finishSFUpdbmCreate( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception{
		try
		{
			fromTASK.setPLWK_CREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
		}
		finally{
		
		}
	}
	
	/**
	 * 网元工单送网元前指令预处理任务
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public static void finishSFUpdbmCreate( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception{
		try
		{
			fromUpfwm.setSTART_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			finishSFUpfwmCreate(fromUpfwm, 
					fromUpdfwm, 
					aContext);
		}
		finally{
		
		}
	}
	
	/**
	 * 网元工单送网元前指令后处理任务
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public static void finishSFUpdbmComplete( IUpdcContext aContext ) throws SFException,Exception{
		try
		{
			IOVTaskPentium fromTASK = UpdcUtils.ISubFlow.getTASK( aContext );
			IOVUpfwmOffer fromUpfwm = UpdcUtils.ISubFlow.getPROVISION( aContext );
			if( fromTASK != null ){
				fromTASK.setPLWK_COMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			}
			else if( fromUpfwm != null ){
				fromUpfwm.setEND_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			}
			UpfsvcManager.getSession().getComposite().clear();
		}
		finally{
			
		}
	}
	
	/**
	 * 网元指令调度前预处理环境变量
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public static void finishSFUpfwmCreate(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception{
		try
		{
			Object fromPARAM[][] = new Object[][]{
					{IUpdcConst.IUpdbm.IUpdbf.ORDER     , fromOrder                 },
					{IUpdcConst.IUpdbm.IUpdbf.TASK      , fromTASK                  },
					{IUpdcConst.IUpdbm.IUpdbf.PLATFORM  , fromUpdfwm.getPLATFORM () },
					{IUpdcConst.IUpdbm.IUpdbf.DIRECTIVE , fromUpdfwm.getDIRECTIVE() },
					{IUpdcConst.IUpdbm.IUpdbf.CHILDREN  , fromUpdfwm.getCHILDREN () },
					{IUpdcConst.IUpdbm.IUpdbf.OPERATE   , fromUpdfwm.getOPERATE  () }};
			java.util.Map fromDelegate[] = new java.util.Map[]{UpfsvcManager.getSession().getComposite() , aContext };
			for( int index = 0 ; index < fromDelegate.length; index++ ){
				ClassUtils.IMerge.merge( fromPARAM , fromDelegate[index], true);
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 网元指令调度前预处理环境变量
	 * @param fromUpfwm
	 * @param fromUpdfwm
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	private static void finishSFUpfwmCreate(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception{
		try
		{
			Object fromPARAM[][] = new Object[][]{
					{IUpdcConst.IUpdbm.IUpdbf.PROVISION , fromUpfwm },
					{IUpdcConst.IUpdbm.IUpdbf.PLATFORM  , fromUpdfwm.getPLATFORM()},
					{IUpdcConst.IUpdbm.IUpdbf.DIRECTIVE , fromUpdfwm.getDIRECTIVE()},
					{IUpdcConst.IUpdbm.IUpdbf.CHILDREN  , fromUpdfwm.getCHILDREN()},
					{IUpdcConst.IUpdbm.IUpdbf.OPERATE   , fromUpdfwm.getOPERATE()}};
			java.util.Map fromDelegate[] = new java.util.Map[]{UpfsvcManager.getSession().getComposite() , aContext };
			for( int index = 0 ; index < fromDelegate.length; index++ ){
				ClassUtils.IMerge.merge( fromPARAM , fromDelegate[index], true);
			}
		}
		finally{
			
		}
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 根据服务任务单构造当前网元工单
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务单
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 服务指令
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrap( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				ISystemTemplate.IUpdbpmOffer fromUpdbpm = null;
				if( fromUpfwm == null ){ fromUpfwm = new IOVUpfwmOffer(); }
				IPeriodGraphToken fromToken = fromUpdfwm.getTOKEN();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				IOVUpfwmOffer.IUpfwmOfferHome fromUpffx = fromUpfwm.getORDER();
				IOVOfferPentium.IOfferMBeanHome fromOffer = fromTASK.getORDER().getOFFER().getORDER();
				fromUpdbpm = UpdcUtils.ISubFlow.getSUBFLOW(fromOrder, fromTASK, fromUpdfwm, aContext);
				ICustomX._wrap(fromOrder, fromTASK, fromUpdfwm, fromUpfwm, aContext          );
				ClassUtils.IMerge.merge ( fromOffer.getOFFER(), fromUpffx.getSUBFLOW      () );
				ClassUtils.IMerge.merge ( fromToken.getDeque(), fromUpffx.getSUBFLOW(), true );
				fromUpfwm.setPROGRAM    ( fromUpdbpm.getPROGRAM                           () );
				fromUpfwm.setCREATE_DATE( fromMBean.getCREATE                             () );
				fromUpfwm.setSUB_PLAN_NO( fromMBean.getORDER_ID                           () );
				fromUpfwm.setSTOP_TYPE  ( ICustomX._jj_STOP_TYPE( fromUpfwm )                );
			}
			finally{
			
			}
			return fromUpfwm;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTYPE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrap( IOVUpfwmOrder fromOrder, ObjectType fromTYPE ) throws SFException,Exception{
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				IISAProvision aProvision = (IISAProvision) ClassUtils.IClass.getASTBOEntity(fromTYPE);
				OracleUtils.ICustom.transfer(fromOrder.getINSTANCE(), aProvision);
				fromUpfwm = new IOVUpfwmOffer( aProvision );
				fromUpfwm.setCOMPOSITE( IUpdcConst.IUpdbm.IUpdbf.NORMAL );
				fromUpfwm.getINSTANCE().setStsToOld();
			}
			finally{
				
			}
			return fromUpfwm;
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromTYPE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrap( IOVUpfwmOffer fromUpfwm, ObjectType fromTYPE )  throws SFException,Exception{
			IOVUpfwmOffer fromCouple = null;
			try
			{
				java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp(System.currentTimeMillis());
				IISAProvision _provision = (IISAProvision) ClassUtils.IClass.getASTBOEntity(fromTYPE);
				OracleUtils.ICustom.transfer( fromUpfwm.getINSTANCE(), _provision );
				fromCouple = new IOVUpfwmOffer( _provision );
				if( fromCouple.getEND_DATE() == null ) fromCouple.setEND_DATE(aCOMPLETE);
				if( fromCouple.getRET_DATE() == null ) fromCouple.setRET_DATE(aCOMPLETE);
			}
			finally{
				
			}
			return fromCouple;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromUpfwm
		 * @param fromINDEX
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrap( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm,
				ObjectType fromINDEX,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfwmOffer _provision = null;
			try
			{
				boolean fromREPLY = UpdbpmUtils.IIfElse.isREPLY(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				_provision = UpfwmUtils.ICustom._wrap(fromUpfwm, fromINDEX );
				_provision.setDIRECTIVE( fromUpdfwm.getOPERATE().getCODE() );
				_provision.setPS_STATUS( fromREPLY == true?IUpfwmConst.IUpdos.CREATE:
					IUpfwmConst.IUpdos.SUCCEED );
			}
			finally{
			
			}
			return _provision;
		}
		
		/**
		 * 全局事务转换为网元工单索引
		 * @param fromMBean
		 * @param fromUpffm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmNotify _wrap( MBeanDelegate fromMBean, IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfwmNotify fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfwmNotify();
				fromINDEX.setORDER_ID   ( fromMBean.getORDER_ID        () );
				fromINDEX.setPLATFORM   ( fromUpffm.getID              () );
				fromINDEX.setCATEGORY   ( IUpdcConst.IUpdbm.IUpdbf.NORMAL );
				fromINDEX.setUSER_ID    ( 0                               );
				fromINDEX.setCREATE_DATE( fromMBean.getCREATE          () );
				fromINDEX.setREGION_ID  ( fromMBean.getREGION_ID       () );
				fromINDEX.setSTATUS     ( IUpfwmConst.IUpdos.CREATE       );
				fromINDEX.setORDER_DATE ( fromMBean.getCREATE          () );
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromMBean
		 * @param fromNotify
		 * @param fromUpffm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmNotify _wrap( MBeanDelegate fromMBean, IOVUpfwmRabbit.IUpfwmNotify fromNotify, IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfwmNotify fromINDEX = null;
			try
			{
				java.math.BigDecimal fromORDER_ID = null;
				fromINDEX = UpfwmUtils.ICustom._wrap(fromMBean, fromUpffm );
				fromORDER_ID = UpfwmFactory.getIUpfwmDAO().getORDER_ID( fromNotify.getREGION_ID() );
				fromINDEX.setORDER_ID   ( fromORDER_ID.longValue   () );
				fromINDEX.setCATEGORY   ( fromNotify.getCATEGORY   () );
				fromINDEX.setUSER_ID    ( fromNotify.getUSER_ID    () );
				fromINDEX.setPLATFORM   ( fromNotify.getPLATFORM   () );
				fromINDEX.setCREATE_DATE( fromMBean.getCREATE      () );
				fromINDEX.setREGION_ID  ( fromNotify.getREGION_ID  () );
				fromINDEX.setORDER_DATE ( fromNotify.getCREATE_DATE() );
				fromINDEX.setSTATUS     ( IUpfwmConst.IUpdos.CREATE   );
				if( fromNotify.isSUSPEND() /*到期暂停上发*/ ){
					fromINDEX.setSTATUS     ( IUpfwmConst.IUpdos.SUSPEND  );
					fromINDEX.setORDER_DATE ( TimeUtils.getMaxExpire   () );
					fromINDEX.setBACKUP_DATE( fromNotify.getCREATE_DATE() );
				}
				fromINDEX.setHAND_ID    ( fromMBean.getORDER_ID    () );
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 异常类型转换网元工单索引
		 * @param fromMBean 全局事务
		 * @param aEXCEPTION 异常类型
		 * @param fromINDEX 网元工单索引
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmNotify _wrap( MBeanDelegate fromMBean, SFException aEXCEPTION, IOVUpfwmNotify fromINDEX ) throws SFException,Exception{
			try
			{
				MBeanDelegate fromLBean = UpfsvcManager.getMBean().getQuality();
				fromINDEX.setSTART_DATE   ( fromMBean.getCREATE     () );
				fromINDEX.setCOMPLETE_DATE( fromMBean.getCOMPLETE   () );
				fromINDEX.setHAND_ID      ( fromLBean.getORDER_ID   () );
				fromINDEX.setHAND_DATE    ( fromMBean.getCOMPLETE   () );
				fromINDEX.setSTATUS       ( IUpfwmConst.IUpdos.SUCCEED );
				fromINDEX.setFAIL_LOG     ( ""                         );
				if( aEXCEPTION != null ){
					fromINDEX.setFAIL_CODE  ( aEXCEPTION.getFaultCode () );
					fromINDEX.setFAIL_REASON( aEXCEPTION.getMessage   () );
					fromINDEX.setSTATUS     ( IUpfwmConst.IUpdos.FAILURE   );
					fromINDEX.setFAIL_LOG   ( SystemUtils.getISTKThrow( aEXCEPTION  ) );
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromMBean
		 * @param fromCouple
		 * @param fromUpfwm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void wrap( MBeanDelegate fromMBean, IOVUpfwmCouple fromCouple, IOVUpfwmOrder fromUpfwm ) throws SFException,Exception{
			try
			{
				fromUpfwm.setSTART_DATE  ( fromCouple.getSTART_DATE  () );
				fromUpfwm.setEND_DATE    ( fromCouple.getEND_DATE    () );
				fromUpfwm.setRET_DATE    ( fromCouple.getRET_DATE    () );
				fromUpfwm.setPS_STATUS   ( fromCouple.getPS_STATUS   () );
				fromUpfwm.setTARGET_PARAM( fromCouple.getTARGET_PARAM() );
				fromUpfwm.setFAIL_CODE( fromCouple.getFAIL_CODE() );
				if( StringUtils.isBlank( fromCouple.getFAIL_CODE() ) ){
					fromUpfwm.setFAIL_CODE( String.valueOf( fromCouple.getPS_STATUS() ) );
				}
				fromUpfwm.setFAIL_DEVICE( fromCouple.getFAIL_DEVICE() );
				fromUpfwm.setFAIL_REASON( fromCouple.getFAIL_REASON() );
				fromUpfwm.setFAIL_LOG   ( fromCouple.getFAIL_LOG   () );
				if( fromCouple.getINSTANCE() != null ){
					IOVUpfwmOrder.IUpfwmOrigHome fromORIGING = null;
					fromORIGING = new IOVUpfwmOrder.IUpfwmOrigHome( 
							fromMBean.getREPOSITORY(), 
							fromCouple.getINSTANCE() );
					fromUpfwm.getORDER().setORIGING( fromORIGING );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 网元反馈转换为统一反馈对象
		 * @param fromUpfwm 工单对象
		 * @param fromUpdfwm 网元指令集
		 * @param fromNetWork 网元原反馈集
		 * 
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmResponse _wrap( IOVUpfwmOffer fromUpfwm, IOVUpdspmLife fromUpdfwm, IOVUpfwmResponse fromNetWork) throws SFException,Exception{
			IOVUpfwmResponse fromRsRsp = null;
			try
			{
				fromRsRsp = new IOVUpfwmResponse( fromUpfwm );
				IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromRsRsp.setFAILURE  ( fromNetWork.getFAILURE           () );
				fromRsRsp.setRspCode  ( fromNetWork.getRspCode           () );
				fromRsRsp.setRspDesc  ( fromNetWork.getRspDesc           () );
				fromRsRsp.setRspHome  ( fromUpfwm.getPLATFORM            () );
				fromRsRsp.setRspResult( fromNetWork.getRspResult         () );
				fromRsRsp.setRspBody  ( fromNetWork.getRspBody           () );
				fromRsRsp.getORDER().getSUBFLOW().putAll( fromNetWork.getORDER().getSUBFLOW() );
				if( fromRsRsp != null && fromRsRsp.isRsRspNull() == false ){
					IPlatformTemplate.IUpffmsOffer _configure = null;
					_configure = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer(fromRsRsp.getRspCode(), 
							fromUpfom.getCATEGORY(), 
							fromUpffm.getID() );
					if( _configure != null && fromRsRsp.isFAILURE() ){
						fromRsRsp.setFAILURE( _configure.isSUCCEED()?Boolean.FALSE:Boolean.TRUE );
					}
				}
			}
			finally{
				
			}
			return fromRsRsp;
		}
		
		/**
		 * 交易事务集转换交易消息表
		 * @param fromUpdgmtx 交易事务集
		 * @param fromUatmix 交易消息表
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVUpfgmtxLife fromUpdgmtx, IOVUpfwmUatmix fromUatmix ) throws SFException,Exception{
			try
			{
				java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
				IOVUpfgmtxLife.IUpfgmtxLifeHome fromUpfgmtxHome = fromUpdgmtx.getSUBFLOW();
				fromUatmix.setLGMSG_ID     ( UpfwmFactory.getIUpdfmxDAO().getPLMM_ID() );
				fromUatmix.setORDER_ID     ( fromUpfgmtxHome.getORDER_ID            () );
				fromUatmix.setDONE_CODE    ( fromUpfgmtxHome.getDONE_CODE           () );
				fromUatmix.setUSER_ID      ( fromUpfgmtxHome.getUSER_ID             () );
				fromUatmix.setBILL_ID      ( fromUpfgmtxHome.getBILL_ID             () );
				fromUatmix.setCREATE_DATE  ( fromUpfgmtxHome.getCREATE_DATE         () );
				fromUatmix.setREGION_ID    ( fromUpfgmtxHome.getREGION_ID           () );
				fromUatmix.setPLATFORM     ( fromUpfgmtxHome.getPLATFORM            () );
				fromUatmix.setCOMPLETE_DATE( aCOMPLETE                                 );
				if( ClassUtils.IClass.isString( fromUpfgmtxHome.getOBJECTIVE() ) ){
					fromUatmix.setPLWK_IDO ( (String)fromUpfgmtxHome.getOBJECTIVE   () );
				}
				else if( ClassUtils.IClass.isMethod( fromUpfgmtxHome.getOBJECTIVE() ) ){
					java.lang.reflect.Method fromMetod = (java.lang.reflect.Method)fromUpfgmtxHome.getOBJECTIVE();
					fromUatmix.setPLWK_IDO ( fromMetod.getName                     () );
				}
				else if( fromUpfgmtxHome.getOBJECTIVE() != null ){
					fromUatmix.setPLWK_IDO( String.valueOf( fromUpfgmtxHome.getOBJECTIVE().hashCode() ) );
				}
				if( ClassUtils.IClass.isString( fromUpfgmtxHome.getIMPLCLASS() ) ){
					fromUatmix.setIMPLCLASS( (String)fromUpfgmtxHome.getIMPLCLASS  () );
				}
				else if( fromUpfgmtxHome.getIMPLCLASS() != null ){
					fromUatmix.setIMPLCLASS( fromUpfgmtxHome.getIMPLCLASS().getClass().getName() );
				}
				if( fromUpfgmtxHome.getBODY() != null && fromUpfgmtxHome.getBODY().size() > 0 ){
					String __msg__ = XmlUtils.createNoformatXml("ucmframe", fromUpfgmtxHome.getBODY() );
					fromUatmix.setMSG      ( __msg__                                  );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromUpdfwm
		 * @param fromUpdgmtx
		 * @param fromPLMX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgmtxLife _wrap(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm,
				IOVUpfgmtxLife fromUpdgmtx,
				Object fromPLMX[][],
			    IUpdcContext aContext) throws SFException, Exception{
			try
			{
				ISystemTemplate.IImplCapital fromCapital = fromUpdfwm.getJAVA();
				IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
				IOVUpfgmtxLife.IUpfgmtxLifeHome fromUpfgmtxHome = fromUpdgmtx.getSUBFLOW();
				if( fromUpfgmtxHome.getPLATFORM() == null ){
					java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
					fromUpfgmtxHome.setORDER_ID   ( String.valueOf( fromUpfwm.getORDER_ID() ) );
					fromUpfgmtxHome.setDONE_CODE  ( fromUpfwm.getDONE_CODE              () );
					fromUpfgmtxHome.setUSER_ID    ( fromUpfwm.getUSER_ID                () );
					fromUpfgmtxHome.setBILL_ID    ( fromUpfwm.getBILL_ID                () );
					fromUpfgmtxHome.setCREATE_DATE( aCOMPLETE                              );
					fromUpfgmtxHome.setREGION_ID  ( fromUpfwm.getREGION_ID              () );
					fromUpfgmtxHome.setPLATFORM   ( fromUpffm.getID                     () );
					fromUpfgmtxHome.setOBJECTIVE  ( String.valueOf( fromUpfwm.getPS_ID() ) );
					fromUpfgmtxHome.setIMPLCLASS  ( fromCapital.getIMPLCLASS            () );
					fromUpfgmtxHome.setCHANNEL    ( "*"                                    );
				}
				for( int index = 0; fromPLMX != null && index < fromPLMX.length; index++ ){
					if( fromUpfgmtxHome.getINDEX() == null ){
						fromUpfgmtxHome.getBODY().put( fromPLMX[index][0], fromPLMX[index][1] );
					}
					else{
						java.util.Map fromPLMMX = null;
						if( (fromPLMMX = (java.util.Map)fromUpfgmtxHome.getBODY().get( fromPLMX[index][0] ) ) == null ){
							fromUpfgmtxHome.getBODY().put( fromPLMX[index][0] , fromPLMMX = new java.util.HashMap() );
						}
						fromPLMMX.put( fromUpfgmtxHome.getINDEX(), fromPLMX[index][1] );
					}
				}
			}
			finally{
				
			}
			return fromUpdgmtx;
		}
		
		/**
		 * 交易事务集转换交易消息表
		 * @param fromUpdgmtx 交易事务集
		 * @param fromUpfwm 网元工单
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmUatmix _wrap( IOVUpfgmtxLife fromUpdgmtx, 
				IOVUpfwmOffer fromUpfwm,
				java.lang.Exception aEXCEPTION,
				IUpdcContext aContext) throws SFException,Exception{
			IOVUpfwmUatmix fromUatmix = null;
			try
			{
				fromUatmix = new IOVUpfwmUatmix();
				UpfwmUtils.ICustom._wrap(fromUpdgmtx, fromUatmix);
				fromUatmix.setORDER_ID( String.valueOf( fromUpfwm.getORDER_ID() ) );
				fromUatmix.setPLWK_IDO( String.valueOf( fromUpfwm.getPS_ID   () ) );
				fromUatmix.setSTATE   ( IUpdcConst.IState.O                       );
				if( aEXCEPTION != null ){
					fromUatmix.setSTATE    ( IUpdcConst.IState.E                   );
					fromUatmix.setFAIL_LOG ( SystemUtils.getISTKThrow( aEXCEPTION ));
				}
				fromUatmix.setORG_ID  ( fromUpfwm.getORG_ID                    () );
				fromUatmix.setSTAFF_ID( fromUpfwm.getSTAFF_ID                  () );
			}
			finally{
				
			}
			return fromUatmix;
		}
		
		/**
		 * 根据网元定单构造网元调度反馈集
		 * @param fromOrder 网元定单
		 * @param fromNetWork 应带集
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmResponse wrap(IOVUpfwmOrder fromOrder, IOVUpfwmResponse fromNetWork ) throws SFException,Exception{
			try
			{
				IOVUpfwmOrder.IUpfwmOfferHome fromOfferHome = fromOrder.getORDER();
				if( fromNetWork == null ) fromNetWork = new IOVUpfwmResponse( fromOrder );
				fromNetWork.setFAILURE  ( fromOrder.isACHIEVE()?Boolean.FALSE:Boolean.TRUE );
				fromNetWork.setRspCode  ( fromOfferHome.getRspCode  () );
				fromNetWork.setRspDesc  ( fromOfferHome.getRspDesc  () );
				fromNetWork.setRspHome  ( fromOfferHome.getRspHome  () );
				if( fromOrder.isNETWORK() &&  StringUtils.isBlank( fromOfferHome.getRspResult() ) == false  ){
					fromNetWork.setRspResult( fromOfferHome.getRspResult                                 () );
					fromNetWork.setRspBody  ( UpfwmUtils.ICustom.wrap( fromOfferHome.getRspResult(), null ) );
				}
			}
			finally{
				
			}
			return fromNetWork;
		}
		
		/**
		 * 根据网元定单解决组件实体
		 * @param fromUpfwm 发起方
		 * @param fromUpdcmpt 解决组件
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVUpfwmOrder fromUpfwm, IProgramTemplate.IUpdfcmpOffer fromUpdcmpt, SFException aEXCEPTION ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				IOVUpfwmResponse fromNetWork = null;
				IOVUpfwmOrder.IUpfwmOfferHome fromOrderHome = fromUpfwm.getORDER();
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromUpfwm, fromUpdcmpt, aEXCEPTION );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromUpfwm.getPROGRAM() ) );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.PROVISION, fromUpfwm );
				ClassUtils.IMerge.merge(fromUpfwm.getORDER().getOFFER(), fromUpdcpm.getSUBFLOW() );
				if( StringUtils.isBlank( fromOrderHome.getRspCode() ) == false ){
					fromNetWork = UpfwmUtils.ICustom.wrap( fromUpfwm, fromNetWork );
				}
				SystemUtils.ICustom.wrap(fromUpfwm, null, fromNetWork, aEXCEPTION, fromUpdcpm.getSUBFLOW() );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据网元工单获取解决组件资产
		 * @param fromUpfwm 网元工单
		 * @param fromUpdcmpt 解决组件
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVUpfwmOffer fromUpfwm, IProgramTemplate.IUpdfcmpOffer fromUpdcmpt, SFException aEXCEPTION ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromUpfwm, fromUpdcmpt, aEXCEPTION );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromUpfwm.getPROGRAM() ) );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.PROVISION, fromUpfwm );
				ClassUtils.IMerge.merge(fromUpfwm.getORDER().getOFFER()  , fromUpdcpm.getSUBFLOW() );
				ClassUtils.IMerge.merge(fromUpfwm.getORDER().getSUBFLOW(), fromUpdcpm.getSUBFLOW() );
				SystemUtils.ICustom.wrap(fromUpfwm, null, null, aEXCEPTION, fromUpdcpm.getSUBFLOW() );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 查询当前网元交互交易事务集,如线程上无交易事务集则构造线程交易事务集
		 * @param fromUpffm 网元定义
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgmtxLife getICSTKUpdgmtx( IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfgmtxLife fromUpdgmtx = null;
			try
			{
				java.util.Map fromUpffmx = UpfsvcManager.getSession().getComposite();
				if( fromUpffm.getENDIAN() != null && fromUpffm.getENDIAN().getREQOTING() ){
					fromUpdgmtx = (IOVUpfgmtxLife)fromUpffmx.get(IUpdcConst.IUpdbm.IUpdbf.REQOTING);
					if (fromUpdgmtx == null) {
						fromUpdgmtx = new IOVUpfgmtxLife( fromUpffm );
						fromUpffmx.put(IUpdcConst.IUpdbm.IUpdbf.REQOTING, fromUpdgmtx );
					}
				}
			}
			finally{
				
			}
			return fromUpdgmtx;
		}
		
		/**
		 * 查询当前线程上网元交易事务集,如线程上无交易事务集则返回空指针
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgmtxLife getICSTKUpdgmtx( ) throws SFException,Exception{
			IOVUpfgmtxLife aTransaction = null;
			try
			{
				java.util.Map fromComposite = UpfsvcManager.getSession().getComposite();
				aTransaction = (IOVUpfgmtxLife)fromComposite.get( IUpdcConst.IUpdbm.IUpdbf.REQOTING );
			}
			finally{
				
			}
			return aTransaction;
		}
		
		/**
		 * 根据网元执行结果反馈到网元工单上
		 * @param fromUpfwm 
		 * @param fromHistory
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IOVUpfwmBase fromUpfwm, IISAProvision fromHistory ) throws SFException,Exception{
			try
			{
				fromHistory.setStartDate   ( fromUpfwm.getSTART_DATE  () );
				fromHistory.setEndDate     ( fromUpfwm.getEND_DATE    () );
				fromHistory.setRetDate     ( fromUpfwm.getRET_DATE    () );
				fromHistory.setTargetParam ( fromUpfwm.getTARGET_PARAM() );
				fromHistory.setPsStatus    ( (int)fromUpfwm.getPS_STATUS   () );
				fromHistory.setFailCode    ( fromUpfwm.getFAIL_CODE   () );
				fromHistory.setFailDevice  ( fromUpfwm.getFAIL_DEVICE () );
				fromHistory.setFailReason  ( fromUpfwm.getFAIL_REASON () );
				fromHistory.setFailLog     ( fromUpfwm.getFAIL_LOG    () );
			}
			finally{
				
			}
		}
		
		/**
		 * 根据网元执行结果反馈到网元工单上
		 * @param fromCouple 
		 * @param fromHistory
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IOVUpfwmCouple fromCouple, IISAProvision fromHistory ) throws SFException,Exception{
			try
			{
				if( fromCouple.getSTART_DATE() != null ) fromHistory.setStartDate   ( fromCouple.getSTART_DATE  () );
				fromHistory.setEndDate     ( fromCouple.getEND_DATE    () );
				fromHistory.setRetDate     ( fromCouple.getRET_DATE    () );
				fromHistory.setTargetParam ( fromCouple.getTARGET_PARAM() );
				fromHistory.setPsStatus    ( (int)fromCouple.getPS_STATUS() );
				fromHistory.setFailCode    ( fromCouple.getFAIL_CODE   () );
				fromHistory.setFailDevice  ( fromCouple.getFAIL_DEVICE () );
				fromHistory.setFailReason  ( fromCouple.getFAIL_REASON () );
				fromHistory.setFailLog     ( fromCouple.getFAIL_LOG    () );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromUATMIX
		 * @param aCOMPLETE
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IISAUatmix fromUATMIX, java.sql.Timestamp aCOMPLETE ) throws SFException,Exception{
			try
			{
				if (fromUATMIX.getCompleteDate() == null) {
					fromUATMIX.setCompleteDate( aCOMPLETE );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param aCOMPLETE
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IISAProvision fromUpfwm, java.sql.Timestamp aCOMPLETE ) throws SFException,Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromTASK
		 * @param fromUpdfwm
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap wrap( Object fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				java.util.Map fromOffer, 
				IUpdcContext aContext) throws SFException, Exception{
			java.util.HashMap fromUpfwm = new java.util.HashMap();
			try
			{
				IPlatformTemplate.IUpffmOperate fromUpfdom = fromUpdfwm.getOPERATE();
				IPlatformTemplate.IUpffmOffer fromUpfom = fromUpdfwm.getPLATFORM();
				ClassUtils.IMerge.merge( fromOffer , fromUpfwm );
				java.util.Map fromList[] = new java.util.Map[]{fromUpfdom.getGRAPHICS() , fromUpfom.getGRAPHICS()};
				for( int index = 0 ; fromList != null && index < fromList.length; index++ ){
					for( java.util.Iterator itera = fromList[index].entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						String fromKEY = (String)fromEntry.getKey();
						Object fromJAVA = fromEntry.getValue();
						if( fromUpfwm.containsKey( fromKEY ) ) continue;
						if( ClassUtils.IClass.isString( fromJAVA ) == false /*非字符串类型*/ ||
								UpfgsmUtils.IUpfsm.isVariable( fromJAVA.toString() ) == false 
								/*字符串类型并且非变量模式*/){
							fromUpfwm.put( fromKEY , fromJAVA );
						}
						else/*字符串类型并且变量模式*/{
							Object aOBJECT = IUpdcpFactory.getIUpfwmSV().
									finishSFUpfvnChain( (String)fromJAVA, 
											fromUpfwm, 
									        aContext);
							if( aOBJECT != null ) fromUpfwm.put( fromKEY , aOBJECT );
						}
					}
				}
			}
			finally{
				
			}
			return fromUpfwm;
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromUpffmx
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpffmxOffer _wrap(IOVUpfwmOffer fromUpfwm,
				IOVUpffmxOffer fromOffer, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVUpfwmOffer.IUpfwmOfferHome fromUpffwm = fromUpfwm.getORDER();
				IOVUpffmxOffer.IUpffmxOfferHome fromUpffmx = fromOffer.getMAPPING();
				String fromDELETE[] = ClassUtils.IClass.transfer( fromUpffmx.getMAPPING(), fromUpfwm);
				ClassUtils.IMerge.purge( fromUpffmx.getMAPPING(), fromDELETE );
				java.util.Map fromUpffx = ICustomX.wrapWithSys( fromUpfwm, fromUpffmx.getMAPPING() );
				if( fromUpffx != null && fromUpffx.size() > 0 ){
					ClassUtils.IMerge.merge( fromUpffx, fromUpffwm.getGRAPHICS() );
					fromUpfwm.setPS_PARAM( ICustom.wrap( fromUpffx ) );
				}
				fromUpffx = ICustomX.wrapWithSys( fromUpfwm, fromUpffmx.getCOMPOSITE() );
				if( fromUpffx != null && fromUpffx.size() > 0 ){
					fromUpfwm.setOLD_PS_PARAM( ICustom.wrap( fromUpffx ) );
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 把属性集按照样例为A1=A1;B1=B1;A2=A2;格式转换
		 * @param fromOffer 激活能力集
		 * @param fromSymbol 分割符
		 * @return
		 */
		public static String wrap( java.util.Map fromOffer ){
			StringBuilder fromUpfwm = new StringBuilder();
			try
			{
				for( java.util.Iterator itera = fromOffer.entrySet().iterator(); itera.hasNext() ; ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					String fromKEY = fromEntry.getKey().toString();
					Object fromPARA = fromEntry.getValue();
					if( fromPARA == null ){ continue; }
					if( StringUtils.startWith( fromKEY, "SYS_" ) ){
						fromKEY = StringUtils.substring( fromKEY, "SYS_".length() );
					}
					if( ClassUtils.IClass.isPrimitive( fromPARA ) == false ){
						fromPARA = JSONUtils.fromBean( fromPARA );
					}
					fromUpfwm.append( fromKEY ).append( "=" ).append( fromPARA.toString() ).append( ";" );
				}
			}
			catch( java.lang.Exception exception ){
				ExceptionFactory.throwRuntime( exception );
			}
			finally{
				
			}
			return fromUpfwm.toString();
		}
		
		/***
		 * 拆分字符串 A=A1;A1=A2;A2=AA;
		 * @param fromJEXP
		 * @param fromOffer
		 * @return
		 */
		public static java.util.Map wrap( String fromJEXP, java.util.Map fromOffer ){
			try
			{
				if( fromOffer == null ) fromOffer = new java.util.HashMap();
				if( StringUtils.isBlank( fromJEXP ) == false ){
					String aCOMPLEX[] = StringUtils.split( fromJEXP , ";" );
					for( int index = 0 ; aCOMPLEX != null && index < aCOMPLEX.length; index++ ){
						String fromCol[] = StringUtils.wildcardTail( aCOMPLEX[index] , "=" );
						if( StringUtils.isBlank( fromCol[0] ) ) continue;
						fromOffer.put( fromCol[0] , fromCol.length > 1?fromCol[1]:"NULL" );
					}
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 把属性集按照样例为A1=A1;B1=B1;A2=A2;格式转换
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 网元指令
		 * @param fromOffer 网元属性
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void wrap( IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm,
				java.util.Map fromOffer,
				IUpdcContext aContext) throws SFException,Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrapWithLmst( Object fromEntity ) throws SFException,Exception{
			IOVUpfwmOffer fromINDEX = null;
			try
			{
				if( fromEntity == null ){
					fromINDEX = null;
				}
				else if( fromEntity instanceof ISAProvision ){
					fromINDEX = new IOVUpfwmOffer( (ISAProvision)fromEntity );
				}
				else if( fromEntity instanceof java.util.Map ){
					fromINDEX = new IOVUpfwmOffer( (java.util.Map)fromEntity );
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
		public static IOVUpfwmRabbit.IUpfwmNotify _wrapWithNotify( MBeanDelegate fromMBean,
				IOVUpfwmOffer fromUpfwm,
				IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
			try
			{
				fromNotify = new IOVUpfwmRabbit.IUpfwmNotify();
				fromNotify.setUSER_ID    ( fromUpfwm.getUSER_ID    () );
				fromNotify.setCATEGORY   ( fromUpfwm.getCOMPOSITE  () );
				fromNotify.setPLATFORM   ( fromUpffm.getID         () );
				fromNotify.setCREATE_DATE( fromUpfwm.getORDER_DATE () );
				fromNotify.setREGION_ID  ( fromUpfwm.getREGION_ID  () );
				fromNotify.setSTATUS     ( fromUpfwm.getSTOP_TYPE  () );
			}
			finally{
				
			}
			return fromNotify;
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromTYPE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrapWithHistory( IOVUpfwmOffer fromUpfwm )  throws SFException,Exception{
			IOVUpfwmOffer fromHistory = null;
			try
			{
				IISAProvision _provision = new ISAProvisionHis();
				java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp(System.currentTimeMillis());
				OracleUtils.ICustom.transfer( fromUpfwm.getINSTANCE(), _provision );
				fromHistory = new IOVUpfwmOffer( _provision );
				if( fromHistory.getEND_DATE() == null ) fromHistory.setEND_DATE(aCOMPLETE);
				if( fromHistory.getRET_DATE() == null ) fromHistory.setRET_DATE(aCOMPLETE);
			}
			finally{
				
			}
			return fromHistory;
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2014-11-28</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class ICustomX{
			public ICustomX(){
				super();
			}
			
			/**
			 * 获取当前网元工单停机类型
			 * @param fromUpfwm 网元工单
			 * @return -1正常,其他则为停机类型(停机类型从0开始)
			 */
			public static long _jj_STOP_TYPE( IOVUpfwmOffer fromUpfwm ){
				long _stoptype = -1;
				try
				{
					java.util.Map fromUpffx = fromUpfwm.getORDER().getSUBFLOW();
					String _stop_type = (String)fromUpffx.get( IUpdcConst.IUpdbm.IUpdbf.STOP_TYPE );
					if( StringUtils.isBlank( _stop_type ) == false ){
						_stoptype = java.lang.Long.parseLong( _stop_type );
					}
				}
				finally{
					
				}
				return _stoptype;
			}
			
			/**
			 * 根据服务任务单构造当前网元工单
			 * @param fromOrder 服务定单
			 * @param fromTASK 服务任务单
			 * @param fromUpdfwm 服务指令
			 * @param fromUpfwm 网元工单
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpfwmOffer _wrap( IOVOrderPentium fromOrder, 
					IOVTaskPentium fromTASK, 
					IOVUpdspmLife fromUpdfwm, 
					IOVUpfwmOffer fromUpfwm,
					IUpdcContext aContext) throws SFException, Exception{
				try
				{
					SFCenterOffer _centeroffer = SFCenterFactory.getCenterInfo();
					MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
					java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
					IProfessionalTemplate.ICompetenceOffer fromBusines = fromOrder.getORDER().getCOMPETENCE();
					IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
					fromUpfwm.setPS_ID      ( UpfwmFactory.getIUpfwmDAO().getPS_ID() );
					fromUpfwm.setCUST_ORDER ( fromOrder.getCUST_ORDER             () );
					fromUpfwm.setDONE_CODE  ( fromOrder.getDONE_CODE              () );
					fromUpfwm.setCATALOG    ( fromBusines.getCATALOG              () );
					if( MathUtils.isNumeric( fromOrder.getCATALOG() ) ){
						fromUpfwm.setCATALOG( MathUtils.decimal( fromOrder.getCATALOG() ) );
					}
					fromUpfwm.setBUSINESS   ( fromBusines.getBUSINESS             () );
					if( MathUtils.isNumeric( fromOrder.getBUSINESS() ) ){
						fromUpfwm.setBUSINESS( MathUtils.decimal( fromOrder.getBUSINESS() ) );
					}
					fromUpfwm.setORDER_ID   ( fromOrder.getORDER_ID               () );
					fromUpfwm.setTASK_ID    ( fromTASK.getTASK_ID                 () );
					fromUpfwm.setCATEGORY   ( fromUpfom.getCATEGORY               () );
					fromUpfwm.setUSER_ID    ( fromOrder.getUSER_ID                () );
					fromUpfwm.setBILL_ID    ( fromOrder.getBILL_ID                () );
					fromUpfwm.setSUB_BILL_ID( fromOrder.getSUB_BILL_ID            () );
					fromUpfwm.setREGION_ID  ( _centeroffer.getREGION_ID           () );
					fromUpfwm.setCREATE_DATE( fromMBean.getCREATE                 () );
					fromUpfwm.setSTART_DATE ( fromCREATE                             );
					fromUpfwm.setPLATFORM   ( fromUpdfwm.getPLATFORM().getID      () );
					fromUpfwm.setDIRECTIVE  ( fromUpdfwm.getDIRECTIVE().getID     () );
					fromUpfwm.setPS_STATUS  ( IUpfwmConst.IUpdos.CREATE              );
					fromUpfwm.setCOMPOSITE  ( fromOrder.getCOMPOSITE              () );
					fromUpfwm.setORDER_DATE ( fromOrder.getORDER_DATE             () );
					fromUpfwm.setPRIORITY   ( fromOrder.getPRIORITY               () );
					fromUpfwm.setSUB_PLAN_NO( fromMBean.getORDER_ID               () );
					fromUpfwm.setSERVICE_ID ( 0                                      );
					fromUpfwm.setRETRY_TIMES( fromUpfom.getREDO_TIMES             () );
					fromUpfwm.setORG_ID     ( IUpdcConst.IEnum.ORGANIZE              );
					if( MathUtils.isNumeric( fromOrder.getORG_ID() ) ){
						fromUpfwm.setORG_ID ( fromOrder.getORG_ID                 () );
					}
					fromUpfwm.setSTAFF_ID   ( IUpdcConst.IEnum.STAFF                 );
					if( MathUtils.isNumeric( fromOrder.getSTAFF_ID() ) ){
						fromUpfwm.setSTAFF_ID( fromOrder.getSTAFF_ID              () );
					}
				}
				finally{
					
				}
				return fromUpfwm;
			}
			
			/**
			 * 
			 * @param fromUpfwm
			 * @param fromOffer
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static java.util.Map wrapWithSys( IOVUpfwmOffer fromUpfwm, java.util.Map fromOffer ) throws SFException,Exception{
				java.util.Map fromUpffmx = new java.util.HashMap();
				try
				{
					IOVUpfwmOffer.IUpfwmOfferHome fromUpffwm = fromUpfwm.getORDER();
					for( java.util.Iterator itera = fromOffer.entrySet().iterator(); itera.hasNext() ; ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						if( fromEntry.getValue() == null ){ continue; }
						String fromKEY = fromEntry.getKey().toString();
						Object fromPARAM = fromEntry.getValue();
						Object fromPARA = fromUpffwm.getCHANGE().get( fromKEY );
						if( StringUtils.startWith( fromKEY, "SYS_" ) ){
							fromKEY = StringUtils.substring( fromKEY, "SYS_".length() );
						}
						else if( fromPARA == null ){
							fromUpffwm.getCHANGE().put( fromKEY, fromPARAM );
						}
						else if( StringUtils.equals( (String)fromPARAM, (String)fromPARA ) ){
							fromUpffwm.getCHANGE().remove( fromKEY );
						}
						else{
							fromUpffwm.getCHANGE().put( fromKEY, fromPARAM );
						}
						fromUpffmx.put( fromKEY, fromPARAM );
					}
				}
				finally{
					
				}
				return fromUpffmx;
			}
			
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 根据JAVA类以及分表路由查询网元级分表路由规范
		 * @param fromJAVA 类路径
		 * @param fromTABLE 表名
		 * @param fromCOLUMN 列名
		 * @param fromOBJECT 列值
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISubTableTemplate.ISubSQLTableCau getSubTableCau( String fromJAVA , 
				String fromTABLE,
				String fromCOLUMN, 
				Object fromOBJECT ) throws SFException,Exception{
			ISubTableTemplate.ISubSQLTableCau fromCAU = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpfm = null;
				fromUpfm = CenterUtils.ICustom.getSFCenterNetWork( fromJAVA );
				fromCAU = IUpdcfgFactory.getIBasicSV().getSFSubTableCau(fromUpfm.getID(), 
						fromTABLE, 
						fromCOLUMN, 
						fromOBJECT.toString() );
			}
			finally{
				
			}
			return fromCAU;
		}
		
		/**
		 * 根据JAVA类以及分表路由查询系统级分表路由规范
		 * @param fromTABLE 表名
		 * @param fromCOLUMN 列名
		 * @param fromOBJECT 列值
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISubTableTemplate.ISubSQLTableCau getSubTableCau(String fromTABLE,
				String fromCOLUMN, 
				Object fromOBJECT ) throws SFException,Exception{
			ISubTableTemplate.ISubSQLTableCau fromCAU = null;
			try
			{
				fromCAU = IUpdcfgFactory.getIBasicSV().getSFSubTableCau(IUpdcConst.IUpfwm.IUpfm.ucmframe, 
						fromTABLE, 
						fromCOLUMN, 
						fromOBJECT.toString() );
			}
			finally{
				
			}
			return fromCAU;
		}
		
		/**
		 * 获取当前网元对应网路路由配置规范
		 * @param fromUpfm 当前网元
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmNetWork getUpffmNetWork( IPlatformTemplate.IUpffmOffer fromUpfm )  throws SFException,Exception{
			IPlatformTemplate.IUpffmNetWork fromNetWork = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
				fromNetWork = fromUpfm.getDIGITAL();
				if( fromNetWork == null ){
					fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( fromUpfm.getID() );
					for( int index = 0 ; fromUpffm != null && index < fromUpffm.length; index++ ){
						fromNetWork = fromUpffm[index].getDIGITAL();
						if( fromNetWork != null ){ break; }
					}
				}
				if( fromNetWork == null ){
					ExceptionFactory.throwIllegal( "IOS0011011", new String[]{ fromUpfm.getID() } );
				}
			}
			finally{
				
			}
			return fromNetWork;
		}
	}
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 判断接口表中PS_PARAM和OLD_PS_PARAM是否相同
		 * 1.判断PsParam和OldPsParam是否相同
		 * 2.如(1)判断结果为false则PsParam和OldPsParam其中是否为空，则返回false
		 * @param fromOrder
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isCHANGE(IOVOrderPentium fromOrder,
				java.util.Map fromUpfwm,
				IUpdcContext aContext) throws SFException, Exception{
			boolean fromEqual = false;
			java.util.Map fromNEW = null,fromOLD = null;
			try
			{   
				String aPsParam = (String)fromUpfwm.get( IISAProvision.S_PsParam );
				String oPsParam = (String)fromUpfwm.get( IISAProvision.S_OldPsParam );
				if(  StringUtils.isBlank( aPsParam ) == false &&  aPsParam.endsWith(";") ){
					aPsParam = StringUtils.substring( aPsParam, 0, aPsParam.length()-1 );
				}
				if(  StringUtils.isBlank( oPsParam ) == false &&  oPsParam.endsWith(";") ){
					oPsParam = StringUtils.substring( oPsParam, 0, oPsParam.length()-1 );
				}
				fromNEW = JdomUtils.ICustom.wrap( aPsParam , (String)null );
				fromOLD = JdomUtils.ICustom.wrap( oPsParam , (String)null );
				fromEqual = ClassUtils.IMerge.equals( fromOLD, fromNEW )?false:true;
			}
			finally{
				if( fromNEW != null ){ fromNEW.clear(); fromNEW = null;}
				if( fromOLD != null ){ fromOLD.clear(); fromOLD = null;}
			}
			return fromEqual;
		}
		
		/**
		 * 判断网元属性是否变化
		 * @param fromUpffxm 网元属性规范
		 * @param fromUpfwm 网元功能属性 
		 * @return
		 */
		public static boolean isCHANGE( IPlatformTemplate.IUpffxOffer fromUpffxm, java.util.Map fromUpfwm){
			boolean fromChange = false;
			try
			{
				if( fromUpfwm.get( fromUpffxm.getID() ) != null ){
					String fromPARA = fromUpfwm.get( fromUpffxm.getID() ).toString();
					fromChange = fromUpffxm.isFUNCTION() && StringUtils.contains( 
							fromPARA, new String[]{IUpfwmConst.IUpdfs.D,
									IUpfwmConst.IUpdfs.U } ) == false;
				}
			}
			finally{
				
			}
			return fromChange;
		}
		
		/**
		 * 是否为网元工单容器
		 * @param aOBJECTIVE
		 * @return
		 */
		public static boolean isPROVISION( Object aOBJECTIVE ){
			return aOBJECTIVE != null && aOBJECTIVE instanceof ISAProvision;
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
				fromNotify = fromEntity != null && ( fromEntity instanceof ISAProvision ) &&
						((ISAProvision)fromEntity).isNew();
			}
			finally{
				
			}
			return fromNotify;
		}
		
		/**
		 * 是否为到期工单
		 * @param fromEntity
		 * @return
		 */
		public static boolean isEXPIRE( Object fromEntity ){
			boolean fromEXPIRE = false;
			try
			{
				fromEXPIRE = fromEntity != null && ( fromEntity instanceof ISAProvision );
				if( fromEXPIRE == true ){
					ISAProvision fromUpfwm = ((ISAProvision)fromEntity);
					fromEXPIRE = fromUpfwm.isNew() && StringUtils.equals( fromUpfwm.getComposite(), 
							IUpdcConst.IUpdbm.IUpdbf.EXPIRE );
				}
			}
			finally{
				
			}
			return fromEXPIRE;
		}
		
		/**
		 * 是否为网元定单历史归档策略
		 * @param fromOrder
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isHISTORY(IOVUpfwmOrder fromOrder, IUpdcContext aContext) throws SFException, Exception{
			boolean fromHistory = false;
			try
			{
				fromHistory = fromOrder.isACHIEVE();
				if( fromHistory == false/*网元异常转监控策略*/){
					IOVUpdspmLife fromUpdfwm = fromOrder.getORDER().getBottom();
					fromHistory = fromUpdfwm == null || fromUpdfwm.getOPERATE() == null ? true
							: (fromUpdfwm.getOPERATE().isMONITOR() ? false : true);
				}
			}
			finally{
				
			}
			return fromHistory;
		}
		
		/**
		 * 判断是否为网元属性(以^开头)
		 * @param aFEATURE 网元属性编码
		 * @return
		 */
		public static boolean isPARAM( String aFEATURE ){
			return StringUtils.isBlank( aFEATURE ) && 
			         StringUtils.startWith( aFEATURE, "^");
		}
	}
}
