package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ����ʽ���쳣</p>
 * <p>Copyright: Copyright (c) 2017��5��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFJevalException extends SFIllegalException {
	private static final long serialVersionUID = 5398052896575159049L;
	public SFJevalException(){
		super();
	}
	
	/**
	 * @param exception
	 */
	public SFJevalException(SFException exception) {
		super(exception);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 */
	public SFJevalException( String faultCode, Object[] args ){
		super(faultCode, args);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param throwable
	 */
	public SFJevalException( String faultCode, Object[] args, java.lang.Throwable throwable ){
		super(faultCode, args, throwable);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param originator ����
	 */
	public SFJevalException( String faultCode, Object[] args, String originator ){
		super(faultCode, args, originator);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param originator ����
	 * @param throwable
	 */
	public SFJevalException( String faultCode, Object[] args, String originator, java.lang.Throwable throwable ){
		super(faultCode, args, originator, throwable);
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     */
	public SFJevalException(String faultCode, String message) {
		super(faultCode, message);
	}
	
	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFJevalException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator �쳣����
     */
	public SFJevalException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator ����
     * @param throwable �쳣ԭ��
     */
	public SFJevalException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}
	
}