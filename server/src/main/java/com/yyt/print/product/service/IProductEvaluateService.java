package com.yyt.print.product.service;

import com.yyt.print.product.pojo.ProductEvaluateRecord;

import java.util.List;

/**
 * Created by leo on 2016/11/24.
 */
public interface IProductEvaluateService {

    /**
     * 评价接口
     * @param buyerId 买家ID
     * @param sellerId 卖家ID
     * @param orderId 订单ID
     * @param goodsId 商品ID
     * @param score 评价分数
     * @param content 评价内容
     * @param imgs 晒图(支持多张图)
     * @param anonymous 是否匿名
     * @return
     */
    public int rate(int buyerId, int sellerId, String orderId, int goodsId, int score, String content, String
            imgs, int anonymous);

    /**
     * 查询货品的评论
     * @param goodIds
     * @param seq
     * @param num
     * @return
     */
    List<ProductEvaluateRecord> findProductEvaluateList(int goodIds,int seq,int num);
}
