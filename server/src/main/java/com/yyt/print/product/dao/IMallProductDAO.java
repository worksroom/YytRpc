package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallProduct;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductDAO {


    int saveSaveMallProduct(MallProduct mallProduct);
    /**
     * 添加货品
     * @param list
     * @return
     */
    int batchSaveMallProduct(List<MallProduct> list);

    /**
     * 获取产品
     * @param id
     * @return
     */
    MallProduct getMallProduct(int id);

    /**
     * 查询货品下的商品
     * @param goodsId
     * @return
     */
    List<MallProduct> findMallProducts(int goodsId);

    /**
     * 修改库存
     * @param id
     * @param num
     * @return
     */
    int updateStore(int id,int num);

    /**
     * 修改销售量
     * @param id
     * @return
     */
    int updateSellNum(int id, int num);



}
