package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IShopUserDAO;
import com.yyt.print.product.pojo.ShopUser;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */
@Repository("shopUserDAO")
public class ShopUserDAOImpl extends YytBaseDAO<ShopUser> implements IShopUserDAO {
    @Override
    public int saveShopUser(ShopUser shopUser){
        shopUser.setCreateTime(new Date());
        if(shopUser.getType()==0){
            shopUser.setType(2);
        }
        return super.insert(shopUser);
    }
    @Override
    public int updateShopUser(ShopUser shopUser){return super.update(shopUser);}
    @Override
    public ShopUser getShopUser(int id){return super.get(id);}
    @Override
    public int delShopUser(int id){return super.delete(id);}

    @Override
    public ShopUser getShopIdFromUid(int userId) {
        return super.findUniqueBy("selectByUid",userId);
    }

    @Override
    public ShopUser getCreateShopUid(int shopId) {
        return super.findUniqueBy("selectCreate",shopId);
    }

    @Override
    public List<ShopUser> findShopUids(int shopId) {
        return super.findBy("selectByShopId",shopId);
    }
}
