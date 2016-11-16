package com.yyt.print.friend.service.impl;

import com.yyt.print.friend.dao.IFriendDAO;
import com.yyt.print.friend.pojo.Friend;
import com.yyt.print.friend.service.IFriendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Service("friendService")
public class FriendService implements IFriendService {

    @Resource
    private IFriendDAO friendDAO;

    @Override
    public int saveFriend(int userId, int friendId) {
        return friendDAO.saveFriend(userId, friendId);
    }

    @Override
    public int deleteFriend(int userId, int friendId) {
        return friendDAO.deleteFriend(userId, friendId);
    }

    @Override
    public Friend getFriend(int userId, int friendId) {
        return friendDAO.getFriend(userId, friendId);
    }

    @Override
    public List<Friend> queryMyFriend(int userId) {
        return friendDAO.queryMyFriend(userId);
    }
}
