package com.ai.sacenter.core.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.service.interfaces.IUpdcmqSRV;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFOLQException;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.util.ArrayUQList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IPeriodGraphToken;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-30</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcmqSRVImpl extends UpdcEclipseImpl implements IUpdcmqSRV {

	public UpdcmqSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcmqSRV#finishSFUpdcmqCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVQueuePentium finishSFUpdcmqCreate(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVQueuePentium fromQueue = null;
		try
		{
			fromQueue = new IOVQueuePentium();
			java.sql.Timestamp fromCREATE = BasicFactory.getIBaseSV().getSysdate();
			IConfigDefine.IGlobalDefine fromConfigItem = IConfigDefine.getINSTANCE().getConfigItem();
			ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
			fromQueue.setQUEUE_ID( UpdcFactory.getIUpdcDAO().getPLQK_ID() );
			fromQueue.setORDER_ID( fromOrder.getORDER_ID() );
			fromQueue.setUSER_ID( fromOrder.getUSER_ID() );
			fromQueue.setBILL_ID( fromOrder.getBILL_ID() );
			fromQueue.setPLQK_ID( fromTASK.getTASK_ID() );
			fromQueue.setCATEGORY( IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
			fromQueue.setPLATFORM ( fromTASK.getPLATFORM() );
			fromQueue.setPROGRAM  ( fromUpdbpm.getPROGRAM());
			fromQueue.setREGION_ID( fromOrder.getREGION_ID() );
			fromQueue.setSRC_SYSTEM(fromOrder.isHUMAN() ? IUpdcConst.IUpdbm.IUpdbf.HUMAN
							: IUpdcConst.IUpdbm.IUpdbf.NORMAL);
			fromQueue.setREDO_TIMES( fromConfigItem.getCONTROL().getREDO_TIMES() );
			fromQueue.setDONE_TIMES( 0l );
			fromQueue.setCREATE_DATE( fromCREATE );
			fromQueue.setSTATE( IUpdcConst.IState.C );
			fromQueue.setCOMPLETE_DATE( fromCREATE );
		}
		finally{
			
		}
		return fromQueue;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcmqSRV#finishSFUpdcmqCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpdcmqCreate(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVQueuePentium fromQueue = null;
			fromQueue = finishSFUpdcmqCreate(fromOrder, fromTASK, aContext);
			fromQueue.setPRIORITY( fromOrder.getPRIORITY() );
			fromQueue.setPLWK_CODING( aEXCEPTION.getFaultCode() );
			fromQueue.setPLWK_DESCRIBE( aEXCEPTION.getMessage() );
			fromTASK.setSTATE( IUpdcConst.IState.D );
			fromTASK.getORDER().getTOKEN().setToken( IPeriodGraphToken.IToken.QUEUEING );
			UpfsvcManager.getSession().submitISQLLite(fromTASK, fromQueue.getINSTANCE() );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcmqSRV#finishSFTaskActive(com.ai.sacenter.core.valuebean.IOVQueuePentium, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskActive(IOVQueuePentium fromQueue, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVTaskPentium fromTASK = IUpdcFactory.getIUpdwfSV().getSFTask( fromQueue );
			if( fromTASK != null ){
				IUpdcFactory.getISystemSV().finishSFTask(fromTASK, aContext);
			}
		}
		catch( java.lang.Exception aEXCEPTION ){
			throw aEXCEPTION;
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcmqSRV#finishSFUpdcmqComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdcmqComplete(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpdfmxHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpdcmqSyncImpl{
				public SFUpdcmqSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromUpdfmxHome
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public ArrayUQList queueTimeBy( IUpfgkmCityHome fromUpdfmxHome ) throws SFException,Exception{
					ArrayUQList fromUpfwmHome = new ArrayUQList();
					java.util.Map fromGroup = new java.util.HashMap();
					java.util.Map fromHigh = new java.util.HashMap();
					try
					{
						ClassUtils.IMerge.merge( fromUpdfmxHome.getCOMPLETE(), fromUpfwmHome );
						fromUpfwmHome = UpdcFactory.getIUpdcDAO().getSFQueue( fromUpfwmHome );
						for( java.util.Iterator itera = fromUpfwmHome.iterator(); itera.hasNext(); ){
							IOVQueuePentium fromQueue = (IOVQueuePentium)itera.next();
							if( fromGroup.containsKey( fromQueue.getBILL_ID() ) == false ){ 
								fromGroup.put( fromQueue.getBILL_ID() , new java.util.ArrayList() );
								fromHigh.put( fromQueue.getBILL_ID() , fromQueue );
							}
							((java.util.List)fromGroup.get( fromQueue.getBILL_ID() ) ).add( fromQueue );
							IOVQueuePentium fromHight = (IOVQueuePentium)fromHigh.get( fromQueue.getBILL_ID() );
							if( fromQueue.getPRIORITY() > fromHight.getPRIORITY() ) fromHigh.put( fromQueue.getBILL_ID() , fromQueue );
							fromHight = (IOVQueuePentium)fromHigh.get( fromQueue.getBILL_ID() );
							java.util.List fromBILL = (java.util.List)fromGroup.get( fromQueue.getBILL_ID() );
							for( java.util.Iterator iterap = fromBILL.iterator(); iterap.hasNext(); ){
								fromQueue = (IOVQueuePentium)iterap.next();
								if( fromQueue.getPRIORITY() < fromHight.getPRIORITY() ){
									fromQueue.getORDER().setPRIORITY( fromHight.getPRIORITY() );
								}
							}
						}
						ClassUtils.IClass.sort( fromUpfwmHome, new java.util.Comparator() {
					    	public int compare(Object a, Object b) {
					    		IOVQueuePentium fromLeft = (IOVQueuePentium)a,fromRight = (IOVQueuePentium)b;
					    		long doCompare = fromLeft.getORDER().getPRIORITY() - fromRight.getORDER().getPRIORITY();
					    		if( doCompare != 0 ) return doCompare > 0?-1:1;
					    		else{
					    			doCompare = fromLeft.getTIMESQ().compareTo( fromRight.getTIMESQ() );
					    			return doCompare == 0?0:(doCompare > 0?1:-1);
					    		}
							}
						});
						fromUpdfmxHome.mergeAsLimite( fromUpfwmHome );
					}
					finally{
						if( fromHigh != null ){ fromHigh.clear(); fromHigh = null;}  
						if( fromGroup != null ){ fromGroup.clear(); fromGroup = null;}
					}
					return fromUpfwmHome;
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromQueue
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void queueComplete( MBeanDelegate fromMBean, 
						IOVQueuePentium fromQueue,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IUpdcFactory.getIUpdcpmSV().finishSFUpdcmqComplete(fromQueue, aContext);
						fromQueue.setSTATE        ( IUpdcConst.IState.O                                  );
						fromQueue.setPLWK_COMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromQueue.setCOMPLETE_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromQueue.getINSTANCE().setStsToOld();
						fromQueue.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLHistory( fromQueue.getINSTANCE() );
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromQueue
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void queueException(MBeanDelegate fromMBean, 
						IOVQueuePentium fromQueue,
						SFException aEXCEPTION,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						fromQueue.setSTATE        ( IUpdcConst.IState.E                    );
						fromQueue.setPLWK_COMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromQueue.setCOMPLETE_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromQueue.setRESULT       ( SystemUtils.getISTKThrow( aEXCEPTION ) );
						fromQueue.getINSTANCE().setStsToOld();
						fromQueue.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLifite( fromQueue.getINSTANCE() );
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromQueueHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void queueConnectionAsyn(MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromQueueHome,
						SFException aEXCEPTION,
						IUpdcContext aContext) throws SFException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromQueueHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVQueuePentium fromQueue = (IOVQueuePentium)itera.next();
							fromQueue.setRESULT ( SystemUtils.getISTKThrow( aEXCEPTION ) );
							UpfsvcManager.getSession().submitISQLLite( fromQueue.getINSTANCE() );
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
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromQueueHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void queueExceptionAsyn(MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromQueueHome,
						SFException aEXCEPTION,
						IUpdcContext aContext) throws SFException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromQueueHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVQueuePentium fromQueue = (IOVQueuePentium)itera.next();
							fromQueue.setPLWK_CREATE  ( new java.sql.Timestamp( System.currentTimeMillis() ) );
							fromQueue.setSTATE        ( IUpdcConst.IState.R           );
							fromQueue.setDONE_TIMES   ( fromQueue.getDONE_TIMES() + 1 );
							UpfsvcManager.getMBean().beginTransaction();
							try
							{
								queueComplete(fromMBean, 
										fromQueue, 
										aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								log.error( exception.getMessage(), exception );
								UpfsvcManager.getMBean().rollbackTransaction();
								aEXCEPTION = ExceptionFactory.getException( exception );
								queueException(fromMBean, 
										fromQueue, 
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
			SFUpdcmqSyncImpl fromUpdcmqImpl = new SFUpdcmqSyncImpl();
			UpfsvcManager.getMBean().beginTransaction();
			ArrayUQList fromQueueHome = null;
			try
			{
				fromQueueHome = fromUpdcmqImpl.queueTimeBy( fromUpdfmxHome );
				for( java.util.Iterator itera = fromQueueHome.iterator(); itera.hasNext(); ){
					IOVQueuePentium fromQueue = (IOVQueuePentium)itera.next();
					fromQueue.setPLWK_CREATE  ( new java.sql.Timestamp( System.currentTimeMillis() ) );
					fromQueue.setSTATE        ( IUpdcConst.IState.R           );
					fromQueue.setDONE_TIMES   ( fromQueue.getDONE_TIMES() + 1 );
					UpfsvcManager.getSession().beginTransaction();
					try
					{
						fromUpdcmqImpl.queueComplete( fromMBean, 
								fromQueue, 
								aContext );
						UpfsvcManager.getSession().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
						UpfsvcManager.getSession().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( exception );
						fromUpdcmqImpl.queueException(fromMBean, 
								fromQueue, 
								aEXCEPTION, 
								aContext);
					}
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( SFOLQException exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUpdcmqImpl.queueConnectionAsyn(fromMBean, 
						fromUpdfmxHome, 
						aEXCEPTION, 
						aContext);
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUpdcmqImpl.queueExceptionAsyn(fromMBean, 
						fromUpdfmxHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromUpdcmqImpl != null ){ fromUpdcmqImpl = null; }
			}
		}
		finally{
			
		}
	}

}
