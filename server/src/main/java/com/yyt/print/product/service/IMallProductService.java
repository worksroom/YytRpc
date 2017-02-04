package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallProduct;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductService {

    /**
     * 新建商品
     * @param mallProduct
     * @return
     */
    public int saveMallProduct(MallProduct mallProduct);

    /**
     * 修改商品
     * @param mallProduct
     * @return
     */
    public int updateMallProduct(MallProduct mallProduct);

    /**
     * 删除商品
     * @param id
     * @return
     */
    public int deleteMallProduct(int id);

    /**
     * 查询商品
     * @param id
     * @return
     */
    public MallProduct getMallProduct(int id);

    /**
     * 分页查询，仅限管理后台调用
     * @param sellUserId
     * @param classId
     * @param goodsId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageHolder<MallProduct> queryMallProduct(int sellUserId, int classId, int goodsId, int pageIndex, int pageSize);

    /**
     * 修改销量计数
     * @param id 商品ID
     * @param num 卖出数量
     * @return
     */
    public int updateSaleNum(int id, int num);

    /**
     * 修改库存数量
     * @param id 商品ID
     * @param num 库存变化量，卖出时，num为负数；进货时num为正数。
     * @return
     */
    public int updateStoreNum(int id, int num);
}
