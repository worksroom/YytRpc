package com.yyt.print.product.service;

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

}
