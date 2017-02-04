package com.yyt.print.info.dao.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.info.dao.IInfoContentDAO;
import com.yyt.print.info.pojo.InfoContent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SomeBody on 2016/9/25.
 */
@Repository
public class InfoContentDAO extends YytBaseDAO<InfoContent> implements IInfoContentDAO {
    @Override
    public int saveInfoContent(InfoContent infoContent) {
        return this.insert(infoContent);
    }

    @Override
    public int deleteInfoContent(int id) {
        return this.delete(id);
    }

    @Override
    public int updateInfoContent(InfoContent infoContent) {
        return this.update(infoContent);
    }

    @Override
    public InfoContent getInfoContent(int id) {
        return this.get(id);
    }

    @Override
    public PageHolder<InfoContent> queryInfoContentByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize) {
        return this.pagedQuery("findByParams", paramMap, pageIndex, pageSize);
    }

    @Override
    public List<InfoContent> queryInfoContentList(String title, String des, int id, int limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("des", des);
        map.put("id", id);
        map.put("limit", limit);
        return this.findBy("queryInfoContentList", map);
    }
}
