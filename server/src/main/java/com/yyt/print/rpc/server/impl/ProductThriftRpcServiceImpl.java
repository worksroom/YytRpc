package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.youguu.core.util.PageHolder;
import com.yyt.print.parser.PageHolderSerializer;
import com.yyt.print.product.pojo.*;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.query.UserShopQuery;
import com.yyt.print.product.service.*;
import com.yyt.print.rpc.thrift.gen.ProductThriftRpcService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Service("productThriftRpcService")
public class ProductThriftRpcServiceImpl implements ProductThriftRpcService.Iface {

    @Resource
    private IMallProductCategoryService mallProductCategoryService;

    @Resource
    private ICategoryProService categoryProService;

    @Resource
    private IMallGoodsService mallGoodsService;

    @Resource
    private IUserShopService userShopService;

    @Resource
    private IMallIndexService mallIndexService;

    @Resource
    private IMallProductService mallProductService;

    @Resource
    private IProductEvaluateService iProductEvaluateService;

    @Override
    public String queryAllMallProductCategory() throws TException {
        List<MallProductCategory> list = mallProductCategoryService.queryAllMallProductCategory();
        if(list!=null){
            return JSON.toJSONString(list);
        }
        return null;
    }

    @Override
    public String findMallProductCategoryList(int parentId) throws TException {
        List<MallProductCategory> list = mallProductCategoryService.findMallProductCategoryList(parentId);
        if(list!=null){
            return JSON.toJSONString(list);
        }
        return null;
    }

    @Override
    public int saveMallProductCategory(String mallProductCategory) throws TException {

        return mallProductCategoryService.saveMallProductCategory(JSON.parseObject(mallProductCategory,MallProductCategory.class));
    }

    @Override
    public int updateMallProductCategory(String mallProductCategory) throws TException {
        MallProductCategory mpc = JSON.parseObject(mallProductCategory,MallProductCategory.class);

        return mallProductCategoryService.updateMallProductCategory(mpc);
    }

    @Override
    public int deleteMallProductCategory(int id) throws TException {
        return mallProductCategoryService.deleteMallProductCategory(id);
    }

    @Override
    public String getMallProductCategory(int id) throws TException {
        return JSON.toJSONString(mallProductCategoryService.getMallProductCategory(id));
    }

    @Override
    public String findProValueByClassId(int classId) throws TException {

        List<CategoryPro> cpro = categoryProService.findProValueByClassId(classId);

        return JSON.toJSONString(cpro);
    }

    @Override
    public int addProAndValues(int classId, String pro, String values) throws TException {
        List<MallProductCategoryProValue> list = JSONArray.parseArray(values,MallProductCategoryProValue.class);
        return categoryProService.addProAndValues(classId,JSON.parseObject(pro, MallProductCategoryPro.class),list);
    }

    @Override
    public String findProList(int classId) throws TException {
        return JSON.toJSONString(categoryProService.findProByClassId(classId));
    }

    @Override
    public String findProValueList(int proId) throws TException {
        return JSON.toJSONString(categoryProService.findProValueByProId(proId));
    }

    @Override
    public int addPro(String pro) throws TException {
        return categoryProService.addPro(JSON.parseObject(pro,MallProductCategoryPro.class));
    }

    @Override
    public int addProValue(String values) throws TException {
        return categoryProService.addProValue(JSONArray.parseArray(values,MallProductCategoryProValue.class));
    }

    @Override
    public String delPros(List<Integer> proIds) throws TException {

        return JSON.toJSONString(categoryProService.delPros(proIds));
    }

    @Override
    public String delProValues(List<Integer> proValueIds) throws TException {
        return JSON.toJSONString(categoryProService.delProValues(proValueIds));
    }

    @Override
    public int modifyPro(String pro) throws TException {
        return categoryProService.modifyPro(JSON.parseObject(pro,MallProductCategoryPro.class));
    }

    @Override
    public int modifyProValue(String value) throws TException {
        return categoryProService.modifyProValue(JSON.parseObject(value,MallProductCategoryProValue.class));
    }

    @Override
    public String findMallGoods(String value) throws TException {
        PageHolder<MallGoods> list = mallGoodsService.findMallGoods(JSON.parseObject(value, MallGoodsQuery.class));

        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(list, config);
    }

    @Override
    public int reviewMallGoods(int id, boolean status) throws TException {
        return mallGoodsService.reviewMallGoods(id,status);
    }

    @Override
    public String findUserShop(String value) throws TException {
        PageHolder<UserShop> list = userShopService.findUserShops(JSON.parseObject(value, UserShopQuery.class));

        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(list, config);
    }

    @Override
    public int reviewUserShop(int id, boolean status) throws TException {
        return userShopService.reviewUserShop(id,status);
    }

