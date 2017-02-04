package com.yyt.print.user.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.service.IUserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceTest extends BaseTestClass {

    IUserService userService = (IUserService) getBean("userService");

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setUserName("zhangsan");
        user.setNickName("hello");
        user.setCreateTime(new Date());
        user.setEmail("123@qq.com");
        user.setPassword("111111");
        user.setPhone("18811119999");
        user.setUpdateTime(new Date());
        userService.saveUser(user);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userService.getUser(3);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = userService.getUser(3);
        user.setNickName("Leo");

        userService.updateUser(user);
    }

    @Test
    public void testGetUserList() throws Exception {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<User> list = userService.getUserList(idList);
        if(list !=null && list.size()>0){
            for(User user : list){
                System.out.println(user);
            }
        }
    }

    @Test
    public void testGetUserMap() throws Exception {

    }
}