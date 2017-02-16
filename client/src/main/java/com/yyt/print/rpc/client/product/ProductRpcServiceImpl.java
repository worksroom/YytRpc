package com.yyt.print.rpc.client.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.pojo.Response;
import com.youguu.core.util.PageHolder;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.product.pojo.*;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.query.UserShopQuery;
import com.yyt.print.rpc.common.Constants;

import java.util.List;

/**
 * Created by lenovo on 2016/12/29.
 */
public class ProductRpcServiceImpl implements IProductRpcService {

    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);

    private static ProductClient  client = null;

    private ProductClient getClient(){
        if(client!=null){
            return client;
        }
        synchronized (ProductRpcServiceImpl.class){
            if(client==null){
                client = new ProductClient();
            }
        }
        return client;
    }

    @Override
    public int saveMallProductCategory(MallProductCategory category) {
        try {
            return getClient().saveMallProductCategory(JSON.toJSONString(category));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateMallProductCategory(MallProductCategory category) {
        try {
            return getClient().updateMallProductCategory(JSON.toJSONString(category));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int deleteMallProductCategory(int id) {
        try {
            return getClient().deleteMallProductCategory(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public MallProductCategory getMallProductCategory(int id) {
        try {
            return JSON.parseObject(getClient().getMallProductCategory(id), MallProductCategory.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<MallProductCategory> queryAllMallProductCategory() {
        try {
            return JSON.parseArray(getClient().queryAllMallProductCategory(), MallProductCategory.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<MallProductCategory> findMallProductCategoryList(int parentId) {
        try {
            return JSON.parseArray(getClient().findMallProductCategoryList(parentId), MallProductCategory.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<CategoryPro> findProValueByClassId(int classId) {
        try {
            return JSON.parseArray(getClient().findProValueByClassId(classId), CategoryPro.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int addProAndValues(int classId, MallProductCategoryPro pro, List<MallProductCategoryProValue> values) {
        try {
            return getClient().addProAndValues(classId,JSON.toJSONString(pro),JSON.toJSONString(values));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<MallProductCategoryPro> findProByClassId(int classId) {
        try {
            return JSON.parseArray(getClient().findProList(classId), MallProductCategoryPro.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<MallProductCategoryProValue> findProValueByProId(int proId) {
        try {
            return JSON.parseArray(getClient().findProValueList(proId), MallProductCategoryProValue.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int addPro(MallProductCategoryPro pro) {
        try {
            return getClient().addPro(JSON.toJSONString(pro));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int addProValue(List<MallProductCategoryProValue> values) {
        try {
            return getClient().addProValue(JSON.toJSONString(values));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int modifyPro(MallProductCategoryPro pro) {
        try {
            return getClient().modifyPro(JSON.toJSONString(pro));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int modifyProValue(MallProductCategoryProValue value) {
        try {
            return getClient().modifyProValue(JSON.toJSONString(value));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public Response<String> delPros(List<Integer> list) {
        try {
            return JSON.parseObject(getClient().delPros(list), Response.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Response<String> delProValues(List<Integer> list) {
        try {
            return JSON.parseObject(getClient().delProValues(list), Response.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<MallGoods> findMallGoods(MallGoodsQuery query) {
        try {
            String result = getClient().findMallGoods(JSON.toJSONString(query));
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(result, new TypeReference<PageHolder<MallGoods>>(){});
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int reviewMallGoods(int id, boolean status) {
        try {
            return getClient().reviewMallGoods(id,status);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public PageHolder<UserShop> findUserShops(UserShopQuery query) {
        try {
            String result = getClient().findUserShop(JSON.toJSONString(query));
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(result, new TypeReference<PageHolder<UserShop>>(){});
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int reviewUserShop(int id, boolean status) {
        try {
            return getClient().reviewUserShop(id,status);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int addMallIndex(MallIndex index, List<MallIndexContent> content) {
        try {
            return getClient().addMallIndex(JSON.toJSONString(index), JSON.toJSONString(content));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateMallIndex(MallIndex index, List<MallIndexContent> content) {
        try {
            return getClient().updateMallIndex(JSON.toJSONString(index), JSON.toJSONString(content));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateStatus(int id, boolean status) {
        try {
            return getClient().updateStatus(id, status);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public PageHolder<MallIndex> queryMallIndex(int status, int pageIndex, int pageSize) {
        try {
            String result = getClient().queryMallIndex(status,pageIndex,pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(result, new TypeReference<PageHolder<MallIndex>>(){});
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<MallIndex> queryUserMallIndex() {
        try {
            return JSON.parseArray(getClient().queryUserMallIndex(), MallIndex.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public MallIndex getMallIndex(int id) {
        try {
            return JSON.parseObject(getClient().getMallIndex(id), MallIndex.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int shelves(MallGoods mallGoods, List<MallProductSet> list,List<MallProductExt> exts) {
        try {
            return getClient().shelves(JSON.toJSONString(mallGoods), JSON.toJSONString(list),JSON.toJSONString(exts));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int goodAddProduct(int goodsId, List<MallProductSet> list,List<MallProductExt> exts) {
        try {
            return getClient().goodAddProduct(goodsId, JSON.toJSONString(list),JSON.toJSONString(exts));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public MallGoodsSet getMallGoodsSetByGood(int goodsId) {
        try {
            return JSON.parseObject(getClient().getMallGoodsSetByGood(goodsId), MallGoodsSet.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public MallGoodsSet getMallGoodsSetByProduct(int productId) {
        try {
            return JSON.parseObject(getClient().getMallGoodsSetByProduct(productId), MallGoodsSet.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    @Override
    public int saveStoreLocation(StoreLocation storeLocation) {
        try {
            return getClient().saveStoreLocation(JSON.toJSONString(storeLocation));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public StoreLocation getStoreLocation(int id) {
        try {
            return JSON.parseObject(getClient().getStoreLocation(id), StoreLocation.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int delStoreLocation(int id) {
        try {
            return getClient().delStoreLocation(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateStoreLocation(StoreLocation storeLocation) {
        try {
            return getClient().updateStoreLocation(JSON.toJSONString(storeLocation));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<StoreLocation> findStoreLocations(int shopId) {
        try {
            return JSON.parseArray(getClient().findStoreLocations(shopId), StoreLocation.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveFareMould(FareMould fareMould) {
        try {
            return getClient().saveFareMould(JSON.toJSONString(fareMould));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public FareMould getFareMould(int id) {
        try {
            return JSON.parseObject(getClient().getFareMould(id), FareMould.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int updateFareMould(FareMould fareMould) {
        try {
            return getClient().updateFareMould(JSON.toJSONString(fareMould));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int delFareMould(int id) {
        try {
            return getClient().delFareMould(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<FareMould> findFareMoulds(int shopId) {
        try {
            return JSON.parseArray(getClient().findFareMoulds(shopId), FareMould.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
