package com.yyt.print.product.service.impl;

import com.yyt.print.product.dao.IMallProductCategoryDAO;
import com.yyt.print.product.pojo.MallProductCategory;
import com.yyt.print.product.service.IMallProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
@Service("mallProductCategoryService")
public class MallProductCategoryService implements IMallProductCategoryService {

    @Resource
    private IMallProductCategoryDAO mallProductCategoryDAO;
    @Override
    public int saveMallProductCategory(MallProductCategory category) {
        return mallProductCategoryDAO.saveMallProductCategory(category);
    }

    @Override
    public int updateMallProductCategory(MallProductCategory category) {
        return mallProductCategoryDAO.updateMallProductCategory(category);
    }

    @Override
    public int deleteMallProductCategory(int id) {
        return mallProductCategoryDAO.deleteMallProductCategory(id);
    }

    @Override
    public MallProductCategory getMallProductCategory(int id) {
        return mallProductCategoryDAO.getMallProductCategory(id);
    }

    @Override
    public List<MallProductCategory> queryAllMallProductCategory() {
        return mallProductCategoryDAO.queryAllCategory();
    }

    @Override
    public List<MallProductCategory> findMallProductCategoryList(int parentId) {
        return mallProductCategoryDAO.queryCategoryByParentId(parentId);
    }
}
