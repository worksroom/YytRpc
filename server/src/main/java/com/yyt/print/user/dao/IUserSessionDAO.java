package com.yyt.print.user.dao;

/**
 * Created by leo on 2017/2/7.
 */
public interface IUserSessionDAO {

    /**
     * 保存session
     * @param userId 用户ID
     * @param session 回话ID
     * @return
     */
    public int saveUserSession(int userId, String session);

    /**
     * 查询session
     * @param userId
     * @return
     */
    public String getSession(int userId);

    /**
     * 生成Session格式{yyyyMMddHHmmss}{userId}
     * @param userId
     * @return
     */
    public String genSession(int userId);
}
