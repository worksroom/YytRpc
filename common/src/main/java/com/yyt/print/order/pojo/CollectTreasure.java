package com.yyt.print.order.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 收藏的宝贝
 */
public class CollectTreasure {
    private int id;
    private int userId;
    private int goodsId;
    private Date createTime;

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

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
