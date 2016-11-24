package com.yyt.print.product.service;

import com.yyt.print.product.pojo.MallGoods;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallGoodsService {

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
     * 根据分类ID查询货品列表
     * @param classId
     * @return
     */
    public List<MallGoods> findMallGoods(int classId);

}
