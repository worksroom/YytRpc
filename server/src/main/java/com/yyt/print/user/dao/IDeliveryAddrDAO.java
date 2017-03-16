package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.DeliveryAddr;

import java.util.List;

/**
 * Created by leo on 2016/11/20.
 */
public interface IDeliveryAddrDAO {
    int saveDeliveryAddr(DeliveryAddr deliveryAddr);

    int updateDeliveryAddr(DeliveryAddr deliveryAddr);

    DeliveryAddr getDeliveryAddr(int id);

    int delDeliveryAddr(int id);

    List<DeliveryAddr> findUserAddr(int uid);

    /**
     * 查询默认收货地址
     * @param userId
     * @return
     */
    DeliveryAddr findDefaultDeliveryAddr(int userId);
}
