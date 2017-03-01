package com.yyt.print.order.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.order.dao.IPayOrdersDAO;
import com.yyt.print.order.pojo.PayOrders;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/3/1.
 */
@Repository("payOrdersDAO")
public class PayOrdersDAOImpl extends YytBaseDAO<PayOrders> implements IPayOrdersDAO {
    @Override
    public int savePayOrders(PayOrders payOrders){
        payOrders.setCreateTime(new Date());
        return super.insert(payOrders);
    }

    @Override
    public int updatePayOrders(PayOrders payOrders){
        payOrders.setUpdateTime(new Date());
        return super.update(payOrders);
    }

    @Override
    public PayOrders getPayOrders(String id){return super.get(id);}

    @Override
    public int delPayOrders(String id){return super.delete(id);}

    @Override
    public int updateStatus(String id, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        map.put("updateTime",new Date());
        return super.updateBy("updateStatus",map);
    }
}