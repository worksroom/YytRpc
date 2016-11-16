package com.yyt.print.user.service.impl;

import com.yyt.print.user.dao.IUserSellerDAO;
import com.yyt.print.user.pojo.UserSeller;
import com.yyt.print.user.service.IUserSellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Service("userSellerService")
public class UserSellerService implements IUserSellerService {

    @Resource
    private IUserSellerDAO userSellerDAO;

    @Override
    public int saveUserSeller(UserSeller userSeller) {
        return userSellerDAO.saveUserSeller(userSeller);
    }

    @Override
    public UserSeller getUserSeller(int userId) {
        return userSellerDAO.getUserSeller(userId);
    }

    @Override
    public int updateUserSeller(UserSeller userSeller) {
        return userSellerDAO.updateUserSeller(userSeller);
    }
}
