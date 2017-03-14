package com.yyt.print.product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.CategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import org.junit.Test;

import java.util.List;

/**
 * Created by lenovo on 2017/2/7.
 */
public class ICategoryProServiceTest extends BaseTestClass {

    ICategoryProService service =  getBean(ICategoryProService.class);

    @Test
    public void findProValueByClassId(){
        List<CategoryPro> list = service.findProValueByClassId(32);
        String str = JSON.toJSONString(list);
        List<CategoryPro> list1 = JSONArray.parseArray(str,CategoryPro.class);
        System.out.println(list1);


    }

    @Test
    public void findProByClassId(){
        List<MallProductCategoryPro> list = service.findProByClassId(1);
        System.out.println(list);
    }





}
