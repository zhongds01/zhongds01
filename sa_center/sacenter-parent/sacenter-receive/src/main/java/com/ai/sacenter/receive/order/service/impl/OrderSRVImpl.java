package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFESBusException;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.OrderFactory;
import com.ai.sacenter.receive.order.bo.ISARocketFail;
import com.ai.sacenter.receive.order.bo.ISARocketHis;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.order.service.interfaces.IOrderSRV;
import com.ai.sacenter.receive.order.valuebean.IOVRocketOffer;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OrderSRVImpl extends UpdcEclipseImpl implements IOrderSRV {
	public OrderSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#getSFMsgFFail(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVRocketExigence getSFMsgFFail(MBeanDelegate fromMBean,
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVRocketExigence fromMsgFFail = null;
		try
		{
			java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
			fromRequest.setSTATE        ( IUpdcConst.IState.X                        );
			fromRequest.setCOMPLETE_DATE( fromMBean.getCOMPLETE()                    );
			fromRequest.setPLWK_COMPLETE( fromCREATE                                 );
			if( aEXCEPTION != null && aEXCEPTION instanceof SFESBusException ){
				fromRequest.setFAIL_LOG ( SystemUtils.getISTKThrow( aEXCEPTION )     );
			}
			else if( aEXCEPTION != null ){
				fromRequest.setSTATE    ( IUpdcConst.IState.E                        );
				fromRequest.setFAIL_LOG ( SystemUtils.getISTKThrow( aEXCEPTION )     );
			}
			fromMsgFFail = new IOVRocketExigence( fromRequest, new ISARocketFail() );
			fromRequest.getORDER().setCOMPLETE( fromMsgFFail );
			for( java.util.Iterator<IOVRocketOffer> itera = fromMsgFFail.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVRocketOffer fromRocketOffer = (IOVRocketOffer)itera.next();
				fromRocketOffer.setOFFER_ID     ( OrderFactory.getIOrderDAO().getORDER_ID () );
				fromRocketOffer.setORDER_ID     ( fromMsgFFail.getROCKET_ID               () );
				fromRocketOffer.setCREATE_DATE  ( fromMsgFFail.getCREATE_DATE             () );
				fromRocketOffer.setREGION_ID    ( fromMsgFFail.getREGION_ID               () );
				fromRocketOffer.setCOMPLETE_DATE( fromMsgFFail.getCOMPLETE_DATE           () );
			}
		}
		finally{
			
		}
		return fromMsgFFail;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#getSFMsgFHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVRocketExigence getSFMsgFHistory(MBeanDelegate fromMBean,
			IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVRocketExigence fromHistory = null;
		try
		{
			java.sql.Timestamp fromCOMPLETE = null;
			IProfessionalTemplate.IBusinesOffer fromBusines = null;
			if( fromUpdcpm != null ) fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
			fromCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
			fromRequest.setSTATE        ( IUpdcConst.IState.O                    );
			fromRequest.setCOMPLETE_DATE( fromCOMPLETE                           );
			fromRequest.setPLWK_COMPLETE( fromCOMPLETE                           );
			if( aEXCEPTION != null && aEXCEPTION instanceof SFESBusException ){
				fromRequest.setSTATE    ( IUpdcConst.IState.X                    );
				fromRequest.setFAIL_LOG ( SystemUtils.getISTKThrow( aEXCEPTION ) );
			}
			else if( aEXCEPTION != null ){
				fromRequest.setSTATE    ( IUpdcConst.IState.E                    );
				fromRequest.setFAIL_LOG ( SystemUtils.getISTKThrow( aEXCEPTION ) );
			}
			fromHistory = new IOVRocketExigence( fromRequest, new ISARocketHis() );
			fromRequest.getORDER().setCOMPLETE( fromHistory );
			if( fromBusines != null && fromBusines.isCOMPLETE() == false && aEXCEPTION == null ){
				fromHistory.getORDER().getORDER().clear();
			}
			else{
				for( java.util.Iterator<IOVRocketOffer> itera = fromHistory.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVRocketOffer fromRocketOffer = (IOVRocketOffer)itera.next();
					fromRocketOffer.setOFFER_ID     ( OrderFactory.getIOrderDAO().getORDER_ID() );
					fromRocketOffer.setORDER_ID     ( fromHistory.getROCKET_ID               () );
					fromRocketOffer.setCREATE_DATE  ( fromHistory.getCREATE_DATE             () );
					fromRocketOffer.setREGION_ID    ( fromHistory.getREGION_ID               () );
					fromRocketOffer.setCOMPLETE_DATE( fromHistory.getCOMPLETE_DATE           () );
				}
			}
		}
		finally{
			
		}
		return fromHistory;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderReceive(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence)
	 */
	public IOVMsgFResponse orderReceive(IOVRocketExigence fromRequest) throws SFException, Exception {
		IOVMsgFResponse fromASK = null;
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			IUpfgkmOfferHome fromUpdcpm = null;
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			try
			{
				fromMBean.setOBJECTIVE( fromRequest );
				fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRequest );
				if( fromUpdcpm == null ){
					ExceptionFactory.throwServiceBus("IOS0011088", new String[]{fromRequest.getCATALOG(), 
							fromRequest.getBUSINESS() });
				}
				fromASK = orderDistribute(fromRequest, 
						fromUpdcpm, 
						aContext);
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				orderComplete(fromRequest, 
						fromUpdcpm, 
						null, 
						aContext);
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				UpdbfsFactory.getIUpdbcSV().orderCompleteAsyn(fromMBean, 
						fromRequest, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
				throw aEXCEPTION;
			}
			finally{
				
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromASK;
	}

	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderReceiveAsyn(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence[])
	 */
	public void orderReceiveAsyn(IOVRocketExigence fromRequest[]) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			IUpfgkmOfferHome fromUpdcpm = null;
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setOBJECTIVE( fromRequest );
			for( int index = 0; fromRequest != null && index < fromRequest.length; index++ ){
				fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRequest[index] );
				orderReceiveAsyn(fromRequest[index], 
						fromUpdcpm, 
						aContext);
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderReceiveAsyn(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence[], com.ai.sacenter.SFException)
	 */
	public void orderReceiveAsyn(IOVRocketExigence[] fromRequest,
			SFException aEXCEPTION) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			IUpfgkmOfferHome fromUpdcpm = null;
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setOBJECTIVE( fromRequest );
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			for( int index = 0 ; fromRequest != null && index < fromRequest.length; index++ ){
				IOVRocketExigence fromMsgFFail = getSFMsgFFail(fromMBean, 
						fromRequest[index], 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
				for( java.util.Iterator<IOVRocketOffer> itera = fromMsgFFail.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
					fromOffer.setCOMPLETE_DATE( fromMsgFFail.getCOMPLETE_DATE() );
					UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
							new Object[]{ fromOffer.getINSTANCE() });
				}
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
						new Object[]{fromMsgFFail.getINSTANCE()});
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderCompleteAsyn(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence[], com.ai.sacenter.SFException)
	 */
	public void orderCompleteAsyn(IOVRocketExigence[] fromRequest, 
			SFException aEXCEPTION) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			IUpfgkmOfferHome fromUpdcpm = null;
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setOBJECTIVE( fromRequest );
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			for( int index = 0 ; fromRequest != null && index < fromRequest.length; index++ ){
				IOVRocketExigence _history = getSFMsgFHistory(fromMBean, 
						fromRequest[index], 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
				for( java.util.Iterator<IOVRocketOffer> itera = _history.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
					fromOffer.setCOMPLETE_DATE( _history.getCOMPLETE_DATE() );
					UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
							new Object[]{ fromOffer.getINSTANCE() });
				}
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
						new Object[]{_history.getINSTANCE()});
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderReceiveAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void orderReceiveAsyn(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromRocketHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFRocketSyncImpl{
				public SFRocketSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromQueue
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketLimite(MBeanDelegate fromMBean, java.util.List<IOVRocketExigence> fromQueue ) throws SFException,Exception{
					java.util.Map<Long,java.util.ArrayList<IOVRocketExigence>> fromGroup = new java.util.HashMap<Long,java.util.ArrayList<IOVRocketExigence>>();
					java.util.Map<Long,IOVRocketExigence> fromHigh = new java.util.HashMap<Long,IOVRocketExigence>();
					try
					{
						for( java.util.Iterator<IOVRocketExigence> itera = fromQueue.iterator(); itera.hasNext(); ){
							IOVRocketExigence fromOrder = (IOVRocketExigence)itera.next();
							Long aUSER_ID = new Long( fromOrder.getUSER_ID() );
							if( fromGroup.containsKey( aUSER_ID ) == false ){ 
								fromGroup.put( aUSER_ID , new java.util.ArrayList<IOVRocketExigence>() );
								fromHigh.put( aUSER_ID , fromOrder );
							}
							((java.util.List<IOVRocketExigence>)fromGroup.get( aUSER_ID ) ).add( fromOrder );
							IOVRocketExigence fromMsgF = (IOVRocketExigence)fromHigh.get( aUSER_ID );
							if( fromOrder.getPRIORITY() > fromMsgF.getPRIORITY() ) fromHigh.put( aUSER_ID , fromOrder );
							fromMsgF = (IOVRocketExigence)fromHigh.get( aUSER_ID );
							for( java.util.Iterator<IOVRocketExigence> iterap = ((java.util.List<IOVRocketExigence>)fromGroup.get( 
									aUSER_ID ) ).iterator(); iterap.hasNext(); ){
								fromOrder = (IOVRocketExigence)iterap.next();
								if( fromOrder.getPRIORITY() < fromMsgF.getPRIORITY() ){
									fromOrder.getORDER().setPRIORITY( fromMsgF.getPRIORITY() );
								}
							}
						}
					}
					finally{
						if( fromHigh != null ){ fromHigh.clear(); fromHigh = null;}  
						if( fromGroup != null ){ fromGroup.clear(); fromGroup = null;}
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromRocketHome
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public java.util.List<IOVRocketExigence> rocketTimeBy( MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromRocketHome, 
			            IUpdcContext aContext) throws SFException, Exception{
					java.util.List<IOVRocketExigence> fromQueue = new ArrayUQCList();
					try
					{
						ClassUtils.IMerge.merge( fromRocketHome.getCOMPLETE(), fromQueue );
						fromQueue = OrderFactory.getIOrderDAO().getSFRocketDispatch( fromQueue );
						rocketLimite( fromMBean, fromQueue );
						ClassUtils.IClass.sort(fromQueue, new java.util.Comparator<Object>() {
					    	public int compare(Object a, Object b) {
					    		IOVRocketExigence _left = (IOVRocketExigence)a,_right = (IOVRocketExigence)b;
					    		long doCompare = _left.getORDER().getPRIORITY() - _right.getORDER().getPRIORITY();
					    		if( doCompare != 0 ) return doCompare > 0?-1:1;
					    		else{
					    			doCompare = _left.getDONE_DATE().compareTo( _right.getDONE_DATE() );
					    			if( doCompare != 0 ) return doCompare > 0?1:-1;
					    			else{
					    				return _left.getROCKET_ID() - _right.getROCKET_ID() > 0?1:-1;
					    			}
					    		}
							}
						});
						fromRocketHome.mergeAsLimite( fromQueue );
					}
					finally{
						
					}
					return fromQueue;
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromRocketHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketComplete( MBeanDelegate fromMBean, 
						IOVRocketExigence fromRocket, 
			            IUpdcContext aContext) throws SFException, Exception{
					IUpfgkmOfferHome fromUpdcpm = null;
					try
					{
						UpfsvcManager.getMBean().getQuality().setOBJECTIVE( fromRocket );
						fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
						IOrderFactory.getIOrderSV().orderReceiveAsyn(fromRocket, 
								fromUpdcpm, 
								aContext);
					}
					finally{
						if( fromUpdcpm != null ){ fromUpdcpm = null; }
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromRocket
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketException( MBeanDelegate fromMBean, 
						IOVRocketExigence fromRocket,
						SFException aEXCEPTION,
			            IUpdcContext aContext) throws SFException, Exception{
					IUpfgkmOfferHome fromUpdcpm = null;
					try
					{
						IOrderFactory.getIOrderSV().orderException(fromRocket, 
								fromUpdcpm, 
								aEXCEPTION, 
								aContext);
					}
					finally{
						if( fromUpdcpm != null ){ fromUpdcpm = null; }
					}
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromRocketHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketException( MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromRocketHome,
						SFException aEXCEPTION,
			            IUpdcContext aContext) throws SFException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator<IOVRocketExigence> itera = fromRocketHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVRocketExigence fromRocket = (IOVRocketExigence)itera.next();
							UpfsvcManager.getMBean().beginTransaction();
							try
							{
								rocketComplete(fromMBean, 
										fromRocket, 
										aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								log.error( exception.getMessage(), exception );
								UpfsvcManager.getMBean().rollbackTransaction();
								aEXCEPTION = ExceptionFactory.getException( exception );
								rocketException(fromMBean, 
										fromRocket, 
										aEXCEPTION, 
										aContext);
							}
							finally{
							
							}
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						log.error( exception.getMessage(), exception );
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
			}
			SFRocketSyncImpl fromRocketImpl = new SFRocketSyncImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromRocketImpl.rocketTimeBy(fromMBean, fromRocketHome, aContext);
				for( java.util.Iterator<IOVRocketExigence> itera = fromRocketHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVRocketExigence fromRocket = (IOVRocketExigence)itera.next();
					fromRocketImpl.rocketComplete(fromMBean, 
							fromRocket, 
							aContext);
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromRocketImpl.rocketException(fromMBean, 
						fromRocketHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderReceiveAsyn(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFResponse orderReceiveAsyn(IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVMsgFResponse fromASK = null;
		try
		{
			UpfsvcManager.getSession().beginTransaction();
			if( fromUpdcpm == null /*无效开通接入能力*/){
				orderException(fromRequest, 
						fromUpdcpm, 
						null, 
						aContext);
			}
			else/*按开通接入能力适配开通定单处理*/{
				fromASK = orderDistribute(fromRequest, 
						fromUpdcpm, 
						aContext);
				orderComplete(fromRequest, 
						fromUpdcpm, 
						null, 
						aContext);
			}
			UpfsvcManager.getSession().commitTransaction();
		}
		catch(java.lang.Exception aException){
			if( log.isErrorEnabled() ) log.error( aException.getMessage(), aException );
			UpfsvcManager.getSession().rollbackTransaction();
			SFException aEXCEPTION = ExceptionFactory.getException( aException );
			orderException(fromRequest, 
					fromUpdcpm, 
					aEXCEPTION, 
					aContext);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderDistribute(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFResponse orderDistribute(IOVMsgFRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVMsgFResponse fromASK = null;
		try
		{
			class SFMsgFSystemImpl{
				public SFMsgFSystemImpl(){
					super();
				}
				/**
				 * 按照开通接入规范完成预转载用户以及订购关系
				 * @param fromRequest 开通定单
				 * @param fromUpdcpm 开通接入规范
				 * @param fromKernel 预转载规范
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserCustom(IOVMsgFRequest fromRequest, 
						IUpfgkmOfferHome fromUpdcpm,
						IProfessionalTemplate.IBusinesKernel fromKernel,
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						ISystemTemplate.IImplCapital fromCapital = null;
						fromCapital = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromKernel.getIMPLCLASS() );
						IBusinesCapital fromBusines = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						ReflectUtils.IReflect.invokeMethod(fromBusines, 
								fromCapital.getMETHOD(), 
								new Object[]{fromRequest,
							                 fromUpdcpm,
							                 aContext},
								new Class[]{IOVMsgFRequest.class,
							                IUpfgkmOfferHome.class, 
							                IUpdcContext.class});
					}
					finally{
						
					}
				}
				/**
				 * 根据开通定单完成开通定单适配调度
				 * @param fromRequest 开通定单
				 * @param fromUpdcpm 开通接入能力
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFResponse finishSFUserKernel(IOVMsgFRequest fromRequest,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFResponse fromASK = null;
					IOVOrderResponse fromOrdRsRsp = null;
					try
					{
						ISystemTemplate.IImplCapital fromCapital = SystemUtils.ISystem.getSFUpfgkmLibrary( fromUpdcpm );
						IBusinesCapital fromUpdcpmImpl = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						fromOrdRsRsp = (IOVOrderResponse)ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
								fromCapital.getMETHOD(), 
								new Object[]{fromRequest,
							                 fromUpdcpm,
							                 aContext},
								new Class[]{IOVMsgFRequest.class,
							                IUpfgkmOfferHome.class, 
							                IUpdcContext.class});
						fromASK = OrderUtils.IRocket._jj_response(fromRequest,
								fromOrdRsRsp, 
								aContext);
					}
					finally{
						if( fromOrdRsRsp != null ){ fromOrdRsRsp = null; }
					}
					return fromASK;
				}
			}
			SFMsgFSystemImpl fromMsgFImpl = new SFMsgFSystemImpl();
			try
			{
				IProfessionalTemplate.IBusinesKernel fromKernel = null;
				fromKernel = fromUpdcpm.getCATALOG().getPROGRAM( IUpdbfsConst.IUpdbm.ICache.PROGRAM_USER );
				if( fromKernel != null && StringUtils.isBlank( fromKernel.getIMPLCLASS() ) == false/*预转载用户以及订购关系*/){
					fromMsgFImpl.finishSFUserCustom(fromRequest, 
							fromUpdcpm, 
							fromKernel, 
							aContext);
				}
				fromASK = fromMsgFImpl.finishSFUserKernel(fromRequest, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				if( fromMsgFImpl != null ){ fromMsgFImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderDistribute(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMsgFResponse orderDistribute(IOVRocketExigence fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVMsgFResponse fromASK = null;
		try
		{
			class SFOrderCapitalImpl{
				public SFOrderCapitalImpl(){
					super();
				}
				/**
				 * 根据开通消息完成开通定单适配调度
				 * @param fromRocket 开通定单
				 * @param fromUpdcpm 开通接入能力
				 * @param fromCapital 开通接入适配器
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFResponse finishSFMsgFKernel(IOVRocketExigence fromRocket,
						IUpfgkmOfferHome fromUpdcpm,
						ISystemTemplate.IImplCapital fromCapital,
						IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFResponse fromASK = null;
					IOVOrderResponse fromOrdRsRsp = null;
					try
					{
						IBusinesCapital fromBusines = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						fromOrdRsRsp = (IOVOrderResponse)ReflectUtils.IReflect.invokeMethod(fromBusines, 
								fromCapital.getMETHOD(), 
								new Object[]{fromRocket,
							                 fromUpdcpm,
							                 aContext},
								new Class[]{IOVRocketExigence.class,
							                IUpfgkmOfferHome.class, 
							                IUpdcContext.class});
						fromASK = OrderUtils.IRocket._jj_response(fromRocket,
								fromOrdRsRsp, 
								aContext);
					}
					finally{
						if( fromOrdRsRsp != null ){ fromOrdRsRsp = null; }
					}
					return fromASK;
				}
				/**
				 * 根据开通定单完成开通定单适配调度
				 * @param fromRequest 开通定单
				 * @param fromUpdcpm 开通接入能力
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFResponse finishSFUserKernel(IOVRocketExigence fromRequest,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFResponse fromASK = null;
					try
					{
						IOVMsgFRequest fromPentium = null;
						fromPentium = OrderUtils.ICustom._wrap(fromRequest, 
								fromUpdcpm);
						fromASK = orderDistribute(fromPentium, 
								fromUpdcpm, 
								aContext);
					}
					finally{
						
					}
					return fromASK;
				}
			}
			SFOrderCapitalImpl fromCapitalImpl = new SFOrderCapitalImpl();
			try
			{
				java.lang.reflect.Method fromMethod = null;
				ISystemTemplate.IImplCapital fromCapital = null;
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				fromBusines = fromUpdcpm.getCATALOG().getBUSINES();
				fromCapital = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromBusines.getIMPLCLASS() );
				fromMethod = fromCapital.getMethod( new Class[]{IOVRocketExigence.class, 
						IUpfgkmOfferHome.class, 
						IUpdcContext.class} );
				if( fromMethod != null /*按开通消息方式调度*/){
					fromASK = fromCapitalImpl.finishSFMsgFKernel(fromRequest, 
							fromUpdcpm, 
							fromCapital,
							aContext);
				}
				else/*按开通用户方式调度*/{
					fromASK = fromCapitalImpl.finishSFUserKernel(fromRequest, 
							fromUpdcpm,
							aContext);
				}
			}
			finally{
				if( fromCapitalImpl != null ){ fromCapitalImpl = null; }
			}
			
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderComplete(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void orderComplete(IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			IOVRocketExigence fromHistory = getSFMsgFHistory(fromMBean, 
					fromRequest, 
					fromUpdcpm, 
					aEXCEPTION,
					aContext);
			for( java.util.Iterator<IOVRocketOffer> itera = fromHistory.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
				fromOffer.setCOMPLETE_DATE( fromHistory.getCOMPLETE_DATE() );
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
						new Object[]{ fromOffer.getINSTANCE() });
			}
			UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
					new Object[]{ fromHistory.getINSTANCE() });
			if( fromRequest.getINSTANCE() != null ){
				fromRequest.getINSTANCE().setStsToOld();
				fromRequest.getINSTANCE().delete();
				for( java.util.Iterator<IOVRocketOffer> itera = fromRequest.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
					fromOffer.setCOMPLETE_DATE( fromHistory.getCOMPLETE_DATE() );
					fromOffer.getINSTANCE().setStsToOld();
					fromOffer.getINSTANCE().delete();
					UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
							new Object[]{ fromOffer.getINSTANCE() });
				}
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
						new Object[]{ fromRequest.getINSTANCE() });
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrderSRV#orderException(com.ai.sacenter.receive.order.valuebean.IOVRocketExigence, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void orderException(IOVRocketExigence fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			IOVRocketExigence fromMsgFFail = getSFMsgFFail(fromMBean, 
					fromRequest, 
					fromUpdcpm, 
					aEXCEPTION,
					aContext);
			for( java.util.Iterator<IOVRocketOffer> itera = fromMsgFFail.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
				fromOffer.setCOMPLETE_DATE( fromMsgFFail.getCOMPLETE_DATE() );
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
						new Object[]{ fromOffer.getINSTANCE() });
			}
			UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
					new Object[]{fromMsgFFail.getINSTANCE()});
			if( fromRequest.getINSTANCE() != null ){
				fromRequest.getINSTANCE().setStsToOld();
				fromRequest.getINSTANCE().delete();
				for( java.util.Iterator<IOVRocketOffer> itera = fromRequest.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
					fromOffer.setCOMPLETE_DATE( fromRequest.getCOMPLETE_DATE() );
					fromOffer.getINSTANCE().setStsToOld();
					fromOffer.getINSTANCE().delete();
					UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
							new Object[]{ fromOffer.getINSTANCE() });
				}
				UpfsvcManager.getSession().submitISQLLite( IUpdbfsConst.IUpdbm.IOrderDAO, 
						new Object[]{ fromRequest.getINSTANCE() });
			}
		}
		finally{
			
		}
	}
}
