package com.yyt.print.ad.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.Ad;
import com.yyt.print.ad.service.IAdService;
import com.yyt.print.base.BaseTestClass;
import com.yyt.print.common.ImgUtils;
import org.junit.Test;

import java.util.Date;

public class AdServiceTest extends BaseTestClass {
    IAdService adService = (IAdService) getBean("adService");

    @Test
    public void testSaveAd() throws Exception {
        Ad ad = new Ad();
        ad.setAdType("0002");
        ad.setDes("这是广告");
        ad.setCreateTime(new Date());
        ad.setImg(ImgUtils.imageToString("E:\\集体照\\身份证\\zheng.jpg"));
        ad.setUrl("https://www.baidu.com/");
        ad.setUsed(1);
        adService.saveAd(ad);
    }

    @Test
    public void testUpdateAd() throws Exception {
        Ad ad = adService.getAd(1);
        ad.setDes("这是一个广告");
        ad.setImg(ImgUtils.imageToString("E:\\集体照\\身份证\\fan.jpg"));
        ad.setUrl("https://www.sohu.com/");
        ad.setUsed(1);

        adService.updateAd(ad);
    }

    @Test
    public void testDeleteAd() throws Exception {
        adService.deleteAd(1);
    }

    @Test
    public void testGetAd() throws Exception {
        Ad ad = adService.getAd(1);
        ImgUtils.strToImage(ad.getImg(), "E:\\集体照\\身份证\\ad.jpg");
    }

    @Test
    public void testQueryAdByPage() throws Exception {
        PageHolder<Ad>  pageHolder = adService.queryAdByPage(null, 1, 50);
        System.out.println(pageHolder.size());
    }
}