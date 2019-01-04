package com.ai.sacenter.core.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.core.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IOrderRsRspHome;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpdcpmGroup;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-4-8</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpmSRVImpl extends UpdcEclipseImpl implements IUpdcpmSRV {
	public UpdcpmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskClaim(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdffwmOffer fromUpdcmpt = null;
			ISystemTemplate.IUpdbpmOffer fromUpdbm = fromTASK.getORDER().getSUBFLOW();
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptDistribute( fromUpdbm != null?fromUpdbm.getPROGRAM():null );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpdcpmUtils.ICustom.wrap(fromOrder, fromTASK, fromUpdcmpt, aEXCEPTION);
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext);
				if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpdcpm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#finishSFTaskClaim(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdffwmOffer finishSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdffwmOffer fromUpdpgm = null;
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFTaskClaim(fromOrder, fromTASK, fromUpdfwm, aEXCEPTION, aContext);
			if( fromUpdcpm != null ){
				try
				{
					IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
					ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
					IUpdcpmCapital fromImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
					fromUpdpgm = (IOVUpdffwmOffer)ReflectUtils.IReflect.invokeMethod(fromImpl, 
							fromJAVA.getMETHOD(), 
							new Object[]{fromOrder, 
						                 fromTASK, 
						                 fromUpdfwm,
						                 fromUpdcpm,
						                 aEXCEPTION,
						                 aContext}, 
						    new Class[]{IOVOrderPentium.class, 
						                IOVTaskPentium.class, 
						                IOVUpdspmLife.class, 
						                IOVUpdcpmOffer.class, 
						                SFException.class, 
						                IUpdcContext.class});
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null ;}
		}
		return fromUpdpgm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskCompensa(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFTaskCompensa(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IOVUpfwmResponse fromNetWork, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdfmptOffer fromUpdcmpt = null;
			ISystemTemplate.IUpdbpmOffer fromUpdbm = fromTASK.getORDER().getSUBFLOW();
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCompensation( fromUpdbm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpdcpmUtils.ICustom.wrap(fromOrder, fromTASK, fromUpdcmpt, fromNetWork, aEXCEPTION);
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext);
				if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#finishSFTaskNetWork(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFTaskNetWork(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromNetWork, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromRespond = null;
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromRespond = getSFTaskRespond(fromTASK, fromUpdfwm, fromNetWork, aEXCEPTION, aContext);
			fromUpdcpm = getSFTaskCompensa(fromOrder, fromTASK, fromNetWork, aEXCEPTION, aContext);
			if( fromUpdcpm != null ){
				java.lang.Object _compensation = null;
				IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
				ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
				fromUpdcpm.setPLWK_ASKING( fromNetWork, fromRespond );
				IUpdcpmCapital fromImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
				_compensation = ReflectUtils.IReflect.invokeMethod(fromImpl, 
						fromJAVA.getMETHOD(), 
						new Object[]{fromOrder, 
					                 fromTASK, 
					                 fromUpdfwm,
					                 fromUpdcpm,
					                 aEXCEPTION,
					                 aContext}, 
						new Class[]{IOVOrderPentium.class, 
				                IOVTaskPentium.class, 
				                IOVUpdspmLife.class,
				                IOVUpdcpmOffer.class,
				                SFException.class,
				                IUpdcContext.class});
				if( _compensation != null ){ fromRespond.setFAILURE( Boolean.FALSE ); }
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
		return fromRespond;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskRespond(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse getSFTaskRespond(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IPlatformTemplate.IUpffmsOffer aConfigure = null;
			IPlatformTemplate.IUpffmOffer fromUpfm = null;
			String fromCODING = fromTASK.getPLWK_CODING();
			if( aEXCEPTION != null ) fromCODING = aEXCEPTION.getFaultCode();
			fromUpfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromTASK.getPLATFORM() );
			if( aEXCEPTION != null ) fromUpfm = UpdcUtils.ISubFlow.getPLATFORM( aEXCEPTION );
			aConfigure = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( fromCODING );
			fromASK = SystemUtils.ICustom._wrap(fromTASK, 
					aConfigure, 
					aEXCEPTION);
			fromASK.setRspHome( fromUpfm.getID() );
		}
		finally{
			
		}
		return fromASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskRespond(java.lang.Object, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse getSFTaskRespond(Object fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromOSS = null;
		try
		{
			IPlatformTemplate.IUpffmsOffer fromRespond = null;
			IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			if( aEXCEPTION != null /*系统级网元异常*/){
				fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer(aEXCEPTION, 
						fromUpfom.getCATEGORY(), 
						fromUpffm.getID() );
			}
			else if( fromNetWork == null || fromNetWork.isSUCCEED()/*网元指令成功*/){
				fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( IUpdcConst.IUpdfx.SUCCEED );
			}
			else if( fromNetWork.isFAILURE() && fromNetWork.isRsRspNull()/*业务级网元异常但未反馈代码*/){
				fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( IUpdcConst.IUpdfx.UNKNOWN );
			}
			else/*网元异常但反馈异常代码*/{
				SFException _exception = ExceptionFactory.getRsRsp(fromNetWork.getRspCode(), 
						fromNetWork.getRspDesc(), 
						fromUpfom.getCATEGORY(), 
						fromNetWork.getRspHome() != null?fromNetWork.getRspHome():fromUpffm.getID() );
				fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( _exception );
			}
			fromOSS = SystemUtils.ICustom._wrap(fromTASK, 
					fromUpffm,
					fromRespond, 
					fromNetWork, 
					aEXCEPTION);
		}
		finally{
			
		}
		return fromOSS;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskExtend(com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOrderRsRspHome getSFTaskExtend(IOVOrderResponse fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOrderRsRspHome fromExtend = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromRspHome = null;
			IPlatformTemplate.IUpffmsOffer fromRespond = null;
			IOrderRsRspHome fromRsRspHome = fromRequest.getRESULT();
			fromExtend = new IOrderRsRspHome( fromRsRspHome );
			fromExtend.setRspHome( IUpdcConst.IUpfwm.IUpfm.ucmframe );
			fromRspHome = SystemUtils.ISystem.getSFUpfgkmNetWork( fromUpdcpm );
			if( fromRspHome.isEXTEND()/*外部系统*/){
				SFException aEXCEPTION = ExceptionFactory.getRsRsp(fromRsRspHome.getRspCode(), 
						fromRsRspHome.getRspDesc(), 
						fromRspHome.getID() );
				fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( aEXCEPTION );
				fromExtend.setRspCode( fromRespond != null && fromRespond.isSUBFLOW()?
						fromRespond.getID():IUpdcConst.IUpdfx.REMOTE    );
				fromExtend.setRspHome( IUpdcConst.IUpfwm.IUpfm.ucmframe );
			}
		}
		finally{
			
		}
		return fromExtend;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskException(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFTaskException(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdfcwmOffer fromUpdcmpt = null;
			ISystemTemplate.IUpdbpmOffer fromUpdbm = fromTASK.getORDER().getSUBFLOW();
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptSubFlow( fromUpdbm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpdcpmUtils.ICustom.wrap(fromOrder, fromTASK, fromUpdcmpt, aEXCEPTION);
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext);
				if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() );}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#finishSFTaskException(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskException(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFTaskException(fromOrder, fromTASK, fromUpdfwm, aEXCEPTION, aContext);
			if( fromUpdcpm == null/*异常转抛异常策略[正常流程发生网元指令异常]*/){
				if( log.isDebugEnabled() ) log.debug( fromTASK.getTASK_ID() + " 异常转抛异常策略[业务系统异常界面]" );
				IUpdcFactory.getITaskSV().finishSFTaskException(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			else/*异常报竣策略组件[正常流程发生网元指令异常]*/{
				IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
				ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
				if (log.isDebugEnabled())
					log.debug(fromTASK.getTASK_ID() + "\t"
							+ fromPROGRAM.getCOMPONENT().getID() + "\t"
							+ fromPROGRAM.getCOMPONENT().getNAME());
				IUpdcpmCapital fromImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
				ReflectUtils.IReflect.invokeMethod(fromImpl, 
						fromJAVA.getMETHOD(), 
						new Object[]{ fromOrder, 
					                  fromTASK, 
					                  fromUpdfwm, 
					                  fromUpdcpm,
					                  aEXCEPTION, 
					                  aContext }, 
						new Class[]{ IOVOrderPentium.class, 
					                 IOVTaskPentium.class, 
					                 IOVUpdspmLife.class, 
					                 IOVUpdcpmOffer.class, 
					                 SFException.class, 
					                 IUpdcContext.class });
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFUpdcmqComplete(com.ai.sacenter.core.valuebean.IOVQueuePentium, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpdcmqComplete(IOVQueuePentium fromQueue, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptQueue( fromQueue.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromQueue, fromUpdcmpt, aEXCEPTION );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromQueue.getPROGRAM() ) );
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#finishSFUpdcmqComplete(com.ai.sacenter.core.valuebean.IOVQueuePentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdcmqComplete(IOVQueuePentium fromQueue, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFUpdcmqComplete(fromQueue, null, aContext);
			if( fromUpdcpm != null ){
				try
				{
					IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
					ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
					fromQueue.getORDER().setCOMPLETE( fromPROGRAM.getCOMPONENT() );
					IUpdcpmCapital fromImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
					ReflectUtils.IReflect.invokeMethod(fromImpl, 
							fromJAVA.getMETHOD(), 
							new Object[]{fromQueue,
						                 fromUpdcpm,
						                 aContext},
						    new Class[]{IOVQueuePentium.class, 
						                IOVUpdcpmOffer.class, 
						                IUpdcContext.class});
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#getSFTaskRollBack(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFTaskRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdfbpmOffer fromUpdcmpt = null;
			ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptRollBack( fromUpdbpm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromOrder, fromTASK, fromUpdcmpt, aEXCEPTION );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog( fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext );
				if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcpmSRV#finishSFTaskRollBack(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFTaskRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium fromPentium[] = null;
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFTaskRollBack(fromOrder, fromTASK, aEXCEPTION, aContext);
			if( fromUpdcpm != null ){
				IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
				UpfsvcManager.getRocket().beginTransaction();
				try
				{
					IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.ORDER , fromOrder );
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.TASK , fromTASK );
					ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
					IUpdcpmCapital fromImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
					fromPentium = (IOVTaskPentium[])ReflectUtils.IReflect.invokeMethod(fromImpl, 
							fromJAVA.getMETHOD(), 
							new Object[]{fromOrder, 
						                 fromTASK, 
						                 fromUpdcpm,
						                 aEXCEPTION,
						                 fromLDAP}, 
						    new Class[]{IOVOrderPentium.class, 
						                IOVTaskPentium.class, 
						                IOVUpdcpmOffer.class, 
						                SFException.class, 
						                IUpdcContext.class});
					UpfsvcManager.getRocket().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					UpfsvcManager.getRocket().rollbackTransaction();
					throw exception;
				}
				finally{
					if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
				}
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
		return fromPentium;
	}
}
