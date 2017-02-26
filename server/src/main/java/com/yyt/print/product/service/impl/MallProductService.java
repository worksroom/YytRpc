package com.yyt.print.product.service.impl;

import com.yyt.print.product.dao.*;
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

    @Resource
    private IStoreLocationDAO storeLocationDAO;

    @Resource
    private IFareMouldDAO fareMouldDAO;

    @Resource
    private IMallProductExtDAO mallProductExtDAO;

    @Resource
    private IShopUserDAO shopUserDAO;

    @Resource
    private IMallGoodBaseProDAO mallGoodBaseProDAO;

    @Transactional
    @Override
    public int shelves(MallGoodsSet goodsSet) {
        MallGoods mallGoods = goodsSet.getMallGoods();
        List<MallProductSet> list = goodsSet.getList();
        List<MallProductExt> exts = goodsSet.getExts();
        List<MallGoodBasePro> bpro = goodsSet.getBpro();
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

            }
            result = mallProductSaleProDAO.batchSaveMallProductSalePro(mallProductSet.getSalePro());
            if(result <= 0 ){
                throw new RuntimeException("add error ");
            }
        }

        for(MallProductExt ext:exts){
            ext.setGoodsId(mallGoods.getId());
        }
        mallProductExtDAO.batchSaveMallProductEx(exts);
        mallGoodBaseProDAO.batchSaveMallGoodBasePro(bpro);

        return 1;
    }

    @Transactional
    @Override
    public int goodAddProduct(MallGoodsSet goodsSet) {
        MallGoods mallGoods = goodsSet.getMallGoods();
        List<MallProductSet> list = goodsSet.getList();
        List<MallProductExt> exts = goodsSet.getExts();
        List<MallGoodBasePro> bpro = goodsSet.getBpro();
        if(mallGoods==null){
            return -1;
        }
        mallGoodsDAO.updateMallGoods(mallGoods);
        //SKU
        if(list!=null){
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

                }
                result = mallProductSaleProDAO.batchSaveMallProductSalePro(mallProductSet.getSalePro());
                if(result <= 0 ){
                    throw new RuntimeException("add error ");
                }
            }
        }

        //扩展属性
        if(exts!=null && exts.size()>0){
            mallProductExtDAO.delExts(mallGoods.getId());
            for(MallProductExt ext:exts){
                ext.setGoodsId(mallGoods.getId());
            }
            mallProductExtDAO.batchSaveMallProductEx(exts);
        }

        //基本属性
        if(bpro!=null && bpro.size()>0){
            mallGoodBaseProDAO.delPros(mallGoods.getId());
            for(MallGoodBasePro pro:bpro){
                pro.setGoodsId(mallGoods.getId());
            }
            mallGoodBaseProDAO.batchSaveMallGoodBasePro(bpro);
        }

        return 1;
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

        List<MallProductExt> exts = mallProductExtDAO.findMallProductExt(goodsId);
        set.setExts(exts);

        List<MallGoodBasePro> bpros = mallGoodBaseProDAO.findByGoodsId(goodsId);
        set.setBpro(bpros);
        return set;
    }

    @Override
    public MallGoodsSet getMallGoodsSetByProduct(int productId) {
        MallProduct product = mallProductDAO.getMallProduct(productId);
        return this.getMallGoodsSetByGood(product.getGoodsId());
    }


    @Override
    public int saveStoreLocation(StoreLocation storeLocation) {
        return storeLocationDAO.saveStoreLocation(storeLocation);
    }

    @Override
    public StoreLocation getStoreLocation(int id) {
        return storeLocationDAO.getStoreLocation(id);
    }

    @Override
    public int delStoreLocation(int id) {
        return storeLocationDAO.delStoreLocation(id);
    }

    @Override
    public int updateStoreLocation(StoreLocation storeLocation) {
        return storeLocationDAO.updateStoreLocation(storeLocation);
    }

    @Override
    public List<StoreLocation> findStoreLocations(int shopId) {
        return storeLocationDAO.findStoreLocations(shopId);
    }

    @Override
    public int saveFareMould(FareMould fareMould) {
        return fareMouldDAO.saveFareMould(fareMould);
    }

    @Override
    public FareMould getFareMould(int id) {
        return fareMouldDAO.getFareMould(id);
    }

    @Override
    public int updateFareMould(FareMould fareMould) {
        return fareMouldDAO.updateFareMould(fareMould);
    }

    @Override
    public int delFareMould(int id) {
        return fareMouldDAO.delFareMould(id);
    }

    @Override
    public List<FareMould> findFareMoulds(int shopId) {
        return fareMouldDAO.findFareMoulds(shopId);
    }

    @Override
    public int addShopUser(ShopUser shopUser) {
        return shopUserDAO.saveShopUser(shopUser);
    }

    @Override
    public ShopUser getShopIdFromUid(int uid) {
        return shopUserDAO.getShopIdFromUid(uid);
    }

    @Override
    public ShopUser getCreateShopUid(int shopId) {
        return shopUserDAO.getCreateShopUid(shopId);
    }

    @Override
    public List<ShopUser> findShopUids(int shopId) {
        return shopUserDAO.findShopUids(shopId);
    }
}
