package com.yyt.print.friend.service;

import com.yyt.print.friend.pojo.Friend;

import java.util.List;

/**
 * 好友关系
 * Created by SomeBody on 2016/9/23.
 */
public interface IFriendService {

    /**
     * 保存好友关系
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    public int saveFriend(int userId, int friendId);

    /**
     * 删除好友关系
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    public int deleteFriend(int userId, int friendId);

    /**
     * 查询好友关系是否存在
     * @param userId
     * @param friendId
     * @return
     */
    public Friend getFriend(int userId, int friendId);

    /**
     * 查询我的好友列表
     * @param userId 用户ID
     * @return
     */
    public List<Friend> queryMyFriend(int userId);
}
