package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UUID;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 开通持久化集</p>
 * <p>Copyright: Copyright (c) 2017年6月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpdfmxOffer implements java.io.Serializable{
	private static final long serialVersionUID = -2594067739289977937L;
	/*交易编号*/
	private UUID   _id = null;
	/*发起方*/
	private Object _objective = null;
	/*开通表集*/
	private IUpdfmxOfferHome _order = null;
	public IOVUpdfmxOffer() {
		super();
		_id    = UUID.getUUID        ();
		_order = new IUpdfmxOfferHome();
	}
	
	public IOVUpdfmxOffer( IOVUpdfmxOffer fromUpdfmx ){
		super();
		_objective = fromUpdfmx._objective                    ;
		_id        = UUID.getUUID                           ();
		_order     = new IUpdfmxOfferHome( fromUpdfmx._order );
	}
	
	public IOVUpdfmxOffer( Object objective ){
		super();
		_objective = objective             ;
		_id        = UUID.getUUID        ();
		_order     = new IUpdfmxOfferHome();
	}
	
	public IOVUpdfmxOffer( Object objective, History creator ){
		super();
		_objective = objective                      ;
		_id        = UUID.getUUID                 ();
		_order     = new IUpdfmxOfferHome( creator );
	}
	
	public IOVUpdfmxOffer( Object objective, History creator, java.sql.Timestamp create, java.sql.Timestamp complete ){
		super();
		_objective = objective;
		_id        = UUID.getUUID();
		_order = new IUpdfmxOfferHome( creator, create, complete );
	}
	
	/**
	 * @return 交易编号
	 */
	public UUID getID() {
		return _id;
	}

	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 开通表集
	 */
	public IUpdfmxOfferHome getORDER() {
		return _order;
	}

	public static class IUpdfmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 6966220669324210912L;
	    /*开通持久化*/
		private CarbonList _order   = new CarbonList();
		/*临时持久化*/
		private CarbonList _future  = new CarbonList();
		/*其他集合*/
		private java.util.HashMap _subflow = new java.util.HashMap();
		/*备份规范*/
		private History  _creator  = null;
		/*创建时间*/
		private java.sql.Timestamp  _create   = null;
		/*归档时间*/
		private java.sql.Timestamp  _complete = null;
		public IUpdfmxOfferHome(){
			super();
			_creator  = History.CREATE;
			_create   = new java.sql.Timestamp( System.currentTimeMillis() );
			_complete = new java.sql.Timestamp( System.currentTimeMillis() ); 
		}
		
		public IUpdfmxOfferHome( IUpdfmxOfferHome fromUpdfmx ){
			super();
			_creator  = fromUpdfmx._creator;
			_create   = fromUpdfmx._create ;
			_complete = fromUpdfmx._complete;
		}
		
		public IUpdfmxOfferHome( History creator ){
			super();
			_creator  = creator;
			_create   = new java.sql.Timestamp( System.currentTimeMillis() );
			_complete = new java.sql.Timestamp( System.currentTimeMillis() ); 
		}
		
		public IUpdfmxOfferHome( History creator, java.sql.Timestamp create, java.sql.Timestamp complete ){
			super();
			_creator  = creator  ;
			_create   = create   ;
			_complete = complete ; 
		}
		
		/**
		 * 开通持久化
		 * @return 
		 */
		public CarbonList getORDER() {
			return _order;
		}

		/**
		 * 按照指定类返回开通持久化
		 * @param aCOMPOSITE
		 * @return
		 */
		public Object getORDER( Class aCOMPOSITE ){
		   	return ClassUtils.IClass.arrayDesign( _order, aCOMPOSITE );
		}
		
		/**
		 * @return 临时持久化
		 */
		public CarbonList getFUTURE() {
			return _future;
		}
		
		/**
		 * 按照指定类返回临时持久化
		 * @param aCOMPOSITE
		 * @return
		 */
		public Object getFUTURE( Class aCOMPOSITE ){
		   	return ClassUtils.IClass.arrayDesign( _future, aCOMPOSITE );
		}
		
		/**
		 * @return 其他集合
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}

		/**
		 * 根据分表表名获取持久化存储结构[开通工单同步]
		 * @param _composite
		 * @return
		 */
		public CarbonList getSUBFLOW( long _composite ){
			java.lang.Long __composite = new java.lang.Long( _composite );
			CarbonList _phantom = (CarbonList)_subflow.get( __composite );
			if( _phantom == null ){
				_subflow.put( __composite, _phantom = new CarbonList() );
			}
			return _phantom;
		}
		
		/**
		 * 根据分表表名获取持久化存储结构[开通工单同步]
		 * @param _composite
		 * @return
		 */
		public CarbonList getSUBFLOW( String _composite ){
			CarbonList _phantom = (CarbonList)_subflow.get( _composite );
			if( _phantom == null ){
				_subflow.put( _composite, _phantom = new CarbonList() );
			}
			return _phantom;
		}
		
		/**
		 * @return 备份规范
		 */
		public History getCREATOR() {
			return _creator;
		}
		
		/**
		 * @return 创建时间
		 */
		public java.sql.Timestamp getCREATE() {
			return _create;
		}

		/**
		 * @param create 创建时间
		 */
		public void setCREATE(java.sql.Timestamp create) {
			_create = create;
		}

		/**
		 * @return 归档时间
		 */
		public java.sql.Timestamp getCOMPLETE() {
			return _complete;
		}

		/**
		 * @param complete 归档时间
		 */
		public void setCOMPLETE(java.sql.Timestamp complete) {
			_complete = complete;
		}
		
		/**
		 * 是否为创建则无备份模式
		 * @return
		 */
		public boolean isCREATE(){
			return _creator == History.CREATE;
		}
		
		/**
		 * 是否为创建则无备份模式
		 * @return
		 */
		public boolean isUPDATE(){
			return _creator == History.UPDATE;
		}
		
		/**
		 * 是否为删除则无备份模式
		 * @return
		 */
		public boolean isDELETE(){
			return _creator == History.DELETE;
		}
		
		/**
		 * 是否为删除则备份历史模式
		 * @return
		 */
		public boolean isHISTORY(){
			return _creator == History.HISTORY;
		}
		
		/**
		 * 是否为删除则备份失败模式
		 * @return
		 */
		public boolean isFAILURE(){
			return _creator == History.FAILURE;
		}
	}
	
	public static enum History {
		CREATE("创建则无备份"),UPDATE("更新则无备份"),DELETE("删除则无备份"),HISTORY("删除则备份历史"),FAILURE("删除则备份失败");
		private String _desc;
		private History( String desc){
			_desc = desc;
		}
		
		/**
		 * @return the _desc
		 */
		public String desc() {
			return _desc;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return super.toString() + "{" + super.name() + ", " +  _desc +"}";  
		}

	}
}
