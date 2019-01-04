package com.ai.sacenter.comptel.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfvmSRVImpl extends UpdcEclipseImpl implements IUpfvmSRV {

	public UpfvmSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbpfChain(java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdbpfChain(String fromID, 
			String fromWHILEX, 
			String fromMODLE, 
			java.util.Map fromOffer, 
			java.util.List fromChain, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromMODLE = StringUtils.substringBetwn( fromMODLE , "$BPF[" , "]" );
			String aINDEX = ClassUtils.getINDEX( new String[]{fromMODLE,"_NUM"});
			Object aOBJECT = UpfgsmUtils.IUpfsm._jj_context(aINDEX, fromOffer, aINDEX, aContext);
			int aPARA_NUM = Integer.parseInt( aOBJECT != null?aOBJECT.toString():"0" );
			for( int index = 0 ; index < aPARA_NUM ; index++ ){
				try
			    {
			    	aINDEX = ClassUtils.getINDEX( new String[]{fromMODLE,"_NAME_",String.valueOf( index + 1 ) } );
			    	Object aPARA_NAME = UpfgsmUtils.IUpfsm._jj_context(aINDEX, fromOffer, aINDEX, aContext);
				    if( aPARA_NAME == null || StringUtils.isBlank( aPARA_NAME.toString() ) ) continue;
				    java.util.Map fromUpfgsm = new java.util.HashMap();
				    aINDEX = ClassUtils.getINDEX( new String[]{fromMODLE,"_VALUE_",String.valueOf( index + 1 ) } );
			    	Object aPARA_VALUE = UpfgsmUtils.IUpfsm._jj_context(aINDEX, fromOffer, aINDEX, aContext);
			    	fromUpfgsm.put( "PARAM_NAME", aPARA_NAME );
			    	fromUpfgsm.put( "PARAM_VALUE", aPARA_VALUE );
				    fromChain.add( fromUpfgsm );
			    }
			    finally{
			    	
			    }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbmfChain(java.lang.String, java.lang.String, java.util.Map, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdbmfChain(String fromID, 
			String fromMODLE, 
			java.util.Map fromOffer, 
			java.util.List fromChain, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			String aCOMPLEX = StringUtils.substringBetwn( fromMODLE , "$BMF[" , "]" );
			aCOMPLEX = StringUtils.replace( aCOMPLEX, "&", ";");
			java.util.Map fromArray[] = UpdcpUtils.ICustom.batchx(fromOffer, 
					aCOMPLEX, 
					true, 
					aContext);
			for( int index = 0 ; fromArray != null && index < fromArray.length; index++ ){
				fromChain.add( fromArray[index] );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbfpChain(java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdbfpChain(String fromID, 
			String fromWHILEX, 
			String fromMODLE, 
			java.util.Map fromOffer, 
			java.util.List fromChain, 
			IUpdcContext aContext) throws SFException, Exception {
		Object fromUpfgsmcL = null;
		try
		{
			fromUpfgsmcL = aContext.get( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
			Object aOBJECT = UpfgsmUtils.IUpfsm._jj_context( fromID , fromOffer , fromWHILEX , aContext );
			if( aOBJECT != null ){
				if( ClassUtils.IClass.isASTArray( aOBJECT ) == false ) ExceptionFactory.throwIllegal("IOS0010010", new String[]{fromWHILEX} );
				java.util.Collection aCOLLECTION = ClassUtils.IClass.getAsArray( aOBJECT );
				for( java.util.Iterator itera = aCOLLECTION.iterator() ; itera.hasNext() ; ){
					Object fromUpfgsmL = aContext.get( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
					java.util.Map fromUpfgsm = new java.util.HashMap();
					try
					{
						Object fromOBJECTIVE = itera.next();
						aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromOBJECTIVE );
						IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromMODLE, fromOffer, fromUpfgsm, aContext);
						if( fromUpfgsm != null && fromUpfgsm.size() > 0 ) fromChain.add( fromUpfgsm );
					}
					finally{
						aContext.remove( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
						if( fromUpfgsmL != null ) aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromUpfgsmL );
					}
				}
			}
		}
		finally{
			aContext.remove( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
			if( fromUpfgsmcL != null ) aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromUpfgsmcL );
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbfpChain(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.lang.String, java.util.Map, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdbfpChain(IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			String fromMODLE, 
			java.util.Map fromOffer, 
			java.util.List fromChain, 
			IUpdcContext aContext) throws SFException, Exception {
		Object fromUpfgsmcL = null;
		try
		{
			fromUpfgsmcL = aContext.get( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
			Object aOBJECT = UpfgsmUtils.IUpfsm._jj_context( fromUpfgsmc , fromOffer , fromMODLE , aContext );
			if( aOBJECT != null ){
				if( ClassUtils.IClass.isASTArray( aOBJECT ) == false ) ExceptionFactory.throwIllegal("IOS0010010", new String[]{fromUpfgsmc.getCOMPETE()} );
				java.util.Collection aCOLLECTION = ClassUtils.IClass.getAsArray( aOBJECT );
				for( java.util.Iterator itera = aCOLLECTION.iterator() ; itera.hasNext() ; ){
					Object fromUpfgsmL = aContext.get( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
					java.util.Map fromUpfgsm = null;
					try
					{
						Object fromOBJECTIVE = itera.next();
						aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromOBJECTIVE );
						fromUpfgsm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer( null , 
								fromUpfgsmc, 
								fromOffer, 
								aContext).getMAPPINGS();
						if( fromUpfgsm != null && fromUpfgsm.size() > 0 ) fromChain.add( fromUpfgsm );
					}
					finally{
						aContext.remove( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
						if( fromUpfgsmL != null ) aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromUpfgsmL );
					}
				}
			}
		}
		finally{
			aContext.remove( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
			if( fromUpfgsmcL != null ) aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromUpfgsmcL );
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishUpdbtfChain(java.lang.String, java.lang.String, java.util.Map)
	 */
	public String finishUpdbtfChain(String fromPRIMITIVE, 
			String fromCOMPETE, 
			java.util.Map fromChain) throws SFException, Exception {
		StringBuilder fromUpdbtf = new StringBuilder( fromPRIMITIVE );
		try
		{
			for( java.util.Iterator itera = fromChain.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromUpffsm = (String)fromEntry.getKey();
				String fromUpffmx = (String)fromEntry.getValue();
				if( fromUpffmx == null || StringUtils.isBlank( fromUpffmx ) ) continue;
				int fromINDEX = Integer.parseInt( StringUtils.substring( fromUpffsm, 
						fromCOMPETE.length() , 
						fromUpffsm.length() ) );
				if( fromUpdbtf.toString().getBytes().length < fromINDEX ){
					ExceptionFactory.throwJeval("IOS0011054", new String[]{ fromUpffsm });
				}
				fromUpdbtf.replace(fromINDEX - 1, fromINDEX - 1 + fromUpffmx.length(), fromUpffmx );
			}
		}
		finally{
			
		}
		return fromUpdbtf.toString();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFXPathChain(java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFXPathChain(String fromXPath, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		Object aOBJECT = null;
		try
		{
			String aCOMPLEX[] = StringUtils.wildcardArray( fromXPath , "." );
			if( aCOMPLEX != null && aCOMPLEX.length > 1 ){
				IProgramTemplate.IUpdffgsmOffer fromUpfsmc = IUpdcfgFactory.getIUpdcpmSV().getSFUpffxmOffer( aCOMPLEX[0], 
						aCOMPLEX[1] );
				aOBJECT = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpfsmc, 
						fromOffer, 
						aContext);
			}
			else if( aCOMPLEX != null && aCOMPLEX.length == 1 ){
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(aCOMPLEX[0], 
						fromOffer, 
						(java.util.Map)(aOBJECT = new java.util.HashMap()), 
						aContext);
			}
		}
		finally{
			
		}
		return aOBJECT;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdforChain(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.List finishSFUpdforChain(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, 
			String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpfgsmc = new java.util.ArrayList();
		UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
		try
		{
			if( StringUtils.startWith( fromMODULE, "$BPF[" )/*批量属性$BPF[]*/ ){
				finishSFUpdbpfChain(fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPETE(), 
						fromMODULE, 
						fromOffer, 
						fromUpfgsmc, 
						aContext);
			}
			else if( StringUtils.startWith( fromMODULE, "$BMF[")/*批量属性模板$BMF[]*/){
				finishSFUpdbmfChain(fromUpfgsm.getCOMPETE(), 
						fromMODULE, 
						fromOffer, 
						fromUpfgsmc, 
						aContext);
			}
			else/*FOR循环*/{
				finishSFUpdbfpChain(fromUpfgsm, 
						fromMODULE, 
						fromOffer, 
						fromUpfgsmc, 
						aContext);
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromUpfgsmc;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbrfChain(java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbrfChain(String fromID, 
			String fromCOMPLEX, 
			String fromPROTOCOL, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMM = null;
		java.util.Map fromUpfgsm = new java.util.HashMap();
		UpfsvcManager.getRocket().beginTransaction(fromID, fromOffer, aContext);
		try
		{
			if( StringUtils.isBlank( fromCOMPLEX ) == false/*模板引用*/ ){
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain( fromCOMPLEX, 
						fromOffer, 
						fromUpfgsm, 
						aContext );
			}
			fromPLMM = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain(fromID, 
					fromPROTOCOL, 
					fromOffer, 
					fromUpfgsm, 
					aContext);
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			if( fromUpfgsm != null ){ fromUpfgsm.clear(); fromUpfgsm = null;}
		}
		return fromPLMM;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbwfChain(java.lang.String, java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbwfChain(String fromID, 
			String fromPROTOCOL, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMM = null;
		try
		{
			fromPLMM = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain(fromID, 
					IUpdcConst.IUpfwm.IUpdpfm.WM, 
					fromPROTOCOL, 
					fromOffer, 
					null, 
					aContext);
		}
		finally{
			
		}
		return fromPLMM;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbpfChain(java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.List finishSFUpdbpfChain(String fromID, 
			String fromWHILEX, 
			String fromMODLE, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpdbm = new java.util.ArrayList();
		UpfsvcManager.getRocket().beginTransaction(fromID, fromOffer, aContext);
		try
		{
			if( StringUtils.startWith( fromMODLE, "$BPF[" )/*批量属性$BPF[]*/ ){
				finishSFUpdbpfChain(fromID, 
						fromWHILEX, 
						fromMODLE, 
						fromOffer, 
						fromUpdbm, 
						aContext);
			}
			else if( StringUtils.startWith( fromMODLE, "$BMF[")/*批量属性模板$BMF[]*/){
				finishSFUpdbmfChain(fromID, 
						fromMODLE, 
						fromOffer, 
						fromUpdbm, 
						aContext);
			}
			else/*FOR循环*/{
				finishSFUpdbfpChain(fromID, 
						fromWHILEX, 
						fromMODLE, 
						fromOffer, 
						fromUpdbm, 
						aContext);
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbtfChain(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbtfChain(IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			String fromPRIMITIVE, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		String aOBJECT = fromPRIMITIVE;
		java.util.Map fromUpfgsm = null;
		UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
		try
		{
			fromUpfgsm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer(null, 
					fromUpfgsmc, 
					fromOffer, 
					aContext).getMAPPINGS();
			if( fromUpfgsm != null && fromUpfgsm.size() > 0 ){
				aOBJECT = finishUpdbtfChain(fromPRIMITIVE, 
						fromUpfgsmc.getMAPPING(), 
						fromUpfgsm);
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			if( fromUpfgsm != null ){ fromUpfgsm.clear(); fromUpfgsm = null; } 			
		}
		return aOBJECT;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbtfChain(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbtfChain(ISystemTemplate.IUpfgsmxOffer fromUpfgsmc, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		String aOBJECT = null;
		java.util.Map fromUpfgsm = new java.util.HashMap();
		UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
		try
		{
			IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromUpfgsmc.getCOMPLEX() , 
					fromOffer, 
					fromUpfgsm, 
					aContext);
			if( fromUpfgsm != null && fromUpfgsm.size() > 0 ){
				String aPRIMITIVE = (String)fromUpfgsm.remove( fromUpfgsmc.getMAPPING() );
				if( StringUtils.isBlank( aPRIMITIVE ) ){
					ExceptionFactory.throwJeval("IOS0010008", new String[]{fromUpfgsmc.getCOMPLEX(),fromUpfgsmc.getMAPPING()});
				}
				aOBJECT = finishUpdbtfChain(aPRIMITIVE, fromUpfgsmc.getMAPPING(), fromUpfgsm);
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			if( fromUpfgsm != null ){ fromUpfgsm.clear(); fromUpfgsm = null; } 
		}
		return aOBJECT;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdfunChain(java.lang.String, java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpdfunChain(String fromID, 
			String fromMODULE, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		Object _objective = null;
		try
		{
			_objective = UpfgsmUtils.IUpfsm._jj_phantom( fromID, 
					fromID, 
					fromMODULE, 
					fromOffer, 
					aContext );
		}
		finally{
			
		}
		return _objective;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV#finishSFUpdbtxChain(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public ISystemTemplate.IEnumWrapper finishSFUpdbtxChain(ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
			java.util.Map fromOffer,
			IUpdcContext aContext) throws SFException, Exception {
		ISystemTemplate.IEnumWrapper fromEnum = null;
		try
		{
			String fromUpffmx = null,aCOMPLEX = fromUpfgsm.getCOMPLEX();
			aCOMPLEX = UpfgsmUtils.IUpfsm._jj_arguments( fromUpfgsm , 
					fromUpfgsm.getCOMPETE() , 
					fromOffer, 
					aCOMPLEX, 
					aContext );
			fromEnum = IUpdcfgFactory.getIBasicSV().getSFEnumChain( aCOMPLEX );
			if( fromEnum != null && StringUtils.contains( fromEnum.getTARGET(), "#{" ) ){
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_jeval(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						fromUpffmx, 
						aContext);
				if( fromUpffmx != null && StringUtils.isBlank( fromUpffmx ) == false ){
					fromEnum = new ISystemTemplate.IEnumWrapper(fromUpfgsm.getCOMPETE(), 
							aCOMPLEX, 
							fromUpffmx );
				}
			}
		}
		finally{
			
		}
		return fromEnum;
	}
}
