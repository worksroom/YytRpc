package com.yyt.print.friend.service.impl;

import com.yyt.print.friend.dao.IChatSessionDAO;
import com.yyt.print.friend.pojo.ChatSession;
import com.yyt.print.friend.service.IChatSessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Service("chatSessionService")
public class ChatSessionService implements IChatSessionService {

    @Resource
    private IChatSessionDAO chatSessionDAO;

    @Override
    public int saveChatSession(ChatSession chatSession) {
        return 0;
    }

    @Override
    public List<ChatSession> queryChatSessionList(int userId, int position, int size) {
        return chatSessionDAO.queryChatSessionList(userId, position, size);
    }
}
