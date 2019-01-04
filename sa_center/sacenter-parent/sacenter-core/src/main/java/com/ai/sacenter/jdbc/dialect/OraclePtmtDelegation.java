package com.ai.sacenter.jdbc.dialect;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-11-26</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class OraclePtmtDelegation implements java.io.Serializable{
	private static final long serialVersionUID = 6576451538557136414L;
	/*创建*/
	private java.util.HashMap CREATE = new java.util.HashMap();
	/*更新*/
	private java.util.HashMap UPDATE = new java.util.HashMap();
	/*删除*/
	private java.util.HashMap DELETE = new java.util.HashMap();
	public OraclePtmtDelegation() {
		super();
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
	 * @return the uPDATE
	 */
	public java.util.HashMap getUPDATE() {
		return UPDATE;
	}
	
}
