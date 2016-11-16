package com.yyt.print.friend.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.friend.dao.IFriendDAO;
import com.yyt.print.friend.pojo.Friend;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Repository
public class FriendDAO extends YytBaseDAO<Friend> implements IFriendDAO {
    @Override
    public int saveFriend(int userId, int friendId) {
        Friend friend = new Friend();
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        friend.setUpdateTime(new Date());
        friend.setCreateTime(new Date());
        return this.insert(friend);
    }

    @Override
    public int deleteFriend(int userId, int friendId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("friendId", friendId);
        return this.deleteBy("deleteFriend", map);
    }

    @Override
    public Friend getFriend(int userId, int friendId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("friendId", friendId);
        return this.findUniqueBy("getFriend", map);
    }

    @Override
    public List<Friend> queryMyFriend(int userId) {
        return this.findBy("queryMyFriend", userId);
    }
}
