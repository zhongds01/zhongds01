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
	/*����*/
	private Object _objective   = null;
	/*���ݹ鵵*/
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
	 * @return ����
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return ���ݹ鵵
	 */
	public IUpdfmxOffer getSUBFLOW() {
		return _order;
	}

	public static class IUpdfmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = 6966220669324210912L;
		private UUID _id;
		/*���ݷ���*/
		private String _repository;
		/*�ֿ��ܺ�*/
		private int _suming = 0;
		/*����ʱ��*/
		private java.sql.Timestamp _create;
		/*���ʱ��*/
		private java.sql.Timestamp _complete;
		/*���ݲֿ�*/
		private java.util.HashMap   _subflow = new java.util.HashMap();
	    /*��������*/
		private CarbonList _order   = new CarbonList();
		/*��ʱ�־û�*/
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
		 * @return ���ݷ���
		 */
		public String getREPOSITORY() {
			return _repository;
		}
		
		/**
		 * @return �ֿ��ܺ�
		 */
		public int getSUMING() {
			return _suming;
		}
		
		/**
		 * @param suming �ֿ��ܺ�
		 */
		public void setSUMING(int suming) {
			_suming = suming;
		}
		
		/**
		 * @return ����ʱ��
		 */
		public java.sql.Timestamp getCREATE() {
			return _create;
		}
		
		/**
		 * @param create ����ʱ��
		 */
		public void setCREATE(java.sql.Timestamp create) {
			_create = create;
		}
		
		/**
		 * @return ���ʱ��
		 */
		public java.sql.Timestamp getCOMPLETE() {
			return _complete;
		}
		
		/**
		 * @param complete ���ʱ��
		 */
		public void setCOMPLETE(java.sql.Timestamp complete) {
			_complete = complete;
		}
		
		/**
		 * @return ���ݲֿ�
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * �������ݱ��ȡ���ݲֿ�
		 * @param _table ���ݱ�
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
		 * ��ͨ�־û�
		 * @return 
		 */
		public CarbonList getORDER() {
			return _order;
		}

		/**
		 * @return ��ʱ�־û�
		 */
		public CarbonList getFUTURE() {
			return _future;
		}
		
	}
}
