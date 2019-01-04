package com.ai.sacenter.core.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.service.interfaces.ISystemSRV;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.target.IUpdbsFactory;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IOrderRsRspHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SystemSRVImpl extends UpdcEclipseImpl implements ISystemSRV {
	private final static Log log = LogFactory.getLog( SystemSRVImpl.class );
	public SystemSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#applySFOrder(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFOrder(IOVOrderRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws SFException, Exception {
		IOVOrderResponse fromASK = new IOVOrderResponse();
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromXML );
		try
		{	
			java.util.Map fromLocal = UpfsvcManager.getMBean().getGraphics();
			IProfessionalTemplate.ICompetenceBusines fromBusines = null;
			fromLocal.put( IUpdcConst.ISystem.CHANNEL, fromRequest.getCHANNEL() );
			fromBusines = fromUpdcpm.getCATALOG().getCOMPETENCE();
			IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().applySFOrder(fromRequest,
					fromBusines, 
					aContext );
			fromASK = UpdcUtils.ICustom._wrap(fromRequest, 
					fromOrder, 
					fromASK, 
					aContext);
		}
		finally{
			
		}
		return fromASK;
	}
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#applySFBatch(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFBatch(IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws SFException,Exception{
		IOVOrderResponse fromASK = new IOVOrderResponse();
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromXML );
		try
		{
			IProfessionalTemplate.ICompetenceBusines fromBusines = null;
			java.util.Map fromLocal = UpfsvcManager.getMBean().getGraphics();
			fromLocal.put( IUpdcConst.ISystem.CHANNEL, fromRequest.getCHANNEL() );
			fromBusines = fromUpdcpm.getCATALOG().getCOMPETENCE();
			IUpdcFactory.getIUpdwfSV().applySFBatch(fromRequest, 
					fromBusines, 
					aContext);
			fromASK = UpdcUtils.ICustom._wrap(fromRequest, 
					null, 
					fromASK, 
					aContext);
		}
		finally{
			
		}
		return fromASK;
		
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#applySFGroup(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFGroup(IOVOrderRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws SFException, Exception {
		IOVOrderResponse fromASK = new IOVOrderResponse();
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromXML );
		try
		{	
			IProfessionalTemplate.ICompetenceBusines fromBusines = null;
			java.util.Map fromLocal = UpfsvcManager.getMBean().getGraphics();
			fromLocal.put( IUpdcConst.ISystem.CHANNEL, fromRequest.getCHANNEL() );
			fromBusines = fromUpdcpm.getCATALOG().getCOMPETENCE();
			IOVOrderPentium fromGroup =IUpdcFactory.getIUpdwfSV().applySFGroup(fromRequest, 
					fromBusines, 
					aContext);
			fromASK = UpdcUtils.ICustom._wrap(fromRequest, 
					fromGroup, 
					fromASK, 
					aContext);
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#applySFCentrex(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFCentrex(IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws SFException, Exception {
		IOVOrderResponse fromASK = new IOVOrderResponse();
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromXML );
		try
		{	
			IProfessionalTemplate.ICompetenceBusines fromBusines = null;
			java.util.Map fromLocal = UpfsvcManager.getMBean().getGraphics();
			fromBusines = fromUpdcpm.getCATALOG().getCOMPETENCE();
			fromLocal.put( IUpdcConst.ISystem.CHANNEL   , fromRequest.getCHANNEL   () );
			fromLocal.put( IUpdcConst.ISystem.ORIGINATOR, fromRequest.getORIGINATOR() );
			IOVOrderPentium _centrex[] =IUpdcFactory.getIUpdwfSV().applySFCentrex(fromRequest, 
					fromBusines, 
					aContext);
			fromASK = UpdcUtils.ICustom._wrap(fromRequest, 
					_centrex != null && _centrex.length > 0?
							_centrex[ _centrex.length - 1]:null, 
					fromASK, 
					aContext);
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#applySFCentrex(com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse applySFCentrex(IOVOrderResponse fromRequest, 
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws SFException, Exception {
		IOVOrderResponse fromASK = new IOVOrderResponse();
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromXML );
		try
		{	
			java.sql.Timestamp _complete = new java.sql.Timestamp( System.currentTimeMillis() );
			java.util.Map fromLocal = UpfsvcManager.getMBean().getGraphics();
			fromLocal.put( IUpdcConst.ISystem.CHANNEL   , fromRequest.getCHANNEL   () );
			fromLocal.put( IUpdcConst.ISystem.ORIGINATOR, fromRequest.getORIGINATOR() );
			IOrderRsRspHome fromExtend = IUpdcFactory.getIUpdcpmSV().getSFTaskExtend(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder(fromRequest.getDONE_CODE(), 
					fromRequest.getUSER_ID(), 
					fromRequest.getREGION_ID() );
			if( fromOrder == null ){
				ExceptionFactory.throwRemote("IOS0010020", new String[]{ fromRequest.getDONE_CODE(), fromRequest.getBILL_ID() });
			}
			fromOrder.setSTATE             ( IUpdcConst.IState.F     );
			fromOrder.setCOMPLETE_DATE     ( _complete               );
			fromOrder.getORDER().setRESPOND( fromExtend              );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#cancelSFExpire(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, java.lang.String)
	 */
	public IOVOrderResponse cancelSFExpire(IOVOrderRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			String fromXML) throws SFException, Exception {
		IOVOrderResponse fromASK = new IOVOrderResponse();
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromXML );
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromUpdcpm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public java.util.HashMap getSFUpffmxHome( IOVOrderRequest fromRequest,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext ) throws SFException,Exception{
					java.util.HashMap fromExpireHome = new java.util.HashMap();
					try
					{
						for( java.util.Iterator itera = fromRequest.getORDER().iterator(); itera.hasNext(); ){
					    	IOVOrderUser fromOrdUserHome = (IOVOrderUser)itera.next();
					    	if( fromExpireHome.get( fromOrdUserHome.getREGION_ID() ) == null ){
					    		fromExpireHome.put( fromOrdUserHome.getREGION_ID(), 
					    				new IUpfgkmCityHome( fromOrdUserHome.getREGION_ID() ) );
					    	}
					    	((IUpfgkmCityHome)fromExpireHome.get( fromOrdUserHome.getREGION_ID() ) 
					    			).getCOMPLETE().add( fromOrdUserHome );
					    }
					}
					finally{
						
					}
					return fromExpireHome;
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromUserHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxComplete( MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromUserHome,
						IUpdcContext aContext ) throws SFException,Exception{
					IUpfgkmCityHome fromNotifyHome = null;
					try
					{
						fromNotifyHome = new IUpfgkmCityHome( fromUserHome.getREGION_ID() );
						long aUSER_ID[] = new long[ fromUserHome.getCOMPLETE().size() ];
						for( int index = 0; index < fromUserHome.getCOMPLETE().size(); index++ ){
							IOVOrderUser fromOrdUserHome = (IOVOrderUser)fromUserHome.getCOMPLETE().get( index );
							aUSER_ID[index] = fromOrdUserHome.getUSER_ID();
						}
						IOVUpfwmNotify fromNotify[] = UpfwmFactory.getIUpffmxDAO().getSFUpffmxHome( aUSER_ID, 
								fromUserHome.getREGION_ID() );
						if( fromNotify != null && fromNotify.length > 0 ){
							ClassUtils.IMerge.merge( fromNotify, fromNotifyHome.getCOMPLETE() );
							IUpfwmFactory.getIUpffmxSV().finishSFUpfgkmHistory(fromMBean, 
									fromNotifyHome, 
									aContext);
						}
					}
					finally{
						if( fromNotifyHome != null ){ fromNotifyHome = null; }
					}
				}
			}
			SFUpffmxExpireImpl fromExpireImpl = new SFUpffmxExpireImpl();
			java.util.Map fromExpireHome = null;
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromExpireHome = fromExpireImpl.getSFUpffmxHome(fromRequest, 
						fromUpdcpm, 
						aContext);
				for( java.util.Iterator itera = fromExpireHome.values().iterator(); itera.hasNext(); ){
					IUpfgkmCityHome fromUserHome = (IUpfgkmCityHome)itera.next();
					fromExpireImpl.finishSFUpffmxComplete(fromMBean, 
							fromUserHome, 
							aContext);
				}
				fromASK = UpdcUtils.ICustom._wrap(fromRequest, 
						null, 
						fromASK, 
						aContext);
			}
			finally{
				if( fromExpireHome != null ){ fromExpireHome.clear(); fromExpireHome = null; }
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#suspendSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void suspendSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID,
			String aVM_REASON, 
			String aADDIN_XML) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( aADDIN_XML );
		try
		{
			IOVOrderPentium fromOrder[] = IUpdcFactory.getIUpdwfSV().getSFOrder( aVM_ORDER_ID );
			if( fromOrder == null || fromOrder.length <= 0 ) ExceptionFactory.throwIllegal("IOS0010020", new String[]{aVM_ORDER_ID, aBILL_ID});
			for( int index = 0 ; fromOrder != null && index < fromOrder.length; index++ ){
				String aORDER_ID = String.valueOf( fromOrder[index].getORDER_ID() );
				if( fromOrder[index].isHUMAN() == false || fromOrder[index].isEXCEPTION() )
					ExceptionFactory.throwIllegal("IOS0010021", new String[]{aVM_ORDER_ID, aORDER_ID});
				 if( StringUtils.equals( fromOrder[index].getSTATE(), IUpdcConst.IState.H ) == false )
					 ExceptionFactory.throwIllegal("IOS0010022", new String[]{aVM_ORDER_ID, aORDER_ID});
				 UpdcUtils.ICustom._wrap( fromOrder[index] , new String[][]{{"SUSPEND",aVM_REASON}}, new String[]{} );
				 fromOrder[index].setSTATE( IUpdcConst.IState.B );
				 UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder[index] );
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#resumeSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void resumeSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( aADDIN_XML );
		try
		{
			IOVOrderPentium fromOrder[] = IUpdcFactory.getIUpdwfSV().getSFOrder( aVM_ORDER_ID );
			if( fromOrder == null || fromOrder.length <= 0 ) ExceptionFactory.throwIllegal("IOS0010020", new String[]{aVM_ORDER_ID, aBILL_ID});
			for( int index = 0 ; fromOrder != null && index < fromOrder.length; index++ ){
				String aORDER_ID = String.valueOf( fromOrder[index].getORDER_ID() );
				if( fromOrder[index].isHUMAN() == false || fromOrder[index].isEXCEPTION() )
					ExceptionFactory.throwIllegal("IOS0010021", new String[]{aVM_ORDER_ID, aORDER_ID});
				 if( StringUtils.equals( fromOrder[index].getSTATE(), IUpdcConst.IState.B ) == false )
					 ExceptionFactory.throwIllegal("IOS0010023", new String[]{aVM_ORDER_ID, aORDER_ID});
				 UpdcUtils.ICustom._wrap( fromOrder[index] , new String[][]{}, new String[]{"SUSPEND"} );
				 fromOrder[index].setSTATE( IUpdcConst.IState.H );
				 UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder[index] );
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#cancelSFOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IOVOrderPentium[] cancelSFOrder(String aVM_ORDER_ID, 
			String aBILL_ID, 
			String aVM_REASON, 
			String aADDIN_XML) throws SFException, Exception {
		IOVOrderPentium fromOrder[] = null;
		IUpdcContext aContext = ClassUtils.getIContextImpl( aADDIN_XML );
		try
		{
			SFException aEXCEPTION = ExceptionFactory.getException("IOS0010030", aVM_REASON);
			fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( aVM_ORDER_ID );
			if( fromOrder == null || fromOrder.length <= 0 ) ExceptionFactory.throwIllegal("IOS0010020", new String[]{aVM_ORDER_ID, aBILL_ID});
			for( int index = 0 ; fromOrder != null && index < fromOrder.length; index++ ){
				String aORDER_ID = String.valueOf( fromOrder[index].getORDER_ID() );
				if( fromOrder[index].isHUMAN() == false || fromOrder[index].isEXCEPTION() )
					ExceptionFactory.throwIllegal("IOS0010021", new String[]{aVM_ORDER_ID, aORDER_ID});
				 if( StringUtils.equals( fromOrder[index].getSTATE(), IUpdcConst.IState.B ) == false )
					 ExceptionFactory.throwIllegal("IOS0010023", new String[]{aVM_ORDER_ID, aORDER_ID } );
				 IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTaskFailure( fromOrder[index] );
				 if( fromTASK != null && fromTASK.length > 0 ){
					 IUpdcFactory.getITaskSV().finishSFTask(fromOrder[index], 
							 fromTASK[0],
							 aEXCEPTION, 
							 aContext);
				 }
				 UpdcUtils.ICustom._wrap( fromOrder[index] , new String[][]{{"CANCEL",aVM_REASON}}, new String[]{} );
				 fromOrder[index].setSTATE( IUpdcConst.IState.K );
				 UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder[index] );
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromOrder;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#getASKOrder(long, java.lang.String, java.lang.String)
	 */
	public java.util.HashMap getASKOrder(long aVM_ORDER_ID, 
			String aBILL_ID, 
			String aADDIN_XML) throws SFException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		IUpdcContext aContext = ClassUtils.getIContextImpl( aADDIN_XML );
		try
		{
			IOVUpdbsComplete fromPentium = IUpdbsFactory.getIUpdbsSV().getSFOrder( aVM_ORDER_ID );
			aContext.put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE, fromPentium );
			IUpdbsFactory.getIUpdcpmSV().finishSFUpdbsOffer( fromPentium, aContext );
			ClassUtils.IMerge.merge( fromPentium.getORDER().getSUBFLOW(), fromASK );
			if( log.isDebugEnabled() ) log.debug( "ucmframe worksheet result:" + XmlUtils.createGeneralXml("ucmframe", fromASK) );
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null; }
		}
		return fromASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFUpfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[], com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwm(IOVOrderPentium fromOrder,
			IOVTaskPentium[] fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			if( fromTASK != null && fromTASK.length > 0 ){
				UpdcUtils.ISystem.transfer( new IOVOrderPentium[]{ fromOrder }, fromINDEX );
				for( ; fromOrder != null ; ){
					java.util.List fromUpdfwm = null;
					try
					{
						fromUpdfwm = IUpdcFactory.getITaskSV().getSFUpdfwm(fromOrder, aContext);
						if( fromUpdfwm == null || fromUpdfwm.size() <= 0 ) break;
						finishSFUpfwm( fromINDEX, fromUpdfwm, aContext );
					}
					finally{
						if( fromUpdfwm != null ){ fromUpdfwm.clear(); fromUpdfwm = null;}
					}
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFUpfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium[], com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwm(IOVOrderPentium[] fromOrder, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			UpdcUtils.ISystem.transfer( fromOrder, fromINDEX );
			for( ; fromOrder != null && fromOrder.length > 0 ; ){
				java.util.List fromUpdfwm = null;
				try
				{
					fromUpdfwm = IUpdcFactory.getITaskSV().getSFUpdfwm(fromOrder, aContext);
					if( fromUpdfwm == null || fromUpdfwm.size() <= 0 ) break;
					finishSFUpfwm( fromINDEX, fromUpdfwm, aContext );
				}
				finally{
					if( fromUpdfwm != null ){ fromUpdfwm.clear(); fromUpdfwm = null;}
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFUpfwm(java.util.Map, java.util.List, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwm(java.util.Map fromUpdbm, 
			java.util.List fromUpdfm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			for( java.util.Iterator itera = fromUpdfm.iterator() ; itera.hasNext() ; ){
				IOVUpdspmLife fromUpdfwm = (IOVUpdspmLife)itera.next();
				for( java.util.Iterator iterap = fromUpdfwm.getBPMING().iterator() ; iterap.hasNext() ; ){
					IOVTaskPentium fromTASK = (IOVTaskPentium)iterap.next();
					IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( fromTASK, fromTASK.getORDER_ID() );
					UpdcUtils.ISystem.finishSFUpfwm( fromOrder, fromTASK, aContext );
					UpfsvcManager.getSession().beginTransaction();
					try
					{
						if( UpdbpmUtils.IIfElse.isMEMORY( fromOrder, 
								fromTASK, fromUpdfwm , aContext )/*流程任务为内存工单*/ ){
							finishSFUpfmc( fromOrder, 
									fromTASK, 
									fromUpdfwm, 
									aContext );
						}
						else/*流程任务为任务工单,判断是否启用名单管理*/{
							finishSFUpfwm( fromOrder, 
									fromTASK, 
									fromUpdfwm, 
									aContext );
						}
						finishSFTask(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromASK, 
								aContext);
						if (log.isDebugEnabled()) log.debug("batch directive ["+ fromUpdfwm.getPLATFORM().getID() +"\t"+ 
								fromUpdfwm.getDIRECTIVE().getID() + "] completed");
						UpfsvcManager.getSession().commitTransaction();
					}
					catch( java.lang.Exception aException ){
						if (log.isDebugEnabled()) log.debug("batch directive ["+ fromUpdfwm.getPLATFORM().getID() +"\t"+ 
								fromUpdfwm.getDIRECTIVE().getID() + "] exception");
						UpfsvcManager.getSession().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( aException );
						finishSFTask(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								aEXCEPTION, 
								aContext);
					}
				}
			}
		}
		finally{
			if( fromASK != null ){ fromASK = null;}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFUpfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwm(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromUpdfm = null;
		try
		{
			fromUpdfm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromOrder, fromTASK, fromUpdfwm, aContext);
			for( java.util.Iterator itera = fromUpdfm.iterator() ; itera.hasNext() ; ){
				fromUpdfwm = (IOVUpdspmLife)itera.next();
				IOVUpfwmResponse fromASK = null;
				try
				{
					fromASK = IUpfwmFactory.getIUpdfwmSV().finishSFUpfwm(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							aContext);
					IUpdcFactory.getITaskSV().finishSFTaskChain(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							fromASK, 
							aContext);
				}
				catch( java.lang.Exception aException ){
					if( log.isErrorEnabled() ) log.error( aException.getMessage(), aException );
					SFException aEXCEPTION = ExceptionFactory.getException( aException );
					IUpdcFactory.getITaskSV().finishSFTaskChain(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							aEXCEPTION, 
							aContext);
                }
				finally{
					if( fromASK != null ){ fromASK = null;}
				}
			}
		}
		finally{
			if( fromUpdfm != null ){ fromUpdfm.clear() ; fromUpdfm = null;}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFUpfmc(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfmc(IOVOrderPentium aINSTANCE, 
			IOVTaskPentium aUpdswfLife, 
			IOVUpdspmLife aUpdspmLife, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			if( aINSTANCE.isEXCEPTION() && aUpdswfLife.getCREATE_TASK_ID() > 0 && 
					aUpdswfLife.getCREATE() != null /*服务定单任务异常回单*/){
				IUpfwmFactory.getIUpdfwmSV().finishSFUpfmc(aINSTANCE, 
						aUpdswfLife, 
						aUpdspmLife, 
						aContext);
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTask(IOVTaskPentium fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		UpfsvcManager.getSession().beginTransaction();
		try
		{
			IOVTaskPentium fromPending[] = null;
			IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( fromTASK, fromTASK.getORDER_ID() );
			fromPending = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder );
			fromOrder.setFAIL_LOG("");
			finishSFUpfwm(fromOrder, fromPending, aContext);
			UpfsvcManager.getSession().commitTransaction();
		}
		catch( java.lang.Exception aEXCEPTION ){
			UpfsvcManager.getSession().rollbackTransaction();
			throw aEXCEPTION;
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTask(long, com.ai.sacenter.valuebean.IOVUpdbfgrpOffer)
	 */
	public void finishSFTask(long aTASK_ID, 
			IOVUpfwmResponse fromASK) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			IOVTaskPentium fromTASK = IUpdcFactory.getIUpdwfSV().getSFTask( aTASK_ID );
			if( fromTASK != null ){
				try
				{
					UpfsvcManager.getSession().beginTransaction();
					IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( fromTASK, 
							fromTASK.getORDER_ID() );
					finishSFTask( fromOrder, 
							fromTASK, 
							fromASK, 
							aContext );
					boolean fromCOMPLETE = UpdbpmUtils.IIfElse.isCOMPLETE( fromOrder, fromTASK );
					if( fromCOMPLETE == true /*服务任务调度已完成(包含异常完成和正常完成)*/){
						IOVTaskPentium fromPending[] = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder );
						finishSFUpfwm( fromOrder, fromPending, aContext );
					}
					UpfsvcManager.getSession().commitTransaction();
				}
				catch( java.lang.Exception aEXCEPTION ){
					UpfsvcManager.getSession().rollbackTransaction();
					throw aEXCEPTION;
				}
				finally{
					
				}
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null;}
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdbfgrpOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmResponse fromASK,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpdspmLife fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getSFUpdfwm(fromOrder, fromTASK, aContext);
			try
			{
				IUpdcFactory.getITaskSV().finishSFTask(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromASK, 
						aContext);
			}
			catch( java.lang.Exception aException ){
				log.error( aException.getMessage() , aException );
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				IUpdcFactory.getITaskSV().finishSFTask( fromOrder, 
						fromTASK, 
						fromUpdfwm,
						aEXCEPTION, 
						aContext );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromTASK.setDONE_TIMES( fromTASK.getREDO_TIMES() );
			boolean fromREPLY = UpdbpmUtils.IIfElse.isSYNCHRONIZE( fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext );
			if (fromREPLY == false/* 异步网元反馈 */) {
				fromTASK.setSTATE(IUpdcConst.IState.R);
			} else/* 同步网元反馈 */{
				fromTASK.setSTATE(fromTASK.isCOMPENSATE() ? 
						IUpdcConst.IState.S:IUpdcConst.IState.O);
			}
			IUpdcFactory.getITaskSV().finishSFTask( fromOrder, 
					fromTASK, 
					fromUpdfwm,
					aContext );
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTask(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IUpdcFactory.getITaskSV().finishSFTask( fromOrder, 
					fromTASK, 
					fromUpdfwm,
					aEXCEPTION, 
					aContext );
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTaskRedo(long[], java.lang.String, java.lang.String, java.util.HashMap)
	 */
	public void finishSFTaskRedo(long[] aTASK_ID, 
			String aVM_ORG_ID, 
			String aVM_STAFF_ID, 
			java.util.HashMap fromASK) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			IOVTaskPentium fromPending[] = null;
			IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTaskFail( aTASK_ID );
			for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
				IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( fromTASK[index], fromTASK[index].getORDER_ID() );
				if( fromTASK[index].isEXCEPTION() == false )
					ExceptionFactory.throwIllegal("IOS0010024", new String[]{String.valueOf( fromTASK[index].getTASK_ID() )} );
				fromOrder.setFAIL_LOG("");fromOrder.setSTATE( IUpdcConst.IState.R );
				fromTASK[index].setSTAFF_ID( aVM_STAFF_ID );fromTASK[index].setORG_ID( aVM_ORG_ID );
				fromTASK[index].setDONE_RESULT("");
				fromTASK[index].setFAIL_LOG("");fromTASK[index].setSTATE( IUpdcConst.IState.C );
				UpfsvcManager.getSession().submitIUpdfmxLifite( new Object[]{fromOrder , fromTASK[index ]} );
				fromPending = IUpdcFactory.getIUpdwfSV().getSFTask( fromOrder );
				finishSFUpfwm( fromOrder, fromPending, aContext );
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null;}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTaskComplete(long[], java.lang.String, java.lang.String, java.lang.String, java.util.HashMap)
	 */
	public void finishSFTaskComplete(long[] aTASK_ID, 
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID, 
			java.util.HashMap fromASK) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( fromASK );
		try
		{
			SFException aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.COMPLETE, aVM_REASON);
			IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTaskFail( aTASK_ID );
			for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
				IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( fromTASK[index], fromTASK[index].getORDER_ID() );
				if( fromTASK[index].isEXCEPTION() == false )
					ExceptionFactory.throwIllegal("IOS0010024", new String[]{String.valueOf( fromTASK[index].getTASK_ID() )} );
				fromOrder.setFAIL_LOG      ( ""           );
				fromTASK[index].setSTAFF_ID( aVM_STAFF_ID );
				fromTASK[index].setORG_ID  ( aVM_ORG_ID   );
				UpfsvcManager.getSession().submitIUpdfmxLifite( new Object[]{fromOrder , fromTASK[index ]} );
				IUpdcFactory.getITaskSV().finishSFTaskComplete(fromOrder, 
						fromTASK[index], 
						aEXCEPTION, 
						aContext);
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null;}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.ISystemSRV#finishSFTaskException(long[], java.lang.String, java.lang.String, java.lang.String, java.util.HashMap)
	 */
	public void finishSFTaskException(long[] aTASK_ID, 
			String aVM_REASON,
			String aVM_ORG_ID, 
			String aVM_STAFF_ID, 
			java.util.HashMap fromASK) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl( );
		try
		{
			SFException aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.CANCEL, aVM_REASON);
			IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTaskFail( aTASK_ID );
			for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
				IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder( fromTASK[index], 
						fromTASK[index].getORDER_ID() );
				if( fromTASK[index].isEXCEPTION() == false )
					ExceptionFactory.throwIllegal("IOS0010024", new String[]{String.valueOf( fromTASK[index].getTASK_ID() )} );
				fromTASK[index].setSTAFF_ID( aVM_STAFF_ID );
				fromTASK[index].setORG_ID( aVM_ORG_ID );
				IUpdcFactory.getITaskSV().finishSFTaskException(fromOrder, 
						fromTASK[index], 
						aEXCEPTION, 
						aContext);
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null;}
		}
	}
}
