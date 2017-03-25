package com.yyt.print.product.service.impl;

import com.yyt.print.order.dao.IOrdersDAO;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.product.dao.IProductEvaluateDAO;
import com.yyt.print.product.dao.IProductEvaluateRecordDAO;
import com.yyt.print.product.pojo.ProductEvaluate;
import com.yyt.print.product.pojo.ProductEvaluateRecord;
import com.yyt.print.product.service.IProductEvaluateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private IOrdersDAO ordersDAO;


    @Transactional
    @Override
    public int rate(int buyerId, int sellerId, String orderId, int goodsId, int score, String content, String imgs, int anonymous) {
        //1、增加评价记录
        ProductEvaluateRecord productEvaluateRecord = new ProductEvaluateRecord();
        productEvaluateRecord.setGoodsId(goodsId);
        productEvaluateRecord.setSellUserId(sellerId);
        productEvaluateRecord.setBuyUserId(buyerId);
        productEvaluateRecord.setOrderId(orderId);
        productEvaluateRecord.setStar(score);
        productEvaluateRecord.setContent(content);
        productEvaluateRecord.setImg(imgs);
        productEvaluateRecord.setCreateTime(new Date());
        iProductEvaluateRecordDAO.saveProductEvaluateRecord(productEvaluateRecord);

        //2、修改商品评价汇总表
        ProductEvaluate productEvaluate = new ProductEvaluate();
        productEvaluate.setGoodsId(goodsId);
        productEvaluate.setTotalNum(1);
        productEvaluate.setTotalStar(score);
//        productEvaluate.setRate();
//        productEvaluate.setProductSpec();
        productEvaluate.setUpdateTime(new Date());
        productEvaluate.setCreateTime(new Date());

        iProductEvaluateDAO.saveProductEvaluate(productEvaluate);

        //3、修改订单状态为'已评价'
        ordersDAO.updateStatus(orderId, Orders.STATUS_EVALUATE);

        return 1;
    }

    @Override
    public List<ProductEvaluateRecord> findProductEvaluateList(int goodIds, int seq, int num) {
        return iProductEvaluateRecordDAO.findProductEvaluateList(goodIds, seq, num);
    }
}
