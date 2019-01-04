package com.ai.sacenter.receive.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOfferX;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.order.IOrderConst;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyOffer;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年10月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UrgencyUtils {

	public UrgencyUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromOsUser
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFRequest _wrap( IOVUser fromUser, 
				IOVUrgencyUser fromOsUser,
				IUpdcContext aContext ) throws SFException,Exception{
			IOVMsgFRequest fromRequest = null;
			try
			{
				fromRequest = new IOVMsgFRequest();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				ISystemTemplate.IUpdbfsLimite fromLimite = SystemUtils.ISystem.getSFUpffmxOffer();
				fromRequest.setROCKET_ID   ( fromOsUser.getORDER_ID                      () );
				fromRequest.setCUST_ORDER  ( fromOsUser.getCUST_ORDER                    () );
				fromRequest.setCATALOG     ( String.valueOf( fromUser.getCATALOG() )        );
				fromRequest.setBUSINESS    ( fromOsUser.getBUSINESS                      () );
				fromRequest.setBATCHES     ( IUpdbfsConst.IUpdbm.IBatches.YES               );
				fromRequest.setORIGINATOR  ( IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_URGENCY );
				fromRequest.setCHANNEL     ( IUpdbfsConst.IUpdbm.ICustom.CHANNEL            );
				fromRequest.setUSER_ID     ( fromOsUser.getUSER_ID                       () );                                                            
				fromRequest.setREGION_ID   ( fromOsUser.getREGION_ID                     () );      
				fromRequest.setPRIORITY    ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY           );
				fromRequest.setCOMPOSITE   ( IUpdcConst.IUpdbm.IUpdbf.NORMAL                );
				if( fromLimite != null ){
					fromRequest.setPRIORITY ( fromLimite.getPRIORITY                     () );
					fromRequest.setCOMPOSITE( fromLimite.getCOMPOSITE                    () );
				}
				fromRequest.setDONE_CODE   ( fromOsUser.getDONE_CODE                     () );
				fromRequest.setDONE_DATE   ( fromOsUser.getCREATE_DATE                   () );                                                            
				fromRequest.setORG_ID      ( String.valueOf( fromOsUser.getORG_ID        ()));                                                            
				fromRequest.setSTAFF_ID    ( String.valueOf( fromOsUser.getSTAFF_ID      ()));
				fromRequest.getORDER().setOBJECTIVE( fromOsUser );
				fromRequest.getORDER().setCREATOR( fromMBean.getCREATOR() );
				IOVMsgFUser fromOrdUser = ICustom._wrap(fromUser, fromOsUser);
				for( java.util.Iterator<IOVUrgencyOffer> itera = fromOsUser.getORDER().iterator(); itera.hasNext(); ){
					IOVUrgencyOffer fromOsOffer = (IOVUrgencyOffer)itera.next();
					if( fromOsOffer.isCREATE() == false ) continue;
					IOVMsgFOrdOffer fromOrdOffer = ICustom._wrap(fromUser, 
							fromOsUser, 
							fromOsOffer);
					fromOrdUser.mergeAsCentrex( fromOrdOffer );
				}
				fromRequest.getUSER().add  ( fromOrdUser );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromOsUser
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFUser _wrap( IOVUser fromUser, IOVUrgencyUser fromOsUser ) throws SFException,Exception{
			IOVMsgFUser fromOrdUser = null;
			java.util.Map<String,String> fromPARAM = new java.util.HashMap<String,String>();
			try
			{
				fromOrdUser = new IOVMsgFUser();
				CustomUtils.ICustom._wrap( fromUser, fromOrdUser            );
				fromOrdUser.setPARAM     ( fromOsUser.getPARAM           () );
				JdomUtils.ICustom.wrap   ( fromOsUser.getPARAM(), fromPARAM );
				String fromDELETE[] = ClassUtils.IClass.transfer( fromPARAM, fromPARAM );
				ClassUtils.IMerge.purge( fromPARAM, fromDELETE );
				for( java.util.Iterator<String> itera = fromPARAM.keySet().iterator(); itera.hasNext(); ){
					String _compete_id_ = (String)itera.next();
					IOVMsgFOfferX _msgfofferx_ = new IOVMsgFOfferX( _compete_id_, 
							(String)fromPARAM.get( _compete_id_ ) );
					if( _msgfofferx_.getATTR_VALUE() == null ){ continue; }
					fromOrdUser.getNATURE().add( _msgfofferx_ );
				}
			}
			finally{
				if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;} 
			}
			return fromOrdUser;
		}
		
		/**
		 * 
		 * @param fromUser
		 * @param fromSosUser
		 * @param fromSosOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFOrdOffer _wrap(IOVUser fromUser, 
				IOVUrgencyUser fromOsUser,
				IOVUrgencyOffer fromOsOffer ) throws SFException,Exception{
			IOVMsgFOrdOffer fromOrdOffer = null;
			try
			{
				fromOrdOffer = new IOVMsgFOrdOffer();
				fromOrdOffer.setUSER_ID     ( fromOsUser.getUSER_ID        () );
				fromOrdOffer.setINS_PROD_ID ( fromOsOffer.getINS_PROD_ID   () );
				fromOrdOffer.setCOMPETE_ID  ( fromOsOffer.getCOMPETE_ID    () );
				fromOrdOffer.setSERVICE_ID  ( fromOsOffer.getSERVICE_ID    () );
				fromOrdOffer.setPRODUCT_ID  ( fromOsOffer.getPRODUCT_ID    () );
				fromOrdOffer.setPROD_TYPE   ( fromOsOffer.getPROD_TYPE     () );
				fromOrdOffer.setSTATUS      ( fromOsOffer.getSTATUS        () );
				fromOrdOffer.setEFFECTIVE   ( fromOsOffer.getCREATE_DATE   () );
				fromOrdOffer.setEXPIRE      ( TimeUtils.getMaxExpire       () );
				IOVUserOrder fromUserOrder = fromUser.getORDER( fromOsOffer.getINS_PROD_ID(), fromOrdOffer.getSERVICE_ID() );
				if( fromUserOrder != null ){
					fromOrdOffer.setPROD_TYPE   ( fromUserOrder.getPROD_TYPE   () );
					for( java.util.Iterator<IOVUserOfferX> itera = fromUserOrder.getFUTURE().iterator(); itera.hasNext(); ){
						IOVUserOfferX fromOfferX = (IOVUserOfferX)itera.next();
						IOVMsgFOfferX fromOrdOffX = new IOVMsgFOfferX();
						CustomUtils.ICustom._wrap(fromOfferX, fromOrdOffX);
						fromOrdOffer.getFUTURE().add( fromOrdOffX );
					}
				}
			}
			finally{
				
			}
			return fromOrdOffer;
		}
	}
	public static class IUpfwm{
		public IUpfwm(){
			super();
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromOrdUser
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _wrap( IOVMsgFRequest fromRequest,
				IOVMsgFUser fromOrdUser,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = new IOVUpfwmOffer();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				IUpfgkmOfferHome.IBusinesOfferHome fromBusines = fromUpdcpm.getCATALOG();
				fromUpfwm.setPS_ID      ( UpfwmFactory.getIUpfwmDAO().getPS_ID()      );
				fromUpfwm.setCUST_ORDER ( fromRequest.getCUST_ORDER             () );
				fromUpfwm.setDONE_CODE  ( fromRequest.getDONE_CODE              () );
				fromUpfwm.setORDER_ID   ( UpdcFactory.getIUpdcDAO().getORDER_ID () );
				fromUpfwm.setTASK_ID    ( fromUpfwm.getORDER_ID()                  );
				fromUpfwm.setUSER_ID    ( fromOrdUser.getUSER_ID                () );
				fromUpfwm.setCREATE_DATE( fromMBean.getCREATE()                    );
				fromUpfwm.setBILL_ID    ( fromOrdUser.getBILL_ID                () );
				fromUpfwm.setSUB_BILL_ID( fromOrdUser.getSUB_BILL_ID            () );
				fromUpfwm.setREGION_ID  ( fromOrdUser.getREGION_ID              () );
				IIUpfwm._wrap           ( fromBusines.getBUSINES(),      fromUpfwm );
				fromUpfwm.setPRIORITY   ( fromUpdcpm.getCATALOG().getBUSINES().getPRIORITY() );
				fromUpfwm.setPS_PARAM   ( fromOrdUser.getPARAM                  () );
				fromUpfwm.setPS_STATUS  ( IUpfwmConst.IUpdos.CREATE                );
				fromUpfwm.setSUB_PLAN_NO( fromMBean.getORDER_ID()                  );
				fromUpfwm.setORDER_DATE ( fromMBean.getCREATE                   () );
				fromUpfwm.setSTART_DATE ( fromMBean.getCREATE()                    );
			}
			finally{
				
			}
			return fromUpfwm;
		}
		public static class IIUpfwm{
			public IIUpfwm(){
				super();
			}
			
			/**
			 * 根据当前接入层配置获取逻辑网元配置信息
			 * @param fromBusines
			 * @param fromUpfwm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpfwmOffer _wrap( IProfessionalTemplate.IBusinesOffer fromBusines, 
					IOVUpfwmOffer fromUpfwm ) throws SFException,Exception{
				java.util.Map<String,String> fromNature = null;
				try
				{
					IPlatformTemplate.IUpffmOperate fromUpfom = null;
					IPlatformTemplate.IUpffmDirective fromUpdfwm = null;
					IPlatformTemplate.IUpffmOffer fromUpffm = null;
					fromNature = JdomUtils.ICustom.wrap( fromBusines.getCOMPLEX(), "" );
					String aPLATFORM = (String)fromNature.get( IOrderConst.IUpfwm.PLATFORM );
					String aDIRECTIVE = (String)fromNature.get( IOrderConst.IUpfwm.DIRECTIVE );
					if(  StringUtils.isBlank( aPLATFORM ) || StringUtils.isBlank( aDIRECTIVE ) ){
						ExceptionFactory.throwIllegal( "IOS0010007", new String[]{String.valueOf( fromBusines.getID() ),
								"PLATFORM/DIRECTIVE"});
					}
					fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( aPLATFORM );
					fromUpdfwm = IUpdcfgFactory.getIUpffmSV().getSFUpffmLogical( aDIRECTIVE, fromUpffm);
					fromUpfom = IUpdcfgFactory.getIUpffmSV().getSFUpffmOperate( fromUpdfwm.getOPERATE_(), 
							fromUpffm);
					fromUpfwm.setCATEGORY   ( fromUpfom.getCATEGORY()                  );
					fromUpfwm.setPRIORITY   ( fromBusines.getPRIORITY               () );
					fromUpfwm.setPLATFORM   ( fromUpffm.getID                       () );
					fromUpfwm.setDIRECTIVE  ( fromUpdfwm.getID                      () );
					fromUpfwm.setRETRY_TIMES( fromUpfom.getREDO_TIMES               () );
					fromUpfwm.setCOMPOSITE  ( fromUpfom.getCOMPOSITE                () );
				}
				finally{
					if( fromNature != null ){ fromNature.clear(); fromNature = null; }
				}
				return fromUpfwm;
			}
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
	}
}
