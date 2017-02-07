package com.yyt.print.user.service.impl;

import com.yyt.print.user.dao.IUserErpDAO;
import com.yyt.print.user.pojo.UserErp;
import com.yyt.print.user.service.IUserErpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by leo on 2017/2/8.
 */
@Service("userErpService")
public class UserErpService implements IUserErpService {
    @Resource
    private IUserErpDAO userErpDAO;

    @Override
    public int saveUserErp(int erpUid, String phone) {
        return userErpDAO.saveUserErp(erpUid, phone);
    }

    @Override
    public UserErp findUserErpByPhone(String phone) {
        return userErpDAO.findUserErpByPhone(phone);
    }
}
