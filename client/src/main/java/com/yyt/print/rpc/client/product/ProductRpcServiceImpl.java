package com.yyt.print.rpc.client.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.pojo.Response;
import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.AdCategory;
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
}
