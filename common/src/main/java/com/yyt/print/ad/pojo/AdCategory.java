package com.yyt.print.ad.pojo;

import java.util.Date;

/**
 * 广告类别
 * Created by SomeBody on 2016/9/23.
 */
public class AdCategory {
    private String id;
    private String name;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AdCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
