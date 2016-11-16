package com.yyt.print.friend.service.impl;

import com.yyt.print.friend.dao.IFriendApplyDAO;
import com.yyt.print.friend.pojo.FriendApply;
import com.yyt.print.friend.service.IFriendApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Service("friendApplyService")
public class FriendApplyService implements IFriendApplyService {

    @Resource
    private IFriendApplyDAO friendApplyDAO;

    @Override
    public int saveFriendApply(FriendApply friendApply) {
        return friendApplyDAO.saveFriendApply(friendApply);
    }

    @Override
    public List<FriendApply> queryFriendApply(int userId) {
        return friendApplyDAO.queryFriendApply(userId);
    }

    @Override
    public int agreeFriendApply(int applyId, int userId, int friendId) {
        return friendApplyDAO.agreeFriendApply(applyId, userId, friendId);
    }

    @Override
    public int refuseFriendApply(int applyId, int userId, int friendId) {
        return friendApplyDAO.refuseFriendApply(applyId, userId, friendId);
    }
}
