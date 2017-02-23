package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.ShopUser;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/23.
 */
public class IShopUserDAOTest extends BaseTestClass {
    IShopUserDAO dao = getBean(IShopUserDAO.class);

    private ShopUser getShopUser(){
        ShopUser su = new ShopUser();
        su.setUserId(2);
        su.setShopId(1);
        su.setType(2);
        return su;
    }

    @Test
    public void saveShopUser(){
        dao.saveShopUser(getShopUser());
    }

    @Test
    public void getShopIdFromUid(){
        System.out.println(dao.getShopIdFromUid(2));
    }

    @Test
    public void getCreateShopUid(){
        System.out.println(dao.getCreateShopUid(1));
    }

    @Test
    public void findShopUids(){
        System.out.println(dao.findShopUids(1));
    }
}
