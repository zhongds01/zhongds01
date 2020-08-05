package com.example.springboot.service.impl;

import com.example.springboot.service.PrivilegeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Description: 权限控制业务实现类
 * Author: zhongds
 * Date : 2020/8/5 21:01
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Override
    public boolean havingPrivilege(String userName, String password, String privilegeValue) {
        // 模拟权限校验场景
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password) && "QUERY".equals(privilegeValue)) {
            return true;
        } else {
            return false;
        }
    }
}
