package com.yyt.print.friend.pojo;

import java.util.Date;

/**
 * 聊天会话
 * Created by SomeBody on 2016/9/23.
 */
public class ChatSession {
    private int id;
    private int userId;
    private int friendId;
    private Date createTime;
    private Date lastTime;
    private String lastContent;
    private int lastUid;

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

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastContent() {
        return lastContent;
    }

    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }

    public int getLastUid() {
        return lastUid;
    }

    public void setLastUid(int lastUid) {
        this.lastUid = lastUid;
    }
}
