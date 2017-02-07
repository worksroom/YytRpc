package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallProductCategoryPro;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductCategoryProDAO {

    /**
     * 增加属性
     * @return
     */
    int saveMallProductCategoryPro(MallProductCategoryPro pro);

    int updateMallProductCategoryPro(MallProductCategoryPro pro);

    List<MallProductCategoryPro> findByClass(int classId);

    int deleteMallProductCategoryPro(int id);


}
