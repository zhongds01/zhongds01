package com.ai.sacenter.valuebean;

import com.ai.appframe2.complex.xml.cfg.defaults.Property;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.base.basic.bo.ISACenterCatalog;
import com.ai.sacenter.base.basic.bo.ISACenterMapping;
import com.ai.sacenter.base.basic.bo.ISACenterWrapper;
import com.ai.sacenter.base.basic.bo.ISADistrict;
import com.ai.sacenter.base.basic.bo.ISAI18nResource;
import com.ai.sacenter.base.basic.bo.ISALibrary;
import com.ai.sacenter.base.basic.bo.ISAParallel;
import com.ai.sacenter.base.basic.bo.ISAPersistent;
import com.ai.sacenter.base.basic.bo.ISAPriorityBusines;
import com.ai.sacenter.base.basic.bo.ISAPriorityLimite;
import com.ai.sacenter.base.basic.bo.ISAPriorityCompete;
import com.ai.sacenter.base.basic.bo.ISAStatic;
import com.ai.sacenter.base.platform.bo.ISAOffice;
import com.ai.sacenter.base.basic.bo.ISACenter;
import com.ai.sacenter.base.basic.bo.ISADiction;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IPrimitive;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-4-26</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISystemTemplate implements java.io.Serializable{
	private static final long serialVersionUID = -8447582729535925156L;
	public ISystemTemplate() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 类结构说明</p>
	 * <p>Copyright: Copyright (c) 2012-3-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ISystemNative implements java.io.Serializable{
		private static final long serialVersionUID = 7470473871240511035L;
		private Class type;
		private java.util.List fields      = new java.util.ArrayList();
		private java.util.List constructor = new java.util.ArrayList();
		private java.util.List methods     = new java.util.ArrayList();
		private java.util.Map  natives     = new java.util.HashMap();
		public ISystemNative(Class aType){
			super();
			type = aType;
		}
		
		/**
		 * @return the constructor
		 */
		public java.util.List getConstructor() {
			return constructor;
		}

		/**
		 * @return the methods
		 */
		public java.util.List getMethods() {
			return methods;
		}
		
		/**
		 * @return the natives
		 */
		public java.util.Map getNatives() {
			return natives;
		}
		
		/**
		 * @return the fields
		 */
		public java.util.List getFields() {
			return fields;
		}
		
		/**
		 * @return the type
		 */
		public Class getType() {
			return type;
		}
		
		/**
		 * 
		 * @param methodName
		 * @param compatible
		 * @return
		 */
		public java.lang.reflect.Method getMethod( String methodName, Object compatible[] ){
			java.util.List methods = (java.util.List)natives.get( methodName );
			if( methods != null && methods.size() > 0 ){
				for( java.util.Iterator itera = methods.iterator(); itera.hasNext(); ){
					java.lang.reflect.Method _method = (java.lang.reflect.Method)itera.next();
					if( compatible( _method, compatible ) ){
						try{_method.setAccessible( true );}catch (SecurityException security){}
						return _method;
					}
				}
			}
			return null;
		}
		
		/**
		 * 
		 * @param methodName
		 * @param compatible
		 * @return
		 */
		public java.lang.reflect.Method getMethod( String methodName, Class compatible[] ){
			java.util.List aMethods = (java.util.List)natives.get( methodName );
			for( java.util.Iterator itera = aMethods.iterator(); itera.hasNext(); ){
				java.lang.reflect.Method method = (java.lang.reflect.Method)itera.next();
				if( assignable( method.getParameterTypes(), compatible ) ){
					try{method.setAccessible( true );}catch (SecurityException security){}
					return method;
				}
			}
			return null;
		}
		
		/**
		 * 获取参数列表对应构造函数,如不存在返回空对象
		 * @param compatible 参数列表
		 * @return
		 */
		public java.lang.reflect.Constructor getConstructor( Class compatible[] ){
			for( java.util.Iterator itera = constructor.iterator(); itera.hasNext(); ){
				java.lang.reflect.Constructor _constructor = (java.lang.reflect.Constructor)itera.next();
				if( assignable( _constructor.getParameterTypes(), compatible ) ){
					try{_constructor.setAccessible( true );}catch (SecurityException security){}
					return _constructor;
				}
			}
			return null;
		}
		
		/**
		 * 
		 * @param method
		 * @param parameter
		 * @return
		 */
		private boolean compatible( java.lang.reflect.Method method, Object compatible[] ){
			Class parameterType[] = method.getParameterTypes();
			if( compatible == null && parameterType.length == 0 ){
				return true;
			}
			else if( compatible.length == 0 && parameterType.length == 0 ){
				return true;
			}
			else if( parameterType.length != compatible.length ){
				return false;
			}
			else{
				for( int index = 0; index < parameterType.length; index++ ){
					if( compatible[index] == null ) continue;
					if( compatible(parameterType[index], compatible[index] ) == false ){
						return false;
					}
				}
			}
			return true;
		}
		
		/**
		 * 
		 * @param method
		 * @param parameter
		 * @return
		 */
		private boolean assignable( Class parameterType[], Class compatible[] ){
			if( compatible == null && parameterType.length == 0 ){
				return true;
			}
			else if( compatible.length == 0 && parameterType.length == 0 ){
				return true;
			}
			else if( parameterType.length != compatible.length ){
				return false;
			}
			else{
				for( int index = 0; index < parameterType.length; index++ ){
					if( compatible[index] == null ) continue;
					if( assignable(parameterType[index], compatible[index] ) == false ){
						return false;
					}
				}
			}
			return true;
		}
		
		/**
		 * 
		 * @param parameterType
		 * @param compatible
		 * @return
		 */
		private boolean compatible( Class parameterType, Object compatible ){
			Class compatibleType = compatible != null?compatible.getClass():null;
			if( compatible == null ){
				return true;
			}
			else if( parameterType.isAssignableFrom( compatibleType ) ){
				return true;
			}
			else if( String.class.equals( parameterType ) ){
				if( compatible instanceof java.lang.String ){
					return true;
				}
				else if( ClassUtils.IClass.isPrimitive( compatible ) ){
					return true;
				}
			}
			else if( Boolean.TYPE.equals( parameterType ) || Boolean.class.equals( parameterType ) ){
				if( Boolean.TYPE.equals( compatibleType ) || compatible instanceof Boolean ){
					return true;
				}
				else if( compatible instanceof String ){
					return StringUtils.containsIgnoreCase( compatible.toString(), 
							new String[]{ Boolean.TRUE.toString(), Boolean.FALSE.toString() } );
				}
			}
			else if( Character.TYPE.equals( parameterType ) || Character.class.equals( parameterType ) ){
				if( Character.TYPE.equals( compatibleType ) || compatible instanceof Character ){
					return true;
				}
				else if( compatible instanceof String ){
					return ((String)compatible).length() == 1?true:false;
				}
			}
			else if( Byte.TYPE.equals( parameterType ) || Byte.class.equals( parameterType ) ){
				if( Byte.TYPE.equals( compatibleType ) || compatible instanceof Byte ){
					return true;
				}
				else if( compatible instanceof java.lang.Number ){
					java.lang.Number _number = (java.lang.Number)compatible;
					return _number.longValue() >= Byte.MIN_VALUE && _number.longValue() <= Byte.MAX_VALUE;
				}
				else if( compatible instanceof String && MathUtils.isDecimal( (String)compatible ) ){
					java.lang.Number _number = new java.math.BigDecimal( (String)compatible );
					return _number.longValue() >= Byte.MIN_VALUE && _number.longValue() <= Byte.MAX_VALUE;
				}
			}
			else if( Short.TYPE.equals( parameterType ) || Short.class.equals( parameterType ) ){
				if( Short.TYPE.equals( compatibleType ) || compatible instanceof Short ){
					return true;
				}
				else if( compatible instanceof java.lang.Number ){
					java.lang.Number _number = (java.lang.Number)compatible;
					return _number.longValue() >= Short.MIN_VALUE && _number.longValue() <= Short.MAX_VALUE;
				}
				else if( compatible instanceof String && MathUtils.isDecimal( (String)compatible ) ){
					java.lang.Number _number = new java.math.BigDecimal( (String)compatible );
					return _number.longValue() >= Short.MIN_VALUE && _number.longValue() <= Short.MAX_VALUE;
				}
			}
			else if( Integer.TYPE.equals( parameterType ) || Integer.class.equals( parameterType ) ){
				if( Integer.TYPE.equals( compatibleType ) || compatible instanceof Integer ){
					return true;
				}
				else if( compatible instanceof java.lang.Number ){
					java.lang.Number _number = (java.lang.Number)compatible;
					return _number.longValue() >= Integer.MIN_VALUE && _number.longValue() <= Integer.MAX_VALUE;
				}
				else if( compatible instanceof String && MathUtils.isDecimal( (String)compatible ) ){
					java.lang.Number _number = new java.math.BigDecimal( (String)compatible );
					return _number.longValue() >= Integer.MIN_VALUE && _number.longValue() <= Integer.MAX_VALUE;
				}
			}
			else if( Long.TYPE.equals( parameterType ) || Long.class.equals( parameterType ) ){
				if( Long.TYPE.equals( compatibleType ) || compatible instanceof Long ){
					return true;
				}
				else if( compatible instanceof java.lang.Number ){
					java.lang.Number _number = (java.lang.Number)compatible;
					return _number.longValue() >= Long.MIN_VALUE && _number.longValue() <= Long.MAX_VALUE;
				}
				else if( compatible instanceof String && MathUtils.isDecimal( (String)compatible ) ){
					java.lang.Number _number = new java.math.BigDecimal( (String)compatible );
					return _number.longValue() >= Long.MIN_VALUE && _number.longValue() <= Long.MAX_VALUE;
				}
			}
			else if( Float.TYPE.equals( parameterType ) || Float.class.equals( parameterType ) ){
				if( Float.TYPE.equals( compatibleType ) || compatible instanceof Float ){
					return true;
				}
				else if( compatible instanceof java.lang.Number ){
					java.lang.Number _number = (java.lang.Number)compatible;
					return _number.longValue() >= Float.MIN_VALUE && _number.longValue() <= Float.MAX_VALUE;
				}
				else if( compatible instanceof String && MathUtils.isDecimal( (String)compatible ) ){
					java.lang.Number _number = new java.math.BigDecimal( (String)compatible );
					return _number.longValue() >= Float.MIN_VALUE && _number.longValue() <= Float.MAX_VALUE;
				}
			}
			else if( Double.TYPE.equals( parameterType ) || Double.class.equals( parameterType ) ){
				if( Double.TYPE.equals( compatibleType ) || compatible instanceof Double ){
					return true;
				}
				else if( compatible instanceof java.lang.Number ){
					java.lang.Number _number = (java.lang.Number)compatible;
					return _number.longValue() >= Double.MIN_VALUE && _number.longValue() <= Double.MAX_VALUE;
				}
				else if( compatible instanceof String && MathUtils.isDecimal( (String)compatible ) ){
					java.lang.Number _number = new java.math.BigDecimal( (String)compatible );
					return _number.longValue() >= Double.MIN_VALUE && _number.longValue() <= Double.MAX_VALUE;
				}
			}
			return false;
		}
		
		/**
		 * 
		 * @param parameterType
		 * @param parameterization
		 * @return
		 */
		private boolean assignable( Class parameterType, Class compatible ){
			if( compatible == null ){
				return true;
			}
			else if( parameterType.isAssignableFrom( compatible ) ){
				return true;
			}
			else if( String.class.equals( parameterType ) ){
				if( parameterType.equals( compatible ) ){
					return true;
				}
				else if( ClassUtils.IClass.isPrimitive( compatible ) ){
					return true;
				}
			}
			else if( Boolean.TYPE.equals( parameterType ) || Boolean.class.equals( parameterType ) ){
				if( Boolean.TYPE.equals( compatible ) || Boolean.class.equals( compatible ) ){
					return true;
				}
				else if( String.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Character.TYPE.equals( parameterType ) || Character.class.equals( parameterType ) ){
				if( Character.TYPE.equals( compatible ) || Character.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Byte.TYPE.equals( parameterType ) || Byte.class.equals( parameterType ) ){
				if( Byte.TYPE.equals( compatible ) || Byte.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Short.TYPE.equals( parameterType ) || Short.class.equals( parameterType ) ){
				if( Short.TYPE.equals( compatible ) || Short.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Integer.TYPE.equals( parameterType ) || Integer.class.equals( parameterType ) ){
				if( Integer.TYPE.equals( compatible ) || Integer.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Long.TYPE.equals( parameterType ) || Long.class.equals( parameterType ) ){
				if( Long.TYPE.equals( compatible ) || Long.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Float.TYPE.equals( parameterType ) || Float.class.equals( parameterType ) ){
				if( Float.TYPE.equals( compatible ) || Float.class.equals( compatible ) ){
					return true;
				}
			}
			else if( Double.TYPE.equals( parameterType ) || Double.class.equals( parameterType ) ){
				if( Double.TYPE.equals( compatible ) || Double.class.equals( compatible ) ){
					return true;
				}
			}
			return false;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IEnumWrapper implements java.io.Serializable{
		private static final long serialVersionUID = 5865154924322072290L;
		private String ID           ;
		private String NAME         ;
		private String CATEGORY     ;
		private String DESCRIPTION  ;
		private String TARGET       ;
		private String COMPLEX      ;
		private String STATE        ;
		private String EXTEND_ATTR_A;
		private String EXTEND_ATTR_B;
		private String EXTEND_ATTR_C;
		private String EXTEND_ATTR_D;
		private String EXTEND_ATTR_E;
		private String EXTEND_ATTR_F;
		private String EXTEND_ATTR_G;
		private String EXTEND_ATTR_H;
		private String EXTEND_ATTR_I;
		private String EXTEND_ATTR_J;
		private String EXTEND_ATTR_K;
		private String EXTEND_ATTR_L;
		private String EXTEND_ATTR_M;
		private String EXTEND_ATTR_N;
		private String EXTEND_ATTR_O;
		public IEnumWrapper( ISADiction aDiction ){
			super();
			ID            = aDiction.getCode         ();
			NAME          = aDiction.getName         ();
			CATEGORY      = aDiction.getCategory     ();
			DESCRIPTION   = aDiction.getDescription  ();
			TARGET        = aDiction.getTarget       ();
			COMPLEX       = aDiction.getComplex      ();
			STATE         = aDiction.getState        ();
			EXTEND_ATTR_A = aDiction.getExtendAttrA  ();
			EXTEND_ATTR_B = aDiction.getExtendAttrB  ();
			EXTEND_ATTR_C = aDiction.getExtendAttrC  ();
			EXTEND_ATTR_D = aDiction.getExtendAttrD  ();
			EXTEND_ATTR_E = aDiction.getExtendAttrE  ();
			EXTEND_ATTR_F = aDiction.getExtendAttrF  ();
			EXTEND_ATTR_G = aDiction.getExtendAttrG  ();
			EXTEND_ATTR_H = aDiction.getExtendAttrH  ();
			EXTEND_ATTR_I = aDiction.getExtendAttrI  ();
			EXTEND_ATTR_J = aDiction.getExtendAttrJ  ();
			EXTEND_ATTR_K = aDiction.getExtendAttrK  ();
			EXTEND_ATTR_L = aDiction.getExtendAttrL  ();
			EXTEND_ATTR_M = aDiction.getExtendAttrM  ();
			EXTEND_ATTR_N = aDiction.getExtendAttrN  ();
			EXTEND_ATTR_O = aDiction.getExtendAttrO  ();
		}
		
		public IEnumWrapper( String aID , String aCATEGORY, String aTARGET ){
			super();
			ID = aID;
			CATEGORY = aCATEGORY;
			TARGET = aTARGET;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @return the eXTEND_ATTR_A
		 */
		public String getEXTEND_ATTR_A() {
			return EXTEND_ATTR_A;
		}
		
		/**
		 * @return the eXTEND_ATTR_B
		 */
		public String getEXTEND_ATTR_B() {
			return EXTEND_ATTR_B;
		}
		
		/**
		 * @return the eXTEND_ATTR_C
		 */
		public String getEXTEND_ATTR_C() {
			return EXTEND_ATTR_C;
		}
		
		/**
		 * @return the eXTEND_ATTR_D
		 */
		public String getEXTEND_ATTR_D() {
			return EXTEND_ATTR_D;
		}
		
		/**
		 * @return the eXTEND_ATTR_E
		 */
		public String getEXTEND_ATTR_E() {
			return EXTEND_ATTR_E;
		}
		
		/**
		 * @return the eXTEND_ATTR_F
		 */
		public String getEXTEND_ATTR_F() {
			return EXTEND_ATTR_F;
		}
		
		/**
		 * @return the eXTEND_ATTR_G
		 */
		public String getEXTEND_ATTR_G() {
			return EXTEND_ATTR_G;
		}
		
		/**
		 * @return the eXTEND_ATTR_H
		 */
		public String getEXTEND_ATTR_H() {
			return EXTEND_ATTR_H;
		}
		
		/**
		 * @return the eXTEND_ATTR_I
		 */
		public String getEXTEND_ATTR_I() {
			return EXTEND_ATTR_I;
		}
		
		/**
		 * @return the eXTEND_ATTR_J
		 */
		public String getEXTEND_ATTR_J() {
			return EXTEND_ATTR_J;
		}
		
		/**
		 * @return the eXTEND_ATTR_K
		 */
		public String getEXTEND_ATTR_K() {
			return EXTEND_ATTR_K;
		}
		
		/**
		 * @return the eXTEND_ATTR_L
		 */
		public String getEXTEND_ATTR_L() {
			return EXTEND_ATTR_L;
		}
		
		/**
		 * @return the eXTEND_ATTR_M
		 */
		public String getEXTEND_ATTR_M() {
			return EXTEND_ATTR_M;
		}
		
		/**
		 * @return the eXTEND_ATTR_N
		 */
		public String getEXTEND_ATTR_N() {
			return EXTEND_ATTR_N;
		}
		
		/**
		 * @return the eXTEND_ATTR_O
		 */
		public String getEXTEND_ATTR_O() {
			return EXTEND_ATTR_O;
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @return the sTATE
		 */
		public String getSTATE() {
			return STATE;
		}
		
		/**
		 * @return the tARGET
		 */
		public String getTARGET() {
			return TARGET;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IEnumGroup implements java.io.Serializable{
		private static final long serialVersionUID = -33402994462966517L;
		private String ID;
		private java.util.Map GROUP = new java.util.HashMap();
		public IEnumGroup( ISADiction fromDiction ){
			super();
			ID = fromDiction.getCategory();
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * 
		 * @param _diction
		 */
		public void mergeAsEnum( ISADiction _diction ){
			try
			{
				ISystemTemplate.IEnumWrapper fromEnum = new ISystemTemplate.IEnumWrapper( _diction );
				GROUP.put( fromEnum.getID(), fromEnum );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param aSTATIC
		 * @return
		 */
		public IEnumWrapper getENUM( String aSTATIC ){
			return (IEnumWrapper)GROUP.get( aSTATIC );
		}
		
		/**
		 * @return the cATALOG
		 */
		public java.util.Map getGROUP() {
			return GROUP;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年8月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IStaticCategory implements java.io.Serializable{
		private static final long serialVersionUID = 6693916617093099505L;
		private String _group   ;
		private java.util.ArrayList<IStaticOffer> _category = new java.util.ArrayList<IStaticOffer>();
		public IStaticCategory( IStaticOffer aSTATIC ){
			super();
			_group = aSTATIC.getCATEGORY();
		}
		
		/**
		 * @return 编码
		 */
		public String getGROUP() {
			return _group;
		}
		
		/**
		 * @param gROUP 编码
		 */
		public void setGROUP(String gROUP) {
			_group = gROUP;
		}

		/**
		 * @return the _category
		 */
		public java.util.ArrayList<IStaticOffer> getCATEGORY() {
			return _category;
		}
		
		/**
		 * 获取首端静态规范
		 * @param _static_
		 * @return
		 */
		public IStaticOffer getLITTLE( String _static_ ){
			IStaticOffer __static__ = null;
			for( java.util.Iterator<IStaticOffer> itera = _category.iterator(); itera.hasNext(); ){
				IStaticOffer ___static___ = (IStaticOffer)itera.next();
				if( StringUtils.equals( ___static___.getCODE(), _static_ ) ){
					__static__ = ___static___;
					break;
				}
			}
			return __static__;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年6月6日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IStaticGroup implements java.io.Serializable{
		private static final long serialVersionUID = 4712962327022725096L;
		private String _group   ;
		private String _category;
		private java.util.HashMap _static = new java.util.HashMap();
		public IStaticGroup( IStaticOffer aSTATIC){
			super();
			_group    = aSTATIC.getCODE    ();
			_category = aSTATIC.getCATEGORY();
		}
		
		/**
		 * @return 编码
		 */
		public String getGROUP() {
			return _group;
		}
		
		/**
		 * @param gROUP 编码
		 */
		public void setGROUP(String gROUP) {
			_group = gROUP;
		}
		
		/**
		 * @return 类型
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param cATEGORY 类型
		 */
		public void setCATEGORY(String cATEGORY) {
			_category = cATEGORY;
		}

		/**
		 * @return 静态列表
		 */
		public java.util.HashMap getSTATIC() {
			return _static;
		}
		
		/**
		 * 
		 * @param aSTATIC
		 */
		public void mergeAsGroup( IStaticOffer aSTATIC ){
			try
			{
				_static.put( aSTATIC.getVALUE(), aSTATIC );
			}
			finally{
				
			}
		}
		
		/**
		 * 获取首端静态规范
		 * @return
		 */
		public IStaticOffer getLITTLE(){
			IStaticOffer fromStatic = null;
			try
			{
				for( java.util.Iterator itera = _static.values().iterator(); itera.hasNext(); ){
					fromStatic = (IStaticOffer)itera.next();
					if( fromStatic != null ){ break; }
				}
			}
			finally{
				
			}
			return fromStatic;
		}
		
		/**
		 * 根据静态值获取静态规范
		 * @param aSTATIC 静态值
		 * @return
		 */
		public IStaticOffer getSTATIC( String aSTATIC ){
			return (IStaticOffer)_static.get( aSTATIC );
		}
		
		/**
		 * 获取静态规范组
		 * @return
		 */
		public IStaticOffer[] getAsGroup(){
			return (IStaticOffer[])_static.values().toArray( new IStaticOffer[]{} );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IStaticOffer implements java.io.Serializable{
		private static final long serialVersionUID = -7953850463872914379L;
		private long   ID         ;
		private String CODE       ;
		private String NAME       ;
		private String CATEGORY   ;
		private long   SORT_BY    ;
		private String ALIAS      ;
		private String DESCRIPTION;
		private String VALUE      ;
		private String EXTEND     ;
		private String STATE      ;
		public IStaticOffer( ISAStatic aStatic ){
			super();
			ID          = aStatic.getId         ();
			CODE        = aStatic.getCode       ();
			NAME        = aStatic.getName       ();
			CATEGORY    = aStatic.getKind       ();
			SORT_BY     = aStatic.getSortId     ();
			ALIAS       = aStatic.getAlias      ();
			DESCRIPTION = aStatic.getDescription();
			VALUE       = aStatic.getValue      ();
			EXTEND      = aStatic.getExtern     ();
			STATE       = aStatic.getState      ();
		}
		
		/**
		 * @return the aLIAS
		 */
		public String getALIAS() {
			return ALIAS;
		}
		
		/**
		 * @return the cODE
		 */
		public String getCODE() {
			return CODE;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @return the eXTEND
		 */
		public String EXTEND() {
			return EXTEND;
		}
		
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}
		
		/**
		 * @return the sTATE
		 */
		public String getSTATE() {
			return STATE;
		}
		
		/**
		 * @return the vALUE
		 */
		public String getVALUE() {
			return VALUE;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-5-29</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmDistrict implements java.io.Serializable{
		private static final long serialVersionUID = -1143266898678351761L;
	    private long   ID         ;
		private String CODE       ;
		private String NAME       ;
		private String ENGLISH    ;
		private long   PARENT     ;
		private String DESCRIPTION;
		private long   TYPE       ;
		private String CONTROL    ;
		private String CENTER     ;
		private long   COURSE     ;
		private long   TWO_NUMBER ;
		private String AREA_CODE  ;
		private String REGION_CODE;
		public IUpfgkmDistrict(ISADistrict aDistrict){
			super();
			ID          = aDistrict.getDistrictId     ();
			CODE        = aDistrict.getDistrictCode   ();
			NAME        = aDistrict.getDistrictName   ();
			ENGLISH     = aDistrict.getEnglishName    ();
			PARENT      = aDistrict.getParentDistrict ();
			DESCRIPTION = aDistrict.getDescription    ();
			TYPE        = aDistrict.getDistrictTypeId ();
			CONTROL     = aDistrict.getControl        ();
			CENTER      = aDistrict.getCenterCode     ();
			COURSE      = aDistrict.getCourseFlag     ();
			TWO_NUMBER  = aDistrict.getTwoNumber      ();
			AREA_CODE   = aDistrict.getAreaCode       ();
			REGION_CODE = aDistrict.getRegionCode     ();
		}
		
		/**
		 * @return the aREA_CODE
		 */
		public String getAREA_CODE() {
			return AREA_CODE;
		}

		/**
		 * @return the cENTER
		 */
		public String getCENTER() {
			return CENTER;
		}

		/**
		 * @return the cODE
		 */
		public String getCODE() {
			return CODE;
		}

		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @return the cOURSE
		 */
		public long getCOURSE() {
			return COURSE;
		}

		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}

		/**
		 * @return the eNGLISH
		 */
		public String getENGLISH() {
			return ENGLISH;
		}

		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}

		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}

		/**
		 * @return the pARENT
		 */
		public long getPARENT() {
			return PARENT;
		}

		/**
		 * @return the rEGION_CODE
		 */
		public String getREGION_CODE() {
			return REGION_CODE;
		}

		/**
		 * @return the tWO_NUMBER
		 */
		public long getTWO_NUMBER() {
			return TWO_NUMBER;
		}

		/**
		 * @return the tYPE
		 */
		public long getTYPE() {
			return TYPE;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IImplCapital extends IPrimitive{
		private static final long serialVersionUID = -88962383719397601L;
		private String NAME         ;                                                                                                                                                                                     
		private String CATEGORY     ;
		private String COMPLEX      ;
		private String CONTROL      ;
		public IImplCapital( ISALibrary aLibrary ){
			super( );
			ID            = aLibrary.getId         ();                                                                                                                                                                                     
			NAME          = aLibrary.getName       ();                                                                                                                                                                                     
			CATEGORY      = aLibrary.getCategory   ();
			DESCRIBE      = aLibrary.getDescribe   ();                                                                                                                                                                                     
			IMPLCLASS     = aLibrary.getImplclass  ();                                                                                                                                                                                     
			METHOD        = aLibrary.getMethod     ();
			COMPLEX       = aLibrary.getComplex    ();
			CONTROL       = aLibrary.getControl    ();
			JdomUtils.ICustom.wrap( COMPLEX , GRAPHICS );
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}
		
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param name the nAME to set
		 */
		public void setNAME(String name) {
			NAME = name;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isJMDI() {
			return StringUtils.isBlank(IMPLCLASS) == false
					&& StringUtils.isBlank(METHOD) == false;
		}
		
		/**
		 * 获取支持服务方法类
		 * @param parameterTypes
		 * @return
		 * @throws Exception
		 */
		public java.lang.reflect.Method getMethod( Class parameterTypes[] ) throws Exception{
			java.lang.reflect.Method fromMethod = null;
			try
			{
				fromMethod = ReflectUtils.IReflect.getMethod( IMPLCLASS, 
						METHOD, 
						parameterTypes );
			}
			finally{
				
			}
			return fromMethod;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-4-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICenterRoute implements java.io.Serializable{
		private static final long serialVersionUID = -3651161542077826965L;
		private long   ID           ;
		private String ROUTE        ;
		private String CATEGORY     ;
		private String PLATFORM_    ;
		private String DESCRIPTION  ;
		private String CENTER       ;
		private long   NUMBER       ;
		public ICenterRoute( ISACenter aCenter ){
			super();
			ID            = aCenter.getId          () ;
			ROUTE         = aCenter.getRoute       () ;
			CATEGORY      = aCenter.getCategory    () ;
			PLATFORM_     = aCenter.getPlatform    () ;
			DESCRIPTION   = aCenter.getDescription () ;
			CENTER        = aCenter.getCenter      () ;
			NUMBER        = aCenter.getRegionNumber() ;
		}
		
		public ICenterRoute( String aROUTE , String aCENTER , String aCATEGORY, String aPLATFORM ){
			ID = 0;
			ROUTE = aROUTE;
			CENTER = aCENTER;
			CATEGORY = aCATEGORY;
			PLATFORM_ = aPLATFORM;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}
		
		/**
		 * @return the cENTER
		 */
		public String getCENTER() {
			return CENTER;
		}
		
		/**
		 * @param center the cENTER to set
		 */
		public void setCENTER(String center) {
			CENTER = center;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}
		
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		
		/**
		 * @param id the iD to set
		 */
		public void setID(long id) {
			ID = id;
		}
		
		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}
		
		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}
		
		/**
		 * @return the rOUTE
		 */
		public String getROUTE() {
			return ROUTE;
		}
		
		/**
		 * @param route the rOUTE to set
		 */
		public void setROUTE(String route) {
			ROUTE = route;
		}
		
		/**
		 * @return the nUMBER
		 */
		public long getNUMBER() {
			return NUMBER;
		}
		
		/**
		 * @param nUMBER the nUMBER to set
		 */
		public void setNUMBER(long nUMBER) {
			NUMBER = nUMBER;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年1月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICenterGroup implements java.io.Serializable{
		private static final long serialVersionUID = 3993251592651187559L;
		private String PLATFORM ;
		private String CATEGORY ;
		private java.util.Map SUBFLOW = new java.util.HashMap();
		private java.util.Map CENTER  = new java.util.HashMap();
		public ICenterGroup( ISACenter aCenter ){
			super();
			PLATFORM = aCenter.getPlatform();
			CATEGORY = aCenter.getCategory();
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param pLATFORM the pLATFORM to set
		 */
		public void setPLATFORM(String pLATFORM) {
			PLATFORM = pLATFORM;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return 地市编码中心路由
		 */
		public java.util.Map getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * @return 地市编号中心路由
		 */
		public java.util.Map getCENTER() {
			return CENTER;
		}
		
		/**
		 * 
		 * @param aCenter
		 */
		public void mergeAsGroup( ISACenter aCenter ){
			try
			{
				ICenterRoute fromCenter = new ISystemTemplate.ICenterRoute( aCenter );
				SUBFLOW.put( fromCenter.getROUTE(), fromCenter );
				if( fromCenter.getNUMBER() > 0 ){
					CENTER.put( String.valueOf( fromCenter.getNUMBER() ), fromCenter );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 根据地市编码获取地市中心路由
		 * @param fromRoute 地市编码
		 * @return
		 */
		public ICenterRoute getSUBFLOW( String fromRoute ){
			return (ICenterRoute)SUBFLOW.get( fromRoute );
		}
		
		/**
		 * 根据地市编号获取地市中心路由
		 * @param fromRoute 地市编码
		 * @return
		 */
		public ICenterRoute getCENTER( String fromNumber ){
			return (ICenterRoute)CENTER.get( fromNumber );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年6月12日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICenterCatalog implements java.io.Serializable{
		private static final long serialVersionUID = -683644614146967662L;
		private String ID       ;
		private String NAME     ;
		private String CATEGORY ;
		private String DESCRIBE ;
		private String IMPLCLASS;
		private String PLATFORM ;
		private String COMPOSITE;
		private String COMPLEX  ;
		public ICenterCatalog(ISACenterCatalog aCatalog){
			super();
			ID        = String.valueOf(aCatalog.getId());
			NAME      = aCatalog.getName     ();
			CATEGORY  = aCatalog.getCategory ();
			DESCRIBE  = aCatalog.getDescribe ();
			IMPLCLASS = aCatalog.getImplclass();
			PLATFORM  = aCatalog.getPlatform ();
			COMPOSITE = aCatalog.getComposite();
			COMPLEX   = aCatalog.getComplex  ();
		}
		
		public ICenterCatalog(Property aCatalog){
			super();
			ID        = String.valueOf( aCatalog.hashCode() );
			NAME      = aCatalog.getName              ();
			CATEGORY  = IUpdcConst.IUpdbm.IUpdbf.SUBFLOW;
			DESCRIBE  = aCatalog.getName              ();
			IMPLCLASS = aCatalog.getName              ();
			PLATFORM  = IUpdcConst.IUpfwm.IUpfm.ucmframe;
			COMPOSITE = aCatalog.getValue             ();
		}
		
		public ICenterCatalog(Class _catalog, String _composite){
			super();
			ID        = String.valueOf( _catalog.hashCode() );
			NAME      = _catalog.getName              ();
			CATEGORY  = IUpdcConst.IUpdbm.IUpdbf.SUBFLOW;
			DESCRIBE  = _catalog.getName              ();
			IMPLCLASS = _catalog.getName              ();
			PLATFORM  = IUpdcConst.IUpfwm.IUpfm.ucmframe;
			COMPOSITE = _composite                      ;
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return the dESCRIBE
		 */
		public String getDESCRIBE() {
			return DESCRIBE;
		}
		
		/**
		 * @param dESCRIBE the dESCRIBE to set
		 */
		public void setDESCRIBE(String dESCRIBE) {
			DESCRIBE = dESCRIBE;
		}
		
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		
		/**
		 * @param iMPLCLASS the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String iMPLCLASS) {
			IMPLCLASS = iMPLCLASS;
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param pLATFORM the pLATFORM to set
		 */
		public void setPLATFORM(String pLATFORM) {
			PLATFORM = pLATFORM;
		}
		
		/**
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}
		
		/**
		 * @param cOMPOSITE the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String cOMPOSITE) {
			COMPOSITE = cOMPOSITE;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年1月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICenterCombine implements java.io.Serializable{
		private static final long serialVersionUID = -8091983475540943833L;
		private String GROUP ;
		private java.util.Map COMBINE = new java.util.HashMap();
		public ICenterCombine( String group ){
			super();
			GROUP = group;
		}
		
		public ICenterCombine( ISACenterCatalog aCatalog ){
			super();
			GROUP = aCatalog.getCategory();
		}
		
		/**
		 * @return the gROUP
		 */
		public String getGROUP() {
			return GROUP;
		}
		
		/**
		 * @param gROUP the gROUP to set
		 */
		public void setGROUP(String gROUP) {
			GROUP = gROUP;
		}
		
		/**
		 * @return the cOMBINE
		 */
		public java.util.Map getCOMBINE() {
			return COMBINE;
		}
		
		/**
		 * 
		 * @param aCatalog
		 */
		public void mergeAsCatalog( ISACenterCatalog aCatalog ){
			try
			{
				ICenterCatalog fromCatalog = new ICenterCatalog( aCatalog );
				COMBINE.put( fromCatalog.getIMPLCLASS(), fromCatalog );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param aCatalog
		 */
		public void mergeAsCatalog( ICenterCatalog aCatalog ){
			try
			{
				COMBINE.put( aCatalog.getIMPLCLASS(), aCatalog );
			}
			finally{
				
			}
		}
		
		/**
		 * 根据类路径获取当前类路径配置
		 * @param aIMPLCLASS
		 * @return
		 */
		public ICenterCatalog getCatalog( String aIMPLCLASS ){
			ICenterCatalog fromCatalog = null;
			java.util.List fromXPath = new java.util.ArrayList();
			try
			{
				String aFUNCTION[] = StringUtils.wildcardArray( aIMPLCLASS, "." );
				ClassUtils.IMerge.merge( aFUNCTION, fromXPath );
				while( fromXPath != null && fromXPath.size() > 0 ){
					aIMPLCLASS = StringUtils.join( fromXPath.iterator(), "." );
					fromCatalog = (ICenterCatalog)COMBINE.get( aIMPLCLASS );
					if( fromCatalog != null ) break;
					fromXPath.remove( fromXPath.size() - 1 );
				} 
			}
			finally{
				if (fromXPath != null) { fromXPath.clear(); fromXPath = null; }
			}
			return fromCatalog;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年6月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbcWrapper implements java.io.Serializable{
		private static final long serialVersionUID = 6831585833451588968L;
		protected String ID       ; 
		protected String CENTER   ;
		protected String NAME     ;
		protected String PLATFORM_;
		protected String CATEGORY ;
		protected String DESCRIBE ;
		protected String FUNCTION ;
		protected String PUSHMAIL ;
		protected String COMPLEX  ;
		public IUpdbcWrapper(){
			super();
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}

		/**
		 * @param pLATFORM_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String pLATFORM_) {
			PLATFORM_ = pLATFORM_;
		}

		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return the dESCRIBE
		 */
		public String getDESCRIBE() {
			return DESCRIBE;
		}
		
		/**
		 * @return the cENTER
		 */
		public String getCENTER() {
			return CENTER;
		}
		
		/**
		 * @param cENTER the cENTER to set
		 */
		public void setCENTER(String cENTER) {
			CENTER = cENTER;
		}
		
		/**
		 * @param dESCRIBE the dESCRIBE to set
		 */
		public void setDESCRIBE(String dESCRIBE) {
			DESCRIBE = dESCRIBE;
		}
		
		/**
		 * @return the fUNCTION
		 */
		public String getFUNCTION() {
			return FUNCTION;
		}
		
		/**
		 * @param fUNCTION the fUNCTION to set
		 */
		public void setFUNCTION(String fUNCTION) {
			FUNCTION = fUNCTION;
		}
		
		/**
		 * @return the pUSHMAIL
		 */
		public String getPUSHMAIL() {
			return PUSHMAIL;
		}
		
		/**
		 * @param pUSHMAIL the pUSHMAIL to set
		 */
		public void setPUSHMAIL(String pUSHMAIL) {
			PUSHMAIL = pUSHMAIL;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isPUSHMAIL(){
			return StringUtils.equals( PUSHMAIL, IUpdcConst.IEnum.IYesNo.No ) == false;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年6月12日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICenterMapping extends IUpdbcWrapper implements java.io.Serializable{
		private static final long serialVersionUID = 2958326499144185974L;
		public ICenterMapping(ISACenterMapping aCenterMapping){
			super();
			ID        = aCenterMapping.getCode        ();
			NAME      = aCenterMapping.getName        ();
			PLATFORM_ = IUpdcConst.IUpfwm.IUpfm.ucmframe;
			CATEGORY  = aCenterMapping.getCategory    ();
			DESCRIBE  = aCenterMapping.getDescribe    ();
			FUNCTION  = aCenterMapping.getImplclass   ();
			CENTER    = aCenterMapping.getCode        ();
			PUSHMAIL  = IUpdcConst.IEnum.IYesNo.Yes     ;
			COMPLEX   = aCenterMapping.getComplex     ();
		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-4-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICenterWrapper extends IUpdbcWrapper implements java.io.Serializable{
		private static final long serialVersionUID = -6196358277270559428L;
		public ICenterWrapper(ISACenterWrapper aCenterWrap) throws Exception{
			super();
			ID         = aCenterWrap.getImplclass   () ;
			PLATFORM_  = aCenterWrap.getPlatform    () ;
			NAME       = aCenterWrap.getDescription () ;
			DESCRIBE   = aCenterWrap.getDescription () ;
			FUNCTION   = aCenterWrap.getFunction    () ;
			CENTER     = aCenterWrap.getCenter      () ;
			CATEGORY   = aCenterWrap.getCategory    () ;
			PUSHMAIL   = aCenterWrap.getPsmlflg     () ;
			COMPLEX    = aCenterWrap.getComplex     () ;
		}
		
		public ICenterWrapper( String aIMPLCLASS , String aPLATFROM ){
			ID        = aIMPLCLASS;
			FUNCTION  = aIMPLCLASS;
			PLATFORM_ = aPLATFROM;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活流程基类</p>
	 * <p>Copyright: Copyright (c) 2014-3-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbpmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 447419257731225615L;
		protected String ID       ;
		protected String NAME     ;
		protected String SUBFLOW  ;
		protected String CATEGORY ;
		protected String PLATFORM ;
		protected String DIRECTIVE;
		protected String PROGRAM  ;
		protected String COMPLETE ;
		protected long   PRIORITY ;
		protected long   SORT_BY  ;
		protected String CONTROL  ;
		protected String IMPLCLASS;  
		protected String JEVAL    ;
		protected String COMPLEX  ;
		protected String COMPOSITE;
		protected java.util.Map GRAPHICS = new java.util.HashMap();
		public IUpdbpmOffer(){
			super();
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}

		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}

		/**
		 * @return the cOMPLETE
		 */
		public String getCOMPLETE() {
			return COMPLETE;
		}

		/**
		 * @param complete the cOMPLETE to set
		 */
		public void setCOMPLETE(String complete) {
			COMPLETE = complete;
		}

		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}

		/**
		 * @param complex the cOMPLEX to set
		 */
		public void setCOMPLEX(String complex) {
			COMPLEX = complex;
		}

		/**
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}

		/**
		 * @param composite the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String composite) {
			COMPOSITE = composite;
		}

		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the dIRECTIVE
		 */
		public String getDIRECTIVE() {
			return DIRECTIVE;
		}

		/**
		 * @param directive the dIRECTIVE to set
		 */
		public void setDIRECTIVE(String directive) {
			DIRECTIVE = directive;
		}

		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}

		/**
		 * @param id the iD to set
		 */
		public void setID(String id) {
			ID = id;
		}

		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}

		/**
		 * @param implclass the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String implclass) {
			IMPLCLASS = implclass;
		}

		/**
		 * @return the jEVAL
		 */
		public String getJEVAL() {
			return JEVAL;
		}

		/**
		 * @param jeval the jEVAL to set
		 */
		public void setJEVAL(String jeval) {
			JEVAL = jeval;
		}

		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}

		/**
		 * @param name the nAME to set
		 */
		public void setNAME(String name) {
			NAME = name;
		}

		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}

		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
		}

		/**
		 * @return the pRIORITY
		 */
		public long getPRIORITY() {
			return PRIORITY;
		}

		/**
		 * @param priority the pRIORITY to set
		 */
		public void setPRIORITY(long priority) {
			PRIORITY = priority;
		}

		/**
		 * @return the pROGRAM
		 */
		public String getPROGRAM() {
			return PROGRAM;
		}

		/**
		 * @param program the pROGRAM to set
		 */
		public void setPROGRAM(String program) {
			PROGRAM = program;
		}

		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}

		/**
		 * @param sort_by the sORT_BY to set
		 */
		public void setSORT_BY(long sort_by) {
			SORT_BY = sort_by;
		}

		/**
		 * @return the sUBFLOW
		 */
		public String getSUBFLOW() {
			return SUBFLOW;
		}

		/**
		 * @param sUBFLOW the sUBFLOW to set
		 */
		public void setSUBFLOW(String sUBFLOW) {
			SUBFLOW = sUBFLOW;
		}

		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}

		/**
		 * 判断是否BSS反馈结果
		 * @return
		 */
		public boolean isREPLY(){
			String fromREPLY = (String)GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.REPLY );
			return StringUtils.equalsIgnoreCase( fromREPLY, IUpdcConst.IEnum.IYesNo.Yes );
		}
		
		/**
		 * 判断是否为指令模型
		 * @return
		 */
		public boolean isPLATFORM(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdbm.IUpdbf.NORMAL );
		}
		
		/**
		 * 判断是否为子流程模型或任务网元级模型
		 * @return
		 */
		public boolean isSUBFLOW(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
		}
		
		/**
		 * 是否为服务任务单归档模式
		 * @return
		 */
		public boolean isCOMPLETE(){
			return StringUtils.equals( COMPLETE, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
		}
		
		/**
		 * 是否为服务激活流程
		 * @return
		 */
		public boolean isUpdbpm(){
			return this instanceof IProfessionalTemplate.IUpdbpelOffer;
		}
		
		/**
		 * 是否为服务网元二级指令流程
		 * @return
		 */
		public boolean isUpdfsm(){
			return this instanceof IPlatformTemplate.IUpffmSubFlow;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活映射基类</p>
	 * <p>Copyright: Copyright (c) 2014-4-1</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 2713417136308653100L;
		protected String ID       ;
		protected String NAME     ;
		protected String COMPETE  ;
		protected String CATEGORY ;
		protected long   SORT_BY  ;
		protected String MAPPING  ;
		protected String IMPLCLASS;
		protected String CHECKING   ;   
		protected String COMPLEX  ;
		protected String CONTROL  ;
		protected java.util.List COMPETENCE = new java.util.ArrayList();
		public IUpfgsmOffer(){
			super();
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}

		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}

		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}

		/**
		 * @param sORT_BY the sORT_BY to set
		 */
		public void setSORT_BY(long sORT_BY) {
			SORT_BY = sORT_BY;
		}

		/**
		 * @return the cHECKING
		 */
		public String getCHECKING() {
			return CHECKING;
		}

		/**
		 * @param checking the cHECKING to set
		 */
		public void setCHECKING(String checking) {
			CHECKING = checking;
		}

		/**
		 * @return the cOMPETE
		 */
		public String getCOMPETE() {
			return COMPETE;
		}

		/**
		 * @param compete the cOMPETE to set
		 */
		public void setCOMPETE(String compete) {
			COMPETE = compete;
		}

		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}

		/**
		 * @param complex the cOMPLEX to set
		 */
		public void setCOMPLEX(String complex) {
			COMPLEX = complex;
		}

		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}

		/**
		 * @param id the iD to set
		 */
		public void setID(String id) {
			ID = id;
		}

		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}

		/**
		 * @param implclass the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String implclass) {
			IMPLCLASS = implclass;
		}

		/**
		 * @return the mAPPING
		 */
		public String getMAPPING() {
			return MAPPING;
		}

		/**
		 * @param mapping the mAPPING to set
		 */
		public void setMAPPING(String mapping) {
			MAPPING = mapping;
		}

		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}

		/**
		 * @param name the nAME to set
		 */
		public void setNAME(String name) {
			NAME = name;
		}

		/**
		 * @param competence the cOMPETENCE to set
		 */
		public void setCOMPETENCE(java.util.List competence) {
			COMPETENCE = competence;
		}

		/**
		 * @return the cOMPETENCE
		 */
		public java.util.List getCOMPETENCE() {
			return COMPETENCE;
		}
		
		/**
		 * 网元级映射单元
		 * @return
		 */
		public boolean isUpffsm(){
			return this instanceof IPlatformTemplate.IUpffgsmOffer;
		}
		
		/**
		 * 产品级映射单元
		 * @return
		 */
		public boolean isUpdcpm(){
			return this instanceof IProfessionalTemplate.IUpdbfgsmOffer;
		}
		
		/**
		 * 产品属性级映射单元
		 * @return
		 */
		public boolean isUpdcpfm(){
			return this instanceof IProfessionalTemplate.IUpdbfgsmxOffer;
		}
		
		/**
		 * 流程级映射单元
		 * @return
		 */
		public boolean isUpffxm(){
			return this instanceof IProgramTemplate.IUpdffgsmOffer;
		}
		
		/**
		 * 分表级映射单元
		 * @return
		 */
		public boolean isUpdbfm(){
			return this instanceof ISubTableTemplate.ISubSQLTableCol;
		}
		
		/**
		 * 是否合法校验
		 * @return
		 */
		public boolean isUpdcvf(){
			return StringUtils.isBlank( CHECKING ) == false;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活属性转换基类</p>
	 * <p>Copyright: Copyright (c) 2015年10月14日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmxOffer extends IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 3426507948442236986L;
		public IUpfgsmxOffer(){
			super();
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年1月18日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmParallel implements java.io.Serializable{
		private static final long serialVersionUID = 789813708938025448L;
		private long    ID          ;     
		private String 	ORIGINATE   ;    
		private String 	REGION_ID   ;    
		private String 	DESCRIPTION ;    
		private String 	PARALLEL    ;
		private String 	COMPLEX     ;
		private java.sql.Timestamp EFFECTIVE ;    
		private java.sql.Timestamp EXPIRE    ;    
		public IUpfgkmParallel(ISAParallel aParallel) {
			ID            = aParallel.getId();
			ORIGINATE     = aParallel.getOriginate();
			REGION_ID     = aParallel.getRegionId();
			DESCRIPTION   = aParallel.getDescription();
			PARALLEL      = aParallel.getParallel();
			COMPLEX       = aParallel.getComplex();
			EFFECTIVE     = aParallel.getEffective();
			EXPIRE        = aParallel.getExpire();
		}
		
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		
		/**
		 * @param iD the iD to set
		 */
		public void setID(long iD) {
			ID = iD;
		}
		
		/**
		 * @return the oRIGINATE
		 */
		public String getORIGINATE() {
			return ORIGINATE;
		}
		
		/**
		 * @param oRIGINATE the oRIGINATE to set
		 */
		public void setORIGINATE(String oRIGINATE) {
			ORIGINATE = oRIGINATE;
		}
		
		/**
		 * @return the rEGION_ID
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}
		
		/**
		 * @param rEGION_ID the rEGION_ID to set
		 */
		public void setREGION_ID(String rEGION_ID) {
			REGION_ID = rEGION_ID;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		
		/**
		 * @return the pARALLEL
		 */
		public String getPARALLEL() {
			return PARALLEL;
		}
		
		/**
		 * @param pARALLEL the pARALLEL to set
		 */
		public void setPARALLEL(String pARALLEL) {
			PARALLEL = pARALLEL;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 网元局向规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月12日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmOffice implements java.io.Serializable{
		private static final long serialVersionUID = 1205561709664448410L;
		private String SEGMENT   ;
		private String CATEGORY  ;
		private String REGION_ID ;
		private java.util.List SUBFLOW = new java.util.ArrayList();
		public IUpfgkmOffice(){
			super();
		}
		
		public IUpfgkmOffice( ISAOffice aOffice ){
			super();
			SEGMENT         = aOffice.getHeadnum         ();
			CATEGORY        = aOffice.getCategory        ();
			REGION_ID       = aOffice.getRegionId        ();
		}
		
		/**
		 * @return the sEGMENT
		 */
		public String getSEGMENT() {
			return SEGMENT;
		}
		
		/**
		 * @param sEGMENT the sEGMENT to set
		 */
		public void setSEGMENT(String sEGMENT) {
			SEGMENT = sEGMENT;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return the rEGION_ID
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}
		
		/**
		 * @param rEGION_ID the rEGION_ID to set
		 */
		public void setREGION_ID(String rEGION_ID) {
			REGION_ID = rEGION_ID;
		}
		
		/**
		 * @return the sUBFLOW
		 */
		public java.util.List getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * 
		 * @param aOffice
		 */
		public void mergeAsOffice( ISAOffice aOffice ){
			try
			{
				SUBFLOW.add( new IUpfgkmOfficeX( aOffice ) );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @return
		 */
		public IUpfgkmOfficeX getOFFICE(){
			return (IUpfgkmOfficeX)SUBFLOW.get( SUBFLOW.size() - 1 );
		}
		
		/**
		 * 
		 * @param fromBILL
		 * @return
		 */
		public IUpfgkmOfficeX getOFFICE( String fromBILL ){
			IUpfgkmOfficeX fromOffice = null;
			try
			{
				for( java.util.Iterator itera = SUBFLOW.iterator(); itera.hasNext(); ){
					IUpfgkmOfficeX fromOfficeX = (IUpfgkmOfficeX)itera.next();
					if( StringUtils.isBlank( fromOfficeX.FROM_ ) || 
							( fromOfficeX.getFROM_().compareTo( fromBILL ) <= 0 
							&& fromOfficeX.getTO_().compareTo( fromBILL ) >= 0 ) ){
						fromOffice = fromOfficeX;
						break;
					}
				}
			}
			finally{
				
			}
			return fromOffice;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 号码局向规范</p>
	 * <p>Copyright: Copyright (c) 2013-4-8</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmOfficeX implements java.io.Serializable{
		private static final long serialVersionUID = -6471095022600156962L;
		private long   ID             ;
		private String NUMBER_        ;
		private String CATEGORY       ;
		private String FROM_          ;
		private String TO_            ;
		private String PLATFORM_      ;
		private String REGION_ID      ;
		private String REGION_CODE    ;
		private String PS_NET_CODE    ;
		public IUpfgkmOfficeX(){
			super();
		}
		
		public IUpfgkmOfficeX(ISAOffice aOffice) {
			super();
			ID              = aOffice.getId              ();
			NUMBER_         = aOffice.getHeadnum         ();
			CATEGORY        = aOffice.getCategory        ();
			FROM_           = aOffice.getStartNum        ();
			TO_             = aOffice.getEndNum          ();
			PLATFORM_       = aOffice.getPlatfrom        ();
			REGION_ID       = aOffice.getRegionId        ();
			REGION_CODE     = aOffice.getRegionCode      ();
			PS_NET_CODE     = aOffice.getPsNetCode       ();
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @return the fROM_
		 */
		public String getFROM_() {
			return FROM_;
		}
		
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		
		/**
		 * @return the nUMBER_
		 */
		public String getNUMBER_() {
			return NUMBER_;
		}
		
		/**
		 * @return the pLATFROM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}
		
		/**
		 * @return the pS_NET_CODE
		 */
		public String getPS_NET_CODE() {
			return PS_NET_CODE;
		}
		
		/**
		 * @return the rEGION_CODE
		 */
		public String getREGION_CODE() {
			return REGION_CODE;
		}
		
		/**
		 * @return the rEGION_ID
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}
		
		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}
		
		/**
		 * @param from_ the fROM_ to set
		 */
		public void setFROM_(String from_) {
			FROM_ = from_;
		}
		
		/**
		 * @param id the iD to set
		 */
		public void setID(long id) {
			ID = id;
		}
		
		/**
		 * @param number_ the nUMBER_ to set
		 */
		public void setNUMBER_(String number_) {
			NUMBER_ = number_;
		}
		
		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}
		
		/**
		 * @param ps_net_code the pS_NET_CODE to set
		 */
		public void setPS_NET_CODE(String ps_net_code) {
			PS_NET_CODE = ps_net_code;
		}
		
		/**
		 * @param region_code the rEGION_CODE to set
		 */
		public void setREGION_CODE(String region_code) {
			REGION_CODE = region_code;
		}
		
		/**
		 * @param region_id the rEGION_ID to set
		 */
		public void setREGION_ID(String region_id) {
			REGION_ID = region_id;
		}
		
		/**
		 * @param to_ the tO_ to set
		 */
		public void setTO_(String to_) {
			TO_ = to_;
		}
		
		/**
		 * @return the tO_
		 */
		public String getTO_() {
			return TO_;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年12月13日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpfgkmGroup implements java.io.Serializable{
		private static final long serialVersionUID = -1800406773044160432L;
		private String _group;
		private java.util.HashMap _subflow = new java.util.HashMap();
		private java.util.List    _sequence = new java.util.ArrayList();
		public IUpfgkmGroup( String group ){
			super();
			_group = group;
		}
		
		/**
		 * @return the _group
		 */
		public String getGROUP() {
			return _group;
		}

		/**
		 * @return the _subflow
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * 
		 * @param _subflow
		 * @return
		 */
		public Object getSUBFLOW( String _composite ){
			return _subflow.get( _composite );
		}
		
		/**
		 * @return the _sequence
		 */
		public java.util.List getSEQUENCE() {
			return _sequence;
		}

		/**
		 * 
		 * @param aPersist
		 */
		public void mergeAsComposite( ISAPersistent aPersist ){
			try
			{
				IUpfgkmComposite _composite = new IUpfgkmComposite( aPersist );
				_subflow.put( _composite.getID(), _composite );
				_sequence.add( _composite );
			}
			finally{
				
			}
		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 分表规则>
	 * <p>Copyright: Copyright (c) 2014-12-8</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgkmComposite implements java.io.Serializable{
		private static final long serialVersionUID = 2750637623803268705L;
		private String ID           ;                              
		private String NAME         ;                              
		private String DESCRIBE     ;                              
		private String PERSISTENT   ;  
		private String FAILURE      ;
		private String HISTORY      ;
		private long   CYCLE        ;
		private String CHECKING     ;
		private String COMPOSITE    ;
		private String CONTROL      ;    
		private String EXTEND_ATTR_A;
		private String EXTEND_ATTR_B;
		private String EXTEND_ATTR_C;
		private String EXTEND_ATTR_D;
		private String EXTEND_ATTR_E;
		private String EXTEND_ATTR_F;
		private String EXTEND_ATTR_G;
		private String EXTEND_ATTR_H;
		private String EXTEND_ATTR_I;
		private String EXTEND_ATTR_J;
		private String EXTEND_ATTR_K;
		private String EXTEND_ATTR_L;
		private String EXTEND_ATTR_M;
		private String EXTEND_ATTR_N;
		private String EXTEND_ATTR_O;
		public IUpfgkmComposite( ISAPersistent aPersistence ){
			super();
			ID            = aPersistence.getCode       ();                              
			NAME          = aPersistence.getName       ();                              
			DESCRIBE      = aPersistence.getDescribe   ();                              
			PERSISTENT    = aPersistence.getPersistent ();
			FAILURE       = aPersistence.getFailure    ();
			HISTORY       = aPersistence.getHistory    ();
			CYCLE         = aPersistence.getCycle      ();
			CHECKING      = aPersistence.getExtendAttrA();
			COMPOSITE     = aPersistence.getExtendAttrB();
			CONTROL       = aPersistence.getControl    ();
			EXTEND_ATTR_A = aPersistence.getExtendAttrA();
			EXTEND_ATTR_B = aPersistence.getExtendAttrB();
			EXTEND_ATTR_C = aPersistence.getExtendAttrC();
			EXTEND_ATTR_D = aPersistence.getExtendAttrD();
			EXTEND_ATTR_E = aPersistence.getExtendAttrE();
			EXTEND_ATTR_F = aPersistence.getExtendAttrF();
			EXTEND_ATTR_G = aPersistence.getExtendAttrG();
			EXTEND_ATTR_H = aPersistence.getExtendAttrH();
			EXTEND_ATTR_I = aPersistence.getExtendAttrI();
			EXTEND_ATTR_J = aPersistence.getExtendAttrJ();
			EXTEND_ATTR_K = aPersistence.getExtendAttrK();
			EXTEND_ATTR_L = aPersistence.getExtendAttrL();
			EXTEND_ATTR_M = aPersistence.getExtendAttrM();
			EXTEND_ATTR_N = aPersistence.getExtendAttrN();
			EXTEND_ATTR_O = aPersistence.getExtendAttrO();                               
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return the dESCRIBE
		 */
		public String getDESCRIBE() {
			return DESCRIBE;
		}
		
		/**
		 * @param dESCRIBE the dESCRIBE to set
		 */
		public void setDESCRIBE(String dESCRIBE) {
			DESCRIBE = dESCRIBE;
		}
		
		/**
		 * @return the pERSISTENT
		 */
		public String getPERSISTENT() {
			return PERSISTENT;
		}
		
		/**
		 * @param pERSISTENT the pERSISTENT to set
		 */
		public void setPERSISTENT(String pERSISTENT) {
			PERSISTENT = pERSISTENT;
		}
		
		/**
		 * @return the fAILURE
		 */
		public String getFAILURE() {
			return FAILURE;
		}
		
		/**
		 * @param fAILURE the fAILURE to set
		 */
		public void setFAILURE(String fAILURE) {
			FAILURE = fAILURE;
		}
		
		/**
		 * @return the hISTORY
		 */
		public String getHISTORY() {
			return HISTORY;
		}
		
		/**
		 * @param hISTORY the hISTORY to set
		 */
		public void setHISTORY(String hISTORY) {
			HISTORY = hISTORY;
		}
		
		/**
		 * @return the cYCLE
		 */
		public long getCYCLE() {
			return CYCLE;
		}
		
		/**
		 * @param cYCLE the cYCLE to set
		 */
		public void setCYCLE(long cYCLE) {
			CYCLE = cYCLE;
		}
		
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @return the cHECKING
		 */
		public String getCHECKING() {
			return CHECKING;
		}

		/**
		 * @param cHECKING the cHECKING to set
		 */
		public void setCHECKING(String cHECKING) {
			CHECKING = cHECKING;
		}

		/**
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}

		/**
		 * @param cOMPOSITE the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String cOMPOSITE) {
			COMPOSITE = cOMPOSITE;
		}

		/**
		 * @param cONTROL the cONTROL to set
		 */
		public void setCONTROL(String cONTROL) {
			CONTROL = cONTROL;
		}
		
		/**
		 * @return the eXTEND_ATTR_A
		 */
		public String getEXTEND_ATTR_A() {
			return EXTEND_ATTR_A;
		}
		
		/**
		 * @param eXTEND_ATTR_A the eXTEND_ATTR_A to set
		 */
		public void setEXTEND_ATTR_A(String eXTEND_ATTR_A) {
			EXTEND_ATTR_A = eXTEND_ATTR_A;
		}
		
		/**
		 * @return the eXTEND_ATTR_B
		 */
		public String getEXTEND_ATTR_B() {
			return EXTEND_ATTR_B;
		}
		
		/**
		 * @param eXTEND_ATTR_B the eXTEND_ATTR_B to set
		 */
		public void setEXTEND_ATTR_B(String eXTEND_ATTR_B) {
			EXTEND_ATTR_B = eXTEND_ATTR_B;
		}
		
		/**
		 * @return the eXTEND_ATTR_C
		 */
		public String getEXTEND_ATTR_C() {
			return EXTEND_ATTR_C;
		}
		
		/**
		 * @param eXTEND_ATTR_C the eXTEND_ATTR_C to set
		 */
		public void setEXTEND_ATTR_C(String eXTEND_ATTR_C) {
			EXTEND_ATTR_C = eXTEND_ATTR_C;
		}
		
		/**
		 * @return the eXTEND_ATTR_D
		 */
		public String getEXTEND_ATTR_D() {
			return EXTEND_ATTR_D;
		}
		
		/**
		 * @param eXTEND_ATTR_D the eXTEND_ATTR_D to set
		 */
		public void setEXTEND_ATTR_D(String eXTEND_ATTR_D) {
			EXTEND_ATTR_D = eXTEND_ATTR_D;
		}
		
		/**
		 * @return the eXTEND_ATTR_E
		 */
		public String getEXTEND_ATTR_E() {
			return EXTEND_ATTR_E;
		}
		
		/**
		 * @param eXTEND_ATTR_E the eXTEND_ATTR_E to set
		 */
		public void setEXTEND_ATTR_E(String eXTEND_ATTR_E) {
			EXTEND_ATTR_E = eXTEND_ATTR_E;
		}
		
		/**
		 * @return the eXTEND_ATTR_F
		 */
		public String getEXTEND_ATTR_F() {
			return EXTEND_ATTR_F;
		}
		
		/**
		 * @param eXTEND_ATTR_F the eXTEND_ATTR_F to set
		 */
		public void setEXTEND_ATTR_F(String eXTEND_ATTR_F) {
			EXTEND_ATTR_F = eXTEND_ATTR_F;
		}
		
		/**
		 * @return the eXTEND_ATTR_G
		 */
		public String getEXTEND_ATTR_G() {
			return EXTEND_ATTR_G;
		}
		
		/**
		 * @param eXTEND_ATTR_G the eXTEND_ATTR_G to set
		 */
		public void setEXTEND_ATTR_G(String eXTEND_ATTR_G) {
			EXTEND_ATTR_G = eXTEND_ATTR_G;
		}
		
		/**
		 * @return the eXTEND_ATTR_H
		 */
		public String getEXTEND_ATTR_H() {
			return EXTEND_ATTR_H;
		}
		
		/**
		 * @param eXTEND_ATTR_H the eXTEND_ATTR_H to set
		 */
		public void setEXTEND_ATTR_H(String eXTEND_ATTR_H) {
			EXTEND_ATTR_H = eXTEND_ATTR_H;
		}
		
		/**
		 * @return the eXTEND_ATTR_I
		 */
		public String getEXTEND_ATTR_I() {
			return EXTEND_ATTR_I;
		}
		
		/**
		 * @param eXTEND_ATTR_I the eXTEND_ATTR_I to set
		 */
		public void setEXTEND_ATTR_I(String eXTEND_ATTR_I) {
			EXTEND_ATTR_I = eXTEND_ATTR_I;
		}
		
		/**
		 * @return the eXTEND_ATTR_J
		 */
		public String getEXTEND_ATTR_J() {
			return EXTEND_ATTR_J;
		}
		
		/**
		 * @param eXTEND_ATTR_J the eXTEND_ATTR_J to set
		 */
		public void setEXTEND_ATTR_J(String eXTEND_ATTR_J) {
			EXTEND_ATTR_J = eXTEND_ATTR_J;
		}
		
		/**
		 * @return the eXTEND_ATTR_K
		 */
		public String getEXTEND_ATTR_K() {
			return EXTEND_ATTR_K;
		}
		
		/**
		 * @param eXTEND_ATTR_K the eXTEND_ATTR_K to set
		 */
		public void setEXTEND_ATTR_K(String eXTEND_ATTR_K) {
			EXTEND_ATTR_K = eXTEND_ATTR_K;
		}
		
		/**
		 * @return the eXTEND_ATTR_L
		 */
		public String getEXTEND_ATTR_L() {
			return EXTEND_ATTR_L;
		}
		
		/**
		 * @param eXTEND_ATTR_L the eXTEND_ATTR_L to set
		 */
		public void setEXTEND_ATTR_L(String eXTEND_ATTR_L) {
			EXTEND_ATTR_L = eXTEND_ATTR_L;
		}
		
		/**
		 * @return the eXTEND_ATTR_M
		 */
		public String getEXTEND_ATTR_M() {
			return EXTEND_ATTR_M;
		}
		
		/**
		 * @param eXTEND_ATTR_M the eXTEND_ATTR_M to set
		 */
		public void setEXTEND_ATTR_M(String eXTEND_ATTR_M) {
			EXTEND_ATTR_M = eXTEND_ATTR_M;
		}
		
		/**
		 * @return the eXTEND_ATTR_N
		 */
		public String getEXTEND_ATTR_N() {
			return EXTEND_ATTR_N;
		}
		
		/**
		 * @param eXTEND_ATTR_N the eXTEND_ATTR_N to set
		 */
		public void setEXTEND_ATTR_N(String eXTEND_ATTR_N) {
			EXTEND_ATTR_N = eXTEND_ATTR_N;
		}
		
		/**
		 * @return the eXTEND_ATTR_O
		 */
		public String getEXTEND_ATTR_O() {
			return EXTEND_ATTR_O;
		}
		
		/**
		 * @param eXTEND_ATTR_O the eXTEND_ATTR_O to set
		 */
		public void setEXTEND_ATTR_O(String eXTEND_ATTR_O) {
			EXTEND_ATTR_O = eXTEND_ATTR_O;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isThreShold(){
			return CYCLE != 0;
		}
		
		/**
		 * 是否归档检验
		 * @return
		 */
		public boolean isCOMPLETE(){
			return StringUtils.equals( CHECKING, IUpdcConst.IEnum.IYesNo.Yes ) && 
					StringUtils.isBlank( COMPOSITE ) == false;
		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 能力优先级组</p>
	 * <p>Copyright: Copyright (c) 2015年10月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbfsCombine implements java.io.Serializable{
		private static final long serialVersionUID = -1855379961135352278L;
		private String PROGRAM  ;
		private String PLATFORM ;
		private java.util.List SUBFLOW = new java.util.ArrayList();
		public IUpdbfsCombine( ISAPriorityBusines aProprity ){
			super();
			PROGRAM  = aProprity.getBusiness();
			PLATFORM = aProprity.getPlatform(); 
		}
		
		/**
		 * @return the pROGRAM
		 */
		public String getPROGRAM() {
			return PROGRAM;
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @return 业务级优先级列表
		 */
		public java.util.List getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * 返回业务优先级首位规范
		 * @return
		 */
		public IUpdbfsBusines getLITTLE(){
			return (IUpdbfsBusines)SUBFLOW.get( SUBFLOW.size() - 1 );
		}
		
		/**
		 * 
		 * @return 业务级优先级列表
		 */
		public IUpdbfsBusines[] getBUSINES(){
			return (IUpdbfsBusines[])SUBFLOW.toArray( new IUpdbfsBusines[]{} );
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 开通国际编码规范</p>
	 * <p>Copyright: Copyright (c) 2017年5月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmResource implements java.io.Serializable{
		private static final long serialVersionUID = 2319645976487357625L;
		private long   ID         ;
		private String CODE       ;
		private String NAME       ;
		private String CATEGORY   ;
		private String DESCRIPTION;
		private long   SORT_BY    ;
		private String DOMAIN     ;
		private String ALIAS      ;
		private String EXTEND     ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
		public IUpfgkmResource( ISAI18nResource aResource ){
			super();
			ID          = aResource.getId         ();
			CODE        = aResource.getCode       ();
			NAME        = aResource.getName       ();
			CATEGORY    = aResource.getCategory   ();
			DESCRIPTION = aResource.getDescription();
			SORT_BY     = aResource.getSortBy     ();
			DOMAIN      = aResource.getDomain     ();
			ALIAS       = aResource.getAlias      ();
			EXTEND      = aResource.getExtend     ();
			EFFECTIVE   = aResource.getEffective  ();
			EXPIRE      = aResource.getExpire     ();
		}
		
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		
		/**
		 * @param iD the iD to set
		 */
		public void setID(long iD) {
			ID = iD;
		}
		
		/**
		 * @return the cODE
		 */
		public String getCODE() {
			return CODE;
		}
		
		/**
		 * @param cODE the cODE to set
		 */
		public void setCODE(String cODE) {
			CODE = cODE;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		
		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}
		
		/**
		 * @param sORT_BY the sORT_BY to set
		 */
		public void setSORT_BY(long sORT_BY) {
			SORT_BY = sORT_BY;
		}
		
		/**
		 * @return the dOMAIN
		 */
		public String getDOMAIN() {
			return DOMAIN;
		}

		/**
		 * @param dOMAIN the dOMAIN to set
		 */
		public void setDOMAIN(String dOMAIN) {
			DOMAIN = dOMAIN;
		}

		/**
		 * @return the aLIAS
		 */
		public String getALIAS() {
			return ALIAS;
		}
		
		/**
		 * @param aLIAS the aLIAS to set
		 */
		public void setALIAS(String aLIAS) {
			ALIAS = aLIAS;
		}
		
		/**
		 * @return the eXTEND
		 */
		public String getEXTEND() {
			return EXTEND;
		}
		
		/**
		 * @param eXTEND the eXTEND to set
		 */
		public void setEXTEND(String eXTEND) {
			EXTEND = eXTEND;
		}
		
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		
		/**
		 * 是否属于非开通规范
		 * @return
		 */
		public boolean isVALID(){
			return StringUtils.contains( DOMAIN, new String[]{ IUpdcConst.IUpdfx.IDomain.INSIDE, IUpdcConst.IUpdfx.IDomain.EXTEND } );
		}
		
		/**
		 * 是否为开通内部资源
		 * @return
		 */
		public boolean isINSIDE(){
			return StringUtils.equals( DOMAIN, IUpdcConst.IUpdfx.IDomain.INSIDE );
		}
		
		/**
		 * 是否为开通外部资源
		 * @return
		 */
		public boolean isEXTEND(){
			return StringUtils.equals( DOMAIN, IUpdcConst.IUpdfx.IDomain.EXTEND );
		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通工单优先级</p>
	 * <p>Copyright: Copyright (c) 2013-4-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfsOffer implements java.io.Serializable{
		private static final long serialVersionUID = 3056727475073575048L;
		protected String ID           ;                                                                          
		protected String NAME         ;                                                                          
		protected String PLATFORM_    ;
		protected String DESCRIPTION  ;
		protected String COMPETE_     ;
		protected long   PRIORITY     ;                                                                          
		protected String COMPOSITE    ;
		protected String COMPLEX      ;
		protected String CONTROL      ;
		protected java.util.Map  PROGRAM = new java.util.HashMap();
		public IUpdbfsOffer(){
			super();
		}
		
		public IUpdbfsOffer(ISAPriorityBusines aProprity){
			super();
			ID            = aProprity.getBusiness   ();                                                                          
			NAME          = aProprity.getName       ();                                                                          
			PLATFORM_     = aProprity.getPlatform   ();
			DESCRIPTION   = aProprity.getDescription();
			COMPETE_      = aProprity.getCompete    ();
			PRIORITY      = aProprity.getPriority   ();                                                                          
			COMPOSITE     = aProprity.getComposite  ();
			COMPLEX       = aProprity.getComplex    ();
			CONTROL       = aProprity.getControl    ();
		}
		
		public IUpdbfsOffer(ISAPriorityCompete aProprity){
			super();
			ID            = aProprity.getProgram    ();                                                                          
			NAME          = aProprity.getName       ();                                                                          
			PLATFORM_     = aProprity.getPlatform   (); 
			DESCRIPTION   = aProprity.getDescription();
			COMPETE_      = aProprity.getCompete    ();
			PRIORITY      = aProprity.getPriority   ();                                                                          
			COMPOSITE     = aProprity.getComposite  ();
			COMPLEX       = aProprity.getComplex    ();
			CONTROL       = aProprity.getControl    ();
		}
		
		public IUpdbfsOffer( long _priority, String _composite, String _description ){
			super();
			ID            = "*";                                                                          
			NAME          = _description;                                                                          
			PLATFORM_     = IUpdcConst.IUpfwm.IUpfm.ucmframe;
			PRIORITY      = _priority;                                                                          
			COMPOSITE     = _composite;
		}
		
		/**
		 * @return the cOMPETE_
		 */
		public String getCOMPETE_() {
			return COMPETE_;
		}
		
		/**
		 * @param compete_ the cOMPETE_ to set
		 */
		public void setCOMPETE_(String compete_) {
			COMPETE_ = compete_;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param complex the cOMPLEX to set
		 */
		public void setCOMPLEX(String complex) {
			COMPLEX = complex;
		}
		
		/**
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}
		
		/**
		 * @param composite the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String composite) {
			COMPOSITE = composite;
		}
		
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param id the iD to set
		 */
		public void setID(String id) {
			ID = id;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param name the nAME to set
		 */
		public void setNAME(String name) {
			NAME = name;
		}
		
		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}
		
		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		/**
		 * @return the pRIORITY
		 */
		public long getPRIORITY() {
			return PRIORITY;
		}
		
		/**
		 * @param priority the pRIORITY to set
		 */
		public void setPRIORITY(long priority) {
			PRIORITY = priority;
		}
		
		/**
		 * @return the pROGRAM
		 */
		public java.util.Map getPROGRAM() {
			return PROGRAM;
		}
		
		/**
		 * 根据开通产品查询该产品对应优先级规范
		 * @param fromCOMPETE
		 * @return
		 */
		public IUpdbfsCatalog[] getPROGRAM( String fromCOMPETE ){
			IUpdbfsCatalog fromCatalog[] = null;
			try
			{
				java.util.List fromPROGRAM = (java.util.List)PROGRAM.get( fromCOMPETE );
				if( fromPROGRAM != null && fromPROGRAM.size() > 0 ){
					fromCatalog = (IUpdbfsCatalog[])fromPROGRAM.toArray( new IUpdbfsCatalog[]{} );
				}
			}
			finally{
				
			}
			return fromCatalog;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 业务级优先级</p>
	 * <p>Copyright: Copyright (c) 2013-4-7</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfsBusines extends IUpdbfsOffer{
		private static final long serialVersionUID = 1427466719713818691L;
		private String CATALOG;
		private String BUSINES;
		private String BATCHES;
		private String CHANNEL;
		public IUpdbfsBusines(ISAPriorityBusines _proprity){
			super( _proprity );
			CATALOG = _proprity.getCatalog ();
			BUSINES = _proprity.getBusiness();
			BATCHES = _proprity.getBatches ();
			CHANNEL = _proprity.getChannel ();
		}
		
		public IUpdbfsBusines(ISAPriorityBusines _proprity, java.util.Map _program ){
			super( _proprity );
			CATALOG = _proprity.getCatalog ();
			BUSINES = _proprity.getBusiness();
			BATCHES = _proprity.getBatches ();
			CHANNEL = _proprity.getChannel ();
			if( StringUtils.isBlank( COMPETE_ ) == false && _program.containsKey( COMPETE_ ) ){
				PROGRAM.putAll( (java.util.Map)_program.get( COMPETE_ ) );
			}
		}
		
		/**
		 * @return the cATALOG
		 */
		public String getCATALOG() {
			return CATALOG;
		}

		/**
		 * @param cATALOG the cATALOG to set
		 */
		public void setCATALOG(String cATALOG) {
			CATALOG = cATALOG;
		}

		/**
		 * @return the cHANNEL
		 */
		public String getCHANNEL() {
			return CHANNEL;
		}
		
		/**
		 * @return the bUSINES
		 */
		public String getBUSINES() {
			return BUSINES;
		}
		
		/**
		 * @return the bATCHES
		 */
		public String getBATCHES() {
			return BATCHES;
		}
		
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 产品级优先级</p>
	 * <p>Copyright: Copyright (c) 2013-4-7</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfsCatalog extends IUpdbfsOffer{
		private static final long serialVersionUID = 5569685569181452240L;
		public IUpdbfsCatalog( ISAPriorityCompete aProprity ){
			super( aProprity );
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 开通优先级时限</p>
	 * <p>Copyright: Copyright (c) 2017年5月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfsGroup implements java.io.Serializable{
		private static final long serialVersionUID = -876273074384221304L;
		private String GROUP    ;
		private String PLATFORM ;
		private java.util.HashMap PROGRAM = new java.util.HashMap();
		public IUpdbfsGroup(){
			super();
		}
		
		public IUpdbfsGroup( ISAPriorityLimite aProprity ){
			super();
			GROUP    = aProprity.getCode    ();
			PLATFORM = aProprity.getPlatform(); 
		}
		
		/**
		 * @return the gROUP
		 */
		public String getGROUP() {
			return GROUP;
		}
		
		/**
		 * @param gROUP the gROUP to set
		 */
		public void setGROUP(String gROUP) {
			GROUP = gROUP;
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param pLATFORM the pLATFORM to set
		 */
		public void setPLATFORM(String pLATFORM) {
			PLATFORM = pLATFORM;
		}

		/**
		 * @return the pROGRAM
		 */
		public java.util.HashMap getPROGRAM() {
			return PROGRAM;
		}
		
		/**
		 * 
		 * @param aPriority
		 */
		public void mergeAsGroup( ISAPriorityLimite aPriority ){
			try
			{
				IUpdbfsLimite fromUpffmx = new IUpdbfsLimite( aPriority );
				if( PROGRAM.get( fromUpffmx.getCATEGORY() ) == null ){
					PROGRAM.put( fromUpffmx.getCATEGORY(), new java.util.ArrayList() );
				}
				((java.util.List)PROGRAM.get( fromUpffmx.getCATEGORY() ) ).add( fromUpffmx );
			}
			finally{
				
			}
		}
		
		/**
		 * 获取开通优先级规范
		 * @return
		 */
		public java.util.List getPRIORITY(){
			return (java.util.List)PROGRAM.get( IUpdcConst.IUpdbm.IUpdbf.PRIORITY );
		}
		
		/**
		 * 获取开通优先时限规范
		 * @return
		 */
		public java.util.List getLIMITESS(){
			return (java.util.List)PROGRAM.get( IUpdcConst.IUpdbm.IUpdbf.LIMITESS );
		}
		
		/**
		 * 获取系统级优先级规范
		 * @return
		 */
		public IUpdbfsLimite getSUBFLOW(){
			IUpdbfsLimite fromUpffmx = null;
			try
			{
				java.util.List fromUpdbfxm = getPRIORITY();
				if( fromUpdbfxm != null && fromUpdbfxm.size() > 0 ){
					for( java.util.Iterator itera = fromUpdbfxm.iterator(); itera.hasNext(); ){
						IUpdbfsLimite fromUpffxm = (IUpdbfsLimite)itera.next();
						if( fromUpffxm.isSUBFLOW() ){ fromUpffmx = fromUpffxm; break; }
					}
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 获取系统级时限规范
		 * @return
		 */
		public IUpdbfsLimite getLMXFLOW(){
			IUpdbfsLimite fromUpffmx = null;
			try
			{
				java.util.List fromUpdbfxm = getLIMITESS();
				if( fromUpdbfxm != null && fromUpdbfxm.size() > 0 ){
					for( java.util.Iterator itera = fromUpdbfxm.iterator(); itera.hasNext(); ){
						IUpdbfsLimite fromUpffxm = (IUpdbfsLimite)itera.next();
						if( fromUpffxm.isSUBFLOW() ){ fromUpffmx = fromUpffxm; break; }
					}
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年5月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfsLimite implements java.io.Serializable{
		private static final long serialVersionUID = -3440220057983233668L;
		private String ID           ;
		private String CODE         ;
		private String NAME         ;                         
		private String PLATFORM     ; 
		private String CATEGORY     ;
		private String DESCRIPTION  ;                         
		private long   SORT_BY      ;                         
		private long   PRIORITY     ;                         
		private String COMPOSITE    ;                         
		private String COMPLEX      ;                         
		private String CONTROL      ;                         
		private String EXTEND_ATTR_A;                         
		private String EXTEND_ATTR_B;                         
		private String EXTEND_ATTR_C;                         
		private String EXTEND_ATTR_D;                         
		private String EXTEND_ATTR_E;                         
		private String EXTEND_ATTR_F;                         
		private String EXTEND_ATTR_G;                         
		private String EXTEND_ATTR_H;                         
		private String EXTEND_ATTR_I;                         
		private String EXTEND_ATTR_J;                         
		private String EXTEND_ATTR_K;                         
		private String EXTEND_ATTR_L;                         
		private String EXTEND_ATTR_M;                         
		private String EXTEND_ATTR_N;                         
		private String EXTEND_ATTR_O;
		public IUpdbfsLimite(){
			super();
		}
		
		public IUpdbfsLimite( String _code, String _category ){
			super();
			ID        = ""                              ;
			CODE      = _code                           ;
			NAME      = "*"                             ;
			CATEGORY  = _category                       ;
			PLATFORM  = IUpdcConst.IUpfwm.IUpfm.ucmframe;
			COMPOSITE = IUpdcConst.IUpdbm.IUpdbf.NORMAL ;
		}
		
		public IUpdbfsLimite( ISAPriorityLimite aPriority ){
			super();
			ID            = String.valueOf(aPriority.getId());         
			CODE          = aPriority.getCode              ();
			NAME          = aPriority.getName              (); 
			CATEGORY      = aPriority.getCategory          ();                       
			PLATFORM      = aPriority.getPlatform          ();
			DESCRIPTION   = aPriority.getDescription       ();                         
			SORT_BY       = aPriority.getSortBy            ();                         
			PRIORITY      = aPriority.getPriority          ();                         
			COMPOSITE     = aPriority.getComposite         ();                         
			COMPLEX       = aPriority.getComplex           ();                         
			CONTROL       = aPriority.getControl           ();                         
			EXTEND_ATTR_A = aPriority.getExtendAttrA       ();                         
			EXTEND_ATTR_B = aPriority.getExtendAttrB       ();                         
			EXTEND_ATTR_C = aPriority.getExtendAttrC       ();                         
			EXTEND_ATTR_D = aPriority.getExtendAttrD       ();                         
			EXTEND_ATTR_E = aPriority.getExtendAttrE       ();                         
			EXTEND_ATTR_F = aPriority.getExtendAttrF       ();                         
			EXTEND_ATTR_G = aPriority.getExtendAttrG       ();                         
			EXTEND_ATTR_H = aPriority.getExtendAttrH       ();                         
			EXTEND_ATTR_I = aPriority.getExtendAttrI       ();                         
			EXTEND_ATTR_J = aPriority.getExtendAttrJ       ();                         
			EXTEND_ATTR_K = aPriority.getExtendAttrK       ();                         
			EXTEND_ATTR_L = aPriority.getExtendAttrL       ();                         
			EXTEND_ATTR_M = aPriority.getExtendAttrM       ();                         
			EXTEND_ATTR_N = aPriority.getExtendAttrN       ();                         
			EXTEND_ATTR_O = aPriority.getExtendAttrO       ();
		}
		
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		
		/**
		 * @return the cODE
		 */
		public String getCODE() {
			return CODE;
		}

		/**
		 * @param cODE the cODE to set
		 */
		public void setCODE(String cODE) {
			CODE = cODE;
		}

		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}

		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}

		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param pLATFORM the pLATFORM to set
		 */
		public void setPLATFORM(String pLATFORM) {
			PLATFORM = pLATFORM;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		
		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}
		
		/**
		 * @param sORT_BY the sORT_BY to set
		 */
		public void setSORT_BY(long sORT_BY) {
			SORT_BY = sORT_BY;
		}
		
		/**
		 * @return the pRIORITY
		 */
		public long getPRIORITY() {
			return PRIORITY;
		}
		
		/**
		 * @param pRIORITY the pRIORITY to set
		 */
		public void setPRIORITY(long pRIORITY) {
			PRIORITY = pRIORITY;
		}
		
		/**
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}
		
		/**
		 * @param cOMPOSITE the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String cOMPOSITE) {
			COMPOSITE = cOMPOSITE;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @param cONTROL the cONTROL to set
		 */
		public void setCONTROL(String cONTROL) {
			CONTROL = cONTROL;
		}
		
		/**
		 * @return the eXTEND_ATTR_A
		 */
		public String getEXTEND_ATTR_A() {
			return EXTEND_ATTR_A;
		}
		
		/**
		 * @param eXTEND_ATTR_A the eXTEND_ATTR_A to set
		 */
		public void setEXTEND_ATTR_A(String eXTEND_ATTR_A) {
			EXTEND_ATTR_A = eXTEND_ATTR_A;
		}
		
		/**
		 * @return the eXTEND_ATTR_B
		 */
		public String getEXTEND_ATTR_B() {
			return EXTEND_ATTR_B;
		}
		
		/**
		 * @param eXTEND_ATTR_B the eXTEND_ATTR_B to set
		 */
		public void setEXTEND_ATTR_B(String eXTEND_ATTR_B) {
			EXTEND_ATTR_B = eXTEND_ATTR_B;
		}
		
		/**
		 * @return the eXTEND_ATTR_C
		 */
		public String getEXTEND_ATTR_C() {
			return EXTEND_ATTR_C;
		}
		
		/**
		 * @param eXTEND_ATTR_C the eXTEND_ATTR_C to set
		 */
		public void setEXTEND_ATTR_C(String eXTEND_ATTR_C) {
			EXTEND_ATTR_C = eXTEND_ATTR_C;
		}
		
		/**
		 * @return the eXTEND_ATTR_D
		 */
		public String getEXTEND_ATTR_D() {
			return EXTEND_ATTR_D;
		}
		
		/**
		 * @param eXTEND_ATTR_D the eXTEND_ATTR_D to set
		 */
		public void setEXTEND_ATTR_D(String eXTEND_ATTR_D) {
			EXTEND_ATTR_D = eXTEND_ATTR_D;
		}
		
		/**
		 * @return the eXTEND_ATTR_E
		 */
		public String getEXTEND_ATTR_E() {
			return EXTEND_ATTR_E;
		}
		
		/**
		 * @param eXTEND_ATTR_E the eXTEND_ATTR_E to set
		 */
		public void setEXTEND_ATTR_E(String eXTEND_ATTR_E) {
			EXTEND_ATTR_E = eXTEND_ATTR_E;
		}
		
		/**
		 * @return the eXTEND_ATTR_F
		 */
		public String getEXTEND_ATTR_F() {
			return EXTEND_ATTR_F;
		}
		
		/**
		 * @param eXTEND_ATTR_F the eXTEND_ATTR_F to set
		 */
		public void setEXTEND_ATTR_F(String eXTEND_ATTR_F) {
			EXTEND_ATTR_F = eXTEND_ATTR_F;
		}
		
		/**
		 * @return the eXTEND_ATTR_G
		 */
		public String getEXTEND_ATTR_G() {
			return EXTEND_ATTR_G;
		}
		
		/**
		 * @param eXTEND_ATTR_G the eXTEND_ATTR_G to set
		 */
		public void setEXTEND_ATTR_G(String eXTEND_ATTR_G) {
			EXTEND_ATTR_G = eXTEND_ATTR_G;
		}
		
		/**
		 * @return the eXTEND_ATTR_H
		 */
		public String getEXTEND_ATTR_H() {
			return EXTEND_ATTR_H;
		}
		
		/**
		 * @param eXTEND_ATTR_H the eXTEND_ATTR_H to set
		 */
		public void setEXTEND_ATTR_H(String eXTEND_ATTR_H) {
			EXTEND_ATTR_H = eXTEND_ATTR_H;
		}
		
		/**
		 * @return the eXTEND_ATTR_I
		 */
		public String getEXTEND_ATTR_I() {
			return EXTEND_ATTR_I;
		}
		
		/**
		 * @param eXTEND_ATTR_I the eXTEND_ATTR_I to set
		 */
		public void setEXTEND_ATTR_I(String eXTEND_ATTR_I) {
			EXTEND_ATTR_I = eXTEND_ATTR_I;
		}
		
		/**
		 * @return the eXTEND_ATTR_J
		 */
		public String getEXTEND_ATTR_J() {
			return EXTEND_ATTR_J;
		}
		
		/**
		 * @param eXTEND_ATTR_J the eXTEND_ATTR_J to set
		 */
		public void setEXTEND_ATTR_J(String eXTEND_ATTR_J) {
			EXTEND_ATTR_J = eXTEND_ATTR_J;
		}
		
		/**
		 * @return the eXTEND_ATTR_K
		 */
		public String getEXTEND_ATTR_K() {
			return EXTEND_ATTR_K;
		}
		
		/**
		 * @param eXTEND_ATTR_K the eXTEND_ATTR_K to set
		 */
		public void setEXTEND_ATTR_K(String eXTEND_ATTR_K) {
			EXTEND_ATTR_K = eXTEND_ATTR_K;
		}
		
		/**
		 * @return the eXTEND_ATTR_L
		 */
		public String getEXTEND_ATTR_L() {
			return EXTEND_ATTR_L;
		}
		
		/**
		 * @param eXTEND_ATTR_L the eXTEND_ATTR_L to set
		 */
		public void setEXTEND_ATTR_L(String eXTEND_ATTR_L) {
			EXTEND_ATTR_L = eXTEND_ATTR_L;
		}
		
		/**
		 * @return the eXTEND_ATTR_M
		 */
		public String getEXTEND_ATTR_M() {
			return EXTEND_ATTR_M;
		}
		
		/**
		 * @param eXTEND_ATTR_M the eXTEND_ATTR_M to set
		 */
		public void setEXTEND_ATTR_M(String eXTEND_ATTR_M) {
			EXTEND_ATTR_M = eXTEND_ATTR_M;
		}
		
		/**
		 * @return the eXTEND_ATTR_N
		 */
		public String getEXTEND_ATTR_N() {
			return EXTEND_ATTR_N;
		}
		
		/**
		 * @param eXTEND_ATTR_N the eXTEND_ATTR_N to set
		 */
		public void setEXTEND_ATTR_N(String eXTEND_ATTR_N) {
			EXTEND_ATTR_N = eXTEND_ATTR_N;
		}
		
		/**
		 * @return the eXTEND_ATTR_O
		 */
		public String getEXTEND_ATTR_O() {
			return EXTEND_ATTR_O;
		}
		
		/**
		 * @param eXTEND_ATTR_O the eXTEND_ATTR_O to set
		 */
		public void setEXTEND_ATTR_O(String eXTEND_ATTR_O) {
			EXTEND_ATTR_O = eXTEND_ATTR_O;
		}
		
		/**
		 * 是否为默认优先级规范
		 * @return
		 */
		public boolean isSUBFLOW(){
			return StringUtils.equals( PLATFORM, IUpdcConst.IUpfwm.IUpfm.ucmframe ) && 
					StringUtils.equals( CODE, IUpdcConst.IEnum.PRIORITY );
		}
	}
}
