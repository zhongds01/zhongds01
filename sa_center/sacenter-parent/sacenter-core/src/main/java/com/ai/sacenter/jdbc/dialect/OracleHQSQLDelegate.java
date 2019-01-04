package com.ai.sacenter.jdbc.dialect;

import com.ai.sacenter.jdbc.HQSQLConst;
import com.ai.sacenter.jdbc.HQSQLDelegate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: JDBC_APP模式</p>
 * <p>Copyright: Copyright (c) 2014-10-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class OracleHQSQLDelegate extends HQSQLDelegate {
	private static final long serialVersionUID = -4952784068007885441L;
	/*数据仓库*/
	private java.util.List REPOSITORY = new java.util.ArrayList();
	public OracleHQSQLDelegate(String aREPOSITORY) {
		super(aREPOSITORY, HQSQLConst.Category.ORACLE );
	}
	/**
	 * @return the rEPOSITORY
	 */
	public java.util.List getREPOSITORY() {
		return REPOSITORY;
	}
}
