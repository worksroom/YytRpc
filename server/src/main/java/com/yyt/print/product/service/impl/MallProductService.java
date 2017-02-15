package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.dao.IMallGoodsDAO;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.MallProduct;
import com.yyt.print.product.pojo.MallProductSet;
import com.yyt.print.product.service.IMallProductService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public class MallProductService implements IMallProductService {

    @Resource
    private IMallGoodsDAO mallGoodsDAO;

    @Transactional
    @Override
    public int shelves(MallGoods mallGoods, List<MallProductSet> list) {
        return 0;
    }
}
