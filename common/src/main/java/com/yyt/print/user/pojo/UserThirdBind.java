package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * Created by SomeBody on 2016/9/23.
 */
public class UserThirdBind {
    private int userId;
    private String thirdId;
    private int type;
    private Date createTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserThirdBind{" +
                "userId=" + userId +
                ", thirdId='" + thirdId + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }
}
