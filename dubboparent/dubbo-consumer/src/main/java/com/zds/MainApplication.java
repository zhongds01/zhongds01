package com.zds;

import com.zds.service.NameService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 16:49
 */
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        ioc.start();
        NameService nameService = (NameService)ioc.getBean("nameServiceImpl");
        nameService.sayName();
        System.out.println("调用完成");
        System.in.read();
    }

}
