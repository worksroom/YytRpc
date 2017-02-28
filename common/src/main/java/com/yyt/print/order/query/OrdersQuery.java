package com.yyt.print.order.query;

import com.yyt.print.query.BaseQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/28.
 */
public class OrdersQuery extends BaseQuery {
    private int status = -1;

    private int shopId = -1;

    private int buyUserId = -1;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(int buyUserId) {
        this.buyUserId = buyUserId;
    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",this.status);
        map.put("shopId",this.status);
        map.put("buyUserId",this.buyUserId);

        return map;
    }
}
