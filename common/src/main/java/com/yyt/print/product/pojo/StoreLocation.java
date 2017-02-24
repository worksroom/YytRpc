package com.yyt.print.product.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2017/2/16.
 */
public class StoreLocation {
    private int id;
    private int shopId;
    private int fCode;
    private String fName;
    private int sCode;
    private String sName;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getFCode() {
        return fCode;
    }

    public void setFCode(int fCode) {
        this.fCode = fCode;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public int getSCode() {
        return sCode;
    }

    public void setSCode(int sCode) {
        this.sCode = sCode;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
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
