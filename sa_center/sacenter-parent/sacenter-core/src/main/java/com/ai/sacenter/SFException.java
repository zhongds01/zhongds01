package com.ai.sacenter;

import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务开通异常</p>
 * <p>Copyright: Copyright (c) 2017年5月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -2180158424103146615L;
    /*异常代码*/
    private String   _faultCode  = null;
    /*参数清单*/
    private Object[] _args       = null;
    /*异常发起方*/
    private String   _originator = null;
    /*发起方类型*/
    private String   _category   = null;
    /*外部参数*/
    private java.util.HashMap _order = new java.util.HashMap();
    /*异常原因*/
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
     * @param faultCode 异常代码
     * @param message 异常描述
     */
	public SFException(String faultCode, String message) {
		super( message );
		_faultCode  = faultCode;
		_originator = IUpdcConst.IUpfwm.IUpfm.ucmframe;
	}
	
	/**
     * 
     * @param faultCode 异常代码
     * @param message 异常描述
     * @param throwable 异常原因
     */
	public SFException(String faultCode, String message, Throwable throwable) {
		super( message, throwable );
		_faultCode  = faultCode ;
		_primitive  = throwable ;
		_originator = IUpdcConst.IUpfwm.IUpfm.ucmframe;
	}
	
	/**
     * 
     * @param faultCode 异常代码
     * @param message 异常描述
     * @param originator 异常发起方
     */
	public SFException(String faultCode, String message, String originator) {
		super( message );
		_faultCode  = faultCode;
		_originator = originator;
	}
	
	/**
     * 
     * @param faultCode 异常代码
     * @param message 异常描述
     * @param originator 异常发起方
     * @param throwable 异常原因
     */
	public SFException(String faultCode, String message, String originator, Throwable throwable) {
		super( message, throwable );
		_faultCode  = faultCode ;
		_originator = originator;
		_primitive  = throwable ;
	}
    
	/**
	 * @return 异常代码
	 */
	public String getFaultCode() {
		return _faultCode;
	}
	
	/**
	 * @return 参数
	 */
	public Object[] getArgs() {
		return _args;
	}

	/**
	 * @param args 参数
	 */
	public void setArgs(Object[] args) {
		_args = args;
	}

	/**
	 * @return 发起方
	 */
	public String getOriginator() {
		return _originator;
	}
	
	/**
	 * @param originator 发起方
	 */
	public void setOriginator(String originator) {
		_originator = originator;
	}

	/**
	 * @return 发起方类型
	 */
	public String getCategory() {
		return _category;
	}
	
	/**
	 * @param category 发起方类型
	 */
	public void setCategory(String category) {
		_category = category;
	}
	
	/**
	 * @return 异常原因
	 */
	public java.lang.Throwable getPrimitive() {
		return _primitive == this?null:_primitive;
	}
	
	/**
	 * 返回布尔类型
	 * @param 参数键
	 * @return
	 */
	public boolean getAsBoolean( String paramName ){
		return ClassUtils.IClass.getAsBoolean( getAsObject( paramName ) );
	}
	
	/**
	 * 设置布尔型变量
	 * @param paramName 参数键
	 * @param paramBoolean 布尔类型
	 */
	public void setAsBoolean( String paramName, boolean paramBoolean ){
		setAsObject( paramName, Boolean.valueOf( paramBoolean ) );
	}
	
	/**
	 * 返回字节类型
	 * @param paramName 参数键
	 * @return
	 */
	public byte getAsByte( String paramName ){
		return ClassUtils.IClass.getAsByte( getAsObject( paramName ) );
	}
	
	/**
	 * 设置字节型变量
	 * @param paramName 参数键
	 * @param paramByte 字节类型
	 */
	public void setAsByte( String paramName, byte paramByte ){
		setAsObject( paramName, Byte.valueOf( paramByte ) );
	}
	
	/**
	 * 返回短整数型变量
	 * @param paramName 参数键
	 * @return
	 */
	public short getAsShort( String paramName ){
		return ClassUtils.IClass.getAsShort( getAsObject( paramName ) );
	}
	
	/**
	 * 设置短整数型变量
	 * @param paramName 参数键
	 * @param paramShort 短整数型
	 */
	public void setAsShort( String paramName, short paramShort ){
		setAsObject( paramName, Short.valueOf( paramShort ) );
	}
	
	/**
	 * 返回整数型变量
	 * @param paramName 参数键
	 * @return
	 */
	public int getAsInt( String paramName ){
		return ClassUtils.IClass.getAsInt( getAsObject( paramName ) );
	}
	
	/**
	 * 设置整数型变量
	 * @param paramName 参数键
	 * @param paramInt 整数型
	 */
	public void setAsInt( String paramName, int paramInt ){
		setAsObject( paramName, Integer.valueOf( paramInt ) );
	}
	
	/**
	 * 返回长整数型变量
	 * @param paramName 参数键
	 * @return
	 */
	public long getAsLong( String paramName ){
		return ClassUtils.IClass.getAsLong( getAsObject( paramName ) );
	}
	
	/**
	 * 设置长整数型变量
	 * @param paramName 参数键
	 * @param paramLong 长整数型
	 */
	public void setAsLong( String paramName, long paramLong ){
		setAsObject( paramName, Long.valueOf( paramLong ) );
	}
	
	/**
	 * 返回浮点型变量
	 * @param paramName 参数键
	 * @return
	 */
	public float getAsFloat( String paramName ){
		return ClassUtils.IClass.getAsFloat( getAsObject( paramName ) );
	}
	
	/**
	 * 设置浮点型变量
	 * @param paramName 参数键
	 * @param paramFloat 浮点型
	 */
	public void setAsFloat( String paramName, long paramFloat ){
		setAsObject( paramName, Float.valueOf( paramFloat ) );
	}
	
	/**
	 * 返回双精度浮点型变量
	 * @param paramName 参数键
	 * @return
	 */
	public double getAsDouble( String paramName ){
		return ClassUtils.IClass.getAsDouble( getAsObject( paramName ) );
	}
	
	/**
	 * 设置双精度浮点型变量
	 * @param paramName 参数键
	 * @param paramDouble 双精度浮点型
	 */
	public void setAsDouble( String paramName, double paramDouble ){
		setAsObject( paramName, Double.valueOf( paramDouble ) );
	}
	
	/**
	 * 返回字符串
	 * @param paramName 参数键
	 * @return
	 */
	public String getAsString( String paramName ){
		return ClassUtils.IClass.getAsString( getAsObject( paramName ) );
	}
	
	/**
	 * 设置字符串
	 * @param paramName 参数键
	 * @param paramString 字符串
	 */
	public void setAsString( String paramName, String paramString ){
		setAsObject( paramName, String.valueOf( paramString ) );
	}
	
	/**
	 * 返回日期型变量
	 * @param paramName 参数键
	 * @return
	 */
	public java.util.Date getAsDate( String paramName ){
		return ClassUtils.IClass.getAsDate( getAsObject( paramName ) );
	}
	
	/**
	 * 设置日期型变量
	 * @param paramName 参数键
	 * @param paramDate 日期型变量
	 */
	public void setAsDate( String paramName, java.util.Date paramDate ){
		setAsObject( paramName, paramDate );
	}
	
	/**
	 * 返回日期型变量
	 * @param paramName 参数键
	 * @return
	 */
	public java.sql.Timestamp getAsTimestamp( String paramName ){
		return ClassUtils.IClass.getAsTimestamp( getAsObject( paramName ) );
	}
	
	/**
	 * 设置日期型变量
	 * @param paramName 参数键
	 * @param paramTimestamp 日期型变量
	 */
	public void setAsTimestamp( String paramName, java.sql.Timestamp paramTimestamp ){
		setAsObject( paramName, paramTimestamp );
	}
	
	/**
	 * 返回键值对应对象
	 * @param paramName 字符串
	 * @return
	 */
	public Object getAsObject(String paramName){
		return _order.get( paramName );
	}
	
	/**
	 * 设置对象
	 * @param paramName 字符串
	 * @param paramObject 对象
	 */
	public void setAsObject( String paramName, Object paramObject ){
		_order.put( paramName, paramObject );
	}
	
	/**
	 * 外部参数合并到当前异常参数
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
	 * @return 外部参数
	 */
	public java.util.HashMap getORDER() {
		return _order;
	}
	
	/**
	 * 返回参数格式字符串
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
