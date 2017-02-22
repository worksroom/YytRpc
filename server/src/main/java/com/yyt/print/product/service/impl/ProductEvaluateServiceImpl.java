package com.yyt.print.product.service.impl;

import com.yyt.print.product.dao.IProductEvaluateDAO;
import com.yyt.print.product.dao.IProductEvaluateRecordDAO;
import com.yyt.print.product.pojo.ProductEvaluateRecord;
import com.yyt.print.product.service.IProductEvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/2/22.
 */
@Service("productEvaluateService")
public class ProductEvaluateServiceImpl implements IProductEvaluateService {

    @Resource
    private IProductEvaluateDAO iProductEvaluateDAO;

    @Resource
    private IProductEvaluateRecordDAO iProductEvaluateRecordDAO;

    @Override
    public int commentGoods(ProductEvaluateRecord pvr) {
        return iProductEvaluateRecordDAO.saveProductEvaluateRecord(pvr);
    }

    @Override
    public List<ProductEvaluateRecord> findProductEvaluateList(int goodIds, int seq, int num) {
        return iProductEvaluateRecordDAO.findProductEvaluateList(goodIds, seq, num);
    }
}
