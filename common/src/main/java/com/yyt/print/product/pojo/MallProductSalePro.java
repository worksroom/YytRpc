package com.yyt.print.product.pojo;

import java.util.Date;

/**
 * Created by leo on 2016/11/17.
 * 商品销售属性
 */
public class MallProductSalePro {
    private int id;
    private int goodsId;//货品ID
    private int productId;
    private int classProValueId;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getClassProValueId() {
        return classProValueId;
    }

    public void setClassProValueId(int classProValueId) {
        this.classProValueId = classProValueId;
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
}
