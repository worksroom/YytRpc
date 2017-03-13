package com.yyt.print.product.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.UserShopQuery;

import java.util.List;

/**
 * Created by lenovo on 2017/2/12.
 */
public interface IUserShopDAO {
    /**
     * 新建店铺
     * @param shop
     * @return
     */
    public int saveUserShop(UserShop shop);

    /**
     * 修改店铺
     * @param shop
     * @return
     */
    public int updateUserShop(UserShop shop);

    /**
     * 删除店铺
     * @param id
     * @return
     */
    public int deleteUserShop(int id);

    /**
     * 查询店铺对象
     * @param id
     * @return
     */
    public UserShop getUserShop(int id);

    /**
     * 查询未审核的店铺
     * @param query 查询条件
     * @return
     */
    public PageHolder<UserShop> findUserShops(UserShopQuery query);

    /**
     * 店铺审核
     * @param id
     * @param status
     * @return
     */
    public int reviewUserShop(int id,boolean status);

    /**
     * 查询用户收藏的店铺
     * @param uid
     * @return
     */
    List<UserShop> findCollectShop(int uid,int pageIndex,int pageSize);
}
