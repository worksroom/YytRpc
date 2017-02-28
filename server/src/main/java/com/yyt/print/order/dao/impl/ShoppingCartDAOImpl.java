package com.yyt.print.order.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.IShoppingCartDAO;
import com.yyt.print.order.pojo.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/28.
 */
@Repository("shoppingCartDAO")
public class ShoppingCartDAOImpl extends YytBaseDAO<ShoppingCart> implements IShoppingCartDAO {
    @Override
    public int saveShoppingCart(ShoppingCart shoppingCart){return super.insert(shoppingCart);}
    @Override
    public int updateShoppingCart(ShoppingCart shoppingCart){return super.update(shoppingCart);}
    @Override
    public ShoppingCart getShoppingCart(int id){return super.get(id);}
    @Override
    public int delShoppingCart(int id){return super.delete(id);}

    @Override
    public List<ShoppingCart> findByUser(int uid) {
        return super.findBy("selectByUid",uid);
    }
}
