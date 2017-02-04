package com.yyt.print.rpc.client.friend;

import com.yyt.print.friend.pojo.ChatRecord;
import com.yyt.print.friend.pojo.ChatSession;
import com.yyt.print.friend.pojo.Friend;
import com.yyt.print.friend.pojo.FriendApply;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IFriendChatRpcService {
    /**
     * 保存好友关系
     *
     * @param userId   用户ID
     * @param friendId 好友ID
     * @return
     */
    public int saveFriend(int userId, int friendId);

    /**
     * 删除好友关系
     *
     * @param userId   用户ID
     * @param friendId 好友ID
     * @return
     */
    public int deleteFriend(int userId, int friendId);

    /**
     * 查询好友关系是否存在
     *
     * @param userId
     * @param friendId
     * @return
     */
    public Friend getFriend(int userId, int friendId);

    /**
     * 查询我的好友列表
     *
     * @param userId 用户ID
     * @return
     */
    public List<Friend> queryMyFriend(int userId);

    /**
     * 保存申请关系，申请成为好友调用
     *
     * @param friendApply
     * @return
     */
    public int saveFriendApply(FriendApply friendApply);

    /**
     * 查询状态为‘申请中’的好友申请
     *
     * @param userId
     * @return
     */
    public List<FriendApply> queryFriendApply(int userId);

    /**
     * 同意申请，成为好友
     *
     * @param applyId  申请ID
     * @param userId   用户ID
     * @param friendId 好友ID
     * @return
     */
    public int agreeFriendApply(int applyId, int userId, int friendId);

    /**
     * 拒绝申请
     *
     * @param applyId  申请ID
     * @param userId   用户ID
     * @param friendId 好友ID
     * @return
     */
    public int refuseFriendApply(int applyId, int userId, int friendId);

    /**
     * 创建会话，首次发起聊天时创建
     *
     * @param chatSession
     * @return
     */
    public int saveChatSession(ChatSession chatSession);

    /**
     * 查询会话列表
     *
     * @param userId   用户ID
     * @param position 起始位置
     * @param size     条数
     * @return
     */
    public List<ChatSession> queryChatSessionList(int userId, int position, int size);

    /**
     * 根据会话ID查询聊天记录
     *
     * @param sessionId
     * @param position
     * @param size
     * @return
     */
    public List<ChatRecord> queryChartRecordList(int sessionId, int position, int size);

    /**
     * 发送消息
     *
     * @param userId
     * @param msgId      消息ID，重新发送时使用
     * @param msgContent 消息内容
     * @param type       消息内容类型
     * @return 返回消息ID
     */
    public int sendMsg(int userId, int toUid, int msgId, String msgContent, int type);
}
