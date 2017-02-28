package com.yyt.print.rpc.client.order;

import com.alibaba.fastjson.JSON;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.yyt.print.order.pojo.OrderAddr;
import com.yyt.print.rpc.common.Constants;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by lenovo on 2017/2/28.
 */
public class OrderRpcServiceImpl implements IOrderRPCService {

    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);
    private static OrderClient client = new OrderClient();
    private OrderClient getClient() {
        return client;
    }


}
