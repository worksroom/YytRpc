package com.yyt.print.user.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.thirdparty.wx.TokenUtil;
import com.yyt.print.thirdparty.wx.WxResponse;
import com.yyt.print.thirdparty.wx.WxUserInfo;
import com.yyt.print.user.dao.*;
import com.yyt.print.user.pojo.DeliveryAddr;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserLoginLog;
import com.yyt.print.user.pojo.UserThirdBind;
import com.yyt.print.user.response.AuthResponse;
import com.yyt.print.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Service("userService")
public class UserService implements IUserService {
    @Resource
    private IUserDAO userDAO;
    @Resource
    private IUserSessionDAO userSessionDAO;
    @Resource
    private IUserLoginLogDAO userLoginLogDAO;
    @Resource
    private IUserThirdBindDAO userThirdBindDAO;

    @Resource
    private IDeliveryAddrDAO deliveryAddrDAO;

    @Override
    public int saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public List<User> getUserList(List<Integer> userIdList) {
        return userDAO.getUserList(userIdList);
    }

    @Override
    public Map<Integer, User> getUserMap(List<Integer> userIdList) {
        return userDAO.getUserMap(userIdList);
    }

    @Override
    public PageHolder<User> queryUserByPage(int userId, String userName, String nickName, String phone, int pageIndex, int pageSize) {
        return userDAO.queryUserByPage(userId, userName, nickName, phone, pageIndex, pageSize);
    }

    @Override
    public AuthResponse login(String username, String password, int type, String ip) {
        AuthResponse response = new AuthResponse();
        User user = null;
        switch (type){
            case 1://微信登录
                WxResponse wxResponse = TokenUtil.authToken(username, password);
                if (wxResponse.getCode() == 0) {
                    WxUserInfo wxUserInfo = TokenUtil.getWxUserInfo(username, password);
                    String unionid = wxUserInfo.getUnionid();
                    UserThirdBind userThirdBind = userThirdBindDAO.getUserThirdBind(unionid, type);
                    user = userDAO.getUser(userThirdBind.getUserId());
                } else {
                    response.setStatus("0013");
                    response.setMessage("微信授权失效");
                    return response;
                }
                break;
            case 2://QQ登录

            case 3://微博登录

            case 4://手机号登录

            case 5://普通账号密码登录
                user = userDAO.findUserByUsername(username);
                break;
            default:

        }

        if(user==null){
            response.setStatus("0011");
            response.setMessage("用户名错误");
            return response;
        }

        if((type == User.REGIST_GENERAL || type == User.REGIST_PHONE) && !password.equals(user.getPassword())){
            response.setStatus("0012");
            response.setMessage("密码错误");
            return response;
        }

        //生成并保存会话Session
        String session = userSessionDAO.genSession(user.getUserId());
        userSessionDAO.saveUserSession(user.getUserId(), session);

        //保存登录日志
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setUserId(user.getUserId());
        userLoginLog.setType(type);
        userLoginLog.setLastTime(new Date());
        userLoginLog.setIp(ip);
        userLoginLogDAO.saveUserLoginLog(userLoginLog);

        //设置返回值
        response.setStatus("0000");
        response.setMessage("登录成功");
        response.setUserId(user.getUserId());
        response.setNickName(user.getNickName());
        response.setSession(session);

        return response;
    }

