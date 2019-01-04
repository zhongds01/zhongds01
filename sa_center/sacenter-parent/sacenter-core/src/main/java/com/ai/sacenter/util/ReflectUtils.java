package com.ai.sacenter.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;

import com.ai.aif.csf.client.service.factory.CsfServiceCaller;
import com.ai.aif.csf.common.exception.CsfException;
import com.ai.appframe2.bo.DataContainer;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: JAVA反射工具</p>
 * <p>Copyright: Copyright (c) 2015年10月21日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ReflectUtils {
	private static final Logger log = Logger.getLogger(ReflectUtils.class);
	private static java.util.Map _runtime_class = new java.util.concurrent.ConcurrentHashMap();
	private static java.util.Map _runtime_native = new java.util.concurrent.ConcurrentHashMap();
	private static final java.lang.Class[]  _emptyClassArray_ = new java.lang.Class[]{};
    private static final java.lang.Object[] _emptyObjectArray_ = new java.lang.Object[]{};
	public ReflectUtils() {
		super();
	}
	
	/**
	 * 
	 * @param fromPath
	 * @param fromEntity
	 * @return
	 * @throws Exception
	 */
	public static Object xPath(String fromPath, Object fromEntity) throws Exception {
		java.util.Queue fromDeque = null;
		try
		{
			fromDeque = ICustom._get_xpath( fromPath );
			while( fromDeque.size() > 0 ){
				XPathNode fromNode = (XPathNode)fromDeque.remove();
				if( fromNode.isEmpty() ){ continue; }
				if( ClassUtils.IClass.isContainer( fromEntity ) ) {
					fromEntity = ICustom._get_container( fromNode, fromEntity);
				} 
				else if( ClassUtils.IClass.isMYSQL5( fromEntity ) ){
					fromEntity = ICustom._get_hqsql( fromNode, fromEntity );
				}
				else if( ClassUtils.IClass.isMap( fromEntity ) ) {
					fromEntity = ICustom._get_map( fromNode, fromEntity);
				} 
				else if( ClassUtils.IClass.isJSON( fromEntity ) ) {
					fromEntity = ICustom._get_jsonobject( fromNode, fromEntity);
				} 
				else if( ClassUtils.IClass.isXML( fromEntity ) ) {
					fromEntity = ICustom._get_jdomxml( fromNode, fromEntity);
				} 
				else if( ClassUtils.IClass.isPrimitive( fromEntity ) ) {
					fromEntity = null;
				} 
				else{
					fromEntity = ICustom._get_javabean( fromNode, fromEntity);
				}
				if (fromEntity == null) { break; }
			}
		} 
		finally{
			if( fromDeque != null ){ fromDeque.clear(); fromDeque = null; }
		}
		return fromEntity;
	}
	
	/**
	 * 根据当前路径查询末端路径对应对象
	 * @param fromXPath 对象路径
	 * @param fromEntity 数据容器
	 * @return
	 * @throws Exception
	 */
	public static Object xPath(String fromXPath[], Object fromEntity) throws Exception {
		Object fromObject = null;
		try
		{
			String fromPath = StringUtils.join(fromXPath, "/");
			fromObject = xPath(fromPath, fromEntity);
		}
		finally {

		}
		return fromObject;
	}
	
	/**
	 * 查询值并如存在则删除数据
	 * @param fromPaths
	 * @param fromEntity
	 * @return 已删除数据
	 * @throws Exception
	 */
	public static Object xPathDel( String fromPaths, Object fromEntity) throws Exception{
		Object fromDELETE = null;
		try
		{
			String fromPath[] = ReflectUtils.ICustom.getXPath( fromPaths );
			String fromXPath[] = new String[ fromPath.length - 1 ];
			System.arraycopy( fromPath, 0, fromXPath, 0, fromPath.length - 1 );
			Object fromDPath = ReflectUtils.xPath( fromXPath, fromEntity );
			fromDELETE = ReflectUtils.xPath(fromPath[fromPath.length - 1], fromDPath);
			if( fromDPath == null || fromDELETE == null ){
				return null;
			}
			if( ( fromDPath instanceof java.util.Map || fromDPath instanceof com.ai.appframe2.bo.DataContainer) == false){
				throw new java.lang.RuntimeException(
						"the path {" + fromPaths + "} not found in data cache path to meet conditions");
			}
			if (fromDPath instanceof java.util.Map){
				((java.util.Map) fromDPath).remove(fromPath[fromPath.length - 1]);
			}
			else if (fromDPath instanceof com.ai.appframe2.bo.DataContainer){
				((com.ai.appframe2.bo.DataContainer) fromDPath).clearProperty(fromPath[fromPath.length - 1]);
			}
		}
		finally{
			
		}
		return fromDELETE;
	}
	
	/**
	 * 根据JEVAL引擎参数规范生成JEVAL参数清单
	 * @param fromKEY
	 * @param fromOBJECT 
	 * @param fromJEVAL
	 * @throws SFException
	 * @throws Exception
	 */
	public static void getICTKJevaL(String fromKEY, Object fromOBJECT, java.util.Map fromJEVAL) throws SFException, Exception {
		try
		{
			ICustom._gvp_complex(fromKEY, fromOBJECT, fromJEVAL);
		} 
		finally{

		}
	}
	
	/**
	 * 
	 * @param aOBJECT
	 * @param fromJEVAL
	 * @throws SFException
	 * @throws Exception
	 */
	public static void getICTKJevaL(Object[] aOBJECT, java.util.Map fromJEVAL) throws SFException, Exception {
		try
		{
			for (int index = 0; aOBJECT != null && index < aOBJECT.length; index++) {
				ICustom._gvp_complex(null, aOBJECT[index], fromJEVAL);
			}
		}
		finally{

		}
	}
	
	/**
	 * 
	 * @param aOBJECT
	 * @param fromJEVAL
	 * @throws SFException
	 * @throws Exception
	 */
	public static void getICTKJevaL(Object[][] aOBJECT, java.util.Map fromJEVAL) throws SFException, Exception {
		try
		{
			for (int index = 0; index < aOBJECT.length; index++) {
				ICustom._gvp_complex( (String)aOBJECT[index][0], aOBJECT[index][1], fromJEVAL );
			}
		} 
		finally{

		}
	}
	
	/**
	 * 根据当前路径对象创建路径元素对象并返回末端元素
	 * @param aPath 对象路径
	 * @param fromMap 数据容器
	 * @return
	 */
	public static Object gcISTKGraph(String aPath, Object fromMap) {
		Object aOBJECT = null;
		try
		{
			aOBJECT = ICustom._gvs_complex(aPath, fromMap);
		} 
		catch (java.lang.Exception aException) {
			ExceptionFactory.throwRuntime(aException);
		} 
		finally {

		}
		return aOBJECT;
	}
	
	/**
	 * 根据当前路径对象创建路径元素对象
	 * @param aOBJECT 路径对象[0路径1对象]
	 * @param fromMap 数据容器
	 * @throws SFException
	 * @throws Exception
	 */
	public static void gcISTKGraph( Object[][] aOBJECT, Object fromMap ) throws SFException, Exception {
		try
		{
			for (int index = 0; aOBJECT != null && index < aOBJECT.length; index++) {
				ICustom._gvs_complex( fromMap, (String) aOBJECT[index][0], aOBJECT[index][1] );
			}
		} 
		finally {

		}
	}
	
	/**
	 * 
	 * @param aCLASS
	 * @return
	 */
	public static ISystemTemplate.ISystemNative getNative(Class aCLASS) {
		ISystemTemplate.ISystemNative _runtime_natives = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX(new String[] { "_$_ISystemNative", "_$_", aCLASS.getName() });
			if( (_runtime_natives = (ISystemTemplate.ISystemNative) _runtime_native.get(fromINDEX )) == null) {
				synchronized (_runtime_native) {
					if ((_runtime_natives = (ISystemTemplate.ISystemNative) _runtime_native.get(fromINDEX)) == null) {
						_runtime_natives = new ISystemTemplate.ISystemNative( aCLASS );
						java.lang.reflect.Method aMethod[] = aCLASS.getMethods();
						for (int index = 0; index < aMethod.length; index++) {
							_runtime_natives.getMethods().add(aMethod[index]);
							if (_runtime_natives.getNatives().containsKey( aMethod[index].getName()) == false){
								_runtime_natives.getNatives().put( aMethod[index].getName(), new java.util.ArrayList());
							}
							((java.util.List) _runtime_natives.getNatives().get(aMethod[index].getName())).add(aMethod[index]);
						}
						java.lang.reflect.Constructor aConstructor[] = aCLASS.getConstructors();
						for( int index = 0; aConstructor != null && index < aConstructor.length; index++ ){
							_runtime_natives.getConstructor().add( aConstructor[index] );
						}
						ReflectUtils.IReflect.loadFields(aCLASS, _runtime_natives.getFields());
						_runtime_native.put( fromINDEX, _runtime_natives );
						if (log.isDebugEnabled()){
							log.debug("initializate JdfomPoolDefine [" + aCLASS.getName() + "] successfully");
						}
					}
				}
			}
		} 
		catch (java.lang.Exception aException) {
			ExceptionFactory.throwRuntime(aException);
		}
		return _runtime_natives;
	}
	
	/**
	 * 根据本地类编码获取本地类调用器
	 * @param aNative 本地类编码,格式为$FUN(采用系统内部类)或本地类编码[采用类资产库]
	 * @return
	 */
	public static ISystemTemplate.ISystemNative getNative(String aNative) throws Exception{
		ISystemTemplate.ISystemNative fromNative = null;
		try
		{
			String _runtime_native[] = new String[]{ aNative };
			if( StringUtils.contains( aNative, "." ) ){ _runtime_native = StringUtils.wildcardArray( aNative, "." ); }
			if( _runtime_native.length <= 1 ){ _runtime_native = new String[]{ _runtime_native[0], "" }; }
			if( StringUtils.equals( _runtime_native[0], "$FUN" ) ){
				_runtime_native[1] = IConfigDefine.getINSTANCE().getConfigItem().getKERNEL();
			}
			else{
				ISystemTemplate.IImplCapital fromSystem;
				fromSystem = SystemUtils.ISystem.getSFUpfgkmCapital( _runtime_native[0] );
				_runtime_native[1] = fromSystem.getIMPLCLASS();
			}
			fromNative = ReflectUtils.getNative( Class.forName( _runtime_native[1] ) );
		}
		finally{
			
		}
		return fromNative;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月21日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
	     * 根据键值路径获取XPath逻辑表达式
	     * @param fromPath
	     * @return
	     */
		public static String[] getXPath( String fromPath ){
			String fromXPath[] = null;
			try
			{
				fromPath = IICustom._jj_xpath( fromPath ); 
				fromXPath = StringUtils.split(fromPath, "/");
			}
			finally{
				
			}
			return fromXPath;
		}
		
		/**
		 * 
		 * @param fromPath
		 * @return
		 * @throws Exception
		 */
		public static java.util.Queue _get_xpath( String fromPath ) throws Exception{
			java.util.Queue fromDeque = new ArrayDeque();
			StackDeque fromPeriod = new StackDeque();
			try
			{
				class QueueXPNode{
					private StringBuilder _id = new StringBuilder();
					private StringBuilder _node = new StringBuilder();
					private StringBuilder _param = new StringBuilder();
					public QueueXPNode(){
						super();
					}
					/**
					 * 
					 * @return
					 */
					public String getID(){
						return StringUtils.isBlank( _id.toString() )?null:_id.toString();
					}
					/**
					 * 
					 * @return
					 */
					public XPathNode getNODE(){
						XPathNode fromNode = null;
						try
						{
							fromNode = new XPathNode( _id.toString(), _node.toString() );
							if( _param.length() > 0 ){
								java.util.StringTokenizer _tokenizer = new java.util.StringTokenizer( _param.toString(), "&" );
							    while( _tokenizer.hasMoreTokens() ){
						            String token = _tokenizer.nextToken();
						            int eq = token.indexOf( "=" );
						            String name = (eq > -1) ? token.substring( 0, eq ) : token;
						            String value = (eq > -1) ? token.substring( eq + 1 ) : "";
						            fromNode.getParam().add( new XPathNodeEqual( name, value ) );
						        }
							}
						}
						finally{
							
						}
						return fromNode;
					}
				}
				int fromINDEX = 0;
				QueueXPNode fromQueue = new QueueXPNode();
				fromPath = IICustom._jj_xpath( fromPath );
				while( fromINDEX < fromPath.length() ){
					if( fromPath.charAt( fromINDEX ) == '/' ){
						if( fromQueue.getID() != null ){ fromDeque.add( fromQueue.getNODE() ); }
						fromQueue = new QueueXPNode();
					}
					else if( fromPath.charAt( fromINDEX ) == '[' ){
						fromQueue._node.append( fromPath.charAt( fromINDEX ) );
						fromINDEX += 1;
						fromPeriod.push( fromQueue );
						while( fromINDEX < fromPath.length() ){
							fromQueue._node.append( fromPath.charAt( fromINDEX ) );
							if( fromPath.charAt( fromINDEX ) == '[' ){
								throw new IllegalArgumentException( "arguments are required."  );
							}
							if( fromPath.charAt( fromINDEX ) == ']' ){
								fromPeriod.pop();
								break;
							}
							fromQueue._param.append( fromPath.charAt( fromINDEX ) );
							fromINDEX += 1;
						}
						if( fromPeriod.size() > 0 ){
							throw new IllegalArgumentException( "arguments are required."  );
						}
					}
					else{
						fromQueue._id.append( fromPath.charAt( fromINDEX ) );
						fromQueue._node.append( fromPath.charAt( fromINDEX ) );
					}
					fromINDEX += 1;
				}
				if( fromPeriod.size() > 0 ){
					throw new IllegalArgumentException( "arguments are required."  );
				}
				if( fromQueue != null && fromQueue.getID() != null ){ fromDeque.add( fromQueue.getNODE() ); }
			}
			finally{
				if( fromPeriod != null ){ fromPeriod.clear(); fromPeriod = null; }
			}
			return fromDeque;
		}
		
		/**
		 * 
		 * @param aKEY
		 * @param aOBJECT
		 * @param fromJEVAL
		 * @throws Exception
		 */
		public static void _gvp_complex(String aKEY, Object aOBJECT, java.util.Map fromJEVAL) throws Exception {
			try 
			{
				if( aOBJECT == null ){ 
					return; 
				}
				else if( ClassUtils.IClass.isPrimitive( aOBJECT.getClass() ) ){
					ICustom._gvp_primitive( aKEY, aOBJECT, fromJEVAL );
				}
				else if( ClassUtils.isAssignable( aOBJECT.getClass(), java.util.Map.class ) ){
					ICustom._gvp_map( aKEY, (java.util.Map)aOBJECT, fromJEVAL );
				}
				else if( ClassUtils.isAssignable( aOBJECT.getClass(), DataContainer.class)){
					ICustom._gvp_map( aKEY, ((DataContainer)aOBJECT).getProperties(), fromJEVAL );
				}
				else if( ClassUtils.isAssignable( aOBJECT.getClass(), net.sf.json.JSON.class)){
					ICustom._gvp_json( aKEY, (net.sf.json.JSON)aOBJECT, fromJEVAL );
				}
				else{
					ICustom._gvp_pojo( aKEY, aOBJECT, fromJEVAL );
				}
			} 
			finally {

			}
		}

		/**
		 * 
		 * @param aKEY
		 * @param aOBJECT
		 * @param fromJEVAL
		 * @throws Exception
		 */
		private static void _gvp_primitive(String aKEY, Object aOBJECT, java.util.Map fromJEVAL) throws Exception {
			try 
			{
				if( aOBJECT != null && StringUtils.isBlank( aOBJECT.toString() ) == false ) {
					fromJEVAL.put(aKEY, aOBJECT.toString());
				}
			} 
			finally {

			}
		}

		/**
		 * 
		 * @param aKEY
		 * @param aOBJECT
		 * @param fromJEVAL
		 * @throws Exception
		 */
		private static void _gvp_map(String aKEY, java.util.Map aOBJECT, java.util.Map fromJEVAL) throws Exception {
			try 
			{
				for( java.util.Iterator itera = aOBJECT.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					if (StringUtils.isBlank(aKEY)) {
						ICustom._gvp_complex(aEntry.getKey().toString(), aEntry.getValue(), fromJEVAL);
					} 
					else{
						String aINDEX = ClassUtils.getINDEX(new String[] { aKEY, ".", aEntry.getKey().toString() });
						ICustom._gvp_complex(aINDEX, aEntry.getValue(), fromJEVAL);
					}
				}
			} 
			finally {

			}
		}

		/**
		 * 
		 * @param aKEY
		 * @param aOBJECT
		 * @param fromJEVAL
		 * @throws Exception
		 */
		private static void _gvp_json(String aKEY, net.sf.json.JSON aOBJECT, java.util.Map fromJEVAL) throws Exception {
			try 
			{
				if( aOBJECT instanceof net.sf.json.JSONNull ) {
					ICustom._gvp_complex( aKEY, IUpdcConst.IEnum.ISschk.NULL, fromJEVAL);
				} 
				else if( aOBJECT instanceof net.sf.json.JSONObject ) {
					net.sf.json.JSONObject fromObject = (net.sf.json.JSONObject)aOBJECT;
					for( java.util.Iterator itera = fromObject.keys(); itera.hasNext(); ) {
						String fromKey = (String) itera.next();
						Object aJSONObject = fromObject.get(fromKey);
						if( StringUtils.isBlank( aKEY ) ) {
							ICustom._gvp_complex(fromKey, aJSONObject, fromJEVAL);
						} 
						else{
							String aINDEX = ClassUtils.getINDEX(new String[] { aKEY, ".", fromKey });
							ICustom._gvp_complex( aINDEX, aJSONObject, fromJEVAL );
						}
					}
				} 
				else if (aOBJECT instanceof net.sf.json.JSONArray) {
					fromJEVAL.put(aKEY, new java.util.ArrayList());
					net.sf.json.JSONArray fromArray = (net.sf.json.JSONArray) aOBJECT;
					for (int index = 0; index < fromArray.size(); index++) {
						java.util.HashMap _childer = new java.util.HashMap();
						Object fromObject = fromArray.get(index);
						ICustom._gvp_complex(null, fromObject, _childer);
						((java.util.List)fromJEVAL.get(aKEY)).add(_childer);
					}
				}
			} finally {

			}
		}

		/**
		 * 
		 * @param aKEY
		 * @param aOBJECT
		 * @param fromMap
		 * @throws Exception
		 */
		private static void _gvp_pojo(String aKEY, Object aOBJECT, java.util.Map fromMap) throws Exception {
			try 
			{
				IBeanWrapper aWapper = new IBeanWrapper( aOBJECT );
				java.beans.PropertyDescriptor aDescriptor[] = aWapper.getPropertyDescriptors();
				if( StringUtils.isBlank( aKEY ) == false ){ fromMap.put( aKEY, aOBJECT ); }
				for( int index = 0; aDescriptor != null && index < aDescriptor.length; index++ ) {
					try 
					{
						Object _objective = aWapper.getPropertyValue(aDescriptor[index].getName());
						if( StringUtils.isBlank( aKEY ) ) {
							ICustom._gvp_complex( aDescriptor[index].getName(), _objective, fromMap);
						} 
						else{
							String aINDEX = ClassUtils.getINDEX( new String[]{ aKEY, ".", aDescriptor[index].getName() });
							ICustom._gvp_complex(aINDEX, _objective, fromMap);
						}
					} 
					catch (java.lang.Exception t) {

					}
				}
			} 
			finally {

			}
		}

		/**
		 * 根据路径创建路径末端元素
		 * 
		 * @param aContainer
		 * @param aPath
		 * @param aCREATE
		 * @throws Exception
		 */
		private static void _gvs_complex(Object aContainer, String aPath, Object aCREATE) throws Exception {
			try 
			{
				Object aContext = aContainer;
				String aPackage[] = StringUtils.split(aPath, ".");
				for( int index = 0; aPackage != null && index < aPackage.length - 1; index++ ) {
					if( aContext instanceof com.ai.appframe2.bo.DataContainer ) {
						if( ( (com.ai.appframe2.bo.DataContainer)aContext).get(aPackage[index]) == null ){
							((com.ai.appframe2.bo.DataContainer)aContext).set(aPackage[index], Class.forName(aContext.getClass().getName()));
						}
						aContext = ((com.ai.appframe2.bo.DataContainer)aContext).get(aPackage[index]);
					} 
					else if( aContext instanceof java.util.Map ) {
						if( ((java.util.Map)aContext).get(aPackage[index]) == null ){
							((java.util.Map) aContext).put(aPackage[index], Class.forName( aContext.getClass().getName()) .newInstance());
						}
						aContext = ((java.util.Map)aContext).get(aPackage[index]);
					} 
					else{
						IBeanWrapper fromWrapper = new IBeanWrapper( aContext );
						aContext = fromWrapper.getPropertyValue(aPackage[index]);
						if (aContext == null){
							throw new java.lang.RuntimeException( "the path {" + aPath + "} not found in data cache path to meet conditions");
						}
					}
				}
				if( aContext instanceof com.ai.appframe2.bo.DataContainer ) {
					((com.ai.appframe2.bo.DataContainer) aContext).set( aPackage[aPackage.length - 1], aCREATE);
				} 
				else if( aContext instanceof java.util.Map ) {
					((java.util.Map) aContext).put( aPackage[aPackage.length - 1], aCREATE);
				} 
				else if ( aContext != null ){
					IBeanWrapper fromWrapper = new IBeanWrapper( aContext );
					fromWrapper.setPropertyValue( aPackage[aPackage.length - 1], aCREATE);
				}
			} 
			finally {

			}
		}

		/**
		 * 根据当前路径对象创建路径元素对象并返回末端元素
		 * @param aPath 对象路径
		 * @param aUpdgmcLife 数据容器
		 * @return
		 */
		private static Object _gvs_complex(String aPath, Object aContext) throws Exception {
			try 
			{
				String aPackage[] = StringUtils.split(aPath, ".");
				for( int index = 0; aPackage != null && index < aPackage.length; index++) {
					if (aContext instanceof com.ai.appframe2.bo.DataContainer) {
						if (((com.ai.appframe2.bo.DataContainer) aContext).get(aPackage[index]) == null){
							((com.ai.appframe2.bo.DataContainer) aContext).set(aPackage[index], Class.forName(aContext.getClass().getName()));
						}
						aContext = ((com.ai.appframe2.bo.DataContainer)aContext).get(aPackage[index]);
					} 
					else if( aContext instanceof java.util.Map) {
						if (((java.util.Map) aContext).get(aPackage[index]) == null){
							((java.util.Map) aContext).put(aPackage[index], Class.forName( aContext.getClass().getName()).newInstance());
						}
						aContext = ((java.util.Map) aContext).get(aPackage[index]);
					} 
					else {
						IBeanWrapper fromWrapper = new IBeanWrapper( aContext );
						aContext = fromWrapper.getPropertyValue(aPackage[index]);
						if (aContext == null){
							throw new java.lang.RuntimeException( "the path {" + aPath + "} not found in data cache path to meet conditions");
						}
					}
				}
			} 
			finally {

			}
			return aContext;
		}

		/**
		 * 
		 * @param aOBJECT
		 * @param aTYPE
		 * @return
		 * @throws Exception
		 */
		public static Object _gwc_timestamp(Object aOBJECT, Class aTYPE) throws Exception {
			try 
			{
				if (aOBJECT instanceof java.lang.Long){
					return new java.sql.Timestamp(((Long) aOBJECT).longValue());
				}
				else if (aOBJECT instanceof java.sql.Timestamp){
					return (java.sql.Timestamp) aOBJECT;
				}
				else if (aOBJECT instanceof java.sql.Date){
					return new java.sql.Timestamp(((java.sql.Date) aOBJECT).getTime());
				}
				else if (aOBJECT instanceof java.util.Date){
					return new java.sql.Timestamp(((java.util.Date) aOBJECT).getTime());
				}
				else if (aOBJECT instanceof java.lang.String){
					if( StringUtils.contains( (String)aOBJECT, "-" ) ){
						return TimeUtils.format( aOBJECT.toString().trim().length() <= 10 ?aOBJECT
												.toString() + " 00:00:00" : aOBJECT.toString(),
										"yyyy-MM-dd HH:mm:ss");
					}
					else{
						return TimeUtils.format( aOBJECT.toString().trim().length() <= 10 ?aOBJECT
								.toString() + "000000" : aOBJECT.toString(),
						         "yyyyMMddHHmmss");
					}
				}
					
			} 
			finally {

			}
			return aOBJECT;
		}

		/**
		 * 
		 * @param aOBJECT
		 * @param aTYPE
		 * @return
		 * @throws Exception
		 */
		public static Object _gwc_map(java.util.Map aOBJECT, Class aTYPE) throws Exception {
			java.util.Map fromObject = null;
			try 
			{
				fromObject = (java.util.Map)IReflect.invokeConstructor( aTYPE, new Object[]{} );
				fromObject.putAll(aOBJECT);
			} 
			finally{

			}
			return fromObject;
		}

		/**
		 * 
		 * @param aOBJECT
		 * @param aTYPE
		 * @return
		 * @throws Exception
		 */
		public static Object _gwc_list(java.util.List aOBJECT, Class aTYPE) throws Exception {
			java.util.List fromObject = null;
			try
			{
				fromObject = (java.util.List)IReflect.invokeConstructor( aTYPE, new Object[]{} );
				ClassUtils.IMerge.merge(aOBJECT, fromObject);
			} 
			finally{

			}
			return fromObject;
		}

		/**
		 * 
		 * @param fromNode
		 * @param fromContext
		 * @return
		 * @throws Exception
		 */
		private static Object _get_container(XPathNode fromNode, Object fromContext) throws Exception {
			Object fromXPath = null;
			try 
			{
				DataContainer fromEntity = (DataContainer)fromContext;
				if( fromNode.getParam() != null && fromNode.getParam().size() > 0 ){
					throw new IllegalArgumentException( fromNode.getId() + " arguments are empty."  );
				}
				fromXPath = fromEntity.get( fromNode.getId() );
			} 
			finally{

			}
			return fromXPath;
		}

		/**
		 * 
		 * @param fromNode
		 * @param fromContext
		 * @return
		 * @throws Exception
		 */
		private static Object _get_hqsql(XPathNode fromNode, Object fromContext) throws Exception {
			Object fromXPath = null;
			try 
			{
				HQSQLEntityBean fromEntity = (HQSQLEntityBean)fromContext;
				if( fromNode.getParam() != null && fromNode.getParam().size() > 0 ){
					throw new IllegalArgumentException( fromNode.getId() + " arguments are empty."  );
				}
				fromXPath = fromEntity.get( fromNode.getId() );
			} 
			finally{

			}
			return fromXPath;
		}
		
		/**
		 * 
		 * @param fromNode
		 * @param fromContext
		 * @return
		 * @throws Exception
		 */
		private static Object _get_map(XPathNode fromNode, Object fromContext) throws Exception {
			Object fromXPath = null;
			try 
			{
				java.util.Map fromEntity = (java.util.Map)fromContext;
				if( fromNode.isPattern() && fromEntity.keySet().size() > 0 ){
					Object fromKEY = fromEntity.keySet().iterator().next();
					fromXPath = fromKEY != null ? fromEntity.get( fromKEY ) : null;
				}
				else if( fromNode.isPattern() == false ){
					fromXPath = fromEntity.get( fromNode.getId() );
					if( fromXPath != null && fromNode.getParam() != null && 
							fromNode.getParam().size() > 0 ){
						fromXPath = IICustom._jj_complex( fromNode, fromXPath );
					}
				}
			} 
			finally{

			}
			return fromXPath;
		}

		/**
		 * 
		 * @param fromNode
		 * @param fromContext
		 * @return
		 * @throws Exception
		 */
		private static Object _get_jdomxml( XPathNode fromNode, Object fromContext) throws Exception {
			Object fromXPath = null;
			org.dom4j.Element fromRoot = null;
			java.util.List fromNodes = null;
			try 
			{
				fromRoot = XmlUtils.parseXml((String) fromContext);
				org.dom4j.Node fromElement = null;
				fromNodes = fromRoot.selectNodes( fromNode.getNode() );
				if (fromNodes != null && fromNodes.size() > 0) {
					if (fromNodes.size() > 1){
						ExceptionFactory.throwIllegal("IOS0011073",
								new String[] { fromNode.getId() });
					}
					fromElement = (org.dom4j.Node) fromNodes.get(fromNodes.size() - 1);
					fromXPath = XmlUtils.IXml._wrap( fromElement );
				}
			} 
			finally {
				if( fromNodes != null){ fromNodes.clear(); fromNodes = null; }
				if( fromRoot != null ){ fromRoot = null; }
			}
			return fromXPath;
		}
		/**
		 * 
		 * @param fromNode
		 * @param fromContext
		 * @return
		 * @throws Exception
		 */
		private static Object _get_jsonobject(XPathNode fromNode, Object fromContext) throws Exception {
			Object fromXPath = null;
			try 
			{
				net.sf.json.JSONObject fromEntity = null;
				if( ClassUtils.IClass.isJSONNull( fromContext) ){
					fromXPath = null;
				}
				else if( ClassUtils.IClass.isJSONArray( fromContext ) ){
					ExceptionFactory.throwIllegal("IOS0011073", new String[] { fromNode.getId() });
				}
				else if( ClassUtils.IClass.isJSONObject( fromContext ) ){
					fromEntity = (net.sf.json.JSONObject)fromContext;
					if( fromNode.isPattern() && fromEntity.keys() != null && fromEntity.keys().hasNext() ){
						String fromKEY = (String)fromEntity.keys().next();
						fromXPath = fromEntity.get( fromKEY );
					}
					else if( fromNode.isPattern() == false ){
						fromXPath = fromEntity.has( fromNode.getId() )?fromEntity.get( fromNode.getId() ) : null;
						if( fromXPath != null && fromNode.getParam() != null && 
								fromNode.getParam().size() > 0 ){
							fromXPath = IICustom._jj_complex( fromNode, fromXPath );
						}
					}
				}
			} 
			finally {

			}
			return fromXPath;
		}
		
		/**
		 * 
		 * @param fromNode
		 * @param fromContext
		 * @return
		 * @throws Exception
		 */
		private static Object _get_javabean(XPathNode fromNode, Object fromContext) throws Exception {
			Object fromXPath = null;
			try 
			{
				IBeanWrapper fromWrapper = new IBeanWrapper(fromContext);
				if( fromWrapper.isReadableProperty( fromNode.getId() ) == false ){
					throw new IllegalArgumentException( fromWrapper.getCLASS().getName() + 
							" unknown property '"+ fromNode.getId() +"'" );
				}
				fromXPath = fromWrapper.getPropertyValue( fromNode.getId() );
				if( fromXPath != null && fromNode.getParam().size() > 0 ){
					fromXPath = IICustom._jj_complex( fromNode, fromXPath );
				}
			} 
			finally {

			}
			return fromXPath;
		}
		public static class IICustom{
			public IICustom(){
				super();
			}
			/**
			 * 
			 * @param fromPath
			 * @return
			 */
			public static String _jj_xpath( String fromPath ){
				try
				{
					if( StringUtils.contains( fromPath, "." ) ) {
						fromPath = StringUtils.replace( fromPath, ".", "/" );
					}
					else if( StringUtils.contains( fromPath, "\\" ) ){
						fromPath = StringUtils.replace( fromPath, "\\", "/" );
					}
				}
				finally{
					
				}
				return fromPath;
			}
			
			/**
			 * 根据形参列表相同下返回当前对象
			 * @param fromNode 节点规范
			 * @param fromParam 形参列表
			 * @param fromContext 当前对象
			 * @return
			 * @throws Exception
			 */
			private static Object _jj_complex_equal( XPathNode fromNode, java.util.ArrayList fromParam, Object fromContext ) throws Exception {
				boolean fromBool = true;
				IBeanWrapper fromWrapper = null;
				try
				{
					fromWrapper = new IBeanWrapper( fromContext );
					for( java.util.Iterator itera = fromNode.getParam().iterator(); itera.hasNext(); ){
						XPathNodeEqual fromXPath = (XPathNodeEqual)itera.next();
						Object fromLeft = IICustom._jj_complex_equal(fromNode, 
								fromWrapper, 
								fromXPath._left );
						fromBool &= IICustom._jj_equal(fromNode, 
								fromXPath._right, 
								fromLeft);
						if( fromBool == false ){ break; }
					}
				}
				finally{
					if( fromWrapper != null ){ fromWrapper = null; }
				}
				return fromBool == true?fromContext:null;
			}
			
			/**
			 * 根据节点参数获取当前对象列表中元素
			 * @param fromNode
			 * @param fromContext
			 * @return
			 * @throws Exception
			 */
			private static Object _jj_complex( XPathNode fromNode, Object fromContext ) throws Exception {
				Object fromXPath = null;
				try
				{
					if( fromContext == null ){ 
						fromXPath = null; 
					}
					else if( fromNode.getParam() == null || fromNode.getParam().size() <= 0 ){
						fromXPath = fromContext;
					}
					else if( ClassUtils.IClass.isArray( fromContext ) ){
						Object fromArray[]= (Object[])fromContext;
						for( int fromINDEX = 0; fromINDEX < fromArray.length; fromINDEX++ ){
							fromXPath = IICustom._jj_complex_equal(fromNode, 
									fromNode.getParam(), 
									fromArray[ fromINDEX ] );
							if( fromXPath != null ){ break; }
						}
					}
					else if( ClassUtils.IClass.isList( fromContext ) ){
						java.util.List fromList = (java.util.List)fromContext;
						for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
							fromXPath = IICustom._jj_complex_equal(fromNode, 
									fromNode.getParam(), 
									itera.next() );
							if( fromXPath != null ){ break; }
						}
					}
					else if( ClassUtils.IClass.isJSONArray( fromContext ) ){
						net.sf.json.JSONArray fromArray = (net.sf.json.JSONArray)fromContext;
						for( int fromINDEX = 0; fromArray != null && fromINDEX < fromArray.size(); fromINDEX++ ){
							fromXPath = IICustom._jj_complex_equal(fromNode, 
									fromNode.getParam(), 
									fromArray.get( fromINDEX ) );
							if( fromXPath != null ){ break; }
						}
					}
					else{
						fromXPath = IICustom._jj_complex_equal(fromNode, 
								fromNode.getParam(), 
								fromContext );
					}
				}
				finally{
					
				}
				return fromXPath;
			}
			/**
			 * 根据键值获取当前对象中属性值
			 * @param fromNode
			 * @param fromLeft
			 * @return
			 * @throws Exception
			 */
			private static Object _jj_complex_equal( XPathNode fromNode, IBeanWrapper fromWrapper, String fromLeft ) throws Exception{
				Object fromEntity = null;
				try
				{
					Object _context = fromWrapper.getObject();
					if( ClassUtils.IClass.isMap( _context ) ){
						java.util.Map fromMap = (java.util.Map)_context;
						fromEntity = fromMap.get( fromLeft );
					}
					else if( ClassUtils.IClass.isContainer( _context ) ){
						fromEntity = ((DataContainer)_context).get( fromLeft );
					}
					else if( ClassUtils.IClass.isMYSQL5( _context ) ){
						fromEntity = ((HQSQLEntityBean)_context).get( fromLeft );
					}
					else if( ClassUtils.IClass.isJSONObject( _context ) ){
						net.sf.json.JSONObject fromJSON = (net.sf.json.JSONObject)_context;
						if( fromJSON.has( fromLeft ) ) fromEntity = fromJSON.get( fromLeft );
					}
					else/*POJO*/{
						if( fromWrapper.isReadableProperty( fromLeft ) == false ){
							throw new IllegalArgumentException( fromNode.getId() + 
									" unknown property '"+ fromLeft +"'" );
						}
						fromEntity = fromWrapper.getPropertyValue( fromLeft );
					}
				}
				finally{
					
				}
				return fromEntity;
			}
			/**
			 * 
			 * @param fromNode
			 * @param fromRight
			 * @param fromLeft
			 * @return
			 * @throws Exception
			 */
			public static boolean _jj_equal(XPathNode fromNode, String fromRight, Object fromLeft ) throws Exception{
				try
				{
					if( fromLeft == null /*如为空则判断fromEqual是否为NULL*/){ 
						return ClassUtils.IClass.isNULL( fromRight ); 
					}
					else if( ClassUtils.IClass.isNULL( fromRight) /*如fromEqual为NULL则判断是否为空*/){
						return false; 
					}
					else if( StringUtils.equals( fromRight, "*" )/*如为通配则不判断值情况*/ ){ 
						return true; 
					}
					else{
						return StringUtils.equals( fromLeft.toString(), fromRight );
					}
				}
				finally{
					
				}
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月21日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IReflect {
		public IReflect() {
			super();
		}
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		public static Class getCLASS( String aClassName ) throws Exception{
			Class fromCLASS = null;
			try
			{
				fromCLASS = (Class)_runtime_class.get( aClassName );
				if( fromCLASS == null ){
					synchronized ( _runtime_class ) {
						fromCLASS = (Class)_runtime_class.get( aClassName );
						if( fromCLASS == null ){
							_runtime_class.put( aClassName, fromCLASS = Class.forName( aClassName ) );
						}
					}
				}
			}
			finally{
				
			}
			return fromCLASS;
		}
		/**
		 * 
		 * @param fromClass
		 * @param fromList
		 * @throws Exception
		 */
		public static void loadFields(Class fromClass, java.util.List fromList) throws Exception {
			try 
			{
				if (fromClass == null) return;
				java.lang.reflect.Field[] aField = fromClass.getDeclaredFields();
				for (int index = 0; index < aField.length; index++) {
					if (java.lang.reflect.Modifier.isStatic(aField[index].getModifiers())){
						continue;
					}
					fromList.add(aField[index]);
				}
				loadFields(fromClass.getSuperclass(), fromList);
			} 
			finally{

			}
		}

		/**
		 * 
		 * @param fromClass
		 * @param MethodName
		 * @param parameterTypes
		 * @return
		 * @throws Exception
		 */
		public static java.lang.reflect.Method getMethod(Class fromClass, String MethodName, Class parameterTypes[]) throws Exception {
			java.lang.reflect.Method fromMethod = null;
			try
			{
				ISystemTemplate.ISystemNative __native__ = ReflectUtils.getNative( fromClass );
				fromMethod = __native__.getMethod( MethodName, parameterTypes );
			} 
			finally{

			}
			return fromMethod;
		}
		
		/**
		 * 获取当前对应方法
		 * @param className
		 * @param methodName
		 * @param parameterTypes
		 * @return
		 * @throws Exception
		 */
		public static java.lang.reflect.Method getMethod(String className, String methodName, Class parameterTypes[]) throws Exception {
			java.lang.reflect.Method fromMethod = null;
			try
			{
				java.lang.Class __clazz__ = IReflect.getCLASS( className );
				fromMethod = IReflect.getMethod( __clazz__, methodName, parameterTypes );
			}
			finally{
				
			}
			return fromMethod;
		}
		
		/**
		 * 获取参数列表对应构造函数,如不存在返回空对象
		 * @param aCLASS 指定类
		 * @param parameterTypes 参数列表
		 * @return
		 */
		public static java.lang.reflect.Constructor getConstructor( Class aCLASS, Class parameterTypes[] ){
			java.lang.reflect.Constructor aConstructor = null;
			try
			{
				ISystemTemplate.ISystemNative _runtime_native  = ReflectUtils.getNative( aCLASS );
				aConstructor = _runtime_native.getConstructor( parameterTypes );
			}
			finally{
				
			}
			return aConstructor;
		}
		
		/**
		 * 
		 * @param instance
		 * @param MethodName
		 * @param Argv
		 * @return
		 * @throws Exception
		 */
		public static Object invokeMethod(Object instance, String methodName, Object parameter) throws Exception {
			java.lang.Object[] _parameter_ = new java.lang.Object[]{ parameter };
			return IReflect.invokeMethod( instance, methodName, _parameter_ );
		}
		
		/**
		 * 
		 * @param instance
		 * @param methodName
		 * @param parameter
		 * @return
		 * @throws Exception
		 */
		public static Object invokeMethod(Object instance, String methodName, Object parameter[]) throws Exception {
			if( parameter == null ){ parameter = _emptyObjectArray_; }
			java.lang.Class[] _parameterTypes_ = new java.lang.Class[ parameter.length ];
			for( int index = 0; index < parameter.length; index++ ){
				_parameterTypes_[index] = parameter[index] != null?parameter[index].getClass():null;
			}
			return IReflect.invokeMethod(instance, methodName, parameter, _parameterTypes_);
		}

		/**
		 * 
		 * @param instance
		 * @param methodName
		 * @param parameter
		 * @param parameterTypes
		 * @return
		 * @throws Exception
		 */
		public static Object invokeMethod(Object instance, String methodName, Object parameter[], Class parameterTypes[]) throws Exception {
			Object _objective = null;
			try 
			{
				if( parameterTypes == null ){ parameterTypes = _emptyClassArray_; }
				if( parameter == null ){ parameter = _emptyObjectArray_; }
				java.lang.reflect.Method __method__  = IReflect.getMethod( instance.getClass(), methodName, parameterTypes );
				if( __method__ == null ){
					throw new NoSuchMethodException( "No such accessible method: " + methodName + "() on object: " + instance.getClass().getName() );
				}
				_objective = __method__.invoke( instance, parameter );
			} 
			catch (InvocationTargetException exception) {
				java.lang.Exception _exception = ExceptionFactory.getException( exception );
				throw _exception;
			} 
			catch (Exception exception) {
				throw exception;
			}
			return _objective;
		}

		/**
		 * 基于JEVAL表达式调用本地服务
		 * @param method
		 * @param arguments
		 * @param variable
		 * @return
		 * @throws Exception
		 */
		public static Object invokeLmic( String method, String arguments[], java.util.Map variable) throws Exception{
			Object _objective = null;
			try
			{
				Object fromPARAM[] = new Object[ arguments.length ];
				for( int index = 0; arguments != null && index < arguments.length; index++ ){
					fromPARAM[index] = arguments[index];
					if( fromPARAM[index] != null && StringUtils.startWith(arguments[index], "$" ) ){
						if( StringUtils.equals( arguments[index], "$PARAM" ) ){
							fromPARAM[index] = (java.util.Map)variable.get( IUpdcConst.IUpdbm.IUpdbf.PARAM );
						}
						else if( StringUtils.equals( arguments[index], "$LDAP" ) ){
							fromPARAM[index] = (java.util.Map)variable.get( IUpdcConst.IUpdbm.IUpdbf.LDPAP );
						}
						else{
							fromPARAM[index] = UpfgsmUtils.IUpfsm.IIUpfsm._jj_variable( method, 
									method, 
									(java.util.Map)variable.get( IUpdcConst.IUpdbm.IUpdbf.PARAM ), 
									arguments[index], 
									(IUpdcContext)variable.get( IUpdcConst.IUpdbm.IUpdbf.LDPAP ));
						}
					}
				}
				_objective = IReflect.invokeCompatible( method, arguments );
			}
			finally{
			
			}
			return _objective;
		}
		
		/**
		 * 根据CSF服务编码调用远程CSF服务方法
		 * @param _objective 调用对象
		 * @param _servicecode 服务方法
		 * @param arguments 调用参数
		 * @param fromUpffmx 调用适配
		 * @return
		 * @throws Exception
		 */
		public static Object invokeCallCsf( Object _objective, String _servicecode,  Object arguments[], IPlatformTemplate.IUpffmOffer fromUpffmx ) throws Exception{
			Object _compatible = null;
			try
			{
				Object _arguments_[] = new Object[ 1 + ( arguments != null?arguments.length:0 ) ];
				_arguments_[0] = _servicecode;
				for( int index = 0; arguments != null && index < arguments.length; index++ ){
					_arguments_[ index + 1 ] = arguments[index];
				}
				_compatible = CsfServiceCaller.call( _arguments_ );
			}
			catch( CsfException exception ){
				SFException aEXCEPTION = ExceptionFactory.getException( fromUpffmx.getID(), exception );
				throw aEXCEPTION;
			}
			catch( java.lang.Exception exception ){
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return _compatible;
		}
		
		/**
		 * 根据本地类调用编码调用本地类方法
		 * @param _native  本地类编码,格式为$FUN(采用系统内部类).#[方法名]或本地类编码[采用类资产库].#[方法名]
		 * @param arguments
		 * @return
		 * @throws Exception
		 */
		public static Object invokeCompatible( String _native, Object arguments[] ) throws Exception{
			Object _objective = null;
			try
			{
				String _runtime_native[] = StringUtils.wildcardArray( _native, "." );
				if( _runtime_native == null || _runtime_native.length != 2 ){
					throw new IllegalArgumentException( "expression <" + _native + "> format $FUN.#{Method} or #{LIBRARY.ID}.#{Method}." );
				}
				ISystemTemplate.ISystemNative fromNative = ReflectUtils.getNative( _runtime_native[0] );
				java.lang.reflect.Method fromMethod = fromNative.getMethod( _runtime_native[1], arguments );
				if( fromMethod == null ){
					throw new NoSuchMethodException( "expression <" + _native + 
							"> No such accessible method <" + _runtime_native[1] + 
							"> on object " + fromNative.getType().getName() + "." );
				}
				for( int index = 0; index < fromMethod.getParameterTypes().length; index++ ){
					if( arguments[index] == null ) continue;
					arguments[index] = ClassUtils.IClass.transfer( arguments[index], 
							fromMethod.getParameterTypes()[index] );
				}
				Object fromKernelImpl = ClassUtils.getSingleton( fromMethod.getDeclaringClass().getName() );
				_objective = fromMethod.invoke( fromKernelImpl, arguments );
			}
			finally{
				
			}
			return _objective;
		}
		
		/**
		 * 
		 * @param fromClass
		 * @param MethodName
		 * @param parameter
		 * @param parameterTypes
		 * @return
		 * @throws Exception
		 */
		public static Object invokeStaticMethod(Class fromClass, String MethodName, Object parameter[], Class parameterTypes[]) throws Exception {
			Object _objective = null;
			try 
			{
				java.lang.reflect.Method method = fromClass.getMethod( MethodName, parameterTypes);
				_objective = method.invoke(fromClass, parameter);
			} 
			catch (InvocationTargetException exception) {
				ExceptionFactory.throwPrimitive( exception );
			} 
			catch (Exception exception) {
				throw exception;
			}
			return _objective;
		}

		/**
		 * 
		 * @param _objective
		 * @return
		 * @throws Exception
		 */
		public static Object invokeConstructor( Object _objective ) throws Exception {
			Object _compatible = _objective;
			java.lang.Class _descriptor = _compatible != null?_compatible.getClass():null;
			if( _compatible != null && _descriptor != null ){
				java.lang.reflect.Constructor _constructor = IReflect.getConstructor( _descriptor, new Class[]{ _descriptor } );
				if( _constructor != null ){
					_compatible = _constructor.newInstance( new Object[]{ _compatible } );
				}
				else if( _compatible instanceof java.io.Serializable ){
					byte[] fromByte = MathUtils.IMath.object2byte( _compatible );
					_compatible = MathUtils.IMath.byte2object( fromByte );
				}
				else{
					_compatible = IReflect.invokeConstructor( _descriptor, new Object[]{} );
				}
			}
			return _compatible;
		}
        
		/**
		 * 
		 * @param _descriptor
		 * @param arguments
		 * @return
		 * @throws Exception
		 */
		public static Object invokeConstructor(Class _descriptor, Object arguments) throws Exception {
			Object compatible = null;
			try
			{
				java.lang.Object[] _arguments_ = new java.lang.Object[]{ arguments };
				compatible = IReflect.invokeConstructor( _descriptor, _arguments_ );
			}
			finally{
				
			}
			return compatible;
		}
		
		/**
		 * 
		 * @param _descriptor
		 * @param arguments
		 * @return
		 * @throws Exception
		 */
		public static Object invokeConstructor( Class _descriptor, Object arguments[] ) throws Exception{
			Object compatible = null;
			try
			{
				if( arguments == null ){ arguments = _emptyObjectArray_; }
				java.lang.Class[] _parametertypes_ = new java.lang.Class[ arguments.length ];
				for( int index = 0; arguments != null && index < arguments.length; index++ ){
					_parametertypes_[index] = arguments[index] != null?arguments[index].getClass():null;
				}
				compatible = IReflect.invokeConstructor( _descriptor, arguments, _parametertypes_ );
			}
			finally{
				
			}
			return compatible;
		}
		
		/**
		 * 
		 * @param _descriptor
		 * @param arguments
		 * @param parameterTypes
		 * @return
		 * @throws Exception
		 */
		public static Object invokeConstructor( Class _descriptor, Object arguments[], Class parameterTypes[] ) throws Exception{
			Object compatible = null;
			try
			{
				if( arguments == null ){ arguments = _emptyObjectArray_; }
				if( parameterTypes == null ){ parameterTypes = _emptyClassArray_; }
				java.lang.reflect.Constructor _constructor = IReflect.getConstructor( _descriptor, parameterTypes );
				if( _constructor == null ){
					throw new NoSuchMethodException("No such accessible constructor on object: " + _descriptor.getName());
				}
				compatible = _constructor.newInstance( arguments );
			}
			finally{
				
			}
			return compatible;
		}
		
	}
	
	public static class XPathNode {
		private String id;
		private String node;
		private java.util.ArrayList param = new java.util.ArrayList();
		public XPathNode( ){
			super();
		}
		
		public XPathNode( String _id, String _node ){
			super();
			id   = _id  ;
			node = _node;
		}
		
		/**
		 * @return the id
		 */
		public String getId() {
			return id != null && StringUtils.isBlank( id ) == false?id:null;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the node
		 */
		public String getNode() {
			return node;
		}

		/**
		 * @param node the node to set
		 */
		public void setNode(String node) {
			this.node = node;
		}

		/**
		 * @return the param
		 */
		public java.util.ArrayList getParam() {
			return param;
		}
		
		/**
		 * 节点为通配符
		 * @return
		 */
		public boolean isPattern(){
			return id != null && StringUtils.isBlank( id ) == false && 
					StringUtils.equals( id, "*" );
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isEmpty(){
			return id != null && StringUtils.isBlank( id );
		}
	}
	
	public static class XPathNodeEqual{
		private String _left;
		private String _right;
		private XPathNodeEqual(){
			super();
		}
		
		private XPathNodeEqual( String left, String right ){
			super();
			_left  = left ;
			_right = right;
		}
		
		/**
		 * @return the left
		 */
		public String getLeft() {
			return _left;
		}
		
		/**
		 * @param left the left to set
		 */
		public void setLeft(String left) {
			_left = left;
		}
		
		/**
		 * @return the right
		 */
		public String getRight() {
			return _right;
		}
		
		/**
		 * @param right the right to set
		 */
		public void setRight(String right) {
			_right = right;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			StringBuilder fromXML = new StringBuilder();
			fromXML.append("[").append( _left ).append("=")
			                   .append( _right )
			       .append("]");
			return fromXML.toString();
		}
		
	}
	
}
