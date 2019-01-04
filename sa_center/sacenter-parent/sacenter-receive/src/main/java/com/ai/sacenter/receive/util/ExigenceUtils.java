package com.ai.sacenter.receive.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.ISystemResultHome;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFESBusException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.provision.valuebean.IOVUpfwmUatmix;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.exigence.IExigenceConst;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderBase;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderMain;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderMinor;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketOffer;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketCompose;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFTextMessage;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.receive.valuebean.IOVMsgFRsRspHome;
import com.ai.sacenter.target.UpdbsFactory;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOrderRsRspHome;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExigenceUtils {
	public ExigenceUtils() {
		super();
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param fromMBean
		 * @param aEXCEPTION
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketExigence _wrap( MBeanDelegate fromMBean, 
				SFException aEXCEPTION, 
				IOVMocketExigence fromRocket ) throws SFException,Exception{
			try
			{
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromRocket.setCOMPLETE_DATE( fromMBean.getCOMPLETE            () );
				if( aEXCEPTION != null && aEXCEPTION instanceof SFESBusException ){
					fromRocket.setSTATE        ( IUpdcConst.IState.X                    );
					fromRocket.setFAIL_CODE    ( aEXCEPTION.getFaultCode             () );
					fromRocket.setFAIL_REASON  ( aEXCEPTION.getMessage               () );
					fromRocket.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
				}
				else if( aEXCEPTION != null ){
					fromRocket.setSTATE        ( IUpdcConst.IState.E                    );
					fromRocket.setFAIL_CODE    ( aEXCEPTION.getFaultCode             () );
					fromRocket.setFAIL_REASON  ( aEXCEPTION.getMessage               () );
					fromRocket.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
				}
				else if( fromRocket.isHISTORY() || fromRocket.isCOMPLETE() ){
					
				}
				else{
					fromRocket.setFAIL_CODE    ( null                                  );
					fromRocket.setFAIL_REASON  ( null                                  );
					fromRocket.setFAIL_LOG     ( null                                  );
					fromRocket.setSTATE        ( IUpdcConst.IState.O                   );
					fromRocket.setCOMPLETE_DATE( fromMBean.getCOMPLETE             ()  );
				}
				for( java.util.Iterator<IOVMocketOffer> itera = fromRocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVMocketOffer fromOffer = (IOVMocketOffer)itera.next();
					fromOffer.setCOMPLETE_DATE( fromRocket.getCOMPLETE_DATE() );
				}
			}
			finally{
				
			}
			return fromRocket;
		}
		/**
		 * 
		 * @param fromRocket
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbsComplete _wrap( IOVMocketExigence fromRocket, 
				IOVUpdbsComplete fromTarget ) throws SFException, Exception{
			try
			{
				java.sql.Timestamp fromCREATE = UpdcFactory.getIUpdcDAO().getSysdate();
				fromTarget.setORDER_ID       ( fromRocket.getORDER_ID                 () );
				fromTarget.setCUST_ORDER     ( fromRocket.getCUST_ORDER               () );
				fromTarget.setDONE_CODE      ( fromRocket.getDONE_CODE                () );
				fromTarget.setCATALOG        ( fromRocket.getCATALOG_ID               () );
				fromTarget.setBUSINESS       ( fromRocket.getBUSINESS_ID              () );
				fromTarget.setUSER_ID        ( fromRocket.getUSER_ID                  () );
				fromTarget.setBILL_ID        ( fromRocket.getBILL_ID                  () );
				fromTarget.setREGION_ID      ( fromRocket.getREGION_ID                () );
				fromTarget.setPLWK_IDO       ( String.valueOf( fromRocket.getORDER_ID()) );
				fromTarget.setORDER_REGION_ID( fromRocket.getORDER_REGION_ID          () );
				fromTarget.setORDER_DATE     ( fromCREATE                                );
				fromTarget.setCREATE_DATE    ( fromCREATE                                );
				fromTarget.setORG_ID         ( fromRocket.getORG_ID                   () );
				fromTarget.setSTAFF_ID       ( fromRocket.getSTAFF_ID                 () );
				fromTarget.setCHANNEL        ( fromRocket.getCHANNEL_ID               () );
				fromTarget.setSTATE          ( IUpdcConst.IState.C                       );
			}
			finally{
				
			}
			return fromTarget;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromNotify
		 * @param fromUpdcpm
		 * @param aEXCEPTION
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbsComplete _wrap( IOVMocketExigence fromRocket, 
				IOVUpdbsComplete fromNotify,
				IOVUpdcpmOffer fromUpdcpm, 
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			java.util.Map<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				ExigenceUtils.ICustom._wrap( fromRocket, fromNotify );
				fromNotify.setMQMSG_ID     ( UpdbsFactory.getIUpdbsDAO().getORDER_ID            () );
				fromNotify.setORDER_ID     ( UpdbsFactory.getIUpdbsDAO().getORDER_ID            () );
				fromNotify.setCOMPLETE     ( fromUpdcpmHome.getPROGRAM().getID                  () );
				fromPARAM.put( IExigenceConst.IUpdbm.IUpdbf.USER_ID, String.valueOf( 
						fromRocket.getUSER_ID() ) );
				fromPARAM.put( IExigenceConst.IUpdbm.IUpdbf.BILL_ID, fromRocket.getBILL_ID      () );
				fromPARAM.put( IExigenceConst.IUpdbm.IUpdbf.ORIGINATOR, fromRocket.getORIGINATOR() );
				fromNotify.mergeAsComplex  ( fromPARAM                                             );
				fromNotify.setPLWK_CODING  ( aEXCEPTION.getFaultCode                            () );
				fromNotify.setPLWK_DESCRIBE( StringUtils.trimRight( aEXCEPTION.getMessage(), 100 ) );
				fromNotify.setCOMPLETE_DATE( fromMBean.getCREATE                                () );
			}
			finally{
				if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			}
			return fromNotify;
		}
		
		/**
		 * 
		 * @param fromMBean
		 * @param fromRocket
		 * @param fromUpffmx
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmUatmix _wrap( MBeanDelegate fromMBean, 
				IOVMocketExigence fromRocket,
				IOVUpfwmUatmix fromUpffmx,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				fromUpffmx.setORDER_ID 	 ( fromRocket.getCUST_ORDER                () );	
				fromUpffmx.setDONE_CODE	 ( fromRocket.getDONE_CODE                 () );	
				fromUpffmx.setUSER_ID	 ( fromRocket.getUSER_ID	               () );	
				fromUpffmx.setBILL_ID	 ( fromRocket.getBILL_ID	               () );	
				fromUpffmx.setCREATE_DATE( fromRocket.getCREATE_DATE               () );
				fromUpffmx.setREGION_ID	 ( fromRocket.getREGION_ID                 () );	
				fromUpffmx.setSTATE      ( fromRocket.getSTATE                     () );
				fromUpffmx.setPLATFORM	 ( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_ROCKET    );	
				fromUpffmx.setPLWK_IDO	 ( String.valueOf( fromRocket.getORDER_ID() ) );	
				fromUpffmx.setIMPLCLASS  ( fromMBean.getREPOSITORY().getName       () );
				fromUpffmx.setFAIL_LOG   ( fromRocket.getFAIL_LOG                  () );
				fromUpffmx.setSTAFF_ID   ( IUpdcConst.IEnum.STAFF                     );
				fromUpffmx.setORG_ID     ( IUpdcConst.IEnum.ORGANIZE                  );
			}
			finally{
				
			}
			return fromUpffmx;
		}
		public static class ICustomX{
			public ICustomX(){
				super();
			}
			
			/**
			 * 
			 * @param fromBusiInfo
			 * @param fromExigence
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrapWithBusiInfo( String fromBusiInfo, 
					IOVMocketExigence fromExigence ) throws SFException, Exception{
				try
				{
					fromExigence.getORDER().setBODY( fromBusiInfo );
					String fromBody[] = SystemUtils.ICustom.substringAsL( fromExigence.getORDER().getBODY() );
					for( int index = 0,fromSortBy = 10000; fromBody != null && index < fromBody.length; fromSortBy++ ){
						IOVMocketOffer fromOsOffer = new IOVMocketOffer();
						fromOsOffer.setORDER_ID     ( fromExigence.getORDER_ID       () );
						fromOsOffer.setUSER_ID      ( fromExigence.getUSER_ID        () );
						fromOsOffer.setSORT_BY      ( fromSortBy                        );
						fromOsOffer.setCREATE_DATE  ( fromExigence.getCREATE_DATE    () );
						fromOsOffer.setREGION_ID    ( fromExigence.getREGION_ID      () );
						fromOsOffer.setSTATE        ( fromExigence.getSTATE          () );
						fromOsOffer.setCOMPLETE_DATE( fromExigence.getCOMPLETE_DATE  () );
						IBeanWrapper fromMBean = new IBeanWrapper( fromOsOffer );
						for( int fromINDEX = 0; fromBody != null && index < fromBody.length && fromINDEX < 20; fromINDEX++,index++ ){
							String fromFIELD = ClassUtils.getINDEX( new String[]{"MSG_",fromINDEX < 9 ?"0":"",
									String.valueOf( fromINDEX + 1 ) } );
							fromMBean.setPropertyValue( fromFIELD, fromBody[index] );
						}
						fromExigence.getORDER().getORDER().add( fromOsOffer );
					}
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param fromOffer
			 * @return
			 */
			public static String _mergex( IOVMocketOffer fromOffer ){
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
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 获取人工跳单原因
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFException getCOMPLETE( IOVMocketExigence fromRocket ) throws SFException,Exception{
			SFException aCOMPLETE = null;
			try
			{
				aCOMPLETE = ExceptionFactory.getException(IUpdcConst.IUpdfx.COMPLETE, 
						new String[]{ fromRocket.getCATALOG_ID(),fromRocket.getBUSINESS_ID() } );
			}
			finally{
				
			}
			return aCOMPLETE;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IBusinesOffer getBUSINESS( IOVMocketExigence fromRocket ) throws SFException,Exception{
			IProfessionalTemplate.IBusinesOffer __business__ = null;
			try
			{
				__business__ = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromRocket.getCATALOG_ID(), 
						fromRocket.getBUSINESS_ID(), 
						fromRocket.getORIGINATOR(), 
						IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
			}
			finally{
				
			}
			return __business__;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.lang.reflect.Method getBUSINESS( IOVMocketExigence fromRocket,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			java.lang.reflect.Method fromMethod = null;
			try
			{
				ISystemTemplate.IImplCapital fromCapital = null;
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				if( fromUpdcpm != null ) fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
				if( fromBusines != null ){
					fromCapital = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromBusines.getIMPLCLASS() );
					fromMethod = fromCapital.getMethod( new Class[]{IOVMocketExigence.class, 
							IUpfgkmOfferHome.class, 
							IUpdcContext.class} );
				}
			}
			finally{
				
			}
			return fromMethod;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.lang.reflect.Method getBUSINESS( IOVMsgFExigence fromRocket,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			java.lang.reflect.Method fromMethod = null;
			try
			{
				ISystemTemplate.IImplCapital fromCapital = null;
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				if( fromUpdcpm != null ) fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
				if( fromBusines != null ){
					fromCapital = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromBusines.getIMPLCLASS() );
					fromMethod = fromCapital.getMethod( new Class[]{IOVMsgFExigence.class, 
							IUpfgkmOfferHome.class, 
							IUpdcContext.class} );
				}
			}
			finally{
				
			}
			return fromMethod;
		}
		
		/**
		 * 根据开通定单项获取开通定单组件资产
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProgramTemplate.IUpdpgmOffer getPROGRAM(IOVMocketExigence fromRocket) throws SFException, Exception{
			IProgramTemplate.IUpdpgmOffer fromUpdcpm = null;
			try
			{
				IUpfgkmOfferHome fromUpfgkmHome = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
				if( fromUpfgkmHome == null /*无次开通业务*/){
					fromUpdcpm = UpdcpmUtils.getPROGRAM();
				}
				else/*根据当前开通定单项接入获取开通组件*/{
					IProfessionalTemplate.ICompetenceOffer competence = null;
					competence = UpdcpmUtils.getCOMPETENCE( fromUpfgkmHome.getCATALOG().getBUSINES().getCOMPETENCE() );
					if( competence != null && StringUtils.isBlank( competence.getCOMPLETE() ) == false ){
						fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdpgmOffer( competence.getCOMPLETE() );
					}
				}
			}
			catch( java.lang.Exception exception ){
				fromUpdcpm = UpdcpmUtils.getPROGRAM();
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据开通定单项获取开通异常定单项归档组件
		 * @param fromRocket 开通定单项
		 * @param fromUpdcpm 开通组件资产
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.lang.reflect.Method getCOMPLETE(IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			java.lang.reflect.Method fromMethod = null;
			try
			{
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = null;
				if( fromUpdcpm != null ){ fromUpdcpmHome = fromUpdcpm.getPROGRAM(); }
				if( fromUpdcpmHome != null && fromUpdcpmHome.getCOMPONENT() != null ){
					ISystemTemplate.IImplCapital fromCapital = fromUpdcpm.getPROGRAM().getIMPLCLASS();
					fromMethod = fromCapital.getMethod( new Class[]{MBeanDelegate.class,
							IOVMocketExigence.class, 
							IOVUpdcpmOffer.class,
							SFException.class,
							IUpdcContext.class} );
				}
			}
			finally{
				
			}
			return fromMethod;
		}
		
		/**
		 * 根据开通定单项获取开通定单分解组件
		 * @param fromRocket 开通定单项
		 * @param fromUpdcpm 开通接入能力
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IBusinesKernel getCOMPOSE( IOVMsgFExigence fromRocket, IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception{
			IProfessionalTemplate.IBusinesKernel fromUpdfmsx = null;
			try
			{
				IProfessionalTemplate.IBusinesCombine fromCombine = null;
				if( fromUpdcpm != null ){ fromCombine = fromUpdcpm.getCATALOG().getPROGRAM(); }
				if( fromCombine != null ){ fromUpdfmsx = fromCombine.getPROGRAM( IUpdbfsConst.IUpdbm.ICache.PROGRAM_COMPOSE ); } 
			}
			finally{
				
			}
			return fromUpdfmsx;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param aEXCEPTION
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer getROCKET( IOVMocketExigence fromRocket, SFException aEXCEPTION, IUpdcContext aContext ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				IOVUpfwmResponse __response__ = null;
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromRocket, aEXCEPTION );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.ROCKET, fromRocket );
				__response__ = SystemUtils.ICustom._wrap( fromRocket, fromUpdcpmHome.getRESPOND(), aEXCEPTION );
				fromUpdcpm.getASKING().setHOMEING ( __response__ );
			}
			finally{
				
			}
			return fromUpdcpm;
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
		 * @param fromXML
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketExigence _jj_mocket( RocketFMessage fromRocket ) throws SFException,Exception{
			IOVMocketExigence fromExigence = null;
			try
			{
				RocketFTextMessage _rocket = RocketUtils.ICustom._jj_rocket( fromRocket );
				org.dom4j.Element fromRoot = XmlUtils.parseXml( _rocket.getText() );
				org.dom4j.Element element = RocketUtils.IMetaX._jj_element( fromRoot, "PubInfo", false );
				fromExigence = new IOVMocketExigence( element );				
				fromExigence.setCREATE_DATE( new java.sql.Timestamp( System.currentTimeMillis()));	
				SFCenterOffer fromCenter = CenterUtils.ISystem._custom( fromExigence );
				fromExigence.setREGION_ID  ( fromCenter.getREGION_ID                          ());	
				
				element = RocketUtils.IMetaX._jj_element( fromRoot, "BusiInfo", false );
				ICustom.ICustomX._wrapWithBusiInfo( element.getTextTrim(), fromExigence );
			}
			finally{
				
			}
			return fromExigence;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param aEXCEPTION
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketExigence _jj_mocket( RocketFMessage fromRocket, SFException aEXCEPTION ) throws SFException,Exception{
			IOVMocketExigence fromExigence = null;
			try
			{
				fromExigence = new IOVMocketExigence();
				java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
				fromExigence.setCUST_ORDER     ( String.valueOf( System.currentTimeMillis ()  ) );
				fromExigence.setDONE_CODE      ( String.valueOf( System.currentTimeMillis ()  ) );
				fromExigence.setDONE_DATE      ( fromCREATE                                     );
				fromExigence.setCATALOG_ID     ( IUpdbfsConst.IUpdbm.ICatalog.RECEIVE           );
				fromExigence.setBUSINESS_ID    ( IUpdbfsConst.IUpdbm.IBusines.RECEIVE           );
				fromExigence.setORIGINATOR     ( IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_RECEIVE );
				fromExigence.setCHANNEL_ID     ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL            );
				fromExigence.setUSER_ID        ( 0l                                             );
				fromExigence.setBILL_ID        ( IUpdbfsConst.IUpdbm.ICustom.BILL_ID            );
				fromExigence.setCREATE_DATE    ( fromCREATE                                     );
				fromExigence.setREGION_ID      ( CenterUtils.ISystem._region_id              () );
				fromExigence.setORDER_REGION_ID( "*"                                            );
				fromExigence.setPRIORITY       ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY           );
				fromExigence.setORG_ID         ( IUpdbfsConst.IUpdbm.ICustom.ORGANIZE           );
				fromExigence.setSTAFF_ID       ( IUpdbfsConst.IUpdbm.ICustom.STAFF              );
				String fromXML = RocketUtils.ICustom._jj_message( fromRocket );
				ICustom.ICustomX._wrapWithBusiInfo( fromXML, fromExigence );
			}
			finally{
				
			}
			return fromExigence;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFExigence _jj_rocket( RocketFMessage fromRocket ) throws SFException,Exception{
			IOVMsgFExigence fromConsult = null;
			try
			{
				RocketFTextMessage _rocket = RocketUtils.ICustom._jj_rocket( fromRocket );
				if( StringUtils.isBlank( _rocket.getText() ) ){
					ExceptionFactory.throwServiceBody("IOS0011009", new String[]{"IPSCRocket"});
				}
				fromConsult = new IOVMsgFExigence( _rocket.getText() );
				IOVRocketExigence fromMockets = fromConsult.getORDER().getROCKET();
				SFCenterFactory.pushCenterInfo( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, fromMockets.getREGION_ID() );
				try
				{
					ISystemTemplate.IUpdbfsOffer fromProtection = null;
					fromProtection = IOrderFactory.getIOrdMixSV().getSFMsgFPriority( fromMockets );
					fromConsult.setROCKET_ID( UpdbfsFactory.getIUpffmxSV().getROCKET_ID () );
					fromMockets.setROCKET_ID( fromConsult.getROCKET_ID                  () );
					fromMockets.setPRIORITY ( fromProtection.getPRIORITY                () );
					fromMockets.setCOMPOSITE( fromProtection.getCOMPOSITE               () );
					for( java.util.Iterator<IOVMsgFOrderBase> itera = fromConsult.getORDER().getORDER().iterator(); itera.hasNext(); ){
						IOVRocketExigence fromOrder = (IOVRocketExigence)itera.next();
						fromOrder.setROCKET_ID( fromMockets.getROCKET_ID  () );
						fromOrder.setPRIORITY ( fromMockets.getPRIORITY   () );
						fromOrder.setCOMPOSITE( fromMockets.getCOMPOSITE  () );
					}
				}
				finally{
					SFCenterFactory.popCenterInfo();
				}
			}
			finally{
				
			}
			return fromConsult;
		}
		
		/**
		 * 
		 * @param fromExigence
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFExigence _jj_rocket( IOVMocketExigence fromExigence ) throws SFException,Exception{
			IOVMsgFExigence fromConsult = null;
			try
			{
				IOVMocketExigence.IRocketOfferHome _rocket_ = fromExigence.getORDER();
				if( StringUtils.isBlank( _rocket_.getBODY() ) ){
					ExceptionFactory.throwServiceBody("IOS0011009", new String[]{"IPSCRocket"});
				}
				fromConsult = new IOVMsgFExigence( fromExigence );
				try
				{
					ISystemTemplate.IUpdbfsOffer fromProtection = null;
					IRocket.IRocketX._wrapWithMocket( fromExigence, fromConsult );
					IOVRocketExigence fromMockets = fromConsult.getORDER().getROCKET();
					fromProtection = IOrderFactory.getIOrdMixSV().getSFMsgFPriority( fromMockets );
					fromConsult.setROCKET_ID( fromMockets.getROCKET_ID   () );
					fromMockets.setPRIORITY ( fromProtection.getPRIORITY () );
					fromMockets.setCOMPOSITE( fromProtection.getCOMPOSITE() );
					for( java.util.Iterator<IOVMsgFOrderBase> itera = fromConsult.getORDER().getORDER().iterator(); itera.hasNext(); ){
						IOVRocketExigence fromOrder = (IOVRocketExigence)itera.next();
						fromOrder.setROCKET_ID( fromMockets.getROCKET_ID  () );
						fromOrder.setPRIORITY ( fromMockets.getPRIORITY   () );
						fromOrder.setCOMPOSITE( fromMockets.getCOMPOSITE  () );
					}
				}
				finally{
					
				}
			}
			finally{
				
			}
			return fromConsult;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketRespone _jj_complete( RocketFMessage fromRocket ) throws SFException,Exception{
			IOVMocketRespone fromConsult = null;
			try
			{
				RocketFTextMessage _rocket = RocketUtils.ICustom._jj_rocket( fromRocket );
				if( StringUtils.isBlank( _rocket.getText() ) ){
					ExceptionFactory.throwServiceBody("IOS0011009", new String[]{"CustOrder"});
				}
				fromConsult = new IOVMocketRespone( _rocket.getText() );
				IOVRocketExigence fromMockets = fromConsult.getORDER().getROCKET();
				SFCenterFactory.pushCenterInfo( IUpdcConst.IUpdbm.IUpdmc.CUSTOM_ID, fromMockets );
				try
				{
					fromConsult.setROCKET_ID  ( UpdbfsFactory.getIUpffmxSV().getROCKET_ID          () );
					fromMockets.setROCKET_ID  ( fromConsult.getROCKET_ID                           () );
					fromMockets.setPRIORITY   ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY                  );
					fromMockets.setCOMPOSITE  ( IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_COMPLETE       );
					fromMockets.setREGION_ID  ( SFCenterFactory.getCenterInfo().getREGION_ID       () );
				}
				finally{
					SFCenterFactory.popCenterInfo();
				}
			}
			finally{
				
			}
			return fromConsult;
		}
		
		/**
		 * 把开通定单应答转换为开通内部应答
		 * @param fromMocket 开通应答
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _jj_network( IOVMocketRespone fromMocket ) throws SFException, Exception{
			String fromXML = null;
			try
			{
				SFException exception = null;
				for( java.util.Iterator<IOVMocketRespone.IRocketRsRspHome> itera = fromMocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVMocketRespone.IRocketRsRspHome _rsRsp = (IOVMocketRespone.IRocketRsRspHome)itera.next();
					if( _rsRsp.getRESULT() == null ){
						exception = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, "" );
						_rsRsp.setRESULT( new IOVMsgFRsRspHome( exception ));
					}
					else if( StringUtils.isBlank( _rsRsp.getRESULT().getRspCode() ) ){
						exception = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, _rsRsp.getRESULT().getRspDesc() );
						_rsRsp.getRESULT().setRspCode( exception.getFaultCode() );
						_rsRsp.getRESULT().setRspDesc( exception.getMessage  () );
					}
				}
				fromXML = fromMocket.toString();
			}
			finally{
				
			}
			return fromXML;
		}
		
		/**
		 * 开通定单项反馈转换为外部开通应答
		 * @param fromMocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _jj_response( IOVMocketRespone fromMocket ) throws SFException, Exception{
			String fromXML = null;
			try
			{
				SFException exception = null;
				for( java.util.Iterator<IOVMocketRespone.IRocketRsRspHome> itera = fromMocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVMocketRespone.IRocketRsRspHome _rsRsp = (IOVMocketRespone.IRocketRsRspHome)itera.next();
					if( _rsRsp.getRESULT() == null ){
						exception = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, "" );
						_rsRsp.setRESULT( new IOVMsgFRsRspHome( exception ));
					}
					else if( StringUtils.isBlank( _rsRsp.getRESULT().getRspCode() ) ){
						exception = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, _rsRsp.getRESULT().getRspDesc() );
						_rsRsp.getRESULT().setRspCode( exception.getFaultCode() );
						_rsRsp.getRESULT().setRspDesc( exception.getMessage  () );
					}
				}
				fromXML = fromMocket.getAsXml();
			}
			finally{
				
			}
			return fromXML;
		}
		
		/**
		 * 
		 * @param fromUpfwm
		 * @param fromRsRspHome
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketRespone _jj_response( IOVUpfwmOffer fromUpfwm,
				IOVUpfwmResponse fromRsRspHome ) throws SFException, Exception {
			IOVMocketRespone fromASK = null;
			try
			{
				
				fromASK = new IOVMocketRespone();
				java.sql.Timestamp _complete = TimeUtils.getSysdate();
				fromASK.setCUST_ORDER( fromUpfwm.getSUB_BILL_ID          () );
				fromASK.setCHANNEL   ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL  );
				fromASK.setORG_ID    ( IUpdbfsConst.IUpdbm.ICustom.ORGANIZE );
				fromASK.setSTAFF_ID  ( IUpdbfsConst.IUpdbm.ICustom.STAFF    );
				IOVMocketRespone.IRocketRsRspHome fromRocketHome = null;
				fromRocketHome = new IOVMocketRespone.IRocketRsRspHome();
				fromRocketHome.setORDER_ID       ( String.valueOf( fromUpfwm.getPS_ID  () ) );
				fromRocketHome.setCATALOG        ( String.valueOf( fromUpfwm.getCATALOG() ) );
				fromRocketHome.setBUSINESS       ( String.valueOf( fromUpfwm.getBUSINESS()) );
				fromRocketHome.setORIGINATOR     ( IUpdbfsConst.IUpdbm.ICustom.ORGANIZE     ); 
				fromRocketHome.setUSER_ID        ( fromUpfwm.getUSER_ID                  () );
				fromRocketHome.setBILL_ID        ( fromUpfwm.getBILL_ID                  () );
				fromRocketHome.setORDER_REGION_ID( fromUpfwm.getREGION_ID                () );
				fromRocketHome.setREGION_ID      ( fromUpfwm.getREGION_ID                () );
				fromRocketHome.setDONE_DATE      ( _complete                                );
				SFException aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, "" );
				fromRocketHome.getRESULT().setRspCode( aEXCEPTION.getFaultCode () );
				fromRocketHome.getRESULT().setRspDesc( aEXCEPTION.getMessage   () );
				if( fromRsRspHome != null ){
					if( fromRsRspHome != null && fromRsRspHome.isFAILURE() ) {
						aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.REMOTE, fromRsRspHome.getRspDesc() );
					}
					fromRocketHome.getRESULT().setRspCode( aEXCEPTION.getFaultCode () );
					fromRocketHome.getRESULT().setRspDesc( aEXCEPTION.getMessage   () );
					if( fromRsRspHome.getRspBody() != null ){ 
						fromRocketHome.getRESULT().setRspBody( fromRsRspHome.getRspBody  () );
					}
				}
				fromASK.getORDER().getORDER().add( fromRocketHome );
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
			 * @param fromExigence
			 * @param fromRocket
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrapWithMocket(IOVMocketExigence fromExigence, 
					IOVMsgFExigence fromRocket) throws SFException,Exception{
				try
				{
					IOVMsgFOrderBase _rocket = new IOVMsgFOrderMain();
					IOVMocketExigence.IRocketOfferHome fromRocketHome = fromExigence.getORDER();
					_rocket.setROCKET_ID      ( fromExigence.getORDER_ID               () );
					_rocket.setCUST_ORDER     ( fromExigence.getCUST_ORDER             () );
					_rocket.setORDER_ITEM_ID  ( fromExigence.getDONE_CODE              () );
					_rocket.setDONE_DATE      ( fromExigence.getDONE_DATE              () );
					_rocket.setCATALOG        ( fromExigence.getCATALOG_ID             () );
					_rocket.setBUSINESS       ( fromExigence.getBUSINESS_ID            () );
					_rocket.setBATCHES        ( IUpdbfsConst.IUpdbm.IBatches.NO           );
					_rocket.setORIGINATOR     ( fromExigence.getORIGINATOR             () );
					_rocket.setCHANNEL        ( fromExigence.getCHANNEL_ID             () );
					_rocket.setUSER_ID        ( fromExigence.getUSER_ID                () );
					_rocket.setBILL_ID        ( fromExigence.getBILL_ID                () );
					_rocket.setCREATE_DATE    ( TimeUtils.getSysdate                   () );
					_rocket.setREGION_ID      ( fromExigence.getREGION_ID              () );
					_rocket.setORDER_REGION_ID( fromExigence.getORDER_REGION_ID        () );
					_rocket.setPRIORITY       ( fromExigence.getPRIORITY               () );
					_rocket.setCOMPOSITE      ( IUpdcConst.IUpdbm.IUpdbf.NORMAL           );
					_rocket.setORG_ID         ( fromExigence.getORG_ID                 () );
					_rocket.setSTAFF_ID       ( fromExigence.getSTAFF_ID               () );
					_rocket.setPLWK_CREATE    ( _rocket.getCREATE_DATE                 () );
					OrderUtils.IRocket.IRocketX._wrapWithRocket( fromRocketHome.getBODY(), _rocket );
					fromRocket.getORDER().setROCKET( _rocket );
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param fromXML
			 * @param fromOsRocket
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _wrapWithMocket(String fromXML, 
					IOVMsgFExigence fromOsRocket) throws SFException,Exception{
				try
				{
					IOVMsgFOrderBase fromExigence = new IOVMsgFOrderMain();
					java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
					ISystemTemplate.IUpdbfsLimite fromDefault = SystemUtils.ISystem.getSFUpffmxOffer();
					fromExigence.setCUST_ORDER     ( String.valueOf( System.currentTimeMillis ()  ) );
					fromExigence.setORDER_ITEM_ID  ( String.valueOf( System.currentTimeMillis ()  ) );
					fromExigence.setDONE_DATE      ( fromCREATE                                     );
					fromExigence.setCATALOG        ( IUpdbfsConst.IUpdbm.ICatalog.RECEIVE           );
					fromExigence.setBUSINESS       ( IUpdbfsConst.IUpdbm.IBusines.RECEIVE           );
					fromExigence.setBATCHES        ( IUpdbfsConst.IUpdbm.IBatches.NO                );
					fromExigence.setORIGINATOR     ( IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_RECEIVE );
					fromExigence.setCHANNEL        ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL            );
					fromExigence.setUSER_ID        ( 0l                                             );
					fromExigence.setBILL_ID        ( IUpdbfsConst.IUpdbm.ICustom.BILL_ID            );
					fromExigence.setPRIORITY       ( fromDefault.getPRIORITY                     () );
					fromExigence.setCOMPOSITE      ( fromDefault.getCOMPOSITE                    () );
					fromExigence.setCREATE_DATE    ( fromCREATE                                     );
					fromExigence.setREGION_ID      ( CenterUtils.ISystem._region_id              () );
					fromExigence.setORG_ID         ( IUpdbfsConst.IUpdbm.ICustom.ORGANIZE           );
					fromExigence.setSTAFF_ID       ( IUpdbfsConst.IUpdbm.ICustom.STAFF              );
					fromExigence.setPLWK_CREATE    ( fromCREATE                                     );
					fromExigence.setORDER_REGION_ID( "*"                                            );
					OrderUtils.IRocket.IRocketX._wrapWithRocket( fromXML, fromExigence );
					fromOsRocket.getORDER().setROCKET( fromExigence );
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param fromCustOrder
			 * @param fromOrderItem
			 * @param fromRocket
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFOrderBase _wrapWithConsult(org.dom4j.Element fromCustOrder,
					org.dom4j.Element fromOrderItem, 
					IOVMsgFExigence fromRocket) throws SFException,Exception{
				IOVMsgFOrderBase fromConsult = null;
				try
				{
					fromConsult = IRocketX._jj_consult( fromCustOrder, fromOrderItem );
					fromConsult.setROCKET_ID  ( fromRocket.getROCKET_ID                            () );
					fromConsult.setPLWK_CREATE( new java.sql.Timestamp( System.currentTimeMillis   ()));
					fromConsult.setCREATE_DATE( new java.sql.Timestamp( System.currentTimeMillis   ()));
					
					org.dom4j.Element fromProdInfo = RocketUtils.IMetaX._jj_element( fromOrderItem, "ProdInfo" );
					String fromOrderInfo = fromProdInfo.getTextTrim();
					java.util.List<org.dom4j.Element> fromChildNode = fromProdInfo.elements();
					if( fromChildNode != null && fromChildNode.size() > 0 ){
						org.dom4j.Element fromUserOrder = fromProdInfo.element( "UserOrder" );
						fromOrderInfo = fromUserOrder != null?fromUserOrder.asXML(): fromProdInfo.asXML();
					}
					OrderUtils.IRocket.IRocketX._wrapWithRocket( fromOrderInfo, fromConsult );
					
					SFCenterOffer fromCenter = CenterUtils.ISystem._custom( fromConsult );
					fromConsult.setREGION_ID  ( fromCenter.getREGION_ID()  );
				}
				finally{
					
				}
				return fromConsult;
			}
			
			/**
			 * 根据开通定单构造开通定单项
			 * @param fromCustOrder 开通客户
			 * @param fromOrderItem 开通定单
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			private static IOVMsgFOrderBase _jj_consult(org.dom4j.Element fromCustOrder,
					org.dom4j.Element fromOrderItem) throws SFException,Exception{
				IOVMsgFOrderBase fromConsult = null;
				try
				{
					java.util.List<org.dom4j.Element> fromOrders = fromOrderItem.getParent().elements( fromOrderItem.getName() );
					if( fromOrders != null && fromOrders.size() <= 1/*开通单定单项*/){
						fromConsult = new IOVMsgFOrderMain( fromCustOrder, fromOrderItem );
					}
					else/*开通多定单项*/{
						IProfessionalTemplate.IProductComptel fromUpffx = null;
						fromConsult = new IOVMsgFOrderMinor( fromCustOrder, fromOrderItem );
						fromUpffx = UpdcpUtils.ISystem.getSUBJECT( fromConsult.getBUSINESS() );
						if( fromUpffx != null && fromUpffx.getCOMPTELX().isBASIC()/*开通主定单项*/){
							fromConsult = new IOVMsgFOrderMain( fromConsult );
						}
					}
				}
				finally{
					
				}
				return fromConsult;
			}
		}
	}
	public static class IRsRsp{
		public IRsRsp(){
			super();
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromOrdRsRsp
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketRespone _wrap( IOVMocketRespone fromRocket, 
				IOVOrderResponse fromOrdRsRsp,
				IUpdcContext aContext) throws SFException, Exception{
			IOVMocketRespone fromASK = null;
			try
			{
				fromASK = new IOVMocketRespone();
				IOVMocketRespone.IRocketRsRspHome fromRsRspHome = null;
				IOVMsgFOrderBase fromOrder = fromRocket.getORDER().getROCKET();
				fromASK.setCUST_ORDER( fromRocket.getCUST_ORDER  () );
				fromASK.setCHANNEL   ( fromRocket.getCHANNEL     () );
				fromASK.setORG_ID    ( fromRocket.getORG_ID      () );
				fromASK.setSTAFF_ID  ( fromRocket.getSTAFF_ID    () );
				fromRsRspHome = new IOVMocketRespone.IRocketRsRspHome( fromOrder );
				IRsRsp.IRsRspX._wrap(fromOrdRsRsp, fromRsRspHome);
				fromASK.getORDER().getORDER().add( fromRsRspHome );
			}
			finally{
				
			}
			return fromASK;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderResponse _wrap( IOVMocketRespone fromRocket,
				IOVMocketRespone.IRocketRsRspHome fromRsRspHome,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVOrderResponse fromRequest = null;
			try
			{
				fromRequest = new IOVOrderResponse();
				fromRequest.setROCKET_ID  ( fromRocket.getROCKET_ID           () );
				fromRequest.setCUST_ORDER ( fromRocket.getCUST_ORDER          () );  
				fromRequest.setCATALOG    ( fromRsRspHome.getCATALOG          () );  
				fromRequest.setBUSINESS   ( fromRsRspHome.getBUSINESS         () );  
				fromRequest.setORIGINATOR ( fromRsRspHome.getORIGINATOR       () );  
				fromRequest.setCHANNEL    ( fromRocket.getCHANNEL             () );  
				fromRequest.setUSER_ID    ( fromRsRspHome.getUSER_ID          () );  
				fromRequest.setBILL_ID    ( fromRsRspHome.getBILL_ID          () );
				fromRequest.setREGION_ID  ( fromRsRspHome.getREGION_ID        () );  
				fromRequest.setDONE_CODE  ( fromRsRspHome.getORDER_ID         () );  
				fromRequest.setDONE_DATE  ( fromRsRspHome.getDONE_DATE        () ); 
				
				IPlatformTemplate.IUpffmOffer fromRspHome = null;
				IOVMsgFRsRspHome fromMsgFRsRspHome = fromRsRspHome.getRESULT();
				fromRspHome = SystemUtils.ISystem.getSFUpfgkmNetWork( fromUpdcpm );
				fromRequest.getRESULT().setRspCode( fromMsgFRsRspHome.getRspCode() );
				fromRequest.getRESULT().setRspHome( fromRspHome.getID           () );
				fromRequest.getRESULT().setRspDesc( fromMsgFRsRspHome.getRspDesc() );
				
				ISystemResultHome fromOrdRspHome = new ISystemResultHome();
				fromOrdRspHome.setRspCode    ( fromMsgFRsRspHome.getRspCode() );
				fromOrdRspHome.setRspDesc    ( fromMsgFRsRspHome.getRspDesc() );
				fromOrdRspHome.mergeAsResult ( fromMsgFRsRspHome.getRspBody() );
				fromRequest.getRESULT().mergeAsGroup( fromOrdRspHome );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromOrdRsRsp
		 * @param fromASK
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketRespone _wrap( IOVMocketCompose fromRocket,
				IOVOrderResponse fromOrdRsRsp,
				IOVMocketRespone fromASK,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVMocketRespone.IRocketRsRspHome fromRsRspHome = null;
				IOVMsgFExigence.IMsgFOfferXHome fromRocketHome = fromRocket.getSUBFLOW().getORDER();
				if( fromASK == null ){
					fromASK = new IOVMocketRespone();
					fromASK.setCUST_ORDER( fromRocket.getSUBFLOW().getCUST_ORDER  () );
					fromASK.setCHANNEL   ( fromRocket.getSUBFLOW().getCHANNEL     () );
					fromASK.setORG_ID    ( fromRocket.getSUBFLOW().getORG_ID      () );
					fromASK.setSTAFF_ID  ( fromRocket.getSUBFLOW().getSTAFF_ID    () );
				}
				for( java.util.Iterator<IOVMsgFOrderBase> itera = fromRocketHome.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrderBase fromOsRocket = (IOVMsgFOrderBase)itera.next();
					fromRsRspHome = new IOVMocketRespone.IRocketRsRspHome( fromOsRocket );
					IRsRsp.IRsRspX._wrap(fromOrdRsRsp, fromRsRspHome);
					fromASK.getORDER().getORDER().add( fromRsRspHome );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromOrdRsRsp
		 * @param fromASK
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketRespone _wrap(IOVMocketCompose fromRocket,
				IOVMsgFResponse fromOrdRsRsp,
				IOVMocketRespone fromASK,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVMocketRespone.IRocketRsRspHome fromRsRspHome = null;
				IOVMsgFExigence.IMsgFOfferXHome fromRocketHome = fromRocket.getSUBFLOW().getORDER();
				if( fromASK == null ){
					fromASK = new IOVMocketRespone();
					fromASK.setCUST_ORDER( fromRocket.getSUBFLOW().getCUST_ORDER  () );
					fromASK.setCHANNEL   ( fromRocket.getSUBFLOW().getCHANNEL     () );
					fromASK.setORG_ID    ( fromRocket.getSUBFLOW().getORG_ID      () );
					fromASK.setSTAFF_ID  ( fromRocket.getSUBFLOW().getSTAFF_ID    () );
				}
				for( java.util.Iterator<IOVMsgFOrderBase> itera = fromRocketHome.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrderBase fromOrder = (IOVMsgFOrderBase)itera.next();
					fromRsRspHome = new IOVMocketRespone.IRocketRsRspHome( fromOrder );
					IRsRsp.IRsRspX._wrap(fromOrdRsRsp, fromRsRspHome);
					fromASK.getORDER().getORDER().add( fromRsRspHome );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromOrdRsRsp
		 * @param fromASK
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMocketRespone _wrap(IOVMsgFOrderBase fromOrder,
				IOVMsgFResponse fromOrdRsRsp,
				IOVMocketRespone fromASK,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVMocketRespone.IRocketRsRspHome fromRsRspHome = null;
				if( fromASK == null ){
					fromASK = new IOVMocketRespone();
					fromASK.setCUST_ORDER( fromOrder.getCUST_ORDER  () );
					fromASK.setCHANNEL   ( fromOrder.getCHANNEL     () );
					fromASK.setORG_ID    ( fromOrder.getORG_ID      () );
					fromASK.setSTAFF_ID  ( fromOrder.getSTAFF_ID    () );
				}
				fromRsRspHome = new IOVMocketRespone.IRocketRsRspHome( fromOrder );
				IRsRsp.IRsRspX._wrap(fromOrdRsRsp, fromRsRspHome);
				fromASK.getORDER().getORDER().add( fromRsRspHome );
			}
			finally{
				
			}
			return fromASK;
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
		public static IOVMocketRespone _wrap( IOVUpdbsComplete fromOrder, 
				IOVUpdcpmOffer fromUpdcpm, 
				IUpdcContext aContext ) throws SFException, Exception{
			IOVMocketRespone fromASK = null;
			try
			{
				IOVMocketRespone.IRocketRsRspHome fromRsRspHome = null;
				fromASK = new IOVMocketRespone();
				fromASK.setCUST_ORDER( fromOrder.getCUST_ORDER  () );
				fromASK.setCHANNEL   ( fromOrder.getCHANNEL     () );
				fromASK.setORG_ID    ( fromOrder.getORG_ID      () );
				fromASK.setSTAFF_ID  ( fromOrder.getSTAFF_ID    () );
				fromRsRspHome = new IOVMocketRespone.IRocketRsRspHome( fromOrder );
				OrderUtils.IRocket.IRocketX._wrap( fromOrder, fromRsRspHome.getRESULT() );
				fromASK.getORDER().getORDER().add( fromRsRspHome );
			}
			finally{
				
			}
			return fromASK;
		}
		
		public static class IRsRspX{
			public IRsRspX(){
				super();
			}
			
			/**
			 * 
			 * @param fromOrdRsRsp
			 * @param fromRsRspHome
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMocketRespone.IRocketRsRspHome _wrap(IOVOrderResponse fromOrdRsRsp, 
					IOVMocketRespone.IRocketRsRspHome fromRsRspHome ) throws SFException,Exception{
				try
				{
					SFException aEXCEPTION = OrderUtils.IRocket.IRocketX._wrap( fromOrdRsRsp );
					fromRsRspHome.getRESULT().setRspCode( aEXCEPTION.getFaultCode() );
					fromRsRspHome.getRESULT().setRspDesc( aEXCEPTION.getMessage  () );
					if( fromOrdRsRsp != null && fromOrdRsRsp.getRESULT() != null ){
						IOrderRsRspHome fromOrdRsRspHome = fromOrdRsRsp.getRESULT();
						ISystemResultHome fromResult = fromOrdRsRspHome.getRspBody();
						if( fromResult != null && fromResult.getRspResult() != null ){
							fromRsRspHome.getRESULT().setRspResult( fromResult.getRspResult() );
						}
						if( fromResult != null && fromResult.getRspBody() != null && 
								fromResult.getRspBody().size() > 0 ){
							fromRsRspHome.getRESULT().setRspBody( fromResult.getRspBody() );
						}
					}
				}
				finally{
					
				}
				return fromRsRspHome;
			}
			
			/**
			 * 
			 * @param fromOrdRsRsp
			 * @param fromRsRspHome
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMocketRespone.IRocketRsRspHome _wrap(IOVMsgFResponse fromOrdRsRsp, 
					IOVMocketRespone.IRocketRsRspHome fromRsRspHome ) throws SFException,Exception{
				try
				{
					SFException aEXCEPTION = OrderUtils.IRocket.IRocketX._wrap( fromOrdRsRsp );
					fromRsRspHome.getRESULT().setRspCode( aEXCEPTION.getFaultCode() );
					fromRsRspHome.getRESULT().setRspDesc( aEXCEPTION.getMessage  () );
					if( fromOrdRsRsp != null && fromOrdRsRsp.getRESULT() != null ){
						IOVMsgFRsRspHome fromOrdRsRspHome = fromOrdRsRsp.getRESULT();
						if( fromOrdRsRspHome != null ){
							fromRsRspHome.getRESULT().setRspResult( fromOrdRsRspHome.getRspResult() );
							if( fromOrdRsRspHome.getRspBody() != null ){
								fromRsRspHome.getRESULT().setRspBody( fromOrdRsRspHome.getRspBody() );
							}
						}
					}
				}
				finally{
					
				}
				return fromRsRspHome;
			}
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
	}
}
