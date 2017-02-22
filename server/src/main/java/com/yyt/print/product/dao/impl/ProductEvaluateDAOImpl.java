package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IProductEvaluateDAO;
import com.yyt.print.product.pojo.ProductEvaluate;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/2/22.
 */
@Repository("productEvaluateDAO")
public class ProductEvaluateDAOImpl extends YytBaseDAO<ProductEvaluate> implements IProductEvaluateDAO {
    @Override
    public int saveProductEvaluate(ProductEvaluate productEvaluate){return super.insert(productEvaluate);}
    @Override
    public int updateProductEvaluate(ProductEvaluate productEvaluate){return super.update(productEvaluate);}
    @Override
    public ProductEvaluate getProductEvaluate(int id){return super.get(id);}
    @Override
    public int delProductEvaluate(int id){return super.delete(id);}
}
