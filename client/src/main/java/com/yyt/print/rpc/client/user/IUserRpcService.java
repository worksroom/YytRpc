package com.yyt.print.rpc.client.user;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.pojo.*;
import com.yyt.print.user.response.AuthResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/22.
 */
public interface IUserRpcService {
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


    public int saveUserThirdBind(UserThirdBind thirdBind);

    public UserThirdBind getUserThirdBind(String thirdId, int type);

    public UserThirdBind getUserThirdBind(int userId, int type);

    /**
     * 保存买家认证信息
     * @param userBuyer
     * @return
     */
    public int saveUserBuyer(UserBuyer userBuyer);

    /**
     * 查询买家认证信息
     * @param userId
     * @return
     */
    public UserBuyer getUserBuyer(int userId);

    /**
     * 修改买家认证信息
     * @param userBuyer
     * @return
     */
    public int updateUserBuyer(UserBuyer userBuyer);

    /**
     * 查询买家认证信息(搜索)
     * @param userId 用户ID
     * @param userName 用户名
     * @param nickName 昵称
     * @param phone 手机号
     * @param cardNumber 身份证号码
     * @param name 用户姓名
     * @param pageIndex 页数
     * @param pageSize 每页显示条数
     * @return
     */
    public PageHolder<UserBuyer> queryUserBuyerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize);

    /**
     * 保存卖家信息
     * @param userSeller
     * @return
     */
    public int saveUserSeller(UserSeller userSeller);

    /**
     * 查询卖家信息
     * @param userId
     * @return
     */
    public UserSeller getUserSeller(int userId);

    /**
     * 修改卖家信息
     * @param userSeller
     * @return
     */
    public int updateUserSeller(UserSeller userSeller);

    /**
     * 查询卖家认证信息(搜索)
     * @param userId 用户ID
     * @param userName 用户名
     * @param nickName 昵称
     * @param phone 手机号
     * @param cardNumber 身份证号码
     * @param name 用户姓名
     * @param pageIndex 页数
     * @param pageSize 每页显示条数
     * @return
     */
    public PageHolder<UserSeller> queryUserSellerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize);


    public int saveUserErp(int erpUid, String phone);

    public UserErp findUserErpByPhone(String phone);


    /** 添加收货地址 **/
    int addUserAddr(DeliveryAddr UserAddr);

    /** 修改收货地址 **/
    int updateUserAddr(DeliveryAddr UserAddr);

    /** 删除收货地址 **/
    int delUserAddr(int id);

    /** 获取收货地址 **/
    DeliveryAddr getUserAddr(int id);

    /** 查询收货地址 **/
    List<DeliveryAddr> findUserAddr(int uid);
}
