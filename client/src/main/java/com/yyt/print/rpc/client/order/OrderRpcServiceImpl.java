package com.yyt.print.rpc.client.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.*;
import com.yyt.print.order.query.OrdersQuery;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.UserShop;
import com.yyt.print.rpc.common.Constants;

import java.util.List;
import java.util.Map;

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

    @Override
    public int addCollectShop(int uid, int shopId) {
        try {
            return getClient().addCollectShop(uid, shopId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int delCollectShop(int id) {
        try {
            return getClient().delCollectShop(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<UserShop> findCollectShop(int uid, int pageIndex, int pageSize) {
        try {
            return JSON.parseArray(getClient().findCollectShop(uid, pageIndex, pageSize),UserShop.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int addCollectGoods(int uid, int goodsId) {
        try {
            return getClient().addCollectGoods(uid, goodsId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int delCollectGoods(int id) {
        try {
            return getClient().delCollectGoods(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<MallGoods> findCollectGoods(int uid, int pageIndex, int pageSize) {
        try {
            return JSON.parseArray(getClient().findCollectGoods(uid, pageIndex, pageSize),MallGoods.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Map<String, Integer> getCollectCount(int uid) {
        try {
            return  getClient().getCollectCount(uid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Map<Integer, Integer> getOrderCount(int uid) {
        try {
            return  getClient().getOrderCount(uid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public CollectShop isCollectShop(int uid, int shopId) {
        try {
            return JSON.parseObject(getClient().isCollectShop(uid, shopId), CollectShop.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public CollectTreasure isCollectGoods(int uid, int goodsId) {
        try {
            return JSON.parseObject(getClient().isCollectShop(uid, goodsId), CollectTreasure.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
