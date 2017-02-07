package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.MallProductCategoryProValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/2/7.
 */
public class IMallProductCategoryProValueDAOTest extends BaseTestClass {

    IMallProductCategoryProValueDAO dao =  getBean(IMallProductCategoryProValueDAO.class);

    private List<MallProductCategoryProValue> getBeans(){
        List<MallProductCategoryProValue> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            MallProductCategoryProValue pv = new MallProductCategoryProValue();
            pv.setName("尺寸_"+i);
            pv.setUpdateTime(new Date());
            pv.setRank(i);
            pv.setClassId(1);
            pv.setClassProId(1);
            pv.setCreateTime(new Date());
            pv.setPic(null);
            pv.setUsed(0);
            list.add(pv);
        }
        return list;

    }

    @Test
    public void batchSaveMallProductCategoryProValue() {
        System.out.println(dao.batchSaveMallProductCategoryProValue(this.getBeans()));
    }

    @Test
    public void findByClass(){
        System.out.println(dao.findByClass(1));
    }
}
