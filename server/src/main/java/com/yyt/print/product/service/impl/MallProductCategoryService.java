package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallProductCategory;
import com.yyt.print.product.service.IMallProductCategoryService;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public class MallProductCategoryService implements IMallProductCategoryService {
    @Override
    public int saveMallProductCategory(MallProductCategory category) {
        return 0;
    }

    @Override
    public int updateMallProductCategory(MallProductCategory category) {
        return 0;
    }

    @Override
    public int deleteMallProductCategory(int id) {
        return 0;
    }

    @Override
    public MallProductCategory getMallProductCategory(int id) {
        return null;
    }

    @Override
    public PageHolder<MallProductCategory> queryMallProductCategory(int id, int parentId, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public List<MallProductCategory> findMallProductCategoryList(int parentId, int level) {
        return null;
    }
}
