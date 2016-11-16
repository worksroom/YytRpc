package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * 卖家认证
 * Created by SomeBody on 2016/9/23.
 */
public class UserSeller {
    private int userId;
    private String cardNumber;
    private String cardFPhoto;
    private String cardBPhoto;
    private String userCardPhoto;
    private String licencePhone;
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

    public String getLicencePhone() {
        return licencePhone;
    }

    public void setLicencePhone(String licencePhone) {
        this.licencePhone = licencePhone;
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
}
