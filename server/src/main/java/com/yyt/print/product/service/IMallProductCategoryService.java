package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallProductCategory;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductCategoryService {

    /**
     * 新建商品类别
     * @param category
     * @return
     */
    public int saveMallProductCategory(MallProductCategory category);

    /**
     * 修改商品类别
     * @param category
     * @return
     */
    public int updateMallProductCategory(MallProductCategory category);

    /**
     * 删除商品类别
     * @param id 类别ID
     * @return
     */
    public int deleteMallProductCategory(int id);

    /**
     * 查询商品类别
     * @param id
     * @return
     */
    public MallProductCategory getMallProductCategory(int id);

    /**
     * 获取全部分类
     * @return
     */
    public List<MallProductCategory> queryAllMallProductCategory();

    /**
     * 查询父分类下的子分类列表
     * @param parentId 父节点ID
     * @return
     */
    public List<MallProductCategory> findMallProductCategoryList(int parentId);
}
