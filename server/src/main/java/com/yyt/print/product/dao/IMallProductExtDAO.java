package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.MallProductExt;

import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
public interface IMallProductExtDAO{
    int saveMallProductExt(MallProductExt mallProductExt);

    int batchSaveMallProductEx(List<MallProductExt> list);

    int updateMallProductExt(MallProductExt mallProductExt);
    MallProductExt getMallProductExt(int id);
    int delMallProductExt(int id);

    /**
     * 货品id查询
     * @param goods
     * @return
     */
    List<MallProductExt> findMallProductExt(int goods);
}
