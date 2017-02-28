package com.yyt.print.order.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.query.OrdersQuery;

/**
 * Created by lenovo on 2017/2/28.
 */
public interface IOrdersDAO {
    int saveOrders(Orders orders);

    Orders getOrders(String id);

    int updateStatus(String id , int paytype , int status);

    int updateMoney(String id , double money);

    PageHolder<Orders> findOrders(OrdersQuery query);
}
