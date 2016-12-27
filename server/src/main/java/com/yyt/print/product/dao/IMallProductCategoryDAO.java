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
     * 删除类别
     * @param id
     * @return
     */
    int deleteMallProductCategory(int id);

    /**
     * 获取类别
     * @param id
     * @return
     */
    MallProductCategory getMallProductCategory(int id);

    /**
     * 通过parentId查询产品分类
     * @param parentId
     * @return
     */
    List<MallProductCategory> queryCategoryByParentId(int parentId);

    // 管理平台需要的数据

    /**
     * 获取全部数据
     * @return
     */
    List<MallProductCategory> queryAllCategory();
}
