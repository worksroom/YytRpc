package com.yyt.print.user.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserBuyerDAO;
import com.yyt.print.user.pojo.UserBuyer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Repository
public class UserBuyerDAO extends YytBaseDAO<UserBuyer> implements IUserBuyerDAO {
    @Override
    public int saveUserBuyer(UserBuyer userBuyer) {
        return this.insert(userBuyer);
    }

    @Override
    public UserBuyer getUserBuyer(int userId) {
        return this.findUniqueBy("findUserBuyerByUserId", userId);
    }

    @Override
    public int updateUserBuyer(UserBuyer userBuyer) {
        return this.update(userBuyer);
    }

    @Override
    public PageHolder<UserBuyer> queryUserBuyerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) {
        HashMap<String, Object> map = new HashMap();
        map.put("userId", userId);
        map.put("userName", userName);
        map.put("nickName", nickName);
        map.put("phone", phone);
        map.put("cardNumber", cardNumber);
        map.put("name", name);
        return this.pagedQuery("queryUserBuyerByPage", map, pageIndex, pageSize);
    }
}
