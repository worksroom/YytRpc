package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserDAO {
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
}
