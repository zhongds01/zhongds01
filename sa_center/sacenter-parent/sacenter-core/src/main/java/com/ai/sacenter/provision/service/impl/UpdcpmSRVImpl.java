package com.ai.sacenter.provision.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IUpdcpmGroup;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpmSRVImpl extends UpdcEclipseImpl implements IUpdcpmSRV {
	public UpdcpmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmRespond(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond(IOVUpfwmOrder fromUpfwm,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			if( aEXCEPTION == null ) {
				fromRespond = fromUpfwm.getORDER().getRespond();
			} 
			else{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				fromUpffm = UpdcUtils.ISubFlow.getPLATFORM( aEXCEPTION );
				fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( aEXCEPTION.getFaultCode() , 
						fromUpffm.getID() );
				if( fromRespond == null ) {
					fromRespond = new IPlatformTemplate.IUpffmsOffer(fromUpffm,
							aEXCEPTION);
				}
			}
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmRespond(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.IUpdcContext)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond(IOVUpfwmOrder fromUpfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			IOVUpfwmOrder.IUpfwmOfferHome fromOfferHome = fromUpfwm.getORDER();
			IPlatformTemplate.IUpffmOffer fromUpffm = fromOfferHome.getBottom().getPLATFORM();
			IPlatformTemplate.IUpffmOperate fromUpfom = fromOfferHome.getBottom().getOPERATE();
			if( StringUtils.isBlank( fromOfferHome.getRspHome() ) == false ){
				fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromOfferHome.getRspHome() );
			}
			fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer(fromOfferHome.getRspCode(), 
					fromUpfom.getCATEGORY(), 
					fromUpffm.getID());
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmComplete(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpfwmComplete(IOVUpfwmOrder fromUpfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptComplete( fromUpfwm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				IUpdcpmGroup fromGroup = null;
				try
				{
					fromUpdcpm = UpfwmUtils.ICustom.wrap( fromUpfwm, fromUpdcmpt, null );
					IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
					fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdcmpt.getID(), 
							fromUpdcpm.getSUBFLOW(), 
							aContext);
					if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
				}
				finally{
					if( fromGroup != null ){ fromGroup = null; }
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#finishSFUpfwmComplete(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmComplete(IOVUpfwmOrder fromUpfwm,
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpfm = null;
			IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
			ISystemTemplate.IImplCapital fromCapital = fromUpdcpmHome.getIMPLCLASS();
			fromUpfm = CenterUtils.ICustom.getSFCenterNetWork( fromCapital.getIMPLCLASS() );
			try
			{
				IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
				ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
						fromCapital.getMETHOD(), 
						new Object[]{ fromUpfwm, 
					                  fromUpdcpm,
					                  aContext }, 
						new Class[]{ IOVUpfwmOrder.class , 
					                 IOVUpdcpmOffer.class, 
					                 IUpdcContext.class });
			}
			catch( java.lang.Exception aEXCEPTION ){
				log.error( aEXCEPTION.getMessage(), aEXCEPTION );
				ExceptionFactory.throwException( fromUpfm.getID(), aEXCEPTION );
			}
			finally{
				
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmRespond(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpfwmRespond(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			fromUpffm = UpdcUtils.ISubFlow.getPLATFORM(aEXCEPTION);
			fromRespond = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer(aEXCEPTION, 
					fromUpfom.getCATEGORY(), 
					fromUpffm.getID() );
			if( fromRespond == null /*构造网元级反馈规范*/){
				fromRespond = new IPlatformTemplate.IUpffmsOffer( aEXCEPTION );
			}
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmException(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpfwmException(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptPlatform( fromUpfwm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpfwmUtils.ICustom.wrap(fromUpfwm, fromUpdcmpt, aEXCEPTION);
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog( fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext );
				if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#finishSFUpfwmException(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmException(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFUpfwmException(fromUpfwm, fromUpdfwm, aEXCEPTION, aContext);
			if( fromUpdcpm != null /*异常报竣策略组件[异常归档策略适配器]*/ ){
				IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
				ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
				IUpdcpmCapital fromImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
				ReflectUtils.IReflect.invokeMethod(fromImpl, 
						fromJAVA.getMETHOD(), 
						new Object[]{ fromUpfwm, 
					                  fromUpdfwm, 
					                  fromUpdcpm, 
					                  aEXCEPTION , 
					                  aContext }, 
						new Class[]{ IOVUpfwmOffer.class, 
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
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmOffice(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdbpmOffice getSFUpfwmOffice(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdbpmOffice fromOffice = null;
		try
		{
			fromOffice = new IOVUpdbpmOffice( fromTASK );
			UpdbpmUtils.ICustom._wrap( fromOrder, fromOffice );
			ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
			if( fromUpdbpm != null && StringUtils.isBlank( fromUpdbpm.getCOMPLEX() ) == false ){
				ISystemTemplate.IUpfgkmOfficeX fromOfficeX = null;
				IOVOfferPentium fromOfferHome = fromTASK.getORDER().getOFFER();
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpdbpm.getCOMPLEX(), 
						fromOfferHome.getORDER().getOFFER(), 
						fromOffice.getSUBFLOW().getSUBFLOW(), 
						aContext);
				ClassUtils.IClass.transfer(fromOffice.getSUBFLOW().getSUBFLOW(), fromOffice.getSUBFLOW() );
				fromOfficeX = CenterUtils.getSFUpfgkmOfficeX( fromOffice.getSUBFLOW().getBILL_ID(),
						fromOffice.getSUBFLOW().getHEADNUM(),
						fromOffice.getSUBFLOW().getCATEGORY() );
				if( fromOfficeX != null ){ fromOffice.getSUBFLOW().setCOMPONENT( fromOfficeX ); }
			}
		}
		finally{

		}
		return fromOffice;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmMapping(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpfwmMapping(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdffsmOffer fromUpdcmpt = UpdcpmUtils.getMAPPING( fromUpfwm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpfwmUtils.ICustom.wrap( fromUpfwm, fromUpdcmpt, null );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext);
				ClassUtils.IMerge.merge( fromGroup.getPROGRAM().getGROUP(), fromUpdcpmHome.getSUBFLOW() );
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#getSFUpfwmComposite(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpfwmComposite(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdffsmOffer fromUpdcmpt = UpdcpmUtils.getCOMPOSITE( fromUpfwm.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpfwmUtils.ICustom.wrap( fromUpfwm, fromUpdcmpt, null );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdcmpt.getID(), 
						fromUpdcpm.getSUBFLOW(), 
						aContext);
				ClassUtils.IMerge.merge( fromGroup.getPROGRAM().getGROUP(), fromUpdcpmHome.getSUBFLOW() );
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV#finishSFUpfwmOffer(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxOffer finishSFUpfwmOffer(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxOffer fromUpffmx = null;
		try
		{
			class SFUpffmxOfferImpl{
				public SFUpffmxOfferImpl(){
					super();
				}
			}
			SFUpffmxOfferImpl fromUpffmxImpl = new SFUpffmxOfferImpl();
			try
			{
				fromUpffmx = new IOVUpffmxOffer( fromUpfwm, fromUpfwm.getORDER().getSUBFLOW() );
				IProgramTemplate.IUpdffsmOffer fromUpdcmpt = UpdcpmUtils.getMAPPING( fromUpfwm.getPROGRAM() );
				if( fromUpdcmpt != null ){
					IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromUpdcmpt.getID(), 
							fromUpfwm.getORDER().getSUBFLOW(), 
							fromUpffmx.getMAPPING().getMAPPING(), 
							aContext);
					if( fromUpfom != null && StringUtils.isBlank( fromUpfom.getCOMPLEX() ) == false ){
						IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain( fromUpfom.getCOMPLEX(), 
								fromUpfwm.getORDER().getSUBFLOW(), 
								fromUpffmx.getMAPPING().getMAPPING(), 
								aContext );
					}
				}
				fromUpdcmpt = UpdcpmUtils.getCOMPOSITE( fromUpfwm.getPROGRAM() );
				if( fromUpdcmpt != null ){
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpdcmpt.getID(), 
							fromUpfwm.getORDER().getSUBFLOW(), 
							fromUpffmx.getMAPPING().getCOMPOSITE(),
							aContext);
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}
}
