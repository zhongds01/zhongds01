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
	/*��ṹ˵��*/
	public static interface Category{
		/*JDBC_MAPģʽ*/
		public static final String SYBASE = "SYBASE";
		/*JDBC_APPģʽ*/
		public static final String ORACLE = "ORACLE";
		/*JDBC_HQSQLģʽ*/
		public static final String MYSQL5 = "MYSQL5";
		public static interface Column{
			public static final String COLUMN   = "COL"    ;
			public static final String PRIMARY  = "PK"     ;
			public static final String VIRTUAL  = "VIRTUAL";
		}
		
		public static interface Null{
			/*�ɿ�*/
			public static final String Null    = "Y";
			/*���ɿ�*/
			public static final String NoNull  = "N";
			/*δ֪*/
			public static final String Unknown = "*";
		}
		
		public interface Status{
			/*δ֪*/
			public static final int UNKNOWN = 0;
			/*���û��±�*/
			public static final int SCHEMA = 1;
			/*���ѳػ�*/
			public static final int ACTIVE = 2;
		}
	}
}
