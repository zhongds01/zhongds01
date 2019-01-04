package com.ai.sacenter.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 标准XML解析</p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */

public class XmlUtils {
	public XmlUtils() {
		super();
	}
	
	/***
	 * 通过XML文件分析XML内容
	 * @param fromFile 文件名
	 * @return
	 */
	public static org.dom4j.Element parseFileXml( String fromFile ){ 
		org.dom4j.Element fromRoot = null;
		try
		{
			java.io.InputStream aInputStream = ClassUtils.IClass.getClassLoaderResource( fromFile );
            if( aInputStream == null ) throw new RuntimeException("not in the class path");
            org.dom4j.io.SAXReader saxReader = new org.dom4j.io.SAXReader(); 
			org.dom4j.Document document = saxReader.read( aInputStream );
			fromRoot = document.getRootElement();	
		}
		catch( java.lang.Exception exception){
			ExceptionFactory.throwRuntime("IOS0011000", new String[] { fromFile,
					exception.getMessage() }, exception);
		}
		return fromRoot;
	}
	
	/**
	 * 
	 * @param aReader
	 * @return
	 */
	public static org.dom4j.Element parseXml( java.io.Reader aReader ) {
		org.dom4j.Element fromRoot = null;
		try
		{
			org.dom4j.io.SAXReader saxReader = new org.dom4j.io.SAXReader(); 
			org.dom4j.Document document = saxReader.read( aReader );
			fromRoot = document.getRootElement();	
		}
		catch( java.lang.Exception exception){
			ExceptionFactory.throwRuntime("IOS0011000", new String[] { "*",
					exception.getMessage() }, exception);
		}
		return fromRoot;
	}
	
	/**
	 * 
	 * @param aInputStream
	 * @return
	 */
	public static org.dom4j.Element parseXml( java.io.InputStream aInputStream ){
		org.dom4j.Element fromRoot = null;
		try
		{
			org.dom4j.io.SAXReader saxReader = new org.dom4j.io.SAXReader(); 
			org.dom4j.Document document = saxReader.read( aInputStream );
			fromRoot = document.getRootElement();	
		}
		catch( java.lang.Exception exception){
			ExceptionFactory.throwRuntime("IOS0011000", new String[] { "*",
					exception.getMessage() }, exception);
		}
		return fromRoot;
	}
	
