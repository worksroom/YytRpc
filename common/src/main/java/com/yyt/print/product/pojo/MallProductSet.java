package com.yyt.print.product.pojo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/15.
 */
public class MallProductSet {
    /**
     * 商品基本属性
     */
    private MallProduct mallProduct;

    /**
     * 商品销售属性
     */
    private List<MallProductSalePro> salePro;

    public MallProduct getMallProduct() {
        return mallProduct;
    }

    public void setMallProduct(MallProduct mallProduct) {
        this.mallProduct = mallProduct;
    }

    public List<MallProductSalePro> getSalePro() {
        return salePro;
    }

    public void setSalePro(List<MallProductSalePro> salePro) {
        this.salePro = salePro;
    }
}
