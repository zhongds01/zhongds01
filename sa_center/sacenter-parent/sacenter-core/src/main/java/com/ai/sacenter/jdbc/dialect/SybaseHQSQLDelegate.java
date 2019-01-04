package com.ai.sacenter.jdbc.dialect;

import com.ai.sacenter.jdbc.HQSQLConst;
import com.ai.sacenter.jdbc.HQSQLDelegate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ����JDBC_MAPģʽ</p>
 * <p>Copyright: Copyright (c) 2014-10-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SybaseHQSQLDelegate extends HQSQLDelegate {
	private static final long serialVersionUID = -1448002548444748806L;
	/*��������[KEY=����Դ.����],DATA=�����б�*/
	private java.util.HashMap CREATE  = new java.util.HashMap();
	/*ɾ������[KEY=����Դ.����],DATA=�����б�*/
	private java.util.HashMap DELETE  = new java.util.HashMap();
	/*��������[KEY=����Դ.����],DATA=�����б�*/
	private java.util.HashMap HISTORY = new java.util.HashMap();
	public SybaseHQSQLDelegate(String aREPOSITORY) {
		super(aREPOSITORY, HQSQLConst.Category.SYBASE);
	}
	/**
	 * @return the cREATE
	 */
	public java.util.HashMap getCREATE() {
		return CREATE;
	}
	/**
	 * @return the dELETE
	 */
	public java.util.HashMap getDELETE() {
		return DELETE;
	}
	/**
	 * @return the hISTORY
	 */
	public java.util.HashMap getHISTORY() {
		return HISTORY;
	}

}
