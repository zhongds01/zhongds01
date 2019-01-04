package com.ai.sacenter.jdbc;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-3</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class HQSQLEntityBean implements DataStructInterface,java.io.Serializable {
	private static final long serialVersionUID = 4105704246195750732L;
	/*实体结构*/
	protected HQSQLTable m_type = null;
	/*是否删除标志*/
	protected boolean m_deleted = false;
	/*变化后字段*/
	private java.util.HashMap m_back  = new java.util.HashMap();
	/*变化前字段*/
	private java.util.HashMap m_front = new java.util.HashMap();
	/*自身实例*/
	private HQSQLEntity m_entity = new HQSQLEntityExtend();
	/*连带实体*/
	private HQSQLEntityOffer _little = new HQSQLEntityOffer();
	public HQSQLEntityBean() throws Exception{
		super();
		m_type = new HQSQLNull();
	}
	
	public HQSQLEntityBean( HQSQLTable type ) throws Exception{
		super();
		m_type = type;
	}
	
	public HQSQLEntityBean( String schema , String table ) throws Exception{
		super();
		m_type = HQSQLUtils.getMYSQLTable( schema, table );
	}
	
	public HQSQLEntityBean( ObjectType type ) throws Exception{
		super();
		m_type = HQSQLUtils.getOracleTable( null, type );
	}
	
	public HQSQLEntityBean( String schema , ObjectType type ) throws Exception{
		super();
		m_type = HQSQLUtils.getOracleTable( schema, type );
	}
	
	public HQSQLEntityBean( DataStructInterface conatin ) throws Exception{
		super();
		m_type = HQSQLUtils.getOracleTable( null, conatin.getObjectType() );
		java.util.Map _properties = conatin.getNewProperties();
		if( _properties != null && _properties.size() > 0 ){
			if( m_front == null ){ m_front = new java.util.HashMap(); }
			m_front.putAll( _properties );
		}
		_properties = conatin.getOldProperties();
		if( _properties != null && _properties.size() > 0 ){
			if( m_back == null ){ m_back = new java.util.HashMap(); }
			m_back.putAll( _properties );
		}
		if( conatin.isDeleted() ){ m_deleted = true; }
	}
	
	/**
	 * 
	 * @return
	 */
	public HQSQLTable getObjectType() {
		return m_type;
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public void set( String name, Object value ) throws AIException{
		try
		{
			name = name.toUpperCase();
			if( m_front == null ) m_front = new java.util.HashMap();
			HQSQLTable.HQSQLColumn _column = m_type.getProperty( name );
			if( _column != null ){
				value = ClassUtils.IClass.transfer( value, _column.getJavaType() );
			}
			m_front.put( name , value );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwOracle("IOS0014002", new String[]{m_type.getDataSource(),
					m_type.getMapingEnty(),
					name},
					exception);
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Object get( String name ){
		Object fromObj = null;
		try
		{
			name = name.toUpperCase();
			if( m_front != null && m_front.containsKey( name ) ){
				fromObj = m_front.get( name );
			}
			else if( m_back != null && m_back.containsKey( name ) ){
				fromObj = m_back.get( name );
			}
		}
		finally{
			
		}
		return fromObj;
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public void setOld( String name, Object value ) throws Exception{
		try
		{
			name = name.toUpperCase();
			if( m_back == null ) m_back = new java.util.HashMap();
			HQSQLTable.HQSQLColumn _column = m_type.getProperty( name );
			if( _column != null ){
				value = ClassUtils.IClass.transfer( value, _column.getJavaType() );
			}
			m_back.put( name , value );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwOracle("IOS0014002", new String[]{m_type.getDataSource(),
					m_type.getMapingEnty(),
					name},
					exception);
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Object getOldObj(String name) {
		name = name.toUpperCase();
		if( m_back != null && m_back.containsKey( name ) ){
			return m_back.get( name );
		}
		return null;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String getAsString( String name ){
		return ClassUtils.IClass.getAsString( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getAsInt( String name ){
		return ClassUtils.IClass.getAsInt( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getAsLong( String name ){
		return ClassUtils.IClass.getAsLong( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public double getAsDouble( String name ){
		return ClassUtils.IClass.getAsDouble( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public float getAsFloat( String name ){
		return ClassUtils.IClass.getAsFloat( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public byte getAsByte( String name ){
		return ClassUtils.IClass.getAsByte( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean getAsBoolean( String name ){
		return ClassUtils.IClass.getAsBoolean( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public char getAsChar( String name ){
		return ClassUtils.IClass.getAsChar( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public java.sql.Date getAsDate( String name ){
		return ClassUtils.IClass.getAsDate( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public java.sql.Time getAsTime( String name ){
		return ClassUtils.IClass.getAsTime( get(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public java.sql.Timestamp getAsDateTime( String name ){
		return ClassUtils.IClass.getAsTimestamp( get(name) );
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.HashMap getProperties(){
		java.util.HashMap _result = new java.util.HashMap();
		try
		{
			if( m_back != null ) _result.putAll( m_back );
			if( m_front != null ) _result.putAll( m_front );
		}
		finally{
			
		}
		return _result;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.HashMap getKeyProperties(){
		java.util.HashMap _result = new java.util.HashMap();
		try
		{
			for( java.util.Iterator itera = m_type.getKeyProperties().values().iterator(); itera.hasNext(); ){
				HQSQLTable.HQSQLColumn _column = (HQSQLTable.HQSQLColumn)itera.next();
				_result.put( _column.getName(), get( _column.getName() ) );
			}
		}
		finally{
			
		}
		return _result;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.HashMap getNewProperties(){
		java.util.HashMap _result = new java.util.HashMap();
		try
		{
			if( m_front != null ) _result.putAll( m_front );
		}
		finally{
			
		}
		return _result;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.HashMap getOldProperties(){
		java.util.HashMap _result = new java.util.HashMap();
		try
		{
			if( m_back != null ) _result.putAll( m_back );
		}
		finally{
			
		}
		return _result;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getPropertyNames(){
		java.util.List _result = new java.util.ArrayList();
		if( ( m_type instanceof HQSQLNull ) == false ){
			_result.addAll( m_type.getProperties().keySet() );
		}
		else{
			if( m_front != null ){ _result.addAll( m_front.keySet() ); }
			if( m_back != null && m_back.size() > 0 ){
				for( java.util.Iterator itera = m_back.keySet().iterator(); itera.hasNext(); ){
					String _name = (String)itera.next();
					if( _result.contains( _name ) == false ){ _result.add( _name ); }
				}
			}
		}
		return (String[])_result.toArray( new String[]{} );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasProperty(String name){
		name = name.toUpperCase();
		return ( m_front != null && m_front.containsKey( name ) ) || ( m_back != null && m_back.containsKey( name ) );
	}
	
	/**
	 * 是否存在字段
	 * @param name
	 * @return
	 */
	public boolean hasPropertyName( String name ){
		name = name.toUpperCase();
		return m_type.getProperties().containsKey( name );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String getPropertyType(String name) throws AIException {
		name = name.toUpperCase();
		return m_type.getProperty( name ).getJavaDataType();
	}

	/**
	 * 字段初始化
	 * @param name
	 * @return
	 */
	public void initProperty(String name, Object value) throws AIException {
		if( value == null ){ return; }
		name = name.toUpperCase();
		if( m_back == null ){ m_back = new java.util.HashMap(); }
		m_back.put( name, value );
	}

	/**
	 * 是否字段初始化
	 * @param name
	 * @return
	 */
	public boolean isPropertyInitial(String name) throws AIException {
		name = name.toUpperCase();
		return ( m_back != null && m_back.containsKey( name ) );
	}

	/**
	 * 是否字段已修改
	 * @param name
	 * @return
	 */
	public boolean isPropertyModified(String name) throws AIException {
		name = name.toUpperCase();
		return ( m_front != null && m_front.containsKey( name ) );
	}

	/**
	 * 
	 * @return
	 */
	public String[] getKeyPropertyNames() {
		return (String[])m_type.getKeyProperties().keySet().toArray( new String[]{} );
	}

	/**
	 * @param source
	 * @return
	 */
	public void copy(DataStructInterface source) throws AIException {
		if( m_front == null ) m_front = new java.util.HashMap();
		if( m_back == null ) m_back = new java.util.HashMap();
		for( java.util.Iterator itera = m_front.entrySet().iterator(); itera.hasNext(); ){
			java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
			if( m_front.containsKey( fromEntry.getKey() ) == false ){
				m_front.put( fromEntry.getKey() , fromEntry.getValue() );
			}
		}
		for( java.util.Iterator itera = m_back.entrySet().iterator(); itera.hasNext(); ){
			java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
			if( m_back.containsKey( fromEntry.getKey() ) == false ){
				m_back.put( fromEntry.getKey() , fromEntry.getValue() );
			}
		}
		m_deleted = false;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Object getExtAttr(String name) {
		return null;
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public void setExtAttr(String name, Object value) {
		
	}

	/**
	 * 
	 * @param attrName
	 * @param displayAttrName
	 * @return
	 */
	public Object getDispalyAttr(String attrName, String displayAttrName) {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public java.util.HashMap getDisplayAttrHashMap() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public java.util.HashMap getOldDisplayAttrHashMap() {
		return null;
	}

	/**
	 * 
	 * @param attrName
	 * @param displayAttrName
	 * @param displayValue
	 */
	public void setDiaplayAttr(String attrName, String displayAttrName, Object displayValue) {
		
	}

	/**
	 * 数据转换为新建状态[包含其下级]
	 *
	 */
	public void setStsToNew(){
		m_entity.setStsToNew();
		for( java.util.Iterator itera = _little._little.iterator(); itera.hasNext(); ){
			HQSQLEntityBean subject = (HQSQLEntityBean)itera.next();
			subject.setStsToNew();
		}
	}
	
	/**
	 * 数据转换为未操作[包含其下级]
	 *
	 */
	public void setStsToOld(){
		m_entity.setStsToOld();
		for( java.util.Iterator itera = _little._little.iterator(); itera.hasNext(); ){
			HQSQLEntityBean subject = (HQSQLEntityBean)itera.next();
			subject.setStsToOld();
		}
	}
	
	/**
	 * 强制更新[包含其下级强制更新]
	 *
	 */
	public void forceStsToUpdate() {
		m_entity.forceStsToUpdate();
		for( java.util.Iterator itera = _little._little.iterator(); itera.hasNext(); ){
			HQSQLEntityBean subject = (HQSQLEntityBean)itera.next();
			subject.forceStsToUpdate();
		}
	}

	/**
	 * 撤销删除[包含其下级撤销删除]
	 *
	 */
	public void unDelete() {
	    m_entity.unDelete();
	    for( java.util.Iterator itera = _little._little.iterator(); itera.hasNext(); ){
			HQSQLEntityBean subject = (HQSQLEntityBean)itera.next();
			subject.unDelete();
		}
	}
	
	/**
	 * 删除[包含其下级数据删除]
	 *
	 */
	public void delete(){
		m_entity.delete();
		for( java.util.Iterator itera = _little._little.iterator(); itera.hasNext(); ){
			HQSQLEntityBean subject = (HQSQLEntityBean)itera.next();
			subject.delete();
		}
	}
	
	/**
	 * 清除实体内容[包含其下级全部清除]
	 *
	 */
	public void clear(){
		m_entity.clear();
		_little._little.clear();
	}
	
	/**
	 * 清除字段内容[包含其下级]
	 * @param name
	 */
	public void clearProperty( String name ){
		m_entity.clearProperty( name );
		for( java.util.Iterator itera = _little._little.iterator(); itera.hasNext(); ){
			HQSQLEntityBean subject = (HQSQLEntityBean)itera.next();
			subject.clearProperty( name );
		}
	}
	
	/**
	 * 
	 * @return 当前实体
	 */
	public HQSQLEntity getEntity(){
		return m_entity;
	}
	
	/**
	 * @return the _subject
	 */
	public HQSQLEntityOffer getLittle() {
		return _little;
	}

	/**
	 * 是否非法表实体
	 * @return
	 */
	public boolean isNull(){
		return m_type instanceof HQSQLNull;
	}
	
	/**
	 * 是否新建
	 * @return
	 */
	public boolean isNew(){
		if( isDeleted() ) return false;
		return m_back == null || m_back.size() <= 0;
	}
	
	/**
	 * 是否修改
	 */
	public boolean isModified(){
		if( isDeleted() ) return false;
		if( isNew() ) return false;
		return m_front != null && m_front.size() > 0 ;
	}
	
	/**
	 * 是否删除
	 * @return
	 */
	public boolean isDeleted(){
		return m_deleted == true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder _result = new StringBuilder();
		try
		{
			_result.append( ExceptionFactory.getDefault().getLocal("com.ai.appframe2.bo.DataContainer.dc", new Object[]{} ) );
			_result.append( m_type.getDataSource() ).append( "." ).append( m_type.getMapingEnty() ).append("[" );
			if( m_front != null ){
				for( java.util.Iterator itera = m_front.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					if( fromEntry.getValue() != null ){
						_result.append( fromEntry.getKey().toString() ).append("=").append( fromEntry.getValue().toString() );
						if( itera.hasNext() ){ _result.append(" , "); }
					}
				}
			}
			if( m_back != null ){
				for( java.util.Iterator itera = m_back.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					if( m_front.containsKey( fromEntry.getKey() ) == false && fromEntry.getValue() != null ){
						_result.append( fromEntry.getKey().toString() ).append("=").append( fromEntry.getValue().toString() );
						if( itera.hasNext() ){ _result.append(" , "); }
					}
				}
			}
			_result.append( "]" );
		}
		catch( java.lang.Exception exception ){
			_result = new StringBuilder( super.toString() );
		}
		finally{
			
		}
		return _result.toString();
	}
	
	public interface HQSQLEntity{
		/**
		 * 数据转换为新建状态
		 */
		public void setStsToNew();
		/**
		 * 数据转换为未操作
		 *
		 */
		public void setStsToOld();
		/**
		 * 撤销删除
		 *
		 */
		public void unDelete();
		/**
		 * 删除
		 *
		 */
		public void delete();
		/**
		 * 强制更新
		 *
		 */
		public void forceStsToUpdate();
		/**
		 * 
		 *
		 */
		public void clear();
		/**
		 * 
		 * @param name
		 */
		public void clearProperty( String name );
	}
	
	private class HQSQLEntityExtend implements HQSQLEntity, java.io.Serializable{
		private static final long serialVersionUID = 8861772264943940535L;
		public HQSQLEntityExtend(){
			super();
		}
		
		/**
		 * 数据转换为新建状态
		 */
		public void setStsToNew(){
			if( m_front == null ) m_front = new java.util.HashMap();
			if( m_back == null ) m_back = new java.util.HashMap();
			for( java.util.Iterator itera = m_back.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				if( m_front.containsKey( fromEntry.getKey() ) == false ){
					m_front.put( fromEntry.getKey() , fromEntry.getValue() );
				}
			}
			m_back.clear();
			m_deleted = false;
		}
		
		/**
		 * 数据转换为未操作
		 *
		 */
		public void setStsToOld(){
			try
			{
				if( m_front == null ) m_front = new java.util.HashMap();
				if( m_back == null )  m_back = new java.util.HashMap();
				for( java.util.Iterator itera = m_front.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					m_back.put( fromEntry.getKey() , fromEntry.getValue() );
				}
				m_front.clear();
				m_deleted = false;
			}
			finally{
				
			}
		}
		
		/**
		 * 强制更新
		 *
		 */
		public void forceStsToUpdate() {
			try
			{
				if( m_front == null ) m_front = new java.util.HashMap();
				if( m_back == null )  m_back = new java.util.HashMap();
				for( java.util.Iterator itera = m_front.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					m_back.put( fromEntry.getKey() , fromEntry.getValue() );
				}
				m_deleted = false;
			}
			finally{
				
			}
		}
		
		/**
		 * 撤销删除
		 *
		 */
		public void unDelete() {
			m_deleted = false;
		}
		
		/**
		 * 删除
		 *
		 */
		public void delete(){
			m_deleted = true;
		}
		
		/**
		 * 
		 *
		 */
		public void clear(){
			try
			{
				m_deleted = false;
			    if( m_back != null ) m_back.clear();
			    if( m_front != null ) m_front.clear();
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param name
		 */
		public void clearProperty( String name ){
			try
			{
				name = name.toUpperCase();
				if( m_back != null ) m_back.remove( name );
				if( m_front != null ) m_front.remove( name );
			}
			finally{
				
			}
		}
	}
	
	public static class HQSQLEntityOffer implements java.io.Serializable{
		private static final long serialVersionUID = -1719289983356793591L;
		private CarbonList<HQSQLEntityBean> _little = new CarbonList<HQSQLEntityBean>(); 
		private java.util.Map<String, Object> _subflow  = new java.util.HashMap<String, Object>();
		public HQSQLEntityOffer(){
			super();
		}
		
		/**
		 * @return 子记录数据[删除/添加时其他操作]
		 */
		public CarbonList<HQSQLEntityBean> getLittle() {
			return _little;
		}

		/**
		 * @return 扩展属性
		 */
		public java.util.Map getSubFlow() {
			return _subflow;
		}
	}
}
