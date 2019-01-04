package com.ai.sacenter.suggest.dbcp;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.suggest.UpfgxmFactory;
import com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年11月9日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IUpfgxmSystemTfImpl extends UpdbcSystemTfImpl{

	public IUpfgxmSystemTfImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务开通阶段通知转移TF</p>
	 * <p>Copyright: Copyright (c) 2016年11月23日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgxmSyncTfImpl extends IUpdbpmSystemTfImpl{
		public IUpfgxmSyncTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			try
			{
				class SFUpfgxmSystemImpl{
					public SFUpfgxmSystemImpl(){
						super();
					}
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfwm
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpfgxmHome( MBeanDelegate fromMBean, java.util.HashMap[] fromUpfwm ) throws SFException,Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfwm );
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0; fromUpfwm != null && index < fromUpfwm.length; index++ ){
								IOVUpfgxmPentium fromSuggest = new IOVUpfgxmPentium( fromUpfwm[index] );
								fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromSuggest.getREGION_ID() );
								if( fromCityHome == null ){
									fromCityHome = new IUpfgkmCityHome( fromSuggest.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
								}
								fromCityHome.getCOMPLETE().add( fromSuggest ); 
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
					public void finishSFUpfgxmComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome) throws SFException,Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpfgxmFactory.getIUpfgxmSV().finishSFUpfgxmComplete(fromMBean, 
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
				SFUpfgxmSystemImpl fromSuggestImpl = new SFUpfgxmSystemImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpdcConst.IUpdbm.IUpfgxmDAO );
					IOVUpdfmxOffer fromUpdfmx = fromSuggestImpl.getSFUpfgxmHome(fromMBean, fromUpdbm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						fromSuggestImpl.finishSFUpfgxmComplete(fromMBean, fromUpfgkmHome);
					}
				}
				finally{
					if( fromSuggestImpl != null ){ fromSuggestImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
}
