package com.ai.sacenter.i18n;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: �������쳣</p>
 * <p>Copyright: Copyright (c) 2017��5��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SF18NException extends SFException {
	private static final long serialVersionUID = 660468848698172496L;
	public SF18NException() {
		super();
	}
    
	/**
	 * @param exception
	 */
	public SF18NException(SFException exception) {
		super(exception);
	}

	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 */
	public SF18NException( String faultCode, Object[] args ){
		super(faultCode, _wrapAsMessage( faultCode, args ), IUpdcConst.IUpfwm.IUpfm.ucmframe );
		setArgs      ( args                             );
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param throwable
	 */
	public SF18NException( String faultCode, Object[] args, java.lang.Throwable throwable ){
		super( faultCode, _wrapAsMessage( faultCode, args ), throwable );
		setArgs      ( args                             );
		setOriginator( IUpdcConst.IUpfwm.IUpfm.ucmframe );
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param originator ����
	 */
	public SF18NException( String faultCode, Object[] args, String originator ){
		super(faultCode, _wrapAsMessage( faultCode, args ), originator);
		setArgs      ( args                             );
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param args ����
	 * @param originator ����
	 * @param throwable
	 */
	public SF18NException( String faultCode, Object[] args, String originator, java.lang.Throwable throwable ){
		super(faultCode, _wrapAsMessage( faultCode, args ), originator, throwable);
		setArgs      ( args                             );
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     */
	public SF18NException(String faultCode, String message) {
		super(faultCode, message);
	}
	
	/**
	 * 
	 * @param faultCode �쳣����
	 * @param message �쳣����
	 * @param throwable
	 */
	public SF18NException(String faultCode, String message, Throwable throwable) {
		super(faultCode, message, throwable);
	}
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator �쳣����
     */
	public SF18NException(String faultCode, String message, String originator) {
		super(faultCode, message, originator);
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator �쳣����
     * @param throwable �쳣ԭ��
     */
	public SF18NException(String faultCode, String message, String originator, Throwable throwable) {
		super(faultCode, message, originator, throwable);
	}
	
	/**
	 * 
	 * @param faultCode
	 * @param args
	 * @return
	 */
	private static String _wrapAsMessage( String faultCode, Object[] args ){
		return  ExceptionFactory.getDefault().getDefault( faultCode, args );
	}
	
}