    /**
     * 根据XML内容分析解析XML
     * @param fromXML XML内容
     * @return
     */
	public static org.dom4j.Element parseXml( String fromXML ){
		org.dom4j.Element fromRoot = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.parseText(fromXML);
			fromRoot = document.getRootElement();
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwRuntime("IOS0011000", new String[] { "*",
					exception.getMessage() }, exception);
		}
		return fromRoot;
	}
	
	/**
	 * 把XML文档输出到指定文件中
	 * @param fromFILE 文件名
	 * @param fromDocument XML文档
	 * @param fromEncoding 字符集
	 * @throws Exception
	 */
	public static void outputFile( String fromFILE , 
			org.dom4j.Document fromDocument , 
			String fromEncoding ) throws Exception{
		org.dom4j.io.XMLWriter xmlWriter = null;
		try
		{
			org.dom4j.io.OutputFormat format = org.dom4j.io.OutputFormat.createPrettyPrint();
			format.setEncoding( fromEncoding != null ?fromEncoding:"utf-8");
			xmlWriter = new org.dom4j.io.XMLWriter(new java.io.FileWriter(fromFILE), format);
			xmlWriter.write(fromDocument);
		}
		finally{
			if( xmlWriter != null ){ xmlWriter.close(); xmlWriter = null;}
		}
	}
	
	/**
	 * 根据JAVABEAN转换为XML
	 * @param _root
	 * @param _encoding 
	 * @param _objective
	 * @return
	 */
	public static String createBeanXml( String _root, String _encoding, Object _objective ){
		String fromXML = null;
		try
		{
			IBeanWrapper fromBeanWrapper = new IBeanWrapper( _objective  );
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( _root );
			java.beans.PropertyDescriptor aDescriptors[] = fromBeanWrapper.getPropertyDescriptors();
			for(int index = 0 ; aDescriptors != null && index < aDescriptors.length ; index++){
				_objective = fromBeanWrapper.getPropertyValue( aDescriptors[index].getName() );
				if( _objective == null ) continue;
				IXml._createIXml( fromRoot, aDescriptors[index].getName(), _objective );
			}
			fromXML = IXml._format( document, _encoding );
		}
		catch( java.lang.Exception exception ){
			throw new java.lang.RuntimeException(exception.getMessage(),
					exception);
		}
		return fromXML;
	}
	
	/**
	 * 创建普通XML
	 * @param _root XML根目录
	 * @param _param XML属性
	 * @return
	 */
	public static String createGeneralXml( String _root, java.util.Map _param ){
		return XmlUtils.createGeneralXml(_root, null, _param);
	}
	
	/**
	 * 创建普通格式化XML
	 * @param _root XML根目录
	 * @param _encoding 字符集
	 * @param _param XML属性
	 * @return
	 */
	public static String createGeneralXml( String _root, String _encoding, java.util.Map _param ){
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( _root );
			if( _param != null ){
				for( java.util.Iterator itera = _param.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry e = (java.util.Map.Entry)itera.next();
					IXml._createIXml( fromRoot, e.getKey(), e.getValue() );
				}
			}
			fromXML = IXml._format( document, _encoding );
		}
		catch( java.lang.Exception exception ){
			throw new java.lang.RuntimeException(exception.getMessage(),
					exception);
		}
		return fromXML;
	}
	
	/**
	 * 创建普通非格式化XML
	 * @param _root XML根目录
	 * @param _param XML属性
	 * @return
	 */
	public static String createNoformatXml( String _root, java.util.Map _param ){
		org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
		try
		{
			org.dom4j.Element fromRoot = document.addElement( _root );
			if( _param != null ){
				for( java.util.Iterator itera = _param.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					IXml._createIXml( fromRoot, fromEntry.getKey(), fromEntry.getValue() );
				}
			}
		}
		catch( java.lang.Exception exception){
			throw new java.lang.RuntimeException( exception.getMessage(), exception );
		}
		return document.asXML();
	}
	
    /**
     * 创建普通格式化XML
     * @param _root
     * @param _param
     * @return
     * @throws Exception
     */
	public static String createGeneralXml( String _root , String[][] _param ) throws Exception{
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( _root );
			if( _param != null ){
				for(int index = 0 ; index < _param.length ; index++){
					fromRoot.addElement( _param[index][0] ).setText( _param[index][1] );
				}
			}
			fromXML = IXml._format( document , null );
		}
		catch( java.lang.Exception exception ){
			throw new java.lang.RuntimeException( exception.getMessage(), exception );
		}
		return fromXML;
	}
	
	/**
	 * 
	 * @param _root
	 * @param _bundle
	 * @return
	 * @throws Exception
	 */
	public static String createBundleXml( String  _root , java.util.Map _bundle ) throws Exception{
		String fromXML = null;
		try
		{
			IBundle aBundle = new IBundle( _root );
			java.util.Iterator itera = _bundle.entrySet().iterator();
			while( itera.hasNext() ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				aBundle.setProperty( fromEntry.getKey().toString(), fromEntry.getValue() != null? fromEntry.getValue().toString():"");
			}
			fromXML = IXml._format( aBundle.toString() );
		}
		catch( java.lang.Exception exception ){
			throw new java.lang.RuntimeException( exception.getMessage(), exception );
		}
		return fromXML;
	}
	
	/**
	 * 
	 * @param fromXML
	 * @param fromPath
	 * @param _bundle
	 */
	public static void XPathUnique( String fromXML, String fromPath, java.util.Map _bundle ){
		try
		{
			org.dom4j.Element fromRoot = XmlUtils.parseXml(fromXML);
			java.util.List fromXPath = StringUtils.isBlank(fromPath) ? fromRoot
					.elements() : fromRoot.selectNodes(fromPath);
			for(java.util.Iterator itera = fromXPath.iterator() ; itera.hasNext() ; ){
				org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
				IXml._parseUSublayer( aElement , _bundle );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromXML
	 * @param _bundle
	 */
	public static java.util.Map XPath( String fromXML, java.util.Map _bundle ){
		try
		{
			if( _bundle == null ) _bundle = new java.util.HashMap();
			XmlUtils.XPath( fromXML , null , _bundle );
		}
		finally{
			
		}
		return _bundle;
	}
	
	/**
	 * 
	 * @param fromXML
	 * @param fromPath
	 * @param fromRETN
	 */
	public static void XPath( String fromXML, String fromPath, java.util.Map _bundle ){
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			org.dom4j.Element fromRoot = null;
			if (XmlUtils.IXml.isXML(fromXML))
				fromRoot = XmlUtils.parseXml(fromXML);
			else
				fromRoot = XmlUtils.parseFileXml(fromXML);
			java.util.List fromXPath = StringUtils.isBlank(fromPath) ? fromRoot
					.elements() : fromRoot.selectNodes(fromPath);
			if (fromXPath.size() > 0) {
				fromINDEX.put(((org.dom4j.Element) fromXPath.get(0)).getParent().getPath(), _bundle);
				for (java.util.Iterator itera = fromXPath.iterator(); itera.hasNext();) {
					org.dom4j.Element aElement = (org.dom4j.Element) itera.next();
					IXml._parseXSublayer(aElement, fromINDEX, _bundle);
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
		}
	}
	
	/**
	 * 
	 * @param fromXML
	 * @param fromPath
	 * @return
	 */
	public static String XPathUnique( String fromXML, String fromPath){
		String fromXPath = null;
		try
		{
			org.dom4j.Element fromRoot = XmlUtils.parseXml(fromXML);
			fromXPath = IXml._wrap( fromRoot.selectSingleNode( fromPath ) );
		}
		finally{
			
		}
		return fromXPath;
	}
	/**
	 * 
	 * @param fromXML
	 * @param fromPath
	 * @return
	 */
	public static String[][] XPath( String fromXML, String fromPath){
		java.util.List fromASK = new java.util.ArrayList();
		try
		{
			org.dom4j.Element fromRoot = XmlUtils.parseXml(fromXML);
			java.util.List fromXPath = fromRoot.selectNodes(fromPath);
			for(java.util.Iterator itera = fromXPath.iterator() ; itera.hasNext() ; ){
	    		org.dom4j.Node fromNode = (org.dom4j.Node)itera.next();
	    		String fromVALUE = IXml._wrap( fromNode );
	    		if( StringUtils.isBlank( fromVALUE ) == false )
	    			fromASK.add( new String[]{ fromNode.getName() , fromVALUE.toString() } );
	    	}
		}
		finally{
			
		}
		return (String[][])fromASK.toArray(new String[][]{{}});
	}
	/**
	 * 
	 * @param fromXML
	 * @param fromPath
	 * @return
	 */
	public static java.util.Map[] XPathSublayer( String fromXML, String fromPath){
		java.util.List XPathSublayer = new java.util.ArrayList();
		try
		{
			org.dom4j.Element fromRoot = XmlUtils.parseXml(fromXML);
			java.util.List fromXPath = fromRoot.selectNodes(fromPath);
			for(java.util.Iterator itera = fromXPath.iterator() ; itera.hasNext() ; ){
				org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
	    		java.util.Map fromSublayer = new java.util.HashMap();
				for( java.util.Iterator iteraNode = aElement.elements().iterator() ; iteraNode.hasNext() ; ){
	    			org.dom4j.Node fromNode = (org.dom4j.Node)iteraNode.next();
	    			String fromVALUE = IXml._wrap( fromNode );
	    			if( StringUtils.isBlank( fromVALUE ) == false ){
	    				fromSublayer.put(fromNode.getName() , fromVALUE );
	    			}
	    		}
				XPathSublayer.add( fromSublayer );
	    	}
		}
		finally{
			
		}
		return (java.util.Map[])XPathSublayer.toArray( new java.util.Map[]{});
	}
	/**
	 * 
	 * <p>Copyright: Copyright (c) 2010-12-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IBundle implements java.io.Serializable {
		private static final long serialVersionUID = -2805062679466701828L;
		private org.dom4j.Document INSTANCE = null;
		public IBundle( String rootElement ) throws Exception{
			INSTANCE = org.dom4j.DocumentHelper.createDocument();
			INSTANCE.setRootElement( INSTANCE.addElement( rootElement ) );
		}
		/**
		 * 
		 * @param name
		 * @return
		 */
		private String[] parsePropertyName(String name) {
		    int size = 1;
		    for (int i = 0; i < name.length(); i++) {
		      if (name.charAt(i) == '.') size++;
		    }
		    String[] propName = new String[size];
		    java.util.StringTokenizer tokenizer = null;
		    tokenizer = new java.util.StringTokenizer(name, ".");
		    int i = 0;
		    while (tokenizer.hasMoreTokens()) {
		      propName[i] = tokenizer.nextToken();
		      i++;
		    }
		    return propName;
		}
		/**
		 * 
		 * @param name
		 * @param value
		 */
		public void setProperty(String name, String value) {
	    	String[] propName = parsePropertyName(name);
	    	org.dom4j.Element element = INSTANCE.getRootElement();
		    for (int i = 0; i < propName.length; i++) {
		    	if( propName[i].charAt(0) == '@' )
		    		element = element.addAttribute( propName[i].substring(1), value );
		    	else if (element.element( propName[i] ) == null) 
		    		element = element.addElement( propName[i] );
		    	else element = element.element( propName[i] );
		    }
		    if( propName[propName.length-1].charAt(0) != '@')
		    	element.setText(value);
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			try{
				return INSTANCE.asXML();
			}
			catch( java.lang.Exception tt){
				throw new java.lang.RuntimeException(tt);
			}
		}
	}
	/**
	 * 
	 * <p>Copyright: Copyright (c) 2010-12-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IXml{
		public IXml(){
			super();
		}
		
		/**
		 * 
		 * @param _key
		 * @return
		 */
		public static boolean isBlank( String _key ){
			return _key == null || StringUtils.isBlank( _key );
		}
		
		/**
		 * 
		 * @param aVaribale
		 * @return
		 */
		public static boolean isXML( String aVaribale ){
			boolean rtn = true;
			try
			{
				org.dom4j.DocumentHelper.parseText( aVaribale );
			}
			catch( java.lang.Exception tt){
				rtn = false;
			}
			return rtn;
		}
		
		/**
		 * 
		 * @param fromNode
		 * @return
		 */
		public static boolean isAttribute( org.dom4j.Node fromNode ){
			return fromNode != null && fromNode instanceof org.dom4j.Attribute;
		}
		
		/**
		 * 
		 * @param fromNode
		 * @return
		 */
		public static boolean isElement( org.dom4j.Node fromNode ){
			return fromNode != null && fromNode instanceof org.dom4j.Element;
		}
		
		/**
		 * 
		 * @param fromNode
		 * @return
		 */
		public static boolean isCData( org.dom4j.Node fromNode ){
			return fromNode != null && fromNode instanceof org.dom4j.CDATA;
		}
		
		/**
		 * 
		 * @param aElement
		 * @param aIGlobalLSKEL
		 * @param aIValueSKEL
		 */
		public static void _parseXSublayer( org.dom4j.Element aElement , java.util.Map aIGlobalLSKEL , java.util.Map aIValueSKEL ){
			if( aElement.elements().size() <= 0 ){ aIValueSKEL.put( aElement.getName() , aElement.getText().trim() ); return; }
			org.dom4j.Element aParentEl = aElement.getParent();
			if( aParentEl.elements( aElement.getName() ).size() <= 0 ){
				IXml._parseSublayer(aElement, aIGlobalLSKEL, aIValueSKEL);
			}
			else if( aParentEl.elements( aElement.getName() ).size() == 1 ){
				aIGlobalLSKEL.put( aElement.getPath() , new java.util.HashMap() );
				aIValueSKEL.put( aElement.getName() , aIGlobalLSKEL.get( aElement.getPath() ) );
				java.util.List aIItemSKEL = aParentEl.elements( aElement.getName() );
				for(java.util.Iterator itera = aIItemSKEL.iterator() ; itera.hasNext() ; ){
					org.dom4j.Element aISubItemL = (org.dom4j.Element)itera.next();
					IXml._parseSublayer(aISubItemL, aIGlobalLSKEL, (java.util.Map)aIGlobalLSKEL.get( aElement.getPath() ) );
		    	}
			}
			else{
				aIGlobalLSKEL.put( aElement.getPath() , new java.util.ArrayList() );
				aIValueSKEL.put( aElement.getName() , aIGlobalLSKEL.get( aElement.getPath() ) );
				java.util.List aISubListSKEL = aParentEl.elements( aElement.getName() );
				for(java.util.Iterator itera = aISubListSKEL.iterator() ; itera.hasNext() ; ){
					org.dom4j.Element aISubItemL = (org.dom4j.Element)itera.next();
		    		java.util.Map aIIValueSKEL = new java.util.HashMap();
		    		((java.util.List)aIGlobalLSKEL.get( aElement.getPath() ) ).add( aIIValueSKEL );
		    		IXml._parseSublayer( aISubItemL, aIGlobalLSKEL, aIIValueSKEL);
		    	}
			}
		}
		
		/**
		 * 
		 * @param aElement
		 * @param aIPathLSKEL
		 * @param aIValueSKEL
		 */
		public static void _parseSublayer( org.dom4j.Element aElement , java.util.Map aIPathLSKEL , java.util.Map aIValueSKEL ){
			java.util.List aISubItemSKEL = aElement.elements();
			if( aISubItemSKEL.size() > 0 ){
				for(java.util.Iterator itera = aISubItemSKEL.iterator() ; itera.hasNext() ; ){
					org.dom4j.Element aElementI = (org.dom4j.Element)itera.next();
					IXml._parseXSublayer( aElementI , aIPathLSKEL , aIValueSKEL );
		    	}
			}
		}
		
		/**
		 * 
		 * @param aElement
		 * @param aIValueSKEL
		 */
		public static void _parseUSublayer( org.dom4j.Element aElement , java.util.Map aIValueSKEL ){
			if( aElement.elements().size() <= 0 ){aIValueSKEL.put( aElement.getName() , aElement.getText().trim() );return;}
			java.util.List aISubItemSKEL = aElement.elements();
	    	for(java.util.Iterator itera = aISubItemSKEL.iterator() ; itera.hasNext() ; ){
	    		org.dom4j.Element aElementI = (org.dom4j.Element)itera.next();
	    		IXml._parseUSublayer( aElementI , aIValueSKEL );
	    	}
		}
		
		/**
		 * 
		 * @param _element
		 * @param _key
		 * @param _objective
		 * @throws Exception
		 */
		public static void _createIXml( org.dom4j.Element _element, Object _key, Object _objective ) throws Exception{
			if( _objective == null ){
				addElement( _element, _key ).setText( "");
			}
			else if( _objective instanceof java.lang.Class ){
				java.lang.Class _class = (java.lang.Class)_objective;
				addElement( _element, _key ).setText( _class.getName() );
			}
			else if( ClassUtils.IClass.isPrimitive( _objective.getClass() ) ){
				if( _objective != null && _objective instanceof java.lang.String && isXML( (String)_objective)) {
					addElement( _element, _key ).addCDATA( (String)_objective);
				} else {
					addElement( _element, _key ).setText( _objective != null?_objective.toString():"");
				}
			}
			else if( _objective instanceof java.util.Map ){
				org.dom4j.Element element = addElement( _element, _key );
				java.util.Map _map = (java.util.Map)_objective;
				for (java.util.Iterator itera = _map.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry _entry = (java.util.Map.Entry) itera.next();
					_createIXml( element, _entry.getKey(), _entry.getValue() );
				}
			}
			else if( _objective instanceof java.util.List ){
				java.util.List _list = (java.util.List)_objective;
				if( _key == null ){ throw new IllegalArgumentException("xml document key value is not empty."); }
				for (java.util.Iterator itera = _list.iterator(); itera.hasNext();) {
					_createIXml( addElement( _element, _key ), null, itera.next());
				}
			}
			else if( _objective instanceof java.util.Set ){
				java.util.Set _set = (java.util.Set)_objective;
				if( _key == null ){ throw new IllegalArgumentException("xml document key value is not empty."); }
				for (java.util.Iterator itera = _set.iterator(); itera.hasNext();) {
					_createIXml(addElement(_element, _key), null, itera.next());
				}
			}
			else if( _objective instanceof java.lang.Object[][]){
				org.dom4j.Element element = addElement( _element, _key );
				java.lang.Object[][] _array = (java.lang.Object[][])_objective;
				for (int index = 0; index < _array.length; index++) {
					element.addElement( _array[index][0].toString()).setText( 
							_array[index][1] != null ? _array[index][1].toString():"");
				}
			}
			else if( _objective instanceof java.lang.Object[] ){
				java.lang.Object[] _array = (java.lang.Object[])_objective;
				if( _key == null ){ throw new IllegalArgumentException("xml document key value is not empty."); }
				for (int index = 0; index < _array.length; index++) {
					_createIXml( addElement( _element, _key ), null, _array[index]);
				}
			}
			else if( _objective instanceof DataContainer ){
				org.dom4j.Element element = addElement( _element, _key );
				DataContainer _entity = (DataContainer)_objective;
				_createIXml( element, null, _entity.getProperties() );
			}
			else if( _objective instanceof HQSQLEntityBean ){
				org.dom4j.Element element = addElement( _element, _key );
				HQSQLEntityBean _entity = (HQSQLEntityBean)_objective;
				_createIXml( element, null, _entity.getProperties() );
			}
			else{
				IBeanWrapper fromWraper = new IBeanWrapper( _objective  );
				java.beans.PropertyDescriptor aDescriptors[] = fromWraper.getPropertyDescriptors();
				org.dom4j.Element element = addElement( _element, _key );
				for(int index = 0 ; index < aDescriptors.length ; index++){
					Object fromValue = fromWraper.getPropertyValue( aDescriptors[index].getName() );
					if( fromValue == null ) continue;
					_createIXml( element, aDescriptors[index].getName(), fromValue );
				}
			}
		}
		/**
		 * 
		 * @param element
		 * @param key
		 * @return
		 * @throws Exception
		 */
		private static org.dom4j.Element addElement( org.dom4j.Element element, Object key ) throws Exception{
			org.dom4j.Element _element = null;
			try
			{
				if( key == null ){
					_element = element;
				}
				else if( key instanceof java.lang.String){
					_element = element.addElement( (String)key );
				}
				else if( key instanceof java.util.Map ){
					String aFUNCTION[] = StringUtils.wildcardArray( key.getClass().getName() , "." );
					_element = element.addElement( aFUNCTION[ aFUNCTION.length - 1 ] );
					for( java.util.Iterator itera = ((java.util.Map)key).entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
						if( aEntry.getValue() != null && aEntry.getValue() instanceof java.lang.String && 
								aEntry.getValue() != null &&  ClassUtils.IClass.isPrimitive( aEntry.getValue().getClass() ) ){
							_element.addAttribute( aEntry.getKey().toString() , aEntry.getKey().toString() );
						}
					}
				}
				else{
					IBeanWrapper aWrapper = new IBeanWrapper( key  );
					String aFUNCTION[] = StringUtils.wildcardArray( aWrapper.getCLASS().getName() , "." );
					if( StringUtils.contains( aFUNCTION[ aFUNCTION.length - 1 ] , "$" ) ) 
						aFUNCTION = StringUtils.wildcardArray( aFUNCTION[ aFUNCTION.length - 1 ] , "$" );
					_element = element.addElement( aFUNCTION[ aFUNCTION.length - 1 ] );
					java.beans.PropertyDescriptor aDescriptor[] = aWrapper.getPropertyDescriptors();
					for( int index = 0 ; aDescriptor != null && index < aDescriptor.length; index++ ){
						Object aVALUE = aWrapper.getPropertyValue( aDescriptor[index].getName() );
						if( aVALUE == null || ClassUtils.IClass.isPrimitive( aVALUE.getClass() ) == false) continue;
						_element.addAttribute( aDescriptor[index].getName() , aVALUE.toString() );
					}
				}
			}
			finally{
				
			}
			return _element;
		}
		/**
		 * 
		 * @param fromNode
		 * @return
		 */
		public static String _wrap( org.dom4j.Node fromNode ){
			String fromXPath = null;
			try {
				if (isAttribute(fromNode)) {
					fromXPath = ((org.dom4j.Attribute) fromNode).getValue();
				} else if (isCData(fromNode)) {
					fromXPath = ((org.dom4j.CDATA) fromNode).getText();
				} else if (isElement(fromNode)) {
					org.dom4j.Element fromElement = (org.dom4j.Element) fromNode;
					if (fromElement.elements().size() > 0) {
						fromXPath = fromElement.asXML();
					} else if (fromElement.attributes().size() <= 0) {
						fromXPath = fromElement.getTextTrim();
					} else {
						fromXPath = fromElement.asXML();
					}
				} else if (fromNode != null) {
					fromXPath = fromNode.asXML();
				}
			} finally {
				
			}
			return fromXPath;
		}
		/**
		 * 
		 * @param doc
		 * @param aEncoding
		 * @return
		 * @throws Exception
		 */
		public static String _format( org.dom4j.Document doc , String aEncoding ) throws Exception{
			java.io.StringWriter aWriter = null;
			try
			{
				org.dom4j.io.OutputFormat formater = org.dom4j.io.OutputFormat.createPrettyPrint();
			    formater.setEncoding( aEncoding != null ?aEncoding:"utf-8");
			    aWriter = new java.io.StringWriter();
			    org.dom4j.io.XMLWriter writer = new org.dom4j.io.XMLWriter( aWriter , formater );
			    writer.write( doc );
			    return aWriter.toString();
			}
			finally{
				if( aWriter != null ){aWriter.close(); aWriter = null;}
			}
		}
		/***
		 * 
		 * @param strVariableXml
		 * @return
		 * @throws Exception
		 */
		public static String _format( String strVariableXml ) throws Exception{
			org.dom4j.io.SAXReader reader=null;
			java.io.StringReader in = null;
			java.io.StringWriter out = null;
			try
			{
			    reader = new org.dom4j.io.SAXReader();
			    in = new java.io.StringReader( strVariableXml );
			    org.dom4j.Document doc = reader.read( in );
			    org.dom4j.io.OutputFormat formater = org.dom4j.io.OutputFormat.createPrettyPrint();
			    formater.setEncoding("utf-8");
			    out = new java.io.StringWriter();
			    org.dom4j.io.XMLWriter writer = new org.dom4j.io.XMLWriter( out , formater );
			    writer.write( doc );
			    return out.toString();
			}
			catch(Exception t){
				throw t;
			}
			finally{
				if( out != null ){out.close(); out = null;}
				if( in != null ){ in.close(); in = null;}
				if( reader != null ){ reader = null;}
			}
		}
	}
}
