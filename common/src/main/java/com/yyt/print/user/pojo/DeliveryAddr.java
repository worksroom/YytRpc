package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 收货地址
 */
public class DeliveryAddr {
    private int id;
    private int userId;//用户ID
    private String name;//收货人姓名
    private String phone;//手机号
    private String tel;//固定电话
    private String region;//所在地区
    private String street;//街道
    private String addr;//详细地址
    private String code;//邮政编码
    private Date createTime;
    private Date updateTime;
    private int defaultAddr;//是否为默认收货地址，1-是；0-否

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(int defaultAddr) {
        this.defaultAddr = defaultAddr;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
