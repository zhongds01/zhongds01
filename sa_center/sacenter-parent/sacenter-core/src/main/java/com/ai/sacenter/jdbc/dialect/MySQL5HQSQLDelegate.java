package com.ai.sacenter.jdbc.dialect;

import com.ai.sacenter.jdbc.HQSQLConst;
import com.ai.sacenter.jdbc.HQSQLDelegate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: JDBC_HQSQL模式</p>
 * <p>Copyright: Copyright (c) 2014-10-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class MySQL5HQSQLDelegate extends HQSQLDelegate {
	private static final long serialVersionUID = -117762103553214409L;
	/*数据仓库{[KEY=数据源.表名],DATA=数据列表}*/
	private java.util.HashMap REPOSITORY = new java.util.HashMap();
	public MySQL5HQSQLDelegate(String aREPOSITORY) {
		super(aREPOSITORY, HQSQLConst.Category.MYSQL5);
	}
	/**
	 * @return the rEPOSITORY
	 */
	public java.util.HashMap getREPOSITORY() {
		return REPOSITORY;
	}
}
