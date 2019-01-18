package com.zds;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/1/16
 * create_time : 17:16
 * https://www.cnblogs.com/yiwangzhibujian/p/7107785.html
 */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        //配置连接的服务端
        String ip_address = "127.0.0.1";
        int port = 55533;
        //与服务端建立连接
        Socket socket = new Socket(ip_address, port);
        //获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好 Server!";
        outputStream.write(message.getBytes("UTF-8"));
        outputStream.flush();
        String message_2 = "hello Server(sec)!";
        outputStream.write(message_2.getBytes("UTF-8"));
        outputStream.flush();
        //关闭输出流  不关闭连接  告诉服务端  我传输完毕
        socket.shutdownOutput();
        System.out.println("Client :isInputShutdown:" + socket.isInputShutdown());
        System.out.println("Client :isOutputShutdown:" + socket.isOutputShutdown());
        System.out.println("Client :isConnected:" + socket.isConnected());
        System.out.println("Client :isBound:" + socket.isBound());
        System.out.println("Client :isClosed:" + socket.isClosed());

        //获得输入流
        InputStream inputStream = socket.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1){
            System.out.println("receive response:"+new String(bytes,0,len));
        }
        //确定不再使用流  关闭  如果关闭了流，那么相应的Socket也将关闭，和直接关闭Socket一个性质。
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
