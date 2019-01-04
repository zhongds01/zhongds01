package com.ai.sacenter.core.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.core.IUpdbpmCapital;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.service.interfaces.IUpdbpmSRV;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.suggest.IUpfgxmFactory;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-12-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdbpmSRVImpl extends UpdcEclipseImpl implements IUpdbpmSRV {

	public UpdbpmSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#getSFUpdbmOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public java.util.HashMap getSFUpdbmOffer(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext)throws SFException, Exception {
		java.util.HashMap fromUpdfmx = null;
		try
		{
			IOVUpdbpmOffer.IUpdbmHome fromUpdbpmHome = fromUpdcpm.getSUBFLOW();
			fromUpdfmx = IUpdcFactory.getITaskSV().getSFTaskOffer( fromOrder );
			ClassUtils.IMerge.merge( fromUpdbpmHome.getSUBFLOW(), fromUpdfmx, false);
			if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() ) == false ){
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpdbm.getCOMPLEX(), 
						fromUpdcpm.getSUBFLOW().getSUBFLOW(), 
						fromUpdfmx, 
						aContext);
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#getSFUpdbpmOffice(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdbpmOffice getSFUpdbpmOffice(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdbpmOffice fromOffice = null;
		try
		{
			IOVUpdbpmOffer.IUpdbmHome fromUpdbpmHome = fromUpdcpm.getSUBFLOW();
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_OFFICE_SECTION, 
					new String[]{ fromUpdbm.getSUBFLOW(), fromUpdbm.getCOMPLEX() });
			fromOffice = (IOVUpdbpmOffice)fromUpdbpmHome.getGraphics().get( fromINDEX );
			if( fromOffice == null ){
				ISystemTemplate.IUpfgkmOfficeX fromOfficeX = null;
				fromOffice = new IOVUpdbpmOffice( fromOrder );
				UpdbpmUtils.ICustom._wrap( fromOrder, fromOffice );
				if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() ) == false ){
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpdbm.getCOMPLEX(), 
							fromUpdcpm.getSUBFLOW().getSUBFLOW(), 
							fromOffice.getSUBFLOW().getSUBFLOW(), 
							aContext);
					ClassUtils.IClass.transfer(fromOffice.getSUBFLOW().getSUBFLOW(), fromOffice.getSUBFLOW() );
				}
				IOVUpdbpmOffice.IUpdbpmOfferHome fromOfficeHome = fromOffice.getSUBFLOW();
				fromOfficeX = CenterUtils.getSFUpfgkmOffice( fromOfficeHome.getBILL_ID(),
						fromOfficeHome.getHEADNUM(),
						fromOfficeHome.getCATEGORY() );
				fromOffice.getSUBFLOW().setCOMPONENT( fromOfficeX );
				fromUpdbpmHome.getGraphics().put( fromINDEX, fromOffice );
			}
		}
		finally{
			
		}
		return fromOffice;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#getSFUpdbmBpel(java.lang.String)
	 */
	public IProfessionalTemplate.IUpdbpmOffer getSFUpdbmBpel(String aWORKFLOW) throws SFException, Exception {
		IProfessionalTemplate.IUpdbpmOffer fromUpdbm = null;
		try
		{
			fromUpdbm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbpmOffer( aWORKFLOW );
		}
		finally{
			
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#getSFUpdbmBpel(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public ISystemTemplate.IUpdbpmOffer getSFUpdbmBpel(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
		try
		{
			fromUpdbm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbpmCatalog( String.valueOf( fromTASK.getSUBFLOW() ) );
		}
		finally{
			
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmDepend(com.ai.sacenter.core.valuebean.IOVOrderPentium, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdbmDepend(IOVOrderPentium fromOrder, 
			java.util.List fromUpdbpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVTaskPentium fromTASK[] = (IOVTaskPentium[])fromUpdbpm.toArray( new IOVTaskPentium[]{} );
			for( int index = 1 ; fromTASK != null && index < fromTASK.length ; index++  ){
				fromTASK[index].setDEPEND_TASK_ID( fromTASK[index-1].getTASK_ID() );
				fromTASK[index].setSTATE( IUpdcConst.IState.P );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder,
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium fromPentium[] = null;
		try
		{
			class IOVOrderUpdbpmImpl{
				public IOVOrderUpdbpmImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpdbmSortBy( IOVOrderPentium fromOrder,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderPentium.IOrderOfferHome fromMBean = fromOrder.getORDER();
						ClassUtils.IClass.sort( fromMBean.getOFFER(), new java.util.Comparator() {
					    	public int compare(Object a, Object b) {
					    		IOVOfferPentium fromOfferA = (IOVOfferPentium)a,fromOfferB = (IOVOfferPentium)b;
					    		long doCompare = fromOfferA.getSORT_BY() - fromOfferB.getSORT_BY();
					    		if( doCompare != 0 ) return doCompare > 0?1:-1;
					    		else{
					    			doCompare = fromOfferA.getOFFER_ID() - fromOfferB.getOFFER_ID();
					    			return doCompare == 0?0:(doCompare > 0?1:-1);
					    		}
							}
						});
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium[] finishSFUpdbpmSplite(IOVOrderPentium fromOrder,
						IUpdcContext aContext) throws SFException, Exception{
					java.util.List fromUpdbm = new java.util.ArrayList();
					IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
					UpfsvcManager.getRocket().beginTransaction();
					try
					{
						IOVTaskPentium[] fromTASK = null;
						fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.ORDER, fromOrder );
						IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 10000000l );
						UpfsvcManager.getRocket().submitIUpfmxMotion( IUpdcConst.ISystem.CONTROL, fromINDEX );
						IOVOrderPentium.IOrderOfferHome fromMBean = fromOrder.getORDER();
						for( java.util.Iterator itera = fromMBean.getOFFER().iterator(); itera.hasNext(); ){
							IOVOfferPentium fromOffer = (IOVOfferPentium)itera.next();
							if( fromOffer.isSUBFLOW() ){
								fromTASK = finishSFUpdbpm(fromOrder, fromOffer, aContext);
								ClassUtils.IMerge.merge( fromTASK, fromUpdbm );
							}
							fromOffer.setSTATE( fromTASK != null && fromTASK.length > 0?
									IUpdcConst.IState.R:IUpdcConst.IState.O );
						}
						finishSFUpdbmDepend(fromOrder, fromUpdbm, fromLDAP);
						UpfsvcManager.getRocket().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getRocket().rollbackTransaction();
						throw exception;
					}
					finally{
						if( fromLDAP != null ){fromLDAP.clear(); fromLDAP = null;}
					}
					return (IOVTaskPentium[])fromUpdbm.toArray( new IOVTaskPentium[]{});
				}
			}
			IOVOrderUpdbpmImpl fromUpdbpmImpl = new IOVOrderUpdbpmImpl();
			try
			{
				IOVOrderPentium.IOrderOfferHome fromMBean = fromOrder.getORDER();
				if( fromMBean.getOFFER() != null && fromMBean.getOFFER().size() > 0 ){
					fromUpdbpmImpl.finishSFUpdbmSortBy(fromOrder, 
							aContext);
					fromPentium = fromUpdbpmImpl.finishSFUpdbpmSplite(fromOrder, 
							aContext);
				}
				fromOrder.setSTATE( fromPentium == null || fromPentium.length <= 0?
						IUpdcConst.IState.O:IUpdcConst.IState.R );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromPentium );
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromPentium );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
			}
			finally{
				if( fromUpdbpmImpl != null ){ fromUpdbpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromPentium;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium[], com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdbpm(IOVOrderPentium[] fromOrder,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			MBeanDelegate fromQuality = UpfsvcManager.getMBean().getQuality();
			java.util.Map fromLocal = UpfsvcManager.getMBean().getGraphics();
			java.sql.Timestamp fromTIME = (java.sql.Timestamp)fromLocal.get( IUpdcConst.ISystem.ACTIVATE );
			if( fromTIME == null || TimeUtils.greaterEqual( fromQuality.getCREATE() , fromTIME ) ){
				for( int index = 0; fromOrder != null && index < fromOrder.length ; index++ ){
					IOVTaskPentium fromTASK[] = null;
					fromTASK = IUpdcFactory.getIUpdbpmSV().finishSFUpdbpm( fromOrder[index], aContext );
					if( fromTASK != null && fromTASK.length > 0 ){
						IUpfgxmFactory.getIUpfgxmSV().finishSFTaskComplete(fromOrder[index], 
								fromTASK, 
								aContext);
						IUpdcFactory.getISystemSV().finishSFUpfwm(fromOrder[index], 
								fromTASK, 
								aContext);
					}
					else if( fromOrder[index].isGROUP() /*服务群组定单*/ ){
						IUpdcFactory.getITaskSV().finishSFTaskGroup(fromOrder[index], 
								aContext);
					}
				}
			}
		}
		finally{
		
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, java.lang.String, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbm(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			String aWORKFLOW,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpdbpm = new java.util.ArrayList();
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		try
		{
			fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.ORDER , fromOrder );
			IProfessionalTemplate.IUpdbpmOffer fromUpdbm = getSFUpdbmBpel( aWORKFLOW );
			IOVTaskPentium fromTASK[] = finishSFUpdbpm(fromOrder,
					fromUpdbm,
					fromUpdcpm,
					fromLDAP);
			ClassUtils.IMerge.merge( fromTASK , fromUpdbpm );
		}
		finally{
			if( fromLDAP != null ){ fromLDAP.clear() ; fromLDAP = null ;}
		}
		return (IOVTaskPentium[])fromUpdbpm.toArray( new IOVTaskPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmException(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbmException(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdcpmOffer fromUpdcmpt, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.ArrayList fromRollBack = null;
		try
		{
			class SFUpdbpmEngineImpl{
				public SFUpdbpmEngineImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfbpm
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public java.util.ArrayList finishSFUpdbpmException(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK,
						IProgramTemplate.IUpdfcmpOffer fromUpdfbpm, 
						IOVUpdbpmOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					java.util.ArrayList fromRollBack = new java.util.ArrayList();
					UpfsvcManager.getRocket().beginTransaction( fromTASK, fromUpdcpm.getSUBFLOW().getSUBFLOW(), aContext);
					try
					{
						IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 10000l );
						IProgramTemplate.IUpdfbpmOffer.IUpdfcmpRollBack fromUpdbm = null;
						UpfsvcManager.getRocket().submitIUpfmxMotion( IUpdcConst.ISystem.CONTROL, fromINDEX );
						for( java.util.Iterator itera = fromUpdfbpm.getSUBFLOW().iterator(); itera.hasNext(); ){
							fromUpdbm = (IProgramTemplate.IUpdfbpmOffer.IUpdfcmpRollBack)itera.next();
							IOVTaskPentium fromPentium[] = finishSFUpdbm(fromOrder,
									fromTASK.getORDER().getOFFER(),
									fromUpdbm.getSUBFLOW(), 
									fromUpdcpm, 
									aContext);
							if( fromPentium != null && fromPentium.length > 0 ){
								for( int index = 0; fromPentium != null && index < fromPentium.length; index++ ){
									fromRollBack.add( fromPentium[index] );
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
					return fromRollBack;
				}
			}
			IProgramTemplate.IUpdfcmpOffer fromUpdfbpm = null;
			fromUpdfbpm = fromUpdcmpt.getPROGRAM().getCOMPONENT();
			if( fromUpdfbpm != null && fromUpdfbpm.getSUBFLOW().size() > 0 ){
				IOVUpdbpmOffer fromUpdcpm = null;
				SFUpdbpmEngineImpl fromUpdbpmImpl = new SFUpdbpmEngineImpl();
				try
				{
					fromUpdcpm = UpdbpmUtils.ICustom._wrap(fromOrder, fromTASK, aEXCEPTION, aContext);
					fromRollBack = fromUpdbpmImpl.finishSFUpdbpmException(fromOrder, 
							fromTASK, 
							fromUpdfbpm, 
							fromUpdcpm, 
							aContext);
				}
				finally{
					if( fromUpdbpmImpl != null ){ fromUpdbpmImpl = null; }
					if( fromUpdcpm != null ){ fromUpdcpm = null; }
				}
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromRollBack.toArray( new IOVTaskPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmCompensate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbmCompensate(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.ArrayList fromUpdbm = new java.util.ArrayList();
		try
		{
			if( fromUpdcpm != null && fromUpdcpm.getPROGRAM().getCOMPONENT().getSUBFLOW().size() > 0 ){
				IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
				java.util.List fromUpdbpm = new java.util.ArrayList();
				UpfsvcManager.getRocket().beginTransaction();
				try
				{
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.ORDER , fromOrder );
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.TASK , fromTASK );
					IOVTaskPentium fromPentium[] = finishSFUpdbmException(fromOrder, 
							fromTASK, 
							fromUpdcpm, 
							aEXCEPTION, 
							fromLDAP);
					if( fromPentium != null && fromPentium.length > 0 ){
						fromUpdbpm.add( fromTASK );
						for( int index = 0; fromPentium != null && index < fromPentium.length; index++ ){
							fromPentium[index].setSORT_BY( fromTASK.getSORT_BY() );
							fromPentium[index].setCREATE_TASK_ID( fromTASK.getTASK_ID() );
							fromPentium[index].setCREATE( fromTASK );
							fromUpdbm.add( fromPentium[index] );
							fromUpdbpm.add( fromPentium[index] );
							UpfsvcManager.getSession().submitIUpdbpmLifite( fromPentium[index] );
						}
						IOVTaskPentium fromDBWK = IUpdcFactory.getIUpdwfSV().getSFTaskDepend(fromOrder, 
								fromTASK);
						if( fromDBWK != null ) fromUpdbpm.add( fromDBWK );
						finishSFUpdbmDepend(fromOrder, fromUpdbpm, aContext);
						fromPentium = (IOVTaskPentium[])fromUpdbpm.toArray( new IOVTaskPentium[]{} );
						UpfsvcManager.getSession().submitIUpdfmxLifite( fromPentium );
					}
					UpfsvcManager.getRocket().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					UpfsvcManager.getRocket().rollbackTransaction();
					throw exception;
				}
				finally{
					if( fromUpdbpm != null ){ fromUpdbpm.clear(); fromUpdbpm = null; }
					if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
				}
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromUpdbm.toArray( new IOVTaskPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmRollBack(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbmRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpdcpm = new java.util.ArrayList();
		try
		{
			class IUpdbmRollBackImpl{
				public IUpdbmRollBackImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public java.util.List getSFUpdbmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
			            IUpdcContext aContext) throws SFException, Exception{
					java.util.List aCOMPLETE = new java.util.ArrayList();
					try
					{
						IOVTaskPentium fromAll[] = IUpdcFactory.getIUpdwfSV().getSFTaskControl( fromOrder );
						for( int index = 0 ; fromAll != null && index < fromAll.length; index++ ){
							if( StringUtils.equals( fromAll[index].getSTATE(), IUpdcConst.IState.O ) == false ) continue;
							aCOMPLETE.add( fromAll[index] );
						}
						java.util.Collections.sort(aCOMPLETE, new java.util.Comparator() {
					    	public int compare(Object a, Object b) {
								IOVTaskPentium aITaskA = (IOVTaskPentium)a,aITaskB = (IOVTaskPentium)b;
								long doCompare =  ( aITaskB.getORDER().getOFFER().getSORT_BY() * 10000000000l + aITaskB.getSORT_BY() ) - 
										( aITaskA.getORDER().getOFFER().getSORT_BY() * 10000000000l + aITaskA.getSORT_BY() );
								if( doCompare == 0 ) doCompare = aITaskB.getTASK_ID() - aITaskA.getTASK_ID();
								return doCompare == 0 ?0:(doCompare > 0?1:-1);
							}
						});
					}
					finally{
						
					}
					return aCOMPLETE;
				}
			}
			IUpdbmRollBackImpl fromUpdbmImpl = new IUpdbmRollBackImpl();
			java.util.List aCOMPLETE = null;
			try
			{
				IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 20000000l );
				aCOMPLETE = fromUpdbmImpl.getSFUpdbmComplete(fromOrder, fromTASK, aContext);
				if( aCOMPLETE != null && aCOMPLETE.size() > 0 ){
					for( java.util.Iterator itera = aCOMPLETE.iterator(); itera.hasNext(); ){
						IOVTaskPentium fromNormal = (IOVTaskPentium)itera.next();
						IOVTaskPentium fromRTASK[] = IUpdcFactory.getIUpdcpmSV().finishSFTaskRollBack(fromOrder, 
								fromNormal,
								aEXCEPTION,
								aContext);
						for( int index = 0 ; fromRTASK != null && index < fromRTASK.length; index++ ){
							fromRTASK[index].setSORT_BY( fromINDEX.getINDEX() );
							fromRTASK[index].setCREATE_TASK_ID( fromNormal.getTASK_ID() );
							fromRTASK[index].setCREATE( fromNormal );
							fromINDEX.setINDEX( fromINDEX.getINDEX() + 1 );
							fromUpdcpm.add( fromRTASK[index] );
						}
					}
					finishSFUpdbmDepend(fromOrder, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( aCOMPLETE != null ){ aCOMPLETE.clear(); aCOMPLETE = null;}
				if( fromUpdbmImpl != null ){ fromUpdbmImpl = null; }
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromUpdcpm.toArray( new IOVTaskPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium[] fromTASK = null;
		try
		{
			ISystemTemplate.IImplCapital fromJAVA = null;
			fromJAVA = SystemUtils.ISystem.getSFUpfgkmCapital( fromUpdbm.getIMPLCLASS() );
	        IUpdbpmCapital fromUpdbmImpl = IUpdcFactory.getIUpdbpmSV( fromJAVA.getIMPLCLASS() );
	        if ( fromJAVA.isJMDI() == false )
	        	fromTASK = fromUpdbmImpl.finishSFUpdbpm( fromOrder,
	        			fromOffer,
	        			fromUpdbm, 
	        			fromUpdcpm,
	        			aContext);
	        else{
	        	fromTASK = (IOVTaskPentium[])ReflectUtils.IReflect.invokeMethod(fromUpdbmImpl, 
	        			fromJAVA.getMETHOD(), 
	            		new Object[]{fromOrder,
	            				     fromOffer,
	        		                 fromUpdbm,
	        		                 fromUpdcpm,
	        		                 aContext },
	            		new Class[]{IOVOrderPentium.class,
	        		                IOVOfferPentium.class,
	        		                ISystemTemplate.IUpdbpmOffer.class,
	        		                IOVUpdbpmOffer.class,
	        		                IUpdcContext.class});
	        }
		}
		finally{
			
		}
        return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder,
			IProfessionalTemplate.IUpdbpmOffer fromUpdbpm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpdpgm = new java.util.ArrayList();
		try
		{
			ISystemTemplate.IUpdbpmOffer fromUpdbm;
			IOVUpdbmtcLife fromINDEX = SystemUtils.ICustom.getICSTKUpdbmtc( aContext );
			for( java.util.Iterator itera = fromUpdbpm.getSUBFLOW().iterator(); itera.hasNext(); ){
				fromUpdbm = (ISystemTemplate.IUpdbpmOffer)itera.next();
				try
				{
					IOVTaskPentium fromTASK[] = finishSFUpdbpm( fromOrder,
							fromUpdcpm.getSUBFLOW().getOFFER(),
							fromUpdbm, 
							fromUpdcpm, 
							aContext );
					if( fromTASK == null || fromTASK.length <= 0 ) continue;
					for(int index = 0 ; fromTASK != null && index < fromTASK.length ; index++){
						if( fromUpdbm.isSUBFLOW() == false/*非子流程模型*/){
							if( fromINDEX != null ){
								fromTASK[index].setSORT_BY( fromINDEX.getINDEX() );
								fromINDEX.setINDEX( fromINDEX.getINDEX() + 1 );
							}
						}
						fromTASK[index].setSTATE( IUpdcConst.IState.C );
						fromUpdpgm.add( fromTASK[index] );
	    			}
				}
				finally{
					
				}
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromUpdpgm.toArray(new IOVTaskPentium[]{});
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder, 
			IOVOfferPentium fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium[] fromTASK = null;
		IOVUpdbpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = UpdbpmUtils.ICustom._wrap(fromOrder, fromOffer, aContext);
			IOVUpdbpmOffer.IUpdbmHome fromUpdbpmHome = fromUpdcpm.getSUBFLOW();
			UpfsvcManager.getRocket().beginTransaction(fromOffer, fromUpdbpmHome.getSUBFLOW(), aContext );
			try
			{
				IProfessionalTemplate.IUpdbpmOffer fromUpdbpm = null;
				fromUpdbpm = getSFUpdbmBpel( fromOffer.getSUBFLOW() );
				fromTASK = finishSFUpdbpm( fromOrder,
						fromUpdbpm,
						fromUpdcpm,
						aContext );
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, java.util.Map, java.lang.Object[][], com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdbmOffer(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			java.util.Map fromUpdspm, 
			Object[][] fromVariable,
			IUpdcContext aContext) throws SFException, Exception {
		java.util.Map fromUpfwm = new java.util.HashMap();
		try
		{
			if( fromUpdspm != null ) fromUpfwm.putAll( fromUpdspm );
			if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() ) == false ){
				java.util.HashMap fromOfferX = new java.util.HashMap(); 
				try
				{
					ClassUtils.IMerge.merge( fromUpdcpm.getSUBFLOW().getSUBFLOW(), fromOfferX );
					ClassUtils.IMerge.merge( fromVariable, fromOfferX, true );
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromUpdbm.getCOMPLEX(), 
							fromOfferX, 
							fromUpfwm, 
							aContext );
				}
				finally{
					if( fromOfferX != null ){ fromOfferX.clear(); fromOfferX = null; }
				}
			}
			UpfsvcManager.getRocket().submitIUpfxDeque( fromUpfwm );
		}
		finally{
			if( fromUpfwm != null ){ fromUpfwm.clear(); fromUpfwm = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmDefault(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbmDefault(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium fromTASK = null;
		try
		{
			class IUpdbpmDefaultImpl{
				public IUpdbpmDefaultImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromOffer
				 * @param fromUpdbm
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium finishSFUpdbpmDefault( IOVOrderPentium fromOrder,
						IOVOfferPentium fromOffer, 
						ISystemTemplate.IUpdbpmOffer fromUpdbm,
						IOVUpdbpmOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVTaskPentium fromTASK = null;
					try
					{
						fromTASK = IUpdcFactory.getITaskSV().finishSFTaskCreate(fromOrder,
								fromOffer,
								fromUpdbm, 
								aContext);
					}
					finally{
						
					}
					return fromTASK;
				}
			}
			IUpdbpmDefaultImpl fromUpdbpmImpl = new IUpdbpmDefaultImpl();
			try
			{
				if( UpdbpmUtils.IIfElse.isSUBFLOW(fromOrder, fromUpdbm, fromUpdcpm, aContext) ){
					fromTASK = fromUpdbpmImpl.finishSFUpdbpmDefault(fromOrder, 
							fromOffer, 
							fromUpdbm, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromUpdbpmImpl != null ){ fromUpdbpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromTASK != null?new IOVTaskPentium[]{fromTASK}:new IOVTaskPentium[]{};
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmSubFlow(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbmSubFlow(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium fromTASK[] = null;
		try
		{
			class SFUpdbpmChildImpl{
				public SFUpdbpmChildImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromUpdbpm
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium[] finishSFUpdbpmDefault(IOVOrderPentium fromOrder,
						IProfessionalTemplate.IUpdbpmOffer fromUpdbpm,
						IOVUpdbpmOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVTaskPentium fromTASK[] = null;
					try
					{
						fromTASK = finishSFUpdbm( fromOrder,
								fromUpdcpm.getSUBFLOW().getOFFER(),
								fromUpdbpm.getID(), 
								fromUpdcpm,
								aContext );
					}
					finally{
						
					}
					return fromTASK;
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromUpdbm
				 * @param fromUpdbpm
				 * @param fromUpdspm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium[] finishSFUpdbpmComplex(IOVOrderPentium fromOrder,
						ISystemTemplate.IUpdbpmOffer fromUpdbm, 
						IProfessionalTemplate.IUpdbpmOffer fromUpdbpm,
						IOVUpdbpmOffer fromUpdspm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVTaskPentium fromTASK[] = null;
					IOVUpdbpmOffer fromUpdcpm = null;
					try
					{
						fromUpdcpm = UpdbpmUtils.ICustom._wrap(fromOrder, fromUpdbm, fromUpdspm, aContext);
						UpfsvcManager.getRocket().beginTransaction(fromOrder, fromUpdcpm.getSUBFLOW().getSUBFLOW(), aContext);
						try
						{
							UpfsvcManager.getRocket().submitIUpfxDeque( fromUpdcpm.getSUBFLOW().getEXTEND() );
							fromTASK = finishSFUpdbm( fromOrder,
									fromUpdcpm.getSUBFLOW().getOFFER(),
									fromUpdbpm.getID(), 
									fromUpdcpm,
									aContext );
							UpfsvcManager.getRocket().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							UpfsvcManager.getRocket().rollbackTransaction();
							throw exception;
						}
						finally{
							
						}
					}
					finally{
						if( fromUpdcpm != null ){ fromUpdcpm = null; }
					}
					return fromTASK;
				}
			}
			SFUpdbpmChildImpl fromUpdbpmImpl = new SFUpdbpmChildImpl();
			try
			{
				IProfessionalTemplate.IUpdbpmOffer fromUpdbpm = null;
				fromUpdbpm = UpdbpmUtils.IIfElse.getSUBFLOW(fromOrder, 
						fromUpdbm, 
						fromUpdcpm, 
						aContext);
				if( fromUpdbpm != null ){
					if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() ) ){
						fromTASK = fromUpdbpmImpl.finishSFUpdbpmDefault(fromOrder,
								fromUpdbpm, 
								fromUpdcpm, 
								aContext);
					}
					else{
						fromTASK = fromUpdbpmImpl.finishSFUpdbpmComplex(fromOrder, 
								fromUpdbm, 
								fromUpdbpm, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpdbpmImpl != null ){ fromUpdbpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromTASK != null?fromTASK:new IOVTaskPentium[]{};
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdbpmSRV#finishSFUpdbmOffice(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbmOffice(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVTaskPentium fromTASK = null;
		try
		{
			class SFUpdbmOfficeImpl{
				public SFUpdbmOfficeImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromOffer
				 * @param fromUpdbm
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium finishSFUpdbpmDefault( IOVOrderPentium fromOrder,
						IOVOfferPentium fromOffer, 
						ISystemTemplate.IUpdbpmOffer fromUpdbm,
						IOVUpdbpmOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVTaskPentium fromPentium = null;
					try
					{
						fromPentium = IUpdcFactory.getITaskSV().finishSFTaskCreate(fromOrder,
								fromOffer,
								fromUpdbm, 
								aContext);
					}
					finally{
						
					}
					return fromPentium;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromOffer
				 * @param fromUpdbm
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium finishSFUpdbpmOffice( IOVOrderPentium fromOrder,
						IOVOfferPentium fromOffer, 
						ISystemTemplate.IUpdbpmOffer fromUpdbm,
						IOVUpdbpmOffer fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVTaskPentium fromTASK = null;
					try
					{
						IOVUpdbpmOffice fromOffice = getSFUpdbpmOffice(fromOrder,
								fromUpdbm, 
								fromUpdcpm, 
								aContext);
						if( fromOffice == null || fromOffice.getSUBFLOW().getCOMPONENT() == null ) {
							ExceptionFactory.throwIllegal("IOS0011057", new String[] {
								fromOffice.getSUBFLOW().getHEADNUM() }); 
						}
						fromTASK = IUpdcFactory.getITaskSV().finishSFTaskCreate( fromOrder,
								fromOffer,
								fromUpdbm, 
								aContext );
						fromTASK.setPLATFORM( fromOffice.getSUBFLOW().getCOMPONENT().getPLATFORM_() );
					}
					finally{
					
					}
					return fromTASK;
				}
			}
			SFUpdbmOfficeImpl fromUpdbpmImpl = new SFUpdbmOfficeImpl();
			try
			{
				if( UpdbpmUtils.IIfElse.isSUBFLOW( fromOrder, fromUpdbm, fromUpdcpm, aContext ) ){
					if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() )/*默认拆分流程规范*/ ){
						fromTASK = fromUpdbpmImpl.finishSFUpdbpmDefault(fromOrder, 
								fromOffer, 
								fromUpdbm, 
								fromUpdcpm, 
								aContext);
					}
					else/*用户局向拆分流程规范*/{
						fromTASK = fromUpdbpmImpl.finishSFUpdbpmOffice(fromOrder, 
								fromOffer, 
								fromUpdbm, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpdbpmImpl != null ){ fromUpdbpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromTASK != null?new IOVTaskPentium[]{fromTASK}:new IOVTaskPentium[]{};
	}
}
