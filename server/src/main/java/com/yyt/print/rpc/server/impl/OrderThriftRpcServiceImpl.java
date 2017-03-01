package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.youguu.core.util.PageHolder;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.query.OrdersQuery;
import com.yyt.print.order.service.IOrderService;
import com.yyt.print.parser.PageHolderSerializer;
import com.yyt.print.rpc.thrift.gen.OrderThriftRpcService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/2/28.
 */
@Service("orderThriftRpcService")
public class OrderThriftRpcServiceImpl implements OrderThriftRpcService.Iface {

    @Resource
    private IOrderService orderService;


    @Override
    public int addShopCart(int uid, int skuId, int buyNum) throws TException {
        return orderService.addShopCart(uid, skuId, buyNum);
    }

    @Override
    public int delShopCart(int id) throws TException {
        return orderService.delShopCart(id);
    }

    @Override
    public int updateShopNum(int id, int num) throws TException {
        return orderService.updateShopNum(id, num);
    }

    @Override
    public String findUserShopCart(int uid) throws TException {
        return JSON.toJSONString(orderService.findUserShopCart(uid));
    }

    @Override
    public String makeOrder(int buyUserId, int addrId, String product, String ext) throws TException {
        return JSON.toJSONString(orderService.makeOrder(buyUserId,addrId,JSON.parseArray(product, OrderProductFront.class),JSON.parseObject(ext)));
    }

    @Override
    public String findOrders(String query) throws TException {
        PageHolder<Orders> list = orderService.findOrders(JSON.parseObject(query, OrdersQuery.class));
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(list, config);
    }

    @Override
    public int updateOrderPrice(String order, double price) throws TException {
        return orderService.updateOrderPrice(order, price);
    }

    @Override
    public int confirmExpress(String orderId, int expressCom, String expressNum) throws TException {
        return orderService.confirmExpress(orderId, expressCom, expressNum);
    }
}
