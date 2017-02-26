package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallProductExtDAO;
import com.yyt.print.product.pojo.MallProductExt;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
@Repository("mallProductExtDAO")
public class MallProductExtDAOImpl extends YytBaseDAO<MallProductExt> implements IMallProductExtDAO {
    @Override
    public int saveMallProductExt(MallProductExt mallProductExt){return super.insert(mallProductExt);}

    @Override
    public int batchSaveMallProductEx(List<MallProductExt> list) {
        return super.batchInsert(list,"insertList");
    }

    @Override
    public int updateMallProductExt(MallProductExt mallProductExt){return super.update(mallProductExt);}
    @Override
    public MallProductExt getMallProductExt(int id){return super.get(id);}
    @Override
    public int delMallProductExt(int id){return super.delete(id);}

    @Override
    public List<MallProductExt> findMallProductExt(int goods) {
        return super.findBy("selectByGoods",goods);
    }

    @Override
    public int delExts(int goodsId) {
        return super.deleteBy("deleteByGoodsId",goodsId);
    }
}
