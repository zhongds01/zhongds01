package com.zds.service.impl;

import com.alibaba.fastjson.JSON;
import com.zds.bean.Custom;
import com.zds.bean.CustomExample;
import com.zds.dao.CustomMapper;
import com.zds.service.CustomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/18
 * create_time : 22:43
 */
@Service
public class CustomServiceImpl implements CustomService {
    private Logger log = LoggerFactory.getLogger(CustomServiceImpl.class);

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> selectByExample() {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustSexIsNotNull();
        return customMapper.selectByExample(customExample);
    }

    @Override
    public List<Custom> loginCheck(Custom custom) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustNameEqualTo(custom.getCustName());
        criteria.andCustPwdEqualTo(custom.getCustPwd());
        criteria.andStateEqualTo("U");
        return customMapper.selectByExample(customExample);
    }

    @Override
    public List<Custom> getAllcustoms() {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andStateEqualTo("U");
        return customMapper.selectByExample(customExample);
    }

    @Override
    public int insert(Custom custom) {
        custom.setState("U");
        return customMapper.insert(custom);
    }

    @Override
    public Custom selectByName(String custName) {
        return customMapper.selectByName(custName);
    }

    @Override
    public int modifyCustom(String customs) {
        Custom custom  = JSON.parseObject(customs,Custom.class);
        System.out.println(custom.getCustAddress());
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustIdEqualTo(custom.getCustId());
        criteria.andStateEqualTo("U");
        return customMapper.updateByExampleSelective(custom,customExample);
    }
}
