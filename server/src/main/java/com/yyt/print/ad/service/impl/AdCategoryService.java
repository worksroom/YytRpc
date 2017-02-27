package com.yyt.print.ad.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.dao.IAdCategoryDAO;
import com.yyt.print.ad.pojo.AdCategory;
import com.yyt.print.ad.service.IAdCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/25.
 */
@Service("adCategoryService")
public class AdCategoryService implements IAdCategoryService {
    @Resource
    private IAdCategoryDAO adCategoryDAO;

    @Override
    public int saveAdCategory(AdCategory category) {
        return adCategoryDAO.saveAdCategory(category);
    }

    @Override
    public int updateAdCategory(AdCategory category) {
        return adCategoryDAO.updateAdCategory(category);
    }

    @Override
    public int deleteAdCategory(int id) {
        return adCategoryDAO.deleteAdCategory(id);
    }

    @Override
    public AdCategory getAdCategory(int id) {
        return adCategoryDAO.getAdCategory(id);
    }

    @Override
    public PageHolder<AdCategory> queryAdCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize) {
        return adCategoryDAO.queryAdCategoryByPage(paramMap, pageIndex, pageSize);
    }
}
