package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.StoreLocation;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/17.
 */
public class IStoreLocationTest extends BaseTestClass {

    IStoreLocationDAO dao = getBean(IStoreLocationDAO.class);

    private StoreLocation getBean(){
        StoreLocation s = new StoreLocation();
        s.setfCode(1);
        s.setfName("北京");
        s.setsCode(12);
        s.setsName("朝阳区");
        s.setShopId(1);
        return s;
    }

    @Test
    public void saveStoreLocation(){
        dao.saveStoreLocation(getBean());
    }

    @Test
    public void getStoreLocation(){
        System.out.println(dao.getStoreLocation(1));
    }

    @Test
    public void delStoreLocation(){
        dao.delStoreLocation(1);
    }

    @Test
    public void updateStoreLocation(){
        StoreLocation s = this.getBean();
        s.setId(2);
        s.setsName("海淀区");
        dao.updateStoreLocation(s);
    }

    @Test
    public void findStoreLocations(){
        System.out.println(dao.findStoreLocations(1).size());
    }
}
