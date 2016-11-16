package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IUserDAO;
import com.yyt.print.user.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
@Repository
public class UserDAO extends YytBaseDAO<User> implements IUserDAO {
    @Override
    public int saveUser(User user) {
        return this.insert(user);
    }

    @Override
    public User getUser(int userId) {
        return this.findUniqueBy("findByUserId", userId);
    }

    @Override
    public int updateUser(User user) {
        return this.update(user);
    }

    @Override
    public List<User> getUserList(List<Integer> userIdList) {
        return this.findBy("findByUserIdList", userIdList);
    }

    @Override
    public Map<Integer, User> getUserMap(List<Integer> userIdList) {
        Map<Integer, User> resultMap = new HashMap<>();
        List<User> list = this.getUserList(userIdList);
        if(list!=null && list.size()>0){
            for(User user : list){
                resultMap.put(user.getUserId(), user);
            }
        }
        return resultMap;
    }
}
