package com.ai.sacenter.jdbc.dialect;

import com.ai.sacenter.jdbc.HQSQLTable;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-11-28</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class OraclePtmtDelegate implements java.io.Serializable{
	private static final long serialVersionUID = -1057236045404379595L;
	/*表结构*/
	private HQSQLTable table;
	/*数据记录*/
	private java.util.ArrayList delegation = new java.util.ArrayList();
	public OraclePtmtDelegate(HQSQLTable table){
		super();
		this.table = table;
	}
	/**
	 * @return the delegation
	 */
	public java.util.ArrayList getDelegation() {
		return delegation;
	}
	/**
	 * @return the table
	 */
	public HQSQLTable getTable() {
		return table;
	}
}
