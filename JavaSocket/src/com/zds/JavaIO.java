package com.zds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/1/17
 * create_time : 10:28
 * inputstream read()方法 outputstream() write方法
 */
public class JavaIO {
    public static void main(String[] args) throws Exception {
        Outputstream();
        Inputstream();
        Read_write_stream();
    }

    /**
     *inputstream方法(读)
     */
    public static void Inputstream() throws Exception{
        //通过FileInputStream打开文件
        FileInputStream fileInputStream = new FileInputStream("b.txt");
        int len;
        //一个字节一个字节读取  返回值为读取到的字节
        /*while ((len=fileInputStream.read()) != -1){
            System.out.println((char)len);
        }*/


        //读取所有字节从输入流到字节数组(如果该文件已经被以上方式读取，此处将读不出数据，因为len此时为-1) 返回值为读取的长度
        //fileInputStream.read();
        byte bytes[] =new byte[1024];
        /*while ((len = fileInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }*/
        //读取固定字节从输入流到字节数组
        while ((len = fileInputStream.read(bytes,0,3)) != -1){
            System.out.println(new String(bytes,0,len));
        }

        fileInputStream.close();
    }
    /**
     *outputstream方法(写)
     */
    public static void Outputstream() throws Exception{
        //fileinputstream为inputstream子类  true设置每次输入的内容追加到后面
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        for(int i = 1;i < 127; i++){
            fileOutputStream.write(String.valueOf(i).getBytes());
            fileOutputStream.write(i);
            fileOutputStream.write("\n\r".getBytes());
        }
        byte[] bytes = {127,126,-1};
        //0表示数组下标第0位，2表示三个byte，即127，126
        fileOutputStream.write(bytes,0,2);
        fileOutputStream.close();
    }

    /**
     * 读写函数
     */
    public static void Read_write_stream() throws Exception{
        //创建读的流对象
        FileInputStream fileInputStream = new FileInputStream("b.txt");
        //创建写的流对象
        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");
        int len;
        byte[] bytes = new byte[1024];
        while ((len =fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len-1);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    /**
     * BufferedOutputStream 字节缓冲输出流
     * description:增加写文件操作的速度
     */

    public static void Bufferedoutputstream() throws Exception{
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("a.txt"));
        byte bytes = 1;
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /**
     * BufferedInputStream 字节缓冲输入流
     * description:增加读文件操作的速度
     */

    public static void Bufferedinputstream() throws Exception{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("b.txt"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bufferedInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len,"UTF-8"));
        }
        bufferedInputStream.close();
    }
}
