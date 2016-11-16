package com.yyt.print.friend.pojo;

import java.util.Date;

/**
 * 聊天记录
 * Created by SomeBody on 2016/9/23.
 */
public class ChatRecord {
    private int id;
    private int sessionId;
    private int userId;
    private String content;
    private Date createTime;
    private int type;//聊天内容类型：扩展使用
    private int pushType;//是否已推送：0-未推送，1-已推送

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPushType() {
        return pushType;
    }

    public void setPushType(int pushType) {
        this.pushType = pushType;
    }
}
