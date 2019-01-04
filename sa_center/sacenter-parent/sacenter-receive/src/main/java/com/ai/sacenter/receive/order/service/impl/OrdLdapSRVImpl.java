package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV;
import com.ai.sacenter.receive.util.ExpireUtils;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVUpffmxConsult;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OrdLdapSRVImpl implements IOrdLdapSRV {

	public OrdLdapSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMsgFExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMsgFExpire(IOVMsgFRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFExpireImpl{
				public SFMsgFExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFUser, fromUpffmx, fromUpdcpm );
						IOVOrderRequest __PLATFORM__ = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction( __PLATFORM__, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFExpire(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw exception;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFSubJect(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult __PLATFORM__ = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(__PLATFORM__.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFExpire(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw exception;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFExpireImpl fromExpireImpl = new SFMsgFExpireImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVUpffmxConsult __PLATFORM__ = fromUpffmx.getPLATFORM();
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					if( __PLATFORM__ != null && __PLATFORM__.getPLATFORM() == null ){
						fromExpireImpl.finishSFMsgFExpire(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
					else if( __PLATFORM__ != null ){
						fromExpireImpl.finishSFMsgFSubJect(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMsgFEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMsgFEffective(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFEffectiveImpl{
				public SFMsgFEffectiveImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFEffective( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFUser, fromUpffmx, fromUpdcpm );
						IOVOrderRequest __PLATFORM__ = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction( __PLATFORM__, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFEffective(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFSubJect(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult __PLATFORM__ = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(__PLATFORM__.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFEffective(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw exception;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFEffectiveImpl fromUpffmxImpl = new SFMsgFEffectiveImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVUpffmxConsult __PLATFORM__ = fromUpffmx.getPLATFORM();
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					if( __PLATFORM__ != null && __PLATFORM__.getPLATFORM() == null ){
						fromUpffmxImpl.finishSFMsgFEffective(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
					else if( __PLATFORM__ != null ){
						fromUpffmxImpl.finishSFMsgFSubJect(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMsgFExpire(com.ai.sacenter.common.IUpdfmxExpire, com.ai.sacenter.valuebean.IOVUpdcpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMsgFExpire(IUpdfmxExpire fromUpdfmx, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFUpdfmxExpireImpl{
				public SFUpdfmxExpireImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromUpdfmx
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IUpfgkmOfferHome getSFMsgFBusines( IUpdfmxExpire fromUpdfmx ) throws SFException,Exception{
					IUpfgkmOfferHome fromUpdcpm = null;
					try
					{
						fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromUpdfmx );
					}
					finally{
						
					}
					return fromUpdcpm;
				}
				
				/**
				 * 
				 * @param fromUpdfmx
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVMsgFRequest getSFMsgFRequest( IUpdfmxExpire fromUpdfmx, IUpdcContext aContext) throws SFException, Exception{
					IOVMsgFRequest fromRequest = null;
					CarbonList<IUpdfmxExpire> __user__ = new CarbonList<IUpdfmxExpire>();
					try
					{
						__user__.add( fromUpdfmx );
						ClassUtils.IMerge.merge( fromUpdfmx.getSUBJECT(), __user__ );
						for( java.util.Iterator<IUpdfmxExpire> itera = __user__.iterator(); itera.hasNext(); ){
							IUpdfmxExpire __expire__ = (IUpdfmxExpire)itera.next();
							IOVUser _user_ = IOrderFactory.getICustomSV().getSFUser( __expire__.getUSER_ID(), __expire__.getUSER_REGION_ID() );
							if( _user_ != null && fromRequest == null ){
								fromRequest = ExpireUtils.ICustom._wrap( _user_, fromUpdfmx, new IOVMsgFRequest() );
							}
							else if( _user_ != null ){
								fromRequest.getUSER().add( ExpireUtils.ICustom._wrap( _user_, new IOVMsgFUser() ) );
							}
						}
					}
					finally{
						if( __user__ != null ){ __user__.clear(); __user__ = null; }
					}
					return fromRequest;
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFEffective( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOrderFactory.getIExpireSV().finishSFUserExpire(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
					finally{
						
					}
				}
			}
			SFUpdfmxExpireImpl fromUpdfmxImpl = new SFUpdfmxExpireImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromUpdfmx );
				IUpfgkmOfferHome fromUpffx = fromUpdfmxImpl.getSFMsgFBusines( fromUpdfmx );
				IOVMsgFRequest fromRequest = fromUpdfmxImpl.getSFMsgFRequest( fromUpdfmx, aContext );
				if( fromRequest != null && fromUpffx != null ){
					for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
						IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
						if( fromMsgFUser.getORDER() != null && fromMsgFUser.getORDER().size() > 0 ){
							fromUpdfmxImpl.finishSFMsgFEffective(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpffx, 
									aContext);
						}
						fromUpdfmxImpl.finishSFMsgFExpire(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpffx, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMsgFNature(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMsgFNature(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFNatureImpl{
				public SFMsgFNatureImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserNature(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOrderFactory.getIExpireSV().finishSFMsgFExpire(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserSubject(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult fromOrdUserHome = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromOrdUserHome.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdExpire(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFNatureImpl fromUpffmxImpl = new SFMsgFNatureImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IProfessionalTemplate.IBusinesOffer fromUpfgkmHome = fromUpdcpm.getCATALOG().getBUSINES();
				IOVMsgFUser fromMsgFUser = (IOVMsgFUser)fromRequest.getUSER().get( fromRequest.getUSER().size() - 1 );
				UpdbfsUtils.ICustom._nature( fromRequest, fromMsgFUser, fromUpffmx, fromUpdcpm );
				fromUpffmxImpl.finishSFUserNature(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
				if( fromMsgFUser.getORDER().size() <= 0 && ( fromUpfgkmHome != null && fromUpfgkmHome.isEXPIRE() ) 
						/*用户无定单服务产品但设置到用户换卡换号后地市变化*/){
					fromUpffmxImpl.finishSFUserExpire(fromRequest, 
							fromMsgFUser, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
				}
				else if( fromMsgFUser.getORDER() != null && fromMsgFUser.getORDER().size() > 0 ){
					fromUpffmxImpl.finishSFUserSubject(fromRequest, 
							fromMsgFUser, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMsgFGroup(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMsgFGroup(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFGroupImpl{
				public SFMsgFGroupImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserHistory(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromGroup,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIExpireSV().finishSFGroupHistory(fromRequest, 
									fromGroup, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFGroupImpl fromUpffmxImpl = new SFMsgFGroupImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromRequest.getUSER_ID() );
				if( fromMsgFUser != null ){
					UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFUser, fromUpffmx, fromUpdcpm );
					fromUpffmxImpl.finishSFUserGroup(fromRequest, 
							fromMsgFUser, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					if( fromRequest.getUSER().size() > 0 ){
						fromUpffmxImpl.finishSFUserHistory(fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMemberNature(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMemberNature(IOVMsgFRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFNatureImpl{
				public SFMsgFNatureImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromGroup
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromGroup,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
									fromGroup, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserSubject(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult fromOrdUserHome = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromOrdUserHome.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFNatureImpl fromUpffmxImpl = new SFMsgFNatureImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFUser fromGroup = fromRequest.getGROUP( );
				if( fromGroup != null ){
					UpdbfsUtils.ICustom._wrap( fromRequest, fromGroup, fromUpffmx, fromUpdcpm );
					fromUpffmxImpl.finishSFUserGroup(fromRequest, 
							fromGroup, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					IOVMsgFUser fromSubJect[] = fromRequest.getMEMBER();
					for( int index = 0; fromSubJect != null && index < fromSubJect.length; index++ ){
						fromUpffmxImpl.finishSFUserSubject(fromRequest, 
								fromSubJect[index], 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMemberEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMemberEffective(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFEffectiveImpl{
				public SFMsgFEffectiveImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromGroup
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromGroup,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
									fromGroup, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserSubject(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult fromOrdUserHome = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromOrdUserHome.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdEffective(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFEffectiveImpl fromUpffmxImpl = new SFMsgFEffectiveImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFUser fromGroup = fromRequest.getGROUP( );
				if( fromGroup != null ){
					UpdbfsUtils.ICustom._wrap( fromRequest, fromGroup, fromUpffmx, fromUpdcpm );
					fromUpffmxImpl.finishSFUserGroup(fromRequest, 
							fromGroup, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					IOVMsgFUser fromSubJect[] = fromRequest.getMEMBER();
					for( int index = 0; fromSubJect != null && index < fromSubJect.length; index++ ){
						fromUpffmxImpl.finishSFUserSubject(fromRequest, 
								fromSubJect[index], 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFMemberExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFMemberExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFExpireImpl{
				public SFMsgFExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromGroup
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromGroup,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
									fromGroup, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserSubject(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult fromOrdUserHome = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromOrdUserHome.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdExpire(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFExpireImpl fromUpffmxImpl = new SFMsgFExpireImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFUser fromGroup = fromRequest.getGROUP( );
				if( fromGroup != null ){
					UpdbfsUtils.ICustom._wrap( fromRequest, fromGroup, fromUpffmx, fromUpdcpm );
					fromUpffmxImpl.finishSFUserGroup(fromRequest, 
							fromGroup, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					IOVMsgFUser fromSubJect[] = fromRequest.getMEMBER();
					for( int index = 0; fromSubJect != null && index < fromSubJect.length; index++ ){
						fromUpffmxImpl.finishSFUserSubject(fromRequest, 
								fromSubJect[index], 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFGroupEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFGroupEffective(IOVMsgFRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFExpireImpl{
				public SFMsgFExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromGroup
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromGroup,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdEffective(fromRequest, 
									fromGroup, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserSubject(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult fromOrdUserHome = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromOrdUserHome.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdEffective(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFExpireImpl fromUpffmxImpl = new SFMsgFExpireImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFUser fromGroup = fromRequest.getGROUP( );
				if( fromGroup != null ){
					UpdbfsUtils.ICustom._wrap( fromRequest, fromGroup, fromUpffmx, fromUpdcpm );
					fromUpffmxImpl.finishSFUserGroup(fromRequest, 
							fromGroup, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					IOVMsgFUser fromSubJect[] = fromRequest.getMEMBER();
					for( int index = 0; fromSubJect != null && index < fromSubJect.length; index++ ){
						fromUpffmxImpl.finishSFUserSubject(fromRequest, 
								fromSubJect[index], 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV#getSFGroupExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpffmxRequest getSFGroupExpire(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			class SFMsgFExpireImpl{
				public SFMsgFExpireImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromGroup
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserGroup(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromGroup,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest fromUpffwm = fromUpffmx.getPLATFORM().getPLATFORM();
						fromUpffmx.getUSER().beginTransaction(fromUpffwm, fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdExpire(fromRequest, 
									fromGroup, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserSubject(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxConsult fromOrdUserHome = fromUpffmx.getPLATFORM();
						IOVOrderUser fromSubJect = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(fromOrdUserHome.getPLATFORM(), fromSubJect, fromUpdcpm);
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdExpire(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException ){
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFExpireImpl fromUpffmxImpl = new SFMsgFExpireImpl();
			try
			{
				fromUpffmx = new IOVUpffmxRequest( fromRequest );
				IOVMsgFUser fromGroup = fromRequest.getGROUP( );
				if( fromGroup != null ){
					UpdbfsUtils.ICustom._wrap( fromRequest, fromGroup, fromUpffmx, fromUpdcpm );
					fromUpffmxImpl.finishSFUserGroup(fromRequest, 
							fromGroup, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
					IOVMsgFUser fromSubJect[] = fromRequest.getMEMBER();
					for( int index = 0; fromSubJect != null && index < fromSubJect.length; index++ ){
						fromUpffmxImpl.finishSFUserSubject(fromRequest, 
								fromSubJect[index], 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
}
