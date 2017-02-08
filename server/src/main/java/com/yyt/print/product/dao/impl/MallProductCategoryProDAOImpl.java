package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallProductCategoryProDAO;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/2/4.
 */
@Repository("mallProductCategoryProDAO")
public class MallProductCategoryProDAOImpl  extends YytBaseDAO<MallProductCategoryPro> implements IMallProductCategoryProDAO {
    @Override
    public int saveMallProductCategoryPro(MallProductCategoryPro pro) {
        pro.setCreateTime(new Date());
        return super.insert(pro);
    }

    @Override
    public int updateMallProductCategoryPro(MallProductCategoryPro pro) {
        pro.setUpdateTime(new Date());
        return super.update(pro);
    }


    @Override
    public List<MallProductCategoryPro> findByClass(int classId) {
        return super.findBy("findByClass",classId);
    }

    @Override
    public int deleteMallProductCategoryPro(int id) {

        return super.delete(id);
    }
}
