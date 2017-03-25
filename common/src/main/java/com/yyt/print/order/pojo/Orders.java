package com.yyt.print.order.pojo;

import com.alibaba.fastjson.JSON;
import com.yyt.print.order.front.OrderProductPojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 * Created by leo on 2016/11/21.
 */
public class Orders {

    private static int  seq = 1;
    public static String getSeq(int buyUserId){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = format.format(new Date());
        synchronized (Orders.class){
            seq++;
            if(seq>=999){
                seq = 1;
            }
        }
        result = (Long.parseLong(result)*1000 + seq) + String.valueOf(buyUserId);

        return result;
    }

    public static final int STATUS_EVALUATE = 5;

    private String id;//订单ID
    private int buyUserId;
    private int sellUserId;
    private int shopId;
    private int payType;
    private Double totalMoney;
    private Double productMoney;
    /**
     * 0.待支付；1.已支付,待发货；2.已发货；3.结束；4.已收货；5.已评价
     */
    private int status;
    private Double fee;
    private String productDesc;
    private String ip;
    private Date payTime;
    private Date createTime;
    private Date updateTime;
    private int addressId;

    public Orders(int buyUserId){
        this.buyUserId = buyUserId;
        this.id = getSeq(this.buyUserId);
    }

    public Orders(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(int buyUserId) {
        this.buyUserId = buyUserId;
    }

    public int getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(int sellUserId) {
        this.sellUserId = sellUserId;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(Double productMoney) {
        this.productMoney = productMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public List<OrderProductPojo> transproductDesc(){
        if(this.productDesc!=null){
            return JSON.parseArray(this.productDesc, OrderProductPojo.class);
        }else{
            return null;
        }

    }
}
