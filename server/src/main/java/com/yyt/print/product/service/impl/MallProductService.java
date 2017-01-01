package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallProduct;
import com.yyt.print.product.service.IMallProductService;

/**
 * Created by leo on 2016/11/23.
 */
public class MallProductService implements IMallProductService {
    @Override
    public int saveMallProduct(MallProduct mallProduct) {
        return 0;
    }

    @Override
    public int updateMallProduct(MallProduct mallProduct) {
        return 0;
    }

    @Override
    public int deleteMallProduct(int id) {
        return 0;
    }

    @Override
    public MallProduct getMallProduct(int id) {
        return null;
    }

    @Override
    public PageHolder<MallProduct> queryMallProduct(int sellUserId, int classId, int goodsId, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public int updateSaleNum(int id, int num) {
        return 0;
    }

    @Override
    public int updateStoreNum(int id, int num) {
        return 0;
    }
}
