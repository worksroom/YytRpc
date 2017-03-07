package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.youguu.core.util.PageHolder;
import com.yyt.print.info.pojo.InfoCategory;
import com.yyt.print.info.pojo.InfoContent;
import com.yyt.print.info.pojo.InfoVender;
import com.yyt.print.info.query.InfoQuery;
import com.yyt.print.info.service.IInfoCategoryService;
import com.yyt.print.info.service.IInfoContentService;
import com.yyt.print.parser.PageHolderSerializer;
import com.yyt.print.rpc.thrift.gen.InfoThriftRpcService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Service("infoThriftRpcService")
public class InfoThriftRpcServiceImpl implements InfoThriftRpcService.Iface {
    @Resource
    private IInfoCategoryService infoCategoryService;
    @Resource
    private IInfoContentService infoContentService;


    @Override
    public int saveInfoCategory(String category) throws TException {
        InfoCategory infoCategory = JSONObject.parseObject(category, InfoCategory.class);
        return infoCategoryService.saveInfoCategory(infoCategory);
    }

    @Override
    public int updateInfoCategory(String category) throws TException {
        InfoCategory infoCategory = JSONObject.parseObject(category, InfoCategory.class);
        return infoCategoryService.updateInfoCategory(infoCategory);
    }

    @Override
    public int deleteInfoCategory(int id) throws TException {
        return infoCategoryService.deleteInfoCategory(id);
    }

    @Override
    public String getInfoCategory(int id) throws TException {
        InfoCategory infoCategory = infoCategoryService.getInfoCategory(id);
        return JSON.toJSONString(infoCategory);
    }

    @Override
    public String findInfoCategoryByParentId(int parentId) throws TException {
        List<InfoCategory> list = infoCategoryService.findInfoCategoryByParentId(parentId);
        return JSON.toJSONString(list);
    }

    @Override
    public String queryInfoCategoryByPage(Map<String, String> paramMap, int pageIndex, int pageSize) throws TException {
        HashMap<String, Object> map = new HashMap<>();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        PageHolder<InfoCategory> pageHolder = infoCategoryService.queryInfoCategoryByPage(map, pageIndex, pageSize);
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }

    @Override
    public int saveInfoContent(String infoContent) throws TException {
        InfoContent content = JSONObject.parseObject(infoContent, InfoContent.class);
        return infoContentService.saveInfoContent(content);
    }

    @Override
    public int deleteInfoContent(int id) throws TException {
        return infoContentService.deleteInfoContent(id);
    }

    @Override
    public int updateInfoContent(String infoContent) throws TException {
        InfoContent content = JSONObject.parseObject(infoContent, InfoContent.class);
        return infoContentService.updateInfoContent(content);
    }

    @Override
    public String getInfoContent(int id) throws TException {
        InfoContent infoContent = infoContentService.getInfoContent(id);
        return JSON.toJSONString(infoContent);
    }

    @Override
    public String queryInfoContentByPage(String query) throws TException {
        PageHolder<InfoContent> pageHolder = infoContentService.queryInfoContentByPage(JSON.parseObject(query, InfoQuery.class));
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }

    @Override
    public int addSupplyInfo(String infoContent, String infoVender) throws TException {
        return infoContentService.addSupplyInfo(JSON.parseObject(infoContent, InfoContent.class), JSON.parseObject(infoVender, InfoVender.class));
    }

    @Override
    public String queryInfoContentList(String title, String des, int id, int limit) throws TException {
        List<InfoContent> list = infoContentService.queryInfoContentList(title, des, id, limit);
        return JSON.toJSONString(list);
    }
}
