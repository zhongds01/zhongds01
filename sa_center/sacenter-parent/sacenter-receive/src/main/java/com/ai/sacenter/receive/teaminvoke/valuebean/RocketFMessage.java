package com.ai.sacenter.receive.teaminvoke.valuebean;

import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JVMUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ��Ϣ</p>
 * <p>Copyright: Copyright (c) 2017��3��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RocketFMessage implements java.io.Serializable{
	private static final long serialVersionUID = 725501646506654734L;
	/*Ψһ����*/
	private UUID   _id;
	/*ԭʼ����*/
	private Object _objective;
	/*������ַ*/
	private String _host;
	/*��������*/
	private String _weblogic;
	/*����ʱ��*/
	private java.sql.Timestamp _create;
	/*��Ϣͷ*/
	private java.util.HashMap<String,Object> _properties = new java.util.HashMap<String,Object>();
	public RocketFMessage( ){
		super();
		String fromWAS[] = JVMUtils.getWEBLOGIC();
		_id        = UUID.getUUID();
		_host      = fromWAS[0];
		_weblogic  = fromWAS[1];
		_create    = new java.sql.Timestamp( System.currentTimeMillis() );
	}
	
	public RocketFMessage( Object objective ) {
		super();
		String fromWAS[] = JVMUtils.getWEBLOGIC();
		_id        = UUID.getUUID();
		_objective = objective;
		_host      = fromWAS[0];
		_weblogic  = fromWAS[1];
		_create    = new java.sql.Timestamp( System.currentTimeMillis() );
	}
		
	/**
	 * @return the _id
	 */
	public UUID getId() {
		return _id;
	}

	/**
	 * @return ��ͨԭʼ����
	 */
	public Object getObjective() {
		return _objective;
	}

	/**
	 * @param _objective ��ͨԭʼ����
	 */
	public void setObjective(Object _objective) {
		this._objective = _objective;
	}
	
	/**
	 * @return ������ַ
	 */
	public String getHost() {
		return _host;
	}

	/**
	 * @return ��������
	 */
	public String getWebLogic() {
		return _weblogic;
	}

	/**
	 * @return ����ʱ��
	 */
	public java.sql.Timestamp getCreate() {
		return _create;
	}

	/**
	 * @param create ����ʱ��
	 */
	public void setCreate(java.sql.Timestamp create) {
		_create = create;
	}

	/**
	 * @return ��Ϣ���
	 */
	public String getMsgId() {
		if( getObjectProperty("MsgId") == null ){
			setMsgId( UUID.getUUID().toString() );
		}
		return getStringProperty( "MsgId" );
	}
	
	/**
	 * @param msgId ��Ϣ���
	 */
	public void setMsgId(String msgId) {
		setStringProperty( "MsgId", msgId );
	}

	/**
	 * @return �������
	 */
	public String getOrderId() {
		if( getObjectProperty("OrderId") == null ){
			setOrderId( String.valueOf( System.currentTimeMillis() ) );
		}
		return getStringProperty( "OrderId" );
	}

	/**
	 * @param orderId �������
	 */
	public void setOrderId(String orderId) {
		setStringProperty( "OrderId", orderId );
	}

	/**
	 * @return ��Ϣͷ
	 */
	public java.util.HashMap<String,Object> getProperties() {
		return _properties;
	}

	/**
	 * @param properties ��Ϣͷ
	 */
	public void setProperties(java.util.HashMap<String,Object> properties) {
		_properties= properties;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public boolean getBooleanProperty( String propertyName ){
		return ClassUtils.IClass.getAsBoolean( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyBoolean
	 */
	public void setBooleanProperty( String propertyName, boolean propertyBoolean ){
		setObjectProperty( propertyName, Boolean.valueOf( propertyBoolean ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public byte getByteProperty( String propertyName ){
		return ClassUtils.IClass.getAsByte( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyByte
	 */
	public void setByteProperty( String propertyName, byte propertyByte ){
		setObjectProperty( propertyName, Byte.valueOf( propertyByte ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public short getShortProperty( String propertyName ){
		return ClassUtils.IClass.getAsShort( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyShort
	 */
	public void setShortProperty( String propertyName, short propertyShort ){
		setObjectProperty( propertyName, Short.valueOf( propertyShort ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public int getIntProperty( String propertyName ){
		return ClassUtils.IClass.getAsInt( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyInt
	 */
	public void setIntProperty( String propertyName, int propertyInt ){
		setObjectProperty( propertyName, Integer.valueOf( propertyInt ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public long getLongProperty( String propertyName ){
		return ClassUtils.IClass.getAsLong( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyLong
	 */
	public void setLongProperty( String propertyName, long propertyLong ){
		setObjectProperty( propertyName, Long.valueOf( propertyLong ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public float getFloatProperty( String propertyName ){
		return ClassUtils.IClass.getAsFloat( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyFloat
	 */
	public void setFloatProperty( String propertyName, long propertyFloat ){
		setObjectProperty( propertyName, Float.valueOf( propertyFloat ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public double getDoubleProperty( String propertyName ){
		return ClassUtils.IClass.getAsDouble( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyDouble
	 */
	public void setDoubleProperty( String propertyName, double propertyDouble ){
		setObjectProperty( propertyName, Double.valueOf( propertyDouble ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return
	 */
	public String getStringProperty( String propertyName ){
		return ClassUtils.IClass.getAsString( getObjectProperty( propertyName ) );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyString
	 */
	public void setStringProperty( String propertyName, String propertyString ){
		setObjectProperty( propertyName, String.valueOf( propertyString ) );
	}
	
	/**
	 * 
	 * @param paramString
	 * @return
	 */
	public Object getObjectProperty(String propertyName){
		return _properties.get( propertyName );
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param propertyObject
	 */
	public void setObjectProperty( String propertyName, Object propertyObject ){
		_properties.put( propertyName, propertyObject );
	}
	
	/**
	 * 
	 */
	public void clearProperties(){
		_properties.clear();
	}

	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	protected String transferAsXml( org.dom4j.Element element ) throws Exception{
		try
		{
			element.addElement( "TransIDO"     ).setText( _id.toString                     () );
			element.addElement( "TransDomain"  ).setText( _host                               );
			element.addElement( "TransIDC"     ).setText( _weblogic                           );
			element.addElement( "TransIDOTime" ).setText( TimeUtils.yyyymmddhhmmss( _create ) );
			if( _properties != null && _properties.size() > 0 ){
				org.dom4j.Element _element = element.addElement( "TransHome" );
				for( java.util.Iterator<java.util.Map.Entry<String,Object>> itera = _properties.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry<String,Object> fromEntry = (java.util.Map.Entry<String,Object>)itera.next();
					XmlUtils.IXml._createIXml(_element, fromEntry.getKey(), fromEntry.getValue() );
				}
			}
		}
		finally{
			
		}
		return element.asXML();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String _rocket = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( "ISPCRocket" );
			transferAsXml( fromRoot );
			_rocket = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_rocket = super.toString();
		}
		return _rocket;
	}
}
