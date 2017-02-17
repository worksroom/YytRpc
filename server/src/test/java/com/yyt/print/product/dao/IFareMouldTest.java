package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.FareMould;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/17.
 */
public class IFareMouldTest extends BaseTestClass {

    IFareMouldDAO dao = getBean(IFareMouldDAO.class);

    private FareMould getBean(){
        FareMould s = new FareMould();
        s.setType(0);
        s.setShopId(1);
        s.setName("免运费");
        return s;
    }

    @Test
    public void saveFareMould(){
        dao.saveFareMould(getBean());
    }

    @Test
    public void getFareMould(){
        System.out.println(dao.getFareMould(1));
    }

    @Test
    public void delFareMould(){
        dao.delFareMould(1);
    }

    @Test
    public void updateFareMould(){
        FareMould s = this.getBean();
        s.setId(2);
        s.setType(1);
        s.setName("平邮");
        s.setNum(2);
        s.setPrice(15.00);
        dao.updateFareMould(s);
    }

    @Test
    public void findFareMoulds(){
        System.out.println(dao.findFareMoulds(1).size());
    }
}
