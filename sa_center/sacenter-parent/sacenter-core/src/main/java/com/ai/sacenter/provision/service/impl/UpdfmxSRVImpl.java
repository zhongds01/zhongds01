package com.ai.sacenter.provision.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.ISAProvisionFail;
import com.ai.sacenter.provision.bo.ISAProvisionHis;
import com.ai.sacenter.provision.service.interfaces.IUpdfmxSRV;
import com.ai.sacenter.provision.valuebean.IOVUpfgmtxLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.provision.valuebean.IOVUpfwmUatmix;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-5-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdfmxSRVImpl extends UpdcEclipseImpl implements IUpdfmxSRV {

	public UpdfmxSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfmxSRV#finishSFUpfwmMonitor(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.String, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmMonitor(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			String fromTYPE, 
			Object fromASK, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfgmtxLife fromUpdgmtx = UpfwmUtils.ICustom.getICSTKUpdgmtx( fromUpdfwm.getPLATFORM() );
			if( fromUpdgmtx != null ){
				UpfwmUtils.ICustom._wrap(fromUpfwm, 
						fromUpdfwm,
						fromUpdgmtx, 
						new Object[][]{{fromTYPE, fromASK}}, 
						aContext);
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfmxSRV#finishSFUpfwmUatmix(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmResponse, java.lang.Exception, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmUatmix(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmResponse fromASK,
			java.lang.Exception aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfgmtxLife fromUpdgmtx = UpfwmUtils.ICustom.getICSTKUpdgmtx();
			if( fromUpdgmtx != null ){
				UpfsvcManager.getMBean().beginTransaction();
				try
				{
					IOVUpfwmUatmix fromUatmix = UpfwmUtils.ICustom._wrap(fromUpdgmtx, fromUpfwm, aEXCEPTION, aContext);
					UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpdfmxDAO, fromUatmix.getINSTANCE() );
					if( log.isDebugEnabled() ) log.debug("ucmframe deposit transaction[" + fromUpdgmtx.getID() + "] successfully");
					UpfsvcManager.getMBean().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					UpfsvcManager.getMBean().rollbackTransaction();
				}
				finally{
					
				}
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfmxSRV#finishSFUpfwmHistory(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmHistory(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			IOVUpfgmtxLife fromUpdgmtx = UpfwmUtils.ICustom.getICSTKUpdgmtx();
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm != null?fromUpdfwm.getOPERATE():null;
			IOVUpfwmOffer fromHistory = UpfwmUtils.ICustom._wrap(fromUpfwm, ISAProvisionHis.S_TYPE );
			fromHistory.setDIRECTIVE( fromUpfom != null?fromUpfom.getCODE():fromHistory.getDIRECTIVE() );
			UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpdfmxDAO, fromHistory.getINSTANCE() );
			if( fromUpfom != null && fromUpfom.isMONITOR() && fromUpfwm.isEXCEPTION() /*ÍøÔªÒì³£¼à¿Ø*/){
				IOVUpfwmOffer fromFail = UpfwmUtils.ICustom._wrap(fromUpfwm, ISAProvisionFail.S_TYPE );
				OracleUtils.ICustom.transfer( fromUpfwm.getINSTANCE(), fromFail.getINSTANCE() );
				UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpdfmxDAO, fromFail.getINSTANCE() );
			}
			if( log.isDebugEnabled() ){
				log.debug("ucmframe deposit transaction[" + (fromUpdgmtx != null ? fromUpdgmtx.getID().toString() : "NULL") + "] successfully");
			}
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			UpfsvcManager.getMBean().rollbackTransaction();
		}
		finally{
		
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpdfmxSRV#finishSFUpfwmUatmix(com.ai.sacenter.valuebean.IOVUpdfmxOffer)
	 */
	public void finishSFUpfwmUatmix(IOVUpdfmxOffer fromUpdfmx) throws SFException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			java.sql.Timestamp _COMPLETE_ = new java.sql.Timestamp( System.currentTimeMillis() );
			for( java.util.Iterator<IOVUpfwmUatmix> itera = fromUpdfmx.getORDER().getORDER().iterator(); itera.hasNext(); ){
				IOVUpfwmUatmix  __uatmix__ = (IOVUpfwmUatmix)itera.next();
				__uatmix__.setLGMSG_ID     ( UpfwmFactory.getIUpdfmxDAO().getPLMM_ID() );
				__uatmix__.setCREATE_DATE  ( _COMPLETE_                                );
				__uatmix__.setCOMPLETE_DATE( _COMPLETE_                                );
				UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpdfmxDAO, __uatmix__.getINSTANCE() );
			}
			if( log.isDebugEnabled() ){
				log.debug("ucmframe deposit transaction[" + fromUpdfmx.getID().toString() + "] successfully");
			}
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			UpfsvcManager.getMBean().rollbackTransaction();
		}
		finally{
		
		}
	}
}
