package com.yyt.print.user.service;

import com.yyt.print.user.pojo.UserBuyer;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IUserBuyerService {
    public int saveUserBuyer(UserBuyer userBuyer);

    public UserBuyer getUserBuyer(int userId);

    public int updateUserBuyer(UserBuyer userBuyer);
}
