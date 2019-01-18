package com.zds;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description: socketserver
 * author: ZDS
 * create_date : 2019/1/16
 * create_time : 17:23
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        //建立socket服务端对象
        try {
            ServerSocket serverSocket = new ServerSocket(55533);
            System.out.println("waiting...");
            //建立socket客户端对象向服务端发送请求
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len=inputStream.read(bytes)) != -1){
                stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("receive message:"+stringBuilder);

            System.out.println("Server :isInputShutdown:" + socket.isInputShutdown());
            System.out.println("Server :isOutputShutdown:" + socket.isOutputShutdown());
            System.out.println("Server :isConnected:" + socket.isConnected());
            System.out.println("Server :isBound:" + socket.isBound());
            System.out.println("Server :isClosed:" + socket.isClosed());

            OutputStream outputStream = socket.getOutputStream();
            String respones_mess = "你好 Client!";
            outputStream.write(respones_mess.getBytes("UTF-8"));


            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
