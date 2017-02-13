package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.query.UserShopQuery;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lenovo on 2017/2/12.
 */
public class IUserShopDAOTest extends BaseTestClass {
    IUserShopDAO dao = getBean(IUserShopDAO.class);
    private UserShop getBean(){
        UserShop shop = new UserShop();
        shop.setName("leo小店");
        shop.setStatus(0);
        shop.setCreateTime(new Date());
        shop.setMainProduct("买衣服的");
        shop.setSellUserId(12);
        return shop;
    }

    @Test
    public void testSaveMallGoods(){
        dao.saveUserShop(getBean());
    }

    @Test
    public void testUpdateMallGoods(){
        UserShop shop = this.getBean();
        shop.setId(1);
        shop.setName("他的小店");
        dao.updateUserShop(shop);
    }

    @Test
    public void testGetMallGoods(){
        System.out.println(dao.getUserShop(1));
    }

    @Test
    public void findMallGoods(){
        UserShopQuery query = new UserShopQuery();
        query.setName("他的小店");
        System.out.println(dao.findUserShops(query).size());
    }

    @Test
    public void testUpdateStatus(){
        dao.reviewUserShop(1,false);
    }
}
