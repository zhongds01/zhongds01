package com.ai.sacenter.receive.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.ISystemResultHome;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.valuebean.IOVRocketOffer;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFTextMessage;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.receive.valuebean.IOVMsgFRsRspHome;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOrderRsRspHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年5月2日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OrderUtils {
	private final static Log log = LogFactory.getLog( OrderUtils.class );
	public OrderUtils() {
		super();
	}
	
    public static class ICustom{
    	public ICustom(){
    		super();
    	}
    	
		/**
		 * 
		 * @param fromOffer
		 * @return
		 */
		public static String _mergex( IOVRocketOffer fromOffer ){
			StringBuilder fromMsgF = new StringBuilder();
			try
			{
				IBeanWrapper fromWrapper = new IBeanWrapper( fromOffer );
				for( int index = 0 ; index < 20; index++ ){
					String aCOMPLEX = ClassUtils.getINDEX( new String[]{"MSG_",index < 9 ?
							"0":"",String.valueOf( index + 1 ) } );
					aCOMPLEX = (String)fromWrapper.getPropertyValue( aCOMPLEX );
					if( StringUtils.isBlank( aCOMPLEX ) ) continue;
					fromMsgF.append( aCOMPLEX );
				}
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromMsgF.toString();
		}
		
		/**
		 * 根据开通消息获取开通定单实体
		 * @param fromRocket 开通消息
		 * @param fromUpdcpm 开通接入能力
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFRequest _wrap(IOVRocketExigence fromRocket,
				IUpfgkmOfferHome fromUpdcpm) throws SFException, Exception{
			IOVMsgFRequest fromRequest = null;
			try
			{
				fromRequest = new IOVMsgFRequest( );
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromRequest.setROCKET_ID       ( fromRocket.getROCKET_ID      () );
				fromRequest.setCUST_ORDER      ( fromRocket.getCUST_ORDER     () );
				fromRequest.setCATALOG         ( fromRocket.getCATALOG        () );
				fromRequest.setBUSINESS        ( fromRocket.getBUSINESS       () );
				fromRequest.setBATCHES         ( fromRocket.getBATCHES        () );
				fromRequest.setORIGINATOR      ( fromRocket.getORIGINATOR     () );
				fromRequest.setCHANNEL         ( fromRocket.getCHANNEL        () );
				fromRequest.setUSER_ID         ( fromRocket.getUSER_ID        () );
				fromRequest.setBILL_ID         ( fromRocket.getBILL_ID        () );
				fromRequest.setREGION_ID       ( fromRocket.getREGION_ID      () );
				fromRequest.setPRIORITY        ( fromRocket.getPRIORITY       () );
				fromRequest.setCOMPOSITE       ( fromRocket.getCOMPOSITE      () );
				fromRequest.setDONE_CODE       ( fromRocket.getORDER_ITEM_ID  () );
				fromRequest.setDONE_DATE       ( fromRocket.getDONE_DATE      () );
				fromRequest.setORDER_REGION_ID ( fromRocket.getORDER_REGION_ID() );
				fromRequest.setORG_ID          ( fromRocket.getORG_ID         () );
				fromRequest.setSTAFF_ID        ( fromRocket.getSTAFF_ID       () );
				fromRequest.setORGIN_XML       ( fromRocket.getORDER().getBODY() );
				fromRequest.getORDER().setOBJECTIVE( fromRocket             );
				fromRequest.getORDER().setCREATOR  ( fromMBean.getCREATOR() );
				if( StringUtils.isBlank( fromRequest.getORGIN_XML() ) == false ){
					org.dom4j.Element fromRoot = XmlUtils.parseXml( fromRequest.getORGIN_XML() );
		    		for( java.util.Iterator<org.dom4j.Element> itera = fromRoot.elements("UserOrderInfo").iterator(); itera.hasNext(); ){
		    			org.dom4j.Element userOrderInfo = (org.dom4j.Element)itera.next();
		    			fromRequest.getUSER().add( new IOVMsgFUser( userOrderInfo ) );
		    		}
		    		for( java.util.Iterator<org.dom4j.Element> itera = fromRoot.elements("RelateUserOrderInfo").iterator(); itera.hasNext(); ){
		    			org.dom4j.Element userOrderInfo = (org.dom4j.Element)itera.next();
		    			fromRequest.getCENTREX().add( new IOVMsgFUser( userOrderInfo ) );
		    		}
				}
			}
			finally{
				
			}
			return fromRequest;
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
    	
    	public static class ISystemX{
    		public ISystemX(){
    			super();
    		}
    	}
    }
    public static class IRocket{
    	public IRocket(){
    		super();
    	}
    	/**
    	 * 
    	 * @param fromRocket
    	 * @return
    	 * @throws SFException
    	 * @throws Exception
    	 */
		public static IOVRocketExigence _jj_rocket( RocketFMessage fromRocket )throws SFException,Exception{
			IOVRocketExigence fromRequest = null;
			try
			{
				ISystemTemplate.IUpdbfsOffer fromProtection = null;
				RocketFTextMessage _rocket = RocketUtils.ICustom._jj_rocket( fromRocket );
				fromRequest = new IOVRocketExigence( _rocket.getText() );
				SFCenterFactory.pushCenterInfo( IUpdcConst.IUpdbm.IUpdmc.CUSTOM_ID, fromRequest );
				try
				{
					fromRequest.setROCKET_ID  ( UpdbfsFactory.getIUpffmxSV().getROCKET_ID         ()  );
					fromRequest.setPLWK_CREATE( fromRequest.getCREATE_DATE                        ()  );
					fromRequest.setREGION_ID  ( SFCenterFactory.getCenterInfo().getREGION_ID      ()  );
				}
				finally{
					SFCenterFactory.popCenterInfo();
				}
				fromProtection = IOrderFactory.getIOrdMixSV().getSFMsgFPriority( fromRequest );
				fromRequest.setPRIORITY   ( fromProtection.getPRIORITY                        ()  );
				fromRequest.setCOMPOSITE  ( fromProtection.getCOMPOSITE                       ()  );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param aEXCEPTION
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVRocketExigence _jj_rocket( RocketFMessage fromRocket, 
				SFException aEXCEPTION ) throws SFException,Exception{
			IOVRocketExigence fromRequest = null;
			SFCenterFactory.pushCenterInfo( CenterUtils.ISystem._region_id() );
			try
			{
				String fromXML = RocketUtils.ICustom._jj_message( fromRocket );
				fromRequest = new IOVRocketExigence( fromXML, aEXCEPTION );
				fromRequest.setROCKET_ID  ( UpdbfsFactory.getIUpffmxSV().getROCKET_ID   () );
				fromRequest.setPLWK_CREATE( fromRequest.getCREATE_DATE                  () );
				fromRequest.setREGION_ID  ( SFCenterFactory.getCenterInfo().getREGION_ID() );
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromASK
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _jj_response( IOVMsgFResponse fromASK ) throws SFException,Exception{
			String fromXML = null;
			try
			{
				SFException exception = null;
				IOVMsgFRsRspHome fromRsRsp = fromASK.getRESULT();
				if( StringUtils.isBlank( fromASK.getRESULT().getRspCode() ) ){
					exception = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, fromRsRsp.getRspDesc() );
					fromASK.getRESULT().setRspCode( exception.getFaultCode() );
					fromASK.getRESULT().setRspDesc( exception.getMessage  () );
				}
				fromXML = fromASK.getAsXml();
			}
			finally{
				
			}
			return fromXML;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromOrdRsRsp
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFResponse _jj_response( IOVMsgFRequest fromRequest, 
				IOVOrderResponse fromOrdRsRsp, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFResponse fromASK = null;
			try
			{
				fromASK = new IOVMsgFResponse();
				IRocket.IRocketX._wrap( fromRequest, fromASK );
				SFException aEXCEPTION = IRocket.IRocketX._wrap( fromOrdRsRsp );
				fromASK.getRESULT().setRspCode( aEXCEPTION.getFaultCode () );
				fromASK.getRESULT().setRspDesc( aEXCEPTION.getMessage   () );
				if( fromOrdRsRsp != null ){
					IRocket.IRocketX._wrapWithRsRsp( fromOrdRsRsp, fromASK );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		/**
		 * 
		 * @param fromRequest
		 * @param fromOrdRsRsp
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFResponse _jj_response( IOVRocketExigence fromRequest, 
				IOVOrderResponse fromOrdRsRsp,
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFResponse fromASK = null;
			try
			{
				fromASK = new IOVMsgFResponse();
				IRocket.IRocketX._wrap(fromRequest, fromASK);
				SFException aEXCEPTION = IRocket.IRocketX._wrap( fromOrdRsRsp );
				fromASK.getRESULT().setRspCode( aEXCEPTION.getFaultCode () );
				fromASK.getRESULT().setRspDesc( aEXCEPTION.getMessage   () );
				if( fromOrdRsRsp != null ){
					IRocket.IRocketX._wrapWithRsRsp( fromOrdRsRsp, fromASK );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromRsRsp
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFResponse _jj_response( IOVUpfwmOffer fromUpfwm,
				IOVUpfwmResponse fromRsRsp ) throws SFException, Exception {
			IOVMsgFResponse fromASK = null;
			try
			{
				fromASK = new IOVMsgFResponse();
				IRocket.IRocketX._wrap(fromUpfwm, fromASK);
				SFException aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, "" );
				fromASK.getRESULT().setRspCode( aEXCEPTION.getFaultCode () );
				fromASK.getRESULT().setRspDesc( aEXCEPTION.getMessage   () );
				if( fromRsRsp != null ){
					if( fromRsRsp != null && fromRsRsp.isFAILURE() ) {
						aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.REMOTE, fromRsRsp.getRspDesc() );
					}
					fromASK.getRESULT().setRspCode( aEXCEPTION.getFaultCode () );
					fromASK.getRESULT().setRspDesc( aEXCEPTION.getMessage   () );
					if( fromRsRsp.getRspResult() != null ){
						fromASK.getRESULT().setRspResult( fromRsRsp.getRspResult() );
					}
					if( fromRsRsp.getRspBody() != null ){ 
						fromASK.getRESULT().setRspBody( fromRsRsp.getRspBody  () );
					}
				}
			}
			finally{
				
			}
			return fromASK;
		}
		
    	public static class IRocketX{
        	public IRocketX(){
        		super();
        	}
        	
			/**
			 * 
			 * @param fromBusiInfo
			 * @param fromRequest
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrapWithRocket( String fromBusiInfo, IOVRocketExigence fromRequest ) throws SFException, Exception{
				try
				{
					fromRequest.getORDER().setBODY( fromBusiInfo );
					String fromBody[] = SystemUtils.ICustom.substringAsL( fromRequest.getORDER().getBODY() );
					for( int index = 0,fromSortBy = 10000; fromBody != null && index < fromBody.length; fromSortBy++ ){
						IOVRocketOffer fromOffer = IRocket.IRocketX._wrapWithOffer( fromRequest, fromSortBy );
						IBeanWrapper fromMBean = new IBeanWrapper( fromOffer );
						for( int fromINDEX = 0; fromBody != null && index < fromBody.length && fromINDEX < 20; fromINDEX++,index++ ){
							String fromFIELD = ClassUtils.getINDEX( new String[]{"MSG_",fromINDEX < 9 ?"0":"",
									String.valueOf( fromINDEX + 1 ) } );
							fromMBean.setPropertyValue( fromFIELD, fromBody[index] );
						}
						fromRequest.getORDER().getORDER().add( fromOffer );
					}
				}
				finally{
					
				}
			}
			/**
			 * 
			 * @param fromRequest
			 * @param fromSortBy
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVRocketOffer _wrapWithOffer( IOVRocketExigence fromRequest, int fromSortBy ) throws SFException, Exception{
				IOVRocketOffer fromOffer = null;
				try
				{
					fromOffer = new IOVRocketOffer();
					fromOffer.setORDER_ID     ( fromRequest.getROCKET_ID    () );
					fromOffer.setUSER_ID      ( fromRequest.getUSER_ID      () );
					fromOffer.setSORT_BY      ( fromSortBy                     );
					fromOffer.setCREATE_DATE  ( fromRequest.getCREATE_DATE  () );
					fromOffer.setREGION_ID    ( fromRequest.getREGION_ID    () );
					fromOffer.setSTATE        ( IUpdbfsConst.IState.C          );
					fromOffer.setCOMPLETE_DATE( fromRequest.getCOMPLETE_DATE() );
				}
				finally{
					
				}
				return fromOffer;
			}
			/**
			 * 
			 * @param fromRsRsp
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static SFException _wrap( Object fromRsRsp ) throws SFException, Exception{
				SFException aEXCEPTION = null;
				try
				{
					if( fromRsRsp == null /*默认成功*/){
						aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, "" );
					}
					else if( fromRsRsp instanceof IOVOrderResponse ){
						IOVOrderResponse fromOrdRsRsp = (IOVOrderResponse)fromRsRsp;
						if( fromOrdRsRsp.getRESULT().getRspCode() == null ){
							aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, 
									fromOrdRsRsp.getRESULT().getRspDesc() );
						}
						else{
							aEXCEPTION = ExceptionFactory.getException( fromOrdRsRsp.getRESULT().getRspCode(), 
									fromOrdRsRsp.getRESULT().getRspDesc() );
						}
					}
					else if( fromRsRsp instanceof IOVMsgFResponse ){
						IOVMsgFResponse fromOrdRsRsp = (IOVMsgFResponse)fromRsRsp;
						if( fromOrdRsRsp.getRESULT().getRspCode() == null ){
							aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, 
									fromOrdRsRsp.getRESULT().getRspDesc() );
						}
						else{
							aEXCEPTION = ExceptionFactory.getException( fromOrdRsRsp.getRESULT().getRspCode(), 
									fromOrdRsRsp.getRESULT().getRspDesc() );
						}
					}
				}
				finally{
					
				}
				return aEXCEPTION;
			}
			
			/**
			 * 
			 * @param fromOrder
			 * @param fromRsRspHome
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFRsRspHome _wrap( IOVUpdbsComplete fromOrder, IOVMsgFRsRspHome fromRsRspHome ) throws SFException,Exception{
				try
				{
					SFException aEXCEPTION = ExceptionFactory.getException( fromOrder.getPLWK_CODING(), 
							fromOrder.getPLWK_DESCRIBE() );
					fromRsRspHome.setRspCode  ( aEXCEPTION.getFaultCode       () );
					fromRsRspHome.setRspDesc  ( aEXCEPTION.getMessage         () );
					if( StringUtils.isBlank( fromOrder.getASKING() ) == false ){
						try
						{
							java.util.Map<Object,Object> fromXPaths = new java.util.HashMap<Object,Object>();
							XmlUtils.XPath( fromOrder.getASKING(), fromXPaths  );
							fromRsRspHome.setRspBody  ( fromXPaths             );
						}
						catch( java.lang.Exception aException ){
							log.error( aException.getMessage(), aException );
						}
						finally{
							
						}
					}
				}
				finally{
					
				}
				return fromRsRspHome;
			}
			
			/**
			 * 
			 * @param fromRocket
			 * @param fromASK
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrap(IOVRocketExigence fromRocket, IOVMsgFResponse fromASK) throws SFException, Exception{
				try
				{
					fromASK.setCUST_ORDER( fromRocket.getCUST_ORDER     () );
					fromASK.setCATALOG   ( fromRocket.getCATALOG        () );
					fromASK.setBUSINESS  ( fromRocket.getBUSINESS       () );
					fromASK.setORIGINATE ( fromRocket.getORIGINATOR     () );
					fromASK.setCHANNEL   ( fromRocket.getCHANNEL        () );
					fromASK.setUSER_ID   ( fromRocket.getUSER_ID        () );
					fromASK.setBILL_ID   ( fromRocket.getBILL_ID        () );
					fromASK.setREGION_ID ( fromRocket.getORDER_REGION_ID() );
					fromASK.setDONE_CODE ( fromRocket.getORDER_ITEM_ID  () );
					fromASK.setDONE_DATE ( fromRocket.getDONE_DATE      () );
					fromASK.setORG_ID    ( fromRocket.getORG_ID         () );
					fromASK.setSTAFF_ID  ( fromRocket.getSTAFF_ID       () ); 
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param fromRequest
			 * @param fromASK
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrap(IOVMsgFRequest fromRequest, IOVMsgFResponse fromASK) throws SFException, Exception{
				try
				{
					fromASK.setCUST_ORDER( fromRequest.getCUST_ORDER     () );
					fromASK.setCATALOG   ( fromRequest.getCATALOG        () );
					fromASK.setBUSINESS  ( fromRequest.getBUSINESS       () );
					fromASK.setORIGINATE ( fromRequest.getORIGINATOR     () );
					fromASK.setCHANNEL   ( fromRequest.getCHANNEL        () );
					fromASK.setUSER_ID   ( fromRequest.getUSER_ID        () );
					fromASK.setBILL_ID   ( fromRequest.getBILL_ID        () );
					fromASK.setREGION_ID ( fromRequest.getORDER_REGION_ID() );
					fromASK.setDONE_CODE ( fromRequest.getDONE_CODE      () );
					fromASK.setDONE_DATE ( fromRequest.getDONE_DATE      () );
					fromASK.setORG_ID    ( fromRequest.getORG_ID         () );
					fromASK.setSTAFF_ID  ( fromRequest.getSTAFF_ID       () ); 
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param fromUpfwm
			 * @param fromASK
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFResponse _wrap( IOVUpfwmOffer fromUpfwm, IOVMsgFResponse fromASK ) throws SFException, Exception{
				try
				{
					fromASK.setCUST_ORDER( String.valueOf( fromUpfwm.getPS_ID()       ) );
					fromASK.setUSER_ID   ( fromUpfwm.getUSER_ID                      () );
					fromASK.setCATALOG   ( IUpdbfsConst.IUpdbm.ICatalog.CATALOG         );
					fromASK.setBUSINESS  ( IUpdbfsConst.IUpdbm.IBusines.BUSINES         );
					fromASK.setORIGINATE ( IUpdbfsConst.IUpdbm.ICustom.ORIGINATOR       );
					fromASK.setCHANNEL   ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL          );
					fromASK.setBILL_ID   ( fromUpfwm.getBILL_ID                      () );
					fromASK.setREGION_ID ( fromUpfwm.getREGION_ID                    () );
					fromASK.setDONE_CODE ( String.valueOf( fromUpfwm.getSUB_PLAN_NO() ) );
					fromASK.setDONE_DATE ( fromUpfwm.getCREATE_DATE                  () );
					fromASK.setORG_ID    ( IUpdbfsConst.IUpdbm.ICustom.ORGANIZE         );
					fromASK.setSTAFF_ID  ( IUpdbfsConst.IUpdbm.ICustom.STAFF            );
				}
				finally{
					
				}
				return fromASK;
			}
				
			/**
			 * 
			 * @param fromOrdRsRsp
			 * @param fromASK
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFResponse _wrapWithRsRsp(IOVOrderResponse fromOrdRsRsp, IOVMsgFResponse fromASK) throws SFException, Exception{
				try
				{
					if( fromOrdRsRsp != null && fromOrdRsRsp.getRESULT() != null ){
						IOrderRsRspHome fromRsRspHome = fromOrdRsRsp.getRESULT();
						ISystemResultHome fromResult = fromRsRspHome.getRspBody();
						if( fromResult != null && fromResult.getRspResult() != null ){
							fromASK.getRESULT().setRspResult( fromResult.getRspResult() );
						}
						if( fromResult != null && fromResult.getRspBody() != null ){
							fromASK.getRESULT().setRspBody( fromResult.getRspBody() );
						}
					}
				}
				finally{
					
				}
				return fromASK;
			}
        }
    	public static class IIRsRsp{
			public IIRsRsp(){
				super();
			}
			
			/**
			 * 
			 * @param fromASK
			 * @param fromPubInfo
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrap( IOVMsgFResponse fromASK, 
					org.dom4j.Element fromPubInfo ) throws SFException,Exception{
				try
				{
					fromPubInfo.addElement( "CustomerOrderId" ).setText( fromASK.getCUST_ORDER() );
					fromPubInfo.addElement( "ProdSpec"        ).setText( fromASK.getCATALOG   () );
					fromPubInfo.addElement( "BusinessId"      ).setText( fromASK.getBUSINESS  () );
					fromPubInfo.addElement( "OriginId"        ).setText( fromASK.getORIGINATE () );
					fromPubInfo.addElement( "ChannelId"       ).setText( fromASK.getCHANNEL   () );
					fromPubInfo.addElement( "RegionId"        ).setText( fromASK.getREGION_ID () );
					fromPubInfo.addElement( "UserId"          ).setText( String.valueOf(fromASK.getUSER_ID() ) );
					fromPubInfo.addElement( "OrgId"           ).setText( fromASK.getORG_ID    () );
					fromPubInfo.addElement( "StaffId"         ).setText( fromASK.getSTAFF_ID  () );
					fromPubInfo.addElement( "DoneCode"        ).setText( fromASK.getDONE_CODE () );
					fromPubInfo.addElement( "DoneDate"        ).setText( TimeUtils.yyyymmddhhmmss( fromASK.getDONE_DATE() ) );
				}
				finally{
					
				}
			}
			/**
			 * 
			 * @param fromNODE
			 * @param fromPARAM
			 * @param fromRoot
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _gvp_wrap_complex( String fromNODE, Object fromPARAM, org.dom4j.Element fromRoot ) throws SFException,Exception{
				try
				{
					org.dom4j.Element fromElement = null;
					if( fromPARAM == null || ClassUtils.IClass.isPrimitive( fromPARAM ) ){
						fromElement = fromRoot.addElement( fromNODE );
						if( fromPARAM != null ){ fromElement.setText( fromPARAM.toString() ); }
					}
					else if( ClassUtils.IClass.isArray( fromPARAM ) ){
						Object fromArray[] = (Object[])fromPARAM;
						for( int index = 0; index < fromArray.length; index++ ){
							IIRsRsp._gvp_wrap_complex(fromNODE, fromArray[index], fromRoot);
						}
					}
					else if( ClassUtils.IClass.isMap( fromPARAM ) ){
						java.util.Map<String,Object> fromMap = (java.util.Map<String,Object>)fromPARAM;
						fromElement = fromRoot.addElement( fromNODE );
						for( java.util.Iterator<java.util.Map.Entry<String,Object>> itera = fromMap.entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry<String,Object> fromEntry = (java.util.Map.Entry<String,Object>)itera.next();
							IIRsRsp._gvp_wrap_complex( (String)fromEntry.getKey(), fromEntry.getValue(), fromElement);
						}
					}
					else if( ClassUtils.IClass.isList( fromPARAM ) ){
						java.util.List<Object> fromList = (java.util.List<Object>)fromPARAM;
						for( java.util.Iterator<Object> itera = fromList.iterator(); itera.hasNext(); ){
							IIRsRsp._gvp_wrap_complex( fromNODE, itera.next(), fromRoot);
						}
					}
					else{
						fromElement = fromRoot.addElement( fromNODE );
						IBeanWrapper fromWrapper = new IBeanWrapper( fromPARAM );
						java.beans.PropertyDescriptor _descriptor[] = fromWrapper.getPropertyDescriptors();
						for( int index = 0; _descriptor != null && index < _descriptor.length; index++ ){
							fromPARAM = fromWrapper.getPropertyValue( _descriptor[index].getName() );
							IIRsRsp._gvp_wrap_complex(_descriptor[index].getName(), fromPARAM, fromElement);
						}
					}
				}
				finally{
					
				}
			}
		}
    }
    public static class IIfElse{
    	public IIfElse(){
    		super();
    	}
    	/**
    	 * 服务产品是否归属服务开通域
    	 * @param fromOffer
    	 * @return
    	 */
    	public static boolean isCOMPETE( IOVMsgFOffer fromOffer ){
    		boolean fromBELONG = true;
    		try
    		{
    			IProfessionalTemplate.IProductOffer fromUSED = null;
    			fromUSED = IOrderFactory.getIProductSV().getSFProductBelong( fromOffer );
    			fromBELONG = fromUSED != null?true:false;
    		}
    		catch( java.lang.Exception aEXCEPTION ){
    			log.error( aEXCEPTION.getMessage(), aEXCEPTION );
    			fromBELONG = true;
    		}
    		finally{
    			
    		}
    		return fromBELONG;
    	}
    }
}
