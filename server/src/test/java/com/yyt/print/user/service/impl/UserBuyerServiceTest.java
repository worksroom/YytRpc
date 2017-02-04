package com.yyt.print.user.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.common.ImgUtils;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.service.IUserBuyerService;
import org.junit.Test;

import java.util.Date;

public class UserBuyerServiceTest extends BaseTestClass {

    IUserBuyerService userBuyerService = (IUserBuyerService) getBean("userBuyerService");


    @Test
    public void testSaveUserBuyer() throws Exception {
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setUserId(3);
        userBuyer.setUpdateTime(new Date());
        userBuyer.setCreateTime(new Date());
        userBuyer.setCardNumber("2323949238423");
        userBuyer.setMsg("aaa");
        userBuyer.setStatus(1);
        userBuyer.setCardBPhoto(ImgUtils.imageToString("E:\\集体照\\身份证\\zheng.jpg"));

        userBuyerService.saveUserBuyer(userBuyer);

    }

    @Test
    public void testGetUserBuyer() throws Exception {
        UserBuyer buyer = userBuyerService.getUserBuyer(3);

        ImgUtils.strToImage(buyer.getCardBPhoto(), "E:\\集体照\\身份证\\blob.jpg");

    }

    @Test
    public void testUpdateUserBuyer() throws Exception {
        UserBuyer buyer = userBuyerService.getUserBuyer(3);
        buyer.setCardNumber("230123198811229088");
        userBuyerService.updateUserBuyer(buyer);
    }




    @Test
    public void testImgStr() throws Exception {
        String imgStr = ImgUtils.imageToString("E:\\集体照\\身份证\\zheng.jpg");
        ImgUtils.strToImage(imgStr, "E:\\集体照\\身份证\\blob.jpg");
    }
}