package com.ai.sacenter.jdbc;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class HQSQLConst {
	/*表结构说明*/
	public static interface Category{
		/*JDBC_MAP模式*/
		public static final String SYBASE = "SYBASE";
		/*JDBC_APP模式*/
		public static final String ORACLE = "ORACLE";
		/*JDBC_HQSQL模式*/
		public static final String MYSQL5 = "MYSQL5";
		public static interface Column{
			public static final String COLUMN   = "COL"    ;
			public static final String PRIMARY  = "PK"     ;
			public static final String VIRTUAL  = "VIRTUAL";
		}
		
		public static interface Null{
			/*可空*/
			public static final String Null    = "Y";
			/*不可空*/
			public static final String NoNull  = "N";
			/*未知*/
			public static final String Unknown = "*";
		}
		
		public interface Status{
			/*未知*/
			public static final int UNKNOWN = 0;
			/*非用户下表*/
			public static final int SCHEMA = 1;
			/*表已池化*/
			public static final int ACTIVE = 2;
		}
	}
}
