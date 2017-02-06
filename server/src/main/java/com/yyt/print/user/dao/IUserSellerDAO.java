package com.yyt.print.user.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserSellerDAO {
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
