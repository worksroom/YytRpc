package com.yyt.print.user.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.common.ImgUtils;
import com.yyt.print.user.pojo.UserSeller;
import com.yyt.print.user.service.IUserSellerService;
import org.junit.Test;

import java.util.Date;

public class UserSellerServiceTest extends BaseTestClass {

    IUserSellerService userSellerService = (IUserSellerService) getBean("userSellerService");

    @Test
    public void testSaveUserSeller() throws Exception {
        UserSeller userSeller = new UserSeller();
        userSeller.setUserId(3);
        userSeller.setUpdateTime(new Date());
        userSeller.setCreateTime(new Date());
        userSeller.setCardNumber("2323949238423");
        userSeller.setMsg("aaa");
        userSeller.setStatus(1);
        userSeller.setCardBPhoto(ImgUtils.imageToString("E:\\集体照\\身份证\\zheng.jpg"));
        userSellerService.saveUserSeller(userSeller);
    }

    @Test
    public void testGetUserSeller() throws Exception {
        UserSeller userSeller = userSellerService.getUserSeller(3);
        ImgUtils.strToImage(userSeller.getCardBPhoto(), "E:\\集体照\\身份证\\seller.jpg");
    }

    @Test
    public void testUpdateUserSeller() throws Exception {
        UserSeller userSeller = userSellerService.getUserSeller(3);
        userSeller.setCardFPhoto(ImgUtils.imageToString("E:\\集体照\\身份证\\fan.jpg"));

        userSellerService.updateUserSeller(userSeller);
    }
}