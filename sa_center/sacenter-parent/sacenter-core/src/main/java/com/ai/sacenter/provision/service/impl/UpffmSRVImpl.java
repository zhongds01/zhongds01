package com.ai.sacenter.provision.service.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.ISAProvisionHis;
import com.ai.sacenter.provision.bo.ISAWorkOrder;
import com.ai.sacenter.provision.service.interfaces.IUpffmSRV;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpffmUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-4-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpffmSRVImpl extends UpdcEclipseImpl implements IUpffmSRV {

	public UpffmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
			fromUpdbm = UpdcUtils.ISubFlow.getSUBFLOW(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					aContext);
			fromTASK.getORDER().setCOMPLETE( fromUpdbm, fromUpdfwm.getPLATFORM() );
			IOVUpfwmOrder fromUpfwom = UpffmUtils.ICustom._wrap(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUpfwm, 
					aContext);
			UpfsvcManager.getSession().submitISQLLite( fromTASK,
					fromUpfwm.getORDER().getREPOSITORY(), 
					fromUpfwom.getINSTANCE() );	
			fromUpfwm.getORDER().setORDER( fromUpfwom );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmCreate(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmOffer fromHISTORY = null;
		try
		{
			fromHISTORY = UpfwmUtils.ICustom._wrap(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUpfwm, 
					ISAProvisionHis.S_TYPE, 
					aContext);
			UpfsvcManager.getSession().submitISQLLite( fromTASK,
					fromUpfwm.getORDER().getREPOSITORY(), 
					fromHISTORY.getINSTANCE() );
			if( fromHISTORY.isCREATE() /*等待网元反馈流程*/){
				finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
		}
		finally{
			if( fromHISTORY != null ){ fromHISTORY = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmHistory(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmHistory(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmOffer fromHISTORY = null;
		try
		{
			fromHISTORY = UpfwmUtils.ICustom._wrap(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUpfwm, 
					ISAProvisionHis.S_TYPE, 
					aContext);
			fromHISTORY.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
			UpfsvcManager.getSession().submitISQLLite( fromTASK,
					fromUpfwm.getORDER().getREPOSITORY(), 
					fromHISTORY.getINSTANCE() );
		}
		finally{
			if( fromHISTORY != null ){ fromHISTORY = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.provision.valuebean.IOVUpfwmCouple[], com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IOVUpfwmCouple[] fromCouple, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfwmCreateImpl{
				public SFUpfwmCreateImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromCouple
				 * @param aContext
				 * @return
				 * @throws RemoteException
				 * @throws Exception
				 */
				public IOVUpfwmOrder[] getSFUpfbpmComplete( MBeanDelegate fromMBean,
						IOVUpfwmCouple fromCouple[],
						IUpdcContext aContext) throws RemoteException, Exception{
					java.util.List aCOMPLETE = new java.util.ArrayList();
					java.util.Map fromUpfgsmHome = null;
					try
					{
						fromUpfgsmHome = UpfwmFactory.getIUpfwmDAO( ).getSFUpfwmOrder( fromCouple );
						for( java.util.Iterator itera = fromUpfgsmHome.entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							ISAWorkOrder fromORDER = (ISAWorkOrder)fromEntry.getKey();
							IOVUpfwmCouple fromUpfwm = (IOVUpfwmCouple)fromEntry.getValue();
							IOVUpfwmOrder fromOrder = new IOVUpfwmOrder( fromORDER );
							UpfwmUtils.ICustom.wrap( fromMBean, fromUpfwm, fromOrder );
							aCOMPLETE.add( fromOrder );
						}
					}
					finally{
						if( fromUpfgsmHome != null ){ fromUpfgsmHome.clear(); fromUpfgsmHome = null; }
					}
					return (IOVUpfwmOrder[])aCOMPLETE.toArray( new IOVUpfwmOrder[]{} );
				}
				/**
				 * 
				 * @param fromUpfwm
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				private void finishSFUpdcpmLoading( IOVUpfwmOrder[] fromUpfwm, 
						IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						IPlatformTemplate.IUpffmsOffer fromRespond = null;
						for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
							IOVUpdspmLife fromUpdfwm = IUpfwmFactory.getIUpdfwmSV().getASKUpdfwm(fromUpfwm[index], aContext);
							fromUpfwm[index].getORDER().setBottom( fromUpdfwm );
							if( fromUpfwm[index].isMANUAL() ) continue;
							fromRespond = IUpfwmFactory.getIUpdcpmSV().getSFUpfwmRespond( fromUpfwm[index], aContext );
							if( fromRespond != null ){
								fromUpfwm[index].getORDER().setRespond( fromRespond );
								if( StringUtils.isBlank( fromUpfwm[index].getORDER().getRspDesc() ) ){
									fromUpfwm[index].getORDER().setRspDesc( fromRespond.getNAME() );
								}
								if( fromUpfwm[index].isACHIEVE() == false /*异常归档*/){
									fromUpfwm[index].getORDER().setSTATUS( fromRespond != null?
											(fromRespond.isSUCCEED()?IUpfwmConst.IUpdos.SUCCEED:IUpfwmConst.IUpdos.FAILURE)
											:fromUpfwm[index].getPS_STATUS() );
								}
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 根据网元定单反馈预转载到服务激活反馈模型中
				 * @param fromOrder
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				private void finishSFUpfbpmCreate(IOVUpfwmOrder[] fromOrder, 
						IUpdcContext aContext) throws RemoteException, Exception {
					java.util.List fromUpdbpm = new java.util.ArrayList();
					try
					{
						for( int index = 0; fromOrder != null && index < fromOrder.length; index++ ){
							if( fromOrder[index].isSUBFLOW()/*归档策略为服务开通*/){
								fromUpdbpm.add( fromOrder[index] );
							}
						}
						if( fromUpdbpm != null && fromUpdbpm.size() > 0 ){
							IOVUpfwmOrder[] fromSubflow = (IOVUpfwmOrder[])fromUpdbpm.toArray( new IOVUpfwmOrder[]{} );
							IOVTaskPentium fromTASK[] = IUpdcFactory.getIUpdwfSV().getSFTask( fromSubflow );
							if( fromTASK != null && fromTASK.length > 0 ){
								UpfsvcManager.getSession().submitIUpdfmxLifite( fromTASK );
							}
						}
						finishSFUpdcpmLoading(fromOrder, aContext);
					}
					finally{
						if( fromUpdbpm != null ){ fromUpdbpm.clear(); fromUpdbpm = null; }
					}
				}
				/**
				 * 
				 * @param fromOrder
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				private void finishSFUpfbpmComplete(IOVUpfwmOrder[] fromOrder, 
						IUpdcContext aContext) throws SFException, Exception {
					try
					{
						
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromOrder
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfbpmComplete(MBeanDelegate fromMBean,
						IOVUpfwmOrder[] fromOrder, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( int index = 0; fromOrder != null && index < fromOrder.length; index++ ){
							IOVUpdcpmOffer fromUpdcpm = null;
							try
							{
								UpfsvcManager.getSession().beginTransaction();
								fromUpdcpm = IUpfwmFactory.getIUpdcpmSV().getSFUpfwmComplete(fromOrder[index], 
										aContext);
								if( fromUpdcpm == null /*网元工单归档[删除服务定单反馈单和网元反馈单]*/){
									finishSFUpfwmHistory(fromOrder[index], 
											fromUpdcpm, 
											aContext);
								}
								else/*网元工单归档[按照网元定单归档组件策略]*/{
									IUpfwmFactory.getIUpdcpmSV().finishSFUpfwmComplete(fromOrder[index], 
											fromUpdcpm,
											aContext);
								}
								UpfsvcManager.getSession().commitTransaction();
							}
							catch( java.lang.Exception aException ){
								log.error( aException.getMessage() , aException );
								UpfsvcManager.getSession().rollbackTransaction();
								SFException aEXCEPTION = ExceptionFactory.getException( aException );
								finishSFUpfwmException(fromOrder[index],
										fromUpdcpm,
										aEXCEPTION,
										aContext);
							}
							finally{
								if( fromUpdcpm != null ){ fromUpdcpm = null; }
							}
						}
					}
					finally{
						
					}
				}
				
			}
			SFUpfwmCreateImpl fromUpfgsmImpl = new SFUpfwmCreateImpl();
			try
			{
				IOVUpfwmOrder fromOrder[] = fromUpfgsmImpl.getSFUpfbpmComplete(fromMBean, 
						fromCouple, 
						aContext);
				if( fromOrder != null && fromOrder.length > 0 ){
					fromUpfgsmImpl.finishSFUpfbpmCreate(fromOrder, aContext);
					try
					{
						fromUpfgsmImpl.finishSFUpfbpmComplete(fromMBean, 
								fromOrder, 
								aContext);
					}
					finally{
						fromUpfgsmImpl.finishSFUpfbpmComplete(fromOrder, aContext);
					}
				}
			}
			finally{
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmHistory(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmHistory(IOVUpfwmOrder fromPentium, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfwmOrder.IUpfwmOfferHome fromOfferHome = fromPentium.getORDER();
			fromPentium.getINSTANCE().setStsToOld();
			fromPentium.getINSTANCE().delete();
			UpfsvcManager.getSession().submitISQLHistory(fromPentium.getINSTANCE());
			if( fromOfferHome.getORIGING() != null ){
				IOVUpfwmOrder.IUpfwmOrigHome fromORIGING = fromOfferHome.getORIGING();
				fromORIGING.getORIGING().setStsToOld();
				fromORIGING.getORIGING().delete();
				UpfsvcManager.getSession().submitISQLLite( fromORIGING.getREPOSITORY(),
						fromORIGING.getORIGING() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmException(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmException(IOVUpfwmOrder fromPentium, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfwmOrder.IUpfwmOfferHome fromOfferHome = fromPentium.getORDER();
			fromPentium.getINSTANCE().setStsToOld();
			fromPentium.getINSTANCE().delete();
			UpfsvcManager.getSession().submitISQLHistory( new Object[]{fromPentium.getINSTANCE() });
			if( fromOfferHome.getORIGING() != null ){
				IOVUpfwmOrder.IUpfwmOrigHome fromORIGING = fromOfferHome.getORIGING();
				fromORIGING.getORIGING().setStsToOld();
				fromORIGING.getORIGING().delete();
				UpfsvcManager.getSession().submitISQLHistory(fromORIGING.getREPOSITORY(),
						new Object[]{ fromORIGING.getORIGING() });
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFTaskComplete(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFTaskComplete(IOVUpfwmOrder fromPentium, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			fromASK = UpfwmUtils.ICustom.wrap(fromPentium, fromASK);
			if( fromPentium.isSUBFLOW() /*归档策略为服务开通*/){
				IUpdcFactory.getISystemSV().finishSFTask( fromPentium.getTASK_ID(), 
						fromASK);
			}
			finishSFUpfwmHistory(fromPentium, 
					fromUpdcpm, 
					aContext);
		}
		finally{
			if( fromASK != null ){ fromASK = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.service.interfaces.IUpffmSRV#finishSFUpfwmException(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFUpfwmException(IOVUpfwmOrder fromPentium, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpfwmOrder.IUpfwmOfferHome fromOfferHome = fromPentium.getORDER();
			fromPentium.setSTATE( IUpdcConst.IState.E );
			fromPentium.setRESULT( SystemUtils.getISTKThrow( aEXCEPTION ) );
			fromPentium.getINSTANCE().setStsToOld();
			fromPentium.getINSTANCE().delete();
			UpfsvcManager.getSession().submitISQLLifite( fromPentium.getINSTANCE() );
			if( fromOfferHome.getORIGING() != null ){
				IOVUpfwmOrder.IUpfwmOrigHome fromORIGING = fromOfferHome.getORIGING();
				fromORIGING.getORIGING().setStsToOld();
				fromORIGING.getORIGING().delete();
				UpfsvcManager.getSession().submitISQLLite(fromORIGING.getREPOSITORY(),
						new Object[]{ fromORIGING.getORIGING() });
			}
		}
		finally{
			
		}
	}
}
