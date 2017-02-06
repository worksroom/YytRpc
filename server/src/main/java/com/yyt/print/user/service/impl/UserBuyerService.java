package com.yyt.print.user.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.user.dao.IUserBuyerDAO;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.service.IUserBuyerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Service("userBuyerService")
public class UserBuyerService implements IUserBuyerService {
    @Resource
    private IUserBuyerDAO userBuyerDAO;
    
    @Override
    public int saveUserBuyer(UserBuyer userBuyer) {
        return userBuyerDAO.saveUserBuyer(userBuyer);
    }

    @Override
    public UserBuyer getUserBuyer(int userId) {
        return userBuyerDAO.getUserBuyer(userId);
    }

    @Override
    public int updateUserBuyer(UserBuyer userBuyer) {
        return userBuyerDAO.updateUserBuyer(userBuyer);
    }

    @Override
    public PageHolder<UserBuyer> queryUserBuyerByPage(int userId, String userName, String nickName, String phone, String cardNumber, String name, int pageIndex, int pageSize) {
        return userBuyerDAO.queryUserBuyerByPage(userId, userName, nickName, phone, cardNumber, name, pageIndex, pageSize);
    }
}
