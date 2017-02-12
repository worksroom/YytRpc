package com.yyt.print.product.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallGoodsDAO;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.query.MallGoodsQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/12.
 */
@Repository("mallGoodsDAO")
public class MallGoodsDAOImpl extends YytBaseDAO<MallGoods> implements IMallGoodsDAO {
    @Override
    public int saveMallGoods(MallGoods goods) {
        return super.insert(goods);
    }

    @Override
    public int updateMallGoods(MallGoods goods) {
        return super.update(goods);
    }

    @Override
    public int deleteMallGoods(int id) {
        return super.delete(id);
    }

    @Override
    public MallGoods getMallGoods(int id) {
        return super.get(id);
    }

    @Override
    public PageHolder<MallGoods> findMallGoods(MallGoodsQuery query) {
        return super.pagedQuery("findByParams",query.getMap(),query.getPageIndex(),query.getPageSize());
    }

    @Override
    public int reviewMallGoods(int id,boolean status) {
        int value = 99;
        if(status){
            value = 1;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",value);

        return super.updateBy("updateStatus",map);
    }
}
