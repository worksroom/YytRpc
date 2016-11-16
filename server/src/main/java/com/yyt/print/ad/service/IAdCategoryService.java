package com.yyt.print.ad.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.AdCategory;
import java.util.HashMap;
/**
 * 广告类别维护
 * Created by SomeBody on 2016/9/23.
 */
public interface IAdCategoryService {
    public int saveAdCategory(AdCategory category);

    public int updateAdCategory(AdCategory category);

    public int deleteAdCategory(String id);

    public AdCategory getAdCategory(String id);

    public PageHolder<AdCategory> queryAdCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

}
