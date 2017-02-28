package com.yyt.print.order.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.IOrderAddrDAO;
import com.yyt.print.order.pojo.OrderAddr;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/2/28.
 */
@Repository("orderAddrDAO")
public class OrderAddrDAOImpl extends YytBaseDAO<OrderAddr> implements IOrderAddrDAO {
    @Override
    public int saveOrderAddr(OrderAddr orderAddr){return super.insert(orderAddr);}

    @Override
    public OrderAddr getOrderAddr(String orderId){return super.get(orderId);}



}
