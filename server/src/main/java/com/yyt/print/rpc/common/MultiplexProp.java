package com.yyt.print.rpc.common;


import com.yyt.print.rpc.server.impl.*;
import com.yyt.print.rpc.thrift.gen.*;

public enum MultiplexProp {

    FriendChatThriftRpcService("FriendChatThriftRpcService",
            FriendChatThriftRpcService.Client.class,
            FriendChatThriftRpcService.Processor.class,
            FriendChatThriftRpcService.Iface.class,
            FriendChatThriftRpcServiceImpl.class),
    InfoThriftRpcService("InfoThriftRpcService",
            InfoThriftRpcService.Client.class,
            InfoThriftRpcService.Processor.class,
            InfoThriftRpcService.Iface.class,
            InfoThriftRpcServiceImpl.class),
    ProductThriftRpcService("ProductThriftRpcService",
            ProductThriftRpcService.Client.class,
            ProductThriftRpcService.Processor.class,
            ProductThriftRpcService.Iface.class,
            ProductThriftRpcServiceImpl.class),
    UserThriftRpcService("UserThriftRpcService",
            UserThriftRpcService.Client.class,
            UserThriftRpcService.Processor.class,
            UserThriftRpcService.Iface.class,
            UserThriftRpcServiceImpl.class),
    AdThriftRpcService("AdThriftRpcService",
            AdThriftRpcService.Client.class,
            AdThriftRpcService.Processor.class,
            AdThriftRpcService.Iface.class,
            AdThriftRpcServiceImpl.class),

    OrderThriftRpcService("OrderThriftRpcService",
            OrderThriftRpcService.Client.class,
            OrderThriftRpcService.Processor.class,
            OrderThriftRpcService.Iface.class,
            OrderThriftRpcServiceImpl.class);

    Class<?> processor;

    Class<?> client;

    Class<?> iface;

    Class<?> impl;

    private String name;

    MultiplexProp(String name, Class<?> client, Class<?> processor, Class<?> iface, Class<?> impl) {
        this.processor = processor;
        this.client = client;
        this.name = name;
        this.iface = iface;
        this.impl = impl;
    }

    public Class<?> getProcessor() {
        return processor;
    }

    public void setProcessor(Class<?> processor) {
        this.processor = processor;
    }

    public Class<?> getClient() {
        return client;
    }

    public void setClient(Class<?> client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getIface() {
        return iface;
    }

    public void setIface(Class<?> iface) {
        this.iface = iface;
    }

    public Class<?> getImpl() {
        return impl;
    }

    public void setImpl(Class<?> impl) {
        this.impl = impl;
    }
}
