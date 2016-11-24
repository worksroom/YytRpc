package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.ShoppingCart;

import java.util.List;

/**
 * Created by leo on 2016/11/21.
 */
public interface IShoppingCartDAO {

    /**
     * 查询购物车商品列表
     * @param userId
     * @return
     */
    public List<ShoppingCart> findShoppingCartList(int userId);

    /**
     * 添加商品到购物车
     * @param shoppingCart
     * @return
     */
    public int saveShoppingCart(ShoppingCart shoppingCart);

    /**
     * 修改购物车中的商品
     * @param shoppingCart
     * @return
     */
    public int updateShoppingCart(ShoppingCart shoppingCart);

    /**
     * 从购物车中移除某个商品
     * @param id
     * @return
     */
    public int deleteShoppingCart(int id);
}
