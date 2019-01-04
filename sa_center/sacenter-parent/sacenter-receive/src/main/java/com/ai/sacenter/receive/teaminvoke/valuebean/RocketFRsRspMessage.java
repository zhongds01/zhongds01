package com.ai.sacenter.receive.teaminvoke.valuebean;

import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通归档报文</p>
 * <p>Copyright: Copyright (c) 2017年6月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RocketFRsRspMessage extends RocketFMessage {
	private static final long serialVersionUID = 2595489479994009931L;
    private String _body = null;
	public RocketFRsRspMessage(){
		super();
	}
	
	public RocketFRsRspMessage(String body ){
		super();
		_body = body;
	}
	
	public RocketFRsRspMessage( Object objective, String body ) {
		super( objective );
		_body = body;
	}
	
	/**
	 * @return 消息体
	 */
	public String getBody() {
		return _body;
	}
	
	/**
	 * @param body 消息体
	 */
	public void setBody(String text) {
		_body = text;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage#toString()
	 */
	public String toString() {
		String _rocket = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( "HomeDomain" );
			super.transferAsXml( fromRoot );
			if( _body != null ){
				XmlUtils.IXml._createIXml(fromRoot, "TransBody", _body );
			}
			_rocket = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_rocket = super.toString();
		}
		return _rocket;
	}
}
