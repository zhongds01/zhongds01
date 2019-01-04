package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.bo.ISAProvisionReset;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpffmxUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于服务激活网元调度</p>
 * <p>Copyright: Copyright (c) 2014-12-3</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmSystemTfImpl extends UpdbcSystemTfImpl{

	public IUpfwmSystemTfImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务网元工单到网元测服务激活</p>
	 * <p>Copyright: Copyright (c) 2014-12-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class SFUpfgkmNetWorkTfImpl extends IUpdbpmSystemTfImpl{
		public SFUpfgkmNetWorkTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			try
			{
				class SFUpfwmNetWorkTfImpl{
					public SFUpfwmNetWorkTfImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpdbm
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpfwmHome( MBeanDelegate fromMBean, java.util.HashMap[] fromUpdbm) throws SFException, Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpdbm );
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0; fromUpdbm != null && index < fromUpdbm.length; index++ ){
								IOVUpfwmOffer fromUpfwm = new IOVUpfwmOffer( fromUpdbm[index] );
								fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromUpfwm.getREGION_ID() );
								if( fromCityHome == null ){
									fromCityHome = new IUpfgkmCityHome( fromUpfwm.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
								}
								fromCityHome.getCOMPLETE().add( fromUpfwm );
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
					public void finishSFUpfwmNetWork( MBeanDelegate fromMBean,
							IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpdcFactory.getIUpdbcFSV().finishSFUpfwmNetWork(fromMBean, 
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
				SFUpfwmNetWorkTfImpl fromUpfgkmImpl = new SFUpfwmNetWorkTfImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfwmConst.IUpfwm.IUpfwmDAO );
					IOVUpdfmxOffer fromUpdfmx = fromUpfgkmImpl.getSFUpfwmHome(fromMBean, fromUpdbm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromNotifyHome = (IUpfgkmCityHome)itera.next();
						fromUpfgkmImpl.finishSFUpfwmNetWork(fromMBean, fromNotifyHome);
					}
				}
				finally{
					if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务网元工单异步反馈到服务激活定单</p>
	 * <p>Copyright: Copyright (c) 2014-12-4</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class SFUpfgkmReplyTfImpl extends IUpdbpmSystemTfImpl{
		public SFUpfgkmReplyTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			try
			{
				class SFUpfgkmRsRspTfImpl{
					public SFUpfgkmRsRspTfImpl(){
						super();
					}
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpdbm
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpfwmRsRspHome( MBeanDelegate fromMBean, java.util.HashMap[] fromUpdbm) throws SFException,Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpdbm );
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0 ; fromUpdbm != null && index < fromUpdbm.length; index++ ){
								ISAProvisionReset provision = new ISAProvisionReset();
								OracleUtils.ICustom.transfer( fromUpdbm[index], provision );
								IOVUpfwmCouple fromCouple = new IOVUpfwmCouple( provision );
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
					public void finishSFUpfwmComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpdcFactory.getIUpdbcFSV().finishSFUpfwmComplete(fromMBean, 
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
				SFUpfgkmRsRspTfImpl fromUpfgkmImpl = new SFUpfgkmRsRspTfImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfwmConst.IUpfwm.IUpfwmDAO );
					IOVUpdfmxOffer fromUpdfmx = fromUpfgkmImpl.getSFUpfwmRsRspHome(fromMBean, fromUpdbm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromNotifyHome = (IUpfgkmCityHome)itera.next();
						fromUpfgkmImpl.finishSFUpfwmComplete(fromMBean, fromNotifyHome);
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
		 * @see com.ai.sacenter.exe.tf.IUpdcdbfmTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute1(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务开通到期工单批开</p>
	 * <p>Copyright: Copyright (c) 2017年2月24日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class SFUpfwmExpireTfImpl extends IUpdbpmSystemTfImpl{
		public SFUpfwmExpireTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpfwm) throws SFException, Exception {
			try
			{
				class SFUpffmxSyncImpl{
					public SFUpffmxSyncImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfgkmHome
					 * @throws Exception
					 */
					public void finishSFUpfwmExpire( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpdcFactory.getIUpdbcFSV().finishSFUpfwmExpire(fromMBean, 
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
				SFUpffmxSyncImpl fromUpfgkmImpl = new SFUpffmxSyncImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfwmConst.IUpfwm.IUpfwmDAO );
					IOVUpdfmxOffer fromUpdfmx = UpffmxUtils.ICustom._jj_notify( fromUpfwm );
					IOVUpdfmxOffer.IUpdfmxOfferHome fromNotifyHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromNotifyHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpfgkmHome.getREGION_ID() ) ) continue;
						fromUpfgkmImpl.finishSFUpfwmExpire(fromMBean, fromUpfgkmHome);
					}
				}
				finally{
					if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
}
