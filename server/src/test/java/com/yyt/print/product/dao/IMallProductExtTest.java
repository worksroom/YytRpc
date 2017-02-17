package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.MallProductExt;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/17.
 */
public class IMallProductExtTest extends BaseTestClass {

    IMallProductExtDAO dao = getBean(IMallProductExtDAO.class);

    private MallProductExt getBean(){
        MallProductExt m = new MallProductExt();
        m.setGoodsId(1);
        m.setType(1);
        m.setThridId(2);
        return m;
    }

    @Test
    public void saveMallProductExt(){
        dao.saveMallProductExt(getBean());
    }

    @Test
    public void getMallProductExt(){
        System.out.println(dao.getMallProductExt(1));
    }

    @Test
    public void delMallProductExt(){
        dao.delMallProductExt(1);
    }



    @Test
    public void findMallProductExt(){
        System.out.println(dao.findMallProductExt(1).size());
    }
}
