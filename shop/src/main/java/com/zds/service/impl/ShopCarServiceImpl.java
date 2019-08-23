package com.zds.service.impl;

import com.alibaba.fastjson.JSON;
import com.zds.bean.Goods;
import com.zds.bean.Shopcar;
import com.zds.bean.ShopcarExample;
import com.zds.dao.ShopcarMapper;
import com.zds.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 13:14
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    ShopcarMapper shopcarMapper;
    @Override
    public int insert(Goods goods,String custName) {
        Shopcar shopcar = new Shopcar();
        shopcar.setState("U");
        shopcar.setGoodsMounts(1);
        shopcar.setTotalPrice(goods.getGoodsPrice());
        shopcar.setGoodsPrice(goods.getGoodsPrice());
        shopcar.setCustName(custName);
        shopcar.setGoodsId(goods.getGoodsId());
        shopcar.setGoodsName(goods.getGoodsName());
        return shopcarMapper.insert(shopcar);
    }

    @Override
    public List<Shopcar> getAllShopCar(String custName) {
        ShopcarExample shopcarExample = new ShopcarExample();
        ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
        criteria.andCustNameEqualTo(custName);
        criteria.andStateEqualTo("U");
        return shopcarMapper.selectByExample(shopcarExample);
    }

    @Override
    public int deleteCar(String shopCars) {
        int row = 0;
        List<Shopcar> shopcarList = JSON.parseArray(shopCars, Shopcar.class);
        for (int i=0;i<shopcarList.size();i++){
            ShopcarExample shopcarExample = new ShopcarExample();
            ShopcarExample.Criteria criteria = shopcarExample.createCriteria();
            criteria.andCarIdEqualTo(shopcarList.get(i).getCarId());
            shopcarList.get(i).setState("E");
            row+=shopcarMapper.updateByExample(shopcarList.get(i),shopcarExample);
        }
        return row;
    }

}
