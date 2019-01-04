package com.ai.sacenter.util;

import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: 到期工具类</p>
 * <p>Copyright: Copyright (c) 2017年2月25日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpffmxUtils {
	public UpffmxUtils() {
		super();
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 按照地市分组转换网元通知
		 * @param fromUpfwm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdfmxOffer _jj_notify( java.util.HashMap[] fromUpfwm ) throws SFException,Exception{
			IOVUpdfmxOffer fromUpfgsmHome = null;
			try
			{
				IUpfgkmCityHome fromUpfgkmHome = null;
				fromUpfgsmHome = new IOVUpdfmxOffer( fromUpfwm );
				IOVUpdfmxOffer.IUpdfmxOfferHome fromUpffmxHome = fromUpfgsmHome.getORDER();
				for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
					IOVUpfwmNotify fromINDEX = new IOVUpfwmNotify( fromUpfwm[index] );
					fromUpfgkmHome = (IUpfgkmCityHome)fromUpffmxHome.getSUBFLOW().get( fromINDEX.getREGION_ID() );
					if( fromUpfgkmHome == null ){
						fromUpfgkmHome = new IUpfgkmCityHome( fromINDEX.getREGION_ID() );
						fromUpffmxHome.getSUBFLOW().put( fromINDEX.getREGION_ID(), fromUpfgkmHome );
					}
					fromUpfgkmHome.getCOMPLETE().add( fromINDEX );
				}
			}
			finally{
				
			}
			return fromUpfgsmHome;
		}
		/**
		 * 按照地市和网元分组转换网元通知
		 * @param fromUpfgkmHome
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdfmxOffer _jj_expire(IUpfgkmCityHome fromUpfgkmHome) throws SFException,Exception{
			IOVUpdfmxOffer fromExpireHome = null;
			try
			{
				IUpfgkmCityHome fromUpfgkmExpireHome = null;
				fromExpireHome = new IOVUpdfmxOffer( fromUpfgkmHome );
				IOVUpdfmxOffer.IUpdfmxOfferHome fromUpffmxHome = fromExpireHome.getORDER();
				for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					String fromINDEX = ClassUtils.getINDEX( new String[]{ fromNotify.getPLATFORM(), 
							"_$_",
							fromNotify.getREGION_ID() } );
					fromUpfgkmExpireHome = (IUpfgkmCityHome)fromUpffmxHome.getSUBFLOW().get( fromINDEX );
					if( fromUpfgkmExpireHome == null ){
						fromUpfgkmExpireHome = new IUpfgkmCityHome( fromNotify.getPLATFORM(), fromNotify.getREGION_ID() );
						fromUpffmxHome.getSUBFLOW().put( fromINDEX, fromUpfgkmExpireHome );
					}
					fromUpfgkmExpireHome.getCOMPLETE().add( fromNotify );
				}
			}
			finally{
						
			}
			return fromExpireHome;
		}
		/**
		 * 
		 * @param fromNotify
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdfmxOffer _jj_notify( IOVUpfwmNotify fromNotify[] ) throws SFException,Exception{
			IOVUpdfmxOffer fromExpireHome = null;
			try
			{
				IUpfgkmCityHome fromUpfgkmExpireHome = null;
				fromExpireHome = new IOVUpdfmxOffer( fromNotify );
				IOVUpdfmxOffer.IUpdfmxOfferHome fromUpffmxHome = fromExpireHome.getORDER();
				for( int index = 0; fromNotify != null && index < fromNotify.length; index++ ){
					String fromINDEX = ClassUtils.getINDEX( new String[]{ fromNotify[index].getPLATFORM(), 
							"_$_",
							fromNotify[index].getREGION_ID() } );
					fromUpfgkmExpireHome = (IUpfgkmCityHome)fromUpffmxHome.getSUBFLOW().get( fromINDEX );
					if( fromUpfgkmExpireHome == null ){
						fromUpfgkmExpireHome = new IUpfgkmCityHome(fromNotify[index].getPLATFORM(), 
								fromNotify[index].getCREATE_DATE(),
								fromNotify[index].getREGION_ID() );
						fromUpffmxHome.getSUBFLOW().put( fromINDEX, fromUpfgkmExpireHome  );
					}
					fromUpfgkmExpireHome.getCOMPLETE().add( fromNotify[index] );
				}
			}
			finally{
						
			}
			return fromExpireHome;
		}
		public static class ICustomX{
			public ICustomX(){
				super();
			}
			
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		public static class ISystemX{
			public ISystemX(){
				super();
			}
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
	}
}
