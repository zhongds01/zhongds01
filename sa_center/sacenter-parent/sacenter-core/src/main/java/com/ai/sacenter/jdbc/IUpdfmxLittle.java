package com.ai.sacenter.jdbc;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;

public class IUpdfmxLittle implements java.io.Serializable{
	private static final long serialVersionUID = -2542196731650655820L;
    protected DataStructInterface _instance;
    protected IUpffxLittle _little = null;
	public IUpdfmxLittle() {
		super();
		_little   = new IUpffxLittle();
	}

	public IUpdfmxLittle( DataStructInterface instance ) {
		super();
		_instance = instance          ;
		_little   = new IUpffxLittle();
	}
	
	public IUpdfmxLittle( IUpdfmxLittle little ) throws Exception{
		super();
		_instance = OracleUtils.ISystem.transfer( little._instance );
		_little   = new IUpffxLittle( little._little               );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Object getAsObject( String name ){
		if( _instance == null ){
			throw new java.lang.UnsupportedOperationException( name );
		}
		return _instance.get( name );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String getAsString( String name ){
		return ClassUtils.IClass.getAsString( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public int getAsInt( String name ){
		return ClassUtils.IClass.getAsInt( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public long getAsLong( String name ){
		return ClassUtils.IClass.getAsLong( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public double getAsDouble( String name ){
		return ClassUtils.IClass.getAsDouble( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public float getAsFloat( String name ){
		return ClassUtils.IClass.getAsFloat( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public byte getAsByte( String name ){
		return ClassUtils.IClass.getAsByte( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean getAsBoolean( String name ){
		return ClassUtils.IClass.getAsBoolean( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public char getAsChar( String name ){
		return ClassUtils.IClass.getAsChar( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public java.sql.Date getAsDate( String name ){
		return ClassUtils.IClass.getAsDate( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public java.sql.Time getAsTime( String name ){
		return ClassUtils.IClass.getAsTime( getAsObject(name) );
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public java.sql.Timestamp getAsDateTime( String name ){
		return ClassUtils.IClass.getAsTimestamp( getAsObject(name) );
	}
	
	/**
	 * 数据转换为新建状态
	 *
	 */
	public void setStsToNew(){
		if( _instance != null ){ _instance.setStsToNew(); }
		for( java.util.Iterator<IUpdfmxLittle> itera = _little._little.iterator(); itera.hasNext(); ){
			IUpdfmxLittle __little = (IUpdfmxLittle)itera.next();
			if( __little != null ){ __little.setStsToNew(); }
		}
	}
	
	/**
	 * 数据转换为未操作
	 *
	 */
	public void setStsToOld(){
		if( _instance != null ){ _instance.setStsToOld(); }
		for( java.util.Iterator<IUpdfmxLittle> itera = _little._little.iterator(); itera.hasNext(); ){
			IUpdfmxLittle __little = (IUpdfmxLittle)itera.next();
			if( __little != null ){ __little.setStsToOld(); }
		}
	}
	
	/**
	 * 强制更新
	 *
	 */
	public void forceStsToUpdate(){
		if( _instance != null ){ _instance.forceStsToUpdate(); }
		for( java.util.Iterator<IUpdfmxLittle> itera = _little._little.iterator(); itera.hasNext(); ){
			IUpdfmxLittle __little = (IUpdfmxLittle)itera.next();
			if( __little != null ){ __little.forceStsToUpdate(); }
		}
	}
	
	/**
	 * 撤销删除
	 *
	 */
	public void unDelete() {
		if( _instance != null && _instance instanceof DataContainer ){ 
			((DataContainer)_instance).unDelete(); 
		}
		else if( _instance != null && _instance instanceof HQSQLEntityBean ){
			((HQSQLEntityBean)_instance).unDelete(); 
		}
		for( java.util.Iterator<IUpdfmxLittle> itera = _little._little.iterator(); itera.hasNext(); ){
			IUpdfmxLittle __little = (IUpdfmxLittle)itera.next();
			if( __little != null ){ __little.unDelete(); }
		}
	}
	
	/**
	 * 删除
	 *
	 */
	public void delete(){
		if( _instance != null ){ _instance.delete(); }
		for( java.util.Iterator<IUpdfmxLittle> itera = _little._little.iterator(); itera.hasNext(); ){
			IUpdfmxLittle __little = (IUpdfmxLittle)itera.next();
			if( __little != null ){ __little.delete(); }
		}
	}

	/**
	 * @return the instance
	 */
	public DataStructInterface getINSTANCE() {
		return _instance;
	}

	/**
	 * 
	 * @param instance
	 */
	public void setINSTANCE(DataStructInterface instance) {
		_instance = instance;
	}

	/**
	 * @return 本地仓库[未默认初始化]
	 */
	protected Class<?> getDestiny(){
		return _little._repository;
	}

	/**
	 * @return the _little
	 */
	public IUpffxLittle getLittle() {
		return _little;
	}

	public static class IUpffxLittle implements java.io.Serializable{
		private static final long serialVersionUID = 7701328598970216367L;
		protected Class<?> _repository = null;
		protected CarbonList<IUpdfmxLittle> _little = new CarbonList<IUpdfmxLittle>();
		protected java.util.HashMap<Object, Object> _subflow = new java.util.HashMap<Object, Object>();
		public IUpffxLittle(){
			super();
		}
		
		public IUpffxLittle( IUpffxLittle little ) throws Exception{
			super();
			_repository = little._repository;
			_subflow.putAll( little._subflow );
			for( java.util.Iterator<IUpdfmxLittle> itera = little._little.iterator(); itera.hasNext(); ){
				IUpdfmxLittle __little = (IUpdfmxLittle)itera.next();
				IUpdfmxLittle ____little = (IUpdfmxLittle)ClassUtils.IClass.atomDesign( __little );
				_little.add( ____little );
			}
		}
		
		/**
		 * @return 本地仓库
		 */
		public Class<?> getREPOSITORY() {
			if( _repository == null ){
				_repository = com.ai.sacenter.jdbc.impl.ISystemDAOImpl.class;
			}
			return _repository;
		}
		
		/**
		 * @param rEPOSITORY 本地仓库
		 */
		public void setREPOSITORY(Class<?> rEPOSITORY) {
			_repository = rEPOSITORY;
		}
		
		/**
		 * @return 扩展属性
		 */
		public CarbonList<IUpdfmxLittle> getLITTLE() {
			return _little;
		}

		/**
		 * @return 开通属性
		 */
		public java.util.HashMap<Object, Object> getSUBFLOW() {
			return _subflow;
		}
	}
	
}
