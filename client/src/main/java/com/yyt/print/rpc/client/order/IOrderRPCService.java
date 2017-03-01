package com.yyt.print.rpc.client.order;

import com.alibaba.fastjson.JSONObject;
import com.youguu.core.util.PageHolder;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.pojo.PayOrders;
import com.yyt.print.order.pojo.ShoppingCartSet;
import com.yyt.print.order.query.OrdersQuery;

import java.util.List;

/**
 * Created by lenovo on 2017/2/28.
 */
public interface IOrderRPCService {
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

    /**
     * 生成订单
     * @param buyUserId 买家ID
     * @param product 订单扩展信息
     *            [{
     *            "productId"
     *            "num"
     *            "addrId"
     *
     *            }]
     * @return 返回订单数据
     */
    public PayOrders makeOrder(int buyUserId,int addrId,List<OrderProductFront> product,JSONObject ext);



    /**
     * 查询订单
     * @param query
     * @return
     */
    PageHolder<Orders> findOrders(OrdersQuery query);

    int updateOrderPrice(String order,double price);

    /**
     * 确认发货 - 物流信息
     * @param orderId
     * @param expressCom
     * @param expressNum
     * @return
     */
    int confirmExpress(String orderId,int expressCom,String expressNum);

}
