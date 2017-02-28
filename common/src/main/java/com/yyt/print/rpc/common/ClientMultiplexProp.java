package com.yyt.print.rpc.common;

import com.yyt.print.rpc.thrift.gen.*;


public enum ClientMultiplexProp {

    FriendChatThriftRpcService("FriendChatThriftRpcService",
            FriendChatThriftRpcService.Client.class,
            FriendChatThriftRpcService.Processor.class,
            FriendChatThriftRpcService.Iface.class),
    InfoThriftRpcService("InfoThriftRpcService",
            InfoThriftRpcService.Client.class,
            InfoThriftRpcService.Processor.class,
            InfoThriftRpcService.Iface.class),
    ProductThriftRpcService("ProductThriftRpcService",
            ProductThriftRpcService.Client.class,
            ProductThriftRpcService.Processor.class,
            ProductThriftRpcService.Iface.class),
    UserThriftRpcService("UserThriftRpcService",
            UserThriftRpcService.Client.class,
            UserThriftRpcService.Processor.class,
            UserThriftRpcService.Iface.class),
    AdThriftRpcService("AdThriftRpcService",
            AdThriftRpcService.Client.class,
            AdThriftRpcService.Processor.class,
            AdThriftRpcService.Iface.class),
    OrderThriftRpcService("OrderThriftRpcService",
            OrderThriftRpcService.Client.class,
            OrderThriftRpcService.Processor.class,
            OrderThriftRpcService.Iface.class);


    Class<?> processor;

    Class<?> client;

    Class<?> iface;

    private String name;

    ClientMultiplexProp(String name, Class<?> client, Class<?> processor, Class<?> iface) {
        this.processor = processor;
        this.client = client;
        this.name = name;
        this.iface = iface;
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

}
