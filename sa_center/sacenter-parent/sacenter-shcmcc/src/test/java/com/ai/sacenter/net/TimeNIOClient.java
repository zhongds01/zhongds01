package com.ai.sacenter.net;

import java.io.IOException;  
import java.net.InetSocketAddress;  
import java.nio.ByteBuffer;  
import java.nio.channels.SelectionKey;  
import java.nio.channels.Selector;  
import java.nio.channels.SocketChannel;  
import java.util.Iterator;

import com.ai.sacenter.util.ClassUtils;  


public class TimeNIOClient {
	//通道管理器  
	private java.nio.channels.Selector selector=null;
	private SocketChannel channel;
	private int _connecttimeout_ = 600;
	private int _timeout = 120000;
	public TimeNIOClient() {
		super();
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void connect() throws Exception{
		Selector selector = null;
		try
		{
			SocketChannel aSocketChannel = SocketChannel.open();  
			aSocketChannel.configureBlocking(false);  
		    selector = Selector.open();  
		    aSocketChannel.connect(new InetSocketAddress( "localhost", 43430 ) );  
		    aSocketChannel.register(selector, SelectionKey.OP_CONNECT); 
		    int connectChannels = selector.select( _connecttimeout_ );
		    if ( connectChannels < 0 ) throw new java.net.ConnectException("<0");
			else if( connectChannels == 0 ) throw new java.net.ConnectException("=0");
			else{
			    java.util.Iterator keyIterator = selector.selectedKeys().iterator();
			    while( keyIterator.hasNext() ) {  
			        SelectionKey aSelectionKey = (SelectionKey) keyIterator.next();  
			        keyIterator.remove();  
			        if (aSelectionKey.isConnectable()) {  
			            channel = (SocketChannel)aSelectionKey.channel();  
			            if(channel.isConnectionPending()){  
			                channel.finishConnect();   
			            }
			            channel.configureBlocking(false);
			            break;
			        } 
			    }  
			}
		}
		finally{
			if( selector != null ){ selector.close(); selector = null; }
		}
	}
	/**
	 * 
	 * @param fromByte
	 * @throws Exception
	 */
	public int _write( byte fromByte[] ) throws Exception{
		int fromBytes = 0;
		try
		{
			ByteBuffer fromBuffer = ByteBuffer.wrap( fromByte, 0, fromByte.length );
			fromBuffer.flip();
			while( fromBuffer.hasRemaining() ){
				fromBytes += channel.write( fromBuffer );
			}
		}
		finally{
			
		}
		return fromBytes;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public byte[] onRead() throws Exception{
		byte[] fromBytes = null;
		try
		{
			java.nio.channels.Selector selector = null;
			try
			{
				selector = java.nio.channels.Selector.open();
	    		channel.register( selector , java.nio.channels.SelectionKey.OP_READ );
	    		int readChannels = selector.select( _timeout );
	    		if( readChannels <= 0 ) throw new java.net.SocketTimeoutException();
	    		else{
	    			java.util.Iterator keyIterator = selector.selectedKeys().iterator();
				    while( keyIterator.hasNext() ) {  
				        SelectionKey aSelectionKey = (SelectionKey) keyIterator.next();  
				        keyIterator.remove();  
				        if( aSelectionKey.isReadable() ){
				        	channel = (SocketChannel)aSelectionKey.channel();
				        }
				        if (aSelectionKey.isConnectable()) {  
				            channel = (SocketChannel)aSelectionKey.channel();  
				            if(channel.isConnectionPending()){  
				                channel.finishConnect();   
				            }
				            channel.configureBlocking(false);
				            break;
				        } 
				    }  
	    		}
			}
			finally{
				if( selector != null ){ selector.close(); selector = null; }
			}
			
		}
		finally{
			
		}
		return fromBytes;
	}
	/**
	 * 
	 * @param fromByte
	 * @return
	 * @throws Exception
	 */
	public int _read( byte [] fromByte ) throws Exception{
		int aReadSize = 0;
		try
		{
			//channel.re
		}
		finally{
			
		}
		return aReadSize;
	}
	/***
	 * 
	 * @throws IOException
	 */
	public void _distconnect( ) throws IOException{
		try
    	{
			channel.configureBlocking(false);
			java.nio.channels.Selector selector=null;
	    	try
	    	{
	    		channel.socket().shutdownOutput();
	    		selector = java.nio.channels.Selector.open();
	    		channel.register( selector , java.nio.channels.SelectionKey.OP_READ );
	    		java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate( 128 );
	    		while(true){
	    			int temp = selector.select( 600/10 );
	    			if(temp <= 0) break;
	    			temp = channel.read(buffer);
	    			if(temp <= 0) break;
	    		}
	    	}
	    	catch(Exception e){
	    	}
	    	//if( channel.socket() != null ) channel.socket().close(); 
	    	//channel.close(); channel=null;
	    	if( channel != null ){ channel.close(); channel = null; }
	    	if( selector != null && selector.isOpen() ){ selector.close(); selector = null;}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
	}
	/**
	 * 
	 * @param ip
	 * @param port
	 * @throws IOException
	 */
	public void initClient(String ip,int port) throws IOException {  
	    //获得一个Socket通道  
	    SocketChannel channel = SocketChannel.open();  
	    //设置通道为非阻塞  
	    channel.configureBlocking(false);  
	    //获得一个通道管理器  
	    this.selector = Selector.open();  
	    //客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调  
	    //用channel.finishConnect();才能完成连接  
	    channel.connect(new InetSocketAddress(ip,port));  
	    //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。  
	    channel.register(selector, SelectionKey.OP_CONNECT);  
	}
	/**
	 * 
	 * @throws IOException
	 */
	public void listen() throws IOException {
		// 轮询访问selector  
		while (true) {  
		    selector.select();  
		    // 获得selector中选中的项的迭代器  
		    Iterator ite = this.selector.selectedKeys().iterator();  
		    while (ite.hasNext()) {  
		        SelectionKey key = (SelectionKey) ite.next();  
		        // 删除已选的key,以防重复处理  
		        ite.remove();  
		        // 连接事件发生  
		        if (key.isConnectable()) {  
		            SocketChannel channel = (SocketChannel)key.channel();  
		            // 如果正在连接，则完成连接  
		            if(channel.isConnectionPending()){  
		                channel.finishConnect();   
		            }  
		            // 设置成非阻塞  
		            channel.configureBlocking(false);  
		            //在这里可以给服务端发送信息哦  
		            channel.write(ByteBuffer.wrap(new String("向客户端发送了一条信息").getBytes()));  
		            //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。  
		            channel.register(this.selector, SelectionKey.OP_READ);  
		            // 获得了可读的事件  
		        } else if (key.isReadable()) {  
		                read(key);  
		        }  

		    }  
		}
	}
	/**
	 * 
	 * @param key
	 * @throws IOException
	 */
	public void read(SelectionKey key) throws IOException{  
		// 服务器可读取消息:得到事件发生的Socket通道  
		SocketChannel channel = (SocketChannel) key.channel();  
		// 创建读取的缓冲区  
		ByteBuffer buffer = ByteBuffer.allocate(10);  
		channel.read(buffer);  
		byte[] data = buffer.array();  
		String msg = new String(data).trim();  
		System.out.println("服务端收到信息："+msg);  
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());  
		channel.write(outBuffer);// 将消息回送给客户端  
	}

	public static void main(String[] args) {
		try
		{
			TimeNIOClient client = new TimeNIOClient();  
			//client.initClient("localhost",43430);  
			//client.listen();
			client.connect();
			System.out.println("_________________________");
			Thread.currentThread().sleep( 120000l );
			System.out.println("_________________________");
			client._distconnect();
			System.out.println("_________________________");
			Thread.currentThread().sleep( 50000000000l );
		}
		catch( java.lang.Exception aException ){
			aException.printStackTrace();
		}
		finally{
			
		}
	}

}
