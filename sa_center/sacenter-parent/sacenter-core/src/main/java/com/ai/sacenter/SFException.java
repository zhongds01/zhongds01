package com.ai.sacenter;

import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: ����ͨ�쳣</p>
 * <p>Copyright: Copyright (c) 2017��5��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -2180158424103146615L;
    /*�쳣����*/
    private String   _faultCode  = null;
    /*�����嵥*/
    private Object[] _args       = null;
    /*�쳣����*/
    private String   _originator = null;
    /*��������*/
    private String   _category   = null;
    /*�ⲿ����*/
    private java.util.HashMap _order = new java.util.HashMap();
    /*�쳣ԭ��*/
    private java.lang.Throwable _primitive = this;
    public SFException(){
    	super();
    }
	
    /**
     * 
     * @param exception
     */
    public SFException( SFException exception ){
    	super( exception.getMessage(), exception );
    	_faultCode  = exception._faultCode ;
    	_originator = exception._originator;
    	_category   = exception._category  ;   
    	_args       = exception._args      ;
    	_primitive  = exception            ;
    	ClassUtils.IMerge.merge( exception._order, _order );
    }
    
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     */
	public SFException(String faultCode, String message) {
		super( message );
		_faultCode  = faultCode;
		_originator = IUpdcConst.IUpfwm.IUpfm.ucmframe;
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param throwable �쳣ԭ��
     */
	public SFException(String faultCode, String message, Throwable throwable) {
		super( message, throwable );
		_faultCode  = faultCode ;
		_primitive  = throwable ;
		_originator = IUpdcConst.IUpfwm.IUpfm.ucmframe;
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator �쳣����
     */
	public SFException(String faultCode, String message, String originator) {
		super( message );
		_faultCode  = faultCode;
		_originator = originator;
	}
	
	/**
     * 
     * @param faultCode �쳣����
     * @param message �쳣����
     * @param originator �쳣����
     * @param throwable �쳣ԭ��
     */
	public SFException(String faultCode, String message, String originator, Throwable throwable) {
		super( message, throwable );
		_faultCode  = faultCode ;
		_originator = originator;
		_primitive  = throwable ;
	}
    
	/**
	 * @return �쳣����
	 */
	public String getFaultCode() {
		return _faultCode;
	}
	
	/**
	 * @return ����
	 */
	public Object[] getArgs() {
		return _args;
	}

	/**
	 * @param args ����
	 */
	public void setArgs(Object[] args) {
		_args = args;
	}

	/**
	 * @return ����
	 */
	public String getOriginator() {
		return _originator;
	}
	
	/**
	 * @param originator ����
	 */
	public void setOriginator(String originator) {
		_originator = originator;
	}

	/**
	 * @return ��������
	 */
	public String getCategory() {
		return _category;
	}
	
	/**
	 * @param category ��������
	 */
	public void setCategory(String category) {
		_category = category;
	}
	
	/**
	 * @return �쳣ԭ��
	 */
	public java.lang.Throwable getPrimitive() {
		return _primitive == this?null:_primitive;
	}
	
	/**
	 * ���ز�������
	 * @param ������
	 * @return
	 */
	public boolean getAsBoolean( String paramName ){
		return ClassUtils.IClass.getAsBoolean( getAsObject( paramName ) );
	}
	
	/**
	 * ���ò����ͱ���
	 * @param paramName ������
	 * @param paramBoolean ��������
	 */
	public void setAsBoolean( String paramName, boolean paramBoolean ){
		setAsObject( paramName, Boolean.valueOf( paramBoolean ) );
	}
	
	/**
	 * �����ֽ�����
	 * @param paramName ������
	 * @return
	 */
	public byte getAsByte( String paramName ){
		return ClassUtils.IClass.getAsByte( getAsObject( paramName ) );
	}
	
	/**
	 * �����ֽ��ͱ���
	 * @param paramName ������
	 * @param paramByte �ֽ�����
	 */
	public void setAsByte( String paramName, byte paramByte ){
		setAsObject( paramName, Byte.valueOf( paramByte ) );
	}
	
	/**
	 * ���ض������ͱ���
	 * @param paramName ������
	 * @return
	 */
	public short getAsShort( String paramName ){
		return ClassUtils.IClass.getAsShort( getAsObject( paramName ) );
	}
	
	/**
	 * ���ö������ͱ���
	 * @param paramName ������
	 * @param paramShort ��������
	 */
	public void setAsShort( String paramName, short paramShort ){
		setAsObject( paramName, Short.valueOf( paramShort ) );
	}
	
	/**
	 * ���������ͱ���
	 * @param paramName ������
	 * @return
	 */
	public int getAsInt( String paramName ){
		return ClassUtils.IClass.getAsInt( getAsObject( paramName ) );
	}
	
	/**
	 * ���������ͱ���
	 * @param paramName ������
	 * @param paramInt ������
	 */
	public void setAsInt( String paramName, int paramInt ){
		setAsObject( paramName, Integer.valueOf( paramInt ) );
	}
	
	/**
	 * ���س������ͱ���
	 * @param paramName ������
	 * @return
	 */
	public long getAsLong( String paramName ){
		return ClassUtils.IClass.getAsLong( getAsObject( paramName ) );
	}
	
	/**
	 * ���ó������ͱ���
	 * @param paramName ������
	 * @param paramLong ��������
	 */
	public void setAsLong( String paramName, long paramLong ){
		setAsObject( paramName, Long.valueOf( paramLong ) );
	}
	
	/**
	 * ���ظ����ͱ���
	 * @param paramName ������
	 * @return
	 */
	public float getAsFloat( String paramName ){
		return ClassUtils.IClass.getAsFloat( getAsObject( paramName ) );
	}
	
	/**
	 * ���ø����ͱ���
	 * @param paramName ������
	 * @param paramFloat ������
	 */
	public void setAsFloat( String paramName, long paramFloat ){
		setAsObject( paramName, Float.valueOf( paramFloat ) );
	}
	
	/**
	 * ����˫���ȸ����ͱ���
	 * @param paramName ������
	 * @return
	 */
	public double getAsDouble( String paramName ){
		return ClassUtils.IClass.getAsDouble( getAsObject( paramName ) );
	}
	
	/**
	 * ����˫���ȸ����ͱ���
	 * @param paramName ������
	 * @param paramDouble ˫���ȸ�����
	 */
	public void setAsDouble( String paramName, double paramDouble ){
		setAsObject( paramName, Double.valueOf( paramDouble ) );
	}
	
	/**
	 * �����ַ���
	 * @param paramName ������
	 * @return
	 */
	public String getAsString( String paramName ){
		return ClassUtils.IClass.getAsString( getAsObject( paramName ) );
	}
	
	/**
	 * �����ַ���
	 * @param paramName ������
	 * @param paramString �ַ���
	 */
	public void setAsString( String paramName, String paramString ){
		setAsObject( paramName, String.valueOf( paramString ) );
	}
	
	/**
	 * ���������ͱ���
	 * @param paramName ������
	 * @return
	 */
	public java.util.Date getAsDate( String paramName ){
		return ClassUtils.IClass.getAsDate( getAsObject( paramName ) );
	}
	
	/**
	 * ���������ͱ���
	 * @param paramName ������
	 * @param paramDate �����ͱ���
	 */
	public void setAsDate( String paramName, java.util.Date paramDate ){
		setAsObject( paramName, paramDate );
	}
	
	/**
	 * ���������ͱ���
	 * @param paramName ������
	 * @return
	 */
	public java.sql.Timestamp getAsTimestamp( String paramName ){
		return ClassUtils.IClass.getAsTimestamp( getAsObject( paramName ) );
	}
	
	/**
	 * ���������ͱ���
	 * @param paramName ������
	 * @param paramTimestamp �����ͱ���
	 */
	public void setAsTimestamp( String paramName, java.sql.Timestamp paramTimestamp ){
		setAsObject( paramName, paramTimestamp );
	}
	
	/**
	 * ���ؼ�ֵ��Ӧ����
	 * @param paramName �ַ���
	 * @return
	 */
	public Object getAsObject(String paramName){
		return _order.get( paramName );
	}
	
	/**
	 * ���ö���
	 * @param paramName �ַ���
	 * @param paramObject ����
	 */
	public void setAsObject( String paramName, Object paramObject ){
		_order.put( paramName, paramObject );
	}
	
	/**
	 * �ⲿ�����ϲ�����ǰ�쳣����
	 * @param order
	 */
	public void mergeAsObject( java.util.Map order ){
		if( order != null && order.size() > 0 ){
			for( java.util.Iterator itera = order.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				setAsObject( (String)fromEntry.getKey(), fromEntry.getValue() );
			}
		}
	}
	
	/**
	 * @return �ⲿ����
	 */
	public java.util.HashMap getORDER() {
		return _order;
	}
	
	/**
	 * ���ز�����ʽ�ַ���
	 * @return
	 */
	public String getAsXML(){
		String fromXml = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			java.util.Map fromBody = null;
			fromPARAM.put("RspCode"  , _faultCode              );
			fromPARAM.put("RspDesc"  , getMessage           () );
			
			fromPARAM.put("RspBody"  , fromBody = new java.util.HashMap() );
			fromBody.put ("PARAM"    , _args );
			if( _order != null && _order.size() > 0 ){
				fromBody.put ("RESULT"   , new java.util.HashMap() );
				((java.util.Map)fromBody.get("RESULT")).putAll( _order );
			}
			fromXml = XmlUtils.createNoformatXml("InterBOSS", fromPARAM);
		}
		catch( java.lang.Exception exception ){
			StringBuilder fromString = new StringBuilder();
			fromString.append("RspCode").append("=").append( _faultCode   );
			fromString.append("RspDesc").append("=").append( getMessage() );
			fromString.append(",RspBody={" );
			for( int index = 0; _args != null && index < _args.length; index++ ){
				fromString.append( _args[index] );
				if( index != _args.length - 1 ) fromString.append(",");
			}
			fromString.append("}");
			fromXml = fromString.toString();
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromXml;
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		if( _category == null ){
			return super.getMessage();
		}
		else{
			StringBuilder fromFixL = new StringBuilder();
			fromFixL.append( _category ).append(":").append( super.getMessage() );
			return fromFixL.toString();
		}
	}
	
}
