package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.dao.IMallGoodsDAO;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.service.IMallGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
@Service("mallGoodsService")
public class MallGoodsService implements IMallGoodsService {

    @Resource
    private IMallGoodsDAO dao;

    @Override
    public int saveMallGoods(MallGoods goods) {
        return dao.saveMallGoods(goods);
    }

    @Override
    public int updateMallGoods(MallGoods goods) {
        return dao.updateMallGoods(goods);
    }

    @Override
    public int deleteMallGoods(int id) {
        return dao.deleteMallGoods(id);
    }

    @Override
    public MallGoods getMallGoods(int id) {
        return dao.getMallGoods(id);
    }

    @Override
    public PageHolder<MallGoods> findMallGoods(MallGoodsQuery query) {
        return null;
    }

    @Override
    public int reviewMallGoods(int id,boolean status) {
        return dao.reviewMallGoods(id,status);
    }
}
