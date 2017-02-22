package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.ProductEvaluate;

/**
 * Created by leo on 2016/11/24.
 */
public interface IProductEvaluateDAO{
    int saveProductEvaluate(ProductEvaluate productEvaluate);
    int updateProductEvaluate(ProductEvaluate productEvaluate);
    ProductEvaluate getProductEvaluate(int id);
    int delProductEvaluate(int id);
}
