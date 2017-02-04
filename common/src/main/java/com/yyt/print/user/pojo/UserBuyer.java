package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * 买家认证
 * Created by SomeBody on 2016/9/23.
 */
public class UserBuyer {
    private int userId;//用户ID
    private String name;//用户姓名
    private String cardNumber;//身份证号码
    private String cardFPhoto;//身份证正面图片地址
    private String cardBPhoto;//身份证反面图片地址
    private String userCardPhoto;//头像照片地址
    private int status;
    private String msg;
    private Date createTime;
    private Date updateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardFPhoto() {
        return cardFPhoto;
    }

    public void setCardFPhoto(String cardFPhoto) {
        this.cardFPhoto = cardFPhoto;
    }

    public String getCardBPhoto() {
        return cardBPhoto;
    }

    public void setCardBPhoto(String cardBPhoto) {
        this.cardBPhoto = cardBPhoto;
    }

    public String getUserCardPhoto() {
        return userCardPhoto;
    }

    public void setUserCardPhoto(String userCardPhoto) {
        this.userCardPhoto = userCardPhoto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        final StringBuilder sb = new StringBuilder("UserBuyer{");
        sb.append("userId=").append(userId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", cardNumber='").append(cardNumber).append('\'');
        sb.append(", cardFPhoto='").append(cardFPhoto).append('\'');
        sb.append(", cardBPhoto='").append(cardBPhoto).append('\'');
        sb.append(", userCardPhoto='").append(userCardPhoto).append('\'');
        sb.append(", status=").append(status);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}
