package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.OrderAddr;

/**
 * Created by lenovo on 2017/2/28.
 */
public interface IOrderAddrDAO{

    int saveOrderAddr(OrderAddr orderAddr);

    OrderAddr getOrderAddr(String orderId);


}
