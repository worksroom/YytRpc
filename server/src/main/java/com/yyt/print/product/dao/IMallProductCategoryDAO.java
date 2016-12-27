package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallProductCategory;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductCategoryDAO {
    /**
     * 新建分类
     * @param mallProductCategory
     * @return
     */
    int saveMallProductCategory(MallProductCategory mallProductCategory);

    /**
     * 修改分类
     * @param mallProductCategory
     * @return
     */
    int updateMallProductCategory(MallProductCategory mallProductCategory);

    /**
     * 通过parentId查询产品分类
     * @param parentId
     * @return
     */
    List<MallProductCategory> queryCategoryByParentId(int parentId);

    //TODO 管理平台需要的数据
}
