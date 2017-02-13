package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.MallIndex;
import org.junit.Test;

/**
 * Created by lenovo on 2017/2/13.
 */
public class IMallIndexDAOTest  extends BaseTestClass {
    IMallIndexDAO dao = getBean(IMallIndexDAO.class);
    private MallIndex getBean(){
        MallIndex index = new MallIndex();
        index.setStatus(0);
        index.setName("第一排");
        index.setContent("测试");
        index.setRank(1);
        index.setType(1);
        return index;
    }

    @Test
    public void saveMallIndex(){
        dao.saveMallIndex(getBean());
    }

    @Test
    public void updateMallIndex(){
        MallIndex index = this.getBean();
        index.setId(1);
        index.setName("测试一下");
        dao.updateMallIndex(index);
    }

    @Test
    public void updateStatus(){
        dao.updateStatus(1,false);
    }

    @Test
    public void queryMallIndex(){
        System.out.println(dao.queryMallIndex(-1,1,10).size());

    }

    @Test
    public void queryUserMallIndex(){
        System.out.println(dao.queryUserMallIndex());
    }
}
