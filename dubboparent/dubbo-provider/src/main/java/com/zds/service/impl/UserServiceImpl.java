package com.zds.service.impl;

import com.zds.bean.User;
import com.zds.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 16:38
 */
public class UserServiceImpl implements UserService {
    public List<User> getUser() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("Tom"));
        userList.add(new User("Tony"));
        userList.add(new User("Jack"));
        return userList;
    }
}
