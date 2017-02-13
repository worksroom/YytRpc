package com.yyt.print.product.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IUserShopDAO;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.UserShopQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/12.
 */
@Repository("userShopDAO")
public class UserShopDAOImpl extends YytBaseDAO<UserShop> implements IUserShopDAO {
    @Override
    public int saveUserShop(UserShop shop) {
        shop.setCreateTime(new Date());
        return super.insert(shop);
    }

    @Override
    public int updateUserShop(UserShop shop) {
        shop.setUpdateTime(new Date());
        return super.update(shop);
    }

    @Override
    public int deleteUserShop(int id) {
        return super.delete(id);
    }

    @Override
    public UserShop getUserShop(int id) {
        return super.get(id);
    }

    @Override
    public PageHolder<UserShop> findUserShops(UserShopQuery query) {
        return super.pagedQuery("findByParams",query.getMap(),query.getPageIndex(),query.getPageSize());

    }

    @Override
    public int reviewUserShop(int id, boolean status) {
        int value = 99;
        if(status){
            value = 1;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",value);

        return super.updateBy("updateStatus",map);
    }
}
