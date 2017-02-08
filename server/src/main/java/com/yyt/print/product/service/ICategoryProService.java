package com.yyt.print.product.service;

import com.youguu.core.pojo.Response;
import com.yyt.print.product.pojo.CategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryProValue;

import java.util.List;

/**
 * Created by lenovo on 2017/2/7.
 */
public interface ICategoryProService {
    /**
     * 通过分类id查询分类属性和值
     * @param classId
     * @return
     */
    List<CategoryPro> findProValueByClassId(int classId);

    /**
     * 添加属性和属性值
     * @param classId
     * @param pro
     * @param values
     * @return
     */
    int addProAndValues(int classId,MallProductCategoryPro pro,List<MallProductCategoryProValue> values);

    /**
     * 通过分类id查询分类属性
     * @param classId
     * @return
     */
    List<MallProductCategoryPro> findProByClassId(int classId);

    /**
     * 通过分类属性id查询分类属性值
     * @param proId
     * @return
     */
    List<MallProductCategoryProValue> findProValueByProId(int proId);

    /**
     * 增加分类属性
     * @param pro
     * @return
     */
    int addPro(MallProductCategoryPro pro);

    /**
     * 增加分类属性值
     * @param values
     * @return
     */
    int addProValue(List<MallProductCategoryProValue> values);

    /**
     * 修改分类属性
     * @param pro
     * @return
     */
    int modifyPro(MallProductCategoryPro pro);

    /**
     * 修改分类属性值
     * @param value
     * @return
     */
    int modifyProValue(MallProductCategoryProValue value);

    /**
     * 批量删除分类属性
     * @param list
     * @return
     */
    Response<String> delPros(List<Integer> list);

    /**
     * 批量删除分类属性值
     * @param list
     * @return
     */
    Response<String> delProValues(List<Integer> list);

}
