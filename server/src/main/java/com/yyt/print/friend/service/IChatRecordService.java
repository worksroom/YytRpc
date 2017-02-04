package com.yyt.print.friend.service;

import com.yyt.print.friend.pojo.ChatRecord;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IChatRecordService {

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
     * @param userId 消息发送人ID
     * @param toUid 消息接收人ID
     * @param msgId 消息ID，重新发送时使用
     * @param msgContent 消息内容
     * @param type 消息内容类型
     * @return 返回消息ID
     */
    public int sendMsg(int userId, int toUid, int msgId, String msgContent, int type);

    /**
     * 修改消息推送状态
     * @param id
     * @param pushType
     * @return
     */
    public int updatePushType(int id, int pushType);

}
