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
public class SybaseHQSQLTable extends HQSQLTable {
	private static final long serialVersionUID = 877982300126534924L;
	public SybaseHQSQLTable( ObjectType _table ) throws Exception{
		super( _table );
	}
	
	public SybaseHQSQLTable(String _owner, String _table_name) throws Exception{
		super( _owner, _table_name );
	}
	
	public SybaseHQSQLTable(HQSQLTable _table_, ObjectType _objecttype) throws Exception{
		super( _table_, _objecttype );
	}
	
	public SybaseHQSQLTable(String _owner, String _table_name, ObjectType _table) throws Exception{
		super( _owner, _table_name, _table );
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.HQSQLTable#getTYPE()
	 */
	public String getTYPE() {
		return HQSQLConst.Category.SYBASE;
	}

}
