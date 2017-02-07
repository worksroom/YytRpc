package com.yyt.print.user.service;

import com.yyt.print.user.pojo.UserErp;

/**
 * Created by leo on 2017/2/8.
 */
public interface IUserErpService {

    public int saveUserErp(int erpUid, String phone);

    public UserErp findUserErpByPhone(String phone);

}
