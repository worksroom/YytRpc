package com.yyt.print.friend.service.impl;

import com.yyt.print.friend.dao.IChatRecordDAO;
import com.yyt.print.friend.dao.IChatSessionDAO;
import com.yyt.print.friend.pojo.ChatRecord;
import com.yyt.print.friend.pojo.ChatSession;
import com.yyt.print.friend.service.IChatRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Service("chatRecordService")
public class ChatRecordService implements IChatRecordService {

    @Resource
    private IChatRecordDAO chatRecordDAO;
    @Resource
    private IChatSessionDAO chatSessionDAO;

    @Override
    public List<ChatRecord> queryChartRecordList(int sessionId, int position, int size) {
        return chatRecordDAO.queryChartRecordList(sessionId, position, size);
    }

    @Transactional
    @Override
    public int sendMsg(int userId, int toUid, int msgId, String msgContent, int type) {
        ChatSession session = chatSessionDAO.getChatSession(userId, toUid);
        //初次发起聊天，需要建立会话
        if(session==null){
            session = new ChatSession();
            session.setUserId(userId);
            session.setFriendId(toUid);
            session.setCreateTime(new Date());
//            session.setLastUid(userId);
//            session.setLastContent(msgContent);
//            session.setLastTime(new Date());
            chatSessionDAO.saveChatSession(session);

            session = chatSessionDAO.getChatSession(userId, toUid);
        }

        if(session==null){
            return 0;
        }
        //发送消息
        chatRecordDAO.sendMsg(session.getId(), userId, msgId, msgContent, type);

        //修改最后一次聊天内容
        chatSessionDAO.updateLastChat(session.getId(), userId, msgContent, new Date());
        return 1;
    }

    @Override
    public int updatePushType(int id, int pushType) {
        return chatRecordDAO.updatePushType(id, pushType);
    }
}
