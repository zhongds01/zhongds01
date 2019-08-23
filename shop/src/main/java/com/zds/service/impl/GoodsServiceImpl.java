package com.zds.service.impl;

import com.alibaba.fastjson.JSON;
import com.zds.bean.*;
import com.zds.dao.GoodsMapper;
import com.zds.dao.OrdersMapper;
import com.zds.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 1:09
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private Logger log = LoggerFactory.getLogger("GoodsServiceImpl.class");
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Goods> getAllGoods() {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andStateEqualTo("U");
        return goodsMapper.selectByExample(goodsExample);
    }

    @Override
    public int commentGoods(Goods goods) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getGoodsId());
        return goodsMapper.updateByExampleSelective(goods,goodsExample);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public List<Goods> recommend() {
        List<Orders> ordersList= ordersMapper.selectMaxSold();
        List<Goods> goodsList =null;
        for (int i=0;i<ordersList.size();i++){
            Integer goodsId = ordersList.get(i).getGoodsId();
            Goods goods = goodsMapper.selectByKey(goodsId);
            goodsList=(goodsMapper.selectRecommendGoods(goods.getGoodsCata()));
        }
        return goodsList;
    }

    @Override
    public List<Goods> searchGoodsByCata(String goodsCata) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsCataEqualTo(goodsCata);
        criteria.andStateEqualTo("U");
        return goodsMapper.selectByExample(goodsExample);
    }

    @Override
    public List<Goods> searchGoodsByNameOrCata(String goodsName, String goodsCata) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if(goodsName!=null&&!"".equals(goodsName)){
            criteria.andGoodsNameLike("%"+goodsName+"%");
        }
        System.out.println(goodsName);
        System.out.println(goodsCata);
        if (goodsCata!=null&&!"".equals(goodsCata)){
            criteria.andGoodsCataEqualTo(goodsCata);
        }
        criteria.andStateEqualTo("U");
        return goodsMapper.selectByExample(goodsExample);
    }

    @Override
    public int modifyGoods(String modifyGoods) {
        Goods goods = JSON.parseObject(modifyGoods, Goods.class);
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getGoodsId());
        criteria.andStateEqualTo("U");
        return goodsMapper.updateByExampleSelective(goods,goodsExample);
    }

    @Override
    public int reduceMounts(String shopCars) {
        int row = 0;
        List<Shopcar> shopcarList = JSON.parseArray(shopCars, Shopcar.class);
        for (int i=0;i<shopcarList.size();i++){
            Goods good = goodsMapper.selectByKey(shopcarList.get(i).getGoodsId());
            GoodsExample goodsExample = new GoodsExample();
            GoodsExample.Criteria criteria = goodsExample.createCriteria();
            good.setGoodsStock(good.getGoodsStock()-shopcarList.get(i).getGoodsMounts());
            criteria.andStateEqualTo("U");
            criteria.andGoodsIdEqualTo(shopcarList.get(i).getGoodsId());
            row+=goodsMapper.updateByExample(good,goodsExample);
        }
        return row;
    }

    @Override
    public int deleteGoods(Integer goodsId) {
        Goods goods = new Goods();
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        goods.setState("E");
        criteria.andGoodsIdEqualTo(goodsId);
        return goodsMapper.updateByExampleSelective(goods,goodsExample);
    }

    @Override
    public List<Goods> searchGoods(String goodsName) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsNameLike("%"+goodsName+"%");
        criteria.andStateEqualTo("U");
        return goodsMapper.selectByExample(goodsExample);
    }
}
