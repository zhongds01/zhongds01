package com.ai.sacenter.i18n.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.aif.csf.common.exception.CsfException;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.common.i18n.BusinessException;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.IUpdfxResource;
import com.ai.sacenter.i18n.SFBsException;
import com.ai.sacenter.i18n.SFConnectException;
import com.ai.sacenter.i18n.SFESCsfException;
import com.ai.sacenter.i18n.SFIdleException;
import com.ai.sacenter.i18n.SFIllegalException;
import com.ai.sacenter.i18n.SFJevalException;
import com.ai.sacenter.i18n.SFOracleException;
import com.ai.sacenter.i18n.SFOtherException;
import com.ai.sacenter.i18n.SFRemoteException;
import com.ai.sacenter.i18n.SFSQLException;
import com.ai.sacenter.i18n.SFTimeOutException;
import com.ai.sacenter.jeval.EvaluationException;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpdfxResourceImpl implements IUpdfxResource {
	private static final Log log = LogFactory.getLog(SFUpdfxResourceImpl.class);
	private boolean _local_fixed = true;
	private java.util.Locale _default_locale = java.util.Locale.CHINA;
	public SFUpdfxResourceImpl() {
		super();
		org.dom4j.Element aConfigItem = JdomUtils.IConfigure.getConfigItem( "LOCALE" );
		try{
			_default_locale = JdomUtils.IConfigure.getAsLocal  ( aConfigItem, "LOCALE", "CHINESE" );
		}
		catch( java.lang.Exception aException ){
			log.error( aException.getMessage(), aException );
			_default_locale = new java.util.Locale( "CHINESE", "" );
		}
		try{
			_local_fixed    = JdomUtils.IConfigure.getAsBoolean( aConfigItem, "LOCALE_FIXED" , true   );
		}
		catch( java.lang.Exception aException ){
			log.error( aException.getMessage(), aException );
			_local_fixed = true;
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getLocal(java.lang.String, java.lang.Object[])
	 */
	public String getLocal(String resource, Object[] args) {
		return AppframeLocaleFactory.getResource( resource, args );
	}

	/* (non-Javadoc)
	 * @see com.ai.appframe2.util.locale.ICustomLocaleResource#getResourceName()
	 */
	public String getResourceName() {
		return "CRM";
	}

	/* (non-Javadoc)
	 * @see com.ai.appframe2.util.locale.ICustomLocaleResource#getResource(java.util.Locale, java.lang.String, java.lang.Object[])
	 */
	public String getResource(java.util.Locale locale, String resource, Object[] args) {
		String fromDefault = null;
		try
		{
			fromDefault = getResource( locale, resource );
			fromDefault = JdomUtils.ICustom._wrapAsMessage( fromDefault, args );
		}
		finally{
			
		}
		return fromDefault;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.locale.IUpdfxResource#getDefault()
	 */
	public java.util.Locale getDefault() {
		java.util.Locale fromDefault = null;
		try
		{
			if( _local_fixed == true ){ fromDefault = _default_locale; }
			else { fromDefault = AppframeLocaleFactory.getCurrentLocale(); }
		}
		finally{
			
		}
		return fromDefault;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.locale.IUpdfxResource#getDefault(java.lang.String)
	 */
	public ISystemTemplate.IUpfgkmResource getDefault(String resource) {
		ISystemTemplate.IUpfgkmResource fromResource = null;
		try
		{
			java.util.Locale fromDefault = getDefault();
			fromResource = SystemUtils.ISystem.getSFUpfgkmResource( resource, fromDefault );
		}
		catch( java.lang.Exception aException ){
			log.error( aException.getMessage(), aException );
			throw new RuntimeException("key:" + resource + ",resource found exception", aException );
		}
		finally{
			
		}
		return fromResource;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.locale.IUpdfxResource#getDefault(java.lang.String, java.lang.Object[])
	 */
	public String getDefault(String resource, Object[] args) {
		StringBuilder fromString = null;
		try
		{
			java.util.Locale fromLocal = getDefault();
			return getResource(fromLocal, resource, args );
		}
		catch( java.lang.Exception aException ){
			fromString = new StringBuilder();
			fromString.append("key").append("=").append( resource );
			fromString.append(",args={" );
			for( int index = 0; args != null && index < args.length; index++ ){
				fromString.append( args[index] );
				if( index != args.length - 1 ) fromString.append(",");
			}
			fromString.append("}");
			return fromString.toString();
		}
		finally{
			if( fromString != null ){ fromString = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getResource(java.lang.String, java.lang.Object[])
	 */
	public String getResource(String resource, Object[] args) {
		String fromDefault = null;
		try
		{
			java.util.Locale _locale = getDefault();
			if( args == null ){
				fromDefault = getResource( _locale, resource );
			}
			else{
				fromDefault = getResource( _locale, resource, args );
			}
		}
		finally{
			
		}
		return fromDefault;
	}

	/* (non-Javadoc)
	 * @see com.ai.appframe2.util.locale.ICustomLocaleResource#getResource(java.util.Locale, java.lang.String)
	 */
	public String getResource(java.util.Locale locale, String resource) {
		ISystemTemplate.IUpfgkmResource fromResource = null;
		try
		{
			try
			{
				java.util.Locale fromDefault = getDefault();
				fromResource = SystemUtils.ISystem.getSFUpfgkmResource( resource, fromDefault );
			}
			catch( java.lang.Exception aException ){
				throw new RuntimeException("key:" + resource + ",resource found exception", aException );
			}
			if( fromResource == null ){
				throw new RuntimeException("key:" + resource + ",resource not found");
			}
		}
		finally{
			
		}
		return StringUtils.isBlank( fromResource.getDESCRIPTION() )?fromResource.getNAME():fromResource.getDESCRIPTION();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getResource(java.lang.Exception)
	 */
	public SFException getResource( java.lang.Exception exception ) {
		SFException aEXCEPTION = null;
		try
		{
			aEXCEPTION = getResource(IUpdcConst.IUpdfx.DESIGNING, 
					new Object[]{IUpdcConst.IUpfwm.IUpfm.ucmframe, exception.getMessage()}, 
					IUpdcConst.IUpfwm.IUpfm.ucmframe,  
					exception);
		}
		finally{
			
		}
		return aEXCEPTION;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getResource(java.lang.String, java.lang.Exception)
	 */
	public SFException getResource( String originator, java.lang.Exception exception ) {
		SFException aEXCEPTION = null;
		try
		{
			aEXCEPTION = getResource(IUpdcConst.IUpdfx.DESIGNING, 
					new Object[]{originator, exception.getMessage()}, 
					originator,  
					exception);
		}
		finally{
			
		}
		return aEXCEPTION;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getResource(java.lang.String, java.lang.Object[], java.lang.Exception)
	 */
	public SFException getResource( String faultCode, Object[] args, java.lang.Exception exception ) {
		SFException aEXCEPTION = null;
		try
		{
			aEXCEPTION = getResource(faultCode, args, IUpdcConst.IUpfwm.IUpfm.ucmframe, exception);
		}
		finally{
			
		}
		return aEXCEPTION;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getResource(java.lang.String, java.lang.Object[], java.lang.String, java.lang.Exception)
	 */
	public SFException getResource(String faultCode, Object[] args, String originator, java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		try 
		{
			if( exception == null ){
				aEXCEPTION = new SFOtherException(faultCode, args, originator);
			} 
			else if( exception instanceof SFException ){
				aEXCEPTION = (SFException)exception;
			} 
			else if( exception instanceof BusinessException ){
				BusinessException fromBusins = (BusinessException)exception;
				aEXCEPTION = new SFRemoteException( fromBusins.getKey(), fromBusins.getMessage(), originator, exception );
				aEXCEPTION.setArgs( fromBusins.getArgs() );
			}
			else if( exception instanceof CsfException ){
				CsfException fromCsf = (CsfException)exception;
				IPlatformTemplate.IUpffmsOffer fromUpffmx = SystemUtils.ISystem.getSFUpfgkmRespond(fromCsf, originator);
				aEXCEPTION = new SFESCsfException( fromUpffmx.getID(), fromCsf.getExceptionMessage(), exception );
				ClassUtils.IMerge.merge( fromCsf.toMap(), aEXCEPTION.getORDER() );
			}
			else{
				java.lang.Exception aPRIMITIVE = ExceptionFactory.getPrimitive( exception );
				if( aPRIMITIVE instanceof EvaluationException ){
					aEXCEPTION = new SFJevalException( IUpdcConst.IUpdfx.JEVALING, args, originator, aPRIMITIVE );
				} 
				else if (aPRIMITIVE instanceof java.net.ConnectException){
					aEXCEPTION = new SFConnectException( IUpdcConst.IUpdfx.CONNECT, args, aPRIMITIVE );
				} 
				else if (aPRIMITIVE instanceof java.net.SocketTimeoutException){
					aEXCEPTION = new SFTimeOutException( IUpdcConst.IUpdfx.TIMEOUT, args, aPRIMITIVE );
				} 
				else if (aPRIMITIVE instanceof java.rmi.RemoteException){
					Object fromArgs[] = ClassUtils.IMerge.merge( args, new Object[]{aPRIMITIVE.getMessage()} );
					aEXCEPTION = new SFRemoteException( IUpdcConst.IUpdfx.REMOTE, fromArgs, originator, aPRIMITIVE );
				} 
				else if( aPRIMITIVE instanceof java.io.IOException ){
					Object fromArgs[] = ClassUtils.IMerge.merge( args, new Object[]{aPRIMITIVE.getMessage()} );
					aEXCEPTION = new SFTimeOutException( IUpdcConst.IUpdfx.FILEING, fromArgs, aPRIMITIVE );
				} 
				else if( aPRIMITIVE instanceof java.sql.SQLException ){
					aEXCEPTION = new SFSQLException( IUpdcConst.IUpdfx.ORACLE, new Object[]{
							aPRIMITIVE.getMessage()}, originator, aPRIMITIVE );
				}
				else if( aPRIMITIVE instanceof java.lang.IllegalArgumentException ){
					aEXCEPTION = new SFIllegalException(faultCode, args, originator, aPRIMITIVE );
				}
				else{
					aEXCEPTION = new SFOtherException(faultCode, args, originator, aPRIMITIVE );
				}
			}
		} 
		finally{

		}
		return aEXCEPTION;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.i18n.IUpdfxResource#getExtend(java.lang.Exception, java.lang.Object[])
	 */
	public SFBsException getExtend(Exception exception, Object[] args) {
		SFBsException fromExtend = null;
		SFUpdfxPtmtImpl fromUpdfxImpl = new SFUpdfxPtmtImpl();
		try
		{
			if( exception == null /*为NULL则默认开通成功*/){
				fromExtend = fromUpdfxImpl.getExtend( null, args, this );
			}
			else if( exception instanceof BusinessException /*业务类资源则转换*/){
				BusinessException aBUSINESS = (BusinessException)exception;
				Object aPARAM[] = ClassUtils.IMerge.merge( args, aBUSINESS.getArgs() );
				fromExtend = fromUpdfxImpl.getExtend( aBUSINESS.getKey(), aPARAM, exception, this );
			}
			else if( exception instanceof SFException /*开通内部异常*/ ){
				SFException aEXCEPTION = (SFException)exception;
				Object aPARAM[] = ClassUtils.IMerge.merge( args, aEXCEPTION.getArgs() );
				fromExtend = fromUpdfxImpl.getExtend( aEXCEPTION.getFaultCode(), aPARAM, exception, this );
				ClassUtils.IMerge.merge( aEXCEPTION.getORDER(), fromExtend.getORDER() );
			}
			else/*非开通内部异常*/{
				fromExtend = fromUpdfxImpl.getExtend( exception, args, this );
			}
		}
		finally{
			if( fromUpdfxImpl != null ){ fromUpdfxImpl = null; }
		}
		return fromExtend;
	}
	
}

class SFUpdfxPtmtImpl{
	public SFUpdfxPtmtImpl(){
		super();
	}
	
	/**
	 * 
	 * @param faultCode
	 * @param args
	 * @param exception
	 * @param fromUpdfxImpl
	 * @return
	 */
	public SFBsException getExtend(String faultCode, Object[] args, java.lang.Exception exception, IUpdfxResource fromUpdfxImpl){
		SFBsException aBusiness = null;
		try
		{
			ISystemTemplate.IUpfgkmResource fromExend = null;
			ISystemTemplate.IUpfgkmResource fromDefault = fromUpdfxImpl.getDefault( faultCode );
			Object aPARAM[] = ClassUtils.IMerge.merge( new Object[]{exception.getMessage()}, args );
			if( fromDefault == null || fromDefault.isVALID() == false /*非开通内部异常则采用默认转换*/){
				aBusiness = new SFBsException( IUpdcConst.IUpdfx.IQuality.REMOTE, aPARAM );
			}
			else if( fromDefault.isEXTEND() /*外部资源*/){
				aBusiness = new SFBsException( fromDefault.getCODE(), aPARAM );
			}
			else if( StringUtils.isBlank( fromDefault.getEXTEND() ) )/*开通内部资源并且非外部配置则采用采用默认转换*/{
				aBusiness = new SFBsException( IUpdcConst.IUpdfx.IQuality.REMOTE, aPARAM );
			}
			else if(( fromExend = fromUpdfxImpl.getDefault( fromDefault.getEXTEND() ) ) == null/*外部资源未配置*/){
				aBusiness = new SFBsException( fromDefault.getEXTEND(), aPARAM );
			}
			else/*外部资源已配置*/{
				String aResource = fromUpdfxImpl.getDefault( fromExend.getCODE(), aPARAM );
				aPARAM = ClassUtils.IMerge.merge( new Object[]{ aResource }, args );
				aBusiness = new SFBsException( fromExend.getCODE(), aPARAM );
			}
		}
		finally{
			
		}
		return aBusiness;
	}
	
	/**
	 * 
	 * @param exception
	 * @param args
	 * @param fromUpdfxImpl
	 * @return
	 */
	public SFBsException getExtend( java.lang.Exception exception, Object[] args, IUpdfxResource fromUpdfxImpl ){
		SFBsException fromExtend = null;
		try
		{
			Object fromArgs[] = ClassUtils.IMerge.merge( exception == null?new Object[]{}:
				new Object[]{exception.getMessage()}, args );
			if( exception == null ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.SUCCEED, fromArgs );
			}
			else if( exception instanceof  SFIllegalException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.DESIGNING, fromArgs );
			}
			else if( exception instanceof SFConnectException ||
					exception instanceof java.net.ConnectException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.CONNECT, fromArgs );
			}
			else if( exception instanceof SFIdleException ||
					exception instanceof java.util.NoSuchElementException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.IDLEING, fromArgs);
			}
			else if( exception instanceof SFTimeOutException || 
					exception instanceof java.net.SocketTimeoutException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.TIMEOUT, fromArgs );
			}
			else if( exception instanceof SFRemoteException ||
					exception instanceof java.rmi.RemoteException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.REMOTE, fromArgs );
			}
			else if( exception instanceof SFOracleException || 
					exception instanceof java.sql.SQLException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.ORACLE, fromArgs );
			}
			else if( exception instanceof SFException ){
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.SYSTEM, fromArgs );
			}
			else if( exception instanceof BusinessException ){
				BusinessException aBUSINESS = (BusinessException)exception;
				fromExtend = new SFBsException( aBUSINESS.getKey(), aBUSINESS.getMessage() );
				fromExtend.setArgs( aBUSINESS.getArgs() );
			}
			else{
				fromExtend = new SFBsException( IUpdcConst.IUpdfx.IQuality.UNKNOWN, fromArgs );
			}
		}
		finally{
			
		}
		return fromExtend;
	}
	
}
