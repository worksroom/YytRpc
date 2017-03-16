package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * 用户
 * Created by SomeBody on 2016/9/22.
 */
public class User {

    public static final int REGIST_WE_CHAT = 1;//微信注册
    public static final int REGIST_QQ = 2;//QQ注册
    public static final int REGIST_SINA_WEIBO = 3;//微博注册
    public static final int REGIST_PHONE = 4;//手机注册
    public static final int REGIST_GENERAL = 5;//普通账号注册

    private int userId;
    private Date createTime;
    private Date updateTime;
    private String userName;
    private String password;
    private String nickName;
    private String email;
    private String phone;
    private String headImg;//头像地址

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
