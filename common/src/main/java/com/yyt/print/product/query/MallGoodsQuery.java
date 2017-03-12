package com.yyt.print.product.query;

import com.yyt.print.query.BaseQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/12.
 */
public class MallGoodsQuery extends BaseQuery {
    /**
     * -1 全部
     * 0 待审
     * 1 审核通过
     * 99 审核未通过
     */
    private int status = -1;
    private String name;
    private String shopName;
    private Integer classId;
    private Integer shopId;
    //排序字段
    private String order;

    //是否需要总记录数
    private boolean needCount = true;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isNeedCount() {
        return needCount;
    }

    public void setNeedCount(boolean needCount) {
        this.needCount = needCount;
    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",this.status);
        if(this.name!=null){
            map.put("name",this.name);
        }
        if(this.shopName!=null){
            map.put("shopName",shopName);
        }
        if(this.classId!=null){
            map.put("classId",classId);
        }

        if(this.shopId!=null){
            map.put("shopId",shopId);
        }
        if(this.order!=null){
            map.put("order",this.order);
        }else{
            map.put("order","create_time desc");
        }
        return map;
    }
}
