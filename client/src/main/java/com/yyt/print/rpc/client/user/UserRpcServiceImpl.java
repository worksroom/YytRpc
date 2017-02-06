package com.yyt.print.rpc.client.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.rpc.common.Constants;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;
import com.yyt.print.user.pojo.UserThirdBind;
import org.apache.thrift.TException;

import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
public class UserRpcServiceImpl implements IUserRpcService {

    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);

    private UserClient getClient() {
        return new UserClient();
    }

    @Override
    public int saveUser(User user) {
        try {
            return getClient().saveUser(JSON.toJSONString(user));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public User getUser(int userId) {
        try {
            String json = getClient().getUser(userId);
            return JSONObject.parseObject(json, User.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int updateUser(User user) {
        try {
            return getClient().updateUser(JSON.toJSONString(user));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<User> getUserList(List<Integer> userIdList) {
        try {
            String json = getClient().getUserList(userIdList);
            return JSONArray.parseArray(json, User.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Map<Integer, User> getUserMap(List<Integer> userIdList) {
        try {
            String json = getClient().getUserList(userIdList);
            return (Map<Integer,User>)JSON.parse(json);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<User> queryUserByPage(int userId, String userName, String nickName, String phone, int pageIndex, int pageSize) {
        try {
            String json = getClient().queryUserByPage(userId, userName, nickName, phone, pageIndex, pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(json, new TypeReference<PageHolder<User>>(){});
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveUserThirdBind(UserThirdBind thirdBind) {
        try {
            return getClient().saveUserThirdBind(JSON.toJSONString(thirdBind));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public UserThirdBind getUserThirdBind(String thirdId, int type) {
        try {
            String json = getClient().getUserThirdBind(thirdId, type);
            return JSONObject.parseObject(json, UserThirdBind.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveUserBuyer(UserBuyer userBuyer) {
        try {
            return getClient().saveUserBuyer(JSON.toJSONString(userBuyer));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public UserBuyer getUserBuyer(int userId) {
        try {
            String json = getClient().getUserBuyer(userId);
            return JSONObject.parseObject(json, UserBuyer.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int updateUserBuyer(UserBuyer userBuyer) {
        try {
            return getClient().updateUserBuyer(JSON.toJSONString(userBuyer));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public PageHolder<UserBuyer> queryUserBuyerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) {
        try {
            String json = getClient().queryUserBuyerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(json, new TypeReference<PageHolder<UserBuyer>>(){});
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveUserSeller(UserSeller userSeller) {
        try {
            return getClient().saveUserSeller(JSON.toJSONString(userSeller));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public UserSeller getUserSeller(int userId) {
        try {
            String json = getClient().getUserSeller(userId);
            return JSONObject.parseObject(json, UserSeller.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int updateUserSeller(UserSeller userSeller) {
        try {
            return getClient().updateUserSeller(JSON.toJSONString(userSeller));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public PageHolder<UserSeller> queryUserSellerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) {
        try {
            String json = getClient().queryUserSellerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(json, new TypeReference<PageHolder<UserSeller>>(){});
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
