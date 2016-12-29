package com.yyt.print.rpc.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yyt.print.product.pojo.MallProductCategory;
import com.yyt.print.product.service.IMallProductCategoryProService;
import com.yyt.print.product.service.IMallProductCategoryService;
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
        return null;
    }
}
