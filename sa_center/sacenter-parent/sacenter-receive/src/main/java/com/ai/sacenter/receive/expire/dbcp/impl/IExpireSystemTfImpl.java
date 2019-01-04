package com.ai.sacenter.receive.expire.dbcp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.expire.ExpireFactory;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;
/**
 * 下周期处理进程
 * @author:HC
 * @date:2016年1月25日
 * @description:
 */
public class IExpireSystemTfImpl extends IUpdbpmSystemTfImpl{
	public IExpireSystemTfImpl(){
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IExpireSyncTfImpl extends IUpdbpmSystemTfImpl{
		public IExpireSyncTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromExpire) throws SFException, Exception {
			try
			{
				class SFExpireSyncImpl{
					public SFExpireSyncImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromExpire
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpffxHome(java.util.HashMap[] fromExpire) throws SFException,Exception{
						IOVUpdfmxOffer fromUpdfmx = null;
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							fromUpdfmx = new IOVUpdfmxOffer( fromExpire );
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0; fromExpire != null && index < fromExpire.length; index++ ){
								IOVExpireUser fromExpireHome = new IOVExpireUser( fromExpire[index] );
								fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromExpireHome.getREGION_ID() );
								if( fromCityHome == null ){
									fromCityHome = new IUpfgkmCityHome( fromExpireHome.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
								}
								fromCityHome.getCOMPLETE().add( fromExpireHome );
							}
						}
						finally{
							
						}
						return fromUpdfmx;
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromExpireHome
					 * @throws SFException
					 * @throws Exception
					 */
					public void finishSFUpffxComplete(MBeanDelegate fromMBean, IUpfgkmCityHome fromExpireHome ) throws SFException,Exception{
						java.util.HashMap fromASK = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromExpireHome.getREGION_ID() );
							try
							{
								ExpireFactory.getExpireSV().finishSFUpffxComplete(fromMBean, 
										fromExpireHome, 
										fromASK);
							}
							finally{
								SFCenterFactory.popCenterInfo();
							}
						}
						finally{
							if( fromASK != null ){ fromASK.clear(); fromASK = null; }
						}
					}
				}
				SFExpireSyncImpl fromExpireImpl = new SFExpireSyncImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpdbfsConst.IUpdbm.IExpireDAO );
					IOVUpdfmxOffer fromUpdfmx = fromExpireImpl.getSFUpffxHome( fromExpire );
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromExpireHome = (IUpfgkmCityHome)itera.next();
						fromExpireImpl.finishSFUpffxComplete( fromMBean, fromExpireHome );
					}
				}
				finally{
					if( fromExpireImpl != null ){ fromExpireImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
}
