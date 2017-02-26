package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallGoodBaseProDAO;
import com.yyt.print.product.pojo.MallGoodBasePro;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/26.
 */
@Repository("mallGoodBaseProDAO")
public class MallGoodBaseProDAOImpl extends YytBaseDAO<MallGoodBasePro> implements IMallGoodBaseProDAO {
    @Override
    public int saveMallGoodBasePro(MallGoodBasePro mallGoodBasePro){return super.insert(mallGoodBasePro);}
    @Override
    public int updateMallGoodBasePro(MallGoodBasePro mallGoodBasePro){return super.update(mallGoodBasePro);}
    @Override
    public MallGoodBasePro getMallGoodBasePro(int id){return super.get(id);}
    @Override
    public int delMallGoodBasePro(int id){return super.delete(id);}

    @Override
    public int batchSaveMallGoodBasePro(List<MallGoodBasePro> mallGoodBasePro) {
        return super.batchInsert(mallGoodBasePro,"insertList");
    }

    @Override
    public int delPros(int goodsId) {
        return super.deleteBy("deleteByGoodsId",goodsId);
    }

    @Override
    public List<MallGoodBasePro> findByGoodsId(int goodsId) {
        return super.findBy("selectByGoodsId",goodsId);
    }
}