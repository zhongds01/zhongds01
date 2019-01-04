package com.ai.sacenter.util;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于类对象建立内存索引列表</p>
 * <p>Copyright: Copyright (c) 2014-12-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */

public class WeakHashMap extends java.util.HashMap {
	private static final long serialVersionUID = -1416765334390379466L;
	public WeakHashMap() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.util.HashMap#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		if( key == null ){
			return super.containsKey( key );
		}
		else if( key instanceof java.lang.Class ){
			return super.containsKey( key );
		}
		else{
			java.util.Map fromMap = null;
			Class fromCLASS = key.getClass();
			if( super.containsKey( fromCLASS ) ){
				fromMap = (java.util.Map)super.get( fromCLASS );
				return fromMap.containsKey( key );
			}
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see java.util.HashMap#get(java.lang.Object)
	 */
	public Object get(Object key) {
		if( key == null ){
			return super.get( key );
		}
		else if( key instanceof java.lang.Class ){
			return super.get( key );
		}
		else{
			java.util.Map fromMap = null;
			Class fromCLASS = key.getClass();
			if( super.containsKey( fromCLASS ) ){
				fromMap = (java.util.Map)super.get( fromCLASS );
				return fromMap.get( key );
			}
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(Object key, Object value) {
		if( key == null ){
			return super.put( key , value );
		}
		else if( key instanceof java.lang.Class ){
			if( value == null ){
				throw new java.lang.NullPointerException();
			}
			else if( value instanceof java.util.TreeMap == false ){
				throw new java.lang.IllegalArgumentException( value.getClass().getName() );
			}
			return super.put( key , value );
		}
		else{
			Class fromCLASS = key.getClass();
			java.util.Map fromMap = null;
			if( (fromMap = (java.util.Map)super.get( fromCLASS )) == null ){
				super.put( fromCLASS, fromMap = new java.util.TreeMap() );
			}
			return fromMap.put( key , value );
		}
	}
	/* (non-Javadoc)
	 * @see java.util.HashMap#remove(java.lang.Object)
	 */
	public Object remove(Object key) {
		Object localDeque = null;
		if( key == null ){
			localDeque = super.remove( key );
		}
		else if( key instanceof java.lang.Class ){
			localDeque = super.remove( key );
		}
		else{
			java.util.Map fromMap = null;
			Class fromCLASS = key.getClass();
			if( super.containsKey( fromCLASS ) ){
				fromMap = (java.util.Map)super.get( fromCLASS );
				localDeque = fromMap.remove( key );
				if( fromMap.size() <= 0 ){
					localDeque = super.remove( fromCLASS );
				}
			}
		}
		return localDeque;
	}
	/* (non-Javadoc)
	 * @see java.util.HashMap#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		throw new java.lang.UnsupportedOperationException();
	}
	/* (non-Javadoc)
	 * @see java.util.HashMap#putAll(java.util.Map)
	 */
	public void putAll(java.util.Map map) {
		throw new java.lang.UnsupportedOperationException();
	}
}
