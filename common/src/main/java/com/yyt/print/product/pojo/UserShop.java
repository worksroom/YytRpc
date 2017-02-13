package com.yyt.print.product.pojo;

import java.util.Date;

/**
 *
 * 店铺表
 */
public class UserShop {
    private int id;
    private int sellUserId;
    private String name;
    private String mainProduct;
    /**
     * 0 待审核
     * 1 已发布
     */
    private int status;
    private Date createTime;
    private Date updateTime;
    private String logo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(int sellUserId) {
        this.sellUserId = sellUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

