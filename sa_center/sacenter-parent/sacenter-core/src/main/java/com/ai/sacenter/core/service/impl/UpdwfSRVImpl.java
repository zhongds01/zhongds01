package com.ai.sacenter.core.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.service.interfaces.IUpdwfSRV;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.target.IUpdbsFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdbpmUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdwfSRVImpl extends UpdcEclipseImpl implements IUpdwfSRV {
	private final static Log log = LogFactory.getLog( UpdwfSRVImpl.class );
	public UpdwfSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#createSFOrder(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVOrderPentium createSFOrder(IOVOrderRequest fromRequest,
			IOVOrderUser fromUSER, 
			IOVOrderUser fromGROUP,
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderPentium fromOrder = null;
		IOVUpdcpCatalog fromUpdbpm = null;
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		try
		{
			fromOrder = new IOVOrderPentium();
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.MEMBER, fromRequest.getORDER() );
			UpdcUtils.wrap(fromMBean, fromOrder, fromRequest, fromUSER, fromUpdcpm, fromLDAP);
			fromOrder.setORDER_ID   ( UpdcFactory.getIUpdcDAO().getORDER_ID() );
			fromOrder.setCREATE_DATE( fromMBean.getCREATE                  () );
			IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromRequest,
					fromOrder, 
					fromUSER, 
					fromGROUP, 
					fromUpdcpm, 
					fromLDAP);
			if( log.isDebugEnabled() ){
				IOVOrderPentium.IOrderOfferHome fromOfferHome = fromOrder.getORDER();
				for( java.util.Iterator itera = fromOfferHome.getOFFER().iterator(); itera.hasNext(); ){
					IOVOfferPentium fromOffer = (IOVOfferPentium)itera.next();
					if( log.isDebugEnabled() ) log.debug( "OFFER_ID = " + fromOffer.getOFFER_ID() + "\t" + 
					          fromOffer.getORDER().getOFFER() );
				}
			}
		}
		finally{
			if( fromOrder != null ){ fromOrder.getORDER().getTOKEN().getDeque().clear(); }
			if( fromUpdbpm != null ){ fromUpdbpm = null; }
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
		}
		return fromOrder;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#createSFOrder(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser[], com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceBusines, com.ai.sacenter.IUpdcContext)
	 */
	public IOVOrderPentium[] createSFOrder(IOVOrderRequest fromRequest,
			IOVOrderUser[] fromMEMBER, 
			IOVOrderUser fromGROUP,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.List fromGroupMem = new java.util.ArrayList();
		try
		{
			IProfessionalTemplate.ICompetenceOffer fromSUBFLOW = null;
			for( int index = 0; fromMEMBER != null && index < fromMEMBER.length; index++ ){
				fromSUBFLOW = fromBusines.getSUBFLOW( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_MEMBER, 
						fromMEMBER[index].getCATALOG_ID() );
				if( fromSUBFLOW != null ){
					IOVOrderPentium fromMember = createSFOrder( fromRequest, 
							fromMEMBER[index], 
							fromGROUP, 
							fromSUBFLOW, 
							aContext );
					fromMember.setCATEGORY( IUpdcConst.IUpdbm.IUpdbf.MEMBER );
					fromMember.setSTATE( IUpdcConst.IState.P );
					fromGroupMem.add( fromMember );
				}
			}
		}
		finally{
			
		}
		return (IOVOrderPentium[])fromGroupMem.toArray( new IOVOrderPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFOrder(java.lang.String)
	 */
	public IOVOrderPentium[] getSFOrder(String aVM_ORDER_ID) throws SFException, Exception {
		IOVOrderPentium fromOrder[] = null;
		try
		{
			fromOrder = UpdcFactory.getIUpdcDAO().getSFOrder( aVM_ORDER_ID );
			SFUpdfmxCoreImpl._jj_extend( fromOrder );
		}
		finally{
		
		}
		return fromOrder;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFOrder(java.lang.String, long, java.lang.String)
	 */
	public IOVOrderPentium getSFOrder(String aORDER_ID, long aUSER_ID, String aREGION_ID) throws SFException, Exception {
		IOVOrderPentium fromOrder = null;
		try
		{
			fromOrder = UpdcFactory.getIUpdcDAO().getSFOrder(aORDER_ID, aUSER_ID, aREGION_ID);
			if( fromOrder != null ){ SFUpdfmxCoreImpl._jj_extend( new IOVOrderPentium[]{ fromOrder } ); }
		}
		finally{
			
		}
		return fromOrder;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFOrder(long)
	 */
	public IOVOrderPentium getSFOrder(long aORDER_ID) throws SFException, Exception {
		IOVOrderPentium fromORDER = null;
		try
		{
			fromORDER = UpdcUtils.ISystem.getCTKSFOrder( aORDER_ID );
			if( fromORDER == null ) fromORDER = UpdcFactory.getIUpdcDAO().getSFOrder( null, aORDER_ID );
			if( fromORDER != null ) SFUpdfmxCoreImpl._jj_extend( new IOVOrderPentium[]{fromORDER} );
		}
		finally{
			
		}
		return fromORDER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IInstanceSRV#getSFOrder(com.ai.sacenter.core.valuebean.IOVTaskPentium, long)
	 */
	public IOVOrderPentium getSFOrder(IOVTaskPentium fromTASK, 
			long aORDER_ID) throws SFException, Exception {
		IOVOrderPentium fromORDER = null;
		try
		{
			fromORDER = UpdcUtils.ISystem.getCTKSFOrder( aORDER_ID );
			if( fromORDER == null ) fromORDER = UpdcFactory.getIUpdcDAO().getSFOrder( fromTASK , aORDER_ID );
			if( fromORDER != null && fromORDER.getINSTANCE() != null ){
				SFUpdfmxCoreImpl._jj_extend( new IOVOrderPentium[]{fromORDER} );
			}
		}
		finally{
			
		}
		return fromORDER;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFMember(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVOrderPentium[] getSFMember(IOVOrderPentium fromGroup) throws SFException, Exception {
		IOVOrderPentium fromMember[] = null;
		try
		{
			fromMember = UpdcUtils.ISystem.getCTKSFMember( fromGroup.getORDER_ID() );
			if( fromMember == null || fromMember.length <= 0 ){
				if( fromGroup.getINSTANCE() != null ) fromMember = UpdcFactory.getIUpdcDAO().getSFMember( fromGroup );
				if( fromMember != null && fromMember.length > 0 ){
					SFUpdfmxCoreImpl._jj_extend( fromMember );
					UpfsvcManager.getSession().submitIUpdbpmLifite( fromMember );
				}
			}
		}
		finally{
			
		}
		return fromMember;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IInstanceSRV#getSFTask(long)
	 */
	public IOVTaskPentium getSFTask(long aTASK_ID) throws SFException, Exception {
		IOVTaskPentium fromTASK = null;
		try
		{
			fromTASK = UpdcUtils.ISystem.getCTKSFTask( aTASK_ID );
			if( fromTASK == null ) fromTASK = UpdcFactory.getIUpdcDAO().getSFTask( aTASK_ID );
			if( fromTASK != null ){
				IOVOrderPentium fromPentium = getSFOrder( fromTASK, fromTASK.getORDER_ID() );
				SFUpdfmxCoreImpl._jj_extend( fromPentium, new IOVTaskPentium[]{fromTASK} );
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromPentium );
			}
		}
		finally{
			
		}
		return fromTASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IInstanceSRV#getSFTaskFail(long[])
	 */
	public IOVTaskPentium[] getSFTaskFail(long[] aTASK_ID) throws SFException, Exception {
		IOVTaskPentium fromBWK[] = null;
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			fromBWK = UpdcFactory.getIUpdcDAO().getSFTaskFail( aTASK_ID );
			if( fromBWK != null && fromBWK.length > 0 ){
				IOVOrderPentium fromORDER[] = UpdcFactory.getIUpdcDAO().getSFOrder( fromBWK );
				IOVTaskPentium  fromTASK[] = UpdcFactory.getIUpdcDAO().getSFTask( fromORDER );
				fromTASK = UpdcUtils.ICustom.merge( fromBWK , fromTASK );
				UpdcUtils.ISystem.transfer( fromORDER , fromINDEX );
				for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
					IOVOrderPentium fromBWO = UpdcUtils.ISystem.getSFOrder( fromTASK[index], fromINDEX );
					if( fromBWO == null ) ExceptionFactory.throwOracle("IOS0010019", new String[]{String.valueOf( fromTASK[index].getORDER_ID() )});
					SFUpdfmxCoreImpl._jj_extend( new IOVOrderPentium[]{fromBWO} );
					SFUpdfmxCoreImpl._jj_extend( fromBWO, new IOVTaskPentium[]{fromTASK[index]} );
					UpfsvcManager.getSession().submitIUpdbpmLifite( fromBWO );
				}
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromTASK );
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromBWK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTask(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder)
	 */
	public IOVTaskPentium getSFTask(IOVUpfwmOrder fromUpfwm) throws SFException, Exception {
		IOVTaskPentium fromTASK = null;
		try
		{
			fromTASK = UpdcUtils.ISystem.getCTKSFTask( fromUpfwm.getTASK_ID() );
			if( fromTASK == null ) fromTASK = UpdcFactory.getIUpdcDAO().getSFTask( fromUpfwm );
			if( fromTASK != null ){
				IOVOrderPentium fromORDER = getSFOrder( fromTASK , fromTASK.getORDER_ID() );
				SFUpdfmxCoreImpl._jj_extend( fromORDER, new IOVTaskPentium[]{fromTASK} );
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromORDER );
			}
		}
		finally{
			
		}
		return fromTASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTask(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder[])
	 */
	public IOVTaskPentium[] getSFTask(IOVUpfwmOrder[] fromUpfwm) throws SFException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.Map fromINDEX = new java.util.HashMap(); 
		try
		{
			fromTASK = UpdcFactory.getIUpdcDAO().getSFTask( fromUpfwm );
			if( fromTASK != null && fromTASK.length > 0 ){
				IOVOrderPentium fromORDER[] = UpdcFactory.getIUpdcDAO().getSFOrder( fromTASK );
				IOVTaskPentium fromALL[] = UpdcFactory.getIUpdcDAO().getSFTask( fromORDER );
				UpdcUtils.ISystem.transfer( fromORDER, fromINDEX );
				fromALL = UpdcUtils.ICustom.merge( fromTASK, fromALL );	
				for( int index = 0 ; fromALL != null && index < fromALL.length; index++ ){
					IOVOrderPentium fromBWO = UpdcUtils.ISystem.getCTKSFOrder( fromALL[index].getORDER_ID() );
					if( fromBWO == null  ){
						fromBWO = UpdcUtils.ISystem.getSFOrder( fromALL[index], fromINDEX );
						SFUpdfmxCoreImpl._jj_extend( new IOVOrderPentium[]{fromBWO} );
						UpfsvcManager.getSession().submitIUpdbpmLifite( fromBWO );
					}
					SFUpdfmxCoreImpl._jj_extend( fromBWO, new IOVTaskPentium[]{fromALL[index]} );
				}
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromALL );
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromTASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTask(com.ai.sacenter.core.valuebean.IOVQueuePentium)
	 */
	public IOVTaskPentium getSFTask(IOVQueuePentium fromQueue) throws SFException, Exception {
		IOVTaskPentium fromTASK = null;
		java.util.List fromList = new ArrayUQCList();
		try
		{
			fromTASK = UpdcUtils.ISystem.getCTKSFTask( fromQueue.getPLQK_ID() );
			if( fromTASK == null ) fromTASK = UpdcFactory.getIUpdcDAO().getSFTask( fromQueue );
			if( fromTASK != null ){
				IOVOrderPentium fromOrder = getSFOrder( fromTASK , fromTASK.getORDER_ID() );
				IOVTaskPentium fromArray[] = getSFTask( fromOrder );
				ClassUtils.IMerge.merge( fromArray, fromList );
				ClassUtils.IMerge.merge( new Object[]{fromTASK}, fromList );
				fromArray = (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
				SFUpdfmxCoreImpl._jj_extend( fromOrder, fromArray );
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromArray );
				UpfsvcManager.getSession().submitIUpdbpmLifite( fromOrder );
			}
		}
		finally{
			if( fromList != null ){ fromList.clear(); fromList = null;}
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IInstanceSRV#getSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVTaskPentium[] getSFTask(IOVOrderPentium fromOrder) throws SFException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.List fromPentium = new ArrayUQCList();
		try
		{
			fromTASK = UpdcUtils.ISystem.getCTKSFTask( fromOrder );
			if( fromOrder.getINSTANCE() != null && ( fromTASK == null || fromTASK.length <= 0 )){
				IOVTaskPentium fromArray[] = UpdcFactory.getIUpdcDAO().getSFTask( new IOVOrderPentium[]{fromOrder} );
				ClassUtils.IMerge.merge( fromArray, fromPentium );
				ClassUtils.IMerge.merge( fromTASK, fromPentium );
				fromTASK = (IOVTaskPentium[])fromPentium.toArray( new IOVTaskPentium[]{} );
				SFUpdfmxCoreImpl._jj_extend( fromOrder, fromTASK );
			}
		}
		finally{
			if( fromPentium != null ){ fromPentium.clear(); fromPentium = null;}
		}
		return fromTASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTaskControl(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVTaskPentium[] getSFTaskControl(IOVOrderPentium fromOrder) throws SFException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.List fromPentium = new ArrayUQCList();
		try
		{
			fromTASK = UpdcUtils.ISystem.getCTKBPMTask( fromOrder );
			if( fromOrder.getINSTANCE() != null && ( fromTASK == null || fromTASK.length <= 0 )){
				IOVTaskPentium fromArray[] = UpdcFactory.getIUpdcDAO().getSFTask( new IOVOrderPentium[]{fromOrder} );
				ClassUtils.IMerge.merge( fromArray, fromPentium );
				ClassUtils.IMerge.merge( fromTASK, fromPentium );
				fromTASK = (IOVTaskPentium[])fromPentium.toArray( new IOVTaskPentium[]{} );
				SFUpdfmxCoreImpl._jj_extend( fromOrder, fromTASK );
			}
		}
		finally{
			if( fromPentium != null ){ fromPentium.clear(); fromPentium = null;}
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTaskCreate(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVTaskPentium[] getSFTaskCreate(IOVOrderPentium fromOrder) throws SFException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.List fromPentium = new ArrayUQCList();
		try
		{
			fromTASK = UpdcUtils.ISystem.getCTKBPKTask( fromOrder );
			if( fromOrder.getINSTANCE() != null && ( fromTASK == null || fromTASK.length <= 0 )){
				IOVTaskPentium fromArray[] = UpdcFactory.getIUpdcDAO().getSFTask( new IOVOrderPentium[]{fromOrder} );
				ClassUtils.IMerge.merge( fromArray, fromPentium );
				ClassUtils.IMerge.merge( fromTASK, fromPentium );
				fromTASK = (IOVTaskPentium[])fromPentium.toArray( new IOVTaskPentium[]{} );
				SFUpdfmxCoreImpl._jj_extend( fromOrder, fromTASK );
			}
		}
		finally{
			if( fromPentium != null ){ fromPentium.clear(); fromPentium = null;}
		}
		return fromTASK;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTaskFailure(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVTaskPentium[] getSFTaskFailure(IOVOrderPentium fromOrder) throws SFException, Exception {
		java.util.List fromList = new java.util.ArrayList();
		try
		{
			IOVTaskPentium fromBWK[] = getSFTask( fromOrder );
			for( int index = 0 ; fromBWK != null && index < fromBWK.length; index++ ){
				if( fromBWK[index].isEXCEPTION() ){
					fromList.add( fromBWK[index] );
				}
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTaskReply(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVTaskPentium[] getSFTaskReply(IOVOrderPentium fromOrder) throws SFException, Exception {
		java.util.List fromList = new java.util.ArrayList();
		try
		{
			IOVTaskPentium fromBWK[] = getSFTask( fromOrder );
			for( int index = 0 ; fromBWK != null && index < fromBWK.length; index++ ){
				if( UpdbpmUtils.IIfElse.isREPLY( fromOrder, fromBWK[index] ) ){
					fromList.add( fromBWK[index] );
				}
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#getSFTaskDepend(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium)
	 */
	public IOVTaskPentium getSFTaskDepend(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK) throws SFException, Exception {
		IOVTaskPentium fromDepend = null;
		try
		{
			IOVTaskPentium fromBWK[] = getSFTask( fromOrder );
			for( int index = 0; fromBWK != null && index < fromBWK.length; index++ ){
				if (fromBWK[index].getDEPEND_TASK_ID() > 0
						&& fromBWK[index].getDEPEND_TASK_ID() == fromTASK
								.getTASK_ID()) {
					fromDepend = fromBWK[index];
				}
			}
		}
		finally{
			
		}
		return fromDepend;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IInstanceSRV#getSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[])
	 */
	public IOVTaskPentium[] getSFTask(IOVOrderPentium fromOrder, 
			IOVTaskPentium[] fromTASK) throws SFException, Exception {
		IOVTaskPentium fromPentium[] = null;
		try
		{
			IOVTaskPentium fromAll[] = getSFTask( fromOrder );
			fromPentium = UpdcUtils.ICustom.merge( fromTASK, fromAll );
			UpfsvcManager.getSession().submitIUpdbpmLifite( fromPentium );
		}
		finally{
			
		}
		return fromPentium;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#finishSFOrder(com.ai.sacenter.common.IUpdcContext)
	 */
	public void finishSFOrder(IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IUpfwmFactory.getIUpffmxSV().finishSFUpffmx( aContext );
			IOVOrderPentium __order__[] = UpdcUtils.ISystem.getSFOrder( aContext );
			IUpdbsFactory.getIUpdbsSV().finishSFOrder( __order__, aContext);
			IUpfwmFactory.getIUpfwmSV().finishSFUpfwm( aContext );
			__order__ = UpdcUtils.ISystem.getSFOrder( aContext );
			IOVTaskPentium __task__[] = UpdcUtils.ISystem.getSFTask( aContext );
			if( ( __order__ != null && __order__.length > 0 ) || ( __task__ != null && __task__.length > 0 ) ){
				UpdcFactory.getIUpdcDAO().finishSFOrder( __order__, __task__ );
			}
		}
		finally{
			
		}
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#applySFOrder(java.lang.String, java.lang.String, java.util.Map, java.sql.Timestamp, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceBusines, com.ai.sacenter.IUpdcContext)
	 */
	public IOVOrderPentium applySFOrder(IOVOrderRequest fromRequest,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderPentium fromOrder = null;
		try
		{
			class SFUpdfmxConsultImpl{
				public SFUpdfmxConsultImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromOrdUser
				 * @param fromBusines
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpdfmxSubJect(IOVOrderRequest fromRequest,
						IOVOrderUser fromOrdUser,
						IProfessionalTemplate.ICompetenceBusines fromBusines, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IProfessionalTemplate.ICompetenceOffer fromUpdcpm = null;
						fromUpdcpm = fromBusines.getBUSINES( fromOrdUser.getCATALOG_ID() );
						IOVOrderPentium fromSubJect = createSFOrder( fromRequest, 
								fromOrdUser, 
								fromRequest.getUSER(), 
								fromUpdcpm, 
								aContext );
						fromSubJect.setCOMPETENCE ( fromUpdcpm.getID()        );
						fromSubJect.setSTATE      ( fromSubJect.getORDER().isSUBFLOW()?
								IUpdcConst.IState.C:IUpdcConst.IState.O );
						fromSubJect.getORDER().setCOMPETENCE( fromUpdcpm      );
						UpfsvcManager.getSession().submitIUpdfmxLifite( fromSubJect );
						IUpdcFactory.getIUpdbpmSV().finishSFUpdbpm( new IOVOrderPentium[]{fromSubJect}, aContext );
					}
					finally{
						
					}
				}
			}
			SFUpdfmxConsultImpl fromUpdfmxImpl = new SFUpdfmxConsultImpl();
			try
			{
				fromOrder = createSFOrder( fromRequest, fromRequest.getUSER(), null, fromBusines, aContext   );
				fromOrder.setSTATE( fromOrder.getORDER().isSUBFLOW()?IUpdcConst.IState.C:IUpdcConst.IState.O );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromOrder );
				for( java.util.Iterator<IOVOrderUser> itera = fromRequest.getORDER().iterator(); itera.hasNext(); ){
					IOVOrderUser fromOrdUser = (IOVOrderUser)itera.next();
					fromUpdfmxImpl.finishSFUpdfmxSubJect(fromRequest, fromOrdUser, fromBusines, aContext);
				}
				IUpdcFactory.getIUpdbpmSV().finishSFUpdbpm( new IOVOrderPentium[]{fromOrder}, aContext );
			}
			finally{
				if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
			}
		}
		finally{
		
		}
		return fromOrder;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#applySFBatch(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceBusines, com.ai.sacenter.IUpdcContext)
	 */
	public IOVOrderPentium[] applySFBatch(IOVOrderRequest fromRequest,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderPentium fromBatch[]=null;
		try
		{
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm = null;
			fromBatch = new IOVOrderPentium[ fromRequest.getORDER().size() ];
			for( int index = 0; index < fromRequest.getORDER().size(); index++ ){
				IOVOrderUser fromOrdUser = (IOVOrderUser)fromRequest.getORDER().get( index );
				fromUpdcpm = fromBusines.getBUSINES( fromOrdUser.getCATALOG_ID() );
				fromBatch[index] = createSFOrder(fromRequest, 
						fromOrdUser, 
						fromRequest.getUSER(),
						fromUpdcpm, 
						aContext);
				fromBatch[index].setCOMPETENCE ( fromBusines.getID()       );
				fromBatch[index].setSTATE      ( fromBatch[index].getORDER().isSUBFLOW()?
						IUpdcConst.IState.C:IUpdcConst.IState.O );
				fromBatch[index].getORDER().setCOMPETENCE( fromBusines     );
				UpfsvcManager.getSession().submitIUpdfmxLifite( fromBatch[index] );
			}
			IUpdcFactory.getIUpdbpmSV().finishSFUpdbpm( fromBatch, 
					aContext );
		}
		finally{
			
		}
		return fromBatch;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#applySFGroup(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceBusines, com.ai.sacenter.IUpdcContext)
	 */
	public IOVOrderPentium applySFGroup(IOVOrderRequest fromRequest,
			IProfessionalTemplate.ICompetenceBusines fromBusines, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderPentium fromGroup = null;
		try
		{
			fromGroup = createSFOrder( fromRequest, 
					fromRequest.getUSER(), 
					null, 
					fromBusines, 
					aContext );
			fromGroup.setCATEGORY( IUpdcConst.IUpdbm.IUpdbf.GROUP );
			fromGroup.setSTATE   ( fromGroup.getORDER().isSUBFLOW()?
					IUpdcConst.IState.C:IUpdcConst.IState.O );
			UpfsvcManager.getSession().submitIUpdfmxLifite( fromGroup );
			if( fromRequest.getORDER() != null && fromRequest.getORDER().size() > 0 ){
				IOVOrderPentium fromMember[] = createSFOrder(fromRequest, 
						(IOVOrderUser[])fromRequest.getORDER().toArray( new IOVOrderUser[]{}), 
						fromRequest.getUSER(), 
						fromBusines, 
						aContext);
				for( int index = 0 ; fromMember != null && index < fromMember.length; index++ ){
					fromMember[index].setCATEGORY      ( IUpdcConst.IUpdbm.IUpdbf.MEMBER );
					fromMember[index].setGROUP_ORDER_ID( fromGroup.getORDER_ID        () );
					fromMember[index].setSTATE         ( IUpdcConst.IState.P             );
					UpfsvcManager.getSession().submitIUpdfmxLifite( fromMember[index] );
				}
			}
			IUpdcFactory.getIUpdbpmSV().finishSFUpdbpm( new IOVOrderPentium[]{fromGroup}, 
					aContext );
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#applySFCentrex(com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest, com.ai.sacenter.valuebean.IProfessionalTemplate.ICompetenceBusines, com.ai.sacenter.IUpdcContext)
	 */
	public IOVOrderPentium[] applySFCentrex(IOVOrderRequest fromRequest, 
			IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderPentium _centrex[] = null;
		try
		{
			class SFUpdbpmCTRXImpl{
				public SFUpdbpmCTRXImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromUSER
				 * @param fromUpdfmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFCentrexOrder( IOVOrderRequest fromRequest, 
						IOVOrderUser fromUSER,
						IOVUpdfmxOffer fromUpdfmx,
						IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderPentium fromOrder = IUpdcFactory.getIUpdwfSV().getSFOrder(fromRequest.getDONE_CODE(), 
								fromRequest.getUSER().getUSER_ID(), 
								fromRequest.getREGION_ID() );
						if( fromOrder == null ){
							fromUpdfmx.getORDER().getORDER().add(  createSFOrder(fromRequest, 
									fromRequest.getUSER(), 
									null, 
									fromUpdcpm, 
									aContext ) );
						}
					}
					finally{
						
					}
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
				public IOVOrderPentium[] finishSFUpdcGroup( IOVOrderRequest fromRequest, 
						IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVOrderPentium _centrex[] = null;
					try
					{
						
					}
					finally{
						
					}
					return _centrex;
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
				public IOVOrderPentium[] finishSFUpdcCentrex( IOVOrderRequest fromRequest, 
						IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVOrderPentium _centrex[] = null;
					try
					{
						
					}
					finally{
						
					}
					return _centrex;
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
				public IOVOrderPentium[] finishSFUpdcDefault( IOVOrderRequest fromRequest, 
						IProfessionalTemplate.ICompetenceBusines fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
					try
					{
						MBeanDelegate fromQuality = UpfsvcManager.getMBean().getQuality();
						if( fromRequest.getORDER() == null || fromRequest.getORDER().size() <= 0 ){
							finishSFCentrexOrder(fromRequest, 
									fromRequest.getUSER(), 
									fromUpdfmx, 
									fromUpdcpm, 
									aContext);
						}
						else/*批量用户*/{
							for( int index = 0; index < fromRequest.getORDER().size(); index++ ){
								IOVOrderUser fromOrdUser = (IOVOrderUser)fromRequest.getORDER().get( index );
								finishSFCentrexOrder(fromRequest, 
										fromOrdUser, 
										fromUpdfmx, 
										fromUpdcpm, 
										aContext);
							}
						}
						for( java.util.Iterator itera = fromUpdfmx.getORDER().getORDER().iterator(); itera.hasNext(); ){
							IOVOrderPentium _centrex = (IOVOrderPentium)itera.next();
							IOVUpdcpmOffer _complete = IUpdbsFactory.getIUpdcpmSV().getSFUpdbsComplete(_centrex, aContext);
							_centrex.setCATEGORY   ( IUpdcConst.IUpdbm.IUpdbf.CENTREX );
							_centrex.setCREATE_DATE( fromQuality.getCREATE         () );
							_centrex.setSTATE      ( _complete != null?IUpdcConst.IState.R:IUpdcConst.IState.O );
							UpfsvcManager.getSession().submitIUpdfmxLifite( _centrex );
						}
					}
					finally{
						
					}
					return (IOVOrderPentium[])fromUpdfmx.getORDER().getORDER().toArray( new IOVOrderPentium[]{} );
				}
			}
			SFUpdbpmCTRXImpl fromCentrexImpl = new SFUpdbpmCTRXImpl();
			try
			{
				if( fromUpdcpm.isGROUP() /*群组定单*/ ){
					_centrex = fromCentrexImpl.finishSFUpdcGroup(fromRequest, 
							fromUpdcpm, 
							aContext);
				}
				else if( fromUpdcpm.isCENTREX() /*成员组定单*/){
					_centrex = fromCentrexImpl.finishSFUpdcCentrex(fromRequest, 
							fromUpdcpm, 
							aContext);
				}
				else/*普通定单*/{
					_centrex = fromCentrexImpl.finishSFUpdcDefault(fromRequest, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromCentrexImpl != null ){ fromCentrexImpl = null; }
			}
		}
		finally{
			
		}
		return _centrex;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdwfSRV#applySFRollBack(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[], com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVOrderPentium applySFRollBack(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVTaskPentium[] fromUpdfmx, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderPentium fromRollBack = null;
		try
		{
			class SFUpdfmxRollBackImpl{
				private SFUpdcpmModule _module = new SFUpdcpmModule();
				public SFUpdfmxRollBackImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromOffer
				 * @param fromINDEX
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVOfferPentium _jj_offer( IOVOrderPentium fromOrder, 
						IOVOfferPentium fromOffer, 
						IOVUpdbmtcLife fromINDEX ) throws SFException,Exception{
					IOVOfferPentium fromOrdOffer = null;
					try
					{
						fromOrdOffer = (IOVOfferPentium)_module._offer.get( new Long( fromOffer.getOFFER_ID() ) );
						if( fromOrdOffer == null ){
							fromOrdOffer = new IOVOfferPentium( fromOffer );
							fromOrdOffer.setOFFER_ID   ( UpdcFactory.getIUpdcDAO().getOFFER_ID() );
							fromOrdOffer.setORDER_ID   ( fromOrder.getORDER_ID             () );
							fromOrdOffer.setCREATE_DATE( fromOrder.getCREATE_DATE          () );
							fromOrdOffer.setSORT_BY    ( fromINDEX.getINDEX                () );
							fromOrdOffer.setSTATE      ( IUpdcConst.IState.C                  );
							fromINDEX.setINDEX         ( fromINDEX.getINDEX() + 1             );
							fromOrder.getORDER().getOFFER().add( fromOrdOffer );
						}
					}
					finally{
						
					}
					return fromOrdOffer;
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfmx
				 * @param fromINDEX
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVOrderPentium _jj_centrex( IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVTaskPentium[] fromUpdfmx,
						IOVUpdbmtcLife fromINDEX,
						IUpdcContext aContext) throws SFException, Exception{
					IOVOrderPentium fromRollBack = null;
					try
					{
						fromRollBack = new IOVOrderPentium( fromOrder );
						fromRollBack.setORDER_ID       ( UpdcFactory.getIUpdcDAO().getORDER_ID() );
						fromRollBack.setCATEGORY       ( IUpdcConst.IUpdbm.IUpdbf.EXCEPTION      );
						fromRollBack.setCREATE_DATE    ( TimeUtils.getSysdate                 () );
						fromRollBack.getORDER().getOFFER().clear();
						for( java.util.Iterator itera = fromOrder.getORDER().getOFFER().iterator(); itera.hasNext(); ){
							IOVOfferPentium fromOffer = (IOVOfferPentium)itera.next();
							if( StringUtils.isBlank( fromOffer.getSUBFLOW() ) ) continue;
							IOVOfferPentium fromOrdOffer = _jj_offer( fromRollBack, fromOffer, fromINDEX );
							fromOrdOffer.setSTATE      ( IUpdcConst.IState.O                     );
						}
						fromRollBack.setCHANNEL        ( fromOrder.getCHANNEL                 () );
						fromRollBack.setCREATE_ORDER_ID( fromOrder.getORDER_ID                () );
						fromRollBack.setCREATE_TASK_ID ( fromTASK.getTASK_ID                  () );
						fromRollBack.setFAIL_LOG       ( ""                                      );
					}
					finally{
						
					}
					return fromRollBack;
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfmx
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVOrderPentium _jj_rollback(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVTaskPentium[] fromUpdfmx, 
						IUpdcContext aContext) throws SFException, Exception{
					IOVOrderPentium fromRollBack = null;
					try
					{
						IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 20000l );
						fromRollBack = _jj_centrex(fromOrder, fromTASK, fromUpdfmx, fromINDEX, aContext);
						for( int index = 0 ; fromUpdfmx != null && index < fromUpdfmx.length; index++ ){
							IOVOfferPentium fromOffer = fromUpdfmx[index].getORDER().getOFFER();
							IOVOfferPentium fromOrdOffer = _jj_offer( fromRollBack, fromOffer, fromINDEX );
							fromUpdfmx[index].setORDER_ID    ( fromRollBack.getORDER_ID   () );
							fromUpdfmx[index].setCREATE_DATE ( fromRollBack.getCREATE_DATE() );
							fromUpdfmx[index].setOFFER_ID    ( fromOrdOffer.getOFFER_ID   () );
							fromUpdfmx[index].getORDER().setOFFER( fromOrdOffer );
						}
						fromRollBack.setSTATE     ( fromUpdfmx == null || fromUpdfmx.length <= 0? 
								IUpdcConst.IState.O:IUpdcConst.IState.R );
						SFUpdfmxCoreImpl._jj_extend( new IOVOrderPentium[]{fromRollBack} );
						UpfsvcManager.getSession().submitIUpdfmxLifite( fromRollBack );
						UpfsvcManager.getSession().submitIUpdfmxLifite( fromUpdfmx );
						UpfsvcManager.getSession().submitIUpdbpmLifite( fromUpdfmx );
					}
					finally{
					
					}
					return fromRollBack;
				}
				class SFUpdcpmModule{
					private java.util.HashMap _offer    = new java.util.HashMap();
					public SFUpdcpmModule(){
						super();
					}
				}
			}
			SFUpdfmxRollBackImpl fromUpdcpmImpl = new SFUpdfmxRollBackImpl();
			UpfsvcManager.getSession().beginTransaction();
			try
			{
				fromRollBack = fromUpdcpmImpl._jj_rollback(fromOrder, 
						fromTASK, 
						fromUpdfmx, 
						aContext);
				IUpdcFactory.getISystemSV().finishSFUpfwm(fromRollBack, 
						fromUpdfmx, 
						aContext );
				UpfsvcManager.getSession().commitTransaction();
			}
			catch( java.lang.Exception aEXCEPTION){
				UpfsvcManager.getSession().rollbackTransaction();
				throw aEXCEPTION;
			}
			finally{
				if( fromUpdcpmImpl != null ){ fromUpdcpmImpl = null; }
			}
		}
		finally{
			
		}
		return fromRollBack;
	}
}

class SFUpdfmxCoreImpl{
	public SFUpdfmxCoreImpl(){
		super();
	}

	/**
	 * 完成服务定单扩展属性 
	 * @param fromOrder
	 * @throws SFException
	 * @throws Exception
	 */
	public static void _jj_extend(IOVOrderPentium[] fromOrder) throws SFException, Exception {
		try
		{
			IProfessionalTemplate.ICompetenceOffer aCOMPETENCE = null;
			for( int index = 0 ; fromOrder != null && index < fromOrder.length ; index++ ){
				if( fromOrder[index] == null ) continue;
				if( fromOrder[index].getORDER().getCOMPETENCE() != null ) continue;
				aCOMPETENCE = UpdcpmUtils.getCOMPETENCE( fromOrder[index].getCOMPETENCE() );
				fromOrder[index].getORDER().setCOMPETENCE( aCOMPETENCE );
			}
		}
		finally{
		
		}
	}

	/**
	 * 完成服务任务单扩展属性
	 * @param fromOrder
	 * @param fromTASK
	 * @throws SFException
	 * @throws Exception
	 */
	public static void _jj_extend(IOVOrderPentium fromOrder, IOVTaskPentium[] fromTASK) throws SFException, Exception {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try
		{
			ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
			IPlatformTemplate.IUpffmOffer fromUpfm = null;
			IOVTaskPentium.ITaskOfferHome fromOffer = null;
			IOVOrderPentium.IOrderOfferHome fromPentium = fromOrder.getORDER();
			for(int index = 0; fromTASK != null && index < fromTASK.length; index++){
				fromOffer = fromTASK[index].getORDER();
				if( fromOffer.getSUBFLOW() != null ) continue;
				fromOffer.setOFFER( fromPentium.getOFFER( fromTASK[index].getOFFER_ID() ) );
				fromUpdbm = IUpdcFactory.getIUpdbpmSV().getSFUpdbmBpel(fromOrder, fromTASK[index], aContext);
				if (fromUpdbm != null) {
					fromUpfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromTASK[index].getPLATFORM());
					fromOffer.setSUBFLOW( fromUpdbm );
					fromOffer.setCOMPLETE( fromUpdbm, fromUpfm );
				}
				if (fromTASK[index].getCREATE_TASK_ID() <= 0) continue;
				if (fromTASK[index].getCREATE() == null) {
					IOVTaskPentium fromCREATE = IUpdcFactory.getIUpdwfSV() .getSFTask(fromTASK[index].getCREATE_TASK_ID());
					if (fromCREATE != null) fromTASK[index].setCREATE(fromCREATE);
				}
			}
		}
		finally{
			if( aContext != null ){ aContext.clear(); aContext = null;}
		}
	}
}
