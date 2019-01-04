package com.ai.sacenter.tykt.dbcp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.IUpdbpmSystemTfImpl;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdbcSystemTfImpl;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.tykt.IUpfgkmConst;
import com.ai.sacenter.tykt.UpfgkmFactory;
import com.ai.sacenter.tykt.bo.ISAEquipmentReset;
import com.ai.sacenter.tykt.valuebean.IOVUpfgkmOffer;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 统一开通TF转移进程</p>
 * <p>Copyright: Copyright (c) 2011-11-2</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmSystemTfImpl extends UpdbcSystemTfImpl{

	public IUpfgkmSystemTfImpl() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活测到统一开通测进程</p>
	 * <p>Copyright: Copyright (c) 2011-11-2</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmSyncTfImpl extends IUpdbpmSystemTfImpl{
		public IUpfgkmSyncTfImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpfwm) throws SFException, Exception {
			try
			{
				class SFUpfgkmSyncTfImpl{
					public SFUpfgkmSyncTfImpl(){
						super();
					}
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfwm
					 * @param fromUpffm
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpfgkmHome( MBeanDelegate fromMBean,
							java.util.HashMap[] fromUpfwm,
							IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException,Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfwm );
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
								IOVUpfgkmOffer fromINDEX = new IOVUpfgkmOffer( fromUpfwm[index] );
								fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromINDEX.getREGION_ID() );
								if( fromCityHome == null ){
									fromCityHome = new IUpfgkmCityHome( fromUpffm.getID(), fromINDEX.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromINDEX.getREGION_ID(), fromCityHome );
								}
								fromCityHome.getCOMPLETE().add( fromINDEX );
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
					public void finishSFUpfgkmComplete( MBeanDelegate fromMBean,
							IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpfgkmFactory.getIUpfgkmSV().finishSFUpfgkmSync(fromMBean, 
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
				SFUpfgkmSyncTfImpl fromUpfgkmImpl = new SFUpfgkmSyncTfImpl();
				IOVUpdfmxOffer fromUpdfmx = null;
				try
				{
					IPlatformTemplate.IUpffmOffer fromUpffm = null;
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfgkmConst.IUpfgkmDAO );
					fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
					fromUpdfmx = fromUpfgkmImpl.getSFUpfgkmHome(fromMBean, fromUpfwm, fromUpffm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpfgkmHome.getREGION_ID() ) ) continue;
						fromUpfgkmImpl.finishSFUpfgkmComplete(fromMBean, fromUpfgkmHome);
					}
				}
				finally{
					if( fromUpdfmx != null ){ fromUpdfmx = null; }
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
	 * <p>Description: 统一开通测到开通测</p>
	 * <p>Copyright: Copyright (c) 2011-11-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmActiveTfImpl extends UpdbcSystemTfImpl{
		public IUpfgkmActiveTfImpl(){
			super();
		}
		
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			try
			{
				class IUpfgkmReplyTfImpl{
					public IUpfgkmReplyTfImpl(){
						super();
					}
					/**
					 * 
					 * @param fromUpdbm
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public IOVUpfwmCouple _wrap( java.util.HashMap fromUpdbm ) throws SFException, Exception{
						IOVUpfwmCouple fromCouple = new IOVUpfwmCouple();
						try
						{
							ISAEquipmentReset fromUpfwm = new ISAEquipmentReset();
							OracleUtils.ICustom.transfer( fromUpdbm, fromUpfwm );
							fromCouple.setPS_ID       ( fromUpfwm.getPsId       () );
							fromCouple.setBILL_ID     ( fromUpfwm.getBillId     () );
							fromCouple.setCREATE_DATE ( fromUpfwm.getCreateDate () );
							fromCouple.setREGION_CODE ( fromUpfwm.getRegionCode () );
							SFCenterOffer fromRoute = CenterUtils.ISystem._custom( fromCouple );
							fromCouple.setREGION_ID   ( fromRoute.getREGION_ID  () );
							fromCouple.setPS_PARAM    ( fromUpfwm.getPsParam    () );
							fromCouple.setTARGET_PARAM( fromUpfwm.getTargetParam() );
							fromCouple.setPS_STATUS   ( fromUpfwm.getPsStatus   () );
							if( fromUpdbm.get( IUpfgkmConst.IUpfwmCol.FAIL_CODE_COL ) != null ){
								fromCouple.setFAIL_CODE( String.valueOf( fromUpfwm.getFailCode() ) );
							}
							fromCouple.setFAIL_REASON ( StringUtils.substring(fromUpfwm.getFailReason(), 0, 100 ) );
							if( fromCouple.getPS_STATUS() == IUpfgkmConst.IUpfwm.SUCCEED /*成功报竣*/){
								fromCouple.setPS_STATUS ( IUpfwmConst.IUpdos.SUCCEED );
							}
							else if( fromCouple.getPS_STATUS() == IUpfgkmConst.IUpfwm.COMPLETE /*人工报竣*/){
								fromCouple.setPS_STATUS ( IUpfwmConst.IUpdos.HUMAN );
							}
							fromCouple.setEND_DATE    ( fromUpfwm.getEndDate    () );
							fromCouple.setRET_DATE    ( fromUpfwm.getRetDate    () );
							fromCouple.setFAIL_LOG    ( fromUpfwm.getFailLog    () );
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
					public IOVUpdfmxOffer getSFUpfgkmHome(MBeanDelegate fromMBean, java.util.HashMap[] fromUpfwm) throws Exception{
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
					public void finishSFUpfgkmComplete(MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpfgkmFactory.getIUpfgkmSV().finishSFUpfgkmComplete(fromMBean,
										fromUpfgkmHome,  
										fromOther );
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
				IUpfgkmReplyTfImpl fromUpfgkmImpl = new IUpfgkmReplyTfImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfgkmConst.IUpfgkmDAO );
					IOVUpdfmxOffer fromUpdfmx = fromUpfgkmImpl.getSFUpfgkmHome(fromMBean, fromUpdbm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpfgkmHome.getREGION_ID() ) ) continue;
						fromUpfgkmImpl.finishSFUpfgkmComplete(fromMBean, fromUpfgkmHome);
					}
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage() ,exception );
					throw exception;
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
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 营业紧急复机</p>
	 * <p>Copyright: Copyright (c) 2016年9月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmUrgencyTfImpl extends IUpdbpmSystemTfImpl{
		public IUpfgkmUrgencyTfImpl(){
			super();
		}
		
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdbcSystemTfImpl#_execute(java.util.HashMap[])
		 */
		protected void _execute(java.util.HashMap[] fromUpdbm) throws SFException, Exception {
			try
			{
				class SFUpfgkmUrgencyTfImpl{
					public SFUpfgkmUrgencyTfImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromUpfwm
					 * @return
					 * @throws Exception
					 */
					public IOVUpdfmxOffer getSFUpfgkmHome(MBeanDelegate fromMBean, java.util.HashMap[] fromUpfwm) throws Exception{
						IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfwm );
						try
						{
							IUpfgkmCityHome fromCityHome = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
								IOVUpfwmOrder fromUrgency = new IOVUpfwmOrder( fromUpfwm[index] );
								fromCityHome = (IUpfgkmCityHome)fromUpdfmxHome.getSUBFLOW().get( fromUrgency.getREGION_ID() );
								if( fromCityHome == null ){
									fromCityHome = new IUpfgkmCityHome( fromUrgency.getREGION_ID() );
									fromUpdfmxHome.getSUBFLOW().put( fromCityHome.getREGION_ID(), fromCityHome );
								}
								fromCityHome.getCOMPLETE().add( fromUrgency );
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
					public void finishSFUpfgkmUrgency(MBeanDelegate fromMBean,
							IUpfgkmCityHome fromUpfgkmHome) throws Exception{
						java.util.HashMap fromOther = new java.util.HashMap();
						try
						{
							SFCenterFactory.pushCenterInfo( fromUpfgkmHome.getREGION_ID() );
							try
							{
								fromMBean.setREGION_ID( fromUpfgkmHome.getREGION_ID() );
								UpfgkmFactory.getIUpfgkmSV().finishSFUpfgkmUrgency(fromMBean, 
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
				SFUpfgkmUrgencyTfImpl fromUpfgkmTfImpl = new SFUpfgkmUrgencyTfImpl();
				try
				{
					MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
					fromMBean.setREPOSITORY( IUpfgkmConst.IUpfgkmDAO );
					IOVUpdfmxOffer fromUpdfmx = fromUpfgkmTfImpl.getSFUpfgkmHome(fromMBean, fromUpdbm);
					IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
					for( java.util.Iterator itera = fromUpdfmxHome.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						IUpfgkmCityHome fromUpfgkmHome = (IUpfgkmCityHome)itera.next();
						if( StringUtils.isBlank( fromUpfgkmHome.getREGION_ID() ) ) continue;
						fromUpfgkmTfImpl.finishSFUpfgkmUrgency(fromMBean, fromUpfgkmHome);
					}
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					throw exception;
				}
				finally{
					if( fromUpfgkmTfImpl != null ){ fromUpfgkmTfImpl = null; }
				}
			}
			finally{
				
			}
		}
	}
}
