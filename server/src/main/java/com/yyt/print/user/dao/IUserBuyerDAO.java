package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.UserBuyer;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserBuyerDAO {
    public int saveUserBuyer(UserBuyer userBuyer);

    public UserBuyer getUserBuyer(int userId);

    public int updateUserBuyer(UserBuyer userBuyer);
}
