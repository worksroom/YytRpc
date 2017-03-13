package com.yyt.print.order.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.IOrdersDAO;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.query.OrdersQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/28.
 */
@Repository("ordersDAO")
public class OrdersDAOImpl extends YytBaseDAO<Orders> implements IOrdersDAO {
    @Override
    public int saveOrders(Orders orders) {
        return super.insert(orders);
    }

    @Override
    public Orders getOrders(String id) {
        return super.get(id);
    }

    @Override
    public int updateStatus(String id, int paytype, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("paytype",paytype);
        map.put("status",status);
        return super.updateBy("updateStatus",map);
    }

    @Override
    public int updateExpress(String id) {
        return super.updateBy("updateExpress",id);
    }

    @Override
    public int updateMoney(String id, double money) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("totalMoney",money);
        return super.updateBy("updateMoney",map);
    }

    @Override
    public PageHolder<Orders> findOrders(OrdersQuery query) {
        return super.rawPagedQuery(super.getSqlStatementName("findByParams"), query.getMap(), query.getPageIndex(), query.getPageSize(), query.isNeedCount());
    }

    @Override
    public int getCount(int uid,int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("buyUserId",uid);
        map.put("status",status);
        return super.count(super.getSqlStatementName("getcount"),map);
    }
}
