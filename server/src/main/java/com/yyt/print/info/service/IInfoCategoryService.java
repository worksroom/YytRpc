package com.yyt.print.info.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.info.pojo.InfoCategory;

import java.util.List;
import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IInfoCategoryService {

    public int saveInfoCategory(InfoCategory category);

    public int updateInfoCategory(InfoCategory category);

    /**
     * 删除资讯类别时，是否要删除该类别下子类别及资讯，谨慎！
     * @param id
     * @return
     */
    public int deleteInfoCategory(int id);

    public InfoCategory getInfoCategory(int id);

    /**
     * 查询子类别
     * @param parentId
     * @return
     */
    public List<InfoCategory> findInfoCategoryByParentId(int parentId);

    public PageHolder<InfoCategory> queryInfoCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);
}
