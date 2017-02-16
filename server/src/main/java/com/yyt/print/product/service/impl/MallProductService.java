package com.yyt.print.product.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.dao.IMallGoodsDAO;
import com.yyt.print.product.dao.IMallProductDAO;
import com.yyt.print.product.dao.IMallProductSaleProDAO;
import com.yyt.print.product.pojo.*;
import com.yyt.print.product.service.IMallProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
@Service("mallProductService")
public class MallProductService implements IMallProductService {

    @Resource
    private IMallGoodsDAO mallGoodsDAO;

    @Resource
    private IMallProductDAO mallProductDAO;

    @Resource
    private IMallProductSaleProDAO mallProductSaleProDAO;

    @Transactional
    @Override
    public int shelves(MallGoods mallGoods, List<MallProductSet> list) {
        int result = mallGoodsDAO.saveMallGoods(mallGoods);
        if(result <= 0 ){
            throw new RuntimeException("add error ");
        }
        for (MallProductSet mallProductSet:list){
            MallProduct product = mallProductSet.getMallProduct();
            product.setClassId(mallGoods.getClassId());
            product.setGoodsId(mallGoods.getId());
            result = mallProductDAO.saveSaveMallProduct(product);
            if(result <= 0 ){
                throw new RuntimeException("add error ");
            }
            for(MallProductSalePro  pro:mallProductSet.getSalePro()){
                pro.setGoodsId(mallGoods.getId());
                pro.setProductId(product.getId());
                pro.setClassProId(mallGoods.getClassId());

            }
            result = mallProductSaleProDAO.batchSaveMallProductSalePro(mallProductSet.getSalePro());
            if(result <= 0 ){
                throw new RuntimeException("add error ");
            }

            return 1;


        }
        return 0;
    }

    @Transactional
    @Override
    public int goodAddProduct(int goodsId, List<MallProductSet> list) {
        MallGoods mallGoods = mallGoodsDAO.getMallGoods(goodsId);
        if(mallGoods==null){
            return -1;
        }
        for (MallProductSet mallProductSet:list){
            MallProduct product = mallProductSet.getMallProduct();
            product.setClassId(mallGoods.getClassId());
            product.setGoodsId(mallGoods.getId());
            int result = mallProductDAO.saveSaveMallProduct(product);
            if(result <= 0 ){
                throw new RuntimeException("add error ");
            }
            for(MallProductSalePro  pro:mallProductSet.getSalePro()){
                pro.setGoodsId(mallGoods.getId());
                pro.setProductId(product.getId());
                pro.setClassProId(mallGoods.getClassId());

            }
            result = mallProductSaleProDAO.batchSaveMallProductSalePro(mallProductSet.getSalePro());
            if(result <= 0 ){
                throw new RuntimeException("add error ");
            }

            return 1;


        }
        return 0;
    }

    @Override
    public MallGoodsSet getMallGoodsSetByGood(int goodsId) {
        MallGoodsSet set = new MallGoodsSet();
        List<MallProductSet> mps = new ArrayList<>();
        MallGoods mallGoods = mallGoodsDAO.getMallGoods(goodsId);
        if(mallGoods==null){
            return null;
        }
        set.setMallGoods(mallGoods);


        List<MallProduct> product = mallProductDAO.findMallProducts(goodsId);
        List<MallProductSalePro> pros = mallProductSaleProDAO.findMallProductSalePro(goodsId);
        for(MallProduct mp:product){
            MallProductSet mpSet = new MallProductSet();
            mpSet.setMallProduct(mp);
            List<MallProductSalePro> list = new ArrayList<>();
            for(MallProductSalePro pro:pros){
                if(pro.getProductId()==mp.getId()){
                    list.add(pro);
                }
            }
            mpSet.setSalePro(list);
            mps.add(mpSet);
        }
        set.setList(mps);
        return set;
    }

    @Override
    public MallGoodsSet getMallGoodsSetByProduct(int productId) {
        MallProduct product = mallProductDAO.getMallProduct(productId);
        return this.getMallGoodsSetByGood(product.getGoodsId());
    }
}
