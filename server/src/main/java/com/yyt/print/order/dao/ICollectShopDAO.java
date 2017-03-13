package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.CollectShop;

/**
 * Created by lenovo on 2017/3/13.
 */
public interface ICollectShopDAO{
    int saveCollectShop(CollectShop collectShop);
    int updateCollectShop(CollectShop collectShop);
    CollectShop getCollectShop(int id);
    int delCollectShop(int id);

    int getCount(int uid);

    CollectShop isCollect(int uid,int shopId);
}
