package com.yyt.print.product.pojo;

/**
 * Created by lenovo on 2017/2/13.
 */
public class MallIndexContent {
    private String name;
    private String img;
    private String url;
    private String price;
    private String salePrice;
    private String discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "MallIndexContent{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                ", price='" + price + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}
