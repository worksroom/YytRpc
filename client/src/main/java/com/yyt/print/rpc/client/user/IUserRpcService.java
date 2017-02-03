package com.yyt.print.rpc.client.user;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;
import com.yyt.print.user.pojo.UserThirdBind;

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

    public int saveUserThirdBind(UserThirdBind thirdBind);

    public UserThirdBind getUserThirdBind(String thirdId, int type);

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
}
