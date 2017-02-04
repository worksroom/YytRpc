package com.yyt.print.rpc.client.info;

import com.youguu.core.util.PageHolder;
import com.yyt.print.fragment.pojo.FragmentHome;
import com.yyt.print.info.pojo.InfoCategory;
import com.yyt.print.info.pojo.InfoContent;

import java.util.HashMap;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/27.
 */
public interface IInfoRpcService {
    public int saveFragmentHome(FragmentHome fragmentHome);

    public int updateFragmentHome(FragmentHome fragmentHome);

    public int deleteFragmentHome(int id);

    public FragmentHome getFragmentHome(int id);

    public PageHolder<FragmentHome> queryFragmentHomeByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

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

    public int saveInfoContent(InfoContent infoContent);

    public int deleteInfoContent(int id);

    public int updateInfoContent(InfoContent infoContent);

    public InfoContent getInfoContent(int id);

    public PageHolder<InfoContent> queryInfoContentByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

    public List<InfoContent> queryInfoContentList(String title, String des, int id, int limit);
}
