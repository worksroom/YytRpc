package com.yyt.print.rpc.client.friend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.yyt.print.friend.pojo.ChatRecord;
import com.yyt.print.friend.pojo.ChatSession;
import com.yyt.print.friend.pojo.Friend;
import com.yyt.print.friend.pojo.FriendApply;
import com.yyt.print.rpc.common.Constants;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
public class FriendChatRpcServiceImpl implements IFriendChatRpcService {
    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);

    private FriendChatClient getClient() {
        return new FriendChatClient();
    }

    @Override
    public int saveFriend(int userId, int friendId) {
        try {
            return getClient().saveFriend(userId, friendId);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int deleteFriend(int userId, int friendId) {
        try {
            return getClient().deleteFriend(userId, friendId);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public Friend getFriend(int userId, int friendId) {
        try {
            String json = getClient().getFriend(userId, friendId);
            return JSONObject.parseObject(json, Friend.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Friend> queryMyFriend(int userId) {
        try {
            String json = getClient().queryMyFriend(userId);
            return JSONArray.parseArray(json, Friend.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveFriendApply(FriendApply friendApply) {
        try {
            return getClient().saveFriendApply(JSON.toJSONString(friendApply));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<FriendApply> queryFriendApply(int userId) {
        try {
            String json = getClient().queryFriendApply(userId);
            return JSONArray.parseArray(json, FriendApply.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int agreeFriendApply(int applyId, int userId, int friendId) {
        try {
            return getClient().agreeFriendApply(applyId, userId, friendId);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int refuseFriendApply(int applyId, int userId, int friendId) {
        try {
            return getClient().refuseFriendApply(applyId, userId, friendId);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int saveChatSession(ChatSession chatSession) {
        try {
            return getClient().saveChatSession(JSON.toJSONString(chatSession));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<ChatSession> queryChatSessionList(int userId, int position, int size) {
        try {
            String json = getClient().queryChatSessionList(userId, position, size);
            return JSONArray.parseArray(json, ChatSession.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<ChatRecord> queryChartRecordList(int sessionId, int position, int size) {
        try {
            String json = getClient().queryChartRecordList(sessionId, position, size);
            return JSONArray.parseArray(json, ChatRecord.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int sendMsg(int userId, int toUid, int msgId, String msgContent, int type) {
        try {
            return getClient().sendMsg(userId, toUid, msgId, msgContent, type);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }
}
