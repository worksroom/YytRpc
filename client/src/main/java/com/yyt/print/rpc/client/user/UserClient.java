package com.yyt.print.rpc.client.user;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
import com.yyt.print.rpc.common.Constants;
import com.yyt.print.rpc.thrift.gen.UserThriftRpcService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by SomeBody on 2016/9/27.
 */
public class UserClient implements UserThriftRpcService.Iface {

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
    public int saveUser(String user) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).saveUser(user);
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
    public String getUser(int userId) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).getUser(userId);
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
    public int updateUser(String user) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).updateUser(user);
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
    public String getUserList(List<Integer> userIdList) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).getUserList(userIdList);
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
    public String getUserMap(List<Integer> userIdList) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).getUserMap(userIdList);
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
    public String queryUserByPage(int userId, String userName, String nickName, String phone, int pageIndex, int pageSize) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).queryUserByPage(userId, userName, nickName, phone, pageIndex, pageSize);
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
    public String login(String username, String password, int type, String ip) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).login(username, password, type, ip);
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
    public String auth(String username, String session, String token, int type) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).auth(username, session, token, type);
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
    public String regist(String username, String password, int type, String nickname, String headImgUrl, String signature, String ip) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).regist(username, password, type, nickname, headImgUrl, signature, ip);
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
    public int saveUserBuyer(String userBuyer) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).saveUserBuyer(userBuyer);
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
    public String getUserBuyer(int userId) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).getUserBuyer(userId);
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
    public int updateUserBuyer(String userBuyer) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).updateUserBuyer(userBuyer);
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
    public String queryUserBuyerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).queryUserBuyerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
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
    public int saveUserSeller(String userSeller) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).saveUserSeller(userSeller);
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
    public String getUserSeller(int userId) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).getUserSeller(userId);
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
    public int updateUserSeller(String userSeller) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).updateUserSeller(userSeller);
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
    public String queryUserSellerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).queryUserSellerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
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
    public int saveUserThirdBind(String thirdBind) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).saveUserThirdBind(thirdBind);
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
    public String getUserThirdBind(String thirdId, int type) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).getUserThirdBind(thirdId, type);
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
    public int saveUserErp(int erpUid, String phone) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).saveUserErp(erpUid, phone);
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
    public String findUserErpByPhone(String phone) throws TException {
        RPCMultiplexConnection client = null;
        try {
            client = getConnection();
            return client.getClient(UserThriftRpcService.Client.class).findUserErpByPhone(phone);
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
