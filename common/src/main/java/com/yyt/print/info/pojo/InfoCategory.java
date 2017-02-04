package com.yyt.print.info.pojo;

import java.util.Date;

/**
 * 资讯类别
 * Created by SomeBody on 2016/9/23.
 */
public class InfoCategory {
    private int id;
    private String name;
    private int parentId;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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
        return "InfoCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
