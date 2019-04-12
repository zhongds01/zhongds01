package com.zds.bean;

import java.io.Serializable;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 16:37
 */
public class User implements Serializable {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
