package com.yyt.print.rpc.server.impl;

import com.yyt.print.order.service.IOrderService;
import com.yyt.print.rpc.thrift.gen.OrderThriftRpcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/2/28.
 */
@Service("orderThriftRpcService")
public class OrderThriftRpcServiceImpl implements OrderThriftRpcService.Iface {

    @Resource
    private IOrderService orderService;


}
