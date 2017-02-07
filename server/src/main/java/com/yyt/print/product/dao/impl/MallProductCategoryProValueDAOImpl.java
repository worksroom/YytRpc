package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallProductCategoryProValueDAO;
import com.yyt.print.product.pojo.MallProductCategoryProValue;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/4.
 */
@Repository("mallProductCategoryProValueDAO")
public class MallProductCategoryProValueDAOImpl extends YytBaseDAO<MallProductCategoryProValue> implements IMallProductCategoryProValueDAO {
    @Override
    public List<MallProductCategoryProValue> findByClass(int classId) {
        return super.findBy("findByClass",classId);
    }

    @Override
    public int batchSaveMallProductCategoryProValue(List<MallProductCategoryProValue> list) {
        return super.batchInsert(list,"insertList");
    }

    @Override
    public List<MallProductCategoryProValue> findByPro(int proId) {
        return super.findBy("findByPro", proId);
    }
}
