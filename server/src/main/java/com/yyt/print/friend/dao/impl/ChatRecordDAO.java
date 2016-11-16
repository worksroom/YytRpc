package com.yyt.print.friend.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.friend.dao.IChatRecordDAO;
import com.yyt.print.friend.pojo.ChatRecord;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Repository
public class ChatRecordDAO extends YytBaseDAO<ChatRecord> implements IChatRecordDAO {

    @Override
    public List<ChatRecord> queryChartRecordList(int sessionId, int position, int size) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", sessionId);
        map.put("position", position);
        map.put("size", size);
        return this.findBy("queryChartRecordList", map);
    }

    @Override
    public int sendMsg(int sessionId, int userId, int msgId, String msgContent, int type) {
        ChatRecord record = getChatRecord(msgId);
        if(record == null){
            record = new ChatRecord();
            record.setSessionId(sessionId);
            record.setUserId(userId);
            record.setContent(msgContent);
            record.setCreateTime(new Date());
            record.setType(1);
            record.setPushType(0);
            this.insert(record);
        }
        //TODO 调用环信API发送消息

        //修改推送状态
        updatePushType(record.getId(), 1);
        return 1;
    }

    @Override
    public ChatRecord getChatRecord(int id) {
        return this.get(id);
    }

    @Override
    public int updatePushType(int id, int pushType) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("pushType", pushType);
        return this.updateBy("updatePushType", map);
    }
}
