package com.yyt.print.info.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.BaseTestClass;
import com.yyt.print.info.pojo.InfoCategory;
import com.yyt.print.info.service.IInfoCategoryService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class InfoCategoryServiceTest extends BaseTestClass {

    IInfoCategoryService infoCategoryService = (IInfoCategoryService) getBean("infoCategoryService");

    @Test
    public void testSaveInfoCategory() throws Exception {
        InfoCategory category = new InfoCategory();
        category.setName("需求");
        category.setParentId(-1);
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());

        infoCategoryService.saveInfoCategory(category);
    }

    @Test
    public void testUpdateInfoCategory() throws Exception {
        InfoCategory category = infoCategoryService.getInfoCategory(1);
        category.setUpdateTime(new Date());
        category.setName("求购");
        infoCategoryService.updateInfoCategory(category);
    }

    @Test
    public void testDeleteInfoCategory() throws Exception {

        infoCategoryService.deleteInfoCategory(1);
    }

    @Test
    public void testGetInfoCategory() throws Exception {
        InfoCategory category = infoCategoryService.getInfoCategory(1);
        System.out.println(category);
    }

    @Test
    public void testFindInfoCategoryByParentId() throws Exception {
        List<InfoCategory> list = infoCategoryService.findInfoCategoryByParentId(-1);
        System.out.println(list.size());
    }

    @Test
    public void testQueryInfoCategoryByPage() throws Exception {
        PageHolder<InfoCategory> pageHolder = infoCategoryService.queryInfoCategoryByPage(null, 1, 20);
        System.out.println(pageHolder.size());
    }
}