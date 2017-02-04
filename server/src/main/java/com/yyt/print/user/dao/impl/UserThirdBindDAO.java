package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserThirdBindDAO;
import com.yyt.print.user.pojo.UserThirdBind;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Repository
public class UserThirdBindDAO extends YytBaseDAO<UserThirdBind> implements IUserThirdBindDAO {
    @Override
    public int saveUserThirdBind(UserThirdBind thirdBind) {
        return this.insert(thirdBind);
    }

    @Override
    public UserThirdBind getUserThirdBind(String thirdId, int type) {
        Map<String, Object> map = new HashMap<>();
        map.put("thirdId", thirdId);
        map.put("type", type);
        return this.findUniqueBy("getUserThirdBind", map);
    }
}
