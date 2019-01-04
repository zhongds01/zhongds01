package com.ai.sacenter.provision.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFOLQException;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.dbcp.IUpffmxCapital;
import com.ai.sacenter.provision.service.interfaces.IUpffmxSRV;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpffmxUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpdcpmGroup;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê2ÔÂ25ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpffmxSRVImpl extends UpdcEclipseImpl implements IUpffmxSRV {
	public UpffmxSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpfgkmSuspend(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgkmSuspend(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxNotify(IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					try
					{
						IOVUpfwmNotify fromNotify[] = UpfwmFactory.getIUpffmxDAO().getSFUpffmxHome( fromUpfwm.getUSER_ID(), fromUpfwm.getREGION_ID() );
						for( int index = 0; fromNotify != null && index < fromNotify.length; index++ ){
							if( fromNotify[index].isSUSPEND() ) continue;
							fromNotify[index].getINSTANCE().setStsToOld();
							fromNotify[index].setBACKUP_DATE( fromNotify[index].getORDER_DATE () );
							fromNotify[index].setORDER_DATE ( TimeUtils.getMaxExpire          () );
							fromNotify[index].setHAND_ID    ( fromUpfwm.getSUB_PLAN_NO        () );
							fromNotify[index].setSTATUS     ( IUpfwmConst.IUpdos.SUSPEND         );
							fromNotify[index].setHAND_DATE  ( fromUpfwm.getCREATE_DATE        () );
							UpfsvcManager.getSession().submitISQLHistory(fromTASK, 
									fromNotify[index].getLittle().getREPOSITORY(), 
									fromNotify[index].getINSTANCE() );
						}
					}
					finally{
						
					}
				}
			}
			SFUpffmxExpireImpl fromUpfgkmImpl = new SFUpffmxExpireImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				if( fromTASK.isPARALLEL() == false ){
					fromUpfgkmImpl.finishSFUpffmxNotify(fromOrder, 
							fromTASK, 
							fromUpfwm, 
							aContext);
				}
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpfgkmResume(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgkmResume(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxNotify(IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					try
					{
						IOVUpfwmNotify fromNotify[] = UpfwmFactory.getIUpffmxDAO().getSFUpffmxHome( fromUpfwm.getUSER_ID(), fromUpfwm.getREGION_ID() );
						for( int index = 0; fromNotify != null && index < fromNotify.length; index++ ){
							if( fromNotify[index].isSUSPEND() == false ) continue;
							fromNotify[index].getINSTANCE().setStsToOld();
							fromNotify[index].setORDER_DATE ( fromNotify[index].getBACKUP_DATE() );
							fromNotify[index].setBACKUP_DATE( null                               );
							fromNotify[index].setHAND_ID    ( fromUpfwm.getSUB_PLAN_NO        () );
							fromNotify[index].setSTATUS     ( IUpfwmConst.IUpdos.CREATE          );
							fromNotify[index].setHAND_DATE  ( fromUpfwm.getCREATE_DATE        () );
							UpfsvcManager.getSession().submitISQLHistory(fromTASK, 
									fromNotify[index].getLittle().getREPOSITORY(), 
									fromNotify[index].getINSTANCE() );
						}
					}
					finally{
						
					}
				}
			}
			SFUpffmxExpireImpl fromUpfgkmImpl = new SFUpffmxExpireImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				if( fromTASK.isPARALLEL() == false ){
					fromUpfgkmImpl.finishSFUpffmxNotify(fromOrder, 
							fromTASK, 
							fromUpfwm, 
							aContext);
				}
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpfgkmChange(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgkmChange(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpfwm
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxComplete( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify[],
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpdfmxOffer fromExpireHome = null;
					try
					{
						IUpffmxCapital fromUpffmxImpl = null;
						fromExpireHome = UpffmxUtils.ICustom._jj_notify( fromNotify );
						IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromExpireHome.getORDER();
						for( java.util.Iterator<IUpfgkmCityHome> itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
							IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
							fromUpffmxImpl = IUpfwmFactory.getIUpffmxSV( fromUpfgkmHome.getPLATFORM() );
							fromUpffmxImpl.finishSFUpfgkmChange(fromOrder, 
									fromTASK, 
									fromUpfwm, 
									fromUpfgkmHome, 
									aContext);
						}
					}
					finally{
						if( fromExpireHome != null ){ fromExpireHome = null; }
					}
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpfwm
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxNotify(IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify[],
						IUpdcContext aContext ) throws SFException, Exception{
					try
					{
						for( int index = 0; fromNotify != null && index < fromNotify.length; index++ ){
							fromNotify[index].getINSTANCE().setStsToOld();
							fromNotify[index].setHAND_ID      ( fromUpfwm.getSUB_PLAN_NO  () );
							fromNotify[index].setHAND_DATE    ( fromUpfwm.getCREATE_DATE  () );
							UpfsvcManager.getSession().submitISQLHistory(fromTASK, 
									fromNotify[index].getLittle().getREPOSITORY(), 
									fromNotify[index].getINSTANCE() );
						}
					}
					finally{
						
					}
				}
			}
			SFUpffmxExpireImpl fromUpfgkmImpl = new SFUpffmxExpireImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				if( fromTASK.isPARALLEL() == false ){
					IOVUpfwmNotify fromNotify[] = UpfwmFactory.getIUpffmxDAO().getSFUpffmxHome( fromUpfwm.getUSER_ID(), fromUpfwm.getREGION_ID() );
					if( fromNotify != null && fromNotify.length > 0 ){
						fromUpfgkmImpl.finishSFUpffmxComplete(fromOrder, 
								fromTASK, 
								fromUpfwm, 
								fromNotify, 
								aContext);
						fromUpfgkmImpl.finishSFUpffmxNotify(fromOrder, 
								fromTASK, 
								fromUpfwm, 
								fromNotify, 
								aContext);
					}
				}
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpfgkmHistory(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgkmHistory(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpfwm
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxComplete( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify[],
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpdfmxOffer fromExpireHome = null;
					try
					{
						IUpffmxCapital fromUpffmxImpl = null;
						fromExpireHome = UpffmxUtils.ICustom._jj_notify( fromNotify );
						IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromExpireHome.getORDER();
						for( java.util.Iterator<IUpfgkmCityHome> itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
							IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
							fromUpffmxImpl = IUpfwmFactory.getIUpffmxSV( fromUpfgkmHome.getPLATFORM() );
							fromUpffmxImpl.finishSFUpfgkmHistory(fromOrder, 
									fromTASK, 
									fromUpfwm, 
									fromUpfgkmHome, 
									aContext);
						}
					}
					finally{
						if( fromExpireHome != null ){ fromExpireHome = null; }
					}
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpfwm
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxNotify(IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK,
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify[],
						IUpdcContext aContext ) throws SFException, Exception{
					try
					{
						for( int index = 0; fromNotify != null && index < fromNotify.length; index++ ){
							fromNotify[index].setHAND_ID      ( fromUpfwm.getSUB_PLAN_NO  () );
							fromNotify[index].setSTATUS       ( IUpfwmConst.IUpdos.CANCEL    );
							fromNotify[index].setCOMPLETE_DATE( fromUpfwm.getCREATE_DATE  () );
							fromNotify[index].setHAND_DATE    ( fromUpfwm.getCREATE_DATE  () );
							fromNotify[index].getINSTANCE().setStsToOld();
							fromNotify[index].getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLHistory(fromTASK, 
									fromNotify[index].getLittle().getREPOSITORY(), 
									fromNotify[index].getINSTANCE() );
						}
					}
					finally{
						
					}
				}
			}
			SFUpffmxExpireImpl fromUpfgkmImpl = new SFUpffmxExpireImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				if( fromTASK.isPARALLEL() == false ){
					IOVUpfwmNotify fromNotify[] = UpfwmFactory.getIUpffmxDAO().getSFUpffmxHome( fromUpfwm.getUSER_ID(), fromUpfwm.getREGION_ID() );
					if( fromNotify != null && fromNotify.length > 0 ){
						fromUpfgkmImpl.finishSFUpffmxComplete(fromOrder, 
								fromTASK, 
								fromUpfwm, 
								fromNotify, 
								aContext);
						fromUpfgkmImpl.finishSFUpffmxNotify(fromOrder, 
								fromTASK, 
								fromUpfwm, 
								fromNotify, 
								aContext);
					}
				}
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpfgkmHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxComplete( MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdfmxOffer fromExpireHome = null;
					try
					{
						IUpffmxCapital fromUpffmxImpl = null;
						fromExpireHome = UpffmxUtils.ICustom._jj_notify( (IOVUpfwmNotify[])fromUpfgkmHome.getCOMPLETE().toArray( new IOVUpfwmNotify[]{} ) );
						IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromExpireHome.getORDER();
						for( java.util.Iterator<IUpfgkmCityHome> itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
							fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
							fromUpffmxImpl = IUpfwmFactory.getIUpffmxSV( fromUpfgkmHome.getPLATFORM() );
							fromUpffmxImpl.finishSFUpfgkmHistory(fromMBean, 
									fromUpfgkmHome, 
									aContext);
						}
					}
					finally{
						if( fromExpireHome != null ){ fromExpireHome = null; }
					}
				}
			}
			SFUpffmxExpireImpl fromUpfgkmImpl = new SFUpffmxExpireImpl();
			try
			{
				fromUpfgkmImpl.finishSFUpffmxComplete(fromMBean, fromUpfgkmHome, aContext);
				for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotifyHome = (IOVUpfwmNotify)itera.next();
					fromNotifyHome.setHAND_ID      ( fromMBean.getORDER_ID     () );
					fromNotifyHome.setSTATUS       ( IUpfwmConst.IUpdos.CANCEL    );
					fromNotifyHome.setCOMPLETE_DATE( fromMBean.getCREATE       () );
					fromNotifyHome.setHAND_DATE    ( fromMBean.getCREATE       () );
					fromNotifyHome.getINSTANCE().setStsToOld();
					fromNotifyHome.getINSTANCE().delete();
					UpfsvcManager.getSession().submitISQLHistory(IUpfwmConst.IUpfwm.IUpfwmDAO, 
							fromNotifyHome.getINSTANCE() );
				}
			}
			finally{
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpfgkmExpire(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfwmSyncImpl{
				public SFUpfwmSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void expireDistribute(MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome, 
						IUpdcContext aContext) throws SFException,Exception{
					try
					{
						IUpffmxCapital fromUpffmxImpl = null;
						fromUpffmxImpl = IUpfwmFactory.getIUpffmxSV( fromUpfgkmHome.getPLATFORM() );
						fromUpffmxImpl.finishSFUpfgkmExpire(fromMBean, 
								fromUpfgkmHome, 
								aContext);
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)itera.next();
							UpfwmUtils.ICustom._wrap(fromMBean, null, fromINDEX);
							fromINDEX.getINSTANCE().setStsToOld();
							fromINDEX.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLHistory( fromINDEX.getINSTANCE() );
						}
					}
					finally{
						
					}
				}

				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void expireConnectionAsyn(MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome, 
						SFException aEXCEPTION,
						IUpdcContext aContext) throws SFException,Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)itera.next();
							UpfwmUtils.ICustom._wrap(fromMBean, aEXCEPTION, fromINDEX);
							UpfsvcManager.getSession().submitISQLLite( fromINDEX.getINSTANCE() );
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void expireExceptionAsyn(MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpfgkmHome, 
						SFException aEXCEPTION,
						IUpdcContext aContext) throws SFException,Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)itera.next();
							fromMBean.setCREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
							IUpfgkmCityHome fromCityHome = null;
							UpfsvcManager.getMBean().beginTransaction();
							try
							{
								fromCityHome = new IUpfgkmCityHome( fromINDEX.getPLATFORM(), fromINDEX.getREGION_ID() ) ;
								fromCityHome.getCOMPLETE().add( fromINDEX );
								expireDistribute(fromMBean, fromCityHome, aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								log.error( exception.getMessage(), exception );
								UpfsvcManager.getMBean().rollbackTransaction();
								fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
								aEXCEPTION = ExceptionFactory.getException( exception );
								UpfwmUtils.ICustom._wrap(fromMBean, aEXCEPTION, fromINDEX);
								fromINDEX.getINSTANCE().setStsToOld();
								fromINDEX.getINSTANCE().delete();
								UpfsvcManager.getSession().submitISQLLifite( fromINDEX.getINSTANCE() );
							}
							finally{
								if( fromCityHome != null ){ fromCityHome = null; }
							}
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
			}
			SFUpfwmSyncImpl fromUpfwmTfImpl = new SFUpfwmSyncImpl();
			IOVUpdfmxOffer fromExpireHome = null;
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromExpireHome = UpffmxUtils.ICustom._jj_expire( fromUpfgkmHome );
				IOVUpdfmxOffer.IUpdfmxOfferHome fromOrderHome = fromExpireHome.getORDER();
				for( java.util.Iterator<IUpfgkmCityHome> itera = fromOrderHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
					IUpfgkmCityHome fromUpfgkmCityHome = (IUpfgkmCityHome)itera.next();
					fromMBean.setCREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						fromUpfwmTfImpl.expireDistribute(fromMBean, 
								fromUpfgkmCityHome, 
								aContext);
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( SFOLQException exception ){
						if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
						UpfsvcManager.getMBean().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( exception );
						fromUpfwmTfImpl.expireConnectionAsyn(fromMBean, 
								fromUpfgkmCityHome, 
								aEXCEPTION, 
								aContext);
					}
					catch( java.lang.Exception exception ){
						if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
						UpfsvcManager.getMBean().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( exception );
						fromUpfwmTfImpl.expireExceptionAsyn(fromMBean, 
								fromUpfgkmCityHome, 
								aEXCEPTION, 
								aContext);
					}
					finally{
						
					}
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromExpireHome != null ){ fromExpireHome = null; }
				if( fromUpfwmTfImpl != null ){ fromUpfwmTfImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmxSRV#finishSFUpffmx(com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffmx(IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfxExpireImpl{
				public SFUpfxExpireImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromUpdfmx
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpmOffer getSFUpffxExpire( IUpdfmxExpire fromUpdfmx, IUpdcContext aContext) throws SFException, Exception{
					IOVUpdcpmOffer fromUpdcpm = null;
					try
					{
						IProgramTemplate.IUpdfcmpOffer __EXPIRE__ = UpdcpmUtils.getEXPIRE();
						if( __EXPIRE__ != null && __EXPIRE__.getCATALOG().size() <= 0 ){
							fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromUpdfmx, __EXPIRE__ );
							fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.EXPIRE, fromUpdfmx );
						}
						else if( __EXPIRE__ != null ){
							fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromUpdfmx, __EXPIRE__ );
							fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.EXPIRE, fromUpdfmx );
							IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
							IUpdcpmGroup fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(__EXPIRE__.getID(), 
									fromUpdcpm.getSUBFLOW(), 
									aContext);
							if( fromGroup != null ){ fromUpdcpmHome.setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
						}
					}
					finally{
						
					}
					return fromUpdcpm;
				}
				
				/**
				 * 
				 * @param fromUpdfmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffxExpire( IUpdfmxExpire fromUpdfmx, 
						IOVUpdcpmOffer fromUpdcpm, 
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
						ISystemTemplate.IImplCapital fromCapital = fromUpdcpmHome.getIMPLCLASS();
						IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
						ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
								fromCapital.getMETHOD(), 
								new Object[]{ fromUpdfmx, 
										      fromUpdcpm,
							                  aContext }, 
								new Class[]{ IUpdfmxExpire.class, 
										     IOVUpdcpmOffer.class, 
							                 IUpdcContext.class });
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromUpdfmx
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffxException( IUpdfmxExpire fromUpdfmx, 
						SFException aEXCEPTION, 
						IUpdcContext aContext ) throws SFException,Exception{
					try
					{
						throw aEXCEPTION;
					}
					finally{
						
					}
				}
			}
			SFUpfxExpireImpl fromExpireImpl = new SFUpfxExpireImpl();
			UpfsvcManager.getSession().beginTransaction();
			try
			{
				IUpdfmxDirectory __EXPIRE__ = UpfsvcManager.getSession().getIUpfxExpire();
				if( __EXPIRE__ != null && __EXPIRE__.getDirectory().size() > 0 ){
					for( java.util.Iterator<IUpdfmxEntry> itera = __EXPIRE__.getDirectory().iterator(); itera.hasNext(); ){
						IUpdfmxExpire fromUpdfmx = (IUpdfmxExpire)itera.next();
						UpfsvcManager.getSession().beginTransaction();
						try
						{
							IOVUpdcpmOffer fromUpdcpm = fromExpireImpl.getSFUpffxExpire( fromUpdfmx, aContext );
							if( fromUpdcpm != null ){
								fromExpireImpl.finishSFUpffxExpire(fromUpdfmx, fromUpdcpm, aContext);
							}
							UpfsvcManager.getSession().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							log.error( exception.getMessage(), exception );
							UpfsvcManager.getSession().rollbackTransaction();
							SFException aEXCEPTION = ExceptionFactory.getException( exception );
							fromExpireImpl.finishSFUpffxException(fromUpdfmx, 
									aEXCEPTION, 
									aContext);
						}
						finally{
							
						}			
					}
				}
				UpfsvcManager.getSession().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getSession().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			
		}
	}

}
