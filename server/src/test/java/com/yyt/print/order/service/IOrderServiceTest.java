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
}
