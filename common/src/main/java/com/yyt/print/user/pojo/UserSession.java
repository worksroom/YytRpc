package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * Created by leo on 2017/2/7.
 */
public class UserSession {

    /**
     * session过期时间
     */
    public static final int EXPIRE_DAYS = 7;

    private int id;
    private int userId;
    private String session;
    private Date createTime;
    private Date expireTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
