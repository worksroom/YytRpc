package com.yyt.print.info.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.info.dao.IInfoCategoryDAO;
import com.yyt.print.info.pojo.InfoCategory;
import com.yyt.print.info.service.IInfoCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/25.
 */
@Service("infoCategoryService")
public class InfoCategoryService implements IInfoCategoryService {
    @Resource
    private IInfoCategoryDAO infoCategoryDAO;

    @Override
    public int saveInfoCategory(InfoCategory category) {
        return infoCategoryDAO.saveInfoCategory(category);
    }

    @Override
    public int updateInfoCategory(InfoCategory category) {
        return infoCategoryDAO.updateInfoCategory(category);
    }

    @Override
    public int deleteInfoCategory(int id) {
        return infoCategoryDAO.deleteInfoCategory(id);
    }

    @Override
    public InfoCategory getInfoCategory(int id) {
        return infoCategoryDAO.getInfoCategory(id);
    }

    @Override
    public List<InfoCategory> findInfoCategoryByParentId(int parentId) {
        return infoCategoryDAO.findInfoCategoryByParentId(parentId);
    }

    @Override
    public PageHolder<InfoCategory> queryInfoCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize) {
        return infoCategoryDAO.queryInfoCategoryByPage(paramMap, pageIndex, pageSize);
    }
}
