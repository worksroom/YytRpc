package com.yyt.print.rpc.client.user;

import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;
import com.yyt.print.user.pojo.UserThirdBind;

import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/22.
 */
public interface IUserRpcService {
    public int saveUser(User user);

    public User getUser(int userId);

    /**
     * 用户ID，用户名不能更改
     * @param user
     * @return
     */
    public int updateUser(User user);

    public List<User> getUserList(List<Integer> userIdList);

    public Map<Integer, User> getUserMap(List<Integer> userIdList);

    public int saveUserThirdBind(UserThirdBind thirdBind);

    public UserThirdBind getUserThirdBind(String thirdId, int type);

    public int saveUserBuyer(UserBuyer userBuyer);

    public UserBuyer getUserBuyer(int userId);

    public int updateUserBuyer(UserBuyer userBuyer);

    public int saveUserSeller(UserSeller userSeller);

    public UserSeller getUserSeller(int userId);

    public int updateUserSeller(UserSeller userSeller);
}
