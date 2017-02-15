package com.yyt.print.product.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IMallIndexDAO;
import com.yyt.print.product.pojo.MallIndex;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/13.
 */
@Repository("mallIndexDAO")
public class MallIndexDAOImpl extends YytBaseDAO<MallIndex> implements IMallIndexDAO {
    @Override
    public int saveMallIndex(MallIndex index) {
        index.setCreateTime(new Date());
        index.setUpdateTime(new Date());
        return super.insert(index);
    }

    @Override
    public int updateMallIndex(MallIndex index) {
        index.setUpdateTime(new Date());
        return super.update(index);
    }

    @Override
    public MallIndex getMallIndex(int id) {
        return super.get(id);
    }

    @Override
    public int updateStatus(int id,boolean isUsed) {
        int status = 1;
        if(!isUsed){
            status = 99;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        return super.updateBy("updateStatus",map);
    }

    @Override
    public PageHolder<MallIndex> queryMallIndex(int status,int pageIndex,int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        return super.pagedQuery("findByParams",map,pageIndex,pageSize);
    }

    @Override
    public List<MallIndex> queryUserMallIndex() {
        return super.findBy("sql_select_front",null);
    }

}
