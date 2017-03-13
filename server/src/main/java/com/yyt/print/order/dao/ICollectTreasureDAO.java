package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.CollectTreasure;

/**
 * Created by lenovo on 2017/3/13.
 */
public interface ICollectTreasureDAO{
    int saveCollectTreasure(CollectTreasure collectTreasure);
    int updateCollectTreasure(CollectTreasure collectTreasure);
    CollectTreasure getCollectTreasure(int id);
    int delCollectTreasure(int id);

    int getCount(int uid);

    CollectTreasure isCollect(int uid,int goodsId);
}
