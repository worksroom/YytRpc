package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.UserSeller;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserSellerDAO {
    public int saveUserSeller(UserSeller userSeller);

    public UserSeller getUserSeller(int userId);

    public int updateUserSeller(UserSeller userSeller);
}
