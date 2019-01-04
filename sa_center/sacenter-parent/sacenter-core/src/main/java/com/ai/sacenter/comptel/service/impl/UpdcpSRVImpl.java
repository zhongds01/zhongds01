package com.ai.sacenter.comptel.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.IUpdcpSystem;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV;
import com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOfferX;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OfferUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.util.WeakLateTrail;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpSRVImpl extends UpdcEclipseImpl implements IUpdcpSRV {

	public UpdcpSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromOffer = null;
		try
		{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			fromUpdcpm = UpdcpUtils.ISystem.getPROGRAM( aContext );
			IUpdcpSystem fromUpdcpImpl = UpdcpmUtils.ISystem.getIUpdcpSV( fromUpfgsm.getIMPLCLASS() );
	    	fromOffer = fromUpdcpImpl.finishSFUpfgsmc(fromUpfgsm, 
        			fromUser, 
        			aContext);
	    	if( fromOffer != null && fromUpfgsm.isUpdcvf() ){
	    		fromUpdcpImpl = UpdcpmUtils.ISystem.getIUpdcpSV( fromUpfgsm.getIMPLCLASS() );
	    		fromUpdcpImpl.finishSFUpfgsmc(fromUpdcpm, 
	    				fromUpfgsm, 
	    				fromOffer, 
	    				aContext);
	    	}
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, java.util.List, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.comptel.bo.IOVUpdcpOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			java.util.List fromCOMPETE, 
			IOVOrderUser fromUser, 
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpdcpOffer fromOffer = null;
			IProfessionalTemplate.IUpdbfgsmxOffer fromUpdbfgsmx = null;
			for( java.util.Iterator itera = fromCOMPETE.iterator(); itera.hasNext(); ){
				ISystemTemplate.IUpfgsmOffer fromUpffmx = (ISystemTemplate.IUpfgsmOffer)itera.next();
				try
				{
					fromUpdbfgsmx = (IProfessionalTemplate.IUpdbfgsmxOffer)fromUpffmx;
					fromOffer = finishSFUpfgsmc(fromUpdbfgsmx, fromUser, aContext);
					if( fromOffer != null ){
						UpdcpUtils.ICustom.wrap(fromUpdbfgsmx, fromOffer, fromUpdcpm);
					}
				}
				catch( java.lang.Exception aEXCEPTION ){
					ExceptionFactory.throwIllegal("IOS0011086", new String[]{ fromUpffmx.getID(), 
							fromUpffmx.getCOMPETE(), aEXCEPTION.getMessage() } );
				}
				finally{
					if( fromOffer != null ){ fromOffer.getCOMPLEX().clear(); fromOffer = null; }
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpOffer(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.comptel.bo.IOVUpdcpOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpOffer(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IProfessionalTemplate.IProductOffer fromUpdcpfm = null;
			fromUpdcpfm = UpdcpUtils.ICustom._wrap( fromUpfgsm );
			if( fromUpdcpfm != null && fromUpdcpfm.getSUBFLOW().size() > 0 ){
				finishSFUpfgsmc(fromUpfgsm, 
						fromUpdcpfm.getSUBFLOW(), 
						fromUser, 
						fromUpdcpm, 
						aContext);
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdbtxChain(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public ISystemTemplate.IEnumWrapper finishSFUpdbtxChain(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		ISystemTemplate.IEnumWrapper fromUpffmx = null;
		try
		{
			class IUpdbtxChainImpl{
				public IUpdbtxChainImpl(){
					super();
				}
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public String finishSFUpdbtxHome( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						IOVOrderUser fromUser,
						IUpdcContext aContext) throws SFException, Exception{
					StringBuilder fromUpdbtxHome = null;
					try
					{
						Object fromUpffmx[] = UpfgsmUtils.IUpfsm._jf_arguments(fromUpfgsm, 
								fromUpfgsm.getCOMPETE(), 
								fromUser.getNATURE(), 
								fromUpfgsm.getCOMPLEX(), 
								aContext);
						if( fromUpffmx != null && fromUpffmx.length > 0 ){
							for( int index = 0; fromUpffmx != null && index < fromUpffmx.length; index++ ){
								if( fromUpdbtxHome == null ) fromUpdbtxHome = new StringBuilder();
								else if( fromUpdbtxHome.length() > 0 ) fromUpdbtxHome.append( "," );
								fromUpdbtxHome.append( fromUpffmx[index] != null?fromUpffmx[index].toString():"NULL" );
							}
						}
					}
					finally{
						
					}
					return fromUpdbtxHome != null && fromUpdbtxHome.length() > 0?fromUpdbtxHome.toString():null;
				}
			}
			IUpdbtxChainImpl fromUpdbtxImpl = new IUpdbtxChainImpl();
			try
			{
				String fromUpdbtxHome = fromUpdbtxImpl.finishSFUpdbtxHome(fromUpfgsm, 
						fromUser, 
						aContext);
				if( fromUpdbtxHome != null && StringUtils.isBlank( fromUpdbtxHome ) == false ){
					fromUpffmx = IUpdcfgFactory.getIBasicSV().getSFEnumChain( fromUpdbtxHome );
				}
			}
			finally{
				if( fromUpdbtxImpl != null ){ fromUpdbtxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpChange(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpChange(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			class IUpdcpChangeImpl{
				private IUpfgsmModel _MODEL = new IUpfgsmModel();
				public IUpdcpChangeImpl(){
					super();
				}
				/**
				 * 
				 * @param fromUpfgsmc
				 * @param fromUpfgsm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void trajectory( ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
						IOVUpdcpOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IProfessionalTemplate.IProductComptel fromUpffx = null;
						for( java.util.Iterator itera = fromUpdcpm.getCOMPLEX().entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							String fromUpfgsmx = fromEntry.getValue() != null?fromEntry.getValue().toString():null;
							fromUpffx = UpdcpUtils.ISystem.getSUBJECT( fromEntry.getKey().toString() );
							if( fromUpffx != null && fromUpffx.getCOMPTELX().isFUNC() ){
								_MODEL._CHANGE = UpdcpUtils.ICustom.trajectory( fromUpffx, 
										fromUpfgsmx, 
										_MODEL._CHANGE );
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer change( ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
						IOVUpdcpOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						Object fromUpffmx = UpdcpUtils.ICustom.change( _MODEL._CHANGE );
						if( fromUpffmx != null && StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) == false ){
							fromUpffmx = UpfgsmUtils.IUpfsm.IIUpfsm._jj_splite( fromUpffmx.toString(), 
									fromUpfgsm.getCOMPLEX() );
						}
						fromUpdcpm.setCOMPTEL( fromUpffmx != null?fromUpffmx.toString():null );
					}
					finally{
						
					}
					return fromUpdcpm;
				}
				class IUpfgsmModel{
					private WeakLateTrail _CHANGE = new WeakLateTrail();
					public IUpfgsmModel(){
						super();
					}
				}
			}
			IUpdcpChangeImpl fromUpfsmModel = new IUpdcpChangeImpl();
			try
			{
				fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, null );
				finishSFUpdcpOffer(fromUpfgsm, 
						fromUser, 
						fromUpdcpm, 
						aContext);
				if( fromUpdcpm != null && fromUpdcpm.getCOMPLEX().size() > 0 ){
					fromUpfsmModel.trajectory(fromUpfgsm, 
							fromUpdcpm, 
							aContext);
				}
				fromUpdcpm = fromUpfsmModel.change(fromUpfgsm, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				if( fromUpfsmModel != null ){ fromUpfsmModel = null; }
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpOffer(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer[] finishSFUpdcpOffer(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromModel = new java.util.ArrayList();
		try
		{
			IOVOrderOffer fromOffer[] = OfferUtils.ISystem.getSFOrderOffer(fromUpfgsm, fromUser, aContext);
		    for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
		    	String fromUpffmx = UpdcpUtils.IUpfvn._get_status_splite(fromUpfgsm, 
		    			fromUser, 
		    			fromOffer[index], 
		    			fromUpfgsm.getCOMPLEX(), 
		    			aContext);
		    	if( fromUpffmx != null ){
		    		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		    		try
		    		{
		    			UpdcpUtils.ISystem._comptel(fromUpfgsm, fromUser, fromOffer[index], fromLDAP);
		    			IOVUpdcpOffer fromUpdcpm = UpdcpUtils.ICustom.wrap(fromUpfgsm, fromUpffmx );
		    			fromUpdcpm.setPRODUCT( fromOffer[index].getPRODUCT() );
		    			finishSFUpdcpOffer(fromUpfgsm, 
		    					fromUser, 
		    					fromUpdcpm, 
		    					fromLDAP);
		    			fromModel.add( fromUpdcpm );
		    		}
		    		finally{
		    			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		    		}
		    	}
		    }
		}
		finally{
			
		}
		return (IOVUpdcpOffer[])fromModel.toArray( new IOVUpdcpOffer[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpComptel(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpComptel(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			IOVOrderOffer fromOffer[] = OfferUtils.ISystem.getSFOrderOffer(fromUpfgsm, fromUser, aContext);
			if( fromOffer != null && fromOffer.length > 0 ){
				IOVOrderOffer fromOrdOff = OfferUtils.ICustom.wrap( fromOffer );
				String fromComptel = UpdcpUtils.IUpfvn._get_status_splite(fromUpfgsm, 
		    			fromUser, 
		    			fromOrdOff, 
		    			fromUpfgsm.getCOMPLEX(), 
		    			aContext);
				if( fromComptel != null ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromComptel );
	    			fromUpdcpm.setPRODUCT( fromOrdOff.getCOMPETE() );
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpLifite(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpLifite(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			IOVOrderOffer fromOffer[] = OfferUtils.ISystem.getSFOrderOffer(fromUpfgsm, fromUser, aContext);
			if( fromOffer != null && fromOffer.length > 0 ){
				IOVOrderOffer fromOrdOff = OfferUtils.ICustom.wrap( fromOffer );
				String fromComptel = UpdcpUtils.IUpfvn._get_status_splite(fromUpfgsm, 
		    			fromUser, 
		    			fromOrdOff, 
		    			fromUpfgsm.getCOMPLEX(), 
		    			aContext);
				if( fromComptel != null ){
					IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
					try
					{
						UpdcpUtils.ISystem._comptel(fromUpfgsm, fromUser, fromOrdOff, fromLDAP);
						fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromComptel );
						fromUpdcpm.setPRODUCT( fromOrdOff.getCOMPETE() );
						finishSFUpdcpOffer(fromUpfgsm, 
		    					fromUser, 
		    					fromUpdcpm, 
		    					fromLDAP);
					}
					finally{
						if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
					}
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpMultle(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpOffer[] finishSFUpdcpMultle(ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer[] fromUpdcpm = null;
		try
		{
			class SFUpdcpMultleImpl{
				private IOVUpdcpComposite.IOVUpdcpMultle _multle = null;  
				public SFUpdcpMultleImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param fromOrdOff
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpdcpGroup( ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
						IOVOrderUser fromUser, 
						IOVOrderOffer fromOrdOff,
			            IUpdcContext aContext) throws SFException, Exception{
					IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
					try
					{
						String __comptel__ = UpdcpUtils.IUpfvn._get_status_splite(fromUpfgsm, 
				    			fromUser, 
				    			fromOrdOff, 
				    			fromUpfgsm.getCOMPLEX(), 
				    			fromLDAP);
						if( __comptel__ != null ){
							IOVUpdcpOffer fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, __comptel__ );
							fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.PRODUCTION, fromOrdOff );
							finishSFUpdcpOffer(fromUpfgsm, fromUser, fromUpdcpm, fromLDAP );
							if( _multle == null ){ _multle = new IOVUpdcpComposite.IOVUpdcpMultle( fromUpfgsm ); }
							_multle.submitAsMultle( fromUpfgsm, fromUser, fromUpdcpm, fromLDAP );
						}
					}
					finally{
						if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
					}
				}
				
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param fromUpdcpmx
				 * @param fromMultle
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				private void finishSFUpffxOffer(IProfessionalTemplate.IProductOffer fromUpffx, 
						IOVUpdcpOffer fromUpdcpm,
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator itera = _multle.getMultle().values().iterator(); itera.hasNext(); ){
							IOVUpdcpComposite.IUpffmxOffer _multle = (IOVUpdcpComposite.IUpffmxOffer)itera.next();
							if( _multle == null || _multle.isCOMPLEX() == false ) continue;
							if( _multle.isCOMPLEX( fromUpffx ) ){
								fromUpdcpm.setCOMPTEL( _multle.getAsLate() );
							}
							else{
								fromUpdcpm.getCOMPLEX().put( _multle.getCOMPETE(), _multle.getAsLate() );
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromUpffx
				 * @param _multle
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer[] finishSFUpffxMultle(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						IOVOrderUser fromUser,
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgsm );
					try
					{
						IProfessionalTemplate.IProductOffer fromUpffx = UpdcpUtils.ICustom._wrap( fromUpfgsm );
						IOVUpdcpComposite.IUpffmxCatalog __catalog__ = (IOVUpdcpComposite.IUpffmxCatalog)_multle.getMultle( fromUpffx );
						if( __catalog__ != null && __catalog__.getCatalog().size() > 0 ){
							for( java.util.Iterator itera = __catalog__.getCatalog().iterator(); itera.hasNext(); ){
								IOVUpdcpOffer ____catalog___ = (IOVUpdcpOffer)itera.next();
								fromUpdfmx.getORDER().getORDER().add( ____catalog___ );
							}
						}
					}
					finally{
						
					}
					return (IOVUpdcpOffer[])fromUpdfmx.getORDER().getORDER().toArray( new IOVUpdcpOffer[]{} );
				}
				
				/**
				 * 
				 * @param fromUpffx
				 * @param _multle
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer[] finishSFUpffxLifite(ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
						IOVOrderUser fromUser, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdcpOffer fromUpdcpm = null;
					try
					{
						IProfessionalTemplate.IProductOffer fromUpffx = UpdcpUtils.ICustom._wrap( fromUpfgsm );
						IOVUpdcpComposite.IUpffmxOffer _multle_ = _multle.getMultle( fromUpffx.getCOMPETE() );
						fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, _multle_.isCOMPLEX()?_multle_.getAsLate():null );
						finishSFUpffxOffer( fromUpffx, fromUpdcpm, aContext );
					}
					finally{
						
					}
					return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
				}
				
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer[] finishSFUpffxOther(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						IOVOrderUser fromUser,
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdcpOffer fromUpdcpm = null;
					try
					{
						IProfessionalTemplate.IProductOffer fromUpffx = UpdcpUtils.ICustom._wrap( fromUpfgsm );
						IOVOrderOffer fromOffer[] = OfferUtils.ISystem.getSFOrderOffer(fromUpfgsm, fromUser, aContext);
						if( fromOffer != null && fromOffer.length > 0 ){
							IOVOrderOffer fromOrdOffer = OfferUtils.ICustom.wrap( fromOffer );
							String __comptel__ = UpdcpUtils.IUpfvn._get_status_splite(fromUpfgsm, 
					    			fromUser, 
					    			fromOrdOffer, 
					    			fromUpfgsm.getCOMPLEX(), 
					    			aContext);
							if( __comptel__ != null ){
								fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, __comptel__ );
								finishSFUpffxOffer(fromUpffx, fromUpdcpm, aContext);
							}
						}
					}
					finally{
						
					}
					return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
				}
				
			}
			SFUpdcpMultleImpl fromUpdcpmImpl = new SFUpdcpMultleImpl();
			try
			{
				IOVOrderOffer fromOffer[] = OfferUtils.ISystem.getSFOrderOffer(fromUpfgsm, fromUser, aContext);
				if( fromOffer != null && fromOffer.length > 0 ){
					for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
						fromUpdcpmImpl.finishSFUpdcpGroup(fromUpfgsm, 
								fromUser, 
								fromOffer[index],
								aContext);
					}
					if( fromUpdcpmImpl._multle != null && fromUpdcpmImpl._multle.getMultle().size() > 0 ){
						if( fromUpfgsm.isUpdcpm() /*产品服务级映射单元*/){
							fromUpdcpm = fromUpdcpmImpl.finishSFUpffxMultle(fromUpfgsm, 
									fromUser, 
									aContext);
						}
						else if( fromUpfgsm.isUpdcpfm() /*产品属性级映射单元*/ ){
							fromUpdcpm = fromUpdcpmImpl.finishSFUpffxLifite(fromUpfgsm, 
									fromUser, 
									aContext);
						}
						else/*无效状态服务产品能力*/{
							fromUpdcpm = fromUpdcpmImpl.finishSFUpffxOther(fromUpfgsm, 
									fromUser, 
									aContext);
						}
					}
				}
			}
			finally{
				if( fromUpdcpmImpl != null ){ fromUpdcpmImpl._multle = null; fromUpdcpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpPriority(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpPriority(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			class SFUpdcpmLimiteImpl{
				private IUpdcpGroup _GROUP = null;
				public SFUpdcpmLimiteImpl(){
					super();
				}
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void _group( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						IOVOrderUser fromUser, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdcpCatalog fromCatalog = null;
					try
					{
						fromCatalog = finishSFUpdcpModule( fromUpfgsm, fromUser, aContext);
						if( fromCatalog != null && fromCatalog.getCATALOG().size() > 0 ){
							_GROUP = new IUpdcpGroup();
							for( java.util.Iterator itera = fromCatalog.getCATALOG().iterator(); itera.hasNext(); ){
								IOVUpdcpOffer fromOffer = (IOVUpdcpOffer)itera.next();
								_GROUP._COMPETE.add( fromOffer );
								_GROUP._CHANGE = UpdcpUtils.ICustom.wrap( fromOffer, _GROUP._CHANGE );
							}
							ClassUtils.IClass.sort(_GROUP._COMPETE, new java.util.Comparator() {
								public int compare(Object a, Object b) {
									IOVUpdcpOffer aLeft = (IOVUpdcpOffer)a,aRight = (IOVUpdcpOffer)b;
									long doCompare = aLeft.getCATALOG().getSORT_BY() - 
											aRight.getCATALOG().getSORT_BY();
									return doCompare == 0?0:(doCompare > 0?1:-1);
								}
							});
						}
					}
					finally{
						if( fromCatalog != null ){ fromCatalog = null; }
					}
				}
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer _mutex(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						IOVOrderUser fromUser, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdcpOffer fromUpdcpm = null;
					try
					{
						IProfessionalTemplate.IProductComptel fromUpffx = null;
						String fromSTATUS = UpdcpUtils.ICustom.change( _GROUP._CHANGE );
						fromSTATUS = UpdcpUtils.IUpfvn._get_status_splite(fromUpfgsm, 
								fromUser, 
								fromSTATUS, 
								fromUpfgsm.getCOMPLEX(), 
								aContext);
						if( fromSTATUS != null && StringUtils.isBlank( fromSTATUS ) == false ){
							fromUpdcpm = UpdcpUtils.ICustom.wrap(fromUpfgsm, fromSTATUS);
							IOVUpdcpOffer fromOffer[] = _GROUP.getGROUP();
							IOVUpdcpOffer fromGroup = fromOffer[ fromOffer.length - 1 ];
							for( int index = fromOffer.length - 1; index >= 0; index-- ){
								fromUpffx = fromOffer[index].getPROVIDER().getCOMPTEL();
								if( UpdcpUtils.IIfElse.isCANCEL( fromUpffx, fromOffer[index].getCOMPTEL() ) == false ){
									fromGroup = fromOffer[index];
									break;
								}
							}
							if( fromGroup != null ){
								IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsmx = null;
								fromUpfgsmx = (IProfessionalTemplate.IUpdbfgsmxOffer)fromGroup.getCATALOG();
								UpdcpUtils.ICustom.wrap(fromUpfgsmx, fromGroup, fromUpdcpm);
							}
						}
					}
					finally{
						
					}
					return fromUpdcpm;
				}
				class IUpdcpGroup{
					private java.util.List _COMPETE = new java.util.ArrayList();
					private WeakLateTrail  _CHANGE = new WeakLateTrail();
					public IUpdcpGroup(){
						super();
					}
					/**
					 * 
					 */
					public IOVUpdcpOffer[] getGROUP(){
						return (IOVUpdcpOffer[])_COMPETE.toArray( new IOVUpdcpOffer[]{} );
					}
				}
			}
			SFUpdcpmLimiteImpl fromUpdcpmImpl = new SFUpdcpmLimiteImpl();
			try
			{
				fromUpdcpmImpl._group(fromUpfgsm, 
						fromUser, 
						aContext);
				if( fromUpdcpmImpl._GROUP != null ){
					fromUpdcpm = fromUpdcpmImpl._mutex(fromUpfgsm, 
							fromUser, 
							aContext);
				}
			}
			finally{
				if( fromUpdcpmImpl != null ){ fromUpdcpmImpl._GROUP = null; fromUpdcpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	
	
	

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpBatchX(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpBatchX(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		StringBuilder fromBatchX = new StringBuilder();
		try
		{
			IOVOrderOffer fromOffer = UpdcpUtils.ISystem.getOFFER( aContext );
			if( fromOffer != null && fromOffer.getFEATURE().size() > 0 ){
				for( int fromINDEX = 0; fromINDEX < fromOffer.getFEATURE().size(); fromINDEX++ ){
					IOVOrderOfferX fromOfferX = (IOVOrderOfferX)fromOffer.getFEATURE().get( fromINDEX );
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.FEATURE, fromOfferX );
					Object fromUpffx = UpdcpUtils.IUpfvn._get_offerx_splite(fromUpfgsm, 
							fromUser, 
							fromLDAP);
					fromBatchX.append( fromINDEX > 0?"/":"");
					if( fromUpffx != null ){ fromBatchX.append( fromUpffx.toString() );}
				}
				fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromBatchX.toString() );
			}
		}
		finally{
			if( fromBatchX != null ){ fromBatchX = null; }
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpUserX(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpdcpUserX(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			class IUpdcpUserXImpl{
				public IUpdcpUserXImpl(){
					super();
				}
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUserX
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IUpdcContext wrap( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						Object fromUserX,
						IUpdcContext aContext) throws SFException, Exception{
					IUpdcContext fromLDAP = null;
					try
					{
						IProfessionalTemplate.IProductOffer fromCatalog;
						fromLDAP = ClassUtils.getIContextImpl( aContext );
						fromCatalog = UpdcpUtils.IUpfvn._get_comptel( fromUpfgsm );
						fromLDAP.put( fromCatalog.getCOMPETE(), fromUserX );
					}
					finally{
						
					}
					return fromLDAP;
				}
				/**
				 * 
				 * @param fromUpfgsm
				 * @param fromUser
				 * @param fromUpdcpm
				 * @param fromUserX
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer finishSFUpdcpUserX( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
						IOVOrderUser fromUser,
						IOVUpdcpOffer fromUpdcpm,
						Object fromUserX,
						IUpdcContext aContext) throws SFException, Exception{
					IUpdcContext fromLDAP = null;
					try
					{
						fromLDAP = wrap(fromUpfgsm, fromUserX, aContext);
						if( ClassUtils.IClass.isPrimitive( fromUserX ) ){
							fromUpdcpm.setCOMPTEL( fromUserX.toString() );
						}
						else{
							if( fromUserX instanceof IOVOrderUser /*服务定单用户*/){
								fromUser = (IOVOrderUser)fromUserX;
							}
							finishSFUpdcpOffer(fromUpfgsm, 
									fromUser, 
									fromUpdcpm, 
									fromLDAP);
						}
					}
					finally{
						if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
					}
					return fromUpdcpm;
				}
			}
			IUpdcpUserXImpl fromUserXImpl = new IUpdcpUserXImpl();
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				Object fromUserX = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUser.getNATURE(), 
						aCOMPLEX[0], 
						aContext);
				if( fromUserX != null ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, aCOMPLEX != null && 
							aCOMPLEX.length > 1?aCOMPLEX[1]:null );
					fromUserXImpl.finishSFUpdcpUserX(fromUpfgsm, 
							fromUser, 
							fromUpdcpm,
							fromUserX, 
							aContext);
				}
			}
			finally{
				if( fromUserXImpl != null ){ fromUserXImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpModule(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpCatalog finishSFUpdcpModule(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpCatalog fromCatalog = null;
		try
		{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			IProfessionalTemplate.IUpdbfgsmxOffer fromUpdbfgsmx = null;
			fromUpdcpm = UpdcpUtils.ICustom._wrap( fromUpfgsm );
			fromCatalog = IUpdcpFactory.getIUpdcpmImpl( fromUpdcpm.getID(), fromUpdcpm );
			for( java.util.Iterator itera = fromUpdcpm.getSUBFLOW().iterator(); itera.hasNext(); ){
				fromUpdbfgsmx = (IProfessionalTemplate.IUpdbfgsmxOffer)itera.next();
				IOVUpdcpOffer fromOffer = finishSFUpfgsmc(fromUpdbfgsmx, 
						fromUser, 
						aContext);
				if( fromOffer != null ){ fromCatalog.getCATALOG().add( fromOffer ); }
			}
		}
		finally{
			
		}
		return fromCatalog;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpOffer(com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpCatalog finishSFUpdcpOffer(IOVOrderUser fromUser,
			IProfessionalTemplate.IProductOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpCatalog fromOffer = null;
		try
		{
			class IUpdbcpCreateImpl{
				public IUpdbcpCreateImpl(){
					super();
				}
				/**
				 * 
				 * @param fromUpdcpm
				 * @param fromCatalog
				 * @param fromUser
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpOffer[] finishSFUpdcpCreate(IProfessionalTemplate.IProductOffer fromUpdcpm,
						IProfessionalTemplate.IUpdbfgsmOffer fromCatalog,
						IOVOrderUser fromUser,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpdcpOffer fromOffer[] = null;
					try
					{
						IUpdcpSystem fromUpdcpImpl = UpdcpmUtils.ISystem.getIUpdcpSV( fromCatalog.getIMPLCLASS() );
						fromOffer = fromUpdcpImpl.finishSFUpfgsmc(fromCatalog, 
			    				fromUser, 
			    				aContext);
						if( fromOffer != null && fromOffer.length > 0 && fromCatalog.isUpdcvf() ){
							for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
								if( fromOffer[index] != null ){
									fromUpdcpImpl = UpdcpmUtils.ISystem.getIUpdcpSV( fromCatalog.getCHECKING() );
									fromUpdcpImpl.finishSFUpfgsmc(fromUpdcpm, 
											fromCatalog, 
						    				fromOffer[index], 
						    				aContext);
								}
							}
						}
					}
					finally{
						
					}
					return fromOffer;
				}
			}
			IUpdbcpCreateImpl fromUpdcpmImpl = new IUpdbcpCreateImpl();
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			try
			{
				IProfessionalTemplate.IUpdbfgsmOffer fromUpdbfgsm = null;
				ClassUtils.IMerge.merge( new Object[][]{ {IUpdcConst.IUpdbm.IUpdbf.USER , fromUser }}, fromLDAP, true );
				fromOffer = IUpdcpFactory.getIUpdcpmImpl( fromUpdcpm.getID(), fromUpdcpm );
				for( java.util.Iterator itera = fromUpdcpm.getSUBFLOW().iterator(); itera.hasNext(); ){
					fromUpdbfgsm = (IProfessionalTemplate.IUpdbfgsmOffer)itera.next();
					IOVUpdcpOffer fromCatalog[] = fromUpdcpmImpl.finishSFUpdcpCreate( fromUpdcpm,
							fromUpdbfgsm, 
							fromUser, 
							fromLDAP ); 
					for( int index = 0; fromCatalog != null && index < fromCatalog.length; index++ ){
						if( StringUtils.isBlank( fromCatalog[index].getSUBFLOW() ) ){
							ClassUtils.IMerge.merge( fromCatalog[index].getCOMPLEX(), fromOffer.getCOMPLEX() );
						}
						fromOffer.getCATALOG().add( fromCatalog[index] );
					}
				}
			}
			finally{
				if( fromLDAP != null ) { fromLDAP.clear(); fromLDAP = null; }
			}
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpOffer(com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpCatalog finishSFUpdcpOffer(IOVOrderUser fromUser,
			IOVOrderUser fromGroup, 
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpCatalog fromChain = null;
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		try
		{
			IProfessionalTemplate.IProductOffer fromUpdbfgsm = null;
			fromUpdbfgsm = UpdcpUtils.ISystem.getBUSINES( fromUpdcpm.getCATALOG(), 
					fromUpdcpm.getBUSINESS() );
			ClassUtils.IMerge.merge( new Object[][]{
				    {IUpdcConst.IUpdbm.IUpdbf.GROUP  , fromGroup   },
					{IUpdcConst.IUpdbm.IUpdbf.PROGRAM, fromUpdbfgsm}},
					fromLDAP, true );
			ClassUtils.IClass.sort(fromUser.getPRODUCTION(), new java.util.Comparator() {
		    	public int compare(Object a, Object b) {
		    		IOVOrderOffer _left = (IOVOrderOffer)a,_right = (IOVOrderOffer)b;
		    		long doCompare = _left.getCOMPTEL() - _right.getCOMPTEL();
		    		if( doCompare != 0 ) return doCompare > 0?1:-1;
		    		else{
		    			doCompare = _left.getEFFECTIVE().compareTo( _right.getEFFECTIVE() );
			    		if( doCompare != 0 ) return doCompare > 0?1:-1;
			    		else{
			    			return _left.getCOMPETE() - _right.getCOMPETE() > 0?1:-1;
			    		}
		    		}
				}
			});
			fromChain = finishSFUpdcpOffer(fromUser, fromUpdbfgsm, fromLDAP);
		}
		finally{
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		}
		return fromChain;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV#finishSFUpdcpOffer(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdcpOffer(IOVOrderRequest fromRequest,
			IOVOrderPentium fromOrder, 
			IOVOrderUser fromUser,
			IOVOrderUser fromGroup, 
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpCatalog fromChain = null;
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		UpfsvcManager.getRocket().beginTransaction();
		try
		{
			ClassUtils.IMerge.merge( new Object[][]{
					{IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE, fromRequest            },
					{IUpdcConst.IUpdbm.IUpdbf.ORDER    , fromOrder              },
					{IUpdcConst.IUpdbm.IUpdbf.MEMBER   , fromRequest.getORDER()}}, 
					fromLDAP, true );
			fromChain = finishSFUpdcpOffer(fromUser, fromGroup, fromUpdcpm, fromLDAP);
			if( fromChain != null && fromChain.getCATALOG().size() > 0 ){
				IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 10000l );
				IOVOrderPentium.IOrderOfferHome fromOfferHome = fromOrder.getORDER();
				for( java.util.Iterator<IOVUpdcpOffer> itera = fromChain.getCATALOG().iterator(); itera.hasNext(); ){
					IOVUpdcpOffer fromUpfgsm = (IOVUpdcpOffer)itera.next();
					IOVOfferPentium fromOffer = UpdcUtils.wrap( fromOrder, fromUser, fromChain, fromUpfgsm );
					fromOffer.setSORT_BY( fromINDEX.getINDEX() );
					fromINDEX.setINDEX( fromINDEX.getINDEX() + 1 );
					fromOfferHome.getOFFER().add( fromOffer );
				}
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			if( fromLDAP != null ) { fromLDAP.clear(); fromLDAP = null;}
			if( fromChain != null ){ fromChain = null;}
		}
	}
}