    @Override
    public int addMallIndex(String mallIndex, String mallindexContent) throws TException {
        List<MallIndexContent> list = JSONArray.parseArray(mallindexContent,MallIndexContent.class);
        MallIndex index = JSON.parseObject(mallIndex,MallIndex.class);
        return mallIndexService.addMallIndex(index,list);
    }

    @Override
    public int updateMallIndex(String mallIndex, String mallindexContent) throws TException {
        List<MallIndexContent> list = JSONArray.parseArray(mallindexContent,MallIndexContent.class);
        MallIndex index = JSON.parseObject(mallIndex,MallIndex.class);
        return mallIndexService.updateMallIndex(index, list);
    }

    @Override
    public int updateStatus(int id, boolean status) throws TException {
        return mallIndexService.updateStatus(id,status);
    }

    @Override
    public String queryMallIndex(int status, int pageIndex, int pageSize) throws TException {
        PageHolder<MallIndex> list = mallIndexService.queryMallIndex(status, pageIndex, pageSize);
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(list, config);
    }

    @Override
    public String queryUserMallIndex() throws TException {
        return JSON.toJSONString(mallIndexService.queryUserMallIndex());
    }

    @Override
    public String getMallIndex(int id) throws TException {
        return JSON.toJSONString(mallIndexService.getMallIndex(id));
    }

    @Override
    public int shelves(String mallGoods, String mallProductSets, String other) throws TException {
        MallGoods goods = JSON.parseObject(mallGoods,MallGoods.class);
        List<MallProductSet> list = JSONArray.parseArray(mallProductSets,MallProductSet.class);
        List<MallProductExt> exts = JSONArray.parseArray(other,MallProductExt.class);
        return mallProductService.shelves(goods,list,exts);
    }

    @Override
    public int goodAddProduct(int goodsId, String mallProductSets, String other) throws TException {
        List<MallProductSet> list = JSONArray.parseArray(mallProductSets,MallProductSet.class);
        List<MallProductExt> exts = JSONArray.parseArray(other,MallProductExt.class);
        return mallProductService.goodAddProduct(goodsId,list,exts);
    }

    @Override
    public String getMallGoodsSetByGood(int goods) throws TException {
        return JSON.toJSONString(mallProductService.getMallGoodsSetByGood(goods));
    }

    @Override
    public String getMallGoodsSetByProduct(int productId) throws TException {
        return JSON.toJSONString(mallProductService.getMallGoodsSetByProduct(productId));
    }

    @Override
    public int saveFareMould(String fareMould) throws TException {
        return mallProductService.saveFareMould(JSON.parseObject(fareMould,FareMould.class));
    }

    @Override
    public String getFareMould(int id) throws TException {
        return JSON.toJSONString(mallProductService.getFareMould(id));
    }

    @Override
    public int updateFareMould(String fareMould) throws TException {
        return mallProductService.updateFareMould(JSON.parseObject(fareMould,FareMould.class));
    }

    @Override
    public int delFareMould(int id) throws TException {
        return mallProductService.delFareMould(id);
    }

    @Override
    public String findFareMoulds(int shopId) throws TException {
        return JSON.toJSONString(mallProductService.findFareMoulds(shopId));
    }

    @Override
    public int saveStoreLocation(String storeLocation) throws TException {
        return mallProductService.saveStoreLocation(JSON.parseObject(storeLocation,StoreLocation.class));
    }

    @Override
    public String getStoreLocation(int id) throws TException {
        return JSON.toJSONString(mallProductService.getStoreLocation(id));
    }

    @Override
    public int delStoreLocation(int id) throws TException {
        return mallProductService.delStoreLocation(id);
    }

    @Override
    public int updateStoreLocation(String storeLocation) throws TException {
        return mallProductService.updateStoreLocation(JSON.parseObject(storeLocation,StoreLocation.class));
    }

    @Override
    public String findStoreLocations(int shopId) throws TException {
        return JSON.toJSONString(mallProductService.findStoreLocations(shopId));
    }

    @Override
    public int commentGoods(String comment) throws TException {
        return iProductEvaluateService.commentGoods(JSON.parseObject(comment,ProductEvaluateRecord.class));
    }

    @Override
    public String findProductEvaluateList(int goodIds, int seq, int num) throws TException {
        return JSON.toJSONString(iProductEvaluateService.findProductEvaluateList(goodIds,seq,num));
    }

    @Override
    public int addShopUser(String shopUser) throws TException {
        return mallProductService.addShopUser(JSON.parseObject(shopUser,ShopUser.class));
    }

    @Override
    public String getShopIdFromUid(int uid) throws TException {
        return JSON.toJSONString(mallProductService.getShopIdFromUid(uid));
    }

    @Override
    public String getCreateShopUid(int shopId) throws TException {
        return JSON.toJSONString(mallProductService.getCreateShopUid(shopId));
    }

    @Override
    public String findShopUids(int shopId) throws TException {
        return JSON.toJSONString(mallProductService.findShopUids(shopId));
    }
}
