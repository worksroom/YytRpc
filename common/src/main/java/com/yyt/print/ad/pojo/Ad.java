package com.yyt.print.ad.pojo;

import java.util.Date;

/**
 * 广告
 * Created by SomeBody on 2016/9/23.
 */
public class Ad {
    private int id;
    private String adType;
    private String img;//base64编码
    private String des;
    private String url;
    private int used;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
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
}
