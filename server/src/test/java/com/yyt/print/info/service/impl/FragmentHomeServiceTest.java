package com.yyt.print.info.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.common.ImgUtils;
import com.yyt.print.fragment.pojo.FragmentContent;
import com.yyt.print.fragment.pojo.FragmentHome;
import com.yyt.print.info.service.IFragmentHomeService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentHomeServiceTest extends BaseTestClass {

    IFragmentHomeService fragmentHomeService = (IFragmentHomeService) getBean("fragmentHomeService");

    @Test
    public void testSaveFragmentHome() throws Exception {
        FragmentHome fragmentHome = new FragmentHome();
        fragmentHome.setType(1);
        fragmentHome.setCreateTime(new Date());
        fragmentHome.setRank(1);
        fragmentHome.setUsed(1);

        List<FragmentContent> content = new ArrayList<>();
        FragmentContent fc = new FragmentContent();
        fc.setImg(ImgUtils.imageToString("E:\\集体照\\身份证\\zheng.jpg"));
        fc.setUrl("http://www.baidu.com/1");
        content.add(fc);
        fragmentHome.setContent(content);
        fragmentHomeService.saveFragmentHome(fragmentHome);
    }

    @Test
    public void testUpdateFragmentHome() throws Exception {
        FragmentHome fragmentHome = fragmentHomeService.getFragmentHome(1);
        fragmentHome.setUsed(0);
        fragmentHomeService.updateFragmentHome(fragmentHome);
    }

    @Test
    public void testDeleteFragmentHome() throws Exception {

    }

    @Test
    public void testGetFragmentHome() throws Exception {
        FragmentHome fragmentHome = fragmentHomeService.getFragmentHome(1);
        List<FragmentContent> list = fragmentHome.getContent();
        for(FragmentContent fc : list){
            System.out.println(fc.getUrl());
            ImgUtils.strToImage(fc.getImg(), "E:\\集体照\\身份证\\fragment.jpg");
        }
    }

    @Test
    public void testQueryFragmentHomeByPage() throws Exception {

    }
}