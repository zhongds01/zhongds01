package com.ai.sacenter.cache.impl;

import com.ai.aif.csf.common.exception.CsfException;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.interfaces.IUpffmSRV;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFRemoteException;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ6ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpffmSRVImpl extends DialectSystemImpl implements IUpffmSRV {
	public UpffmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmOffer()
	 */
	public IPlatformTemplate.IUpffmOffer getSFUpffmOffer() throws SFException, Exception {
		IPlatformTemplate.IUpffmOffer _network = null;
		try
		{
			_network = getSFUpffmOffer( IUpdcConst.IUpfwm.IUpfm.ucmframe );
		}
		finally{
			
		}
		return _network;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmOffer(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmOffer getSFUpffmOffer(String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffmOffer fromUpfm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_BASIC, 
					new String[]{fromPLATFORM} );
			fromUpfm = (IPlatformTemplate.IUpffmOffer)hget( IUpdcConst.ICache.IIUpfgmccI , aINDEX );
			if( fromUpfm == null ){
				ExceptionFactory.throwIllegal("IOS0011044", new String[]{fromPLATFORM});
			}
		}
		finally{
			
		}
		return fromUpfm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmNetWork(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmNetWork getSFUpffmNetWork(String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffmNetWork fromNetWork = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_NETWORK, 
					new String[]{fromPLATFORM} );
			fromNetWork = (IPlatformTemplate.IUpffmNetWork)hget( IUpdcConst.ICache.IIUpfgmccI , aINDEX );
		}
		finally{
			
		}
		return fromNetWork;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmParent(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmOffer[] getSFUpffmParent(String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffmOffer[] fromUpfm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_PARENT, 
					new String[]{fromPLATFORM} );
			java.util.List fromUpfspm = (java.util.List)hget( IUpdcConst.ICache.IIUpfgmccI , aINDEX );
			if( fromUpfspm != null ){
				fromUpfm = (IPlatformTemplate.IUpffmOffer[])fromUpfspm.toArray( 
						new IPlatformTemplate.IUpffmOffer[]{} );
			}
			else{
				fromUpfm = new IPlatformTemplate.IUpffmOffer[]{};
			}
		}
		finally{
			
		}
		return fromUpfm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmChild(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmOffer[] getSFUpffmChild(String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffmOffer[] fromUpfm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_CHILD, new String[]{fromPLATFORM} );
			java.util.List fromUpfspm = (java.util.List)hget( IUpdcConst.ICache.IIUpfgmccI , aINDEX );
			if( fromUpfspm != null ){
				fromUpfm = (IPlatformTemplate.IUpffmOffer[])fromUpfspm.toArray( new IPlatformTemplate.IUpffmOffer[]{} );
			}
			else{
				fromUpfm = new IPlatformTemplate.IUpffmOffer[]{};
			}
		}
		finally{
			
		}
		return fromUpfm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmOperate(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public IPlatformTemplate.IUpffmOperate getSFUpffmOperate(String fromOPERATE,
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception {
		IPlatformTemplate.IUpffmOperate fromUpfom = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffmx[] = getSFUpffmParent( fromUpffm.getID() );
			for( int index = 0 ; fromUpffmx != null && index < fromUpffmx.length ; index++ ){
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_OPERATE, 
						new String[]{fromUpffmx[index].getID(),fromOPERATE} );
				fromUpfom = (IPlatformTemplate.IUpffmOperate)hget( IUpdcConst.ICache.IIUpfgmccI , aINDEX ) ;
				if( fromUpfom != null ) break;
			}
			if( fromUpfom == null ) ExceptionFactory.throwIllegal("IOS0011046", new String[]{fromUpffm.getID() , fromOPERATE});
		}
		finally{
			
		}
		return fromUpfom;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmOperate(java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmOperate getSFUpffmOperate(String fromDIRECTIVE,
			String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffmOperate fromUpfom = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			IPlatformTemplate.IUpffmDirective fromUpfdfm = null;
			fromUpffm = getSFUpffmOffer( fromPLATFORM );
			if( fromUpffm != null ){
				fromUpfdfm = getSFUpffmLogical( fromDIRECTIVE, fromUpffm );
				fromUpfom = getSFUpffmOperate( fromUpfdfm.getOPERATE_(), fromUpffm );
			}
		}
		finally{
			
		}
		return fromUpfom;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmLogical(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public IPlatformTemplate.IUpffmDirective getSFUpffmLogical(String fromDIRECTIVE,
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception {
		IPlatformTemplate.IUpffmDirective fromUpfdfm = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffmx[] = getSFUpffmParent( fromUpffm.getID() );
			for( int index = 0 ; fromUpffmx != null && index < fromUpffmx.length ; index++ ){
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_DIRECTIVE, 
						new String[]{fromUpffmx[index].getID() , fromDIRECTIVE} );
				fromUpfdfm = (IPlatformTemplate.IUpffmDirective)hget( IUpdcConst.ICache.IIUpfgmccI , aINDEX );
				if( fromUpfdfm != null ) break;
			}
			if( fromUpfdfm == null ) ExceptionFactory.throwIllegal("IOS0011014", new String[]{fromUpffm.getID() , fromDIRECTIVE});
		}
		finally{
			
		}
		return fromUpfdfm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmSubFlow(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public IPlatformTemplate.IUpffbpmOffer getSFUpffmSubFlow(String fromSUBFLOW, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception {
		IPlatformTemplate.IUpffbpmOffer fromUpffbpm = null;
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_SUBFLOW, new String[]{fromSUBFLOW} );
			fromUpffbpm = (IPlatformTemplate.IUpffbpmOffer)hget( IUpdcConst.ICache.IIUpfgmccI, aINDEX );
			if( fromUpffbpm != null && fromUpffbpm.getSUBFLOW().size() > 0 ){
				IPlatformTemplate.IUpffmOffer fromUpfm[] = getSFUpffmParent( fromUpffm.getID() );
				for( int index = 0 ; fromUpfm != null && index < fromUpfm.length; index++ ){
					fromINDEX.put( fromUpfm[index].getID() , fromUpfm[index] );
				}
				for( java.util.Iterator itera = fromUpffbpm.getSUBFLOW().iterator() ; itera.hasNext() ; ){
					IPlatformTemplate.IUpffmSubFlow fromUpdfsm = (IPlatformTemplate.IUpffmSubFlow)itera.next();
					if( fromUpdfsm.isUpfdfm() == false ){
						if( fromINDEX.containsKey( fromUpdfsm.getPLATFORM() ) == false ){ 
							ExceptionFactory.throwIllegal("IOS0011047", new String[]{String.valueOf( fromUpdfsm.getID() ) , 
									fromUpdfsm.getPLATFORM() , fromUpffm.getID()} );
						}
					}
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromUpffbpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmProtocol(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmProtocol getSFUpffmProtocol(String fromPROTOCOL) throws SFException, Exception {
		IPlatformTemplate.IUpffmProtocol fromPLMM = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_PROTOCOL , 
					new String[]{ fromPROTOCOL } );
			fromPLMM = (IPlatformTemplate.IUpffmProtocol)hget( IUpdcConst.ICache.IIUpfvmfsI,  aINDEX );
			if( fromPLMM == null ){ ExceptionFactory.throwException("IOS0011045", new String[]{fromPROTOCOL} ); }
		}
		finally{
			
		}
		return fromPLMM;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmPhone(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpffmPhone(String fromBILL, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception {
		IPlatformTemplate.IUpffmPhone fromUser = null;
		try
		{
			String fromMSISDN[] = new String[]{fromBILL,"*"};
			IPlatformTemplate.IUpffmOffer fromUpffmx[] = getSFUpffmParent( fromUpffm.getID() );
			for( int index = 0; fromUpffmx != null && index < fromUpffmx.length; index++ ){
				for( int aINDEX = 0; fromMSISDN != null && aINDEX < fromMSISDN.length; aINDEX++ ){
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_OFFICE_PHONE , 
							new String[]{ fromMSISDN[aINDEX] , fromUpffmx[index].getID() } );
					fromUser = (IPlatformTemplate.IUpffmPhone)hget( IUpdcConst.ICache.IIUpfmsgtI, fromINDEX );
					if( fromUser != null ){ break; }
				}
			}
		}
		finally{
			
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmDebug(java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmDebuging getSFUpffmDebug(String fromDIRECTIVE,
			String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffmDebuging fromUpfwm = null;
		try
		{
			String fromNAME[] = new String[]{ fromDIRECTIVE, "*" };
			for( int index = 0; fromNAME != null && index < fromNAME.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_DEBUG, 
						new String[]{ fromPLATFORM, fromNAME[index] } );
				fromUpfwm = (IPlatformTemplate.IUpffmDebuging)hget( IUpdcConst.ICache.IIUpfgmccI, fromINDEX );
				if( fromUpfwm != null ){ break; }
			}
		}
		finally{
			
		}
		return fromUpfwm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffsmOffer(java.lang.String)
	 */
	public IPlatformTemplate.IUpffsmOffer getSFUpffsmOffer(String fromMODULE) throws SFException, Exception {
		IPlatformTemplate.IUpffsmOffer fromUpfgsm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_MAPPING, 
					new String[]{ fromMODULE } );
			fromUpfgsm = (IPlatformTemplate.IUpffsmOffer)hget( IUpdcConst.ICache.IIUpfgsmcI, fromINDEX );
			if( fromUpfgsm == null ){
				ExceptionFactory.throwIllegal("IOS0011042", new String[]{fromMODULE});
			}
		}
		finally{
			
		}
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpfgsmMisc(java.lang.String)
	 */
	public IUpfgsmTemplate.IUpfgsmOffer getSFUpfgsmMisc(String fromMODULE) throws SFException, Exception {
		IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_MISC,
					new String[]{ fromMODULE } );
			fromUpfgsm = (IUpfgsmTemplate.IUpfgsmOffer)hget( IUpdcConst.ICache.IIUpfgsmcI, aINDEX );
		}
		finally{
			
		}
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffxOffer()
	 */
	public java.util.Map getSFUpffxOffer() throws SFException, Exception {
		java.util.Map fromUpffxm = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_FEATURE, 
					new String[]{ IUpdcConst.IUpfwm.IUpfm.ucmframe } );
			fromUpffxm = (java.util.Map)hget( IUpdcConst.ICache.IIUpfgmccI, aINDEX );
		}
		finally{
			
		}
		return fromUpffxm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffxOffer(java.lang.String)
	 */
	public java.util.Map getSFUpffxOffer(String fromPLATFORM) throws SFException, Exception {
		java.util.Map fromUpffxm = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpfm[] = null;
			fromUpfm = getSFUpffmParent( fromPLATFORM );
			for( int index = 0 ; fromUpfm != null && index < fromUpfm.length; index++ ){
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_FEATURE, 
						new String[]{fromUpfm[index].getID()} );
				fromUpffxm = (java.util.Map)hget( IUpdcConst.ICache.IIUpfgmccI, aINDEX );
				if( fromUpffxm != null ){ break; }
			}
			if( fromUpffxm == null && StringUtils.equals( fromPLATFORM, 
					IUpdcConst.IUpfwm.IUpfm.ucmframe ) ){
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_FEATURE, 
						new String[]{ IUpdcConst.IUpfwm.IUpfm.ucmframe } );
				fromUpffxm = (java.util.Map)hget( IUpdcConst.ICache.IIUpfgmccI, aINDEX );
			}
		}
		finally{
			
		}
		return fromUpffxm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffxOffer(java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffxOffer getSFUpffxOffer(String fromFEATURE, 
			String fromPLATFORM) throws SFException, Exception {
		IPlatformTemplate.IUpffxOffer fromUpffx = null;
		try
		{
			java.util.Map fromUpffxm = getSFUpffxOffer( fromPLATFORM );
			if( fromUpffxm != null && fromUpffxm.get( fromFEATURE ) != null ){
				fromUpffx = (IPlatformTemplate.IUpffxOffer)fromUpffxm.get( fromFEATURE );
			}
		}
		finally{
			
		}
		return fromUpffx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsGroup getSFUpffmsGroup(String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsGroup fromGroup = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffmx[] = getSFUpffmParent( _platform );
			for( int index = 0 ; fromUpffmx != null && index < fromUpffmx.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_RESPOND, 
						new String[]{ fromUpffmx[index].getID()} );
				fromGroup = (IPlatformTemplate.IUpffmsGroup)hget( IUpdcConst.ICache.IIUpdfgrpI, fromINDEX );
				if( fromGroup != null ){ break; }
			}
		}
		finally{
			
		}
		return fromGroup;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(String _coding) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			fromRespond = getSFUpffmsOffer(_coding, "*", IUpdcConst.IUpfwm.IUpfm.ucmframe);
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(String _coding, String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			fromRespond = getSFUpffmsOffer(_coding, "*", _platform);
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(java.lang.String, java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(String _coding, String _category, String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			IPlatformTemplate.IUpffmsGroup fromGroup = getSFUpffmsGroup( _platform );
			if( fromGroup != null ){ fromRespond = fromGroup.getRESPOND(_coding, _category);}
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(com.ai.sacenter.SFException)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(SFException _exception) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			fromRespond = getSFUpffmsOffer(_exception, 
					_exception.getCategory() != null?_exception.getCategory():"*", 
					_exception.getOriginator() != null?_exception.getOriginator():IUpdcConst.IUpfwm.IUpfm.ucmframe );
		}
		finally{
			
		}
		return fromRespond;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(com.ai.sacenter.SFException, java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(SFException _exception, String _category, String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			IPlatformTemplate.IUpffmsCatalog fromCatalog = null;
			IPlatformTemplate.IUpffmOffer fromUpffmx = getSFUpffmOffer( _platform );
			IPlatformTemplate.IUpffmsGroup fromGroup = getSFUpffmsGroup( _platform );
			if( fromGroup == null && _exception.getOriginator() != null ){
				fromGroup = getSFUpffmsGroup( _exception.getOriginator() );
			}
			if( fromGroup == null ){
				ExceptionFactory.throwIllegal( "IOS0011070", new String[]{ _platform } );
			}
			fromCatalog = fromGroup.getCATALOG( _exception.getFaultCode(), _category );
			if( fromCatalog == null && _exception instanceof SFRemoteException ){
				fromRespond = getSFUpffmsOffer( IUpdcConst.IUpdfx.REMOTE );
			}
			else if( fromCatalog == null ){ 
				fromRespond = fromGroup.getRESPOND( _exception.getFaultCode(), _category );
			}
			else{
				fromGroup = getSFUpffmsGroup( fromCatalog.getNETWORK() );
				fromRespond = fromGroup.getRESPOND( fromCatalog.getCOMPOSITE(), _category );
			}
			if( fromRespond == null ){ fromRespond = getSFUpffmsOffer( _exception.getFaultCode() ); }
			if( fromRespond == null ){ fromRespond = new IPlatformTemplate.IUpffmsOffer( fromUpffmx, _exception );}
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(com.ai.aif.csf.common.exception.CsfException, java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(CsfException _exception, String _category, String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			IPlatformTemplate.IUpffmsCatalog fromCatalog = null;
			IPlatformTemplate.IUpffmsGroup fromGroup = getSFUpffmsGroup( _platform );
			if( fromGroup != null){
				fromCatalog = fromGroup.getCATALOG( _exception.getExceptionCode(), _category );
				if( fromCatalog != null ){
					fromRespond = getSFUpffmsOffer( fromCatalog.getCOMPOSITE() );
				}
			}
			if( fromRespond == null ){ fromRespond = getSFUpffmsOffer( IUpdcConst.IUpdfx.REMOTE ); }
		}
		finally{
			
		}
		return fromRespond;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsOffer(com.ai.aif.csf.common.exception.CsfException, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(CsfException _exception, String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsOffer fromRespond = null;
		try
		{
			IPlatformTemplate.IUpffmsCatalog fromCatalog = null;
			IPlatformTemplate.IUpffmsGroup fromGroup = getSFUpffmsGroup( _platform );
			if( fromGroup != null){
				fromCatalog = fromGroup.getCATALOG( _exception.getExceptionCode(), "*" );
				if( fromCatalog != null ){
					fromRespond = getSFUpffmsOffer( fromCatalog.getCOMPOSITE() );
				}
			}
			if( fromRespond == null && fromCatalog != null ){
				fromRespond = new IPlatformTemplate.IUpffmsOffer( fromCatalog.getCOMPOSITE(), 
						_exception.getExceptionMessage() );
			}
			else if( fromRespond == null ){
				fromRespond = getSFUpffmsOffer( IUpdcConst.IUpdfx.REMOTE );
			}
		}
		finally{
			
		}
		return fromRespond;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IUpffmSRV#getSFUpffmsCatalog(java.lang.String, java.lang.String, java.lang.String)
	 */
	public IPlatformTemplate.IUpffmsCatalog getSFUpffmsCatalog(String _coding,
			String _category, 
			String _platform) throws SFException, Exception {
		IPlatformTemplate.IUpffmsCatalog fromCatalog = null;
		try
		{
			IPlatformTemplate.IUpffmsGroup fromGroup = getSFUpffmsGroup( _platform );
			if( fromGroup != null ){ fromCatalog = fromGroup.getCATALOG( _coding, _category); }
		}
		finally{
			
		}
		return fromCatalog;
	}

}
