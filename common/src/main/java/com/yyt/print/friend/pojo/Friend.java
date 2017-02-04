package com.yyt.print.friend.pojo;

import java.util.Date;

/**
 * 好友关系
 * Created by SomeBody on 2016/9/23.
 */
public class Friend {
    private int userId;
    private int friendId;
    private Date createTime;
    private Date updateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
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

    @Override
    public String toString() {
        return "Friend{" +
                "userId=" + userId +
                ", friendId=" + friendId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
