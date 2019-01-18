package com.zds;

import java.io.IOException;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/1/16
 * create_time : 16:47
 */
public class Test {

    public static void main(String[] args) throws Exception {
        /*try {
            //获取本机InetAddress实例
            //InetAddress address = InetAddress.getLocalHost();
            //获取其他机器实例
            InetAddress address1 = InetAddress.getByName("ZDS-PC");
            InetAddress address2 = InetAddress.getByName("10.10.167.212");
            String host_name = address2.getHostName();//获取计算机名
            String host_address = address2.getHostAddress();//获取IP地址
            System.out.println(host_name+host_address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
        sample1();
    }
    public static void sample1() throws IOException{
        //byte bytes[] = new byte[1024];
        //byte bytes = 127;
        Byte byte1 = new Byte("127");
        Byte byte2 = new Byte("127");
        Byte byte3 = byte1;
        Byte byte4 =12;
        Integer i = new Integer(1);
        System.out.println(byte1.SIZE);
        System.out.println(i.MIN_VALUE);
        System.out.println(byte1.MIN_VALUE);
        System.out.println(byte4);
        System.out.println("你好  yiwangzhibujian".getBytes("UTF-8").length >> 8);
    }
}
