package com.yyt.print.order.util;

import com.yyt.print.product.pojo.FareMould;
import com.yyt.print.product.pojo.MallProduct;

/**
 * Created by lenovo on 2017/2/28.
 */
public class OrderUtil {

    /**
     * 获取运费
     * @return
     */
    public static double getFreightMoney(FareMould moudle,int num){
        double money = 0;
        if(moudle.getType()==1){
            money = moudle.getPrice() * (num%moudle.getNum()==0?num/moudle.getNum():(num/moudle.getNum()+1));
        }
        return money;
    }

    /**
     * 计算商品价格
     * @param product
     * @param num
     * @return
     */
    public static double getProductMoney(MallProduct product,int num){
        double money = num * (product.getSalePrice()<=0?product.getPrice():product.getSalePrice());

        return money;
    }
}
