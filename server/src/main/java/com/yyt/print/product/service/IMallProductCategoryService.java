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
     * 分页查询，仅限管理后台调用此方法
     * @param id
     * @param parentId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageHolder<MallProductCategory> queryMallProductCategory(int id, int parentId, int pageIndex, int pageSize);

    /**
     * 查询父分类下的子分类列表
     * @param parentId 父节点ID
     * @param level 子节点层级数，-1表示查询全部层级的子节点
     * @return
     */
    public List<MallProductCategory> findMallProductCategoryList(int parentId, int level);
}
