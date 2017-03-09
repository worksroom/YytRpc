package com.yyt.print.product.dao;

import com.yyt.print.base.BaseTestClass;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.query.MallGoodsQuery;
import org.junit.Test;

import java.util.Date;
/**
 * Created by lenovo on 2017/2/12.
 */
public class IMallGoodsDAOTest extends BaseTestClass {
    IMallGoodsDAO dao = getBean(IMallGoodsDAO.class);
    private MallGoods getBean(){
        MallGoods good = new MallGoods();
        good.setName("衣服");
        good.setShopId(1);
        good.setShopName("leo小店");
        good.setCreateTime(new Date());
        good.setClassId(1);
        good.setDes("上衣的");
        good.setStatus(0);
        good.setUpdateTime(new Date());
        return good;
    }

    @Test
    public void testSaveMallGoods(){
        MallGoods mallGoods = getBean();
        System.out.println(dao.saveMallGoods(mallGoods));
        System.out.println(mallGoods.getId());
    }

    @Test
    public void testUpdateMallGoods(){
        MallGoods good = this.getBean();
        good.setId(1);
        good.setName("不干胶");
        dao.updateMallGoods(good);
    }

    @Test
    public void testGetMallGoods(){
        System.out.println(dao.getMallGoods(1));
    }

    @Test
    public void findMallGoods(){
        MallGoodsQuery query = new MallGoodsQuery();
        query.setName("不干胶");
        query.setNeedCount(false);
        System.out.println(dao.findMallGoods(query).size());
    }

    @Test
    public void testUpdateStatus(){
        dao.reviewMallGoods(1,false);
    }
}
