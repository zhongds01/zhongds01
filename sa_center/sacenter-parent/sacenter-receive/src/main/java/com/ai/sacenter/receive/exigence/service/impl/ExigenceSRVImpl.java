package com.ai.sacenter.receive.exigence.service.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFOLQException;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.exigence.ExigenceFactory;
import com.ai.sacenter.receive.exigence.IExigenceConst;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderBase;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketOffer;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketCompose;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

public class ExigenceSRVImpl extends UpdcEclipseImpl implements IExigenceSRV {

	public ExigenceSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rocketDistribute(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMocketRespone rocketDistribute(IOVMsgFExigence fromExigence,
			IUpdcContext aContext) throws SFException, Exception {
		IOVMocketRespone fromRsRsp = null;
		try
		{
			class SFUpdfmxExplainImpl{
				public SFUpdfmxExplainImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRocket
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFRequest _jj_request( IOVMocketCompose fromRocket,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFRequest fromRequest = null;
					try
					{
						IOVMsgFOrderBase fromOrder = fromRocket.getORDER();
						fromRequest = OrderUtils.ICustom._wrap(fromOrder, fromUpdcpm);
						for( java.util.Iterator<IOVMsgFOrderBase> itera = fromRocket.getSUBFLOW().getORDER().getORDER().iterator(); itera.hasNext(); ){
							IOVMsgFOrderBase fromOrderItem = (IOVMsgFOrderBase)itera.next();
							if( StringUtils.equals( fromOrderItem.getORDER_ITEM_ID(), fromOrder.getORDER_ITEM_ID() ) ){ continue; }
							IOVMsgFRequest fromSubOrder = OrderUtils.ICustom._wrap(fromOrderItem, fromUpdcpm);
							for( java.util.Iterator<IOVMsgFUser> iterap = fromSubOrder.getUSER().iterator(); iterap.hasNext(); ){
								IOVMsgFUser fromChild = (IOVMsgFUser)iterap.next();
								IOVMsgFUser fromUser = fromRequest.getUSER( fromSubOrder.getUSER_ID() );
								if( fromUser != null ){ fromUser.mergeAsUser( fromChild ); }
								else{ fromRequest.getUSER().add( new IOVMsgFUser( fromChild ) ); }
							}
						}
					}
					finally{
						
					}
					return fromRequest;
				}
				
				/**
				 * 
				 * @param fromRocket
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMocketConsult rocketExplain( IOVMsgFExigence fromRocket, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVMocketConsult fromConsult = null;
					try
					{
						IProfessionalTemplate.IBusinesKernel fromUpdfmsx = null;
						IOVMocketConsult fromUpdfmx = new IOVMocketConsult( fromRocket );
						IOVMsgFOrderBase _rocket = fromRocket.getORDER().getROCKET();
						IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( _rocket );
						fromUpdfmsx = ExigenceUtils.ISystem.getCOMPOSE( fromRocket, fromUpdcpm );
						if( fromUpdfmsx == null /*按用户分解类*/){
							fromConsult = IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxDefault(fromRocket, 
									fromUpdfmx, 
									fromUpdcpm, 
									aContext);
						}
						else/*按指定分解组件分解*/{
							ISystemTemplate.IImplCapital fromCapital = SystemUtils.ISystem.getSFUpfgkmCapital( fromUpdfmsx.getIMPLCLASS() );
							IBusinesCapital fromUpdcpmImpl = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
							fromConsult = (IOVMocketConsult)ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
									fromCapital.getMETHOD(), 
									new Object[]{fromRocket,
											     fromUpdfmx,
								                 fromUpdcpm,
								                 aContext},
									new Class[]{IOVMsgFExigence.class,
											    IOVMocketConsult.class,
								                IUpfgkmOfferHome.class, 
								                IUpdcContext.class});
						}
					}
					finally{
						
					}
					return fromConsult;
				}
				
