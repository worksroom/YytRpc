package com.yyt.print.order.front;

/**
 * Created by lenovo on 2017/2/28.
 */
public class OrderProductPojo {

    private String product_name;

    private String product_img;
    /**
     * 属性值 ， 多个使用;分割
     */
    private String product_pro_value;

    private String price;

    private String salePrice;

    private String fee;

    private int num;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_pro_value() {
        return product_pro_value;
    }

    public void setProduct_pro_value(String product_pro_value) {
        this.product_pro_value = product_pro_value;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
