package com.yyt.print.user.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.dao.IUserDAO;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Service("userService")
public class UserService implements IUserService {
    @Resource
    private IUserDAO userDAO;

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
}
