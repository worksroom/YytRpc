package com.yyt.print.product.service;

import com.yyt.print.product.pojo.ProductEvaluateRecord;

import java.util.List;

/**
 * Created by leo on 2016/11/24.
 */
public interface IProductEvaluateService {
    /**
     * 增加一条评论
     * @return
     */
    int commentGoods(ProductEvaluateRecord pvr);

    /**
     * 查询货品的评论
     * @param goodIds
     * @param seq
     * @param num
     * @return
     */
    List<ProductEvaluateRecord> findProductEvaluateList(int goodIds,int seq,int num);
}
