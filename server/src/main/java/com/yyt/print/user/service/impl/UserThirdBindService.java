package com.yyt.print.user.service.impl;

import com.yyt.print.user.dao.IUserThirdBindDAO;
import com.yyt.print.user.pojo.UserThirdBind;
import com.yyt.print.user.service.IUserThirdBindService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Service("userThirdBindService")
public class UserThirdBindService implements IUserThirdBindService {

    @Resource
    private IUserThirdBindDAO userThirdBindDAO;

    @Override
    public int saveUserThirdBind(UserThirdBind thirdBind) {
        return userThirdBindDAO.saveUserThirdBind(thirdBind);
    }

    @Override
    public UserThirdBind getUserThirdBind(String thirdId, int type) {
        return userThirdBindDAO.getUserThirdBind(thirdId, type);
    }
}
