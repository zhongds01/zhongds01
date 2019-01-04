package com.ai.sacenter.core.dbcp;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于服务其他TF转移进程</p>
 * <p>Copyright: Copyright (c) 2014-12-4</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdbmSystemTfImpl extends UpdbcSystemTfImpl {

	public IUpdbmSystemTfImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于服务队列调度</p>
	 * <p>Copyright: Copyright (c) 2014-12-4</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdcmqSyncTfImpl extends IUpdbpmSystemTfImpl{
		public IUpdcmqSyncTfImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromQueue) throws SFException, Exception {
			try
			{
				class SFUpdcmqSyncImpl{
					public SFUpdcmqSyncImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromQueue
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpdcmqHome( MBeanDelegate fromMBean, java.util.HashMap[] fromQueue) throws SFException,Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromQueue );
						try
						{
							IUpfgkmCityHome fromUpdcmqHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0 ; fromQueue != null && index < fromQueue.length; index++ ){
								IOVQueuePentium fromQueueHome = new IOVQueuePentium( fromQueue[index] );
								fromUpdcmqHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromQueueHome.getREGION_ID() );
								if( fromUpdcmqHome == null ){
									fromUpdcmqHome = new IUpfgkmCityHome( fromQueueHome.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromQueueHome.getREGION_ID(), fromUpdcmqHome );
								}
								fromUpdcmqHome.getCOMPLETE().add( fromQueueHome );
							}
						}
						finally{
							
						}
						return fromUpdfmx;
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpdcmqHome
					 * @throws SFException
					 * @throws Exception
					 */
					public void finishSFUpdcmqComplete( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpdcmqHome) throws SFException,Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpdcmqHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpdcmqHome.getREGION_ID() );
								UpdcFactory.getIUpdbcFSV().finishSFUpdcmqComplete(fromMBean, 
										fromUpdcmqHome, 
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
				SFUpdcmqSyncImpl fromUpdcmqImpl = new SFUpdcmqSyncImpl();
				IOVUpdfmxOffer fromUpdfmx = null;
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpdcConst.IUpdbm.IUpdcDAO );
					fromUpdfmx = fromUpdcmqImpl.getSFUpdcmqHome( fromMBean, fromQueue );
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpdcmqHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpdcmqHome.getREGION_ID() ) ) continue;
						fromUpdcmqImpl.finishSFUpdcmqComplete(fromMBean, fromUpdcmqHome);
					}
				}
				finally{
					if( fromUpdfmx != null ){ fromUpdfmx = null; }
					if( fromUpdcmqImpl != null ){ fromUpdcmqImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
}
