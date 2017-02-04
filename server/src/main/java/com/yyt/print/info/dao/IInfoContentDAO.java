package com.yyt.print.info.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.info.pojo.InfoContent;

import java.util.HashMap;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/25.
 */
public interface IInfoContentDAO {
    public int saveInfoContent(InfoContent infoContent);

    public int deleteInfoContent(int id);

    public int updateInfoContent(InfoContent infoContent);

    public InfoContent getInfoContent(int id);

    public PageHolder<InfoContent> queryInfoContentByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

    public List<InfoContent> queryInfoContentList(String title, String des, int id, int limit);
}
