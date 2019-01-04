package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于其它消息</p>
 * <p>Copyright: Copyright (c) 2017年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RocketFOtherMessage extends RocketFMessage {
	private static final long serialVersionUID = 4424389309581421615L;
	public RocketFOtherMessage() {
		super();
	}
	
	public RocketFOtherMessage( Object objective ) {
		super( objective );
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
			_rocket = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_rocket = super.toString();
		}
		return _rocket;
	}
}
