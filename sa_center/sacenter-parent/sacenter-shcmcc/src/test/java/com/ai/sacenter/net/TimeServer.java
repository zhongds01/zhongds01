package com.ai.sacenter.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.util.ByteBuffer;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

public class TimeServer {
	private final static Log log = LogFactory.getLog( TimeServer.class );
	public TimeServer() {
		super();
	}
    /**
     * 
     * @param args
     */
	public static void main(String[] args) {
		try
		{
			if( log.isDebugEnabled() ) log.debug("服务器启动...\n");
			 try 
			 {   
	             ServerSocket serverSocket = new ServerSocket(43430);   
	             while (true) 
	             {   
	                 // 一旦有堵塞, 则表示服务器与客户端获得了连接   
	                 Socket client = serverSocket.accept();   
	                 if( log.isDebugEnabled() ) log.debug("客户端: " + client.getRemoteSocketAddress() );  
	                 // 处理这次连接   
	                 new TimeClientHandler(client).start();   
	             }   
	         } 
			 catch (Exception e) {   
				 if( log.isErrorEnabled() ) log.error( "服务器异常: " + e.getMessage(), e );
	         }      
		}
		finally{
			
		}
	}
	public static class TimeClientHandler extends java.lang.Thread{
		private java.net.Socket _socket = null;
		public TimeClientHandler( java.net.Socket socket ){
			super();
			_socket = socket;  
		}
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			try
			{
				DataInputStream input = new DataInputStream(_socket.getInputStream());
				DataOutputStream out = new DataOutputStream(_socket.getOutputStream());   
				/*byte fromBytes[] = new byte[10];
				while( true ){
					int aReadSize = input.read(fromBytes);
					if( aReadSize <= 0 ){
						if( log.isDebugEnabled() ) log.debug("客户端{ "+_socket.getRemoteSocketAddress()+"}异常（close socket）。。。。。。。。。。。。。。。。。 " );
						_socket.close(); _socket = null;
						break;
					}
					else{
						String msg = new String(fromBytes).trim();  
						if( log.isDebugEnabled() ) log.debug("客户端{ "+_socket.getRemoteSocketAddress()+"}消息: " + msg );
						out.write( msg.getBytes() );
						out.flush();
					}
				}*/
				byte fromBytes[] = new byte[4];
				while( true ){
					int aReadSize = input.read(fromBytes);
					if( aReadSize <= 0 ){
						if( log.isDebugEnabled() ) log.debug("客户端{ "+_socket.getRemoteSocketAddress()+"}异常（close socket）。。。。。。。。。。。。。。。。。 " );
						_socket.close(); _socket = null;
						break;
					}
					else if( aReadSize == 4 ){
						String fromHead = MathUtils.IMath.toString(fromBytes, 0, 4 );
						if( fromHead.equals("AISC") ){
							TimeIORequest fromKySync = readKySync( input );
							if( log.isDebugEnabled() ) log.debug("客户端{ "+_socket.getRemoteSocketAddress()+"}消息: " + fromKySync.toString() );
							//Thread.currentThread().sleep( 1200000l );
							writeKySync( out );
						}
					}
				}
			}
			catch( java.lang.Exception aEXCEPTION ){
				if( log.isErrorEnabled() ) log.error("服务器 run 异常: " + aEXCEPTION.getMessage());   
			}
			finally{
				if (_socket != null) {   
                    try {   
                    	_socket.close();   
                    } catch (Exception e) {   
                    	_socket = null;   
                    	if( log.isErrorEnabled() ) log.error("服务端 finally 异常:" + e.getMessage());   
                    }   
                }   
			}
		}
		
		/**
		 * 
		 * @param fromInput
		 * @return
		 * @throws Exception
		 */
		public TimeIORequest readKySync( DataInputStream fromInput ) throws Exception{
			TimeIORequest fromKySync = null;
			try
			{
				fromKySync = new TimeIORequest();
				byte fromBytes[] = new byte[4];
				fromInput.read( fromBytes );
				int fromBodyL = MathUtils.IMath.toInt( fromBytes, 0 );
				fromBytes = new byte[ 182 + fromBodyL ];
				fromInput.read( fromBytes, 0, fromBytes.length );
				fromKySync.setPsNetCode( StringUtils.trim( fromBytes, 0, 20 ) );
				fromKySync.setPsId( Long.parseLong( StringUtils.trim( fromBytes, 20, 16 ) ) );
				fromKySync.setActionId( Long.parseLong( StringUtils.trim( fromBytes, 36, 10 ) ) );
				fromKySync.setPsServiceType( StringUtils.trim( fromBytes, 46, 32 ) );
				fromKySync.setBillId( StringUtils.trim( fromBytes, 78, 32 ) );
				fromKySync.setRegionId( StringUtils.trim( fromBytes, 110, 8 ) );
				fromKySync.setDoneCode( StringUtils.trim( fromBytes, 118, 64 ) );
				fromKySync.setPsParam( StringUtils.trim( fromBytes, 182, fromBytes.length - 182 ) );
			}
			finally{
				
			}
			return fromKySync;
		}
		/**
		 * 
		 * @param fromOutput
		 * @throws Exception
		 */
		public void writeKySync( DataOutputStream fromOutput ) throws Exception{
			try
			{
				byte fromBytes[] = new byte[182];
				fromOutput.write( "AISC".getBytes() );
			    String fromXML = "9$@$$@$<PROV_ITEM><STATE>9</STATE><FAIL_REASON><![CDATA[success]]></FAIL_REASON><PS_SERVICE_TYPE>VPN</PS_SERVICE_TYPE></PROV_ITEM>$@$RETN=1001,DESC=用户未被列入黑名单,ACCOUNTSTATE=1;  $@$";
			    fromOutput.writeInt( fromXML.getBytes().length );
			    fromOutput.write( fromBytes );
			    fromOutput.write( fromXML.getBytes() );
			    fromOutput.flush();
			}
			finally{
				
			}
		}
	}
}
