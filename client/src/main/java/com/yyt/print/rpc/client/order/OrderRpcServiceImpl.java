package com.yyt.print.rpc.client.order;

import com.alibaba.fastjson.JSON;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.yyt.print.order.pojo.ShoppingCartSet;
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
}
