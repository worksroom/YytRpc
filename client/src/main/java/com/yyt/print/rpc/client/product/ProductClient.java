package com.yyt.print.rpc.client.product;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
import com.yyt.print.rpc.common.Constants;
import com.yyt.print.rpc.thrift.gen.ProductThriftRpcService;
import org.apache.thrift.TException;

/**
 * Created by lenovo on 2016/12/29.
 */
public class ProductClient implements ProductThriftRpcService.Iface {
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
    public String queryAllMallProductCategory() throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(ProductThriftRpcService.Client.class).queryAllMallProductCategory();
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
    public String findMallProductCategoryList(int parentId) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(ProductThriftRpcService.Client.class).findMallProductCategoryList(parentId);
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
    public int saveMallProductCategory(String mallProductCategory) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(ProductThriftRpcService.Client.class).saveMallProductCategory(mallProductCategory);
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
    public int updateMallProductCategory(String mallProductCategory) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(ProductThriftRpcService.Client.class).updateMallProductCategory(mallProductCategory);
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
    public int deleteMallProductCategory(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(ProductThriftRpcService.Client.class).deleteMallProductCategory(id);
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
    public String getMallProductCategory(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(ProductThriftRpcService.Client.class).getMallProductCategory(id);
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
}
