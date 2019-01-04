package com.ai.sacenter.provision.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISAProvisionHis;
import com.ai.sacenter.provision.bo.ISAProvisionReset;
import com.ai.sacenter.provision.service.interfaces.IUpfwmSRV;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmComplete;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxDestiny;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-4-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfwmSRVImpl extends UpdcEclipseImpl implements IUpfwmSRV {
	public UpfwmSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmLifite(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxOffer finishSFUpfwmLifite(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxOffer fromUpffmx = null;
		try
		{
			class SFUpfwmLifiteImpl{
				public SFUpfwmLifiteImpl(){
					super();
				}
				
				/**
				 * 根据当前网元工单获取当前网元优先级时限规则
				 * @param fromUpfwm 网元工单
				 * @param fromUpdbfmx 开通优先时限
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public ISystemTemplate.IUpdbfsLimite getSFUpfwmLimite( IOVUpfwmOffer fromUpfwm, 
						java.util.List fromUpdbfmx,
						IOVUpdspmLife fromUpdfwm, 
						IUpdcContext aContext) throws SFException, Exception{
					ISystemTemplate.IUpdbfsLimite fromUpffmx = null;
					try
					{
						ISystemTemplate.IUpdbfsLimite fromLimite = null;
						IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmHome = fromUpfwm.getORDER();
						for( java.util.Iterator itera = fromUpdbfmx.iterator(); itera.hasNext(); ){
							fromLimite = (ISystemTemplate.IUpdbfsLimite)itera.next();
							try
							{
								if( UpdcpUtils.IUpfvn.decision( fromLimite.getCOMPLEX(), fromUpfwmHome.getSUBFLOW(), aContext ) ){
									fromUpffmx = fromLimite;
									break;
								}
							}
							catch( java.lang.Exception exception ){
								log.error( exception.getMessage(), exception );
								ExceptionFactory.throwIllegal( "IOS0011090", new String[]{ fromLimite.getID(), exception.getMessage() } );
							}
							finally{
								
							}
						}
					}
					finally{
						
					}
					return fromUpffmx;
				}
				
				/**
				 * 根据当前网元工单完成当前网元优先级
				 * @param fromUpfwm 开通工单
				 * @param fromUpdfwm 网元指令集
				 * @param fromGroup 网元优先级
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmLimite(IOVUpfwmOffer fromUpfwm, 
						IOVUpdspmLife fromUpdfwm,
						ISystemTemplate.IUpdbfsGroup fromGroup,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						if( fromGroup.getPRIORITY() != null/*开通优先级规则*/){
							ISystemTemplate.IUpdbfsLimite fromLimite = null;
							fromLimite = getSFUpfwmLimite(fromUpfwm, fromGroup.getPRIORITY(), fromUpdfwm, aContext);
							if( fromLimite != null && fromLimite.getPRIORITY() > 0 ){
								fromUpfwm.setPRIORITY ( fromLimite.getPRIORITY () );
								fromUpfwm.setCOMPOSITE( fromLimite.getCOMPOSITE() );
							}
						}
						else if( fromGroup.getLIMITESS() != null/*开通工单时限规则*/){
							ISystemTemplate.IUpdbfsLimite fromLimite = null,fromDefault = null;
							fromDefault = SystemUtils.ISystem.getSFUpffmxLimite();
							fromLimite = getSFUpfwmLimite(fromUpfwm, fromGroup.getLIMITESS(), fromUpdfwm, aContext);
							if( fromLimite == null && fromDefault != null /*采用默认开通时限*/){
								long fromDealLine = Long.parseLong( fromDefault.getEXTEND_ATTR_A() ) - 
										fromUpfwm.getPRIORITY() * Long.parseLong( fromDefault.getEXTEND_ATTR_B() );
								fromUpfwm.setPRIORITY ( fromDealLine              );
							}
							else/*采用开通时限规则*/{
								long fromDealLine = TimeUtils.getAsTime() + fromLimite.getPRIORITY();
								fromUpfwm.setPRIORITY ( fromDealLine              );
								fromUpfwm.setCOMPOSITE( fromLimite.getCOMPOSITE() );
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromUpfwm
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpffmxOffer finishSFUpfwmMapping(IOVUpfwmOffer fromUpfwm, 
						IOVUpdspmLife fromUpdfwm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpffmxOffer fromUpffmx = null;
					try
					{
						fromUpffmx = IUpfwmFactory.getIUpdcpmSV().finishSFUpfwmOffer(fromUpfwm, 
								fromUpdfwm, 
								aContext);
					}
					finally{
						
					}
					return fromUpffmx;
				}
			}
			SFUpfwmLifiteImpl fromLifiteImpl = new SFUpfwmLifiteImpl();
			UpfsvcManager.getRocket().beginTransaction( fromUpfwm, fromUpfwm.getORDER().getSUBFLOW(), aContext );
			try
			{
				ISystemTemplate.IUpdbfsGroup fromLimite = null;
				fromLimite = SystemUtils.ISystem.getSFUpffmxOffer( fromUpfwm.getPRIORITY(), fromUpfwm.getPLATFORM() );
				if( fromLimite != null ){
					if( fromLimite.getPRIORITY() != null && fromLimite.getLIMITESS() != null ){
						ExceptionFactory.throwIllegal("IOS0011089", new String[]{ fromLimite.getPLATFORM(), fromLimite.getGROUP() } );
					}
					fromLifiteImpl.finishSFUpfwmLimite(fromUpfwm, 
							fromUpdfwm, 
							fromLimite, 
							aContext);
				}
				fromUpffmx = fromLifiteImpl.finishSFUpfwmMapping(fromUpfwm, 
						fromUpdfwm, 
						aContext);
				if( fromUpffmx != null && fromUpfwm != null ){
					UpfwmUtils.ICustom._wrap(fromUpfwm,
							fromUpffmx, 
							aContext);
				}
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromLifiteImpl != null ){ fromLifiteImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmOffer(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdcpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public java.util.HashMap finishSFUpfwmOffer(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		java.util.HashMap fromUpffx = new java.util.HashMap();
		try
		{
			IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
			if( fromPROGRAM != null && fromPROGRAM.getSUBFLOW().size() > 0 ){
				IProgramTemplate.IUpdffsmOffer fromUpdffsm = null;
				for( java.util.Iterator itera = fromPROGRAM.getSUBFLOW().iterator(); itera.hasNext(); ){
					fromUpdffsm = (IProgramTemplate.IUpdffsmOffer)itera.next();
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpdffsm, 
							fromUpdcpm.getSUBFLOW(), 
							fromUpffx, 
							aContext);
				}
			}
		}
		finally{
			
		}
		return fromUpffx;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#getSFUpfwmOffer(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmRequest getSFUpfwmOffer(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmRequest fromUpdcpm = null;
		IOVUpfgsmCatalog fromUpfsm = null;
		try
		{
			fromUpdcpm = new IOVUpfwmRequest( fromUpfwm );
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			IOVUpfwmRequest.IUpdbpmOfferHome fromUpdbpmOffer = fromUpdcpm.getSUBFLOW();
			UpfsvcVantage.IUpdfmxDeque fromUpdbpmHome = UpfsvcManager.getRocket().getBlankDeque();
			ClassUtils.IMerge.merge( fromUpfwm.getORDER().getOFFER(), fromUpdbpmOffer.getSUBFLOW() );
			ClassUtils.IMerge.merge( fromUpdfwm.getTOKEN().getDeque(), fromUpdbpmOffer.getSUBFLOW(), false );
			if( fromUpdbpmHome != null ){
				ClassUtils.IMerge.merge( fromUpdbpmHome.getSubFlow(), fromUpdbpmOffer.getSUBFLOW(), true );
			}
			if( StringUtils.isBlank( fromUpfom.getREQUEST() ) == false ){
				fromUpfsm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmc( fromUpfom.getREQUEST(), 
						fromUpdbpmOffer.getSUBFLOW(), 
						aContext);
			}
			if( fromUpfsm != null ){
				ClassUtils.IMerge.merge( fromUpfsm.getMAPPINGS(), fromUpdbpmOffer.getPLATFORM() );
			}
			else{
				ClassUtils.IMerge.merge( fromUpdbpmOffer.getSUBFLOW(), fromUpdbpmOffer.getPLATFORM() );
			}
		}
		finally{
			if( fromUpfsm != null ){ fromUpfsm = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmOffer finishSFUpfwmCreate(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmOffer fromUpfwm = null;
		try
		{
			fromUpfwm = new IOVUpfwmOffer();
			fromUpfwm = UpfwmUtils.ICustom._wrap(fromOrder, 
					fromTASK, 
					fromUpfwm,
					fromUpdfwm,
					aContext);
			if( fromUpfwm != null ){
				finishSFUpfwmLifite(fromOrder, 
						fromTASK, 
						fromUpfwm, 
						fromUpdfwm, 
						aContext);
			}
		}
		finally{
			
		}
		return fromUpfwm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmChange(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmOffer finishSFUpfwmChange(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmOffer fromUpfwm = null;
		try
		{
			fromUpfwm = new IOVUpfwmOffer();
			fromUpfwm = UpfwmUtils.ICustom._wrap(fromOrder, 
					fromTASK, 
					fromUpfwm,
					fromUpdfwm,
					aContext);
			if( fromUpfwm != null ){
				finishSFUpfwmLifite(fromOrder, 
						fromTASK, 
						fromUpfwm, 
						fromUpdfwm, 
						aContext);
			}
		}
		finally{
			
		}
		return fromUpfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmActive(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmOffer finishSFUpfwmActive(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmOffer fromUpfwm = null;
		try
		{
			fromUpfwm = finishSFUpfwmCreate(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext);
			UpfsvcManager.getSession().submitISQLLite(fromTASK, 
					fromUpfwm.getORDER().getREPOSITORY(), 
					fromUpfwm.getINSTANCE() );
			IUpfwmFactory.getIUpffmSV().finishSFUpfwmCreate(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUpfwm, 
					aContext);
		}
		finally{
			
		}
		return fromUpfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmSync(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfwmSync(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = finishSFUpfwmCreate(fromOrder, 
						fromTASK,
						fromUpdfwm, 
						aContext);
				if( fromTASK.isPARALLEL() == false ){
					fromASK = IUpfwmFactory.getIUpdfwmSV().finishSFUpfwm(fromUpfwm, 
							fromUpdfwm, 
						    aContext);
				}
				finishSFUpfwmMonitor(fromUpfwm, 
						fromUpdfwm, 
						fromASK, 
						null, 
						aContext );
			}
			catch( java.lang.Exception aException){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				finishSFUpfwmMonitor(fromUpfwm, 
						fromUpdfwm, 
						fromASK, 
						aEXCEPTION, 
						aContext );
				ExceptionFactory.throwException( aEXCEPTION );
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null ;}
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#getSFUpfwmUser(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpfwmUser(String fromBILL, 
			IPlatformTemplate.IUpffmOffer fromUpfm,
			IUpdcContext aContext) throws SFException, Exception {
		IPlatformTemplate.IUpffmPhone fromUser= null;
		try
		{
			IOVUpdbmtcLife fromToken = IUpdcFactory.getIUpdosSV().getSFUpdbmToken();
			String aINDEX = ClassUtils.getINDEX(new String[] {
					IUpdcConst.IEnum.MSDNLST, "_$_", fromBILL, "_$_",
					fromUpfm.getID() });
			java.util.Map fromGraph = fromToken.getTOKEN().getGraphics();
			if( fromGraph.containsKey( aINDEX ) == false ){
				fromUser = IUpdcfgFactory.getIUpffmSV().getSFUpffmPhone( fromBILL, fromUpfm );
				fromGraph.put( aINDEX , fromUser );
			}
			fromUser = (IPlatformTemplate.IUpffmPhone)fromGraph.get( aINDEX );
		}
		finally{
			
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#getSFUpfwmUser(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpfwmUser(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IPlatformTemplate.IUpffmPhone fromUser = null;
		try
		{
			IOVUpdbmtcLife fromUpdbmtc = IUpdcFactory.getIUpdosSV().getSFUpdbmToken();
			if( fromUpdbmtc != null && fromUpdbmtc.getACCOUNT() != null ){
				IPlatformTemplate.IUpffmOffer fromUpfm = fromUpdfwm.getPLATFORM();
				fromUser = getSFUpfwmUser(fromOrder.getBILL_ID(), 
						fromUpfm, 
						aContext);
				if (fromUpdbmtc.isWHITELST()/* 白名单控制 */) {
					if (fromUser == null) {
						fromUser = new IPlatformTemplate.IUpffmPhone(fromOrder
								.getBILL_ID(), fromUpfm.getID(),
								IUpdcConst.IUpfwm.IUpfms.BLACKLST);
					}
				} else if (fromUpdbmtc.isBLACKLST()/* 黑名单控制 */) {
					if (fromUser == null) {
						fromUser = new IPlatformTemplate.IUpffmPhone(fromOrder
								.getBILL_ID(), fromUpfm.getID(),
								IUpdcConst.IUpfwm.IUpfms.WHITELST);
					}
				}
			}
		}
		finally{
			
		}
		return fromUser;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#getSFUpfwmDebug(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmDirective)
	 */
	public byte[] getSFUpfwmDebug(IPlatformTemplate.IUpffmOffer fromUpfm, 
			IPlatformTemplate.IUpffmDirective fromUpdfm) throws SFException, Exception {
		byte[] fromBytes = null;
		try
		{
			IPlatformTemplate.IUpffmDebuging fromUpffom = null;
			IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
			fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( fromUpfm.getID() );
			for( int index = 0; fromUpffm != null && index < fromUpffm.length; index++ ){
				fromUpffom = IUpdcfgFactory.getIUpffmSV().getSFUpffmDebug(fromUpdfm.getID(), 
						fromUpffm[index].getID() );
				if( fromUpffom != null ){ break; }
			}
			if( fromUpffom != null ){ fromBytes = fromUpffom.getCOMPLEX().getBytes(); }
		}
		finally{
			
		}
		return fromBytes;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwm(com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwm(IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpdfmxDestiny fromUpdfmx = UpfsvcManager.getSession().getBottle();
			for( java.util.Iterator itera = fromUpdfmx.getDestiny().values().iterator() ; itera.hasNext() ; ){
				IOVUpdfmxDestiny.IUpdfmxDestiny fromDestiny = (IOVUpdfmxDestiny.IUpdfmxDestiny)itera.next();
				if( ClassUtils.isAssignable( fromDestiny.getDestiny(), IUpdbmDAOLife.class ) == false ) continue;
				UpdcFactory.getIUpdcDAO( fromDestiny.getDestiny() ).finish( fromDestiny.getBottle() );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmComplete(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer[], com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmComplete(IOVUpfwmOffer[] fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			for( int index = 0; fromUpfwm != null && index < fromUpfwm.length; index++ ){
				IOVUpfwmOrder fromOrder = fromUpfwm[index].getORDER().getORDER();
				if( fromUpfwm[index].isCOMPLETE() /*网元成功,网元异常,人工报俊[网元反馈归档]*/){
					IISAProvision fromHistory = new ISAProvisionHis();
					OracleUtils.ICustom.transfer( fromUpfwm[index].getINSTANCE(), fromHistory );
					fromHistory.setStsToOld();
					UpfwmUtils.ICustom.transfer(fromUpfwm[index], fromHistory);
					
					IISAProvision fromComplete = new ISAProvisionReset();
					OracleUtils.ICustom.transfer( fromUpfwm[index].getINSTANCE(), fromComplete );
					
					fromUpfwm[index].getINSTANCE().setStsToOld();
					fromUpfwm[index].getINSTANCE().delete();
					UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpfwmDAO, 
							new Object[]{fromComplete, fromHistory, fromUpfwm[index].getINSTANCE()} );
				}
				else if( fromUpfwm[index].isISSUED() /*异步报竣{转等待表}*/){
					IISAProvision fromHistory = new ISAProvisionHis();
					OracleUtils.ICustom.transfer( fromUpfwm[index].getINSTANCE(), fromHistory );
					fromHistory.setStsToOld();
					UpfwmUtils.ICustom.transfer(fromUpfwm[index], fromHistory);
					
					fromUpfwm[index].getINSTANCE().setStsToOld();
					fromUpfwm[index].getINSTANCE().delete();
					UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpfwmDAO, 
							new Object[]{fromHistory, 
							fromOrder != null?fromOrder.getINSTANCE():null, 
							fromUpfwm[index].getINSTANCE()} );
				}
				else/*其他处理*/{
					UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpfwmDAO, 
							new Object[]{fromUpfwm[index].getINSTANCE()} );
				}
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			if( fromASK == null || fromASK.isSUCCEED() /*网元应答成功*/){
				fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
				fromUpfwm.setFAIL_LOG ( ""                         );
				if( fromASK != null ){
					fromUpfwm.setFAIL_CODE  ( fromASK.getRspCode   () );
					fromUpfwm.setFAIL_DEVICE( fromASK.getRspHome   () );
					fromUpfwm.setFAIL_REASON( fromASK.getRspDesc   () );
				}
				if( fromUpfom.isSYNCFLG() == false/*异步网元*/){
					fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.ISSUED );
				}
			}
			else/*网元逻辑异常*/{
				fromUpfwm.setPS_STATUS  ( IUpfwmConst.IUpdos.FAILURE );
				fromUpfwm.setFAIL_CODE  ( fromASK.getRspCode      () );
				fromUpfwm.setFAIL_DEVICE( fromASK.getRspHome      () );
				fromUpfwm.setFAIL_REASON( fromASK.getRspDesc      () );
				fromUpfwm.setFAIL_LOG   ( ""                         );
				SFException aEXCEPTION = ExceptionFactory.getRsRsp(fromASK.getRspCode(), 
						fromASK.getRspDesc(), 
						fromUpfwm.getCATEGORY(), 
						fromUpfwm.getPLATFORM() );
				IUpfwmFactory.getIUpdcpmSV().finishSFUpfwmException(fromUpfwm, 
						fromUpdfwm, 
						aEXCEPTION, 
						aContext);
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.EXCEPTION );
			fromUpfwm.setFAIL_CODE( aEXCEPTION.getFaultCode   () );
			fromUpfwm.setFAIL_DEVICE( aEXCEPTION.getOriginator() );
			fromUpfwm.setFAIL_REASON( aEXCEPTION.getMessage   () );
			fromUpfwm.setFAIL_LOG( SystemUtils.getISTKThrow( aEXCEPTION ) );
			IUpfwmFactory.getIUpdcpmSV().finishSFUpfwmException(fromUpfwm, 
					fromUpdfwm, 
					aEXCEPTION, 
					aContext);
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmActive(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmNetWork(IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IOVUpdspmLife fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromUpfwm, aContext);
			UpfsvcManager.getSession().beginTransaction();
			try
			{
				fromASK = IUpfwmFactory.getIUpdfwmSV().finishSFUpfwm(fromUpfwm, 
						fromUpdfwm, 
						aContext);
				finishSFUpfwm(fromUpfwm, 
						fromUpdfwm, 
						fromASK, 
						aContext);
				if (log.isDebugEnabled())
					log.debug("batch directive ["+ fromUpdfwm.getPLATFORM().getID() + "\t"
									+ fromUpdfwm.getDIRECTIVE().getID() + "] completed");
				UpfsvcManager.getSession().commitTransaction();
			}
			catch( java.lang.Exception aException ){
				UpfsvcManager.getSession().rollbackTransaction();
				if (log.isDebugEnabled())
					log.debug("batch directive [" + fromUpdfwm.getPLATFORM().getID() + "\t"
									+ fromUpdfwm.getDIRECTIVE().getID() + "] exception");
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				finishSFUpfwm(fromUpfwm, 
						fromUpdfwm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		finally{
			if( fromASK != null ){ fromASK = null; }
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmQueue(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmQueue(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IPlatformTemplate.IUpffmsOffer __component__ = fromUpdcpm.getPROGRAM().getRESPOND();
			fromUpfwm.setRETRY_TIMES( fromUpfwm.getRETRY_TIMES() - 1 );
			if( fromUpfwm.getRETRY_TIMES() > 0 ){
				java.sql.Timestamp fromTIME = new java.sql.Timestamp( System.currentTimeMillis() );
				if( __component__ != null && __component__.getRETRY_INTERVAL() > 0 ){
					fromTIME = TimeUtils.addSecond( fromTIME, (int)__component__.getRETRY_INTERVAL() );
				}
				fromUpfwm.setORDER_DATE( fromTIME );
				fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.RETRY );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmException(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmException(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmMonitor(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmMonitor(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			java.sql.Timestamp aCOMPLETE = null;
			aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
			fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
			fromUpfwm.setEND_DATE ( aCOMPLETE                  );
			fromUpfwm.setRET_DATE ( aCOMPLETE                  );
			if( aEXCEPTION != null ){
				fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.FAILURE );
				fromUpfwm.setFAIL_CODE( aEXCEPTION.getFaultCode   () );
				fromUpfwm.setFAIL_DEVICE( aEXCEPTION.getOriginator() );
				fromUpfwm.setFAIL_REASON( aEXCEPTION.getMessage   () );
				fromUpfwm.setFAIL_LOG( SystemUtils.getISTKThrow( aEXCEPTION ) );
			}
			else if( fromASK != null ){
				fromUpfwm.setPS_STATUS( fromASK.isSUCCEED()?IUpfwmConst.IUpdos.SUCCEED:
					IUpfwmConst.IUpdos.FAILURE );
				fromUpfwm.setFAIL_CODE  ( fromASK.getRspCode   () );
				fromUpfwm.setFAIL_DEVICE( fromASK.getRspHome   () );
				fromUpfwm.setFAIL_REASON( fromASK.getRspDesc   () );
			}
			IUpfwmFactory.getIUpdfmxSV().finishSFUpfwmHistory(fromUpfwm, 
					fromUpdfwm,
					aContext);
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmHistory(com.ai.sacenter.provision.valuebean.IOVUpfwmComplete, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmHistory(IOVUpfwmComplete fromUpfwm, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			ISAProvisionHis fromHistory = new ISAProvisionHis();
			OracleUtils.ICustom.transfer( fromUpfwm.getINSTANCE(), fromHistory );
			fromHistory.setStsToOld();
			UpfwmUtils.ICustom.transfer(fromUpfwm, fromHistory);
			UpfsvcManager.getSession().submitISQLLite( fromHistory );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			class SFUpfwmReplyImpl{
				public SFUpfwmReplyImpl(){
					super();
				}
				
				/**
				 * 网元反馈单归档到服务工单历史表中
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfwmHistory(MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome,
						IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						IPlatformTemplate.IUpffmOffer fromUpffm = null;
						fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( fromMBean.getREPOSITORY().getName() );
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmCouple fromCouple = (IOVUpfwmCouple)itera.next();
							IISAProvision fromHistory = new ISAProvisionHis();
							fromHistory.setPsId        ( fromCouple.getPS_ID       () );  
							fromHistory.setRegionId    ( fromCouple.getREGION_ID   () );
							fromHistory.setCreateDate  ( fromCouple.getCREATE_DATE () );
							fromHistory.setPlatform    ( fromUpffm.getID                  () );
							fromHistory.setStsToOld();
							UpfwmUtils.ICustom.transfer( fromCouple, fromHistory);
							UpfsvcManager.getSession().submitISQLLite(IUpfwmConst.IUpfwm.IUpfwmDAO, fromHistory );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 删除网元定单反馈单发起方数据
				 * @param fromMBean 
				 * @param fromCouple
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfwmLifite(MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome,
						IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmCouple fromCouple = (IOVUpfwmCouple)itera.next();
							if( fromCouple.getINSTANCE() != null ){
								fromCouple.getINSTANCE().setStsToOld();
								fromCouple.getINSTANCE().delete();
								UpfsvcManager.getSession().submitISQLLite( fromMBean.getREPOSITORY(), 
										fromCouple.getINSTANCE() );
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfwmException(MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome,
						SFException aEXCEPTION,
						IUpdcContext aContext) throws RemoteException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmCouple fromCouple = (IOVUpfwmCouple)itera.next();
							if( fromCouple.getINSTANCE() != null ){
								fromCouple.getINSTANCE().setStsToOld();
								fromCouple.getINSTANCE().delete();
								UpfsvcManager.getSession().submitISQLLifite( fromMBean.getREPOSITORY(), 
										fromCouple.getINSTANCE() );
							}
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
				
			}
			SFUpfwmReplyImpl fromUpfgkmImpl = new SFUpfwmReplyImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOVUpfwmCouple fromCouple[] = null;
				fromCouple = (IOVUpfwmCouple[])fromUpfgkmHome.getCOMPLETE( IOVUpfwmCouple.class );
				fromUpfgkmImpl.finishSFUpfwmHistory(fromMBean, 
						fromUpfgkmHome, 
						aContext);
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmComplete(fromMBean,
						fromCouple, 
						aContext);
				fromUpfgkmImpl.finishSFUpfwmLifite(fromMBean, 
						fromUpfgkmHome, 
						aContext);
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUpfgkmImpl.finishSFUpfwmException(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmSync(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfwmSync(IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext) throws RemoteException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IOVUpdspmLife fromUpdfwm = null; 
			fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromUpfwm, aContext);
			UpfsvcManager.getSession().beginTransaction();
			UpfwmUtils.finishSFUpdbmCreate(fromUpfwm, fromUpdfwm, aContext);
			try
			{
				fromASK = IUpfwmFactory.getIUpdfwmSV().finishSFUpdfwm(fromUpfwm, 
						fromUpdfwm, 
						aContext);
				finishSFUpfwmMonitor(fromUpfwm, 
						fromUpdfwm, 
						fromASK, 
						null, 
						aContext);
				UpfsvcManager.getSession().commitTransaction();
			}
			catch( java.lang.Exception aException ){
				UpfsvcManager.getSession().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				finishSFUpfwmMonitor(fromUpfwm, 
						fromUpdfwm, 
						null, 
						aEXCEPTION, 
						aContext);
				throw aEXCEPTION;
			}
			finally{
				UpfwmUtils.finishSFUpdbmComplete( aContext );
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpfwmSRV#finishSFUpfwmNetWork(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmNetWork(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			class SFUpfwmSyncImpl{
				public SFUpfwmSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUserHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(MBeanDelegate fromMBean, 
						ArrayUQCList fromUserHome,
						IUpdcContext aContext ) throws SFException,Exception{
					java.util.Map fromGroup = new java.util.HashMap();
					java.util.Map fromHigh = new java.util.HashMap();
					try
					{
						for( java.util.Iterator itera = fromUserHome.iterator(); itera.hasNext(); ){
							IOVUpfwmOffer aUpfwmLife = (IOVUpfwmOffer)itera.next();
							Long aUSER_ID = new Long( aUpfwmLife.getUSER_ID() );
							if( fromGroup.containsKey( aUSER_ID ) == false ){ 
								fromGroup.put( aUSER_ID , new java.util.ArrayList() );
								fromHigh.put( aUSER_ID , aUpfwmLife );
							}
							((java.util.List)fromGroup.get( aUSER_ID ) ).add( aUpfwmLife );
							IOVUpfwmOffer aUpfwmspLife = (IOVUpfwmOffer)fromHigh.get( aUSER_ID );
							if( aUpfwmLife.getPRIORITY() > aUpfwmspLife.getPRIORITY() ) fromHigh.put( aUSER_ID , aUpfwmLife );
							aUpfwmspLife = (IOVUpfwmOffer)fromHigh.get( aUSER_ID );
							for( java.util.Iterator iterap = ((java.util.List)fromGroup.get( aUSER_ID ) ).iterator(); iterap.hasNext(); ){
								aUpfwmLife = (IOVUpfwmOffer)iterap.next();
								if( aUpfwmLife.getPRIORITY() < aUpfwmspLife.getPRIORITY() ){
									aUpfwmLife.getORDER().setPRIORITY( aUpfwmspLife.getPRIORITY() );
								}
							}
						}
					}
					finally{
						if( fromHigh != null ){ fromHigh.clear(); fromHigh = null;}  
						if( fromGroup != null ){ fromGroup.clear(); fromGroup = null;}
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @return
				 * @throws RemoteException
				 * @throws Exception
				 */
				public ArrayUQCList getSFUpfwmUserHome( MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromUpfgkmHome, 
						IUpdcContext aContext) throws RemoteException, Exception{
					ArrayUQCList fromGroupHome = new ArrayUQCList();
					try
					{
						ClassUtils.IMerge.merge( fromUpfgkmHome.getCOMPLETE(), fromGroupHome );
						fromGroupHome = UpfwmFactory.getIUpfwmDAO().getSFUpfwmActive( fromGroupHome );
						finishSFUserGroup(fromMBean, fromGroupHome, aContext);
						ClassUtils.IClass.sort( fromGroupHome , new java.util.Comparator() {
					    	public int compare(Object a, Object b) {
					    		IOVUpfwmOffer fromUpfwmA = (IOVUpfwmOffer)a,fromUpfwmB = (IOVUpfwmOffer)b;
					    		long doCompare = fromUpfwmA.getORDER().getPRIORITY() - fromUpfwmB.getORDER().getPRIORITY();
					    		if( doCompare != 0 ) return doCompare > 0?-1:1;
					    		else{
					    			doCompare = fromUpfwmA.getTIMESQ().compareTo( fromUpfwmB.getTIMESQ() );
					    			return doCompare == 0?0:(doCompare > 0?1:-1);
					    		}
							}
						});
					}
					finally{
						
					}
					return fromGroupHome;
				}
				/**
				 * 
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmHistory( IOVUpfwmOffer fromUpfwm, 
						IUpdcContext aContext) throws SFException,Exception{
					try
					{
						fromUpfwm.setRET_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						finishSFUpfwmComplete( new IOVUpfwmOffer[]{ fromUpfwm }, aContext);
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromUpfwm
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmException(IOVUpfwmOffer fromUpfwm, 
						SFException aEXCEPTION, 
						IUpdcContext aContext) throws SFException, Exception {
					try
					{
						fromUpfwm.setRET_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.EXCEPTION );
						fromUpfwm.setFAIL_CODE( aEXCEPTION.getFaultCode   () );
						fromUpfwm.setFAIL_DEVICE( aEXCEPTION.getOriginator() );
						fromUpfwm.setFAIL_REASON( aEXCEPTION.getMessage   () );
						fromUpfwm.setFAIL_LOG( SystemUtils.getISTKThrow( aEXCEPTION ) );
						finishSFUpfwmComplete( new IOVUpfwmOffer[]{ fromUpfwm }, aContext);
					}
					finally{
						
					}
				}
			}
			SFUpfwmSyncImpl fromUpfwmImpl = new SFUpfwmSyncImpl();
			ArrayUQCList fromUpfwmHome = new ArrayUQCList();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromUpfwmHome = fromUpfwmImpl.getSFUpfwmUserHome(fromMBean, fromUpfgkmHome, aContext);
				for( java.util.Iterator itera = fromUpfwmHome.iterator(); itera.hasNext(); ){
					IOVUpfwmOffer fromUpfwm = (IOVUpfwmOffer)itera.next();
					fromUpfwm.setPS_STATUS( IUpfwmConst.IUpdos.RUNNING );
					UpfsvcManager.getSession().beginTransaction();
					try
					{
						IUpfwmFactory.getIUpfwmSV().finishSFUpfwmNetWork(fromUpfwm, aContext);
						fromUpfwmImpl.finishSFUpfwmHistory( fromUpfwm, aContext );
						UpfsvcManager.getSession().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getSession().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( exception );
						fromUpfwmImpl.finishSFUpfwmException(fromUpfwm, aEXCEPTION, aContext);
					}
					finally{
						
					}
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromUpfwmHome != null ){ fromUpfwmHome.clear(); fromUpfwmHome = null;}
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
			}
		}
		finally{
			
		}
	}
}
