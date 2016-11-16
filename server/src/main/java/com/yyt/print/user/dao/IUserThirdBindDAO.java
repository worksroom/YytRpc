package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.UserThirdBind;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserThirdBindDAO {
    public int saveUserThirdBind(UserThirdBind thirdBind);

    public UserThirdBind getUserThirdBind(String thirdId, int type);
}
