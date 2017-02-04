package com.yyt.print.info.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.info.dao.IInfoCategoryDAO;
import com.yyt.print.info.pojo.InfoCategory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/25.
 */
@Repository
public class InfoCategoryDAO extends YytBaseDAO<InfoCategory> implements IInfoCategoryDAO {
    @Override
    public int saveInfoCategory(InfoCategory category) {
        return this.insert(category);
    }

    @Override
    public int updateInfoCategory(InfoCategory category) {
        return this.update(category);
    }

    @Override
    public int deleteInfoCategory(int id) {
        return this.delete(id);
    }

    @Override
    public InfoCategory getInfoCategory(int id) {
        return this.get(id);
    }

    @Override
    public List<InfoCategory> findInfoCategoryByParentId(int parentId) {
        return this.findBy("findInfoCategoryByParentId", parentId);
    }

    @Override
    public PageHolder<InfoCategory> queryInfoCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize) {
        return this.pagedQuery("findByParams", paramMap, pageIndex, pageSize);
    }
}
