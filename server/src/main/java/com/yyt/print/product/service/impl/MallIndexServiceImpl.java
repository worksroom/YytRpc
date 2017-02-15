package com.yyt.print.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.youguu.core.util.PageHolder;
import com.yyt.print.product.dao.IMallIndexDAO;
import com.yyt.print.product.pojo.MallIndex;
import com.yyt.print.product.pojo.MallIndexContent;
import com.yyt.print.product.service.IMallIndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/2/13.
 */
@Service("mallIndexService")
public class MallIndexServiceImpl implements IMallIndexService {

    @Resource
    private IMallIndexDAO mallIndexDAO;

    @Override
    public int addMallIndex(MallIndex index, List<MallIndexContent> content) {
        index.setContent(JSON.toJSONString(content));
        return mallIndexDAO.saveMallIndex(index);
    }

    @Override
    public int updateMallIndex(MallIndex index, List<MallIndexContent> content) {
        index.setContent(JSON.toJSONString(content));
        return mallIndexDAO.updateMallIndex(index);
    }

    @Override
    public int updateStatus(int id, boolean status) {
        return mallIndexDAO.updateStatus(id,status);
    }

    @Override
    public PageHolder<MallIndex> queryMallIndex(int status, int pageIndex, int pageSize) {
        return mallIndexDAO.queryMallIndex(status,pageIndex,pageSize);
    }

    @Override
    public List<MallIndex> queryUserMallIndex() {
        return mallIndexDAO.queryUserMallIndex();
    }

    @Override
    public MallIndex getMallIndex(int id) {
        return mallIndexDAO.getMallIndex(id);
    }
}
