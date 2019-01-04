package com.ai.sacenter.receive.teaminvoke.valuebean;

import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于文本消息</p>
 * <p>Copyright: Copyright (c) 2017年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RocketFTextMessage extends RocketFMessage {
	private static final long serialVersionUID = -750540643411756377L;
	private String _text;
	public RocketFTextMessage(){
		super();
	}
	
	public RocketFTextMessage(String fromXmlBusi ){
		super();
		_text = fromXmlBusi;
	}
	
	public RocketFTextMessage( Object objective, String fromXmlBusi ) {
		super( objective );
		_text = fromXmlBusi;
	}
	
	/**
	 * @return 消息体
	 */
	public String getText() {
		return _text;
	}
	
	/**
	 * @param body 消息体
	 */
	public void setText(String text) {
		_text = text;
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
			if( _text != null ){
				XmlUtils.IXml._createIXml(fromRoot, "TransBody", _text );
			}
			_rocket = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_rocket = super.toString();
		}
		return _rocket;
	}
}
