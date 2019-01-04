package com.ai.sacenter.receive.exigence.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmUatmix;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderBase;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketCompose;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketOffer;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018Äê1ÔÂ31ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class UpdfmxSRVImpl extends UpdcEclipseImpl implements IUpdfmxSRV {

	public UpdfmxSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpdfmxHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdfmxHistory(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE      () );
			fromRocket.setCOMPLETE_DATE( fromRocket.getPLWK_COMPLETE() );
			fromRocket.getINSTANCE().setStsToOld();
			fromRocket.getINSTANCE().delete();
			UpfsvcManager.getSession().submitISQLHistory( fromMBean.getREPOSITORY(), fromRocket.getINSTANCE() );
			for( java.util.Iterator<IOVMocketOffer> itera = fromRocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVMocketOffer fromOffer = (IOVMocketOffer)itera.next();
				fromOffer.setCOMPLETE_DATE( fromRocket.getCOMPLETE_DATE() );
				fromOffer.getINSTANCE().setStsToOld();
				fromOffer.getINSTANCE().delete();
				UpfsvcManager.getSession().submitISQLHistory( fromMBean.getREPOSITORY(), fromOffer.getINSTANCE() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpdfmxHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdfmxHistory(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = IExigenceFactory.getIUpdcpmSV().getSFUpfgkmComplete(fromRocket, 
					aEXCEPTION, 
					aContext);
			IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmHistory(fromMBean, 
					fromRocket, 
					fromUpdcpm, 
					aEXCEPTION, 
					aContext);
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpdfmxDefault(com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence, com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVMocketConsult finishSFUpdfmxDefault(IOVMsgFExigence fromRocket, 
			IOVMocketConsult fromUpdfmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpdfmxUserImpl{
				public SFUpdfmxUserImpl(){
					super();
				}
			}
			SFUpdfmxUserImpl fromUpdfmxImpl = new SFUpdfmxUserImpl();
			try
			{
				IOVMsgFExigence.IMsgFOfferXHome fromUpdfmxHome = fromRocket.getORDER();
				IOVMocketConsult.IUpdfmxOfferHome fromUpdfmsHome = fromUpdfmx.getSUBFLOW();
				for( java.util.Iterator<IOVMsgFOrderBase> itera = fromUpdfmxHome.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrderBase fromOrder = (IOVMsgFOrderBase)itera.next();
					IUpfgkmOfferHome fromBusines = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromOrder );
					String fromINDEX = ClassUtils.getINDEX( new String[]{ "CUSTOM_ORDER_$_NULL_$_USER_$_", 
							String.valueOf( fromOrder.getUSER_ID() ) } );
					IOVMocketCompose fromExplain = (IOVMocketCompose)fromUpdfmsHome.getGROUP().get( fromINDEX );
					if( fromExplain == null ){
						fromExplain = new IOVMocketCompose( fromOrder, fromBusines );
						fromExplain.setSUBFLOW( new IOVMsgFExigence( fromRocket ) );
						fromUpdfmsHome.getGROUP().put( fromINDEX, fromExplain  );
					}
					fromExplain.mergeAsConsult( fromOrder, fromBusines );
				}
			}
			finally{
				if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpfgkmHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.valuebean.IOVUpdcpmOffer, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket, 
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			SFException aCOMPLETE = ExigenceUtils.ISystem.getCOMPLETE( fromRocket );
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE      () );
			fromRocket.setCOMPLETE_DATE( fromRocket.getPLWK_COMPLETE() );
			fromRocket.getINSTANCE().setStsToOld();
			fromRocket.getINSTANCE().delete();
			UpfsvcManager.getSession().submitISQLHistory( fromMBean.getREPOSITORY(), fromRocket.getINSTANCE() );
			for( java.util.Iterator<IOVMocketOffer> itera = fromRocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVMocketOffer fromOffer = (IOVMocketOffer)itera.next();
				fromOffer.setCOMPLETE_DATE( fromRocket.getCOMPLETE_DATE() );
				fromOffer.getINSTANCE().setStsToOld();
				fromOffer.getINSTANCE().delete();
				UpfsvcManager.getSession().submitISQLHistory( fromMBean.getREPOSITORY(), fromOffer.getINSTANCE() );
			}
			if( fromUpdcpm != null && fromUpdcpm.getPROGRAM().getPROGRAM() != null ){
				IOVUpdbsComplete fromNotify = new IOVUpdbsComplete();
				ExigenceUtils.ICustom._wrap(fromRocket, fromNotify, fromUpdcpm, aCOMPLETE, aContext);
				fromNotify.setCOMPLETE_DATE( fromRocket.getCOMPLETE_DATE() );
				UpfsvcManager.getSession().submitISQLLite( fromNotify.getINSTANCE() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpfgkmConnection(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.valuebean.IOVUpdcpmOffer, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmConnection(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			java.sql.Timestamp __order_date__ = null;
			IPlatformTemplate.IUpffmsOffer fromUpffms = fromUpdcpm.getPROGRAM().getRESPOND();
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromRocket.setRETRY_TIMES  ( fromRocket.getRETRY_TIMES() + 1 );
			fromRocket.setCOMPLETE_DATE( fromMBean.getCOMPLETE        () );
			fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE        () );
			if( fromRocket.getRETRY_TIMES() >= fromUpffms.getRETRY_TIMES() ){
				finishSFUpfgkmException(fromMBean, fromRocket, fromUpdcpm, aEXCEPTION, aContext);
			}
			else{
				__order_date__ = TimeUtils.addSecond( fromMBean.getCOMPLETE(), (int)fromUpffms.getRETRY_INTERVAL() );
				fromRocket.setSTATE      ( IUpdcConst.IState.R             );
				fromRocket.setORDER_DATE ( __order_date__                  );
				UpfsvcManager.getSession().submitISQLLite( fromMBean.getREPOSITORY(), fromRocket.getINSTANCE() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpfgkmException(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.valuebean.IOVUpdcpmOffer, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmException(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdbsComplete fromNotify = null;
		try
		{
			fromNotify = new IOVUpdbsComplete();
			fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromRocket.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
			fromRocket.setPLWK_COMPLETE( fromMBean.getCOMPLETE() );
			fromRocket.getINSTANCE().setStsToOld();
			fromRocket.getINSTANCE().delete();
			UpfsvcManager.getSession().submitISQLLifite(fromMBean.getREPOSITORY(), fromRocket.getINSTANCE() );
			for( java.util.Iterator<IOVMocketOffer> itera = fromRocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVMocketOffer fromOffer = (IOVMocketOffer)itera.next();
				fromOffer.setCOMPLETE_DATE( fromRocket.getCOMPLETE_DATE() );
				fromOffer.getINSTANCE().setStsToOld();
				fromOffer.getINSTANCE().delete();
				UpfsvcManager.getSession().submitISQLLifite(fromMBean.getREPOSITORY(), fromOffer.getINSTANCE() );
			}
			if( fromUpdcpm != null && fromUpdcpm.getPROGRAM().getPROGRAM() != null ){
				ExigenceUtils.ICustom._wrap(fromRocket, fromNotify, fromUpdcpm, aEXCEPTION, aContext);
				fromNotify.setCOMPLETE_DATE( fromRocket.getCOMPLETE_DATE() );
				UpfsvcManager.getSession().submitISQLLite( fromNotify.getINSTANCE          () );
			}
		}
		finally{
			if( fromNotify != null ){ fromNotify = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdfmxSRV#finishSFUpdfmxLifite(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpdfmxLifite(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRocket );
		try
		{
			IOVUpfwmUatmix fromUpffmx = new IOVUpfwmUatmix();
			ExigenceUtils.ICustom._wrap( fromMBean, fromRocket, fromUpffmx, aContext );
			fromUpffmx.setCOMPLETE_DATE( fromMBean.getCOMPLETE                    () );
			if( aEXCEPTION != null ){
				fromUpffmx.setFAIL_CODE( aEXCEPTION.getFaultCode                  () );
				fromUpffmx.setFAIL_LOG ( SystemUtils.getISTKThrow( aEXCEPTION      ) );
				fromUpffmx.setMSG      ( aEXCEPTION.getAsXML                      () );
			}
			fromUpdfmx.getORDER().getORDER().add( fromUpffmx );
			IUpfwmFactory.getIUpdfmxSV().finishSFUpfwmUatmix( fromUpdfmx );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			if( fromUpdfmx != null ){ fromUpdfmx = null; }
		}
	}
}
