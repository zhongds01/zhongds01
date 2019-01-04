package com.ai.sacenter.cache.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.interfaces.IUpdcpmSRV;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jeval.JevalSTKEngine;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpdcpmGroup;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpmSRVImpl extends DialectSystemImpl implements IUpdcpmSRV {
	public UpdcpmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbfxBusines(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IProfessionalTemplate.IBusinesOffer getSFUpdbfxBusines(String fromCATALOG,
			String fromBUSINES, 
			String fromORIGINATE, 
			String fromCATEGORY) throws SFException, Exception {
		IProfessionalTemplate.IBusinesOffer fromBusines = null;
		try
		{
			String fromUpffmx[][] = new String[][]{{fromCATALOG, fromBUSINES, fromORIGINATE},
				                                   {fromCATALOG, fromBUSINES, "*"          },
				                                   {"*"        , fromBUSINES, fromORIGINATE},
				                                   {"*"        , fromBUSINES, "*"          }};
		    for( int index = 0; fromUpffmx != null && index < fromUpffmx.length; index++ ){
		    	String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES, 
						new String[]{fromUpffmx[index][0], 
						             fromBUSINES, 
						             fromUpffmx[index][2], 
						             fromCATEGORY});
				fromBusines = (IProfessionalTemplate.IBusinesOffer)hget( IUpdcConst.ICache.IIUpdfbmcI, fromINDEX );
				if( fromBusines != null ){ break; }
		    }
		}
		finally{
			
		}
		return fromBusines;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbfxKernel(java.lang.String)
	 */
	public IProfessionalTemplate.IBusinesCombine getSFUpdbfxKernel(String fromPROGRAM) throws SFException, Exception {
		IProfessionalTemplate.IBusinesCombine fromBusinesX = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES_KERNEL, new String[]{ fromPROGRAM } );
			fromBusinesX = (IProfessionalTemplate.IBusinesCombine)hget( IUpdcConst.ICache.IIUpdfbmcI, fromINDEX );
		}
		finally{
			
		}
		return fromBusinesX;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbfxKernel(java.lang.String, java.lang.String)
	 */
	public IProfessionalTemplate.IBusinesKernel getSFUpdbfxKernel(String fromCATEGORY,
			String fromPROGRAM) throws SFException, Exception {
		IProfessionalTemplate.IBusinesKernel fromBusinesX = null;
		try
		{
			IProfessionalTemplate.IBusinesCombine fromGroup = null;
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES_KERNEL, new String[]{ fromPROGRAM } );
			fromGroup = (IProfessionalTemplate.IBusinesCombine)hget( IUpdcConst.ICache.IIUpdfbmcI, fromINDEX );
			if( fromGroup != null ){
				fromBusinesX = (IProfessionalTemplate.IBusinesKernel)fromGroup.getPROGRAM().get( fromCATEGORY );
			}
		}
		finally{
			
		}
		return fromBusinesX;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbfxCatalog(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFUpdbfxCatalog(String fromCATALOG,
			String fromBUSINES, 
			String fromPRODUCT, 
			String fromCATEGORY) throws SFException, Exception {
		IProfessionalTemplate.IBusinesCatalog fromBusines = null;
		try
		{
			String fromNAME[][] = new String[][]{ {fromCATALOG, fromBUSINES},
					                              {"*"        , fromBUSINES},
					                              {"*"        , "*"        }};
			for( int index = 0; index < fromNAME.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES_COMPETE , 
						new String[]{fromNAME[index][0], fromNAME[index][1], fromPRODUCT, fromCATEGORY});
				fromBusines = (IProfessionalTemplate.IBusinesCatalog)hget( 
						IUpdcConst.ICache.IIUpdfbmcI, fromINDEX );
				if( fromBusines != null ){ break; }
			}
		}
		finally{
			
		}
		return fromBusines;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbfxCompete(java.lang.String)
	 */
	public IProfessionalTemplate.ICompetenceBusines getSFUpdbfxCompete(String fromMODULE) throws SFException, Exception {
		IProfessionalTemplate.ICompetenceBusines fromBusines = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_TEMPLATE, 
					new String[]{fromMODULE});
			fromBusines = (IProfessionalTemplate.ICompetenceBusines)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
			if( fromBusines == null ) ExceptionFactory.throwServiceBus( "IOS0011019", new String[]{fromMODULE} );
		}
		finally{
			
		}
		return fromBusines;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpOffer(long)
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpOffer(long fromPRODUCT) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_BASIC , 
					new String[]{ String.valueOf( fromPRODUCT ) } );
			fromUpdcpm = (IProfessionalTemplate.IProductOffer)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpComptel(java.lang.String)
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpComptel(String fromPRODUCT) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_COMPTEL, 
					new String[]{ fromPRODUCT } );
			fromUpdcpm = (IProfessionalTemplate.IProductOffer)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpSubject(java.lang.String)
	 */
	public IProfessionalTemplate.IProductComptel getSFUpdcpSubject(String fromPRODUCT) throws SFException, Exception {
		IProfessionalTemplate.IProductComptel fromSubject = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_SUBJECT, 
					new String[]{ fromPRODUCT } );
			fromSubject = (IProfessionalTemplate.IProductComptel)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
		}
		finally{
			
		}
		return fromSubject;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpGroup(java.lang.String)
	 */
	public IProfessionalTemplate.IProductGroup getSFUpdcpGroup(String fromGroup) throws SFException, Exception {
		IProfessionalTemplate.IProductGroup fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_GROUP, 
					new String[]{ fromGroup } );
			fromUpdcpm = (IProfessionalTemplate.IProductGroup)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpCombine(java.lang.String, java.lang.String)
	 */
	public IProfessionalTemplate.IProductCombine getSFUpdcpCombine(String fromPRODUCT,
			String fromCATEGORY) throws SFException, Exception {
		IProfessionalTemplate.IProductCombine fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_COMBINE, 
					new String[]{ fromCATEGORY, fromPRODUCT } );
			fromUpdcpm = (IProfessionalTemplate.IProductCombine)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpBusines(java.lang.String, java.lang.String)
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpBusines(String fromCATALOG,
			String fromBUSINES) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_BASIC, 
					new String[]{ fromBUSINES } );
			fromUpdcpm = (IProfessionalTemplate.IProductOffer)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
			if( fromUpdcpm == null ){
				ExceptionFactory.throwIllegal("IOS0011020", new String[]{ fromBUSINES });
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpProperty(long)
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpProperty(long fromCOMPETE) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.
					I_COMPETENCE_PRODUCT_BASIC, new String[]{ String.valueOf( fromCOMPETE ) } );
			fromUpdcpm = (IProfessionalTemplate.IProductOffer)hget( 
					IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
			if( fromUpdcpm == null ){
				ExceptionFactory.throwIllegal("IOS0011020", new String[]{ String.valueOf( fromCOMPETE ) });
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcpKernel(java.lang.String)
	 */
	public IProfessionalTemplate.IComptelKernel getSFUpdcpKernel(String fromCOMPETE) throws SFException, Exception {
		IProfessionalTemplate.IComptelKernel fromUpdcpm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_KERNEL, 
					new String[]{ fromCOMPETE } );
			fromUpdcpm = (IProfessionalTemplate.IComptelKernel)hget( IUpdcConst.ICache.IIUpdcpgmI, fromINDEX );
			if( fromUpdcpm == null ){ ExceptionFactory.throwIllegal("IOS0011079", new String[]{fromCOMPETE});}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbpmOffer(java.lang.String)
	 */
	public IProfessionalTemplate.IUpdbpmOffer getSFUpdbpmOffer(String fromWORKFLOW) throws SFException, Exception {
		IProfessionalTemplate.IUpdbpmOffer fromUpdbm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_WORKFLOW , 
					new String[]{fromWORKFLOW} );
			fromUpdbm = (IProfessionalTemplate.IUpdbpmOffer)hget( IUpdcConst.ICache.IIUpdfbpmI, aINDEX );
			if( fromUpdbm == null ) ExceptionFactory.throwIllegal("IOS0011035", new String[]{fromWORKFLOW});
		}
		finally{
			
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdbpmCatalog(java.lang.String)
	 */
	public ISystemTemplate.IUpdbpmOffer getSFUpdbpmCatalog(String fromSUBFLOW) throws SFException, Exception {
		ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BPELFLOW, 
					new String[]{ ClassUtils.getINDEX( fromSUBFLOW ) } );
			fromUpdbm = (ISystemTemplate.IUpdbpmOffer)hget( IUpdcConst.ICache.IIUpdfbpmI, aINDEX );
			if( fromUpdbm == null ) ExceptionFactory.throwIllegal("IOS0011038", new String[]{fromSUBFLOW});
		}
		finally{
			
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpffwmOffer(java.lang.String)
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpffwmOffer(String fromMODULE) throws SFException, Exception {
		IProgramTemplate.IUpdffsmOffer fromUpffwm= null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_COMPONENT, 
					new String[]{ fromMODULE } );
			fromUpffwm = (IProgramTemplate.IUpdffsmOffer)hget( IUpdcConst.ICache.IIUpdprgmI, fromINDEX );
			if( fromUpffwm == null ){ ExceptionFactory.throwIllegal("IOS0011055", new String[]{fromMODULE});}
		}
		finally{
			
		}
		return fromUpffwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpffxmOffer(java.lang.String, java.lang.String)
	 */
	public IProgramTemplate.IUpdffgsmOffer getSFUpffxmOffer(String fromMODULE, 
			String fromFEATURE) throws SFException, Exception {
		IProgramTemplate.IUpdffgsmOffer fromUpffxm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_COMPONENT_MAPPING, 
					new String[]{fromMODULE, fromFEATURE} );
			fromUpffxm = (IProgramTemplate.IUpdffgsmOffer)hget( IUpdcConst.ICache.IIUpdprgmI, aINDEX );
			if( fromUpffxm == null ) ExceptionFactory.throwIllegal("IOS0011056", new String[]{fromMODULE, fromFEATURE});
		}
		finally{
			
		}
		return fromUpffxm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpffxmOffice(java.lang.String)
	 */
	public IProgramTemplate.IUpdffgsmOffer[] getSFUpffxmOffice(String fromMODULE) throws SFException, Exception {
		java.util.List fromOffice = new java.util.ArrayList();
		try
		{
			IProgramTemplate.IUpdffgsmOffer fromUpffxm = null;
			String fromOfficeX[] = new String[]{IUpdcConst.IUpdbm.IUpdbpm.BILL_ID,
					IUpdcConst.IUpdbm.IUpdbpm.SUB_BILL_ID, IUpdcConst.IUpdbm.IUpdbpm.OFFICE      };
			for( int index = 0; fromOfficeX != null && index < fromOfficeX.length; index++ ){
				String  fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_COMPONENT_MAPPING, 
						new String[]{fromMODULE, fromOfficeX[index] } );
				fromUpffxm = (IProgramTemplate.IUpdffgsmOffer)hget( IUpdcConst.ICache.IIUpdprgmI, fromINDEX );
				if( fromUpffxm != null ){ fromOffice.add( fromUpffxm ); }
			}
		}
		finally{
			
		}
		return fromOffice != null && fromOffice.size() > 0?(IProgramTemplate.IUpdffgsmOffer[])
				fromOffice.toArray( new IProgramTemplate.IUpdffgsmOffer[]{} ):null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdpgmOffer(java.lang.String)
	 */
	public IProgramTemplate.IUpdpgmOffer getSFUpdpgmOffer(String fromPROGRAM)
			throws SFException, Exception {
		IProgramTemplate.IUpdpgmOffer fromUpdpgm = null;
		try
		{
			if( StringUtils.isBlank( fromPROGRAM ) == false ){
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_PROGRAM, 
						new String[]{fromPROGRAM} );
				fromUpdpgm = (IProgramTemplate.IUpdpgmOffer)hget( IUpdcConst.ICache.IIUpdprgmI, aINDEX );
			}
		}
		finally{
			
		}
		return fromUpdpgm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptOffer(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcmpOffer getSFUpdcmptOffer( String fromCOMPONENT ) throws SFException, Exception {
		IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_COMPONENT, new String[]{ fromCOMPONENT });
			fromUpdcmpt = (IProgramTemplate.IUpdfcmpOffer)hget( IUpdcConst.ICache.IIUpdprgmI, fromINDEX );
			if( fromUpdcmpt == null ){
				ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCOMPONENT, "*" });
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptOffer(com.ai.sacenter.valuebean.IProgramTemplate.IUpdfcmpOffer, java.util.HashMap, com.ai.sacenter.common.IUpdcContext)
	 */
	public IProgramTemplate.IUpdfcmpOffer getSFUpdcmptOffer(IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
			java.util.HashMap fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpdcpmGroup fromGroup = null;
		try
		{
			if( fromUpdcmpt.getCATALOG() != null && fromUpdcmpt.getCATALOG().size() > 0 ){
				fromGroup = getSFUpdcmptCatalog(fromUpdcmpt.getID(), fromOffer, aContext);
				if( fromGroup != null && fromGroup.getPROGRAM().getGROUP().size() > 0 ){
					fromUpdcmpt = fromGroup.getPROGRAM().getPROJECT();
				}
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpdcmpt;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptCatalog(java.lang.String, java.util.Map, com.ai.sacenter.IUpdcContext)
	 */
	public IUpdcpmGroup getSFUpdcmptCatalog(String aCOMPONENT,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpdcpmGroup fromGroup = null;
		try
		{
			class SFUpdcpmGroupImpl{
				public SFUpdcpmGroupImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromUpdcmpt
				 * @param fromJEVAL
				 * @param fromGroup
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				private void _program( IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
						JevalSTKEngine fromJEVAL,
						IUpdcpmGroup fromGroup) throws SFException,Exception{
					try
					{
						if( fromUpdcmpt.getCATALOG().size() <= 0 ){
							fromGroup.getPROGRAM().getGROUP().add( fromUpdcmpt );
						}
						else if( fromGroup.getPROGRAM().getGROUP().indexOf( fromUpdcmpt ) < 0 ){
							_catalog( fromUpdcmpt, fromJEVAL, fromGroup );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromUpdcmpt
				 * @param fromOffer
				 * @param fromGroup
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				private void _catalog( IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
						JevalSTKEngine fromJEVAL,
						IUpdcpmGroup fromGroup) throws SFException,Exception{
					try
					{
						IProgramTemplate.IUpdfcmpOffer fromSubfigure = null;
						for( java.util.Iterator itera = fromUpdcmpt.getCATALOG().iterator(); itera.hasNext(); ){
							IProgramTemplate.IUpdfcmpCatalog fromCatalog = (IProgramTemplate.IUpdfcmpCatalog)itera.next();
							if( fromJEVAL.decision( fromCatalog.getCOMPLEX() ) ){
								fromSubfigure = getSFUpdcmptOffer( fromCatalog.getSUBFIGURE() );
								if( StringUtils.equals( fromCatalog.getCOMPONENT(), fromCatalog.getSUBFIGURE() ) ){
									fromGroup.getPROGRAM().getGROUP().add( fromUpdcmpt );
								}
								else{
									_program( fromSubfigure, fromJEVAL, fromGroup );
								}
							}
						}
					}
					finally{
						
					}
				}
			}
			SFUpdcpmGroupImpl fromUpdcpmImpl = new SFUpdcpmGroupImpl();
			JevalSTKEngine fromJEVAL = UpfsvcManager.getMBean().getJEVAL();
			try
			{
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = getSFUpdcmptOffer( aCOMPONENT );
				fromGroup = new IUpdcpmGroup( aCOMPONENT, fromUpdcmpt );
				fromGroup.getPROGRAM().getSUBFLOW().putAll( fromOffer );
				if( fromUpdcmpt != null && fromUpdcmpt.getCATALOG().size() <= 0 ){
					fromGroup.getPROGRAM().getGROUP().add( fromUpdcmpt );
				}
				else{
					fromJEVAL.submitVariables( fromOffer, aContext );
					fromUpdcpmImpl._program(fromUpdcmpt, 
							fromJEVAL, 
							fromGroup);
				}
			}
			finally{
				if( fromJEVAL != null ){ fromJEVAL.clearVariables(); }
				if( fromUpdcpmImpl != null ){ fromUpdcpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptMapping(java.lang.String)
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpdcmptMapping(String fromPROGRAM)
			throws SFException, Exception {
		IProgramTemplate.IUpdffsmOffer fromUpdffsm = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getMAPPING() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getMAPPING();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdffsm = (IProgramTemplate.IUpdffsmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdffsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptComposite(java.lang.String)
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpdcmptComposite(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdffsmOffer fromUpdffsm = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getCOMPOSITE() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getCOMPOSITE();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdffsm = (IProgramTemplate.IUpdffsmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdffsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptSubFlow(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptSubFlow(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromUpdcmpt = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getSUBFLOW() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getSUBFLOW();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdcmpt = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptQueue(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptQueue(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromQueue = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getQUEUE() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getQUEUE();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromQueue = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromQueue;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptRocket(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptRocket(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromRocket = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getROCKET() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getROCKET();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromRocket = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromRocket;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptComplete(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptComplete(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromUpdfcwm = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getCOMPLETE() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getCOMPLETE();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdfcwm = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdfcwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptPlatform(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptPlatform(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromUpdcmpt = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getPLATFORM() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getPLATFORM();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdcmpt = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptCompensation(java.lang.String)
	 */
	public IProgramTemplate.IUpdfmptOffer getSFUpdcmptCompensation(String fromPROGRAM)
			throws SFException, Exception {
		IProgramTemplate.IUpdfmptOffer fromUpdcmpt = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromPROGRAM != null && fromUpdpgm.getCOMPENSA() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getCOMPENSA();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdcmpt = (IProgramTemplate.IUpdfmptOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptRollBack(java.lang.String)
	 */
	public IProgramTemplate.IUpdfbpmOffer getSFUpdcmptRollBack(String fromPROGRAM)
			throws SFException, Exception {
		IProgramTemplate.IUpdfbpmOffer fromUpdcmpt = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getROLLBACK() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getROLLBACK();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdcmpt = (IProgramTemplate.IUpdfbpmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptDistribute(java.lang.String)
	 */
	public IProgramTemplate.IUpdffwmOffer getSFUpdcmptDistribute(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdffwmOffer fromUpdgma = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getDISTRIBUTE() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getDISTRIBUTE();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdgma = (IProgramTemplate.IUpdffwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdgma;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptSuggest(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptSuggest(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromUpdcmpt = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getSUGGEST() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getSUGGEST();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdcmpt = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpdcpmSRV#getSFUpdcmptExpire(java.lang.String)
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptExpire(String fromPROGRAM) throws SFException, Exception {
		IProgramTemplate.IUpdfcwmOffer fromUpdcmpt = null;
		try
		{
			IProgramTemplate.IUpdpgmOffer fromUpdpgm = getSFUpdpgmOffer( fromPROGRAM );
			if( fromUpdpgm != null && fromUpdpgm.getEXPIRE() != null ){
				IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCATALOG = fromUpdpgm.getEXPIRE();
				if( fromCATALOG.getMODULE() == null ){
					ExceptionFactory.throwIllegal("IOS0011018", new String[]{fromCATALOG.getCOMPONENT(),
							fromCATALOG.getCATEGORY() });
				}
				fromUpdcmpt = (IProgramTemplate.IUpdfcwmOffer)fromCATALOG.getMODULE();
			}
		}
		finally{
			
		}
		return fromUpdcmpt;
	}
}
