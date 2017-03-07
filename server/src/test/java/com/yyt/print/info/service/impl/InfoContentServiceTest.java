package com.yyt.print.info.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.BaseTestClass;
import com.yyt.print.common.ImgUtils;
import com.yyt.print.info.pojo.InfoContent;
import com.yyt.print.info.service.IInfoContentService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class InfoContentServiceTest extends BaseTestClass {

    IInfoContentService infoContentService = (IInfoContentService) getBean("infoContentService");

    @Test
    public void testSaveInfoContent() throws Exception {
        InfoContent content = new InfoContent();
        content.setClassId(2);
        content.setDes("hahaha");
        content.setContent("塑料袋烦死了都放假塑料袋附加费沃尔夫");
        content.setPhoto(ImgUtils.imageToString("E:\\集体照\\身份证\\zheng.jpg"));
        content.setTitle("我是标题");
        content.setType(1);
        content.setUserId(224);
        content.setWeight(1);
        content.setUpdateTime(new Date());
        content.setCreateTime(new Date());
        infoContentService.saveInfoContent(content);
    }

    @Test
    public void testDeleteInfoContent() throws Exception {
        infoContentService.deleteInfoContent(1);
    }

    @Test
    public void testUpdateInfoContent() throws Exception {
        InfoContent content = infoContentService.getInfoContent(1);
        content.setTitle("测试修改标题");
        content.setUpdateTime(new Date());
        infoContentService.updateInfoContent(content);
    }

    @Test
    public void testGetInfoContent() throws Exception {

    }

    @Test
    public void testQueryInfoContentByPage() throws Exception {
        PageHolder<InfoContent> pageHolder = infoContentService.queryInfoContentByPage(null);
        System.out.println(pageHolder.size());
    }

    @Test
    public void testQueryInfoContentList() throws Exception {
        List<InfoContent> list = infoContentService.queryInfoContentList("", "", 10, 20);
        System.out.println(list.size());
    }
}