package com.ai.sacenter.core.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.service.interfaces.ITaskSRV;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.suggest.IUpfgxmFactory;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.valuebean.IUpfgkmUserHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class TaskSRVImpl extends UpdcEclipseImpl implements ITaskSRV {
    private final static Log log = LogFactory.getLog( TaskSRVImpl.class );
	public TaskSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium finishSFTaskCreate(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium fromTASK = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpfm = null;
			IPlatformTemplate.IUpffmDirective fromUpdfm = null;
			IPlatformTemplate.IUpffmOperate fromUpfom = null;
			UpfsvcVantage.IUpdfmxDeque fromUpdbpmHome = UpfsvcManager.getRocket().getBlankDeque();
			fromUpfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromUpdbm.getPLATFORM() );
			fromUpdfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmLogical( fromUpdbm.getDIRECTIVE(), fromUpfm );
			fromUpfom = IUpdcfgFactory.getIUpffmSV().getSFUpffmOperate( fromUpdfm.getOPERATE_() , fromUpfm );
			fromTASK = new IOVTaskPentium( fromOrder , 
					fromUpdfm,
					fromUpfom,
					fromUpdbm,
					fromUpfm ) ;
			fromTASK.setOFFER_ID( fromOffer.getOFFER_ID() );
			fromTASK.getORDER().setOFFER( fromOffer );
			if( fromUpdbpmHome != null && fromUpdbpmHome.getSubFlow().size() > 0 ){
				String aCOMPLEX = JdomUtils.ICustom.wrap( fromUpdbpmHome.getSubFlow(), null );
				fromTASK.setPARAM( aCOMPLEX );
			}
		}
		finally{
			
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#getSFTaskOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder) throws SFException, Exception {
		java.util.HashMap fromOffer = new java.util.HashMap();
		try
		{
			UpfsvcVantage.IUpdfmxDeque fromUpdbpmHome = UpfsvcManager.getRocket().getBlankDeque();
			IOVOrderPentium.IOrderOfferHome fromOfferHome = fromOrder.getORDER();
			ClassUtils.IMerge.merge( fromOfferHome.getTOKEN().getDeque(), fromOffer , true );
			if( fromUpdbpmHome != null ) fromOffer.putAll( fromUpdbpmHome.getSubFlow() );
		}
		finally{
		
		}
		return fromOffer;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#getSFTaskOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.HashMap fromUpffmx = null;
		try
		{
			IOVOrderPentium.IOrderOfferHome fromOfferHome = fromOrder.getORDER();
			ClassUtils.IMerge.merge( fromTASK.getORDER().getPARAM(), fromOfferHome.getTOKEN().getDeque() );
			fromUpffmx = getSFTaskOffer( fromOrder );
			IOVOfferPentium fromOffer = fromTASK.getORDER().getOFFER();
			if( fromOffer != null ){
				ClassUtils.IMerge.merge( fromOffer.getORDER().getOFFER(), fromUpffmx );
			}
		}
		finally{
			if( fromOrder != null ){ fromOrder.getORDER().getTOKEN().getDeque().clear();}
		}
		return fromUpffmx;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#getSFTaskOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		java.util.HashMap fromUpffmx = null;
		try
		{
			fromUpffmx = getSFTaskOffer(fromOrder, fromTASK, aContext);
			ClassUtils.IMerge.merge( fromUpdfwm.getTOKEN().getDeque(), fromUpffmx, true );
		}
		finally{
			if( fromOrder != null ){ fromOrder.getORDER().getTOKEN().getDeque().clear();}
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#getSFUpfgkmUser(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.IUpdcContext)
	 */
	public IUpfgkmUserHome getSFUpfgkmUser(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpfgkmUserHome fromPhone = null;
		try
		{
			fromPhone = new IUpfgkmUserHome( fromTASK );
			IOVOfferPentium fromOffer = fromTASK.getORDER().getOFFER();
			IOVTaskPentium.ITaskOfferHome fromTaskHome = fromTASK.getORDER();
			fromPhone.getUSER().setUSER_ID    ( fromOrder.getUSER_ID        () );
			fromPhone.getUSER().setBILL_ID    ( fromOrder.getBILL_ID        () );
			fromPhone.getUSER().setSUB_BILL_ID( fromOrder.getSUB_BILL_ID    () );
			fromPhone.getUSER().setREGION_CODE( fromOrder.getUSER_REGION_ID () );
			fromPhone.getUSER().setREGION_ID  ( fromOrder.getORDER_REGION_ID() );
			if( fromOffer != null ){ ClassUtils.IMerge.merge( fromOffer.getORDER().getOFFER(), 
					fromPhone.getOFFER() ); }
			if( StringUtils.isBlank( fromTASK.getPARAM() ) == false ){
				IUpfgkmUserHome.IUpfgkmPhoneHome fromUser = fromPhone.getUSER();
				ClassUtils.IMerge.merge( fromTaskHome.getPARAM(), fromUser.getPARAM() );
				String fromDELETE[] = ClassUtils.IClass.transfer(fromUser.getPARAM(), fromUser );
				ClassUtils.IMerge.purge( fromUser.getPARAM(), fromDELETE );
			}
		}
		finally{
			
		}
		return fromPhone;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#getSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.IUpdcContext)
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium fromOrder, IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpfwm = new java.util.ArrayList();
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			IOVUpdspmLife fromUpdfwm = null;
			IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTaskCreate( fromOrder );
			for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
				if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK[index] ) ) continue;
				if( UpdbpmUtils.IIfElse.isIMMED( fromOrder, fromTASK[index], aContext ) ){
					String fromGroup = ClassUtils.getINDEX( new String[]{fromTASK[index].getPLATFORM(), 
							fromTASK[index].getDIRECTIVE() } );
					if( fromINDEX.containsKey( fromGroup ) == false ){
						fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromOrder, 
								fromTASK[index], 
								aContext );
						fromINDEX.put( fromGroup , fromUpdfwm );
						fromUpfwm.add( fromUpdfwm );
					}
					( (IOVUpdspmLife)fromINDEX.get( fromGroup ) ).getBPMING().add( fromTASK[index] );
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromUpfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#getSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium[], com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium[] fromOrder, IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpfwm = new java.util.ArrayList();
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			IOVUpdspmLife fromUpdfwm = null;
			for( int index = 0 ; fromOrder != null && index < fromOrder.length ; index++ ){
				IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTaskCreate( fromOrder[index] );
				for( int aINDEX = 0 ; fromTASK != null && aINDEX < fromTASK.length ; aINDEX++ ){
					if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder[index], fromTASK[aINDEX] ) ) continue;
					if( UpdbpmUtils.IIfElse.isIMMED( fromOrder[index], fromTASK[aINDEX], aContext ) ){
						String fromGroup = ClassUtils.getINDEX( new String[]{fromTASK[aINDEX].getPLATFORM(), 
								fromTASK[aINDEX].getDIRECTIVE() } );
						if( fromINDEX.containsKey( fromGroup ) == false ){
							fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromOrder[index], 
									fromTASK[aINDEX], 
									aContext );
							fromINDEX.put( fromGroup , fromUpdfwm );
							fromUpfwm.add( fromUpdfwm );
						}
						( (IOVUpdspmLife)fromINDEX.get( fromGroup ) ).getBPMING().add( fromTASK[aINDEX] );
					}
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromUpfwm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskRespond(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskRespond(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromNetWork, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			if( fromNetWork == null && aEXCEPTION != null ){
				fromNetWork = SystemUtils.ICustom._wrap(fromTASK, null, aEXCEPTION);
				fromTASK.setFAIL_LOG   ( SystemUtils.getISTKThrow( aEXCEPTION ) );
				fromTASK.setDONE_RESULT( fromNetWork.getAsXml                () );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			}
			else if( fromNetWork != null ){
				if( UpdbpmUtils.IIfElse.isREPLY( fromOrder, fromTASK, aEXCEPTION ) ){
					fromOrder.getORDER().mergeAsRespond( fromNetWork );
					UpfsvcManager.getMBean().getRespond().mergeAsGroup( fromNetWork );
					UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
				}
				fromTASK.setDONE_RESULT( fromNetWork.getAsXml() );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskChain(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskChain(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromNetWork, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			if( fromNetWork != null ){
				finishSFTaskRespond(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromNetWork, 
						null, 
						aContext);
				if( fromNetWork != null && fromNetWork.isFAILURE()/*网元指令逻辑异常[服务激活补偿规范]*/){
					finishSFTaskNetWork(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							fromNetWork, 
							null, 
							aContext);
				}
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskChain(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskChain(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			if( UpdbpmUtils.IIfElse.isREMOTE( aEXCEPTION )/*补偿异常直接抛逻辑类异常*/ )
				throw aEXCEPTION;
			finishSFTaskRespond(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					null, 
					aEXCEPTION, 
					aContext);
			throw aEXCEPTION;
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromTASK.setPLWK_CODING( IUpdcConst.IUpdfx.SUCCEED );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK ) ){ 
				IUpfgxmFactory.getIUpfgxmSV().finishSFTaskComplete(fromOrder, 
						fromTASK,
						null,
						aContext);
				finishSFTaskComplete( fromOrder, 
						fromTASK, 
						aContext );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
			fromTASK.setDONE_TIMES   ( fromTASK.getREDO_TIMES () );
			fromTASK.setPLWK_COMPLETE( aCOMPLETE                 );
			if( fromASK != null ){
				finishSFTaskChain(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromASK,
						aContext);
			}
			fromTASK.setSTATE( fromTASK.isCOMPENSATE()?IUpdcConst.IState.S:IUpdcConst.IState.O );
			finishSFTask( fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext );
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpdspmLife fromUpdfwm = null;
			fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromOrder, 
					fromTASK, 
					aContext);
			finishSFTaskException( fromOrder, 
					fromTASK, 
					fromUpdfwm,
					aEXCEPTION, 
					aContext );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromTASK.setDONE_TIMES ( fromTASK.getDONE_TIMES() + 1           );
			fromTASK.setSTATE      ( IUpdcConst.IState.E                    );
			fromTASK.setPLWK_CODING( aEXCEPTION.getFaultCode             () );
			fromTASK.setFAIL_LOG   ( SystemUtils.getISTKThrow( aEXCEPTION ) );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			finishSFTaskException( fromOrder, 
					fromTASK, 
					fromUpdfwm,
					aEXCEPTION, 
					aContext );
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTaskComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
			fromTASK.setDONE_TIMES   ( fromTASK.getDONE_TIMES() + 1           );
			fromTASK.setSTATE        ( IUpdcConst.IState.E                    );
			fromTASK.setPLWK_CODING  ( aEXCEPTION.getFaultCode             () );
			fromTASK.setPLWK_COMPLETE( aCOMPLETE                              );
			fromTASK.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			finishSFTask(fromOrder, 
					fromTASK, 
					aEXCEPTION, 
					aContext);
			IOVTaskPentium fromPending[] = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder );
			IUpdcFactory.getISystemSV().finishSFUpfwm( fromOrder, 
					fromPending, 
					aContext );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskException(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTaskException(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
			fromTASK.setDONE_TIMES   ( fromTASK.getDONE_TIMES() + 1           );
			fromTASK.setSTATE        ( IUpdcConst.IState.E                    );
			fromTASK.setPLWK_CODING  ( aEXCEPTION.getFaultCode             () );
			fromTASK.setPLWK_COMPLETE( aCOMPLETE                              );
			fromTASK.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			finishSFTask(fromOrder, 
					fromTASK, 
					aEXCEPTION, 
					aContext);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskComplete(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpdcpmImpl{
				SFUpdcpmComplete _COMPLETE = new SFUpdcpmComplete();
				public SFUpdcpmImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromPending
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOfferComplete( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVTaskPentium fromPending[],
			            IUpdcContext aContext) throws SFException, Exception{
					SFOfferComplete _OFFER = new SFOfferComplete();
					try
					{
						IOVOfferPentium fromOFFER = fromTASK.getORDER().getOFFER();
						if( fromOFFER != null ){
							_OFFER._complete(fromOrder, fromTASK, fromPending, aContext);
							fromOFFER = fromOrder.getORDER().getOFFER( fromOFFER.getOFFER_ID() );
							if( fromOFFER != null && _OFFER.isCOMPLETE() /*开通订购已正常完成*/){
								fromOFFER.setSTATE( IUpdcConst.IState.O );
								UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
							}
							else if( fromOFFER != null && _OFFER.isEXCEPTION() /*开通订购已异常完成*/ ){
								fromOFFER.setSTATE( IUpdcConst.IState.E );
								UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
							}
							else if( fromOFFER != null && _OFFER.isCANCEL() /*开通订购已撤销完成*/){
								fromOFFER.setSTATE( IUpdcConst.IState.Q );
								UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
							}
						}
					}
					finally{
						if( _OFFER != null ) { _OFFER._OFFER.clear(); _OFFER = null; }
					}
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFComplete(IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVTaskPentium fromPending[] = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder );
						fromPending = finishSFTaskDepend( fromOrder, fromPending, fromTASK, aContext );
						finishSFOfferComplete(fromOrder, fromTASK, fromPending, aContext);
						UpdcUtils.ICustom.groupAsState( fromPending, _COMPLETE._COMPLETE );
						ClassUtils.IMerge.purge( _COMPLETE._COMPLETE , new String[]{IUpdcConst.IState.O,
								IUpdcConst.IState.F, IUpdcConst.IState.Q, IUpdcConst.IState.S } );
						if( _COMPLETE.isEXCEPTION() || _COMPLETE.isCOMPLETE() ){
							fromOrder.setSTATE( IUpdcConst.IState.O );
							if( _COMPLETE.isEXCEPTION() ){
								fromOrder.setSTATE( IUpdcConst.IState.E );
							}
							UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
						}
					}
					finally{
						
					}
				}
				/**
				 * 完成服务异常定单
				 * @param fromOrder
				 * @param fromTASK
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFTaskRollBack(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						if( fromTASK.getCREATE_TASK_ID() > 0 && fromTASK.getCREATE() != null 
								/*服务异常定单任务报竣工设置父级任务单为被异常回单*/ ){
							IOVTaskPentium fromPending[] = null;
							IOVTaskPentium fromCREATE = IUpdcFactory.getIUpdwfSV().getSFTask( fromTASK.getCREATE_TASK_ID() );
							if( fromCREATE != null ){
								IOVOrderPentium fromMain = IUpdcFactory.getIUpdwfSV().getSFOrder(fromCREATE, fromCREATE.getORDER_ID() );
								fromCREATE.setSTATE( IUpdcConst.IState.Q );
								UpfsvcManager.getSession().submitIUpdfmxLifite( fromCREATE );
								fromPending = IUpdcFactory.getIUpdwfSV().getSFTask( fromMain );
								finishSFOfferComplete(fromMain, fromCREATE, fromPending, aContext);
							}
							if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder ) /*开通异常工单报竣*/){
								fromCREATE = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder.getCREATE_TASK_ID() );
								if( fromCREATE != null ){
									fromCREATE.setSTATE( IUpdcConst.IState.E );
									UpfsvcManager.getSession().submitIUpdfmxLifite( fromCREATE );
									IOVOrderPentium fromCREATE_ORDER = IUpdcFactory.getIUpdwfSV().getSFOrder( fromCREATE, fromCREATE.getORDER_ID() );
									fromCREATE_ORDER.setSTATE( IUpdcConst.IState.Q );
									fromPending = IUpdcFactory.getIUpdwfSV().getSFTask( fromCREATE_ORDER );
									finishSFOfferComplete(fromCREATE_ORDER, fromCREATE, fromPending, aContext);
									UpfsvcManager.getSession().submitIUpdfmxLifite( fromCREATE_ORDER );
								}
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 完成服务群组定单
				 * @param fromGroup
				 * @param fromTASK
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFTaskMember(IOVOrderPentium fromGroup, 
						IOVTaskPentium fromTASK, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						finishSFTaskGroup(fromGroup, aContext);
					}
					finally{
						
					}
				}
				class SFUpdcpmComplete{
					private java.util.Map _COMPLETE = new java.util.HashMap();
					public SFUpdcpmComplete(){
						super();
					}
					/**
					 * 是否开通任务已正常完成
					 * @return
					 */
					public boolean isCOMPLETE(){
						return  _COMPLETE.size() == 0;
					}
					/**
					 * 是否开通任务已发生异常
					 * @return
					 */
					public boolean isEXCEPTION(){
						return _COMPLETE.size() > 0 && _COMPLETE.containsKey( IUpdcConst.IState.E );
					}
				}
				class SFOfferComplete{
					java.util.Map _OFFER = new java.util.HashMap();
					public SFOfferComplete(){
						super();
					}
					/**
					 * 计算正常报竣开通订购
					 * @param fromOrder
					 * @param fromTASK
					 * @param fromPending
					 * @param aContext
					 * @throws SFException
					 * @throws Exception
					 */
					public void _complete( IOVOrderPentium fromOrder,
							IOVTaskPentium fromTASK,
							IOVTaskPentium fromPending[],
				            IUpdcContext aContext) throws SFException, Exception{
						try
						{
							IOVOfferPentium fromOFFER = fromTASK.getORDER().getOFFER();
							for( int index = 0; fromPending != null && index < fromPending.length; index++ ){
						    	IOVOfferPentium fromOffer = fromPending[index].getORDER().getOFFER();
						    	if( fromOffer.getOFFER_ID() != fromOFFER.getOFFER_ID() ) continue;
						    	if( fromPending[index].isCOMPLETE() == false ){
						    		if( _OFFER.containsKey( fromPending[index].getSTATE() ) == false ){
							    		_OFFER.put( fromPending[index].getSTATE() , new java.util.ArrayList() );
							    	}
							    	((java.util.List)_OFFER.get( fromPending[index].getSTATE() )).add( fromOffer );
						    	}
						    }
						}
						finally{
							
						}
					}
					/**
					 * 是否开通订购已正常完成
					 * @return
					 */
					public boolean isCOMPLETE(){
						return _OFFER != null && _OFFER.size() == 0;
					}
					/**
					 * 是否开通订购已异常完成
					 * @return
					 */
					public boolean isEXCEPTION(){
						return _OFFER != null && _OFFER.containsKey( IUpdcConst.IState.E );
					}
					/**
					 * 是否为开通订购已撤销
					 * @return
					 */
					public boolean isCANCEL(){
						return _OFFER != null && _OFFER.containsKey( IUpdcConst.IState.Q );
					}
				}
			}
			SFUpdcpmImpl fromUpdcpm = new SFUpdcpmImpl();
			try
			{
				fromUpdcpm.finishSFComplete(fromOrder, 
						fromTASK, 
						aContext);
				if( fromOrder.isEXCEPTION() /*服务异常定单*/ ){
					fromUpdcpm.finishSFTaskRollBack(fromOrder, 
							fromTASK, 
							aContext);
				}
				else if( fromOrder.isGROUP() && UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder ) /*服务群组定单*/ ){
					fromUpdcpm.finishSFTaskMember(fromOrder, 
							fromTASK, 
							aContext);
				}
			}
			finally{
				if( fromUpdcpm != null ){ fromUpdcpm._COMPLETE = null; fromUpdcpm = null; }
			}
		}
		finally{
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskGroup(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTaskGroup(IOVOrderPentium fromGroup,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVOrderPentium fromChild[] = IUpdcFactory.getIUpdwfSV().getSFMember( fromGroup );
			for( int index = 0; fromChild != null && index < fromChild.length; index++ ){
				if( fromGroup.isFAILURE() /*群组成员单转人工单[群组单转人工]*/){
					fromChild[index].setSTATE( IUpdcConst.IState.H, fromChild[index].getSTATE() );
					UpfsvcManager.getSession().submitIUpdfmxLifite( fromChild[index] );
				}
				else if( fromGroup.isCOMPLETE() /*群组成员工单拆分[群组单正常报竣]*/){
					fromChild[index].setSTATE( IUpdcConst.IState.C );
					UpfsvcManager.getSession().submitIUpdfmxLifite( fromChild[index] );
					IUpdcFactory.getIUpdbpmSV().finishSFUpdbpm( new IOVOrderPentium[]{fromChild[index]}, 
							aContext );
				}
				else if( fromGroup.isHISTORY() /*群组成员归档[群组单归档]*/){
					fromChild[index].setSTATE( fromGroup.getSTATE(), fromChild[index].getSTATE() );
					UpfsvcManager.getSession().submitIUpdfmxLifite( fromChild[index] );
				}
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskException(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskException(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromOrder.setFAIL_LOG( fromTASK.getDONE_RESULT() );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
			if( fromOrder.isEXCEPTION() == false /*异常策略组件[服务正常任务发生网元指令异常]*/ ){
				IUpdcFactory.getIUpdcpmSV().finishSFTaskException(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aEXCEPTION, 
						aContext);
				IUpfgxmFactory.getIUpfgxmSV().finishSFTaskComplete(fromOrder, 
						fromTASK,
						aEXCEPTION,
						aContext);
			}
			else/*是否异常回滚工单对应任务单异常*/{
				fromTASK.setSTATE( IUpdcConst.IState.S );
				IOVTaskPentium fromALL[] = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder );
				finishSFTaskDepend(fromOrder, fromALL, fromTASK, aContext );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
				if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK ) ){ 
					finishSFTaskComplete( fromOrder, 
							fromTASK, 
							aContext );
				}
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskNetWork(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskNetWork(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromNetWork, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfwmResponse fromUpdbfmx = null;
			fromUpdbfmx = IUpdcFactory.getIUpdcpmSV().finishSFTaskNetWork(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromNetWork, 
					aEXCEPTION, 
					aContext);
			if( fromUpdbfmx != null && fromUpdbfmx.isFAILURE()/*异常补偿[转服务任务人工界面]*/ ){
				if( fromNetWork == null && aEXCEPTION != null/*非逻辑异常*/){
					ExceptionFactory.throwException( aEXCEPTION );
				}
				else if( fromNetWork != null/*逻辑异常*/ ){
					ExceptionFactory.throwRsRsp(fromUpdbfmx.getRspCode(), 
							fromUpdbfmx.getRspDesc(), 
							fromUpdbfmx.getRspHome() );
				}
			}
			fromTASK.setCOMPENSATE( fromUpdbfmx.getORDER().getSUBFLOW() );
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskCompensa(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFTaskCompensa(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		UpfsvcManager.getRocket().beginTransaction( fromTASK, fromUpdcpm.getSUBFLOW(), aContext );
		try
		{
			IProgramTemplate.IUpdfmptOffer.IUpdfcmpCompensation aCompensation = null;
			IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
			for( java.util.Iterator itera = fromUpdcpmHome.getSUBFLOW().iterator(); itera.hasNext(); ){
				IProgramTemplate.IUpdfmptOffer fromUpffmx = (IProgramTemplate.IUpdfmptOffer)itera.next();
				for( java.util.Iterator iterap = fromUpffmx.getCOMPENSA().iterator(); iterap.hasNext(); ){
					aCompensation = (IProgramTemplate.IUpdfmptOffer.IUpdfcmpCompensation)iterap.next();
					if( UpdcpUtils.IUpfvn.decision( aCompensation.getCOMPLEX(), fromUpdcpm.getSUBFLOW(), aContext ) ){
						return aCompensation;
					}
				}
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskDepend(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[], com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFTaskDepend(IOVOrderPentium fromOrder, 
			IOVTaskPentium[] fromDepend, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromINDEX = new ArrayUQCList();
		try
		{
			if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK ) ) {
				IOVTaskPentium fromPentium = null;
				ClassUtils.IMerge.merge( fromDepend, fromINDEX );
				for( int index = 0 ; fromDepend != null && index < fromDepend.length ; index++ ){
					if( fromDepend[index].isDEPEND() && fromDepend[index].getDEPEND_TASK_ID() == 
						fromTASK.getTASK_ID() && fromDepend[index].getORDER_ID() == fromOrder.getORDER_ID() ){
						fromPentium = new IOVTaskPentium( fromDepend[index] );
						fromPentium.setSTATE( IUpdcConst.IState.C );
						fromINDEX.add( fromPentium );
						UpfsvcManager.getSession().submitIUpdfmxLifite( fromPentium );
					}
				}
				if( fromINDEX != null && fromINDEX.size() > 0 ){
					fromDepend = (IOVTaskPentium[])fromINDEX.toArray( new IOVTaskPentium[]{} );
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
		}
		return fromDepend;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskException(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskException(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromOrder.setSTATE( IUpdcConst.IState.E );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			ExceptionFactory.throwException( aEXCEPTION );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskIgnore(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskIgnore(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromTASK.setSTATE( IUpdcConst.IState.S );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK ) ){ 
				finishSFTaskComplete( fromOrder, 
						fromTASK, 
						aContext );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskComplete(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromTASK.setSTATE( IUpdcConst.IState.F );
			fromOrder.setSTATE( IUpdcConst.IState.R );
			UpfsvcManager.getSession().submitIUpdfmxLifite( new Object[]{ fromTASK, fromOrder } );
			if( UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK ) ){
				IUpdcFactory.getIUpdbpmSV().finishSFUpdbmCompensate(fromOrder, 
						fromTASK, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
				finishSFTaskComplete( fromOrder, 
						fromTASK, 
						aContext );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskHuman(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskHuman(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromOrder.setSTATE( IUpdcConst.IState.H );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
			if( fromTASK.isASSIGNED() == false /*服务任务未派单*/){
				IOVUpdffwmOffer fromUpdgma = IUpdcFactory.getIUpdcpmSV().finishSFTaskClaim(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aEXCEPTION,
						aContext);
				fromTASK.setSTATION_ID( fromUpdgma != null ?fromUpdgma.getOBJECT():IUpdcConst.IEnum.STATION );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskQueue(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskQueue(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVQueuePentium fromQueue = null;
			IOVTaskPentium.ITaskOfferHome fromOffer = fromTASK.getORDER();
			if( fromTASK.isQUEUE() ) fromQueue = (IOVQueuePentium)fromOffer.getORIGING();
			if( fromQueue == null )/*转服务队列调度*/{
				IUpdcFactory.getIUpdcmqSV().finishSFUpdcmqCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			else{
				if( fromQueue.isRETRY()/* 转重做操作网元,否则转人工单处理 */) {
					if( fromQueue != null ){
						ExceptionFactory.throwException("IOS0010029", new String[]{
								String.valueOf(fromTASK.getTASK_ID())});
					}
				}
				finishSFTaskHuman(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
		}
		finally{
		
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskRollBack(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVTaskPentium fromRollBack[] = null;
			fromRollBack = IUpdcFactory.getIUpdbpmSV().finishSFUpdbmRollBack( fromOrder, 
					fromTASK ,
					aEXCEPTION,
					aContext);
			fromOrder.setSTATE( fromRollBack != null && fromRollBack.length > 0 ?
					IUpdcConst.IState.W:IUpdcConst.IState.E );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
			if( StringUtils.equals( fromOrder.getSTATE(), IUpdcConst.IState.W ) /*流程订单待回滚机制处理*/){
				IProfessionalTemplate.ICompetenceOffer fromUpdcwm = fromOrder.getORDER().getCOMPETENCE();
				if( log.isDebugEnabled() ) log.debug("ucmframe exception rollback worflow [" + fromOrder.getORDER_ID() + 
						"," + fromUpdcwm.getID() + "," + fromUpdcwm.getNAME() +"]" );
				IUpdcFactory.getIUpdwfSV().applySFRollBack(fromOrder, 
						fromTASK, 
						fromRollBack, 
						aContext);
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskHistory(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskHistory(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromOrder.setSTATE( IUpdcConst.IState.E );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ITaskSRV#finishSFTaskClaim(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdffwmOffer finishSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdffwmOffer fromHUMAN = null;
		try
		{
			IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute fromUpffxm = null;
			ISystemTemplate.IImplCapital fromJAVA = fromUpdcpm.getPROGRAM().getIMPLCLASS();
			fromUpffxm = IUpdcFactory.getIUpdosSV().getSFUpdbmClaim(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUpdcpm, 
					aEXCEPTION, 
					aContext);
			if( fromUpffxm == null ){
				ExceptionFactory.throwIllegal("IOS0011043", new String[] {
						fromUpdfwm.getPLATFORM().getID(),
						fromUpdfwm.getOPERATE().getCATEGORY() });
			}
			fromHUMAN = new IOVUpdffwmOffer(fromUpffxm.getDISTRIBUTE() , 
					fromUpffxm.getCOMPOSITE(), 
					fromJAVA.getIMPLCLASS() );
			fromHUMAN.setCONFIGURE( fromUpffxm );
		}
		finally{
			
		}
		return fromHUMAN;
	}
}
