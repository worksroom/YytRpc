package com.yyt.print.friend.dao;

import com.yyt.print.friend.pojo.ChatSession;

import java.util.Date;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/24.
 */
public interface IChatSessionDAO {
    /**
     * 创建会话，首次发起聊天时创建
     * @param chatSession
     * @return
     */
    public int saveChatSession(ChatSession chatSession);


    /**
     * 查询会话对象
     * @param userId
     * @param friendId
     * @return
     */
    public ChatSession getChatSession(int userId, int friendId);

    /**
     * 查询会话列表
     * @param userId 用户ID
     * @param position 起始位置
     * @param size 条数
     * @return
     */
    public List<ChatSession> queryChatSessionList(int userId, int position, int size);

    /**
     * 更新最后一次聊天内容
     * @param sessionId
     * @param lastUid
     * @param lastContent
     * @param lastTime
     * @return
     */
    public int updateLastChat(int sessionId, int lastUid, String lastContent, Date lastTime);
}
