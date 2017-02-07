package com.yyt.print.user.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.pojo.User;

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


}
