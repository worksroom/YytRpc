package com.yyt.print.rpc.client.user;

import com.yyt.print.rpc.client.YytRpcClientFactory;
import com.yyt.print.user.pojo.User;
import org.junit.Test;

public class UserRpcServiceImplTest {
    IUserRpcService userRpcService = YytRpcClientFactory.getUserRpcService();
    @Test
    public void testSaveUser() throws Exception {

    }

    @Test
    public void testGetUser() throws Exception {
        User user = userRpcService.getUser(3);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testGetUserList() throws Exception {

    }

    @Test
    public void testGetUserMap() throws Exception {

    }

    @Test
    public void testSaveUserThirdBind() throws Exception {

    }

    @Test
    public void testGetUserThirdBind() throws Exception {

    }

    @Test
    public void testSaveUserBuyer() throws Exception {

    }

    @Test
    public void testGetUserBuyer() throws Exception {

    }

    @Test
    public void testUpdateUserBuyer() throws Exception {

    }

    @Test
    public void testSaveUserSeller() throws Exception {

    }

    @Test
    public void testGetUserSeller() throws Exception {

    }

    @Test
    public void testUpdateUserSeller() throws Exception {

    }
}