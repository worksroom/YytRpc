package com.yyt.print.rpc.client.user;

import com.youguu.core.util.PageHolder;
import com.yyt.print.rpc.client.YytRpcClientFactory;
import com.yyt.print.user.pojo.User;
import com.yyt.print.user.pojo.UserBuyer;
import com.yyt.print.user.pojo.UserSeller;
import org.junit.Test;

import java.util.Date;

public class UserRpcServiceImplTest {
    IUserRpcService userRpcService = YytRpcClientFactory.getUserRpcService();

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setUserId(2);
        user.setUserName("李四");
        user.setPassword("111111");
        user.setNickName("哈哈");
        user.setPhone("18811114444");
        user.setEmail("123@qq.com");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        userRpcService.saveUser(user);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userRpcService.getUser(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("张三");
        user.setPassword("123456");
        user.setNickName("打不死的小强");
        user.setPhone("18811113333");
        user.setEmail("123@qq.com");
        user.setUpdateTime(new Date());
        userRpcService.updateUser(user);
    }

    @Test
    public void testGetUserList() throws Exception {

    }

    @Test
    public void testGetUserMap() throws Exception {

    }

    @Test
    public void testQueryUserByPage() throws Exception {
        PageHolder<User> pageHolder = userRpcService.queryUserByPage(0, "", "", "", 1, 20);
        if (pageHolder!=null){
            for(User user : pageHolder){
                System.out.println(user);
            }
        }
    }

    @Test
    public void testSaveUserThirdBind() throws Exception {

    }

    @Test
    public void testGetUserThirdBind() throws Exception {

    }

    @Test
    public void testSaveUserBuyer() throws Exception {
        UserBuyer buyer = new UserBuyer();
        buyer.setUserId(2);
        buyer.setName("李四");
        buyer.setCardNumber("1013479234729342");
        buyer.setUserCardPhoto("");
        buyer.setCardBPhoto("");
        buyer.setCardFPhoto("");
        buyer.setCreateTime(new Date());
        buyer.setUpdateTime(new Date());
        buyer.setMsg("success");
        buyer.setStatus(1);
        userRpcService.saveUserBuyer(buyer);
    }

    @Test
    public void testGetUserBuyer() throws Exception {
        UserBuyer buyer = userRpcService.getUserBuyer(1);
        System.out.println(buyer);
    }

    @Test
    public void testUpdateUserBuyer() throws Exception {
        UserBuyer buyer = new UserBuyer();
        buyer.setUserId(2);
        buyer.setName("李四");
        buyer.setCardNumber("1111111111111111111");
        buyer.setUserCardPhoto("");
        buyer.setCardBPhoto("");
        buyer.setCardFPhoto("");
        buyer.setUpdateTime(new Date());
        buyer.setMsg("success");
        buyer.setStatus(1);
        userRpcService.updateUserBuyer(buyer);
    }

    @Test
    public void testQueryUserBuyerByPage() throws Exception{
        PageHolder<UserBuyer> pageHolder = userRpcService.queryUserBuyerByPage(0, null, null, null, null, null, 1, 10);
        if (pageHolder!=null){
            for(UserBuyer buyer : pageHolder){
                System.out.println(buyer);
            }
        }
    }

    @Test
    public void testSaveUserSeller() throws Exception {
        UserSeller seller = new UserSeller();
        seller.setUserId(2);
        seller.setName("李四");
        seller.setCardNumber("1013479234729342");
        seller.setUserCardPhoto("");
        seller.setCardBPhoto("");
        seller.setCardFPhoto("");
        seller.setLicencePhone("");
        seller.setCreateTime(new Date());
        seller.setUpdateTime(new Date());
        seller.setMsg("success");
        seller.setStatus(1);
        userRpcService.saveUserSeller(seller);
    }

    @Test
    public void testGetUserSeller() throws Exception {
        UserSeller seller = userRpcService.getUserSeller(2);
        System.out.println(seller);
    }

    @Test
    public void testUpdateUserSeller() throws Exception {
        UserSeller seller = new UserSeller();
        seller.setUserId(2);
        seller.setName("李四");
        seller.setCardNumber("1013479234729355");
        seller.setUserCardPhoto("");
        seller.setCardBPhoto("");
        seller.setCardFPhoto("");
        seller.setLicencePhone("");
        seller.setCreateTime(new Date());
        seller.setUpdateTime(new Date());
        seller.setMsg("success");
        seller.setStatus(1);
        userRpcService.updateUserSeller(seller);
    }

    @Test
    public void testQueryUserSellerByPage() throws Exception{
        PageHolder<UserSeller> pageHolder = userRpcService.queryUserSellerByPage(0, null, null, null, null, null, 1, 10);
        if (pageHolder!=null){
            for(UserSeller seller : pageHolder){
                System.out.println(seller);
            }
        }
    }
}