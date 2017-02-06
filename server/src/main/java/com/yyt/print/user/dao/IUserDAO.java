package com.yyt.print.user.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserBuyer;

import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserDAO {
    /**
     * 保存用户
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 查询用户
     * @param userId
     * @return
     */
    public User getUser(int userId);

    /**
     * 修改用户信息，用户ID，用户名不能更改
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 批量查询用户信息
     * @param userIdList
     * @return
     */
    public List<User> getUserList(List<Integer> userIdList);

    /**
     * 批量查询用户信息
     * @param userIdList
     * @return
     */
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

}
