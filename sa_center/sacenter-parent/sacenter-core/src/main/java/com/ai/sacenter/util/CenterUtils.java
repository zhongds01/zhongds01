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
 * <p>Copyright: Copyright (c) 2016��3��29��</p>
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
	 * �����û������ѯ�û������Ӧ�������
	 * @param fromBILL_ID �û�����
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
	 * ���ݾ�������ѯ���������Ϣ[�粻���������쳣]
	 * @param fromBILL_ID �û�����
	 * @param fromHEADNUM ����Ŷ�
	 * @param fromCATEGORY �Ŷ�����
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
	 * ���ݾ�������ѯ���������Ϣ[�粻���������쳣]
	 * @param fromBILL_ID �û�����
	 * @param fromHEADNUM ����Ŷ�
	 * @param fromCATEGORY �Ŷ�����
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
	 * ���ݸ�����·����ȡ��ǰ������ת��
	 * @param aIMPLCLASS ��·��
	 * @param fromNetWork ��Ԫ����
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
		 * �������������Ų�ѯ����������Ϣ
		 * @param DistrictId ����������
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
		 * ���ݵ��б�Ų�ѯ����������Ϣ
		 * @param aREGION_ID ���б��
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
		 * ��ѯ��������������Ϣ
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
		 * ������·����ȡ��ǰ��·����Ӧ��Ԫ��·����
		 * @param aIMPLCLASS ��·��
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
		 * ������·����ȡ��ǰ��·����Ӧ����Դ
		 * @param aIMPLCLASS ��·��
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
		 * ������·����ȡ��ǰ��·����Ӧ��Ԫ����
		 * @param aIMPLCLASS ������
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
		 * ���ݵ��б����ѯ���������Ϣ
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
		 * ��ȡ�߳��ϵ��б���
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
		 * ��ѯ���з���ͨ����·�ɹ淶
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
		 * ����·�ɱ������Ԫ�����ѯ����������Ϣ
		 * @param aROUTE ·�ɱ���
		 * @param aCATEGORY ·������
		 * @param aPLATFORM ��������
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
		 * ���ݵ��б����ѯ����ͨ�Զ������·����Ϣ
		 * @param aREGION_ID ���б���
		 * @param aIMPLCLASS ·��������
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
		 * ����ϵͳ��Ų�ѯ�������
		 * @param aORDER_ID �������
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
		 * ���б���ת������
		 * @param aREGION_ID ���б���
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
		 * ��������·������������Ŀ¼
		 * @param aIMPLCLASS ·����
		 * @param aCENTER ����ֵ
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
		 * ��������������������Ŀ¼
		 * @param aIMPLCLASS ��Ԫ�ʲ���
		 * @param aCATEGORY ��������
		 * @param aCENTER ����ֵ
		 * @param aCHANNEL ��������
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
		 * ��������������������Ŀ¼
		 * @param aCATEGORY ��������
		 * @param aCENTER ����ֵ
		 * @param aCHANNEL ��������
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
		 * �����Զ���·�����ͻ�ȡ����·��
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
		 * ��ȡϵͳĬ�ϵ��б���
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
