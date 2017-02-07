package com.yyt.print.user.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.response.AuthResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IUserService {
    public int saveUser(User user);

    public User getUser(int userId);

    /**
     * 用户ID，用户名不能更改
     * @param user
     * @return
     */
    public int updateUser(User user);

    public List<User> getUserList(List<Integer> userIdList);

    public Map<Integer, User> getUserMap(List<Integer> userIdList);

    /**
     * 分页查询用户，管理平台调用此接口
     * @param userId
     * @param userName
     * @param nickName
     * @param phone
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageHolder<User> queryUserByPage(int userId, String userName, String nickName, String phone, int pageIndex, int pageSize);

    /**
     * 用户登录接口
     * @param username 用户名，三方注册时此字段代表openid
     * @param password 密码，三方注册时此字段代表token令牌
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @param ip IP地址
     * @return
     */
    public AuthResponse login(String username, String password, int type, String ip);

    /**
     * session验证接口
     * @param username 用户名，第三方登录时此字段代表openid
     * @param session 系统生成的会话ID
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @param token 第三方token
     * @return
     */
    public AuthResponse auth(String username, String session, String token, int type);

    /**
     * 用户注册接口
     * @param username 用户名，三方注册时此字段代表openid
     * @param password 密码，三方注册时此字段代表token令牌
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @param nickname 昵称，三方注册时使用第三方的昵称
     * @param headImgUrl 头像地址
     * @param signature 签名
     * @param ip IP地址
     * @return
     */
    public AuthResponse regist(String username, String password, int type, String nickname, String headImgUrl, String signature, String ip);

}
