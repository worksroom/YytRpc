package com.yyt.print.rpc.client.order;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
import com.yyt.print.rpc.common.Constants;
import com.yyt.print.rpc.thrift.gen.OrderThriftRpcService;
import org.apache.thrift.TException;

/**
 * Created by lenovo on 2017/2/28.
 */
public class OrderClient implements OrderThriftRpcService.Iface {
    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);

    private static RPCMultiplexPool pool = RPCServiceClient.getMultiplexCPool(Constants.YytRpcPOOL);

    private RPCMultiplexConnection getConnection(){
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    @Override
    public int addShopCart(int uid, int skuId, int buyNum) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).addShopCart(uid, skuId, buyNum);
        } catch(TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public int delShopCart(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).delShopCart(id);
        } catch(TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public int updateShopNum(int id, int num) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).updateShopNum(id, num);
        } catch(TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public String findUserShopCart(int uid) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).findUserShopCart(uid);
        } catch(TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }


    @Override
    public String makeOrder(int buyUserId, int addrId, String product, String ext) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).makeOrder(buyUserId, addrId, product, ext);
        } catch(TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public String findOrders(String query) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).findOrders(query);
        } catch (TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public int updateOrderPrice(String order, double price) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).updateOrderPrice(order,price);
        } catch (TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public int confirmExpress(String orderId, int expressCom, String expressNum) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(OrderThriftRpcService.Client.class).confirmExpress(orderId, expressCom, expressNum);
        } catch (TException e){
            client.setIdle(false);
            throw e;
        }finally {
            if(client != null){
                try {
                    pool.returnObject(client);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }
}
