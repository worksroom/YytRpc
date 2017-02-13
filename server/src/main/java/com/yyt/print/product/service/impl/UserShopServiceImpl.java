package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.dao.IUserShopDAO;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.UserShopQuery;
import com.yyt.print.product.service.IUserShopService;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/2/13.
 */
public class UserShopServiceImpl implements IUserShopService {
    @Resource
    private IUserShopDAO userShopDAO;

    @Override
    public UserShop getUserShop(int id) {
        return userShopDAO.getUserShop(id);
    }

    @Override
    public PageHolder<UserShop> findUserShops(UserShopQuery query) {
        return userShopDAO.findUserShops(query);
    }

    @Override
    public int reviewUserShop(int id, boolean status) {
        return userShopDAO.reviewUserShop(id,status);
    }
}
