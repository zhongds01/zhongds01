package com.ai.sacenter.receive.exigence.dbcp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.receive.exigence.ExigenceFactory;
import com.ai.sacenter.receive.exigence.IExigenceConst;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IExigenceSystemTfImpl extends UpdbcSystemTfImpl {
	public IExigenceSystemTfImpl() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 异步定单[本端系统]调度</p>
	 * <p>Copyright: Copyright (c) 2017年5月4日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IRocketSystemTfImpl extends IUpdbpmSystemTfImpl{
		public IRocketSystemTfImpl(){
			super();
		}
		
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			class SFRocketSyncImpl{
				public SFRocketSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromExpire
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdfmxOffer getSFRocketHome(java.util.HashMap[] fromUpfwm) throws SFException,Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfwm );;
					try
					{
						IUpfgkmCityHome fromCityHome = null;
						IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
						for( int index = 0; fromUpfwm != null && index < fromUpfwm.length; index++ ){
							IOVMocketExigence fromRocket = new IOVMocketExigence( fromUpfwm[index] );
							fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromRocket.getREGION_ID() );
							if( fromCityHome == null ){
								fromCityHome = new IUpfgkmCityHome( fromRocket.getREGION_ID() );
								fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
							}
							fromCityHome.getCOMPLETE().add( fromRocket );
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
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgkmComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome ) throws SFException,Exception{
					java.util.HashMap fromOther = new java.util.HashMap();
					try
					{
						SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
						try
						{
							fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
							ExigenceFactory.getIUpdcSV().rocketReceiveAsyn(fromMBean, 
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
			SFRocketSyncImpl fromRocketImpl = new SFRocketSyncImpl();
			try
			{
				MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
				fromMBean.setREPOSITORY( IExigenceConst.IUpdbm.IRocketDAO );
				IOVUpdfmxOffer fromUpdfmx = fromRocketImpl.getSFRocketHome(fromUpdbm);
				IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
				for( java.util.Iterator<IUpfgkmCityHome> itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
					IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
					fromRocketImpl.finishSFUpfgkmComplete( fromMBean, fromUpfgkmHome );
				}
			}
			finally{
				if( fromRocketImpl != null ){ fromRocketImpl = null; }
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 异步定单[远端系统]调度</p>
	 * <p>Copyright: Copyright (c) 2017年5月4日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IRocketRemoteTfImpl extends IUpdbpmSystemTfImpl{
		public IRocketRemoteTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			class SFRocketSyncImpl{
				public SFRocketSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromExpire
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdfmxOffer getSFRocketHome(java.util.HashMap[] fromUpfwm) throws SFException,Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfwm );;
					try
					{
						IUpfgkmCityHome fromCityHome = null;
						IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
						for( int index = 0; fromUpfwm != null && index < fromUpfwm.length; index++ ){
							IOVMocketExigence fromRocket = new IOVMocketExigence( fromUpfwm[index] );
							fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromRocket.getREGION_ID() );
							if( fromCityHome == null ){
								fromCityHome = new IUpfgkmCityHome( fromRocket.getREGION_ID() );
								fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
							}
							fromCityHome.getCOMPLETE().add( fromRocket );
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
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgkmComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome ) throws SFException,Exception{
					java.util.HashMap fromOther = new java.util.HashMap();
					try
					{
						SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
						try
						{
							fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
							ExigenceFactory.getIUpdcSV().rocketReceiveAsyn(fromMBean, 
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
			SFRocketSyncImpl fromRocketImpl = new SFRocketSyncImpl();
			try
			{
				MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
				fromMBean.setREPOSITORY( IExigenceConst.IUpdbm.IRemoteDAO );
				IOVUpdfmxOffer fromUpdfmx = fromRocketImpl.getSFRocketHome(fromUpdbm);
				IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
				for( java.util.Iterator<IUpfgkmCityHome> itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
					IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
					fromRocketImpl.finishSFUpfgkmComplete( fromMBean, fromUpfgkmHome );
				}
			}
			finally{
				if( fromRocketImpl != null ){ fromRocketImpl = null; }
			}
		}
	}
}
