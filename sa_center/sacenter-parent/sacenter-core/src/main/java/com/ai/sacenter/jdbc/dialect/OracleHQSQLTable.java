package com.ai.sacenter.jdbc.dialect;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.jdbc.HQSQLConst;
import com.ai.sacenter.jdbc.HQSQLTable;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class OracleHQSQLTable extends HQSQLTable {
	private static final long serialVersionUID = 5063747229784021967L;
	/*数据来源*/
	private ObjectType schema;
	public OracleHQSQLTable( ObjectType _table ) throws Exception{
		super( _table );
		schema = _table;
	}

	public OracleHQSQLTable(HQSQLTable _table_, ObjectType _objecttype) throws Exception{
		super( _table_, _objecttype );
		schema = _objecttype;
	}
	
	public OracleHQSQLTable( String _owner, String _table_name, ObjectType _table) throws Exception{
		super( _owner, _table_name, _table );
		schema = _table;
	}
	
	/**
	 * @return the schema
	 */
	public ObjectType getSchema() {
		return schema;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.HQSQLTable#getTYPE()
	 */
	public String getTYPE() {
		return HQSQLConst.Category.ORACLE;
	}
}
