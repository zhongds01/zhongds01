package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/3/24
 * create_time : 13:21
 */
@RestController
public class HelloController {
    @Autowired
    private ApplicationContext ioc;

    @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;
    @Value("${content}")
    private String content;
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot"+ioc.containsBean("helloService");
    }
}
