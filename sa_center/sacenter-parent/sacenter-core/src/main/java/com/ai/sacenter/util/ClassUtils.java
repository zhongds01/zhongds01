package com.ai.sacenter.util;

import java.lang.reflect.Array;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdcContextImpl;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.util.ReflectUtils.IReflect;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-2-17</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class ClassUtils extends org.apache.commons.lang.ClassUtils {
	private static final Logger log = Logger.getLogger(ClassUtils.class);
	private static java.util.Map _runtime_singleton = new java.util.concurrent.ConcurrentHashMap();
	public ClassUtils() {
		super();
	}

	/**
	 * 统一索引号
	 * 
	 * @param aINDEX
	 * @return
	 */
	public static String getINDEX(String aINDEX) {
		try 
		{
			aINDEX = StringUtils.filling(aINDEX, 15, StringUtils.RIGHT, '0');
		} 
		finally {

		}
		return aINDEX;
	}

	/**
	 * 构造内存变量索引编码
	 * 
	 * @param aPIDX
	 * @return
	 */
	public static String getINDEX(String aPIDX[]) {
		String aOBJECT = null;
		StringBuilder aINDEX = new StringBuilder();
		try 
		{
			for (int index = 0; index < aPIDX.length; index++) {
				if (aPIDX[index] == null) continue;
				aINDEX.append(aPIDX[index]);
			}
			if (aINDEX.length() > 0) aOBJECT = aINDEX.toString();
		} 
		finally {
			if (aINDEX != null) { aINDEX = null; }
		}
		return aOBJECT;
	}

	/**
	 * 构造内存变量索引编码
	 * 
	 * @param aPREF
	 * @param aPIDX
	 * @return
	 */
	public static String getINDEX(String aPREF, String aPIDX[]) {
		String aOBJECT = null;
		StringBuilder aINDEX = new StringBuilder();
		try 
		{
			if (StringUtils.isBlank(aPREF) == false) aINDEX.append(aPREF);
			for( int index = 0; index < aPIDX.length; index++) {
				if (aPIDX[index] == null) continue;
				if (StringUtils.startWith(aPIDX[index], "#[")) {
					String aJEXP[] = StringUtils.substring(aPIDX[index], "#[", "]");
					if (aINDEX.length() > 0) aINDEX.append(".");
					aINDEX.append(aJEXP[0]);
				} else {
					if (aINDEX.length() > 0) aINDEX.append(".");
					aINDEX.append(aPIDX[index]);
				}
			}
			if (aINDEX.length() > 0) aOBJECT = aINDEX.toString();
		} 
		finally {
			if (aINDEX != null) { aINDEX = null; }
		}
		return aOBJECT;
	}

	/**
	 * 构造内存变量索引编码
	 * 
	 * @param aPREF
	 * @param aPIDX
	 * @param aConatiner
	 * @return
	 */
	public static String getINDEX(String aPREF, String aPIDX[],
			DataStructInterface aConatiner) {
		String aOBJECT = null;
		StringBuilder aINDEX = new StringBuilder();
		try 
		{
			if (StringUtils.isBlank(aPREF) == false) aINDEX.append(aPREF);
			for (int index = 0; index < aPIDX.length; index++) {
				if (aPIDX[index] == null) continue;
				if (StringUtils.startWith(aPIDX[index], "#[")) {
					String aJEXP[] = StringUtils.substring(aPIDX[index], "#[", "]");
					if (aINDEX.length() > 0) aINDEX.append(".");
					aINDEX.append(aJEXP[0]);
				} 
				else if (aConatiner.get(aPIDX[index]) != null) {
					if (aINDEX.length() > 0) aINDEX.append(".");
					aINDEX.append(aConatiner.get(aPIDX[index]).toString());
				}
			}
			if (aINDEX.length() > 0) aOBJECT = aINDEX.toString();
		} finally {
			if (aINDEX != null) { aINDEX = null; }
		}
		return aOBJECT;
	}
	/**
	 * 构造接口框架上下文
	 * 
	 * @return
	 */
	public static IUpdcContext getIContextImpl() {
		return new IUpdcContextImpl();
	}

	/**
	 * 
	 * @param aVariableXml
	 * @return
	 */
	public static IUpdcContext getIContextImpl(String aVariableXml) {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		try {
			if (StringUtils.isBlank(aVariableXml) == false) {
				if (IClass.isXML(aVariableXml)) {
					XmlUtils.XPath(aVariableXml, aContext);
				} else {
					JdomUtils.ICustom.wrap(aVariableXml, aContext);
				}
			}
		} 
		finally {

		}
		return aContext;
	}

	/**
	 * 
	 * @param aContext
	 * @return
	 */
	public static IUpdcContext getIContextImpl(IUpdcContext aContext) {
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl();
		fromLDAP.putAll(aContext);
		return fromLDAP;
	}

	/**
	 * 
	 * @param aContext
	 * @param fromXML
	 * @return
	 */
	public static IUpdcContext getIContextImpl(IUpdcContext aContext, Object[][] fromXML ){
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		for(int index = 0; fromXML != null && index < fromXML.length; index++ ){
			if( fromXML[index][0] != null && fromXML[index][1] != null ){
				fromLDAP.put( fromXML[index][0], fromXML[index][1] );
			}
		}
		return fromLDAP;
	}
	
	/**
	 * 
	 * @param fromXML
	 * @return
	 */
	public static IUpdcContext getIContextImpl(java.util.Map fromXML) {
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		if (fromXML != null && fromXML.size() > 0) {
			for (java.util.Iterator itera = fromXML.entrySet().iterator(); itera.hasNext();) {
				java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
				if (StringUtils.startWith(fromEntry.getKey().toString(), "PLATFORM$" ) && fromEntry.getValue() != null){
					aContext.put(fromEntry.getKey(), fromEntry.getValue());
				}
			}
		}
		return aContext;
	}
	
	/**
	 * 根据类名构造类对象适配器
	 * 
	 * @param aIMPLCLASS
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static Object getSingleton(String aIMPLCLASS) throws SFException, Exception {
		Object fromImpl = null;
		try 
		{
			if( StringUtils.isBlank( aIMPLCLASS ) == false ){
				if( (fromImpl = _runtime_singleton.get( aIMPLCLASS ) ) == null ){
					synchronized( _runtime_singleton ){
						if( (fromImpl = _runtime_singleton.get( aIMPLCLASS ) ) == null ){
							_runtime_singleton.put( aIMPLCLASS, fromImpl = Class.forName( aIMPLCLASS ).newInstance() );
						}
					}
				}
			}
		} 
		finally {

		}
		return fromImpl;
	}

	public static class IClass {
		public IClass() {
			super();
		}

		/**
		 * 
		 * @param aLog4j
		 */
		public static void environ(String aLog4j) {
			try 
			{
				java.io.InputStream fromIN = IClass.getClassLoaderResource(aLog4j);
				if (fromIN == null) return;
				java.util.Properties properties = new java.util.Properties();
				properties.load( fromIN );
				PropertyConfigurator.configure( properties );
			} 
			catch (java.lang.Exception tt) {
				log.error("initialize log4j error", tt);
			}
		}

		/**
		 * 浅度克隆(改变非基本类型时,原对象的值不变)
		 * @param fromObject
		 * @return
		 * @throws Exception
		 */
		public static Object shallowDesign(Object fromObject) throws Exception {
			Object toObject = null;
			try 
			{
				if (fromObject != null) {
					Class fromCLASS = fromObject.getClass();
					if (fromObject instanceof java.lang.Cloneable) {
						toObject = ReflectUtils.IReflect.invokeMethod(fromObject, "clone",
								new Object[] {}, new Class[] {});
					} else {
						toObject = ReflectUtils.IReflect.invokeConstructor(fromCLASS,
								new Object[] { fromObject });
					}
				}
			} 
			finally {

			}
			return toObject;
		}

		/**
		 * 深度克隆(改变非基本类型时,原对象的值改变)
		 * @param fromObject
		 * @return
		 * @throws Exception
		 */
		public static Object deepDesign(Object fromObject) throws Exception {
			Object toObject = null;
			try
			{
				byte[] fromByte = MathUtils.IMath.object2byte( fromObject );
				toObject = MathUtils.IMath.byte2object( fromByte );
			}
			finally{
				
			}
			return toObject;
		}
		
		/**
		 * 拷贝克隆(基于自身拷贝构造函数深度克隆(如不存在拷贝构造函数则直接返回))
		 * @param _objective 深度克隆对象
		 * @return
		 */
		public static Object atomDesign( Object _objective ){
			Object compatible = _objective;
			try
			{
				if( _objective == null ){
					compatible = null;
				}
				else if( IClass.isArray( _objective ) /*数组*/){
					Object _arrayobject[] = (Object[])_objective;
					compatible = Array.newInstance( _arrayobject.getClass().getComponentType(), _arrayobject.length );
					for( int index = 0; index < _arrayobject.length; index++ ){
						((Object[])compatible)[index] = atomDesign( _arrayobject[index] );
					}
				}
				else if( IClass.isPrimitive( _objective ) /*基本类型*/){
					compatible = _objective;
				}
				else if( IClass.isContainer( _objective ) /*BO数据表*/){
					DataStructInterface _bottle = (DataStructInterface)_objective;
					Class _descriptor = Class.forName( _bottle.getObjectType().getFullName() );
					compatible = DataContainerFactory.createDataContainerInstance( _descriptor, _bottle.getObjectType() );
					DataContainerFactory.transfer( _bottle, (DataStructInterface)compatible );
				}
				else if( IClass.isMYSQL5( _objective ) /*自定义数据表*/){
					HQSQLEntityBean _bottle = (HQSQLEntityBean)_objective;
					compatible = ReflectUtils.IReflect.invokeConstructor( _objective.getClass(), new Object[]{ _bottle.getObjectType() } );
					HQSQLUtils.ICustom.transfer( (DataStructInterface)_bottle, (HQSQLEntityBean)compatible );
					for( java.util.Iterator itera = _bottle.getLittle().getLittle().iterator(); itera.hasNext(); ){
						HQSQLEntityBean __bottle = (HQSQLEntityBean)itera.next();
						HQSQLEntityBean _compatible = (HQSQLEntityBean)atomDesign( __bottle );
						((HQSQLEntityBean)compatible).getLittle().getLittle().add( _compatible );
					}
				}
				else if( IClass.isJSONObject( _objective )/*JSON对象*/){
					net.sf.json.JSONObject _bottle = (net.sf.json.JSONObject)_objective;
					compatible = new net.sf.json.JSONObject();
					for( java.util.Iterator itera = _bottle.keys(); itera.hasNext(); ){
						String __entrykey = (String)itera.next();
						Object __entryobject = atomDesign( _bottle.get( __entrykey ) );
						((net.sf.json.JSONObject)compatible).put( __entrykey, __entryobject );
					}
				}
				else if( IClass.isJSONArray( _objective ) /*JSON数组*/){
					net.sf.json.JSONArray _bottle = (net.sf.json.JSONArray)_objective;
					compatible = new net.sf.json.JSONArray();
					for( int index = 0; index < _bottle.size(); index++ ){
						Object _compatible = atomDesign( _bottle.get( index ) );
						((net.sf.json.JSONArray)compatible).add( _compatible );
					}
				}
				else if( IClass.isMap( _objective ) /*键值类型*/){
					java.util.Map _bottle = (java.util.Map)_objective;
					compatible = ReflectUtils.IReflect.invokeConstructor( _bottle.getClass(), new Object[]{} );
					for( java.util.Iterator itera = _bottle.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry __entry = (java.util.Map.Entry)itera.next();
						Object __entrykey = atomDesign( __entry.getKey() );
						Object __entryobject = atomDesign( __entry.getValue() );
						((java.util.Map)compatible).put( __entrykey, __entryobject );
					}
				}
				else if( IClass.isCollection( _objective ) /*链表类型*/){
					java.util.Collection _bottle = (java.util.Collection)_objective;
					compatible = ReflectUtils.IReflect.invokeConstructor( _bottle.getClass(), new Object[]{} );
					for( java.util.Iterator itera = _bottle.iterator(); itera.hasNext(); ){
						Object ___objective = itera.next();
						((java.util.Collection)compatible).add( atomDesign( ___objective ) );
					}
				}
				else/*自定义JAVA对象*/{
					java.lang.reflect.Constructor _constructor = null;
					_constructor = ReflectUtils.IReflect.getConstructor( _objective.getClass(), new Class[]{ _objective.getClass() } );
					if( _constructor == null && _objective instanceof java.io.Serializable){
						byte[] _bytes = MathUtils.IMath.object2byte( _objective );
						compatible = MathUtils.IMath.byte2object( _bytes );
					}
					else if( _constructor == null ){
						compatible = _objective;
					}
					else{
						compatible = _constructor.newInstance( new Object[]{ _objective } );
					}
				}
			}
			catch( java.lang.Exception exception ){
				SFException _exception = ExceptionFactory.getException( exception );
				throw _exception;
			}
			finally{
				
			}
			return compatible;
		}
		
		/**
		 * 
		 * @param aCLASS
		 * @param aCONTAINS
		 * @return
		 */
		public static boolean contains(Class aCLASS, Class aCONTAINS[]) {
			boolean aOBJECT = false;
			try 
			{
				for (int index = 0; index < aCONTAINS.length; index++) {
					aOBJECT |= aCLASS.equals(aCONTAINS[index]);
				}
			} 
			finally {

			}
			return aOBJECT;
		}

		/**
		 * 
		 * @param aTYPE
		 * @return
		 * @throws Exception
		 */
		public static Class wrap(String aTYPE) throws Exception {
			if (aTYPE == null || StringUtils.isBlank(aTYPE) || aTYPE.equalsIgnoreCase("NONE")){
				aTYPE = java.lang.String.class.getName();
			}
			return Class.forName(aTYPE);
		}

		/**
		 * 是否为JAVA类
		 * 
		 * @param fromClass
		 * @return
		 * @throws Exception
		 */
		public static boolean isAssignable(String fromClass) throws Exception {
			boolean aOBJECT = false;
			try 
			{
				if (StringUtils.isBlank(fromClass) == false && StringUtils.equalsIgnoreCase(fromClass, "NONE") == false) {
					ClassLoader aClassLoader = Thread.currentThread().getContextClassLoader();
					String aFileName = StringUtils.replace(fromClass, ".", "/");
					if (StringUtils.endsWith(aFileName, ".class ") == false)
						aFileName = ClassUtils.getINDEX(new String[] { aFileName, ".class" });
					if (aClassLoader.getResource(aFileName) != null) {
						aOBJECT = ClassUtils.isAssignable(Class.forName(fromClass), java.lang.Object.class);
					}
				}
			} 
			finally {

			}
			return aOBJECT;
		}

		/**
		 * 
		 * @param aCLASS
		 * @param toClass
		 * @return
		 * @throws Exception
		 */
		public static boolean isAssignable(String fromClass, Class toClass)
				throws Exception {
			try 
			{
				if (IClass.isAssignable(fromClass) == false){
					return false;
				}
				if (ClassUtils.isAssignable(Class.forName(fromClass), toClass)){
					return true;
				}
			} 
			finally {

			}
			return false;
		}

		/**
		 * 
		 * @param fromClass
		 * @param toClass
		 * @return
		 */
		public static boolean isAssignable(Class fromClass, Class toClass) {
			return fromClass != null && ClassUtils.isAssignable(fromClass, toClass);
		}

		/**
		 * 
		 * @param aCLASS
		 * @param toClass
		 * @return
		 * @throws Exception
		 */
		public static boolean isAssignable(String aCLASS, Class toClass[]) throws Exception {
			if (isAssignable(aCLASS) == false){
				return false;
			}
			java.lang.Class fromClass = Class.forName(aCLASS);
			for (int index = 0; toClass != null && index < toClass.length; index++) {
				if (ClassUtils.isAssignable(fromClass, toClass[index])){
					return true;
				}
			}
			return false;
		}

		/**
		 * 
		 * @param fromObject
		 * @param toClassArray
		 * @return
		 */
		public static boolean isAssignable(Object fromObject, Class[] toClassArray) {
			for (int index = 0; index < toClassArray.length; index++) {
				if (fromObject == null && toClassArray[index] == null)
					return true;
				else if (fromObject != null
						&& ClassUtils.isAssignable(fromObject.getClass(),
								toClassArray[index]))
					return true;
			}
			return toClassArray != null && toClassArray.length > 0 ? false
					: true;
		}

		/**
		 * 
		 * @param fromObject
		 * @param toClass
		 * @return
		 */
		public static boolean isAssignable(java.util.List fromObject, Class toClass) {
			for( java.util.Iterator itera = fromObject.iterator(); itera.hasNext();) {
				Object aOBJECT = itera.next();
				if (aOBJECT == null || isAssignable(aOBJECT.getClass(), toClass) == false) {
					return false;
				}
			}
			return true;
		}

		/**
		 * 判断是否INTEGER
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isASTInt(String str) {
			boolean retn = false;
			try 
			{
				retn = str != null && StringUtils.isNumeric(str) ? true : false;
				if (retn == true) {
					Integer.parseInt(str);
					retn = true;
				}
			} 
			catch (java.lang.Exception ee) {
				retn = false;
			} 
			finally {

			}
			return retn;
		}

		/**
		 * 判断是否为LONG
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isASTLong(String str) {
			boolean retn = false;
			try 
			{
				String aPrimitive = str;
				retn = aPrimitive != null
						&& StringUtils.isBlank(aPrimitive) == false
						&& IClass.isASTString(aPrimitive) == false
						&& IClass.isASTCharacter(aPrimitive) == false ? true
						: false;
				if (retn == true) {
					char quoteCharacter = aPrimitive.charAt(aPrimitive.length() - 1);
					if (quoteCharacter == 'L' || quoteCharacter == 'l')
						aPrimitive = aPrimitive.substring(0, aPrimitive
								.length() - 1);
					Long.parseLong(aPrimitive);
					retn = true;
				}
			} 
			catch (java.lang.Exception ee) {
				retn = false;
			}
			return retn;
		}

		/**
		 * 判断是否float
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isASTFloat(String str) {
			boolean retn = false;
			try 
			{
				String aPrimitive = str;
				retn = aPrimitive != null && StringUtils.isBlank(aPrimitive) == false
						&& IClass.isASTString(aPrimitive) == false 
						&& IClass.isASTCharacter(aPrimitive) == false ? true : false;
				if (retn == true) {
					char quoteCharacter = aPrimitive.charAt(aPrimitive.length() - 1);
					if (quoteCharacter == 'f' || quoteCharacter == 'F'){
						aPrimitive = aPrimitive.substring(0, aPrimitive.length() - 1);
					}
					Float.parseFloat(aPrimitive);
					retn = true;
				}
			} 
			catch (java.lang.Exception ee) {
				retn = false;
			}
			return retn;
		}

		/**
		 * 判断是否为DOUBLE
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isASTDouble(String str) {
			boolean retn = false;
			try 
			{
				String aPrimitive = str;
				retn = aPrimitive != null ? true : false;
				if (retn == true) {
					char quoteCharacter = aPrimitive.charAt(aPrimitive.length() - 1);
					retn = quoteCharacter != 'F' && quoteCharacter != 'f';
					if (retn == true) {
						Double.parseDouble(str);
						retn = true;
					}
				}
			} 
			catch (java.lang.Exception ee) {
				retn = false;
			}
			return retn;
		}

		/**
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isASTCharacter(String str) {
			boolean retn = false;
			try 
			{
				String arguments = str;
				retn = arguments != null && arguments.length() == 3 ? true
						: false;
				if (retn == true) {
					retn = arguments.charAt(0) == '\''
							&& arguments.charAt(arguments.length() - 1) == '\'';
				}
			} 
			catch (java.lang.Exception ee) {
				retn = false;
			}
			return retn;
		}

		/**
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isASTString(String str) {
			boolean retn = false;
			try 
			{
				String arguments = str;
				retn = arguments != null ? true : false;
				if (retn == true) {
					retn = arguments.charAt(0) == '"' && arguments.charAt(arguments.length() - 1) == '"';
				}
			} 
			catch (java.lang.Exception ee) {
				retn = false;
			}
			return retn;
		}

		/**
		 * 判断是否为数组或JDK中Collection数据
		 * 
		 * @param fromObject
		 * @return
		 */
		public static boolean isASTArray(Object fromObject) {
			boolean aObject = fromObject != null;
			if (aObject == true) {
				if ((aObject = fromObject instanceof java.lang.Object[]) == false)
					aObject = fromObject instanceof java.util.Collection;
			}
			return aObject;
		}

		/***
		 * 判断是否已更新
		 * @param fromEntity
		 * @return
		 * @throws Exception
		 */
		public static boolean isASTUpdate(DataStructInterface fromEntity) throws Exception {
			return fromEntity != null && (fromEntity.isNew() || fromEntity.isDeleted() || 
					fromEntity.isModified()) ? true : false;
		}

		/**
		 * 判断是否已删除
		 * @param fromEntity
		 * @return
		 * @throws Exception
		 */
		public static boolean isASTDelete(DataStructInterface fromEntity)
				throws Exception {
			return fromEntity != null && fromEntity.isDeleted();
		}
		
		/**
		 * 两个CLASS类是否相同
		 * @param fromTYPE
		 * @param toTYPE
		 * @return
		 */
		public static boolean equals( Class fromTYPE, Class toTYPE ){
			return fromTYPE.equals( toTYPE );
		}
		/**
		 * 是否为java.lang.Class类型
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isClass(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.lang.Class;
		}

		/**
		 * 是否简单数据类型
		 * 
		 * @param primitiveType
		 * @return
		 */
		public static boolean isPrimitive(Class primitiveType) {
			Class aPRIMITIVE[] = new Class[] { java.math.BigDecimal.class,
					Long.class, long.class, Integer.class, int.class,
					Short.class, short.class, Byte.class, byte.class,
					Character.class, char.class, Double.class, double.class,
					Float.class, float.class, Boolean.class, boolean.class,
					String.class, java.util.Date.class };
			for (int index = 0; index < aPRIMITIVE.length; index++) {
				if (ClassUtils.isAssignable(primitiveType, aPRIMITIVE[index]))
					return true;
			}
			return false;
		}

		/**
		 * 是否为数字类型
		 * 
		 * @param aTYPE
		 * @return
		 */
		public static boolean isDigital(Class aTYPE) {
			Class aDIGITAL_TYPE[] = new Class[] { java.math.BigDecimal.class,
					Long.class, long.class, Integer.class, int.class,
					Short.class, short.class, Byte.class, byte.class,
					Double.class, double.class, Float.class, float.class };
			for (int index = 0; index < aDIGITAL_TYPE.length; index++) {
				if (ClassUtils.isAssignable(aTYPE, aDIGITAL_TYPE[index]))
					return true;
			}
			return false;
		}

		/**
		 * 
		 * @param aTYPE
		 * @return
		 */
		public static boolean isBoolean(Class aTYPE) {
			return ClassUtils.isAssignable(aTYPE, Boolean.class)
					|| ClassUtils.isAssignable(aTYPE, boolean.class);
		}
		
		/**
		 * 
		 * @param aTYPE
		 * @return
		 */
		public static boolean isBoolean(Object aOBJECT) {
			return aOBJECT != null && isBoolean( aOBJECT.getClass() );
		}
		
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isPrimitive( Object aOBJECT ){
			return aOBJECT != null && isPrimitive( aOBJECT.getClass() );
		}
		
		/**
		 * 是否为数字类型
		 * 
		 * @param aTYPE
		 * @return
		 */
		public static boolean isDigital( Object aOBJECT ){
			return aOBJECT != null && isDigital( aOBJECT.getClass() );
		}
		
		/**
		 * 是否Method对象
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isMethod(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.lang.reflect.Method;
		}

		/**
		 * 是否为字符串
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isString(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.lang.String;
		}
		/**
		 * 是否为XML内容
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isXML( Object aOBJECT ){
			return aOBJECT != null && isString( aOBJECT ) && XmlUtils.IXml.isXML( aOBJECT.toString() );
		}
		/**
		 * 是否为APP对象
		 * 
		 * @param aTYPE
		 * @return
		 */
		public static boolean isContainer(Object aOBJECT) {
			return aOBJECT != null && (aOBJECT instanceof DataContainer || aOBJECT instanceof DataContainer[]);
		}
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isJSON( Object aOBJECT){
			return aOBJECT != null && aOBJECT instanceof net.sf.json.JSON;
		}
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isJSONObject( Object aOBJECT ){
			return aOBJECT != null && aOBJECT instanceof net.sf.json.JSONObject;
		}
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isJSONArray( Object aOBJECT ){
			return aOBJECT != null && aOBJECT instanceof net.sf.json.JSONArray;
		}
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isJSONNull( Object aOBJECT ){
			return aOBJECT != null && aOBJECT instanceof net.sf.json.JSONNull;
		}
		/**
		 * 
		 * @param aObject
		 * @return
		 */
		public static boolean isException( Object aObject ){
			return aObject != null && aObject instanceof java.lang.Exception;
		}
		/**
		 * 是否为MYSQL5
		 * 
		 * @param aObJECT
		 * @return
		 */
		public static boolean isMYSQL5(Object aOBJECT) {
			return aOBJECT != null && (aOBJECT instanceof HQSQLEntityBean || aOBJECT instanceof HQSQLEntityBean[]);
		}
		
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isLittle( Object aOBJECT ){
			return aOBJECT != null && (aOBJECT instanceof IUpdfmxLittle || aOBJECT instanceof IUpdfmxLittle[]);
		}
		
		/**
		 * 是否为数组实例
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isArray(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.lang.Object[] ? true : false;
		}

		/**
		 * 是否NULL字符
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isNULL(Object aOBJECT) {
			return aOBJECT != null && StringUtils.equals(aOBJECT.toString(), IUpdcConst.IEnum.ISschk.NULL);
		}

		/**
		 * 是否存在多属性[包含等号]格式为A=1;B=1 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isMULTLE( Object aOBJECT ){
			return aOBJECT != null && IClass.isString( aOBJECT ) && StringUtils.contains( (String)aOBJECT, "=" ) == false;
		}
		
		/**
		 * 是否列表对象
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isList(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.util.List;
		}
		
		/**
		 * 是否JDK列表对象
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isJDKList( Object aOBJECT ){
			boolean fromBool = false;
			try 
			{
				fromBool = aOBJECT != null && aOBJECT instanceof java.util.List;
				if (fromBool == true) {
					String fromCLASS = aOBJECT.getClass().getName();
					fromBool = StringUtils.startWith(fromCLASS, "java.util.");
				}
			} 
			finally {

			}
			return fromBool;
		}
		
		/**
		 * 是否Map对象
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isMap(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.util.Map;
		}

		/**
		 * 是否Set对象
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isSet(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.util.Set;
		}

		/**
		 * 是否Collection对象
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isCollection( Object aOBJECT ){
			return aOBJECT != null && aOBJECT instanceof java.util.Collection;
		}
		
		/**
		 * 是否为日期类型
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isDate(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.util.Date;
		}

		/**
		 * 是否一维对象
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isArray1(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.lang.Object[];
		}

		/**
		 * 是否二维对象
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isArray2(Object aOBJECT) {
			return aOBJECT != null && aOBJECT instanceof java.lang.Object[][];
		}

		/**
		 * 根据BO文件路径查询BO对象类型
		 * @param fromTYPE
		 * @return
		 * @throws Exception
		 */
		public static ObjectType getASTBOType( String fromTYPE ) throws Exception {
			return ServiceManager.getObjectTypeFactory().getInstance( fromTYPE );
		}
		
		/**
		 * 根据BO文件路径转换为BO对象
		 * 
		 * @param fromTYPE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static DataContainer getASTBOEntity( ObjectType fromTYPE ) throws SFException, Exception {
			DataContainer fromEntity = null;
			try 
			{
				Class fromCLASS = Class.forName( fromTYPE.getFullName() );
				fromEntity = (DataContainer) DataContainerFactory
						.createDataContainerInstance(fromCLASS, fromTYPE);
			} 
			finally{

			}
			return fromEntity;
		}
		
		/**
		 * 
		 * @param aPERSISTENT
		 * @return
		 * @throws Exception
		 */
		public static DataContainer getASTBOEntity( String aPERSISTENT ) throws Exception{
			DataContainer fromEntity = null;
			try
			{
				ObjectType fromTYPE = IClass.getASTBOType( aPERSISTENT );
				fromEntity = IClass.getASTBOEntity( fromTYPE );
			}
			finally{
				
			}
			return fromEntity;
		}
		/**
		 * 根据BO对象查询主键字段信息
		 * 
		 * @param aObject
		 * @return [0字段名1字段值]
		 * @throws Exception
		 */
		public static String[] getPRIMARY( DataStructInterface aObject ) throws Exception {
			String aPRIMARY[] = null;
			try 
			{
				ObjectType fromTYPE = aObject.getObjectType();
				if (fromTYPE.getKeyProperties().size() > 0) {
					aPRIMARY = (String[]) fromTYPE.getKeyProperties().keySet().toArray(new String[] {});
				}
			} 
			finally{

			}
			return aPRIMARY;
		}

		/**
		 * 将Map对象映射到JAVA对象并返回当前替换字段名
		 * 
		 * @param fromMap
		 * @param toObject
		 * @return
		 * @throws Exception
		 */
		public static String[] transfer(java.util.Map fromMap, Object toObject) throws Exception {
			java.util.List fromField = new java.util.ArrayList();
			try 
			{
				IBeanWrapper aWrapper = new IBeanWrapper(toObject);
				java.beans.PropertyDescriptor aDescriptors[] = aWrapper.getPropertyDescriptors();
				for (int index = 0; aDescriptors != null && index < aDescriptors.length; index++) {
					if (fromMap.containsKey(aDescriptors[index].getName()) == false) continue;
					Object fromJAVA = fromMap.get(aDescriptors[index].getName());
					fromJAVA = ClassUtils.IClass.transfer(fromJAVA, aDescriptors[index].getPropertyType());
					aWrapper.setPropertyValue(aDescriptors[index].getName(), fromJAVA);
					fromField.add(aDescriptors[index].getName());
				}
			} 
			finally{

			}
			return (String[]) fromField.toArray(new String[] {});
		}

		/**
		 * 
		 * @param fromMap
		 * @param toObject
		 * @return
		 * @throws Exception
		 */
		public static String[] transfer(java.util.Map fromMap, DataStructInterface toObject) throws Exception {
			java.util.List fromField = new java.util.ArrayList();
			try 
			{
				String fromProperty[] = toObject.getPropertyNames();
				for( int index = 0; fromProperty != null && index < fromProperty.length; index++ ){
					if( fromMap.containsKey( fromProperty[index] ) ){
						Object fromColumn = fromMap.get( fromProperty[index] );
						toObject.set( fromProperty[index], fromColumn );
						fromField.add( fromProperty[index] );
					}
				}
			} 
			finally {

			}
			return (String[]) fromField.toArray(new String[] {});
		}
		
		/**
		 * 
		 * @param fromObject
		 * @param toObject
		 * @return
		 * @throws Exception
		 */
		public static String[] transfer(Object fromObject, Object toObject) throws Exception {
			java.util.List fromField = new java.util.ArrayList();
			try 
			{
				IBeanWrapper fromWrapper = new IBeanWrapper(fromObject);
				IBeanWrapper toWrapper = new IBeanWrapper(toObject);
				java.beans.PropertyDescriptor aDescriptors[] = fromWrapper.getPropertyDescriptors();
				for (int index = 0; aDescriptors != null && index < aDescriptors.length; index++) {
					if (toWrapper.isPropertyDescriptor(aDescriptors[index]) == false) continue;
					if (fromWrapper.isReadableProperty(aDescriptors[index].getName())
							&& toWrapper.isWritableProperty(aDescriptors[index].getName())) {
						java.beans.PropertyDescriptor aDescriptor = toWrapper
								.getPropertyDescriptor(aDescriptors[index].getName());
						Object fromJAVA = fromWrapper.getPropertyValue(aDescriptors[index].getName());
						fromJAVA = ClassUtils.IClass.transfer(fromJAVA, aDescriptor.getPropertyType());
						toWrapper.setPropertyValue(aDescriptor.getName(), fromJAVA);
						fromField.add( aDescriptor.getName() );
					}
				}
			} 
			finally {

			}
			return (String[]) fromField.toArray(new String[] {});
		}

		/**
		 * 
		 * @param fromObject
		 * @param aTYPE
		 * @return
		 * @throws Exception
		 */
		public static Object transfer(Object fromObject, String aTYPE)
				throws Exception {
			if (IClass.isAssignable(aTYPE) == false){
				return fromObject;
			}
			return transfer(fromObject, Class.forName(aTYPE));
		}

		/**
		 * 
		 * @param aVALUE
		 * @param aTYPE
		 * @return
		 * @throws Exception
		 */
		public static Object transfer(Object _object, Class _type) throws Exception {
			Object _objective = _object;
			try 
			{
				if( _object == null ){
					_objective = null;
				}
				else if( _type.equals( java.lang.Boolean.class ) || _type.equals( java.lang.Boolean.TYPE ) ){
					if( _object instanceof java.lang.Boolean ){
						_objective = _object;
					}
					else if( _object instanceof java.lang.Number ){
						java.lang.Number _number = (java.lang.Number)_object;
						_objective = _number.doubleValue() > 0.0d?
								new java.lang.Boolean(true):new java.lang.Boolean(false);
					}
					else if( _object instanceof java.lang.String ){
						java.lang.String _string = (java.lang.String)_object;
						_objective = _string.equalsIgnoreCase("TRUE") || _string.equalsIgnoreCase("Y")?
								new java.lang.Boolean(true):new java.lang.Boolean(false);
					}
					else{
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString(), "Boolean" } );
						throw new java.lang.RuntimeException( _message );
					}
				}
				else if( _type.equals( java.lang.Byte.class ) || _type.equals( java.lang.Byte.TYPE ) ){
					if( _object instanceof java.lang.Byte ){
						_objective = _object;
					}
					else{
						java.math.BigDecimal _decimal = new java.math.BigDecimal( _object.toString() );
						_objective = new java.lang.Byte( _decimal.byteValue() );
					}
				}
				else if( _type.equals( java.lang.Short.class ) || _type.equals( java.lang.Short.TYPE ) ){
					if( _object instanceof java.lang.Short ){
						_objective = _object;
					}
					else{
						java.math.BigDecimal _decimal = new java.math.BigDecimal( _object.toString() );
						_objective = new java.lang.Short( _decimal.shortValue() );
					}
				}
				else if( _type.equals( java.lang.Integer.class ) || _type.equals( java.lang.Integer.TYPE ) ){
					if( _object instanceof java.lang.Integer ){
						_objective = _object;
					}
					else{
						java.math.BigDecimal _decimal = new java.math.BigDecimal( _object.toString() );
						_objective = new java.lang.Integer( _decimal.intValue() );
					}
				}
				else if( _type.equals( java.lang.Long.class ) || _type.equals( java.lang.Long.TYPE ) ){
					if( _object instanceof java.lang.Long ){
						_objective = _object;
					}
					else{
						java.math.BigDecimal _decimal = new java.math.BigDecimal( _object.toString() );
						_objective = new java.lang.Long( _decimal.longValue() );
					}
				}
				else if( _type.equals( java.lang.Float.class ) || _type.equals( java.lang.Float.TYPE ) ){
					if( _object instanceof java.lang.Float ){
						_objective = _object;
					}
					else{
						java.math.BigDecimal _decimal = new java.math.BigDecimal( _object.toString() );
						_objective = new java.lang.Float( _decimal.floatValue() );
					}
				}
				else if( _type.equals( java.lang.Double.class ) || _type.equals( java.lang.Double.TYPE ) ){
					if( _object instanceof java.lang.Double ){
						_objective = _object;
					}
					else{
						java.math.BigDecimal _decimal = new java.math.BigDecimal( _object.toString() );
						_objective = new java.lang.Double( _decimal.doubleValue() );
					}
				}
				else if( _type.equals( java.math.BigInteger.class ) ){
					if( _object instanceof java.math.BigInteger ){
						_objective = _object;
					}
					else{
						_objective = new java.math.BigInteger( _object.toString() );
					}
				}
				else if( _type.equals( java.math.BigInteger.class ) ){
					if( _object instanceof java.math.BigInteger ){
						_objective = _object;
					}
					else{
						_objective = new java.math.BigInteger( _object.toString() );
					}
				}
				else if( _type.equals( java.math.BigDecimal.class ) ){
					if( _object instanceof java.math.BigDecimal ){
						_objective = _object;
					}
					else{
						_objective = new java.math.BigDecimal( _object.toString() );
					}
				}
				else if( _type.equals( java.lang.Character.class ) || _type.equals( java.lang.Character.TYPE ) ){
					if( _object instanceof java.lang.Character ){
						_objective = _object;
					}
					else if( _object.toString().length() <= 0 ){
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , "Character" } );
						throw new java.lang.RuntimeException( _message );
					}
					else{
						java.lang.String _string = _object.toString();
						_objective = new java.lang.Character( _string.charAt( _string.length() - 1 ) );
					}
				}
				else if( _type.equals( java.lang.String.class ) ){
					if( _object instanceof java.lang.String ){
						_objective = _object;
					}
					else if( _object instanceof net.sf.json.JSONObject ){
						net.sf.json.JSONObject _json = (net.sf.json.JSONObject)_object;
						_objective = _json.toString();
					}
					else{
						_objective = _object.toString();
					}
				}
				else if( _type.equals( java.util.Date.class ) ){
					if( _object instanceof java.util.Date ){
						_objective = _object;
					}
					else if( _object.toString().length() <= 0 ){
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , "java.util.Date" } );
						throw new java.lang.RuntimeException( _message );
					}
					else{
						java.sql.Timestamp _timestamp = TimeUtils.getTime( _object );
						_objective = new java.util.Date( _timestamp.getTime() );
					}
				}
				else if( _type.equals( java.sql.Date.class ) ){
					if( _object instanceof java.sql.Date ){
						_objective = _object;
					}
					else if( _object instanceof oracle.sql.DATE ){
						oracle.sql.DATE _date_ = (oracle.sql.DATE)_object;
						_objective = _date_.dateValue();
					}
					else if( _object instanceof oracle.sql.TIMESTAMP ){
						oracle.sql.TIMESTAMP _date_ = (oracle.sql.TIMESTAMP)_object;
						_objective = _date_.dateValue();
					}
					else if( _object instanceof java.util.Date ){
						java.util.Date _date = (java.util.Date)_object;
						_objective = new java.sql.Date( _date.getTime() );
					}
					else if( _object.toString().length() <= 0 ){
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , "java.sql.Date" } );
						throw new java.lang.RuntimeException( _message );
					}
					else{
						java.sql.Timestamp _timestamp = TimeUtils.getTime( _object );
						_objective = new java.sql.Date( _timestamp.getTime() );
					}
				}
				else if( _type.equals( java.sql.Time.class ) ){
					if( _object instanceof java.sql.Time ){
						_objective = _object;
					}
					else if( _object instanceof java.sql.Date ){
						java.sql.Date _date = (java.sql.Date)_object;
						_objective = new java.sql.Time( _date.getTime() );
					}
					else if( _object instanceof oracle.sql.DATE ){
						oracle.sql.DATE _date_ = (oracle.sql.DATE)_object;
						_objective = _date_.timeValue();
					}
					else if( _object instanceof oracle.sql.TIMESTAMP ){
						oracle.sql.TIMESTAMP _date_ = (oracle.sql.TIMESTAMP)_object;
						_objective = _date_.timeValue();
					}
					else if( _object instanceof java.util.Date ){
						java.util.Date _date = (java.util.Date)_object;
						_objective = new java.sql.Time( _date.getTime() );
					}
					else if( _object.toString().length() <= 0 ){
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , "java.sql.Date" } );
						throw new java.lang.RuntimeException( _message );
					}
					else{
						java.sql.Timestamp _timestamp = TimeUtils.getTime( _object );
						_objective = new java.sql.Time( _timestamp.getTime() );
					}
				}
				else if( _type.equals( java.sql.Timestamp.class ) ){
					if( _object instanceof java.sql.Timestamp ){
						_objective = _object;
					}
					else if( _object instanceof java.sql.Date ){
						java.sql.Date _date = (java.sql.Date)_object;
						_objective = new java.sql.Timestamp( _date.getTime() );
					}
					else if( _object instanceof oracle.sql.DATE ){
						oracle.sql.DATE _date_ = (oracle.sql.DATE)_object;
						_objective = _date_.timestampValue();
					}
					else if( _object instanceof oracle.sql.TIMESTAMP ){
						oracle.sql.TIMESTAMP _date_ = (oracle.sql.TIMESTAMP)_object;
						_objective = _date_.timestampValue();
					}
					else if( _object instanceof java.util.Date ){
						java.util.Date _date = (java.util.Date)_object;
						_objective = new java.sql.Timestamp( _date.getTime() );
					}
					else if( _object.toString().length() <= 0 ){
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , "java.sql.Date" } );
						throw new java.lang.RuntimeException( _message );
					}
					else{
						_objective = TimeUtils.getTime( _object );
					}
				}
				else if( java.util.Map.class.isAssignableFrom( _type ) ){
					if( _type.isAssignableFrom( _object.getClass() ) ){
						_objective = _object;
					}
					else if( _object instanceof java.util.Map ){
						_objective = (java.util.Map)IReflect.invokeConstructor( _type, new Object[]{} );
						((java.util.Map)_objective).putAll( (java.util.Map)_object );
					}
					else{
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , _type.getName() } );
						throw new java.lang.RuntimeException( _message );
					}
				}
				else if( java.util.List.class.isAssignableFrom( _type ) ){
					if( _type.isAssignableFrom( _object.getClass() ) ){
						_objective = _object;
					}
					else if( _object instanceof java.util.List ){
						_objective = (java.util.List)IReflect.invokeConstructor( _type, new Object[]{} );
						((java.util.List)_objective).addAll( ((java.util.List)_object) );
					}
					else{
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , _type.getName() } );
						throw new java.lang.RuntimeException( _message );
					}
				}
				else if( java.util.Set.class.isAssignableFrom( _type ) ){
					if( _type.isAssignableFrom( _object.getClass() ) ){
						_objective = _object;
					}
					else if( _object instanceof java.util.Set ){
						_objective = (java.util.Set)IReflect.invokeConstructor( _type, new Object[]{} );
						((java.util.Set)_objective).addAll( ((java.util.Set)_object) );
					}
					else{
						String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
								new String[] { _object.toString() , _type.getName() } );
						throw new java.lang.RuntimeException( _message );
					}
				}
				else{
					_objective = _object;
				}
			}
			catch( java.lang.Exception exception ){
				String _message = ExceptionFactory.getDefault().getLocal("com.ai.appframe2.datatype_transform_error", 
						new String[] { _object.toString() , _type.getName() } );
				throw new java.lang.IllegalArgumentException( _message, exception );
			}
			finally {

			}
			return _objective;
		}

		/**
		 * 
		 * @param fromArray
		 * @param fromSize
		 * @return
		 */
		public static Object[] arrayCopy(Object[] fromArray, int fromSize) {
			Object[] arrayOfObject = null;
			try 
			{
				Class paramClass = fromArray.getClass();
				arrayOfObject = (paramClass == Object[].class) ? (Object[]) new Object[fromSize]
						: (Object[]) (Object[]) Array.newInstance(paramClass.getComponentType(), fromSize);
				System.arraycopy(fromArray, 0, arrayOfObject, 0, Math.min(
						fromArray.length, fromSize));
			} 
			finally {

			}
			return arrayOfObject;
		}
		
		/**
		 * 将列表存放全量对象转换为指定CLASS类数组
		 * @param fromList
		 * @param toClass
		 * @return
		 */
		public static Object[] arrayCopy(java.util.List fromList, Class toClass) {
			Object aOBJECT[] = null;
			try 
			{
				aOBJECT = (Object[]) Array.newInstance(toClass, fromList.size());
				System.arraycopy(fromList.toArray(), 0, aOBJECT, 0, fromList.size());
			} 
			finally {

			}
			return aOBJECT;
		}

		/**
		 * 将列表存放全量对象转换为类数组
		 * 
		 * @param fromList
		 * @return
		 */
		public static Object[] arrayDesign(java.util.List fromList) {
			Object fromArray[] = null;
			try 
			{
				Object fromObject = fromList != null && fromList.size() > 0 ? fromList
						.get(fromList.size() - 1) : null;
				if( fromObject != null && IClass.isAssignable(fromList, fromObject.getClass()) ) {
					fromArray = IClass.arrayCopy(fromList, fromObject.getClass());
				} 
				else if( fromList != null && fromList.size() > 0 ) {
					fromArray = fromList.toArray();
				}
			} 
			finally {

			}
			return fromArray;
		}

		/**
		 * 将列表存放指定CLASS对象转换为指定CLASS类数组
		 * @param fromObject
		 * @param toClass
		 * @return
		 */
		public static Object[] arrayDesign(java.util.List fromList, Class toClass) {
			Object arrayObject[] = null;
			java.util.List fromRetain = new java.util.ArrayList();
			try 
			{
				for (java.util.Iterator itera = fromList.iterator(); itera.hasNext();) {
					Object aOBJECT = itera.next();
					if (aOBJECT == null || isAssignable(aOBJECT.getClass(), toClass) == false)
						continue;
					fromRetain.add(aOBJECT);
				}
				arrayObject = IClass.arrayCopy(fromRetain, toClass);
			} 
			finally {
				if (fromRetain != null) { fromRetain.clear(); fromRetain = null; }
			}
			return arrayObject;
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static String getAsString(Object fromObj) {
			return DataType.getAsString(fromObj);
		}
		
		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static short getAsShort(Object fromObj) {
			return DataType.getAsShort(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static int getAsInt(Object fromObj) {
			return DataType.getAsInt(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static long getAsLong(Object fromObj) {
			return DataType.getAsLong(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static double getAsDouble(Object fromObj) {
			return DataType.getAsDouble(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static float getAsFloat(Object fromObj) {
			return DataType.getAsFloat(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static byte getAsByte(Object fromObj) {
			return DataType.getAsByte(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static boolean getAsBoolean(Object fromObj) {
			return DataType.getAsBoolean(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static char getAsChar(Object fromObj) {
			return DataType.getAsChar(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static java.sql.Date getAsDate(Object fromObj) {
			return DataType.getAsDate(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static java.sql.Time getAsTime(Object fromObj) {
			return DataType.getAsTime(fromObj);
		}

		/**
		 * 
		 * @param fromObj
		 * @return
		 */
		public static java.sql.Timestamp getAsTimestamp(Object fromObj) {
			return DataType.getAsDateTime(fromObj);
		}

		/**
		 * 
		 * @param fromMap
		 * @param aITagIdL
		 * @return
		 * @throws Exception
		 */
		public static java.util.HashMap[] getAsMap(java.util.Map fromMap,
				String fromTagId) throws Exception {
			java.util.HashMap fromArray[] = new java.util.HashMap[] {};
			try
			{
				Object fromEntity = ReflectUtils.xPath( fromTagId , fromMap );
				if( fromEntity != null && fromEntity instanceof java.util.List ){
					fromArray = (java.util.HashMap[]) ((java.util.List)fromEntity)
							.toArray(new java.util.HashMap[] {});
				}
				else if( fromEntity != null && fromEntity instanceof java.util.Map[] ){
					fromArray = (java.util.HashMap[]) fromEntity;
				}
				else if (fromEntity != null){
					fromArray = new java.util.HashMap[] { (java.util.HashMap) fromEntity };
				}
			}
			finally{
				
			}
			return fromArray;
		}

		/**
		 * 
		 * @param aOBJECTIVE
		 * @return
		 */
		public static java.util.List getAsArray( Object aOBJECTIVE ){
			java.util.ArrayList collection = new java.util.ArrayList();
			if( IClass.isArray( aOBJECTIVE ) ){
				IMerge.merge( (Object[])aOBJECTIVE, collection );
			}
			else if( IClass.isList( aOBJECTIVE ) ){
				IMerge.merge( (java.util.List)aOBJECTIVE, collection );
			}
			else if( IClass.isSet( aOBJECTIVE ) ){
				IMerge.merge( ((java.util.Set)aOBJECTIVE).toArray(), collection );
			}
			else if( IClass.isCollection( aOBJECTIVE ) ){
				IMerge.merge( ((java.util.Collection)aOBJECTIVE).toArray(), collection );
			}
			else{
				IMerge.merge( new Object[]{aOBJECTIVE}, collection );
			}
			return collection;
		}
		
		/**
		 * 根据变量路径删除元素和被删除元素作为数组
		 * @param fromMap 
		 * @param fromTagId 待删除路径
		 * @param toMap
		 * @throws Exception
		 */
		public static Object purge(java.util.Map fromMap,
				String fromTagId,
				java.util.Map toMap) throws Exception {
			java.util.Map fromArray[] = null;
			Object fromDelete = ReflectUtils.xPathDel( fromTagId, fromMap );
			if( fromDelete != null && fromDelete instanceof java.util.List ){
				fromArray = (java.util.Map[]) ((java.util.List) fromDelete)
						.toArray(new java.util.Map[] {});
			}
			else if( fromDelete != null && fromDelete instanceof java.util.Map[] ){
				fromArray = (java.util.Map[]) fromDelete;
			}
			else if( fromDelete != null && fromDelete instanceof java.util.Map ){
				fromArray = new java.util.Map[] { (java.util.Map) fromDelete };
			}
			ClassUtils.IMerge.merge(fromMap, toMap);
			if( fromArray != null ){ toMap.put( fromTagId, fromArray); }
			return fromDelete;
		}

		/**
		 * 根据接口类构造其接口实现类
		 * 
		 * @param aIInterface
		 * @return
		 * @throws Exception
		 */
		public static Class getSVImpl(Class aIInterface) throws Exception {
			String fromImpl = ClassUtils.getPackageName(aIInterface.getName())
					+ "." + StringUtils.substring( ClassUtils.getShortClassName(aIInterface.getName()), 1)
					+ "Impl";
			if (StringUtils.contains( fromImpl, "interfaces")){
				fromImpl = StringUtils.replace(fromImpl , "interfaces", "impl");
			}
			else if (isAssignable(fromImpl) == false){
				fromImpl = ClassUtils.getPackageName(aIInterface.getName())
						+ ".impl."
						+ StringUtils.substring(ClassUtils.getShortClassName(aIInterface.getName()), 1)
						+ "Impl";
			}
			return Class.forName(fromImpl);
		}

		/**
		 * 根据路径数组构造并查询末端对象
		 * @param fromObject
		 * @param toMap
		 * @return 返回末端元素
		 */
		public static java.util.Map bottom(Object fromPath[], java.util.Map toMap) {
			java.util.Map fromBottom = toMap;
			try 
			{
				for (int index = 0; fromPath != null && index < fromPath.length; index++) {
					java.util.Map fromMap = fromBottom;
					if( (fromBottom = (java.util.Map) fromMap.get(fromPath[index]) ) == null ) {
						fromMap.put(fromPath[index], fromBottom = new java.util.HashMap());
					}
				}
			} 
			finally {

			}
			return fromBottom;
		}

		/**
		 * 根据类路径查询最近路径模板
		 * @param fromPath
		 * @param fromXPath
		 * @return 0匹配到路径1匹配到路径对应值
		 */
		public static String[] xPath( String fromPath, java.util.Map fromXPath) {
			String fromArray[] = null;
			java.util.List fromPaths = new java.util.ArrayList();
			try 
			{
				String aFUNCTION[] = StringUtils.wildcardArray(fromPath, ".");
				ClassUtils.IMerge.merge(aFUNCTION, fromPaths);
				while( fromXPath != null && fromPaths.size() > 0) {
					fromPath = StringUtils.join( fromPaths.iterator(), "." );
					if( fromXPath.get(fromPath) != null ) {
						fromArray = new String[] { fromPath, (String)fromXPath.get(fromPath) };
						break;
					}
					fromPaths.remove(fromPaths.size() - 1);
				}
			} 
			finally {
				if (fromPaths != null) { fromPaths.clear(); fromPaths = null; }
			}
			return fromArray;
		}

		/**
		 * Tries to load the classes present in the array passed has second
		 * parameter from the ClassLoader passed has first parameter. Returns
		 * the HashMap of all the classed successfully loaded.
		 * 
		 * @param classLoader
		 *            ClassLoader used to find the class
		 * @param classNames
		 *            array of classes to load.
		 */
		public static java.util.Map loadClass(ClassLoader classLoader, String classNames[]) throws Exception {
			Class classloded = null;
			java.util.HashMap classHash = new java.util.HashMap();
			for (int i = 0; i < classNames.length; i++) {
				try 
				{
					classloded = classLoader.loadClass(classNames[i]);
					classHash.put(classNames[i], classloded);
				} 
				catch (Exception e) {
					log.warn("Could not load classes : " + e);
				}
			}
			return classHash;
		}

		/**
		 * Returns the ClassLoader to all the jars present in the dir passed has
		 * first parameter.
		 * 
		 * @param jarDir
		 *            path to the directory containing the jars
		 */
		public static ClassLoader getClassLoaderFromJars(String jarDir)
				throws Exception {
			if (log.isDebugEnabled()) log.debug("Getting ClassLoader for jars in " + jarDir);
			java.util.ArrayList list = new java.util.ArrayList();
			java.io.File jars[] = FileUtils.IFile.listSubFiles(jarDir, "*.jar");
			for (int j = 0; j < jars.length; j++){
				list.add(jars[j].toURI().toURL());
			}
			Object array[] = list.toArray();
			java.net.URL jarurl[] = new java.net.URL[array.length];
			for (int i = 0; i < array.length; i++){
				jarurl[i] = (java.net.URL) array[i];
			}
			java.net.URLClassLoader classLoader = java.net.URLClassLoader.newInstance(jarurl);
			return classLoader;
		}

		/**
		 * Returns the ClassLoader to a jar
		 * 
		 * @since 1.3.3
		 */
		public static ClassLoader getClassLoaderFromJar(String jarPath) throws Exception {
			java.io.File file = new java.io.File(jarPath);
			java.net.URL jarurl[] = { file.toURI().toURL() };
			java.net.URLClassLoader classLoader = java.net.URLClassLoader.newInstance(jarurl);
			return classLoader;
		}

		/**
		 * Returns the ClassLoader
		 * 
		 * @since 1.3.3
		 */
		public static ClassLoader getClassLoader(String path) throws Exception {
			java.io.File file = new java.io.File(path);
			if (file.canRead() == false) {
				log.warn("Could not read path: " + path);
				return null;
			}
			if (file.isDirectory())
				return getClassLoaderFromJars(path);
			else
				return getClassLoaderFromJar(path);
		}

		/**
		 * 返回properties文件
		 * 
		 * @param resource
		 * @param resource
		 *            如果conf/etc等根目录找不到，就到directory目录底下找
		 * @return properties
		 */
		public static java.util.Properties getProperties(String resource) {
			java.util.Properties properties = new java.util.Properties();
			try 
			{
				properties.load(getClassLoaderResource(resource));
			} 
			catch (java.lang.Exception e) {
				log.error("updcframe not load properties file: '" + resource
						+ "'" + "current thread :"
						+ Thread.currentThread().toString());
				properties = null;
			}
			return properties;
		}

		/**
		 * 
		 * @param filePath
		 * @param prefix
		 * @param isDiscardPrefix
		 * @return
		 * @throws Exception
		 */
		public static java.util.Properties loadPropertiesFromClassPath(
				String filePath, String prefix, boolean isDiscardPrefix)
				throws Exception {
			java.util.Properties rtn = new java.util.Properties();
			java.util.Properties pc = getProperties(filePath);
			java.util.Set key = pc.keySet();
			for (java.util.Iterator iter = key.iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				if (StringUtils.isBlank(prefix))
					rtn.put(element, pc.get(element));
				else if (StringUtils.indexOf(element, prefix) != -1) {
					if (isDiscardPrefix == true)
						rtn.put(StringUtils.replace(element, prefix + ".", "")
								.trim(), new String(pc.getProperty(element)
								.getBytes("ISO-8859-1"), "GBK"));
					else
						rtn.put(element, pc.get(element));
				}
			}
			return rtn;
		}

		/**
		 * 
		 * @param aFileName
		 * @return
		 */
		public static boolean isExistFile(String aFileName) {
			return getClassLoaderResource(aFileName) != null ? true : false;
		}

		/**
		 * 
		 * @param aResource
		 * @return
		 * @throws Exception
		 */
		public static java.io.InputStream getClassLoaderResource(
				String aResource) {
			java.io.InputStream result = Thread.currentThread().getContextClassLoader().getResourceAsStream(aResource);
			if (result == null){
				result = ClassUtils.class.getClassLoader().getResourceAsStream(
						aResource);
			}
			return result;
		}

		/**
		 * 
		 * @param aResource
		 * @return
		 * @throws Exception
		 */
		public static java.io.Reader getClassLoaderReader(String aResource) {
			return new java.io.InputStreamReader(
					getClassLoaderResource(aResource));
		}

		/**
		 * 对LIST实例进行排序
		 * 
		 * @param list
		 */
		public static void sort(java.util.List list) throws Exception {
			java.util.List fromList = null;
			try 
			{
				if (StringUtils.startWith(list.getClass().getName(), "java.util.")){
					java.util.Collections.sort(list);
				}
				else {
					fromList = new java.util.ArrayList();
					fromList.addAll(list);
					java.util.Collections.sort( fromList );
					list.clear();
					list.addAll( fromList );
				}
			} 
			finally {
				if (fromList != null) { fromList.clear(); fromList = null; }
			}
		}

		/**
		 * 
		 * @param fromList
		 * @param aComparator
		 */
		public static void sort(java.util.List fromList,
				java.util.Comparator aComparator) {
			try 
			{
				if (IClass.isJDKList(fromList)) {
					java.util.Collections.sort(fromList, aComparator);
				} else {
					Object[] fromArray = fromList.toArray();
					fromList.clear();
					java.util.Arrays.sort(fromArray, (java.util.Comparator) aComparator);
					for (int index = 0; index < fromArray.length; index++) {
						fromList.add(fromArray[index]);
					}
				}
			} 
			finally {

			}
		}
	}

	public static class IMerge {
		public IMerge() {
			super();
		}

		/**
		 * 判断两者是否相等
		 * 
		 * @param fromOLD
		 * @param fromNEW
		 * @return
		 */
		public static boolean equals(java.util.Map fromOLD,
				java.util.Map fromNEW) {
			try 
			{
				if (fromNEW.size() > 0 && fromOLD.size() <= 0)
					return false;
				else if (fromNEW.size() <= 0 && fromOLD.size() > 0)
					return false;
				else if (fromNEW.size() > 0 && fromOLD.size() > 0) {
					if (_equals(fromOLD, fromNEW) == false)
						return false;
					else if (_equals(fromNEW, fromOLD) == false)
						return false;
				}
			} 
			finally {

			}
			return true;
		}

		/**
		 * 判断fromOLD是否全部包含fromNEW中
		 * @param fromOLD
		 * @param fromNEW
		 * @return
		 */
		private static boolean _equals(java.util.Map fromOLD,
				java.util.Map fromNEW) {
			try 
			{
				for (java.util.Iterator itera = fromOLD.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
					Object fromKEY = fromEntry.getKey();
					Object fromOBJ = fromEntry.getValue();
					if (fromNEW.containsKey(fromKEY) == false){
						return false;
					}
					else {
						Object fromDEST = fromNEW.get(fromKEY);
						if (fromOBJ == null && fromDEST != null)
							return false;
						else if (fromOBJ != null && fromDEST == null)
							return false;
						else if (fromOBJ.equals(fromDEST) == false)
							return false;
					}
				}
			} 
			finally {

			}
			return true;
		}

		/**
		 * 判断两个对象是否相同
		 * @param fromLeft
		 * @param fromRight
		 * @return
		 */
		public static boolean equals(Object fromLeft, Object fromRight) {
			boolean fromEqual = false;
			try 
			{
				if (fromLeft == null && fromRight == null) {
					fromEqual = true;
				} 
				else if ((fromLeft != null && fromRight == null)
						|| (fromLeft == null && fromRight != null)) {
					fromEqual = false;
				} 
				else if (fromLeft.getClass().equals(fromRight.getClass()) == false) {
					fromEqual = false;
				} 
				else {
					fromEqual = fromLeft.equals(fromRight);
				}
			} 
			finally {

			}
			return fromEqual;
		}

		/**
		 * 根据键值删除集合中对象
		 * @param fromMap
		 * @param fromKEY 待删除键值
		 * @return
		 */
		public static java.util.Map purge(java.util.Map fromMap,
				String fromKEY[]) {
			try 
			{
				for (int index = 0; fromKEY != null && index < fromKEY.length; index++){
					fromMap.remove( fromKEY[index] );
				}
			} 
			finally {

			}
			return fromMap;
		}

		/**
		 * 根据fromDelete数组对象删除fromObject内数组对象
		 * @param fromDelete 删除对象
		 * @param fromObject 待删除对象
		 * @return
		 */
		public static Object[] purge(Object[] fromDelete, Object fromObject[]) {
			java.util.List fromRetain = new ArrayUQList();
			try 
			{
				IMerge.merge(fromObject, fromRetain);
				for( int index = 0; fromDelete != null && index < fromDelete.length; index++ ) {
					if (fromRetain.indexOf(fromDelete[index]) >= 0) {
						fromRetain.remove(fromDelete[index]);
					}
				}
				fromObject = IClass.arrayDesign(fromRetain);
			} 
			finally{
				if (fromRetain != null) { fromRetain.clear(); fromRetain = null; }
			}
			return fromObject;
		}

		/**
		 * 根据fromDelete列表对象删除fromList列表对象
		 * @param fromDelete
		 * @param fromList
		 * @return
		 */
		public static java.util.List purge(java.util.List fromDelete,
				java.util.List fromList) {
			try 
			{
				for (java.util.Iterator itera = fromDelete.iterator(); itera.hasNext();) {
					Object fromEntity = itera.next();
					if( fromList.indexOf( fromEntity ) >= 0 ){ fromList.remove( fromEntity ); }
				}
			} 
			finally {

			}
			return fromList;
		}

		/**
		 * 根据fromDelete列表对象删除fromSet列表对象
		 * @param fromDelete
		 * @param fromSet
		 * @return
		 */
		public static java.util.Set purge(java.util.Set fromDelete,
				java.util.Set fromSet ) {
			try 
			{
				for( java.util.Iterator itera = fromDelete.iterator(); itera.hasNext(); ){
					Object fromEntity = itera.next();
					if( fromSet.contains( fromEntity ) ){ fromSet.remove( fromEntity ); }
				}
			} 
			finally{

			}
			return fromSet;
		}

		/**
		 * 删除fromMap中键值为aPATTERN通配符数据
		 * @param fromMap
		 * @param pattern 键值通配符
		 * @param
		 */
		public static java.util.Map purge(java.util.Map fromMap, String pattern) {
			java.util.List fromDelete = new java.util.ArrayList();
			try 
			{
				for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					java.lang.String fromKEY = aEntry.getKey() != null ? aEntry.getKey().toString() : null;
					if (StringUtils.startWith(fromKEY, pattern) || StringUtils.wildcardMatch(fromKEY, pattern)) {
						fromDelete.add(aEntry.getKey());
					}
				}
				for( java.util.Iterator itera = fromDelete.iterator(); itera.hasNext(); ) {
					fromMap.remove(itera.next());
				}
			} 
			finally {
				if (fromDelete != null) { fromDelete.clear(); fromDelete = null; }
			}
			return fromMap;
		}

		/**
		 * 删除除fromObligate为键值外数据对象
		 * @param fromObligate 保留键值
		 * @param fromObject
		 */
		public static java.util.Map reserve(Object fromObligate[], java.util.Map fromMap) {
			java.util.Map fromField = new java.util.HashMap();
			java.util.List fromDelete = new java.util.ArrayList();
			try 
			{
				for (int index = 0; fromObligate != null && index < fromObligate.length; index++) {
					fromField.put(fromObligate[index], null);
				}
				for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry aEntry = (java.util.Map.Entry) itera.next();
					if( fromField.containsKey( aEntry.getKey() ) == false) {
						fromDelete.add(aEntry.getKey());
					}
				}
				for (java.util.Iterator itera = fromDelete.iterator(); itera.hasNext();) {
					fromMap.remove(itera.next());
				}
			} 
			finally {
				if (fromDelete != null) { fromDelete.clear(); fromDelete = null; }
				if (fromField != null) { fromField.clear(); fromField = null; }
			}
			return fromMap;
		}

		/**
		 * 把fromMap合并到toMap集合中(忽律toMap中存在元素)
		 * @param fromMap
		 * @param toMap
		 * @return
		 */
		public static java.util.Map merge(java.util.Map fromMap,
				java.util.Map toMap) {
			try 
			{
				if (fromMap != null) {
					for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
						java.util.Map.Entry e = (java.util.Map.Entry) itera.next();
						if (toMap.containsKey(e.getKey()) == false){
							toMap.put(e.getKey(), e.getValue());
						}
					}
				}
			} 
			finally {

			}
			return toMap;
		}

		/**
		 * 把fromMap合并到toMap集合中 
		 * @param fromMap
		 * @param toMap
		 * @param aOverWrite 如存在相同元素则是否合并
		 * @return
		 */
		public static java.util.Map merge(java.util.Map fromMap,
				java.util.Map toMap, 
				boolean aOverWrite) {
			try 
			{
				if (fromMap != null) {
					for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
						java.util.Map.Entry aEntry = (java.util.Map.Entry) itera.next();
						if( aOverWrite == true || toMap.containsKey(aEntry.getKey()) == false) {
							toMap.put(aEntry.getKey(), aEntry.getValue());
						}
					}
				}
			} 
			finally {

			}
			return toMap;
		}

		/**
		 * 把aProperties合并到fromObject集合中
		 * 
		 * @param aProperties
		 * @param fromObject
		 * @return
		 */
		public static java.util.Map merge(java.util.Properties aProperties,
				java.util.Map fromObject) {
			try 
			{
				for (java.util.Enumeration itera = aProperties.keys(); itera.hasMoreElements();) {
					String aKEY = (String) itera.nextElement();
					fromObject.put(aKEY, aProperties.getProperty(aKEY) );
				}
			} 
			finally {

			}
			return fromObject;
		}

		/**
		 * 把aOBJECT合并到toMap集合中
		 * @param aOBJECT
		 * @param fromMap
		 * @param aOverWrite 如存在相同元素则是否合并
		 * @return
		 */
		public static java.util.Map merge(Object aOBJECT[][],
				java.util.Map fromMap, 
				boolean aOverWrite) {
			try 
			{
				for (int index = 0; aOBJECT != null && index < aOBJECT.length; index++) {
					if (aOBJECT[index][1] == null) continue;
					if (aOverWrite == true){
						fromMap.put(aOBJECT[index][0], aOBJECT[index][1]);
					}
					else if (fromMap.containsKey(aOBJECT[index][0]) == false) {
						fromMap.put(aOBJECT[index][0], aOBJECT[index][1]);
					}
				}
			} 
			finally {

			}
			return fromMap;
		}

		/**
		 * 把aOBJECT合并到链表中[唯一性判断]
		 * @param aOBJECT
		 * @param toList
		 * @return
		 */
		public static java.util.List merge(Object aOBJECT[], java.util.List toList) {
			try 
			{
				for (int index = 0; aOBJECT != null && index < aOBJECT.length; index++) {
					int indexOf = toList.indexOf( aOBJECT[index] );
					if( indexOf >= 0 ) { toList.set( indexOf, aOBJECT[index] ); }
					else { toList.add( aOBJECT[index] ); }
				}
			} 
			finally {

			}
			return toList;
		}

		/**
		 * 把aOBJECT合并到链表中[忽虑唯一性判断]
		 * @param aOBJECT
		 * @param toList
		 * @return
		 */
		public static java.util.List mergeAsIgnore( Object aOBJECT[], java.util.List toList ){
			try 
			{
				for (int index = 0; aOBJECT != null && index < aOBJECT.length; index++) {
					toList.add( aOBJECT[index] );
				}
			} 
			finally {

			}
			return toList;
		}
		
		/**
		 * 把fromObject合并到链表toObject中
		 * 
		 * @param fromList
		 * @param toList
		 * @param
		 */
		public static java.util.List merge(java.util.List fromList,
				java.util.List toList) {
			try 
			{
				if (fromList == null) return toList;
				for (java.util.Iterator itera = fromList.iterator(); itera.hasNext();) {
					Object fromObject = itera.next();
					IMerge.merge(new Object[] { fromObject }, toList);
				}
			} 
			finally {

			}
			return toList;
		}

		/**
		 * 把fromObject合并到链表toObject中
		 * 
		 * @param fromObject
		 * @param toObject
		 * @return
		 */
		public static java.util.Set merge(java.util.Set fromObject,
				java.util.Set toObject) {
			try 
			{
				if( fromObject == null ) return toObject;
				for (java.util.Iterator itera = fromObject.iterator(); itera.hasNext();) {
					Object aOBJECT = itera.next();
					toObject.add(aOBJECT);
				}
			} 
			finally {

			}
			return toObject;
		}

		/**
		 * 两个数组合并为一个数组
		 * @param fromObject
		 * @param toObject
		 * @return
		 */
		public static Object[] merge(Object[] fromObject, Object toObject[]) {
			Object fromArray[] = null;
			try
			{
				fromArray = new Object[ (fromObject != null?fromObject.length:0) + 
				                        ( toObject != null?toObject.length:0 ) ];
				for( int index = 0; fromObject != null && index < fromObject.length; index++ ){
					fromArray[index] = fromObject[index];
				}
				for( int index = 0; toObject != null && index < toObject.length; index++ ){
					fromArray[ fromObject.length + index ] = toObject[index];
				}
			}
			finally{
				
			}
			return fromArray;
		}
		
		/**
		 * 两个数组合并为首位基础类同组数组[首位对象为基础类,如为NULL则全部合并]
		 * @param fromObject
		 * @param toObject
		 * @return
		 */
		public static Object[] arrayDesign( Object[] fromObject, Object toObject[] ){
			Object aOBJECT[] = null;
			java.util.List fromRetain = new ArrayUQList();
			try 
			{
				IMerge.merge( toObject, fromRetain );
				IMerge.merge( fromObject, fromRetain );
				aOBJECT = IClass.arrayDesign(fromRetain);
			} 
			finally{
				if (fromRetain != null) { fromRetain.clear(); fromRetain = null; }
			}
			return aOBJECT;
		}
		/**
		 * 根据fromMap中KEY删除toMap数据 
		 * @param fromMap 需要删除KEY
		 * @param toMap 被删除集合
		 * @return
		 */
		public static java.util.Map atomOut(java.util.Map fromMap, java.util.Map toMap) {
			try 
			{
				for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry aEntry = (java.util.Map.Entry) itera.next();
					Object fromKey = aEntry.getKey();
					Object fromDelete = aEntry.getValue();
					Object fromObject = toMap.get(fromKey);
					if (fromObject == null) continue;
					if (fromDelete != null && IClass.isArray(fromDelete)) {
						Object atomObject[] = IMerge.purge((Object[]) fromDelete, (Object[]) fromObject);
						if (atomObject == null || atomObject.length <= 0) {
							toMap.remove(fromKey);
						} 
						else{
							toMap.put(aEntry.getKey(), atomObject);
						}
					} 
					else if (fromDelete != null && IClass.isMap(fromDelete)) {
						java.util.Map atomObject = IMerge.atomOut( (java.util.Map)fromDelete, (java.util.Map)fromObject);
						if (atomObject == null || atomObject.size() <= 0) {
							toMap.remove(fromKey);
						}
					} 
					else if (fromDelete != null && IClass.isList(fromDelete)) {
						java.util.List atomObject = IMerge.purge( (java.util.List)fromDelete, (java.util.List)fromObject);
						if (atomObject == null || atomObject.size() <= 0) {
							toMap.remove(fromKey);
						}
					} 
					else if (fromDelete != null && IClass.isSet(fromDelete)) {
						java.util.Set atomObject = IMerge.purge( (java.util.Set) fromDelete, (java.util.Set) fromObject);
						if (atomObject == null || atomObject.size() <= 0) {
							toMap.remove(fromKey);
						}
					} 
					else if (fromDelete != null && fromDelete.equals(fromObject)) {
						toMap.remove(aEntry.getKey());
					}
				}
			} 
			finally {

			}
			return toMap;
		}
		/**
		 * 
		 * @param fromKEY
		 * @param fromEntity
		 * @param toMap
		 */
		public static void atomIn( Object fromKEY, Object fromEntity, java.util.Map toMap ){
			try
			{
				if( toMap.containsKey( fromKEY ) == false) {
					toMap.put(fromKEY, fromEntity);
				} 
				else if( fromEntity == null || toMap.get( fromKEY ) == null ) {
					if( fromEntity != null && toMap.get( fromEntity ) == null ) {
						toMap.put( fromKEY, fromEntity );
					}
				} 
				else if( IClass.isArray( fromEntity ) ) {
					Object fromObject[] = IMerge.arrayDesign( (Object[])fromEntity, (Object[])toMap.get( fromKEY ) );
					toMap.put( fromKEY, fromObject );
				} 
				else if( IClass.isContainer( fromEntity ) ) {
					OracleUtils.ICustom.transfer( (DataContainer)fromEntity, (DataContainer)toMap.get( fromKEY ) );
				}
				else if( ClassUtils.IClass.isMYSQL5( fromEntity ) ){
					HQSQLUtils.ICustom.transfer( (HQSQLEntityBean)fromEntity, (HQSQLEntityBean)toMap.get( fromKEY ) );
				}
				else if( IClass.isMap( fromEntity ) ) {
					IMerge.atomIn( (java.util.Map)fromEntity, (java.util.Map)toMap.get(fromKEY) );
				} 
				else if( IClass.isList( fromEntity ) ) {
					IMerge.merge( (java.util.List)fromEntity, (java.util.List) toMap.get(fromKEY) );
				} 
				else if( IClass.isSet(fromEntity) ) {
					IMerge.merge( (java.util.Set)fromEntity, (java.util.Set) toMap.get(fromKEY) );
				} 
				else{
					toMap.put( fromKEY, fromEntity );
				}
			}
			catch( java.lang.Exception aEXCEPTION ){
				ExceptionFactory.throwRuntime( aEXCEPTION );
			}
			finally{
				
			}
		}
		
		/**
		 * 把fromMap所有信息合并到toMap
		 * @param fromMap
		 * @param toMap
		 * @return
		 */
		public static java.util.Map atomIn(java.util.Map fromMap, java.util.Map toMap) {
			try 
			{
				for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
					if( fromEntry.getValue() == null ) continue;
					IMerge.atomIn(fromEntry.getKey(), fromEntry.getValue(), toMap);
				}
			} 
			finally {

			}
			return toMap;
		}
		
		/**
		 * 
		 * @param fromMap
		 * @param fromKEY
		 * @param toMap
		 */
		public static void atomIn(java.util.Map fromMap, Object fromKEY[], java.util.Map toMap ){
			try 
			{
				for (int index = 0; fromKEY != null && index < fromKEY.length; index++) {
					Object fromEntity = fromMap.get(fromKEY[index]);
					if (fromEntity == null) continue;
					IMerge.atomIn(fromKEY[index], fromEntity, toMap);
				}
			} 
			finally {

			}
		}
		
		/**
		 * 
		 * @param fromMap
		 * @param toMap
		 */
		public static java.util.Map atomDesign( java.util.Map fromMap, java.util.Map toMap ){
			try 
			{
				for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
					Object __key = fromEntry.getKey();
					Object __bottle = fromEntry.getValue();
					if( __bottle == null ){
						if( toMap.containsKey( __key ) ){ toMap.remove( __key ); }
					}
					else{
						if( IClass.isPrimitive( __key ) == false ){ __key = IClass.atomDesign( __key ); }
						if( IClass.isPrimitive( __bottle ) == false ){ __bottle = IClass.atomDesign( __bottle ); }
						toMap.put( __key, __bottle );
					}
				}
			} 
			catch( java.lang.Exception exception ){
				ExceptionFactory.throwRuntime( exception );
			}
			finally {

			}
			return toMap;
		}
	}

}
