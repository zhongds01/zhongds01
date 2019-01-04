package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 开通外部业务异常</p>
 * <p>Copyright: Copyright (c) 2017年5月25日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFBsException extends SF18NException {
	private static final long serialVersionUID = -6846134205103250269L;
	public SFBsException() {
		super();
	}

	/**
	 * @param exception
	 */
	public SFBsException(SFException exception) {
		super(exception);
	}

	/**
	 * @param faultCode
	 * @param args
	 */
	public SFBsException(String faultCode, Object[] args) {
		super(faultCode, args);
	}
	
	/**
	 * @param faultCode
	 * @param args
	 * @param throwable
	 */
	public SFBsException(String faultCode, Object[] args, Throwable throwable) {
		super(faultCode, args, throwable);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 */
	public SFBsException(String faultCode, Object[] args, String originator) {
		super(faultCode, args, originator);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 * @param throwable
	 */
	public SFBsException(String faultCode, Object[] args, String originator, Throwable throwable) {
		super(faultCode, args, originator, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 */
	public SFBsException(String faultCode, String message) {
		super(faultCode, message);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFBsException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 */
	public SFBsException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 * @param throwable
	 */
	public SFBsException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}

}