				/**
				 * 按开通开通定单方式开通
				 * @param fromRocket
				 * @param fromUpdcpm
				 * @param fromRsRsp
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMocketRespone rocketKernel( IOVMocketCompose fromRocket,
						IUpfgkmOfferHome fromUpdcpm,
						IOVMocketRespone fromRsRsp,
						IUpdcContext aContext) throws SFException, Exception{
					IOVOrderResponse fromOrdRsRsp = null;
					try
					{
						ISystemTemplate.IImplCapital fromCapital = SystemUtils.ISystem.getSFUpfgkmLibrary( fromUpdcpm );
						IBusinesCapital fromUpdcpmImpl = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						fromOrdRsRsp = (IOVOrderResponse)ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
								fromCapital.getMETHOD(), 
								new Object[]{fromRocket.getSUBFLOW(),
							                 fromUpdcpm,
							                 aContext},
								new Class[]{IOVMsgFExigence.class,
							                IUpfgkmOfferHome.class, 
							                IUpdcContext.class});
						fromRsRsp = ExigenceUtils.IRsRsp._wrap(fromRocket, 
								fromOrdRsRsp, 
								fromRsRsp, 
								aContext);
					}
					finally{
						if( fromOrdRsRsp != null ){ fromOrdRsRsp = null; }
					}
					return fromRsRsp;
				}
				
				/**
				 * 按开通开通定单方式开通
				 * @param fromRocket
				 * @param fromUpdcpm
				 * @param fromRsRsp
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMocketRespone orderKernel( IOVMocketCompose fromRocket,
						IUpfgkmOfferHome fromUpdcpm,
						IOVMocketRespone fromRsRsp,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFResponse fromOrdRsRsp = null; 
						IOVMsgFRequest fromRequest = _jj_request(fromRocket, fromUpdcpm, aContext);
						fromOrdRsRsp = IOrderFactory.getIOrderSV().orderDistribute(fromRequest, fromUpdcpm, aContext);
						fromRsRsp = ExigenceUtils.IRsRsp._wrap(fromRocket,
								fromOrdRsRsp, 
								fromRsRsp, 
								aContext);
					}
					finally{
						
					}
					return fromRsRsp;
				}
			}
			SFUpdfmxExplainImpl fromExigeceImpl = new SFUpdfmxExplainImpl();
			IOVMocketConsult fromConsult = null;
			try
			{
				fromConsult = fromExigeceImpl.rocketExplain(fromExigence, aContext);
				IOVMocketConsult.IUpdfmxOfferHome fromUpdfmxHome = fromConsult.getSUBFLOW();
				for( java.util.Iterator<IOVMocketCompose> itera = fromUpdfmxHome.getGROUP().values().iterator(); itera.hasNext(); ){
					IOVMocketCompose fromRocket = (IOVMocketCompose)itera.next();
					try
					{
						if( fromRocket.getBUSINES() == null ){
							ExceptionFactory.throwServiceBus("IOS0011088", new String[]{fromRocket.getORDER().getCATALOG(), 
									fromRocket.getORDER().getBUSINESS() });
						}
						else{
							java.lang.reflect.Method fromMethod = null;
							fromMethod = ExigenceUtils.ISystem.getBUSINESS(fromRocket.getSUBFLOW(), fromRocket.getBUSINES(), aContext);
							if( fromMethod != null /*按开通开通定单方式开通*/){
								fromRsRsp = fromExigeceImpl.rocketKernel(fromRocket, 
										fromRocket.getBUSINES(), 
										fromRsRsp,
										aContext);
							}
							else/*按开通定单项方式开通*/{
								fromRsRsp = fromExigeceImpl.orderKernel(fromRocket, 
										fromRocket.getBUSINES(), 
										fromRsRsp,
										aContext);
							}
						}
					}
					finally{
						
					}
				}
			}
			finally{
				if( fromConsult != null ){ fromConsult = null; }
				if( fromExigeceImpl != null ){ fromExigeceImpl = null; }
			}
		}
		finally{
			
		}
		return fromRsRsp;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rocketReceiveAsyn(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void rocketReceiveAsyn(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFRocketFExigenceImpl{
				SFRocketExigenceImpl _rocket = new SFRocketExigenceImpl();
				public SFRocketFExigenceImpl(){
					super();
				}
				
				/**
				 * 根据当前开通定单项获取当前开通时序定单项
				 * @param fromMBean 全局事务
				 * @param fromUpfgkmHome 开通定单项
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public CarbonList<IOVMocketExigence> rocketTimeBy( MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromUpfgkmHome, 
						IUpdcContext aContext) throws SFException, Exception{
					CarbonList<IOVMocketExigence> fromRocketHome = null;
					try
					{
						fromRocketHome = _rocket.rocketTimeBy(fromMBean, fromUpfgkmHome, aContext);
						fromUpfgkmHome.mergeAsLimite( fromRocketHome );
					}
					finally{
						
					}
					return fromRocketHome;
				}
				
				/**
				 * 开通异步定单分发和历史归档[异步入开通异步单]
				 * @param fromMBean 全局事务
				 * @param fromRocket 开通异步定单
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketComplete(MBeanDelegate fromMBean,
						IOVMocketExigence fromRocket,
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						IPlatformTemplate.IUpffmOffer __platform__ = fromRocket.getORDER().getCOMPLETE();
						if( fromRocket.isHISTORY() /*历史归档*/){
							SFException aEXCEPTION = ExigenceUtils.ISystem.getCOMPLETE( fromRocket );
							fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
							fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE    () );
							if( __platform__ != null && __platform__.getENDIAN().getREQOTING() ){
								IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxLifite(fromMBean, 
										fromRocket, 
										aEXCEPTION, 
										aContext);
							}
							IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxHistory(fromMBean, 
									fromRocket, 
									aEXCEPTION, 
									aContext);
						}
						else/*开通定单项送网元*/{
							_rocket.rocketDistribute( fromMBean, fromRocket, aContext );
							fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
							ExigenceUtils.ICustom._wrap( fromMBean, null, fromRocket );
							fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE    () );
							if( __platform__ != null && __platform__.getENDIAN().getREQOTING() ){
								IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxLifite(fromMBean, 
										fromRocket, 
										null, 
										aContext);
							}
							IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxHistory(fromMBean, 
									fromRocket, 
									aContext);
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 开通异步定单数业务类异常归档[异步入开通异步单]
				 * @param fromMBean 全局事务
				 * @param fromRocket 开通定单项
				 * @param aEXCEPTION 异常类型
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketException( MBeanDelegate fromMBean,
						IOVMocketExigence fromRocket,
						SFException aEXCEPTION,
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						IPlatformTemplate.IUpffmOffer __platform__ = fromRocket.getORDER().getCOMPLETE();
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						ExigenceUtils.ICustom._wrap( fromMBean, aEXCEPTION, fromRocket );
						fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE          () );
						if( __platform__ != null && __platform__.getENDIAN().getREQOTING() ){
							IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxLifite(fromMBean, 
									fromRocket, 
									aEXCEPTION, 
									aContext);
						}
						IExigenceFactory.getIUpdcpmSV().finishSFUpfgkmComplete(fromMBean, 
								fromRocket, 
								aEXCEPTION, 
								aContext);
					}
					finally{
						
					}
				}
				
				/**
				 * 开通异步定单数据库连接类异常归档[异步入开通异步单]
				 * @param fromMBean 全局事务
				 * @param fromRocketHome 开通异步定单
				 * @param aEXCEPTION 异常类型
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketConnectionAsyn( MBeanDelegate fromMBean,
						IUpfgkmCityHome fromRocketHome,
						SFException aEXCEPTION,
						IUpdcContext aContext ) throws SFException,Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator<IOVMocketExigence> itera = fromRocketHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVMocketExigence fromRocket = (IOVMocketExigence)itera.next();
							IOVUpdcpmOffer fromUpdcpm = ExigenceUtils.ISystem.getROCKET( fromRocket, aEXCEPTION, aContext );
							IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmConnection(fromMBean, 
									fromRocket, 
									fromUpdcpm, 
									aEXCEPTION, 
									aContext);
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
				 * 开通异步定单数业务类类异常归档[异步入开通异步单]
				 * @param fromMBean 全局事务
				 * @param fromRocketHome 开通定单项
				 * @param aEXCEPTION 异常类型
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void rocketExceptionAsyn( MBeanDelegate fromMBean,
						IUpfgkmCityHome fromRocketHome,
						SFException aEXCEPTION,
						IUpdcContext aContext ) throws SFException,Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator<IOVMocketExigence> itera = fromRocketHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVMocketExigence fromRocket = (IOVMocketExigence)itera.next();
							fromRocket.setPLWK_CREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
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
								SFException __EXCEPTION__ = ExceptionFactory.getException( exception );
								rocketException(fromMBean, 
										fromRocket,
										__EXCEPTION__, 
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
			SFRocketFExigenceImpl fromRocketImpl = new SFRocketFExigenceImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromRocketImpl.rocketTimeBy(fromMBean, fromUpfgkmHome, aContext);
				for( java.util.Iterator<IOVMocketExigence> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVMocketExigence fromRocket = (IOVMocketExigence)itera.next();
					fromRocket.setPLWK_CREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
					UpfsvcManager.getSession().beginTransaction();
					try
					{
						fromRocketImpl.rocketComplete(fromMBean, 
								fromRocket, 
								aContext);
						UpfsvcManager.getSession().commitTransaction();
					}
					catch( SFOLQException exception ){
						log.error( exception.getMessage(), exception );
						UpfsvcManager.getSession().rollbackTransaction();
						throw exception;
					}
					catch( java.lang.Exception exception ){
						log.error( exception.getMessage(), exception );
						UpfsvcManager.getSession().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( exception );
						fromRocketImpl.rocketException(fromMBean, 
								fromRocket,
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
				fromRocketImpl.rocketConnectionAsyn(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromRocketImpl.rocketExceptionAsyn(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromRocketImpl != null ){ fromRocketImpl._rocket = null; fromRocketImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rocketReceive(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence)
	 */
	public IOVMocketRespone rocketReceive(IOVMsgFExigence fromExigence) throws SFException, Exception {
		IOVMocketRespone fromASK = null;
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		SFRocketExigenceImpl fromRocketImpl = new SFRocketExigenceImpl();
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			UpfsvcManager.getSession().beginTransaction();
			try
			{
				fromMBean.setOBJECTIVE( fromExigence );
				fromASK = rocketDistribute( fromExigence, aContext );
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromRocketImpl.rocketComplete(fromExigence, 
						null, 
						aContext);
				UpfsvcManager.getSession().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
				UpfsvcManager.getSession().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromRocketImpl.rocketCompleteAsyn(fromMBean, 
						fromExigence, 
						aEXCEPTION, 
						aContext);
				throw aEXCEPTION;
			}
			finally{
				
			}
		}
		finally{
			if( fromRocketImpl != null ){ fromRocketImpl = null; }
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromASK;
	}


	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rocketReceiveAsyn(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence[])
	 */
	public void rocketReceiveAsyn(IOVMsgFExigence[] fromExigence) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		SFRocketExigenceImpl fromRocketImpl = new SFRocketExigenceImpl();
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setOBJECTIVE( fromExigence );
			for( int index = 0; fromExigence != null && index < fromExigence.length; index++ ){
				UpfsvcManager.getSession().beginTransaction();
				try
				{
					java.sql.Timestamp _create = new java.sql.Timestamp( System.currentTimeMillis() );
					fromExigence[index].getORDER().getROCKET().setPLWK_CREATE( _create );
					rocketDistribute( fromExigence[index], aContext );
					fromRocketImpl.rocketComplete(fromExigence[index], 
							null, 
							aContext);
					UpfsvcManager.getSession().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					UpfsvcManager.getSession().rollbackTransaction();
					SFException aEXCEPTION  = ExceptionFactory.getException( exception );
					java.sql.Timestamp _complete = new java.sql.Timestamp( System.currentTimeMillis() );
					fromExigence[index].getORDER().getROCKET().setPLWK_COMPLETE( _complete );
					fromRocketImpl.rocketException(fromExigence[index], 
							aEXCEPTION, 
							aContext);
				}
			}
		}
		finally{
			if( fromRocketImpl != null ){ fromRocketImpl = null; }
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}


	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rocketReceiveAsyn(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence[], com.ai.sacenter.SFException)
	 */
	public void rocketReceiveAsyn(IOVMsgFExigence[] fromExigence, 
			SFException aEXCEPTION) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromMBean.setOBJECTIVE( fromExigence );
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			for( int index = 0 ; fromExigence != null && index < fromExigence.length; index++ ){
				IOVMsgFExigence.IMsgFOfferXHome fromRocketHome = fromExigence[index].getORDER();
				IOrderFactory.getIOrderSV().orderException( fromRocketHome.getROCKET(), 
						null, 
						aEXCEPTION, 
						aContext);
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}


	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rocketComplete(com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone)
	 */
	public IOVMocketRespone rocketComplete(IOVMocketRespone fromRocket) throws SFException, Exception {
		IOVMocketRespone fromASK = null;
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			IUpfgkmOfferHome fromUpdcpm = null;
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			UpfsvcManager.getSession().beginTransaction();
			try
			{
				fromMBean.setOBJECTIVE( fromRocket );
				IOVMsgFOrderBase fromOrder = fromRocket.getORDER().getROCKET();
				fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFComplete( fromOrder );
				IExigenceFactory.getIUpdcpmSV().finishSFUpfgkmComplete(fromRocket, aContext);
				fromASK = ExigenceUtils.IRsRsp._wrap(fromRocket, 
						(IOVOrderResponse)null, 
						aContext);
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				IOrderFactory.getIOrderSV().orderComplete(fromOrder, 
						fromUpdcpm, 
						null, 
						aContext);
				UpfsvcManager.getSession().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
				UpfsvcManager.getSession().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				UpdbfsFactory.getIUpdbcSV().orderCompleteAsyn(fromMBean, 
						fromRocket.getORDER().getROCKET(), 
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
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSRV#rabbitReceiveAsyn(com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence[])
	 */
	public void rabbitReceiveAsyn(IOVMocketExigence[] fromExigence) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			class SFRabbitSystemImpl{
				public SFRabbitSystemImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromExigence
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public ISystemTemplate.IUpdbfsLimite getSFRocketLimite( MBeanDelegate fromMBean, 
						IOVMocketExigence fromExigence, 
						IUpdcContext aContext ) throws SFException,Exception{
					ISystemTemplate.IUpdbfsLimite fromLimite = null;
					java.util.Map<String,Object> fromUpffmx = new java.util.HashMap<String,Object>();
					try
					{
						fromUpffmx.put( IExigenceConst.IUpdbm.IUpdbf.EXIGENCE, fromExigence );
						UpfsvcManager.getRocket().beginTransaction(fromExigence, fromUpffmx, aContext);
						try
						{
							ISystemTemplate.IUpdbfsGroup fromLimitess = null;
							fromLimitess = SystemUtils.ISystem.getSFUpffmxOffer( fromExigence.getPRIORITY() );
							if( fromLimitess != null && fromLimitess.getLIMITESS() != null ){
								ISystemTemplate.IUpdbfsLimite fromLimites = null;
								for( java.util.Iterator<ISystemTemplate.IUpdbfsLimite> itera = fromLimitess.getLIMITESS().iterator(); itera.hasNext(); ){
									fromLimites = (ISystemTemplate.IUpdbfsLimite)itera.next();
									try
									{
										if( UpdcpUtils.IUpfvn.decision( fromLimites.getCOMPLEX(), fromUpffmx, aContext ) ){
											fromLimite = fromLimites;
											break;
										}
									}
									catch( java.lang.Exception aException ){
										log.error( aException.getMessage(), aException );
										ExceptionFactory.throwIllegal( "IOS0011090", new String[]{ fromLimite.getID(), aException.getMessage() } );
									}
									finally{
										
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
					}
					finally{
						if( fromUpffmx != null ){ fromUpffmx = null; }
					}
					return fromLimite;
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromExigence
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFRocketLimite( MBeanDelegate fromMBean, 
						IOVMocketExigence fromExigence, 
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						ISystemTemplate.IUpdbfsLimite fromLimite = null, fromDefault = null;
						fromDefault = SystemUtils.ISystem.getSFUpffmxLimite();
						fromLimite = getSFRocketLimite(fromMBean, fromExigence, aContext);
						if( fromLimite == null && fromDefault != null /*采用默认开通时限*/){
							long fromDealLine = Long.parseLong( fromDefault.getEXTEND_ATTR_A() ) - 
									fromExigence.getPRIORITY() * Long.parseLong( fromDefault.getEXTEND_ATTR_B() );
							fromExigence.setPRIORITY ( fromDealLine              );
						}
						else/*采用开通时限规则*/{
							long fromDealLine = TimeUtils.getAsTime() + fromLimite.getPRIORITY();
							fromExigence.setPRIORITY ( fromDealLine              );
						}
					}
					finally{
						
					}
				}
			}
			SFRabbitSystemImpl fromRocketImpl = new SFRabbitSystemImpl();
			try
			{
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromMBean.setOBJECTIVE( fromExigence );
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				ISystemTemplate.IUpdbfsLimite fromDefault = SystemUtils.ISystem.getSFUpffmxOffer();
				for( int index = 0; fromExigence != null && index < fromExigence.length; index++ ){
					SFCenterFactory.pushCenterInfo( IExigenceConst.IUpdbm.IUpdbc.DISTRICT_ID, fromExigence[index].getORDER_REGION_ID() );
					try
					{
						fromBusines = IOrderFactory.getIOrdMixSV().getSFMsgFComptel( fromExigence[index] );
						fromExigence[index].setORDER_ID( ExigenceFactory.getIRemoteDAO().getORDER_ID( ) );
						fromExigence[index].setPRIORITY( fromBusines != null?fromBusines.getPRIORITY():
							fromDefault != null?fromDefault.getPRIORITY():IUpdbfsConst.IUpdbm.ICustom.PRIORITY );
						fromExigence[index].setSTATE   ( IUpdbfsConst.IState.C                         );
						fromRocketImpl.finishSFRocketLimite( fromMBean, fromExigence[index], aContext  );
						for( java.util.Iterator<IOVMocketOffer> itera = fromExigence[index].getORDER().getORDER().iterator(); itera.hasNext(); ){
							IOVMocketOffer fromOsOffer = (IOVMocketOffer)itera.next();
							fromOsOffer.setOFFER_ID ( ExigenceFactory.getIRemoteDAO().getORDER_ID() );
							fromOsOffer.setORDER_ID ( fromExigence[index].getORDER_ID            () );
							fromOsOffer.setREGION_ID( fromExigence[index].getORDER_REGION_ID     () );
							fromOsOffer.setSTATE    ( IUpdbfsConst.IState.C                         );
							UpfsvcManager.getSession().submitISQLHistory( IExigenceConst.IUpdbm.IRemoteDAO, fromOsOffer.getINSTANCE() );
						}
						UpfsvcManager.getSession().submitISQLHistory( IExigenceConst.IUpdbm.IRemoteDAO, fromExigence[index].getINSTANCE() );
					}
					finally{
						SFCenterFactory.popCenterInfo();
					}
				}
			}
			finally{
				if( fromRocketImpl != null ){ fromRocketImpl = null; }
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年5月31日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	class SFRocketExigenceImpl{
		public SFRocketExigenceImpl(){
			super();
		}
		
		/**
		 * 
		 * @param fromMBean
		 * @param fromRocketHome
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		private void rocketLimite(MBeanDelegate fromMBean, 
				CarbonList<IOVMocketExigence> fromRocketHome, 
				IUpdcContext aContext) throws SFException, Exception{
			java.util.Map<Long,java.util.ArrayList<IOVMocketExigence>> fromGroup = new java.util.HashMap<Long,java.util.ArrayList<IOVMocketExigence>>();
			java.util.Map<Long,IOVMocketExigence> fromHigh = new java.util.HashMap<Long,IOVMocketExigence>();
			try
			{
				for( java.util.Iterator<IOVMocketExigence> itera = fromRocketHome.iterator(); itera.hasNext(); ){
					IOVMocketExigence fromRocket = (IOVMocketExigence)itera.next();
					Long _user_id = new Long( fromRocket.getUSER_ID() );
					if( fromGroup.containsKey( _user_id ) == false ){ 
						fromGroup.put( _user_id, new java.util.ArrayList<IOVMocketExigence>() );
						fromHigh.put( _user_id, fromRocket );
					}
					((java.util.List<IOVMocketExigence>)fromGroup.get( _user_id ) ).add( fromRocket );
					IOVMocketExigence __limite__ = (IOVMocketExigence)fromHigh.get( _user_id );
					if( fromRocket.getPRIORITY() > __limite__.getPRIORITY() ){ fromHigh.put( _user_id, fromRocket ); }
				}
				for( java.util.Iterator<IOVMocketExigence> itera = fromHigh.values().iterator(); itera.hasNext(); ){
					IOVMocketExigence __limite__ = (IOVMocketExigence)itera.next();
					java.util.List<IOVMocketExigence> _group_home = (java.util.List<IOVMocketExigence>)fromGroup.get( new Long( __limite__.getUSER_ID() ) );
					if( _group_home == null || _group_home.size() <= 0 ){ continue; }
					for( java.util.Iterator<IOVMocketExigence> iterap = _group_home.iterator(); iterap.hasNext(); ){
						IOVMocketExigence _rocket_home = (IOVMocketExigence)iterap.next();
						if( _rocket_home.getORDER().getPRIORITY() < __limite__.getPRIORITY() ){
							_rocket_home.getORDER().setPRIORITY( __limite__.getPRIORITY() );
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
		 * @param fromUpfgkmHome
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public CarbonList<IOVMocketExigence> rocketTimeBy( MBeanDelegate fromMBean, 
				IUpfgkmCityHome fromUpfgkmHome, 
				IUpdcContext aContext) throws SFException, Exception{
			CarbonList<IOVMocketExigence> _rocket_home = new CarbonList<IOVMocketExigence>();
			try
			{
				ClassUtils.IMerge.merge( fromUpfgkmHome.getCOMPLETE(), _rocket_home );
				_rocket_home = ExigenceFactory.getIRocketDAO( fromMBean.getREPOSITORY() ).getSFRocketLimite( _rocket_home );
				rocketLimite(fromMBean, _rocket_home, aContext);
				ClassUtils.IClass.sort( _rocket_home , new java.util.Comparator<Object>() {
			    	public int compare(Object a, Object b) {
			    		IOVMocketExigence fromRocketA = (IOVMocketExigence)a,fromRocketB = (IOVMocketExigence)b;
			    		long __compare__ = fromRocketA.getORDER().getPRIORITY() - fromRocketB.getORDER().getPRIORITY();
			    		if( __compare__ != 0 ){ return __compare__ > 0?-1:1; }
			    		else{
			    			__compare__ = fromRocketA.getTIMESQ().compareTo( fromRocketB.getTIMESQ() );
			    			return __compare__ == 0?0:(__compare__ > 0?1:-1);
			    		}
					}
				});
			}
			finally{
				
			}
			return _rocket_home;
		}
		
		/**
		 * 异步开通单分发
		 * @param fromMBean
		 * @param fromRocket
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void rocketDistribute( MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IUpdcContext aContext ) throws SFException,Exception{
			IUpfgkmOfferHome fromUpdcpm = null;
			try
			{
				java.lang.reflect.Method fromMethod = null;
				fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
				fromMethod = ExigenceUtils.ISystem.getBUSINESS( fromRocket, fromUpdcpm, aContext );
				if( fromMethod == null/*按开通定单项分发调度*/ ){
					IOVMsgFExigence fromExigece = ExigenceUtils.IRocket._jj_rocket( fromRocket );
					IExigenceFactory.getIUpdcSV().rocketDistribute( fromExigece, aContext );
				}
				else/*按异步开通单转存*/{
					ISystemTemplate.IImplCapital fromCapital = SystemUtils.ISystem.getSFUpfgkmLibrary( fromUpdcpm );
					IBusinesCapital fromUpdcpmImpl = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
					ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
							fromCapital.getMETHOD(), 
							new Object[]{fromRocket,
						                 fromUpdcpm,
						                 aContext},
							new Class[]{IOVMocketExigence.class,
						                IUpfgkmOfferHome.class, 
						                IUpdcContext.class});
				}
			}
			finally{
			
			}
		}
		
		/**
		 * 开通定单转开通消息历史
		 * @param fromEXIGENCE 开通定单
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void rocketComplete( IOVMsgFExigence fromEXIGENCE,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			IUpfgkmOfferHome fromUpdcpm = null;
			try
			{
				fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromEXIGENCE );
				IOrderFactory.getIOrderSV().orderComplete(fromEXIGENCE.getORDER().getROCKET(), 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromUpdcpm != null ){ fromUpdcpm = null; }
			}
		}
		
		/**
		 * 根据开通定单完成开通定单异步事务归档
		 * @param fromMBean 全局事务
		 * @param fromEXIGENCE 开通定单
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws RemoteException
		 * @throws Exception
		 */
		public void rocketCompleteAsyn( MBeanDelegate fromMBean, 
				IOVMsgFExigence fromEXIGENCE,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws RemoteException, Exception{
			try
			{
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				UpdbfsFactory.getIUpdbcSV().rocketCompleteAsyn(fromMBean, 
						fromEXIGENCE,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 开通定单转开通消息失败
		 * @param fromEXIGENCE 开通定单
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void rocketException( IOVMsgFExigence fromEXIGENCE,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			IUpfgkmOfferHome fromUpdcpm = null;
			try
			{
				fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromEXIGENCE );
				IOrderFactory.getIOrderSV().orderException(fromEXIGENCE.getORDER().getROCKET(), 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromUpdcpm != null ){ fromUpdcpm = null; }
			}
		}
		
	}
}

