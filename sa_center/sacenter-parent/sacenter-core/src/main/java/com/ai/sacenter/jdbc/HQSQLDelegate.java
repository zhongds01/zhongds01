package com.ai.sacenter.jdbc;

public class HQSQLDelegate implements java.io.Serializable{
	private static final long serialVersionUID = -687763569260754123L;
	/*�־û�DAO��*/
	private String PERSISTENT;
	/*�־û�����*/
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
