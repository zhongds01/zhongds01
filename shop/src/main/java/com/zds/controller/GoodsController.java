package com.zds.controller;

import com.zds.bean.Goods;
import com.zds.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 1:13
 */
@Controller
public class GoodsController {
    private Logger log = LoggerFactory.getLogger("GoodsController.class");

    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;

    @RequestMapping("/getAllGoods.action")
    @ResponseBody
    public List<Goods> getAllGoods(){
        List<Goods> goods = goodsService.getAllGoods();
        for (int i=0;i<goods.size();i++){
            String url = goods.get(i).getGoodsPic();
            url = url.replaceAll("\\\\","/");
            System.out.println(url);
            goods.get(i).setGoodsPic(url);
        }
        return goods;
    }
    @RequestMapping("/commentGoods.action")
    @ResponseBody
    public Map<String,String> commentGoods(Goods goods){
        Map<String,String> map = new HashMap<String, String>();
        System.out.println(goods.getGoodsId());
        System.out.println(goods.getGoodsComment());
        int row = goodsService.commentGoods(goods);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }

    @RequestMapping("/goodsAdd.action")
    public String goodsAdd(String goodsName,Double goodsPrice,String goodsCata,Integer goodsStock,String goodsDesc,String goodsComment, MultipartFile goodsPic){
        //System.out.println(goodsName);
        String originalName = goodsPic.getOriginalFilename();

        String dirPath = "D:"+File.separator+"upload"+File.separator+ Calendar.getInstance().get(Calendar.YEAR)+File.separator+(Calendar.getInstance().get(Calendar.MONTH)+1)+File.separator+Calendar.getInstance().get(Calendar.DATE)+File.separator;
        File filePath = new File(dirPath);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        String newName = UUID.randomUUID()+"_"+originalName;
        try {
            goodsPic.transferTo(new File(dirPath + newName ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String goodsPicURL = Calendar.getInstance().get(Calendar.YEAR)+File.separator+(Calendar.getInstance().get(Calendar.MONTH)+1)+File.separator+Calendar.getInstance().get(Calendar.DATE)+File.separator+newName;
        Goods goods = new Goods();
        System.out.println(goodsPrice);
        goods.setGoodsStock(goodsStock);
        goods.setGoodsCata(goodsCata);
        goods.setGoodsDesc(goodsDesc);
        goods.setGoodsName(goodsName);
        goods.setGoodsPrice(goodsPrice);
        goods.setGoodsComment(goodsComment);
        goods.setState("U");
        goods.setGoodsPic(goodsPicURL);
        int row = goodsService.insert(goods);
        if (row>0){
            return "ok";
        }else {
            return "error";
        }
    }
    @RequestMapping("/recommend.action")
    @ResponseBody
    public List<Goods> recommend(){
        return goodsService.recommend();
    }
    @RequestMapping("/searchGoods.action")
    @ResponseBody
    public List<Goods> searchGoods(String goodsName){
        return goodsService.searchGoods(goodsName);
    }
    @RequestMapping("/searchGoodsByCata.action")
    @ResponseBody
    public List<Goods> searchGoodsByCata (String goodsCata){
        return goodsService.searchGoodsByCata(goodsCata);
    }
    @RequestMapping("/searchGoodsByNameOrCata.action")
    @ResponseBody
    public List<Goods> searchGoodsByNameOrCata (String goodsName,String goodsCata){
        return goodsService.searchGoodsByNameOrCata(goodsName,goodsCata);
    }
    @RequestMapping("/modifyGoods.action")
    @ResponseBody
    public Map<String,String> modifyGoods(String modifyGoods){
        Map<String,String> map = new HashMap<String, String>();
        int row = goodsService.modifyGoods(modifyGoods);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    @RequestMapping("/reduceMounts.action")
    @ResponseBody
    public Map<String,String> reduceMounts(String shopCars){
        Map<String,String> map = new HashMap<String, String>();
        int row = goodsService.reduceMounts(shopCars);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }
    @RequestMapping("/deleteGoods.action")
    @ResponseBody
    public Map<String,String> deleteGoods(Integer goodsId){
        Map<String,String> map = new HashMap<String, String>();
        int row = goodsService.deleteGoods(goodsId);
        if (row>0){
            map.put("msg","ok");
        }else {
            map.put("msg","error");
        }
        return map;
    }

}
