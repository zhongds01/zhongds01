package com.ai.sacenter.receive.teaminvoke.valuebean;

import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于KEY-VALUE开通消息</p>
 * <p>Copyright: Copyright (c) 2017年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RocketFMapMessage extends RocketFMessage {
	private static final long serialVersionUID = -8022595462205881133L;
    private java.util.Map<String,Object> _mapMessage = new java.util.HashMap<String,Object>();
    public RocketFMapMessage( ) {
		super();
	}
    
    public RocketFMapMessage(Object objective ) {
		super( objective );
	}
    
	public RocketFMapMessage(Object objective, java.util.Map<String,Object> mapMessage ) {
		super( objective );
		_mapMessage = mapMessage;
	}
	
	/**
	 * @return 消息体
	 */
	public java.util.Map<String,Object> getMapMessage() {
		return _mapMessage;
	}
	
	/**
	 * @param body 消息体
	 */
	public void setMapMessage(java.util.Map<String,Object> mapMessage) {
		_mapMessage = mapMessage;
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public boolean getBoolean( String paramName ){
		return ClassUtils.IClass.getAsBoolean( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramBoolean
	 */
	public void setBoolean( String paramName, boolean paramBoolean ){
		setObject( paramName, Boolean.valueOf( paramBoolean ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public byte getByte( String paramName ){
		return ClassUtils.IClass.getAsByte( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramByte
	 */
	public void setByte( String paramName, byte paramByte ){
		setObject( paramName, Byte.valueOf( paramByte ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public short getShort( String paramName ){
		return ClassUtils.IClass.getAsShort( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramShort
	 */
	public void setShort( String paramName, short paramShort ){
		setObject( paramName, Short.valueOf( paramShort ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public int getInt( String paramName ){
		return ClassUtils.IClass.getAsInt( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramInt
	 */
	public void setInt( String paramName, int paramInt ){
		setObject( paramName, Integer.valueOf( paramInt ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public long getLong( String paramName ){
		return ClassUtils.IClass.getAsLong( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramLong
	 */
	public void setLong( String paramName, long paramLong ){
		setObject( paramName, Long.valueOf( paramLong ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public float getFloat( String paramName ){
		return ClassUtils.IClass.getAsFloat( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramFloat
	 */
	public void setFloat( String paramName, long paramFloat ){
		setObject( paramName, Float.valueOf( paramFloat ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public double getDouble( String paramName ){
		return ClassUtils.IClass.getAsDouble( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramDouble
	 */
	public void setDouble( String paramName, double paramDouble ){
		setObject( paramName, Double.valueOf( paramDouble ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @return
	 */
	public String getString( String paramName ){
		return ClassUtils.IClass.getAsString( getObject( paramName ) );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramString
	 */
	public void setString( String paramName, String paramString ){
		setObject( paramName, String.valueOf( paramString ) );
	}
	
	/**
	 * 
	 * @param paramString
	 * @return
	 */
	public Object getObject(String paramName){
		return _mapMessage.get( paramName );
	}
	
	/**
	 * 
	 * @param paramName
	 * @param paramObject
	 */
	public void setObject( String paramName, Object paramObject ){
		_mapMessage.put( paramName, paramObject );
	}
	
	/**
	 * 
	 */
	public void clear(){
		_mapMessage.clear();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage#toString()
	 */
	public String toString() {
		String _rocket = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( "OrigDomain" );
			super.transferAsXml( fromRoot );
			if( _mapMessage != null && _mapMessage.size() > 0 ){
				org.dom4j.Element _element = fromRoot.addElement( "TransBody" );
				for( java.util.Iterator<java.util.Map.Entry<String,Object>> itera = _mapMessage.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry<String,Object> fromEntry = (java.util.Map.Entry<String,Object>)itera.next();
					XmlUtils.IXml._createIXml(_element, fromEntry.getKey(), fromEntry.getValue() );
				}
			}
			_rocket = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_rocket = super.toString();
		}
		return _rocket;
	}
}
