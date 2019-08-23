package com.zds.controller;

import com.zds.bean.Goods;
import com.zds.bean.Shopcar;
import com.zds.service.ShopCarService;
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
 * create_time : 12:24
 */
@Controller
public class ShopCarController {
    private Logger log = LoggerFactory.getLogger("ShopCarController.class");

    @Autowired
    ShopCarService shopCarService;
    @RequestMapping("/toShopCar.action")
    public String toShopCar(HttpSession session){
        String custName = (String) session.getAttribute("session");
        if (custName==null||"".equals(custName)){
            return "warn";
        }else {
            return "shopcar";
        }
    }

    @RequestMapping("/addToShopCar.action")
    @ResponseBody
    public Map<String,String> addToShopCar(Goods goods,HttpSession session){
        Map<String,String> map = new HashMap<String, String>();
        String custName = (String) session.getAttribute("session");
        if (custName==null||"".equals(custName)){
            map.put("msg","nologin");
        }else {
            int row = shopCarService.insert(goods,custName);
            if (row==1){
                map.put("msg","ok");
            }else{
                map.put("msg","error");
            }
        }
        return map;
    }
    @RequestMapping("/getAllShopCar.action")
    @ResponseBody
    public List<Shopcar> getAllShopCar(HttpSession session){
        String custName = (String) session.getAttribute("session");
        return shopCarService.getAllShopCar(custName);
    }
    @RequestMapping("/deleteCar.action")
    @ResponseBody
    public Map<String,String> deleteCar(String shopCars){
        Map<String,String> map = new HashMap<String, String>();
        int row = shopCarService.deleteCar(shopCars);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }

}
