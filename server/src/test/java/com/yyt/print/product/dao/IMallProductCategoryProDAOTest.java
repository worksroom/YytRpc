package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public class IMallProductCategoryProDAOTest extends BaseTestClass {

    IMallProductCategoryProDAO dao =  getBean(IMallProductCategoryProDAO.class);
    private MallProductCategoryPro getBean(){
        MallProductCategoryPro pro = new MallProductCategoryPro();
        pro.setClassId(1);
        pro.setCreateTime(new Date());
        pro.setIsNeed(0);
        pro.setIsSearch(0);
        pro.setName("颜色");
        pro.setType(1);
        pro.setRank(1);
        pro.setUpdateTime(new Date());
        return pro;
    }
    /**
     * 增加属性
     * @return
     */
    @Test
    public void testSaveMallProductCategoryPro(){
        dao.saveMallProductCategoryPro(this.getBean());
    }

    @Test
    public void testUpdateMallProductCategoryPro(){
        MallProductCategoryPro pro = this.getBean();
        pro.setId(1);
        pro.setName("尺码");
        dao.updateMallProductCategoryPro(pro);
    }

    @Test
    public void testFindByClass(){
        System.out.println(dao.findByClass(1));
    }

    @Test
    public void deleteMallProductCategoryPro(){
        dao.deleteMallProductCategoryPro(2);
    }


}
