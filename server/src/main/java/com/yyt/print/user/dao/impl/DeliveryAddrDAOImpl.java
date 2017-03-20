package com.yyt.print.user.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.user.dao.IDeliveryAddrDAO;
import com.yyt.print.user.pojo.DeliveryAddr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/28.
 */
@Repository("deliveryAddrDAO")
public class DeliveryAddrDAOImpl extends YytBaseDAO<DeliveryAddr> implements IDeliveryAddrDAO {
    @Override
    public int saveDeliveryAddr(DeliveryAddr deliveryAddr) {
        return super.insert(deliveryAddr);
    }

    @Override
    public int updateDeliveryAddr(DeliveryAddr deliveryAddr) {
        return super.update(deliveryAddr);
    }

    @Override
    public DeliveryAddr getDeliveryAddr(int id) {
        return super.get(id);
    }

    @Override
    public int delDeliveryAddr(int id) {
        return super.delete(id);
    }

    @Override
    public List<DeliveryAddr> findUserAddr(int uid) {
        return super.findBy("selectByUid", uid);
    }

    @Override
    public DeliveryAddr findDefaultDeliveryAddr(int userId) {
        return super.findUniqueBy("findDefaultDeliveryAddr", userId);
    }

    @Override
    public int resetDefaultAddr(int userId) {
        return super.updateBy("resetDefaultAddr", userId);
    }
}