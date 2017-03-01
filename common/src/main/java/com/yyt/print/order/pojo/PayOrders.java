package com.yyt.print.order.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/2/28.
 */
public class PayOrders {

    private static int  seq = 1;
    public static String getSeq(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = format.format(new Date());
        synchronized (Orders.class){
            seq++;
            if(seq>=9999){
                seq = 1;
            }
        }
        result =String.valueOf(Long.parseLong(result) * 1000 + seq) ;

        return result;
    }
    public static PayOrders getByIds(){
        PayOrders po = new PayOrders();
        po.setId(getSeq());
        return po;
    }

    private String id;
    private String orderIdSet;
    private int status;

    /**
     * 0 待支付
     * 1 已支付
     */
    private int payType;
    private double totalMoney;
    private double fee;
    private Date payTime;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderIdSet() {
        return orderIdSet;
    }

    public void setOrderIdSet(String orderIdSet) {
        this.orderIdSet = orderIdSet;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
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

}
