package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.UserThirdBind;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IUserThirdBindDAO {
    /**
     * 保存三方绑定关系
     * @param thirdBind
     * @return
     */
    public int saveUserThirdBind(UserThirdBind thirdBind);

    /**
     * 查询三方绑定关系
     * @param thirdId 三方ID
     * @param type 三方类型 {@link com.yyt.print.user.pojo.User}
     * @return
     */
    public UserThirdBind getUserThirdBind(String thirdId, int type);

    public UserThirdBind getUserThirdBind(int userId, int type);
}
