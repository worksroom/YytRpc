package com.yyt.print.user.dao;

import com.yyt.print.user.pojo.DeliveryAddr;

import java.util.List;

/**
 * Created by leo on 2016/11/20.
 */
public interface IDeliveryAddrDAO {

    /**
     * 查询收货地址列表
     * @param userId
     * @return
     */
    public List<DeliveryAddr> findDeliveryAddrListByUserId(int userId);

    /**
     * 增加收货地址
     * @param addr
     * @return
     */
    public int saveDeliveryAddr(DeliveryAddr addr);

    /**
     * 修改收货地址
     * @param addr
     * @return
     */
    public int updateDeliveryAddr(DeliveryAddr addr);

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    public int deleteDeliveryAddr(int id);

    /**
     * 根据地址ID查询地址
     * @param id
     * @return
     */
    public DeliveryAddr getDeliveryAddr(int id);

    /**
     * 设为默认收货地址
     * @param id 地址ID
     * @return
     */
    public int setDefaultAddr(int id);

    /**
     * 根据用户ID查询默认收货地址
     * @param userId
     * @return
     */
    public DeliveryAddr getDefaultAddr(int userId);
}
