package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.ShoppingCart;

import java.util.List;

/**
 * Created by lenovo on 2017/2/28.
 */
public interface IShoppingCartDAO{
    int saveShoppingCart(ShoppingCart shoppingCart);
    int updateShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCart(int id);
    int delShoppingCart(int id);

    List<ShoppingCart> findByUser(int uid);
}
