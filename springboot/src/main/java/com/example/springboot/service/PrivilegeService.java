package com.example.springboot.service;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2020/8/5 21:00
 */
public interface PrivilegeService {

    /**
     * 模拟校验用户是否有权限
     *
     * @param userName 用户名称
     * @param password 密码
     * @return true：有权限，false：没有
     */
    boolean havingPrivilege(String userName,String password,String privilegeValue);
}
