package com.yyt.print.order.dao.impl;

import com.yyt.print.order.dao.IShoppingCartDAO;
import com.yyt.print.order.pojo.ShoppingCart;

import java.util.List;

/**
 * Created by leo on 2016/11/21.
 */
public class ShoppingCartDAO implements IShoppingCartDAO {
    @Override
    public List<ShoppingCart> findShoppingCartList(int userId) {
        return null;
    }

    @Override
    public int saveShoppingCart(ShoppingCart shoppingCart) {
        return 0;
    }

    @Override
    public int updateShoppingCart(ShoppingCart shoppingCart) {
        return 0;
    }

    @Override
    public int deleteShoppingCart(int id) {
        return 0;
    }
}
