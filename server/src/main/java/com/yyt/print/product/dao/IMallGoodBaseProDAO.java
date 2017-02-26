package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallGoodBasePro;

import java.util.List;

/**
 * Created by lenovo on 2017/2/26.
 */
public interface IMallGoodBaseProDAO{
    int batchSaveMallGoodBasePro(List<MallGoodBasePro> mallGoodBasePro);
    int saveMallGoodBasePro(MallGoodBasePro mallGoodBasePro);
    int updateMallGoodBasePro(MallGoodBasePro mallGoodBasePro);
    MallGoodBasePro getMallGoodBasePro(int id);
    int delMallGoodBasePro(int id);

    int delPros(int goodsId);

    /**
     * 获取货品的基本属性
     * @param goodsId
     * @return
     */
    List<MallGoodBasePro> findByGoodsId(int goodsId);
}

