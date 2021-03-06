package com.yyt.print.order.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 收藏的店铺
 */
public class CollectShop {
    private int id;
    private int userId;
    private int sellUserId;
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

    public int getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(int sellUserId) {
        this.sellUserId = sellUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
