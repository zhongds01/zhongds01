package com.ai.sacenter.jdbc;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018Äê4ÔÂ26ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class HQSQLSubSQLBean extends HQSQLEntityBean {
	private static final long serialVersionUID = -5718509724736613241L;
	private ObjectType _objectType;
	public HQSQLSubSQLBean(OracleHQSQLTable type) throws Exception{
		super(type);
		_objectType = type.getSchema();
	}

	public HQSQLSubSQLBean(ObjectType type) throws Exception{
		super(type);
		_objectType = type;
	}

	public HQSQLSubSQLBean(String schema, ObjectType type) throws Exception{
		super(schema, type);
		_objectType = type;
	}

	public HQSQLSubSQLBean(DataStructInterface conatin) throws Exception{
		super(conatin);
		_objectType = conatin.getObjectType();
	}
	
	/**
	 * @return the _objectType
	 */
	public ObjectType getSchema() {
		return _objectType;
	}

}
