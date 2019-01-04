package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ���ݿ����쳣</p>
 * <p>Copyright: Copyright (c) 2017��5��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFOracleException extends SF18NException {
	private static final long serialVersionUID = -5572276683776758112L;
	public SFOracleException() {
		super();
	}
    
	/**
	 * @param exception
	 */
	public SFOracleException(SFException exception) {
		super(exception);
	}

	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 */
	public SFOracleException( String faultCode, Object[] args ){
		super(faultCode, args);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param throwable
	 */
	public SFOracleException( String faultCode, Object[] args, java.lang.Throwable throwable ){
		super(faultCode, args, throwable);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param originator ����
	 */
	public SFOracleException( String faultCode, Object[] args, String originator ){
		super(faultCode, args, originator);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param originator ����
	 * @param throwable
	 */
	public SFOracleException( String faultCode, Object[] args, String originator, java.lang.Throwable throwable ){
		super(faultCode, args, originator, throwable);
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     */
	public SFOracleException(String faultCode, String message) {
		super(faultCode, message);
	}
	
	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFOracleException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}

	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator �쳣����
     */
	public SFOracleException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator ����
     * @param throwable �쳣ԭ��
     */
	public SFOracleException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}
	
}
