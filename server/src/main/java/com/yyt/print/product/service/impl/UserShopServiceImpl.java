package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.dao.IShopUserDAO;
import com.yyt.print.product.dao.IUserShopDAO;
import com.yyt.print.product.pojo.ShopUser;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.UserShopQuery;
import com.yyt.print.product.service.IUserShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/13.
 */
@Service("userShopService")
public class UserShopServiceImpl implements IUserShopService {
    @Resource
    private IUserShopDAO userShopDAO;

    @Resource
    private IShopUserDAO shopUserDAO;

    @Override
    public UserShop getUserShop(int id) {
        return userShopDAO.getUserShop(id);
    }

    @Override
    public PageHolder<UserShop> findUserShops(UserShopQuery query) {
        return userShopDAO.findUserShops(query);
    }

    @Transactional
    @Override
    public int reviewUserShop(int id, boolean status) {
        if(status){
            UserShop shop = userShopDAO.getUserShop(id);
            ShopUser su = shopUserDAO.getShopIdFromUid(shop.getSellUserId());
            if(su==null){
                su = new ShopUser();
                su.setShopId(id);
                su.setType(1);
                su.setUserId(shop.getSellUserId());
                shopUserDAO.saveShopUser(su);
            }
        }
        return userShopDAO.reviewUserShop(id,status);
    }

    @Override
    public Map<Integer, UserShop> findUserShopMap(List<Integer> shopIdList) {
        return userShopDAO.findUserShopMap(shopIdList);
    }
}
