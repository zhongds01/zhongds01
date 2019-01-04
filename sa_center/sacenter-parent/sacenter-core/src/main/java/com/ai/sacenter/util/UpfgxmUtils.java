package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.suggest.IUpfgxmConst;
import com.ai.sacenter.suggest.UpfgxmFactory;
import com.ai.sacenter.suggest.bo.ISASuggest;
import com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年11月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfgxmUtils {
	public UpfgxmUtils() {
		super();
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 
		 * @param fromOrder
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgxmPentium _wrap( IOVOrderPentium fromOrder,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgxmPentium fromSuggest = null;
			try
			{
				fromSuggest = new IOVUpfgxmPentium();
				java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
				fromSuggest.setMQMSG_ID       ( UpfgxmFactory.getIUpfgxmDAO().getPLMQ_ID  () );                   
				fromSuggest.setCUST_ORDER     ( fromOrder.getCUST_ORDER                   () );                   
				fromSuggest.setDONE_CODE      ( fromOrder.getDONE_CODE                    () );
				fromSuggest.setCATEGORY       ( IUpfgxmConst.IUpdbm.IUpdbf.PLATFORM          );
				fromSuggest.setORDER_ID       ( fromOrder.getORDER_ID                     () );          
				fromSuggest.setPLQK_ID        ( fromOrder.getORDER_ID                     () );          
				fromSuggest.setUSER_ID        ( fromOrder.getUSER_ID                      () );          
				fromSuggest.setPROGRAM        ( fromUpdcpm.getPROGRAM().getPROGRAM().getID() );          
				fromSuggest.setCREATE_DATE    ( fromCREATE                                   );          
				fromSuggest.setREGION_ID      ( fromOrder.getREGION_ID                    () );          
				fromSuggest.setSTATE          ( IUpdcConst.IState.C                          );
				fromSuggest.setCOMPLETE_DATE  ( fromCREATE                                   );   
				fromSuggest.setORDER_REGION_ID( fromOrder.getORDER_REGION_ID              () );
				fromSuggest.setORG_ID         ( fromOrder.getORG_ID                       () );          
				fromSuggest.setSTAFF_ID       ( fromOrder.getSTAFF_ID                     () );
			}
			finally{
				
			}
			return fromSuggest;
		}
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfgxmPentium _wrap( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfgxmPentium fromSuggest = null;
			try
			{
				fromSuggest = ICustom._wrap(fromOrder, fromUpdcpm, aContext   );
				fromSuggest.setPLQK_ID ( fromTASK.getTASK_ID                ());
				fromSuggest.setCATEGORY( IUpfgxmConst.IUpdbm.IUpdbf.PLATFORM );
			}
			finally{
				
			}
			return fromSuggest;
		}
		/**
		 * 
		 * @param aSuggest
		 * @param fromSuggest
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( ISASuggest aSuggest, 
				IOVUpfgxmPentium fromSuggest ) throws SFException,Exception{
			try
			{
				fromSuggest.setMQMSG_ID       ( aSuggest.getMqmsgId      () );            
				fromSuggest.setCUST_ORDER     ( aSuggest.getCustOrder    () );            
				fromSuggest.setDONE_CODE      ( aSuggest.getDoneCode     () );
				fromSuggest.setCATEGORY       ( aSuggest.getCategory     () ); 
				fromSuggest.setORDER_ID       ( aSuggest.getOrderId      () );            
				fromSuggest.setPLQK_ID        ( aSuggest.getPlqkId       () );            
				fromSuggest.setUSER_ID        ( aSuggest.getUserId       () );            
				fromSuggest.setPROGRAM        ( aSuggest.getProgram      () );             
				fromSuggest.setCREATE_DATE    ( aSuggest.getCreateDate   () );            
				fromSuggest.setREGION_ID      ( aSuggest.getRegionId     () );            
				fromSuggest.setSTATE          ( aSuggest.getState        () );
				fromSuggest.setORDER_REGION_ID( aSuggest.getOrderRegionId() );
				fromSuggest.setCOMPLETE_DATE  ( aSuggest.getCompleteDate () );            
				fromSuggest.setMSG_01         ( aSuggest.getMsg01        () );            
				fromSuggest.setMSG_02         ( aSuggest.getMsg02        () );            
				fromSuggest.setMSG_03         ( aSuggest.getMsg03        () );            
				fromSuggest.setMSG_04         ( aSuggest.getMsg04        () );            
				fromSuggest.setMSG_05         ( aSuggest.getMsg05        () );            
				fromSuggest.setMSG_06         ( aSuggest.getMsg06        () );            
				fromSuggest.setMSG_07         ( aSuggest.getMsg07        () );            
				fromSuggest.setMSG_08         ( aSuggest.getMsg08        () );            
				fromSuggest.setMSG_09         ( aSuggest.getMsg09        () );            
				fromSuggest.setMSG_10         ( aSuggest.getMsg10        () );            
				fromSuggest.setMSG_11         ( aSuggest.getMsg11        () );            
				fromSuggest.setMSG_12         ( aSuggest.getMsg12        () );            
				fromSuggest.setMSG_13         ( aSuggest.getMsg13        () );            
				fromSuggest.setMSG_14         ( aSuggest.getMsg14        () );            
				fromSuggest.setMSG_15         ( aSuggest.getMsg15        () );            
				fromSuggest.setMSG_16         ( aSuggest.getMsg16        () );            
				fromSuggest.setMSG_17         ( aSuggest.getMsg17        () );            
				fromSuggest.setMSG_18         ( aSuggest.getMsg18        () );            
				fromSuggest.setMSG_19         ( aSuggest.getMsg19        () );            
				fromSuggest.setMSG_20         ( aSuggest.getMsg20        () );            
				fromSuggest.setFAIL_LOG       ( aSuggest.getFailLog      () );            
				fromSuggest.setORG_ID         ( aSuggest.getOrgId        () );            
				fromSuggest.setSTAFF_ID       ( aSuggest.getStaffId      () );     
			}
			finally{
				
			}
		}
		
		/**
		 * 根据服务定单转换开通归档单主体
		 * @param fromOrder 服务定单
		 * @param fromTarget 服务归档单
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVOrderPentium fromOrder, 
				IOVUpdbsComplete fromTarget ) throws SFException,Exception{
			try
			{
				IProfessionalTemplate.ICompetenceOffer fromComplete = null;
				java.util.Map fromGlobal = UpfsvcManager.getMBean().getGraphics();
				java.sql.Timestamp fromCREATE = UpdcFactory.getIUpdcDAO().getSysdate();
				fromComplete = fromOrder.getORDER().getCOMPETENCE();
				fromTarget.setORDER_ID        ( fromOrder.getORDER_ID     () );
				fromTarget.setCUST_ORDER      ( fromOrder.getCUST_ORDER   () );
				fromTarget.setDONE_CODE       ( fromOrder.getDONE_CODE    () );
				fromTarget.setCATALOG         ( fromOrder.getCATALOG      () );
				fromTarget.setBUSINESS        ( fromOrder.getBUSINESS     () );
				fromTarget.setUSER_ID         ( fromOrder.getUSER_ID      () );
				fromTarget.setBILL_ID         ( fromOrder.getBILL_ID      () );
				fromTarget.setREGION_ID       ( fromOrder.getREGION_CODE  () );
				String aPLWK_IDO[] = (String[])fromGlobal.get( fromOrder );
				if( aPLWK_IDO != null && aPLWK_IDO != null && aPLWK_IDO.length > 0 ){
					fromTarget.setPLWK_IDO     ( aPLWK_IDO[0] );
				}                           
				fromTarget.setCOMPLETE       ( fromComplete.getCOMPLETE    () );
				fromTarget.setORDER_REGION_ID( fromOrder.getORDER_REGION_ID() );
				fromTarget.setORDER_DATE     ( fromCREATE                     );
				fromTarget.setCREATE_DATE    ( fromCREATE                     );
				fromTarget.setORG_ID         ( fromOrder.getORG_ID         () );
				fromTarget.setSTAFF_ID       ( fromOrder.getSTAFF_ID       () );
				fromTarget.setCHANNEL        ( fromOrder.getCHANNEL        () );
				fromTarget.setSTATE          ( IUpdcConst.IState.C            );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdfmx
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap groupAsOffer( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IOVUpdbsComplete fromUpdfmx ) throws SFException,Exception{
			try
			{
				IOVOrderPentium.IOrderOfferHome fromOrderHome = fromOrder.getORDER();
				if( fromTASK != null && fromTASK.getORDER().getOFFER() != null ){
					IOVOfferPentium fromOrdOffer = fromTASK.getORDER().getOFFER();
					UpdcUtils.ICustom._wrap( fromOrdOffer, fromUpdfmx.getORDER().getSUBFLOW() );
				}
				else/*按照服务产品配置[主体服务/承载服务]*/{
					IProfessionalTemplate.IProductOffer fromUpdcpm = null;
					IProfessionalTemplate.IProductComptel fromUpffmx = null;
					for( java.util.Iterator itera = fromOrderHome.getOFFER().iterator(); itera.hasNext(); ){
						IOVOfferPentium fromOrdOffer = (IOVOfferPentium)itera.next();
						fromUpdcpm = UpdcpUtils.ISystem.getCOMPETE( fromOrdOffer.getCOMPETE_ID() );
						fromUpffmx = fromUpdcpm != null?fromUpdcpm.getCOMPTEL():null;
						if( StringUtils.isBlank( fromOrdOffer.getSUBFLOW() ) /*全局变量*/){
							UpdcUtils.ICustom._wrap( fromOrdOffer, fromUpdfmx.getORDER().getSUBFLOW() );
						}
						else if( fromUpffmx != null && fromUpffmx.getCOMBINE().isMASS() /*基本服务*/){
							UpdcUtils.ICustom._wrap( fromOrdOffer, fromUpdfmx.getORDER().getSUBFLOW() );
						}
						else if( fromUpffmx != null && fromUpffmx.getCOMBINE().isBASIC()/*承载服务*/ ){
							UpdcUtils.ICustom._wrap( fromOrdOffer, fromUpdfmx.getORDER().getSUBFLOW() );
						}
					}
				}
			}
			finally{
				
			}
			return fromUpdfmx.getORDER().getSUBFLOW();
		}
		
		/**
		 * 根据发起方构造服务归档组件
		 * @param fromTarget 服务归档单
		 * @param fromUpdcmpt 解决组件
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVUpdbsComplete fromTarget, 
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromTarget, fromUpdcmpt );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromTarget.getCOMPLETE() ) );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.TARGET, fromTarget );
				ClassUtils.IMerge.merge( fromTarget.getORDER().getSUBFLOW(), fromUpdcpm.getSUBFLOW() );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		/**
		 * 根据发起方构造解决组件实体
		 * @param fromTarget 反馈定单
		 * @param fromUpdcmpt 解决组件
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVUpdbsComplete fromTarget, 
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
				SFException aEXCEPTION) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				IOVUpfwmResponse fromUpffmx = null;
				IPlatformTemplate.IUpffmsOffer fromUpffms = null;		
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromTarget, fromUpdcmpt, aEXCEPTION );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromTarget.getCOMPLETE() ) );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.TARGET, fromTarget );
				ClassUtils.IMerge.merge( fromTarget.getORDER().getSUBFLOW(), fromUpdcpm.getSUBFLOW() );
				try
				{
					fromUpffms = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( aEXCEPTION );
					fromUpffmx = SystemUtils.ICustom._wrap( fromTarget, fromUpffms, aEXCEPTION );
				}
				catch( java.lang.Exception exception ){
					fromUpffmx = SystemUtils.ICustom._wrap( fromTarget, null, aEXCEPTION );
					try
					{
						fromUpffms = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( aEXCEPTION.getFaultCode(), 
								aEXCEPTION.getOriginator() );
					}
					catch( java.lang.Exception _exception ){
						
					}
				}
				fromUpdcpm.getPROGRAM().setRESPOND( fromUpffms );
				fromUpdcpm.getASKING().setHOMEING ( fromUpffmx );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param aEXCEPTION
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium[] getSFSuggestTask( IOVOrderPentium fromOrder,
				IOVTaskPentium[] fromTASK, 
				SFException aEXCEPTION,
	            IUpdcContext aContext) throws SFException, Exception{
			java.util.List fromSuggest = new java.util.ArrayList();
			try
			{
				IOVTaskPentium.ITaskOfferHome fromTaskHome = null;
				for( int index = 0; fromTASK != null && index < fromTASK.length; index++ ){
					fromTaskHome = fromTASK[index].getORDER();
					if( fromTaskHome.getSUGGEST() != null ){fromSuggest.add( fromTASK[index] );}
				}
			}
			finally{
				
			}
			return (IOVTaskPentium[])fromSuggest.toArray( new IOVTaskPentium[]{} );
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
	}
}
