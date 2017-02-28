package com.yyt.print.order.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.order.pojo.OrderAddr;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/28.
 */
public class IOrderAddrTest extends BaseTestClass {
    private IOrderAddrDAO orderAddrDAO = getBean(IOrderAddrDAO.class);

    private OrderAddr getOrderAddr(){
        OrderAddr od = new OrderAddr();
        od.setUserId(224);
        od.setCode("100000");
        od.setRegion("{\"chengshi\":102}");
        od.setAddr("复健大道13号");
        od.setPhone("13810436365");
        od.setName("asd");
        return od;
    }

    @Test
    public void saveOrderAddr(){
        orderAddrDAO.saveOrderAddr(getOrderAddr());
    }


}
