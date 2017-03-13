package com.yyt.print.order.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.ICollectShopDAO;
import com.yyt.print.order.pojo.CollectShop;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/3/13.
 */
@Repository("collectShopDAO")
public class CollectShopDAOImpl extends YytBaseDAO<CollectShop> implements ICollectShopDAO {
    @Override
    public int saveCollectShop(CollectShop collectShop){
        collectShop.setCreateTime(new Date());
        return super.insert(collectShop);
    }
    @Override
    public int updateCollectShop(CollectShop collectShop){return super.update(collectShop);}
    @Override
    public CollectShop getCollectShop(int id){return super.get(id);}
    @Override
    public int delCollectShop(int id){return super.delete(id);}

    @Override
    public int getCount(int uid) {
        return super.count(super.getSqlStatementName("getcount"),uid);
    }

    @Override
    public CollectShop isCollect(int uid, int shopId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",uid);
        map.put("shopId",shopId);

        return super.findUniqueBy("selectIsCollect",map);
    }
}