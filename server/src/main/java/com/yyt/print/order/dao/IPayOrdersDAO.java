package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.PayOrders;

/**
 * Created by lenovo on 2017/3/1.
 */
public interface IPayOrdersDAO{
    int savePayOrders(PayOrders payOrders);
    int updatePayOrders(PayOrders payOrders);
    PayOrders getPayOrders(String id);
    int delPayOrders(String id);

    int updateStatus(String id,int status);
}