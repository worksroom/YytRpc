package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.youguu.core.util.PageHolder;
import com.yyt.print.parser.PageHolderSerializer;
import com.yyt.print.rpc.thrift.gen.UserThriftRpcService;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;
import com.yyt.print.user.pojo.UserThirdBind;
import com.yyt.print.user.response.AuthResponse;
import com.yyt.print.user.service.IUserBuyerService;
import com.yyt.print.user.service.IUserSellerService;
import com.yyt.print.user.service.IUserService;
import com.yyt.print.user.service.IUserThirdBindService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Service("userThriftRpcService")
public class UserThriftRpcServiceImpl implements UserThriftRpcService.Iface {
    @Resource
    private IUserBuyerService userBuyerService;
    @Resource
    private IUserSellerService userSellerService;
    @Resource
    private IUserService userService;
    @Resource
    private IUserThirdBindService userThirdBindService;

    @Override
    public int saveUser(String user) throws TException {
        User u = JSONObject.parseObject(user, User.class);
        return userService.saveUser(u);
    }

    @Override
    public String getUser(int userId) throws TException {
        User u = userService.getUser(userId);
        return JSON.toJSONString(u);
    }

    @Override
    public int updateUser(String user) throws TException {
        User u = JSONObject.parseObject(user, User.class);
        return userService.updateUser(u);
    }

    @Override
    public String getUserList(List<Integer> userIdList) throws TException {
        List<User> list = userService.getUserList(userIdList);
        return JSON.toJSONString(list);
    }

    @Override
    public String getUserMap(List<Integer> userIdList) throws TException {
        Map<Integer, User> map = userService.getUserMap(userIdList);
        return JSON.toJSONString(map, true);
    }

    @Override
    public String queryUserByPage(int userId, String userName, String nickName, String phone, int pageIndex, int pageSize) throws TException {
        PageHolder<User> pageHolder = userService.queryUserByPage(userId, userName, nickName, phone, pageIndex, pageSize);
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }

    @Override
    public String login(String username, String password, int type, String ip) throws TException {
        AuthResponse rs = userService.login(username, password, type, ip);
        return JSON.toJSONString(rs);
    }

    @Override
    public String auth(String username, String session, String token, int type) throws TException {
        AuthResponse rs = userService.auth(username, session, token, type);
        return JSON.toJSONString(rs);
    }

    @Override
    public String regist(String username, String password, int type, String nickname, String headImgUrl, String signature, String ip) throws TException {
        AuthResponse rs = userService.regist(username, password, type, nickname, headImgUrl, signature, ip);
        return JSON.toJSONString(rs);
    }

    @Override
    public int saveUserBuyer(String userBuyer) throws TException {
        UserBuyer buyer = JSONObject.parseObject(userBuyer, UserBuyer.class);
        return userBuyerService.saveUserBuyer(buyer);
    }

    @Override
    public String getUserBuyer(int userId) throws TException {
        UserBuyer userBuyer = userBuyerService.getUserBuyer(userId);
        return JSON.toJSONString(userBuyer);
    }

    @Override
    public int updateUserBuyer(String userBuyer) throws TException {
        UserBuyer buyer = JSONObject.parseObject(userBuyer, UserBuyer.class);
        return userBuyerService.updateUserBuyer(buyer);
    }

    @Override
    public String queryUserBuyerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) throws TException {
        PageHolder<UserBuyer> pageHolder = userBuyerService.queryUserBuyerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }

    @Override
    public int saveUserSeller(String userSeller) throws TException {
        UserSeller seller = JSONObject.parseObject(userSeller, UserSeller.class);
        return userSellerService.saveUserSeller(seller);
    }

    @Override
    public String getUserSeller(int userId) throws TException {
        UserSeller seller = userSellerService.getUserSeller(userId);
        return JSON.toJSONString(seller);
    }

    @Override
    public int updateUserSeller(String userSeller) throws TException {
        UserSeller seller = JSONObject.parseObject(userSeller, UserSeller.class);
        return userSellerService.updateUserSeller(seller);
    }

    @Override
    public String queryUserSellerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) throws TException {
        PageHolder<UserSeller> pageHolder = userSellerService.queryUserSellerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }

    @Override
    public int saveUserThirdBind(String thirdBind) throws TException {
        UserThirdBind userThirdBind = JSONObject.parseObject(thirdBind, UserThirdBind.class);
        return userThirdBindService.saveUserThirdBind(userThirdBind);
    }

    @Override
    public String getUserThirdBind(String thirdId, int type) throws TException {
        UserThirdBind userThirdBind = userThirdBindService.getUserThirdBind(thirdId, type);
        return JSON.toJSONString(userThirdBind);
    }
}
