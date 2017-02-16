package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.MallGoodsSet;
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
    int shelves(MallGoods mallGoods,List<MallProductSet> list);


    /**
     * 为货品增加新的商品
     * @param goodsId
     * @param list
     * @return
     */
    int goodAddProduct(int goodsId,List<MallProductSet> list);

    /**
     * 获取货品明细
     * @param goodsId
     * @return
     */
    MallGoodsSet getMallGoodsSetByGood(int goodsId);

    /**
     * 获取货品明细
     * @param productId
     * @return
     */
    MallGoodsSet getMallGoodsSetByProduct(int productId);

}
