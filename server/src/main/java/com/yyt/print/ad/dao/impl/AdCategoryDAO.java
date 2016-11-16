package com.yyt.print.ad.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.dao.IAdCategoryDAO;
import com.yyt.print.ad.pojo.AdCategory;
import com.yyt.print.base.YytBaseDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/24.
 */
@Repository
public class AdCategoryDAO extends YytBaseDAO<AdCategory> implements IAdCategoryDAO {

    @Override
    public int saveAdCategory(AdCategory category) {
        return this.insert(category);
    }

    @Override
    public int updateAdCategory(AdCategory category) {
        return this.update(category);
    }

    @Override
    public int deleteAdCategory(String id) {
        return this.delete(id);
    }

    @Override
    public AdCategory getAdCategory(String id) {
        return this.get(id);
    }

    @Override
    public PageHolder<AdCategory> queryAdCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize) {
        return this.pagedQuery("findByParams", paramMap, pageIndex, pageSize);
    }
}
