package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallProductDAO;
import com.yyt.print.product.pojo.MallProduct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/14.
 */
@Repository("mallProductDAO")
public class MallProductDAOImpl extends YytBaseDAO<MallProduct> implements IMallProductDAO {

    @Override
    public int saveSaveMallProduct(MallProduct mallProduct) {
        return super.insert(mallProduct);
    }

    @Override
    public int batchSaveMallProduct(List<MallProduct> list) {
        return super.batchInsert(list, "insertList");
    }

    @Override
    public MallProduct getMallProduct(int id) {
        return super.get(id);
    }

    @Override
    public List<MallProduct> findMallProducts(int goodsId) {
        return super.findBy("findByGood",goodsId);
    }

    @Override
    public int updateStore(int id, int num) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("num",num);
        return super.updateBy("updateStore",map);
    }

    @Override
    public int updateSellNum(int id, int num) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("num",num);
        return super.updateBy("updateSellNum",map);
    }
}