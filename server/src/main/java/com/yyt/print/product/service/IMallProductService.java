package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.MallProduct;
import com.yyt.print.product.pojo.MallProductSet;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductService {

    /**
     * 上架货品 ，
     * @param mallGoods
     * @param list  商品以及销售属性集合
     * @return
     */
    public int shelves(MallGoods mallGoods,List<MallProductSet> list);


}
