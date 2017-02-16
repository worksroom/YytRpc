package com.yyt.print.product.service;

import com.alibaba.fastjson.JSON;
import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/2/15.
 */
public class MallProductServiceTest extends BaseTestClass {
    private IMallProductService service = getBean(IMallProductService.class);
    private MallGoods getBean(){
        MallGoods good = new MallGoods();
        good.setName("外套");
        good.setShopId(1);
        good.setShopName("leo小店");
        good.setCreateTime(new Date());
        good.setClassId(1);
        good.setDes("保暖");
        good.setStatus(0);
        good.setUpdateTime(new Date());
        return good;
    }

    private MallProductSet getMallProductSet(){
        MallProductSet set = new MallProductSet();
        MallProduct product = new MallProduct();
        product.setName("名称");
        product.setPrice(128.00);
        product.setSalePrice(128.00);

        List<MallProductSalePro> list = new ArrayList<>();
        MallProductSalePro pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(1);
        list.add(pro);

        pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(2);
        list.add(pro);

        pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(3);
        list.add(pro);

        pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(4);
        list.add(pro);

        set.setMallProduct(product);
        set.setSalePro(list);
        return set;
    }

    @Test
    public void shelves(){
        List<MallProductSet> list = new ArrayList<>();
        list.add(getMallProductSet());
        service.shelves(getBean(),list);
    }

    @Test
    public void goodAddProduct(){
        List<MallProductSet> list = new ArrayList<>();
        list.add(getMallProductSet());
        service.goodAddProduct(9,list);
    }

    @Test
    public void getMallGoodsSetByGood(){
        MallGoodsSet set = service.getMallGoodsSetByGood(9);
        System.out.println(set);
        String json = JSON.toJSONString(set);
        System.out.println(json);
        MallGoodsSet set1 = JSON.parseObject(json,MallGoodsSet.class);
        System.out.println(set1);


    }
}
