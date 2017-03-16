package com.yyt.print.user.service;

import com.yyt.print.user.pojo.UserThirdBind;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IUserThirdBindService {

    public int saveUserThirdBind(UserThirdBind thirdBind);

    public UserThirdBind getUserThirdBind(String thirdId, int type);

    public UserThirdBind getUserThirdBind(int userId, int type);
}
