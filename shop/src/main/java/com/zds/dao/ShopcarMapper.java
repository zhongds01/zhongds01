package com.zds.dao;

import com.zds.bean.Shopcar;
import com.zds.bean.ShopcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopcarMapper {
    int countByExample(ShopcarExample example);

    int deleteByExample(ShopcarExample example);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    List<Shopcar> selectByExample(ShopcarExample example);

    int updateByExampleSelective(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByExample(@Param("record") Shopcar record, @Param("example") ShopcarExample example);
}