package com.zds;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 14:55
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        //context.start();
        System.out.println("Provider started...");
        System.in.read(); // press any key to exit

    }
}
