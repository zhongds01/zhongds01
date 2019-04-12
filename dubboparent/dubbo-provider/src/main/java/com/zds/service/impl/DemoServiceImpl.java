package com.zds.service.impl;

import com.zds.service.DemoService;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 14:50
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello:"+name;
    }
}
