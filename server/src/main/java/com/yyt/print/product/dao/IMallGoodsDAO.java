package com.yyt.print.product.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.query.MallGoodsQuery;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallGoodsDAO {
    /**
     * 新建货品
     * @param goods
     * @return
     */
    public int saveMallGoods(MallGoods goods);

    /**
     * 修改货品
     * @param goods
     * @return
     */
    public int updateMallGoods(MallGoods goods);

    /**
     * 删除货品
     * @param id
     * @return
     */
    public int deleteMallGoods(int id);

    /**
     * 查询货品对象
     * @param id
     * @return
     */
    public MallGoods getMallGoods(int id);

    /**
     * 查询未审核的货品
     * @param query 查询条件
     * @return
     */
    public PageHolder<MallGoods> findMallGoods(MallGoodsQuery query);

    /**
     * 货品审核
     * @param status
     * @return
     */
    public int reviewMallGoods(int id,boolean status);
}
