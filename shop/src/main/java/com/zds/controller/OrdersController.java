package com.zds.controller;

import com.alibaba.fastjson.JSON;
import com.zds.bean.Orders;
import com.zds.bean.Shopcar;
import com.zds.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 6:13
 */
@Controller
public class OrdersController {
    private Logger log = LoggerFactory.getLogger("OrdersController.class");

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/getAllOrders.action")
    @ResponseBody
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @RequestMapping("/makeOrders.action")
    @ResponseBody
    public Map<String,String> makeOrders(String shopCars){
        //System.out.println(shopCars);
        List<Shopcar> toObj = JSON.parseArray(shopCars,Shopcar.class);
        System.out.println(toObj.get(0).getGoodsMounts());
        Map<String,String> map = new HashMap<String, String>();
        int row = ordersService.insertMore(toObj);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    @RequestMapping("/getFinishedOrders.action")
    @ResponseBody
    public List<Orders> getFinishedOrders(HttpSession session){
        String custName = (String) session.getAttribute("session");
        return ordersService.getFinishedOrders(custName);
    }


    @RequestMapping("/getIngOrders.action")
    @ResponseBody
    public List<Orders> getIngOrders(HttpSession session){
        String custName = (String) session.getAttribute("session");
        System.out.println(custName);
        return ordersService.getIngOrders(custName);
    }

    @RequestMapping("/toOrders.action")
    public String toOrders(HttpSession session){
        String userName = (String) session.getAttribute("session");
        System.out.println(userName);
        if (userName==null||"".equals(userName)){
            return "warn";
        }else {
            return "orders";
        }
    }

    @RequestMapping("/finishOrders.action")
    @ResponseBody
    public Map<String,String> finishOrders(Integer orderId){
        Map<String,String> map = new HashMap<String, String>();
        int row = ordersService.finishOrders(orderId);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    @RequestMapping("/deleteOrders.action")
    @ResponseBody
    public Map<String,String> deleteOrders(Integer orderId){
        Map<String,String> map = new HashMap<String, String>();
        int row = ordersService.deleteOrders(orderId);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    @RequestMapping("/searchOrders.action")
    @ResponseBody
    public List<Orders> searchOrders(String custName){
        //System.out.println(custName);
        return ordersService.searchGoods(custName);

    }
}
