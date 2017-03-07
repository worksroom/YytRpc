package com.yyt.print.info.service.impl;

import com.youguu.core.util.PageHolder;
import com.yyt.print.info.dao.IInfoContentDAO;
import com.yyt.print.info.pojo.InfoContent;
import com.yyt.print.info.pojo.InfoVender;
import com.yyt.print.info.query.InfoQuery;
import com.yyt.print.info.service.IInfoContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SomeBody on 2016/9/25.
 */
@Service("infoContentService")
public class InfoContentService implements IInfoContentService {

    @Resource
    private IInfoContentDAO infoContentDAO;

    @Override
    public int saveInfoContent(InfoContent infoContent) {
        return infoContentDAO.saveInfoContent(infoContent);
    }

    @Override
    public int deleteInfoContent(int id) {
        return infoContentDAO.deleteInfoContent(id);
    }

    @Override
    public int updateInfoContent(InfoContent infoContent) {
        return infoContentDAO.updateInfoContent(infoContent);
    }

    @Override
    public InfoContent getInfoContent(int id) {
        return infoContentDAO.getInfoContent(id);
    }

    @Override
    public PageHolder<InfoContent> queryInfoContentByPage(InfoQuery query) {
        return infoContentDAO.queryInfoContentByPage(query);
    }

    @Override
    public int addSupplyInfo(InfoContent infoContent, InfoVender infoVender) {
        return infoContentDAO.addSupplyInfo(infoContent, infoVender);
    }


    @Override
    public List<InfoContent> queryInfoContentList(String title, String des, int id, int limit) {
        return infoContentDAO.queryInfoContentList(title, des, id, limit);
    }
}
