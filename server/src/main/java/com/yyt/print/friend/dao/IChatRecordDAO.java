package com.yyt.print.friend.dao;

import com.yyt.print.friend.pojo.ChatRecord;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/24.
 */
public interface IChatRecordDAO {
    /**
     * 根据会话ID查询聊天记录
     * @param sessionId
     * @param position
     * @param size
     * @return
     */
    public List<ChatRecord> queryChartRecordList(int sessionId, int position, int size);

    /**
     * 发送消息
     * @param userId
     * @param msgId 消息ID，重新发送时使用
     * @param msgContent 消息内容
     * @param type 消息内容类型
     * @return 返回消息ID
     */
    public int sendMsg(int sessionId, int userId, int msgId, String msgContent, int type);

    /**
     * 查询消息记录
     * @param id
     * @return
     */
    public ChatRecord getChatRecord(int id);

    /**
     * 修改消息推送状态
     * @param id
     * @param pushType
     * @return
     */
    public int updatePushType(int id, int pushType);
}
