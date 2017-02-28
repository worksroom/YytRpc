package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallProductSalePro;

import java.util.List;

/**
 * Created by leo on 2016/11/24.
 */
public interface IMallProductSaleProDAO {

    int batchSaveMallProductSalePro(List<MallProductSalePro> list);

    List<MallProductSalePro> findMallProductSalePro(int goods);

    List<MallProductSalePro> findProByProductId(int productId);
}
