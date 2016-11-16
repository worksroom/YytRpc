package com.yyt.print.user.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.user.pojo.UserThirdBind;
import com.yyt.print.user.service.IUserThirdBindService;
import org.junit.Test;

import java.util.Date;

public class UserThirdBindServiceTest extends BaseTestClass {

    IUserThirdBindService userThirdBindService = (IUserThirdBindService) getBean("userThirdBindService");

    @Test
    public void testSaveUserThirdBind() throws Exception {
        UserThirdBind bind = new UserThirdBind();
        bind.setUserId(3);
        bind.setThirdId("18801156796");
        bind.setCreateTime(new Date());
        bind.setType(1);
        userThirdBindService.saveUserThirdBind(bind);
    }

    @Test
    public void testGetUserThirdBind() throws Exception {
        UserThirdBind bind = userThirdBindService.getUserThirdBind("18801156796", 1);
        System.out.println(bind);
    }
}