package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserBuyerDAO;
import com.yyt.print.user.pojo.UserBuyer;
import org.springframework.stereotype.Repository;

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
}
