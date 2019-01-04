package com.ai.sacenter.subtable;

import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.valuebean.ISubTableTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ISubSQLOffer implements java.io.Serializable{
	private static final long serialVersionUID = -5200015708717709841L;
    /*发起方*/
	private Object _objective;
	/*数据转换*/
	private IUpdfmxOffer _subflow;
	public ISubSQLOffer( Object objective ) {
		super();
		_objective = objective;
		_subflow   = new IUpdfmxOffer();
	}
	
	public ISubSQLOffer( Object objective, HQSQLEntityBean entity ){
		super();
		_objective = objective;
		_subflow   = new IUpdfmxOffer();
		_subflow._subflow.putAll( entity.getProperties                   () );
		_subflow._subflow.put   ( "PARAM", entity.getLittle().getSubFlow() );
		for( java.util.Iterator itera = entity.getLittle().getSubFlow().entrySet().iterator(); itera.hasNext(); ){
			java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
			if( _subflow._subflow.containsKey( fromEntry.getKey() ) == false ){
				_subflow._subflow.put( fromEntry.getKey(), fromEntry.getValue() );
			}
		}
	}
	
	public ISubSQLOffer( Object objective, HQSQLEntityBean entity, ISubTableTemplate.ISubSQLTable subtable, ISubTableTemplate.ISubSQLTableRel subjsql ) throws Exception {
		super();
		_objective = objective;
		_subflow           = new IUpdfmxOffer();
		_subflow._subtable = subtable          ;
		_subflow._subjsql  = subjsql           ;
		_subflow._subflow.putAll( entity.getProperties                   () );
		_subflow._subflow.put   ( "PARAM", entity.getLittle().getSubFlow() );
		_subflow._subject  = HQSQLUtils.getOracleTable( Class.forName( subjsql.getPERSISTENT() ), subjsql.getTARGET(), entity );
		for( java.util.Iterator itera = entity.getLittle().getSubFlow().entrySet().iterator(); itera.hasNext(); ){
			java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
			if( _subflow._subflow.containsKey( fromEntry.getKey() ) == false ){
				_subflow._subflow.put( fromEntry.getKey(), fromEntry.getValue() );
			}
		}
		
	}
	
	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 数据转换
	 */
	public IUpdfmxOffer getSubFlow() {
		return _subflow;
	}

	public static class IUpdfmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = -3878837498138880829L;
		/*原表规范*/
		private ISubTableTemplate.ISubSQLTable   _subtable = null;
		/*目标规范*/
		private ISubTableTemplate.ISubSQLTableRel _subjsql = null;
		/*目标结构*/
		private HQSQLTable        _subject = null;
		/*扩展属性*/
		private java.util.HashMap _subflow = new java.util.HashMap();
		public IUpdfmxOffer(){
			super();
		}
		
		/**
		 * @return 原表规范
		 */
		public ISubTableTemplate.ISubSQLTable getSubTable() {
			return _subtable;
		}

		/**
		 * @param subtable 原表规范
		 */
		public void setSubTable(ISubTableTemplate.ISubSQLTable subtable) {
			_subtable = subtable;
		}

		/**
		 * @return 目标规范
		 */
		public ISubTableTemplate.ISubSQLTableRel getSubJsql() {
			return _subjsql;
		}

		/**
		 * @param subjsql 目标规范
		 */
		public void setSubJsql(ISubTableTemplate.ISubSQLTableRel subjsql) {
			_subjsql = subjsql;
		}

		/**
		 * @return 目标结构
		 */
		public HQSQLTable getSubJect() {
			return _subject;
		}

		/**
		 * @param subject 目标结构
		 */
		public void setSubJect(HQSQLTable subject) {
			_subject = subject;
		}

		/**
		 * @return 扩展属性
		 */
		public java.util.HashMap getSubFlow() {
			return _subflow;
		}
	}
}
