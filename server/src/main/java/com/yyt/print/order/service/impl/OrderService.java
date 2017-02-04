package com.yyt.print.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leo on 2016/11/21.
 */
@Service("orderService")
public class OrderService implements IOrderService {
    @Override
    public Orders makeOrder(int buyUserId, int sellUserId, int payType, Double totalMoney, JSONObject ext) {
        return null;
    }

    @Override
    public List<Orders> queryOrders(int buyUserId, int type) {
        return null;
    }

    @Override
    public String payOrder(int buyUserId, String orderId) {
        return null;
    }

    @Override
    public int rate(int buyUserId, String orderId, String goodsId, int score, String content, String imgs) {
        return 0;
    }

    @Override
    public int receive(int buyUserId, String orderId) {
        return 0;
    }

    @Override
    public int queryExpress(int buyUserId, String orderId) {
        return 0;
    }
}
