package com.yyt.print.ad.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.Ad;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/24.
 */
public interface IAdDAO {
    public int saveAd(Ad ad);

    public int updateAd(Ad ad);

    public int deleteAd(int id);

    public Ad getAd(int id);

    public PageHolder<Ad> queryAdByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

}
