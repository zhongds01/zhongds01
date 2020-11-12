package com.example.springboot.bean;

import org.springframework.stereotype.Component;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/3/26
 * create_time : 13:14
 */
@Component
public class Dog {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
