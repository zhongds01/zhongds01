package com.ai.sacenter.jdbc;

public class HQSQLDelegate implements java.io.Serializable{
	private static final long serialVersionUID = -687763569260754123L;
	/*持久化DAO类*/
	private String PERSISTENT;
	/*持久化类型*/
	private String COMPOSITE;
	public HQSQLDelegate(String aPERSISTENT,String aCOMPOSITE) {
		super();
		PERSISTENT = aPERSISTENT;
		COMPOSITE = aCOMPOSITE;
	}
	/**
	 * @return the cOMPOSITE
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}
	/**
	 * @return the pERSISTENT
	 */
	public String getPERSISTENT() {
		return PERSISTENT;
	}
}
