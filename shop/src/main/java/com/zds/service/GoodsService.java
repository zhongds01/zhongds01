package com.zds.service;

import com.zds.bean.Goods;

import java.util.List;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/4/19
 * create_time : 1:08
 */
public interface GoodsService {

    List<Goods> getAllGoods();

    int commentGoods(Goods goods);

    int insert(Goods goods);

    List<Goods> recommend();

    List<Goods> searchGoods(String goodsName);

    List<Goods> searchGoodsByCata(String goodsCata);

    List<Goods> searchGoodsByNameOrCata(String goodsName, String goodsCata);

    int modifyGoods(String modifyGoods);

    int reduceMounts(String shopCars);

    int deleteGoods(Integer goodsId);
}
