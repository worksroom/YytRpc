package com.yyt.print.order.service;

import com.alibaba.fastjson.JSONObject;
import com.youguu.core.util.PageHolder;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.pojo.ShoppingCartSet;
import com.yyt.print.order.query.OrdersQuery;

import java.util.List;

/**
 * Created by leo on 2016/11/21.
 */
public interface IOrderService {

    /**
     * 生成订单
     * @param buyUserId 买家ID
     * @param ext 订单扩展信息
     *            [{
     *            "productId"
     *            "num"
     *            "addrId"
     *
     *            }]
     * @return 返回订单数据
     */
    public Orders makeOrder(int buyUserId,int addrId,List<OrderProductFront> product,JSONObject ext);



    /**
     * 查询订单
     * @param query
     * @return
     */
    PageHolder<Orders> findOrders(OrdersQuery query);

    /**
     * 确认发货 - 物流信息
     * @param orderId
     * @param expressCom
     * @param expressNum
     * @return
     */
    int confirmExpress(String orderId,int expressCom,String expressNum);

    /**
     * 确认收货
     * @param buyUserId 买家ID
     * @param orderId 订单ID
     * @return
     */
    public int receive(int buyUserId, String orderId);

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
     * 查询物流信息
     * @param buyUserId
     * @param orderId
     * @return
     */
    public int queryExpress(int buyUserId, String orderId);


    /**
     * 加入购物车
     * @param uid
     * @param skuId
     * @param buyNum
     * @return
     */
    int addShopCart(int uid,int skuId,int buyNum);

    /**
     * 删除购物车
     * @param id
     * @return
     */
    int delShopCart(int id);

    /**
     * 修改数量
     * @param num
     * @return
     */
    int updateShopNum(int id , int num);

    /**
     * 查询用户的购物车
     * @param uid
     * @return
     */
    List<ShoppingCartSet> findUserShopCart(int uid);


}
