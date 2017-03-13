package com.yyt.print.rpc.client.info;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.yyt.print.fragment.pojo.FragmentHome;
import com.yyt.print.info.pojo.InfoCategory;
import com.yyt.print.info.pojo.InfoContent;
import com.yyt.print.info.pojo.InfoVender;
import com.yyt.print.info.query.InfoQuery;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.parser.PageHolderDeserializer;
import com.yyt.print.rpc.common.Constants;
import org.apache.thrift.TException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/27.
 */
public class InfoRpcServiceImpl implements IInfoRpcService {

    private static final Log logger = LogFactory.getLog(Constants.YYT_RPC_CLIENT);

    private InfoClient getClient() {
        return new InfoClient();
    }

    @Override
    public int saveInfoCategory(InfoCategory category) {
        try {
            return getClient().saveInfoCategory(JSON.toJSONString(category));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateInfoCategory(InfoCategory category) {
        try {
            return getClient().updateInfoCategory(JSON.toJSONString(category));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int deleteInfoCategory(int id) {
        try {
            return getClient().deleteInfoCategory(id);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public InfoCategory getInfoCategory(int id) {
        try {
            String json = getClient().getInfoCategory(id);
            return JSONObject.parseObject(json, InfoCategory.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<InfoCategory> findInfoCategoryByParentId(int parentId) {
        try {
            String json = getClient().findInfoCategoryByParentId(parentId);
            return JSONArray.parseArray(json, InfoCategory.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<InfoCategory> queryInfoCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize) {
        try {
            HashMap<String, String> map = new HashMap<>();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                map.put(entry.getKey(), (String)entry.getValue());
            }
            String json = getClient().queryInfoCategoryByPage(map, pageIndex, pageSize);
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(json, new TypeReference<PageHolder<InfoCategory>>(){});
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int saveInfoContent(InfoContent infoContent) {
        try {
            return getClient().saveInfoContent(JSON.toJSONString(infoContent));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int deleteInfoContent(int id) {
        try {
            return getClient().deleteInfoContent(id);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public int updateInfoContent(InfoContent infoContent) {
        try {
            return getClient().updateInfoContent(JSON.toJSONString(infoContent));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public InfoContent getInfoContent(int id) {
        try {
            String json = getClient().getInfoContent(id);
            return JSONObject.parseObject(json, InfoContent.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PageHolder<InfoContent> queryInfoContentByPage(InfoQuery query) {
        try {
            String result = getClient().queryInfoContentByPage(JSON.toJSONString(query));
            ParserConfig.getGlobalInstance().putDeserializer(PageHolder.class, new PageHolderDeserializer());
            return JSON.parseObject(result, new TypeReference<PageHolder<InfoContent>>(){});
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public int addSupplyInfo(InfoContent infoContent, InfoVender infoVender) {
        try {
            return getClient().addSupplyInfo(JSON.toJSONString(infoContent), JSON.toJSONString(infoVender));
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public List<InfoContent> queryInfoContentList(String title, String des, int id, int limit) {
        try {
            String json = getClient().queryInfoContentList(title, des, id, limit);
            return JSONArray.parseArray(json, InfoContent.class);
        } catch (TException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
