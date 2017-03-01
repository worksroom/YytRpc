package com.yyt.print.rpc.client.order;

import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.query.OrdersQuery;
import com.yyt.print.rpc.client.YytRpcClientFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void makeOrder(){
        service.makeOrder(224,3,getlist(),null);
    }

    private List<OrderProductFront> getlist(){
        List<OrderProductFront> list = new ArrayList<>();
        OrderProductFront opf = new OrderProductFront();
        opf.setShopId(1);
        opf.setAddr(3);
        opf.setNum(1);
        opf.setProductId(15);
        list.add(opf);
        return list;
    }
    @Test
    public void findOrders(){
        OrdersQuery query = new OrdersQuery();
        query.setShopId(1);
        System.out.println(service.findOrders(query));
    }
    @Test
    public void updateOrderPrice(){
        System.out.println(service.updateOrderPrice("20170301171212002224", 12.00));
    }

    @Test
    public void confirmExpress(){
        System.out.println(service.confirmExpress("20170301171212002224", 1, "11111"));
    }
}
