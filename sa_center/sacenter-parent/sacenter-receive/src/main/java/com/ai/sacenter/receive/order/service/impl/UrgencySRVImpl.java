package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.ICustomFactory;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.OrderFactory;
import com.ai.sacenter.receive.order.service.interfaces.IUrgencySRV;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyOffer;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyUser;
import com.ai.sacenter.receive.util.UrgencyUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年10月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UrgencySRVImpl extends UpdcEclipseImpl implements IUrgencySRV{
	public UrgencySRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IUrgencySRV#urgencyReceiveAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void urgencyReceiveAsyn(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUrgencyHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUrgencySyncImpl{
				public SFUrgencySyncImpl(){
					super();
				}
				
				/**
				 * 紧急定单分发调度
				 * @param fromMBean
				 * @param fromUrgency
				 * @param fromUser
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void urgencyDistribute( MBeanDelegate fromMBean,
						IOVUrgencyUser fromUrgency,
						IUpdcContext aContext ) throws SFException,Exception{
					IUpfgkmOfferHome fromUpdcpm = null;
					try
					{
						IOVUser fromUser = ICustomFactory.getICustomSV().getSFUserByUserId(fromUrgency.getUSER_ID(), 
								fromUrgency.getUSER_REGION_ID() );
						if( fromUser == null ){
							urgencyException(fromMBean, fromUrgency, aContext);
						}
						else{
							IOVMsgFRequest fromRequest = UrgencyUtils.ICustom._wrap(fromUser, fromUrgency, aContext);
							fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFUrgencyBusines( fromRequest );
							if( fromUpdcpm == null ){
								urgencyException(fromMBean, fromUrgency, null, aContext);
							}
							else{
								IOrderFactory.getIOrderSV().orderDistribute(fromRequest, fromUpdcpm, aContext);
								urgencyHistory(fromMBean, fromUrgency, aContext);
							}
						}
					}
					finally{
						if( fromUpdcpm != null ){ fromUpdcpm = null; }
					}
				}
				
				/**
				 * 紧急定单异常分发调度
				 * @param fromMBean
				 * @param fromUrgencyHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void urgencyExceptionAsyn( MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUrgencyHome,
						SFException aEXCEPTION,
						IUpdcContext aContext ) throws SFException,Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator<IOVUrgencyUser> itera = fromUrgencyHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUrgencyUser fromUrgency = (IOVUrgencyUser)itera.next();
							UpfsvcManager.getMBean().beginTransaction();
							try
							{
								urgencyDistribute(fromMBean, 
										fromUrgency, 
										aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception aException ){
								if (log.isErrorEnabled()) log.error(aException.getMessage(), aException);
								UpfsvcManager.getMBean().rollbackTransaction();
								aEXCEPTION = ExceptionFactory.getException(aException);
								urgencyException(fromMBean, 
										fromUrgency,
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
				}
				
				/**
				 * 紧急定单转历史归档
				 * @param fromMBean
				 * @param fromUrgency
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void urgencyHistory( MBeanDelegate fromMBean,
						IOVUrgencyUser fromUrgency,
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						for (java.util.Iterator<IOVUrgencyOffer> itera = fromUrgency.getORDER().iterator(); itera.hasNext();) {
							IOVUrgencyOffer fromOffer = (IOVUrgencyOffer) itera.next();
							fromOffer.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
							fromOffer.setSTATE        ( IUpdcConst.IState.O     );
							fromOffer.getINSTANCE().setStsToOld();
							fromOffer.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLHistory( IUpdbfsConst.IUpdbm.IUrgencyDAO, 
									fromOffer.getINSTANCE());
						}
						fromUrgency.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
						fromUrgency.setSTATE        ( IUpdcConst.IState.O     );
						fromUrgency.getINSTANCE().setStsToOld();
						fromUrgency.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLHistory( IUpdbfsConst.IUpdbm.IUrgencyDAO, 
								fromUrgency.getINSTANCE());
					}
					finally{
						
					}
				}
				
				/**
				 * 紧急定单其他异常完成
				 * @param fromMBean
				 * @param fromUrgency
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void urgencyException( MBeanDelegate fromMBean,
						IOVUrgencyUser fromUrgency,
						SFException aEXCEPTION,
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromUrgency.setSTATE        ( IUpdcConst.IState.X                 );
						fromUrgency.setCOMPLETE_DATE( fromMBean.getCOMPLETE             ());
						if( aEXCEPTION != null ){
							fromUrgency.setSTATE    ( IUpdcConst.IState.E                 );
							fromUrgency.setFAIL_LOG ( SystemUtils.getISTKThrow(aEXCEPTION));
						}
						fromUrgency.getINSTANCE().setStsToOld();
						fromUrgency.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLifite( IUpdbfsConst.IUpdbm.IUrgencyDAO, 
								fromUrgency.getINSTANCE() );
					}
					finally{
						
					}
				}
				
				/**
				 * 用户资料级异常完成
				 * @param fromMBean
				 * @param fromUrgency
				 * @param fromUser
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void urgencyException( MBeanDelegate fromMBean,
						IOVUrgencyUser fromUrgency,
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromUrgency.setSTATE        ( IUpdcConst.IState.F     );
						fromUrgency.setCOMPLETE_DATE( fromMBean.getCOMPLETE ());
						fromUrgency.getINSTANCE().setStsToOld();
						fromUrgency.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLifite( IUpdbfsConst.IUpdbm.IUrgencyDAO, fromUrgency.getINSTANCE() );
					}
					finally{
						
					}
				}
			}
			SFUrgencySyncImpl fromUrgencyImpl = new SFUrgencySyncImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				OrderFactory.getIUrgencyDAO().getSFUrgencyUser( fromUrgencyHome );
				for( java.util.Iterator<IOVUrgencyUser> itera = fromUrgencyHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUrgencyUser fromUrgency = (IOVUrgencyUser)itera.next();
					UpfsvcManager.getSession().beginTransaction();
					try
					{
						fromUrgencyImpl.urgencyDistribute(fromMBean, 
								fromUrgency, 
								aContext);
						UpfsvcManager.getSession().commitTransaction();
					}
					catch( java.lang.Exception aException ){
						if (log.isErrorEnabled()) log.error(aException.getMessage(), aException);
						UpfsvcManager.getSession().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException(aException);
						fromUrgencyImpl.urgencyException(fromMBean, 
								fromUrgency,
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
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUrgencyImpl.urgencyExceptionAsyn(fromMBean, 
						fromUrgencyHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		finally{
			
		}
	}

}
