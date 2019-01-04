package com.ai.sacenter.provision.mstp.impl;

import java.io.ByteArrayOutputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.util.HttpUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-29</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmSoapClient extends UpfwmHttpClient {
	private static final long serialVersionUID = 211442986291456987L;
	private SOAPConnectionFactory _CONNECTION_FACTORY_ = null;
	private MessageFactory _MESSAGE_FACTORY_ = null;
	private TransformerFactory _TRANSFORMER_FACTORY = null;
	public UpfwmSoapClient(IUpffmNetWork fromUpfm, IUpfwmDefine fromNetWork)
			throws Exception {
		super(fromUpfm, fromNetWork);
		_CONNECTION_FACTORY_ = SOAPConnectionFactory.newInstance();
		_MESSAGE_FACTORY_ = MessageFactory.newInstance( "SOAP 1.1 Protocol" );
		_TRANSFORMER_FACTORY = TransformerFactory.newInstance();
	}
	/**
	 * 
	 * @param fromMessage 要发送消息
	 * @return
	 * @throws Exception
	 */
	public String call( String fromMessage ) throws Exception{
		String fromASK = null;
		SOAPMessage response = null;
		SOAPMessage request = null;
		try
		{
			request = _wrap( fromMessage );
			response = call( request );
		    fromASK = _wrap( response );
		}
		finally{
			if( request != null ){ request = null; }
			if( response != null ){ response = null; }
		}
		return fromASK;
	}
	/**
	 * 
	 * @param fromMessage 要发送消息
	 * @return
	 * @throws Exception
	 */
	public SOAPMessage call( SOAPMessage fromMessage ) throws Exception{
		SOAPMessage fromASK = null;
		SOAPConnection _connection_ = null;
		try {
			CfgHttpClient _httpclient_ = null;
			if (StringUtils.isBlank(_client_) == false) {
				_httpclient_ = IUpdcfgFactory.getIBasicSV()
						.getHttpClient(_client_);
			}
			if (_httpclient_ == null) {
				ExceptionFactory.throwIllegal("IOS0011072", new String[] {
						PLATFORM_.getID(), NETWORK_.getID_() });
			}
			java.net.URL fromEndpoint = null;
			try {
				_connection_ = _CONNECTION_FACTORY_.createConnection();
				fromEndpoint = HttpUtils._wrap(_httpclient_);
				fromASK = _connection_.call(fromMessage, fromEndpoint);
			} finally {
				if (fromEndpoint != null) {
					fromEndpoint = null;
				}
			}
			if (fromASK != null && fromASK.getSOAPBody().hasFault()) {
				SOAPFault fromFault = fromASK.getSOAPBody().getFault();
				fault(fromFault);
			}
		} catch (java.lang.Exception aEXCEPTION) {
			ExceptionFactory.throwPrimitive(aEXCEPTION);
		} finally {
			if (_connection_ != null) {
				_connection_.close();
				_connection_ = null;
			}
		}
		return fromASK;
	}
	/**
	 * 
	 * @param fromFault
	 * @throws Exception
	 */
	private void fault( SOAPFault fromFault ) throws Exception{
		try
		{
			ExceptionFactory.throwFault("IOS0012015", new String[] { PLATFORM_.getID(),
					fromFault.getFaultCode(), fromFault.getFaultString() },
					PLATFORM_.getID(), fromFault);
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param fromMessage
	 * @return
	 * @throws Exception
	 */
	public String _wrap( SOAPMessage fromMessage ) throws Exception{
		Transformer transformer = null;
		ByteArrayOutputStream fromOut = null;
		try
		{
			transformer = _TRANSFORMER_FACTORY.newTransformer();
			StreamResult fromResult = new StreamResult( fromOut );
			transformer.transform(fromMessage.getSOAPPart().getContent(), fromResult);
		}
		finally{
			if( transformer != null ){ transformer = null; }
		}
		return fromOut != null?fromOut.toString():null;
	}
	/**
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public SOAPMessage _wrap( String message ) throws Exception{
		SOAPMessage request = null;
		try
		{
			request = _MESSAGE_FACTORY_.createMessage();
			StreamSource preppedMsgSrc = new StreamSource( new java.io.StringReader( message ) );
			request.getSOAPPart().setContent( preppedMsgSrc );
		    request.saveChanges();
		}
		finally{
		
		}
		return request;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-1-29</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmSoapDefine extends UpfwmHttpClient.IUpfwmHttpDefine{
		private static final long serialVersionUID = -1222623433411511644L;
		public IUpfwmSoapDefine(org.dom4j.Element aElement ) throws Exception{
			super( aElement );
		}
	}
}
