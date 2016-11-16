package com.yyt.print.friend.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.friend.dao.IFriendApplyDAO;
import com.yyt.print.friend.pojo.FriendApply;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Repository
public class FriendApplyDAO extends YytBaseDAO<FriendApply> implements IFriendApplyDAO {
    @Override
    public int saveFriendApply(FriendApply friendApply) {
        return this.insert(friendApply);
    }

    @Override
    public List<FriendApply> queryFriendApply(int userId) {
        return this.findBy("queryFriendApply", userId);
    }

    @Override
    public int agreeFriendApply(int applyId, int userId, int friendId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", applyId);
        map.put("userId", userId);
        map.put("friendId", friendId);
        return this.updateBy("agreeFriendApply", map);
    }

    @Override
    public int refuseFriendApply(int applyId, int userId, int friendId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", applyId);
        map.put("userId", userId);
        map.put("friendId", friendId);
        return this.updateBy("refuseFriendApply", map);
    }
}
