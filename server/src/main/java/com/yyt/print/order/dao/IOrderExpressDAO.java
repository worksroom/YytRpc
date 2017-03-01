package com.yyt.print.order.dao;

import com.yyt.print.order.pojo.OrderExpress;

/**
 * Created by lenovo on 2017/3/1.
 */
public interface IOrderExpressDAO {
    int saveOrderExpress(OrderExpress orderExpress);
    OrderExpress getOrderExpress(String id);
}
