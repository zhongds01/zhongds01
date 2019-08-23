package com.zds;

import com.zds.bean.Custom;
import com.zds.service.CustomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/18
 * create_time : 23:18
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        CustomService customServiceImpl = (CustomService)ioc.getBean("customServiceImpl");
        List<Custom> customs = customServiceImpl.selectByExample();
        for (int i = 0;i<customs.size();i++){
            System.out.println(customs.get(i).getCustEmail());
        }
    }
    public void method(){
        String[] arr = new String[]{"jack","jerry"};
        ArrayList<Object> objects = new ArrayList<Object>();

        //fori
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        //iter
        for (Object object : objects) {
            System.out.println(object);
        }
        //itar
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
        }
        //itli
        for (int i = 0; i < objects.size(); i++) {
            Object o =  objects.get(i);
        }
        String str = null;
        //ifn  str.null
        if (str == null) {

        }
        //inn
        if (str != null) {

        }

        
    }
}
