package com.zds.service;

import com.zds.bean.Orders;
import com.zds.bean.Shopcar;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 6:14
 */
public interface OrdersService {

    List<Orders> getAllOrders();

    int insertMore(List<Shopcar> shopcars);

    List<Orders> getIngOrders(String custName);

    List<Orders> getFinishedOrders(String custName);

    int finishOrders(Integer orderId);

    int deleteOrders(Integer orderId);

    List<Orders> searchGoods(String custName);

    List<Orders> selectMaxSold();
}
