package com.ai.sacenter.util;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-2-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IPrimitive implements java.io.Serializable{
	private static final long serialVersionUID = -3753324724052508863L;
	protected String ID             ;
	protected String DESCRIBE       ;
	protected String IMPLCLASS      ;
	protected String METHOD         ;
	protected java.util.Map GRAPHICS = new java.util.HashMap();
	public IPrimitive(){
		super();
	}
	public IPrimitive( org.dom4j.Element aElement ){
		super();
		ID = aElement.attributeValue( "id" );
		java.util.List aAttributes = aElement.attributes();
		for( java.util.Iterator itera = aAttributes.iterator(); itera.hasNext(); ){
			org.dom4j.Attribute aAttribute = (org.dom4j.Attribute)itera.next();
			if( StringUtils.equals( aAttribute.getName(), "id" ) ) continue;
			if( StringUtils.equals( aAttribute.getName(), "class" ) )
				IMPLCLASS = StringUtils.trim( aAttribute.getText() );
			else if( StringUtils.equals( aAttribute.getName(), "method" ) )
				METHOD = StringUtils.trim( aAttribute.getText() );
			else if( StringUtils.equals( aAttribute.getName(), "desc" ) )
				DESCRIBE = StringUtils.trim( aAttribute.getText() );
			else 
				GRAPHICS.put( aAttribute.getName() , StringUtils.trim( aAttribute.getText() ) );
		}
		JdomUtils.IJdom.getIJDX$StubL( aElement , GRAPHICS );
	}
	
	/**
	 * @return the dESCRIBE
	 */
	public String getDESCRIBE() {
		return DESCRIBE;
	}
	/**
	 * @param describe the dESCRIBE to set
	 */
	public void setDESCRIBE(String describe) {
		DESCRIBE = describe;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param id the iD to set
	 */
	public void setID(String id) {
		ID = id;
	}
	/**
	 * @return the iMPLCLASS
	 */
	public String getIMPLCLASS() {
		return IMPLCLASS;
	}
	/**
	 * @param implclass the iMPLCLASS to set
	 */
	public void setIMPLCLASS(String implclass) {
		IMPLCLASS = implclass;
	}
	/**
	 * @return the mETHOD
	 */
	public String getMETHOD() {
		return METHOD;
	}
	/**
	 * @param method the mETHOD to set
	 */
	public void setMETHOD(String method) {
		METHOD = method;
	}
	/**
	 * @return the gRAPHICS
	 */
	public java.util.Map getGRAPHICS() {
		return GRAPHICS;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isJMDI(){
		return StringUtils.isBlank( IMPLCLASS ) == false && StringUtils.isBlank( METHOD ) == false;
	}
}
