package com.ai.sacenter.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: SOCKET¿Í»§¶Ë</p>
 * <p>Copyright: Copyright (c) 2015-1-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SocketClient extends org.apache.commons.net.SocketClient {
	private final static Log log = LogFactory.getLog( SocketClient.class );
	private static final org.apache.commons.net.SocketFactory _SOCKET_FACTORY_ = new DefaultSocketFactory();
	private DataInputStream _input_ = null;
	private DataOutputStream _output_ = null;
	private int _connecttimeout_ = 0;
    public SocketClient() {
		super();
		super.setSocketFactory( _SOCKET_FACTORY_ );
	}
	/**
     * 
     * @return
     */
    public java.io.DataInputStream getInputStream() {
		return _input_;
	}
    /***
     * 
     * @return
     */
	public java.io.DataOutputStream getOutputStream() {
		return _output_;
	}
	/**
	 * 
	 * @throws Exception
	 */
	private void _connectActionL_() throws Exception{
		super._connectAction_();
		_input_ = new DataInputStream( new BufferedInputStream( super._input_ ) );
		_output_ = new DataOutputStream( new BufferedOutputStream( super._output_ ) );
	}
	/**
	 * 
	 * @param platform
	 * @param host
	 * @param port
	 * @param timeout
	 * @throws Exception
	 */
	public void connect(String platform, String host, int port, int timeout) throws Exception {
		SocketFactory _socketFactory_ = (SocketFactory)super._socketFactory_;
		if( timeout <= 0 ) _socket_ = _socketFactory_.createSocket( host, port );
		else _socket_ = _socketFactory_.createSocket( host , port , timeout );
		_connecttimeout_ = timeout;
		_connectActionL_();
	}
	/***
	 * 
	 * @throws IOException
	 */
	private void _distconnect( ) throws IOException{
		try
    	{
			if( _output_ != null ){
				if( super._socket_ != null ) {
					try{ super._socket_.shutdownOutput();}catch(java.lang.Exception aException){}
				}
				try{_output_.flush(); } catch(IOException aException){ }
				try{ _output_.close(); _output_ = null;}catch(java.lang.Exception aException){}
			}
			if( _input_ != null ){
				try{ _input_.close(); _input_ = null;}catch(java.lang.Exception aException){}
			}
			try
			{
				if( super._socket_ != null ){ super.disconnect(); }
			}
			catch( java.lang.Exception aException ){
				if( log.isErrorEnabled() ) log.error( aException.getMessage(), aException );
			}
		}
    	catch(Exception aException){
    		if( log.isErrorEnabled() ) log.error( aException.getMessage(), aException );
    	}
		finally{
			
		}
	}
	/* (non-Javadoc)
	 * @see org.apache.commons.net.SocketClient#disconnect()
	 */
	public void disconnect() throws IOException {
		if( _connecttimeout_ <= 0 ) super.disconnect();
		else _distconnect( );
	}
	/**
	 * @author Administrator
	 *
	 */
	public interface SocketFactory extends org.apache.commons.net.SocketFactory {
		/**
		 * 
		 * @param host
		 * @param port
		 * @param connctiontimeout
		 * @return
		 * @throws Exception
		 */
		public java.net.Socket createSocket(String host , int port , int connctiontimeout ) throws Exception;
	}
	/**
	 * @author Administrator
	 *
	 */
	public static class DefaultSocketFactory extends
			org.apache.commons.net.DefaultSocketFactory implements SocketFactory {
		public DefaultSocketFactory() {
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.util.SocketClient.SocketFactory#createSocket(java.lang.String, int, int)
		 */
		public java.net.Socket createSocket( String host, int port, int connctiontimeout ) throws Exception {
			java.net.Socket _socket_ = null;
			try
			{
				_socket_ = new java.net.Socket();
				InetSocketAddress _endpoint_ = new InetSocketAddress( host, port );
				_socket_.connect( _endpoint_, connctiontimeout ); 
			}
			catch( java.lang.Exception aException ){
				throw aException;
			}
			finally{
				
			}
			return _socket_;
		}
	}
}
