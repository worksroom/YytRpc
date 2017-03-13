package com.yyt.print.order.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.ICollectTreasureDAO;
import com.yyt.print.order.pojo.CollectTreasure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/3/13.
 */
@Repository("collectTreasureDAO")
public class CollectTreasureDAOImpl extends YytBaseDAO<CollectTreasure> implements ICollectTreasureDAO {
    @Override
    public int saveCollectTreasure(CollectTreasure collectTreasure){
        collectTreasure.setCreateTime(new Date());
        return super.insert(collectTreasure);
    }
    @Override
    public int updateCollectTreasure(CollectTreasure collectTreasure){return super.update(collectTreasure);}
    @Override
    public CollectTreasure getCollectTreasure(int id){return super.get(id);}
    @Override
    public int delCollectTreasure(int id){return super.delete(id);}

    @Override
    public int getCount(int uid) {
        return super.count(super.getSqlStatementName("getcount"),uid);
    }

    @Override
    public CollectTreasure isCollect(int uid, int goodsId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",uid);
        map.put("goodsId",goodsId);

        return super.findUniqueBy("selectIsCollect",map);
    }
}
