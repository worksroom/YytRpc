package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallProductSaleProDAO;
import com.yyt.print.product.pojo.MallProductSalePro;

import java.util.List;

/**
 * Created by lenovo on 2017/2/14.
 */
public class MallProductSaleProDAOImpl extends YytBaseDAO<MallProductSalePro> implements IMallProductSaleProDAO {
    @Override
    public int batchSaveMallProductSalePro(List<MallProductSalePro> list) {
        return super.batchInsert(list,"insertList");
    }

    @Override
    public List<MallProductSalePro> findMallProductSalePro(int goods) {
        return super.findBy("findByGood",goods);
    }
}
