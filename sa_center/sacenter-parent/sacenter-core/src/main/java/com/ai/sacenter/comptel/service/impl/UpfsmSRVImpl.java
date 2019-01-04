package com.ai.sacenter.comptel.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.IUpfgsmSystem;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-4-10</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfsmSRVImpl extends UpdcEclipseImpl implements IUpfsmSRV {

	public UpfsmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmc(java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmc(String fromMODULE, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromUpfgsm = null;
		try
		{
			IPlatformTemplate.IUpffsmOffer fromUpffsm = null;
			fromUpffsm = IUpdcfgFactory.getIUpffmSV().getSFUpffsmOffer( fromMODULE );
			fromUpfgsm = IUpdcpFactory.getIUpfgsmImpl( fromUpffsm.getID(), fromUpffsm );
			if( fromUpffsm.getCOMPETENCE().size() > 0 ){
				finishSFUpfgsmc(fromUpffsm, 
						fromUpffsm.getCOMPETENCE(), 
						fromOffer, 
						fromUpfgsm, 
						aContext);
			}
		}
		finally{
            
        }
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromUpfgsm = null;
	    try
	    {
	    	IPlatformTemplate.IUpffsmOffer fromMODULE = null;
	    	fromUpfgsm = IUpdcpFactory.getIUpfgsmImpl();
	    	if( fromUpfgsmc.getCOMPETENCE().size() > 0 ){
	    		fromMODULE = UpfgsmUtils.ICustom.getPROGRAM( aContext );
	    		finishSFUpfgsmc( fromMODULE, 
	    				fromUpfgsmc.getCOMPETENCE(), 
	    				fromOffer, 
	    				fromUpfgsm, 
	    				aContext);
	    	}
	    }
	    finally{
            
        }
	    return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffsmOffer, java.util.List, java.util.Map, com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfgsmc(IPlatformTemplate.IUpffsmOffer fromUpfgsm, 
			java.util.List fromCOMPETE, 
			java.util.Map fromOffer, 
			IOVUpfgsmCatalog fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpdcContext fromLDAP = null;
		try
		{
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc = null;
			fromLDAP = UpfgsmUtils.ICustom.getPROGRAM(fromUpfgsm, fromUpfwm, aContext);
			for( java.util.Iterator itera = fromCOMPETE.iterator(); itera.hasNext(); ){
				fromUpfgsmc = (IPlatformTemplate.IUpffgsmOffer)itera.next();
				Object aOBJECT = finishSFUpfgsmc(fromUpfgsm , fromUpfgsmc, fromOffer, fromLDAP );
				if( fromUpfgsmc.getIGNOREABLE() && aOBJECT != null ) 
					fromLDAP.put( fromUpfgsmc.getMAPPING() , aOBJECT );
				else if( fromUpfgsmc.getIGNOREABLE() == false ){
					if( UpfgsmUtils.IUpfsm.isUpfgsm( fromUpfgsmc, aOBJECT ) )
						ClassUtils.IMerge.merge((java.util.Map)aOBJECT, fromUpfwm.getMAPPINGS());
					else{
						if( aOBJECT != null ){
							fromUpfwm.getMAPPINGS().put( fromUpfgsmc.getMAPPING(), 
									ClassUtils.IClass.transfer( aOBJECT , 
											fromUpfgsmc.getCATEGORY()) );
						}
						UpfsvcManager.getRocket().submitIUpfxEntry( fromUpfgsmc , aOBJECT != null?true:false );
					}
				}
			}
		}
		finally{
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffsmOffer, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfgsmc(IPlatformTemplate.IUpffsmOffer fromUpfgsm, 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		Object aOBJECT = null;
	    try
	    {
	    	IUpfgsmSystem fromUpfgsmImpl = UpdcpmUtils.ISystem.getIUpfgsmSV( fromUpfgsmc.getIMPLCLASS() );
	    	aOBJECT = fromUpfgsmImpl.finishSFUpfgsmc( fromUpfgsmc, 
        			fromOffer, 
        			aContext );
	        if ( fromUpfgsmc.getNULLABLE() == false && aOBJECT == null ){
	        	ExceptionFactory.throwIllegal("IOS0010008", new String[]{ fromUpfgsm != null?fromUpfgsm.getID():"NULL",
	        			fromUpfgsmc.getMAPPING()});
	        }
		}
	    finally {
	    }
	    return aOBJECT;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmOffer(java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer(String fromMODULE, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromUpfgsm = null;
		try
		{
			if( StringUtils.isBlank( fromMODULE ) == false ){
				fromUpfgsm = finishSFUpfgsmc(fromMODULE, 
						fromOffer, 
						aContext);
			}
			else{
				fromUpfgsm = IUpdcpFactory.getIUpfgsmImpl();
				ClassUtils.IMerge.merge( fromOffer , fromUpfgsm.getMAPPINGS() );
			}
		}
		finally{
			
		}
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmOffer(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer(String fromMODULE, 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromUpfgsm = null;
		try
		{
			if( StringUtils.isBlank( fromMODULE ) == false ){
				fromUpfgsm = finishSFUpfgsmc( fromMODULE, 
						fromOffer, 
						aContext );
			}
			else{
				fromUpfgsm = finishSFUpfgsmc( fromUpfgsmc, 
						fromOffer, 
						aContext );
			}
		}
		finally{
			
		}
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishSFUpfgsmOffer(java.lang.String, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer(String fromMODULE, 
			Object fromUpfgsmc, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromUpfsm = null;
		try
		{
			java.util.Map fromOffer = null;
			IUpdcContext fromLdap = ClassUtils.getIContextImpl( aContext );
			Object fromUpfgsmL = fromLdap.get( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
			try
			{
				fromLdap.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE, fromUpfgsmc );
				if( ClassUtils.IClass.isMap( fromUpfgsmc ) ){
					fromUpfsm = finishSFUpfgsmOffer(fromMODULE, 
							(java.util.Map)fromUpfgsmc, 
							fromLdap);
				}
				else{
					fromUpfsm = finishSFUpfgsmOffer(fromMODULE, 
							fromOffer = new java.util.HashMap(), 
							fromLdap);
				}
			}
			finally{
				fromLdap.remove( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
				if( fromUpfgsmL != null ) fromLdap.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE , fromUpfgsmL );
				if( fromOffer != null ){ fromOffer.clear(); fromOffer = null; }
				if( fromLdap != null ){ fromLdap.clear(); fromLdap = null; }
			}
		}
		finally{
			
		}
		return fromUpfsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#finishASKUpfwmOffer(java.lang.String, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfgsmCatalog finishASKUpfwmOffer(String fromMODULE, 
			Object fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromASK = null;
		try
		{
			if (ClassUtils.IClass.isASTArray(fromUpfwm) == false/* 非数组 */) {
				IOVUpfgsmCatalog fromUpfgsm = null;
				try
				{
					fromUpfgsm = finishSFUpfgsmOffer(fromMODULE, fromUpfwm, aContext);
					if( fromUpfgsm != null && fromUpfgsm.getMAPPINGS().size() > 0 ){
						fromASK = IUpdcpFactory.getIUpfgsmImpl( fromMODULE, null );
						fromASK.getMAPPINGS().put( IUpdcConst.IUpfwm.PLWK_DISPING, 
								fromUpfgsm.getMAPPINGS() );
					}
				}
				finally{
					if( fromUpfgsm != null ){ fromUpfgsm = null; }
				}
			} else/* 数组类型 */{
				java.util.ArrayList fromChain = new java.util.ArrayList();
				try
				{
					java.util.Collection fromArray = ClassUtils.IClass.getAsArray( fromUpfwm );
					for( java.util.Iterator itera = fromArray.iterator() ; itera.hasNext() ; ){
						IOVUpfgsmCatalog fromUpfgsm = null;
						try
						{
							Object fromOBJECTIVE = itera.next();
							fromUpfgsm = finishSFUpfgsmOffer(fromMODULE, fromOBJECTIVE, aContext);
							if( fromUpfgsm != null && fromUpfgsm.getMAPPINGS().size() > 0 ){
								fromChain.add( fromUpfgsm.getMAPPINGS() );
							}
						}
						finally{
							if( fromUpfgsm != null ){ fromUpfgsm = null; }
						}
					}
					if( fromChain != null && fromChain.size() > 0 ){
						fromASK = IUpdcpFactory.getIUpfgsmImpl( fromMODULE, null );
						fromASK.getMAPPINGS().put( IUpdcConst.IUpfwm.PLWK_DISPING, fromChain );
					}
				}
				finally{
				
				}
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#deployUpffsmOracle(java.lang.String)
	 */
	public void deployUpffsmOracle(String aFILE) throws SFException, Exception {
		java.util.HashMap fromUpdbm = new java.util.HashMap();
		java.util.HashMap fromUpfsm = new java.util.HashMap();
		try
		{
			if( StringUtils.isBlank( aFILE ) == false ){ 
				UpfgsmUtils.deployUpfsmFile( aFILE , fromUpfsm );
			}
			else{
				IConfigDefine.IModuleDefine.IModuleIDefine aModuleDefine[] = IConfigDefine.getINSTANCE().getModule();
				for( int index = 0 ; aModuleDefine != null && index < aModuleDefine.length ; index++ ){
					if( StringUtils.equalsIgnoreCase( aModuleDefine[index].getUSE() , "TRUE" ) == false ) continue;
					UpfgsmUtils.deployUpfsmFile( aModuleDefine[index].getFILE() , fromUpfsm );
				}
			}
			for(  java.util.Iterator itera = fromUpfsm.values().iterator(); itera.hasNext(); ){
				IPlatformTemplate.IUpffsmOffer fromUpffsm = (IPlatformTemplate.IUpffsmOffer)itera.next();
				if( fromUpdbm.containsKey( fromUpffsm.getMODULE() ) == false ){
					fromUpdbm.put( fromUpffsm.getMODULE(), new java.util.ArrayList() );
				}
				((java.util.List)fromUpdbm.get( fromUpffsm.getMODULE() ) ).add( fromUpffsm );
			}
			BasicFactory.getIUpffmSV().deployUpffsmOffer( fromUpdbm );
		}
		finally{
			if( fromUpfsm != null ){ fromUpfsm.clear(); fromUpfsm = null;}
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null;}
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV#deployUpffsmFile(java.lang.String, java.lang.String)
	 */
	public void deployUpffsmFile(String aMODULE, 
			String rootFilePath) throws SFException, Exception {
		java.util.HashMap fromUpdbmc = new java.util.HashMap();
		java.util.Map fromMODULE = new java.util.HashMap();
		try
		{
			UpfgsmUtils.deployUpfsmOracle( (java.util.HashMap)null , fromUpdbmc );
			for( java.util.Iterator itera = fromUpdbmc.values().iterator(); itera.hasNext(); ){
				IPlatformTemplate.IUpffsmOffer fromUpffsm = (IPlatformTemplate.IUpffsmOffer)itera.next();
				if( StringUtils.isBlank( aMODULE) == false && StringUtils.equals( aMODULE, 
						fromUpffsm.getMODULE() ) == false ) continue;
				if( fromMODULE.containsKey( fromUpffsm.getMODULE() ) == false ){
					fromMODULE.put( fromUpffsm.getMODULE() , new java.util.ArrayList() );
				}
				((java.util.List)fromMODULE.get( fromUpffsm.getMODULE() ) ).add( fromUpffsm );
			}
			for( java.util.Iterator itera = fromMODULE.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
				aMODULE = aEntry.getKey().toString();
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element rootElement = document.addElement( "ucmframe" ).addAttribute("id", aMODULE);
				for( java.util.Iterator iterap = ((java.util.List)aEntry.getValue()).iterator(); iterap.hasNext(); ){
					IPlatformTemplate.IUpffsmOffer fromUpffsm = (IPlatformTemplate.IUpffsmOffer)iterap.next();
					fromUpffsm.baleUcm2Jdom( rootElement.addElement( "mappings" ) );
				}
				XmlUtils.outputFile( rootFilePath + aMODULE + ".xml" , document, null );
			}
		}
		finally{
			if( fromMODULE != null ){ fromMODULE.clear(); fromMODULE = null;}
			if( fromUpdbmc != null ){ fromUpdbmc.clear(); fromUpdbmc = null;}
		}
	}
}
