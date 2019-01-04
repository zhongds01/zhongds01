package com.ai.sacenter.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-2-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IBeanWrapper {
	private final static java.util.Map _runtime_descriptor = new java.util.concurrent.ConcurrentHashMap();
	private java.util.Map _descriptor = null;
	private Object INSTANCE;
	/***
	 * Create new BeanWrapperImpl for the given object,
	 * registering a nested path that the object is in.
	 * @param object object wrapped by this BeanWrapper
	 */
	public IBeanWrapper( Object object ){
		_wrap( object );
	}
	/**
	 * 
	 * @return
	 */
	public Object getObject(){
		return INSTANCE;
	}
	/**
	 * Switch the target object, replacing the cached introspection results only
	 * if the class of the new object is different to that of the replaced object.
	 * @param object new targets
	 */ 
	public void _wrap(Object object){
		try
		{
			AssertUtils.isNull(object,"Bean object must not be null");
			this.INSTANCE = object;
			Class fromCLASS = INSTANCE.getClass();
			if( (_descriptor = (java.util.Map)_runtime_descriptor.get( fromCLASS ) ) == null ){
				synchronized ( fromCLASS ) {
					if( (_descriptor = (java.util.Map)_runtime_descriptor.get( fromCLASS ) ) == null ){
						_descriptor = new java.util.HashMap();
						PropertyDescriptor aDescriptor[] = PropertyUtils.getPropertyDescriptors( INSTANCE.getClass() );
						for(int index = 0 ; index < aDescriptor.length ; index++){
							_descriptor.put( aDescriptor[index].getName() , new IPropertyDescriptor( aDescriptor[index] ) );
						}
						_runtime_descriptor.put( fromCLASS , _descriptor );
					}
				}
			}
		}
		catch( java.lang.Exception tt){
			throw new java.lang.RuntimeException( tt.getMessage() , tt );
		}
		finally{
			
		}
	}
	/***
	 * 获得对象类
	 * @return
	 */
	public Class getCLASS(){
		AssertUtils.isNull(INSTANCE);
		return INSTANCE.getClass();
	}
	/***
	 * 
	 * @param primitiveType
	 * @return
	 */
	public Class getPrimitive(Class primitiveType){
		AssertUtils.isNull(primitiveType);
		if(Boolean.TYPE.equals(primitiveType))
            return java.lang.Boolean.class;
		else if(Float.TYPE.equals(primitiveType))
            return java.lang.Float.class;
		else if(Long.TYPE.equals(primitiveType))
            return java.lang.Long.class;
		else if(Integer.TYPE.equals(primitiveType))
            return java.lang.Integer.class;
		else if(Short.TYPE.equals(primitiveType))
            return java.lang.Short.class;
		else if(Byte.TYPE.equals(primitiveType))
            return java.lang.Byte.class;
		else if(Double.TYPE.equals(primitiveType))
            return java.lang.Double.class;
		else if(Character.TYPE.equals(primitiveType))
            return java.lang.Character.class;
		else if(Void.TYPE.equals(primitiveType))
        	return java.lang.Void.class;
        return primitiveType;
	}
	/***
	 * 获得对象属性列表
	 * @return
	 */
	public PropertyDescriptor[] getPropertyDescriptors(){
		java.util.List aPropertyDescriptors = new java.util.ArrayList();
		if( _descriptor != null ){
			for( java.util.Iterator itera = _descriptor.entrySet().iterator() ; itera.hasNext() ; ){
				java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
				IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)aEntry.getValue();
				if( aPropertyDescriptor.getReadMethod() != null && aPropertyDescriptor.getWriteMethod() != null )
					aPropertyDescriptors.add( aPropertyDescriptor.getDescriptor() );
			}
		}
		return (PropertyDescriptor[])aPropertyDescriptors.toArray( new PropertyDescriptor[]{} );
	}
	/***
	 * 根据对象属性获得该对象属性信息
	 * @param propertyName
	 * @return
	 * @throws Exception
	 */
	public PropertyDescriptor getPropertyDescriptor(String propertyName) throws Exception{
		AssertUtils.notNull(propertyName, "Property name must not be null");
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		if( aPropertyDescriptor != null) return aPropertyDescriptor.getDescriptor();
		else throw new Exception( INSTANCE.getClass().getName()+" "+"No property '" + propertyName + "' found");
	}
	/**
	 * 
	 * @param propertyName
	 * @return
	 * @throws Exception
	 */
	public boolean isPropertyDescriptor(String propertyName) throws Exception{
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		return aPropertyDescriptor != null?true:false;
	}
	/**
	 * 
	 * @param aDescriptor
	 * @return
	 */
	public boolean isPropertyDescriptor(PropertyDescriptor aDescriptor){
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( aDescriptor.getName() );
		return aPropertyDescriptor != null && aPropertyDescriptor.Descriptor.getPropertyType().equals( 
				aDescriptor.getPropertyType() );
	}
	/***
	 * 判断对象属性是否可读
	 * @param propertyName
	 * @return
	 * @throws Exception 
	 */
	public boolean isReadableProperty(String propertyName) throws Exception{
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		return aPropertyDescriptor != null && aPropertyDescriptor.getReadMethod() != null;
	}
	/***
	 * 判断对象属性是否可写
	 * @param propertyName
	 * @return
	 * @throws Exception 
	 */
	public boolean isWritableProperty(String propertyName) throws Exception{
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		return aPropertyDescriptor != null && aPropertyDescriptor.getWriteMethod() != null;
	}
	/***
	 * 根据对象属性获得属性类型
	 * @param propertyName
	 * @return
	 * @throws Exception
	 */
	public Class getPropertyType(String propertyName) throws Exception{
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		if( aPropertyDescriptor != null && aPropertyDescriptor.getDescriptor().getPropertyType() != null) 
			return getPrimitive( aPropertyDescriptor.getDescriptor().getPropertyType());
		else return null; 
	}
	/***
	 * 根据对象属性获得该属性对应值
	 * @param propertyName
	 * @return
	 * @throws Exception
	 */
	public Object getPropertyValue(String propertyName) throws Exception{
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		if( aPropertyDescriptor == null ) throw new java.lang.NoSuchMethodException( "Unknown property '"+propertyName +"'");
		Method readMethod = aPropertyDescriptor.getReadMethod();
		if( Modifier.isPublic( readMethod.getModifiers() ) == false ) readMethod.setAccessible( true );
		return readMethod.invoke( INSTANCE , (Object[])null );
	}
	/***
	 * 设置对象属性值
	 * @param propertyName
	 * @param Value
	 * @throws Exception
	 */
	public void setPropertyValue(String propertyName, Object Value) throws Exception{
		IPropertyDescriptor aPropertyDescriptor = (IPropertyDescriptor)_descriptor.get( propertyName );
		if( aPropertyDescriptor == null ) throw new java.lang.NoSuchMethodException( "Unknown property '"+propertyName +"'");
		Method writeMethod = aPropertyDescriptor.getWriteMethod();
		if( Modifier.isPublic( writeMethod.getModifiers() ) == false ) writeMethod.setAccessible( true );
		if( Value != null && ClassUtils.isAssignable( Value.getClass() , aPropertyDescriptor.getDescriptor().getPropertyType() ) == false )
			Value = ClassUtils.IClass.transfer( Value , aPropertyDescriptor.getDescriptor().getPropertyType() );
		writeMethod.invoke( INSTANCE , new Object[]{ Value } );
	}
	/***
	 * 执行对象对应方法
	 * @param MethodName
	 * @param Argv
	 * @return
	 * @throws Exception
	 */
	public Object invokeMethod(String MethodName, Object Argv) throws Exception{
		AssertUtils.isNull(MethodName);
		return MethodUtils.invokeMethod( INSTANCE ,MethodName,Argv);
	}
	
	/***
	 * 执行对象对应方法
	 * @param MethodName
	 * @param Argv
	 * @return
	 * @throws Exception
	 */
	public Object invokeMethod(String MethodName, Object Argv[]) throws Exception{
		AssertUtils.isNull(MethodName);
		return MethodUtils.invokeMethod( INSTANCE ,MethodName,Argv);
	}
	/***
	 * 执行对象对应方法
	 * @param methodName
	 * @param args
	 * @param parameterTypes
	 * @return
	 * @throws Exception
	 */
	public Object invokeMethod(String methodName, Object args[], Class parameterTypes[]) throws Exception{
		AssertUtils.isNull(methodName);
		return MethodUtils.invokeMethod(INSTANCE,methodName,args,parameterTypes);
	}
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	public Method[] getAccessibleMethod() throws Exception{
		AssertUtils.isNull(INSTANCE);
		java.util.List MethodList = new java.util.ArrayList();
		Method methods[] = getCLASS().getDeclaredMethods();
		if(methods != null && methods.length > 0){
			for(int Index=0;Index<methods.length;Index++){
				if(Modifier.isPublic(methods[Index].getModifiers())){
					methods[Index].setAccessible(true);
					MethodList.add(methods[Index]);
				}
			}
		}
		return (Method[])MethodList.toArray(new Method[]{});
	}
	/***
	 * 根据对象方法名获得对象对应方法(如存在多条方法,则抛出异常)
	 * @param methodName
	 * @return
	 * @throws Exception
	 */
	public Method getAccessibleMethod(String methodName) throws Exception{
		AssertUtils.isNull(methodName);
		java.util.List MethodList = new java.util.ArrayList();
	    Class InstanceClass = getCLASS();
	    Method Methods[] = InstanceClass.getDeclaredMethods();
	    if(Methods != null && Methods.length > 0){
	    	for(int Index = 0; Index < Methods.length; Index++){
	    		if(Modifier.isPublic(Methods[Index].getModifiers()) && StringUtils.equals(Methods[Index].getName(),methodName)){
	    			Methods[Index].setAccessible(true);
	    			MethodList.add(Methods[Index]);
	    		}
	    	}
	    }
	    if(MethodList.size() <= 0) throw new NoSuchMethodException(methodName);
	    else if(MethodList.size() > 1) throw new Exception(this.getCLASS().getName()+" Method:"+methodName+" not Only");
		return (Method)MethodList.get(0);
	}
	/***
	 * 根据对象方法名和类型获得对象对应方法
	 * @param methodName
	 * @param parameterType
	 * @return
	 * @throws Exception
	 */
	public Method getAccessibleMethod(String methodName, Class parameterType) throws Exception{
		AssertUtils.isNull(methodName);
		return MethodUtils.getAccessibleMethod(getCLASS(),methodName,parameterType);
	}
	/***
	 * 根据对象方法名和类型获得对象对应方法
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 * @throws Exception
	 */
	public Method getAccessibleMethod(String methodName, Class parameterTypes[]) throws Exception{
		AssertUtils.isNull(methodName);
		return MethodUtils.getAccessibleMethod(getCLASS(),methodName,parameterTypes);
	}
	/**
	 * 
	 * <p>Title: zjcrm_java</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-8-30</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IPropertyDescriptor implements java.io.Serializable{
		private static final long serialVersionUID = -8344336742814486345L;
		private PropertyDescriptor Descriptor;
		private java.lang.reflect.Method ReadMethod;
		private java.lang.reflect.Method WriteMethod;
		public IPropertyDescriptor(){
			
		}
		public IPropertyDescriptor( PropertyDescriptor aPropertyDescriptor ){
			Descriptor = aPropertyDescriptor;
			ReadMethod = aPropertyDescriptor.getReadMethod();
			if( ReadMethod != null && Modifier.isPublic( ReadMethod.getModifiers() ) == false ) 
				ReadMethod.setAccessible( true );
			WriteMethod = aPropertyDescriptor.getWriteMethod();
			if( WriteMethod != null && Modifier.isPublic( WriteMethod.getModifiers() ) == false ) 
				WriteMethod.setAccessible( true );
		}
		
		/**
		 * @return the Descriptor
		 */
		public PropertyDescriptor getDescriptor() {
			return Descriptor;
		}
		/**
		 * @return the readMethod
		 */
		public java.lang.reflect.Method getReadMethod() {
			return ReadMethod;
		}
		/**
		 * @return the writeMethod
		 */
		public java.lang.reflect.Method getWriteMethod() {
			return WriteMethod;
		}
	
	}
}
