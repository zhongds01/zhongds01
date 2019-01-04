package com.ai.sacenter.receive.teaminvoke.valuebean;

import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于对象开通消息</p>
 * <p>Copyright: Copyright (c) 2017年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RocketFObjectMessage extends RocketFMessage {
	private static final long serialVersionUID = -7934919170053219787L;
	private Object _objective;
	public RocketFObjectMessage() {
		super();
	}
	
	public RocketFObjectMessage( Object objective) {
		super( objective );
	}
	/**
	 * @return 消息对象
	 */
	public Object getObject() {
		return _objective;
	}
	
	/**
	 * @param objective 消息对象
	 */
	public void setObject(Object objective) {
		_objective = objective;
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
			if( _objective != null ){
				org.dom4j.Element _element = fromRoot.addElement( "TransBody" );
				XmlUtils.IXml._createIXml( _element, "OBJECTIVE", _objective );
			}
			_rocket = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_rocket = super.toString();
		}
		return _rocket;
	}
}
