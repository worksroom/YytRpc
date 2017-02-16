package com.yyt.print.product.service;

import com.yyt.print.product.pojo.*;

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
    int shelves(MallGoods mallGoods,List<MallProductSet> list,List<MallProductExt> exts);


    /**
     * 为货品增加新的商品
     * @param goodsId
     * @param list
     * @return
     */
    int goodAddProduct(int goodsId,List<MallProductSet> list,List<MallProductExt> exts);

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





    /**
     * 添加库存为止
     * @param storeLocation
     * @return
     */
    int saveStoreLocation(StoreLocation storeLocation);

    /**
     * 获取库存位置
     * @param id
     * @return
     */
    StoreLocation getStoreLocation(int id);

    /**
     * 删除库存位置
     * @param id
     * @return
     */
    int delStoreLocation(int id);

    /**
     * 修改库存位置
     * @param storeLocation
     * @return
     */
    int updateStoreLocation(StoreLocation storeLocation);

    /**
     * 查询商铺的所有库存位置
     * @param shopId
     * @return
     */
    List<StoreLocation> findStoreLocations(int shopId);


    //=====================运费模板=============================
    int saveFareMould(FareMould fareMould);

    FareMould getFareMould(int id);

    int updateFareMould(FareMould fareMould);

    int delFareMould(int id);

    List<FareMould> findFareMoulds(int shopId);
}
