package com.zds.service.impl;

import com.alibaba.fastjson.JSON;
import com.zds.bean.Custom;
import com.zds.bean.Orders;
import com.zds.bean.OrdersExample;
import com.zds.bean.Shopcar;
import com.zds.dao.CustomMapper;
import com.zds.dao.OrdersMapper;
import com.zds.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 6:14
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    CustomMapper customMapper;
    @Override
    public List<Orders> getAllOrders() {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andStateEqualTo("U");
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public int insertMore(List<Shopcar> shopcars) {
        int row = 0;
        for (int i=0;i<shopcars.size();i++){
            Custom custom = customMapper.selectByName(shopcars.get(i).getCustName());
            Orders orders = new Orders();
            orders.setGoodsId(shopcars.get(i).getGoodsId());
            orders.setGoodsName(shopcars.get(i).getGoodsName());
            orders.setGoodsMounts(shopcars.get(i).getGoodsMounts());
            orders.setTotalPrice(shopcars.get(i).getGoodsPrice()*shopcars.get(i).getGoodsMounts());
            orders.setCustName(shopcars.get(i).getCustName());
            orders.setCustAddress(custom.getCustAddress());
            orders.setCustTel(custom.getCustTel());
            orders.setOrderState("进行中");
            orders.setState("U");
            row+=ordersMapper.insert(orders);
        }
        return row;
    }

    @Override
    public List<Orders> getIngOrders(String custName) {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andStateEqualTo("U");
        criteria.andOrderStateEqualTo("进行中");
        criteria.andCustNameEqualTo(custName);
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public List<Orders> getFinishedOrders(String custName) {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andStateEqualTo("U");
        criteria.andOrderStateEqualTo("已完成");
        criteria.andCustNameEqualTo(custName);
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public int finishOrders(Integer orderId) {
        Orders orders = new Orders();
        orders.setOrderState("已完成");
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andStateEqualTo("U");
        criteria.andOrderIdEqualTo(orderId);
        return ordersMapper.updateByExampleSelective(orders,ordersExample);
    }

    @Override
    public int deleteOrders(Integer orderId) {
        Orders orders = new Orders();
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        orders.setState("E");
        criteria.andOrderIdEqualTo(orderId);
        return ordersMapper.updateByExampleSelective(orders,ordersExample);
    }

    @Override
    public List<Orders> searchGoods(String custName) {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andCustNameLike("%"+custName+"%");
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public List<Orders> selectMaxSold() {
        return ordersMapper.selectMaxSold();
    }
}
