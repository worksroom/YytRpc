package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserSellerDAO;
import com.yyt.print.user.pojo.UserSeller;
import org.springframework.stereotype.Repository;

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
}
