package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFRsRspException extends SFRemoteException {
	private static final long serialVersionUID = -8401511024705300004L;
	public SFRsRspException() {
		super();
	}
    
	/**
	 * @param exception
	 */
	public SFRsRspException(SFException exception) {
		super(exception);
	}

	/**
	 * 
	 * @param faultCode 异常代码
	 * @param args 参数
	 */
	public SFRsRspException( String faultCode, Object[] args ){
		super(faultCode, args);
	}
	
	/**
	 * 
	 * @param faultCode 异常代码
	 * @param args 参数
	 * @param throwable
	 */
	public SFRsRspException( String faultCode, Object[] args, java.lang.Throwable throwable ){
		super(faultCode, args, throwable);
	}
	
	/**
	 * 
	 * @param faultCode 异常代码
	 * @param args 参数
	 * @param originator 发起方
	 */
	public SFRsRspException( String faultCode, Object[] args, String originator ){
		super(faultCode, args, originator);
	}
	
	/**
	 * 
	 * @param faultCode 异常代码
	 * @param args 参数
	 * @param originator 发起方
	 * @param throwable
	 */
	public SFRsRspException( String faultCode, Object[] args, String originator, java.lang.Throwable throwable ){
		super(faultCode, args, originator, throwable);
	}
	
	/**
     * 
     * @param faultCode 异常代码
     * @param message 异常描述
     */
	public SFRsRspException(String faultCode, String message) {
		super(faultCode, message);
	}
	
	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFRsRspException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}

	/**
     * 
     * @param faultCode 异常代码
     * @param message 异常描述
     * @param originator 异常发起方
     */
	public SFRsRspException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}
	
	/**
     * 
     * @param faultCode 异常代码
     * @param message 异常描述
     * @param originator 发起方
     * @param throwable 异常原因
     */
	public SFRsRspException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}
	
}
