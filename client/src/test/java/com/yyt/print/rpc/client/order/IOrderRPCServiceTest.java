package com.yyt.print.rpc.client.order;

import com.yyt.print.rpc.client.YytRpcClientFactory;
import org.junit.Test;
/**
 * Created by lenovo on 2017/2/28.
 */
public class IOrderRPCServiceTest {
    IOrderRPCService service = YytRpcClientFactory.getOrderRPCService();

    @Test
    public void addShopCart(){
        service.addShopCart(22,2,1);
    }

    @Test
    public void delShopCart(){
        service.delShopCart(1);
    }

    @Test
    public void updateShopNum(){
        service.updateShopNum(1,10);
    }

    @Test
    public void findUserShopCart(){
        System.out.println(service.findUserShopCart(22));
    }
}
