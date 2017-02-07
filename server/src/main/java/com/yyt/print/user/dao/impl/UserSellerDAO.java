package com.yyt.print.user.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserSellerDAO;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Repository
public class UserSellerDAO extends YytBaseDAO<UserSeller> implements IUserSellerDAO {

    @Override
    public int saveUserSeller(UserSeller userSeller) {
        return this.insert(userSeller);
    }

    @Override
    public UserSeller getUserSeller(int userId) {
        return this.findUniqueBy("findUserBuyerByUserId", userId);
    }

    @Override
    public int updateUserSeller(UserSeller userSeller) {
        return this.update(userSeller);
    }

    @Override
    public PageHolder<UserSeller> queryUserSellerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) {
        HashMap<String, Object> map = new HashMap();
        map.put("userId", userId);
        map.put("userName", userName);
        map.put("nickName", nickName);
        map.put("phone", phone);
        map.put("cardNumber", cardNumber);
        map.put("name", name);
        return this.pagedQuery("queryUserSellerByPage", map, pageIndex, pageSize);
    }
}
