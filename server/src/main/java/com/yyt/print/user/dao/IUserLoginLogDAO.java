package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.UserLoginLog;

/**
 * Created by leo on 2017/2/7.
 */
public interface IUserLoginLogDAO {
    /**
     * 保存用户登录日志
     * @param userLoginLog
     * @return
     */
    public int saveUserLoginLog(UserLoginLog userLoginLog);
}
