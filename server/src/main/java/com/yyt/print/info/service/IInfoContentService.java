package com.yyt.print.info.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.info.pojo.InfoContent;
import com.yyt.print.info.pojo.InfoVender;
import com.yyt.print.info.query.InfoQuery;

import java.util.HashMap;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/23.
 */
public interface IInfoContentService {

    /**
     * 添加用户需求
     * @param infoContent
     * @return
     */
    public int saveInfoContent(InfoContent infoContent);

    public int deleteInfoContent(int id);

    public int updateInfoContent(InfoContent infoContent);

    public InfoContent getInfoContent(int id);

    public PageHolder<InfoContent> queryInfoContentByPage(InfoQuery query);

    /**
     * 添加供应商信息
     * @param infoContent
     * @param infoVender
     * @return
     */
    public int addSupplyInfo(InfoContent infoContent, InfoVender infoVender);

    public List<InfoContent> queryInfoContentList(String title, String des, int id, int limit);
}
