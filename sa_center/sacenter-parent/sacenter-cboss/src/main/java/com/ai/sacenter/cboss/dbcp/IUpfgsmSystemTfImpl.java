package com.ai.sacenter.cboss.dbcp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.cboss.UpfgsmFactory;
import com.ai.sacenter.cboss.bo.ISARadiusCallBack;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpffmxUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: CBOSS转移进程</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgsmSystemTfImpl extends UpdbcSystemTfImpl {

	public IUpfgsmSystemTfImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 即开即通到CBOSS测同步</p>
	 * <p>Copyright: Copyright (c) 2011-11-1</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmSyncTfImpl extends IUpdbpmSystemTfImpl{
		public IUpfgsmSyncTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpfwm) throws SFException, Exception {
			try
			{
				class SFUpfgsmSyncTfImpl{
					public SFUpfgsmSyncTfImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfgkmHome
					 * @throws Exception
					 */
					public void finishSFUpfgsmComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmSync(fromMBean, 
										fromUpfgkmHome, 
										fromOther);
							}
							finally{
								SFCenterFactory.popCenterInfo();
							}
						}
						finally{
							if( fromOther != null ){ fromOther.clear(); fromOther = null; }
						}
					}
				}
				SFUpfgsmSyncTfImpl fromUpfgsmImpl = new SFUpfgsmSyncTfImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfgsmConst.IUpfgsmDAO );
					IOVUpdfmxOffer fromUpdfmx = UpffmxUtils.ICustom._jj_notify( fromUpfwm );
					IOVUpdfmxOffer.IUpdfmxOfferHome fromNotifyHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromNotifyHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpfgkmHome.getREGION_ID() ) ) continue;
						fromUpfgsmImpl.finishSFUpfgsmComplete(fromMBean, fromUpfgkmHome);
					}
				}
				finally{
					if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
				}
			}
			catch( java.lang.Exception aException ){
				log.error( aException.getMessage(), aException );
				throw aException;
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: CBOSS测到即开即通同步</p>
	 * <p>Copyright: Copyright (c) 2013-6-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmActiveTfImpl extends UpdbcSystemTfImpl{
		public IUpfgsmActiveTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			try
			{
				class IUpfgsmReplyTfImpl{
					public IUpfgsmReplyTfImpl(){
						super();
					}
					/**
					 * 
					 * @param fromUpfwm
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpfwmCouple _wrap( java.util.HashMap fromUpfwm ) throws SFException,Exception{
						IOVUpfwmCouple fromCouple = new IOVUpfwmCouple();
						try
						{
							ISARadiusCallBack fromCallBack = new ISARadiusCallBack();
							OracleUtils.ICustom.transfer( fromUpfwm, fromCallBack );
							fromCouple.setPS_ID      ( fromCallBack.getSoNbr      () );
							fromCouple.setUSER_ID    ( fromCallBack.getUserId     () );
							fromCouple.setBILL_ID    ( fromCallBack.getBillId     () );
							fromCouple.setCREATE_DATE( fromCallBack.getCommitDate () );
							fromCouple.setREGION_CODE( String.valueOf( fromCallBack.getRegionCode() ) );
							SFCenterOffer fromRoute = CenterUtils.ISystem._custom( fromCouple );
							fromCouple.setREGION_ID  ( fromRoute.getREGION_ID     () );
							fromCouple.setPS_STATUS  ( IUpfwmConst.IUpdos.FAILURE    );
							if( StringUtils.isBlank( fromCallBack.getResult() ) == false && 
									StringUtils.equals( fromCallBack.getResult(), IUpfgsmConst.IUpfrsp.SUCCEED ) ){
								fromCouple.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED    );
							}
							fromCouple.setFAIL_CODE  ( fromCallBack.getResult     () );
							fromCouple.setFAIL_REASON( fromCallBack.getResultDesc () );
							fromCouple.setSTART_DATE ( fromCallBack.getCommitDate () );
							fromCouple.setEND_DATE   ( fromCallBack.getProcessDate() );
							fromCouple.setRET_DATE   ( fromCallBack.getProcessDate() );
						}
						finally{
							
						}
						return fromCouple;
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfwm
					 * @return
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpfgsmHome(MBeanDelegate fromMBean, java.util.HashMap[] fromUpfwm) throws Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfwm );
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
								IOVUpfwmCouple fromCouple = _wrap( fromUpfwm[index] );
								fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromCouple.getREGION_ID() );
								if( fromCityHome == null ){
									fromCityHome = new IUpfgkmCityHome( fromCouple.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
								}
								fromCityHome.getCOMPLETE().add( fromCouple );
							}
						}
						finally{
							
						}
						return fromUpdfmx;
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfgkmHome
					 * @throws Exception
					 */
					public void finishSFUpfgsmComplete( MBeanDelegate fromMBean,
							IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmComplete(fromMBean, 
										fromUpfgkmHome, 
										fromOther);
							}
							finally{
								SFCenterFactory.popCenterInfo();
							}
						}
						finally{
							if( fromOther != null ){ fromOther.clear(); fromOther = null; }
						}
					}
				}
				IUpfgsmReplyTfImpl fromUpfgsmImpl = new IUpfgsmReplyTfImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfgsmConst.IUpfgsmDAO );
					IOVUpdfmxOffer fromUpdfmx = fromUpfgsmImpl.getSFUpfgsmHome(fromMBean, fromUpdbm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromNotifyHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromNotifyHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpfgkmHome.getREGION_ID() ) ) continue;
						fromUpfgsmImpl.finishSFUpfgsmComplete(fromMBean, fromUpfgkmHome);
					}
				}
				finally{
					if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
				}
				
			}
			finally{
				
			}
		}
	}
}
