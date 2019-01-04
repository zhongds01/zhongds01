package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISAProvision;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê5ÔÂ16ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpffmxExpireImpl extends IUpffmxCapitalImpl {
	public IUpffmxExpireImpl() {
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
					try
					{
						
					}
					finally{
						
					}
				}
			}
			SFUpfwmExpireImpl fromUpfwmImpl = new SFUpfwmExpireImpl();
			try
			{
				IUpfgkmCityHome fromUpdfmx = UpfwmFactory.getIUpfwmDAO().getSFNotifyPassage( fromUpfgkmHome );
				for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					fromUpfwmImpl.finishSFUpffmxChange(fromOrder, fromTASK, fromUpfwm, fromNotify, aContext);
					for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
						IOVUpfwmOffer _jj_provsion = (IOVUpfwmOffer)iterap.next();
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
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
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
				public void finishSFUpffmxCancel( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
							IOVUpfwmOffer _jj_provsion = (IOVUpfwmOffer)iterap.next();
							_jj_provsion.getINSTANCE().setStsToOld();
							_jj_provsion.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromNotify.getLittle().getREPOSITORY(), 
									_jj_provsion );
						}
					}
					finally{
						
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
				public void finishSFUpffmxHistory( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpfwmOffer fromUpfwm,
						IOVUpfwmNotify fromNotify, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
							IOVUpfwmOffer _jj_provsion = (IOVUpfwmOffer)iterap.next();
							IOVUpfwmOffer _jj_history = UpfwmUtils.ICustom._wrapWithHistory( _jj_provsion );
							_jj_history.getINSTANCE().setStsToOld();
							_jj_history.setPS_STATUS( IUpfwmConst.IUpdos.CANCEL );
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromNotify.getLittle().getREPOSITORY(), 
									_jj_history );
						}
					}
					finally{
						
					}
				}
			}
			SFUpfwmExpireImpl fromUpfwmImpl = new SFUpfwmExpireImpl();
			try
			{
				ISystemTemplate.IUpfgkmComposite fromORACLE = null;
				fromORACLE = HQSQLUtils.ISystem.getSFUpfgkmTable( ISAProvision.S_TYPE.getMapingEnty() );
				IUpfgkmCityHome fromUpdfmx = UpfwmFactory.getIUpfwmDAO().getSFNotifyPassage( fromUpfgkmHome );
				for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					fromUpfwmImpl.finishSFUpffmxCancel(fromOrder, 
							fromTASK, 
							fromUpfwm, 
							fromNotify, 
							aContext);
					if( fromORACLE != null && StringUtils.isBlank( fromORACLE.getHISTORY() ) == false ){
						fromUpfwmImpl.finishSFUpffmxHistory(fromOrder, 
								fromTASK, 
								fromUpfwm, 
								fromNotify, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
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
				 * @param fromUpdfmx
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxCancel( MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpdfmx,
						IOVUpfwmNotify fromNotify,
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
							IOVUpfwmOffer _jj_provsion = (IOVUpfwmOffer)iterap.next();
							_jj_provsion.getINSTANCE().setStsToOld();
							_jj_provsion.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLLite(fromNotify,
									fromNotify.getLittle().getREPOSITORY(), 
									_jj_provsion );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpdfmx
				 * @param fromNotify
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxHistory( MBeanDelegate fromMBean,
						IUpfgkmCityHome fromUpdfmx,
						IOVUpfwmNotify fromNotify, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IUpdfmxLittle> iterap = fromNotify.getLittle().getLITTLE().iterator(); iterap.hasNext(); ){
							IOVUpfwmOffer _jj_provsion = (IOVUpfwmOffer)iterap.next();
							IOVUpfwmOffer _jj_history = UpfwmUtils.ICustom._wrapWithHistory( _jj_provsion );
							_jj_history.getINSTANCE().setStsToOld();
							_jj_history.setPS_STATUS( IUpfwmConst.IUpdos.CANCEL );
							UpfsvcManager.getSession().submitISQLLite(fromNotify,
									fromNotify.getLittle().getREPOSITORY(), 
									_jj_history );
						}
					}
					finally{
						
					}
				}
			}
			SFUpfwmExpireImpl fromUpfwmImpl = new SFUpfwmExpireImpl();
			try
			{
				ISystemTemplate.IUpfgkmComposite fromORACLE = null;
				fromORACLE = HQSQLUtils.ISystem.getSFUpfgkmTable( ISAProvision.S_TYPE.getMapingEnty() );
				IUpfgkmCityHome fromUpdfmx = UpfwmFactory.getIUpfwmDAO().getSFNotifyPassage( fromUpfgkmHome );
				for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					fromUpfwmImpl.finishSFUpffmxCancel(fromMBean, 
							fromUpdfmx, 
							fromNotify, 
							aContext);
					if( fromORACLE != null && StringUtils.isBlank( fromORACLE.getHISTORY() ) == false ){
						fromUpfwmImpl.finishSFUpffmxHistory(fromMBean, 
								fromUpdfmx, 
								fromNotify, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; } 
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
			class SFUpfwmExpireImpl{
				public SFUpfwmExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromORACLE
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxExpire( MBeanDelegate fromMBean,
						ISystemTemplate.IUpfgkmComposite fromORACLE,
						java.util.List fromUpfgkmHome, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.iterator(); itera.hasNext(); ){
							HQSQLEntityBean fromSubJect = (HQSQLEntityBean)itera.next();
							IISAProvision fromUpfwm = (IISAProvision)ClassUtils.IClass.getASTBOEntity( fromORACLE.getPERSISTENT() );
							OracleUtils.ICustom.transfer( fromSubJect, fromUpfwm );
							fromUpfwm.setComposite ( IUpdcConst.IUpdbm.IUpdbf.NORMAL );
							fromUpfwm.setCreateDate( fromMBean.getCREATE          () );
							fromUpfwm.setOrderDate ( fromMBean.getCREATE          () );
							fromUpfwm.setPsStatus  ( IUpfwmConst.IUpdos.CREATE       );
							fromSubJect.setStsToOld();
							fromSubJect.delete();
							UpfsvcManager.getSession().submitISQLLite( IUpfwmConst.IUpfwm.IUpfwmDAO, new Object[]{fromSubJect, fromUpfwm} );
						}
					}
					finally{
						
					}
				}
			}
			SFUpfwmExpireImpl fromUpfwmImpl = new SFUpfwmExpireImpl();
			try
			{
				ISystemTemplate.IUpfgkmComposite fromORACLE = null;
				IOVUpdfmxOffer fromUpdfmx = UpfwmFactory.getIUpfwmDAO().getSFNotifyLimite( fromUpfgkmHome );
				if( fromUpdfmx != null && fromUpdfmx.getORDER().getSUBFLOW().size() > 0 ){
					for( java.util.Iterator itera = fromUpdfmx.getORDER().getSUBFLOW().entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						fromORACLE = HQSQLUtils.ISystem.getSFUpfgkmTable( (String)fromEntry.getKey() );
						java.util.List fromUpfgsmHome = (java.util.List)fromEntry.getValue();
						fromUpfwmImpl.finishSFUpffmxExpire(fromMBean, 
								fromORACLE, 
								fromUpfgsmHome, 
								aContext);
						
					}
				}
			}
			finally{
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
			}
		}
		finally{
			
		}
	}

}
