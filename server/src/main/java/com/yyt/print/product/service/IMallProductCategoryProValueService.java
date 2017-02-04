package com.yyt.print.product.service;

import com.yyt.print.product.pojo.MallProductCategoryProValue;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductCategoryProValueService {
    /**
     * 新建属性值
     * @param categoryProValue
     * @return
     */
    public int saveMallProductCategoryProValue(MallProductCategoryProValue categoryProValue);

    /**
     * 修改属性值
     * @param categoryProValue
     * @return
     */
    public int updateMallProductCategoryProValue(MallProductCategoryProValue categoryProValue);

    /**
     * 删除属性值
     * @param id
     * @return
     */
    public int deleteMallProductCategoryProValue(int id);

    /**
     * 查询一个属性值
     * @param id
     * @return
     */
    public MallProductCategoryProValue getMallProductCategoryProValue(int id);

    /**
     * 查询属性值列表
     * @param classId 分类ID
     * @param classProId 分类属性ID
     * @return
     */
    public List<MallProductCategoryProValue> findMallProductCategoryProValue(int classId, int classProId);
}
