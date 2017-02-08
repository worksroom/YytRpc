package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * Created by leo on 2017/2/7.
 */
public class UserLoginLog {
    private int id;
    private int userId;
    private Date lastTime;
    private String ip;
    /**
     * 1-微信注册，2-QQ注册，3-微博注册，4-手机注册，5-普通账号注册
     */
    private int type;

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

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
