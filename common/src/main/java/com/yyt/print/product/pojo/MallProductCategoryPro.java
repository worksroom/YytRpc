package com.yyt.print.product.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 商品分类属性表
 */
public class MallProductCategoryPro {
    private int id;// 属性ID
    private String name;
    private int classId;
    /**
     * 1 颜色
     * 2 选择
     * 3 输入
     */
    private int type;
    private int isNeed;
    private int isSearch;
    private int rank;
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsNeed() {
        return isNeed;
    }

    public void setIsNeed(int isNeed) {
        this.isNeed = isNeed;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public int getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(int isSearch) {
        this.isSearch = isSearch;
    }
}
