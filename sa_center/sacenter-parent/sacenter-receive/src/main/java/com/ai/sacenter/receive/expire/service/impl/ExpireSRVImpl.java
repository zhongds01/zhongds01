package com.ai.sacenter.receive.expire.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.expire.ExpireFactory;
import com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.util.ExpireUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年3月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExpireSRVImpl extends UpdcEclipseImpl implements IExpireSRV {

	public ExpireSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#getSFUpffxUser(long, java.lang.String)
	 */
	public IUpdfmxDirectory getSFUpffxUser(long aUSER_ID, String aREGION_ID) throws SFException, Exception {
		IUpdfmxDirectory _expire_factory = null;
		try
		{
			String _user_id_ = CustomUtils.ICatalog._expire_user_id( aUSER_ID );
			_expire_factory = (IUpdfmxDirectory)UpfsvcManager.getRocket().getIUpfxCustom( _user_id_ );
			if( _expire_factory == null ){
				_expire_factory = new IUpdfmxDirectory( _user_id_ );
				IOVExpireUser fromExpire[] = ExpireFactory.getExpireDAO().getExpireUser( aUSER_ID, aREGION_ID );
				for( int index = 0; fromExpire != null && index < fromExpire.length; index++ ){
					_expire_factory.getDirectory().add( fromExpire[index] );
				}
				UpfsvcManager.getRocket().submitIUpfxCustom( _user_id_, _expire_factory);
			}
		}
		finally{
			
		}
		return _expire_factory;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#getSFUpffxUser(long, java.lang.String, long)
	 */
	public IOVExpireUser getSFUpffxUser(long aUSER_ID, String aREGION_ID, long fromExpire) throws SFException, Exception {
		IOVExpireUser fromExpUser = null;
		try
		{
			IUpdfmxDirectory _expire_factory = getSFUpffxUser(aUSER_ID, aREGION_ID);
			if( _expire_factory != null && _expire_factory.getDirectory().size() > 0 ){
				for (java.util.Iterator<IUpdfmxEntry> itera = _expire_factory.getDirectory().iterator(); itera.hasNext();) {
					IOVExpireUser __user__ = (IOVExpireUser)itera.next();
					if (__user__.getUSER_ID() == aUSER_ID && __user__.getORDER_DATE() == fromExpire) {
						fromExpUser = __user__;
						break;
					}
				}
			}
		}
		finally{
			
		}
		return fromExpUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxLoad(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffxLoad(IOVMsgFRequest fromRequest, IUpfgkmOfferHome fromUpdcpm, IUpdcContext aContext) throws SFException, Exception {
		try 
		{	
			for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
				IOVMsgFUser fromUSER = (IOVMsgFUser)itera.next();
				getSFUpffxUser( fromUSER.getUSER_ID(), fromUSER.getREGION_ID() );
			}
		} 
		finally 
		{

		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxRecycle(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffxRecycle(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			String _expire_user_id = CustomUtils.ICatalog._expire_user_id( fromUser.getUSER_ID() );
			IUpdfmxDirectory __expire_factory = UpfsvcManager.getRocket().getIUpfxCustom( _expire_user_id );
			if( __expire_factory != null ){ __expire_factory.getDirectory().clear(); }
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxHistory(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffxHistory(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			IUpdfmxDirectory __expire_factory = getSFUpffxUser(fromUser.getUSER_ID(), fromUser.getREGION_ID() );
			if( __expire_factory != null && __expire_factory.getDirectory().size() > 0 ){
				for( java.util.Iterator<IUpdfmxEntry> itera = __expire_factory.getDirectory().iterator(); itera.hasNext(); ){
					IOVExpireUser fromExpire = (IOVExpireUser)itera.next();
					fromExpire.setCOMPLETE_DATE( fromMBean.getCREATE() );
					fromExpire.setSTATE        ( IUpdcConst.IState.F   );
					fromExpire.getINSTANCE().setStsToOld();
					fromExpire.getINSTANCE().delete();
					for( java.util.Iterator<IOVExpireOffer> iterap = fromExpire.getORDER().iterator(); iterap.hasNext(); ){
						IOVExpireOffer fromOffer = (IOVExpireOffer)iterap.next();
						fromOffer.setCOMPLETE_DATE( fromMBean.getCREATE() );
						fromOffer.setSTATE        ( IUpdcConst.IState.F   );
						fromOffer.getINSTANCE().setStsToOld();
						fromOffer.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLHistory(IUpdbfsConst.IUpdbm.IExpireDAO,
								fromOffer.getINSTANCE());
					}
					UpfsvcManager.getSession().submitISQLHistory(IUpdbfsConst.IUpdbm.IExpireDAO, 
							fromExpire.getINSTANCE());
				}
				finishSFUpffxRecycle( fromRequest, fromUser, aContext );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxHistory(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffxHistory(IOVMsgFRequest fromOrder,
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try 
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			IUpdfmxDirectory __expire_factory = getSFUpffxUser(fromUser.getUSER_ID(), fromUser.getREGION_ID());
			if( __expire_factory != null && __expire_factory.getDirectory().size() > 0 ){
				for (java.util.Iterator<IUpdfmxEntry> itera = __expire_factory.getDirectory().iterator(); itera.hasNext();) {
					IOVExpireUser __user__ = (IOVExpireUser)itera.next();
					for (java.util.Iterator<IOVExpireOffer> iterap = __user__.getORDER().iterator(); iterap.hasNext();) {
						IOVExpireOffer __user_offer__ = (IOVExpireOffer) iterap.next();
						if (__user_offer__.getINS_PROD_ID() == fromOffer.getINS_PROD_ID()) {
							__user_offer__.setCOMPLETE_DATE( fromMBean.getCREATE   () );
							__user_offer__.setDONE_CODE    ( fromOrder.getDONE_CODE() );
							__user_offer__.setSTATE        ( IUpdcConst.IState.Q   );
							__user_offer__.getINSTANCE().setStsToOld();
							__user_offer__.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLHistory(IUpdbfsConst.IUpdbm.IExpireDAO,
									__user_offer__.getINSTANCE());
						}
					}
				}
			}
		} 
		finally {

		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxUser(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, java.sql.Timestamp, com.ai.sacenter.IUpdcContext)
	 */
	public IOVExpireUser finishSFUpffxUser(IOVMsgFRequest fromOrder,
			IOVMsgFUser fromUser, 
			java.sql.Timestamp fromExpire, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVExpireUser _expire_user_ = null;
		try 
		{
			long aEXPIRE = Long.parseLong(TimeUtils.format(TimeUtils.expire(fromExpire), "yyyyMMdd"));
			_expire_user_ = getSFUpffxUser(fromUser.getUSER_ID(), fromUser.getREGION_ID(), aEXPIRE );
			if( _expire_user_ == null /*新装开通到期工单*/){
				IUpdfmxDirectory __expire_factory = getSFUpffxUser( fromUser.getUSER_ID(), fromUser.getREGION_ID() );
				_expire_user_ = ExpireUtils.ICustom._wrap(fromOrder, 
						fromUser, 
						aEXPIRE, 
						aContext);
				__expire_factory.getDirectory().add( _expire_user_ );
				UpfsvcManager.getSession().submitISQLHistory(IUpdbfsConst.IUpdbm.IExpireDAO, 
						_expire_user_.getINSTANCE());
			}
		} 
		finally {

		}
		return _expire_user_;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, java.sql.Timestamp, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffxExpire(IOVMsgFRequest fromOrder,
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer, 
			java.sql.Timestamp fromExpire,
			IUpdcContext aContext) throws SFException, Exception {
		try 
		{
			//判断用户到期产品订购是否归属到期系统处理
			IProfessionalTemplate.IProductCatalog fromExpireGroup[] = null;
			fromExpireGroup = IOrderFactory.getIProductSV().getSFExpireGroup(fromOrder, fromUser, fromOffer);
			if( fromExpireGroup == null || fromExpireGroup.length <= 0 ){
				IOVExpireUser fromExpUser = null;
				fromExpUser = finishSFUpffxUser(fromOrder, 
						fromUser, 
						fromExpire, 
						aContext);
				if (fromExpUser != null) {
					IOVExpireOffer fromExpOffer = null;
					fromExpOffer = ExpireUtils.ICustom._wrap(fromOrder, 
							fromUser, 
							fromOffer, 
							fromExpUser, 
							aContext);
					fromExpUser.getORDER().add(fromExpOffer);
					UpfsvcManager.getSession().submitISQLHistory(IUpdbfsConst.IUpdbm.IExpireDAO, 
							fromExpOffer.getINSTANCE());
				}
			}
		} 
		finally {

		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.service.interfaces.IExpireSRV#finishSFUpffxComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpffxComplete(MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromExpireHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			class SFUpdfmxExpireImpl {
				public SFUpdfmxExpireImpl() {
					super();
				}
				
				/**
				 * 
				 * @param fromExpireHome
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpdfmxLoad( IUpfgkmCityHome fromExpireHome ) throws RemoteException,Exception{
					java.util.Map<String, CarbonList<Long>> fromUpdfmx = new java.util.HashMap<String, CarbonList<Long>>();
					try
					{
						for( java.util.Iterator<IOVExpireUser> itera = fromExpireHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVExpireUser fromExpire = (IOVExpireUser)itera.next();
							CarbonList<Long> _user_id_home = (CarbonList<Long>)fromUpdfmx.get( fromExpire.getUSER_REGION_ID() );
							if( _user_id_home == null ){
								fromUpdfmx.put( fromExpire.getUSER_REGION_ID(), _user_id_home = new CarbonList<Long>() );
							}
							_user_id_home.add( new Long( fromExpire.getUSER_ID() ) );
						}
						IOrderFactory.getICustomSV().finishSFUserLoad( fromUpdfmx );
					}
					finally{
						if( fromUpdfmx != null ){ fromUpdfmx.clear(); fromUpdfmx = null; }
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUser
				 * @param fromExpire
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpdfmxExpire(MBeanDelegate fromMBean, 
						IOVExpireUser fromExpire, 
						IUpdcContext aContext) throws RemoteException, Exception {
					IOVMsgFRequest fromRequest = null;
					try 
					{
						IOVUser fromUser = IOrderFactory.getICustomSV().getSFUser( fromExpire.getUSER_ID(), fromExpire.getUSER_REGION_ID() );
						if( fromUser != null ){
							fromRequest = ExpireUtils.ICustom._wrap(fromUser, fromExpire, new IOVMsgFRequest() );
							IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRequest );
							if( fromUpdcpm != null ){
								IOrderFactory.getIOrderSV().orderDistribute( fromRequest, fromUpdcpm, aContext );
							}
						}
						finishSFUpdfmxHistory( fromMBean, fromExpire, aContext );
					} 
					finally{
						if (fromRequest != null) { fromRequest = null; }
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromExpire
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpdfmxHistory(MBeanDelegate fromMBean, 
						IOVExpireUser fromExpire,
						IUpdcContext aContext) throws RemoteException, Exception {
					try 
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						for (java.util.Iterator<IOVExpireOffer> itera = fromExpire.getORDER().iterator(); itera.hasNext();) {
							IOVExpireOffer fromOffer = (IOVExpireOffer)itera.next();
							fromOffer.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
							fromOffer.setSTATE        ( IUpdcConst.IState.O     );
							fromOffer.getINSTANCE().setStsToOld();
							fromOffer.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLHistory( fromMBean.getREPOSITORY(), fromOffer.getINSTANCE());
						}
						fromExpire.setCOMPLETE_DATE( fromMBean.getCOMPLETE() );
						fromExpire.setSTATE        ( IUpdcConst.IState.O     );
						fromExpire.getINSTANCE().setStsToOld();
						fromExpire.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLHistory( fromMBean.getREPOSITORY(), fromExpire.getINSTANCE() );
					} 
					finally 
					{

					}
				}

				/**
				 * 
				 * @param fromMBean
				 * @param fromExpire
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpdfmxException(MBeanDelegate fromMBean, 
						IOVExpireUser fromExpire,
						SFException aEXCEPTION, 
						IUpdcContext aContext) throws RemoteException, Exception {
					try 
					{
						fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
						fromExpire.setSTATE        ( IUpdcConst.IState.E                    );
						fromExpire.setCOMPLETE_DATE( fromMBean.getCOMPLETE               () );
						fromExpire.setFAIL_LOG     ( SystemUtils.getISTKThrow( aEXCEPTION ) );
						fromExpire.getINSTANCE().setStsToOld();
						fromExpire.getINSTANCE().delete();
						UpfsvcManager.getSession().submitISQLLifite( fromMBean.getREPOSITORY(), fromExpire.getINSTANCE() );
					} 
					finally 
					{

					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromExpireHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpdfmxException( MBeanDelegate fromMBean, 
						IUpfgkmCityHome fromExpireHome, 
						SFException aEXCEPTION,
						IUpdcContext aContext) throws RemoteException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator<IOVExpireUser> itera = fromExpireHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVExpireUser fromExpire = (IOVExpireUser)itera.next();
							UpfsvcManager.getMBean().beginTransaction();
							try
							{
								finishSFUpdfmxExpire(fromMBean, 
										fromExpire, 
										aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
								UpfsvcManager.getMBean().rollbackTransaction();
								aEXCEPTION = ExceptionFactory.getException( exception );
								finishSFUpdfmxException(fromMBean, 
										fromExpire, 
										aEXCEPTION, 
										aContext);
							}
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
				}
			}
			SFUpdfmxExpireImpl fromExpireImpl = new SFUpdfmxExpireImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromExpireImpl.finishSFUpdfmxLoad( fromExpireHome );
				fromExpireHome = ExpireFactory.getExpireDAO().getExpireUser( fromExpireHome );
				for( java.util.Iterator<IOVExpireUser> itera = fromExpireHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVExpireUser fromExpire = (IOVExpireUser)itera.next();
					UpfsvcManager.getSession().beginTransaction();
					try
					{
						fromExpireImpl.finishSFUpdfmxExpire(fromMBean, 
								fromExpire, 
								aContext);
						UpfsvcManager.getSession().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
						UpfsvcManager.getSession().rollbackTransaction();
						SFException aEXCEPTION = ExceptionFactory.getException( exception );
						fromExpireImpl.finishSFUpdfmxException(fromMBean, 
								fromExpire, 
								aEXCEPTION, 
								aContext);
					}
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromExpireImpl.finishSFUpdfmxException(fromMBean, 
						fromExpireHome, 
						aEXCEPTION, 
						aContext);
			}
		}
		finally{
			
		}
	}

}
