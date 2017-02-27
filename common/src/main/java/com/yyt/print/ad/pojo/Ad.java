package com.yyt.print.ad.pojo;

import java.util.Date;

/**
 * 广告
 * Created by SomeBody on 2016/9/23.
 */
public class Ad {
    private int id;
    private int adType;
    private String img;//base64编码
    private String des;
    private String url;
    private int used;
    private Date createTime;

    private String adCategoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAdCategoryName() {
        return adCategoryName;
    }

    public void setAdCategoryName(String adCategoryName) {
        this.adCategoryName = adCategoryName;
    }
}
