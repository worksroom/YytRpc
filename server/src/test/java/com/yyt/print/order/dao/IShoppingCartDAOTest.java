package com.yyt.print.order.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.order.pojo.ShoppingCart;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/28.
 */
public class IShoppingCartDAOTest  extends BaseTestClass {
    IShoppingCartDAO dao = getBean(IShoppingCartDAO.class);

    private ShoppingCart getShoppingCart(){
        ShoppingCart sc = new ShoppingCart();
        sc.setUserId(224);
        sc.setGoodsId(20);
        sc.setProductId(45);
        sc.setBuyNum(1);
        return sc;
    }


    @Test
    public void saveShoppingCart(){
        dao.saveShoppingCart(getShoppingCart());
    }
}
