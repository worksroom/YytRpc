package com.yyt.print.order.pojo;

/**
 * Created by leo on 2016/11/17.
 * 订单发票信息
 */
public class OrderReceipt {
    private String orderId;//订单ID
    private int type;//发票类型
    private String title;//发票抬头
    private String content;//发票内容

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
