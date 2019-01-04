package com.ai.sacenter.util;

import com.ai.sacenter.module.IConfigDefine;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-5-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class JdomUtils {

	public JdomUtils() {
		super();
	}
	
	/**
	 * 
	 * @param aControl
	 * @param fromJdom
	 */
	public static void _getISTKJdomL( String aControl , 
			java.util.Map fromJdom ){
		try
		{
			if( StringUtils.isBlank( aControl ) ) return;
			org.dom4j.Element aElement = null;
			if( StringUtils.startWith( aControl, "$REF[" ) ) 
				aElement = XmlUtils.parseFileXml( StringUtils.substringBetwn( aControl, "$REF[", "]" ) );
			else if( StringUtils.endsIgnoreCaseWith( aControl, ".xml") )
				aElement = XmlUtils.parseFileXml( aControl );
			else
				aElement = XmlUtils.parseXml( aControl );
			if( aElement.elements( "item" ).size() > 0 ) 
				IJdom.getIJDX$ItemL( aElement , fromJdom );
			else if( aElement.elements( "stub" ).size() > 0 ) 
				IJdom.getIJDX$Stub( aElement , fromJdom );
			else 
				XmlUtils.XPath( aElement.asXML() , fromJdom );
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param aJEXP
	 * @param fromOffer
	 * @param fromUpfwm
	 * @throws Exception
	 */
	public static void evaluate( String aJEXP, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfwm) throws Exception{
		java.util.Map fromUpfgsm = new java.util.HashMap();
		try
		{
			if( StringUtils.isBlank( aJEXP ) == false ){
				JdomUtils.ICustom.wrap( aJEXP , fromUpfgsm );
				for( java.util.Iterator itera = fromUpfgsm.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					if( StringUtils.isBlank( aEntry.getValue().toString() ) ) continue;
					String aColumn[] = new String[]{StringUtils.trim( (String)aEntry.getKey() ), 
							StringUtils.trim( (String)aEntry.getValue() ) };
					if( StringUtils.contains( aColumn[1] , "NULL" ) ){
						aColumn[1] = StringUtils.replace( aColumn[1] , "NULL", "" );
					}
					if( StringUtils.startWith(aColumn[0],"^") )
						fromUpfwm.put( StringUtils.substring(aColumn[0] , 1 ), aColumn[1] );
					else if( StringUtils.startWith( aColumn[1], "^" ) )
						fromUpfwm.put( aColumn[0], StringUtils.substring(aColumn[1] , 1 ) );				
					else if( fromUpfwm.containsKey( aColumn[0] ) == false ) 
						fromUpfwm.put( aColumn[0], aColumn[1] );				
				}
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-5-10</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 把属性集按照样例为A1=A1;B1=B1;A2=A2格式转换
		 * @param fromOffer 激活能力集
		 * @param fromSymbol 分割符
		 * @return
		 */
		public static String wrap( java.util.Map fromOffer , String fromSymbol ){
			StringBuilder aOBJECT = new StringBuilder();
			try
			{
				if( StringUtils.isBlank( fromSymbol ) ) fromSymbol = ";";
				for( java.util.Iterator itera = fromOffer.entrySet().iterator(); itera.hasNext() ; ){
					java.util.Map.Entry e = (java.util.Map.Entry)itera.next();
					aOBJECT.append( e.getKey().toString() ).append( "=" )
					       .append( e.getValue() != null ?e.getValue().toString():"");
					if( itera.hasNext() ) aOBJECT.append( fromSymbol );
				}
			}
			finally{
				
			}
			return aOBJECT.toString();
		}
		/**
		 * 把属性字符串(格式为A1=A1;A2=A2等)转换激活能力集
		 * @param fromJEXP 属性字符串(格式为A1=A1;A2=A2等)
		 * @param fromSymbol 分割字符串
		 * @return
		 */
		public static java.util.Map wrap( String fromJEXP , String fromSymbol ){
			java.util.Map fromUpfwm = new java.util.HashMap();
			try
			{
				if( StringUtils.isBlank( fromSymbol ) ) fromSymbol = ";";
				String aCOMPLEX[] = StringUtils.wildcardArray( fromJEXP , fromSymbol );
				for(int index = 0 ; StringUtils.isBlank( fromJEXP ) == false && 
						index < aCOMPLEX.length ; index++){
					String aColumn[] = StringUtils.wildcardTail( aCOMPLEX[index] , "=" );
					fromUpfwm.put( aColumn[0], aColumn != null && aColumn.length > 1 ?aColumn[1]:"");
				}
			}
			finally{
				
			}
			return fromUpfwm;
		}
		/***
		 * 拆分字符串 A=A1;A1=A2;A2=AA
		 * @param fromJEXP
		 * @param fromOffer
		 * @return
		 */
		public static java.util.Map wrap( String fromJEXP , java.util.Map fromOffer ){
			try
			{
				if( fromOffer == null ) fromOffer = new java.util.HashMap();
				if( StringUtils.isBlank( fromJEXP ) == false ){
					String aCOMPLEX[] = StringUtils.split( fromJEXP , ";" );
					for( int index = 0 ; aCOMPLEX != null && index < aCOMPLEX.length; index++ ){
						String aColumn[] = StringUtils.wildcardTail( aCOMPLEX[index] , "=" );
						if( StringUtils.isBlank( aColumn[0] ) ) continue;
						fromOffer.put( aColumn[0] , aColumn.length > 1?aColumn[1]:"" );
					}
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * 
		 * @param fromDefault
		 * @param args
		 * @return
		 */
		public static String _wrapAsMessage( String fromDefault, Object[] args ){
			try
			{
				for( int index = 0; args != null && index < args.length; index++ ){
					if( args[index] == null || ClassUtils.IClass.isPrimitive( args[index] )  ){
						String fromINDEX = ClassUtils.getINDEX( new String[]{ "{", String.valueOf( index ), "}" } );
						if( StringUtils.contains( fromDefault, fromINDEX ) == false ) continue;
						fromDefault = StringUtils.replace( fromDefault, fromINDEX , args[index] ==null?"<null>":args[index].toString() );
					}
					else if( StringUtils.contains( fromDefault, "$" ) && args[index] instanceof java.util.Map ){
						for( java.util.Iterator itera = ((java.util.Map)args[index]).entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							String fromINDEX = ClassUtils.getINDEX( new String[]{ "{$", fromEntry.getKey().toString(), "}" } );
							fromDefault = StringUtils.replace( fromDefault, fromINDEX , fromEntry.getValue() == null?
									"<null>":fromEntry.getValue().toString() );
						}
					}
					else if( StringUtils.contains( fromDefault, "$" ) ){
						IBeanWrapper fromMBean = new IBeanWrapper( args[index] );
						java.beans.PropertyDescriptor aDescriptors[] = fromMBean.getPropertyDescriptors();
						for( int itera = 0; aDescriptors != null && itera < aDescriptors.length; itera++ ){
							String fromINDEX = ClassUtils.getINDEX( new String[]{ "{$", aDescriptors[itera].getName(), "}" } );
							try
							{
								Object fromOBJECT = fromMBean.getPropertyValue( aDescriptors[itera].getName() );
								fromDefault = StringUtils.replace( fromDefault, fromINDEX, fromOBJECT == null?
										"<null>":fromOBJECT.toString() );
							}
							catch( java.lang.Exception exception){
								fromDefault = StringUtils.replace( fromDefault, fromINDEX, "<*>" );
							}
						}
					}
				}
			}
			finally{
				
			}
			return fromDefault;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-24</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IJdom{
		public IJdom(){
			super();
		}
		/**
         * 
         * @param aElement
         * @param aUcm2Jdom
         */
		public static void getIJDX$ItemL( org.dom4j.Element aElement , 
				java.util.Map aUcm2Jdom ){
			try
			{
				if( aElement == null ) return;
				for(java.util.Iterator itera = aElement.elements("item").iterator() ; itera.hasNext() ; ){
					org.dom4j.Element temp = (org.dom4j.Element)itera.next();
					IJdom._getIJDX$Item( temp , aUcm2Jdom );
				}
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param aElement
		 * @param aUcm2Jdom
		 */
		private static void _getIJDX$Item(  org.dom4j.Element aElement , 
				java.util.Map aUcm2Jdom ){
			try
			{
				String aUSE = aElement.attributeValue("use", "true");
				if( aUSE.equalsIgnoreCase( "TRUE" ) == false ) return;
	            String aNAME = aElement.attributeValue("name");
	            String aVALUE = aElement.attributeValue("value");
	            if( aElement.elements("item").size() == 0 )
                	aUcm2Jdom.put( aNAME , aVALUE );
                else if( StringUtils.isBlank( aVALUE ) == false )
                	aUcm2Jdom.put( aNAME , _getIJDX$Item( aElement ) );
	            else{
	            	aUcm2Jdom.put( aNAME , new java.util.HashMap() );
	            	getIJDX$ItemL( aElement , (java.util.Map)aUcm2Jdom.get( aNAME ));
                }
			}
			finally{
				
			}
		}
        /**
         * 
         * @param aElement
         * @return
         */
		private static java.util.List _getIJDX$Item( org.dom4j.Element aElement  ){
			java.util.List aUcm2Jdom = new java.util.ArrayList();
			try
			{
				for(java.util.Iterator itera = aElement.elements("item").iterator() ; itera.hasNext() ; ){
					org.dom4j.Element temp = (org.dom4j.Element)itera.next();
					String aUSE = temp.attributeValue("use", "true");
		            if( aUSE.equalsIgnoreCase("true") == false ) continue;
		            IPeriodGraphics aReference = new IPeriodGraphics();
		            aReference.setId( temp.attributeValue("value") );
		            aReference.setName( temp.attributeValue("name") );
		            aReference.setType( temp.attributeValue("name") );
		            IJdom._getIJDX$Item( temp , aReference.getGraphics() );
		            aUcm2Jdom.add( aReference );
				}
			}
			finally{
				
			}
			return aUcm2Jdom;
		}
		/**
		 * 
		 * @param aElement
		 * @param aUcm2Jdom
		 */
		public static void getIJDX$StubL( org.dom4j.Element aElement , 
				java.util.Map aUcm2Jdom ){
			try
			{
				if( aElement == null ) return;
				for(java.util.Iterator itera = aElement.elements("stub").iterator(); itera.hasNext(); ){
					org.dom4j.Element temp = (org.dom4j.Element)itera.next();
					IJdom.getIJDX$Stub( temp , aUcm2Jdom );
				}
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param aElement
		 * @param aUcm2Jdom
		 */
		private static void getIJDX$Stub( org.dom4j.Element aElement , 
				java.util.Map aUcm2Jdom ){
			try
			{
				String aUSE = aElement.attributeValue("use", "true");
				if( aUSE.equalsIgnoreCase("true") == false ) return;
				String aNAME = aElement.attributeValue("name");
				String aVALUE = aElement.attributeValue("value");
				if( aElement.elements("stub").size() == 0 )
					aUcm2Jdom.put( aNAME , aVALUE );
	            else if( StringUtils.isBlank( aVALUE ) == false )
	            	aUcm2Jdom.put( aNAME , _getIJDX$StubL( aElement ) );
	            else{
	            	aUcm2Jdom.put( aNAME , new java.util.HashMap() );
	            	getIJDX$StubL( aElement , (java.util.Map)aUcm2Jdom.get( aNAME ));
                }
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param aElement
		 * @return
		 */
		private static java.util.List _getIJDX$StubL( org.dom4j.Element aElement ){
			java.util.List aUcm2Jdom = new java.util.ArrayList();
			try
			{
				for(java.util.Iterator itera = aElement.elements("stub").iterator() ; itera.hasNext() ; ){
					org.dom4j.Element temp = (org.dom4j.Element)itera.next();
					String aUSE = temp.attributeValue("use", "true");
		            if( aUSE.equalsIgnoreCase("true") == false ) continue;
		            IPeriodGraphics aReference = new IPeriodGraphics();
		            aReference.setId( temp.attributeValue("value") );
		            aReference.setName( temp.attributeValue("name") );
		            aReference.setType( temp.attributeValue("name") );
		            IJdom.getIJDX$Stub( temp , aReference.getGraphics() );
		            aUcm2Jdom.add( aReference );
				}
			}
			finally{
				
			}
			return aUcm2Jdom;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年5月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IConfigure{
		public IConfigure(){
			super();
		}
		
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		public static String getIConfigRoot() throws Exception{
			String aConfigXml = "com/ai/sacenter/AIUpdcRoot.xml";
			if( ClassUtils.IClass.isExistFile( aConfigXml ) == false ) aConfigXml = "AIUpdcRoot.xml";
			if( System.getProperties().containsKey("pdcframe.configure") ) aConfigXml = System.getProperty( "pdcframe.configure" );
			return aConfigXml;
		}
		
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		public static String getIConfigCache() throws Exception{
			String configure = "com/ai/sacenter/AIUpdcCache.xml";
			if( ClassUtils.IClass.isExistFile( configure ) == false ) configure = "AIUpdcCache.xml";
			if( System.getProperties().containsKey("pdcframe.configure.cache") ) configure = System.getProperty( "pdcframe.configure.cache" );
			return ClassUtils.IClass.isExistFile( configure )?configure:null;
		}

		/**
		 *
		 * @return
		 * @throws Exception
		 */
		public static String getOthersConfig() throws Exception{
			String configure = "com/ai/sacenter/others.xml";
			if( ClassUtils.IClass.isExistFile( configure ) == false ) configure = "others.xml";
			return ClassUtils.IClass.isExistFile( configure )?configure:null;
		}
		
		/**
		 * 
		 * @param fromNode
		 * @return
		 */
		public static org.dom4j.Element getConfigItem( String fromNode ){
			org.dom4j.Element aConfigure = null;
			StringBuilder fromNodeName = new StringBuilder();
			try
			{
				org.dom4j.Element aConfigItem = IConfigDefine.getINSTANCE().getConfigItem().getConfigure();
				fromNodeName.append("item[@name='").append( fromNode ).append("']");
				aConfigure = (org.dom4j.Element)aConfigItem.selectSingleNode( fromNodeName.toString() );
			}
			finally{
				
			}
			return aConfigure;
		}
		/**
		 * 
		 * @param fromRoot
		 * @param fromNode
		 * @param fromDefault
		 * @return
		 */
		public static String getAsString( org.dom4j.Element fromRoot, String fromNode, String fromDefault ){
			String fromText = fromDefault;
			StringBuilder fromNodeName = new StringBuilder();
			try
			{
				if( fromRoot != null ){
					fromNodeName.append("item[@name='").append( fromNode ).append("']");
					org.dom4j.Element fromElement = (org.dom4j.Element)fromRoot.selectSingleNode( fromNodeName.toString() ) ;
					if( fromElement != null ) fromText = fromElement.getTextTrim();
				}
			}
			finally{
				if( fromNodeName != null ){ fromNodeName = null; }
			}
			return fromText;
		}
		
		/**
		 * 
		 * @param fromRoot
		 * @param fromNode
		 * @param fromDefault
		 * @return
		 */
		public static boolean getAsBoolean( org.dom4j.Element fromRoot, String fromNode, boolean fromDefault ){
			boolean fromBoolean = fromDefault;
			try
			{
				String fromText = IConfigure.getAsString(fromRoot, fromNode, null);
				if( fromText != null ){
					fromBoolean = StringUtils.isBlank( fromText ) == false && 
							StringUtils.equalsIgnoreCase( fromText, "TRUE" )?true:false;
				}
			}
			finally{
				
			}
			return fromBoolean;
		}
		
		/**
		 * 
		 * @param fromRoot
		 * @param fromNode
		 * @param fromDefault
		 * @return
		 */
		public static long getAsLong( org.dom4j.Element fromRoot, String fromNode, long fromDefault ){
			long fromLong = fromDefault;
			try
			{
				String fromText = IConfigure.getAsString(fromRoot, fromNode, null);
				if( StringUtils.isBlank( fromText ) == false ){
					fromLong = Long.parseLong( fromText );
				}
			}
			finally{
				
			}
			return fromLong;
		}
		
		/**
		 * 
		 * @param fromDefault
		 * @param fromNode
		 * @param fromDefault
		 * @return
		 */
		public static java.util.Locale getAsLocal( org.dom4j.Element fromRoot, 
				String fromNode, 
				String fromDefault ){
			java.util.Locale fromLocal = java.util.Locale.CHINESE;
			try
			{
				String fromText = IConfigure.getAsString(fromRoot, fromNode, fromDefault);
				if( StringUtils.isBlank( fromText ) == false ){
					String lang[] = StringUtils.split( fromText, "_" );
					fromLocal = new java.util.Locale( lang[0], lang.length > 1 && 
							StringUtils.isBlank( lang[1] ) == false?lang[1]:"" );
				}
			}
			finally{
				
			}
			return fromLocal;
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
	}
}
