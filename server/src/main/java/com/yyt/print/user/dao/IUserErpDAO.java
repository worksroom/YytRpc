package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.UserErp;

/**
 * Created by leo on 2017/2/8.
 */
public interface IUserErpDAO {
    public int saveUserErp(int erpUid, String phone);

    public UserErp findUserErpByPhone(String phone);
}
