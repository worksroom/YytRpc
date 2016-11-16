package com.yyt.print.user.service;

import com.yyt.print.user.pojo.UserSeller;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IUserSellerService {
    public int saveUserSeller(UserSeller userSeller);

    public UserSeller getUserSeller(int userId);

    public int updateUserSeller(UserSeller userSeller);
}
