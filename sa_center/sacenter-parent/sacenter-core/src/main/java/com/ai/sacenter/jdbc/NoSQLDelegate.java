package com.ai.sacenter.jdbc;

import com.ai.sacenter.jdbc.dialect.MySQL5HQSQLDelegate;
import com.ai.sacenter.jdbc.dialect.MySQL5HQSQLTable;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLDelegate;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.dialect.SybaseHQSQLDelegate;
import com.ai.sacenter.jdbc.dialect.SybaseHQSQLTable;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UUID;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-9-29</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class NoSQLDelegate implements java.io.Serializable{
	private static final long serialVersionUID = 7901109055663258436L;
	/*发起方*/
	private Object _objective   = null;
	/*数据归档*/
	private IUpdfmxOffer _order = null;
	public NoSQLDelegate(Object objective) {
		super();
		_objective = objective         ;
		_order     = new IUpdfmxOffer();
	}
	
	public NoSQLDelegate( Object objective, String repository ){
		super();
		_objective = objective                 ;
		_order = new IUpdfmxOffer( repository );
	}
	
	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 数据归档
	 */
	public IUpdfmxOffer getSUBFLOW() {
		return _order;
	}

	public static class IUpdfmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = 6966220669324210912L;
		private UUID _id;
		/*数据访问*/
		private String _repository;
		/*仓库总和*/
		private int _suming = 0;
		/*创建时间*/
		private java.sql.Timestamp _create;
		/*完成时间*/
		private java.sql.Timestamp _complete;
		/*数据仓库*/
		private java.util.HashMap   _subflow = new java.util.HashMap();
	    /*其他参数*/
		private CarbonList _order   = new CarbonList();
		/*临时持久化*/
		private CarbonList _future  = new CarbonList();
		public IUpdfmxOffer(){
			super();
			_id     = UUID.getUUID()    ;
			_suming = 0                 ;
		}
		
		public IUpdfmxOffer( String repository ){
			super();
			_id         = UUID.getUUID()        ;
			_repository = repository            ;
			_suming     = 0                     ;
			_create     = TimeUtils.getSysdate();
		}
		
		/**
		 * @return the iD
		 */
		public UUID getID() {
			return _id;
		}
		
		/**
		 * @return 数据访问
		 */
		public String getREPOSITORY() {
			return _repository;
		}
		
		/**
		 * @return 仓库总和
		 */
		public int getSUMING() {
			return _suming;
		}
		
		/**
		 * @param suming 仓库总和
		 */
		public void setSUMING(int suming) {
			_suming = suming;
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
		 * @return 完成时间
		 */
		public java.sql.Timestamp getCOMPLETE() {
			return _complete;
		}
		
		/**
		 * @param complete 完成时间
		 */
		public void setCOMPLETE(java.sql.Timestamp complete) {
			_complete = complete;
		}
		
		/**
		 * @return 数据仓库
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * 根据数据表获取数据仓库
		 * @param _table 数据表
		 * @return 
		 */
		public HQSQLDelegate getSUBFLOW( HQSQLTable _table ) {
			HQSQLDelegate _tables = (HQSQLDelegate)_subflow.get( _table );
			if( _tables == null ){
				if( _table instanceof MySQL5HQSQLTable ){
					_tables = new MySQL5HQSQLDelegate( _repository );
				}
				else if( _table instanceof OracleHQSQLTable ){
					_tables = new OracleHQSQLDelegate( _repository );
				}
				else if( _table instanceof SybaseHQSQLTable ){
					_tables = new SybaseHQSQLDelegate( _repository );
				}
				else{
					_tables = new OracleHQSQLDelegate( _repository );
				}
				_subflow.put( _table, _tables );
			}
			return _tables;
		}
		
		/**
		 * 开通持久化
		 * @return 
		 */
		public CarbonList getORDER() {
			return _order;
		}

		/**
		 * @return 临时持久化
		 */
		public CarbonList getFUTURE() {
			return _future;
		}
		
	}
}
