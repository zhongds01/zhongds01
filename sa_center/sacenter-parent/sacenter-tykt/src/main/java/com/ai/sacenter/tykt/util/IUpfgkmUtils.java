package com.ai.sacenter.tykt.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISAProvisionHis;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.tykt.IUpfgkmConst;
import com.ai.sacenter.tykt.bo.IISAEquipment;
import com.ai.sacenter.tykt.valuebean.IOVKtSyncRequest;
import com.ai.sacenter.tykt.valuebean.IOVKtSyncResponse;
import com.ai.sacenter.tykt.valuebean.IOVUpfgkmOffer;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年8月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmUtils {

	public IUpfgkmUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
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
		public static IOVUpfgkmOffer _wrap( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgkmOffer fromINDEX = null;
			try
			{
				fromINDEX = new IOVUpfgkmOffer();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromINDEX.setPS_ID          ( fromUpfwm.getPS_ID          () );
				fromINDEX.setBUSI_CODE      ( fromUpfwm.getBUSINESS       () );
				fromINDEX.setDONE_CODE      ( fromUpfwm.getDONE_CODE      () );
				fromINDEX.setPS_TYPE        ( Integer.parseInt( fromUpfom.getPS_TYPE() ) );
				fromINDEX.setPRIO_LEVEL     ( fromUpfwm.getPRIORITY       () );
				fromINDEX.setPS_SERVICE_TYPE( fromUpfom.getPS_SERVICE     () );
				fromINDEX.setBILL_ID        ( fromUpfwm.getBILL_ID        () );
				fromINDEX.setSUB_BILL_ID    ( fromUpfwm.getSUB_BILL_ID	 () );
				fromINDEX.setSUB_VALID_DATE ( fromUpfwm.getCREATE_DATE    () );
				fromINDEX.setUPP_CREATE_DATE( fromUpfwm.getCREATE_DATE    () );
				fromINDEX.setCREATE_DATE    ( fromUpfwm.getCREATE_DATE    () );
				fromINDEX.setSTATUS_UPD_DATE( fromUpfwm.getCREATE_DATE    () );
				fromINDEX.setSTART_DATE     ( fromUpfwm.getSTART_DATE     () );
				fromINDEX.setACTION_ID      ( Long.parseLong( fromUpfom.getCODE() ) );
				fromINDEX.setOLD_PS_PARAM   ( fromUpfwm.getOLD_PS_PARAM   () );
				fromINDEX.setPS_PARAM       ( fromUpfwm.getPS_PARAM       () );
				fromINDEX.setTARGET_PARAM   ( fromUpfwm.getTARGET_PARAM   () );
				fromINDEX.setPS_STATUS      ( IUpfgkmConst.IUpfwm.CREATE     );
				fromINDEX.setREGION_ID      ( fromUpfwm.getREGION_ID      () );
				fromINDEX.setSTOP_TYPE      ( (int)fromUpfwm.getSTOP_TYPE () );
				fromINDEX.setPS_NET_CODE    ( fromUpfwm.getPS_NET_CODE    () );
				fromINDEX.setSERVICE_ID     ( (int)fromUpfwm.getSERVICE_ID() );
				fromINDEX.setSUB_PLAN_NO    ( fromMBean.getORDER_ID()        );
				fromINDEX.setCOMPOSITE      ( fromUpfwm.getCOMPOSITE      () );
				fromINDEX.setORDER_DATE     ( fromUpfwm.getORDER_DATE     () );
				fromINDEX.setUSER_ID        ( fromUpfwm.getUSER_ID()         );
				fromINDEX.setRETRY_TIMES    ( (int)fromUpfom.getREDO_TIMES() );
				fromINDEX.setORG_ID         ( Long.parseLong( fromUpfwm.getORG_ID  () )%1000000000 );
				fromINDEX.setOP_ID          ( Long.parseLong( fromUpfwm.getSTAFF_ID() )%1000000000  );
				fromINDEX.setSOURCE_ID      ( IUpfgkmConst.IUpfwm.IChannel.CENTER );
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromORACLE
		 * @param fromSubJect
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IISAEquipment _wrap( ISystemTemplate.IUpfgkmComposite fromORACLE, HQSQLEntityBean fromSubJect ) throws SFException,Exception{
			IISAEquipment fromSubSQL = null;
			try
			{
				fromSubSQL = (IISAEquipment)ClassUtils.IClass.getASTBOEntity( fromORACLE.getPERSISTENT() );
				HQSQLUtils.ICustom.transfer( fromSubJect, (DataContainer)fromSubSQL );
			}
			finally{
				
			}
			return fromSubSQL;
		}
		
		/**
		 * 网元工单转换为统一开通实时接口请求
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 网元指令
		 * @param fromKtSync 网元请求
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVKtSyncRequest _wrap( IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IOVKtSyncRequest fromKtSync,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
				fromKtSync.setPsId         ( fromUpfwm.getPS_ID                 () );
				fromKtSync.setDoneCode     ( fromUpfwm.getDONE_CODE             () );
				fromKtSync.setBillId       ( fromUpfwm.getBILL_ID               () );
				fromKtSync.setRegionId     ( fromUpfwm.getREGION_ID             () );
				fromKtSync.setPsServiceType( fromUpfom.getPS_SERVICE            () );
				fromKtSync.setActionId     ( Long.parseLong( fromUpfom.getCODE() ) );
				fromKtSync.setPsParam      ( ""                                    );
				fromKtSync.setPsNetCode    ( fromUpffm.getCODE                  () );
				SFCenterOffer fromRoute = CenterUtils.ISystem._custom( fromKtSync  );
				fromKtSync.setRegionId     ( fromRoute.getREGION_ID             () );
				if( StringUtils.isBlank( fromUpfwm.getPS_PARAM() ) == false ){
					fromKtSync.setPsParam  ( fromUpfwm.getPS_PARAM              () );
					if( StringUtils.contains( fromKtSync.getPsParam() , ";" ) ){
						fromKtSync.setPsParam( StringUtils.replace( fromKtSync.getPsParam(), ";", "$@$" ) );
					}
				}
				
			}
			finally{
				
			}
			return fromKtSync;
		}
		/**
		 * 统一开通实时网元应答转换为网元工单应答集
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 网元指令
		 * @param fromKtSync 网元应答
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmResponse _wrap( IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm,
				IOVKtSyncResponse fromKtSync,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfwmResponse fromASK = null;
			try
			{
				IOVKtSyncResponse.IOVKySyncRsRsp fromRsResult = null;
				fromASK = new IOVUpfwmResponse( fromUpfwm );
				fromRsResult = fromKtSync.getRspResult();
				fromASK.setFAILURE   ( Boolean.TRUE                               );
				fromASK.setRspCode   ( String.valueOf( fromKtSync.getPsStatus() ) );
				fromASK.setRspDesc   ( fromKtSync.getFailReason                () );
				fromASK.setRspResult ( fromKtSync.getRspResult().getRspResult  () );
				fromASK.setRspBottom ( fromKtSync.getOriginal                  () );
				if( fromKtSync.isSUCCEED() ){
					fromASK.setFAILURE( Boolean.FALSE                             );
				}
				if( StringUtils.isBlank( fromRsResult.getRspCode() ) == false ){
					fromASK.setRspCode( String.valueOf( fromRsResult.getRspCode () ) );
				}
				if( StringUtils.isBlank( fromRsResult.getRspDesc() ) == false ){
					fromASK.setRspDesc( String.valueOf( fromRsResult.getRspDesc () ) );
				}
				
				if( fromRsResult.getRspBody() != null && fromRsResult.getRspBody().size() > 0 ){
					java.util.Map fromRsBody = new java.util.HashMap( );
					ClassUtils.IMerge.merge ( fromRsResult.getRspBody(), fromRsBody );
					fromASK.setRspBody( fromRsBody );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		/**
		 * 将基于人机指令(MML)转换为开通所需要报文
		 * @param fromMML 人机指令
		 * @param fromKtSync 网元应答
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map _wrapWithMML( String fromMML, 
				IOVKtSyncResponse fromKtSync) throws SFException, Exception{
			java.util.Map fromKtRsRsp = new java.util.HashMap();
			try
			{
				IOVKtSyncResponse.IOVKySyncRsRsp fromRsResult = null;
				fromMML = IICustom._wrapWithSMML( fromMML );
				java.util.Map fromResult[] = null;
				fromRsResult = fromKtSync.getRspResult();
				String fromSMML[][] = StringUtils.wildcardSplite( fromMML, ";" );
				if( fromSMML != null && fromSMML.length > 0 ){
					String fromSMMLX = null,fromSMMLT = null;
					for( int index = 0 ; index < fromSMML.length; index++ ){
						if( fromSMML[index].length < 2 ) continue;
						fromSMML[index][0] = fromSMML[index][0].trim();
						fromKtRsRsp.put( fromSMML[index][0], fromSMML[index][1].trim() );
						if( StringUtils.equals( fromSMML[index][0], "ATTR" ) ){
							fromSMMLX = fromSMML[index][1].trim();
						}
						else if( StringUtils.equals( fromSMML[index][0], "RESULT" ) ){
							fromSMMLT = fromSMML[index][1].trim();
						}
						else if( StringUtils.equals( fromSMML[index][0], "RETN" ) ){
							fromRsResult.setRspCode( fromSMML[index][1].trim() ) ;
						}
						else if( StringUtils.equals( fromSMML[index][0], "DESC" ) ){
							fromRsResult.setRspDesc( fromSMML[index][1] ) ;
						}
					}
					if( StringUtils.isBlank( fromSMMLX ) == false && StringUtils.isBlank( fromSMMLX ) == false ){
						fromResult = IICustom._wrapWithSMMLT(fromSMMLX, fromSMMLT);
						if( fromResult != null && fromResult.length > 0 ){
							ClassUtils.IMerge.purge( fromKtRsRsp, new String[]{"ATTR", "RESULT"} );
							if( fromResult.length > 1 ) fromKtRsRsp.put( "RESULT", fromResult );
							else fromKtRsRsp.put( "RESULT", fromResult[0] );
						}
					}
				}
			}
			finally{
				
			}
			return fromKtRsRsp;
		}
		/**
		 * 
		 * @param fromMML
		 * @param fromKtSync
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map _wrapWithPARAM( String fromMML, 
				IOVKtSyncResponse fromKtSync) throws SFException, Exception{
			java.util.Map fromRsBody = new java.util.HashMap();
			try
			{
				UpfwmUtils.ICustom.wrap( fromMML, fromRsBody );
			}
			finally{
				
			}
			return fromRsBody;
		}
		/**
		 * 
		 * @param fromMML
		 * @param fromKtSync
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map _wrapWithAAA( String fromMML, 
				IOVKtSyncResponse fromKtSync) throws SFException, Exception{
			java.util.Map fromRsBody = new java.util.HashMap();
			try
			{
				IOVKtSyncResponse.IOVKySyncRsRsp fromKtRsRsp = fromKtSync.getRspResult();
				String fromPARAM[] = StringUtils.substring( fromMML, "{", "}" );
				for( int index = 0 ; fromPARAM != null && index < fromPARAM.length; index++ ){
					String fromKEY = ClassUtils.getINDEX( new String[]{"RETN_",String.valueOf( index ) } );
					if( StringUtils.equals( fromKEY, "RETN_1" ) ){
						fromKtRsRsp.setRspCode( fromPARAM[index] );
					}
					else if( StringUtils.equals( fromKEY, "RETN_2" ) ){
						fromKtRsRsp.setRspDesc( fromPARAM[index] );
					}
					fromRsBody.put( fromKEY , fromPARAM[index] );
				}
			}
			finally{
				
			}
			return fromRsBody;
		}
		public static class IICustom{
			public IICustom(){
				super();
			}
			/**
			 * 将基于人机指令(MML)去掉特殊字符转换为标准人机指令(MML)
			 * @param fromMML 人机指令
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static String _wrapWithSMML( String fromMML ) throws SFException, Exception{
				try
				{
					if( StringUtils.startWith( fromMML, "ACK" ) ){
						fromMML = StringUtils.substringAfter( StringUtils.substringAfter( 
								fromMML , ":" ),":");
					}
					if( StringUtils.endsWith(fromMML, ";") || StringUtils.endsWith(fromMML, ",") ){
						fromMML = StringUtils.substring(fromMML, 0, fromMML.length() - 1);
					}
					if(StringUtils.contains( fromMML, "," ) ){
						fromMML = StringUtils.replace(fromMML, ",", ";");
					}
					fromMML = StringUtils.replace( fromMML , "\"" , "" );
				}
				finally{
					
				}
				return fromMML;
			}
			/**
			 * 
			 * @param fromSMMLX
			 * @param fromSMMLT
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static java.util.Map[] _wrapWithSMMLT( String fromSMMLX, 
					String fromSMMLT ) throws SFException, Exception{
				java.util.Map[] fromSMML = null;
				try
				{
					String fromMML[] = new String[]{ fromSMMLT };
					if( StringUtils.contains( fromSMMLT , "|" ) ){ 
						fromMML = StringUtils.wildcardArray( fromSMMLT , "&" );
		    			for(int index = 0 ; index < fromMML.length ; index++){ 
		    				fromMML[index] = StringUtils.replace( fromMML[index] , "|" , "&" );
		    			}
					}
					fromSMML = new java.util.HashMap[ fromMML.length ];
					String fromAttr[] = StringUtils.wildcardArray( fromSMMLX, "&" );
					for( int index = 0; index < fromMML.length; index++ ){
						String fromResult[] = StringUtils.wildcardArray( fromMML[index] ,  "&" );
						if( fromResult.length < fromAttr.length ){
							ExceptionFactory.throwRemote("IOS0012012", new String[]{fromSMMLT});
						}
						fromSMML[index] = new java.util.HashMap();
						for(int aINDEX = 0 ; aINDEX < fromAttr.length ; aINDEX++ ){
							fromSMML[index].put( fromAttr[aINDEX].trim() , StringUtils.replace( 
									fromResult[aINDEX].trim(), "\"", "") );
		    			}
					}
		    	}
				finally{
					
				}
				return fromSMML;
			}
		}
		
		/**
		 * 
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgkmOffer _wrapWithLmst( Object fromEntity ) throws SFException,Exception{
			IOVUpfgkmOffer fromINDEX = null;
			try
			{
				if( fromEntity == null ){
					fromINDEX = null;
				}
				else if( fromEntity instanceof IISAEquipment ){
					fromINDEX = new IOVUpfgkmOffer( (IISAEquipment)fromEntity );
				}
				else if( fromEntity instanceof java.util.Map ){
					fromINDEX = new IOVUpfgkmOffer( (java.util.Map)fromEntity );
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _jj_history( IOVUpfgkmOffer fromOrder ) throws SFException,Exception{
			IOVUpfwmOffer fromHistory = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromORACLE = null;
				ObjectType _objecttype = fromOrder.getINSTANCE().getObjectType();
				fromORACLE = HQSQLUtils.ISystem.getSFUpfgkmTable( _objecttype.getMapingEnty() );
				if( fromORACLE != null && StringUtils.isBlank( fromORACLE.getHISTORY() ) == false ){
					IISAProvision _provision = new ISAProvisionHis();
					OracleUtils.ICustom.transfer( fromOrder.getINSTANCE(), _provision );
					fromHistory = new IOVUpfwmOffer( _provision );
				}
			}
			finally{
				
			}
			return fromHistory;
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
		public static IOVUpfwmRabbit.IUpfwmNotify _wrapWithNotify(MBeanDelegate fromMBean,
				IOVUpfgkmOffer fromUpfwm,
				IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
			IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
			try
			{
				fromNotify = new IOVUpfwmRabbit.IUpfwmNotify();
				fromNotify.setUSER_ID     ( fromUpfwm.getUSER_ID   () );
				fromNotify.setCATEGORY    ( fromUpfwm.getCOMPOSITE () );
				if( fromNotify.isEXPIRE() == false/*非到期工单*/){
					fromNotify.setCATEGORY( IUpdcConst.IUpdbm.IUpdbf.NORMAL  );
				}
				fromNotify.setPLATFORM    ( fromUpffm.getID        () );
				fromNotify.setCREATE_DATE ( fromUpfwm.getORDER_DATE() );
				fromNotify.setREGION_ID   ( fromUpfwm.getREGION_ID () );
				fromNotify.setSTATUS      ( fromUpfwm.getSTOP_TYPE () );
			}
			finally{
				
			}
			return fromNotify;
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
		/**
		 * 功能变更工单是否有效
		 * @param fromUpfwm
		 * @param fromUpdfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isCHANGE(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException,Exception{
			boolean fromCHANGE = false;
			try
			{
				IOVUpfwmOffer.IUpfwmOfferHome fromOffer = fromUpfwm.getORDER();
				fromCHANGE = fromUpfwm != null && fromOffer.getCHANGE() != null && 
						fromOffer.getCHANGE().size() > 0;
			}
			finally{
			
			}
			return fromCHANGE;
		}
		/**
		 * 是否为网元工单容器
		 * @param aOBJECTIVE
		 * @return
		 */
		public static boolean isPROVISION( Object aOBJECTIVE ){
			return aOBJECTIVE != null && aOBJECTIVE instanceof IISAEquipment;
		}
	}

}
