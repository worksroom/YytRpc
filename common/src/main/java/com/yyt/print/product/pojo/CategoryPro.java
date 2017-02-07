package com.yyt.print.product.pojo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/7.
 */
public class CategoryPro {

    private MallProductCategoryPro pro;

    private List<MallProductCategoryProValue> values;

    public MallProductCategoryPro getPro() {
        return pro;
    }

    public void setPro(MallProductCategoryPro pro) {
        this.pro = pro;
    }

    public List<MallProductCategoryProValue> getValues() {
        return values;
    }

    public void setValues(List<MallProductCategoryProValue> values) {
        this.values = values;
    }
}
