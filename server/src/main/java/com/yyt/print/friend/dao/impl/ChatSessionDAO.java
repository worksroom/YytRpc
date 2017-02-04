package com.yyt.print.friend.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.friend.dao.IChatSessionDAO;
import com.yyt.print.friend.pojo.ChatSession;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Repository
public class ChatSessionDAO extends YytBaseDAO<ChatSession> implements IChatSessionDAO {
    @Override
    public int saveChatSession(ChatSession chatSession) {
        return this.insert(chatSession);
    }

    @Override
    public ChatSession getChatSession(int userId, int friendId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("friendId", friendId);
        return this.findUniqueBy("getChatSession", map);
    }

    @Override
    public List<ChatSession> queryChatSessionList(int userId, int position, int size) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("position", position);
        map.put("size", size);
        return this.findBy("queryChatSessionList", map);
    }

    @Override
    public int updateLastChat(int sessionId, int lastUid, String lastContent, Date lastTime) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", sessionId);
        map.put("lastUid", lastUid);
        map.put("lastContent", lastContent);
        map.put("lastTime", lastTime);
        return this.updateBy("updateLastChat", map);
    }
}
