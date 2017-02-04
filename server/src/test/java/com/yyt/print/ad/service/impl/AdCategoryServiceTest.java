package com.yyt.print.ad.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.AdCategory;
import com.yyt.print.ad.service.IAdCategoryService;
import com.yyt.print.base.BaseTestClass;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.parser.PageHolderSerializer;
import org.junit.Test;

import java.util.Date;

public class AdCategoryServiceTest extends BaseTestClass {

    IAdCategoryService adCategoryService = (IAdCategoryService) getBean("adCategoryService");

    @Test
    public void testSaveAdCategory() throws Exception {
        AdCategory category = new AdCategory();
        category.setId("0002");
        category.setName("纸张");
        category.setCreateTime(new Date());
        adCategoryService.saveAdCategory(category);
    }

    @Test
    public void testUpdateAdCategory() throws Exception {
        AdCategory category = adCategoryService.getAdCategory("0001");
        category.setName("油墨");
        adCategoryService.updateAdCategory(category);
    }

    @Test
    public void testDeleteAdCategory() throws Exception {
        adCategoryService.deleteAdCategory("0001");
    }

    @Test
    public void testGetAdCategory() throws Exception {
        AdCategory category = adCategoryService.getAdCategory("0001");
        System.out.println(category);
    }

    @Test
    public void testQueryAdCategoryByPage() throws Exception {
        PageHolder<AdCategory>  pageHolder = adCategoryService.queryAdCategoryByPage(null, 1, 50);
        System.out.println(pageHolder.size());
    }

    @Test
    public void testPageHolderSerializer(){
        PageHolder<AdCategory> pageHolder = new PageHolder<>();
        pageHolder.setTotalCount(10);
        pageHolder.setPageSize(50);
        pageHolder.setPageIndex(1);

        AdCategory category = new AdCategory();
        category.setName("ddddddddddd");
        pageHolder.add(category);

        String json = JSON.toJSONString(pageHolder);
        System.out.println(json);
    }

    @Test
    public void testSerializer(){


        PageHolder<AdCategory> pageHolder = new PageHolder<>();
        pageHolder.setTotalCount(10);
        pageHolder.setPageSize(50);
        pageHolder.setPageIndex(1);

        AdCategory category = new AdCategory();
        category.setName("ddddddddddd");
        pageHolder.add(category);

        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        String jsonStr = JSON.toJSONString(pageHolder, config);
        System.out.println("序列化："+jsonStr);


        ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
        PageHolder result = JSON.parseObject(jsonStr, new TypeReference<PageHolder<AdCategory>>(){});
        System.out.println("反序列化：pageIndex="+result.getPageIndex()+", pageSize="+result.getPageSize()+",list="+result.getList().get(0).toString());
    }
}