package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.StoreLocation;

import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
public interface IStoreLocationDAO {
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
}
