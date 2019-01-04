package com.ai.sacenter.tykt.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFOLQException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.bo.ISAProvision;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.tykt.IUpfgkmConst;
import com.ai.sacenter.tykt.UpfgkmFactory;
import com.ai.sacenter.tykt.bo.ISAEquipment;
import com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSRV;
import com.ai.sacenter.tykt.util.IUpfgkmUtils;
import com.ai.sacenter.tykt.valuebean.IOVUpfgkmOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年2月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpfgkmSRVImpl extends UpdcEclipseImpl implements ISFUpfgkmSRV {

	public SFUpfgkmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSRV#finishSFUpfwmCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfwmCreate(IOVOrderPentium fromOrder, IOVTaskPentium fromTASK, IOVUpdspmLife fromUpdfwm, IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		IOVUpfwmOffer fromUpfwm = null;
		try
		{
			fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext);
			if( fromTASK.isPARALLEL() == false /*正式割接*/){
				IOVUpfgkmOffer fromINDEX = IUpfgkmUtils.ICustom._wrap(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
				UpfsvcManager.getSession().submitISQLLite(fromTASK, 
						fromUpfwm.getORDER().getREPOSITORY(), 
						fromINDEX.getINSTANCE() );
				fromUpfwm.getORDER().setPASSIVE( fromINDEX );
			}
			IUpfwmFactory.getIUpffmSV().finishSFUpfwmCreate(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUpfwm, 
					aContext);
		}
		finally{
			if( fromUpfwm != null ){ fromUpfwm = null; }
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSRV#finishSFUpfwmChange(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfwmChange(IOVOrderPentium fromOrder, IOVTaskPentium fromTASK, IOVUpdspmLife fromUpdfwm, IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		IOVUpfwmOffer fromUpfwm = null;
		try
		{
			fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext);
			if( IUpfgkmUtils.IIfElse.isCHANGE( fromUpfwm, fromUpdfwm, aContext ) ){
				if( fromTASK.isPARALLEL() == false /*正式割接*/){
					IOVUpfgkmOffer fromINDEX = IUpfgkmUtils.ICustom._wrap(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							fromUpfwm, 
							aContext);
					UpfsvcManager.getSession().submitISQLLite(fromTASK, 
							fromUpfwm.getORDER().getREPOSITORY(), 
							fromINDEX.getINSTANCE() );
					fromUpfwm.getORDER().setPASSIVE( fromINDEX );
				}
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
		}
		finally{
			if( fromUpfwm != null ){ fromUpfwm = null; }
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSRV#finishSFUpfgkmUrgency(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmUrgency(MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfgkmUrgencyImpl{
				public SFUpfgkmUrgencyImpl(){
					super();
				}
				/**
				 * 
				 * @param fromORDER
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmResponse finishSFUpfwmNetWork( IOVUpfwmOrder fromORDER, IUpdcContext aContext )throws SFException,Exception{
					IOVUpfwmResponse fromASK = null;
					IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
					try
					{
						IOVUpfwmOffer fromUpfwm = UpfwmUtils.ICustom._wrap(fromORDER, ISAProvision.S_TYPE );
						IOVUpdspmLife fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromUpfwm, aContext);
						UpfwmUtils.finishSFUpdbmCreate(fromUpfwm, fromUpdfwm, fromLDAP);
						try
						{
							fromASK = IUpfwmFactory.getIUpdfwmSV().finishSFUpdfwm(fromUpfwm, 
									fromUpdfwm, 
									fromLDAP);
						}
						finally{
							UpfwmUtils.finishSFUpdbmComplete( fromLDAP );
							if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
						}
					}
					finally{
						
					}
					
					
					return fromASK;
				}
				/**
				 * 
				 * @param fromORDER
				 * @param fromASK
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmHistory( IOVUpfwmOrder fromORDER, IOVUpfwmResponse fromASK, IUpdcContext aContext) throws SFException,Exception{
					try
					{
						MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						if( fromASK != null ){
							fromORDER.setFAIL_CODE  ( fromASK.getRspCode      () );
							fromORDER.setFAIL_REASON( fromASK.getRspDesc      () );
							fromORDER.setPS_STATUS  ( IUpfwmConst.IUpdos.SUCCEED );
							if( fromASK.isFAILURE() ){
								fromORDER.setPS_STATUS( IUpfwmConst.IUpdos.FAILURE );
							}
						}
						fromORDER.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
						fromORDER.setSTATE        ( IUpdcConst.IState.D     );
						UpfsvcManager.getSession().submitISQLLite( IUpfgkmConst.IUpfgkmDAO, 
								fromORDER.getINSTANCE() );
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromORDER
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmException( IOVUpfwmOrder fromORDER, SFException aEXCEPTION, IUpdcContext aContext) throws SFException,Exception{
					try
					{
						MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromORDER.setFAIL_CODE    ( aEXCEPTION.getFaultCode() );
						fromORDER.setFAIL_REASON  ( aEXCEPTION.getMessage  () );
						fromORDER.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
						fromORDER.setCOMPLETE_DATE( fromMBean.getCOMPLETE  () );
						fromORDER.setSTATE        ( IUpdcConst.IState.Q       );
						UpfsvcManager.getSession().submitISQLLite( IUpfgkmConst.IUpfgkmDAO, 
								fromORDER.getINSTANCE() );
					}
					finally{
						
					}
				}
			}
			SFUpfgkmUrgencyImpl fromUpfgkmImpl = new SFUpfgkmUrgencyImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmOrder fromORDER = (IOVUpfwmOrder)itera.next();
					IOVUpfwmResponse fromASK = null;
					try
					{
						fromASK = fromUpfgkmImpl.finishSFUpfwmNetWork(fromORDER, 
								aContext);
						fromUpfgkmImpl.finishSFUpfwmHistory(fromORDER,
								fromASK,
								aContext);
					}
					catch( java.lang.Exception aException ){
						log.error( aException.getMessage(), aException );
						SFException aEXCEPTION = ExceptionFactory.getException( aException );
						fromUpfgkmImpl.finishSFUpfwmException(fromORDER, 
								aEXCEPTION, 
								aContext);
					}
					finally{
						if( fromASK != null ){ fromASK = null; }
					} 
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSRV#finishSFUpfgkmSync(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmSync(MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfgkmSyncTfImpl{
				public SFUpfgkmSyncTfImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromNotifyHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void orderComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, IUpdcContext aContext) throws SFException, Exception{
					try
					{
						HQSQLEntityBean fromSubJect = null;
						String _table_name = ISAEquipment.S_TYPE.getMapingEnty();
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, _table_name );
						IOVUpdfmxOffer frmUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfgkmOffer fromUpfwm = (IOVUpfgkmOffer)itera.next();
							fromSubJect = HQSQLUtils.ICustom.transfer( fromUpfwm.getINSTANCE(), fromORACLE );
							frmUpdfmx.getORDER().getSUBFLOW( _table_name ).add( fromSubJect );
						}
						UpfgkmFactory.getIUpfgkmDAO().finish( frmUpdfmx.getORDER().getSUBFLOW() );
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
				public void orderConnectionAsyn( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, SFException aEXCEPTION, IUpdcContext aContext) throws SFException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfgkmOffer fromEntity = (IOVUpfgkmOffer)itera.next();
							fromEntity.getINSTANCE().setStsToOld();
							fromEntity.setSTATUS_UPD_DATE( fromMBean.getCOMPLETE               () );
							fromEntity.setFAIL_LOG       ( SystemUtils.getISTKThrow( aEXCEPTION ) );
							UpfsvcManager.getSession().submitISQLLifite( fromMBean.getREPOSITORY(),
									fromEntity.getINSTANCE() );
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
				public void orderExceptionAsyn( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, SFException aEXCEPTION, IUpdcContext aContext) throws SFException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfgkmOffer fromUpfwm = (IOVUpfgkmOffer)itera.next();
							IUpfgkmCityHome fromCityHome = null;
							UpfsvcManager.getMBean().beginTransaction();
							try{
								fromCityHome = new IUpfgkmCityHome( fromUpfwm.getREGION_ID() ) ;
								fromCityHome.getCOMPLETE().add( fromUpfwm );
								orderComplete(fromMBean, fromCityHome, aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								UpfsvcManager.getMBean().rollbackTransaction();
								aEXCEPTION = ExceptionFactory.getException( exception );
								fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
								fromUpfwm.getINSTANCE().setStsToOld();
								fromUpfwm.setPS_STATUS      ( IUpfwmConst.IUpdos.EXCEPTION           );
								fromUpfwm.setSTATUS_UPD_DATE( fromMBean.getCOMPLETE               () );
								fromUpfwm.setFAIL_LOG       ( SystemUtils.getISTKThrow( aEXCEPTION ) );
								UpfsvcManager.getSession().submitISQLLifite( fromMBean.getREPOSITORY(),
										fromUpfwm.getINSTANCE() );
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
			SFUpfgkmSyncTfImpl fromUpfgkmImpl = new SFUpfgkmSyncTfImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromUpfgkmImpl.orderComplete(fromMBean, 
						fromUpfgkmHome, 
						aContext);
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( SFOLQException aEXCEPTION ){
				log.error( aEXCEPTION.getMessage(), aEXCEPTION );
				UpfsvcManager.getMBean().rollbackTransaction();
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromUpfgkmImpl.orderConnectionAsyn(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUpfgkmImpl.orderExceptionAsyn(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
	}

}
