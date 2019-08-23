package com.zds.dao;

import com.zds.bean.Custom;
import com.zds.bean.CustomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    int countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    Custom selectByName(String custName);
}