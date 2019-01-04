package com.ai.sacenter.receive.order.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderBase;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.util.UpdbfxUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdCentrex;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVUpffmxDepend;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOfferX;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OrdMixSRVImpl extends UpdcEclipseImpl implements IOrdMixSRV {
	public OrdMixSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(String fromCATALOG,
			String fromBUSINES, 
			String fromORIGINATE, 
			String fromCATEGORY) throws RemoteException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			IProfessionalTemplate.IBusinesOffer fromBUSINESS = null;
			IProfessionalTemplate.IBusinesCombine fromBusinesX = null;
			IProfessionalTemplate.ICompetenceBusines fromUpdcp = null;
			fromBUSINESS = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromCATALOG, 
					fromBUSINES, 
					fromORIGINATE, 
					fromCATEGORY );
			if( fromBUSINESS != null ){
				fromUpdcpm = new IUpfgkmOfferHome( null );
				fromUpdcp = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxCompete( fromBUSINESS.getCOMPETENCE() );
				fromUpdcpm.getCATALOG().setBUSINES( fromBUSINESS );
				fromUpdcpm.getCATALOG().setCOMPETENCE( fromUpdcp );
				if( StringUtils.isBlank( fromBUSINESS.getPROGRAM() ) == false ){
					fromBusinesX = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxKernel( fromBUSINESS.getPROGRAM() );
					fromUpdcpm.getCATALOG().setPROGRAM( fromBusinesX );
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFExpireBusines(com.ai.sacenter.receive.valuebean.IOVMsgFUser)
	 */
	public IUpfgkmOfferHome getSFExpireBusines(IOVMsgFUser fromMsgFUser) throws RemoteException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFMsgFBusines(fromMsgFUser.getCATALOG(), 
					IUpdbfsConst.IUpdbm.IBusines.EXPIRE, 
					IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_EXPIRE, 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVMocketExigence fromExigence) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			IProfessionalTemplate.IBusinesOffer fromBUSINESS = null;
			fromBUSINESS = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromExigence.getCATALOG_ID(), 
					fromExigence.getBUSINESS_ID(), 
					fromExigence.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
			if( fromBUSINESS != null ){
				fromUpdcpm = new IUpfgkmOfferHome( fromExigence );
				fromUpdcpm.getCATALOG().setBUSINES( fromBUSINESS );
				if( StringUtils.isBlank( fromBUSINESS.getPROGRAM() ) == false ){
					IProfessionalTemplate.IBusinesCombine fromBusinesX = null;
					fromBusinesX = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxKernel( fromBUSINESS.getPROGRAM() );
					fromUpdcpm.getCATALOG().setPROGRAM( fromBusinesX );
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVMsgFExigence fromExigence) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			if( fromExigence.getORDER().getROCKET() != null ){
				fromUpdcpm = getSFMsgFBusines( fromExigence.getORDER().getROCKET() );
			}
			else if( fromExigence.getORDER().getORDER().size() > 0 ){
				for( java.util.Iterator<IOVMsgFOrderBase> itera = fromExigence.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrderBase fromOsOrderItem = (IOVMsgFOrderBase)itera.next();
					fromUpdcpm = getSFMsgFBusines( fromOsOrderItem );
					if(  fromUpdcpm == null ){ break; }
				}
			}
			if( fromUpdcpm == null ){
				fromUpdcpm = getSFMsgFBusines(IUpdbfsConst.IUpdbm.ICatalog.RECEIVE, 
						IUpdbfsConst.IUpdbm.IBusines.RECEIVE, 
						IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_RECEIVE, 
						IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.common.IUpdfmxExpire)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IUpdfmxExpire fromUpdfmx) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			IProfessionalTemplate.IBusinesOffer __business__ = null;
			__business__ = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromUpdfmx.getCATALOG(), 
					fromUpdfmx.getBUSINESS(), 
					fromUpdfmx.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
			if( __business__ == null ){
				__business__ = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromUpdfmx.getCATALOG(), 
						IUpdbfsConst.IUpdbm.IBusines.EXPIRE, 
						IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_EXPIRE, 
						IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
			}
			if( __business__ != null ){
				IProfessionalTemplate.IBusinesCombine _businessx_ = null;
				fromUpdcpm = new IUpfgkmOfferHome( fromUpdfmx );
				fromUpdcpm.getCATALOG().setBUSINES   ( __business__ );
				fromUpdcpm.getCATALOG().setCOMPETENCE( UpdcpmUtils.getCOMPETENCE( __business__.getCOMPETENCE() ) );
				if( StringUtils.isBlank( __business__.getPROGRAM() ) == false ){
					_businessx_ = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxKernel( __business__.getPROGRAM() );
					fromUpdcpm.getCATALOG().setPROGRAM( _businessx_ );
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFComptel(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence)
	 */
	public IProfessionalTemplate.IBusinesOffer getSFMsgFComptel(IOVRocketExigence fromRequest) throws SFException, Exception {
		IProfessionalTemplate.IBusinesOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromRequest.getCATALOG(), 
					fromRequest.getBUSINESS(), 
					fromRequest.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFComptel(com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence)
	 */
	public IProfessionalTemplate.IBusinesOffer getSFMsgFComptel(IOVMocketExigence fromExigence) throws SFException, Exception {
		IProfessionalTemplate.IBusinesOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxBusines(fromExigence.getCATALOG_ID(), 
					fromExigence.getBUSINESS_ID(), 
					fromExigence.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVRocketExigence fromMsgF) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFMsgFBusines(fromMsgF.getCATALOG(), 
					fromMsgF.getBUSINESS(), 
					fromMsgF.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFComplete(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence)
	 */
	public IUpfgkmOfferHome getSFMsgFComplete(IOVRocketExigence fromRequest) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFMsgFBusines(fromRequest.getCATALOG(), 
					fromRequest.getBUSINESS(), 
					fromRequest.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_COMPLETE );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVOrderRequest fromRequest) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFMsgFBusines(fromRequest.getCATALOG(), 
					fromRequest.getBUSINESS(), 
					fromRequest.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.receive.valuebean.IOVMsgFRequest)
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVMsgFRequest fromRequest) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFMsgFBusines(fromRequest.getCATALOG(), 
					fromRequest.getBUSINESS(), 
					fromRequest.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFUrgencyBusines(com.ai.sacenter.receive.valuebean.IOVMsgFRequest)
	 */
	public IUpfgkmOfferHome getSFUrgencyBusines(IOVMsgFRequest fromRequest) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFMsgFBusines(fromRequest.getCATALOG(), 
					fromRequest.getBUSINESS(), 
					fromRequest.getORIGINATOR(), 
					IUpdbfsConst.IUpdbm.ICache.PROGRAM_URGENCY );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFBusines(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome)
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFMsgFBusines(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm) throws SFException, Exception {
		IProfessionalTemplate.IBusinesCatalog fromCatalog = null;
		try
		{
			String _compatible[] = new String[]{ String.valueOf( fromOffer.getPRODUCT_ID() ), 
					String.valueOf( fromOffer.getCOMPETE_ID() ), 
					String.valueOf( fromOffer.getSERVICE_ID() ) };
			IProfessionalTemplate.IBusinesOffer fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
			for( int index = 0; _compatible != null && index < _compatible.length; index++ ){
				fromCatalog = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxCatalog(fromBusines.getCATALOG(), 
						fromBusines.getBUSINES(), 
						_compatible[index], 
						IUpdbfsConst.IUpdbm.ICache.PROGRAM_PLATFORM);
				if( fromCatalog != null ){ break; }
			}
			
		}
		finally{
			
		}
		return fromCatalog;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFReceive(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome)
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFMsgFReceive(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm) throws SFException, Exception {
		IProfessionalTemplate.IBusinesCatalog fromCatalog = null;
		try
		{
			String _compatible[] = new String[]{ String.valueOf( fromOffer.getPRODUCT_ID() ), 
					String.valueOf( fromOffer.getCOMPETE_ID() ), 
					String.valueOf( fromOffer.getSERVICE_ID() ) };
			IProfessionalTemplate.IBusinesOffer fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
			for( int index = 0; _compatible != null && index < _compatible.length; index++ ){
				fromCatalog = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxCatalog(fromBusines.getCATALOG(), 
						fromBusines.getBUSINES(), 
						_compatible[index], 
						IUpdbfsConst.IUpdbm.ICache.PROGRAM_RECEIVE);
				if( fromCatalog != null ){ break; }
			}
		}
		finally{
			
		}
		return fromCatalog;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFPriority(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfsBusines)
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority(IOVMsgFRequest fromRequest, 
			ISystemTemplate.IUpdbfsBusines fromBusines) throws SFException, Exception {
		ISystemTemplate.IUpdbfsOffer fromPriority = fromBusines;
		try
		{
			class SFUpdbfsGroupImpl{
				public SFUpdbfsGroupImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromMsgFCentrex
				 * @param fromBusines
				 * @param fromPriority
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public ISystemTemplate.IUpdbfsOffer finishSFMsgFLimite( IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser, 
						IOVMsgFCentrex fromMsgFCentrex, 
						ISystemTemplate.IUpdbfsBusines fromBusines,
						ISystemTemplate.IUpdbfsOffer fromPriority) throws SFException,Exception{
					try
					{
						ISystemTemplate.IUpdbfsCatalog fromCatalog[] = null;
						IProfessionalTemplate.IProductOffer fromGroup = null;
						for( java.util.Iterator<IOVMsgFOffer> itera = fromMsgFCentrex.getCENTREX().iterator(); itera.hasNext(); ){
							IOVMsgFOffer fromMsgFOffer = (IOVMsgFOffer)itera.next();
							fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( fromMsgFOffer.getSERVICE_ID() );
							if( fromGroup == null ) continue;
							fromCatalog = fromBusines.getPROGRAM( fromGroup.getCOMPETE() );
							for( int index = 0; fromCatalog != null && index < fromCatalog.length; index++ ){
								if( fromCatalog[index].getPRIORITY() > fromPriority.getPRIORITY() ){
									fromPriority = fromCatalog[index];
								}
							}
						}
					}
					finally{
						
					}
					return fromPriority;
				}
			}
			SFUpdbfsGroupImpl fromGroupImpl = new SFUpdbfsGroupImpl();
			try
			{
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					for( java.util.Iterator<IOVMsgFOrdCentrex> iterap = fromMsgFUser.getORDER().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)iterap.next();
						fromPriority = fromGroupImpl.finishSFMsgFLimite(fromRequest, 
								fromMsgFUser, 
								ordercentrex, 
								fromBusines, 
								fromPriority);
					}
				}
			}
			finally{
				if( fromGroupImpl != null ){ fromGroupImpl = null; }
			}
		}
		finally{
			
		}
		return fromPriority;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFPriority(com.ai.sacenter.receive.valuebean.IOVMsgFRequest)
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority( IOVMsgFRequest fromRequest ) throws SFException, Exception {
		ISystemTemplate.IUpdbfsOffer fromLimite = null;
		try
		{
			ISystemTemplate.IUpdbfsCombine fromGroup = null;
			fromGroup = IUpdcfgFactory.getIBasicSV().getSFUpdbfsOffer(fromRequest.getCATALOG(),
					fromRequest.getBUSINESS(), 
					fromRequest.getBATCHES(),
					fromRequest.getCHANNEL() );
			if( fromGroup == null || fromGroup.getSUBFLOW().size() <= 0 ){
				ISystemTemplate.IUpdbfsLimite fromDefault = SystemUtils.ISystem.getSFUpffmxOffer();
				fromLimite = new ISystemTemplate.IUpdbfsOffer( fromDefault.getPRIORITY(), 
						fromDefault.getCOMPOSITE(), 
						fromDefault.getNAME() );
			}
			else{
				ISystemTemplate.IUpdbfsBusines fromBusines = fromGroup.getLITTLE();
				if( fromBusines != null && fromBusines.getPROGRAM().size() <= 0 ){
					fromLimite = fromBusines;
				}
				else if( fromBusines != null && fromBusines.getPROGRAM().size() > 0 ){
					fromLimite = getSFMsgFPriority(fromRequest, fromBusines);
				}
			}
		}
		finally{
			
		}
		return fromLimite;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#getSFMsgFPriority(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence)
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority( IOVRocketExigence fromMsgF ) throws SFException, Exception {
		ISystemTemplate.IUpdbfsOffer fromLimite = null;
		try
		{
			ISystemTemplate.IUpdbfsCombine fromGroup = null;
			fromGroup = IUpdcfgFactory.getIBasicSV().getSFUpdbfsOffer(fromMsgF.getCATALOG(),
					fromMsgF.getBUSINESS(),
					fromMsgF.getBATCHES(),
					fromMsgF.getCHANNEL() );
			if( fromGroup == null || fromGroup.getSUBFLOW().size() <= 0 ){
				ISystemTemplate.IUpdbfsLimite fromDefault = SystemUtils.ISystem.getSFUpffmxOffer();
				fromLimite = new ISystemTemplate.IUpdbfsOffer( fromDefault.getPRIORITY(), 
						fromDefault.getCOMPOSITE(), 
						fromDefault.getNAME() );
			}
			else{
				ISystemTemplate.IUpdbfsBusines fromBusines = fromGroup.getLITTLE();
				if( fromBusines != null && fromBusines.getPROGRAM().size() <= 0 ){
					fromLimite = fromBusines;
				}
				else if( fromBusines != null && fromBusines.getPROGRAM().size() > 0 ){
					IUpfgkmOfferHome fromUpdcpm = getSFMsgFBusines( fromMsgF );
					IOVMsgFRequest fromRequest = OrderUtils.ICustom._wrap(fromMsgF, fromUpdcpm);
					fromLimite = getSFMsgFPriority( fromRequest, fromBusines );
				}
			}
		}
		finally{
			
		}
		return fromLimite;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFMsgFReceive(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFOffer[] finishSFMsgFReceive(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromMsgFOffer, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVMsgFOffer fromOffer[] = new IOVMsgFOffer[]{fromMsgFOffer};
		IUpdcContext fromLDAP = null;
		try
		{
			IProfessionalTemplate.IBusinesCatalog fromCatalog = null;
			fromCatalog = getSFMsgFReceive(fromRequest, fromMsgFOffer, fromUpdcpm);
			if( fromCatalog != null ){
				ISystemTemplate.IImplCapital fromCapital = null;
				fromLDAP = UpdbfxUtils.ISystem.getPROGRAM(fromRequest, fromMsgFOffer, fromCatalog, aContext);
				fromCapital = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromCatalog.getIMPLCLASS() );
				IBusinesCapital fromBusines = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
				fromOffer = (IOVMsgFOffer[])ReflectUtils.IReflect.invokeMethod(fromBusines, 
						fromCapital.getMETHOD(), 
						new Object[]{fromRequest,
								     fromMsgFOffer,
					                 fromUpffmx,
					                 fromUpdcpm,
					                 fromLDAP},
						new Class[]{IOVMsgFRequest.class,
									IOVMsgFOffer.class,
									IOVUpffmxRequest.class,
					                IUpfgkmOfferHome.class,
					                IUpdcContext.class});
			}
		}
		finally{
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFMsgFOffer(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFOffer[] finishSFOfferNature(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVMsgFOffer fromNature[] = null;
		try
		{
			class SFMsgFNatureImpl{
				public SFMsgFNatureImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromOffer
				 * @param fromNature
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFOffer[] finishSFMsgFNature( IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromOffer,
						Object fromNature, 
			            IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFOffer fromGroup[] = null;
					try
					{
						if( ClassUtils.IClass.isArray( fromNature ) ){
							fromGroup = (IOVMsgFOffer[])fromNature;
						}
						else if( ClassUtils.IClass.isList( fromNature ) ){
							fromGroup = (IOVMsgFOffer[])((java.util.List<IOVMsgFOffer>)fromNature).toArray( 
									new IOVMsgFOffer[]{} );
						}
						else if( fromNature != null ){
							fromGroup = new IOVMsgFOffer[]{ (IOVMsgFOffer)fromNature };
						}
					}
					finally{
						
					}
					return fromGroup;
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromOffer
				 * @param fromCatalog
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFOffer[] finishSFMsgFNature( IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromOffer,
						IProfessionalTemplate.IBusinesCatalog fromCatalog,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFOffer fromGroup[] = null;
					IUpdcContext fromLDAP = null;
					try
					{
						ISystemTemplate.IImplCapital fromCapital = null;
						fromLDAP = UpdbfxUtils.ISystem.getPROGRAM(fromRequest, fromOffer, fromCatalog, aContext);
						fromCapital = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromCatalog.getIMPLCLASS() );
						IBusinesCapital fromBusines = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						Object fromNature = ReflectUtils.IReflect.invokeMethod(fromBusines, 
								fromCapital.getMETHOD(), 
								new Object[]{fromRequest,
							                 fromOffer,
							                 fromUpffmx,
							                 fromUpdcpm,
							                 fromLDAP},
								new Class[]{IOVMsgFRequest.class,
							                IOVMsgFOffer.class,
							                IOVUpffmxRequest.class,
							                IUpfgkmOfferHome.class,
							                IUpdcContext.class});
						fromGroup = finishSFMsgFNature(fromRequest, 
								fromOffer, 
								fromNature, 
								fromLDAP);
					}
					finally{
						if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
					}
					return fromGroup;
				}
			}
			SFMsgFNatureImpl fromNatureImpl = new SFMsgFNatureImpl();
			try
			{
				IProfessionalTemplate.IBusinesCatalog fromCatalog = null;
				fromCatalog = getSFMsgFBusines(fromRequest, fromOffer, fromUpdcpm);
				if( fromCatalog == null  ){
					fromNature = fromNatureImpl.finishSFMsgFNature(fromRequest, 
							fromOffer, 
							fromOffer, 
							aContext);
				}
				else{
					fromNature = fromNatureImpl.finishSFMsgFNature(fromRequest, 
							fromOffer, 
							fromCatalog,
							fromUpffmx,
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromNatureImpl != null ){ fromNatureImpl = null; }
			}
		}
		finally{
			
		}
		return fromNature;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFOsStatusTrail(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser)
	 */
	public void finishSFOsStatusTrail(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVOrderUser fromOrdUser) throws SFException, Exception {
		try
		{
			class SFUserOsStatusImpl{
				private IUpffxUser _os_user;
				public SFUserOsStatusImpl( ISystemTemplate.IEnumGroup fromGroup ){
					super();
					_os_user = new IUpffxUser( fromGroup );
				}
				
				/**
				 * 根据开通停机规范获取当前停机位值
				 * @param fromOsStatus 用户停开机位串
				 * @param fromOsState 开通停机规范
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public String _jj_os_status( String fromOsStatus, ISystemTemplate.IEnumWrapper fromOsState ) throws SFException,Exception{
					String fromOsByte = null;
					try
					{
						int fromOsBytes = Integer.parseInt( fromOsState.getID() );
						if( StringUtils.isBlank( fromOsStatus ) == false && fromOsStatus.length() >= 
								fromOsBytes && fromOsBytes > 0 ){
							fromOsByte = String.valueOf( fromOsStatus.charAt( fromOsBytes - 1 ) );
						}
					}
					finally{
						
					}
					return fromOsByte;
				}
				
				/**
				 * 开通用户停复机状态位转换
				 * @param fromCOMPETE 停机类型
				 * @param fromState 停机订购状态
				 * @param fromOsUser 开通用户
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IUpffxOsState _os_status_digit( String fromCOMPETE, String fromState, IUpffxUser fromOsUser ) throws SFException,Exception{
					IUpffxOsState _os_state = null;
					try
					{
						_os_state = (IUpffxOsState)fromOsUser._os_user.get( fromCOMPETE );
						if( _os_state == null ){
							_os_state = new IUpffxOsState( fromCOMPETE, fromState );
						}
						else if( StringUtils.equals( fromState, IUpdbfsConst.IState.D ) ){
							_os_state._status = fromState;
						}
						else if( StringUtils.equals( fromState, IUpdbfsConst.IState.U ) ){
							_os_state._status = fromState;
						}
						else if( StringUtils.equals( _os_state._status, fromState ) == false &&
								StringUtils.contains( _os_state._status, new String[]{ 
										IUpdbfsConst.IState.U, IUpdbfsConst.IState.D }) == false ){
							StringBuilder fromOsBit = new StringBuilder( fromState );
							fromOsBit.insert( 0,  _os_state._status );
							if( StringUtils.equals( fromOsBit.toString(), IUpdbfsConst.IState.EC ) ){
								_os_state._status = IUpdbfsConst.IState.U;
							}
							else if( StringUtils.equals( fromOsBit.toString(), IUpdbfsConst.IState.CE ) ){
								_os_state._status = IUpdbfsConst.IState.U;
							}
						}
					}
					finally{
						
					}
					return _os_state;
				}
				
				/**
				 * 开通用户停机变化状态位转换
				 * @param fromDigitByte 停机位变化值
				 * @param fromOsState 开通停机规范
				 * @param fromState 停机订购状态
				 * @param fromOrdUser 开通用户
				 * @throws SFException
				 * @throws Exception
				 */
				public void _os_status_offer( String fromDigitByte, ISystemTemplate.IEnumWrapper fromOsState, String fromState, IUpffxUser fromOsUser ) throws SFException,Exception{
					try
					{
						/*开通用户停机位串转换[用户停复机]*/
						fromOsUser.mergeAsOsStatus( new IUpffxOsGate(fromDigitByte, fromState, fromOsState) );
						/*开通用户停机位状转换[用户停复机]*/
						String aCOMPLEX[] = StringUtils.split( fromOsState.getTARGET(), ";" );
						for( int index = 0; aCOMPLEX != null && index < aCOMPLEX.length; index++ ){
							IUpffxOsState _os_state = _os_status_digit(aCOMPLEX[index], fromState, fromOsUser);
							fromOsUser._os_user.put( _os_state._compete, _os_state );
						}
					}
					finally{
						
					}
				}
				/**
				 * 根据停机变化前和变化后分析开通停机订购或退订
				 * @param fromPreOsStatus 停机变化前
				 * @param fromOsStatus 停机变化后
				 * @param fromOsState 开通停机规范
				 * @throws SFException
				 * @throws Exception
				 */
				public void _os_status_change( String  fromPreOsStatus, 
						String fromOsStatus, 
						ISystemTemplate.IEnumWrapper fromOsState) throws SFException,Exception{
					try
					{
						String fromPreByte = _jj_os_status(fromPreOsStatus, fromOsState );
						String fromAftByte = _jj_os_status(fromOsStatus, fromOsState );
						if( fromPreByte == null && StringUtils.equals( fromAftByte, "1") ){
							_os_status_offer(fromAftByte, fromOsState, IUpdbfsConst.IState.D, _os_user );
						}
						else if( StringUtils.isBlank( fromPreByte ) && StringUtils.equals( fromAftByte, "1") ){
							_os_status_offer(fromAftByte, fromOsState, IUpdbfsConst.IState.C, _os_user);
						}
						else if( StringUtils.equals( fromPreByte , "0") && StringUtils.equals( fromAftByte , "1") ){
							_os_status_offer(fromAftByte, fromOsState, IUpdbfsConst.IState.C, _os_user);
						}
						else if( StringUtils.equals( fromPreByte , "1") && StringUtils.equals( fromAftByte , "0") ){
							_os_status_offer(fromAftByte, fromOsState, IUpdbfsConst.IState.E, _os_user);
						}
						else if( StringUtils.equals( fromPreByte , "1") && StringUtils.equals( fromAftByte , "1") ){
							_os_status_offer(fromAftByte, fromOsState, IUpdbfsConst.IState.U, _os_user);
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromOrdUser
				 * @throws SFException
				 * @throws Exception
				 */
				public void _os_status_final(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IOVOrderUser fromOrdUser) throws SFException, Exception{
					try
					{
						//停机类型[单听BAOCUSER停机STOPUSER[C开机E停机U停机D停机]/开通停机位串OS_STATUS]
						IUpffxOsStatus fromOsStatus = _os_user.getAsOsStatus();
						if( fromOsStatus != null ){ fromOrdUser.setOS_STATUS( fromOsStatus.getOsStatus() ); }
						for( java.util.Iterator<IUpffxOsState> itera = _os_user._os_user.values().iterator(); itera.hasNext(); ){
							IUpffxOsState fromOsUser = (IUpffxOsState)itera.next();
							IOVOrderOfferX fromOrdOffer = new IOVOrderOfferX( fromOsUser._compete, fromOsUser._status );
							fromOrdUser.getNATURE().put( fromOrdOffer.getCOMPETE(), fromOrdOffer );
						}
						//最终停机类型[OS_STATE][0正常1管理停机2营业停机3帐务停机4营业挂失5营业解挂]
						IUpffxOsGate fromOsState = _os_user.getAsOsState();
						if( fromOsState != null ){ fromOrdUser.setOS_STATE( fromOsState._os_state ); }
						//停开机位订退[VMICMOTB][0开机1停机]/停开机位类型[VMICMOST][开通测停机位类型]
						IUpffxOsGate fromOsGate = _os_user.getAsChange();
						if( fromOsGate != null ){
							String fromUpffx[][] = new String[][]{{IUpdbfsConst.IUpdbm.IUser.VMICMOTB, fromOsGate._os_gate },
								{IUpdbfsConst.IUpdbm.IUser.VMICMOST, fromOsGate._os_type }};
							for( int index = 0; fromUpffx != null && index < fromUpffx.length; index++ ){
								IOVOrderOfferX fromOrdOffer = new IOVOrderOfferX( fromUpffx[index][0], fromUpffx[index][1] );
								fromOrdUser.getNATURE().put( fromOrdOffer.getCOMPETE(), fromOrdOffer );
							}
						}
					}
					finally{
						
					}
				}
				
				class IUpffxUser{
					/*开通停机位串[初始值][00000000000000000000]*/
					private IUpffxOsStatus _os_status;
					/*停开机规则*/
					private ISystemTemplate.IEnumGroup _group = null;
					/*停机类型[单听BAOCUSER停机STOPUSER[C开机E停机U停机D停机]]*/
					private java.util.Map<String,IUpffxOsState>  _os_user = new java.util.HashMap<String,IUpffxOsState>();
					/*停机位变化*/
					private java.util.List<IUpffxOsGate> _os_change  = new java.util.ArrayList<IUpffxOsGate>();
					/*停机位全量*/
					private java.util.List<IUpffxOsGate> _os_subflow = new java.util.ArrayList<IUpffxOsGate>();
					public IUpffxUser(ISystemTemplate.IEnumGroup group){
						super();
						_group = group;
						ISystemTemplate.IEnumWrapper _os_state = getGroup( "0" );
						if( _os_state != null && StringUtils.isBlank( _os_state.getTARGET() ) == false ){ 
							_os_status = new IUpffxOsStatus( _os_state.getTARGET() );
						}
					}
					
					/**
					 * 
					 * @param fromINDEX
					 * @return
					 */
					public ISystemTemplate.IEnumWrapper getGroup( String fromINDEX ){
						return _group.getENUM( fromINDEX );
					}
					
					/**
					 * 
					 * @return
					 */
					public IUpffxOsStatus getAsOsStatus(){
						return _os_status;
					}
					
					/**
					 * 
					 * @param fromOsGate
					 */
					public void mergeAsOsStatus( IUpffxOsGate fromOsGate ){
						try
						{
							_os_subflow.add( fromOsGate );
							if( fromOsGate.isCHANGE() /*停机位变化*/){ _os_change.add( fromOsGate ); }
							java.util.Collections.sort( _os_subflow );
							java.util.Collections.sort( _os_change  );
							if( _os_status != null && fromOsGate.isSTOPUSER() /*单停或停机*/){
								_os_status.mergeAsOsStatus( fromOsGate._os_type, fromOsGate._os_gate );
							}
						}
						finally{
							
						}
					}
					
					/**
					 * 获取当前用户停开机位
					 * @return
					 */
					public IUpffxOsGate getAsChange(){
						IUpffxOsGate fromOsGate = null;
						try
						{
							if( _os_change != null && _os_change.size() > 0 ){ 
								fromOsGate = (IUpffxOsGate)_os_change.get( 0 ); 
							}
							if( fromOsGate == null && _os_subflow != null && _os_subflow.size() > 0 ){
								fromOsGate = (IUpffxOsGate)_os_subflow.get( 0 ); 
							}
						}
						finally{
							
						}
						return fromOsGate;
					}
					
					/**
					 * 获取最终用户停开机状态
					 * @return
					 */
					public IUpffxOsGate getAsOsState(){
						IUpffxOsGate fromOsGate = null;
						try
						{
							for( java.util.Iterator<IUpffxOsGate> itera = _os_subflow.iterator(); itera.hasNext(); ){
								IUpffxOsGate _OsGate = (IUpffxOsGate)itera.next();
								if( _OsGate.isSTOPUSER() ){ fromOsGate = _OsGate; break; }
							}
						}
						finally{
							
						}
						return fromOsGate;
					}
					
					/* (non-Javadoc)
					 * @see java.lang.Object#toString()
					 */
					public String toString() {
						String _xml = null;
						try
						{
							org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
							org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
							org.dom4j.Element fromOsUser = fromRoot.addElement( "OsUser" );
							if( _os_status != null ){ _os_status.toXML( fromOsUser ); }
							if( _os_user != null && _os_user.size() > 0 ){
								for( java.util.Iterator<IUpffxOsState> itera = _os_user.values().iterator(); itera.hasNext(); ){
									IUpffxOsState fromUpffx = (IUpffxOsState)itera.next();
									fromUpffx.toXML( fromOsUser );
								}
							}
							org.dom4j.Element fromOsChange = fromOsUser.addElement( "CHANGE" );
							if( _os_change != null && _os_change.size() > 0 ){
								for( java.util.Iterator<IUpffxOsGate> itera = _os_change.iterator(); itera.hasNext(); ){
									IUpffxOsGate fromUpffx = (IUpffxOsGate)itera.next();
									fromUpffx.toXML( fromOsChange.addElement( "FUTURE" ) );
								}
							}
							org.dom4j.Element fromOsSubFlow = fromOsUser.addElement( "SUBFLOW" );
							if( _os_subflow != null && _os_subflow.size() > 0 ){
								for( java.util.Iterator<IUpffxOsGate> itera = _os_subflow.iterator(); itera.hasNext(); ){
									IUpffxOsGate fromUpffx = (IUpffxOsGate)itera.next();
									fromUpffx.toXML( fromOsSubFlow.addElement( "FUTURE" ) );
								}
							}
							_xml = XmlUtils.IXml._format( document.asXML() );
						}
						catch( java.lang.Exception exception ){
							_xml = super.toString();
						}
						finally{
							
						}
						return _xml;
					}
					
				}
				class IUpffxOsGate implements java.lang.Comparable<Object>{
					/*CRM测停机位置*/
					private long   _id;
					/*优先级[固定为5位数字,从低到高][如为空则CRM测停机位置为准，计算规则10000+CRM测停机位置]*/
					private long   _priority;
					/*用户停机类型[0正常1管理停机2营业停机3帐务停机4营业挂失5营业解挂]*/
					private String _os_state;
					/*停机位订购[C订购E退订U不变D停机]*/
					private String _os_status;
					/*停机位变化[0开机1停机]*/
					private String _os_gate ;
					/*停机位类型[开通测停机位类型]*/
					private String _os_type;
					public IUpffxOsGate( String digit_byte, String os_status, ISystemTemplate.IEnumWrapper os_state ){
						super();
						_id        = Long.parseLong( os_state.getID() );
						_priority  = 10000 + Integer.parseInt( os_state.getID() );
						if( StringUtils.isBlank( os_state.getEXTEND_ATTR_B() ) == false ){
							_priority = Integer.parseInt( os_state.getEXTEND_ATTR_B() );
						}
						_os_state  = StringUtils.equals( digit_byte, "1" )?os_state.getCOMPLEX():IUpdbfsConst.IUpdbm.IUser.IOsState.NORMAL;
						_os_gate   = digit_byte;
						_os_status = os_status;
						_os_type   = String.valueOf( Integer.parseInt( os_state.getEXTEND_ATTR_A() ) -1 );
						
					}
					
					/**
					 * 停机位变化
					 * @return
					 */
					public boolean isCHANGE(){
						return StringUtils.contains( _os_status, new String[]{IUpdbfsConst.IState.C, IUpdbfsConst.IState.E} );
					}
					
					/**
					 * 是否处于停机状态
					 * @return
					 */
					public boolean isSTOPUSER(){
						return StringUtils.equals( _os_state, IUpdbfsConst.IUpdbm.IUser.IOsState.NORMAL ) == false;
					}
					
					/**
					 * 
					 * @param _element
					 */
					public void toXML( org.dom4j.Element _element ){
						try
						{
							_element.addElement( "VMICMIID" ).setText( String.valueOf( _id )         );
							_element.addElement( "VMICMPRI" ).setText( String.valueOf( _priority   ) );
							_element.addElement( "VMICMOSS" ).setText( String.valueOf( _os_state  ) );
							_element.addElement( "VMICMGATE").setText( String.valueOf( _os_status ) );
							_element.addElement( "VMICMOTB" ).setText( String.valueOf( _os_gate   ) );
							_element.addElement( "VMICMOST" ).setText( String.valueOf( _os_type   ) );
						}
						finally{
							
						}
					}

					/* (non-Javadoc)
					 * @see java.lang.Object#equals(java.lang.Object)
					 */
					public boolean equals(Object objective) {
						IUpffxOsGate fromGate = (IUpffxOsGate)objective;
						long doEqual = _priority - fromGate._priority;
						if( doEqual == 0 ){ doEqual = _id - fromGate._id; }
						return doEqual == 0?true:false;
					}
					
					/* (non-Javadoc)
					 * @see java.lang.Comparable#compareTo(java.lang.Object)
					 */
					public int compareTo(Object objective) {
						IUpffxOsGate fromGate = (IUpffxOsGate)objective;
						long doCompare = fromGate._priority - _priority;
						if( doCompare == 0 ){ doCompare = fromGate._id - _id; }
						return doCompare == 0?0:(doCompare > 0?1:-1);
					}
					
				}
				class IUpffxOsState{
					/*服务产品*/
					private String _compete;
					/*服务产品状态*/
					private String _status;
					public IUpffxOsState( String compete, String status ){
						super();
						_compete = compete;
						_status  = status ;
					}
					
					/**
					 * 
					 * @param _element
					 */
					public void toXML( org.dom4j.Element _element ){
						_element.addElement( _compete ).setText( _status );
					}
				}
				class IUpffxOsStatus{
					/*最终用户停机位串*/
					private StringBuilder _os_status;
					public IUpffxOsStatus( String os_status ){
						super();
						_os_status = new StringBuilder( os_status );
					}
					
					/**
					 * @return the _os_status
					 */
					public String getOsStatus() {
						return _os_status.toString();
					}
					
					/**
					 * 
					 * @param OsType
					 * @param OsGate
					 */
					public void mergeAsOsStatus( String OsType, String OsGate ){
						try
						{
							_os_status.setCharAt( Integer.parseInt( OsType ), OsGate.charAt( OsGate.length() - 1 ) );
						}
						finally{
							
						}
					}
					
					/**
					 * 
					 * @param _element
					 */
					public void toXML( org.dom4j.Element _element ){
						_element.addElement( "VMICMOTS" ).setText( _os_status.toString() );
					}
				}
			}
			SFUserOsStatusImpl fromUpfxImpl = null;
			try
			{
				ISystemTemplate.IEnumGroup fromGroup = null;
				fromOrdUser.setOS_STATE( IUpdbfsConst.IUpdbm.IUser.IOsState.NORMAL );
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFEnumGroup( IUpdbfsConst.IUpdbm.ICache.PROGRAM_OSSTATUS );
				if( fromGroup != null && ( StringUtils.isBlank( fromMsgFUser.getOS_STATUS() ) == false ) ){
					fromUpfxImpl = new SFUserOsStatusImpl( fromGroup );
					String fromOsStatus[] = new String[]{ StringUtils.isBlank( fromMsgFUser.getPRE_OS_STATUS() )?
							null:fromMsgFUser.getPRE_OS_STATUS(), StringUtils.isBlank( fromMsgFUser.getOS_STATUS() )?
									null:fromMsgFUser.getOS_STATUS() };
					for( int index = 0 ; fromOsStatus[1] != null && index < fromOsStatus[1].length() ; index++ ){
						ISystemTemplate.IEnumWrapper fromOsState = fromUpfxImpl._os_user.getGroup( String.valueOf( index + 1 ) );
						if( fromOsState == null || StringUtils.isBlank( fromOsState.getCOMPLEX() ) ) continue;
						fromUpfxImpl._os_status_change( fromOsStatus[0], fromOsStatus[1], fromOsState );
					}
					fromUpfxImpl._os_status_final(fromRequest, fromMsgFUser, fromOrdUser);
				}
			}
			finally{
				if( fromUpfxImpl != null ){ fromUpfxImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFOfferDepend(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOfferDepend(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromOffer, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpffmxDepend fromDepend = fromUpffmx.getUSER().getUSER().getDEPENDENT();
		    if( fromDepend != null && fromDepend.getGROUP() != null && fromDepend.getGROUP().size() > 0 ){
		    	IProfessionalTemplate.IProductCatalog fromCatalog[] = null;
		    	fromCatalog = fromDepend.getGROUP( fromOffer );
		    	if( fromCatalog != null && fromCatalog.length > 0 ){
		    		fromDepend.getINSTANCE().add( fromOffer );
		    		for( int index = 0 ; fromCatalog != null && index < fromCatalog.length; index++ ){
						if( StringUtils.equals( fromCatalog[index].getCATEGORY(), 
								IUpdbfsConst.IUpdbm.IProduct.PROGRAM_DEPEND_COMPETE ) ){
							fromDepend.submitIOddOffer( fromOffer, fromCatalog[index] );
						}
						else if( StringUtils.equals( fromCatalog[index].getCATEGORY(), 
								IUpdbfsConst.IUpdbm.IProduct.PROGRAM_DEPEND_GROUP ) ){
							fromDepend.submitIGrpOffer( fromOffer, fromCatalog[index] );
						}
					}
		    	}
		    }
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFOfferGroup(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFOffer[] finishSFOfferGroup(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromMsgFOffer, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		CarbonList<IOVMsgFOffer> fromNetWork = new CarbonList<IOVMsgFOffer>();
		try
		{
			IProfessionalTemplate.IProductGroup fromGroup = null;
			IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
			fromGroup = IOrderFactory.getIProductSV().getSFProductGroup(fromRequest, 
					fromMsgFUser, 
					fromUpdcpm);
			if( fromGroup == null ){ fromNetWork.add( fromMsgFOffer ); }
			else{
				java.util.List<IProfessionalTemplate.IProductCatalog> fromCOMBINE = UpdbfsUtils.ICustom.getCOMBINE(fromRequest, fromMsgFOffer, fromGroup);
				if( fromCOMBINE == null ){ fromNetWork.add( fromMsgFOffer ); }
				else{
					for( java.util.Iterator<IProfessionalTemplate.IProductCatalog> itera = fromCOMBINE.iterator(); itera.hasNext(); ){
						IProfessionalTemplate.IProductCatalog fromCatalog = (IProfessionalTemplate.IProductCatalog)itera.next();
						IOVMsgFOffer fromOffer = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						if( StringUtils.equals( fromCatalog.getCATEGORY(), IUpdbfsConst.IUpdbm.IProduct.PROGRAM_GROUP_COMPETE ) /*同组服务模型*/){
							fromOffer.setCOMPETE_ID( Long.parseLong( fromCatalog.getEXTEND_ATTR_B() ) );
						}
						else if( StringUtils.equals( fromCatalog.getCATEGORY(), IUpdbfsConst.IUpdbm.IProduct.PROGRAM_GROUP_PRICE ) /*同组产品模型*/ ){
							fromOffer.setPRODUCT_ID( Long.parseLong( fromCatalog.getEXTEND_ATTR_A() ) );
							if( StringUtils.isBlank( fromCatalog.getEXTEND_ATTR_B() ) == false ){
								fromOffer.setCOMPETE_ID( Long.parseLong( fromCatalog.getEXTEND_ATTR_B() ) );
							}
						}
						fromNetWork.add( fromOffer );
					}
				}
			}
		}
		finally{
			
		}
		return (IOVMsgFOffer[])fromNetWork.toArray( new IOVMsgFOffer[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFOfferCompete(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOfferCompete(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IProfessionalTemplate.IProductComptel fromComptel = null;
			IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
			IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
			fromComptel = IOrderFactory.getIProductSV().getSFProductNature(fromRequest, 
					fromNature, 
					fromUpdcpm);
			IOVOrderOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap(fromRequest, 
					fromMsgFUser, 
					fromNature,
					fromComptel,
					fromUpdcpm);
			if( fromUpffmx.getUSER() != null && fromOrdOffer != null ){
				UpdbfsUtils.ISystem._groupAsCompete( fromOrdUserHome.getPLATFORM(),
						fromOrdUserHome.getUSER(), 
						fromOrdOffer);
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFOfferPrice(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOfferPrice(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IProfessionalTemplate.IProductComptel fromComptel = null;
			IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
			IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
			fromComptel = IOrderFactory.getIProductSV().getSFProductNature(fromRequest, 
					fromNature, 
					fromUpdcpm);
			IOVOrderOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap(fromRequest, 
					fromMsgFUser, 
					fromNature,
					fromComptel,
					fromUpdcpm);
			if( fromOrdOffer != null && fromOrdUserHome.getUSER() != null ){
				UpdbfsUtils.ISystem._groupAsProduct( fromOrdUserHome.getPLATFORM(),
						fromOrdUserHome.getUSER(), 
						fromOrdOffer);
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFOfferMultle(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOfferMultle(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IProfessionalTemplate.IProductComptel fromComptel = null;
			IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
			IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
			fromComptel = IOrderFactory.getIProductSV().getSFProductNature(fromRequest, 
					fromNature, 
					fromUpdcpm);
			IOVOrderOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap(fromRequest, 
					fromMsgFUser, 
					fromNature,
					fromComptel,
					fromUpdcpm);
			if( fromOrdOffer != null && fromOrdUserHome.getUSER() != null ){
				UpdbfsUtils.ISystem._groupAsMultle(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getUSER(), 
						fromOrdOffer);
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV#finishSFMsgFNetWork(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFMsgFNetWork(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromMsgFOffer, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFOfferNetWorkImpl{
				public SFOfferNetWorkImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFOffer
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFOffer[] finishSFMsgFGroup(IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromMsgFOffer,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					CarbonList<IOVMsgFOffer> fromGroup = new CarbonList<IOVMsgFOffer>();
					try
					{
						IOVMsgFOffer fromOffer[] = finishSFOfferGroup(fromRequest, 
								fromMsgFOffer, 
								fromUpdcpm, 
								aContext);
						for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
							IOVMsgFOffer fromNature[] = finishSFOfferNature(fromRequest, 
									fromOffer[index],
									fromUpffmx,
									fromUpdcpm, 
									aContext);
							ClassUtils.IMerge.mergeAsIgnore( fromNature, fromGroup );
						}
					}
					finally{
						
					}
					return (IOVMsgFOffer[])fromGroup.toArray( new IOVMsgFOffer[]{} );
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromNature
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFNature(IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromNature,
			            IOVUpffmxRequest fromUpffmx,
			            IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IProfessionalTemplate.IProductComptel fromSubject = null;
						fromSubject = IOrderFactory.getIProductSV().getSFProductNature(fromRequest, 
								fromNature, 
								fromUpdcpm);
						if( fromSubject != null && fromSubject.isPRICE() /*单产品类开通*/){
							finishSFOfferPrice(fromRequest, 
									fromNature, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
						else if( fromSubject != null && fromSubject.isMULTLE() /*多次订购类开通*/){
							finishSFOfferMultle(fromRequest, 
									fromNature, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
						else/*单服务类开通*/{
							finishSFOfferCompete(fromRequest, 
									fromNature, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
					}
					finally{
						
					}
				}
			}
			SFOfferNetWorkImpl fromNetWorkImpl = new SFOfferNetWorkImpl();
			try
			{
				IOVMsgFOffer fromNature[] = null;
				fromNature = fromNetWorkImpl.finishSFMsgFGroup(fromRequest, 
						fromMsgFOffer,
						fromUpffmx,
						fromUpdcpm, 
						aContext);
				if( fromNature != null && fromNature.length > 0 ){
					finishSFOfferDepend(fromRequest, 
							fromMsgFOffer, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					for( int index = 0; fromNature != null && index < fromNature.length; index++ ){
						fromNetWorkImpl.finishSFMsgFNature(fromRequest, 
								fromNature[index], 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromNetWorkImpl != null ){ fromNetWorkImpl = null; }
			}
		}
		finally{
			
		}
	}

}
