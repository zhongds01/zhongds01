package com.ai.sacenter.tykt.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.tykt.UpfgkmFactory;
import com.ai.sacenter.tykt.util.IUpfgkmUtils;
import com.ai.sacenter.tykt.valuebean.IOVUpfgkmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: ��Ԫ���ڹ�������</p>
 * <p>Copyright: Copyright (c) 2017��3��1��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpfgkmExpireImpl extends IUpffmxCapitalImpl {
	public SFUpfgkmExpireImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl#finishSFUpfgkmChange(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmChange(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfwmExpireImpl{
				public SFUpfwmExpireImpl(){
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
				public void finishSFUpffmxChange( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify, 
			            IUpdcContext aContext) throws SFException, Exception{
					
				}
			}
			SFUpfwmExpireImpl fromUpfgkmImpl = new SFUpfwmExpireImpl();
			try
			{
				IUpfgkmCityHome fromUpdfmx = UpfgkmFactory.getIUpfgkmDAO().getSFNotifyPassage( fromUpfgkmHome );
				for( java.util.Iterator itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					fromUpfgkmImpl.finishSFUpffmxChange(fromOrder, fromTASK, fromUpfwm, fromNotify, aContext);
					for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
						IOVUpfgkmOffer _jj_provsion = (IOVUpfgkmOffer)iterap.next();
						_jj_provsion.getINSTANCE().setStsToOld();
						_jj_provsion.setBILL_ID    ( fromUpfwm.getBILL_ID    () );
						_jj_provsion.setSUB_BILL_ID( fromUpfwm.getSUB_BILL_ID() );
						UpfsvcManager.getSession().submitISQLLite(fromTASK, 
								fromNotify.getLittle().getREPOSITORY(), 
								_jj_provsion );
					}
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
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl#finishSFUpfgkmHistory(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmHistory(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpfwmOffer fromUpfwm,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfwmExpireImpl{
				public SFUpfwmExpireImpl(){
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
				public void finishSFUpffmxHistory( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify, 
			            IUpdcContext aContext) throws SFException, Exception{
					
				}
			}
			SFUpfwmExpireImpl fromUpfgkmImpl = new SFUpfwmExpireImpl();
			try
			{
				IUpfgkmCityHome fromUpdfmx = UpfgkmFactory.getIUpfgkmDAO().getSFNotifyPassage( fromUpfgkmHome );
				for( java.util.Iterator itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					fromUpfgkmImpl.finishSFUpffmxHistory(fromOrder, fromTASK, fromUpfwm, fromNotify, aContext);
					for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
						IOVUpfgkmOffer _jj_provision = (IOVUpfgkmOffer)iterap.next();
						IOVUpfwmOffer _jj_history = IUpfgkmUtils.ICustom._jj_history( _jj_provision );
						_jj_provision.setPS_STATUS( IUpfwmConst.IUpdos.CANCEL );
						_jj_provision.getINSTANCE().setStsToOld();
						_jj_provision.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLite(fromTASK, 
								fromNotify.getLittle().getREPOSITORY(), 
								_jj_provision );
						if( _jj_history != null && _jj_history.getINSTANCE() != null ){
							_jj_history.getINSTANCE().setStsToOld();
							_jj_history.setPS_STATUS  ( IUpfwmConst.IUpdos.CANCEL  );
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromNotify.getLittle().getREPOSITORY(), 
									_jj_history );
						}
					}
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
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl#finishSFUpfgkmHistory(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfwmExpireImpl{
				public SFUpfwmExpireImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxHistory( MBeanDelegate fromMBean,
						IOVUpfwmNotify fromNotify, 
			            IUpdcContext aContext) throws SFException, Exception{
					
				}
			}
			SFUpfwmExpireImpl fromUpfgkmImpl = new SFUpfwmExpireImpl();
			try
			{
				IUpfgkmCityHome fromUpdfmx = UpfgkmFactory.getIUpfgkmDAO().getSFNotifyPassage( fromUpfgkmHome );
				for( java.util.Iterator itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					fromUpfgkmImpl.finishSFUpffmxHistory(fromMBean, fromNotify, aContext);
					for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
						IOVUpfgkmOffer _jj_provision = (IOVUpfgkmOffer)iterap.next();
						IOVUpfwmOffer _jj_history = IUpfgkmUtils.ICustom._jj_history( _jj_provision );
						_jj_provision.setPS_STATUS( IUpfwmConst.IUpdos.CANCEL );
						_jj_provision.getINSTANCE().setStsToOld();
						_jj_provision.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLite(fromNotify, 
								fromNotify.getLittle().getREPOSITORY(), 
								_jj_provision );
						if( _jj_history != null && _jj_history.getINSTANCE() != null ){
							_jj_history.getINSTANCE().setStsToOld();
							_jj_history.setPS_STATUS  ( IUpfwmConst.IUpdos.CANCEL  );
							UpfsvcManager.getSession().submitISQLLite(fromNotify, 
									fromNotify.getLittle().getREPOSITORY(), 
									_jj_history );
						}
					}
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
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpffmxCapitalImpl#finishSFUpfgkmExpire(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmExpire(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpdfmxOffer fromUpdfmx = UpfgkmFactory.getIUpfgkmDAO().getSFNotifyLimite( fromUpfgkmHome );
			if( fromUpdfmx != null && fromUpdfmx.getORDER().getSUBFLOW().size() > 0 ){
				UpfgkmFactory.getIUpfgkmDAO().finish( fromUpdfmx.getORDER().getSUBFLOW() );
			}
		}
		finally{
		
		}
	}

}
