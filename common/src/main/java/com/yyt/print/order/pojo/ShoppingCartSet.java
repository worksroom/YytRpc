package com.yyt.print.order.pojo;


import com.yyt.print.product.pojo.MallProductSet;

/**
 * Created by leo on 2016/11/17.
 * 购物车
 */
public class ShoppingCartSet {
    private ShoppingCart shoppingCart;

    private MallProductSet productset;

    public MallProductSet getProductset() {
        return productset;
    }

    public void setProductset(MallProductSet productset) {
        this.productset = productset;
    }

    public ShoppingCart getShoppingCart() {

        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
