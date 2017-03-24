package com.yyt.print.product.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IUserShopDAO;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.product.query.UserShopQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<UserShop> findCollectShop(int uid,int pageIndex,int pageSize) {
        PageHolder<UserShop> list = super.rawPagedQuery(super.getSqlStatementName("findCollectShop"), uid, pageIndex,pageSize, false);
        return list.getList();
    }

    @Override
    public Map<Integer, UserShop> findUserShopMap(List<Integer> shopIdList) {
        Map<Integer, UserShop> map = new HashMap<>();
        List<UserShop> list = super.findBy("findUserShopMap", shopIdList);
        if(list!=null && !list.isEmpty()){
            for(UserShop userShop : list){
                map.put(userShop.getId(), userShop);
            }
        }
        return map;
    }
}
