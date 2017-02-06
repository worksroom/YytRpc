package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * Created by SomeBody on 2016/9/23.
 */
public class UserThirdBind {
    private int userId;//用户ID
    private String thirdId;//第三方用户唯一ID
    private int type;//第三方类型
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
