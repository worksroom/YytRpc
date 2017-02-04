package com.yyt.print.product.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 商品分类表
 */
public class MallProductCategory {
    private int id;
    private String name;
    private String des;
    private int rank;
    /**
     * -1表示1级分类
     */
    private int parentId = -1;
    private int isEnd;
    private String logo;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(int isEnd) {
        this.isEnd = isEnd;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
