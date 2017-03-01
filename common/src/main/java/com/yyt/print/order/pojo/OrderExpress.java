package com.yyt.print.order.pojo;

/**
 * Created by leo on 2016/11/17.
 * 订单物流详情
 */
public class OrderExpress {
    private String orderId;//订单ID
    private String orgId;//物流公司
    private int code;//物流公司编号
    private String num; //物流单号

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
