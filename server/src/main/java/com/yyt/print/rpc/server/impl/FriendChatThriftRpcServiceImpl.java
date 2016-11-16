package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yyt.print.friend.pojo.ChatRecord;
import com.yyt.print.friend.pojo.ChatSession;
import com.yyt.print.friend.pojo.Friend;
import com.yyt.print.friend.pojo.FriendApply;
import com.yyt.print.friend.service.IChatRecordService;
import com.yyt.print.friend.service.IChatSessionService;
import com.yyt.print.friend.service.IFriendApplyService;
import com.yyt.print.friend.service.IFriendService;
import com.yyt.print.rpc.thrift.gen.FriendChatThriftRpcService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Service("friendChatThriftRpcService")
public class FriendChatThriftRpcServiceImpl implements FriendChatThriftRpcService.Iface {
    @Resource
    private IChatRecordService chatRecordService;
    @Resource
    private IChatSessionService chatSessionService;
    @Resource
    private IFriendApplyService friendApplyService;
    @Resource
    private IFriendService friendService;

    @Override
    public int saveFriend(int userId, int friendId) throws TException {
        return friendService.saveFriend(userId, friendId);
    }

    @Override
    public int deleteFriend(int userId, int friendId) throws TException {
        return friendService.deleteFriend(userId, friendId);
    }

    @Override
    public String getFriend(int userId, int friendId) throws TException {
        Friend friend = friendService.getFriend(userId, friendId);
        return JSON.toJSONString(friend);
    }

    @Override
    public String queryMyFriend(int userId) throws TException {
        List<Friend> list = friendService.queryMyFriend(userId);
        return JSON.toJSONString(list);
    }

    @Override
    public int saveFriendApply(String friendApply) throws TException {
        FriendApply apply = JSONObject.parseObject(friendApply, FriendApply.class);
        return friendApplyService.saveFriendApply(apply);
    }

    @Override
    public String queryFriendApply(int userId) throws TException {
        List<FriendApply> list = friendApplyService.queryFriendApply(userId);
        if(list!=null){
            return JSON.toJSONString(list);
        }
        return null;
    }

    @Override
    public int agreeFriendApply(int applyId, int userId, int friendId) throws TException {
        return friendApplyService.agreeFriendApply(applyId, userId, friendId);
    }

    @Override
    public int refuseFriendApply(int applyId, int userId, int friendId) throws TException {
        return friendApplyService.refuseFriendApply(applyId, userId, friendId);
    }

    @Override
    public int saveChatSession(String chatSession) throws TException {
        ChatSession cs = JSONObject.parseObject(chatSession, ChatSession.class);
        return chatSessionService.saveChatSession(cs);
    }

    @Override
    public String queryChatSessionList(int userId, int position, int size) throws TException {
        List<ChatSession> list = chatSessionService.queryChatSessionList(userId, position, size);
        return JSON.toJSONString(list);
    }

    @Override
    public String queryChartRecordList(int sessionId, int position, int size) throws TException {
        List<ChatRecord> list = chatRecordService.queryChartRecordList(sessionId, position, size);
        return JSON.toJSONString(list);
    }

    @Override
    public int sendMsg(int userId, int toUid, int msgId, String msgContent, int type) throws TException {
        return chatRecordService.sendMsg(userId, toUid, msgId, msgContent, type);
    }
}
