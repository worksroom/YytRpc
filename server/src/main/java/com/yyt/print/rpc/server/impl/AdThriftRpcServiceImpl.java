package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.Ad;
import com.yyt.print.ad.pojo.AdCategory;
import com.yyt.print.ad.service.IAdCategoryService;
import com.yyt.print.ad.service.IAdService;
import com.yyt.print.parser.PageHolderSerializer;
import com.yyt.print.rpc.thrift.gen.AdThriftRpcService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/23.
 */
@Service("adThriftRpcService")
public class AdThriftRpcServiceImpl implements AdThriftRpcService.Iface {
    @Resource
    private IAdCategoryService adCategoryService;
    @Resource
    private IAdService adService;

    @Override
    public int saveAd(String ad) throws TException {
        Ad o =  JSON.parseObject(ad, Ad.class);
        return adService.saveAd(o);
    }

    @Override
    public int updateAd(String ad) throws TException {
        Ad o =  JSON.parseObject(ad, Ad.class);
        return adService.updateAd(o);
    }

    @Override
    public int deleteAd(int id) throws TException {
        return adService.deleteAd(id);
    }

    @Override
    public String getAd(int id) throws TException {
        Ad ad = adService.getAd(id);
        if(ad!=null){
            return JSON.toJSONString(ad);
        }
        return null;
    }

    @Override
    public String queryAdByPage(Map<String, String> paramMap, int pageIndex, int pageSize) throws TException {
        HashMap<String, Object> map = new HashMap<>();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        PageHolder<Ad> pageHolder = adService.queryAdByPage(map, pageIndex, pageSize);
        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }

    @Override
    public int saveAdCategory(String category) throws TException {
        AdCategory adCategory = JSON.parseObject(category, AdCategory.class);
        return adCategoryService.saveAdCategory(adCategory);
    }

    @Override
    public int updateAdCategory(String category) throws TException {
        AdCategory adCategory = JSON.parseObject(category, AdCategory.class);
        return adCategoryService.updateAdCategory(adCategory);
    }

    @Override
    public int deleteAdCategory(String id) throws TException {
        return adCategoryService.deleteAdCategory(id);
    }

    @Override
    public String getAdCategory(String id) throws TException {
        AdCategory adCategory = adCategoryService.getAdCategory(id);
        if(adCategory!=null){
            return JSON.toJSONString(adCategory);
        }
        return null;
    }

    @Override
    public String queryAdCategoryByPage(Map<String, String> paramMap, int pageIndex, int pageSize) throws TException {
        HashMap<String, Object> map = new HashMap<>();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        PageHolder<AdCategory> pageHolder = adCategoryService.queryAdCategoryByPage(map, pageIndex, pageSize);

        SerializeConfig config = new SerializeConfig();
        config.put(PageHolder.class, new PageHolderSerializer());
        return JSON.toJSONString(pageHolder, config);
    }
}
