package com.yyt.print.rpc.client.order;

import com.yyt.print.order.pojo.ShoppingCartSet;

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

}
