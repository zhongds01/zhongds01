package com.ai.sacenter.i18n;

import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务调度异常</p>
 * <p>Copyright: Copyright (c) 2018年1月4日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class SFESFaultException extends SF18NException {
	private static final long serialVersionUID = -4646297729388087792L;
	public SFESFaultException() {
		super();
	}

	/**
	 * @param exception
	 */
	public SFESFaultException(SFException exception) {
		super(exception);
	}

	/**
	 * @param faultCode
	 * @param args
	 */
	public SFESFaultException(String faultCode, Object[] args) {
		super(faultCode, args);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param throwable
	 */
	public SFESFaultException(String faultCode, Object[] args, Throwable throwable) {
		super(faultCode, args, throwable);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 */
	public SFESFaultException(String faultCode, Object[] args, String originator) {
		super(faultCode, args, originator);
	}

	/**
	 * @param faultCode
	 * @param args
	 * @param originator
	 * @param throwable
	 */
	public SFESFaultException(String faultCode, Object[] args, String originator, Throwable throwable) {
		super(faultCode, args, originator, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 */
	public SFESFaultException(String faultCode, String message) {
		super(faultCode, message);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param throwable
	 */
	public SFESFaultException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 */
	public SFESFaultException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}

	/**
	 * @param faultCode
	 * @param message
	 * @param originator
	 * @param throwable
	 */
	public SFESFaultException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}

}
