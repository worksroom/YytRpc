package com.yyt.print.rpc.client.info;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
import com.yyt.print.rpc.common.Constants;
import com.yyt.print.rpc.thrift.gen.InfoThriftRpcService;
import org.apache.thrift.TException;

import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
public class InfoClient implements InfoThriftRpcService.Iface {

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
    public int saveFragmentHome(String fragmentHome) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).saveFragmentHome(fragmentHome);
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
    public int updateFragmentHome(String fragmentHome) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).updateFragmentHome(fragmentHome);
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
    public int deleteFragmentHome(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).deleteFragmentHome(id);
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
    public String getFragmentHome(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).getFragmentHome(id);
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
    public String queryFragmentHomeByPage(Map<String, String> paramMap, int pageIndex, int pageSize) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).queryFragmentHomeByPage(paramMap, pageIndex, pageSize);
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
    public int saveInfoCategory(String category) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).saveInfoCategory(category);
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
    public int updateInfoCategory(String category) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).updateInfoCategory(category);
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
    public int deleteInfoCategory(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).deleteInfoCategory(id);
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
    public String getInfoCategory(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).getInfoCategory(id);
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
    public String findInfoCategoryByParentId(int parentId) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).findInfoCategoryByParentId(parentId);
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
    public String queryInfoCategoryByPage(Map<String, String> paramMap, int pageIndex, int pageSize) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).queryInfoCategoryByPage(paramMap, pageIndex, pageSize);
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
    public int saveInfoContent(String infoContent) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).saveInfoContent(infoContent);
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
    public int deleteInfoContent(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).deleteInfoContent(id);
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
    public int updateInfoContent(String infoContent) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).updateInfoContent(infoContent);
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
    public String getInfoContent(int id) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).getInfoContent(id);
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
    public String queryInfoContentByPage(Map<String, String> paramMap, int pageIndex, int pageSize) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).queryInfoContentByPage(paramMap, pageIndex, pageSize);
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
    public String queryInfoContentList(String title, String des, int id, int limit) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(InfoThriftRpcService.Client.class).queryInfoContentList(title, des, id, limit);
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
