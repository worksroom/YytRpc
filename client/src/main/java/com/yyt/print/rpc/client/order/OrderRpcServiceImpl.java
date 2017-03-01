package com.yyt.print.rpc.client.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.pojo.PayOrders;
import com.yyt.print.order.pojo.ShoppingCartSet;
import com.yyt.print.order.query.OrdersQuery;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.rpc.common.Constants;

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

    @Override
    public int addShopCart(int uid, int skuId, int buyNum) {
        try {
            return getClient().addShopCart(uid, skuId, buyNum);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int delShopCart(int id) {
        try {
            return getClient().delShopCart(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateShopNum(int id, int num) {
        try {
            return getClient().updateShopNum(id, num);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<ShoppingCartSet> findUserShopCart(int uid) {
        try {
            return JSON.parseArray(getClient().findUserShopCart(uid),ShoppingCartSet.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PayOrders makeOrder(int buyUserId, int addrId, List<OrderProductFront> product, JSONObject ext) {
        try {

            String result = getClient().makeOrder(buyUserId,addrId,JSON.toJSONString(product),ext==null?null:ext.toJSONString());
            return JSON.parseObject(result,PayOrders.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<Orders> findOrders(OrdersQuery query) {
        try {
            String result = getClient().findOrders(JSON.toJSONString(query));
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(result, new TypeReference<PageHolder<Orders>>(){});
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int updateOrderPrice(String order, double price) {
        try {
            return getClient().updateOrderPrice(order, price);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int confirmExpress(String orderId, int expressCom, String expressNum) {
        try {
            return getClient().confirmExpress(orderId, expressCom, expressNum);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }
}
