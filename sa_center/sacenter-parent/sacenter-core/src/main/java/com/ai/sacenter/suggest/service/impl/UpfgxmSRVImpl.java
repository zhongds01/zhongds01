package com.ai.sacenter.suggest.service.impl;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.suggest.IUpfgxmFactory;
import com.ai.sacenter.suggest.service.interfaces.IUpfgxmSRV;
import com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfgxmSRVImpl extends UpdcEclipseImpl implements IUpfgxmSRV {
	private final static Log log = LogFactory.getLog( UpfgxmSRVImpl.class );
	public UpfgxmSRVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpfgxmSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[], com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTaskComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium[] fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfgxmPentium fromPentium = null;
			fromPentium = IUpfgxmFactory.getIUpdcpmSV().finishSFTaskComplete(fromOrder, 
					fromTASK, 
					aContext);
			if( fromPentium != null ){
				UpfsvcManager.getSession().submitISQLLite( IUpdcConst.IUpdbm.IUpfgxmDAO, 
						fromPentium.getINSTANCE() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpfgxmSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTaskComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfgxmPentium fromPentium = null;
			fromPentium = IUpfgxmFactory.getIUpdcpmSV().finishSFTaskComplete(fromOrder, 
					fromTASK, 
					aEXCEPTION,
					aContext);
			if( fromPentium != null ){
				UpfsvcManager.getSession().submitISQLLite( IUpdcConst.IUpdbm.IUpfgxmDAO, 
						fromPentium.getINSTANCE() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpfgxmSRV#finishSFUpfgxmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.common.IOVUpdbpmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgxmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			class SFUpfgxmSyncImpl{
				public SFUpfgxmSyncImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromSuggest
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void suggestComplete( MBeanDelegate fromMBean,
						IOVUpfgxmPentium fromSuggest, 
						IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						IUpfgxmFactory.getIUpdcpmSV().finishSFUpfgxmComplete(fromMBean,
								fromSuggest, 
								aContext);
						fromSuggest.setSTATE        ( IUpdcConst.IState.O     );
						fromSuggest.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
						fromSuggest.getINSTANCE().setStsToOld();
						fromSuggest.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLHistory( IUpdcConst.IUpdbm.IUpfgxmDAO, 
								fromSuggest.getINSTANCE() );
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromSuggest
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void suggestException( MBeanDelegate fromMBean,
						IOVUpfgxmPentium fromSuggest, 
						SFException aEXCEPTION,
						IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						fromSuggest.setSTATE        ( IUpdcConst.IState.E                    );
						fromSuggest.setCOMPLETE_DATE( fromMBean.getCOMPLETE()                );
						fromSuggest.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
						fromSuggest.getINSTANCE().setStsToOld();
						fromSuggest.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLifite( IUpdcConst.IUpdbm.IUpfgxmDAO, 
								fromSuggest.getINSTANCE() );
					}
					finally{
						
					}
				}
			}
			SFUpfgxmSyncImpl fromUpfgxmImpl = new SFUpfgxmSyncImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfgxmPentium fromSuggest = (IOVUpfgxmPentium)itera.next();
					try
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromUpfgxmImpl.suggestComplete(fromMBean, 
								fromSuggest, 
								aContext);
					}
					catch( java.lang.Exception aException ){
						log.error( aException.getMessage(), aException );
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						SFException aEXCEPTION = ExceptionFactory.getException( aException );
						fromUpfgxmImpl.suggestException(fromMBean, 
								fromSuggest, 
								aEXCEPTION, 
								aContext);
					}
					finally{
						
					}
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			finally{
				if( fromUpfgxmImpl != null ){ fromUpfgxmImpl = null; }
			}
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
