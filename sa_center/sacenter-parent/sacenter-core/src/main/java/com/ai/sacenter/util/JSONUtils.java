package com.ai.sacenter.util;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;

import net.sf.json.JSONException;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */

public class JSONUtils {
	public JSONUtils() {
		super();
	}
	
	/**
	 * 根据JSON内容转换JSON对象
	 * @param fromString JSON字符串
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static net.sf.json.JSON fromString( String fromString ) throws JSONException, Exception{
		net.sf.json.JSON _jsonobject = null;
		try
		{
			if( IJson.isJSONObject( fromString ) ){
				_jsonobject = net.sf.json.JSONObject.fromObject( fromString );
			}
			else if( IJson.isJSONArray( fromString ) ){
				_jsonobject = net.sf.json.JSONArray.fromObject( fromString );
			}
			else{
				throw new JSONException("JSONString text <" + fromString + "> must start with [/{ end with ]/}");
			} 
		}
		finally{
			
		}
		return _jsonobject;
	}
	
	/**
	 * 根据JAVA对象转换JSON
	 * @param fromObject JAVA对象
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static String fromBean( Object fromObject ) throws JSONException, Exception{
		String _string = null;
		try
		{
			Object fromJSON = IJson._fromBundle( fromObject );
			_string = IJson._fromJSONString( fromJSON );
		}
		finally{
			
		}
		return _string;
	}
	
	/**
	 * 根据JSON转换JAVA对象
	 * @param fromString JSON字符串
	 * @param objectClass 对象类
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static Object fromBean( String fromString, Class objectClass ) throws JSONException, Exception{
		Object fromObject = null;
		try
		{
			net.sf.json.JSONObject fromJSON = net.sf.json.JSONObject.fromObject( fromString );
			fromObject = net.sf.json.JSONObject.toBean( fromJSON, objectClass );
		}
		finally{
			
		}
		return fromObject;
	}
	
	/**
	 * 根据JAVA对象转换JSON数组
	 * @param fromArray 数据组对象
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static String fromList( Object fromArray ) throws JSONException, Exception{
		net.sf.json.JSONArray fromJSON = null;
		try
		{
			fromJSON = net.sf.json.JSONArray.fromObject( fromArray );
		}
		finally{
			
		}
		return fromJSON.toString();
	}
	
	/**
	 * 根据JSON数组转换JAVA对象列表
	 * @param fromString JSON字符串
	 * @param objectClass
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static java.util.List fromList( String fromString, Class objectClass ) throws JSONException, Exception{
		java.util.List fromList = null;
		java.util.Collection fromArray = null;
		try
		{
			net.sf.json.JSONArray fromJSON = net.sf.json.JSONArray.fromObject( fromString );
			fromArray = net.sf.json.JSONArray.toCollection(fromJSON, objectClass);
		    if( fromArray != null ){
		    	fromList = new java.util.ArrayList();
		    	for( java.util.Iterator itera = fromArray.iterator(); itera.hasNext(); ){
		    		fromList.add( itera.next() );
		    	}
		    }
		}
		finally{
			
		}
		return fromList;
	}
	
	/**
	 * 将JSON字符串转换Map对象
	 * @param fromJSONString JSON字符串
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static java.util.HashMap fromMap( String fromJSONString ) throws JSONException, Exception{
		java.util.HashMap fromBundles = new java.util.HashMap();
		try
		{
			net.sf.json.JSONObject fromJSONRoot = net.sf.json.JSONObject.fromObject( fromJSONString );
			for( java.util.Iterator itera = fromJSONRoot.keys(); itera.hasNext(); ){
				String fromNodeName = (String)itera.next();
				Object fromJSON = fromJSONRoot.get( fromNodeName );
				IJson.fromJSON( fromNodeName, fromJSON, fromBundles );
			}
		}
		finally{
			
		}
		return fromBundles;
	}
	
	/**
	 * 将Map对象转换JSON对象
	 * @param fromBundles JSONMap对象
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static String fromMap( java.util.Map fromBundles ) throws JSONException, Exception{
		net.sf.json.JSONObject fromJSONRoot = null;
		try
		{
			if( fromBundles != null && fromBundles.size() > 0 ){
				fromJSONRoot = new net.sf.json.JSONObject();
				for( java.util.Iterator itera = fromBundles.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					IJson.fromJSON( fromEntry.getKey().toString(), fromEntry.getValue(), fromJSONRoot );
				}
			}
		}
		finally{
			
		}
		return fromJSONRoot != null?fromJSONRoot.toString():null;
	}
	
	/**
	 * 根据XML内容转换为JSON内容
	 * @param fromXML XML内容
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static String fromXML( String fromXML ) throws JSONException, Exception{
		net.sf.json.JSONObject fromJSONRoot = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.parseText( fromXML );
			org.dom4j.Element fromRoot = document.getRootElement();
			if( fromRoot != null && fromRoot.elements().size() > 0 ){
				IJson.fromXML( fromRoot , fromJSONRoot = new net.sf.json.JSONObject() );
			}
		}
		finally{
			
		}
		return fromJSONRoot != null?fromJSONRoot.toString():null;
	}
	
	/**
	 * 根据JSON转换XML
	 * @param fromRootName XML根名
	 * @param fromJSONString JSON内容
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public static String fromXML(String fromRootName, String fromJSONString ) throws JSONException, Exception{
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( fromRootName );
			if( StringUtils.isBlank( fromJSONString ) == false ){
				net.sf.json.JSONObject fromJSONObject =net.sf.json. JSONObject.fromObject( fromJSONString );
				IJson.fromJSON( fromJSONObject, fromRoot );
			}
			fromXML = document.asXML();
		}
		finally{
			
		}
		return fromXML;
	}
	
	/**
	 * 把JSON字符串转换为BO实体
	 * @param fromJSONString
	 * @param fromTYPE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static DataStructInterface fromBean( String fromJSONString, ObjectType fromTYPE ) throws SFException,Exception{
		DataStructInterface fromEntity = null;
		try
		{
			com.ai.appframe2.common.Property _Property = null;
			fromEntity = ClassUtils.IClass.getASTBOEntity( fromTYPE );
			net.sf.json.JSONObject _jsonObject = net.sf.json.JSONObject.fromObject( fromJSONString );
			String _dba_type = (String)_jsonObject.get( "ROWOX" );
			if( StringUtils.equalsIgnoreCase( _dba_type, "INSERT" ) /*新增*/){
				for( java.util.Iterator itera = _jsonObject.keys(); itera.hasNext(); ){
					String _fieldName = (String)itera.next();
					if( fromTYPE.hasProperty( _fieldName ) == false ) continue;
					_Property = fromTYPE.getProperty( _fieldName );
					Object _fieldObj = IJson._fromBundle( _jsonObject, _Property );
					fromEntity.set( _fieldName, _fieldObj );
				}
				fromEntity.setStsToNew();
			}
			else if( StringUtils.equalsIgnoreCase( _dba_type, "UPDATE" ) /*更新*/ ){
				//主键
				java.util.Map _primary = fromTYPE.getKeyProperties();
				for( java.util.Iterator itera = _primary.keySet().iterator(); itera.hasNext(); ){
					String _fieldName = (String)itera.next();
					if( _jsonObject.get( _fieldName ) != null ){ 
						_Property = fromTYPE.getProperty( _fieldName );
						Object _fieldObj = IJson._fromBundle( _jsonObject, _Property );
						fromEntity.set( _fieldName, _fieldObj );
					}
				}
				fromEntity.setStsToOld();
				//更新内容
				for( java.util.Iterator itera = _jsonObject.keys(); itera.hasNext(); ){
					String _fieldName = (String)itera.next();
					if( fromTYPE.hasProperty( _fieldName ) && _primary.containsKey( _fieldName ) == false ){
						_Property = fromTYPE.getProperty( _fieldName );
						Object _fieldObj = IJson._fromBundle( _jsonObject, _Property );
						fromEntity.set( _fieldName, _fieldObj );
					}
				}
			}
			else if( StringUtils.equalsIgnoreCase( _dba_type, "DELETE" ) /*删除*/ ){
				java.util.Map _primary = fromTYPE.getKeyProperties();
				for( java.util.Iterator itera = _jsonObject.keys(); itera.hasNext(); ){
					String _fieldName = (String)itera.next();
					if( fromTYPE.hasProperty( _fieldName ) == false ) continue;
					if( _primary.containsKey( _fieldName ) && _jsonObject.get( _fieldName ) == null ){
						throw new SFException("IOS0014019", ExceptionFactory.getDefault().getLocal(
								"com.ai.appframe2.complex.tab.store.blank_key_col", new Object[]{} ) );
					}
					_Property = fromTYPE.getProperty( _fieldName );
					Object _fieldObj = IJson._fromBundle( _jsonObject, _Property );
					fromEntity.set( _fieldName, _fieldObj );
				}
				fromEntity.setStsToOld();
				fromEntity.delete();
			}
			else/*其它*/{
				for( java.util.Iterator itera = _jsonObject.keys(); itera.hasNext(); ){
					String _fieldName = (String)itera.next();
					if( fromTYPE.hasProperty( _fieldName ) == false ) continue;
					_Property = fromTYPE.getProperty( _fieldName );
					Object _fieldObj = IJson._fromBundle( _jsonObject, _Property );
					fromEntity.set( _fieldName, _fieldObj );
				}
				fromEntity.setStsToOld();
			}
		}
		finally{
			
		}
		return fromEntity;
	}
	
	/**
	 * 
	 * @param fromEntity
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String fromBean( DataStructInterface fromEntity ) throws SFException,Exception{
		net.sf.json.JSONObject _jsonobject = null;
		try
		{
			_jsonobject = new net.sf.json.JSONObject();
			if( fromEntity.isNew() ){
				_jsonobject.put( "ROWOX", "INSERT" );
				//插入
				for( java.util.Iterator itera = fromEntity.getNewProperties().entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					_jsonobject.put( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
			}
			else if( fromEntity.isModified() ){
				_jsonobject.put( "ROWOX", "UPDATE" );
				//更新
				java.util.Map _update = fromEntity.getNewProperties();
				for( java.util.Iterator itera = _update.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					_jsonobject.put( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
				//主键
				java.util.Map _primary = fromEntity.getKeyProperties();
				if( _primary.size() <= 0 ){
					throw new SFException("IOS0014019", ExceptionFactory.getDefault().getLocal(
							"com.ai.appframe2.complex.tab.store.blank_key_col", new Object[]{} ) );
				}
				for( java.util.Iterator itera = _primary.keySet().iterator(); itera.hasNext(); ){
					String _principal = (String)itera.next();
					Object _entitry = fromEntity.getOldObj( _principal );
					if( _entitry == null ){
						throw new SFException("IOS0014019", ExceptionFactory.getDefault().getLocal(
								"com.ai.appframe2.complex.tab.store.blank_key_col", new Object[]{} ) );
					}
					_jsonobject.put( _principal, _entitry );
				}
			}
			else if( fromEntity.isDeleted() ){
				_jsonobject.put( "ROWOX", "DELETE" );
				//主键
				java.util.Map _primary = fromEntity.getKeyProperties();
				java.util.Map _properties = fromEntity.getOldProperties();
				if( _primary.size() <= 0 ){
					throw new SFException("IOS0014019", ExceptionFactory.getDefault().getLocal(
							"com.ai.appframe2.complex.tab.store.blank_key_col", new Object[]{} ) );
				}
				for( java.util.Iterator itera = _properties.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					if( _primary.containsKey( fromEntry.getKey() ) && fromEntry.getValue() == null ){
						throw new SFException("IOS0014019", ExceptionFactory.getDefault().getLocal(
								"com.ai.appframe2.complex.tab.store.blank_key_col", new Object[]{} ) );
					}
					_jsonobject.put( fromEntry.getKey(), fromEntry.getValue() );
				}
			}
			else{
				//其它
				java.util.Map _properties = fromEntity.getProperties();
				for( java.util.Iterator itera = _properties.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					_jsonobject.put( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
			}
		}
		finally{
			
		}
		return _jsonobject.toString();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-7-19</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IJson{
		private IJson(){
			super();
		}
		
		/**
		 * 
		 * @param _string
		 * @return
		 */
		public static boolean isJSONString( String _string ){
			boolean _jsonobject = false;
			try
			{
				net.sf.json.JSONObject.fromObject( _string );
				_jsonobject = true;
			}
			catch( java.lang.Exception exception ){
				try
				{
					net.sf.json.JSONArray.fromObject( _string );
					_jsonobject = true;
				}
				catch( java.lang.Exception _exception ){
					_jsonobject = false;
				}
			}
			return _jsonobject;
		}
		
		/**
		 * 
		 * @param _string
		 * @return
		 */
		public static boolean isJSONObject( String _string ){
			boolean _jsonobject = false;
			try
			{
				net.sf.json.JSONObject.fromObject( _string );
				_jsonobject = true;
			}
			catch( java.lang.Exception exception ){
				_jsonobject = false;
			}
			return _jsonobject;
		}
		
		/**
		 * 
		 * @param _string
		 * @return
		 */
		public static boolean isJSONArray( String _string ){
			boolean _jsonobject = false;
			try
			{
				net.sf.json.JSONArray.fromObject( _string );
				_jsonobject = true;
			}
			catch( java.lang.Exception exception ){
				_jsonobject = false;
			}
			return _jsonobject;
		}

		/**
		 * 
		 * @param fromRoot
		 * @param fromJSONRoot
		 * @throws JSONException
		 * @throws Exception
		 */
		public static net.sf.json.JSON fromXML( org.dom4j.Element fromRoot, net.sf.json.JSONObject fromJSONRoot ) throws JSONException, Exception{
			try
			{
				java.util.List fromSublayer = IIJson._jj_sublayer( fromRoot );
				if( fromSublayer == null || fromSublayer.size() <= 0 ){
					if( fromRoot.getText() == null ){
						fromJSONRoot.put( fromRoot.getName(), net.sf.json.JSONNull.getInstance() );
					}
					else{
						fromJSONRoot.put( fromRoot.getName(), fromRoot.getText() );
					}
				}
				else{
					for( java.util.Iterator itera = fromSublayer.iterator(); itera.hasNext(); ){
						String fromName = (String)itera.next();
						java.util.List fromBundles = fromRoot.elements( fromName );
						if( fromBundles != null && fromBundles.size() <= 1 ){
							org.dom4j.Element fromBundle = (org.dom4j.Element)fromBundles.get( fromBundles.size() - 1 );
							if( fromBundle.elements().size() <= 0 ){
								IJson.fromXML( fromBundle, fromJSONRoot );
							}
							else{
								net.sf.json.JSONObject fromJSONChild = new net.sf.json.JSONObject();
								IJson.fromXML( fromBundle, fromJSONChild );
								fromJSONRoot.put( fromBundle.getName(), fromJSONChild );
							}
						}
						else{
							net.sf.json.JSONArray fromArray = new net.sf.json.JSONArray();
							for( java.util.Iterator iterap = fromBundles.iterator(); iterap.hasNext(); ){
								org.dom4j.Element fromBundle = (org.dom4j.Element)iterap.next();
								if( fromBundle.elements().size() <= 0 ){
									fromArray.add( fromBundle.getText() );
								}
								else{
									net.sf.json.JSONObject fromJSONChild = new net.sf.json.JSONObject();
									IJson.fromXML( fromBundle, fromJSONChild );
									fromArray.add( fromJSONChild );
								}
							}
							fromJSONRoot.put( fromName, fromArray );
						}
					}
				}
			}
			finally{
				
			}
			return fromJSONRoot;
		}
		
		/**
		 * 
		 * @param fromJSONRoot
		 * @param fromRoot
		 * @throws JSONException
		 * @throws Exception
		 */
		public static void fromJSON( net.sf.json.JSONObject fromJSONRoot, org.dom4j.Element fromRoot ) throws JSONException, Exception{
			try
			{
				for( java.util.Iterator itera = fromJSONRoot.keys(); itera.hasNext(); ){
					String fromNodeName = (String)itera.next();
					Object fromJSON = fromJSONRoot.get( fromNodeName );
					if( fromJSON instanceof net.sf.json.JSONNull ){
						fromRoot.addElement( fromNodeName );
					}
					else if( IIJson.isJSONObject( fromJSON ) ){
						net.sf.json.JSONObject fromJSONObject = ((net.sf.json.JSONObject)fromJSON);
						org.dom4j.Element fromBundle = fromRoot.addElement( fromNodeName );
						IJson.fromJSON( fromJSONObject, fromBundle);
					}
					else if( IIJson.isJSONArray( fromJSON ) ){
						net.sf.json.JSONArray fromJSONArray = ((net.sf.json.JSONArray)fromJSON);
						for( int index = 0; fromJSONArray != null && index < fromJSONArray.size(); index++ ){
							Object fromObject = fromJSONArray.get( index );
							if( IIJson.isJSONPrimitive( fromObject ) ){
								fromRoot.addElement( fromNodeName ).setText( fromObject.toString() );
							}
							else
							{
								org.dom4j.Element fromBundle = fromRoot.addElement( fromNodeName );
								IJson.fromJSON( (net.sf.json.JSONObject)fromObject, fromBundle );
							}
						}
					}
					else if( IIJson.isJSONString( fromJSON ) ){
						if( IIJson.isXML( fromJSON.toString() ) ){
							fromRoot.addElement( fromNodeName ).addCDATA( fromJSON.toString() );
						}
						else{
							fromRoot.addElement( fromNodeName ).setText( fromJSON.toString() );
						}
					}
					else{
						fromRoot.addElement( fromNodeName ).setText( fromJSON.toString() );
					}
				}
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromKey
		 * @param fromObject
		 * @param fromMap
		 * @throws JSONException
		 * @throws Exception
		 */
		public static void fromJSON(String fromKey, Object fromObject, java.util.Map fromMap ) throws JSONException,Exception{
			try
			{
				if (fromObject == null || ClassUtils.IClass.isJSONNull(fromObject)) {
					fromMap.put(fromKey, null);
				} 
				else if( IIJson.isJSONPrimitive( fromObject ) ) {
					fromMap.put(fromKey, fromObject);
				} 
				else if( IIJson.isJSONObject( fromObject ) ) {
					java.util.Map afromMap = fromMap;
					if (fromKey != null) fromMap.put(fromKey, afromMap = new java.util.HashMap());
					net.sf.json.JSONObject fromJSONObject = (net.sf.json.JSONObject)fromObject;
					for (java.util.Iterator itera = fromJSONObject.keys(); itera.hasNext();) {
						fromKey = (String) itera.next();
						Object aObject = ((net.sf.json.JSONObject) fromObject).get(fromKey);
						IJson.fromJSON(fromKey, aObject, afromMap);
					}
				} 
				else if( IIJson.isJSONArray( fromObject ) ) {
					if( fromKey == null ){ throw new JSONException( "JSONArray is not Primitive.");}
					java.util.List fromArray = new java.util.ArrayList();
					fromMap.put(fromKey, fromArray);
					net.sf.json.JSONArray aJSONArray = (net.sf.json.JSONArray)fromObject;
					for (int index = 0; fromObject != null && index < aJSONArray.size(); index++) {
						fromObject = aJSONArray.get(index);
						if( IIJson.isJSONPrimitive( fromObject ) ){
							fromArray.add( fromObject );
						}
						else{
							if( IIJson.isJSONObject( fromObject ) == false) {
								throw new JSONException("JSONArray[" + index + "] is not a JSONObject.");
							}
							fromArray.add(new java.util.HashMap());
							IJson.fromJSON(null, fromObject, (java.util.Map) fromArray.get(fromArray.size() - 1));
						}
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromName
		 * @param fromObject
		 * @param fromJSONRoot
		 * @throws net.sf.json.JSONException
		 * @throws Exception
		 */
		public static void fromJSON(String fromName, Object fromObject, net.sf.json.JSONObject fromJSONRoot ) throws net.sf.json.JSONException,Exception{
			try
			{
				if( fromObject == null ){
					if( fromName == null ) { throw new JSONException("JSON keys cannot be null."); }
					fromJSONRoot.put( fromName,  net.sf.json.JSONNull.getInstance() );
				}
				else if( IIJson.isJSONPrimitive( fromObject ) ){
					if( fromName == null ) { throw new JSONException("JSON keys cannot be null."); }
					fromJSONRoot.put( fromName, fromObject );
				}
				else if( fromObject instanceof java.util.Map ){
					java.util.Map fromJSONMap = (java.util.Map)fromObject;
					net.sf.json.JSONObject fromJSONObject = fromJSONRoot;
					if( fromName != null ) fromJSONObject = new net.sf.json.JSONObject();
					for (java.util.Iterator itera = fromJSONMap.entrySet().iterator(); itera.hasNext();) {
						java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
						IJson.fromJSON( (String)fromEntry.getKey(), fromEntry.getValue(), fromJSONObject );
					}
					if( fromName != null ) fromJSONRoot.put( fromName, fromJSONObject );
				}
				else if( fromObject instanceof java.util.List ){
					java.util.List fromJSONList = (java.util.List)fromObject;
					if( fromName == null ) { throw new JSONException("JSONArray keys must not be null nor the 'null' string."); }
					net.sf.json.JSONArray fromJSONArray = new net.sf.json.JSONArray();
					for( java.util.Iterator itera = fromJSONList.iterator(); itera.hasNext(); ){
						Object fromEntry = itera.next();
						if( IIJson.isJSONPrimitive( fromEntry ) ){
							fromJSONArray.add( fromEntry );
						}
						else{
							net.sf.json.JSONObject fromJSONObject = new net.sf.json.JSONObject();
							IJson.fromJSON( null, fromEntry, fromJSONObject );
							fromJSONArray.add( fromJSONObject );
						}
					}
					fromJSONRoot.put( fromName, fromJSONArray );
				}
				else if( fromObject instanceof java.lang.Object[] ){
					java.lang.Object fromJSONList[] = (java.lang.Object[])fromObject;
					if( fromName == null ) { throw new JSONException("JSONArray[" + fromName + "] is not null."); }
					net.sf.json.JSONArray fromJSONArray = new net.sf.json.JSONArray();
					for( int index = 0; index < fromJSONList.length; index++ ){
						if( IIJson.isJSONPrimitive( fromJSONList[index] ) ){
							fromJSONArray.add( fromJSONList[index] );
						}
						else{
							net.sf.json.JSONObject fromJSONObject = new net.sf.json.JSONObject();
							IJson.fromJSON( null, fromJSONList[index], fromJSONObject );
							fromJSONArray.add( fromJSONObject );
						}
					}
					fromJSONRoot.put( fromName, fromJSONArray );
				}
				else if( fromObject instanceof com.ai.appframe2.common.DataStructInterface ){
					com.ai.appframe2.common.DataStructInterface fromEntity = (com.ai.appframe2.common.DataStructInterface)fromObject;
					net.sf.json.JSONObject fromJSONObject = fromJSONRoot;
					if( fromName != null ) fromJSONObject = new net.sf.json.JSONObject();
					for (java.util.Iterator itera = fromEntity.getProperties().entrySet().iterator(); itera.hasNext();) {
						java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
						IJson.fromJSON( (String)fromEntry.getKey(), fromEntry.getValue(), fromJSONObject );
					}
					if( fromName != null ) fromJSONRoot.put( fromName, fromJSONObject );
				}
				else{
					IBeanWrapper fromWraper = new IBeanWrapper( fromObject  );
					java.beans.PropertyDescriptor aDescriptors[] = fromWraper.getPropertyDescriptors();
					net.sf.json.JSONObject fromJSONObject = fromJSONRoot;
					if( fromName != null ) fromJSONObject = new net.sf.json.JSONObject();
					for(int index = 0 ; index < aDescriptors.length ; index++){
						Object fromOBJECT = fromWraper.getPropertyValue( aDescriptors[index].getName() );
						if( fromOBJECT == null ) continue;
						IJson.fromJSON( aDescriptors[index].getName(), fromOBJECT, fromJSONObject );
					}
					if( fromName != null ) fromJSONRoot.put( fromName, fromJSONObject );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _bundle
		 * @return
		 * @throws Exception
		 */
		public static Object _fromBundle( Object _bundle ) throws Exception{
			Object fromJSON = null;
			try
			{
				if( IIJson.isJSONNull( _bundle ) ){
					fromJSON = new net.sf.json.JSONObject( true );
				}
				else if( _bundle instanceof net.sf.json.JSON ){
					fromJSON = (net.sf.json.JSON)_bundle;
				}
				else if( IIJson.isJSONPrimitive( _bundle ) ){
					if( IIJson.isJSONString( _bundle ) == false ){
						fromJSON = _bundle;
					}
					else if( IIJson.isXML( (String)_bundle ) ){
						org.dom4j.Element fromRoot = XmlUtils.parseXml( (String)_bundle );
						fromJSON = IJson.fromXML( fromRoot, new net.sf.json.JSONObject() );
					}
					else{
						fromJSON = _bundle;
					}
				}
				else if( _bundle instanceof DataStructInterface ){
					DataStructInterface fromSubSQL = (DataStructInterface)_bundle;
					fromJSON = IJson._fromBundle( fromSubSQL.getProperties(), new net.sf.json.JSONObject() );
				}
				else if( _bundle instanceof java.util.Map ){
					java.util.Map _bundles = (java.util.Map)_bundle;
					fromJSON = IJson._fromBundle( _bundles, new net.sf.json.JSONObject() );
				}
				else if( _bundle instanceof java.util.Collection ){
					java.util.Collection _bundles = (java.util.Collection)_bundle;
					fromJSON = IJson._fromBundle( _bundles, new net.sf.json.JSONArray() );
				}
				else{
					fromJSON = new net.sf.json.JSONObject();
					IBeanWrapper fromWraper = new IBeanWrapper( _bundle  );
					java.beans.PropertyDescriptor _descriptors[] = fromWraper.getPropertyDescriptors();
					for(int index = 0 ; index < _descriptors.length ; index++){
						Object _objective = fromWraper.getPropertyValue( _descriptors[index].getName() );
						if( _objective == null ) continue;
						IJson.fromJSON( _descriptors[index].getName(), _objective, (net.sf.json.JSONObject)fromJSON );
					}
				}
			}
			finally{
				
			}
			return fromJSON;
		}
		
		/**
		 * 
		 * @param _bundles
		 * @param fromJSON
		 * @return
		 * @throws Exception
		 */
		public static net.sf.json.JSON _fromBundle( java.util.Map _bundles, net.sf.json.JSONObject fromJSONObject ) throws Exception{
			try
			{
				for( java.util.Iterator itera = _bundles.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					IJson.fromJSON( fromEntry.getKey().toString(), fromEntry.getValue(), fromJSONObject );
				}
			}
			finally{
				
			}
			return fromJSONObject;
		}
		
		/**
		 * 
		 * @param _bundles
		 * @param fromJSONArray
		 * @return
		 * @throws Exception
		 */
		public static net.sf.json.JSON _fromBundle( java.util.Collection _bundles, net.sf.json.JSONArray fromJSONArray ) throws Exception{
			try
			{
				for( java.util.Iterator itera = _bundles.iterator(); itera.hasNext(); ){
					Object _objective = itera.next();
					fromJSONArray.add( IJson._fromBundle( _objective ) );
				}
			}
			finally{
				
			}
			return fromJSONArray;
		}
		
		/**
		 * 
		 * @param _jsonObject
		 * @param _field
		 * @return
		 * @throws Exception
		 */
		public static Object _fromBundle( net.sf.json.JSONObject _jsonObject, com.ai.appframe2.common.Property _field ) throws Exception{
			Object _objective = null;
			try
			{
				_objective = _jsonObject.get( _field.getName() );
				if( _objective instanceof net.sf.json.JSONNull ){
					return null;
				}
				else{
					_objective = ClassUtils.IClass.transfer( _objective, 
							DataType.getJavaClass( _field.getJavaDataType() ) );
				}
			}
			finally{
				
			}
			return _objective;
		}
		
		/**
		 * 
		 * @param fromJSON
		 * @return
		 */
		public static String _fromJSONString( Object fromJSON ){
			String _string = null;
			if( fromJSON != null && fromJSON instanceof net.sf.json.JSON ){
				_string = ((net.sf.json.JSON)fromJSON).toString();
			}
			else{
				_string = net.sf.json.util.JSONUtils.valueToString( fromJSON );
			}
			return _string;
		}
		
		/**
		 * 
		 * <p>Title: sacenter-core</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2017年5月13日</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public static class IIJson{
			/**
			 * 
			 * @param fromRoot
			 * @return
			 */
			public static java.util.List _jj_sublayer( org.dom4j.Element fromRoot ){
				java.util.List fromNodeName = new java.util.ArrayList();
				try
				{
					for( java.util.Iterator itera = fromRoot.elements().iterator(); itera.hasNext(); ){
						org.dom4j.Element fromChild = (org.dom4j.Element)itera.next();
						if( fromNodeName.indexOf( fromChild.getName() ) < 0 ){
							fromNodeName.add( fromChild.getName() );
						}
					}
				}
				finally{
					
				}
				return fromNodeName;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSON( Object fromJSON ){
				return fromJSON != null && fromJSON instanceof net.sf.json.JSON;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONPrimitive( Object fromJSON ){
				return ClassUtils.IClass.isPrimitive( fromJSON );
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONNull( Object fromJSON ){
				if( fromJSON instanceof net.sf.json.JSONObject ){
					return ((net.sf.json.JSONObject)fromJSON).isNullObject();
				}
				return net.sf.json.JSONNull.getInstance().equals( fromJSON );
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONBoolean( Object fromJSON ){
				return fromJSON != null && ( fromJSON instanceof java.lang.Boolean );
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONInteger( Object fromJSON ){
				if( fromJSON != null && fromJSON instanceof java.lang.Number ){
					java.lang.Number fromNumber = (java.lang.Number)fromJSON;
					if( fromNumber instanceof java.lang.Integer ){
						return true;
					}
					try
				    {
						Integer.parseInt( String.valueOf( fromNumber ) );
				        return true; 
				    } 
					catch( java.lang.NumberFormatException e ){
						
				    }
				}
				return false;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONLong( Object fromJSON ){
				if( fromJSON != null && fromJSON instanceof java.lang.Number ){
					java.lang.Number fromNumber = (java.lang.Number)fromJSON;
					if( fromNumber instanceof java.lang.Long ){
						return true;
					}
					try
				    {
						Long.parseLong( String.valueOf( fromNumber ) );
				        return true; 
				    } 
					catch( java.lang.NumberFormatException e ){
						
				    }
				}
				return false;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONFloat( Object fromJSON ){
				if( fromJSON != null && fromJSON instanceof java.lang.Number ){
					java.lang.Number fromNumber = (java.lang.Number)fromJSON;
					if( fromNumber instanceof java.lang.Float ){
						return true;
					}
					try
				    {
						Float.parseFloat( String.valueOf( fromNumber ) );
				        return true; 
				    } 
					catch( java.lang.NumberFormatException e ){
						
				    }
				}
				return false;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONBigInteger( Object fromJSON ){
				if( fromJSON != null && fromJSON instanceof java.lang.Number ){
					java.lang.Number fromNumber = (java.lang.Number)fromJSON;
					if( fromNumber instanceof java.math.BigInteger ){
						return true;
					}
					try
				    {
						new java.math.BigInteger( String.valueOf( fromNumber ) );
				        return true; 
				    } 
					catch( java.lang.NumberFormatException e ){
						
				    }
				}
				return false;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONBigDecimal( Object fromJSON ){
				if( fromJSON != null && fromJSON instanceof java.lang.Number ){
					java.lang.Number fromNumber = (java.lang.Number)fromJSON;
					if( fromNumber instanceof java.math.BigDecimal ){
						return true;
					}
					try
				    {
						new java.math.BigDecimal( String.valueOf( fromNumber ) );
				        return true; 
				    } 
					catch( java.lang.NumberFormatException e ){
						
				    }
				}
				return false;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONDouble( Object fromJSON ){
				if( fromJSON != null && fromJSON instanceof java.lang.Number ){
					java.lang.Number fromNumber = (java.lang.Number)fromJSON;
					if( fromNumber instanceof java.lang.Double ){
						return true;
					}
					try
				    {
						double fromDouble = Double.parseDouble( String.valueOf( fromNumber ) );
						return MathUtils.isFinite( fromDouble );
				    } 
					catch( java.lang.NumberFormatException e ){
						
				    }
				}
				return false;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONNumber( Object fromJSON ){
				if( ( (fromJSON != null) && (fromJSON.getClass() == Byte.TYPE) ) || 
						(fromJSON != null) && (fromJSON.getClass() == Short.TYPE) ||
						(fromJSON != null) && (fromJSON.getClass() == Integer.TYPE) ||
						(fromJSON != null) && (fromJSON.getClass() == Long.TYPE) ||
						(fromJSON != null) && (fromJSON.getClass() == Float.TYPE) ||
						(fromJSON != null) && (fromJSON.getClass() == Double.TYPE) ){
					return true;
				}
				return fromJSON != null && fromJSON instanceof java.lang.Number;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONString( Object fromJSON ){
				return fromJSON != null && ( fromJSON instanceof java.lang.String || 
						fromJSON instanceof java.lang.Character || 
						fromJSON instanceof net.sf.json.JSONString );
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONArray( Object fromJSON ){
				return (fromJSON != null && fromJSON.getClass().isArray() ) || 
						( fromJSON instanceof java.util.Collection ) || 
						( fromJSON instanceof net.sf.json.JSONArray );
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONSql( Object fromJSON ){
				return fromJSON != null && fromJSON instanceof DataStructInterface;
			}
			
			/**
			 * 
			 * @param fromJSON
			 * @return
			 */
			public static boolean isJSONObject( Object fromJSON ){
				return fromJSON != null && fromJSON instanceof net.sf.json.JSONObject ;
			}
			
			/**
			 * 
			 * @param fromString
			 * @return
			 */
			public static boolean isXML( String fromString ){
				boolean rtn = true;
				try
				{
					org.dom4j.DocumentHelper.parseText( fromString );
				}
				catch( java.lang.Exception tt){
					rtn = false;
				}
				return rtn;
			}
			
		}
	}
}
