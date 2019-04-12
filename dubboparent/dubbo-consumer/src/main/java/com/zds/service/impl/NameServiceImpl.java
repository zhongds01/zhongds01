package com.zds.service.impl;

import com.zds.bean.User;
import com.zds.service.NameService;
import com.zds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/12
 * create_time : 16:42
 */
@Service
public class NameServiceImpl implements NameService {
    @Autowired
    UserService userService;
    public void sayName() {
        List<User> userList = userService.getUser();
        for (User user:userList
             ) {
            System.out.println(user.getName());
        }
    }
}
