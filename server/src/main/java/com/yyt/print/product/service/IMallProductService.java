package com.yyt.print.product.service;

import com.yyt.print.product.pojo.*;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductService {

    /**
     * 上架货品 ，
     * @param goodsSet
     * @return
     */
    int shelves(MallGoodsSet goodsSet);


    /**
     * 修改货品 ， 包括基本属性  新增sku 修改货运信息等
     * @param goodsSet
     * @return
     */
    int goodAddProduct(MallGoodsSet goodsSet);

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


    MallProductSet getMallProductSet(int productId);


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

    /**
     * 店铺设置用户
     * @param shopUser
     * @return
     */
    int addShopUser(ShopUser shopUser);

    /**
     * 获取用户的店铺id
     * @param uid
     * @return
     */
    ShopUser getShopIdFromUid(int uid);

    /**
     * 获取店铺的创建者
     * @param shopId
     * @return
     */
    ShopUser getCreateShopUid(int shopId);

    /**
     * 获取店铺的所有员工
     * @param shopId
     * @return
     */
    List<ShopUser> findShopUids(int shopId);

    /**
     * 修改sku基本属性(价格 和 库存)
     * @param mallProduct
     * @return
     */
    int updateSku(MallProduct mallProduct);

}
