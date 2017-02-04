package com.yyt.print.friend.service.impl;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.friend.service.IChatRecordService;
import org.junit.Test;

public class ChatRecordServiceTest extends BaseTestClass {

    IChatRecordService chatRecordService = (IChatRecordService) getBean("chatRecordService");

    @Test
    public void testQueryChartRecordList() throws Exception {

    }

    @Test
    public void testSendMsg() throws Exception {
        chatRecordService.sendMsg(224, 3298, -1, "中华人民共和国成立了！", 1);
    }
}