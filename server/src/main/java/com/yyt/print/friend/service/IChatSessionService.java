package com.yyt.print.friend.service;

import com.yyt.print.friend.pojo.ChatSession;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IChatSessionService {

    /**
     * 创建会话，首次发起聊天时创建
     * @param chatSession
     * @return
     */
    public int saveChatSession(ChatSession chatSession);

    /**
     * 查询会话列表
     * @param userId 用户ID
     * @param position 起始位置
     * @param size 条数
     * @return
     */
    public List<ChatSession> queryChatSessionList(int userId, int position, int size);
}
