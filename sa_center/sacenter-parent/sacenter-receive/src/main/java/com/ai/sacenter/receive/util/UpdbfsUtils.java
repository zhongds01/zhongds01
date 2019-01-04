package com.ai.sacenter.receive.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxDepend;
import com.ai.sacenter.receive.valuebean.IOVMsgFCustom;
import com.ai.sacenter.receive.valuebean.IOVMsgFGroup;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFPlan;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderCustom;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderGroup;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOfferX;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月25日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public final class UpdbfsUtils {
	public UpdbfsUtils(){
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 根据开通服务订购构造其对应服务订购
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通订购
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFOffer _wrap(IOVMsgFRequest fromRequest, IOVMsgFOffer fromMsgFOffer ) throws SFException, Exception{
			IOVMsgFOffer fromOffer = null;
			try
			{
				if( fromMsgFOffer instanceof IOVMsgFOrdOffer ){
					fromOffer = new IOVMsgFOrdOffer( fromMsgFOffer );
				}
				else if( fromMsgFOffer instanceof IOVMsgFUserOffer ){
					fromOffer = new IOVMsgFUserOffer( fromMsgFOffer );
				}
				else{
					fromOffer = new IOVMsgFOrdOffer( fromMsgFOffer );
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 根据开通服务属性订购构造其对应服务订购
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通订购
		 * @param fromMsgFOfferX 开通属性
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFOffer _wrap(IOVMsgFRequest fromRequest, 
				IOVMsgFOffer fromMsgFOffer,
				IOVMsgFOfferX fromMsgFOfferX) throws SFException, Exception{
			IOVMsgFOffer fromOffer = null;
			try
			{
				if( fromMsgFOffer instanceof IOVMsgFOrdOffer ){
					fromOffer = new IOVMsgFOrdOffer( fromMsgFOfferX );
					fromOffer.setINS_PROD_ID ( fromMsgFOffer.getINS_PROD_ID () );
					fromOffer.setUSER_ID     ( fromMsgFOffer.getUSER_ID     () );
					fromOffer.setPROD_TYPE   ( fromMsgFOffer.getPROD_TYPE   () );
				}
				else if( fromMsgFOffer instanceof IOVMsgFUserOffer ){
					fromOffer = new IOVMsgFUserOffer( fromMsgFOfferX );
					fromOffer.setINS_PROD_ID ( fromMsgFOffer.getINS_PROD_ID () );
					fromOffer.setUSER_ID     ( fromMsgFOffer.getUSER_ID    () );
					fromOffer.setPROD_TYPE   ( fromMsgFOffer.getPROD_TYPE  () );
				}
				else{
					fromOffer = new IOVMsgFOrdOffer( fromMsgFOfferX );
					fromOffer.setINS_PROD_ID ( fromMsgFOffer.getINS_PROD_ID () );
					fromOffer.setUSER_ID     ( fromMsgFOffer.getUSER_ID     () );
					fromOffer.setPROD_TYPE   ( fromMsgFOffer.getPROD_TYPE   () );
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 将开通定单订购转换开通定单依赖订购关系
		 * @param fromRequest 开通定单
		 * @param fromMsgFUser 开通用户
		 * @param fromMsgFOffer 开通定单订购
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFUserOffer _depend( IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMsgFUser,
				IOVMsgFOffer fromMsgFOffer ) throws SFException, Exception{
			IOVMsgFUserOffer fromUserOffer = null;
			try
			{
				fromUserOffer = new IOVMsgFUserOffer( fromMsgFOffer );
				fromUserOffer.setSTATUS( IUpdbfsConst.IState.IOrder.S05 );
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromUserOffer.getFUTURE().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
					fromOfferX.setSTATUS( IUpdbfsConst.IState.IOrder.S05 );
				}
			}
			finally{
				
			}
			return fromUserOffer;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromOrdUser
		 * @param fromUpdcpm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap(IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMsgFUser, 
				IOVOrderUser fromOrdUser,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			try
			{
				fromOrdUser.setUSER_ID       ( fromMsgFUser.getUSER_ID                () );
				fromOrdUser.setCATALOG_ID    ( fromMsgFUser.getCATALOG                () );
				fromOrdUser.setBILL_ID       ( fromMsgFUser.getBILL_ID                () );
				fromOrdUser.setSUB_BILL_ID   ( fromMsgFUser.getSUB_BILL_ID            () );
				fromOrdUser.setBRAND_ID      ( fromMsgFUser.getBRAND_ID               () );
				fromOrdUser.setROLE_ID		 ( fromMsgFUser.getROLE_ID	              () );
				fromOrdUser.setUSER_TYPE     ( fromMsgFUser.getUSER_TYPE              () );
				fromOrdUser.setRISK_FLAG     ( fromMsgFUser.getRISK_FLAG              () );
				fromOrdUser.setNOTICE_FLAG   ( fromMsgFUser.getNOTICE_FLAG            () );
				fromOrdUser.setIS_OUT_NET    ( fromMsgFUser.getIS_OUT_NET             () );
				fromOrdUser.setSTATE         ( fromMsgFUser.getUSER_STATUS            () );
				fromOrdUser.setREGION_ID     ( fromMsgFUser.getREGION_ID              () );
				fromOrdUser.setUSER_REGION_ID( fromMsgFUser.getUSER_REGION_ID         () );
				fromOrdUser.setCOUNTRY_CODE  ( fromMsgFUser.getCOUNTRY_CODE           () );
				fromOrdUser.setEFFECTIVE     ( fromMsgFUser.getEFFECTIVE              () );
				fromOrdUser.setEXPIRE        ( fromMsgFUser.getEXPIRE                 () );
				fromOrdUser.setCUSTOM        ( ICustom._wrap( fromMsgFUser.getCUSTOM() ) );
				fromOrdUser.setGROUP         ( ICustom._wrap( fromMsgFUser.getGROUP  ()) );
				ICustomX._jj_global( fromRequest, fromMsgFUser, fromOrdUser, fromUpdcpm );
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFUser.getNATURE().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromMsgFOffX = (IOVMsgFOfferX)itera.next();
					if( fromMsgFOffX.isEFFECTIVE() == false ) continue;
					IOVOrderOfferX fromOfferX = ICustom._wrap( fromMsgFOffX );
					fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
				}
				IOrderFactory.getIOrdMixSV().finishSFOsStatusTrail(fromRequest, 
						fromMsgFUser, 
						fromOrdUser);
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromMsgFCust
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderCustom _wrap( IOVMsgFCustom fromMsgFCust ) throws SFException,Exception{
			IOVOrderCustom fromOrdCust = null;
			try
			{
				if( fromMsgFCust != null ){
					fromOrdCust = new IOVOrderCustom();
					fromOrdCust.setCUST_ID        ( fromMsgFCust.getCUST_ID        () );
					fromOrdCust.setCUST_CODE      ( fromMsgFCust.getCUST_CODE      () );
					fromOrdCust.setCUST_NAME      ( fromMsgFCust.getCUST_NAME      () );
					fromOrdCust.setCUST_TYPE      ( fromMsgFCust.getCUST_TYPE      () );
					fromOrdCust.setCUST_LEVEL     ( fromMsgFCust.getCUST_LEVEL     () );
					fromOrdCust.setCUST_ADDRESS   ( fromMsgFCust.getCUST_ADDRESS   () );
					fromOrdCust.setCUST_VOCATION  ( fromMsgFCust.getCUST_VOCATION  () );
					fromOrdCust.setCUST_CERTTYPE  ( fromMsgFCust.getCUST_CERTTYPE  () );
					fromOrdCust.setCUST_CERTCODE  ( fromMsgFCust.getCUST_CERTCODE  () );
					fromOrdCust.setCONTACT_NAME   ( fromMsgFCust.getCONTACT_NAME   () );
					fromOrdCust.setCONTACT_ENGLISH( fromMsgFCust.getCONTACT_ENGLISH() );
					fromOrdCust.setCONTACT_PHONE  ( fromMsgFCust.getCONTACT_PHONE  () );
					fromOrdCust.setCOUNTRY_CODE   ( fromMsgFCust.getCOUNTRY_CODE   () );
					fromOrdCust.setREGION_ID      ( fromMsgFCust.getREGION_ID      () );
					fromOrdCust.setEFFECTIVE      ( fromMsgFCust.getEFFECTIVE      () );
					fromOrdCust.setEXPIRE         ( fromMsgFCust.getEXPIRE         () );
					for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFCust.getNATURE().iterator(); itera.hasNext(); ){
						IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
						if( StringUtils.isBlank( fromMsgFOfferX.getATTR_ID() ) ) continue;
						IOVOrderOfferX fromOfferX = ICustom._wrap( fromMsgFOfferX );
						fromOrdCust.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
					}
				}
			}
			finally{
				
			}
			return fromOrdCust;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromMsgFGroup
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderGroup _wrap( IOVMsgFGroup fromMsgFGroup ) throws SFException,Exception{
			IOVOrderGroup fromOrdGroup = null;
			try
			{
				if( fromMsgFGroup != null ){
					fromOrdGroup = new IOVOrderGroup();
					fromOrdGroup.setGROUP_ID    ( fromMsgFGroup.getGROUP_ID    () );
					fromOrdGroup.setGROUP_TYPE  ( fromMsgFGroup.getGROUP_TYPE  () );
					fromOrdGroup.setGROUP_AMOUNT( fromMsgFGroup.getGROUP_AMOUNT() );
					fromOrdGroup.setGROUP_BY    ( fromMsgFGroup.getGROUP_BY    () );
				}
			}
			finally{
				
			}
			return fromOrdGroup;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromMsgFOffer
		 * @param fromComptel
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderOffer _wrap(IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMsgFUser,
				IOVMsgFOffer fromMsgFOffer,
				IProfessionalTemplate.IProductComptel fromComptel,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderOffer fromOffer  = null;
			try
			{	
				fromOffer = new IOVOrderOffer();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromOffer.setOFFER_ID     ( fromMsgFOffer.getINS_PROD_ID () );
				fromOffer.setCOMPETE      ( fromMsgFOffer.getCOMPETE_ID  () );  
				fromOffer.setCOMPTEL      ( fromMsgFOffer.getSERVICE_ID  () );
				fromOffer.setPRODUCT      ( fromMsgFOffer.getPRODUCT_ID  () );  
				fromOffer.setCATALOG      ( fromMsgFOffer.getPROD_TYPE   () );
				fromOffer.setCOMPOSITE    ( IUpdcConst.IUpdcp.SERVICE       );
				if( fromComptel != null ){
					fromOffer.setCOMPOSITE  ( fromComptel.getCATEGORY    () );
				}
				fromOffer.setSTATUS       ( fromMsgFOffer.getSTATUS      () );  
				fromOffer.setEFFECTIVE	  ( fromMsgFOffer.getEFFECTIVE   () );  
				fromOffer.setEXPIRE   	  ( fromMsgFOffer.getEXPIRE      () );  
				fromOffer.setSTATUS( ICustomX._os_status( fromRequest, fromMsgFOffer, fromUpdcpm) );
				if( fromMsgFOffer.getCENTREX() != null ){
					ICustomX._jj_centrex( fromRequest, fromMsgFOffer.getCENTREX(), fromOffer );
				}
				if( fromMsgFOffer instanceof IOVMsgFUserOffer ){
					if( StringUtils.equals( fromOffer.getSTATUS(), IUpdcConst.IState.T ) == false ){
						if(StringUtils.contains( fromOffer.getSTATUS(), new String[]{
								IUpdcConst.IState.X, IUpdcConst.IState.U} ) )
						{
							if( TimeUtils.greaterEqual( fromMBean.getCREATE(), fromOffer.getEXPIRE() ) ){
								fromOffer.setSTATUS( IUpdcConst.IState.E );
							}
						}
					}
				}
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFOffer.getFUTURE().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
					IOVOrderOfferX fromOfferX = ICustom._wrap(fromRequest, 
							fromMsgFUser, 
							fromMsgFOffer, 
							fromMsgFOfferX, 
							fromUpdcpm);
					fromOffer.getFEATURE().add( fromOfferX );
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 
		 * @param fromMsgFOffX
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderOfferX _wrap( IOVMsgFOfferX fromMsgFOffX ) throws SFException,Exception{
			IOVOrderOfferX fromOfferX = null;
			try
			{
				fromOfferX = new IOVOrderOfferX();
				fromOfferX.setOFFER_ID      ( fromMsgFOffX.getINS_ATTR_ID   () );
				fromOfferX.setCOMPETE       ( fromMsgFOffX.getATTR_ID       () );
				fromOfferX.setATTR_VALUE    ( fromMsgFOffX.getATTR_VALUE    () );
				fromOfferX.setPRE_ATTR_VALUE( fromMsgFOffX.getPRE_ATTR_VALUE() );
				fromOfferX.setSTATUS        ( fromMsgFOffX.getSTATUS        () );
				fromOfferX.setEFFECTIVE     ( fromMsgFOffX.getEFFECTIVE     () );
				fromOfferX.setEXPIRE        ( fromMsgFOffX.getEXPIRE        () );
			}
			finally{
				
			}
			return fromOfferX;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromMsgFOffer
		 * @param fromMsgFOfferX
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderOfferX _wrap(IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMsgFUser,
				IOVMsgFOffer fromMsgFOffer,
				IOVMsgFOfferX fromMsgFOfferX,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderOfferX fromOfferX = null;
			try
			{
				fromOfferX = ICustom._wrap( fromMsgFOfferX );
				fromOfferX.setSTATUS( ICustomX._os_status(fromRequest, 
						fromMsgFOffer, 
						fromMsgFOfferX, 
						fromUpdcpm) );
			}
			finally{
				
			}
			return fromOfferX;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromPentium
		 * @param fromUpdcpm
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderUser _wrap( IOVMsgFRequest fromRequest, 
				IOVMsgFUser fromMsgFUser,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderUser fromOrdUser = null;
			try
			{
				IOVOrderRequest __request__ = new IOVOrderRequest();
				ICustom._wrap(fromRequest, __request__, fromUpdcpm);
				fromOrdUser = ICustom._wrap( fromRequest, fromMsgFUser, fromUpdcpm );
				__request__.setUSER                 ( fromOrdUser              );
				fromUpffmx.getPLATFORM().setPLATFORM( __request__, fromUpdcpm  );
			}
			finally{
				
			}
			return fromOrdUser;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromUpffmx
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderRequest _wrap( IOVRocketExigence fromOrder,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderRequest fromRequest = null;
			try
			{
				fromRequest = ICustom._wrap(fromOrder, fromUpdcpm);
				fromUpffmx.getPLATFORM().setPLATFORM( fromRequest, fromUpdcpm  );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderRequest _wrap( IOVRocketExigence fromOrder, 
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderRequest fromRequest = null;
			try
			{
				IOVOrderUser fromOrdUser = null;
				fromRequest = new IOVOrderRequest();
				ICustom._wrap(fromOrder, fromRequest, fromUpdcpm);
				ICustom._wrap(fromOrder, fromOrdUser = new IOVOrderUser(), fromUpdcpm);
				fromRequest.setUSER( fromOrdUser              );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 用户资料变化(包含用户状态以及换卡换号等)
		 * @param fromRequest 开通定单
		 * @param fromMsgFUser 开通用户
		 * @param fromUpffmx 开通工单
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderUser _nature( IOVMsgFRequest fromRequest, 
				IOVMsgFUser fromMsgFUser,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderUser fromOrdUser = null;
			try
			{
				IOVOrderRequest __request__ = new IOVOrderRequest();
				ICustom._wrap(fromRequest, __request__, fromUpdcpm);
				fromOrdUser = ICustom._wrap( fromRequest, fromMsgFUser, fromUpdcpm );
				if( ExpireUtils.IIfElse.isEXPIRE( fromMsgFUser ) /*用户存在到期资费*/){
					IOVOrderOfferX fromOfferX = UpdbfsUtils.ICustom.ICustomX._jj_expire( IUpdbfsConst.IState.C );
					fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
					fromUpffmx.getEXPIRE().submitSFUpffxUser( __request__, fromOrdUser, fromUpdcpm );
				}
				__request__.setUSER                 ( fromOrdUser              );
				fromUpffmx.getPLATFORM().setPLATFORM( __request__, fromUpdcpm  );
			}
			finally{
				
			}
			return fromOrdUser;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromOrderHome
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderRequest _wrap( IOVMsgFRequest fromRequest, 
				IOVMsgFUser fromMsgFUser,
				IOVOrderRequest fromOrderHome,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			try
			{
				ICustom._wrap(fromRequest, fromOrderHome, fromUpdcpm);
				IOVOrderUser aOrdUser = ICustom._wrap( fromRequest, 
						fromMsgFUser, 
						fromUpdcpm );
				fromOrderHome.setUSER( aOrdUser   );
			}
			finally{
				
			}
			return fromOrderHome;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromRequest
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderRequest _wrap( IOVMsgFRequest fromRocket, 
				IOVOrderRequest fromRequest,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			try
			{
				fromRequest.setROCKET_ID      ( fromRocket.getROCKET_ID      () );
				fromRequest.setCUST_ORDER     ( fromRocket.getCUST_ORDER     () );
				fromRequest.setCATALOG        ( fromRocket.getCATALOG        () );
				fromRequest.setBUSINESS       ( fromRocket.getBUSINESS       () );
				fromRequest.setORIGINATOR     ( fromRocket.getORIGINATOR     () );
				fromRequest.setCHANNEL        ( fromRocket.getCHANNEL        () );
				fromRequest.setUSER_ID        ( fromRocket.getUSER_ID        () );
				fromRequest.setBILL_ID        ( fromRocket.getBILL_ID        () );
				fromRequest.setORDER_REGION_ID( fromRocket.getORDER_REGION_ID() );
				fromRequest.setREGION_ID      ( fromRocket.getREGION_ID      () );
				fromRequest.setPRIORITY       ( fromRocket.getPRIORITY       () );
				fromRequest.setCOMPOSITE      ( fromRocket.getCOMPOSITE      () );
				fromRequest.setDONE_CODE      ( fromRocket.getDONE_CODE      () );
				fromRequest.setDONE_DATE      ( fromRocket.getDONE_DATE      () );
				fromRequest.setORDER_DATE     ( fromRocket.getDONE_DATE      () );
				fromRequest.setORG_ID         ( fromRocket.getORG_ID         () );
				fromRequest.setSTAFF_ID       ( fromRocket.getSTAFF_ID       () );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromRequest
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderRequest _wrap( IOVRocketExigence fromOrder, 
				IOVOrderRequest fromRequest,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			try
			{
				fromRequest.setROCKET_ID      ( fromOrder.getROCKET_ID      () );
				fromRequest.setCUST_ORDER     ( fromOrder.getCUST_ORDER     () );
				fromRequest.setCATALOG        ( fromOrder.getCATALOG        () );
				fromRequest.setBUSINESS       ( fromOrder.getBUSINESS       () );
				fromRequest.setORIGINATOR     ( fromOrder.getORIGINATOR     () );
				fromRequest.setCHANNEL        ( fromOrder.getCHANNEL        () );
				fromRequest.setUSER_ID        ( fromOrder.getUSER_ID        () );
				fromRequest.setBILL_ID        ( fromOrder.getBILL_ID        () );
				fromRequest.setORDER_REGION_ID( fromOrder.getORDER_REGION_ID() );
				fromRequest.setREGION_ID      ( fromOrder.getREGION_ID      () );
				fromRequest.setPRIORITY       ( fromOrder.getPRIORITY       () );
				fromRequest.setCOMPOSITE      ( fromOrder.getCOMPOSITE      () );
				fromRequest.setDONE_CODE      ( fromOrder.getORDER_ITEM_ID  () );
				fromRequest.setDONE_DATE      ( fromOrder.getDONE_DATE      () );
				fromRequest.setORDER_DATE     ( fromOrder.getDONE_DATE      () );
				fromRequest.setORG_ID         ( fromOrder.getORG_ID         () );
				fromRequest.setSTAFF_ID       ( fromOrder.getSTAFF_ID       () );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromPentium
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderUser _wrap( IOVMsgFRequest fromRequest, 
				IOVMsgFUser fromMsgFUser,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderUser fromOrdUser = null;
			java.util.Map<String,String> fromNature = null;
			try
			{
				fromOrdUser = new IOVOrderUser();
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				ICustom._wrap( fromRequest, fromMsgFUser, fromOrdUser, fromUpdcpm );
				fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
				if( StringUtils.isBlank( fromBusines.getCOMPLEX() ) == false ){
					fromNature = JdomUtils.ICustom.wrap( fromBusines.getCOMPLEX(), "" );
					for( java.util.Iterator<java.util.Map.Entry<String, String>> itera = fromNature.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry<String, String> fromEntry = (java.util.Map.Entry<String, String>)itera.next();
						IOVOrderOfferX fromOfferX = new IOVOrderOfferX( (String)fromEntry.getKey(), (String)fromEntry.getValue() );
						fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
					}
				}
			}
			finally{
				if( fromNature != null ){ fromNature.clear(); fromNature = null; }
			}
			return fromOrdUser;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromOrdUser
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderUser _wrap( IOVRocketExigence fromRequest,
				IOVOrderUser fromOrdUser,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			java.util.Map<String,String> fromNature = null;
			try
			{
				ISystemTemplate.IUpfgkmParallel fromParallel = null;
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				if( fromOrdUser == null ) fromOrdUser = new IOVOrderUser();
				fromOrdUser.setUSER_ID       ( fromRequest.getUSER_ID                () );
				fromOrdUser.setCATALOG_ID    ( fromRequest.getCATALOG                () );
				fromOrdUser.setBILL_ID       ( fromRequest.getBILL_ID                () );
				fromOrdUser.setREGION_ID     ( fromRequest.getREGION_ID              () );
				fromOrdUser.setSTATE         ( IUpdbfsConst.IUpdbm.IUser.IOsState.NORMAL);
				fromOrdUser.setOS_STATE      ( IUpdbfsConst.IUpdbm.IUser.IOsState.NORMAL);
				fromOrdUser.setUSER_REGION_ID( fromRequest.getORDER_REGION_ID        () );
				fromOrdUser.setCOUNTRY_CODE  ( fromRequest.getORDER_REGION_ID        () );
				fromOrdUser.setEFFECTIVE     ( TimeUtils.getEffective                () );
				fromOrdUser.setEXPIRE        ( TimeUtils.getMaxExpire                () );
				fromOrdUser.setROLE_ID		 ( IUpdbfsConst.IUpdbm.IRole.NORMAL         );
				if( fromRequest.getDONE_DATE() != null ){
					IOVOrderOfferX _nature = new IOVOrderOfferX( IUpdbfsConst.IUpdbm.IUser.OPRTIME, 
							TimeUtils.yyyymmddhhmmss( fromRequest.getDONE_DATE() ) );
					fromOrdUser.getNATURE().put( _nature.getCOMPETE(), _nature );
				}
				IOVOrderOfferX  _parallel = new IOVOrderOfferX( IUpdcConst.ISystem.PARALLEL, 
						IUpdcConst.IEnum.IYesNo.No );
				fromParallel = SystemUtils.ISystem.getSFUpfgkmParallel(fromRequest.getORIGINATOR(), 
						fromRequest.getORDER_REGION_ID() );
				if( fromParallel != null && StringUtils.isEmpty( fromParallel.getPARALLEL() ) == false ){
					_parallel.setATTR_VALUE( fromParallel.getPARALLEL() );
				}
				fromOrdUser.getNATURE().put( _parallel.getCOMPETE(), _parallel );
				fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
				if( StringUtils.isBlank( fromBusines.getCOMPLEX() ) == false ){
					fromNature = JdomUtils.ICustom.wrap( fromBusines.getCOMPLEX(), "" );
					for( java.util.Iterator<java.util.Map.Entry<String,String>> itera = fromNature.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry<String,String> fromEntry = (java.util.Map.Entry<String,String>)itera.next();
						IOVOrderOfferX fromOfferX = new IOVOrderOfferX( (String)fromEntry.getKey(), (String)fromEntry.getValue() );
						fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
					}
				}
			}
			finally{
				if( fromNature != null ){ fromNature.clear(); fromNature = null; }
			}
			return fromOrdUser;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderUser _subject( IOVMsgFRequest fromRequest, 
				IOVMsgFUser fromMsgFUser,
				IUpfgkmOfferHome fromUpdcpm) throws SFException,Exception{
			IOVOrderUser fromOrdUser = null;
			try
			{
				fromOrdUser = ICustom._wrap(fromRequest, fromMsgFUser, fromUpdcpm);
				IOVMsgFOfferX fromOfferX = fromMsgFUser.getNATURE( IUpdbfsConst.IUpdbm.IUser.NEWMSDN );
				if( fromOfferX != null && StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
					fromOrdUser.setBILL_ID( fromOfferX.getATTR_VALUE() );
				}
				fromOfferX = fromMsgFUser.getNATURE( IUpdbfsConst.IUpdbm.IUser.NEWIMSI );
				if( fromOfferX != null && StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
					fromOrdUser.setSUB_BILL_ID( fromOfferX.getATTR_VALUE() );
				}
			}
			finally{
				
			}
			return fromOrdUser;
		}
		
		/**
		 * 
		 * @param fromPentium
		 * @param fromOffer
		 * @param fromGroup
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.List<IProfessionalTemplate.IProductCatalog> getCOMBINE( IOVMsgFRequest fromPentium,
				IOVMsgFOffer fromOffer,
				IProfessionalTemplate.IProductGroup fromGroup ) throws SFException,Exception{
			java.util.List<IProfessionalTemplate.IProductCatalog> fromCOMBINE = null;
			try
			{
				String aCOMPETE = String.valueOf( fromOffer.getPRODUCT_ID() );
				fromCOMBINE = fromGroup.getCOMBINE( aCOMPETE );
				if( fromCOMBINE == null ){
					aCOMPETE = String.valueOf( fromOffer.getSERVICE_ID() );
					fromCOMBINE = fromGroup.getCOMBINE( aCOMPETE );
				}
			}
			finally{
				
			}
			return fromCOMBINE;
		}
		public static class ICustomX{
			public ICustomX() {
				super();
			}
			
			/**
			 * 属性状态转换
			 * @param fromRequest
			 * @param fromOffer
			 * @param fromOfferX
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static String _os_status( IOVMsgFRequest fromRequest, 
					IOVMsgFOffer fromOffer,
					IOVMsgFOfferX fromOfferX, 
					IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception{
				String o_state = "";
				try
				{
					String state = fromOfferX.getSTATUS();
					if(StringUtils.equals( IUpdbfsConst.IState.IOrder.S01, state)){
						o_state = IUpdbfsConst.IState.C;
					}
					else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S02, state) ){
						o_state = IUpdbfsConst.IState.X;
					}
					else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S03, state) ){
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							o_state = IUpdbfsConst.IState.E;
						}
						else {
							o_state = IUpdbfsConst.IState.T;
						}
					}
					else if(StringUtils.equals( IUpdbfsConst.IState.IOrder.S04, state) ){
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							o_state = IUpdbfsConst.IState.U;
						}
						else{
							o_state = IUpdbfsConst.IState.C;// 实例恢复
						}
					}
					else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S05, state ) ){
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							o_state = IUpdbfsConst.IState.U;
						}
						else{
							o_state = IUpdbfsConst.IState.D;
						}
					}
				}
				finally{
					
				}
				
				return o_state;
			}
			
			/**
			 * 服务状态转换
			 * 用户订购 1=C;3=T;4=C
			 * 订单订购 1=C;2=X;3=E;4=U
			 * @param fromRequest
			 * @param fromOffer
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static String _os_status(IOVMsgFRequest fromRequest, 
					IOVMsgFOffer fromOffer, 
					IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception{
				String o_state = "";
				try
				{
					String state = fromOffer.getSTATUS();
					MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
					if(StringUtils.equals( IUpdbfsConst.IState.IOrder.S01, state)){
						o_state = IUpdbfsConst.IState.C;
					}
					else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S02, state) ){
						o_state = IUpdbfsConst.IState.X;
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							if( TimeUtils.greater( fromMBean.getCREATOR(), fromOffer.getEXPIRE() ) )/*修复OCRM营业BUG*/{
								o_state = IUpdbfsConst.IState.E;
							}
							else if( TimeUtils.greater( fromOffer.getEXPIRE(), fromMBean.getCREATOR() ) /*失效时间为月底*/){
								java.sql.Timestamp __monthend__ = TimeUtils.getActualMaxtime( fromMBean.getCREATOR() );
								java.sql.Timestamp __monthstart__ = TimeUtils.getNextMonthStartDate( fromMBean.getCREATOR() );
								if( TimeUtils.equalYYYYMMDD( fromOffer.getEXPIRE(), __monthend__ ) || 
										TimeUtils.equalYYYYMMDD( fromOffer.getEXPIRE(), __monthstart__ ) ){
									o_state = IUpdbfsConst.IState.E;
								}
							}
						}
					}
					else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S03, state) ){
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							o_state = IUpdbfsConst.IState.E;
						}
						else {
							o_state = IUpdbfsConst.IState.T;
						}
					}
					else if(StringUtils.equals( IUpdbfsConst.IState.IOrder.S04, state) ){
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							o_state = IUpdbfsConst.IState.U;
						}
						else{
							o_state = IUpdbfsConst.IState.C;// 假实例恢复
						}
					}
					else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S05, state ) ){
						
						if( fromOffer instanceof IOVMsgFOrdOffer ){
							o_state = IUpdbfsConst.IState.T;
						}
						else{
							o_state = IUpdbfsConst.IState.D;
						}
					}else if( StringUtils.equals( IUpdbfsConst.IState.IOrder.S06, state )){
						o_state=IUpdbfsConst.IState.F;
					}
				}
				finally{
					
				}
				
				return o_state;
			}
			
			/**
			 * 
			 * @param fromRequest
			 * @param fromMsgFUser
			 * @param fromOrdUser
			 * @param fromUpdcpm
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _jj_global(IOVMsgFRequest fromRequest,
					IOVMsgFUser fromMsgFUser, 
					IOVOrderUser fromOrdUser,
					IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception{
				IUpdcContext aContext = ClassUtils.getIContextImpl();
				try
				{
					ISystemTemplate.IUpfgkmParallel fromParallel = null;
					IProfessionalTemplate.IBusinesKernel fromUpdfmsx = null;
					//操作时间
					IOVOrderOfferX fromOfferX = new IOVOrderOfferX( IUpdbfsConst.IUpdbm.IUser.OPRTIME, fromRequest.getDONE_DATE() );
					fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
					//并行割接
					fromOfferX = new IOVOrderOfferX( IUpdcConst.ISystem.PARALLEL, IUpdcConst.IEnum.IYesNo.No );
					fromParallel = SystemUtils.ISystem.getSFUpfgkmParallel(fromRequest.getORIGINATOR(), fromRequest.getORDER_REGION_ID() );
					if( fromParallel != null && StringUtils.isEmpty( fromParallel.getPARALLEL() ) == false ){
						fromOfferX.setATTR_VALUE( fromParallel.getPARALLEL() );
					}
					fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
					//开通自定义组件
					fromUpdfmsx = fromUpdcpm.getCATALOG().getPROGRAM( IUpdbfsConst.IUpdbm.ICache.PROGRAM_CUSTOM );
					if( fromUpdfmsx != null ){
						ISystemTemplate.IImplCapital fromCapital = SystemUtils.ISystem.getSFUpfgkmCapital( fromUpdfmsx.getIMPLCLASS() );
						IBusinesCapital fromUpdcpmImpl = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
								fromCapital.getMETHOD(), 
								new Object[]{fromRequest,
										     fromOrdUser,
							                 fromUpdcpm,
							                 aContext},
								new Class[]{IOVMsgFRequest.class,
										    IOVOrderUser.class,
							                IUpfgkmOfferHome.class, 
							                IUpdcContext.class});
					}
				}
				finally{
					if( aContext != null ){ aContext.clear(); aContext = null; }
				}
			}
			
			/**
			 * 
			 * @param fromRequest
			 * @param fromMsgFPlot
			 * @param fromOrdOffer
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVOrderOffer _jj_centrex(IOVMsgFRequest fromRequest,
					IOVMsgFPlan fromMsgFPlot,
					IOVOrderOffer fromOrdOffer) throws SFException,Exception{
				IBeanWrapper fromCustom = new IBeanWrapper( fromMsgFPlot );
				try
				{
					java.beans.PropertyDescriptor aDescriptor[] = fromCustom.getPropertyDescriptors();
					for( int index = 0; aDescriptor != null && index < aDescriptor.length; index++ ){
						if( aDescriptor[index].getReadMethod() != null && 
								ClassUtils.IClass.isPrimitive( aDescriptor[index].getPropertyType() ) ){
							String _descriptor = ClassUtils.getINDEX(new String[]{"CPMPLT_", StringUtils.replace( 
									aDescriptor[index].getName(), "_", "" ) } );
							Object _objective = fromCustom.getPropertyValue( aDescriptor[index].getName() );
							if( fromOrdOffer.getFEATURE( _descriptor ) == null && _objective != null ){
								fromOrdOffer.getFEATURE().add( new IOVOrderOfferX( _descriptor, _objective.toString() ) );
							}
						}
					}
				}
				finally{
					if( fromCustom != null ){ fromCustom = null; }
				}
				return fromOrdOffer;
			}
			
			/**
			 * 
			 * @param fromSTATUS
			 * @return
			 */
			public static IOVOrderOfferX _jj_expire( String fromSTATUS ){
				IOVOrderOfferX fromOfferX = null;
				try
				{
					fromOfferX = new IOVOrderOfferX();
					fromOfferX.setCOMPETE   ( IUpdbfsConst.IUpdbm.IUser.EXPIREUSER );
					fromOfferX.setATTR_VALUE( fromSTATUS                           );
					fromOfferX.setSTATUS    ( IUpdbfsConst.IState.C                );
				}
				finally{
					
				}
				return fromOfferX;
			}
			
		}
	}
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 是否开通产品订购来源于订单模型
		 * @param fromMsgF 开通定单
		 * @param fromUpdcpm 开通能力规范
		 * @return
		 */
		public static boolean isORDER(IOVMsgFRequest fromMsgF, 
				IUpfgkmOfferHome fromUpdcpm){
			boolean fromEnable = true;
			try
			{
				IProfessionalTemplate.IBusinesKernel fromBusinesX = null;
				fromBusinesX = fromUpdcpm.getCATALOG().getPROGRAM( IUpdbfsConst.IUpdbm.ICache.PROGRAM_PRODUCTION );
				fromEnable = fromBusinesX == null || StringUtils.equals( fromBusinesX.getCOMPLEX(), 
						IUpdbfsConst.IUpdbm.IUser.ORDER )?true:false;
			}
			finally{
				
			}
			return fromEnable;
		}
		
		/**
		 * 是否开通产品订购来源于订单模型
		 * @param fromMsgF 开通定单
		 * @param fromUpdcpm 开通能力规范
		 * @return
		 */
		public static boolean isUSER(IOVMsgFRequest fromMsgF, 
				IUpfgkmOfferHome fromUpdcpm){
			boolean fromEnable = true;
			try
			{
				IProfessionalTemplate.IBusinesKernel fromBusinesX = null;
				fromBusinesX = fromUpdcpm.getCATALOG().getPROGRAM( IUpdbfsConst.IUpdbm.ICache.PROGRAM_PRODUCTION );
				fromEnable = fromBusinesX != null && StringUtils.equals( fromBusinesX.getCOMPLEX(), 
						IUpdbfsConst.IUpdbm.IUser.INSTANCE )?true:false;
			}
			finally{
				
			}
			return fromEnable;
		}
		
		/**
		 * 判断是否同组服务产品
		 * @param fromPentium 开通定单
		 * @param fromOffer 开通服务产品
		 * @param fromCatalog 开通同组规范
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isGROUP( IOVMsgFRequest fromPentium,
				IOVMsgFOffer fromOffer, 
				IProfessionalTemplate.IProductCatalog fromCatalog) throws SFException, Exception{
			boolean fromGroup = false;
			try
			{
				if( fromCatalog != null ){
					String aCOMPETE_ID = String.valueOf( fromOffer.getPRODUCT_ID() );
					fromGroup = StringUtils.equals( fromCatalog.getCOMPETE_ID(), aCOMPETE_ID );
					if( fromGroup == false ){
						aCOMPETE_ID = String.valueOf( fromOffer.getSERVICE_ID() );
						fromGroup = StringUtils.equals( fromCatalog.getCOMPETE_ID(), aCOMPETE_ID );
					}
				}
			}
			finally{
				
			}
			return fromGroup;
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 根据产品编号将当前开通订购状态合并到开通工单订购模型中
		 * @param fromPentium 开通工单
		 * @param fromOrdUser 开通用户
		 * @param fromOrdOffer 开通订购
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean _groupAsCompete(IOVOrderRequest fromPentium,
				IOVOrderUser fromOrdUser, 
				IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
			boolean fromBool = true;
			java.util.List<IOVOrderOffer> fromOrdUsed = new java.util.ArrayList<IOVOrderOffer>();
			try
			{
				for( java.util.Iterator<IOVOrderOffer> itera = fromOrdUser.getPRODUCTION().iterator(); itera.hasNext(); ){
					IOVOrderOffer fromOfferUsed = (IOVOrderOffer)itera.next();
					if( fromOfferUsed.isCAPITY() && fromOfferUsed.getCOMPETE() == fromOrdOffer.getCOMPETE() ){
						fromOrdUsed.add( fromOfferUsed );
					}
				}
				fromBool = IISystem._jj_mergeoffer(fromOrdUser, 
						fromOrdUsed != null && fromOrdUsed.size() > 0?
								(IOVOrderOffer)fromOrdUsed.get( fromOrdUsed.size() - 1 ):null, 
						fromOrdOffer);
			}
			finally{
				if( fromOrdUsed != null ){ fromOrdUsed.clear(); fromOrdUsed = null; }
			}
			return fromBool;
		}
		
		/**
		 * 根据产品编号将当前开通订购状态合并到开通工单订购模型中
		 * @param fromPentium 开通工单
		 * @param fromOrdUser 开通用户
		 * @param fromOrdOffer 开通订购
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean _groupAsProduct(IOVOrderRequest fromPentium,
				IOVOrderUser fromOrdUser, 
				IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
			boolean fromBool = true;
			java.util.List<IOVOrderOffer> fromOrdUsed = new java.util.ArrayList<IOVOrderOffer>();
			try
			{
				for( java.util.Iterator<IOVOrderOffer> itera = fromOrdUser.getPRODUCTION().iterator(); itera.hasNext(); ){
					IOVOrderOffer fromOfferUsed = (IOVOrderOffer)itera.next();
					if( fromOfferUsed.isPRICE() && fromOfferUsed.getPRODUCT() == fromOrdOffer.getPRODUCT() ){
						fromOrdUsed.add( fromOfferUsed );
					}
				}
				fromBool = IISystem._jj_mergeoffer(fromOrdUser, 
						fromOrdUsed != null && fromOrdUsed.size() > 0?
								(IOVOrderOffer)fromOrdUsed.get( fromOrdUsed.size() - 1 ):null, 
						fromOrdOffer);
			}
			finally{
				if( fromOrdUsed != null ){ fromOrdUsed.clear(); fromOrdUsed = null; }
			}
			return fromBool;
		}
		
		/**
		 * 
		 * @param fromPentium
		 * @param fromOrdUser
		 * @param fromOrdOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean _groupAsMultle(IOVOrderRequest fromPentium,
				IOVOrderUser fromOrdUser, 
				IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
			boolean fromBool = true;
			try
			{
				fromOrdUser.getPRODUCTION().add( fromOrdOffer );
			}
			finally{
				
			}
			return fromBool;
		}
		
		/**
		 * 根据开通定单完成网元侧服务产品依赖组装载
		 * @param fromUpdcpm
		 * @param fromDepend
		 * @return
		 */
		public static IOVUpffmxDepend _jj_dependent(IUpfgkmOfferHome fromUpdcpm, IOVUpffmxDepend fromDepend ){
			try
			{
				IProfessionalTemplate.IBusinesKernel fromKernel = null;
				IProfessionalTemplate.IBusinesCombine fromBusinesX = null;
				IProfessionalTemplate.IProductGroup fromCombine = null;
				if( fromUpdcpm.getCATALOG().getPROGRAM() != null ){
					fromBusinesX = fromUpdcpm.getCATALOG().getPROGRAM();
					for( java.util.Iterator<IProfessionalTemplate.IBusinesKernel> itera = fromBusinesX.getPROGRAM().values().iterator(); itera.hasNext(); ){
						fromKernel = (IProfessionalTemplate.IBusinesKernel)itera.next();
						if( StringUtils.startWith( fromKernel.getID(), IUpdbfsConst.IUpdbm.ICache.PROGRAM_DEPEND ) ){
							fromCombine = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpGroup( fromKernel.getCOMPLEX() );
							if( fromCombine != null ){ 
								fromDepend.addGROUP( fromKernel, fromCombine ); 
							}
						}
					}
				}
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromDepend;
		}
		
		/**
		 * 
		 * <p>Title: sacenter-receive</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2017年10月17日</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author huiyu
		 * @version 3.0
		 */
		public static class IISystem{
			public IISystem(){
				super();
			}
			
			/**
			 * 
			 * @param fromOrdUser
			 * @param fromOrdUsed
			 * @param fromOrdOffer
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static boolean _jj_mergeoffer( IOVOrderUser fromOrdUser, 
					IOVOrderOffer fromOrdUsed,
					IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
				boolean fromBool = true;
				try
				{
					if( fromOrdUsed == null /*原不存在则增加*/){
						fromOrdUser.getPRODUCTION().add( fromOrdOffer );
					}
					else if( fromOrdUsed.isDEPEND() )/*依赖合并*/{
						String __status = IISystem._jj_mergestatus( fromOrdUsed, fromOrdOffer );
						fromOrdUsed.setSTATUS   ( __status                  );
						IISystem._jj_mergefuture( fromOrdOffer, fromOrdUsed );
						fromOrdUser.getPRODUCTION().remove( fromOrdUsed     );
						fromOrdUser.getPRODUCTION().add   ( fromOrdUsed     );
					}
					else/*不为依赖合并*/{
						String __status = IISystem._jj_mergestatus( fromOrdUsed, fromOrdOffer );
						if( StringUtils.equals( __status, IUpdbfsConst.IState.CE ) /*先订后退则无此功能*/ ){
							fromOrdUsed.setSTATUS   ( __status                  );
							IISystem._jj_mergefuture( fromOrdOffer, fromOrdUsed );
							fromOrdUser.getPRODUCTION().remove( fromOrdUsed     );
							fromOrdUser.getPRODUCTION().add   ( fromOrdUsed     );
						}
						else if( StringUtils.equals( __status, IUpdbfsConst.IState.EC ) /*先退后订则开通此功能*/){
							fromOrdOffer.setSTATUS  (  __status                 );
							IISystem._jj_mergefuture( fromOrdUsed, fromOrdOffer );
							fromOrdUser.getPRODUCTION().remove( fromOrdUsed     );
							fromOrdUser.getPRODUCTION().add   ( fromOrdOffer    );
						}
						else{
							fromOrdOffer.setSTATUS  (  __status                 );
							IISystem._jj_mergefuture( fromOrdUsed, fromOrdOffer );
							fromOrdUser.getPRODUCTION().remove( fromOrdUsed     );
							fromOrdUser.getPRODUCTION().add( fromOrdOffer       );
						}
					}
				}
				finally{
					
				}
				return fromBool;
			}
			
			/**
			 * 
			 * @param fromOrdUsed
			 * @param fromOrdOffer
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _jj_mergefuture( IOVOrderOffer fromOrdUsed,
					IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
				try
				{
					for( java.util.Iterator<IOVOrderOfferX> itera = fromOrdUsed.getFEATURE().iterator(); itera.hasNext(); ){
						IOVOrderOfferX fromUsedX = (IOVOrderOfferX)itera.next();
						IOVOrderOfferX fromOfferX = fromOrdOffer.getFEATURE( fromUsedX.getCOMPETE() );
						if( fromOfferX == null ){ 
							fromOrdOffer.getFEATURE().add( fromUsedX ); 
						}
						else if( StringUtils.equals( fromOfferX.getATTR_VALUE(), fromUsedX.getATTR_VALUE() ) ){
							fromOfferX.setPRE_ATTR_VALUE( fromUsedX.getATTR_VALUE() );
							fromOfferX.setSTATUS( IUpdbfsConst.IState.U );
						}
						else{
							fromOfferX.setPRE_ATTR_VALUE( fromUsedX.getATTR_VALUE() );
							fromOfferX.setSTATUS( IUpdbfsConst.IState.X );
						}
					}
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param fromOrdUsed
			 * @param fromOrdOffer
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static String _jj_mergestatus(IOVOrderOffer fromOrdUsed, IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
				StringBuffer fromOsState = new StringBuffer();
				try
				{
					if( fromOrdUsed == null ){
						fromOsState.append( fromOrdOffer.getSTATUS() );
					}
					else if( fromOrdOffer.isDEPEND() ){
						fromOsState.append( fromOrdUsed.getSTATUS() );
						if( fromOrdUsed.isDEPEND() == false ){ fromOsState.insert( 0, fromOrdOffer.getSTATUS() ); }
					}
					else{
						if( StringUtils.equals( fromOrdUsed.getSTATUS(), fromOrdOffer.getSTATUS() ) ){
							fromOsState.append( fromOrdOffer.getSTATUS() );
						}
						else if( StringUtils.endsWith( fromOrdUsed.getSTATUS(), fromOrdOffer.getSTATUS() ) ){
							fromOsState.append( fromOrdUsed.getSTATUS() );
						}
						else{
							fromOsState.append( fromOrdUsed.getSTATUS() ).append( fromOrdOffer.getSTATUS() );
						}
					}
				}
				finally{
					
				}
				return fromOsState.toString();
			}
		}
	}

}
	