    @Override
    public AuthResponse auth(String username, String session, String token, int type) {
        AuthResponse response = new AuthResponse();

        User user = null;

        switch (type){
            case 1://微信验证
                WxResponse wxResponse = TokenUtil.authToken(username, token);
                if (wxResponse.getCode() == 0) {
                    WxUserInfo wxUserInfo = TokenUtil.getWxUserInfo(username, token);
                    String unionid = wxUserInfo.getUnionid();
                    UserThirdBind userThirdBind = userThirdBindDAO.getUserThirdBind(unionid, type);
                    user = userDAO.getUser(userThirdBind.getUserId());
                } else {
                    response.setStatus("0013");
                    response.setMessage("微信授权失效");
                    return response;
                }
                break;
            case 2://QQ验证

            case 3://微博验证

            case 4://手机号验证

            case 5://普通账号密码验证
                user = userDAO.findUserByUsername(username);
                break;
            default:

        }

        String dbSession = userSessionDAO.getSession(user.getUserId());
        if(dbSession.equals(session)){
            response.setStatus("0000");
            response.setMessage("登录成功");
            response.setUserId(user.getUserId());
            response.setNickName(user.getNickName());
            response.setSession(session);
        } else {
            response.setStatus("0014");
            response.setMessage("会话失效，请重新登录");
        }
        return response;
    }


    @Transactional
    @Override
    public AuthResponse regist(String username, String password, int type, String nickname, String headImgUrl, String signature, String ip) {
        AuthResponse response = new AuthResponse();

        if(username==null || "".equals(username) || "".equals(username.trim())){
            response.setStatus("0014");
            response.setMessage("入参错误");
            return response;
        }

        if(password==null || "".equals(password) || "".equals(password.trim())){
            response.setStatus("0014");
            response.setMessage("入参错误");
            return response;
        }

        int result = 0;//注册成功标志，大于0表示注册成功
        switch (type){
            case 1://微信注册
                WxResponse wxResponse = TokenUtil.authToken(username, password);
                if (wxResponse.getCode() == 0) {
                    WxUserInfo wxUserInfo = TokenUtil.getWxUserInfo(username, password);
                    String unionid = wxUserInfo.getUnionid();

                    String userName = this.genUserName();
                    String userPwd = this.genPassword();

                    User user = new User();
                    user.setUserName(userName);
                    user.setNickName(wxUserInfo.getNickname());
                    user.setPassword(userPwd);
                    user.setUpdateTime(new Date());
                    user.setCreateTime(new Date());
                    result = userDAO.saveUser(user);

                    UserThirdBind bind = new UserThirdBind();
                    bind.setUserId(result);
                    bind.setType(type);
                    bind.setThirdId(unionid);
                    bind.setCreateTime(new Date());
                    result = userThirdBindDAO.saveUserThirdBind(bind);

                } else {
                    response.setStatus("0013");
                    response.setMessage("微信授权失效");
                    return response;
                }
                break;
            case 2://QQ注册

            case 3://微博注册

            case 4://手机号注册

            case 5://普通账号密码注册
                User user = new User();
                user.setUserName(username);
                user.setNickName(nickname);
                user.setPassword(password);
                user.setUpdateTime(new Date());
                user.setCreateTime(new Date());
                result = userDAO.saveUser(user);
                break;
            default:

        }

        if(result>0){
            return this.login(username, password, type, ip);
        }

        response.setStatus("0015");
        response.setMessage("注册失败");
        return response;
    }

    /**
     * 三方注册生成用户名
     * @return
     */
    private String genUserName(){
        return null;
    }

    /**
     * 三方注册生成密码
     * @return
     */
    private String genPassword(){
        return null;
    }


    @Override
    public int addUserAddr(DeliveryAddr userAddr) {
        return deliveryAddrDAO.saveDeliveryAddr(userAddr);
    }

    @Override
    public int updateUserAddr(DeliveryAddr userAddr) {
        return deliveryAddrDAO.updateDeliveryAddr(userAddr);
    }

    @Override
    public int delUserAddr(int id) {
        return deliveryAddrDAO.delDeliveryAddr(id);
    }

    @Override
    public DeliveryAddr getUserAddr(int id) {
        return deliveryAddrDAO.getDeliveryAddr(id);
    }

    @Override
    public List<DeliveryAddr> findUserAddr(int uid) {
        return deliveryAddrDAO.findUserAddr(uid);
    }

    @Override
    public DeliveryAddr findDefaultDeliveryAddr(int userId) {
        return deliveryAddrDAO.findDefaultDeliveryAddr(userId);
    }
}
