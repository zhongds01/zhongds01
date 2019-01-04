package com.ai.sacenter.receive.util;

import com.ai.appframe2.bo.dialect.DialectFactory;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.datasource.DataSourceTemplate;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.bo.InsOffer;
import com.ai.sacenter.receive.custom.bo.InsOfferInsUser;
import com.ai.sacenter.receive.custom.bo.InsProd;
import com.ai.sacenter.receive.custom.bo.InsProdInsSrv;
import com.ai.sacenter.receive.custom.bo.InsSrvAttr;
import com.ai.sacenter.receive.custom.bo.InsUser;
import com.ai.sacenter.receive.custom.bo.InsUserOsState;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOfferX;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFCustom;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFPlan;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年5月2日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class CustomUtils {

	public CustomUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromMsgFUser
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFUser _wrap( IOVUser fromUser, 
				IOVMsgFUser fromMsgFUser ) throws SFException,Exception{
			try
			{
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
				fromMsgFUser.setCOUNTRY_CODE  ( fromUser.getCOUNTRY_CODE      () );
				fromMsgFUser.setIS_OUT_NET    ( fromUser.getIS_OUT_NET        () );
				fromMsgFUser.setEFFECTIVE     ( fromUser.getEFFECTIVE         () );
				fromMsgFUser.setEXPIRE        ( fromUser.getEXPIRE            () );
				SFCenterOffer fromRoute = CenterUtils.ISystem._custom( fromMsgFUser );
				fromMsgFUser.setREGION_ID     ( fromRoute.getREGION_ID        () );
				for( java.util.Iterator<IOVUserOfferX> itera = fromUser.getNATURE().iterator(); itera.hasNext(); ){
					IOVUserOfferX fromOfferX = (IOVUserOfferX)itera.next();
					IOVMsgFOfferX fromMsgFOfferX = new IOVMsgFOfferX();
					ICustom._wrap( fromOfferX, fromMsgFOfferX );
					fromMsgFUser.getNATURE().add( fromMsgFOfferX );
				}
			}
			finally{
				
			}
			return fromMsgFUser;
		}
		
		/**
		 * 
		 * @param fromUserOrder
		 * @param fromMsgFOffer
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVUserOrder fromUserOrder, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception{
			try
			{
				fromMsgFOffer.setINS_SRVC_ID ( fromUserOrder.getINS_SERV_ID () );
				fromMsgFOffer.setINS_PROD_ID ( fromUserOrder.getINS_PROD_ID () );  
				fromMsgFOffer.setUSER_ID     ( fromUserOrder.getUSER_ID     () );
				fromMsgFOffer.setCOMPETE_ID  ( fromUserOrder.getSERVICE_ID  () );
				fromMsgFOffer.setSERVICE_ID  ( fromUserOrder.getSERVICE_ID  () );        
				fromMsgFOffer.setPRODUCT_ID  ( fromUserOrder.getPRODUCT_ID  () );        
				fromMsgFOffer.setSTATUS      ( fromUserOrder.getSTATUS      () );
				if( fromMsgFOffer.isORDER() && fromUserOrder.isSUSPEND() /*暂停*/){
					fromMsgFOffer.setSTATUS  ( IUpdbfsConst.IState.IOrder.S05  );
				}
                fromMsgFOffer.setPROD_TYPE   ( fromUserOrder.getPROD_TYPE   () );        
				fromMsgFOffer.setEFFECTIVE   ( fromUserOrder.getEFFECTIVE   () );        
				fromMsgFOffer.setEXPIRE      ( fromUserOrder.getEXPIRE      () );
				for( java.util.Iterator<IOVUserOfferX> itera = fromUserOrder.getFUTURE().iterator(); itera.hasNext(); ){
					IOVUserOfferX fromOfferX = (IOVUserOfferX)itera.next();
					IOVMsgFOfferX fromMsgFOfferX = new IOVMsgFOfferX();
					ICustom._wrap( fromOfferX, fromMsgFOfferX );
					fromMsgFOffer.getFUTURE().add( fromMsgFOfferX );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromOfferX
		 * @param fromMsgFOfferX
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVUserOfferX fromOfferX, 
				IOVMsgFOfferX fromMsgFOfferX ) throws SFException,Exception{
			try
			{
				fromMsgFOfferX.setINS_ATTR_ID( fromOfferX.getINS_ATTR_ID() );
				fromMsgFOfferX.setATTR_ID    ( fromOfferX.getATTR_ID    () );
				fromMsgFOfferX.setATTR_VALUE ( fromOfferX.getATTR_VALUE () );
				fromMsgFOfferX.setSTATUS     ( fromOfferX.getSTATUS     () );
				fromMsgFOfferX.setEFFECTIVE  ( fromOfferX.getEFFECTIVE  () ); 
				fromMsgFOfferX.setEXPIRE     ( fromOfferX.getEXPIRE     () );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromInsUser
		 * @param fromOsState
		 * @param fromUser
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUser _wrap( InsUser fromInsUser, 
				InsUserOsState fromOsState) throws SFException,Exception{
			IOVUser fromUser = null;
			try
			{
				fromUser = new IOVUser();
				fromUser.setUSER_ID     ( fromInsUser.getUserId                          () ); 
				fromUser.setCATALOG     ( String.valueOf(fromInsUser.getProdCatalogId    ())); 
				fromUser.setCUST_ID     ( fromInsUser.getCustId                          () ); 
				fromUser.setCUST_TYPE   ( fromInsUser.getCustType                        () );
				fromUser.setREGION_ID   ( fromInsUser.getRegionId                        () ); 
				fromUser.setBILL_ID     ( fromInsUser.getBillId                          () ); 
				fromUser.setSUB_BILL_ID ( fromInsUser.getSubBillId                       () ); 
				fromUser.setIS_OUT_NET  ( String.valueOf(fromInsUser.getIsOutNet         ())); 
				fromUser.setUSER_TYPE   ( String.valueOf(fromInsUser.getUserType         ())); 
				fromUser.setNOTICE_FLAG ( String.valueOf(fromInsUser.getNoticeFlag       ())); 
				fromUser.setRISK_FLAG   ( String.valueOf(fromInsUser.getRiskFlag         ()));
				fromUser.setOS_STATUS   ( fromOsState != null?fromOsState.getOsStatus():null);
				fromUser.setSTATUS      ( fromInsUser.getState                           () );
				fromUser.setCOUNTRY_CODE( fromInsUser.getCountryCode                     () );
				fromUser.setADDRESS_ID  ( fromInsUser.getAddressId                       () );
				fromUser.setADDRESS_DESC( fromInsUser.getAddressDesc                     () );
				if( StringUtils.isBlank( fromUser.getCOUNTRY_CODE() ) ){
					fromUser.setCOUNTRY_CODE( fromInsUser.getAreaCode                    () );
				}
				fromUser.setEFFECTIVE	( fromInsUser.getEffectiveDate                   () );
				fromUser.setEXPIRE		( fromInsUser.getExpireDate                      () );
			}
			finally{
				
			}
			return fromUser;
		}
		
		/**
		 * 
		 * @param aInsOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserOffer _wrap(InsOffer aInsOffer) throws SFException,Exception{
			IOVUserOffer fromOffer = null;
			try
			{
				fromOffer = new IOVUserOffer();
				fromOffer.setINS_OFFER_ID( aInsOffer.getOfferInstId                () ); 
				fromOffer.setUSER_ID     ( aInsOffer.getUserId                     () );
				fromOffer.setOFFER_ID    ( aInsOffer.getOfferId                    () ); 
				fromOffer.setOFFER_TYPE  ( aInsOffer.getOfferType                  () ); 
				fromOffer.setSTATUS      ( aInsOffer.getState                      () ); 
				fromOffer.setBRAND_ID    ( String.valueOf( aInsOffer.getBrandId ()  ) );
				fromOffer.setCOUNTY_CODE ( aInsOffer.getCountyCode                 () ); 
				fromOffer.setREGION_ID   ( aInsOffer.getRegionId                   () ); 
				fromOffer.setEFFECTIVE   ( aInsOffer.getEffectiveDate              () ); 
				fromOffer.setEXPIRE      ( aInsOffer.getExpireDate                 () );
				fromOffer.setSALE_TYPE	 ( aInsOffer.getSaleType                   () );
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 
		 * @param aInsOfferInsUser
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserOrderOffer _wrap(InsOfferInsUser aOfferUser) throws SFException,Exception{
			IOVUserOrderOffer fromOffer = null;
			try
			{
				fromOffer = new IOVUserOrderOffer();
				fromOffer.setINS_OFFER_ID    ( aOfferUser.getOfferInstId	 () );  
				fromOffer.setUSER_ID         ( aOfferUser.getUserId			 () );  
				fromOffer.setOFFER_ID        ( aOfferUser.getOfferId	     () );  
				fromOffer.setROLE_ID         ( aOfferUser.getRoleId			 () );  
				fromOffer.setMAIN_OFFER      ( aOfferUser.getIsMainOffer	 () );  
				fromOffer.setGROUP_USER      ( aOfferUser.getIsGrpMainUser   () );  
				fromOffer.setSTATUS          ( aOfferUser.getState			 () );  
				fromOffer.setCOUNTY_CODE     ( aOfferUser.getCountyCode	     () );  
				fromOffer.setREGION_ID       ( aOfferUser.getRegionId		 () );  
				fromOffer.setUSER_REGION_ID  ( aOfferUser.getUserRegionId    () );
				fromOffer.setGROUP_REGION_ID ( aOfferUser.getGroupRegionId   () );  
				fromOffer.setEFFECTIVE       ( aOfferUser.getEffectiveDate   () );  
				fromOffer.setEXPIRE          ( aOfferUser.getExpireDate	     () ); 
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromGroup
		 * @param fromInsSrv
		 * @param fromInsSrvpkg
		 * @param fromInsSrvAttr
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserOrder _wrap(IOVUserOrderOffer fromGroup,
				InsProdInsSrv fromInsSrv, 
				InsProd fromInsSrvpkg, 
				InsSrvAttr fromInsSrvAttr[] ) throws SFException,Exception{
			IOVUserOrder fromOrder = null;
			try
			{
				fromOrder = new IOVUserOrder();
				fromOrder.setINS_SERV_ID ( fromInsSrv.getProdSrvRelatId       () );
				fromOrder.setINS_PROD_ID ( fromInsSrv.getProdInstId           () );
				fromOrder.setINS_OFFER_ID( fromInsSrv.getOfferInstId          () );
				fromOrder.setUSER_ID     ( fromInsSrv.getUserId               () );
				fromOrder.setSERVICE_ID  ( fromInsSrv.getServiceId            () );
				fromOrder.setPRODUCT_ID  ( fromInsSrvpkg.getProdId            () );
				ICustom._wrap            ( fromGroup, fromOrder                  );
				fromOrder.setSTATUS      ( String.valueOf(fromInsSrv.getState()) );
				fromOrder.setEFFECTIVE   ( fromInsSrv.getEffectiveDate        () );
				fromOrder.setEXPIRE      ( fromInsSrv.getExpireDate           () );
				for( int index = 0; fromInsSrvAttr != null && index < fromInsSrvAttr.length; index++ ){
					IOVUserOfferX fromOrdAttr = ICustom._wrap( fromInsSrvAttr[index] );
					fromOrder.getFUTURE().add( fromOrdAttr );
				}
			}
			finally{
				
			}
			return fromOrder;
		}
		
		/**
		 * 
		 * @param aInsSrvAttr
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserOfferX _wrap(InsSrvAttr aInsSrvAttr) throws SFException,Exception{
			IOVUserOfferX fromOrdAttr =new IOVUserOfferX();
			try
			{
				fromOrdAttr.setINS_ATTR_ID(aInsSrvAttr.getAttrInstId              ());   
				fromOrdAttr.setATTR_ID    (String.valueOf(aInsSrvAttr.getAttrId  ()));   
				fromOrdAttr.setATTR_VALUE (aInsSrvAttr.getAttrValue               ());   
				fromOrdAttr.setSTATUS     (String.valueOf(aInsSrvAttr.getState   ()));   
				fromOrdAttr.setEFFECTIVE  (aInsSrvAttr.getEffectiveDate           ());   
				fromOrdAttr.setEXPIRE     (aInsSrvAttr.getExpireDate              ());   
			}
			finally{
				
			}
			return fromOrdAttr;
		}
		
		/**
		 * 
		 * @param fromGroup
		 * @param fromOrder
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVUserOrderOffer fromGroup, 
				IOVUserOrder fromOrder ) throws SFException,Exception{
			try
			{
				fromOrder.setPROD_TYPE   ( IUpdbfsConst.IUpdbm.IProdType.NORMAL );
				fromOrder.setGROUP       ( fromGroup                            );
				if( fromGroup != null && fromGroup.getGROUP_USER() == 1 ){
					fromOrder.setPROD_TYPE( IUpdbfsConst.IUpdbm.IProdType.GROUP );
				}
				else if( fromGroup != null && fromGroup.getMAIN_OFFER() == 1 ){
					fromOrder.setPROD_TYPE   ( IUpdbfsConst.IUpdbm.IProdType.GROUP );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromMsgFUser
		 * @param fromUser
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUser _wrap( IOVMsgFUser fromMsgFUser, IOVUser fromUser ) throws SFException,Exception{
			try
			{
				IOVMsgFCustom fromMsgFCust = fromMsgFUser.getCUSTOM();
				fromUser.setUSER_ID       ( fromMsgFUser.getUSER_ID                            () );
				fromUser.setCATALOG       ( fromMsgFUser.getCATALOG                            () );
				fromUser.setCUSTOM        ( ICustom._wrap( fromMsgFCust                         ) );
				fromUser.setBILL_ID       ( fromMsgFUser.getBILL_ID                            () );
				fromUser.setREGION_ID     ( fromMsgFUser.getUSER_REGION_ID                     () );
				fromUser.setSUB_BILL_ID   ( fromMsgFUser.getSUB_BILL_ID                        () );
				fromUser.setSTATUS        ( fromMsgFUser.getUSER_STATUS                        () );
				fromUser.setOS_STATUS     ( fromMsgFUser.getOS_STATUS                          () );
				fromUser.setIS_OUT_NET    ( fromMsgFUser.getIS_OUT_NET                         () );
				fromUser.setBRAND_ID      ( fromMsgFUser.getBRAND_ID                           () );
				fromUser.setUSER_TYPE     ( fromMsgFUser.getUSER_TYPE                          () );
				fromUser.setNOTICE_FLAG   ( fromMsgFUser.getNOTICE_FLAG                        () );
				fromUser.setRISK_FLAG     ( fromMsgFUser.getRISK_FLAG                          () );
				fromUser.setCOUNTRY_CODE  ( fromMsgFUser.getCOUNTRY_CODE                       () );
				fromUser.setEFFECTIVE     ( fromMsgFUser.getEFFECTIVE                          () );
				fromUser.setEXPIRE        ( fromMsgFUser.getEXPIRE                             () );
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFUser.getNATURE().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
					IOVUserOfferX _userofferx = ICustom._wrap( fromMsgFOfferX, new IOVUserOfferX() );
					if( StringUtils.equals( _userofferx.getATTR_ID(), IUpdbfsConst.IUpdbm.IUser.NEWMSDN ) ){
						fromUser.setBILL_ID( _userofferx.getATTR_VALUE() );
					}
					else if( StringUtils.equals( _userofferx.getATTR_ID(), IUpdbfsConst.IUpdbm.IUser.NEWIMSI ) ){
						fromUser.setSUB_BILL_ID( _userofferx.getATTR_VALUE() );
					}
					else{
						fromUser.mergeAsNature( _userofferx );
					}
					
				}
			}
			finally{
				
			}
			return fromUser;
		}
		
		/**
		 * 
		 * @param fromMsgFCentrex
		 * @param fromCentrex
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserCentrex _wrap( IOVMsgFCentrex fromMsgFCentrex, IOVUserCentrex fromCentrex ) throws SFException,Exception{
			try
			{
				fromCentrex.setINS_PROD_ID ( fromMsgFCentrex.getINS_PROD_ID () );
				fromCentrex.setINS_OFFER_ID( fromMsgFCentrex.getINS_OFFER_ID() );
				fromCentrex.setUSER_ID     ( fromMsgFCentrex.getUSER_ID     () );
				fromCentrex.setREGION_ID   ( fromMsgFCentrex.getREGION_ID   () );
				fromCentrex.setPRODUCT_ID  ( fromMsgFCentrex.getPRODUCT_ID  () );
				fromCentrex.setSTATUS      ( fromMsgFCentrex.getSTATUS      () );
				fromCentrex.setEFFECTIVE   ( fromMsgFCentrex.getEFFECTIVE   () );
				fromCentrex.setEXPIRE      ( fromMsgFCentrex.getEXPIRE      () );
				for( java.util.Iterator<IOVMsgFOffer> itera = fromMsgFCentrex.getCENTREX().iterator(); itera.hasNext(); ){
					IOVMsgFOffer fromMsgFOffer = (IOVMsgFOffer)itera.next();
					IOVUserOrder _userorder = _wrap( fromMsgFOffer, new IOVUserOrder() );
					fromCentrex.getCENTREX().add( _userorder );
				}
			}
			finally{
				
			}
			return fromCentrex;
		}
		
		/**
		 * 
		 * @param fromMsgFOffer
		 * @param fromOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserOrder _wrap( IOVMsgFOffer fromMsgFOffer, IOVUserOrder fromOffer ) throws SFException,Exception{
			try
			{
				fromOffer.setINS_SERV_ID ( fromMsgFOffer.getINS_SRVC_ID () );
				fromOffer.setINS_PROD_ID ( fromMsgFOffer.getINS_PROD_ID () );
				fromOffer.setINS_OFFER_ID( fromMsgFOffer.getINS_OFFER_ID() );
				fromOffer.setUSER_ID     ( fromMsgFOffer.getUSER_ID     () );
				fromOffer.setSERVICE_ID  ( fromMsgFOffer.getSERVICE_ID  () );
				fromOffer.setPRODUCT_ID  ( fromMsgFOffer.getPRODUCT_ID  () );
				fromOffer.setPROD_TYPE   ( fromMsgFOffer.getPROD_TYPE   () );
				fromOffer.setSTATUS      ( IUpdbfsConst.IState.IOrder.S01  );
				if( fromMsgFOffer.isSUSPEND() /*暂停服务产品*/){
					fromOffer.setSTATUS  ( IUpdbfsConst.IState.IOrder.S03  );
				}
				fromOffer.setEFFECTIVE   ( fromMsgFOffer.getEFFECTIVE   () );
				fromOffer.setEXPIRE      ( fromMsgFOffer.getEXPIRE      () );
				if( fromMsgFOffer.isVALIDALL() == false ){
					fromOffer.setEXPIRE   ( TimeUtils.getExpire         () );
				}
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFOffer.getFUTURE().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
					IOVUserOfferX fromOfferX = _wrap( fromMsgFOfferX, new IOVUserOfferX() );
					fromOffer.getFUTURE().add( fromOfferX );
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 
		 * @param fromMsgFPlan
		 * @param fromPlan
		 * @return
		 */
		public static IOVUserOffer _wrap( IOVMsgFPlan fromMsgFPlan, IOVUserOffer fromPlan ){
			try
			{
				fromPlan.setINS_OFFER_ID( fromMsgFPlan.getINS_OFFER_ID           () );
				fromPlan.setUSER_ID     ( fromMsgFPlan.getUSER_ID                () );
				fromPlan.setOFFER_ID    ( fromMsgFPlan.getOFFER_ID               () );
				fromPlan.setOFFER_TYPE  ( fromMsgFPlan.getOFFER_TYPE             () );
				fromPlan.setSTATUS      ( Long.parseLong(fromMsgFPlan.getSTATUS() ) );
				fromPlan.setEFFECTIVE   ( fromMsgFPlan.getEFFECTIVE              () );
				fromPlan.setEXPIRE      ( fromMsgFPlan.getEXPIRE                 () );
			}
			finally{
				
			}
			return fromPlan;
		}
		
		/**
		 * 
		 * @param fromMsgFPlan
		 * @param fromPlan
		 * @return
		 */
		public static IOVMsgFPlan _wrap(IOVUserOffer fromPlan, IOVMsgFPlan fromMsgFPlan ){
			try
			{
				fromMsgFPlan.setINS_OFFER_ID( fromPlan.getINS_OFFER_ID           () );
				fromMsgFPlan.setUSER_ID     ( fromPlan.getUSER_ID                () );
				fromMsgFPlan.setOFFER_ID    ( fromPlan.getOFFER_ID               () );
				fromMsgFPlan.setOFFER_TYPE  ( fromPlan.getOFFER_TYPE             () );
				fromMsgFPlan.setSTATUS      ( String.valueOf( fromPlan.getSTATUS()) );
				fromMsgFPlan.setEFFECTIVE   ( fromPlan.getEFFECTIVE              () );
				fromMsgFPlan.setEXPIRE      ( fromPlan.getEXPIRE                 () );
			}
			finally{
				
			}
			return fromMsgFPlan;
		}
		
		/**
		 * 
		 * @param fromMsgFCust
		 * @param fromCustom
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVCustom _wrap( IOVMsgFCustom fromMsgFCust ) throws SFException,Exception{
			IOVCustom fromCustom = null;
			try
			{
				if( fromMsgFCust != null ){
					fromCustom = new IOVCustom();
					fromCustom.setCUST_ID        ( fromMsgFCust.getCUST_ID        () );
					fromCustom.setCUST_CODE      ( fromMsgFCust.getCUST_CODE      () );
					fromCustom.setCUST_NAME      ( fromMsgFCust.getCUST_NAME      () );
					fromCustom.setCUST_TYPE      ( fromMsgFCust.getCUST_TYPE      () );
					fromCustom.setGROUP_ID       ( fromMsgFCust.getCUST_CODE      () );
					fromCustom.setGROUP_TYPE     ( fromMsgFCust.getCUST_LEVEL     () );
					fromCustom.setCUST_LEVEL     ( fromMsgFCust.getCUST_LEVEL     () );
					fromCustom.setCUST_ADDRESS   ( fromMsgFCust.getCUST_ADDRESS   () );
					fromCustom.setCUST_VOCATION  ( fromMsgFCust.getCUST_VOCATION  () );
					fromCustom.setCUST_CERTTYPE  ( fromMsgFCust.getCUST_CERTTYPE  () );
					fromCustom.setCUST_CERTCODE  ( fromMsgFCust.getCUST_CERTCODE  () );
					fromCustom.setCONTACT_NAME   ( fromMsgFCust.getCONTACT_NAME   () );
					fromCustom.setCONTACT_ENGLISH( fromMsgFCust.getCONTACT_ENGLISH() );
					fromCustom.setCONTACT_PHONE  ( fromMsgFCust.getCONTACT_PHONE  () );
					fromCustom.setCOUNTRY_CODE   ( fromMsgFCust.getCOUNTRY_CODE   () );
					fromCustom.setREGION_ID      ( fromMsgFCust.getREGION_ID      () );
					fromCustom.setEFFECTIVE      ( fromMsgFCust.getEFFECTIVE      () );
					fromCustom.setEXPIRE         ( fromMsgFCust.getEXPIRE         () );
					for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFCust.getNATURE().iterator(); itera.hasNext(); ){
						IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
						IOVUserOfferX fromOfferX = new IOVUserOfferX();
						ICustom._wrap( fromMsgFOfferX, fromOfferX );
						if( StringUtils.equals( fromOfferX.getATTR_ID(), IUpdbfsConst.IUpdbm.IUser.GROUP_ID ) ){
							fromCustom.setGROUP_ID  ( fromOfferX.getATTR_VALUE() );
						}
						else if( StringUtils.equals( fromOfferX.getATTR_ID(), IUpdbfsConst.IUpdbm.IUser.GROUP_TYPE ) ){
							fromCustom.setGROUP_TYPE( fromOfferX.getATTR_VALUE() );
						}
						fromCustom.getNATURE().add( fromOfferX );
					}
				}
			}
			finally{
				
			}
			return fromCustom;
		}
		
		/**
		 * 
		 * @param fromCustom
		 * @param fromMsgFCust
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFCustom _wrap( IOVCustom fromCustom, 
				IOVMsgFCustom fromMsgFCust )  throws SFException,Exception{
			try
			{
				fromMsgFCust.setCUST_ID        ( fromCustom.getCUST_ID        () );
				fromMsgFCust.setCUST_CODE      ( fromCustom.getCUST_CODE      () );
				fromMsgFCust.setCUST_NAME      ( fromCustom.getCUST_NAME      () );
				fromMsgFCust.setCUST_TYPE      ( fromCustom.getCUST_TYPE      () );
				fromMsgFCust.setCUST_LEVEL     ( fromCustom.getCUST_LEVEL     () );
				fromMsgFCust.setCUST_ADDRESS   ( fromCustom.getCUST_ADDRESS   () );
				fromMsgFCust.setCUST_VOCATION  ( fromCustom.getCUST_VOCATION  () );
				fromMsgFCust.setCUST_CERTTYPE  ( fromCustom.getCUST_CERTTYPE  () );
				fromMsgFCust.setCUST_CERTCODE  ( fromCustom.getCUST_CERTCODE  () );
				fromMsgFCust.setCONTACT_NAME   ( fromCustom.getCONTACT_NAME   () );
				fromMsgFCust.setCONTACT_ENGLISH( fromCustom.getCONTACT_ENGLISH() );
				fromMsgFCust.setCONTACT_PHONE  ( fromCustom.getCONTACT_PHONE  () );
				fromMsgFCust.setCOUNTRY_CODE   ( fromCustom.getCOUNTRY_CODE   () );
				fromMsgFCust.setREGION_ID      ( fromCustom.getREGION_ID      () );
				fromMsgFCust.setEFFECTIVE      ( fromCustom.getEFFECTIVE      () );
				fromMsgFCust.setEXPIRE         ( fromCustom.getEXPIRE         () );
				if( StringUtils.isBlank( fromCustom.getGROUP_ID() ) == false ){
					fromMsgFCust.getNATURE().add( new IOVMsgFOfferX(IUpdbfsConst.IUpdbm.IUser.GROUP_ID,
							fromCustom.getGROUP_ID() ) );
				}
				if( StringUtils.isBlank( fromCustom.getGROUP_TYPE() ) == false ){
					fromMsgFCust.getNATURE().add( new IOVMsgFOfferX(IUpdbfsConst.IUpdbm.IUser.GROUP_TYPE,
							fromCustom.getGROUP_TYPE() ) );
				}
				for( java.util.Iterator<IOVUserOfferX> itera = fromCustom.getNATURE().iterator(); itera.hasNext(); ){
					IOVUserOfferX fromOfferX = (IOVUserOfferX)itera.next();
					IOVMsgFOfferX fromMsgFOfferX = new IOVMsgFOfferX();
					ICustom._wrap( fromOfferX, fromMsgFOfferX );
					fromMsgFCust.getNATURE().add( fromMsgFOfferX );
				}
			}
			finally{
				
			}
			return fromMsgFCust;
		}
		
		/**
		 * 
		 * @param fromMsgFOfferX
		 * @param fromOfferX
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUserOfferX _wrap( IOVMsgFOfferX fromMsgFOfferX, IOVUserOfferX fromOfferX ) throws SFException,Exception{
			try
			{
				fromOfferX.setINS_ATTR_ID( fromMsgFOfferX.getINS_ATTR_ID() );
				fromOfferX.setATTR_ID    ( fromMsgFOfferX.getATTR_ID    () );
				fromOfferX.setATTR_VALUE ( fromMsgFOfferX.getATTR_VALUE () );
				fromOfferX.setSTATUS     ( null                            );
				if( fromMsgFOfferX.getSTATUS() != null ){
					fromOfferX.setSTATUS ( IUpdbfsConst.IState.IOrder.S01  );
				}
				fromOfferX.setEFFECTIVE  ( fromMsgFOfferX.getEFFECTIVE  () );
				fromOfferX.setEXPIRE     ( fromMsgFOfferX.getEXPIRE     () );
				if( fromMsgFOfferX.isVALIDALL() == false ){
					fromOfferX.setEXPIRE  ( TimeUtils.getExpire         () );
				}
			}
			finally{
				
			}
			return fromOfferX;
		}
		
		/**
		 * 
		 * @return
		 */
		public static String getSqlSysdate() {
			String fromSysdate = "sysdate";
			try
			{
				String fromTYPE = DialectFactory.getDialect().getDatabaseType();
				if( DialectFactory.ORACLE.equals( fromTYPE ) ) {
					fromSysdate = "sysdate";
				} 
				else if( DialectFactory.MYSQL.equals( fromTYPE ) ) {
					fromSysdate = "sysdate()";
				}
				else if( DialectFactory.SYBASE.equals( fromTYPE ) ){
					fromSysdate = "getdate()";
				}
			}
			finally{
				
			}
			return fromSysdate;
		}
		
		/**
		 * 
		 * @return
		 */
		public  static String getSqlPreSysdate(){
			String fromSysdate = "sysdate";
			try
			{
				String fromTYPE = DialectFactory.getDialect().getDatabaseType();
				if( DialectFactory.ORACLE.equals( fromTYPE ) ) {
					fromSysdate = "sysdate - 1";
				} 
				else if( DialectFactory.MYSQL.equals( fromTYPE ) ) {
					fromSysdate = "sysdate()";
				}
				else if( DialectFactory.SYBASE.equals( fromTYPE ) ){
					fromSysdate = "getdate()";
				}
			}
			finally{
				
			}
			return fromSysdate;
		}
		
		/**
		 * 
		 * @param fromValidType
		 * @return
		 */
		public static String getSqlValidType(int fromValidType){
			StringBuilder condition = new StringBuilder();
			try
			{
			    if(fromValidType == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW){//1
			    	condition.append(" and ").append( ICustom.getSqlSysdate() )
			    	         .append(" between EFFECTIVE_DATE and EXPIRE_DATE ");
			    }else if(fromValidType == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NEXT){//2
			    	condition.append(" and ").append("EFFECTIVE_DATE > ")
			    	         .append( ICustom.getSqlSysdate() ).append(" ");
			    }else if(fromValidType == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_EXPIRED){//4
			    	condition.append(" and EXPIRE_DATE < ")
			    	         .append( ICustom.getSqlSysdate() ).append(" ");
			    }else if(fromValidType == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL){//-1
			    	condition.append(" and EXPIRE_DATE >= ")
			    	         .append( ICustom.getSqlPreSysdate() ).append(" ");
			    }
			}
			finally{
				
			}
			return condition.toString();
		}
		
	}
	
	public static class ICatalog{
		public ICatalog(){
			super();
		}
		
		/**
		 * 获取客户中心用户编号索引号[用户信息]
		 * @param aUserId 用户编码
		 * @return
		 */
		public static String _custom_user_id( long aUserId ){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_USER_ID", "_$_", String.valueOf( aUserId ) });
		}
		
		/**
		 * 获取客户编号索引号[客户信息]
		 * @param aCustId 客户编号
		 * @param aCustType 客户类型
		 * @return
		 */
		public static String _custom_cust_id( long aCustId, String aCustType ){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_CUSTOM_ID", "_$_", String.valueOf( aCustId ) , "_$_" , aCustType });
		}
		
		/**
		 * 获取策划实例编号索引号[用户套餐]
		 * @param aInsOfferId 套餐编号
		 * @param aRegionId 地市编码
		 * @return
		 */
		public static String _custom_offer_id( long aInsOfferId, String aRegionId ){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_OFFER_ID", "_$_", String.valueOf( aInsOfferId ), "_$_", aRegionId });
		}
		
		/**
		 * 获取客户中心服务产品索引号[用户订购]
		 * @param aSpromId 产品编号
		 * @return
		 */
		public static String _custom_sprom_id( long aSpromId ){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_SPROM_ID", "_$_", String.valueOf( aSpromId ) });
		}
		
		/**
		 * 获取客户中心用户群组索引号[用户群关系]
		 * @return
		 */
		public static String _custom_user_group(){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_USER_GROUP_$_USER_GROUP_XXX" });
		}
		
		/**
		 * 获取客户中心群组策划关系索引号[群组策划关系]
		 * @param aInsOfferId 策划编号
		 * @param aRegionId 地市编码
		 * @return
		 */
		public static String _custom_group_offer_id(long aInsOfferId, String aRegionId ){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_GROUP_OFFER_ID", "_$_", String.valueOf( aInsOfferId ), "_$_", aRegionId });
		}
		
		/**
		 * 获取群组策划用户索引号
		 * @param aInsOfferId 策划编号
		 * @param aRegionId 地市编码
		 * @return
		 */
		public static String _custom_group_user_id( long aInsOfferId, String aRegionId ){
			return ClassUtils.getINDEX( new String[]{ "PROGRAM_CUSTOM_$_GROUP_USER_ID", "_$_", String.valueOf( aInsOfferId ), "_$_", aRegionId });
		}
		
		/**
		 * 获取到期用户索引号
		 * @param aUserId 用户编码
		 * @return
		 */
		public static String _expire_user_id( long aUserId ){
			String fromINDEX = null;
			try
			{
				fromINDEX = ClassUtils.getINDEX( new String[]{ "PROGRAM_EXPIRE_$_USER_ID", "_$_", String.valueOf( aUserId ) } );
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 获取下周期素引
		 * @param aUserId 用户编号
		 * @param aExpire 到期时间
		 * @return
		 */
		public static String _expire_user_id( long aUserId, java.sql.Timestamp aExpire ){
			String fromINDEX = null;
			try
			{
				fromINDEX = ClassUtils.getINDEX( new String[]{String.valueOf( aUserId ), "_$_", TimeUtils.getAsExpire( aExpire ) } );
			}
			finally{
				
			}
			return fromINDEX;
		}
	}
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 是否发起为消息消费者
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isRECEIVE() throws SFException,Exception{
			boolean fromBool = false;
			try
			{
				MBeanDelegate fromMBean = null;
				if( UpfsvcManager.getBlankMBean() != null ){
					fromMBean = UpfsvcManager.getBlankMBean().getQuality();
				}
				fromBool = fromMBean != null && fromMBean.getOBJECTIVE() != null && 
						( ( fromMBean.getOBJECTIVE() instanceof IOVRocketExigence ) ||
								( fromMBean.getOBJECTIVE() instanceof IOVRocketExigence[] ) );
			}
			finally{
				
			}
			return fromBool;
		}
		
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 根据地市编码获取系统级数据源
		 * @param aREGION_ID 地市编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getTransactionName( String aREGION_ID) throws SFException, Exception {
			String fromSCHEMA = null;
			try
			{
				ISystemTemplate.ICenterRoute fromCENTER = null;
				fromSCHEMA = ServiceManager.getSession().getCurrentTransactionName();
				String aTEMPLATE = DataSourceTemplate.getCurrentTemplate();
				if( StringUtils.contains( aTEMPLATE, IUpdcConst.IUpdbm.IUpdmc.CENTER_FLAG ) ){
					fromCENTER = ISystem.getCenterByRegionId( aREGION_ID );
					fromSCHEMA = StringUtils.replace( aTEMPLATE, 
							IUpdcConst.IUpdbm.IUpdmc.CENTER_FLAG, 
							fromCENTER.getCENTER() );
				}
			}
			finally{
				
			}
			return fromSCHEMA;
		}
		
		/**
		 * 根据当前数据记录获取当前系统级数据源
		 * @param fromTYPE BO对象类型
		 * @param fromPARAM 查询条件
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getTransactionName( ObjectType fromTYPE, java.util.Map<String,Object> fromPARAM  ) throws SFException,Exception{
			String aSchema = null;
			try
			{
				Object _region_id = fromPARAM.get( IUpdcConst.IUpdbm.IUpdmc.REGION_ID );
				if( _region_id == null ){
					_region_id = fromPARAM.get( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE );
				}
				if( _region_id == null || StringUtils.isBlank( _region_id.toString() ) ){
					_region_id = CenterUtils.ICustom.getRegionId();
				}
				aSchema = ISystem.getTransactionName( _region_id != null?_region_id.toString():null );
			}
			finally{
				
			}
			return aSchema;
		}
		
		/**
		 * 根据当前数据记录获取当前系统级数据源
		 * @param fromEntity 
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getTransactionName( DataStructInterface fromEntity ) throws SFException,Exception{
			String aSchema = null;
			try
			{
				aSchema = ISystem.getTransactionName( fromEntity.getObjectType(), fromEntity.getProperties() );
			}
			finally{
				
			}
			return aSchema;
		}
		
		/**
		 * 根据当前数据源获取当前指定数据连接
		 * @param schema 当前数据源
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.sql.Connection getTransaction( String schema ) throws SFException,Exception{
			java.sql.Connection aTransaction = null;
			try
			{
				aTransaction = ServiceManager.getSession().getConnection( schema );
			}
			catch( java.lang.Exception aEXCEPTION ){
				ExceptionFactory.throwOracleConnect("IOS0014014", new String[]{schema,
						aEXCEPTION.getMessage()}, 
						aEXCEPTION );
			}
			finally{
				
			}
			return aTransaction;
		}
		/**
		 * 根据当前数据源获取数据库连接对象
		 * @param aTYPE  数据库表
		 * @param fromPARAM 数据参数
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.sql.Connection getTransaction( ObjectType fromTYPE, java.util.Map<String,Object> fromPARAM  ) throws SFException,Exception{
			java.sql.Connection aTransaction = null;
			try
			{
				String aTransactionName = ISystem.getTransactionName( fromTYPE, fromPARAM );
				aTransaction = ISystem.getTransaction( aTransactionName );
			}
			finally{
				
			}
			return aTransaction;
		}
		
		/**
		 * 根据当前地市编码获取指定数据库中心路由
		 * @param aREGION_ID 地市编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterRoute getCenterByRegionId( String aREGION_ID )  throws SFException,Exception{
			ISystemTemplate.ICenterRoute fromCENTER = null;
			try
			{
				fromCENTER = IUpdcfgFactory.getIBasicSV().getSFCenterOffer(aREGION_ID, 
						IUpdcConst.IUpdbm.IUpdbf.CUSTOM, 
						IUpdcConst.IUpfwm.IUpfm.ucmframe );
			}
			finally{
				
			}
			return fromCENTER;
		}
	}

}
