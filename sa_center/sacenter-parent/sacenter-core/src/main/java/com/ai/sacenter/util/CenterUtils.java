package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.ICenterFactory;
import com.ai.sacenter.center.ICenterWrapper;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class CenterUtils {
	public CenterUtils() {
		super();
	}
	
	/**
	 * 根据用户号码查询用户号码对应局向规则
	 * @param fromBILL_ID 用户号码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice( String fromBILL_ID ) throws SFException,Exception{
		ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
		try
		{
			fromOffice = IUpdcfgFactory.getIBasicSV().getSFUpfgkmOffice(fromBILL_ID, IUpdcConst.IUpdbm.IUpdbf.MSISDN );
			if( fromOffice == null ){ 
				ExceptionFactory.throwIllegal("IOS0011048", new String[]{fromBILL_ID, IUpdcConst.IUpdbm.IUpdbf.MSISDN});
			}
		}
		finally{
			
		}
		return fromOffice;
	}
	
	/**
	 * 根据局向规则查询局向规则信息[如不存在则抛异常]
	 * @param fromBILL_ID 用户号码
	 * @param fromHEADNUM 号码号段
	 * @param fromCATEGORY 号段类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOfficeX(String fromBILL_ID, String fromHEADNUM, String fromCATEGORY) throws SFException,Exception{
		ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
		try
		{
			fromOffice = IUpdcfgFactory.getIBasicSV().getSFUpfgkmOffice(fromBILL_ID, fromHEADNUM, fromCATEGORY);
		}
		finally{
			
		}
		return fromOffice;
	}
	
    /**
	 * 根据局向规则查询局向规则信息[如不存在则抛异常]
	 * @param fromBILL_ID 用户号码
	 * @param fromHEADNUM 号码号段
	 * @param fromCATEGORY 号段类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice(String fromBILL_ID, String fromHEADNUM, String fromCATEGORY) throws SFException,Exception{
		ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
		try
		{
			fromOffice = IUpdcfgFactory.getIBasicSV().getSFUpfgkmOffice(fromBILL_ID, fromHEADNUM, fromCATEGORY);
			if( fromOffice == null ){ 
				ExceptionFactory.throwIllegal("IOS0011048", new String[]{fromBILL_ID, fromCATEGORY});
			}
		}
		finally{
			
		}
		return fromOffice;
	}
	
	/**
	 * 根据根据类路径获取当前类中心转换
	 * @param aIMPLCLASS 类路径
	 * @param fromNetWork 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ISystemTemplate.ICenterWrapper getSFCenterWrapper(String aIMPLCLASS, IPlatformTemplate.IUpffmOffer fromNetWork ) throws SFException, Exception{
		ISystemTemplate.ICenterWrapper fromWrapper = null;
		try
		{
			fromWrapper = IUpdcfgFactory.getIBasicSV().getSFCenterWrapper( aIMPLCLASS, fromNetWork );
		}
		finally{
			
		}
		return fromWrapper;
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 根据行政区域编号查询行政区域信息
		 * @param DistrictId 行政区域编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpfgkmDistrict getDistrictByDistrictId( long DistrictId ) throws SFException,Exception{
			ISystemTemplate.IUpfgkmDistrict fromDistrict = null;
			try
			{
				String fromINDEX = ClassUtils.getINDEX( new String[]{ IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT, "_$_ADL^", String.valueOf( DistrictId ) } );
				fromDistrict = (ISystemTemplate.IUpfgkmDistrict)IUpdcfgFactory.getIUpdcfgSV().hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
			}
			finally{
				
			}
			return fromDistrict;
		}
		
		/**
		 * 根据地市编号查询行政区域信息
		 * @param aREGION_ID 地市编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpfgkmDistrict getDistrictByRegionId( String aREGION_ID ) throws SFException,Exception{
			ISystemTemplate.IUpfgkmDistrict fromDistrict = null;
			try
			{
				String fromINDEX = ClassUtils.getINDEX( new String[]{ IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT, "_$_MAC^", aREGION_ID});
				fromDistrict = (ISystemTemplate.IUpfgkmDistrict)IUpdcfgFactory.getIUpdcfgSV().hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
			}
			finally{
				
			}
			return fromDistrict;
		}
		
		/**
		 * 查询所有行政地市信息
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpfgkmDistrict[] getAllDistrict( ) throws SFException,Exception{
			ISystemTemplate.IUpfgkmDistrict fromDistrict[] = null;
			try
			{
				java.util.List fromAllDistrict = null;
				String fromINDEX = ClassUtils.getINDEX( new String[]{ IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT, "_$_ADR^" });
				fromAllDistrict = (java.util.List)IUpdcfgFactory.getIUpdcfgSV().hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
				if( fromAllDistrict != null ){
					fromDistrict = (ISystemTemplate.IUpfgkmDistrict[])fromAllDistrict.toArray( new ISystemTemplate.IUpfgkmDistrict[]{});
				}
			}
			finally{
				
			}
			return fromDistrict;
		}
		
		/**
		 * 根据类路径获取当前类路径对应网元网路配置
		 * @param aIMPLCLASS 类路径
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterCatalog getSFCenterChannel( String aIMPLCLASS ) throws SFException, Exception{
			ISystemTemplate.ICenterCatalog fromCatalog = null;
			try
			{
				fromCatalog = IUpdcfgFactory.getIBasicSV().getSFCenterCatalog(aIMPLCLASS, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
			}
			finally{
				
			}
			return fromCatalog;
		}
		
		/**
		 * 根据类路径获取当前类路径对应数据源
		 * @param aIMPLCLASS 类路径
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterCatalog getSFCenterComposite( String aIMPLCLASS ) throws SFException, Exception{
			ISystemTemplate.ICenterCatalog fromCatalog = null;
			try
			{
				fromCatalog = ICustom.getSFCenterChannel( aIMPLCLASS );
				if( fromCatalog == null ){ ExceptionFactory.throwIllegal("IOS0011027", new String[]{ "*", aIMPLCLASS } ); }
			}
			finally{
				
			}
			return fromCatalog;
		}
		
		/**
		 * 根据类路径获取当前类路径对应网元配置
		 * @param aIMPLCLASS 服务类
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmOffer getSFCenterNetWork(String aIMPLCLASS ) throws SFException, Exception{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			try
			{
				ISystemTemplate.ICenterCatalog fromCatalog = null;
				fromCatalog = IUpdcfgFactory.getIBasicSV().getSFCenterCatalog(aIMPLCLASS, IUpdcConst.IUpdbm.IUpdbf.PLATFORM );
				if( fromCatalog != null ){
					fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromCatalog.getCOMPOSITE() );
				}
				if( fromUpffm == null ){ 
					ExceptionFactory.throwIllegal("IOS0011051", new String[]{aIMPLCLASS}); 
				}
			}
			finally{
				
			}
			return fromUpffm;
		}
	
		/**
		 * 根据地市编码查询局向规则信息
		 * @param aREGION_ID
		 * @param fromCatalog
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterOffer getSFUpfgkmDistrict( String aREGION_ID, SFCenterCatalog fromCatalog ) throws SFException,Exception{
			SFCenterOffer fromOffer = null;
			try
			{
				ISystemTemplate.ICenterRoute fromRoute = null;
				fromRoute = ICustom.getCenterByRegionId( aREGION_ID );
				if( fromRoute == null ) ExceptionFactory.throwIllegal("IOS0011076", new String[]{ aREGION_ID } );
				fromOffer = ISystem._wrap(fromCatalog, fromRoute);
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 获取线程上地市编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getRegionId() throws SFException,Exception{
			String aREGION_ID = null;
			try
			{
				SFCenterOffer _centeroffer = SFCenterFactory.getCenterBlank();
				if( _centeroffer != null ){ aREGION_ID = _centeroffer.getREGION_ID(); }
			}
			finally{
				
			}
			return aREGION_ID;
		}
		
		/**
		 * 查询所有服务开通地市路由规范
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map getAllRegion() throws SFException,Exception{
			java.util.Map fromALL = new java.util.HashMap();
			try
			{
				ISystemTemplate.ICenterRoute fromRoute[] = null;
				fromRoute = IUpdcfgFactory.getIBasicSV().getSFCenterSubFlow();
				if( fromRoute != null && fromRoute.length > 0 ){
					for( int index = 0; fromRoute != null && index < fromRoute.length; index++ ){
						fromALL.put( fromRoute[index].getROUTE(), fromRoute[index] );
					}
				}
			}
			finally{
				
			}
			return fromALL;
		}
		
		/**
		 * 
		 * @param aREGION_ID
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterRoute getCenterByRegionId( String aREGION_ID )  throws SFException,Exception{
			ISystemTemplate.ICenterRoute fromCENTER = null;
			try
			{
				fromCENTER = IUpdcfgFactory.getIBasicSV().getSFCenterSubFlow( aREGION_ID );
			}
			finally{
				
			}
			return fromCENTER;
		}
		
		/**
		 * 根据路由编码和网元编码查询服务中心信息
		 * @param aROUTE 路由编码
		 * @param aCATEGORY 路由类型
		 * @param aPLATFORM 归属编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterRoute getCenterOffer( String aROUTE, String aCATEGORY, String aPLATFORM ) throws SFException,Exception{
			ISystemTemplate.ICenterRoute fromCAU = null;
			try
			{
				fromCAU = IUpdcfgFactory.getIBasicSV().getSFCenterOffer(aROUTE, aCATEGORY, aPLATFORM);
			}
			finally{
				
			}
			return fromCAU;
		}
		
		/**
		 * 根据地市编码查询服务开通自定义地市路由信息
		 * @param aREGION_ID 地市编码
		 * @param aIMPLCLASS 路由适配类
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterRoute getCenterCustom( String aREGION_ID, String aIMPLCLASS ) throws SFException, Exception{
			ISystemTemplate.ICenterRoute fromRoute = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = ICustom.getSFCenterNetWork( aIMPLCLASS );
				ISystemTemplate.ICenterWrapper fromWrapper = IUpdcfgFactory.getIBasicSV().getSFCenterWrapper( aIMPLCLASS, fromUpffm );
				if( fromWrapper == null ){ 
					ExceptionFactory.throwIllegal( "IOS0011050", new String[]{ fromUpffm.getID(), aIMPLCLASS } );
				}
				fromRoute = IUpdcfgFactory.getIBasicSV().getSFCenterOffer( aREGION_ID, fromWrapper.getCATEGORY(), fromUpffm.getID() );
				if( fromRoute == null ){ ExceptionFactory.throwIllegal("IOS0011076", new String[]{ aREGION_ID }); }
			}
			finally{
				
			}
			return fromRoute;
		}
		
		/**
		 * 
		 * @param aREGION_NUMBER
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.ICenterRoute getCenterByNumber( long aREGION_NUMBER )  throws SFException,Exception{
			ISystemTemplate.ICenterRoute fromCENTER = null;
			try
			{
				fromCENTER = IUpdcfgFactory.getIBasicSV().getSFCenterSubFlow( aREGION_NUMBER );
			}
			finally{
				
			}
			return fromCENTER;
		}
		
		/**
		 * 根据系统编号查询地区编号
		 * @param aORDER_ID 定单编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getRegionIdByOrderId( long aORDER_ID ) throws SFException,Exception{
			String aREGION_ID = null;
			try
			{
				ISystemTemplate.ICenterRoute fromRoute = null;
				if( String.valueOf( aORDER_ID ).length() != 15 ){
					ExceptionFactory.throwIllegal("IOS0010031", new String[]{ String.valueOf( aORDER_ID ) } );
				}
				fromRoute = ICustom.getCenterByNumber( aORDER_ID / 1000000000000l );
				aREGION_ID = fromRoute.getROUTE();
			}
			finally{
				
			}
			return aREGION_ID;
		}
		
		/**
		 * 地市编码转换区号
		 * @param aREGION_ID 地市编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getRegionCodeByRegionId( String aREGION_ID ) throws SFException,Exception{
			String aREGION_CODE = null;
			try
			{
				ISystemTemplate.IUpfgkmDistrict fromDistrict = null;
				fromDistrict = getDistrictByRegionId( aREGION_ID );
				if( fromDistrict != null ){ aREGION_CODE = fromDistrict.getREGION_CODE(); }
			}
			finally{
				
			}
			return aREGION_CODE;
		}
		
		/**
		 * 
		 * @param aREGION_ID
		 * @param fromCatalog
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterOffer _wrap( String aREGION_ID, SFCenterCatalog fromCatalog ) throws SFException,Exception{
			SFCenterOffer fromOffer = null;
			try
			{
				ISystemTemplate.ICenterRoute fromRoute = ICustom.getCenterByRegionId( aREGION_ID );
				fromOffer = ISystem._wrap(fromCatalog, fromRoute);
			}
			finally{
				
			}
			return fromOffer;
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 根据中心路由类生成中心目录
		 * @param aIMPLCLASS 路由类
		 * @param aCENTER 中心值
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterCatalog _jj_catalog(Class aIMPLCLASS, Object aCENTER) throws SFException, Exception{
			SFCenterCatalog aCatalog = null;
			try
			{
				IPlatformTemplate.IUpffmOffer _network = ICustom.getSFCenterNetWork( aIMPLCLASS.getName() );
				ISystemTemplate.ICenterWrapper _route = CenterUtils.getSFCenterWrapper(aIMPLCLASS.getName(), _network);
				if( _route == null || StringUtils.isBlank( _route.getFUNCTION() ) ){
					ExceptionFactory.throwIllegal("IOS0011026", new String[]{ _network.getID(), aIMPLCLASS.getName() } );
				}
				aCatalog = new SFCenterCatalog( _route, aCENTER );
			}
			finally{
				
			}
			return aCatalog;
		}
		
		/**
		 * 根据中心类型生成中心目录
		 * @param aIMPLCLASS 网元资产类
		 * @param aCATEGORY 中心类型
		 * @param aCENTER 中心值
		 * @param aCHANNEL 渠道类型
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterCatalog _jj_catalog(String aIMPLCLASS, String aCATEGORY, Object aCENTER, String aCHANNEL) throws SFException, Exception{
			SFCenterCatalog aCatalog = null;
			try
			{
				ISystemTemplate.ICenterMapping fromCatalog = IUpdcfgFactory.getIBasicSV().getSFCenterMapping( aCATEGORY );
				aCatalog = new SFCenterCatalog(aIMPLCLASS, fromCatalog, aCATEGORY, aCENTER, aCHANNEL );
			}
			finally{
				
			}
			return aCatalog;
		}
		
		/**
		 * 根据中心类型生成中心目录
		 * @param aCATEGORY 中心类型
		 * @param aCENTER 中心值
		 * @param aCHANNEL 渠道类型
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterCatalog _jj_catalog(String aCATEGORY, Object aCENTER, String aCHANNEL) throws SFException, Exception{
			SFCenterCatalog aCatalog = null;
			try
			{
				ISystemTemplate.ICenterMapping _catalog = IUpdcfgFactory.getIBasicSV().getSFCenterMapping( aCATEGORY );
				aCatalog = new SFCenterCatalog( _catalog, aCENTER, aCHANNEL);
			}
			finally{
				
			}
			return aCatalog;
		}
		
		/**
		 * 
		 * @param fromCatalog
		 * @param fromRoute
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterOffer _wrap( SFCenterCatalog fromCatalog, ISystemTemplate.ICenterRoute fromRoute) throws SFException,Exception{
			SFCenterOffer _centeroffer = null;
			try
			{
				_centeroffer = new SFCenterOffer( fromCatalog, fromRoute );
			}
			finally{
				
			}
			return _centeroffer;
		}
		
		/**
		 * 
		 * @param _region_id
		 * @param _catalog
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFCenterOffer _wrap(Object _region_id, SFCenterCatalog _catalog) throws SFException, Exception{
			SFCenterOffer fromRoute = null;
			try
			{
				ICenterWrapper fromCenterImpl = null;
				ISystemTemplate.IUpdbcWrapper fromWrapper = _catalog.getSUBFLOW().getMapping();
				fromCenterImpl = ICenterFactory.getIUpdbcSV( fromWrapper.getFUNCTION() );
				if( StringUtils.isBlank( fromWrapper.getCOMPLEX() ) == false ){
					_region_id = ReflectUtils.xPath( fromWrapper.getCOMPLEX(), _region_id );
				}
				fromRoute = fromCenterImpl.wrapper( _region_id, _catalog, _catalog.getSUBFLOW().getContext() );
			}
			finally{
				
			}
			return fromRoute;
		}
		
		/**
		 * 根据自定义路由类型获取中心路由
		 * @param fromCenter
		 * @return
		 */
		public static SFCenterOffer _custom( Object fromCenter ){
    		SFCenterOffer fromRoute = null;
    		SFCenterCatalog fromCatalog = null;
    		try
    		{
    			fromCatalog = CenterUtils.ISystem._jj_catalog(IUpdcConst.IUpdbm.IUpdmc.CUSTOM_ID, 
    					fromCenter, 
    					"*");
    			fromRoute = CenterUtils.ISystem._wrap( fromCatalog.getCenter(), 
    					fromCatalog );
    		}
    		catch( java.lang.Exception aException ){
    			SFException aEXCEPTION = ExceptionFactory.getException( aException );
    			throw aEXCEPTION;
    		}
    		finally{
    			
    		}
    		return fromRoute;
		}
		
		/**
		 * 获取系统默认地市编码
		 * @return
		 */
		public static String _region_id(){
			 String aREGION_ID = null;
			 try
			 {
				 aREGION_ID = IConfigDefine.getINSTANCE().getControl().getREGION_ID();
			 }
			 finally{
				 
			 }
			 return aREGION_ID;
		}
	}
}
