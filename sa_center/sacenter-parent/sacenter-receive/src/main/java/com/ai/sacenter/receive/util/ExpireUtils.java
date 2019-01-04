package com.ai.sacenter.receive.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.expire.ExpireFactory;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOfferX;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserCentrex;
import com.ai.sacenter.receive.valuebean.IOVUpffmxExpire;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExpireUtils {
	public ExpireUtils() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年6月13日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param fromExpire
		 * @param fromRequest
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFRequest _wrap( IOVUser fromUser, IOVExpireUser fromExpUser, IOVMsgFRequest fromRequest ) throws SFException,Exception{
			try
			{
				ISystemTemplate.IUpdbfsOffer fromProtection = null;
				fromRequest.setROCKET_ID      ( fromExpUser.getORDER_ID                         () );
				fromRequest.setCUST_ORDER     ( fromExpUser.getCUST_ORDER                       () );
				fromRequest.setCATALOG        ( String.valueOf(fromExpUser.getCATALOG          ()) );
				fromRequest.setBUSINESS       ( IUpdbfsConst.IUpdbm.IBusines.EXPIRE                );
				fromRequest.setBATCHES        ( IUpdbfsConst.IUpdbm.IBatches.YES                   );
				fromRequest.setORIGINATOR     ( fromExpUser.getCATEGORY                         () );
				fromRequest.setCHANNEL        ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL                );
				fromRequest.setUSER_ID        ( fromExpUser.getUSER_ID                          () );                                                            
				fromRequest.setREGION_ID      ( fromExpUser.getREGION_ID                        () ); 
				fromRequest.setORDER_REGION_ID( fromExpUser.getUSER_REGION_ID                   () );
				fromRequest.setPRIORITY       ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY               );
				fromRequest.setDONE_CODE      ( fromExpUser.getDONE_CODE                        () );
				fromRequest.setDONE_DATE      ( TimeUtils.getAsExpire(fromExpUser.getORDER_DATE()) );
				fromRequest.setORG_ID         ( fromExpUser.getORG_ID                           () );                                                            
				fromRequest.setSTAFF_ID       ( fromExpUser.getSTAFF_ID                         () );
				fromRequest.getORDER().setOBJECTIVE( fromExpUser              );
				fromRequest.getORDER().setCREATOR( fromRequest.getDONE_DATE() );
				IOVMsgFUser fromOrdUser = ICustom._wrap(fromUser, fromExpUser );
				for( java.util.Iterator<IOVExpireOffer> itera = fromExpUser.getORDER().iterator(); itera.hasNext(); ){
					IOVExpireOffer fromExpOffer = (IOVExpireOffer)itera.next();
					IOVMsgFOrdOffer fromOrdOffer = ICustom._wrap(fromUser, 
							fromExpUser, 
							fromExpOffer);
					fromOrdUser.mergeAsCentrex( fromOrdOffer );
				}
				if( fromOrdUser != null ) fromRequest.getUSER().add( fromOrdUser );
				fromProtection = IOrderFactory.getIOrdMixSV().getSFMsgFPriority( fromRequest );
				fromRequest.setPRIORITY    ( fromProtection.getPRIORITY            () );
				fromRequest.setCOMPOSITE   ( IUpdcConst.IUpdbm.IUpdbf.EXPIRE          );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromExpire
		 * @param fromRequest
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFRequest _wrap( IOVUser fromUser, IUpdfmxExpire fromUpdfmx, IOVMsgFRequest fromRequest ) throws SFException,Exception{
			try
			{
				ISystemTemplate.IUpdbfsOffer fromProtection = null;
				fromRequest.setROCKET_ID      ( fromUpdfmx.getROCKET_ID               () );
				fromRequest.setCUST_ORDER     ( fromUpdfmx.getCUST_ORDER              () );
				fromRequest.setCATALOG        ( String.valueOf(fromUpdfmx.getCATALOG() ) );
				fromRequest.setBUSINESS       ( IUpdbfsConst.IUpdbm.IBusines.EXPIRE      );
				fromRequest.setBATCHES        ( IUpdbfsConst.IUpdbm.IBatches.YES         );
				fromRequest.setORIGINATOR     ( fromUpdfmx.getORIGINATOR              () );
				fromRequest.setCHANNEL        ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL      );
				fromRequest.setUSER_ID        ( fromUpdfmx.getUSER_ID                 () );
				fromRequest.setREGION_ID      ( fromUpdfmx.getREGION_ID               () );
				fromRequest.setORDER_REGION_ID( fromUpdfmx.getORDER_REGION_ID         () );
				fromRequest.setPRIORITY       ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY     );
				fromRequest.setDONE_CODE      ( fromUpdfmx.getDONE_CODE               () );
				fromRequest.setDONE_DATE      ( fromUpdfmx.getCREATE_DATE             () );
				fromRequest.setORG_ID         ( fromUpdfmx.getORG_ID                  () );                                                            
				fromRequest.setSTAFF_ID       ( fromUpdfmx.getSTAFF_ID                () );
				fromRequest.getORDER().setOBJECTIVE( fromUpdfmx                          );
				fromRequest.getORDER().setCREATOR( fromRequest.getDONE_DATE           () );
				IOVMsgFUser fromOrdUser = ICustom._wrap( fromUser, new IOVMsgFUser    () );
				if( fromOrdUser != null ){ fromRequest.getUSER().add( fromOrdUser );  }
				fromProtection = IOrderFactory.getIOrdMixSV().getSFMsgFPriority( fromRequest );
				fromRequest.setPRIORITY    ( fromProtection.getPRIORITY            () );
				fromRequest.setCOMPOSITE   ( IUpdcConst.IUpdbm.IUpdbf.EXPIRE          );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromUpdfmx
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpdfmxExpire _wrap( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser, IUpdcContext aContext ) throws SFException,Exception{
			IUpdfmxExpire fromUpdfmx = null;
			try
			{
				fromUpdfmx = new IUpdfmxExpire();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromUpdfmx.setROCKET_ID      ( fromRequest.getROCKET_ID      () );
				fromUpdfmx.setCUST_ORDER     ( fromRequest.getCUST_ORDER     () );
				fromUpdfmx.setDONE_CODE      ( fromRequest.getDONE_CODE      () );
				fromUpdfmx.setCATALOG        ( fromRequest.getCATALOG        () );
				fromUpdfmx.setBUSINESS       ( fromRequest.getBUSINESS       () );
				fromUpdfmx.setORIGINATOR     ( fromRequest.getORIGINATOR     () );
				fromUpdfmx.setUSER_ID        ( fromMsgFUser.getUSER_ID       () );
				fromUpdfmx.setCREATE_DATE    ( fromMBean.getCREATE           () );
				fromUpdfmx.setREGION_ID      ( fromRequest.getREGION_ID      () );
				fromUpdfmx.setORDER_REGION_ID( fromRequest.getORDER_REGION_ID() );
				fromUpdfmx.setUSER_REGION_ID ( fromMsgFUser.getUSER_REGION_ID() );
				fromUpdfmx.setORG_ID         ( fromRequest.getORG_ID         () );
				fromUpdfmx.setSTAFF_ID       ( fromRequest.getSTAFF_ID       () );
			}
			finally{
				
			}
			return fromUpdfmx;
		}
		
		/**
		 * 
		 * @param fromHome
		 * @param fromUserHome
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFRequest _wrap( IOVMsgFRequest fromHome, IOVUpffmxExpire.IUpffmxUser fromUserHome) throws SFException,Exception{
			IOVMsgFRequest fromRequest = null;
			try
			{
				fromRequest = new IOVMsgFRequest();
				ISystemTemplate.IUpdbfsOffer fromProtection = null;
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				fromBusines = fromUserHome.getCOMPETENCE().getCATALOG().getBUSINES();
				fromRequest.setROCKET_ID         ( fromHome.getROCKET_ID                      () );
				fromRequest.setCUST_ORDER        ( fromHome.getCUST_ORDER                     () );
				fromRequest.setCATALOG           ( fromUserHome.getUSER().getCATALOG          () );
				fromRequest.setBUSINESS          ( IUpdbfsConst.IUpdbm.IBusines.EXPIRE           );
				fromRequest.setBATCHES           ( fromHome.getBATCHES                        () );
				fromRequest.setORIGINATOR        ( IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_EXPIRE );
				fromRequest.setCHANNEL           ( fromHome.getCHANNEL                        () );
				fromRequest.setPRIORITY          ( fromBusines.getPRIORITY                    () );
				fromRequest.setUSER_ID           ( fromUserHome.getUSER().getUSER_ID          () );
				fromRequest.setBILL_ID           ( fromUserHome.getUSER().getBILL_ID          () );
				fromRequest.setREGION_ID         ( fromHome.getREGION_ID                      () );
				fromRequest.setDONE_CODE         ( fromHome.getDONE_CODE                      () );
				fromRequest.setDONE_DATE         ( fromUserHome.getORDER_DATE                 () );
				fromRequest.setORDER_REGION_ID   ( fromHome.getORDER_REGION_ID                () );
				fromRequest.setORG_ID            ( fromHome.getORG_ID                         () );
				fromRequest.setSTAFF_ID          ( fromHome.getSTAFF_ID                       () );
				fromRequest.getORDER().setOBJECTIVE( fromHome.getORDER().getOBJECTIVE         () );
				fromRequest.getORDER().setCREATOR( fromUserHome.getORDER_DATE                 () );
				fromRequest.getUSER().add( fromUserHome.getUSER() );
				fromProtection = IOrderFactory.getIOrdMixSV().getSFMsgFPriority( fromRequest );
				fromRequest.setPRIORITY          ( fromProtection.getPRIORITY                 () );
				fromRequest.setCOMPOSITE         ( IUpdcConst.IUpdbm.IUpdbf.EXPIRE               );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromExpUser
		 * @param fromMsgFUser
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFUser _wrap( IOVUser fromUser, IOVExpireUser fromExpUser ) throws SFException,Exception{
			IOVMsgFUser fromMsgFUser = null;
			try
			{
				fromMsgFUser = new IOVMsgFUser();
				fromMsgFUser.setUSER_ID       ( fromUser.getUSER_ID           () );
				fromMsgFUser.setCATALOG       ( fromUser.getCATALOG           () );
				fromMsgFUser.setBILL_ID       ( fromUser.getBILL_ID           () );
				fromMsgFUser.setSUB_BILL_ID   ( fromUser.getSUB_BILL_ID       () );
				fromMsgFUser.setBRAND_ID      ( fromExpUser.getBRAND_ID       () );
				fromMsgFUser.setUSER_TYPE     ( fromUser.getUSER_TYPE         () );
				fromMsgFUser.setUSER_STATUS   ( fromUser.getSTATUS            () );
				fromMsgFUser.setOS_STATUS     ( fromUser.getOS_STATUS         () );
				fromMsgFUser.setRISK_FLAG     ( fromUser.getRISK_FLAG         () );
				fromMsgFUser.setROLE_ID       ( IUpdbfsConst.IUpdbm.IRole.NORMAL );
				fromMsgFUser.setUSER_REGION_ID( fromExpUser.getUSER_REGION_ID () );
				fromMsgFUser.setREGION_ID     ( fromExpUser.getREGION_ID      () );
				fromMsgFUser.setCOUNTRY_CODE  ( fromUser.getCOUNTRY_CODE      () );
				fromMsgFUser.setIS_OUT_NET    ( fromUser.getIS_OUT_NET        () );
				fromMsgFUser.setEFFECTIVE     ( fromUser.getEFFECTIVE         () );
				fromMsgFUser.setEXPIRE        ( fromUser.getEXPIRE            () );
			}
			finally{
				
			}
			return fromMsgFUser;
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromMsgFUser
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFUser _wrap( IOVUser fromUser, IOVMsgFUser fromMsgFUser ) throws SFException,Exception{
			try
			{
				SFCenterOffer _centeroffer_ = CenterUtils.ISystem._custom( fromUser );
				fromMsgFUser.setUSER_ID       ( fromUser.getUSER_ID           () );
				fromMsgFUser.setCATALOG       ( fromUser.getCATALOG           () );
				fromMsgFUser.setBILL_ID       ( fromUser.getBILL_ID           () );
				fromMsgFUser.setSUB_BILL_ID   ( fromUser.getSUB_BILL_ID       () );
				fromMsgFUser.setBRAND_ID      ( fromUser.getBRAND_ID          () );
				fromMsgFUser.setUSER_TYPE     ( fromUser.getUSER_TYPE         () );
				fromMsgFUser.setUSER_STATUS   ( fromUser.getSTATUS            () );
				fromMsgFUser.setOS_STATUS     ( fromUser.getOS_STATUS         () );
				fromMsgFUser.setRISK_FLAG     ( fromUser.getRISK_FLAG         () );
				fromMsgFUser.setROLE_ID       ( IUpdbfsConst.IUpdbm.IRole.NORMAL );
				fromMsgFUser.setUSER_REGION_ID( fromUser.getREGION_ID         () );
				fromMsgFUser.setREGION_ID     ( _centeroffer_.getREGION_ID    () );
				fromMsgFUser.setCOUNTRY_CODE  ( fromUser.getCOUNTRY_CODE      () );
				fromMsgFUser.setIS_OUT_NET    ( fromUser.getIS_OUT_NET        () );
				fromMsgFUser.setEFFECTIVE     ( fromUser.getEFFECTIVE         () );
				fromMsgFUser.setEXPIRE        ( fromUser.getEXPIRE            () );
			}
			finally{
				
			}
			return fromMsgFUser;
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromExpUser
		 * @param fromExpOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFOrdOffer _wrap( IOVUser fromUser, IOVExpireUser fromExpUser, IOVExpireOffer fromExpOffer ) throws SFException,Exception{
			IOVMsgFOrdOffer fromOrdOffer = null;
			try
			{
				fromOrdOffer = new IOVMsgFOrdOffer();
				fromOrdOffer.setINS_PROD_ID ( fromExpOffer.getINS_PROD_ID       () );
				fromOrdOffer.setUSER_ID     ( fromExpOffer.getUSER_ID           () );
				fromOrdOffer.setCOMPETE_ID  ( fromExpOffer.getSERVICE_ID        () );
				fromOrdOffer.setSERVICE_ID  ( fromExpOffer.getSERVICE_ID        () );
				fromOrdOffer.setPRODUCT_ID  ( fromExpOffer.getPRODUCT_ID        () );
				fromOrdOffer.setPROD_TYPE   ( fromExpOffer.getPROD_TYPE         () );
				fromOrdOffer.setSTATUS      ( fromExpOffer.getSTATUS            () );
				fromOrdOffer.setEFFECTIVE   ( fromExpOffer.getCREATE_DATE       () );
				fromOrdOffer.setEXPIRE      ( TimeUtils.getMaxExpire            () );
				IOVUserOrder fromUserOrder = fromUser.getORDER( fromOrdOffer.getINS_PROD_ID(), fromOrdOffer.getSERVICE_ID() );
				if( fromUserOrder != null ){
					fromOrdOffer.setPROD_TYPE   ( fromUserOrder.getPROD_TYPE   () );
				}
				for(java.util.Iterator<IOVExpireOfferX> itera = fromExpOffer.getORDER().iterator();itera.hasNext();){
					IOVExpireOfferX fromExpOfferX = (IOVExpireOfferX)itera.next();
					fromOrdOffer.getFUTURE().add( _wrap( fromExpOfferX ) );
				}
			}
			finally{
				
			}
			return fromOrdOffer;
		}
		/**
		 * 
		 * @param aExpireOfferX
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFOfferX _wrap( IOVExpireOfferX aExpireOfferX ) throws SFException,Exception{
			IOVMsgFOfferX fromOfferX = null;
			try
			{
				fromOfferX = new IOVMsgFOfferX();
				fromOfferX.setINS_ATTR_ID   ( aExpireOfferX.getINS_ATTR_ID                        () );
				fromOfferX.setATTR_ID       ( aExpireOfferX.getATTR_ID                            () );
				fromOfferX.setATTR_VALUE    ( aExpireOfferX.getATTR_VALUE                         () );
				fromOfferX.setPRE_ATTR_VALUE( aExpireOfferX.getPRE_ATTR_VALUE                     () );
				fromOfferX.setSTATUS        ( aExpireOfferX.getSTATUS                             () );
				fromOfferX.setEFFECTIVE     ( TimeUtils.getTimestamp( aExpireOfferX.getEFFECTIVE() ) );
				fromOfferX.setEXPIRE        ( TimeUtils.getTimestamp( aExpireOfferX.getEXPIRE   () ) );
				
			}finally{
				
			}
			return fromOfferX;
		}
		/**
		 * 
		 * @param fromOrder
		 * @param fromUser
		 * @param fromExpire
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVExpireUser _wrap(IOVMsgFRequest fromOrder,
				IOVMsgFUser fromUser, 
				long fromExpire, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVExpireUser fromExpUser = null;
			try
			{
				fromExpUser = new IOVExpireUser();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromExpUser.setORDER_ID      ( ExpireFactory.getExpireDAO().getORDER_ID() ); 
				fromExpUser.setCUST_ORDER    ( fromOrder.getCUST_ORDER            ()   );
				fromExpUser.setDONE_CODE     ( fromOrder.getDONE_CODE             ()   );
				fromExpUser.setUSER_ID       ( fromUser.getUSER_ID                ()   );                                                            
				fromExpUser.setCATEGORY      ( IUpdbfsConst.IUpdbm.IUser.CYCLE         );
				fromExpUser.setCATALOG       ( Long.parseLong(fromUser.getCATALOG () ) );
				fromExpUser.setBILL_ID       ( fromUser.getBILL_ID                ()   );  
				fromExpUser.setBRAND_ID      ( fromUser.getBRAND_ID               ()   );
				fromExpUser.setUSER_REGION_ID( fromUser.getUSER_REGION_ID         ()   );
				fromExpUser.setCREATE_DATE   ( fromMBean.getCREATE                ()   );
				fromExpUser.setREGION_ID     ( fromUser.getREGION_ID              ()   ); 
				fromExpUser.setORDER_DATE    ( fromExpire                              );
				fromExpUser.setORG_ID        ( fromOrder.getORG_ID                ()   );                                                            
				fromExpUser.setSTAFF_ID      ( fromOrder.getSTAFF_ID              ()   );                                                            
				fromExpUser.setSTATE         ( IUpdcConst.IState.C                     );
			}
			finally{
				
			}
			return fromExpUser;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromUser
		 * @param fromOffer
		 * @param fromExpUser
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVExpireOffer _wrap(IOVMsgFRequest fromOrder,
				IOVMsgFUser fromUser, 
				IOVMsgFOffer fromOffer, 
				IOVExpireUser fromExpUser,
			    IUpdcContext aContext) throws SFException, Exception{
			IOVExpireOffer fromExpOffer = null;
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromExpOffer = new IOVExpireOffer();
				fromExpOffer.setOFFER_ID     ( ExpireFactory.getExpireDAO().getORDER_ID() );
				fromExpOffer.setORDER_ID     ( fromExpUser.getORDER_ID   () );
				fromExpOffer.setCUST_ORDER   ( fromOrder.getCUST_ORDER   () );
				fromExpOffer.setDONE_CODE    ( fromOrder.getDONE_CODE    () );
				fromExpOffer.setUSER_ID      ( fromOffer.getUSER_ID      () );
				fromExpOffer.setCREATE_DATE  ( fromMBean.getCREATE       () );
				fromExpOffer.setREGION_ID    ( fromExpUser.getREGION_ID  () );
				fromExpOffer.setINS_PROD_ID  ( fromOffer.getINS_PROD_ID  () );
				fromExpOffer.setSERVICE_ID   ( fromOffer.getSERVICE_ID   () );
				fromExpOffer.setPRODUCT_ID   ( fromOffer.getPRODUCT_ID   () );
				fromExpOffer.setPROD_TYPE    ( fromOffer.getPROD_TYPE    () );
				fromExpOffer.setSTATUS       ( fromOffer.getSTATUS       () );
				fromExpOffer.setCREATE_DATE  ( fromMBean.getCREATE       () );
				fromExpOffer.setSTATE        ( IUpdcConst.IState.C          );
				ICustom._wrap(fromUser, fromOffer, fromExpUser, fromExpOffer);
				if( fromExpOffer != null && fromExpOffer.getORDER().size() > 0 ){
					String fromORDER = JSONUtils.fromList( fromExpOffer.getORDER() );
					String fromPARAM[] = SystemUtils.ICustom.substringAsL( fromORDER );
					if( fromPARAM != null && fromPARAM.length <= 5 ){
						IBeanWrapper fromWrapper = new IBeanWrapper( fromExpOffer );
						for( int index = 0; fromPARAM != null && index < fromPARAM.length; index++ ){
							String fromINDEX = ClassUtils.getINDEX( new String[]{"PARAM_",index < 9 ?
									"0":"",String.valueOf( index + 1 ) } );
							fromWrapper.setPropertyValue( fromINDEX, fromPARAM[index] );
						}
					}
				}
			}
			finally{
				
			}
			return fromExpOffer;
		}
		/**
		 * 
		 * @param fromUser
		 * @param fromOffer
		 * @param fromExpUser
		 * @param fromExpOffer
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap(IOVMsgFUser fromUser, 
				IOVMsgFOffer fromOffer, 
				IOVExpireUser fromExpUser,
				IOVExpireOffer fromExpOffer) throws SFException, Exception{
			try
			{
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromOffer.getFUTURE().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
					IOVExpireOfferX fromExpOfferX = new IOVExpireOfferX();
					fromExpOfferX.setINS_ATTR_ID   ( fromMsgFOfferX.getINS_ATTR_ID   () );
					fromExpOfferX.setATTR_ID       ( fromMsgFOfferX.getATTR_ID       () );
					fromExpOfferX.setATTR_VALUE    ( fromMsgFOfferX.getATTR_VALUE    () );
					fromExpOfferX.setPRE_ATTR_VALUE( fromMsgFOfferX.getPRE_ATTR_VALUE() );
					fromExpOfferX.setSTATUS        ( fromMsgFOfferX.getSTATUS        () );
					fromExpOfferX.setEFFECTIVE     ( TimeUtils.yyyymmddhhmmss( 
							fromMsgFOfferX.getEFFECTIVE() ) );
					fromExpOfferX.setEXPIRE        ( TimeUtils.yyyymmddhhmmss( 
							fromMsgFOfferX.getEXPIRE() ) );
					fromExpOffer.getORDER().add( fromExpOfferX );
				}
			}
			finally{
				
			}
		}
		public static class IICustom{
			public IICustom(){
				super();
			}
			
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 是否有可能存在下周期开通模式
		 * @param fromMsgFUser
		 * @return
		 */
		public static boolean isEXPIRE( IOVMsgFUser fromMsgFUser ){
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromMsgFUser.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUserCentrex fromCentrex = (IOVMsgFUserCentrex)itera.next();
					if( fromCentrex.isEFFECTIVE( fromMBean.getCREATOR() ) /*到期订购*/|| 
							fromCentrex.isEXPIRE( fromMBean.getCREATOR() ) /*到期退订*/){
						return true;
					}
				}
			}
			finally{
				
			}
			return false;
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
	}
}
