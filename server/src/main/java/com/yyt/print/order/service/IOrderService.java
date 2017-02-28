package com.yyt.print.order.service;

import com.alibaba.fastjson.JSONObject;
import com.yyt.print.order.pojo.OrderAddr;
import com.yyt.print.order.pojo.Orders;

import java.util.List;

/**
 * Created by leo on 2016/11/21.
 */
public interface IOrderService {

    /**
     * 生成订单
     * @param buyUserId 买家ID
     * @param sellUserId 卖家ID
     * @param payType 支付类型
     * @param totalMoney 支付总金额
     * @param ext 订单扩展信息，包括物流，商品，发票，收货人等等
     * @return 返回订单数据
     */
    public Orders makeOrder(int buyUserId, int sellUserId, int payType, Double totalMoney,
                            JSONObject ext);

    /**
     * 查询订单列表
     * @param buyUserId 买家ID
     * @param type 1-待付款；2-待评价；3-待收货；9-全部订单
     * @return
     */
    public List<Orders> queryOrders(int buyUserId, int type);

    /**
     * 付款接口，返回支付需要的签名数据
     * @param buyUserId
     * @param orderId
     * @return
     */
    public String payOrder(int buyUserId, String orderId);

    /**
     * 评价接口
     * @param buyUserId 买家ID
     * @param orderId 订单ID
     * @param goodsId 商品ID
     * @param score 评价分数
     * @param content 评价内容
     * @param imgs 晒图(支持多张图)
     * @return
     */
    public int rate(int buyUserId, String orderId, String goodsId, int score, String content, String imgs);

    /**
     * 确认收货
     * @param buyUserId 买家ID
     * @param orderId 订单ID
     * @return
     */
    public int receive(int buyUserId, String orderId);

    /**
     * 查询物流信息
     * @param buyUserId
     * @param orderId
     * @return
     */
    public int queryExpress(int buyUserId, String orderId);


}
