package com.yyt.print.friend.service;

import com.yyt.print.friend.pojo.FriendApply;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IFriendApplyService {

    /**
     * 保存申请关系，申请成为好友调用
     * @param friendApply
     * @return
     */
    public int saveFriendApply(FriendApply friendApply);

    /**
     * 查询状态为‘申请中’的好友申请
     * @param userId
     * @return
     */
    public List<FriendApply> queryFriendApply(int userId);

    /**
     * 同意申请，成为好友
     * @param applyId 申请ID
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    public int agreeFriendApply(int applyId, int userId, int friendId);

    /**
     * 拒绝申请
     * @param applyId 申请ID
     * @param userId 用户ID
     * @param friendId 好友ID
     * @return
     */
    public int refuseFriendApply(int applyId, int userId, int friendId);
}
