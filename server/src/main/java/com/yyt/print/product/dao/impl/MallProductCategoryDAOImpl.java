package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallProductCategoryDAO;
import com.yyt.print.product.pojo.MallProductCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/12/20.
 */
public class MallProductCategoryDAOImpl extends YytBaseDAO<MallProductCategory> implements IMallProductCategoryDAO{

    @Override
    public int saveMallProductCategory(MallProductCategory mallProductCategory) {
        return super.insert(mallProductCategory);
    }

    @Override
    public int updateMallProductCategory(MallProductCategory mallProductCategory) {
        return super.update(mallProductCategory);
    }

    @Override
    public List<MallProductCategory> queryCategoryByParentId(int parentId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("parentId",parentId);
        return super.findBy("selectByParentId",map);
    }


}
