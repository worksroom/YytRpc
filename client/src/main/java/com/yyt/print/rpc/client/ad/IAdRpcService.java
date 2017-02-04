package com.yyt.print.rpc.client.ad;

import com.youguu.core.util.PageHolder;
import com.yyt.print.ad.pojo.Ad;
import com.yyt.print.ad.pojo.AdCategory;

import java.util.HashMap;

/**
 * Created by SomeBody on 2016/9/27.
 */
public interface IAdRpcService {
    public int saveAdCategory(AdCategory category);

    public int updateAdCategory(AdCategory category);

    public int deleteAdCategory(String id);

    public AdCategory getAdCategory(String id);

    public PageHolder<AdCategory> queryAdCategoryByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

    public int saveAd(Ad ad);

    public int updateAd(Ad ad);

    public int deleteAd(int id);

    public Ad getAd(int id);

    public PageHolder<Ad> queryAdByPage(HashMap<String, Object> paramMap, int pageIndex, int pageSize);

}
