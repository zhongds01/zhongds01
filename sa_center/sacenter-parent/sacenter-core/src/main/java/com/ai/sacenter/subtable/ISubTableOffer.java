package com.ai.sacenter.subtable;

import com.ai.appframe2.complex.self.po.TableSplit;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年2月21日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISubTableOffer implements java.io.Serializable{
	private static final long serialVersionUID = -5188247853205629419L;
	/*分表变量*/
	private java.util.Map _table = new java.util.HashMap();
	public ISubTableOffer(){
		super();
	}
	/**
	 * 
	 * @param aTableSplit
	 * @return
	 */
	public ISubTableOfferHome add( TableSplit aTableSplit ){
		ISubTableOfferHome fromSubTable = null;
		try
		{
			if( _table.containsKey( aTableSplit.getTableName() ) ){
				fromSubTable = (ISubTableOfferHome)_table.get( aTableSplit.getTableName() );
			}
			else{
				fromSubTable = new ISubTableOfferHome( );
				fromSubTable.setTableName( aTableSplit.getTableName() );
				fromSubTable.setSubTable( aTableSplit );
				_table.put( aTableSplit.getTableName(), fromSubTable );
			}
		}
		finally{
			
		}
		return fromSubTable;
	}
	/**
	 * 
	 * @param aTableSplit
	 * @param columnName
	 * @param value
	 * @return
	 */
	public ISubTableOfferHome add(TableSplit aTableSplit,
			String columnName, 
			String value){
		ISubTableOfferHome aSubTableCross = null;
		try
		{
			ISubTableOfferHome fromSubTable = null;
			if( StringUtils.isBlank( aTableSplit.getTableName() ) || StringUtils.isBlank( columnName ) || value == null ){
				ExceptionFactory.throwIllegal("IOS0014007", new String[]{aTableSplit.getTableName() ,columnName , value });
			}
			if( _table.containsKey( aTableSplit.getTableName() ) ){
				fromSubTable = (ISubTableOfferHome)_table.get( aTableSplit.getTableName() );
				fromSubTable.addColAndValue( columnName , value );
			}
			else{
				fromSubTable = new ISubTableOfferHome( );
				fromSubTable.setTableName( aTableSplit.getTableName() );
				fromSubTable.setSubTable( aTableSplit );
				fromSubTable.addColAndValue( columnName , value );
				_table.put( fromSubTable.getTableName(), fromSubTable );
			}
		}
		finally{
			
		}
		return aSubTableCross;
	}
	/**
	 * 
	 * @param tableName
	 * @return
	 */
	public ISubTableOfferHome getTable( String tableName ){
		return (ISubTableOfferHome)_table.get( tableName );
	}
	/**
	 * @return the table
	 */
	public java.util.Map getTable() {
		return _table;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-9-10</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISubTableOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 6046267609928916419L;
		/*表名*/
		private String _tableName;
		/*分表规范*/
		private TableSplit _subTable;
		/*变量列表*/
		private java.util.Map _variables = new java.util.HashMap();
		public ISubTableOfferHome(){
			super();
		}
		public ISubTableOfferHome( String aTableName ){
			super();
			_tableName = aTableName;
		}
		public ISubTableOfferHome( String aTableName, TableSplit fromSubTable ){
			super();
			_tableName = aTableName;
			_subTable  = fromSubTable;
		}
		/**
		 * @return 表名
		 */
		public String getTableName() {
			return _tableName;
		}
		/**
		 * @param tableName 表名
		 */
		public void setTableName(String tableName) {
			_tableName = tableName;
		}
		/**
		 * @return 分表规范
		 */
		public TableSplit getSubTable() {
			return _subTable;
		}
		/**
		 * @param subTable 分表规范
		 */
		public void setSubTable(TableSplit subTable) {
			_subTable = subTable;
		}
		/**
		 * 设置变量列表
		 * @param columnName
		 * @param strValues
		 */
		public void addColAndValue(String columnName, String aValues){
			_variables.put( columnName, aValues );
		}
		/**
		 * 获取变量列表
		 * @param columnName
		 * @return
		 */
		public String getValueByCol(String columnName) {
		    return ((String)_variables.get(columnName)); 
		}
		/**
		 * @return 变量列表
		 */
		public java.util.Map getVariables() {
			return _variables;
		}
	}
}
