package com.zds.service;

import com.zds.bean.Custom;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/18
 * create_time : 22:42
 */
public interface CustomService {
    List<Custom> selectByExample();

    List<Custom> loginCheck(Custom custom);

    List<Custom> getAllcustoms();

    int insert(Custom custom);

    Custom selectByName(String custName);

    int modifyCustom(String customs);
}
