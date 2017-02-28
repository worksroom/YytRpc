package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.yyt.print.order.service.IOrderService;
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
}
