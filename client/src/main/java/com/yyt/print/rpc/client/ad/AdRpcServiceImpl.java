package com.yyt.print.rpc.client.ad;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.Ad;
import com.yyt.print.ad.pojo.AdCategory;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.rpc.common.Constants;
import org.apache.thrift.TException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
public class AdRpcServiceImpl implements IAdRpcService {
    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);

    private AdClient getClient() {
        return new AdClient();
    }

    @Override
    public int saveAdCategory(AdCategory category) {
        try {
            return getClient().saveAdCategory(JSON.toJSONString(category));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateAdCategory(AdCategory category) {
        try {
            return getClient().updateAdCategory(JSON.toJSONString(category));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int deleteAdCategory(int id) {
        try {
            return getClient().deleteAdCategory(id);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public AdCategory getAdCategory(int id) {
        try {
            String json = getClient().getAdCategory(id);
            return JSONObject.parseObject(json, AdCategory.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<AdCategory> queryAdCategoryByPage(String name, int pageIndex, int pageSize) {
        try {
            String json = getClient().queryAdCategoryByPage(name, pageIndex, pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(json, new TypeReference<PageHolder<AdCategory>>(){});
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveAd(Ad ad) {
        try {
            return getClient().saveAd(JSON.toJSONString(ad));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateAd(Ad ad) {
        try {
            return getClient().updateAd(JSON.toJSONString(ad));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int deleteAd(int id) {
        try {
            return getClient().deleteAd(id);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public Ad getAd(int id) {
        try {
            String json = getClient().getAd(id);
            return JSONObject.parseObject(json, Ad.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<Ad> queryAdByPage(int adType, int used, int pageIndex, int pageSize) {
        try {
            String json = getClient().queryAdByPage(adType, used, pageIndex, pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(json, new TypeReference<PageHolder<Ad>>(){});
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
