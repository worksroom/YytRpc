package com.yyt.print.order.service;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.query.OrdersQuery;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/1.
 */
public class IOrderServiceTest extends BaseTestClass {
    IOrderService service  = getBean(IOrderService.class);

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
    public void makeOrder(){
        service.makeOrder(224,3,getlist(),null);
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
        service.addCollectShop(224,12);
    }

    @Test
    public void delCollectShop(){
        service.delCollectShop(1);
    }

    @Test
    public void findCollectShop(){
        System.out.println(service.findCollectShop(224, 1, 10));
    }


    @Test
    public void addCollectGoods(){
        service.addCollectGoods(224, 20);
    }

    @Test
    public void delCollectGoods(){
        service.delCollectGoods(1);
    }

    @Test
    public void findCollectGoods(){
        service.findCollectGoods(224, 1, 10);
    }

    @Test
    public void getCollectCount(){
        System.out.println(service.getCollectCount(224));
    }

    @Test
    public void getOrderCount(){
        System.out.println(service.getOrderCount(1));
    }

    @Test
    public void isCollectShop(){
        System.out.println(service.isCollectShop(224,12));
    }

    @Test
    public void isCollectGoods(){
        System.out.println(service.isCollectGoods(224,2));
    }
}
