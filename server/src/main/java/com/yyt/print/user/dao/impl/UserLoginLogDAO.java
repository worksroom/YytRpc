package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserLoginLogDAO;
import com.yyt.print.user.pojo.UserLoginLog;
import org.springframework.stereotype.Repository;

/**
 * Created by leo on 2017/2/7.
 */
@Repository
public class UserLoginLogDAO extends YytBaseDAO<UserLoginLog> implements IUserLoginLogDAO {
    @Override
    public int saveUserLoginLog(UserLoginLog userLoginLog) {
        return this.insert(userLoginLog);
    }
}
