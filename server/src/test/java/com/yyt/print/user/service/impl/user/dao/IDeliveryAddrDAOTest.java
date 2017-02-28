package com.yyt.print.user.service.impl.user.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.user.dao.IDeliveryAddrDAO;
import com.yyt.print.user.pojo.DeliveryAddr;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2017/2/28.
 */
public class IDeliveryAddrDAOTest extends BaseTestClass {
    private IDeliveryAddrDAO dao = getBean(IDeliveryAddrDAO.class);

    private DeliveryAddr getDeliveryAddr(){
        DeliveryAddr d = new DeliveryAddr();
        d.setName("测试");
        d.setAddr("大道1号");
        d.setPhone("13810436365");
        d.setRegion("{\"chengshi:11\"}");
        d.setCode("100000");
        d.setTel("");
        d.setUserId(224);
        return d;
    }

    @Test
    public void saveDeliveryAddr(){
        dao.saveDeliveryAddr(getDeliveryAddr());
    }

    @Test
    public void updateDeliveryAddr(){
        DeliveryAddr d = dao.getDeliveryAddr(1);
        d.setName("改了");
        dao.updateDeliveryAddr(d);
    }

    @Test
    public void delDeliveryAddr(){
        dao.delDeliveryAddr(1);
    }

    @Test
    public void findUserAddr(){
        System.out.println(dao.findUserAddr(224));
    }

}
