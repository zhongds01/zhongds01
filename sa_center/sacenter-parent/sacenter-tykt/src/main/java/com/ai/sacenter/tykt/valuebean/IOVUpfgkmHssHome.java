package com.ai.sacenter.tykt.valuebean;

import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê1ÔÂ11ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfgkmHssHome implements java.io.Serializable{
	private static final long serialVersionUID = 1737329972797405743L;
	private String resultCode;
	private String resultDesc;
	private java.util.List resultData = new java.util.ArrayList();
	public IOVUpfgkmHssHome( String fromXML ) throws Exception{
		super();
		StringBuilder fromBody = new StringBuilder();
		try
		{
			fromBody.append( "<Result>" )
			       .append( StringUtils.substringBetwn(fromXML, "<Result>", "</Result>") )
			       .append("</Result>");
			org.dom4j.Element fromRoot = XmlUtils.parseXml( fromBody.toString() );
			resultCode = fromRoot.elementText("ResultCode");
			resultDesc = fromRoot.elementText("ResultDesc");
			org.dom4j.Element fromResultData = fromRoot.element( "ResultData" );
			if( fromResultData != null ){
				java.util.Map fromGroup = null;
				for( java.util.Iterator itera = fromResultData.elements("Group").iterator(); itera.hasNext(); ){
					org.dom4j.Element fromElement = (org.dom4j.Element)itera.next();
					if( fromElement.attribute("Name") == null ){
						fromGroup = new java.util.HashMap();
						XmlUtils.XPath( fromElement.asXML(), fromGroup );
						resultData.add( fromGroup );
					}
					else{
						fromGroup = new java.util.HashMap();
						XmlUtils.XPath( fromElement.asXML(), fromGroup );
						fromGroup.put("GROUP", fromElement.attribute("Name").getText() );
						fromElement = (org.dom4j.Element)itera.next();
						XmlUtils.XPath( fromElement.asXML(), fromGroup );
						resultData.add( fromGroup );
					}
				}
			}
			
		}
		finally{
			if( fromBody != null ){ fromBody = null; }
		}
	}
	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the resultDesc
	 */
	public String getResultDesc() {
		return resultDesc;
	}
	/**
	 * @param resultDesc the resultDesc to set
	 */
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	/**
	 * @return the resultData
	 */
	public java.util.List getResultData() {
		return resultData;
	}
	/**
	 * @param resultData the resultData to set
	 */
	public void setResultData(java.util.List resultData) {
		this.resultData = resultData;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		java.util.HashMap fromBody = new java.util.HashMap();
		try
		{
			fromBody.put("ResultCode", resultCode);
			fromBody.put("ResultDesc", resultDesc);
			fromBody.put("ResultData", new java.util.HashMap() );
			((java.util.Map)fromBody.get( "ResultData" ) ).put( "Group", resultData );
			fromXML = XmlUtils.createGeneralXml("ucmframe", fromBody );
		}
		catch( java.lang.Exception aa){
			
		}
		finally{
			if( fromBody != null ){ fromBody.clear(); fromBody = null; }
		}
		return fromXML;
	}
}
