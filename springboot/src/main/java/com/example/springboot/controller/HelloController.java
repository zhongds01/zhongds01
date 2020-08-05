package com.example.springboot.controller;

import com.example.springboot.annotation.Privilege;
import com.example.springboot.constant.DConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/3/24
 * create_time : 13:21
 */
@Validated
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

    private String para1;

    public String getPara1() {
        return para1;
    }

    public void setPara1(String para1) {
        this.para1 = para1;
    }

    @Privilege(value = DConstant.PRIVILEGE.ADD)
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@NotBlank(message = "para1不能为空") String para1) {
        System.out.println(para1.length());
        return "Hello SpringBoot" + ioc.containsBean("helloService") + para1;
    }
}
