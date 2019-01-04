package com.ai.sacenter.i18n;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.common.i18n.BusinessException;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.impl.SFUpdfxResourceImpl;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��5��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExceptionFactory {
	private static final Log log = LogFactory.getLog(ExceptionFactory.class);
	private static IUpdfxResource _default_factory = null;
	static{
		try
		{
			org.dom4j.Element aConfigItem = JdomUtils.IConfigure.getConfigItem( "LOCALE" );
			try{
				String fromFactory = JdomUtils.IConfigure.getAsString( aConfigItem, "LOCALE_CUSTOM", SFUpdfxResourceImpl.class.getName() );
				_default_factory = (IUpdfxResource)Class.forName( fromFactory.trim() ).newInstance();
			}
			catch( java.lang.Exception aException ){
				log.error( aException.getMessage(), aException );
				_default_factory = new SFUpdfxResourceImpl();
			}
		}
		finally{
			
		}
	}
	
	public ExceptionFactory() {
		super();
	}
	
	/**
	 * ��ȡ��ǰ��������
	 * @return
	 */
	public static java.util.Locale getLocale(){
		return _default_factory.getDefault();
	}
	
	/**
	 * ��ȡ��������ת��
	 * @return
	 */
	public static IUpdfxResource getDefault(){
		return _default_factory;
	}
	
	/**
	 * ������Դ�����ȡ������Դ[���쳣������Ĭ�Ϲ�����Դ]
	 * @param resource ��Դ����
	 * @param args �����嵥
	 * @return
	 */
	public static String getResource( String resource, Object args[]){
		return _default_factory.getDefault( resource, args );
	}
	
	/**
	 * �����쳣������쳣����ת��Ϊ��ͨ��ͨ�쳣
	 * @param faultCode �쳣����
	 * @param message �쳣����
	 * @return
	 */
	public static SFException getException(String faultCode, String message) {
		SFException aEXCEPTION = null;
		try 
		{
			if( StringUtils.isBlank( faultCode ) ){
				ExceptionFactory.throwException("IOS0011071", new Object[] { "EXCEPTION_CODE" });
			}
			else if( StringUtils.isBlank( message ) ) {
				try 
				{
					message = ExceptionFactory.getDefault().getResource( faultCode, new Object[] {});
				} 
				catch (java.lang.Exception aException) {
					message = "*";
				}
			}
			aEXCEPTION = new SF18NException(faultCode, message);
		} 
		finally {

		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣����ת��Ϊ��ͨ��ͨ�쳣
	 * @param faultCode �쳣����
	 * @param args �쳣����
	 * @return
	 */
	public static SFException getException( String faultCode, Object args[] ){
		SFException aEXCEPTION = null;
		try 
		{
			aEXCEPTION = new SF18NException( faultCode, args );
		} 
		finally {

		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣ת��Ϊ��ͨ�쳣����
	 * @param exception �쳣����
	 * @return
	 * @throws SFException
	 */
	public static SFException getException(java.lang.Exception exception) throws SFException {
		try 
		{
			if( exception instanceof SFException ){
				return (SFException)exception;
			}
			else if( exception.getCause() == null ){
				return _default_factory.getResource( exception );
			}
			else if( exception.getCause() instanceof java.lang.Exception ){
				return getException( (java.lang.Exception)exception.getCause() );
			}
			else{
				return _default_factory.getResource( exception );
			}
		} 
		finally {

		}
	}
	
	/**
	 * �����쳣����ת��Ϊ��ͨ�쳣
	 * @param originator ����
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getException( String originator, java.lang.Exception exception ){
		return _default_factory.getResource( originator, exception );
	}
	
	/**
	 * ��ȡĬ�ϳɹ��쳣����
	 * @return
	 */
	public static SFException getSucceed( ){
		SFException aEXCEPTION = null;
		try 
		{
			aEXCEPTION = _default_factory.getResource(IUpdcConst.IUpdfx.SUCCEED, new String[]{}, null );
		} 
		finally {

		}
		return aEXCEPTION;
	}
	/**
	 * �����쳣����ת��Ϊ��ͨ�������
	 * @param faultCode ��Դ����
	 * @param message ��Դ����
	 * @return
	 */
	public static SFBsException getExtend( String faultCode, String message ){
		SFException exception = new SFRemoteException( faultCode, message );
		return _default_factory.getExtend( exception, new Object[]{} );
	}
	
	/**
	 * �����쳣����ת��Ϊ��ͨ�������
	 * @param exception �쳣����
	 * @return
	 */
	public static SFBsException getExtend( java.lang.Exception exception ){
		return _default_factory.getExtend( exception, new Object[]{} );
	}
	
	/**
	 * ���ݿ�ͨ�쳣ת����ͳһ�����쳣
	 * @param exception ��ͨ�쳣
	 * @throws BusinessException
	 */
	public static void throwExtend( java.lang.Exception exception ) throws BusinessException{
		SFBsException fromExtend = _default_factory.getExtend( exception, new Object[]{} );
		throw new BusinessException( fromExtend.getFaultCode(), new Object[]{ fromExtend.getMessage() } );
	}
	
	/**
	 * ���쳣����ת��Ϊԭʼ�쳣
	 * @param exception �쳣����
	 * @throws SFException
	 * @throws Exception
	 */
	public static void throwPrimitive(java.lang.Exception exception) throws SFException, Exception {
		java.lang.Exception aPRIMITIVE = getPrimitive(exception);
		throw aPRIMITIVE;
	}

	/**
	 * ������ܵײ��쳣
	 * @param exception
	 * @return
	 */
	public static SFException getBottom(java.lang.Exception exception) {
		if( exception.getCause() == null ) {
			if( exception instanceof SFException ) {
				return (SFException)exception;
			} 
			else{
				String fromKEY = IUpdcConst.IUpdfx.UNKNOWN;
				String fromMessage = exception.getMessage();
				if (fromMessage == null) {
					fromMessage = ExceptionFactory.getDefault().getResource(fromKEY, new Object[] {});
				}
				return new SFException(fromKEY, fromMessage, exception);
			}
		}
		return getBottom( (java.lang.Exception)exception.getCause() );
	}

	/**
	 * ����ԭʼ�쳣
	 * @param aException
	 * @return
	 */
	public static java.lang.Exception getPrimitive( java.lang.Exception exception) {
		if( exception instanceof SFException ) {
			SFException aEXCEPTION = (SFException)exception;
			if( aEXCEPTION.getPrimitive() == null ) {
				return aEXCEPTION;
			} 
			else if( aEXCEPTION.getPrimitive() instanceof Exception) {
				return getPrimitive( (java.lang.Exception)aEXCEPTION.getPrimitive() );
			}
			else{
				return aEXCEPTION;
			}
		} 
		else if( exception.getCause() == null ) {
			return exception;
		} 
		else if( exception.getCause() instanceof java.lang.Exception ) {
			return getPrimitive((java.lang.Exception) exception.getCause());
		} 
		else{
			return exception;
		}
	}
	
	/**
	 * �����쳣ת��Ϊ��ͨ�쳣�淶
	 * @param exception �쳣����
	 * @throws SFException
	 * @throws Exception
	 */
	public static void throwException(java.lang.Exception exception) throws SFException, Exception {
		if( exception == null ){
			SFException aEXCEPTION = new SF18NException( IUpdcConst.IUpdfx.DESIGNING, 
					new Object[]{ IUpdcConst.IUpfwm.IUpfm.ucmframe, "" } );
			throw aEXCEPTION;
		}
		else if( exception instanceof BusinessException ) {
			BusinessException fromBusins = (BusinessException)exception;
			SFException aEXCEPTION = new SF18NException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof java.lang.Exception ){
			throw (java.lang.Exception)exception;
		}
		else{
			SFException aEXCEPTION = new SF18NException( IUpdcConst.IUpdfx.DESIGNING, 
					new Object[]{ IUpdcConst.IUpfwm.IUpfm.ucmframe, "" });
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣��ת����Ԫ���쳣�淶
	 * @param originator ��Ԫ����
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwException(String originator, java.lang.Exception exception) throws SFException {
		SFException aEXCEPTION = _default_factory.getResource(originator, exception);
		throw aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��ͨ�쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣�������
	 * @throws SFException
	 */
	public static void throwException(String faultCode, Object[] args) throws SFException {
		throw new SF18NException( faultCode, args );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��ͨ�쳣 
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwException(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		SFException aEXCEPTION = _default_factory.getResource(faultCode, 
				args, 
				exception);
		throw aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���������쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @return
	 */
	public static SFException getServiceBus(String faultCode, Object[] args) {
		SFException aEXCEPTION = new SFESBusException( faultCode, args );
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���������쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceBus(String faultCode, Object[] args, java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFESBusException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			aEXCEPTION = (SFException)aEXCEPTION;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFESBusException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFESBusException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���������쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 */
	public static void throwServiceBus(String faultCode, Object[] args) throws SFException {
		throw new SFESBusException( faultCode, args );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���������쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwServiceBus(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFESBusException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFESBusException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFESBusException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ������Ƿ��쳣
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceBody(java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		try
		{
			SFException _exception = ExceptionFactory.getException( exception );
			if( _exception instanceof SFOracleException ){
				aEXCEPTION = (SFOracleException)_exception;
			}
			else if( _exception instanceof SFESBodyException ){
				aEXCEPTION = (SFESBodyException)_exception;
			}
			else{
				aEXCEPTION = new SFESBodyException( _exception );
			}
		}
		finally{
			
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ������Ƿ��쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @return
	 */
	public static SFException getServiceBody(String faultCode, Object[] args) {
		SFException aEXCEPTION = new SFESBodyException( faultCode, args );
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ������Ƿ��쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceBody(String faultCode, Object[] args, java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFESBodyException( faultCode, args );
		}
		else if( exception instanceof SFOracleException ){
			aEXCEPTION = (SFOracleException)exception;
		}
		else if( exception instanceof SFESBodyException ){
			aEXCEPTION = (SFESBodyException)exception;
		}
		else if( exception instanceof SFException ){
			SFException _exception = (SFException)exception;
			aEXCEPTION = new SFESBodyException( _exception );
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFESBodyException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFESBodyException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ������Ƿ��쳣
	 * @param exception �쳣����
	 * @return
	 */
	public static void throwServiceBody(java.lang.Exception exception) throws SFException {
		SFException aEXCEPTION = ExceptionFactory.getServiceBody( exception );
		throw aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ������Ƿ��쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 */
	public static void throwServiceBody(String faultCode, Object[] args) throws SFException {
		throw new SFESBodyException( faultCode, args );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ������Ƿ��쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwServiceBody(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFESBodyException( faultCode, args );
		}
		else if( exception instanceof SFOracleException ){
			throw (SFOracleException)exception;
		}
		else if( exception instanceof SFESBodyException ){
			throw (SFESBodyException)exception;
		}
		else if( exception instanceof SFException ){
			throw new SFESBodyException( (SFException)exception );
		}
		else if( exception instanceof BusinessException ){
			BusinessException _exception = (BusinessException)exception;
			SFException aEXCEPTION = new SFESBodyException( _exception.getKey(), _exception.getMessage(), exception );
			aEXCEPTION.setArgs( _exception.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFESBodyException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceFault(java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		try
		{
			SFException _exception = ExceptionFactory.getException( exception );
			if( _exception instanceof SFOracleException ){
				aEXCEPTION = (SFOracleException)_exception;
			}
			else if( _exception instanceof SFESFaultException ){
				aEXCEPTION = (SFESFaultException)_exception;
			}
			else{
				aEXCEPTION = new SFESFaultException( _exception );
			}
		}
		finally{
			
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @return
	 */
	public static SFException getServiceFault(String faultCode, Object[] args) {
		SFException aEXCEPTION = new SFESFaultException( faultCode, args );
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceFault(String faultCode, Object[] args, java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFESFaultException( faultCode, args );
		}
		else if( exception instanceof SFOracleException ){
			aEXCEPTION = (SFOracleException)exception;
		}
		else if( exception instanceof SFESFaultException ){
			aEXCEPTION = (SFESFaultException)exception;
		}
		else if( exception instanceof SFException ){
			SFException _exception = (SFException)exception;
			aEXCEPTION = new SFESFaultException( _exception );
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFESFaultException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFESFaultException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param exception �쳣����
	 * @return
	 */
	public static void throwServiceFault(java.lang.Exception exception) throws SFException {
		SFException aEXCEPTION = ExceptionFactory.getServiceFault( exception );
		throw aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 */
	public static void throwServiceFault(String faultCode, Object[] args) throws SFException {
		throw new SFESFaultException( faultCode, args );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwServiceFault(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFESFaultException( faultCode, args );
		}
		else if( exception instanceof SFOracleException ){
			throw (SFOracleException)exception;
		}
		else if( exception instanceof SFESFaultException ){
			throw (SFESFaultException)exception;
		}
		else if( exception instanceof SFException ){
			throw new SFESFaultException( (SFException)exception );
		}
		else if( exception instanceof BusinessException ){
			BusinessException _exception = (BusinessException)exception;
			SFException aEXCEPTION = new SFESFaultException( _exception.getKey(), _exception.getMessage(), exception );
			aEXCEPTION.setArgs( _exception.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFESFaultException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ�ⲿ������[���ݿ⼶�쳣����]
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceCsf(java.lang.Exception exception) {
		return ExceptionFactory.getServiceCsf( exception, IUpdcConst.IUpfwm.IUpfm.ucmframe );
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ�ⲿ������[���ݿ⼶�쳣����]
	 * @param exception �쳣����
	 * @param platform ��Ԫ���� 
	 * @return
	 */
	public static SFException getServiceCsf(java.lang.Exception exception, String platform) {
		SFException aEXCEPTION = null;
		try
		{
			SFException _exception = _default_factory.getResource(platform, exception );
			if( _exception instanceof SFOracleException ){
				aEXCEPTION = (SFOracleException)_exception;
			}
			else if( _exception instanceof SFESCsfException ){
				aEXCEPTION = (SFESCsfException)_exception;
			}
			else{
				aEXCEPTION = new SFESCsfException( _exception );
			}
		}
		finally{
			
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�ⲿ������[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @return
	 */
	public static SFException getServiceCsf(String faultCode, Object[] args) {
		SFException aEXCEPTION = new SFESCsfException( faultCode, args );
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�ⲿ��[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getServiceCsf(String faultCode, Object[] args, java.lang.Exception exception) {
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFESCsfException( faultCode, args );
		}
		else if( exception instanceof SFOracleException ){
			aEXCEPTION = (SFOracleException)exception;
		}
		else if( exception instanceof SFESCsfException ){
			aEXCEPTION = (SFESCsfException)exception;
		}
		else if( exception instanceof SFException ){
			SFException _exception = (SFException)exception;
			aEXCEPTION = new SFESCsfException( _exception );
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFESCsfException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFESCsfException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * ���ݷ����쳣ת��Ϊ�ⲿ������[���ݿ⼶�쳣����]
	 * @param exception �쳣����
	 * @return
	 */
	public static void throwServiceCsf(java.lang.Exception exception) throws SFException {
		SFException aEXCEPTION = ExceptionFactory.getServiceCsf( exception );
		throw aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�ⲿ������[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 */
	public static void throwServiceCsf(String faultCode, Object[] args) throws SFException {
		throw new SFESCsfException( faultCode, args );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�����߼���[���ݿ⼶�쳣����]
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwServiceCsf(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		SFException aEXCEPTION = ExceptionFactory.getServiceCsf(faultCode, args, exception);
		throw aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��ΪIO�쳣 
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 */
	public static void throwIOException(String faultCode, Object[] args) throws SFException {
		throw new SFIOException( faultCode, args );
	}
	
	/**
	 * �����쳣���ʱ���ת��ΪIO�쳣 
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwIOException(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFIOException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFIOException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFIOException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣����ת��Ϊ����̬�쳣
	 * @param exception �쳣����
	 * @throws RuntimeException
	 */
	public static void throwRuntime(java.lang.Exception exception) throws RuntimeException {
		java.lang.RuntimeException aEXCEPTION = null;
		if( exception instanceof SFException ){
			aEXCEPTION = (SFException)exception;
		}
		else if (exception instanceof java.lang.RuntimeException){
			aEXCEPTION = (RuntimeException) exception;
		}
		else{
			aEXCEPTION = new java.lang.RuntimeException( exception.getMessage(), exception );
		}
		throw aEXCEPTION;
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ�����쳣
	 * @param faultCode �쳣���ʱ���
	 * @param fromPARAM �쳣���ʲ���
	 * @throws SFException
	 * @throws Exception
	 */
	public static void throwRuntime(String faultCode,  Object[] args) throws SFException {
		throw new SF18NException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ�����쳣 
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwRuntime(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SF18NException( faultCode, args );
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SF18NException aEXCEPTION = new SF18NException(faultCode, 
					fromBusins.getMessage(),
					exception);
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else{
			throw new SF18NException(faultCode, args, exception);
		}
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��ܼ���Ч�������쳣
	 * 
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 * @throws Exception
	 */
	public static void throwIllegal(String faultCode, Object[] args) throws SFException {
		throw new SFIllegalException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ��Ч�������쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args  �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwIllegal(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFIllegalException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFIllegalException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFIllegalException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���ʽ���쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @throws SFException
	 */
	public static void throwJeval(String faultCode, Object[] args) throws SFException {
		throw new SFJevalException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ���ʽ���쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣���ʲ���
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwJeval(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFJevalException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFJevalException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFJevalException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ����쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 * @throws Exception
	 */
	public static void throwOracle(String faultCode, Object[] args) throws SFException {
		throw new SFOracleException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ����쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwOracle(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFOracleException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFOracleException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else if( exception instanceof java.sql.BatchUpdateException ){
			SFException aEXCEPTION = new SFSQLException(faultCode, args, exception);
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFOracleException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ����쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwOracleInside(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFOracleException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFOracleException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else if( exception instanceof java.sql.BatchUpdateException ){
			SFException aEXCEPTION = new SFSQLException( faultCode, args );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFOracleException( faultCode, args );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ��������쳣
	 * @param faultCode ���ʱ���
	 * @param fromPARAM ���ʱ������
	 * @throws SFException
	 */
	public static void throwOracleConnect(String faultCode, Object[] args) throws SFException {
		throw new SFOLQException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ��������쳣
	 * 
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwOracleConnect(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFOLQException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFOLQException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFOLQException( faultCode, args );
			throw aEXCEPTION;
		}
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ�SQL���쳣 
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 */
	public static void throwOracleSQL(String faultCode, Object[] args) throws SFException {
		throw new SFSQLException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ���ݿ�SQL���쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwOracleSQL(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFSQLException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFSQLException( fromBusins.getKey(), fromBusins.getMessage() );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFSQLException( faultCode, args );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * ������Ԫ����ת��Ϊҵ����Ԫ�쳣
	 * @param aRsRspCode ��������
	 * @param aRsRspDesc ��������
	 * @return
	 */
	public static SFException getRemote( String aRsRspCode, String aRsRspDesc ){
		return new SFRemoteException( aRsRspCode, aRsRspDesc );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊҵ�����쳣
	 * @param faultCode ���ʱ���
	 * @param args �������
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getRemote(String faultCode, Object[] args, java.lang.Exception exception){
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFRemoteException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			aEXCEPTION = (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFRemoteException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFRemoteException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊҵ�����쳣 
	 * @param faultCode ���ʱ���
	 * @param fromPARAM  ���ʱ������
	 * @throws SFException
	 */
	public static void throwRemote(String faultCode, Object[] args) throws SFException {
		throw new SFRemoteException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊҵ�����쳣
	 * @param faultCode ���ʱ���
	 * @param fromPARAM ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwRemote(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFRemoteException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFRemoteException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFRemoteException( faultCode, args, 
					IUpdcConst.IUpfwm.IUpfm.ucmframe, exception );
			throw aEXCEPTION;
		}
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ�������쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 * @throws Exception
	 */
	public static void throwConnect(String faultCode, Object[] args) throws SFException {
		throw new SFConnectException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ�������쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwConnect(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFConnectException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFConnectException( fromBusins.getKey(), 
					fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFConnectException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��ʱ���쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 */
	public static void throwTimeOut(String faultCode, Object[] args) throws SFException {
		throw new SFTimeOutException(faultCode, args);
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��ܼ��������쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwTimeOut(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFTimeOutException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFTimeOutException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFTimeOutException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�������쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 */
	public static void throwIdle(String faultCode, Object[] args) throws SFException {
		throw new SFIdleException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ�������쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwIdle(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFIdleException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFIdleException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFIdleException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}

	/**
	 * ������Ԫ����ת��Ϊҵ����Ԫ�쳣
	 * @param aRsRspCode ��������
	 * @param aRsRspDesc ��������
	 * @param aRsRspDevice �����豸
	 * @return
	 */
	public static SFException getRsRsp( String aRsRspCode, String aRsRspDesc, String aRsRspDevice ){
		SFException aEXCEPTION = null;
		if( aRsRspCode != null ){ 
			aEXCEPTION = new SFRsRspException( aRsRspCode, 
					aRsRspDesc, 
					aRsRspDevice ); 
		}
		else if( aRsRspDesc != null ){
			aEXCEPTION = new SFRsRspException( IUpdcConst.IUpdfx.REMOTE, 
					aRsRspDesc, 
					aRsRspDevice );
		}
		else{
			aEXCEPTION = new SFRsRspException( IUpdcConst.IUpdfx.REMOTE, 
					new Object[]{aRsRspDevice}, 
					aRsRspDevice);
		}
		return aEXCEPTION;
	}
	
	/**
	 * ������Ԫ����ת��Ϊҵ����Ԫ�쳣
	 * @param aRsRspCode ��������
	 * @param aRsRspDesc ��������
	 * @param aRsRspCate ��������
	 * @param aRsRspDevice �����豸
	 * @return
	 */
	public static SFException getRsRsp( String aRsRspCode, String aRsRspDesc, String aRsRspCate, String aRsRspDevice ){
		SFException aEXCEPTION = ExceptionFactory.getRsRsp(aRsRspCode, aRsRspDesc, aRsRspDevice);
		aEXCEPTION.setCategory( aRsRspCate );
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊҵ�����쳣
	 * @param faultCode ���ʱ���
	 * @param fromPARAM ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	/**
	 * �����쳣���ʱ���ת��Ϊ����˵������쳣
	 * @param faultCode ���ʱ���
	 * @param args �������
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getRsRsp(String faultCode, Object[] args, java.lang.Exception exception){
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFRsRspException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			aEXCEPTION = (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFRsRspException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFRsRspException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ�������쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 */
	public static void throwRsRsp(String faultCode, Object[] args) throws SFException {
		throw new SFRsRspException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ�������쳣
	 * @param faultCode ��������
	 * @param args ��������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwRsRsp(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFRsRspException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFRsRspException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFRsRspException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ��Ԫ���������쳣
	 * @param faultCode ��������
	 * @param message ��������
	 * @param originator ��Ԫ����
	 * @throws SFException
	 */
	public static void throwRsRsp(String faultCode, String message, String originator) throws SFException {
		throw new SFRsRspException(faultCode, message, originator);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ��Ԫ���������쳣
	 * @param faultCode ��������
	 * @param message ��������
	 * @param originator  ��Ԫ����
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwRsRsp(String faultCode, String fromMessage, String originator, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFRsRspException( faultCode, fromMessage, originator );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFRsRspException( fromBusins.getKey(), 
					fromBusins.getMessage(), originator, exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFRsRspException( faultCode, originator, originator, exception );
			throw aEXCEPTION;
		}
	}
	
	/**
	 * ������Ԫ����ת��Ϊҵ����Ԫ�쳣
	 * @param aRsRspCode ��������
	 * @param aRsRspDesc ��������
	 * @return
	 */
	public static SFException getFault( String aRsRspCode, String aRsRspDesc ){
		return new SFFaultException( aRsRspCode, aRsRspDesc );
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ����˵������쳣
	 * @param faultCode ���ʱ���
	 * @param args �������
	 * @param originator ����
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getFault(String faultCode, Object[] args, String originator){
		return new SFFaultException(faultCode, args, originator);
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ����˵������쳣
	 * @param faultCode ���ʱ���
	 * @param args �������
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getFault(String faultCode, Object[] args, java.lang.Exception exception){
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFFaultException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			aEXCEPTION = (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFFaultException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFFaultException( faultCode, args, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ����˵������쳣
	 * @param faultCode ���ʱ���
	 * @param args �������
	 * @param originator ����
	 * @param exception �쳣����
	 * @return
	 */
	public static SFException getFault(String faultCode, Object[] args, String originator, java.lang.Exception exception){
		SFException aEXCEPTION = null;
		if( exception == null ){
			aEXCEPTION = new SFFaultException( faultCode, args, originator );
		}
		else if( exception instanceof SFException ){
			aEXCEPTION = (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			aEXCEPTION = new SFFaultException( fromBusins.getKey(), fromBusins.getMessage(), originator, exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
		}
		else{
			aEXCEPTION = new SFFaultException( faultCode, args, originator, exception );
		}
		return aEXCEPTION;
	}
	
	/**
	 * ������Ԫ����ת��Ϊ����˵������쳣
	 * @param faultCode ��������
	 * @param args ��������
	 * @throws SFFaultException
	 */
	public static void throwFault(String faultCode, Object[] args) throws SFFaultException {
		throw new SFFaultException( faultCode, args );
	}
	
	/**
	 * ������Ԫ����ת��Ϊ����˵������쳣
	 * @param faultCode ��������
	 * @param args ��������
	 * @param originator ��Ԫ����
	 * @throws SFFaultException
	 */
	public static void throwFault(String faultCode, Object[] args, String originator) throws SFFaultException {
		throw new SFFaultException(faultCode, args, originator);
	}

	/**
	 * ������Ԫ����ת��Ϊ����˵������쳣
	 * @param faultCode ��������
	 * @param args ��������
	 * @param originator  ��Ԫ����
	 * @param fault ʧ����ϸ
	 * @throws SFFaultException
	 */
	public static void throwFault(String faultCode, Object[] args, String originator, Object fault) throws SFFaultException {
		Object fromPARA[] = ClassUtils.IMerge.merge( args, new Object[]{ fault } );
		throw new SFFaultException(faultCode, fromPARA, originator);
	}
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��Ȩ���쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @throws SFException
	 */
	public static void throwAuth(String faultCode, Object[] args) throws SFException {
		throw new SFAuthException(faultCode, args);
	}

	/**
	 * �����쳣���ʱ���ת��Ϊ��Ȩ���쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʱ������
	 * @param exception �쳣����
	 * @throws SFException
	 */
	public static void throwAuth(String faultCode, Object[] args, java.lang.Exception exception) throws SFException {
		if( exception == null ){
			throw new SFAuthException( faultCode, args );
		}
		else if( exception instanceof SFException ){
			throw (SFException)exception;
		}
		else if( exception instanceof BusinessException ){
			BusinessException fromBusins = (BusinessException) exception;
			SFException aEXCEPTION = new SFAuthException( fromBusins.getKey(), fromBusins.getMessage(), exception );
			aEXCEPTION.setArgs( fromBusins.getArgs() );
			throw aEXCEPTION;
		}
		else{
			SFException aEXCEPTION = new SFAuthException( faultCode, args, exception );
			throw aEXCEPTION;
		}
	}
	
}
