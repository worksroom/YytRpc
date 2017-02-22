package com.yyt.print.product.service;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.ProductEvaluateRecord;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/22.
 */
public class IProductEvaluateServiceTest extends BaseTestClass {
    IProductEvaluateService service = getBean(IProductEvaluateService.class);


    private ProductEvaluateRecord getBean(){
        ProductEvaluateRecord record = new ProductEvaluateRecord();
        record.setGoodsId(1);
        record.setBuyUserId(224);
        record.setContent("不错呀");
        record.setDes("tinghao");
        record.setOrderId("099018981");
        record.setStar(5);
        record.setSellUserId(23);
        return record;
    }

    @Test
    public void commentGoods(){
        service.commentGoods(getBean());
    }

    @Test
    public void findProductEvaluateList(){
        System.out.println(service.findProductEvaluateList(1,0,10));
    }
}
