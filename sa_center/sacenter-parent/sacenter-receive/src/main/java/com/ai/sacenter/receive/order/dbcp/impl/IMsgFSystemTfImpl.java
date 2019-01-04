package com.ai.sacenter.receive.order.dbcp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyUser;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 开通定单调度进程
 * @author:HC
 * @date:2016年3月2日
 * @description:
 */
public class IMsgFSystemTfImpl extends UpdbcSystemTfImpl{
	public IMsgFSystemTfImpl(){
		super();
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 开通定单调度进程</p>
	 * <p>Copyright: Copyright (c) 2018年1月3日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IRocketSystemTfImpl extends IUpdbpmSystemTfImpl{
		public IRocketSystemTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromMsgF) throws Exception {
			try
			{
				class SFRocketSyncImpl{
					public SFRocketSyncImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromMsgF
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFRocketHome( MBeanDelegate fromMBean, java.util.HashMap[] fromMsgF) throws SFException, Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromMsgF );
						try
						{
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for(int index = 0; fromMsgF != null && index < fromMsgF.length; index++ ){
								IOVRocketExigence fromRocket = new IOVRocketExigence( fromMsgF[index] );
								IUpfgkmCityHome fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromRocket.getREGION_ID() );
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
					 * @param fromRocket
					 * @throws SFException
					 * @throws Exception
					 */
					public void finishSFRocketSync( MBeanDelegate fromMBean, IUpfgkmCityHome fromRocket ) throws SFException, Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromRocket.getREGION_ID() );
							try
							{
								UpdbfsFactory.getIUpdcSV().orderReceiveAsyn(fromMBean, 
										fromRocket, 
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
					fromMBean.setOBJECTIVE( fromMsgF );
					fromMBean.setREPOSITORY( IUpdbfsConst.IUpdbm.IOrderDAO );
					IOVUpdfmxOffer fromUpdfmx = fromRocketImpl.getSFRocketHome(fromMBean, fromMsgF);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromRocket = (IUpfgkmCityHome)itera.next();
						fromRocketImpl.finishSFRocketSync( fromMBean, fromRocket );
					}
				}
				finally{
					if( fromRocketImpl != null ){ fromRocketImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 开通修复定单进程</p>
	 * <p>Copyright: Copyright (c) 2016年10月31日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUrgencySystemTfImpl extends IUpdbpmSystemTfImpl{
		public IUrgencySystemTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUrgency) throws Exception {
			try
			{
				class SFUrgencySyncImpl{
					public SFUrgencySyncImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUrgency
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUrgencyHome( MBeanDelegate fromMBean, java.util.HashMap[] fromUrgency) throws SFException, Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUrgency );
						try
						{
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for(int index = 0; fromUrgency != null && index < fromUrgency.length; index++ ){
								IOVUrgencyUser fromRocket = new IOVUrgencyUser( fromUrgency[index] );
								IUpfgkmCityHome fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromRocket.getREGION_ID() );
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
					 * @param fromUrgency
					 * @throws SFException
					 * @throws Exception
					 */
					public void finishSFUrgencySync( MBeanDelegate fromMBean, IUpfgkmCityHome fromUrgency ) throws SFException, Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUrgency.getREGION_ID() );
							try
							{
								UpdbfsFactory.getIUpdcSV().urgencyReceiveAsyn(fromMBean, 
										fromUrgency, 
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
				SFUrgencySyncImpl fromRocketImpl = new SFUrgencySyncImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setOBJECTIVE( fromUrgency );
					fromMBean.setREPOSITORY( IUpdbfsConst.IUpdbm.IUrgencyDAO );
					IOVUpdfmxOffer fromUpdfmx = fromRocketImpl.getSFUrgencyHome(fromMBean, fromUrgency);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromRocket = (IUpfgkmCityHome)itera.next();
						fromRocketImpl.finishSFUrgencySync( fromMBean, fromRocket );
					}
				}
				finally{
					if( fromRocketImpl != null ){ fromRocketImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
}
