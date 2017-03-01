package com.yyt.print.order.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.IOrderExpressDAO;
import com.yyt.print.order.pojo.OrderExpress;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/3/1.
 */
@Repository("orderExpressDAO")
public class OrderExpressDAOImpl extends YytBaseDAO<OrderExpress> implements IOrderExpressDAO {
    @Override
    public int saveOrderExpress(OrderExpress orderExpress) {
        return super.insert(orderExpress);
    }

    @Override
    public OrderExpress getOrderExpress(String id) {
        return super.get(id);
    }
}
