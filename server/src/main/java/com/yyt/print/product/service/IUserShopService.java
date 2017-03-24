package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.query.UserShopQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by leo on 2016/11/23.
 */
public interface IUserShopService {

    /**
     * 查询货品对象
     * @param id
     * @return
     */
    public UserShop getUserShop(int id);

    /**
     * 查询未审核的货品
     * @param query -1 代表查询全部
     * @return
     */
    public PageHolder<UserShop> findUserShops(UserShopQuery query);

    /**
     * 审核货品
     * @param status
     * @return
     */
    int reviewUserShop(int id, boolean status);


    public Map<Integer,UserShop> findUserShopMap(List<Integer> shopIdList);

}
