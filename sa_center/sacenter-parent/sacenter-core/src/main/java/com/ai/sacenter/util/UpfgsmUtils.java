package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.SAMapping;
import com.ai.sacenter.base.platform.bo.SAMappingRel;
import com.ai.sacenter.common.IUpfvmsSTKLocal;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jeval.EvaluationConstants;
import com.ai.sacenter.jeval.PhantomEvaluator;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月16日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfgsmUtils {
	public UpfgsmUtils() {
		super();
	}
	/**
	 * 从基于配置表解析为标准映射集
	 * @param fromUpdbsm
	 * @param fromUpfgsm
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.util.HashMap deployUpfsmOracle( java.util.HashMap fromUpdbsm , 
			java.util.HashMap fromUpfgsm ) throws SFException,Exception{
		try
		{
			IPlatformTemplate.IUpffsmOffer fromUpfgsmc = null;
			if( fromUpdbsm == null ) fromUpdbsm = BasicFactory.getIUpffmSV().getIUpffsmOffer();
			java.util.HashMap fromUpfvm = (java.util.HashMap)fromUpdbsm.get( "MODULE" );
			java.util.HashMap fromUpfms = (java.util.HashMap)fromUpdbsm.get( "MAPPING" );
			if( fromUpfms == null ) fromUpfms = new java.util.HashMap();
			if( fromUpfgsm == null ) fromUpfgsm = new java.util.HashMap();
			for( java.util.Iterator itera = fromUpfvm.entrySet().iterator() ; itera.hasNext() ; ){
				java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
				SAMapping fromModule = (SAMapping)aEntry.getKey();
				java.util.List fromUpffgsm = (java.util.List)aEntry.getValue();
				fromUpfgsmc = new IPlatformTemplate.IUpffsmOffer( fromModule );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_MAPPING, 
						new String[]{ fromUpfgsmc.getID() } );
				for( java.util.Iterator iterap = fromUpffgsm.iterator() ; iterap.hasNext() ; ){
					SAMappingRel fromCatalog = (SAMappingRel)iterap.next();
					fromUpfgsmc.baleUcm2Upfsm( fromCatalog , fromUpfms );
				}
				fromUpfgsm.put( fromINDEX , fromUpfgsmc );
			}
		}
		finally{
			
		}
		return fromUpfgsm;
	}
	/**
	 * 从映射文件解析为标准映射集
	 * @param aFILE
	 * @param fromUpfgsm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.util.Map deployUpfsmFile( String aFILE , 
			java.util.Map fromUpfgsm ) throws SFException,Exception{
		try {
			if (fromUpfgsm == null) fromUpfgsm = new java.util.HashMap();
			IPlatformTemplate.IUpffsmOffer fromUpfsmc = null;
			org.dom4j.Element aElement = XmlUtils.parseFileXml(aFILE);
			for (java.util.Iterator itera = aElement.elements("mappings").iterator(); itera.hasNext();) {
				org.dom4j.Element element = (org.dom4j.Element) itera.next();
				String aUSE = element.attributeValue("use", "true");
				if (aUSE.equalsIgnoreCase( "false" ) ) continue;
				fromUpfsmc = new IPlatformTemplate.IUpffsmOffer( element );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_MAPPING, 
						new String[]{ fromUpfsmc.getID() } );
				if (fromUpfgsm.containsKey( fromINDEX ) == false){
					fromUpfgsm.put( fromINDEX, fromUpfsmc);
				}
				else{
					((IPlatformTemplate.IUpffsmOffer) fromUpfgsm
							.get(fromINDEX)).baleUcm2Upfsm(fromUpfsmc);
				}
			}
		} finally {

		}
		return fromUpfgsm;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffsmOffer getPROGRAM( IUpdcContext aContext ) throws SFException,Exception{
			IPlatformTemplate.IUpffsmOffer fromUpffsm = null;
			try
			{
				fromUpffsm = (IPlatformTemplate.IUpffsmOffer)aContext.get( IUpdcConst.IUpdbm.IUpdbf.PROGRAM );
			}
			finally{
				
			}
			return fromUpffsm;
		}
		
		/**
		 * 
		 * @param fromUpfgsm
		 * @param fromUpfwm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpdcContext getPROGRAM(IPlatformTemplate.IUpffsmOffer fromUpfgsm, 
				IOVUpfgsmCatalog fromUpfwm, 
				IUpdcContext aContext) throws SFException, Exception{
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			try
			{
				fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.MAPPING, fromUpfwm.getMAPPINGS() );
				if( fromLDAP.containsKey( IUpdcConst.IUpdbm.IUpdbf.PROGRAM ) == false ){
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.PROGRAM , fromUpfgsm );
				}
			}
			finally{
				
			}
			return fromLDAP;
		}
		
		/**
		 * 查询当前堆栈中查询非空映射集
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffgsmOffer[] getICSTKUpffgsm() throws SFException,Exception{
			IPlatformTemplate.IUpffgsmOffer fromUpfgsm[] = null;
			try
			{
				fromUpfgsm = (IPlatformTemplate.IUpffgsmOffer[])UpfsvcManager.getRocket().getIUpfxChange(
						IPlatformTemplate.IUpffgsmOffer.class );
			}
			finally{
				
			}
			return fromUpfgsm;
		}
		
		/**
		 * 查询当前堆栈中查询映射集
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffgsmOffer[] getICSTKUpfgsmc() throws SFException,Exception{
			IPlatformTemplate.IUpffgsmOffer fromUpfgsm[] = null;
			try
			{
				fromUpfgsm = (IPlatformTemplate.IUpffgsmOffer[])UpfsvcManager.getRocket().getIUpfxEntry( 
						IPlatformTemplate.IUpffgsmOffer.class );
			}
			finally{
				
			}
			return fromUpfgsm;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月14日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfvm{
		public IUpfvm(){
			super();
		}
		/**
		 * 
		 * @param aJEVAL
		 * @return
		 */
		public static String[][] getISTKJexpL( String aJEVAL ){
			java.util.List fromJdom = new java.util.ArrayList();
			try
			{
				if( StringUtils.isBlank( aJEVAL ) == false ){
					String arguments[] = StringUtils.split( aJEVAL , ";" );
					for( int index = 0 ; arguments.length > 0 && index < arguments.length; index++ ){
						String aJEXP[] = StringUtils.wildcardTail( arguments[index] , "=" );
						if( aJEXP != null && aJEXP.length <= 1 ) aJEXP = new String[]{ IUpdcConst.IEnum.ISschk.NULL , aJEXP[0] };
						fromJdom.add( aJEXP );
					}
				}
			}
			finally{
				
			}
			return (String[][])fromJdom.toArray( new String[][]{} );
		}
		/**
		 * 
		 * @param aJEXP
		 * @param aOBJECT
		 * @param fromOffer
		 * @param fromUpfgsm
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void wrap( String aJEXP ,
				Object aOBJECT,
				java.util.Map fromOffer, 
				java.util.Map fromUpfgsm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				if( ClassUtils.IClass.isNULL( aJEXP ) == false ){
					IUpfvmX._jf_complex_primitive(aJEXP, 
							aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( ClassUtils.IClass.isMULTLE( aOBJECT ) ){
					IUpfvmX._jf_complex_multle(aJEXP, 
							(String)aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( ClassUtils.IClass.isList( aOBJECT ) ){
					IUpfvmX._jf_complex_list(aJEXP, 
							(java.util.List)aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( ClassUtils.IClass.isMap( aOBJECT ) ){
					IUpfvmX._jf_complex_map(aJEXP, 
							(java.util.Map)aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( ClassUtils.IClass.isSet( aOBJECT ) ){
					IUpfvmX._jf_complex_set(aJEXP, (java.util.Set)aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( ClassUtils.IClass.isArray2( aOBJECT ) ){
					IUpfvmX._jf_complex_array2(aJEXP, 
							(Object[][])aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( ClassUtils.IClass.isArray1( aOBJECT ) ){
					IUpfvmX._jf_complex_array1(aJEXP, 
							(Object[])aOBJECT, 
							fromOffer, 
							fromUpfgsm, 
							aContext);
				}
				else if( aOBJECT != null ){
					JdomUtils.ICustom.wrap( StringUtils.replace( (String)aOBJECT, "&", ";"), fromUpfgsm );
				}
			}
			finally{
				
			}
		}
		public static class IUpfvmX{
			public IUpfvmX(){
				super();
			}
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_primitive( String aMAPPING ,
					Object aPRIMITIVE, 
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					if( aPRIMITIVE instanceof java.lang.String && StringUtils.startWith( (String)aPRIMITIVE, "#[" ) )
						aPRIMITIVE = StringUtils.substringBetwn( (String)aPRIMITIVE , "#[" , "]" );
					if( aPRIMITIVE != null ) fromUpfgsm.put( aMAPPING , aPRIMITIVE );
				}
				finally{
					
				}
			}
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_multle(String aMAPPING ,
					String aPRIMITIVE, 
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					JdomUtils.ICustom.wrap( aPRIMITIVE, fromUpfgsm );
				}
				finally{
					
				}
			}
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_map( String aMAPPING ,
					java.util.Map aPRIMITIVE,
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					for( java.util.Iterator itera = aPRIMITIVE.entrySet().iterator(); itera.hasNext() ; ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						if( fromEntry.getValue() == null ) continue;
						IUpfvm.wrap( (String)fromEntry.getKey() , 
								fromEntry.getValue(), 
								fromOffer, 
								fromUpfgsm, 
								aContext);
					}
				}
				finally{
					
				}
			}
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_list( String aMAPPING ,
					java.util.List aPRIMITIVE,
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					for( java.util.Iterator itera = aPRIMITIVE.iterator(); itera.hasNext(); ){
						IUpfvm.wrap( IUpdcConst.IEnum.ISschk.NULL, 
								itera.next(), 
								fromOffer, 
								fromUpfgsm, 
								aContext);
					}
				}
				finally{
					
				}
			}
		
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_set( String aMAPPING ,
					java.util.Set aPRIMITIVE,
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					for( java.util.Iterator itera = aPRIMITIVE.iterator(); itera.hasNext(); ){
						Object fromOBJECT = itera.next();
						if( fromOBJECT == null ) continue;
						IUpfvm.wrap( IUpdcConst.IEnum.ISschk.NULL , 
								fromOBJECT, 
								fromOffer, 
								fromUpfgsm, 
								aContext);
					}
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_array2( String aMAPPING ,
					Object[][] aPRIMITIVE,
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					for( int index = 0 ; index < aPRIMITIVE.length; index++ ){
						IUpfvm.wrap( (String)aPRIMITIVE[index][0] , 
								aPRIMITIVE[index][1], 
								fromOffer, 
								fromUpfgsm, 
								aContext);
					}
				}
				finally{
					
				}
			}
			
			/**
			 * 
			 * @param aMAPPING
			 * @param aPRIMITIVE
			 * @param fromOffer
			 * @param fromUpfgsm
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			private static void _jf_complex_array1( String aMAPPING ,
					Object[] aPRIMITIVE,
					java.util.Map fromOffer,
					java.util.Map fromUpfgsm,
					IUpdcContext aContext ) throws SFException,Exception{
				try
				{
					for( int index = 0 ; index < aPRIMITIVE.length; index++ ){
						IUpfvm.wrap( IUpdcConst.IEnum.ISschk.NULL , 
								aPRIMITIVE[index], 
								fromOffer, 
								fromUpfgsm, 
								aContext);
					}
				}
				finally{
					
				}
			}
		}
		public static class IIfElse{
			public IIfElse(){
				super();
			}
			
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元属性映射模块</p>
	 * <p>Copyright: Copyright (c) 2013-3-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfsm{
		public IUpfsm(){
			super();
		}
		
		/**
		 * 是否满足系统表达式中包含$或#
		 * @param aJEXP
		 * @return
		 */
		public static boolean isVariable( String aJEXP ){
			return StringUtils.startWith( aJEXP , "$" ) || 
			         StringUtils.startWith( aJEXP , "#" ) ;
		}
		
		/**
		 * 判断是否映射集为普通元素
		 * @param fromUpfgsmc
		 * @param fromXPath
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isUpfgsm( IPlatformTemplate.IUpffgsmOffer fromUpfgsmc , 
				Object fromXPath ) throws SFException,Exception{
			boolean fromEnable = false;
			try {
				if (fromXPath != null && fromXPath instanceof java.util.Map) {
					fromEnable = StringUtils.isBlank(fromUpfgsmc.getCATEGORY())
							|| ClassUtils.IClass.isAssignable(fromUpfgsmc
									.getCATEGORY(), java.util.Map.class) == false;
				}
			} finally {

			}
			return fromEnable;
		}
		
		/**
		 * 表达式参数打包分析
		 * @param aJEXP
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String[] getISTKJexpL( String aJEXP ) throws SFException,Exception{
			java.util.List fromList = new java.util.ArrayList();
			try
			{
				String fromArray[] = new String[]{ aJEXP };
				if( StringUtils.equals( aJEXP , ",") == false ) fromArray = StringUtils.wildcardArray( aJEXP , "," );
				if( fromArray != null && fromArray.length > 0 ){
					for(int index = 0 ; index < fromArray.length ; index++){
						if( StringUtils.startWith( fromArray[index] , "[" ) ){
							fromArray[index] = StringUtils.substringBeforeLast(StringUtils.substringAfter( fromArray[index], "[" ), "]" );
						}
						if( fromList.size() > index + 1 ){ 
							fromList.set( index + 1 , IUpfsm.IIUpfsm._jf_specific( fromArray[index].trim() ) );
						}
						else{
							fromList.add( IUpfsm.IIUpfsm._jf_specific( fromArray[index].trim() ) );
						}
					}
				}
			}
			finally{
				
			}
			return (String[])fromList.toArray( new String[]{} );
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aCOMPLEX
		 * @param aMAPPINGS
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object[] _jj_jexp( Object fromUpfgsmc ,
				String aCOMPETE,
				String aCOMPLEX,
				java.util.Map aMAPPINGS, 
				IUpdcContext aContext) throws SFException, Exception{
			java.util.List fromList = new java.util.ArrayList();
			try
			{
				Object aJEXP[] = IUpfsm.getISTKJexpL( aCOMPLEX );
				ClassUtils.IMerge.merge( aJEXP, fromList);
				for(int index = 0 ; index < aJEXP.length ; index++){
					if( aJEXP[index] == null || aJEXP[index].toString().startsWith("$REF[")) continue;
					if( aJEXP[index].toString().startsWith("$")){
						Object aOBJECT = IUpfsm.IIUpfsm._jj_variable( fromUpfgsmc, 
                                aCOMPETE, 
                                aMAPPINGS, 
                                aJEXP[index].toString(), 
                                aContext);
						fromList.set( index, aOBJECT );
					}
					else if( aJEXP[index].toString().startsWith("#") ){
						Object aOBJECT = IUpfsm.IIUpfsm._jj_conston( fromUpfgsmc, 
								aCOMPETE, 
								aMAPPINGS, 
								aJEXP[index].toString(), 
								aContext);
						fromList.set( index, aOBJECT );
					}
					else if( StringUtils.contains( aJEXP[index].toString() , "=") ){
						Object aOBJECT = IUpfsm.IIUpfsm._jj_splite( fromUpfgsmc, 
								aCOMPETE, 
								aMAPPINGS, 
								aJEXP[index].toString(), 
								aContext);
						fromList.set( index, aOBJECT );
					}
				}
			}
			finally{
				
			}
			return (Object[])fromList.toArray( new Object[]{} );
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_direct(  Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				aOBJECT = IIUpfsm._jf_variable(aCOMPETE, aMAPPINGS, aContext);
				aOBJECT = aOBJECT != null ? aOBJECT
						: (aCOMPLEX != null ? (StringUtils.equals(aCOMPLEX,
								IUpdcConst.IEnum.ISschk.NULL) ? ""
								: aCOMPLEX) : null);
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_null(  Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				aOBJECT = IIUpfsm._jf_variable(aCOMPETE, aMAPPINGS, aContext);
				aOBJECT = aOBJECT == null?aCOMPLEX:(StringUtils.equals( 
						aOBJECT.toString(), IUpdcConst.IEnum.ISschk.NULL )?
						"":aOBJECT);
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_context( Object fromUpfgsmc ,
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
	    	Object _objective = null;
	    	try
	    	{
	    		String fromArray[] = IIUpfsm._jf_complex( aCOMPLEX );
	    		for( int index = 0; fromArray != null && index < fromArray.length; index++ ){
	    			if( StringUtils.isBlank( fromArray[index] ) ) continue;
	    			if( fromArray[index].startsWith( EvaluationConstants.OPEN_CONSTANT ) ){
	    				if( fromArray[index].endsWith( EvaluationConstants.CLOSED_CONSTANT ) == false ){
	    					throw new IllegalArgumentException("string constant <" + fromArray[index] + "> does not end with " + 
	    				             EvaluationConstants.CLOSED_CONSTANT + ".");
	    				}
	    				_objective = fromArray[index].substring( EvaluationConstants.OPEN_CONSTANT.length(), 
	    						fromArray[index].length() - EvaluationConstants.CLOSED_CONSTANT.length() );
	    			}
	    			else if( fromArray[index].startsWith( EvaluationConstants.OPEN_VARIABLE ) ){
	    				if( fromArray[index].endsWith( EvaluationConstants.CLOSED_VARIABLE ) == false ){
	    					throw new IllegalArgumentException("string constant <" + fromArray[index] + "> does not end with " + 
	    				             EvaluationConstants.CLOSED_VARIABLE + ".");
	    				}
	    				fromArray[index] = fromArray[index].substring( EvaluationConstants.OPEN_VARIABLE.length(), 
	    						fromArray[index].length() - EvaluationConstants.CLOSED_VARIABLE.length() );
	    				fromArray[index] = UpdcpUtils.ICustom.wrap( fromArray[index] );
	    				String aJEXP[] = ReflectUtils.ICustom.getXPath( fromArray[index] );
	    				if( aJEXP.length == 1 )
	    					_objective = IIUpfsm._jf_variable( aJEXP[0], aMAPPINGS, aContext);
	    				else
	    					_objective = IIUpfsm._jf_context( aJEXP, aMAPPINGS, aContext);
	    			}
	    			else{
	    				fromArray[index] = UpdcpUtils.ICustom.wrap( fromArray[index] );
	    				String aJEXP[] = ReflectUtils.ICustom.getXPath( fromArray[index] );
	    				if( aJEXP.length == 1 )
	    					_objective = IIUpfsm._jf_variable( aJEXP[0], aMAPPINGS, aContext);
	    				else
	    					_objective = IIUpfsm._jf_context( aJEXP, aMAPPINGS, aContext);
	    			}
	    			if( _objective != null ){ break; }
	    		}
	    	}
	    	finally{
	    		
	    	}
	    	return _objective;
	    }
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param fromCOMPETE
		 * @param aMAPPINGS
		 * @param fromCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_context( Object fromUpfgsmc ,
				String fromCOMPETE, 
				java.util.Map aMAPPINGS, 
				String fromCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				String aCOMPLEX[] = IUpfsm.getISTKJexpL( fromCOMPLEX );
				if( aCOMPLEX != null && aCOMPLEX.length > 0 && StringUtils.isBlank( aCOMPLEX[0] ) == false ){
					fromCOMPLEX = StringUtils.replace( aCOMPLEX[0], "&", ";" );
					aOBJECT = IUpfsm._jj_context(fromUpfgsmc, aMAPPINGS, fromCOMPLEX, aContext);
				}
				if( aOBJECT == null && aCOMPLEX.length > 1 && StringUtils.isBlank( 
						aCOMPLEX[1] ) == false ){
					aOBJECT = aCOMPLEX[1];
				}
				if( aOBJECT != null && StringUtils.startWith( aOBJECT.toString(), "$" ) ){
					aOBJECT = (String)IIUpfsm._jj_variable( fromUpfgsmc, fromCOMPETE, 
							aMAPPINGS, aOBJECT.toString(), aContext );
				}
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param fromCOMPETE
		 * @param fromCOMPLEX
		 * @param aMAPPINGS
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_phantom( Object fromUpfgsmc ,
				String fromCOMPETE, 
				String fromCOMPLEX, 
				java.util.Map aMAPPINGS, 
				IUpdcContext aContext) throws SFException,Exception{
			Object _objective = null;
			PhantomEvaluator _phantom = null;
			try
			{
				if( fromCOMPLEX != null ){
					_phantom = new PhantomEvaluator();
					_objective = _phantom.evaluate( fromCOMPLEX, 
							aMAPPINGS, 
							aContext );
				}
			}
			finally{
				if( _phantom != null ){ _phantom = null; }
			}
			return _objective;
		}
		
		/**
		 * 依赖变量规则
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_depend( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				String fromCOMPLEX[] = IUpfsm.getISTKJexpL( aCOMPLEX );
				Object fromDEPEND = IUpfsm._jj_context( fromUpfgsmc, aMAPPINGS, fromCOMPLEX[0], aContext );
				if( fromDEPEND != null && fromCOMPLEX != null && fromCOMPLEX.length > 1 ){
					aOBJECT = IUpfsm._jj_context(fromUpfgsmc, aMAPPINGS, fromCOMPLEX[1], aContext);
					if( aOBJECT == null && fromCOMPLEX.length > 2 && 
							StringUtils.isBlank( fromCOMPLEX[2] ) == false ){
						aOBJECT = fromCOMPLEX[2];
					}
				}
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 复合遍历合
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map _jj_complex( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			java.util.Map fromMap = new java.util.HashMap();
			try
			{
				String fromJEXP[] = IUpfsm.getISTKJexpL( aCOMPLEX );
				String aOBJECT = (String)_jj_context( fromUpfgsmc , aMAPPINGS, fromJEXP[0], aContext );
				if( StringUtils.isBlank( aOBJECT ) == false ){
					String fromArray[] = UpdcpUtils.ICustom.batchx( aOBJECT );
					for(int index = 0 ; fromArray != null && index < fromArray.length ; index++){
						String fromCol[] = StringUtils.wildcardArray( fromArray[index], "=");
						if( fromCol.length <= 1 ){ ExceptionFactory.throwJeval("IOS0011001", new String[]{ ClassUtils.getINDEX(
								new String[]{aCOMPETE,"," ,fromArray[index] })} );
						}
						if( fromJEXP.length <= 1 || StringUtils.isBlank( fromJEXP[1] ) ){
							fromMap.put( fromCol[0], fromCol[1] );
						}
						else{
							Object fromObject = _jj_splite(fromUpfgsmc, aCOMPETE, fromCol[1], 
									aMAPPINGS, fromJEXP[1], aContext);
							if( fromObject != null ) fromMap.put( fromCol[0], fromObject );
						}
					}
				}
			}
			finally{
				
			}
			return fromMap;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_sequence( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object fromDecimal = null;
			try
			{
				String aJEXP[] = IUpfsm.getISTKJexpL( aCOMPLEX );
				fromDecimal = UpdcFactory.getIUpdcDAO().getSEQUENCE( aJEXP[0] );
				if( aJEXP != null && aJEXP.length > 1 ) {
					fromDecimal = StringUtils.filling( fromDecimal.toString(), 
							Integer.parseInt( aJEXP[1] ), 
							StringUtils.RIGHT, 
							'0');
				}
			}
			finally{
				
			}
			return fromDecimal;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_sysdate( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				aOBJECT = IUpfsm._jj_context(fromUpfgsmc,  
						aMAPPINGS, 
						aCOMPETE, 
						aContext);
				aOBJECT = TimeUtils.getTime( aOBJECT );
				if( aOBJECT != null && StringUtils.isBlank( aCOMPLEX ) == false ){
					aOBJECT = TimeUtils.format( (java.util.Date)aOBJECT , aCOMPLEX );
				}
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 根据拆分表达式进行拆分,
		 * 格式为C=1;E=0;DU=1或C=$CFUNUM;E=0;DU=$CFUNUM
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param fromCOMPTEL
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_splite( Object fromUpfgsmc , 
				String aCOMPETE, 
				String fromCOMPTEL,
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				aOBJECT = IIUpfsm._jj_splite( fromCOMPTEL , aCOMPLEX );
				if( aOBJECT != null && aOBJECT.toString().length() > 0 && 
						aOBJECT.toString().startsWith( "$" )){
					aOBJECT = IIUpfsm._jj_variable( fromUpfgsmc, 
							aCOMPETE, 
							aMAPPINGS, 
							aOBJECT.toString(), 
							aContext);
				}
			}
			finally{
				
			}
			
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		public static String _jj_jeval( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws Exception{
			String fromUpffmx = null;
			try
			{
				fromUpffmx = IUpfsm._jj_velocity( aCOMPLEX , 
						aMAPPINGS, 
						aContext );
				fromUpffmx = UpdcpUtils.IUpfvn.evaluate( fromUpffmx, 
						aMAPPINGS,
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 基于JEVAL计算参数清单
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		public static String _jj_arguments( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws Exception{
			String fromUpffmx = null;
			try
			{
				fromUpffmx = UpdcpUtils.IUpfvn.arguments( aCOMPLEX , 
						aMAPPINGS ,
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 基于变量计算参数清单,返回值用逗号风格
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		public static Object[] _jf_arguments( Object fromUpfgsmc ,
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws Exception{
			Object fromUpffmx[] = null;
			try
			{
				String fromCOMPLEX[] = IUpfsm.getISTKJexpL( aCOMPLEX );
				if( fromCOMPLEX != null && fromCOMPLEX.length > 0 ){
					fromUpffmx = new Object[ fromCOMPLEX.length ];
					for( int index = 0; fromCOMPLEX != null && index < fromCOMPLEX.length; index++ ){
						fromUpffmx[index] = IUpfsm._jj_context(fromUpfgsmc, 
								aMAPPINGS, 
								fromCOMPLEX[index], 
								aContext);
					}
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aDEFAULT
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_splite( Object fromUpfgsmc , 
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX,
				String aDEFAULT,
				IUpdcContext aContext) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				aOBJECT = _jj_context( fromUpfgsmc , 
						aMAPPINGS , 
						aCOMPETE , 
						aContext );
				if( aOBJECT != null && StringUtils.isBlank( aCOMPLEX ) == false ){
					aOBJECT = IUpfsm._jj_splite(fromUpfgsmc, 
							aCOMPETE, 
							aOBJECT.toString() , 
							aMAPPINGS, 
							aCOMPLEX, 
							aContext);
				}
				if( aDEFAULT != null && aOBJECT == null ) aOBJECT = aDEFAULT;
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param fromUpfgsmc
		 * @param aCOMPETE
		 * @param aMAPPINGS
		 * @param aCOMPLEX
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _jj_velocity( Object fromUpfgsmc , 
				String aCOMPETE, 
				java.util.Map aMAPPINGS, 
				String aCOMPLEX , 
				IUpdcContext aContext) throws SFException,Exception{
			String aOBJECT = null;
			try
			{
				String aJEXP = aCOMPLEX;
				if( StringUtils.isBlank( aJEXP ) ) ExceptionFactory.throwJeval("IOS0011021", new String[]{aCOMPETE,"COMPLEX"} );
				java.util.Map fromUpfgsm = (java.util.Map)aContext.get(IUpdcConst.IUpdbm.IUpdbf.MAPPING);
				aOBJECT = IUpfvmsSTKLocal.getINSTANCE().evaluate(aCOMPETE, aJEXP, fromUpfgsm, aMAPPINGS, aContext);
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param aJEXP
		 * @param aMAPPINGS
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		public static String _jj_velocity( String aJEXP ,
				java.util.Map aMAPPINGS , 
				IUpdcContext aContext ) throws Exception{
			if( StringUtils.isBlank( aJEXP ) || StringUtils.contains( aJEXP , "$" ) == false ) return aJEXP;
			return IUpfvmsSTKLocal.getINSTANCE().evaluate("NULL", aJEXP, (java.util.Map)null, aMAPPINGS, aContext);
		}
		
		/**
         * 
         * @param fromUpfgsmc
         * @param fromOffer
         * @param aCOMPLEX
         * @param aContext
         * @return
         * @throws Exception
         */
		public static boolean _jj_IfElse( Object fromUpfgsmc,
				java.util.Map fromOffer,
				String aCOMPLEX,
				IUpdcContext aContext ) throws Exception{
			boolean aOBJECT = false;
			java.util.Map fromJEVAL = new java.util.HashMap();
			try
			{
				aOBJECT = UpdcpUtils.IUpfvn.decision( aCOMPLEX, 
						fromOffer, 
						aContext );
			}
			finally{
				if( fromJEVAL != null ){ fromJEVAL.clear() ; fromJEVAL = null;}
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * @param aCOMPLEX
		 * @param aMAPPINGS
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		public static boolean _jj_exist( String aCOMPLEX,
				java.util.Map fromOffer,
				IUpdcContext aContext ) throws Exception{
			boolean aOBJECT = false;
			try
			{
				Object fromJEVAL = IUpfsm._jj_context( aCOMPLEX, 
						fromOffer, 
						aCOMPLEX, 
						aContext );
				aOBJECT = fromJEVAL != null?true:false;
			}
			finally{
				
			}
			return aOBJECT;
		}
		
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-3-12</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public static class IIUpfsm{
			public IIUpfsm(){
				super();
			}
			
			/**
			 * 
			 * @param fromUpfgsmc
			 * @param aMAPPINGS
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static java.util.List _jf_bottom(Object fromUpfgsmc ,
					java.util.Map aMAPPINGS , 
				    IUpdcContext aContext ) throws SFException,Exception{
				java.util.List fromList = new java.util.ArrayList() ;
				try
				{
					java.util.Map fromMap = null;
					ClassUtils.IMerge.merge( new Object[]{aContext , aMAPPINGS}, fromList );
					if( ( fromMap = aContext.getMap( IUpdcConst.IUpdbm.IUpdbf.MAPPING ) ) != null ) fromList.add( fromMap );
					fromMap = UpfsvcManager.getBlankSession() != null?UpfsvcManager.getSession().getComposite():null;
					if( fromMap != null ) fromList.add( fromMap );
					fromList.add( IConfigDefine.getINSTANCE().getConfigItem().getGRAPHICS() );
				}
				finally{
					
				}
				return fromList;
			}
			
			/**
			 * 按照分号拆分表达式
			 * @param aJEXP
			 * @return
			 */
			private static String[] _jf_complex( String aJEXP ){
				return StringUtils.wildcardArray( aJEXP , ";" );
			}
			
			/**
			 * 特殊字符替换
			 * @param aJEXP
			 * @return
			 */
			private static String _jf_specific( String aJEXP ){
				try
				{
					String aSPECIFIC[][] = new String[][]{{"@",","}};
					for(int index = 0 ; index < aSPECIFIC.length ; index++){
						if( StringUtils.contains( aJEXP , aSPECIFIC[index][0] ) ){
							aJEXP = StringUtils.replace( aJEXP , 
									aSPECIFIC[index][0], 
									aSPECIFIC[index][1] );
						}
					}
				}
				finally{
					
				}
				return aJEXP;
			}
			
			/**
			 * 变量模式[$变量模式,$[变量模式],${待定},$(待定)]
			 * @param fromUpfgsmc
			 * @param aCOMPETE
			 * @param aMAPPINGS
			 * @param aCOMPLEX
			 * @param aContext
			 * @return
			 * @throws Exception
			 */
			public static Object _jj_variable(Object fromUpfgsmc ,
					String aCOMPETE, 
					java.util.Map aMAPPINGS, 
					String aCOMPLEX , 
					IUpdcContext aContext) throws Exception{
				Object aOBJECT = aCOMPLEX;
				try
				{
					String JEXP[][] = new String[][]{{"$[","]","I"},{"${","}","J"},{"$(",")","R",},{"$","","I"}};
					for(int index = 0 ; index < JEXP.length ; index++){
						if( aCOMPLEX.startsWith( JEXP[index][0] ) ){
							if( StringUtils.isBlank( JEXP[index][2] ) ) return aOBJECT;
		                    else if( JEXP[index][2].equalsIgnoreCase("R"))
		                    	return StringUtils.substringBeforeLast(StringUtils.substringAfter( aCOMPLEX, 
		                    			JEXP[index][0]), JEXP[index][1]);
		                    else if( JEXP[index][2].equalsIgnoreCase("I") ){
								if( StringUtils.isBlank( JEXP[index][1] ) ) aOBJECT = aCOMPLEX.substring( JEXP[index][2].length() );
								else  aOBJECT = StringUtils.substringBeforeLast(StringUtils.substringAfter( aCOMPLEX, 
										JEXP[index][0]), JEXP[index][1]);
								return IUpfsm._jj_context( fromUpfgsmc, aMAPPINGS, aOBJECT.toString() , aContext);
							}
		                    else if( JEXP[index][2].equalsIgnoreCase("J") ){
		                    	aOBJECT = StringUtils.substringBeforeLast(StringUtils.substringAfter( aCOMPLEX, 
		                    			JEXP[index][0]), JEXP[index][1]);
		                    	String fromObject[] = StringUtils.wildcardArray( aOBJECT.toString() , "," );
		                    	aOBJECT = IUpfsm._jj_context( fromUpfgsmc, aMAPPINGS, fromObject[0] , aContext);
		                    	return aOBJECT == null && fromObject.length > 1? fromObject[1]:aOBJECT;
		                    }
						}
					}
				}
				finally{
					
				}
				return aOBJECT;
			}
			
			/**
			 * 常量模式[#{计算模式},#{{计算模式}},#(待定),#[常量]]
			 * @param aMAPPING
			 * @param aNAME
			 * @param aMAPPINGS
			 * @param aCOMPLEX
			 * @param aContext
			 * @return
			 * @throws Exception
			 */
			public static Object _jj_conston(Object aMAPPING ,
					String aNAME, 
					java.util.Map aMAPPINGS, 
					String aCOMPLEX , 
					IUpdcContext aContext) throws Exception{
				Object aOBJECT = aCOMPLEX;
				String aJEXP[][] = new String[][]{{"#{{","}}","RJ","@",","},{"#{","}","J"},{"#[","]","R",}};
				for(int index = 0 ; index < aJEXP.length ; index++){
					if( aCOMPLEX.startsWith( aJEXP[index][0] ) ){
						if( StringUtils.isBlank( aJEXP[index][2] ) ) return aOBJECT;
	                    else if( aJEXP[index][2].equalsIgnoreCase("R"))
	                    	return StringUtils.substringBeforeLast(StringUtils.substringAfter( aCOMPLEX,aJEXP[index][0]), aJEXP[index][1]);
	                    else if( aJEXP[index][2].equalsIgnoreCase("RJ")){
	                    	aOBJECT = StringUtils.substringBeforeLast(StringUtils.substringAfter( aCOMPLEX.toString(), 
	                    			aJEXP[index][0]), aJEXP[index][1]);
	                    	if( aJEXP[index].length >= 5 && StringUtils.contains( aOBJECT.toString() , aJEXP[index][3] ) )
	                    		aOBJECT = StringUtils.replace( aOBJECT.toString() , aJEXP[index][3] , aJEXP[index][4] );
	                    	return aOBJECT;
	                    }
	                    else if( aJEXP[index][2].equalsIgnoreCase("J") ){
	                    	aOBJECT = StringUtils.substringBeforeLast(StringUtils.substringAfter( aCOMPLEX, aJEXP[index][0]), aJEXP[index][1]);
							return  IUpfsm._jj_jeval(aMAPPING , aNAME , aMAPPINGS , aOBJECT.toString() , aContext );
						}
					}
				}
				return aOBJECT;
			}

	        /**
	         * 拆分模式
	         * @param aMAPPING
	         * @param aNAME
	         * @param aMAPPINGS
	         * @param aIMethodSKEL
	         * @param aContext
	         * @return
	         * @throws Exception
	         */
			public static Object _jj_splite(Object aMAPPING ,
					String aNAME, 
					java.util.Map aMAPPINGS, 
					String aCOMPLEX , 
					IUpdcContext aContext) throws Exception{
				Object aOBJECT = IUpfsm._jj_splite(aMAPPING, 
						aNAME, 
						aMAPPINGS, 
						aCOMPLEX,
						null,
						aContext);
				if( aOBJECT != null && aOBJECT.toString().startsWith( "$" ) ){
					aOBJECT = IUpfsm.IIUpfsm._jj_variable( aMAPPING, 
							aNAME, 
							aMAPPINGS, 
							aOBJECT.toString(), 
							aContext);
				}
				return aOBJECT;
			}
			
			/**
			 * 
			 * @param aOBJECT
			 * @param aCOMPLEX
			 * @return
			 */
			public static Object _jj_splite( String aOBJECT, String aCOMPLEX ){
				String fromAsL = null;
				try
				{
					String fromSplite[][] = StringUtils.wildcardSplite( aCOMPLEX, ";" );
					if( fromSplite != null && fromSplite.length > 0 ){
						for( int index = 0 ; fromSplite != null && index < fromSplite.length ; index++ ){
							if( StringUtils.equals( fromSplite[index][0], aOBJECT ) ){
								fromAsL = fromSplite[index][1];
								break;
			  			    }
							else if( StringUtils.equals( fromSplite[index][0], "*" ) ){
								fromAsL = fromSplite[index][1];
								break;
							}
							else if( StringUtils.wildcardMatch( aOBJECT, fromSplite[index][0] ) ){
								fromAsL = fromSplite[index][1];
								break;
							}
			  		    }
					}
				}
				finally{
					
				}
				return fromAsL;
			}
			
			/**
			 * 查询流程变量值
			 * @param aJEXP
			 * @param aMAPPINGS
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static Object _jf_variable(String aJEXP ,
					java.util.Map aMAPPINGS , 
				    IUpdcContext aContext ) throws SFException,Exception{
				Object aOBJECT = null;
				java.util.List fromList = null;
				try
				{
					if( StringUtils.contains( aJEXP , "." ) ) aJEXP = StringUtils.split( aJEXP , "." )[0];
					fromList = IIUpfsm._jf_bottom( aJEXP, aMAPPINGS, aContext );
					for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
						java.util.Map fromMap = (java.util.Map)itera.next();
						if( (aOBJECT = fromMap.get( aJEXP ) ) != null ){ break; }
					}
				}
				finally{
					if( fromList != null ){ fromList.clear(); fromList = null; }
				}
		    	return aOBJECT;
			}
			
	        /**
	         * 查询上下文最近[aIExprL.length - 1]数据
	         * @param aJEXP
	         * @param aMAPPINGS
	         * @param aContext
	         * @return
	         * @throws Exception
	         */
			public static Object _jf_context( String aJEXP[] , 
					java.util.Map aMAPPINGS , 
					IUpdcContext aContext ) throws Exception{
				Object aOBJECT = null;
				java.util.List fromList = null;
				try
				{
					java.util.Map fromObject = aContext;
					fromList = IIUpfsm._jf_bottom( aJEXP[0], aMAPPINGS, aContext );
					for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
						java.util.Map fromMap = (java.util.Map)itera.next();
						if( fromMap.containsKey( aJEXP[0] ) ){
							fromObject = fromMap;
							break;
						}
					}
					aOBJECT = ReflectUtils.xPath(aJEXP, fromObject);
				}
				finally{
					if( fromList != null ){ fromList.clear(); fromList = null; }
				}
				return aOBJECT;
			}
		}
	}
}
