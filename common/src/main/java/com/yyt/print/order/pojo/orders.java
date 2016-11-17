package com.yyt.print.order.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 订单表
 */
public class Orders {
    private String id;//订单ID
    private int buyUserId;
    private int sellUserId;
    private int payType;
    private Double totalMoney;
    private Double productMoney;
    private int status;
    private Double fee;
    private String productDesc;
    private String ip;
    private Date payTime;
    private Date createTime;
    private Date updateTime;
    private int addressId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(int buyUserId) {
        this.buyUserId = buyUserId;
    }

    public int getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(int sellUserId) {
        this.sellUserId = sellUserId;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(Double productMoney) {
        this.productMoney = productMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
