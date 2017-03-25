package com.yyt.print.rpc.client.order;

import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.Orders;
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

    @Test
    public void addCollectShop(){
        service.addCollectShop(224, 1);
    };

    @Test
    public void delCollectShop(){
        service.delCollectShop(2);
    }

    @Test
    public void findCollectShop(){
        System.out.println(service.findCollectShop(224,1,10));
    }

    @Test
    public void addCollectGoods(){
        service.addCollectGoods(224,20);
    }

    @Test
    public void delCollectGoods(){
        service.delCollectGoods(2);
    }

    @Test
    public void findCollectGoods(){
        System.out.println(service.findCollectGoods(224, 1, 10));
    }

    /**
     * 获取用户收藏的数量
     * key shop 收藏的店铺
     * key goods 收藏的货品
     * @return
     */
    @Test
    public void getCollectCount(){
        System.out.println(service.getCollectCount(224));
    }


    /**
     * 获取用户收藏的数量
     * key 0 待付款
     * key 1 待发货
     * @return
     */
    @Test
    public void getOrderCount(){
        System.out.println(service.getOrderCount(224));
    }

    @Test
    public void getOrder(){
        Orders orders = service.getOrders("25");
    }
}
