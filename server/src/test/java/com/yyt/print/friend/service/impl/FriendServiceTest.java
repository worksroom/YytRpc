package com.yyt.print.friend.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.friend.pojo.Friend;
import com.yyt.print.friend.service.IFriendService;
import org.junit.Test;

import java.util.List;

public class FriendServiceTest extends BaseTestClass {

    IFriendService friendService = (IFriendService) getBean("friendService");

    @Test
    public void testSaveFriend() throws Exception {
        friendService.saveFriend(224, 3298);
    }

    @Test
    public void testDeleteFriend() throws Exception {
        friendService.deleteFriend(224, 3298);
    }

    @Test
    public void testGetFriend() throws Exception {
        Friend friend = friendService.getFriend(224, 3298);
        System.out.println(friend);
    }

    @Test
    public void testQueryMyFriend() throws Exception {
        List<Friend> list = friendService.queryMyFriend(224);
        System.out.println(list.size());
    }
}