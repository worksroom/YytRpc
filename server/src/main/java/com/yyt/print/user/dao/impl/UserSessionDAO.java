package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserSessionDAO;
import com.yyt.print.user.pojo.UserSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by leo on 2017/2/7.
 */
@Repository
public class UserSessionDAO extends YytBaseDAO<UserSession> implements IUserSessionDAO {

    @Override
    public int saveUserSession(int userId, String session) {
        UserSession userSession = new UserSession();
        Date now = new Date();
        userSession.setCreateTime(now);
        userSession.setSession(session);
        userSession.setUserId(userId);

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_MONTH, UserSession.EXPIRE_DAYS);
        userSession.setExpireTime(cal.getTime());
        return this.insert(userSession);
    }

    @Override
    public String getSession(int userId) {
        return this.findUniqueBy("getSession", userId);
    }

    @Override
    public String genSession(int userId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = dateFormat.format(new Date());
        return date+userId;
    }
}
