package com.yyt.print.friend.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.friend.pojo.FriendApply;
import com.yyt.print.friend.service.IFriendApplyService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class FriendApplyServiceTest extends BaseTestClass {

    IFriendApplyService friendApplyService = (IFriendApplyService) getBean("friendApplyService");

    @Test
    public void testSaveFriendApply() throws Exception {
        FriendApply friendApply = new FriendApply();
        friendApply.setUserId(224);
        friendApply.setFriendId(21);
        friendApply.setCreateTime(new Date());
        friendApply.setUpdateTime(new Date());
        friendApply.setMsg("请加一下好友");
        friendApply.setStatus(0);
        friendApplyService.saveFriendApply(friendApply);
    }

    @Test
    public void testQueryFriendApply() throws Exception {
        List<FriendApply> list = friendApplyService.queryFriendApply(224);
        System.out.println(list.size());
    }

    @Test
    public void testAgreeFriendApply() throws Exception {
        friendApplyService.agreeFriendApply(1, 224, 3298);
    }

    @Test
    public void testRefuseFriendApply() throws Exception {
        friendApplyService.refuseFriendApply(2, 224, 21);
    }
}