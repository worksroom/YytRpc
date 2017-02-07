package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallProductCategoryProValue;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductCategoryProValueDAO {
    /**
     * 批量增加属性
     * @param list
     * @return
     */
    int batchSaveMallProductCategoryProValue(List<MallProductCategoryProValue> list);


    /**
     * 根据分类查询所有的属性
     * @param classId
     * @return
     */
    List<MallProductCategoryProValue> findByClass(int classId);


    /**
     * 根据分类查询所有的属性
     * @param proId
     * @return
     */
    List<MallProductCategoryProValue> findByPro(int proId);
}
