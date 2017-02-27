package com.yyt.print.ad.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.AdCategory;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/24.
 */
public interface IAdCategoryDAO {
    public int saveAdCategory(AdCategory category);

    public int updateAdCategory(AdCategory category);

    public int deleteAdCategory(int id);

    public AdCategory getAdCategory(int id);

    public PageHolder<AdCategory> queryAdCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

}
