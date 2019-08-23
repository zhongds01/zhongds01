package com.zds.service;

import com.zds.bean.Goods;
import com.zds.bean.Shopcar;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 13:14
 */
public interface ShopCarService {

    int insert(Goods goods,String custName);

    List<Shopcar> getAllShopCar(String custName);

    int deleteCar(String shopCars);

}
