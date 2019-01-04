package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018��8��6��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IOVUpdfmxUnique implements java.io.Serializable{
	private static final long serialVersionUID = -5645131830956549096L;
	private Object _objective;
	/*������Ԫ*/
	private IPlatformTemplate.IUpffmOffer _platform_;
	/*��������*/
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
	 * @return ������Ԫ
	 */
	public IPlatformTemplate.IUpffmOffer getPLATFORM() {
		return _platform_;
	}
	
	/**
	 * @return ��������
	 */
	public java.util.Map<String, IUpdfmxUnique> getUNIQUE() {
		return _unique;
	}
	
	/**
	 * ���ݹ������������ȡ����������
	 * @param _component_ ��������
	 * @return
	 */
	public IUpdfmxUnique getUNIQUE( String _component_ ){
		return (IUpdfmxUnique)_unique.get( _component_ );
	}
	
	public static class IUpdfmxUnique implements java.io.Serializable{
		private static final long serialVersionUID = -4357196138816663983L;
		/*�������*/
		protected long   _order_id;
		/*��������*/
		protected String _category;
		/*�û����*/
		protected long   _user_id ;
		/*ԤԼʱ��*/
		protected java.sql.Timestamp _create_date;
		/*���б���*/
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
		 * @return �������
		 */
		public long getORDER_ID() {
			return _order_id;
		}
		
		/**
		 * @param order_id �������
		 */
		public void setORDER_ID(long order_id) {
			_order_id = order_id;
		}
		
		/**
		 * @return ��������
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param category ��������
		 */
		public void setCATEGORY(String category) {
			_category = category;
		}
		
		/**
		 * @return user_id �û����
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param user_id �û����
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return create_date ԤԼʱ��
		 */
		public java.sql.Timestamp getCREATE_DATE() {
			return _create_date;
		}
		
		/**
		 * @param create_date ԤԼʱ��
		 */
		public void setCREATE_DATE(java.sql.Timestamp create_date) {
			_create_date = create_date;
		}
		
		/**
		 * @return region_id ���б���
		 */
		public String getREGION_ID() {
			return _region_id;
		}
		
		/**
		 * @param region_id ���б���
		 */
		public void setREGION_ID(String region_id) {
			_region_id = region_id;
		}

		/**
		 * ��ȡ��ǰ����
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
