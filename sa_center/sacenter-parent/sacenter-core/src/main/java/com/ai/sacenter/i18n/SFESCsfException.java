package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 外部服务异常</p>
 * <p>Copyright: Copyright (c) 2018年1月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class SFESCsfException extends SF18NException {
	private static final long serialVersionUID = -6025808098505462663L;
	public SFESCsfException() {
		super();
	}

	/**
	 * @param exception
	 */
	public SFESCsfException(SFException exception) {
		super(exception);
	}

	/**
	 * @param faultCode
	 * @param args
	 */
	public SFESCsfException(String faultCode, Object[] args) {
		super(faultCode, args);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param throwable
	 */
	public SFESCsfException(String faultCode, Object[] args, Throwable throwable) {
		super(faultCode, args, throwable);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 */
	public SFESCsfException(String faultCode, Object[] args, String originator) {
		super(faultCode, args, originator);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 * @param throwable
	 */
	public SFESCsfException(String faultCode, Object[] args, String originator, Throwable throwable) {
		super(faultCode, args, originator, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 */
	public SFESCsfException(String faultCode, String message) {
		super(faultCode, message);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFESCsfException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 */
	public SFESCsfException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 * @param throwable
	 */
	public SFESCsfException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}

}
