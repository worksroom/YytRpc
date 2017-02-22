package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IProductEvaluateRecordDAO;
import com.yyt.print.product.pojo.ProductEvaluateRecord;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/22.
 */
@Repository("productEvaluateRecordDAO")
public class ProductEvaluateRecordDAOImpl extends YytBaseDAO<ProductEvaluateRecord> implements IProductEvaluateRecordDAO {
    @Override
    public int saveProductEvaluateRecord(ProductEvaluateRecord productEvaluateRecord){
        productEvaluateRecord.setCreateTime(new Date());
        return super.insert(productEvaluateRecord);
    }
    @Override
    public int updateProductEvaluateRecord(ProductEvaluateRecord productEvaluateRecord){return super.update(productEvaluateRecord);}
    @Override
    public ProductEvaluateRecord getProductEvaluateRecord(int id){return super.get(id);}
    @Override
    public int delProductEvaluateRecord(int id){return super.delete(id);}

    @Override
    public List<ProductEvaluateRecord> findProductEvaluateList(int goodIds, int seq, int num) {
        Map<String,Object> map = new HashMap<>();

        if(seq<=0){
            seq = Integer.MAX_VALUE;
        }

        map.put("seq",seq);
        map.put("goodsId",goodIds);
        map.put("num",num);

        return super.findBy("selectByinc",map);
    }
}
