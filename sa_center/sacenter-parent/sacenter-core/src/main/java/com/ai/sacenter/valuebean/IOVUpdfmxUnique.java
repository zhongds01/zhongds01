package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018年8月6日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IOVUpdfmxUnique implements java.io.Serializable{
	private static final long serialVersionUID = -5645131830956549096L;
	private Object _objective;
	/*归属网元*/
	private IPlatformTemplate.IUpffmOffer _platform_;
	/*归属索引*/
	private java.util.Map<String, IUpdfmxUnique> _unique = new java.util.HashMap<String, IUpdfmxUnique>();
	public IOVUpdfmxUnique() {
		super();
	}

	public IOVUpdfmxUnique( IOVUpdfmxUnique _unqiue_ ) throws Exception {
		super();
		_objective = _unqiue_._objective;
		_platform_ = _unqiue_._platform_;
		for( java.util.Iterator<String> itera = _unqiue_._unique.keySet().iterator(); itera.hasNext(); ){
			String __component__ = (String)itera.next();
			IUpdfmxUnique __unqiue__ = (IUpdfmxUnique)_unqiue_._unique.get( __component__ );
			_unique.put( __component__, (IUpdfmxUnique)ClassUtils.IClass.atomDesign( __unqiue__ ) );
		}
	}
	
	public IOVUpdfmxUnique(Object objective,IPlatformTemplate.IUpffmOffer platform) {
		super();
		_objective  = objective;
		_platform_  = platform ;
	}
	
	/**
	 * @return the _objective
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 归属网元
	 */
	public IPlatformTemplate.IUpffmOffer getPLATFORM() {
		return _platform_;
	}
	
	/**
	 * @return 归属索引
	 */
	public java.util.Map<String, IUpdfmxUnique> getUNIQUE() {
		return _unique;
	}
	
	/**
	 * 根据归属索引编码获取归属索引区
	 * @param _component_ 索引编码
	 * @return
	 */
	public IUpdfmxUnique getUNIQUE( String _component_ ){
		return (IUpdfmxUnique)_unique.get( _component_ );
	}
	
	public static class IUpdfmxUnique implements java.io.Serializable{
		private static final long serialVersionUID = -4357196138816663983L;
		/*定单编号*/
		protected long   _order_id;
		/*索引类型*/
		protected String _category;
		/*用户编号*/
		protected long   _user_id ;
		/*预约时间*/
		protected java.sql.Timestamp _create_date;
		/*地市编码*/
		protected String _region_id;
		public IUpdfmxUnique(){
			super();
		}
		
		public IUpdfmxUnique( IUpdfmxUnique _unique_ ) throws Exception{
			super();
			_order_id    = _unique_._order_id    ;   
			_category    = _unique_._category    ;
			_user_id     = _unique_._user_id     ;
			_create_date = _unique_._create_date ;
			_region_id   = _unique_._region_id   ;
		}
		
		/**
		 * @return 定单编号
		 */
		public long getORDER_ID() {
			return _order_id;
		}
		
		/**
		 * @param order_id 定单编号
		 */
		public void setORDER_ID(long order_id) {
			_order_id = order_id;
		}
		
		/**
		 * @return 索引类型
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param category 索引类型
		 */
		public void setCATEGORY(String category) {
			_category = category;
		}
		
		/**
		 * @return user_id 用户编号
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param user_id 用户编号
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return create_date 预约时间
		 */
		public java.sql.Timestamp getCREATE_DATE() {
			return _create_date;
		}
		
		/**
		 * @param create_date 预约时间
		 */
		public void setCREATE_DATE(java.sql.Timestamp create_date) {
			_create_date = create_date;
		}
		
		/**
		 * @return region_id 地市编码
		 */
		public String getREGION_ID() {
			return _region_id;
		}
		
		/**
		 * @param region_id 地市编码
		 */
		public void setREGION_ID(String region_id) {
			_region_id = region_id;
		}

		/**
		 * 获取当前索引
		 * @return
		 */
		public String getINDEX(){
			StringBuilder fromINDEX = new StringBuilder();
			try
			{
				fromINDEX.append( _order_id > 0?String.valueOf(_order_id):"*" ).append("_$_")
				         .append( _user_id > 0?String.valueOf(_user_id):"*").append("_$_")
				         .append( _category != null?_category:"*" ).append("_$_")
				         .append( _create_date != null?TimeUtils.yyyymmddhhmmss( _create_date ):"*" ).append("_$_")
				         .append( _region_id );
			}
			finally{
				
			}
			return fromINDEX.toString();
		}
	}
	
}
