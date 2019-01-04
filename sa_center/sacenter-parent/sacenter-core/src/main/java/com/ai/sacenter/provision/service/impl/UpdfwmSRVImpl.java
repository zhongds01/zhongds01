package com.ai.sacenter.provision.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.dbcp.IUpfwmCapital;
import com.ai.sacenter.provision.dbcp.IUpfwmProtocol;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.IUpfwmMonitor;
import com.ai.sacenter.provision.mstp.IUpfwmPool;
import com.ai.sacenter.provision.mstp.IUpfwmPoolFactory;
import com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;

public class UpdfwmSRVImpl extends UpdcEclipseImpl implements IUpdfwmSRV {

	public UpdfwmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getSFUpdfwm(java.lang.String, java.lang.String, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdspmLife getSFUpdfwm(String aPLATFORM, 
			String aDIRECTIVE, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdspmLife fromUpdfwm = new IOVUpdspmLife();
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpfm = null;
			IPlatformTemplate.IUpffmDirective fromUpdfm = null;
			IPlatformTemplate.IUpffmOperate fromUpfom = null;
			ISystemTemplate.IImplCapital fromJAVA = null;
			fromUpfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( aPLATFORM );
			fromUpdfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmLogical( aDIRECTIVE , fromUpfm );
			fromUpfom = IUpdcfgFactory.getIUpffmSV().getSFUpffmOperate( fromUpdfm.getOPERATE_(), fromUpfm );
			fromJAVA = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromUpdfm.getIMPLCLASS() );
			fromUpdfwm.setPLATFORM( fromUpfm );
			fromUpdfwm.setDIRECTIVE( fromUpdfm );
			fromUpdfwm.setOPERATE( fromUpfom );
			fromUpdfwm.setJAVA( fromJAVA );
		}
		finally{
			
		}
		return fromUpdfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdspmLife getSFUpdfwm(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdspmLife fromUpdfwm = null;
		try
		{
			fromUpdfwm = getSFUpdfwm(fromTASK.getPLATFORM(), 
					fromTASK.getDIRECTIVE(),
					aContext);
		}
		finally{
			
		}
		return fromUpdfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromChain = new java.util.ArrayList();
		try
		{
			class SFUpffbpmFlowImpl{
				public SFUpffbpmFlowImpl(){
					super();
				}
				/**
				 * 根据网元二级指令规范查询网元指令调度
				 * @param fromOrder 服务定单
				 * @param fromTASK 服务定单任务
				 * @param fromUpdfwm 服务指令集
				 * @param fromINDEX 网元指令索引
				 * @param fromUpdgm 网元指令列表
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpdbpmChild(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						java.util.Map fromINDEX,
						java.util.List fromUpdgm,
						IUpdcContext aContext) throws SFException, Exception{
					java.util.Map fromOffer = null;
					IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
					try
					{
						fromOffer = IUpdcFactory.getITaskSV().getSFTaskOffer(fromOrder, fromTASK, aContext );
						fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.ORDER , fromOrder );
						finishSFUpdfwmBpel(fromTASK, 
								fromUpdfwm, 
								fromOffer, 
								fromINDEX, 
								fromUpdgm, 
								fromLDAP);
					}
					finally{
						if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
						if( fromOffer != null ){ fromOffer.clear(); fromOffer = null;}
					}
				}
			}
			SFUpffbpmFlowImpl fromUpffwmImpl = new SFUpffbpmFlowImpl();
			java.util.Map fromINDEX = new java.util.HashMap();
			try
			{
				IPlatformTemplate.IUpffmDirective fromUpfdfm = fromUpdfwm.getDIRECTIVE();
				if( fromUpfdfm.getWRKFLW() == null || fromUpfdfm.getWRKFLW().size() <= 0 ){
					fromChain.add( fromUpdfwm );
				}
				else/*二级指令规范*/{
					IOVUpdspmLife fromUpdfm = new IOVUpdspmLife( fromUpdfwm );
					fromUpdfm.getBPMING().add( fromTASK );
					fromUpffwmImpl.finishSFUpdbpmChild(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							fromINDEX, 
							fromChain, 
							aContext);
					String aINDEX = fromUpdfm.getDIRECTIVE().getINDEX();
					if( fromINDEX.containsKey( aINDEX ) == false ) fromChain.add( 0 , fromUpdfm );
				}
			}
			finally{
				if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
				if( fromUpffwmImpl != null ){ fromUpffwmImpl = null; }
			}
		}
		finally{
			
		}
		return fromChain;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getSFUpdfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdspmLife getSFUpdfwm(IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdspmLife fromUpdfwm = null;
		try
		{
			fromUpdfwm = getSFUpdfwm(fromUpfwm.getPLATFORM(), 
					fromUpfwm.getDIRECTIVE(),
					aContext);
			fromUpdfwm.getBPMING().add( fromUpfwm );
		}
		finally{
			
		}
		return fromUpdfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getASKUpdfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdspmLife getASKUpdfwm(IOVUpfwmOrder fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdspmLife fromUpdfwm = null;
		try
		{
			fromUpdfwm = getSFUpdfwm(fromUpfwm.getPLATFORM(), 
					fromUpfwm.getDIRECTIVE(),
					aContext);
			fromUpdfwm.getBPMING().add( fromUpfwm );
		}
		finally{
			
		}
		return fromUpdfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishSFUpdfwmBpel(java.lang.Object, com.ai.sacenter.valuebean.IOVUpdspmLife, java.util.Map, java.util.Map, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdfwmBpel(Object fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			java.util.Map fromOffer, 
			java.util.Map fromINDEX, 
			java.util.List fromUpdgm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IPlatformTemplate.IUpffbpmOffer fromUpffbpm = null;
			IPlatformTemplate.IUpffmOffer fromUpfm = fromUpdfwm.getPLATFORM();
			IPlatformTemplate.IUpffmDirective fromUpdfm = fromUpdfwm.getDIRECTIVE();
			for( java.util.Iterator itera = fromUpdfm.getWRKFLW().iterator() ; itera.hasNext() ; ){
				String aWORKFLW = (String)itera.next();
				java.util.Map[] fromBPK = null;
				IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
				try
				{
					String fromPLWK[] = StringUtils.wildcardArray( aWORKFLW , "|" );
					fromBPK = new java.util.Map[]{ fromOffer };
					boolean fromEqual = fromPLWK != null && fromPLWK.length > 1 && StringUtils.isBlank( fromPLWK[1] ) == false;
					if( fromEqual == true ) fromBPK = UpdcpUtils.ICustom.batchx( fromOffer, fromPLWK[1] , true , fromLDAP);
					for( int index = 0 ; fromBPK != null && index < fromBPK.length; index++ ){
						java.util.Map fromJEVAL = new java.util.HashMap();
						UpfsvcManager.getRocket().beginTransaction();
						try
						{
							if( fromEqual == true ) ClassUtils.IMerge.merge( fromBPK[index], fromJEVAL );
							ClassUtils.IMerge.merge( fromOffer, fromJEVAL, false );
							fromUpffbpm = IUpdcfgFactory.getIUpffmSV().getSFUpffmSubFlow( fromPLWK[0], fromUpfm );
							if( fromUpffbpm != null && fromUpffbpm.getSUBFLOW().size() > 0 ){
								for( java.util.Iterator iterap = fromUpffbpm.getSUBFLOW().iterator(); iterap.hasNext(); ){
									IPlatformTemplate.IUpffmSubFlow fromUpdbm = (IPlatformTemplate.IUpffmSubFlow)iterap.next();
									IPlatformTemplate.IUpffmOffer fromUpfom = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromUpdbm.isUpfdfm()? 
											fromUpdbm.getPLATFORM() : fromUpfm.getID() );
				        			IPlatformTemplate.IUpffmDirective fromUpdffmx = IUpdcfgFactory.getIUpffmSV().
				        					getSFUpffmLogical(
													fromUpdbm.getDIRECTIVE(),
													fromUpfom);
				        			fromINDEX.put( fromUpdffmx.getINDEX(), Boolean.TRUE );
									if( UpdbpmUtils.IIfElse.isCHILDREN( fromUpfwm, fromUpdbm, fromJEVAL, fromLDAP) ){
										IOVUpdspmLife fromUpdfsm = getSFUpdfwm( fromUpfom.getID(), fromUpdffmx.getID() , fromLDAP );
										fromUpdfsm.setPARENT( fromUpdfwm );
										fromUpdfsm.setCHILDREN( fromUpdbm );
										if( fromEqual == true ) ClassUtils.IMerge.merge( fromBPK[index] , fromUpdfsm.getTOKEN().getDeque() );
										fromUpdfsm.getBPMING().add( fromUpfwm );
										fromUpdgm.add( fromUpdfsm );
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
							if( fromJEVAL != null ){ fromJEVAL.clear(); fromJEVAL = null;}
						}
					}
				}
				finally{
					if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
					if( fromBPK != null ){ fromBPK = null;}
				}
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getSFUpdfwm(java.lang.Object, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmDirective, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.List getSFUpdfwm(Object fromUpfwm, 
			IPlatformTemplate.IUpffmDirective fromUpdfwm, 
			IPlatformTemplate.IUpffmOffer fromUpfm, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromList = new java.util.ArrayList();
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			IOVUpdspmLife fromUpfdfwm = getSFUpdfwm(fromUpfm.getID(), 
					fromUpdfwm.getID(), 
					aContext);
			if( fromUpfdfwm.getDIRECTIVE().getWRKFLW() == null || 
					fromUpfdfwm.getDIRECTIVE().getWRKFLW().size() <= 0 ){
				fromList.add( fromUpfdfwm );
			}
			else{
				IOVUpdspmLife fromUpdfsm = new IOVUpdspmLife( fromUpfdfwm );
				fromUpdfsm.getBPMING().add( fromUpfwm );
				finishSFUpdfwmBpel(fromUpfwm, 
						fromUpfdfwm, 
						fromOffer, 
						fromINDEX, 
						fromList, 
						aContext);
				String aINDEX = fromUpdfsm.getDIRECTIVE().getINDEX();
				if( fromINDEX.containsKey( aINDEX ) == false ) fromList.add( 0 , fromUpdfsm );
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromList;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishSFUpfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfwm(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpdfwmFlowImpl{
				public SFUpdfwmFlowImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpdfwmCreate( IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpdbpmOffice fromOfficeX = null;
						ISystemTemplate.IImplCapital fromCapital = fromUpdfwm.getJAVA();
						fromTASK.setPLWK_CREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						UpfwmUtils.finishSFUpfwmCreate(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								aContext);
						fromOfficeX = IUpfwmFactory.getIUpdcpmSV().getSFUpfwmOffice(fromOrder, 
								fromTASK, 
								aContext);
						IOVUpdbpmOffice.IUpdbpmOfferHome fromOfficeHome = fromOfficeX.getSUBFLOW();
						aContext.put( IUpdcConst.IUpdbm.IUpdbf.SEGMENT, fromOfficeX );
						if( fromOfficeHome.getCOMPONENT() != null ){
							aContext.put( IUpdcConst.IUpdbm.IUpdbf.OFFICE, fromOfficeHome.getCOMPONENT() );
						}
						SFCenterFactory.pushCenterInfo(fromCapital.getIMPLCLASS(),
								IUpdcConst.IUpdbm.IUpdmc.REGION_CODE, 
								fromOfficeX, 
								fromOrder.getCHANNEL() );
					}
					finally{
					
					}
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmResponse finishSFUpfwmComplete( IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmResponse fromASK = null;
					try
					{
						ISystemTemplate.IImplCapital fromJAVA = fromUpdfwm.getJAVA();
						IUpfwmCapital fromCapital = IUpfwmFactory.getIUpdfwmSV( fromJAVA.getIMPLCLASS() );
						if( fromJAVA.isJMDI() )
							fromASK = (IOVUpfwmResponse)ReflectUtils.IReflect.invokeMethod( fromCapital , 
									fromJAVA.getMETHOD() , 
									new Object[]{fromOrder , fromTASK , fromUpdfwm , aContext }, 
									new Class[]{IOVOrderPentium.class, IOVTaskPentium.class, IOVUpdspmLife.class, IUpdcContext.class } );
						else
							fromASK = fromCapital.finishSFUpdfwm( fromOrder, 
									fromTASK, 
									fromUpdfwm, 
									aContext );
					}
					catch( java.lang.Exception aException ){
						log.error( aException.getMessage(),aException );
						ExceptionFactory.throwException( aException );
					}
					finally{
					
					}
					return fromASK;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpdfwmComplete( IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						SFCenterFactory.popCenterInfo();
						UpfsvcManager.getSession().getComposite().clear();
						fromTASK.setPLWK_COMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
					}
					finally{
						
					}
				}
			}
			SFUpdfwmFlowImpl fromUpdfwmImpl = new SFUpdfwmFlowImpl();
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			try
			{
				fromUpdfwmImpl.finishSFUpdfwmCreate(fromOrder, fromTASK, fromUpdfwm, fromLDAP);
				try
				{
					IPlatformTemplate.IUpffmPhone fromPhone = null;
					fromPhone = IUpfwmFactory.getIUpfwmSV().getSFUpfwmUser(
							fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							fromLDAP);
					if( fromPhone == null || fromPhone.isWHITELST() ){
						fromASK = fromUpdfwmImpl.finishSFUpfwmComplete(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromLDAP);
					}
				}
				finally{
					fromUpdfwmImpl.finishSFUpdfwmComplete(fromOrder, fromTASK, fromUpdfwm, fromLDAP);
				}
			}
			finally{
				if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
				if( fromUpdfwmImpl != null ){ fromUpdfwmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishSFUpfmc(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfmc(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IOVTaskPentium fromCREATE = fromTASK.getCREATE();
			java.util.Map fromINDEX = UpfsvcManager.getSession().getIndexs( fromCREATE );
			if( fromCREATE != null && fromINDEX != null && fromINDEX.size() > 0 ){
				UpfsvcManager.getSession().rollbackISQLLite( fromCREATE );
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishSFUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		SFCenterFactory.pushCenterInfo( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, 
				fromUpfwm.getREGION_ID(), 
				IUpdcConst.IEnum.SYSTEM );
		try
		{
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			UpfwmUtils.finishSFUpdbmCreate(fromUpfwm, fromUpdfwm, fromLDAP);
			UpfsvcManager.getRocket().beginTransaction(fromUpfwm, fromUpfwm.getORDER().getOFFER(), aContext);
			try
			{
				ISystemTemplate.IImplCapital fromJAVA = fromUpdfwm.getJAVA();
				IUpfwmCapital fromCapital = IUpfwmFactory.getIUpdfwmSV( fromJAVA.getIMPLCLASS() );
				if( fromJAVA.isJMDI() )
					fromASK = (IOVUpfwmResponse)ReflectUtils.IReflect.invokeMethod( fromCapital , 
							fromJAVA.getMETHOD() , 
							new Object[]{fromUpfwm, fromUpdfwm , fromLDAP }, 
							new Class[]{IOVUpfwmOffer.class, IOVUpdspmLife.class, IUpdcContext.class } );
				else
					fromASK = fromCapital.finishSFUpdfwm( fromUpfwm,
							fromUpdfwm, 
							fromLDAP );
				IUpfwmFactory.getIUpdfmxSV().finishSFUpfwmUatmix(fromUpfwm, 
						fromUpdfwm, 
						fromASK, 
						null, 
						aContext);
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception aEXCEPTION ){
				UpfsvcManager.getRocket().rollbackTransaction();
				IUpfwmFactory.getIUpdfmxSV().finishSFUpfwmUatmix(fromUpfwm, 
						fromUpdfwm, 
						null, 
						aEXCEPTION, 
						aContext);
				ExceptionFactory.throwException( aEXCEPTION );
			}
			finally{
				UpfwmUtils.finishSFUpdbmComplete( fromLDAP );
				if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
			}
		}
		finally{
			SFCenterFactory.popCenterInfo();
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishSFUpdfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			IOVUpfwmRequest fromRequest = null;
			IOVUpfwmResponse fromResponse = null;
			UpfsvcManager.getRocket().beginTransaction();
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpfm = fromUpdfwm.getPLATFORM();
				fromRequest = finishRQKUpfwm(fromUpfwm, fromUpdfwm, aContext);
				Object fromRspBody = null;
				if( fromUpfm.getENDIAN().getDEBUGING() ){
					fromRspBody = IUpfwmFactory.getIUpfwmSV().getSFUpfwmDebug(
							fromUpdfwm.getPLATFORM(), 
							fromUpdfwm.getDIRECTIVE());
				}
				else{ 
					fromRspBody = finishBPKUpfwm(fromUpfwm, 
							fromUpdfwm, 
							fromRequest, 
							aContext);
				}
				fromResponse  = finishASKUpfwm(fromUpfwm,
						fromUpdfwm, 
						fromRspBody, 
						aContext);
				fromASK = UpfwmUtils.ICustom._wrap(fromUpfwm, 
						fromUpdfwm, 
						fromResponse);
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromRequest != null ){ fromRequest = null; }
				if( fromResponse != null ){ fromResponse = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#getSFUpfwmProtocol(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public IUpfwmProtocol getSFUpfwmProtocol(IPlatformTemplate.IUpffmOffer fromUpfm) throws SFException, Exception {
		IUpfwmProtocol fromProtocol = null;
		try
		{
			IPlatformTemplate.IUpffmNetWork fromNetWork = null;
			fromNetWork = UpfwmUtils.ISystem.getUpffmNetWork( fromUpfm );
			fromProtocol = IUpfwmFactory.getIUpdcpSV( fromNetWork.getIMPLCLASS() );
		}
		finally{
			
		}
		return fromProtocol;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmRequest fromUpdcpm = null;
		UpfsvcManager.getRocket().beginTransaction();
		try
		{
			fromUpdcpm = IUpfwmFactory.getIUpfwmSV().getSFUpfwmOffer(fromUpfwm, 
					fromUpdfwm, 
					aContext);
			IUpfwmProtocol fromUpfwmImpl = getSFUpfwmProtocol( fromUpdfwm.getPLATFORM() );
			fromUpdcpm = fromUpfwmImpl.finishRQKUpfwm(fromUpfwm, 
					fromUpdfwm, 
					fromUpdcpm, 
					aContext);
			IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
			if( StringUtils.isBlank( fromUpffmxHome.getBOTTOM() ) == false ){
				IUpfwmFactory.getIUpdfmxSV().finishSFUpfwmMonitor(fromUpfwm, 
						fromUpdfwm, 
						IUpdcConst.IUpfwm.PLWK_ORIGING, 
						fromUpffmxHome.getBOTTOM(), 
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
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmRequest fromUpdcpm,
	        IUpdcContext aContext) throws SFException, Exception {
		Object fromASK = null;
		try
		{
			IUpfwmClient fromNetWork = null;
			IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
			IUpfwmPool fromUpfwmPool = IUpfwmPoolFactory.getUpdbcpPool( fromUpffm );
			try
			{
				IUpfwmMonitor fromMonitor = null;
				fromNetWork = fromUpfwmPool.makeClient();
				ISystemTemplate.IImplCapital fromJAVA = fromUpdfwm.getJAVA();
				fromMonitor = (IUpfwmMonitor)IUpfwmFactory.getIUpdfwmSV( fromJAVA.getIMPLCLASS() );
				if( fromNetWork.isClientReady() == false ){ fromNetWork.login( fromMonitor ); }
				IUpfwmProtocol fromProtocol =  getSFUpfwmProtocol( fromUpdfwm.getPLATFORM() );
				fromASK = fromProtocol.finishBPKUpfwm(fromUpfwm,
						fromUpdfwm, 
						fromNetWork, 
						fromUpdcpm, 
						aContext);
			}
			catch( java.lang.Exception aEXCEPTION ){
				if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage(), aEXCEPTION );
				if( fromNetWork != null ){ fromNetWork.logout(); }
				ExceptionFactory.throwException("IOS0012013", new String[]{fromUpffm.getID(),
						aEXCEPTION.getMessage()}, 
						aEXCEPTION);
			}
			finally{
				if( fromNetWork != null ){
					if( fromNetWork.isClientReady() && fromUpfwmPool.getHBT() == false ){ fromNetWork.logout(); }
					fromUpfwmPool.returnClient( fromNetWork );
				}
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			Object fromRsBody, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		UpfsvcManager.getRocket().beginTransaction();
		try
		{
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			IUpfwmProtocol fromUpfwmImpl = getSFUpfwmProtocol( fromUpdfwm.getPLATFORM() );
			fromASK = fromUpfwmImpl.finishASKUpfwm(fromUpfwm, fromUpdfwm, fromRsBody, aContext);
			if( StringUtils.isBlank( fromUpfom.getRESPONSE() ) == false && fromASK.getRspBody() != null ){
				IOVUpfgsmCatalog  fromUpdcpm = null;
				try
				{
					fromUpdcpm = IUpdcpFactory.getIUpfsmSV().finishASKUpfwmOffer(
							fromUpfom.getRESPONSE(), 
							fromASK.getRspBody(), 
							aContext);
					if (fromUpdcpm != null ) {
						fromASK.setRspBody( fromUpdcpm.getMAPPINGS() );
					}
				}
				finally{
					if( fromUpdcpm != null ){ fromUpdcpm = null; }
				}
			}
			if( StringUtils.isBlank( fromASK.getRspBottom() ) == false ){
				IUpfwmFactory.getIUpdfmxSV().finishSFUpfwmMonitor(fromUpfwm, 
						fromUpdfwm, 
						IUpdcConst.IUpfwm.PLWK_HOMEING, 
						fromASK.getRspBottom(), 
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
		return fromASK;
	}
	
}
