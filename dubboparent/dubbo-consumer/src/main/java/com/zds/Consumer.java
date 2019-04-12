package com.zds;

import com.zds.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 14:57
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        // Obtaining a remote service proxy
        DemoService demoService = (DemoService)context.getBean("demoService");
        // Executing remote methods
        String hello = demoService.sayHello("world");
        // Display the call result
        System.out.println(hello);
        System.out.println(1);
    }
}
