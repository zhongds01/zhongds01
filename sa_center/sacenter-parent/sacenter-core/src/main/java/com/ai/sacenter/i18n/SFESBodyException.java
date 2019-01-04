package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务包体非法</p>
 * <p>Copyright: Copyright (c) 2018年1月4日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class SFESBodyException extends SF18NException {
	private static final long serialVersionUID = 1462354836996841766L;
	public SFESBodyException() {
		super();
	}

	/**
	 * @param exception
	 */
	public SFESBodyException(SFException exception) {
		super(exception);
	}

	/**
	 * @param faultCode
	 * @param args
	 */
	public SFESBodyException(String faultCode, Object[] args) {
		super(faultCode, args);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param throwable
	 */
	public SFESBodyException(String faultCode, Object[] args, Throwable throwable) {
		super(faultCode, args, throwable);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 */
	public SFESBodyException(String faultCode, Object[] args, String originator) {
		super(faultCode, args, originator);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 * @param throwable
	 */
	public SFESBodyException(String faultCode, Object[] args, String originator, Throwable throwable) {
		super(faultCode, args, originator, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 */
	public SFESBodyException(String faultCode, String message) {
		super(faultCode, message);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFESBodyException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 */
	public SFESBodyException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 * @param throwable
	 */
	public SFESBodyException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}

}
