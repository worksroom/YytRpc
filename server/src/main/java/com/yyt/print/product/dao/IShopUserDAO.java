package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.ShopUser;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
public interface IShopUserDAO{
    int saveShopUser(ShopUser shopUser);
    int updateShopUser(ShopUser shopUser);
    ShopUser getShopUser(int id);
    int delShopUser(int id);

    /**
     * 查询用户的shopId
     * @param userId
     * @return
     */
    ShopUser getShopIdFromUid(int userId);

    ShopUser getCreateShopUid(int shopId);

    List<ShopUser> findShopUids(int shopId);

}
