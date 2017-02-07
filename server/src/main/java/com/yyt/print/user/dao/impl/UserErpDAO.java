package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserErpDAO;
import com.yyt.print.user.pojo.UserErp;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by leo on 2017/2/8.
 */
@Repository
public class UserErpDAO extends YytBaseDAO<UserErp> implements IUserErpDAO {
    @Override
    public int saveUserErp(int erpUid, String phone) {
        UserErp userErp = new UserErp();
        userErp.setErpUid(erpUid);
        userErp.setPhone(phone);
        userErp.setCreateTime(new Date());
        return super.insert(userErp);
    }

    @Override
    public UserErp findUserErpByPhone(String phone) {
        return super.findUniqueBy("findUserErpByPhone", phone);
    }
}
